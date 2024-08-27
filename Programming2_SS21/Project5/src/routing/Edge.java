package routing;

/**
 * Edges are next to nodes the building blocks of a graph. They are weighted
 * (length) and have access rights that encode if traversal (e.g., by car) is
 * allowed.
 */
public interface Edge {

	/**
	 * Check if it is allowed to access this edge with the given travel type and
	 * in the given direction.
	 * 
	 * @param tt
	 *            The travel type in question.
	 * @param dir
	 *            The direction in question.
	 * 
	 * @return True, iff the travel type is allowed on this edge in direction D.
	 */
	public boolean allowsTravelType(TravelType tt, Direction dir);

	/**
	 * @return The end node of this edge.
	 */
	public Node getEnd();

	/**
	 * @return The length (distance) of this edge in meters.
	 */
	public double getLength();

	/**
	 * @return The start node of this edge.
	 */
	public Node getStart();
}
