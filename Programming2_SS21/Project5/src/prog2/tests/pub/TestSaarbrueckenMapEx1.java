package prog2.tests.pub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import routing.Graph;
import routing.tests.TestingBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSaarbrueckenMapEx1 extends TestingBase {

	private static final String MapFileName = "saarbruecken.osm.nae";

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

	@Test(timeout = 5000)
	public void test0_ParseFile() {
		Graph g = getGraph();
		assertNotNull("Graph could not be parsed from the .nae file.", g);
	}

	@Test(timeout = 10000)
	public void test1_CheckGraph() {
		Graph g = getGraph();
		assertEquals("Number of nodes in initial map did not match.", 165906,
				g.numNodes());
		assertEquals("Number of edges in initial map did not match.", 103020,
				g.numEdges());
	}

}
