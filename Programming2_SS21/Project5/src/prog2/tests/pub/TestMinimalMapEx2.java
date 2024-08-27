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
public class TestMinimalMapEx2 extends TestingBase {

	private static final String MapFileName = "minimal.nae";

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

	@Test(timeout = 1000)
	public void test3_CheckMinimizedGraph() {
		Graph g = getGraph();

		int numRemovedNodes = g.removeIsolatedNodes();
		assertEquals("Number of removed isolated nodes did not match.", 0,
				numRemovedNodes);
		assertEquals("Number of non isolated nodes did not match.", 6,
				g.numNodes());

		// There is exactly one edge that is untraversable for unidirectional
		// routing algorithms but none for
		// bidirectional ones.
		RoutingAlgorithm ra = getRoutingAlgorithm(g);
		int untraversableEdges = ra.isBidirectional() ? 0 : 1;

		TravelType[] travelTypes = { TravelType.ANY, TravelType.BIKE,
				TravelType.CAR, TravelType.FOOT };
		for (TravelType tt : travelTypes) {
			int numRemovedEdges = g.removeUntraversableEdges(ra, tt);
			reset();

			assertEquals(
					"Number of removed untraversable edges did not match.",
					untraversableEdges, numRemovedEdges);
			untraversableEdges = 0;
		}
	}
}