package routing;

import java.util.Iterator;

/**
 * Nodes are next to edges the building blocks of a graph. In this project they
 * contain information about the outgoing edges but also about their OSM id and
 * coordinates.
 */
public interface Node extends Iterable<Edge> {

	/**
	 * @return The coordinates of this node.
	 */
	public Coordinate getCoordinate();

	/**
	 * Get an outgoing edge of this node.
	 * 
	 * @param idx
	 *            The edge index.
	 * 
	 * @return The "idx'th" outgoing edge if it exists.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             If idx is not a valid edge index.
	 */
	public Edge getEdge(int idx);

	/**
	 * @return The OSM id of this node.
	 */
	public long getId();

	/**
	 * @return An iterator over all outgoing edges of this node.
	 */
	@Override
	public Iterator<Edge> iterator();

	/**
	 * @return The number of outgoing edges of this node.
	 */
	public int numEdges();

	/**
	 * Add an outgoing edge to this node.
	 * 
	 * @param e
	 *            The edge to add.
	 */
	public void addEdge(Edge e);

	/**
	 * Remove an outgoing edge from this node.
	 * 
	 * @param i The index of the edge that should be removed.
	 */
	public void removeEdge(int i);
}
