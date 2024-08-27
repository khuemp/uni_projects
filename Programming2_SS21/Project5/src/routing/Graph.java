package routing;

import java.util.Iterator;

/**
 * The graph interface allows to interact with a graph in a read-only matter,
 * hence the internal representation is not necessarily defined by the methods
 * declared here.
 */
public interface Graph extends Iterable<Node> {

	/**
	 * @param id
	 *            The OSM id of the node in question.
	 * 
	 * @return The Node with the given OSM id in the graph or null if it doesn't
	 *         exist.
	 */
	public Node getNode(long id);

	/**
	 * @return The maximal coordinate in this graph (max latitude, max
	 *         longitude).
	 */
	public Coordinate getNWCoordinate();

	/**
	 * @return The minimal coordinate in this graph (min latitude, min
	 *         longitude).
	 */
	public Coordinate getSECoordinate();

	/**
	 * @return An iterator that allows to iterate over all nodes in the graph.
	 */
	@Override
	public Iterator<Node> iterator();

	/**
	 * @return The number of edges of this graph.
	 */
	public int numEdges();
	
	/**
	 * @return The number of nodes of this graph.
	 */
	public int numNodes();

	/**
	 * Remove nodes that cannot be part of a route as they are isolated.
	 * 
	 * @return The number of nodes removed.
	 */
	public int removeIsolatedNodes();

	/**
	 * Remove edges that cannot be traversed with the given travel type.
	 * 
	 * @param ra
	 *            The routing algorithm used.
	 * @param tt
	 *            The travel type to specialize for.
	 * 
	 * @return The number of edges removed.
	 */
	public int removeUntraversableEdges(RoutingAlgorithm ra, TravelType tt);
	
	/**
	 * == BONUS ==
	 * 
	 * Note: Implementing an overlay graph is part of a bonus exercise, not of the regular project.
	 * 
	 * @retun True, iff this is an overlay graph.
	 */
	boolean isOverlayGraph();
	
	
	/**
	 * == BONUS ==
	 * 
	 * Note: Implementing an overlay graph is part of a bonus exercise, not of the regular project.
	 * 
	 * @param id
	 *            The OSM id of the node in question.
	 *            
	 * @return The Node with the given OSM id in the underlying graph or null if it doesn't
	 *         exist.
	 * 
	 * This is only a valid call for an overlay graph (see isOverlayGraph).
	 */
	Node getNodeInUnderlyingGraph(long id);
}
