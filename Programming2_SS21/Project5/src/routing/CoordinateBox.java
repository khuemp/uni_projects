package routing;

/**
 * A box in coordinate space
 */
public class CoordinateBox {
	private Coordinate lower;
	private Coordinate upper;
	
	/**
	 * Defines a box given a lower and an upper bound
	 * 
	 * @param lower  lower bound on latitude and longitude on coordinates in this box
	 * @param upper  upper bound on latitude and longitude on coordinates in this box
	 */
	public CoordinateBox(Coordinate lower, Coordinate upper) {
		this.lower = lower;
		this.upper = upper;
		
		assert (lower.getLatitude() <= upper.getLatitude());
		assert (lower.getLongitude() <= upper.getLongitude());
	}
	
	public Coordinate getLowerBound() { return lower; }
	public Coordinate getUpperBound() { return upper; }
	public double getWidth() { return upper.getLongitude() - lower.getLongitude(); }
	public double getHeight() { return upper.getLatitude() - lower.getLatitude(); }
	
	@Override
	public
	String toString() {
		return "CoordinateBox [" + lower.toString() + " to " + upper.toString() + "]"; 
		
	}
	
	/**
	 * Checks whether a coordinate is contained in this box
	 * 
	 * @param c  the coordinate
	 * @return whether it is contained in the box
	 */
	public boolean
	contains(Coordinate c) {
		return
				lower.getLatitude() <= c.getLatitude() && c.getLatitude() <= upper.getLatitude() &&
				lower.getLongitude() <= c.getLongitude() && c.getLongitude() <= upper.getLongitude();
				
	}
}
