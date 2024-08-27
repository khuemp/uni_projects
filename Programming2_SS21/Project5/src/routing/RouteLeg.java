package routing;

import java.util.Iterator;

public interface RouteLeg extends Iterable<Node> {

	/**
	 * @return The distance/length of this leg in meters.
	 */
	public double getDistance();

	/**
	 * @return The end node of this route leg, hence the last.
	 */
	public Node getEndNode();

	/**
	 * @return The start node of this route leg, hence the first.
	 */
	public Node getStartNode();

	/**
	 * Returns an iterator over the nodes in this leg.
	 */
	@Override
	public Iterator<Node> iterator();

	/**
	 * @return The number of nodes on this leg.
	 */
	public int size();

	/**
	 * @return A JSON representation for this route suitable for the web
	 *         fronted.
	 */
	public String toJSON();

}