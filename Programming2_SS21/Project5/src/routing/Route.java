package routing;

import java.util.Iterator;
import java.util.List;

public interface Route extends Iterable<RouteLeg> {

	/**
	 * @return The distance/length of this route in meters.
	 */
	public double distance();

	/**
	 * @return The end node of this route, hence the last.
	 */
	public Node getEndNode();

	/**
	 * @return The start node of this route, hence the first.
	 */
	public Node getStartNode();

	/**
	 * @return The travel type this route was computed for.
	 */
	public TravelType getTravelType();

	/**
	 * Returns an iterator over the nodes in this route.
	 */
	@Override
	public Iterator<RouteLeg> iterator();

	/**
	 * @return The number of RouteLegs on this route.
	 */
	public int size();

	/**
	 * @param time
	 *            The time it took to compute this route.
	 * @return A JSON representation for this route suitable for the web
	 *         fronted.
	 */
	public String toJSON(long time, List<Coordinate> waypoints);
}
