package prog2.tests.pub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import routing.Graph;
import routing.Node;
import routing.RoutingAlgorithm;
import routing.RoutingAlgorithm.NoSuchRouteException;
import routing.TravelType;
import routing.tests.TestingBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCampusMapEx1 extends TestingBase {

	private static final String MapFileName = "campus.osm.nae";

	public static String getCategory() {
		return "public";
	}

	public static String getExercise() {
		return "buildgraph";
	}

	@Override
	public String getMapFileName() {
		return MapFileName;
	}

	@Test(timeout = 2500)
	public void test0_ParseFile() {
		Graph g = getGraph();
		assertNotNull("Graph could not be parsed from the .nae file.", g);
	}

	@Test(timeout = 1500)
	public void test1_CheckGraph() {
		Graph g = getGraph();
		assertEquals("Number of nodes in initial map did not match.", 5938,
				g.numNodes());
		assertEquals("Number of edges in initial map did not match.", 5710,
				g.numEdges());
	}

	@Test(timeout = 2500)
	public void testX_InvalidQueries() {
		Graph g = getGraph();

		long[] illegalIds = { -42, -1, 42, Long.MAX_VALUE, Long.MIN_VALUE };
		for (long illegalId : illegalIds) {

			Node n = g.getNode(illegalId);
			assertNull("Excepted a NoSuchNodeException for illigal node ID ("
					+ illegalId + ")", n);
		}

		RoutingAlgorithm ra = getRoutingAlgorithm(g);
		for (long illegalId : illegalIds) {
			try {
				ra.computeRouteLeg(g, 1, illegalId, TravelType.CAR);
				fail("Excepted a NoSuchRouteException for illigal node ID ("
						+ illegalId + ")");
			} catch (NoSuchRouteException e) {
			}
		}
	}
}
