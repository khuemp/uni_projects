package prog2.tests.pub;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import routing.Graph;
import routing.RoutingAlgorithm;
import routing.TravelType;
import routing.tests.TestingBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCampusMapEx2 extends TestingBase {

	private static final String MapFileName = "campus.osm.nae";

	public static String getCategory() {
		return "public";
	}

	public static String getExercise() {
		return "simplifygraph";
	}

	@Override
	public String getMapFileName() {
		return MapFileName;
	}

	@Test(timeout = 3000)
	public void test2_CheckMinimizedGraphSimple() {
		Graph g = getGraph();

		RoutingAlgorithm ra = getRoutingAlgorithm(g);

		int numRemovedNodes, numRemovedNodes2, numRemovedNodesAfterNodes, numRemovedEdges;

		numRemovedNodes = g.removeIsolatedNodes();
		numRemovedNodes2 = g.removeIsolatedNodes();
		numRemovedEdges = g.removeUntraversableEdges(ra, TravelType.ANY);
		numRemovedNodesAfterNodes = g.removeIsolatedNodes();

		reset();

		assertEquals("Number of removed isolated nodes did not match.", 3299,
				numRemovedNodes);
		assertEquals("Isolated nodes cannot be removed twice.", 0,
				numRemovedNodes2);
		assertEquals("Number of removed untraversable edges did not match.",
				124, numRemovedEdges);
		assertEquals("Number of removed isolated nodes did not match.", 48,
				numRemovedNodesAfterNodes);
		assertEquals("Number of non isolated nodes did not match.", 2591,
				g.numNodes());
	}

	@Test(timeout = 3000)
	public void test3_CheckMinimizedGraphAll() {
		Graph g = getGraph();

		RoutingAlgorithm ra = getRoutingAlgorithm(g);

		int[] numExpectedRemovedNodesUni = { 4021, 5394, 3413, 3347 };
		int[] numExpectedRemovedNodesBid = { 4020, 5393, 3413, 3347 };
		int[] numExpectedRemovedNodes = ra.isBidirectional() ? numExpectedRemovedNodesBid
				: numExpectedRemovedNodesUni;

		int[] numExpectedRemovedEdgesUni = { 1993, 4858, 276, 124 };
		int[] numExpectedRemovedEdgesBid = { 1724, 4586, 276, 124 };
		int[] numExpectedRemovedEdges = ra.isBidirectional() ? numExpectedRemovedEdgesBid
				: numExpectedRemovedEdgesUni;

		for (int i = 0; i < 4; i++) {
			int numRemovedNodes, numRemovedEdges, numEdges;

			numRemovedEdges = g.removeUntraversableEdges(ra, travelTypes[i]);
			numRemovedNodes = g.removeIsolatedNodes();
			numEdges = g.numEdges();

			g = reloadGraph();

			assertEquals(
					"Number of removed untraversable edges did not match.",
					numExpectedRemovedEdges[i], numRemovedEdges);
			assertEquals("Number of edges in map did not match.",
					5710 - numRemovedEdges, numEdges);
			assertEquals("Number of removed isolated nodes did not match.",
					numExpectedRemovedNodes[i], numRemovedNodes);
		}
	}
}