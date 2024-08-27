package routing;

import java.util.List;

/**
 * The routing interface allows to compute shortest routes between nodes in a
 * graph.
 *
 */
public interface RoutingAlgorithm {

	/**
	 * Custom exception to indicate that a requested route could not be found.
	 */
	@SuppressWarnings("serial")
	class NoSuchRouteException extends Exception {
		public NoSuchRouteException() {
		}

		public NoSuchRouteException(String s) {
			super(s);
		}
	}

	/**
	 * Compute the shortest route between nodes for the given travel type.
	 * 
	 * @param g
	 *            The underlying graph.
	 * @param nodes
	 *            The waypoints of the required route.
	 * @param tt
	 *            The chosen travel type.
	 * 
	 * @return The shortest route from the first to the last node in ids that
	 *         contains all in-between.
	 * 
	 * @throws NoSuchRouteException
	 *             If no route from start to end exists.
	 */
	public Route computeRoute(Graph g, List<Node> nodes, TravelType tt)
			throws NoSuchRouteException;

	/**
	 * Compute the shortest route leg between two nodes for the given travel
	 * type.
	 * 
	 * Note: This is a convenience wrapper.
	 * 
	 * @param g
	 *            The underlying graph.
	 * @param startId
	 *            The OSM id of the start node.
	 * @param endId
	 *            The OSM id of the end node.
	 * @param tt
	 *            The chosen travel type.
	 * 
	 * @return The shortest route leg from start to end.
	 * 
	 * @throws NoSuchRouteException
	 *             If no route from start to end exists.
	 */
	public RouteLeg computeRouteLeg(Graph g, long startId, long endId,
			TravelType tt) throws NoSuchRouteException;

	/**
	 * Compute the shortest route leg between two nodes for the given travel
	 * type.
	 * 
	 * @param g
	 *            The underlying graph.
	 * @param start_node
	 *            The start node.
	 * @param end_node
	 *            The end node.
	 * @param tt
	 *            The chosen travel type.
	 * 
	 * @return The shortest route leg from start to end.
	 * 
	 * @throws NoSuchRouteException
	 *             If no route from start to end exists.
	 */
	public RouteLeg computeRouteLeg(Graph G, Node start_node, Node end_node,
			TravelType TT) throws NoSuchRouteException;

	/**
	 * == BONUS ==
	 * 
	 * Note: Implementing a bidirectional routing algorithm is part of a bonus
	 * exercise, not of the regular project.
	 * 
	 * @return True iff the routing algorithm is bidirectional.
	 */
	public boolean isBidirectional();
}