/**
 * The server communication used to access the servers of algorithm engineering groups
 */
function Server_Comm() {
	this.newServerCall = function () {
		if (window.XMLHttpRequest){
			// code for IE7+, Firefox, Chrome, Opera, Safari
			return new XMLHttpRequest();
		}
		else{
			// code for IE6, IE5
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	};
	/**
	 * Pending request if present, null otherwise
	 */
	this.xmlhttp = this.newServerCall();
	
	/**
	 * Starts a new computation request to the API given in the query object parameter.
	 * Cancels pending computations. After receiving the result, processResult() is called.
	 */
	this.getRoute = function (query, handler){
		this.cancelCurrentRequest();
		this.xmlhttp = this.newServerCall();
		
		// Encode query to url
		var urlWithParams = this.buildUrl(query);
		var ref = this.xmlhttp;
		this.xmlhttp.onreadystatechange = function(){
			if (ref.readyState==4 && ref.status==200){
				try{
					handler(JSON.parse(ref.responseText)); //parse and pass
				}catch (e){
					handler({error: ref.responseText });
				}
			}
			if(ref.readyState==4 && ref.status>=400){
//				handler(dummy);
				handler({error : "The computation was not successful. Server answer: " + ref.statusText});
			}
		};
		this.xmlhttp.open("GET",urlWithParams,false);
		this.xmlhttp.send(null);
	};
	
	/**
	 * Starts a call for features the given API is able to deal with. After receiving
	 * the feature list it calls the given handler with the response
	 */
	this.getFeatures = function(apiUrl, handler){
		var featureReq = this.newServerCall();
		featureReq.onreadystatechange = function(){
			if (featureReq.readyState==4 && featureReq.status==200){
				handler(JSON.parse(featureReq.responseText)); //parse and pass
			}
			if (featureReq.readyState==4 && featureReq.status>=400){
				handler({error: "Computation failed. Server response: "+ref.statusText});
			}
		};
		featureReq.open("GET", this.bypass + apiUrl + "/features",true);
		featureReq.send(null);
	};
	
	//this.connection = function (){
	//	var featureReq = newServerCall();
	//	var answer = false;
	//	
	//	featureReq.onreadystatechange = function(){
	//		if (featureReq.readyState==4 && featureReq.status==200){
	//			answer = true; //parse this and send it to controller/view?
	//		}
	//	};
	//	featureReq.open("POST",url + "/features",true);
	//	featureReq.send();
	//	window.setTimeout("return answer;",1000);
	//	return true;
	//};
	
	/**
	 * Aborts current server request.
	 */
	this.cancelCurrentRequest = function () {
		if(this.xmlhttp && this.xmlhttp.readyState != 4){
			this.xmlhttp.abort();
		}
	};
	
	/**
	 * Builds up the url for a (GET) server request given a valid query object.
	 * 
	 * @param query the query object containing the needed parameters
	 * @returns {String} the computed url
	 */
	this.buildUrl = function (query) {
		//encode waypoints
		var points = query.destinations;
		var ret = document.location + "/routes?waypoints";
		for (var i = 0; i < points.length; i++)
      if (parseInt(points[i]) == points[i])
        ret = ret + "|" + points[i];
      else
        ret = ret + "|" + points[i].x + "," + points[i].y;
		//optional options
		if(query.mode)
			ret = ret + "|travelmode=" + query.mode; //& must be encoded to %26 for the forwarding script in api.php
		if(query.metric)
			ret = ret + "|metric=" + query.metric;
		if(query.avoid){
			ret = ret + "|avoid=" + query.avoid[0];
			for(var i = 1; i < query.avoid.length; i++)
				ret = ret + "|" + query.avoid[i];
		}
		return ret;
	};
}
var Server_Comm = new Server_Comm(); //emulates a "static class"
