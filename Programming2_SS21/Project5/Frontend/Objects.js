/**
 * Contains the declaration of all needed objects
 */

/**
 * Point object with a longitude (X) and latitude (Y).
 */
function Point(x, y) {
	this.x = x;
	this.y = y;
}

/**
 * Route object which represents the calculated route.
 * Should be treated as immutable after creation.
 *
 * @param nodes			Array containing the points the route consists of.
 */
function Route(nodes) {
	this.nodes = nodes;
}

/**
 * Query object, which is used for communication with the API.
 *
 * @param destinations 	All points of the route in travel order.
 * @param mode 			Means of transport (possible values: "driving",
 *						"bicycling", "walking").
 * @param metric		Which metric shall be used to weight the edges
 *						computing the route (possible values so far: "time",
 *						"distance", "energy").
 * @param API			The API which shall be used.
 * @param {Array} avoid	Possible values: tolls, highways, ferries, unpaved,
 *						seasonal_closure, country_crossing 	
 */
function Query(destinations, mode, API, metric) {
	this.destinations = destinations;
	this.mode = mode;
	this.API = API;
	this.length_unit = metric;	
}

/**
 * Object representing the response from the API, encoding the route.
 *
 * @param boundingBox	The bounding box of the calculated route.
 * @param route			Array, consisting of an array of "legs", which
 *						again consists of an array of "steps" each. A step
 *						is the most atomic piece of a route description.
 *
 *						All these arrays consist strings. TODO Right?
 */
function Server_response(boundingBox, route) {
	this.boundingBox = boundingBox;
	this.route = route;
}

