/**
 * This file contains all methods for input and output handling of the web
 * interface.
 */

function ViewIO() {
	
	/**
	 * number of the actually chosen API and string that
	 * contains the actually chosen API
	 */
	this.api = [ 0, "default" ];
	//TODO: insert valid API String which is used as default
	
	/**
	 * Save a scheduled task needed for handling user input in destination fields.
	 */
	this.geoTimeOut;
	
	/**
	 * This function hides the options panel when visible and shows it when
	 * invisible (=hidden) by setting the corresponding CSS properties.
	 */
	this.hideOptions = function () {
		var hide = document.getElementById("options").style.display == "none";
		document.getElementById("options").style.display = hide? "block" : "none";
		document.getElementById("maptd").style.marginLeft = hide? "250px" : "0px";
		document.getElementById("hidebar").style.backgroundImage = hide ? "url(images/hideOptions.png)" : "url(images/showOptions.png)";
		document.getElementById("hidebar").title = hide ? "Hide Options" : "Show Options";
		Controller.getMap().updateSize();
	};
	
	this.triggerPopup = function(id, show){
		var popup = document.getElementById(id);
		if (show) {
			popup.style.top = Math.floor((window.innerHeight - popup.offsetHeight) / 2)
					+ "px";
			popup.style.left = Math.floor((window.innerWidth - popup.offsetWidth) / 2)
					+ "px";
			popup.style.visibility = "visible";
		} else {
			popup.style.visibility = "hidden";
		}
	};

	/**
	 * This function handles the visibility of the settings popup.
	 */
	this.showSettings = function (show) {
		this.triggerPopup("settingspopup", show);
	};
	
	/**
	 * called when the API is changed in the Settings; that means when clicking the
	 * OK button in the Settings window. The global variable this.api is updated by
	 * the newly chosen API.
	 */
	this.updateAPI = function () {
		var sel = document.getElementById("selAPI");
		var index = sel.selectedIndex;
		this.api = [ index, sel.options[index].value + Url.get.port ];
		this.showSettings(false);
	};
	
	/**
	 * called when the Cancel button in the Settings window is clicked
	 */
	this.cancelSettings = function () {
		document.getElementById("selAPI").options[this.api[0]].selected = true;
		this.showSettings(false);
	};
	
	/**
	 * called when user cancels the calculation
	 */
	this.cancelCalculation = function() {
//		View.waiting(false);
		Controller.cancel(); // call cancel method of the controller
	};
	
	/**
	 * Called when clicking "x" right of an input button to delete this destination.
	 * 
	 * @param {}
	 *            num: number of the input field
	 */
	this.deleteDestination = function (num) {
		if(View.destinations.length <= 2) {
			document.getElementById("place_"+num).value = "";
      return;
    }
		for(var i = num; i<View.destinations.length-1; i++){
			document.getElementById("place_"+i).value = document.getElementById("place_"+(i+1)).value;
		}
		document.getElementById("place_"+(View.destinations.length-1)+"wrap").parentNode.removeChild(document.getElementById("place_"+(View.destinations.length-1)+"wrap"));
		View.destinations.splice(num, 1);
	};
	
	/**
	 * swaps start and destination in the input fields
	 */
	this.swapStartDestination = function () {
		var start = document.getElementById("place_0").value;
		var dest = document.getElementById("place_1").value;
		document.getElementById("place_0").value = dest;
		document.getElementById("place_1").value = start;
	};

	/**
	 * 
	 * Called when clicking "u" right of an input button.
	 * 
	 * @param {}
	 *            name: name of the input field
	 */
	this.inputFieldUp = function (name) {
		this.swapStartDestination();
	};
	/**
	 * Called when clicking "d" right of an input button.
	 * 
	 * @param {}
	 *            name: name of the input field
	 */
	this.inputFieldDown = function (name) {
		this.swapStartDestination();
	};
	
	/**
	 * called when "Calculate Route"-button is clicked.
	 */
	this.beginCalculation = function () {
		View.replaceText("output",""); // leere Outputfeld
		if(document.getElementById("place_0").value == ""){
			this.highlightInput("place_0", "No address entered.");
		}
		Controller.computeRoute(); // call start method of the controller
	};
	
	this.highlightInput = function(id, message){
		document.getElementById(id).style.border = "2px solid red";
	};
	
	this.unhighlightInput = function(field){
		field.style.border = null;
	};
	
	
	/**
	 * sets a div-Object visible (show == true) or hides it.
	 */
	this.showGrit = function (id, show) {
		var mode = document.getElementById(id).className.indexOf("blist") == -1 ? "block" : "inline-block";
		document.getElementById(id).style.display = show ? mode : "none";
	};

	this.stopSuggestions = function(){
		//alten Timeout abbrechen
		if(this.geoTimeOut) {
			window.clearTimeout(this.geoTimeOut);
			this.geoTimeOut = null;
		}
	};
	
	this.destFieldChanged = function (num){
		//alten Timeout abbrechen
		if(this.geoTimeOut) {
			window.clearTimeout(this.geoTimeOut);
			this.geoTimeOut = null;
		}
		this.geoTimeOut = window.setTimeout("ViewIO.showSuggestions(\"" + num + "\", \"" + document.getElementById("place_"+num).value +"\")", 600);
	};
	
	this.showSuggestions = function(id, dest) {
		
		var handler = function(sugg) {
			var html = "<ul>";
			
			var even = false;
			for(var i = 0; i < sugg.length; i++){
				var row = sugg[i];
				html = html + "<li onclick=\"ViewIO.chooseSuggestion(this, "+id+")\" class=\"" + (even? "even" : "odd") + "\">" + row + "</li>";
				even = !even;
			}
			
			html = html + "</ul>";
			document.getElementById("place_" + id + "suggestions").innerHTML = html; 
			this.geoTimeOut = null;
		};
		Geocoding.similarAddressesAsy(dest,8, handler);
		
	};
	
	this.chooseSuggestion = function(choice, id){
		document.getElementById("place_"+id).value = choice.innerHTML;
		document.getElementById("place_"+id + "suggestions").innerHTML = "";
		View.destinations[id].name = choice.innerHTML;
		Geocoding.convertAddressAsy(choice.innerHTML, function(arg) {
			View.destinations[id].coords = arg;
		});
	};
	
	this.hideSuggestions = function() {
		for(var i = 0; i< View.destinations.length; i++){
			if(document.getElementById("place_" + i + "suggestions")) document.getElementById("place_" + i + "suggestions").innerHTML = "";
		}
	};
	
	this.showPlace = function(dest){
		if(View.getInputValues().destinations[dest]) 
			Controller.objectMapView.searchPoint(View.getInputValues().destinations[dest]);
	};
	
	this.addDest = function() {
		var dests = View.destinations;
		var newone = dests.length;
		var newLetter;
		switch (newone) {
		case 0:	newLetter = "A"; break;
		case 1:	newLetter = "B"; break;
		case 2:	newLetter = "C"; break;
		case 3:	newLetter = "D"; break;
		case 4:	newLetter = "E"; break;
		case 5:	newLetter = "F"; break;
		case 6:	newLetter = "G"; break;
		case 7:	newLetter = "H"; break;
		default:
			return; //reached max.
		}
		dests.push({name : "", coords : null});
		var node = document.createElement("div");
		node.setAttribute("id", "place_" + newone + "wrap");
		node.setAttribute("class", "location navform destpicker");
		var tmp = "	<table style=\"width: 100%\">"
				+"		<tr>"
				+"			<td><label for=\"place_ID\" onclick=\"ViewIO.showPlace(ID)\" title=\"Click to show this place in the map\">" + newLetter + "</label></td>"
				+"			<td>"
				+"				<input id=\"place_ID\" type=\"text\" class=\"textfield\" onkeyup=\"ViewIO.destFieldChanged(ID)\" />"
				+"				<div id=\"place_IDsuggestions\" class=\"suggestions\"></div>"
				+"				</td>"
				+"			<td><input type=\"button\" value=\"\""
				+"				onclick=\"ViewIO.inputFieldUp('place_ID')\" class=\"button bup\""
				+"				title=\"Move destination up in list\" /></td>"
				+"			<td><input type=\"button\" value=\"\""
				+"				onclick=\"ViewIO.inputFieldDown('place_ID')\" class=\"button bdown\""
				+"				title=\"Move destination down in list\" /></td>"
				+"			<td><input type=\"button\" value=\"\""
				+"				onclick=\"ViewIO.deleteDestination(ID)\""
				+"				class=\"button bdelete\" title=\"Delete destination\" /></td>"
				+"		</tr>"
				+"	</table>";
		node.innerHTML = tmp.replace(/ID/g, newone);
		document.getElementById("locations").appendChild(node);
	};
}
var ViewIO = new ViewIO();

