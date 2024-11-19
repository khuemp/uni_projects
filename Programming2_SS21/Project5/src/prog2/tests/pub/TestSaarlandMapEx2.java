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
public class TestSaarlandMapEx2 extends TestingBase {

	private static final String MapFileName = "saarland.osm.nae";

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

	@Test(timeout = 15000)
	public void test2_CheckMinimizedGraphFoot() {
		Graph g = getGraph();

		int numRemovedNodes, numRemovedEdges;
		int numAssumedRemovedNodes, numAssumedRemovedEdges;
		int numRemainingEdges;

		RoutingAlgorithm ra = getRoutingAlgorithm(g);
		numRemovedEdges = g.removeUntraversableEdges(ra, TravelType.ANY);
		numAssumedRemovedEdges = ra.isBidirectional() ? 66490 : 79696;
		numRemainingEdges = ra.isBidirectional() ? 1205832 : 1192626;
		assertEquals("Number of removed untraversable edges did not match.",
				numAssumedRemovedEdges, numRemovedEdges);
		assertEquals("Number of remaining edges did not match.",
				numRemainingEdges, g.numEdges());

		numAssumedRemovedNodes = ra.isBidirectional() ? 1767804 : 1767818;
		numRemovedNodes = g.removeIsolatedNodes();
		assertEquals("Number of removed isolated nodes did not match.",
				numAssumedRemovedNodes, numRemovedNodes);
		assertEquals("Number of non isolated nodes did not match.",
				2331746 - numAssumedRemovedNodes, g.numNodes());

		numRemovedNodes = g.removeIsolatedNodes();
		assertEquals("Isolated nodes cannot be removed twice.", 0,
				numRemovedNodes);
	}

}