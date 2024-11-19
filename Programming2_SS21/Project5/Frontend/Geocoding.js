/**
 * @class Geocoding
 *
 * Translates a string from the API to a point representing a point
 * of the calculated route. Full text addresses and GPS values are
 * supported. 
 */
function Geocoding() {
}


//TODO Support more than two destinations. May-Have feature.
/**
 * Calls a geocoding API to convert readable addresses into GPS coordinates.
 * @param address A string containing an address in a not further standardized format (with/without postal code, country, etc., POI?)
 *
 * 
 * @returns A point object if conversion was successful, false otherwise.
 */
Geocoding.prototype.getCoords = function(address) {

	//Reordered this, because convertGPS does not recognize a non GPS-Value yet, but
	//convertAddress does recognize a non-Address.
	var point;
	try {
		point = Geocoding.convertAddress(address);
		return point;
	} catch(e) {
		point = Geocoding.convertGPS(address);
	
		if(!point) {
			throw e;
		}
		return point;
	}
};

//Does not seem to be needed, string = string.replace(/\s/g, "+"); does the same job.
/*
function replaceAll(Source,stringToFind,stringToReplace){
  var temp = Source;
  var index = temp.indexOf(stringToFind);
    while(index != -1){
        temp = temp.replace(stringToFind,stringToReplace);
        index = temp.indexOf(stringToFind);
    }
    return temp;
};
*/

/**
 * Calls a webservice (OpenStreetMap) to convert a full text address into corrdinates.
 *
 * @param string A string containing the address.
 * @throws undefined-Exception if the address is no full text address.
 *
 * @return point A Geometry.Point object containing the coordinates of the address.
 */
Geocoding.prototype.convertAddress = function(string) {

	var xmlhttp=new XMLHttpRequest(); //Create XMLHttpRequest object 
	string = string.replace(/\s/g, "+");
	
	xmlhttp.open("GET",encodeURI("https://nominatim.openstreetmap.org/search?q="+string+"&format=json&polygon=1&addressdetails=0"),false);
	xmlhttp.send();
	
	var json = JSON.parse(xmlhttp.responseText);
	if(!json[0]){
		throw Exception;
	}
	var lat = json[0].lat;
	var lon = json[0].lon;
	return (new OpenLayers.Geometry.Point(lat, lon));
};

/**
 * Calls a webservice (OpenStreetMap) asynchronously to convert a full text address into corrdinates.
 *
 * @param string A string containing the address.
 * @throws undefined-Exception if the address is no full text address.
 *
 * @return point A Geometry.Point object containing the coordinates of the address.
 */
Geocoding.prototype.convertAddressAsy = function(string, handler) {

	var xmlhttp= Server_Comm.newServerCall(); 
	string = string.replace(/\s/g, "+");
	
	xmlhttp.onreadystatechange = function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			var json = JSON.parse(xmlhttp.responseText);
			if(!json[0]){
				return;
			}
			var lat = json[0].lat;
			var lon = json[0].lon;
			handler(new OpenLayers.Geometry.Point(lat, lon)); //parse and pass
		}
	};
	
	xmlhttp.open("GET",encodeURI("https://nominatim.openstreetmap.org/search?q="+string+"&format=json&polygon=1&addressdetails=0"),true);
	xmlhttp.send(null);
};

/**
 * Calls a webservice (OpenStreetMap) to show similar adresses of a full text address.
 *
 * @param string A string containing the address.
 * @param number number of the returned adresses
 * @throws undefined-Exception if the address is no full text address.
 *
 * @return adressArray An Array containing the 8 best hits as strings, if they exists.
*/
Geocoding.prototype.similarAdresses = function(string,number) {
	var xmlhttp=new XMLHttpRequest(); //Create XMLHttpRequest object 
	string = string.replace(/\s/g, "+");
	xmlhttp.open("GET",encodeURI("https://nominatim.openstreetmap.org/search?q="+string+"&format=json&polygon=1&addressdetails=0"),false);
	xmlhttp.send();
	
	var json = JSON.parse(xmlhttp.responseText);
	//returns the 8 best hits
	var adressArray = new Array();
	for ( var i = 0 ; i < number ; i++){
		if (json.length > i){
			adressArray[i] = json[i].display_name;
		}
	};
	return adressArray;
};

/**
 * Calls a webservice (OpenStreetMap) asynchronously to show similar addresses of a full text address.
 *
 * @param string A string containing the address.
 * @param number number of the returned adresses
 * @throws undefined-Exception if the address is no full text address.
 *
 * @return adressArray An Array containing the 8 best hits as strings, if they exists.
*/
Geocoding.prototype.similarAddressesAsy = function(string,number, handler) {
	var xmlhttp= Server_Comm.newServerCall(); 
	string = string.replace(/\s/g, "+");
	
	xmlhttp.onreadystatechange = function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			var json = JSON.parse(xmlhttp.responseText);
			//returns the 8 best hits
			var adressArray = new Array();
			for ( var i = 0 ; i < number ; i++){
				if (json.length > i){
					adressArray[i] = json[i].display_name;
				}
			};
			handler(adressArray); //parse and pass
		}
	};
	
	xmlhttp.open("GET",encodeURI("https://nominatim.openstreetmap.org/search?q="+string+"&format=json&polygon=1&addressdetails=0"),true);
	xmlhttp.send(null);
};



/**
 * Converts the given GPS coordinates into normal coordinates locally. Needs no webservice
 * for this.
 *
 * @param string A string containing the GPS-coordinates.
 *
 * @return A point containing the coordinates or false, if the input was not GPS-coordinate.
 */
Geocoding.prototype.convertGPS = function (string){

	var parse = function(s){
		//replace , with . and parse the string to a float
		var ret = s.replace(/,/g,".");
		return parseFloat(ret);
	}

	var north;
	var east;
	
	//first check if string contains a °
	if(string.match(/°/)){
		var h;
		var min;
		var sec;
		//look if we have 49° 32.12312' or 49° 32' 13143.232''
		if(string.match(/''/)){
			var regExpMinSecNorth = /(?:N|S)\s*(\d+)°\s*(\d+)'\s*(\d+(?:(?:\.|,)\d+)?)''/i ;
			var regExpMinSecEast = /(?:E|W)\s*(\d+)°\s*(\d+)'\s*(\d+(?:(?:\.|,)\d+)?)''/i ;
			var complexGPSNorth = regExpMinSecNorth.exec(string);
			var complexGPSEast = regExpMinSecEast.exec(string);
			if(complexGPSNorth && complexGPSEast){
				h = parse(complexGPSNorth[1]);
				min = parse(complexGPSNorth[2]);
				sec = parse(complexGPSNorth[3]);
				north = h + (min/60.0 + sec/3600);
				h = parse(complexGPSEast[1]);
				min = parse(complexGPSEast[2]);
				sec = parse(complexGPSEast[3]);
				east = h + (min/60.0 + sec/3600);
			}else{
				var regExpMinSecWithoutNE = /-?(\d+)°\s*(\d+)'\s*(\d+(?:(?:\.|,)\d+)?)''/ ;
				//search the first occurence
				var complexGPS = regExpMinSecWithoutNE.exec(string);
				if(complexGPS){
					h = parse(complexGPS[1]);
					min = parse(complexGPS[2]);
					sec = parse(complexGPS[3]);
					north = h + (min/60.0 + sec/3600);
					if(complexGPS[0].match(/-/))
						north = -north;
					//search the second occurence
					var splString = string.substr(complexGPS[0].length,string.length);
					complexGPS = regExpMinSecWithoutNE.exec(splString);
					if(complexGPS){
						h = parse(complexGPS[1]);
						min = parse(complexGPS[2]);
						sec = parse(complexGPS[3]);
						east = h + (min/60.0 + sec/3600);
						if(complexGPS[0].match(/-/))
							east = -east;
					}
				}
			}
		}else{
			//last check: 49° 32.1234'
			var regExpMinNorth = /(?:N|S)\s*(\d+)°\s*(\d+(?:(?:\.|,)\d+)?)'/i ;
			var regExpMinEast = /(?:E|W)\s*(\d+)°\s*(\d+(?:(?:\.|,)\d+)?)'/i ;
			var minGPSNorth = regExpMinNorth.exec(string);
			var minGPSEast = regExpMinEast.exec(string);
			if(minGPSEast && minGPSNorth){
				h = parse(minGPSNorth[1]); 
				min = parse(minGPSNorth[2]);
				north = h + (min/60.0);
				h = parse(minGPSEast[1]); 
				min = parse(minGPSEast[2]);
				east = h + (min/60.0);
			}else{
				var regExpMinWithoutNE = /-?(\d+)°\s*(\d+(?:(?:\.|,)\d+)?)'/ ;
				var minGPS = regExpMinWithoutNE.exec(string);
				if(minGPS){
					h = parse(minGPS[1]);
					min = parse(minGPS[2]);
					north = h + min/60.0;
					if(minGPS[0].match(/-/))
						north = -north;
					var splittedString = string.substr(minGPS[0].length,string.length);
					minGPS = regExpMinWithoutNE.exec(splittedString);
					if(minGPS){
						h = parse(minGPS[1]);
						min = parse(minGPS[2]);
						east = h + min/60.0;
						if(minGPS[0].match(/-/))
							east = -east;
					}
				}
			}
		}
	}else{
		//check if the string is a simple input
		//Simple would be N49.323121 E34.345435
		var regExpSimpleNorth = /(?:N|S)\s*(\d+(?:(?:\.|,)\d+)?)/i ;
		var regExpSimpleEast = /(?:E|W)\s*(\d+(?:(?:\.|,)\d+)?)/i ;
		
		var simpleGPSNorth = regExpSimpleNorth.exec(string);
		var simpleGPSEast = regExpSimpleEast.exec(string);
		
		if(simpleGPSNorth && simpleGPSEast){
			north = parse(simpleGPSNorth[1]);
			east = parse(simpleGPSEast[1]);
		}else{
			//if no N and E are given, we interprete the first as north and the second as east
			var regExpSimpleWithoutNE = /(-?\d+(?:(?:\.|,)\d+)?)/ ;
			var simpleGPS;
			simpleGPS = regExpSimpleWithoutNE.exec(string);
			if(simpleGPS){
				north = parse(simpleGPS[1]);
				//look for the next occurence
				var splitString = string.substr(simpleGPS[0].length,string.length);
				simpleGPS = regExpSimpleWithoutNE.exec(splitString);
				if(simpleGPS){
					east = parse(simpleGPS[1]);
				}
			}
		}
	}
	
	if(north && east){
		if(north > 60 || north < -60 || east > 60 || east < -60)
			return false;
		if(string.match(/S/i))
			north = -north;
		if(string.match(/W/i))
			east = -east;
		return new OpenLayers.Geometry.Point(north, east);
	}
	
	//no valid coordinate
	return false;
};



//Static.
var Geocoding = new Geocoding();
