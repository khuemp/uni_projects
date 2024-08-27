function View() {
	/**
	 * emulates a class "View"
	 */
}

View.prototype.destinations = [{name : "", coords: null}, {name : "", coords: null}];
/**
 * changes the text in the
 * <td> object with given id sID to new text sText.
 */
View.prototype.replaceText = function (sId, sText) {
	document.getElementById(sId).innerHTML = sText;
};

/**
 * Sets the output (length, duration, turn by turn instructions) into the output
 * field on the left.
 * 
 * @param length:
 *            string with length and unit of the calculated route such as "32.5km"
 * @param duration:
 *            formatted string with duration of the calculated route such as "1h 12 min"
 * @param start:
 *            well formatted string with start of the route, such as
 *            "Outreauplatz, 66571 Eppelborn"
 * @param dest:
 *            well formatted string representing the destination of the route
 * @param instructions:
 *            as String[] which contains the turn by turn instructions (may have feature)
 */
View.prototype.setOutput = function(length, duration, time, traveltype, start, dest, instructions) {
	var output = "Length: " + length + "<br/>" 
				+ "Travel type: " + traveltype + "<br/>"
				+ "Computation time: " + time + "<br/><hr/>";
				//+ "Duration: " + duration + "<br/><hr/>";
	var title = "<h1>Route from&nbsp;&quot;" + start + "&quot; to&nbsp;&quot;" + dest + "&quot;: </h1>";
	output = output + title +"<ol>";
	if (instructions) for (var i = 0; i < instructions.length; i++) {
		output = output + "<li>" + instructions[i] + "</li>";
	}
	output = output + "</ol>";
	this.replaceText("output", output);
};

/**
 * called if an error occurred. Shows an message in the output field on the left
 * with given error message.
 */
View.prototype.displayError = function(message) {
	var s = "<br /><span style=\"color:red\">Error: <br /><b>" + message + "</b></span>";
	this.replaceText("output", s);
};

/**
 * reads the mode of transport actually selected in the browser
 */
View.prototype.getMode = function() {
	var result = "";
	if (document.getElementsByName("mot")[0].checked) {
		result = "driving";
	} else {
		if (document.getElementsByName("mot")[1].checked) {
			result = "bicycling";
		} else {
			if (document.getElementsByName("mot")[2].checked) {
				result = "walking";
			} else {
				result = "ERROR";
			}
		}
	}
	return result;
};

/**
 * reads the length unit actually selected in the browser
 */
View.prototype.getUnit = function() {
	var result = "";
	if (document.getElementsByName("lunit")[0].checked) {
		result = "km";
	} else {
		if (document.getElementsByName("lunit")[1].checked) {
			result = "miles";
		} else {
			result = "ERROR";
		}
	}
	return result;
};

/**
 * reads the API actually selected in the browser
 */
View.prototype.getAPI = function() {
	return ViewIO.api[1];
};

/**
 * Writes the given string into the input field A or B.
 * @param "place_0" or "place_1": string
 * @param string that will be placed in input field A or input field B
 */
View.prototype.setInputField = function (str) {
	if(field == "place_A") field = "place_0";
	if(field == "place_B") field = "place_1";
	document.getElementById(field).value = str;
};

/**
 * Writes the given string in the first empty destination field.
 */
View.prototype.setEmptyField = function (str) {
	for(var i = 0; i<this.destinations.length; i++)
		if(document.getElementById("place_"+i).value == ""){
			document.getElementById("place_"+i).value = str;
			Geocoding.convertAddressAsy(str, function(coords) {
				View.destinations[i].coords = coords;
			});
			return;
		}
};

function isInt(n){
  return Number(n)===n && n%1===0;
}

function isFloat(n){
  return n===Number(n)  && n%1!==0
}

/**
 * returns a Query object with the input values the user entered
 * 
 * destinations are saved as Strings.
 */
View.prototype.getInputValues = function() {
	var mode = this.getMode();
	var api = this.getAPI();
	for(var i = 0; i<this.destinations.length; i++)
		if(this.destinations[i].name != document.getElementById("place_"+i).value){
			this.destinations[i].name = document.getElementById("place_"+i).value;
			if(this.destinations[i].name != "") {
        if ((isInt(parseInt(this.destinations[i].name))) && (parseInt(this.destinations[i].name) == this.destinations[i].name))
          this.destinations[i].coords = this.destinations[i].name;
        else
          this.destinations[i].coords = Geocoding.getCoords(this.destinations[i].name);
			} else this.destinations[i].coords = null;
		}

	var ret = new Array();
	for(var i = 0; i<this.destinations.length; i++){
		ret.push(this.destinations[i].coords);
	}

	return new Query(ret, mode, api, "time");
};

/**
 * returns the associated label with el
 */
//View.prototype.findLabel = function (el) {
//	var idVal = el.id;
//	labels = document.getElementsByTagName('label');
//	for ( var i = 0; i < labels.length; i++) {
//		if (labels[i].htmlFor == idVal)
//			return labels[i];
//	}
//};

/**
 * hides the options in the web interface that are not supported by the API
 */
View.prototype.setFeatures = function (features){
	// TRAVELMODE: at least "driving" has to be supported corresponding to API
	ViewIO.showGrit("mot_bike_div", features.travelmode.bicycling);
	ViewIO.showGrit("mot_byfoot_div", features.travelmode.walking);

	// METRIC: at least one of them has to be supported corresponding to API
	if(features.metric.distance || features.metric.energy){
		ViewIO.showGrit("met_dist_div", features.metric.distance);
		ViewIO.showGrit("met_en_div", features.metric.energy);
	}else{
		ViewIO.showGrit("met", false);
	}
	// AVOID:
	// hide whole block "Avoid:"
	ViewIO.showGrit("avoid", !features.avoid);

	if(features.avoid){
		// set variables (false if has to be hidden)
		var tolls	= (features.avoid.tolls);
		var hw		= (features.avoid.highways);
		var ferries	= (features.avoid.ferries);
		var unpaved	= (features.avoid.unpaved);
		var sc		= (features.avoid.seasonal_closure);
		var cc		= (features.avoid.country_crossing);

		ViewIO.showGrit("avoid", tolls || hw || ferries || unpaved || sc || cc);
		
		ViewIO.showGrit("avoid_tolls_div", tolls);
		ViewIO.showGrit("avoid_highways_div" , hw);
		ViewIO.showGrit("avoid_ferries_div", ferries);
		ViewIO.showGrit("avoid_unpaved_div", unpaved);
		ViewIO.showGrit("avoid_sc_div", sc);
		ViewIO.showGrit("avoid_cc_div", cc);
	}else{
		ViewIO.showGrit("avoid", false);
	}
	
};

/**
 * shows a waiting perspective on the screen during calculation
 */
View.prototype.waiting = function(b) {
	var popup = document.getElementById("waitpopup");

	if (b) {
		popup.style.top = Math.floor((window.innerHeight - document
				.getElementById("waitpopup").offsetHeight) / 2)
				+ "px";
		popup.style.left = Math.floor((window.innerWidth - document
				.getElementById("waitpopup").offsetWidth) / 2)
				+ "px";
		popup.style.visibility = "visible";
	} else {
		document.getElementById("waitpopup").style.visibility = "hidden";
	}
};

var View = new View();
