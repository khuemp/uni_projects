package routing;

import java.io.IOException;

public class Factory {

	/**
	 * Create a graph from the description in a .nae file.
	 *
	 * @param fileName A path to an NAE file.
	 *
	 * @return The graph as described in the .nae file.
	 *
	 * @throws IOException If an Input/Output error occurs.
	 */
	public static Graph createGraphFromMap(String fileName) throws IOException {
		// DONE: Implement me.
		return new MyGraph(fileName);
	}

	/**
	 * Return a node finder algorithm for the graph g. The graph argument allows the
	 * node finder to build internal data structures.
	 *
	 * @param g The graph the nodes are looked up in.
	 * @return A node finder algorithm for that graph.
	 */
	public static NodeFinder createNodeFinder(Graph g) {
		// DONE: Implement me.
		return new NearestNodeFinder(g);
	}

	/**
	 * == BONUS ==
	 *
	 * Compute the overlay graph (or junction graph).
	 *
	 * Note: This is part of a bonus exercise, not of the regular project.
	 *
	 * @return The overlay graph for the given graph g.
	 */
	public static Graph createOverlayGraph(Graph g) {
		// TODO: Implement me.
		return null;
	}

	/**
	 * Return a routing algorithm for the graph g. This allows to inspect the graph
	 * and choose from different routing strategies if appropriate.
	 *
	 * @param g The graph the routing is performed on.
	 * @return A routing algorithm suitable for that graph.
	 */
	public static RoutingAlgorithm createRoutingAlgorithm(Graph g) {
		// DONE: Implement me.
		return new Dijkstra();
	}

}
