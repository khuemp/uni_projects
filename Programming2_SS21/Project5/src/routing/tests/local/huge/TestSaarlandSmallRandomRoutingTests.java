package routing.tests.local.huge;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import routing.Graph;
import routing.Node;
import routing.Route;
import routing.TravelType;
import routing.tests.TestingBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSaarlandSmallRandomRoutingTests extends TestingBase {

@Test(timeout = 15000)
public void testSmallRouting0RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1544835161l, 1219490209l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1544835161l, 1219490209l, TravelType.BIKE, false);
    computeRoute(1544835161l, 1219490209l, TravelType.CAR, false);
    Route r2a = computeRoute(1544835161l, 1219490209l, TravelType.FOOT, true);
    checkRoute(r2a, 16973.081210189488, 1544835161l, 1219490209l);
    Route r3a = computeRoute(1544835161l, 1219490209l, TravelType.ANY, true);
    checkRoute(r3a, 16972.625045444976, 1544835161l, 1219490209l);
}


@Test(timeout = 15000)
public void testSmallRouting1RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2718816619l, 408363256l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2718816619l, 408363256l, TravelType.BIKE, true);
    checkRoute(r0a, 22110.84559593359, 2718816619l, 408363256l);
    computeRoute(2718816619l, 408363256l, TravelType.CAR, false);
    Route r2a = computeRoute(2718816619l, 408363256l, TravelType.FOOT, true);
    checkRoute(r2a, 21426.167308751337, 2718816619l, 408363256l);
    Route r3a = computeRoute(2718816619l, 408363256l, TravelType.ANY, true);
    checkRoute(r3a, 21426.167308751337, 2718816619l, 408363256l);
}


@Test(timeout = 15000)
public void testSmallRouting2RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 299107879l, 2348997305l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(299107879l, 2348997305l, TravelType.BIKE, false);
    computeRoute(299107879l, 2348997305l, TravelType.CAR, false);
    Route r2a = computeRoute(299107879l, 2348997305l, TravelType.FOOT, true);
    checkRoute(r2a, 18122.835851067342, 299107879l, 2348997305l);
    Route r3a = computeRoute(299107879l, 2348997305l, TravelType.ANY, true);
    checkRoute(r3a, 17983.018843239468, 299107879l, 2348997305l);
}


@Test(timeout = 15000)
public void testSmallRouting3RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1911946777l, 278910959l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1911946777l, 278910959l, TravelType.BIKE, true);
    checkRoute(r0a, 30545.491500932567, 1911946777l, 278910959l);
    Route r1a = computeRoute(1911946777l, 278910959l, TravelType.CAR, true);
    checkRoute(r1a, 31518.039914042198, 1911946777l, 278910959l);
    Route r2a = computeRoute(1911946777l, 278910959l, TravelType.FOOT, true);
    checkRoute(r2a, 30281.593396459513, 1911946777l, 278910959l);
    Route r3a = computeRoute(1911946777l, 278910959l, TravelType.ANY, true);
    checkRoute(r3a, 30224.506170582314, 1911946777l, 278910959l);
}


@Test(timeout = 15000)
public void testSmallRouting4RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1247277556l, 488141296l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1247277556l, 488141296l, TravelType.BIKE, true);
    checkRoute(r0a, 57137.93953129119, 1247277556l, 488141296l);
    computeRoute(1247277556l, 488141296l, TravelType.CAR, false);
    Route r2a = computeRoute(1247277556l, 488141296l, TravelType.FOOT, true);
    checkRoute(r2a, 55610.53287812423, 1247277556l, 488141296l);
    Route r3a = computeRoute(1247277556l, 488141296l, TravelType.ANY, true);
    checkRoute(r3a, 55271.916776814614, 1247277556l, 488141296l);
}


@Test(timeout = 15000)
public void testSmallRouting5RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 408476182l, 473078259l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(408476182l, 473078259l, TravelType.BIKE, true);
    checkRoute(r0a, 21223.4724377844, 408476182l, 473078259l);
    computeRoute(408476182l, 473078259l, TravelType.CAR, false);
    Route r2a = computeRoute(408476182l, 473078259l, TravelType.FOOT, true);
    checkRoute(r2a, 20811.361939229035, 408476182l, 473078259l);
    Route r3a = computeRoute(408476182l, 473078259l, TravelType.ANY, true);
    checkRoute(r3a, 20811.361939229035, 408476182l, 473078259l);
}


@Test(timeout = 15000)
public void testSmallRouting6RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 264132126l, 2470337905l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(264132126l, 2470337905l, TravelType.BIKE, true);
    checkRoute(r0a, 36802.7365473988, 264132126l, 2470337905l);
    Route r1a = computeRoute(264132126l, 2470337905l, TravelType.CAR, true);
    checkRoute(r1a, 39103.533072215345, 264132126l, 2470337905l);
    Route r2a = computeRoute(264132126l, 2470337905l, TravelType.FOOT, true);
    checkRoute(r2a, 36644.412123003385, 264132126l, 2470337905l);
    Route r3a = computeRoute(264132126l, 2470337905l, TravelType.ANY, true);
    checkRoute(r3a, 35866.06887698462, 264132126l, 2470337905l);
}


@Test(timeout = 15000)
public void testSmallRouting7RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 492503916l, 278328917l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(492503916l, 278328917l, TravelType.BIKE, false);
    computeRoute(492503916l, 278328917l, TravelType.CAR, false);
    Route r2a = computeRoute(492503916l, 278328917l, TravelType.FOOT, true);
    checkRoute(r2a, 42105.75344989849, 492503916l, 278328917l);
    Route r3a = computeRoute(492503916l, 278328917l, TravelType.ANY, true);
    checkRoute(r3a, 41767.90074520818, 492503916l, 278328917l);
}


@Test(timeout = 15000)
public void testSmallRouting8RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 259000786l, 429906121l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(259000786l, 429906121l, TravelType.BIKE, false);
    computeRoute(259000786l, 429906121l, TravelType.CAR, false);
    Route r2a = computeRoute(259000786l, 429906121l, TravelType.FOOT, true);
    checkRoute(r2a, 54899.82987095784, 259000786l, 429906121l);
    Route r3a = computeRoute(259000786l, 429906121l, TravelType.ANY, true);
    checkRoute(r3a, 54886.94475388039, 259000786l, 429906121l);
}


@Test(timeout = 15000)
public void testSmallRouting9RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 384631341l, 585337508l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(384631341l, 585337508l, TravelType.BIKE, true);
    checkRoute(r0a, 12432.23996844832, 384631341l, 585337508l);
    computeRoute(384631341l, 585337508l, TravelType.CAR, false);
    Route r2a = computeRoute(384631341l, 585337508l, TravelType.FOOT, true);
    checkRoute(r2a, 11169.176039863421, 384631341l, 585337508l);
    Route r3a = computeRoute(384631341l, 585337508l, TravelType.ANY, true);
    checkRoute(r3a, 11169.176039863421, 384631341l, 585337508l);
}


@Test(timeout = 15000)
public void testSmallRouting10RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 432627420l, 1209314509l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(432627420l, 1209314509l, TravelType.BIKE, true);
    checkRoute(r0a, 50372.9038568058, 432627420l, 1209314509l);
    computeRoute(432627420l, 1209314509l, TravelType.CAR, false);
    Route r2a = computeRoute(432627420l, 1209314509l, TravelType.FOOT, true);
    checkRoute(r2a, 48296.87180577412, 432627420l, 1209314509l);
    Route r3a = computeRoute(432627420l, 1209314509l, TravelType.ANY, true);
    checkRoute(r3a, 48044.391514856725, 432627420l, 1209314509l);
}


@Test(timeout = 15000)
public void testSmallRouting11RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2369167727l, 2533989102l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2369167727l, 2533989102l, TravelType.BIKE, false);
    computeRoute(2369167727l, 2533989102l, TravelType.CAR, false);
    computeRoute(2369167727l, 2533989102l, TravelType.FOOT, false);
    Route r3a = computeRoute(2369167727l, 2533989102l, TravelType.ANY, true);
    checkRoute(r3a, 26872.493384011555, 2369167727l, 2533989102l);
}


@Test(timeout = 15000)
public void testSmallRouting12RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2395977060l, 345716573l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2395977060l, 345716573l, TravelType.BIKE, true);
    checkRoute(r0a, 57301.68398268704, 2395977060l, 345716573l);
    computeRoute(2395977060l, 345716573l, TravelType.CAR, false);
    Route r2a = computeRoute(2395977060l, 345716573l, TravelType.FOOT, true);
    checkRoute(r2a, 55449.45197063302, 2395977060l, 345716573l);
    Route r3a = computeRoute(2395977060l, 345716573l, TravelType.ANY, true);
    checkRoute(r3a, 55449.45197063302, 2395977060l, 345716573l);
}


@Test(timeout = 15000)
public void testSmallRouting13RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2962602034l, 759526238l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2962602034l, 759526238l, TravelType.BIKE, true);
    checkRoute(r0a, 36525.93320572931, 2962602034l, 759526238l);
    Route r1a = computeRoute(2962602034l, 759526238l, TravelType.CAR, true);
    checkRoute(r1a, 37495.915750150474, 2962602034l, 759526238l);
    Route r2a = computeRoute(2962602034l, 759526238l, TravelType.FOOT, true);
    checkRoute(r2a, 36156.082977954604, 2962602034l, 759526238l);
    Route r3a = computeRoute(2962602034l, 759526238l, TravelType.ANY, true);
    checkRoute(r3a, 36156.082977954604, 2962602034l, 759526238l);
}


@Test(timeout = 15000)
public void testSmallRouting14RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 354603360l, 506294623l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(354603360l, 506294623l, TravelType.BIKE, true);
    checkRoute(r0a, 56994.49376899875, 354603360l, 506294623l);
    computeRoute(354603360l, 506294623l, TravelType.CAR, false);
    Route r2a = computeRoute(354603360l, 506294623l, TravelType.FOOT, true);
    checkRoute(r2a, 54920.88696250068, 354603360l, 506294623l);
    Route r3a = computeRoute(354603360l, 506294623l, TravelType.ANY, true);
    checkRoute(r3a, 54780.413656137796, 354603360l, 506294623l);
}


@Test(timeout = 15000)
public void testSmallRouting15RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 313201120l, 270110241l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(313201120l, 270110241l, TravelType.BIKE, true);
    checkRoute(r0a, 53550.64387155493, 313201120l, 270110241l);
    Route r1a = computeRoute(313201120l, 270110241l, TravelType.CAR, true);
    checkRoute(r1a, 54655.921573417836, 313201120l, 270110241l);
    Route r2a = computeRoute(313201120l, 270110241l, TravelType.FOOT, true);
    checkRoute(r2a, 53119.60737049546, 313201120l, 270110241l);
    Route r3a = computeRoute(313201120l, 270110241l, TravelType.ANY, true);
    checkRoute(r3a, 53106.72225341801, 313201120l, 270110241l);
}


@Test(timeout = 15000)
public void testSmallRouting16RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 104578762l, 461846711l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(104578762l, 461846711l, TravelType.BIKE, true);
    checkRoute(r0a, 55560.59066448303, 104578762l, 461846711l);
    Route r1a = computeRoute(104578762l, 461846711l, TravelType.CAR, true);
    checkRoute(r1a, 56414.016932534134, 104578762l, 461846711l);
    Route r2a = computeRoute(104578762l, 461846711l, TravelType.FOOT, true);
    checkRoute(r2a, 54298.705303690615, 104578762l, 461846711l);
    Route r3a = computeRoute(104578762l, 461846711l, TravelType.ANY, true);
    checkRoute(r3a, 54254.191759063, 104578762l, 461846711l);
}


@Test(timeout = 15000)
public void testSmallRouting17RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 648369055l, 1219490209l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(648369055l, 1219490209l, TravelType.BIKE, false);
    computeRoute(648369055l, 1219490209l, TravelType.CAR, false);
    Route r2a = computeRoute(648369055l, 1219490209l, TravelType.FOOT, true);
    checkRoute(r2a, 16746.233102543516, 648369055l, 1219490209l);
    Route r3a = computeRoute(648369055l, 1219490209l, TravelType.ANY, true);
    checkRoute(r3a, 16745.771197543952, 648369055l, 1219490209l);
}


@Test(timeout = 15000)
public void testSmallRouting18RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 431242599l, 2420026770l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(431242599l, 2420026770l, TravelType.BIKE, true);
    checkRoute(r0a, 21759.035701714172, 431242599l, 2420026770l);
    computeRoute(431242599l, 2420026770l, TravelType.CAR, false);
    Route r2a = computeRoute(431242599l, 2420026770l, TravelType.FOOT, true);
    checkRoute(r2a, 21243.62825455904, 431242599l, 2420026770l);
    Route r3a = computeRoute(431242599l, 2420026770l, TravelType.ANY, true);
    checkRoute(r3a, 21235.685663067077, 431242599l, 2420026770l);
}


@Test(timeout = 15000)
public void testSmallRouting19RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1536561771l, 1992457392l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1536561771l, 1992457392l, TravelType.BIKE, true);
    checkRoute(r0a, 46651.83550348317, 1536561771l, 1992457392l);
    computeRoute(1536561771l, 1992457392l, TravelType.CAR, false);
    Route r2a = computeRoute(1536561771l, 1992457392l, TravelType.FOOT, true);
    checkRoute(r2a, 45071.72740628331, 1536561771l, 1992457392l);
    Route r3a = computeRoute(1536561771l, 1992457392l, TravelType.ANY, true);
    checkRoute(r3a, 45071.72740628331, 1536561771l, 1992457392l);
}


@Test(timeout = 15000)
public void testSmallRouting20RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 765816274l, 291310120l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(765816274l, 291310120l, TravelType.BIKE, true);
    checkRoute(r0a, 51572.17835925716, 765816274l, 291310120l);
    computeRoute(765816274l, 291310120l, TravelType.CAR, false);
    computeRoute(765816274l, 291310120l, TravelType.FOOT, false);
    Route r3a = computeRoute(765816274l, 291310120l, TravelType.ANY, true);
    checkRoute(r3a, 50632.20355680801, 765816274l, 291310120l);
}


@Test(timeout = 15000)
public void testSmallRouting21RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 339452973l, 104573494l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(339452973l, 104573494l, TravelType.BIKE, true);
    checkRoute(r0a, 32851.826310794844, 339452973l, 104573494l);
    computeRoute(339452973l, 104573494l, TravelType.CAR, false);
    Route r2a = computeRoute(339452973l, 104573494l, TravelType.FOOT, true);
    checkRoute(r2a, 32003.759177693562, 339452973l, 104573494l);
    Route r3a = computeRoute(339452973l, 104573494l, TravelType.ANY, true);
    checkRoute(r3a, 31718.04796424266, 339452973l, 104573494l);
}


@Test(timeout = 15000)
public void testSmallRouting22RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 271045378l, 2409210584l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(271045378l, 2409210584l, TravelType.BIKE, true);
    checkRoute(r0a, 53711.72669180624, 271045378l, 2409210584l);
    computeRoute(271045378l, 2409210584l, TravelType.CAR, false);
    Route r2a = computeRoute(271045378l, 2409210584l, TravelType.FOOT, true);
    checkRoute(r2a, 53694.67356572089, 271045378l, 2409210584l);
    Route r3a = computeRoute(271045378l, 2409210584l, TravelType.ANY, true);
    checkRoute(r3a, 52877.59444364924, 271045378l, 2409210584l);
}


@Test(timeout = 15000)
public void testSmallRouting23RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1293191134l, 3045060706l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1293191134l, 3045060706l, TravelType.BIKE, true);
    checkRoute(r0a, 58406.45419560016, 1293191134l, 3045060706l);
    computeRoute(1293191134l, 3045060706l, TravelType.CAR, false);
    Route r2a = computeRoute(1293191134l, 3045060706l, TravelType.FOOT, true);
    checkRoute(r2a, 57504.047807891024, 1293191134l, 3045060706l);
    Route r3a = computeRoute(1293191134l, 3045060706l, TravelType.ANY, true);
    checkRoute(r3a, 57504.047807891024, 1293191134l, 3045060706l);
}


@Test(timeout = 15000)
public void testSmallRouting24RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 300902782l, 278943009l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(300902782l, 278943009l, TravelType.BIKE, true);
    checkRoute(r0a, 15807.448480254761, 300902782l, 278943009l);
    Route r1a = computeRoute(300902782l, 278943009l, TravelType.CAR, true);
    checkRoute(r1a, 16225.141475350976, 300902782l, 278943009l);
    Route r2a = computeRoute(300902782l, 278943009l, TravelType.FOOT, true);
    checkRoute(r2a, 15467.350055603883, 300902782l, 278943009l);
    Route r3a = computeRoute(300902782l, 278943009l, TravelType.ANY, true);
    checkRoute(r3a, 15467.350055603883, 300902782l, 278943009l);
}


@Test(timeout = 15000)
public void testSmallRouting25RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2120504038l, 405103150l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2120504038l, 405103150l, TravelType.BIKE, false);
    computeRoute(2120504038l, 405103150l, TravelType.CAR, false);
    computeRoute(2120504038l, 405103150l, TravelType.FOOT, false);
    Route r3a = computeRoute(2120504038l, 405103150l, TravelType.ANY, true);
    checkRoute(r3a, 13981.561456743453, 2120504038l, 405103150l);
}


@Test(timeout = 15000)
public void testSmallRouting26RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1237269534l, 301814952l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1237269534l, 301814952l, TravelType.BIKE, false);
    computeRoute(1237269534l, 301814952l, TravelType.CAR, false);
    Route r2a = computeRoute(1237269534l, 301814952l, TravelType.FOOT, true);
    checkRoute(r2a, 17177.332019630172, 1237269534l, 301814952l);
    Route r3a = computeRoute(1237269534l, 301814952l, TravelType.ANY, true);
    checkRoute(r3a, 17177.332019630172, 1237269534l, 301814952l);
}


@Test(timeout = 15000)
public void testSmallRouting27RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 845054039l, 2301183203l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(845054039l, 2301183203l, TravelType.BIKE, true);
    checkRoute(r0a, 52115.72366288638, 845054039l, 2301183203l);
    computeRoute(845054039l, 2301183203l, TravelType.CAR, false);
    Route r2a = computeRoute(845054039l, 2301183203l, TravelType.FOOT, true);
    checkRoute(r2a, 52021.29046026996, 845054039l, 2301183203l);
    Route r3a = computeRoute(845054039l, 2301183203l, TravelType.ANY, true);
    checkRoute(r3a, 51155.74268769794, 845054039l, 2301183203l);
}


@Test(timeout = 15000)
public void testSmallRouting28RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 873992176l, 419922102l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(873992176l, 419922102l, TravelType.BIKE, true);
    checkRoute(r0a, 28532.291964473923, 873992176l, 419922102l);
    computeRoute(873992176l, 419922102l, TravelType.CAR, false);
    Route r2a = computeRoute(873992176l, 419922102l, TravelType.FOOT, true);
    checkRoute(r2a, 28257.226151736926, 873992176l, 419922102l);
    Route r3a = computeRoute(873992176l, 419922102l, TravelType.ANY, true);
    checkRoute(r3a, 28026.515484858137, 873992176l, 419922102l);
}


@Test(timeout = 15000)
public void testSmallRouting29RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2701745817l, 2452231593l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2701745817l, 2452231593l, TravelType.BIKE, false);
    computeRoute(2701745817l, 2452231593l, TravelType.CAR, false);
    Route r2a = computeRoute(2701745817l, 2452231593l, TravelType.FOOT, true);
    checkRoute(r2a, 64242.53113993544, 2701745817l, 2452231593l);
    Route r3a = computeRoute(2701745817l, 2452231593l, TravelType.ANY, true);
    checkRoute(r3a, 64229.64602285799, 2701745817l, 2452231593l);
}


@Test(timeout = 15000)
public void testSmallRouting30RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 745740203l, 571804698l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(745740203l, 571804698l, TravelType.BIKE, false);
    computeRoute(745740203l, 571804698l, TravelType.CAR, false);
    Route r2a = computeRoute(745740203l, 571804698l, TravelType.FOOT, true);
    checkRoute(r2a, 22256.900400673036, 745740203l, 571804698l);
    Route r3a = computeRoute(745740203l, 571804698l, TravelType.ANY, true);
    checkRoute(r3a, 22047.891231743874, 745740203l, 571804698l);
}


@Test(timeout = 15000)
public void testSmallRouting31RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2096723198l, 1547328882l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2096723198l, 1547328882l, TravelType.BIKE, true);
    checkRoute(r0a, 26973.38852524316, 2096723198l, 1547328882l);
    Route r1a = computeRoute(2096723198l, 1547328882l, TravelType.CAR, true);
    checkRoute(r1a, 27208.3613054686, 2096723198l, 1547328882l);
    Route r2a = computeRoute(2096723198l, 1547328882l, TravelType.FOOT, true);
    checkRoute(r2a, 26782.008644579484, 2096723198l, 1547328882l);
    Route r3a = computeRoute(2096723198l, 1547328882l, TravelType.ANY, true);
    checkRoute(r3a, 26782.008644579484, 2096723198l, 1547328882l);
}


@Test(timeout = 15000)
public void testSmallRouting32RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 524153716l, 2162383637l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(524153716l, 2162383637l, TravelType.BIKE, false);
    computeRoute(524153716l, 2162383637l, TravelType.CAR, false);
    Route r2a = computeRoute(524153716l, 2162383637l, TravelType.FOOT, true);
    checkRoute(r2a, 41791.694333667445, 524153716l, 2162383637l);
    Route r3a = computeRoute(524153716l, 2162383637l, TravelType.ANY, true);
    checkRoute(r3a, 41771.76762835313, 524153716l, 2162383637l);
}


@Test(timeout = 15000)
public void testSmallRouting33RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 849006095l, 283165669l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(849006095l, 283165669l, TravelType.BIKE, true);
    checkRoute(r0a, 39683.723677894755, 849006095l, 283165669l);
    computeRoute(849006095l, 283165669l, TravelType.CAR, false);
    Route r2a = computeRoute(849006095l, 283165669l, TravelType.FOOT, true);
    checkRoute(r2a, 39203.38091432856, 849006095l, 283165669l);
    Route r3a = computeRoute(849006095l, 283165669l, TravelType.ANY, true);
    checkRoute(r3a, 39163.102081102596, 849006095l, 283165669l);
}


@Test(timeout = 15000)
public void testSmallRouting34RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 311767138l, 3449099723l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(311767138l, 3449099723l, TravelType.BIKE, false);
    computeRoute(311767138l, 3449099723l, TravelType.CAR, false);
    Route r2a = computeRoute(311767138l, 3449099723l, TravelType.FOOT, true);
    checkRoute(r2a, 56592.03361702786, 311767138l, 3449099723l);
    Route r3a = computeRoute(311767138l, 3449099723l, TravelType.ANY, true);
    checkRoute(r3a, 56578.69003522239, 311767138l, 3449099723l);
}


@Test(timeout = 15000)
public void testSmallRouting35RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2290627039l, 2140536775l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2290627039l, 2140536775l, TravelType.BIKE, false);
    computeRoute(2290627039l, 2140536775l, TravelType.CAR, false);
    Route r2a = computeRoute(2290627039l, 2140536775l, TravelType.FOOT, true);
    checkRoute(r2a, 32036.700684555635, 2290627039l, 2140536775l);
    Route r3a = computeRoute(2290627039l, 2140536775l, TravelType.ANY, true);
    checkRoute(r3a, 32036.700684555635, 2290627039l, 2140536775l);
}


@Test(timeout = 15000)
public void testSmallRouting36RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 502542992l, 178903435l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(502542992l, 178903435l, TravelType.BIKE, true);
    checkRoute(r0a, 51414.47584078942, 502542992l, 178903435l);
    computeRoute(502542992l, 178903435l, TravelType.CAR, false);
    Route r2a = computeRoute(502542992l, 178903435l, TravelType.FOOT, true);
    checkRoute(r2a, 50621.16560629286, 502542992l, 178903435l);
    Route r3a = computeRoute(502542992l, 178903435l, TravelType.ANY, true);
    checkRoute(r3a, 50212.71130300621, 502542992l, 178903435l);
}


@Test(timeout = 15000)
public void testSmallRouting37RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 264121627l, 1616133271l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(264121627l, 1616133271l, TravelType.BIKE, false);
    computeRoute(264121627l, 1616133271l, TravelType.CAR, false);
    Route r2a = computeRoute(264121627l, 1616133271l, TravelType.FOOT, true);
    checkRoute(r2a, 23556.23726320432, 264121627l, 1616133271l);
    Route r3a = computeRoute(264121627l, 1616133271l, TravelType.ANY, true);
    checkRoute(r3a, 23362.089030821062, 264121627l, 1616133271l);
}


@Test(timeout = 15000)
public void testSmallRouting38RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3124029180l, 173974744l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(3124029180l, 173974744l, TravelType.BIKE, true);
    checkRoute(r0a, 52391.82249424373, 3124029180l, 173974744l);
    computeRoute(3124029180l, 173974744l, TravelType.CAR, false);
    Route r2a = computeRoute(3124029180l, 173974744l, TravelType.FOOT, true);
    checkRoute(r2a, 51649.401534327684, 3124029180l, 173974744l);
    Route r3a = computeRoute(3124029180l, 173974744l, TravelType.ANY, true);
    checkRoute(r3a, 51446.26577394381, 3124029180l, 173974744l);
}


@Test(timeout = 15000)
public void testSmallRouting39RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1520343477l, 448915742l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1520343477l, 448915742l, TravelType.BIKE, false);
    computeRoute(1520343477l, 448915742l, TravelType.CAR, false);
    computeRoute(1520343477l, 448915742l, TravelType.FOOT, false);
    Route r3a = computeRoute(1520343477l, 448915742l, TravelType.ANY, true);
    checkRoute(r3a, 27687.97043791042, 1520343477l, 448915742l);
}


@Test(timeout = 15000)
public void testSmallRouting40RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2275837226l, 685514095l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2275837226l, 685514095l, TravelType.BIKE, false);
    computeRoute(2275837226l, 685514095l, TravelType.CAR, false);
    Route r2a = computeRoute(2275837226l, 685514095l, TravelType.FOOT, true);
    checkRoute(r2a, 53769.757478656094, 2275837226l, 685514095l);
    Route r3a = computeRoute(2275837226l, 685514095l, TravelType.ANY, true);
    checkRoute(r3a, 53675.0402297853, 2275837226l, 685514095l);
}


@Test(timeout = 15000)
public void testSmallRouting41RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 269108160l, 1900683618l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(269108160l, 1900683618l, TravelType.BIKE, false);
    computeRoute(269108160l, 1900683618l, TravelType.CAR, false);
    computeRoute(269108160l, 1900683618l, TravelType.FOOT, false);
    Route r3a = computeRoute(269108160l, 1900683618l, TravelType.ANY, true);
    checkRoute(r3a, 30445.732308881197, 269108160l, 1900683618l);
}


@Test(timeout = 15000)
public void testSmallRouting42RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 307399533l, 259494855l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(307399533l, 259494855l, TravelType.BIKE, true);
    checkRoute(r0a, 34315.04925281083, 307399533l, 259494855l);
    computeRoute(307399533l, 259494855l, TravelType.CAR, false);
    Route r2a = computeRoute(307399533l, 259494855l, TravelType.FOOT, true);
    checkRoute(r2a, 33576.29057815555, 307399533l, 259494855l);
    Route r3a = computeRoute(307399533l, 259494855l, TravelType.ANY, true);
    checkRoute(r3a, 33520.35458209287, 307399533l, 259494855l);
}


@Test(timeout = 15000)
public void testSmallRouting43RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2144829811l, 1519388845l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2144829811l, 1519388845l, TravelType.BIKE, false);
    computeRoute(2144829811l, 1519388845l, TravelType.CAR, false);
    computeRoute(2144829811l, 1519388845l, TravelType.FOOT, false);
    Route r3a = computeRoute(2144829811l, 1519388845l, TravelType.ANY, true);
    checkRoute(r3a, 20631.02843165085, 2144829811l, 1519388845l);
}


@Test(timeout = 15000)
public void testSmallRouting44RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 447362900l, 330159129l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(447362900l, 330159129l, TravelType.BIKE, true);
    checkRoute(r0a, 53687.014953957936, 447362900l, 330159129l);
    computeRoute(447362900l, 330159129l, TravelType.CAR, false);
    Route r2a = computeRoute(447362900l, 330159129l, TravelType.FOOT, true);
    checkRoute(r2a, 52937.11343816553, 447362900l, 330159129l);
    Route r3a = computeRoute(447362900l, 330159129l, TravelType.ANY, true);
    checkRoute(r3a, 52924.22832108808, 447362900l, 330159129l);
}


@Test(timeout = 15000)
public void testSmallRouting45RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 457410131l, 2322145984l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(457410131l, 2322145984l, TravelType.BIKE, true);
    checkRoute(r0a, 38690.490651816195, 457410131l, 2322145984l);
    computeRoute(457410131l, 2322145984l, TravelType.CAR, false);
    Route r2a = computeRoute(457410131l, 2322145984l, TravelType.FOOT, true);
    checkRoute(r2a, 38160.30504830673, 457410131l, 2322145984l);
    Route r3a = computeRoute(457410131l, 2322145984l, TravelType.ANY, true);
    checkRoute(r3a, 38160.30504830673, 457410131l, 2322145984l);
}


@Test(timeout = 15000)
public void testSmallRouting46RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 429503719l, 972881479l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(429503719l, 972881479l, TravelType.BIKE, true);
    checkRoute(r0a, 15788.368287344269, 429503719l, 972881479l);
    computeRoute(429503719l, 972881479l, TravelType.CAR, false);
    Route r2a = computeRoute(429503719l, 972881479l, TravelType.FOOT, true);
    checkRoute(r2a, 15084.652544365586, 429503719l, 972881479l);
    Route r3a = computeRoute(429503719l, 972881479l, TravelType.ANY, true);
    checkRoute(r3a, 15084.652544365586, 429503719l, 972881479l);
}


@Test(timeout = 15000)
public void testSmallRouting47RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 319443832l, 672706542l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(319443832l, 672706542l, TravelType.BIKE, false);
    computeRoute(319443832l, 672706542l, TravelType.CAR, false);
    Route r2a = computeRoute(319443832l, 672706542l, TravelType.FOOT, true);
    checkRoute(r2a, 53582.369163755124, 319443832l, 672706542l);
    Route r3a = computeRoute(319443832l, 672706542l, TravelType.ANY, true);
    checkRoute(r3a, 53286.3247235625, 319443832l, 672706542l);
}


@Test(timeout = 15000)
public void testSmallRouting48RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 267396076l, 1612244829l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(267396076l, 1612244829l, TravelType.BIKE, false);
    computeRoute(267396076l, 1612244829l, TravelType.CAR, false);
    Route r2a = computeRoute(267396076l, 1612244829l, TravelType.FOOT, true);
    checkRoute(r2a, 20287.049261140688, 267396076l, 1612244829l);
    Route r3a = computeRoute(267396076l, 1612244829l, TravelType.ANY, true);
    checkRoute(r3a, 20287.049261140688, 267396076l, 1612244829l);
}


@Test(timeout = 15000)
public void testSmallRouting49RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 429562588l, 514263024l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(429562588l, 514263024l, TravelType.BIKE, true);
    checkRoute(r0a, 8897.995494956367, 429562588l, 514263024l);
    computeRoute(429562588l, 514263024l, TravelType.CAR, false);
    Route r2a = computeRoute(429562588l, 514263024l, TravelType.FOOT, true);
    checkRoute(r2a, 7918.616406756009, 429562588l, 514263024l);
    Route r3a = computeRoute(429562588l, 514263024l, TravelType.ANY, true);
    checkRoute(r3a, 7918.616406756009, 429562588l, 514263024l);
}


@Test(timeout = 15000)
public void testSmallRouting50RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 273103708l, 374535590l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(273103708l, 374535590l, TravelType.BIKE, false);
    computeRoute(273103708l, 374535590l, TravelType.CAR, false);
    computeRoute(273103708l, 374535590l, TravelType.FOOT, false);
    Route r3a = computeRoute(273103708l, 374535590l, TravelType.ANY, true);
    checkRoute(r3a, 8782.18853522356, 273103708l, 374535590l);
}


@Test(timeout = 15000)
public void testSmallRouting51RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1534030583l, 731504032l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1534030583l, 731504032l, TravelType.BIKE, true);
    checkRoute(r0a, 33410.85607699848, 1534030583l, 731504032l);
    computeRoute(1534030583l, 731504032l, TravelType.CAR, false);
    Route r2a = computeRoute(1534030583l, 731504032l, TravelType.FOOT, true);
    checkRoute(r2a, 32992.466668415465, 1534030583l, 731504032l);
    Route r3a = computeRoute(1534030583l, 731504032l, TravelType.ANY, true);
    checkRoute(r3a, 32992.466668415465, 1534030583l, 731504032l);
}


@Test(timeout = 15000)
public void testSmallRouting52RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1347615834l, 1580771862l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1347615834l, 1580771862l, TravelType.BIKE, false);
    computeRoute(1347615834l, 1580771862l, TravelType.CAR, false);
    Route r2a = computeRoute(1347615834l, 1580771862l, TravelType.FOOT, true);
    checkRoute(r2a, 32252.368815932303, 1347615834l, 1580771862l);
    Route r3a = computeRoute(1347615834l, 1580771862l, TravelType.ANY, true);
    checkRoute(r3a, 31874.934014383132, 1347615834l, 1580771862l);
}


@Test(timeout = 15000)
public void testSmallRouting53RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 335933813l, 492880125l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(335933813l, 492880125l, TravelType.BIKE, true);
    checkRoute(r0a, 26151.571902563464, 335933813l, 492880125l);
    computeRoute(335933813l, 492880125l, TravelType.CAR, false);
    Route r2a = computeRoute(335933813l, 492880125l, TravelType.FOOT, true);
    checkRoute(r2a, 24572.240434722346, 335933813l, 492880125l);
    Route r3a = computeRoute(335933813l, 492880125l, TravelType.ANY, true);
    checkRoute(r3a, 24572.240434722346, 335933813l, 492880125l);
}


@Test(timeout = 15000)
public void testSmallRouting54RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 371088741l, 59923472l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(371088741l, 59923472l, TravelType.BIKE, true);
    checkRoute(r0a, 5321.927031987118, 371088741l, 59923472l);
    computeRoute(371088741l, 59923472l, TravelType.CAR, false);
    Route r2a = computeRoute(371088741l, 59923472l, TravelType.FOOT, true);
    checkRoute(r2a, 5044.814512750976, 371088741l, 59923472l);
    Route r3a = computeRoute(371088741l, 59923472l, TravelType.ANY, true);
    checkRoute(r3a, 5044.814512750976, 371088741l, 59923472l);
}


@Test(timeout = 15000)
public void testSmallRouting55RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 676782817l, 269014379l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(676782817l, 269014379l, TravelType.BIKE, false);
    computeRoute(676782817l, 269014379l, TravelType.CAR, false);
    computeRoute(676782817l, 269014379l, TravelType.FOOT, false);
    Route r3a = computeRoute(676782817l, 269014379l, TravelType.ANY, true);
    checkRoute(r3a, 30216.132152247643, 676782817l, 269014379l);
}


@Test(timeout = 15000)
public void testSmallRouting56RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2237074827l, 1213025261l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2237074827l, 1213025261l, TravelType.BIKE, true);
    checkRoute(r0a, 23063.627736006172, 2237074827l, 1213025261l);
    computeRoute(2237074827l, 1213025261l, TravelType.CAR, false);
    Route r2a = computeRoute(2237074827l, 1213025261l, TravelType.FOOT, true);
    checkRoute(r2a, 21590.301842061213, 2237074827l, 1213025261l);
    Route r3a = computeRoute(2237074827l, 1213025261l, TravelType.ANY, true);
    checkRoute(r3a, 21590.301842061213, 2237074827l, 1213025261l);
}


@Test(timeout = 15000)
public void testSmallRouting57RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 446271965l, 338957814l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(446271965l, 338957814l, TravelType.BIKE, true);
    checkRoute(r0a, 33175.62437480302, 446271965l, 338957814l);
    computeRoute(446271965l, 338957814l, TravelType.CAR, false);
    Route r2a = computeRoute(446271965l, 338957814l, TravelType.FOOT, true);
    checkRoute(r2a, 32396.638627150198, 446271965l, 338957814l);
    Route r3a = computeRoute(446271965l, 338957814l, TravelType.ANY, true);
    checkRoute(r3a, 32396.638627150198, 446271965l, 338957814l);
}


@Test(timeout = 15000)
public void testSmallRouting58RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2432416187l, 312926915l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2432416187l, 312926915l, TravelType.BIKE, false);
    computeRoute(2432416187l, 312926915l, TravelType.CAR, false);
    Route r2a = computeRoute(2432416187l, 312926915l, TravelType.FOOT, true);
    checkRoute(r2a, 28955.08460301396, 2432416187l, 312926915l);
    Route r3a = computeRoute(2432416187l, 312926915l, TravelType.ANY, true);
    checkRoute(r3a, 28955.08460301396, 2432416187l, 312926915l);
}


@Test(timeout = 15000)
public void testSmallRouting59RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 363840198l, 279340212l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(363840198l, 279340212l, TravelType.BIKE, true);
    checkRoute(r0a, 30855.295385649173, 363840198l, 279340212l);
    computeRoute(363840198l, 279340212l, TravelType.CAR, false);
    Route r2a = computeRoute(363840198l, 279340212l, TravelType.FOOT, true);
    checkRoute(r2a, 30045.29310967702, 363840198l, 279340212l);
    Route r3a = computeRoute(363840198l, 279340212l, TravelType.ANY, true);
    checkRoute(r3a, 29701.890899830963, 363840198l, 279340212l);
}


@Test(timeout = 15000)
public void testSmallRouting60RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 252789322l, 266382312l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(252789322l, 266382312l, TravelType.BIKE, true);
    checkRoute(r0a, 54363.422261551525, 252789322l, 266382312l);
    computeRoute(252789322l, 266382312l, TravelType.CAR, false);
    Route r2a = computeRoute(252789322l, 266382312l, TravelType.FOOT, true);
    checkRoute(r2a, 53687.70128878091, 252789322l, 266382312l);
    Route r3a = computeRoute(252789322l, 266382312l, TravelType.ANY, true);
    checkRoute(r3a, 53683.633084367335, 252789322l, 266382312l);
}


@Test(timeout = 15000)
public void testSmallRouting61RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 419355104l, 678590248l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(419355104l, 678590248l, TravelType.BIKE, true);
    checkRoute(r0a, 20722.371847004506, 419355104l, 678590248l);
    Route r1a = computeRoute(419355104l, 678590248l, TravelType.CAR, true);
    checkRoute(r1a, 21460.270341534393, 419355104l, 678590248l);
    Route r2a = computeRoute(419355104l, 678590248l, TravelType.FOOT, true);
    checkRoute(r2a, 20585.752287540992, 419355104l, 678590248l);
    Route r3a = computeRoute(419355104l, 678590248l, TravelType.ANY, true);
    checkRoute(r3a, 20577.337339293736, 419355104l, 678590248l);
}


@Test(timeout = 15000)
public void testSmallRouting62RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1722219709l, 826182524l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1722219709l, 826182524l, TravelType.BIKE, true);
    checkRoute(r0a, 58517.42500456824, 1722219709l, 826182524l);
    computeRoute(1722219709l, 826182524l, TravelType.CAR, false);
    Route r2a = computeRoute(1722219709l, 826182524l, TravelType.FOOT, true);
    checkRoute(r2a, 56734.864490211425, 1722219709l, 826182524l);
    Route r3a = computeRoute(1722219709l, 826182524l, TravelType.ANY, true);
    checkRoute(r3a, 56619.05634113656, 1722219709l, 826182524l);
}


@Test(timeout = 15000)
public void testSmallRouting63RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 291588043l, 893294102l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(291588043l, 893294102l, TravelType.BIKE, true);
    checkRoute(r0a, 53570.39871798094, 291588043l, 893294102l);
    computeRoute(291588043l, 893294102l, TravelType.CAR, false);
    Route r2a = computeRoute(291588043l, 893294102l, TravelType.FOOT, true);
    checkRoute(r2a, 52088.31165846589, 291588043l, 893294102l);
    Route r3a = computeRoute(291588043l, 893294102l, TravelType.ANY, true);
    checkRoute(r3a, 52075.426541388435, 291588043l, 893294102l);
}


@Test(timeout = 15000)
public void testSmallRouting64RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 800699844l, 1315142832l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(800699844l, 1315142832l, TravelType.BIKE, true);
    checkRoute(r0a, 14731.63786656536, 800699844l, 1315142832l);
    computeRoute(800699844l, 1315142832l, TravelType.CAR, false);
    Route r2a = computeRoute(800699844l, 1315142832l, TravelType.FOOT, true);
    checkRoute(r2a, 14710.143285707147, 800699844l, 1315142832l);
    Route r3a = computeRoute(800699844l, 1315142832l, TravelType.ANY, true);
    checkRoute(r3a, 14710.143285707147, 800699844l, 1315142832l);
}


@Test(timeout = 15000)
public void testSmallRouting65RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1340026410l, 2358878305l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1340026410l, 2358878305l, TravelType.BIKE, false);
    computeRoute(1340026410l, 2358878305l, TravelType.CAR, false);
    Route r2a = computeRoute(1340026410l, 2358878305l, TravelType.FOOT, true);
    checkRoute(r2a, 37291.118397846294, 1340026410l, 2358878305l);
    Route r3a = computeRoute(1340026410l, 2358878305l, TravelType.ANY, true);
    checkRoute(r3a, 37291.118397846294, 1340026410l, 2358878305l);
}


@Test(timeout = 15000)
public void testSmallRouting66RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1842443939l, 1492542302l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1842443939l, 1492542302l, TravelType.BIKE, true);
    checkRoute(r0a, 12238.112874583863, 1842443939l, 1492542302l);
    computeRoute(1842443939l, 1492542302l, TravelType.CAR, false);
    Route r2a = computeRoute(1842443939l, 1492542302l, TravelType.FOOT, true);
    checkRoute(r2a, 11861.759543744382, 1842443939l, 1492542302l);
    Route r3a = computeRoute(1842443939l, 1492542302l, TravelType.ANY, true);
    checkRoute(r3a, 11768.601907043287, 1842443939l, 1492542302l);
}


@Test(timeout = 15000)
public void testSmallRouting67RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2300458437l, 318772519l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2300458437l, 318772519l, TravelType.BIKE, true);
    checkRoute(r0a, 15837.246021739782, 2300458437l, 318772519l);
    computeRoute(2300458437l, 318772519l, TravelType.CAR, false);
    Route r2a = computeRoute(2300458437l, 318772519l, TravelType.FOOT, true);
    checkRoute(r2a, 15387.898825941556, 2300458437l, 318772519l);
    Route r3a = computeRoute(2300458437l, 318772519l, TravelType.ANY, true);
    checkRoute(r3a, 15221.081887105607, 2300458437l, 318772519l);
}


@Test(timeout = 15000)
public void testSmallRouting68RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 268126624l, 957328628l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(268126624l, 957328628l, TravelType.BIKE, true);
    checkRoute(r0a, 17575.07670864566, 268126624l, 957328628l);
    computeRoute(268126624l, 957328628l, TravelType.CAR, false);
    Route r2a = computeRoute(268126624l, 957328628l, TravelType.FOOT, true);
    checkRoute(r2a, 17374.0224941785, 268126624l, 957328628l);
    Route r3a = computeRoute(268126624l, 957328628l, TravelType.ANY, true);
    checkRoute(r3a, 17374.0224941785, 268126624l, 957328628l);
}


@Test(timeout = 15000)
public void testSmallRouting69RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 442608457l, 676682999l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(442608457l, 676682999l, TravelType.BIKE, true);
    checkRoute(r0a, 36144.27791931238, 442608457l, 676682999l);
    computeRoute(442608457l, 676682999l, TravelType.CAR, false);
    Route r2a = computeRoute(442608457l, 676682999l, TravelType.FOOT, true);
    checkRoute(r2a, 35086.53565812363, 442608457l, 676682999l);
    Route r3a = computeRoute(442608457l, 676682999l, TravelType.ANY, true);
    checkRoute(r3a, 34979.4190082558, 442608457l, 676682999l);
}


@Test(timeout = 15000)
public void testSmallRouting70RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 939955556l, 427963268l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(939955556l, 427963268l, TravelType.BIKE, false);
    computeRoute(939955556l, 427963268l, TravelType.CAR, false);
    computeRoute(939955556l, 427963268l, TravelType.FOOT, false);
    Route r3a = computeRoute(939955556l, 427963268l, TravelType.ANY, true);
    checkRoute(r3a, 23571.406205809326, 939955556l, 427963268l);
}


@Test(timeout = 15000)
public void testSmallRouting71RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 408359874l, 1267045137l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(408359874l, 1267045137l, TravelType.BIKE, false);
    computeRoute(408359874l, 1267045137l, TravelType.CAR, false);
    Route r2a = computeRoute(408359874l, 1267045137l, TravelType.FOOT, true);
    checkRoute(r2a, 29382.13671863083, 408359874l, 1267045137l);
    Route r3a = computeRoute(408359874l, 1267045137l, TravelType.ANY, true);
    checkRoute(r3a, 29382.13671863083, 408359874l, 1267045137l);
}


@Test(timeout = 15000)
public void testSmallRouting72RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 483007459l, 434404157l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(483007459l, 434404157l, TravelType.BIKE, false);
    computeRoute(483007459l, 434404157l, TravelType.CAR, false);
    Route r2a = computeRoute(483007459l, 434404157l, TravelType.FOOT, true);
    checkRoute(r2a, 28673.356603843014, 483007459l, 434404157l);
    Route r3a = computeRoute(483007459l, 434404157l, TravelType.ANY, true);
    checkRoute(r3a, 28673.356603843014, 483007459l, 434404157l);
}


@Test(timeout = 15000)
public void testSmallRouting73RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 504553448l, 1752495625l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(504553448l, 1752495625l, TravelType.BIKE, false);
    computeRoute(504553448l, 1752495625l, TravelType.CAR, false);
    Route r2a = computeRoute(504553448l, 1752495625l, TravelType.FOOT, true);
    checkRoute(r2a, 65782.93115475401, 504553448l, 1752495625l);
    Route r3a = computeRoute(504553448l, 1752495625l, TravelType.ANY, true);
    checkRoute(r3a, 65716.79667336181, 504553448l, 1752495625l);
}


@Test(timeout = 15000)
public void testSmallRouting74RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 674247267l, 1393877504l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(674247267l, 1393877504l, TravelType.BIKE, false);
    computeRoute(674247267l, 1393877504l, TravelType.CAR, false);
    Route r2a = computeRoute(674247267l, 1393877504l, TravelType.FOOT, true);
    checkRoute(r2a, 33404.151312189344, 674247267l, 1393877504l);
    Route r3a = computeRoute(674247267l, 1393877504l, TravelType.ANY, true);
    checkRoute(r3a, 33398.820395376104, 674247267l, 1393877504l);
}


@Test(timeout = 15000)
public void testSmallRouting75RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2450358063l, 601142788l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2450358063l, 601142788l, TravelType.BIKE, true);
    checkRoute(r0a, 12786.809264719372, 2450358063l, 601142788l);
    computeRoute(2450358063l, 601142788l, TravelType.CAR, false);
    Route r2a = computeRoute(2450358063l, 601142788l, TravelType.FOOT, true);
    checkRoute(r2a, 12379.294015803687, 2450358063l, 601142788l);
    Route r3a = computeRoute(2450358063l, 601142788l, TravelType.ANY, true);
    checkRoute(r3a, 11982.094144653907, 2450358063l, 601142788l);
}


@Test(timeout = 15000)
public void testSmallRouting76RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2192915978l, 2505260034l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2192915978l, 2505260034l, TravelType.BIKE, false);
    computeRoute(2192915978l, 2505260034l, TravelType.CAR, false);
    Route r2a = computeRoute(2192915978l, 2505260034l, TravelType.FOOT, true);
    checkRoute(r2a, 32702.15623620037, 2192915978l, 2505260034l);
    Route r3a = computeRoute(2192915978l, 2505260034l, TravelType.ANY, true);
    checkRoute(r3a, 32702.15623620037, 2192915978l, 2505260034l);
}


@Test(timeout = 15000)
public void testSmallRouting77RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2075831320l, 472295057l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2075831320l, 472295057l, TravelType.BIKE, false);
    computeRoute(2075831320l, 472295057l, TravelType.CAR, false);
    Route r2a = computeRoute(2075831320l, 472295057l, TravelType.FOOT, true);
    checkRoute(r2a, 35852.28133162131, 2075831320l, 472295057l);
    Route r3a = computeRoute(2075831320l, 472295057l, TravelType.ANY, true);
    checkRoute(r3a, 35852.28133162131, 2075831320l, 472295057l);
}


@Test(timeout = 15000)
public void testSmallRouting78RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 534760936l, 1170365007l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(534760936l, 1170365007l, TravelType.BIKE, true);
    checkRoute(r0a, 16817.964133808302, 534760936l, 1170365007l);
    computeRoute(534760936l, 1170365007l, TravelType.CAR, false);
    Route r2a = computeRoute(534760936l, 1170365007l, TravelType.FOOT, true);
    checkRoute(r2a, 16682.30492925401, 534760936l, 1170365007l);
    Route r3a = computeRoute(534760936l, 1170365007l, TravelType.ANY, true);
    checkRoute(r3a, 16682.30492925401, 534760936l, 1170365007l);
}


@Test(timeout = 15000)
public void testSmallRouting79RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 261753238l, 393417689l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(261753238l, 393417689l, TravelType.BIKE, true);
    checkRoute(r0a, 26243.068561915177, 261753238l, 393417689l);
    computeRoute(261753238l, 393417689l, TravelType.CAR, false);
    Route r2a = computeRoute(261753238l, 393417689l, TravelType.FOOT, true);
    checkRoute(r2a, 24919.62290486064, 261753238l, 393417689l);
    Route r3a = computeRoute(261753238l, 393417689l, TravelType.ANY, true);
    checkRoute(r3a, 24919.62290486064, 261753238l, 393417689l);
}


@Test(timeout = 15000)
public void testSmallRouting80RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 503580951l, 430831517l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(503580951l, 430831517l, TravelType.BIKE, true);
    checkRoute(r0a, 13892.257570302017, 503580951l, 430831517l);
    computeRoute(503580951l, 430831517l, TravelType.CAR, false);
    Route r2a = computeRoute(503580951l, 430831517l, TravelType.FOOT, true);
    checkRoute(r2a, 12538.655432185486, 503580951l, 430831517l);
    Route r3a = computeRoute(503580951l, 430831517l, TravelType.ANY, true);
    checkRoute(r3a, 12208.347587549846, 503580951l, 430831517l);
}


@Test(timeout = 15000)
public void testSmallRouting81RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 428766480l, 469127368l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(428766480l, 469127368l, TravelType.BIKE, true);
    checkRoute(r0a, 19293.514461316652, 428766480l, 469127368l);
    computeRoute(428766480l, 469127368l, TravelType.CAR, false);
    Route r2a = computeRoute(428766480l, 469127368l, TravelType.FOOT, true);
    checkRoute(r2a, 17624.998154413624, 428766480l, 469127368l);
    Route r3a = computeRoute(428766480l, 469127368l, TravelType.ANY, true);
    checkRoute(r3a, 17624.998154413624, 428766480l, 469127368l);
}


@Test(timeout = 15000)
public void testSmallRouting82RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2964197479l, 322824571l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2964197479l, 322824571l, TravelType.BIKE, true);
    checkRoute(r0a, 36542.79394411778, 2964197479l, 322824571l);
    Route r1a = computeRoute(2964197479l, 322824571l, TravelType.CAR, true);
    checkRoute(r1a, 38363.36542417699, 2964197479l, 322824571l);
    Route r2a = computeRoute(2964197479l, 322824571l, TravelType.FOOT, true);
    checkRoute(r2a, 36088.742849916416, 2964197479l, 322824571l);
    Route r3a = computeRoute(2964197479l, 322824571l, TravelType.ANY, true);
    checkRoute(r3a, 36088.742849916416, 2964197479l, 322824571l);
}


@Test(timeout = 15000)
public void testSmallRouting83RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 457131094l, 363225819l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(457131094l, 363225819l, TravelType.BIKE, true);
    checkRoute(r0a, 38907.99384375281, 457131094l, 363225819l);
    Route r1a = computeRoute(457131094l, 363225819l, TravelType.CAR, true);
    checkRoute(r1a, 39986.54463308592, 457131094l, 363225819l);
    Route r2a = computeRoute(457131094l, 363225819l, TravelType.FOOT, true);
    checkRoute(r2a, 38305.19171096773, 457131094l, 363225819l);
    Route r3a = computeRoute(457131094l, 363225819l, TravelType.ANY, true);
    checkRoute(r3a, 37746.47494845126, 457131094l, 363225819l);
}


@Test(timeout = 15000)
public void testSmallRouting84RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2203039756l, 2327475304l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2203039756l, 2327475304l, TravelType.BIKE, false);
    computeRoute(2203039756l, 2327475304l, TravelType.CAR, false);
    Route r2a = computeRoute(2203039756l, 2327475304l, TravelType.FOOT, true);
    checkRoute(r2a, 36520.4835917945, 2203039756l, 2327475304l);
    Route r3a = computeRoute(2203039756l, 2327475304l, TravelType.ANY, true);
    checkRoute(r3a, 36380.43454554237, 2203039756l, 2327475304l);
}


@Test(timeout = 15000)
public void testSmallRouting85RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 937154664l, 278065491l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(937154664l, 278065491l, TravelType.BIKE, true);
    checkRoute(r0a, 46667.20492200245, 937154664l, 278065491l);
    Route r1a = computeRoute(937154664l, 278065491l, TravelType.CAR, true);
    checkRoute(r1a, 47475.13154145272, 937154664l, 278065491l);
    Route r2a = computeRoute(937154664l, 278065491l, TravelType.FOOT, true);
    checkRoute(r2a, 45275.48791757944, 937154664l, 278065491l);
    Route r3a = computeRoute(937154664l, 278065491l, TravelType.ANY, true);
    checkRoute(r3a, 45177.879639505845, 937154664l, 278065491l);
}


@Test(timeout = 15000)
public void testSmallRouting86RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1364815751l, 335322439l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1364815751l, 335322439l, TravelType.BIKE, true);
    checkRoute(r0a, 11104.617625665313, 1364815751l, 335322439l);
    computeRoute(1364815751l, 335322439l, TravelType.CAR, false);
    Route r2a = computeRoute(1364815751l, 335322439l, TravelType.FOOT, true);
    checkRoute(r2a, 10994.870700377109, 1364815751l, 335322439l);
    Route r3a = computeRoute(1364815751l, 335322439l, TravelType.ANY, true);
    checkRoute(r3a, 10994.870700377109, 1364815751l, 335322439l);
}


@Test(timeout = 15000)
public void testSmallRouting87RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1831377652l, 108008426l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1831377652l, 108008426l, TravelType.BIKE, false);
    computeRoute(1831377652l, 108008426l, TravelType.CAR, false);
    computeRoute(1831377652l, 108008426l, TravelType.FOOT, false);
    Route r3a = computeRoute(1831377652l, 108008426l, TravelType.ANY, true);
    checkRoute(r3a, 68042.33617988498, 1831377652l, 108008426l);
}


@Test(timeout = 15000)
public void testSmallRouting88RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2146913818l, 446779511l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2146913818l, 446779511l, TravelType.BIKE, false);
    computeRoute(2146913818l, 446779511l, TravelType.CAR, false);
    Route r2a = computeRoute(2146913818l, 446779511l, TravelType.FOOT, true);
    checkRoute(r2a, 11244.663883981311, 2146913818l, 446779511l);
    Route r3a = computeRoute(2146913818l, 446779511l, TravelType.ANY, true);
    checkRoute(r3a, 11095.442653516515, 2146913818l, 446779511l);
}


@Test(timeout = 15000)
public void testSmallRouting89RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1756487497l, 448008360l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1756487497l, 448008360l, TravelType.BIKE, true);
    checkRoute(r0a, 15279.229173610898, 1756487497l, 448008360l);
    computeRoute(1756487497l, 448008360l, TravelType.CAR, false);
    Route r2a = computeRoute(1756487497l, 448008360l, TravelType.FOOT, true);
    checkRoute(r2a, 14917.47143090079, 1756487497l, 448008360l);
    Route r3a = computeRoute(1756487497l, 448008360l, TravelType.ANY, true);
    checkRoute(r3a, 14917.47143090079, 1756487497l, 448008360l);
}


@Test(timeout = 15000)
public void testSmallRouting90RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2892279797l, 2264546519l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2892279797l, 2264546519l, TravelType.BIKE, false);
    computeRoute(2892279797l, 2264546519l, TravelType.CAR, false);
    Route r2a = computeRoute(2892279797l, 2264546519l, TravelType.FOOT, true);
    checkRoute(r2a, 16362.519474768353, 2892279797l, 2264546519l);
    Route r3a = computeRoute(2892279797l, 2264546519l, TravelType.ANY, true);
    checkRoute(r3a, 16362.519474768353, 2892279797l, 2264546519l);
}


@Test(timeout = 15000)
public void testSmallRouting91RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 316590622l, 968115165l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(316590622l, 968115165l, TravelType.BIKE, true);
    checkRoute(r0a, 45893.60692297116, 316590622l, 968115165l);
    computeRoute(316590622l, 968115165l, TravelType.CAR, false);
    Route r2a = computeRoute(316590622l, 968115165l, TravelType.FOOT, true);
    checkRoute(r2a, 44823.66017017357, 316590622l, 968115165l);
    Route r3a = computeRoute(316590622l, 968115165l, TravelType.ANY, true);
    checkRoute(r3a, 44823.66017017357, 316590622l, 968115165l);
}


@Test(timeout = 15000)
public void testSmallRouting92RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1793507365l, 705472546l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1793507365l, 705472546l, TravelType.BIKE, false);
    computeRoute(1793507365l, 705472546l, TravelType.CAR, false);
    Route r2a = computeRoute(1793507365l, 705472546l, TravelType.FOOT, true);
    checkRoute(r2a, 43068.53575054678, 1793507365l, 705472546l);
    Route r3a = computeRoute(1793507365l, 705472546l, TravelType.ANY, true);
    checkRoute(r3a, 43011.44852466958, 1793507365l, 705472546l);
}


@Test(timeout = 15000)
public void testSmallRouting93RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1300493385l, 1368339208l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1300493385l, 1368339208l, TravelType.BIKE, true);
    checkRoute(r0a, 13846.73230005958, 1300493385l, 1368339208l);
    computeRoute(1300493385l, 1368339208l, TravelType.CAR, false);
    Route r2a = computeRoute(1300493385l, 1368339208l, TravelType.FOOT, true);
    checkRoute(r2a, 13248.325820886159, 1300493385l, 1368339208l);
    Route r3a = computeRoute(1300493385l, 1368339208l, TravelType.ANY, true);
    checkRoute(r3a, 13248.325820886159, 1300493385l, 1368339208l);
}


@Test(timeout = 15000)
public void testSmallRouting94RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1416360772l, 470046579l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1416360772l, 470046579l, TravelType.BIKE, true);
    checkRoute(r0a, 55219.50250033941, 1416360772l, 470046579l);
    computeRoute(1416360772l, 470046579l, TravelType.CAR, false);
    Route r2a = computeRoute(1416360772l, 470046579l, TravelType.FOOT, true);
    checkRoute(r2a, 54663.122898606474, 1416360772l, 470046579l);
    Route r3a = computeRoute(1416360772l, 470046579l, TravelType.ANY, true);
    checkRoute(r3a, 54527.582178330835, 1416360772l, 470046579l);
}


@Test(timeout = 15000)
public void testSmallRouting95RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2451677169l, 432643020l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2451677169l, 432643020l, TravelType.BIKE, true);
    checkRoute(r0a, 27843.25990894254, 2451677169l, 432643020l);
    Route r1a = computeRoute(2451677169l, 432643020l, TravelType.CAR, true);
    checkRoute(r1a, 28741.43156058578, 2451677169l, 432643020l);
    Route r2a = computeRoute(2451677169l, 432643020l, TravelType.FOOT, true);
    checkRoute(r2a, 27543.56992493795, 2451677169l, 432643020l);
    Route r3a = computeRoute(2451677169l, 432643020l, TravelType.ANY, true);
    checkRoute(r3a, 27363.24068202628, 2451677169l, 432643020l);
}


@Test(timeout = 15000)
public void testSmallRouting96RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 262292503l, 348418743l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(262292503l, 348418743l, TravelType.BIKE, true);
    checkRoute(r0a, 10153.410950179468, 262292503l, 348418743l);
    computeRoute(262292503l, 348418743l, TravelType.CAR, false);
    Route r2a = computeRoute(262292503l, 348418743l, TravelType.FOOT, true);
    checkRoute(r2a, 10118.840467654247, 262292503l, 348418743l);
    Route r3a = computeRoute(262292503l, 348418743l, TravelType.ANY, true);
    checkRoute(r3a, 10118.840467654247, 262292503l, 348418743l);
}


@Test(timeout = 15000)
public void testSmallRouting97RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 373447236l, 2450498715l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(373447236l, 2450498715l, TravelType.BIKE, false);
    computeRoute(373447236l, 2450498715l, TravelType.CAR, false);
    Route r2a = computeRoute(373447236l, 2450498715l, TravelType.FOOT, true);
    checkRoute(r2a, 25393.03811597837, 373447236l, 2450498715l);
    Route r3a = computeRoute(373447236l, 2450498715l, TravelType.ANY, true);
    checkRoute(r3a, 25344.596022692316, 373447236l, 2450498715l);
}


@Test(timeout = 15000)
public void testSmallRouting98RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3479463169l, 423791282l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(3479463169l, 423791282l, TravelType.BIKE, true);
    checkRoute(r0a, 58801.75449833237, 3479463169l, 423791282l);
    Route r1a = computeRoute(3479463169l, 423791282l, TravelType.CAR, true);
    checkRoute(r1a, 61402.76941299156, 3479463169l, 423791282l);
    Route r2a = computeRoute(3479463169l, 423791282l, TravelType.FOOT, true);
    checkRoute(r2a, 57940.02661249639, 3479463169l, 423791282l);
    Route r3a = computeRoute(3479463169l, 423791282l, TravelType.ANY, true);
    checkRoute(r3a, 57338.52378040823, 3479463169l, 423791282l);
}


@Test(timeout = 15000)
public void testSmallRouting99RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2444648767l, 1369118828l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2444648767l, 1369118828l, TravelType.BIKE, true);
    checkRoute(r0a, 24849.291756726652, 2444648767l, 1369118828l);
    computeRoute(2444648767l, 1369118828l, TravelType.CAR, false);
    Route r2a = computeRoute(2444648767l, 1369118828l, TravelType.FOOT, true);
    checkRoute(r2a, 23255.120413027875, 2444648767l, 1369118828l);
    Route r3a = computeRoute(2444648767l, 1369118828l, TravelType.ANY, true);
    checkRoute(r3a, 23071.363636801845, 2444648767l, 1369118828l);
}


@Test(timeout = 15000)
public void testSmallRouting100RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 365535328l, 392230867l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(365535328l, 392230867l, TravelType.BIKE, true);
    checkRoute(r0a, 44774.26492053365, 365535328l, 392230867l);
    computeRoute(365535328l, 392230867l, TravelType.CAR, false);
    Route r2a = computeRoute(365535328l, 392230867l, TravelType.FOOT, true);
    checkRoute(r2a, 43505.07508339505, 365535328l, 392230867l);
    Route r3a = computeRoute(365535328l, 392230867l, TravelType.ANY, true);
    checkRoute(r3a, 43206.70607109478, 365535328l, 392230867l);
}


@Test(timeout = 15000)
public void testSmallRouting101RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 434401084l, 3274916419l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(434401084l, 3274916419l, TravelType.BIKE, true);
    checkRoute(r0a, 47942.16632226125, 434401084l, 3274916419l);
    computeRoute(434401084l, 3274916419l, TravelType.CAR, false);
    Route r2a = computeRoute(434401084l, 3274916419l, TravelType.FOOT, true);
    checkRoute(r2a, 46341.072974613766, 434401084l, 3274916419l);
    Route r3a = computeRoute(434401084l, 3274916419l, TravelType.ANY, true);
    checkRoute(r3a, 45720.87811579599, 434401084l, 3274916419l);
}


@Test(timeout = 15000)
public void testSmallRouting102RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 666086151l, 442600379l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(666086151l, 442600379l, TravelType.BIKE, true);
    checkRoute(r0a, 24819.574649317346, 666086151l, 442600379l);
    computeRoute(666086151l, 442600379l, TravelType.CAR, false);
    Route r2a = computeRoute(666086151l, 442600379l, TravelType.FOOT, true);
    checkRoute(r2a, 23963.114031756286, 666086151l, 442600379l);
    Route r3a = computeRoute(666086151l, 442600379l, TravelType.ANY, true);
    checkRoute(r3a, 23963.114031756286, 666086151l, 442600379l);
}


@Test(timeout = 15000)
public void testSmallRouting103RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 458867802l, 293787753l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(458867802l, 293787753l, TravelType.BIKE, true);
    checkRoute(r0a, 23967.96458215103, 458867802l, 293787753l);
    computeRoute(458867802l, 293787753l, TravelType.CAR, false);
    Route r2a = computeRoute(458867802l, 293787753l, TravelType.FOOT, true);
    checkRoute(r2a, 23781.558064558907, 458867802l, 293787753l);
    Route r3a = computeRoute(458867802l, 293787753l, TravelType.ANY, true);
    checkRoute(r3a, 23399.36123240957, 458867802l, 293787753l);
}


@Test(timeout = 15000)
public void testSmallRouting104RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1696246056l, 2503856553l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1696246056l, 2503856553l, TravelType.BIKE, false);
    computeRoute(1696246056l, 2503856553l, TravelType.CAR, false);
    Route r2a = computeRoute(1696246056l, 2503856553l, TravelType.FOOT, true);
    checkRoute(r2a, 20171.770534788444, 1696246056l, 2503856553l);
    Route r3a = computeRoute(1696246056l, 2503856553l, TravelType.ANY, true);
    checkRoute(r3a, 20171.770534788444, 1696246056l, 2503856553l);
}


@Test(timeout = 15000)
public void testSmallRouting105RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 361508539l, 2435600777l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(361508539l, 2435600777l, TravelType.BIKE, true);
    checkRoute(r0a, 29184.850654038713, 361508539l, 2435600777l);
    computeRoute(361508539l, 2435600777l, TravelType.CAR, false);
    Route r2a = computeRoute(361508539l, 2435600777l, TravelType.FOOT, true);
    checkRoute(r2a, 27544.87844280072, 361508539l, 2435600777l);
    Route r3a = computeRoute(361508539l, 2435600777l, TravelType.ANY, true);
    checkRoute(r3a, 27544.87844280072, 361508539l, 2435600777l);
}


@Test(timeout = 15000)
public void testSmallRouting106RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1763014647l, 266163106l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1763014647l, 266163106l, TravelType.BIKE, true);
    checkRoute(r0a, 56212.27448126311, 1763014647l, 266163106l);
    computeRoute(1763014647l, 266163106l, TravelType.CAR, false);
    Route r2a = computeRoute(1763014647l, 266163106l, TravelType.FOOT, true);
    checkRoute(r2a, 54239.73097151612, 1763014647l, 266163106l);
    Route r3a = computeRoute(1763014647l, 266163106l, TravelType.ANY, true);
    checkRoute(r3a, 53746.545691798055, 1763014647l, 266163106l);
}


@Test(timeout = 15000)
public void testSmallRouting107RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 756655877l, 972540225l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(756655877l, 972540225l, TravelType.BIKE, true);
    checkRoute(r0a, 50742.61113149986, 756655877l, 972540225l);
    computeRoute(756655877l, 972540225l, TravelType.CAR, false);
    Route r2a = computeRoute(756655877l, 972540225l, TravelType.FOOT, true);
    checkRoute(r2a, 48187.513387511295, 756655877l, 972540225l);
    Route r3a = computeRoute(756655877l, 972540225l, TravelType.ANY, true);
    checkRoute(r3a, 48152.22060333005, 756655877l, 972540225l);
}


@Test(timeout = 15000)
public void testSmallRouting108RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 317933991l, 2977006373l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(317933991l, 2977006373l, TravelType.BIKE, true);
    checkRoute(r0a, 26308.347419540667, 317933991l, 2977006373l);
    computeRoute(317933991l, 2977006373l, TravelType.CAR, false);
    Route r2a = computeRoute(317933991l, 2977006373l, TravelType.FOOT, true);
    checkRoute(r2a, 25857.83837658221, 317933991l, 2977006373l);
    Route r3a = computeRoute(317933991l, 2977006373l, TravelType.ANY, true);
    checkRoute(r3a, 25740.509009604593, 317933991l, 2977006373l);
}


@Test(timeout = 15000)
public void testSmallRouting109RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1900704005l, 391059554l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1900704005l, 391059554l, TravelType.BIKE, true);
    checkRoute(r0a, 36648.99639850234, 1900704005l, 391059554l);
    computeRoute(1900704005l, 391059554l, TravelType.CAR, false);
    Route r2a = computeRoute(1900704005l, 391059554l, TravelType.FOOT, true);
    checkRoute(r2a, 36541.943939629506, 1900704005l, 391059554l);
    Route r3a = computeRoute(1900704005l, 391059554l, TravelType.ANY, true);
    checkRoute(r3a, 36529.05882255206, 1900704005l, 391059554l);
}


@Test(timeout = 15000)
public void testSmallRouting110RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2324398149l, 440648906l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2324398149l, 440648906l, TravelType.BIKE, true);
    checkRoute(r0a, 19472.037659696987, 2324398149l, 440648906l);
    computeRoute(2324398149l, 440648906l, TravelType.CAR, false);
    Route r2a = computeRoute(2324398149l, 440648906l, TravelType.FOOT, true);
    checkRoute(r2a, 19107.881149611832, 2324398149l, 440648906l);
    Route r3a = computeRoute(2324398149l, 440648906l, TravelType.ANY, true);
    checkRoute(r3a, 18975.832583811352, 2324398149l, 440648906l);
}


@Test(timeout = 15000)
public void testSmallRouting111RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 917595222l, 662943609l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(917595222l, 662943609l, TravelType.BIKE, true);
    checkRoute(r0a, 30120.79381414008, 917595222l, 662943609l);
    computeRoute(917595222l, 662943609l, TravelType.CAR, false);
    Route r2a = computeRoute(917595222l, 662943609l, TravelType.FOOT, true);
    checkRoute(r2a, 27857.78912720923, 917595222l, 662943609l);
    Route r3a = computeRoute(917595222l, 662943609l, TravelType.ANY, true);
    checkRoute(r3a, 27857.78912720923, 917595222l, 662943609l);
}


@Test(timeout = 15000)
public void testSmallRouting112RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 359626068l, 336144767l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(359626068l, 336144767l, TravelType.BIKE, true);
    checkRoute(r0a, 34119.63527629438, 359626068l, 336144767l);
    Route r1a = computeRoute(359626068l, 336144767l, TravelType.CAR, true);
    checkRoute(r1a, 34372.83592768226, 359626068l, 336144767l);
    Route r2a = computeRoute(359626068l, 336144767l, TravelType.FOOT, true);
    checkRoute(r2a, 33795.44547690767, 359626068l, 336144767l);
    Route r3a = computeRoute(359626068l, 336144767l, TravelType.ANY, true);
    checkRoute(r3a, 33795.44547690767, 359626068l, 336144767l);
}


@Test(timeout = 15000)
public void testSmallRouting113RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2496333226l, 448915839l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2496333226l, 448915839l, TravelType.BIKE, false);
    computeRoute(2496333226l, 448915839l, TravelType.CAR, false);
    Route r2a = computeRoute(2496333226l, 448915839l, TravelType.FOOT, true);
    checkRoute(r2a, 14093.545348923742, 2496333226l, 448915839l);
    Route r3a = computeRoute(2496333226l, 448915839l, TravelType.ANY, true);
    checkRoute(r3a, 14093.545348923742, 2496333226l, 448915839l);
}


@Test(timeout = 15000)
public void testSmallRouting114RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 425799174l, 263686235l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(425799174l, 263686235l, TravelType.BIKE, true);
    checkRoute(r0a, 73726.22102973759, 425799174l, 263686235l);
    computeRoute(425799174l, 263686235l, TravelType.CAR, false);
    Route r2a = computeRoute(425799174l, 263686235l, TravelType.FOOT, true);
    checkRoute(r2a, 71923.89142900254, 425799174l, 263686235l);
    Route r3a = computeRoute(425799174l, 263686235l, TravelType.ANY, true);
    checkRoute(r3a, 71430.70614928451, 425799174l, 263686235l);
}


@Test(timeout = 15000)
public void testSmallRouting115RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 371732593l, 2284655038l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(371732593l, 2284655038l, TravelType.BIKE, true);
    checkRoute(r0a, 12894.519783905382, 371732593l, 2284655038l);
    computeRoute(371732593l, 2284655038l, TravelType.CAR, false);
    Route r2a = computeRoute(371732593l, 2284655038l, TravelType.FOOT, true);
    checkRoute(r2a, 12438.365726626596, 371732593l, 2284655038l);
    Route r3a = computeRoute(371732593l, 2284655038l, TravelType.ANY, true);
    checkRoute(r3a, 12438.365726626596, 371732593l, 2284655038l);
}


@Test(timeout = 15000)
public void testSmallRouting116RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2657225438l, 339166238l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2657225438l, 339166238l, TravelType.BIKE, true);
    checkRoute(r0a, 38341.727904096006, 2657225438l, 339166238l);
    computeRoute(2657225438l, 339166238l, TravelType.CAR, false);
    Route r2a = computeRoute(2657225438l, 339166238l, TravelType.FOOT, true);
    checkRoute(r2a, 37311.63847929524, 2657225438l, 339166238l);
    Route r3a = computeRoute(2657225438l, 339166238l, TravelType.ANY, true);
    checkRoute(r3a, 37311.63847929524, 2657225438l, 339166238l);
}


@Test(timeout = 15000)
public void testSmallRouting117RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 717700294l, 275597167l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(717700294l, 275597167l, TravelType.BIKE, true);
    checkRoute(r0a, 52672.73702718485, 717700294l, 275597167l);
    computeRoute(717700294l, 275597167l, TravelType.CAR, false);
    Route r2a = computeRoute(717700294l, 275597167l, TravelType.FOOT, true);
    checkRoute(r2a, 51295.0898577805, 717700294l, 275597167l);
    Route r3a = computeRoute(717700294l, 275597167l, TravelType.ANY, true);
    checkRoute(r3a, 50921.30797387842, 717700294l, 275597167l);
}


@Test(timeout = 15000)
public void testSmallRouting118RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 288466192l, 289940561l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(288466192l, 289940561l, TravelType.BIKE, true);
    checkRoute(r0a, 11807.943511814457, 288466192l, 289940561l);
    Route r1a = computeRoute(288466192l, 289940561l, TravelType.CAR, true);
    checkRoute(r1a, 14108.137310760434, 288466192l, 289940561l);
    Route r2a = computeRoute(288466192l, 289940561l, TravelType.FOOT, true);
    checkRoute(r2a, 11254.91605815988, 288466192l, 289940561l);
    Route r3a = computeRoute(288466192l, 289940561l, TravelType.ANY, true);
    checkRoute(r3a, 11254.91605815988, 288466192l, 289940561l);
}


@Test(timeout = 15000)
public void testSmallRouting119RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 301616371l, 435561101l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(301616371l, 435561101l, TravelType.BIKE, true);
    checkRoute(r0a, 51749.342407523574, 301616371l, 435561101l);
    Route r1a = computeRoute(301616371l, 435561101l, TravelType.CAR, true);
    checkRoute(r1a, 51936.25367579676, 301616371l, 435561101l);
    Route r2a = computeRoute(301616371l, 435561101l, TravelType.FOOT, true);
    checkRoute(r2a, 50912.56622085862, 301616371l, 435561101l);
    Route r3a = computeRoute(301616371l, 435561101l, TravelType.ANY, true);
    checkRoute(r3a, 50912.56622085862, 301616371l, 435561101l);
}


@Test(timeout = 15000)
public void testSmallRouting120RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 427009896l, 815293542l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(427009896l, 815293542l, TravelType.BIKE, true);
    checkRoute(r0a, 45954.969482349356, 427009896l, 815293542l);
    computeRoute(427009896l, 815293542l, TravelType.CAR, false);
    Route r2a = computeRoute(427009896l, 815293542l, TravelType.FOOT, true);
    checkRoute(r2a, 44957.294770265595, 427009896l, 815293542l);
    Route r3a = computeRoute(427009896l, 815293542l, TravelType.ANY, true);
    checkRoute(r3a, 44796.58114408719, 427009896l, 815293542l);
}


@Test(timeout = 15000)
public void testSmallRouting121RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 376373628l, 687502146l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(376373628l, 687502146l, TravelType.BIKE, true);
    checkRoute(r0a, 9600.854260310613, 376373628l, 687502146l);
    computeRoute(376373628l, 687502146l, TravelType.CAR, false);
    Route r2a = computeRoute(376373628l, 687502146l, TravelType.FOOT, true);
    checkRoute(r2a, 9600.854260310613, 376373628l, 687502146l);
    Route r3a = computeRoute(376373628l, 687502146l, TravelType.ANY, true);
    checkRoute(r3a, 9600.854260310613, 376373628l, 687502146l);
}


@Test(timeout = 15000)
public void testSmallRouting122RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 539398236l, 359160182l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(539398236l, 359160182l, TravelType.BIKE, true);
    checkRoute(r0a, 31626.988593112183, 539398236l, 359160182l);
    Route r1a = computeRoute(539398236l, 359160182l, TravelType.CAR, true);
    checkRoute(r1a, 32803.341867018455, 539398236l, 359160182l);
    Route r2a = computeRoute(539398236l, 359160182l, TravelType.FOOT, true);
    checkRoute(r2a, 31497.830947262595, 539398236l, 359160182l);
    Route r3a = computeRoute(539398236l, 359160182l, TravelType.ANY, true);
    checkRoute(r3a, 31497.685532889296, 539398236l, 359160182l);
}


@Test(timeout = 15000)
public void testSmallRouting123RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 321585431l, 262786990l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(321585431l, 262786990l, TravelType.BIKE, true);
    checkRoute(r0a, 39834.20794503483, 321585431l, 262786990l);
    computeRoute(321585431l, 262786990l, TravelType.CAR, false);
    computeRoute(321585431l, 262786990l, TravelType.FOOT, false);
    Route r3a = computeRoute(321585431l, 262786990l, TravelType.ANY, true);
    checkRoute(r3a, 39723.83272332162, 321585431l, 262786990l);
}


@Test(timeout = 15000)
public void testSmallRouting124RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3219889079l, 1425012468l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(3219889079l, 1425012468l, TravelType.BIKE, false);
    computeRoute(3219889079l, 1425012468l, TravelType.CAR, false);
    Route r2a = computeRoute(3219889079l, 1425012468l, TravelType.FOOT, true);
    checkRoute(r2a, 43245.822558428976, 3219889079l, 1425012468l);
    Route r3a = computeRoute(3219889079l, 1425012468l, TravelType.ANY, true);
    checkRoute(r3a, 43245.822558428976, 3219889079l, 1425012468l);
}


@Test(timeout = 15000)
public void testSmallRouting125RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1722116364l, 1381405435l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1722116364l, 1381405435l, TravelType.BIKE, false);
    computeRoute(1722116364l, 1381405435l, TravelType.CAR, false);
    Route r2a = computeRoute(1722116364l, 1381405435l, TravelType.FOOT, true);
    checkRoute(r2a, 51816.330501385746, 1722116364l, 1381405435l);
    Route r3a = computeRoute(1722116364l, 1381405435l, TravelType.ANY, true);
    checkRoute(r3a, 51622.28399204477, 1722116364l, 1381405435l);
}


@Test(timeout = 15000)
public void testSmallRouting126RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2039811997l, 1501249780l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2039811997l, 1501249780l, TravelType.BIKE, false);
    Route r1a = computeRoute(2039811997l, 1501249780l, TravelType.CAR, true);
    checkRoute(r1a, 1617.6506472728274, 2039811997l, 1501249780l);
    Route r2a = computeRoute(2039811997l, 1501249780l, TravelType.FOOT, true);
    checkRoute(r2a, 1603.1465973090592, 2039811997l, 1501249780l);
    Route r3a = computeRoute(2039811997l, 1501249780l, TravelType.ANY, true);
    checkRoute(r3a, 1603.1465973090592, 2039811997l, 1501249780l);
}


@Test(timeout = 15000)
public void testSmallRouting127RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1765141941l, 281384860l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1765141941l, 281384860l, TravelType.BIKE, true);
    checkRoute(r0a, 31698.540929593164, 1765141941l, 281384860l);
    computeRoute(1765141941l, 281384860l, TravelType.CAR, false);
    Route r2a = computeRoute(1765141941l, 281384860l, TravelType.FOOT, true);
    checkRoute(r2a, 27696.07620257759, 1765141941l, 281384860l);
    Route r3a = computeRoute(1765141941l, 281384860l, TravelType.ANY, true);
    checkRoute(r3a, 27557.672363508987, 1765141941l, 281384860l);
}


@Override
public String getMapFileName() {
    return "saarland.osm.nae";
}


}