package routing.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;

import routing.Direction;
import routing.Edge;
import routing.Factory;
import routing.Graph;
import routing.Node;
import routing.NodeFinder;
import routing.Route;
import routing.RouteLeg;
import routing.RoutingAlgorithm;
import routing.RoutingAlgorithm.NoSuchRouteException;
import routing.TravelType;

public abstract class TestingBase {

	/**
	 * The maximal difference between the actual and expected distance.
	 */
	private static final double DISTANCE_DELTA = /* 1cm */0.01;

	/**
	 * The graph used in this tests. It is initialized by the first test.
	 */
	protected static Graph graph = null;

	/**
	 * The node finder used in this tests. It is initialized by the first use.
	 */
	private static NodeFinder nf = null;

	/**
	 * Forget the cached graph and force re-parsing on the next getGraph call.
	 */
	static protected void reset() {
		TestingBase.graph = null;
		TestingBase.nf = null;
	}

	@Before
	public void setUp() {
		if (getMapFileName() != null)
			getGraph();
	}

	@AfterClass
	public static void tearDown() {
		reset();
	}

	/**
	 * The possible travel types.
	 */
	protected final TravelType[] travelTypes = { TravelType.BIKE,
			TravelType.CAR, TravelType.FOOT, TravelType.ANY };

	protected void assumeDistance(Route r, double distance) {
		assertEquals(getRouteAssertStr(r)
				+ " did not have the assumed distance.", distance,
				r.distance(), DISTANCE_DELTA);
	}

	protected void assumeLegs(Route r, int size) {
		assertEquals(getRouteAssertStr(r) + " did not have the assumed size.",
				size, r.size());
	}

	protected void checkEndpoints(Route r, long start, long end) {
		assertTrue("Route was empty!", r.size() > 0);
		assertEquals(
				getRouteAssertStr(r) + " did have a different start node.",
				start, r.getStartNode().getId());
		assertEquals(getRouteAssertStr(r) + " did have a different end node.",
				end, r.getEndNode().getId());
	}

	protected void checkRoute(Route r, double distance, long start, long end) {
		checkEndpoints(r, start, end);
		checkRouteConsistency(r);
		assumeDistance(r, distance);
	}

	protected void checkRouteConsistency(Route r) {
		assertTrue(getRouteAssertStr(r) + " did not contain any nodes.",
				r.size() > 0 && r.iterator().hasNext());

		TravelType tt = r.getTravelType();

		int numLegs = 0;
		double distance = 0;
		for (RouteLeg rl : r) {
			numLegs += 1;
			Iterator<Node> it = rl.iterator();
			assertTrue(
					getRouteAssertStr(r) + " leg did not contain any nodes.",
					it.hasNext());

			double distanceLeg = 0;
			int numNodes = 1;

			Node n = it.next();
			assertEquals(getRouteAssertStr(r)
					+ " did have wrong leg start point.", n.getId(), rl
					.getStartNode().getId());

			while (it.hasNext()) {
				Node s = it.next();
				numNodes += 1;
				double minEdge = Double.MAX_VALUE;
				for (int i = 0; i < n.numEdges(); i++) {
					Edge e = n.getEdge(i);
					if (e.getEnd().getId() != s.getId())
						continue;
					if (!e.allowsTravelType(tt, Direction.FORWARD))
						continue;
					minEdge = Math.min(minEdge, e.getLength());
				}

				if (minEdge == Double.MAX_VALUE)
					fail(getRouteAssertStr(r)
							+ " contains an invalid edge from " + n.getId()
							+ " to " + s.getId());

				n = s;
				distance += minEdge;
				distanceLeg += minEdge;
			}
			assertEquals(getRouteAssertStr(r)
					+ " did have wrong leg end point.", n.getId(), rl
					.getEndNode().getId());

			assertEquals(
					getRouteAssertStr(r)
					+ " has leg with distance that is not the sum of the edge distances.",
					distanceLeg, rl.getDistance(), DISTANCE_DELTA);
			assertEquals(getRouteAssertStr(r)
					+ " has leg with different number of nodes than reported.",
					numNodes, rl.size());
		}

		assertEquals(getRouteAssertStr(r)
				+ " has distance that is not the sum of the edge distances.",
				distance, r.distance(), DISTANCE_DELTA);
		assertEquals(getRouteAssertStr(r)
				+ " has different number of legs than reported.", numLegs,
				r.size());
	}

	protected void checkWaypoints(Route r, double distance, long[] waypoints) {
		checkRoute(r, distance, waypoints[0], waypoints[waypoints.length - 1]);
		assertEquals(getRouteAssertStr(r) + " did have wrong number of legs.",
				r.size(), waypoints.length - 1);
		int waypointIdx = 0;
		for (RouteLeg rl : r) {
			if (waypointIdx + 1 >= waypoints.length)
				fail(getRouteAssertStr(r) + " did have to many legs.");
			assertEquals(getRouteAssertStr(r)
					+ " did have wrong leg start point.",
					waypoints[waypointIdx], rl.getStartNode().getId());
			assertEquals(getRouteAssertStr(r)
					+ " did have wrong leg end point.",
					waypoints[waypointIdx + 1], rl.getEndNode().getId());
			waypointIdx += 1;
		}
	}

	protected Route computeRoute(List<Node> waypoints, TravelType tt,
			boolean possible) {
		Graph g = getGraph();

		RoutingAlgorithm ra = getRoutingAlgorithm(g);

		Route r = null;
		try {
			r = ra.computeRoute(g, waypoints, tt);
		} catch (NoSuchRouteException e) {
			if (possible)
				fail(getRouteAssertStr(r) + " was not found.");
			else
				return null;
		}

		if (!possible)
			fail(getRouteAssertStr(r) + " was found but doesn't exist.");

		return r;
	}

	protected Route computeRoute(long startId, long endId, TravelType tt,
			boolean possible) {
		Graph g = getGraph();
		List<Node> list = new ArrayList<Node>();
		list.add(g.getNode(startId));
		list.add(g.getNode(endId));

		return computeRoute(list, tt, possible);
	}

	/**
	 * @return The graph parsed from the map file of this test class.
	 */
	protected Graph getGraph() {
		if (TestingBase.graph == null)
			TestingBase.graph = readGraphFromFile();
		return TestingBase.graph;
	}

	/**
	 * @return The path to the graph file for a test class.
	 */
	public abstract String getMapFileName();

	/**
	 * @return The path to the graph file for a test class.
	 */
	protected NodeFinder getNodeFinder() {
		if (TestingBase.nf == null)
			TestingBase.nf = Factory.createNodeFinder(getGraph());
		return TestingBase.nf;
	}

	private String getRouteAssertStr(Route r) {
		if (r == null)
			return "Route";
		Node start = r.getStartNode();
		Node end = r.getEndNode();
		TravelType tt = r.getTravelType();
		return "Route from " + (start == null ? "<unknown>" : start.getId())
				+ " to " + (end == null ? "<unknown>" : end.getId()) + " by "
				+ tt.name();
	}

	protected RoutingAlgorithm getRoutingAlgorithm(Graph g) {
		return Factory.createRoutingAlgorithm(g);
	}

	protected boolean isBidirectional() {
		return getRoutingAlgorithm(getGraph()).isBidirectional();
	}

	protected Graph readGraphFromFile() {
		Graph g = null;
		try {
			g = Factory.createGraphFromMap(getMapFileName());
		} catch (IOException e) {
			e.printStackTrace();
			fail("Factory reported that the NAE file could not be read.");
		}
		return g;
	}

	/**
	 * @return Reload the graph.
	 */
	protected Graph reloadGraph() {
		reset();
		return getGraph();
	}

}
