package routing;

/**
 * A coordinate on the earth defined by the latitude and longitude.
 * 
 * See also: http://en.wikipedia.org/wiki/Geographic_coordinate_system
 */
public class Coordinate {
	/**
	 * The earth radius in meters.
	 */
	static final double earthRadius = 6378137.0; // WGS84 standard earth radius
	
	static final double MIN_LON = -180.0;
	static final double MAX_LON = 180.0;
	/** maximum latitude (north) for mercator display */
	static final double MIN_LAT = -85.05112877980659;
	/** minimum latitude (south) for mercator display */
	static final double MAX_LAT = 85.05112877980659;
	
	/**
	 * Compute the geographic distance between coordinates.
	 * 
	 * @param lat1
	 *            The latitude of the first coordinate.
	 * @param lng1
	 *            The longitude of the first coordinate.
	 * @param lat2
	 *            The latitude of the second coordinate.
	 * @param lng2
	 *            The longitude of the second coordinate.
	 * 
	 * @return The distance in meters between the coordinates.
	 */
	public static double distance(double lat1, double lng1, double lat2,
			double lng2) {

		// Always compute the distance from the smaller to the bigger
		// coordinate.
		if (lat1 > lat2 || (lat1 == lat2 && lng1 > lng2))
			return distance(lat2, lng2, lat1, lng1);

		double phi1 = Math.toRadians(90.0 - lat1);
		double phi2 = Math.toRadians(90.0 - lat2);

		double theta1 = Math.toRadians(lng1);
		double theta2 = Math.toRadians(lng2);

		double cos = Math.sin(phi1) * Math.sin(phi2)
				* Math.cos(theta1 - theta2);
		cos += (Math.cos(phi1) * Math.cos(phi2));

		double arc;
		if (cos < -1 || cos > 1)
			arc = 0;
		else
			arc = Math.acos(cos);

		return arc * earthRadius;
	}

	/**
	 * The latitude value of this coordinate.
	 */
	private final double latitude;

	/**
	 * The longitude value of this coordinate.
	 */
	private final double longitude;

	/**
	 * A coordinate on the earth.
	 * 
	 * @param latitude
	 *            The latitude value of this coordinate.
	 * @param longitude
	 *            The longitude value of this coordinate.
	 */
	public Coordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @param c
	 *            The other coordinate
	 * 
	 * @return The distance in meters between these and the given coordinates.
	 */
	public double getDistance(Coordinate c) {
		return distance(getLatitude(), getLongitude(), c.getLatitude(),
				c.getLongitude());
	}

	/**
	 * @return The latitude value of this coordinate.
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return The longitude value of this coordinate.
	 */
	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "Coordinate [lat=" + latitude + ", lng=" + longitude + "]";
	}
	
	/**
	 * Creates a Coordinate object from latitude and longitude in radians
	 * 
	 * @param radLat  the latitude in radians
	 * @param radLon  the longitude in radians
	 * 
	 * @return a Coordinate object
	 */
	public static Coordinate
	fromRadians(double radLat, double radLon) {
		return new Coordinate(Math.toDegrees(radLat), Math.toDegrees(radLon));
	}
	
	/**
	 * Creates a Coordinate object from latitude and longitude degrees
	 * 
	 * @param radLat  the latitude in degrees
	 * @param radLon  the longitude in degrees
	 * 
	 * @return a Coordinate object
	 */
	public static Coordinate
	fromDegree(double degLat, double degLon) {
		return new Coordinate(degLat, degLon);
	}
	
	/**
	* Calculates the end-point from a given source at a given range (meters)
	* and bearing (degrees). This methods uses simple geometry equations to
	* calculate the end-point.
	* 
	* @param point
	*            Point of origin
	* @param range
	*            Range in meters
	* @param bearing
	*            Bearing in degrees
	* @return End-point from the source given the desired range and bearing.
	*/
	public static Coordinate calculateDerivedPosition(Coordinate point,
	            double range, double bearing)
    {
        double latA = Math.toRadians(point.getLatitude());
        double lonA = Math.toRadians(point.getLongitude());
        double angularDistance = range / earthRadius;
        double trueCourse = Math.toRadians(bearing);

        double lat = Math.asin(
                Math.sin(latA) * Math.cos(angularDistance) +
                        Math.cos(latA) * Math.sin(angularDistance)
                        * Math.cos(trueCourse));

        double dlon = Math.atan2(
                Math.sin(trueCourse) * Math.sin(angularDistance)
                        * Math.cos(latA),
                Math.cos(angularDistance) - Math.sin(latA) * Math.sin(lat));

        double lon = ((lonA + dlon + Math.PI) % (Math.PI * 2)) - Math.PI;

        return Coordinate.fromRadians(lat, lon);
    }
		
	
	/**
	 * Computes bounds on the longitude and latitude of all coordinates that are within the given distance of this Coordinate
	 *  
	 * @param  distance the distance
	 * @return  a bounding box containing all coordinates that are within the distance of this coordinate
	 */
	public CoordinateBox computeBoundingBox(double distance) {
		// http://stackoverflow.com/questions/3695224/sqlite-getting-nearest-locations-with-latitude-and-longitude/12997900#12997900

		Coordinate lower = new Coordinate(Double.MAX_VALUE, Double.MAX_VALUE);
		Coordinate upper = new Coordinate(Double.MIN_VALUE, Double.MIN_VALUE);
		
		for (int i = 0; i < 4; ++i) {
			Coordinate a = calculateDerivedPosition(this, distance, 90.0 * i);
			double lowerLat = Math.min(lower.getLatitude(), a.getLatitude());
			double lowerLon = Math.min(lower.getLongitude(), a.getLongitude());
			double upperLat = Math.max(upper.getLatitude(), a.getLatitude());
			double upperLon = Math.max(upper.getLongitude(), a.getLongitude());
			
			final double EPS = 0.000001;
			lower = new Coordinate(lowerLat - EPS, lowerLon - EPS);
			upper = new Coordinate(upperLat + EPS, upperLon + EPS);
		}
		
		return new CoordinateBox(lower, upper);
	}
}
