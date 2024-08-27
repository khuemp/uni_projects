package prog2.tests.pub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import routing.Graph;
import routing.Node;
import routing.tests.TestingBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMinimalMapEx1 extends TestingBase {

	private static final String MapFileName = "minimal.nae";

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

	private Node[] getNodesById() {
		Graph g = getGraph();
		Node[] nodes = new Node[6];
		for (int i = 0; i < 6; i++) {
			nodes[i] = g.getNode(i);
			assertNotNull("Expected node was not found in the graph", nodes[i]);
		}

		return nodes;
	}

	@Test(timeout = 5000)
	public void test0_ParseFile() {
		Graph g = reloadGraph();
		assertNotNull("Graph could not be parsed from the .nae file.", g);
	}

	@Test(timeout = 1000)
	public void test1_CheckEdges() {
		Node[] nodes = getNodesById();
		for (Node n : nodes)
			assertEquals("Each node should have 3 outgoing edges", 3,
					n.numEdges());
	}

	@Test(timeout = 1000)
	public void test1_CheckGraph() {
		Graph g = getGraph();
		assertEquals("Number of nodes in initial map did not match.", 6,
				g.numNodes());
		assertEquals("Number of edges in initial map did not match.", 18,
				g.numEdges());
	}

	@Test(timeout = 1000)
	public void test1_CheckNodesById() {
		getNodesById();
	}

	@Test(timeout = 1000)
	public void test1_CheckNodesInCollection() {
		Graph g = getGraph();
		assertEquals("The size of the graph of nodes did not match.", 6,
				g.numNodes());

		HashSet<Node> hs = new HashSet<>();
		for (Node n : g)
			hs.add(n);

		assertEquals("The size of the graph of nodes did not match.", 6,
				hs.size());

		Node[] nodes = getNodesById();
		for (Node n : nodes)
			assertTrue("The graph did not contain all nodes:", hs.contains(n));
	}

}