package routing;

public interface NodeFinder {
	/**
	 * Find the node closest to c in the navigation graph.
	 * 
	 * @param c
	 *            The coordinate we are interested in.
	 * 
	 * @return The node closest to c in the navigation graph.
	 */
	public Node getNodeForCoordinates(Coordinate c);

}
