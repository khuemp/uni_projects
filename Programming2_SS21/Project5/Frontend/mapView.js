function MapView(){
		var map; //complex object of type OpenLayers.Map
		var route; //route already drawn?
		var markerDrawn //marker already drawn?
		var lgpx; //routeLayer
		var markers; //the markers
	
		//inital start position
		var lat=49.254781;
    var lon=7.041368;

		var lonLat;
		
		//initial zoom level
		var zoom=17;
		
		//is there a route on the map?
		this.route = false;
 
		OpenLayers.DOTS_PER_INCH = 72;
 
		//Initialise the 'mapDiv' object
		//You can use it in HTML with <div style="width:1024px; height:90%" id="map"></div>
		this.map = new OpenLayers.Map ("map", {
				controls:[
					new OpenLayers.Control.Navigation(),
					new OpenLayers.Control.PanZoomBar(),
					new OpenLayers.Control.LayerSwitcher(),
					new OpenLayers.Control.Attribution()],
				minResolution: "auto",
                minExtent: new OpenLayers.Bounds(-1, -1, 1, 1),
                maxResolution: "auto",
                maxExtent: new OpenLayers.Bounds(-180, -90, 180, 90),
				numZoomLevels: 19,
				units: 'm',
				projection: new OpenLayers.Projection("EPSG:900913"),
				displayProjection: new OpenLayers.Projection("EPSG:4326")
				} );
 
		
			
			// Define the map layer
			// Note that we use a predefined layer that will be
			// kept up to date with URL changes
			// Here we define just one layer, but providing a choice
			// of several layers is also quite simple
			// Other defined layers are OpenLayers.Layer.OSM.Mapnik, OpenLayers.Layer.OSM.Maplint and OpenLayers.Layer.OSM.CycleMap
			layerMapnik = new OpenLayers.Layer.OSM.Mapnik("Mapnik");
			this.map.addLayer(layerMapnik);
			

			//layerCycleMap = new OpenLayers.Layer.OSM.CycleMap("CycleMap");
			//this.map.addLayer(layerCycleMap);
 
			this.lonLat = new OpenLayers.LonLat(lon, lat).transform(new OpenLayers.Projection("EPSG:4326"), this.map.getProjectionObject());
			this.map.setCenter (this.lonLat, zoom);
 
			
			this.map.events.register('click', this.map, this.handleMapClick);

}
/**
 * This function converts the position of the mouse to a lonlat variable.
 * 
 * @param evt Contains the position of the mouse when clicking
 */

MapView.prototype.handleMapClick = function(evt){

	var lonlat = Controller.getMap().getLonLatFromViewPortPx(evt.xy).transform(Controller.getMap().getProjectionObject(),new OpenLayers.Projection("EPSG:4326"));

	View.setEmptyField(Geocoding.similarAdresses(lonlat.lat + " " + lonlat.lon, 1)[0]);
	
//	if(!document.getElementById("place_A").value) {
////		View.setInputField("place_A", lonlat.lat + " " + lonlat.lon);
//		var address = Geocoding.similarAdresses(lonlat.lat + " " + lonlat.lon, 1);
//		View.setInputField("place_A", address);
//	} else {
//		if(!document.getElementById("place_B").value) {
////			View.setInputField("place_B", lonlat.lat + " " + lonlat.lon);
//			var address = Geocoding.similarAdresses(lonlat.lat + " " + lonlat.lon, 1);
//			View.setInputField("place_B", address);
//		}
//	}	
};



/*
 * converts the points into lonLat
 * so they can be used for a Layer
 */
MapView.prototype.convertPoints = function(points){
	//document.show.board.value = document.show.board.value + " \n" + points
	var lonLat;
	for (var i = 0; i<points.length; i++){

		lonLat = new OpenLayers.LonLat(points[i].x, points[i].y).transform(new OpenLayers.Projection("EPSG:4326"), this.map.getProjectionObject());
		points[i] = new OpenLayers.Geometry.Point(lonLat.lon,lonLat.lat);

	}
	//document.show.board.value = document.show.board.value + " \n" + points
	return points;
}

/**
 * given a list of points this function draws a marker layer in the map
 * maximum number of marker is 8
 */
MapView.prototype.drawMarker = function(markerList){

	if (this.markerDrawn==true){
		this.map.removeLayer(this.markers);
		this.markerDrawn=false;
	}
	
	var markerListCopy = markerList.slice();
	
	markerListCopy = this.convertPoints(markerListCopy);
	
	this.markers = new OpenLayers.Layer.Markers( "Markers" );
	this.map.addLayer(this.markers);
	
	//initialalize markers
	var size = new OpenLayers.Size(21,25);
	var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
	var icon = new Array(5);
	icon[0] = new OpenLayers.Icon('images/markerA.png', size, offset);
	icon[1] = new OpenLayers.Icon('images/markerB.png', size, offset);
	icon[2] = new OpenLayers.Icon('images/markerC.png', size, offset);
	icon[3] = new OpenLayers.Icon('images/markerD.png', size, offset);
	icon[4] = new OpenLayers.Icon('images/markerE.png', size, offset);
	icon[5] = new OpenLayers.Icon('images/markerF.png', size, offset);
	icon[6] = new OpenLayers.Icon('images/markerG.png', size, offset);
	icon[7] = new OpenLayers.Icon('images/markerH.png', size, offset);
	
	for (var i = 0; i<markerListCopy.length; i++){
		this.markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(markerListCopy[i].x,markerListCopy[i].y),icon[i]));
	}
	
	this.markerDrawn=true;
}

/**
 * given a list of points this function draws a marker layer in the map
 * maximum number of marker is 8
 */
MapView.prototype.drawMarkerPoint = function(point){

	if(this.route == true) {
		this.map.removeLayer(this.lgpx);
		this.route = false;
	}
	
	if (this.markerDrawn==true){
		this.map.removeLayer(this.markers);
		this.markerDrawn=false;
	}
	
	this.markers = new OpenLayers.Layer.Markers( "Markers" );
	this.map.addLayer(this.markers);
	
	lonLat = new OpenLayers.LonLat(point.y, point.x).transform(new OpenLayers.Projection("EPSG:4326"), this.map.getProjectionObject());
	
	//initialalize markers
	var size = new OpenLayers.Size(21,25);
	var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
	var icon = new OpenLayers.Icon('images/markerA.png', size, offset);
	
	this.markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(lonLat.lon,lonLat.lat),icon));
	
	
	this.markerDrawn=true;
}

/*
 * draws a route for a given pointList
 * if a route already is drawn, it will be deleted.
 */
MapView.prototype.drawRoute = function(pointList)
{
	
	if (this.route==true){
		this.map.removeLayer(this.lgpx);
		this.route=false;
	}
		
		
	var pointListCopy = pointList.slice();
	
	pointListCopy = this.convertPoints(pointListCopy);

	
	//defines the shape of the route
	 
	var color = "#ff0000";
	var style_green = {
            strokeColor: color,
            strokeOpacity: 0.6,
            strokeWidth: 5,
            pointRadius: 6,
            pointerEvents: "visiblePainted"
    };
	
    
    var featureTRK = [];
    featureTRK.push(new OpenLayers.Feature.Vector(new OpenLayers.Geometry.LineString(pointListCopy),null,style_green), color);
    
	this.lgpx = new OpenLayers.Layer.Vector("Route");
	this.lgpx.addFeatures(featureTRK);
	this.map.addLayer(this.lgpx);
	
	this.route=true;
	
	this.map.zoomToExtent(this.lgpx.getDataExtent());
	this.zoom = this.map.getZoom();
	
	/*
	 * this is only for testing issues. Remove it when implementing the drawMarker function in the controller.
	 */
	//var markerArray = new Array(pointList[0],pointList[(pointList.length-1)/2],pointList[pointList.length-1]);
//	var markerArray = new Array(pointList[0],pointList[Math.floor((pointList.length-1)/4)],pointList[Math.floor((pointList.length-1)*(3/4))],pointList[pointList.length-1]);
//	this.drawMarker(markerArray);
	
	
}




/*
 * You have to use this in the Controler to get the MapObject
 */
MapView.prototype.getMap = function(){
	return this.map;
}

/*
 * searches a point 
 * using the actual zoom level
 */
MapView.prototype.searchPoint = function(point)
{

	this.zoom = this.map.getZoom();
	lonLat = new OpenLayers.LonLat(point.y, point.x).transform(new OpenLayers.Projection("EPSG:4326"), this.map.getProjectionObject());

	this.map.setCenter (lonLat, this.zoom);
}

