//If computation is canceled or not.
Controller.canceled;

function Controller (){
	this.canceled=false;
	this.route;

	var objectMapView;
	this.objectMapView = new MapView();
}


//TODO documentation
Controller.prototype.searchPoint = function(point){
	/*
	 * Generates a point.
	 */
	//var input = View.getInputValues();
	if(!point){
		View.displayError("No address entered.");
		View.waiting(false);
		return;
	}
//	var point = input.destinations[0];
//  (to test geocodeAdress)
 	this.objectMapView.searchPoint(point);
	this.objectMapView.drawMarkerPoint(point);
	View.waiting(false);

}


//TODO documentation
/*
Controller.prototype.drawRoute = function() {
//	this.objectMapView.drawRoute(this.route);

//	generates a pointArray for testing issues
	var routeArray = new Array(new Array(7.589664,47.547855),new Array(7.592068,47.546871),new Array(7.593312,47.546379),new Array(7.59254,47.545338),new Array(7.591596,47.545685),new Array(7.591381,47.545395),new Array(7.588205,47.546089),new Array(7.587776,47.545338),new Array(7.586532,47.545799),new Array(7.584171,47.542873),new Array(7.587175,47.541889),new Array(7.586489,47.540615),new Array(7.586532,47.540062),new Array(7.58709,47.539688),new Array(7.587647,47.5396),new Array(7.587733,47.539425),new Array(7.586617,47.539455),new Array(7.58606,47.539425),new Array(7.58563,47.539165),new Array(7.585545,47.538528),new Array(7.585545,47.538269),new Array(7.585888,47.537746),new Array(7.58636,47.537281),new Array(7.586617,47.536209),new Array(7.587218,47.535717),new Array(7.587347,47.53421),new Array(7.58709,47.533283),new Array(7.587218,47.532269),new Array(7.588162,47.531895),new Array(7.588634,47.530994),new Array(7.588549,47.529545),new Array(7.588592,47.528214),new Array(7.588978,47.528069),new Array(7.589536,47.527809),new Array(7.589922,47.525894),new Array(7.589407,47.523083),new Array(7.589793,47.521778),new Array(7.590308,47.519577),new Array(7.58975,47.516304),new Array(7.588634,47.513142),new Array(7.587004,47.509953),new Array(7.583227,47.509434),new Array(7.583055,47.508156),new Array(7.583184,47.507172),new Array(7.581425,47.507141),new Array(7.580566,47.506882),new Array(7.58018,47.506359),new Array(7.579536,47.50523),new Array(7.579408,47.503838),new Array(7.578421,47.502911),new Array(7.580566,47.50288),new Array(7.582669,47.502968),new Array(7.581553,47.501228),new Array(7.581811,47.501053),new Array(7.577734,47.500126),new Array(7.575459,47.49894),new Array(7.57503,47.498619),new Array(7.572412,47.49688),new Array(7.571726,47.496792),new Array(7.57061,47.49514),new Array(7.571082,47.494995),new Array(7.570095,47.49395));

	var pointList = [];
    for (var i = 0; i< routeArray.length; i++) {
    	pointList.push(new OpenLayers.Geometry.Point(routeArray[i][0],routeArray[i][1]))
	}
    
    this.objectMapView.drawRoute(pointList);


}
*/


//TODO documentation
Controller.prototype.getMap = function() {
	return this.objectMapView.getMap();
}


//TODO documentation
Controller.prototype.computeRoute = function () {

	View.waiting(true);
	var query = View.getInputValues();
	if(!query){//TODO Eingabe korrekt pruefen.
		View.displayError("The input adress doesn't exists.");
		View.waiting(false);
		return;
	}
	if(!query.destinations[1]) {
		Controller.searchPoint(query.destinations[0]);
		return;
	}
	
	Server_Comm.getRoute(query,
		function(Server_response) {
			Controller.processResult(Server_response);
		}
	);


//	Controller.drawRoute();

};


//TODO documentation
Controller.prototype.processResult = function (server_response) {
	/*
	View.waiting(false);
	//TODO API-Error handling is missing here right now.

//	alert(Server_response.toString);
	var responseRoute = Server_response[0];
	
	try {
		var totalDistance = responseRoute.distance.value;
	} catch(e) {
		Controller.drawRoute();
		return;
	}

	var totalDuration = responseRoute.duration.value;
	var instructions = new Array();

	//TODO Support more legs?	
	var legs = responseRoute[4];
	var steps = new Array();

	for(step in legs[4]) {
		//coords[0]/coords[1] own the lat/lng of the start point,
		//coords[2]/coords[3] the lat/lng of the end point.
		var coords = new Array();
		var start = step[2];
		var end = step[3];
		
		coords[0] = start[0];
		coords[1] = start[1];
		coords[2] = end[0];
		coords[3] = end[1];

		steps.push(coords);

		//how about a check if instructions are available?
		instructions.push(step[5]);
	}

	//Array containing the single points of the route.
	//Every even index is a start point of a step.
	var points = new Array();
	
	for(var coords in steps) {
		//Start point of step.
		var lat = coords[0];
		var lng = coords[1];
		var point = new OpenLayers.Geometry.Point(lat, lng);
		points.push(point);
		
		//End point of step.
		lat = coords[2];
		lng = coords[3];
		point = new OpenLayers.Geometry.Point(lat, lng);
		points.push(point);
	}

	this.route = new Route(points);

	View.drawRoute(route);

	View.setOutput(totalDistance, totalDuration, instructions);
	*/
	View.waiting(false);
	
	if(server_response.error){
		View.displayError(server_response.error);
		return;
	}else{
		var instructions = new Array();
		var durations = new Array();
		var distances = new Array();
		var points = new Array();
		var markerArray = new Array();

		//we always have just one route...
		var route = server_response.routes[0];
		//points.push(new OpenLayers.Geometry.Point(route.start_location[1],route.start_location[0]));

		var total_distance = route.distance.text;
		var total_duration = route.duration.text;
		var ctime = route.ctime.text;
		var traveltype = route.traveltype.text;

		for(var i=0; i < route.legs.length; i++){
      markerArray.push(new OpenLayers.Geometry.Point(route.legs[i].start_location[1], route.legs[i].start_location[0]));
			//here we could collect information about one leg(like intermediate goals) which is not needed so far
			for(var j=0; j < route.legs[i].steps.length; j++){
				var step = route.legs[i].steps[j];
				if(step.distance)
					distances.push(step.distance.value);
				if(step.duration)
					durations.push(step.duration.value);
				if(step.instruction)
					instructions.push(step.instruction);
			  for(var k=0; k < step.polyline.length; k++) {
          points.push(new OpenLayers.Geometry.Point(step.polyline[k][1], step.polyline[k][0]));
        }
			}
		}
		markerArray.push(new OpenLayers.Geometry.Point(route.end_location[1],route.end_location[0]));
		this.objectMapView.drawRoute(points);
		this.objectMapView.drawMarker(markerArray);
		//instructions is an array!
		//TODO maybe reverse geocoding for start and destination here
		View.setOutput(total_distance, total_duration, ctime, traveltype, route.start_location, route.end_location, instructions);
	}
};


//TODO documentation
Controller.prototype.init = function (){
	var query = View.getInputValues();
	var api = query.API;
	var features = Server_Comm.getFeatures( api,
		function(features){
			View.setFeatures(features);
		}
	);
	View.setFeature(features); 
};


//TODO documentation
Controller.prototype.cancel = function () {
	canceled = true;
	Server_Comm.cancelCurrentRequest();
	View.waiting(false);
	View.displayError("Calculation canceled.");
};
