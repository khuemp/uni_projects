package routing.tests.local.huge;

import static org.junit.Assert.assertEquals;

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
public class TestSaarlandMapRandomRoutingTests extends TestingBase {

@Test(timeout = 20000)
public void testRouting2RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 504466758l, 2448171502l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(504466758l, 2448171502l, TravelType.BIKE, true);
    checkRoute(r0a, 18296.952017900545, 504466758l, 2448171502l);
    computeRoute(504466758l, 2448171502l, TravelType.CAR, false);
    Route r2a = computeRoute(504466758l, 2448171502l, TravelType.FOOT, true);
    checkRoute(r2a, 12016.322280298862, 504466758l, 2448171502l);
    Route r3a = computeRoute(504466758l, 2448171502l, TravelType.ANY, true);
    checkRoute(r3a, 12016.322280298862, 504466758l, 2448171502l);
    Route r0b = computeRoute(waypointsList, TravelType.BIKE, true);
    assertEquals("Route did not have waypoints many legs", r0b.size(), 1);
    checkWaypoints(r0b, 18296.952017900545, waypoints);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 1);
    checkWaypoints(r2b, 12016.322280298862, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 1);
    checkWaypoints(r3b, 12016.322280298862, waypoints);
}


@Test(timeout = 20000)
public void testRouting3RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 763399059l, 596484860l, 254400425l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(763399059l, 254400425l, TravelType.BIKE, true);
    checkRoute(r0a, 50304.18990490245, 763399059l, 254400425l);
    computeRoute(763399059l, 254400425l, TravelType.CAR, false);
    Route r2a = computeRoute(763399059l, 254400425l, TravelType.FOOT, true);
    checkRoute(r2a, 49855.28636906201, 763399059l, 254400425l);
    Route r3a = computeRoute(763399059l, 254400425l, TravelType.ANY, true);
    checkRoute(r3a, 49855.28636906201, 763399059l, 254400425l);
    Route r0b = computeRoute(waypointsList, TravelType.BIKE, true);
    assertEquals("Route did not have waypoints many legs", r0b.size(), 2);
    checkWaypoints(r0b, 53279.34487711477, waypoints);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 2);
    checkWaypoints(r2b, 52616.68523817877, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 2);
    checkWaypoints(r3b, 52254.94283255033, waypoints);
}


@Test(timeout = 20000)
public void testRouting4RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2450847891l, 3455290034l, 338001045l, 1550397658l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2450847891l, 1550397658l, TravelType.BIKE, true);
    checkRoute(r0a, 52577.56564058277, 2450847891l, 1550397658l);
    computeRoute(2450847891l, 1550397658l, TravelType.CAR, false);
    computeRoute(2450847891l, 1550397658l, TravelType.FOOT, false);
    Route r3a = computeRoute(2450847891l, 1550397658l, TravelType.ANY, true);
    checkRoute(r3a, 51949.17373727972, 2450847891l, 1550397658l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 3);
    checkWaypoints(r3b, 85143.60595172181, waypoints);
}


@Test(timeout = 20000)
public void testRouting5RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 279571744l, 880702160l, 1243792977l, 377786697l, 484802119l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(279571744l, 484802119l, TravelType.BIKE, true);
    checkRoute(r0a, 16103.88413725271, 279571744l, 484802119l);
    computeRoute(279571744l, 484802119l, TravelType.CAR, false);
    Route r2a = computeRoute(279571744l, 484802119l, TravelType.FOOT, true);
    checkRoute(r2a, 15149.019919207118, 279571744l, 484802119l);
    Route r3a = computeRoute(279571744l, 484802119l, TravelType.ANY, true);
    checkRoute(r3a, 15149.019919207118, 279571744l, 484802119l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 4);
    checkWaypoints(r2b, 116356.55057424406, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 4);
    checkWaypoints(r3b, 115761.86234726082, waypoints);
}


@Test(timeout = 20000)
public void testRouting6RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 293415816l, 293612479l, 380378241l, 1917131683l, 3298852173l, 1647452946l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(293415816l, 1647452946l, TravelType.BIKE, true);
    checkRoute(r0a, 27687.634206834777, 293415816l, 1647452946l);
    Route r1a = computeRoute(293415816l, 1647452946l, TravelType.CAR, true);
    checkRoute(r1a, 29297.321944563217, 293415816l, 1647452946l);
    Route r2a = computeRoute(293415816l, 1647452946l, TravelType.FOOT, true);
    checkRoute(r2a, 26471.725594891002, 293415816l, 1647452946l);
    Route r3a = computeRoute(293415816l, 1647452946l, TravelType.ANY, true);
    checkRoute(r3a, 26415.789598828316, 293415816l, 1647452946l);
    Route r0b = computeRoute(waypointsList, TravelType.BIKE, true);
    assertEquals("Route did not have waypoints many legs", r0b.size(), 5);
    checkWaypoints(r0b, 104933.65982569584, waypoints);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 5);
    checkWaypoints(r2b, 99262.2231854666, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 5);
    checkWaypoints(r3b, 99088.73684196496, waypoints);
}


@Test(timeout = 20000)
public void testRouting7RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 349031382l, 410348616l, 1227809328l, 720614030l, 1534689025l, 1385775414l, 303218688l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(349031382l, 303218688l, TravelType.BIKE, false);
    computeRoute(349031382l, 303218688l, TravelType.CAR, false);
    Route r2a = computeRoute(349031382l, 303218688l, TravelType.FOOT, true);
    checkRoute(r2a, 17409.047658315347, 349031382l, 303218688l);
    Route r3a = computeRoute(349031382l, 303218688l, TravelType.ANY, true);
    checkRoute(r3a, 17197.662510520047, 349031382l, 303218688l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 6);
    checkWaypoints(r2b, 157922.37211161896, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 6);
    checkWaypoints(r3b, 157410.68980855867, waypoints);
}


@Test(timeout = 20000)
public void testRouting8RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1557337537l, 2073047792l, 1268518012l, 410348384l, 3071434438l, 2536198502l, 312520253l, 914884661l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1557337537l, 914884661l, TravelType.BIKE, true);
    checkRoute(r0a, 31895.44961116293, 1557337537l, 914884661l);
    computeRoute(1557337537l, 914884661l, TravelType.CAR, false);
    Route r2a = computeRoute(1557337537l, 914884661l, TravelType.FOOT, true);
    checkRoute(r2a, 31188.172190405505, 1557337537l, 914884661l);
    Route r3a = computeRoute(1557337537l, 914884661l, TravelType.ANY, true);
    checkRoute(r3a, 31185.206510478805, 1557337537l, 914884661l);
    Route r0b = computeRoute(waypointsList, TravelType.BIKE, true);
    assertEquals("Route did not have waypoints many legs", r0b.size(), 7);
    checkWaypoints(r0b, 190700.14629259257, waypoints);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 7);
    checkWaypoints(r2b, 185626.94147722668, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 7);
    checkWaypoints(r3b, 182922.94274130254, waypoints);
}


@Test(timeout = 20000)
public void testRouting9RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1597598064l, 350674616l, 583490556l, 1199436278l, 1509646773l, 1519388335l, 343240224l, 719130771l, 667001478l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1597598064l, 667001478l, TravelType.BIKE, false);
    computeRoute(1597598064l, 667001478l, TravelType.CAR, false);
    Route r2a = computeRoute(1597598064l, 667001478l, TravelType.FOOT, true);
    checkRoute(r2a, 67161.55294798648, 1597598064l, 667001478l);
    Route r3a = computeRoute(1597598064l, 667001478l, TravelType.ANY, true);
    checkRoute(r3a, 66725.99504856838, 1597598064l, 667001478l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 8);
    checkWaypoints(r3b, 179346.77216903106, waypoints);
}


@Test(timeout = 20000)
public void testRouting10RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 988627418l, 507943590l, 280878579l, 2622282667l, 443457101l, 958456654l, 324719244l, 1658793022l, 384631358l, 410348143l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(988627418l, 410348143l, TravelType.BIKE, true);
    checkRoute(r0a, 22368.269271658854, 988627418l, 410348143l);
    computeRoute(988627418l, 410348143l, TravelType.CAR, false);
    Route r2a = computeRoute(988627418l, 410348143l, TravelType.FOOT, true);
    checkRoute(r2a, 22165.040119937636, 988627418l, 410348143l);
    Route r3a = computeRoute(988627418l, 410348143l, TravelType.ANY, true);
    checkRoute(r3a, 22165.040119937636, 988627418l, 410348143l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 9);
    checkWaypoints(r2b, 287537.22045889264, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 9);
    checkWaypoints(r3b, 287442.53785551817, waypoints);
}


@Test(timeout = 20000)
public void testRouting11RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 291866472l, 298207676l, 2954148913l, 370412683l, 262169122l, 2958186242l, 476560595l, 474694396l, 339114387l, 1777380023l, 366889919l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(291866472l, 366889919l, TravelType.BIKE, true);
    checkRoute(r0a, 22674.771218012553, 291866472l, 366889919l);
    computeRoute(291866472l, 366889919l, TravelType.CAR, false);
    Route r2a = computeRoute(291866472l, 366889919l, TravelType.FOOT, true);
    checkRoute(r2a, 20652.925987348062, 291866472l, 366889919l);
    Route r3a = computeRoute(291866472l, 366889919l, TravelType.ANY, true);
    checkRoute(r3a, 20438.862720588644, 291866472l, 366889919l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 10);
    checkWaypoints(r2b, 354776.08301769546, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 10);
    checkWaypoints(r3b, 354263.0132871105, waypoints);
}


@Test(timeout = 20000)
public void testRouting12RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 485921203l, 765271276l, 1372569496l, 2874021190l, 316521337l, 765842689l, 2107761470l, 1300545916l, 1365406817l, 1939192928l, 365365586l, 506698216l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(485921203l, 506698216l, TravelType.BIKE, true);
    checkRoute(r0a, 56747.57033162445, 485921203l, 506698216l);
    computeRoute(485921203l, 506698216l, TravelType.CAR, false);
    Route r2a = computeRoute(485921203l, 506698216l, TravelType.FOOT, true);
    checkRoute(r2a, 55640.83417275322, 485921203l, 506698216l);
    Route r3a = computeRoute(485921203l, 506698216l, TravelType.ANY, true);
    checkRoute(r3a, 55302.2180714436, 485921203l, 506698216l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 11);
    checkWaypoints(r2b, 448130.5389012669, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 11);
    checkWaypoints(r3b, 446104.8560619081, waypoints);
}


@Test(timeout = 25000)
public void testRouting13RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2468838767l, 472280152l, 370328998l, 450873159l, 310387931l, 2441778008l, 1806244643l, 827320760l, 718744525l, 696918641l, 353893662l, 268887095l, 659952064l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2468838767l, 659952064l, TravelType.BIKE, true);
    checkRoute(r0a, 32446.418521559033, 2468838767l, 659952064l);
    computeRoute(2468838767l, 659952064l, TravelType.CAR, false);
    Route r2a = computeRoute(2468838767l, 659952064l, TravelType.FOOT, true);
    checkRoute(r2a, 31577.292399214322, 2468838767l, 659952064l);
    Route r3a = computeRoute(2468838767l, 659952064l, TravelType.ANY, true);
    checkRoute(r3a, 31577.292399214322, 2468838767l, 659952064l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 12);
    checkWaypoints(r2b, 481039.5052136778, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 12);
    checkWaypoints(r3b, 480130.5892373731, waypoints);
}


@Test(timeout = 20000)
public void testRouting14RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2514877194l, 717942143l, 434518235l, 2698093686l, 2509247145l, 278064841l, 391721003l, 964817657l, 322705665l, 1372333873l, 802635910l, 1410544435l, 2725006825l, 3485077867l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2514877194l, 3485077867l, TravelType.BIKE, false);
    computeRoute(2514877194l, 3485077867l, TravelType.CAR, false);
    Route r2a = computeRoute(2514877194l, 3485077867l, TravelType.FOOT, true);
    checkRoute(r2a, 32075.413364739175, 2514877194l, 3485077867l);
    Route r3a = computeRoute(2514877194l, 3485077867l, TravelType.ANY, true);
    checkRoute(r3a, 32068.371776502285, 2514877194l, 3485077867l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 13);
    checkWaypoints(r3b, 371336.5663590203, waypoints);
}


@Test(timeout = 20000)
public void testRouting15RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2180538472l, 2689623273l, 2535311211l, 607573144l, 2405972368l, 735120094l, 312953193l, 1492432703l, 2283375168l, 2235404812l, 287098705l, 2975931860l, 2089351910l, 1561622081l, 1340039153l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2180538472l, 1340039153l, TravelType.BIKE, false);
    computeRoute(2180538472l, 1340039153l, TravelType.CAR, false);
    Route r2a = computeRoute(2180538472l, 1340039153l, TravelType.FOOT, true);
    checkRoute(r2a, 17059.4840981059, 2180538472l, 1340039153l);
    Route r3a = computeRoute(2180538472l, 1340039153l, TravelType.ANY, true);
    checkRoute(r3a, 17059.4840981059, 2180538472l, 1340039153l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 14);
    checkWaypoints(r2b, 467047.09549714124, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 14);
    checkWaypoints(r3b, 465765.80521284416, waypoints);
}


@Test(timeout = 20000)
public void testRouting16RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 265783566l, 1247360977l, 11981337l, 2120716735l, 258856304l, 371357047l, 696936314l, 310523999l, 2364215529l, 305707250l, 667001029l, 269146881l, 454488202l, 295032708l, 3426311235l, 1674751947l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(265783566l, 1674751947l, TravelType.BIKE, true);
    checkRoute(r0a, 19495.02191183599, 265783566l, 1674751947l);
    Route r1a = computeRoute(265783566l, 1674751947l, TravelType.CAR, true);
    checkRoute(r1a, 19823.253742301848, 265783566l, 1674751947l);
    Route r2a = computeRoute(265783566l, 1674751947l, TravelType.FOOT, true);
    checkRoute(r2a, 19272.20249076151, 265783566l, 1674751947l);
    Route r3a = computeRoute(265783566l, 1674751947l, TravelType.ANY, true);
    checkRoute(r3a, 19272.20249076151, 265783566l, 1674751947l);
    Route r0b = computeRoute(waypointsList, TravelType.BIKE, true);
    assertEquals("Route did not have waypoints many legs", r0b.size(), 15);
    checkWaypoints(r0b, 508544.45998924447, waypoints);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 15);
    checkWaypoints(r2b, 488162.55802497454, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 15);
    checkWaypoints(r3b, 486433.73036474356, waypoints);
}


@Test(timeout = 20000)
public void testRouting17RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 306405990l, 33715367l, 1611992098l, 429624061l, 361524266l, 426975580l, 1687559569l, 1247277601l, 2422577901l, 424239571l, 2081498045l, 1073099973l, 387873634l, 271513240l, 3159541397l, 766925947l, 2300037125l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(306405990l, 2300037125l, TravelType.BIKE, true);
    checkRoute(r0a, 61214.74982970729, 306405990l, 2300037125l);
    computeRoute(306405990l, 2300037125l, TravelType.CAR, false);
    Route r2a = computeRoute(306405990l, 2300037125l, TravelType.FOOT, true);
    checkRoute(r2a, 59993.71390717607, 306405990l, 2300037125l);
    Route r3a = computeRoute(306405990l, 2300037125l, TravelType.ANY, true);
    checkRoute(r3a, 59849.72026773891, 306405990l, 2300037125l);
    Route r0b = computeRoute(waypointsList, TravelType.BIKE, true);
    assertEquals("Route did not have waypoints many legs", r0b.size(), 16);
    checkWaypoints(r0b, 516002.8417930973, waypoints);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 16);
    checkWaypoints(r2b, 504980.92646752024, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 16);
    checkWaypoints(r3b, 504032.0466850011, waypoints);
}


@Test(timeout = 20000)
public void testRouting18RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2472899697l, 304112345l, 1615969343l, 270557556l, 1446410883l, 765279080l, 693118904l, 1743292740l, 1388467596l, 303343620l, 1128138115l, 370895854l, 429443745l, 2275916160l, 335857276l, 2185958549l, 2198023112l, 382753146l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2472899697l, 382753146l, TravelType.BIKE, false);
    computeRoute(2472899697l, 382753146l, TravelType.CAR, false);
    computeRoute(2472899697l, 382753146l, TravelType.FOOT, false);
    Route r3a = computeRoute(2472899697l, 382753146l, TravelType.ANY, true);
    checkRoute(r3a, 61688.52744135443, 2472899697l, 382753146l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 17);
    checkWaypoints(r3b, 534121.3904254244, waypoints);
}


@Test(timeout = 20000)
public void testRouting19RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2093454462l, 2055330641l, 415383469l, 369671279l, 765621819l, 1551882295l, 446713162l, 677455188l, 392392909l, 2940980118l, 473124535l, 673587886l, 2334777520l, 2958335155l, 2076902200l, 2249012657l, 33983257l, 1347218377l, 62645785l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2093454462l, 62645785l, TravelType.BIKE, false);
    computeRoute(2093454462l, 62645785l, TravelType.CAR, false);
    computeRoute(2093454462l, 62645785l, TravelType.FOOT, false);
    Route r3a = computeRoute(2093454462l, 62645785l, TravelType.ANY, true);
    checkRoute(r3a, 48092.2436152000054, 2093454462l, 62645785l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 18);
    checkWaypoints(r3b, 652926.0976803573, waypoints);
}


@Test(timeout = 20000)
public void testRouting20RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 775762230l, 313060789l, 259048497l, 1559585453l, 520407411l, 1450513084l, 263875945l, 1534689017l, 469111650l, 1564351377l, 2715214780l, 2444898222l, 2531342408l, 1248875797l, 1644889610l, 410348702l, 699529257l, 826780416l, 2841291091l, 408353518l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(775762230l, 408353518l, TravelType.BIKE, false);
    computeRoute(775762230l, 408353518l, TravelType.CAR, false);
    Route r2a = computeRoute(775762230l, 408353518l, TravelType.FOOT, true);
    checkRoute(r2a, 31457.47694180236, 775762230l, 408353518l);
    Route r3a = computeRoute(775762230l, 408353518l, TravelType.ANY, true);
    checkRoute(r3a, 31447.499726257676, 775762230l, 408353518l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 19);
    checkWaypoints(r2b, 591887.6064747459, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 19);
    checkWaypoints(r3b, 586399.7177452586, waypoints);
}


@Test(timeout = 20000)
public void testRouting21RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1436382429l, 497374604l, 419909742l, 377784708l, 1709220974l, 338959743l, 292746096l, 2733301065l, 2113108653l, 2809138111l, 370131420l, 378784688l, 1758219857l, 1534649963l, 567618729l, 1450512868l, 1044844270l, 454186860l, 392351760l, 1866471669l, 410342713l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1436382429l, 410342713l, TravelType.BIKE, true);
    checkRoute(r0a, 23617.635365342245, 1436382429l, 410342713l);
    computeRoute(1436382429l, 410342713l, TravelType.CAR, false);
    Route r2a = computeRoute(1436382429l, 410342713l, TravelType.FOOT, true);
    checkRoute(r2a, 21386.830148284924, 1436382429l, 410342713l);
    Route r3a = computeRoute(1436382429l, 410342713l, TravelType.ANY, true);
    checkRoute(r3a, 21386.830148284924, 1436382429l, 410342713l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 20);
    checkWaypoints(r3b, 729504.6814036274, waypoints);
}


@Test(timeout = 20000)
public void testRouting22RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 298204956l, 2352363833l, 1248887566l, 568328134l, 374517633l, 277787905l, 2958378126l, 1275866807l, 266647635l, 664206779l, 270316172l, 518305808l, 392297506l, 2958339987l, 745067765l, 367922354l, 3450158712l, 281581518l, 842080975l, 1882653137l, 1446867231l, 835906227l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(298204956l, 835906227l, TravelType.BIKE, true);
    checkRoute(r0a, 34489.6640243843, 298204956l, 835906227l);
    computeRoute(298204956l, 835906227l, TravelType.CAR, false);
    Route r2a = computeRoute(298204956l, 835906227l, TravelType.FOOT, true);
    checkRoute(r2a, 33247.284148408195, 298204956l, 835906227l);
    Route r3a = computeRoute(298204956l, 835906227l, TravelType.ANY, true);
    checkRoute(r3a, 31975.42002659845, 298204956l, 835906227l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 21);
    checkWaypoints(r3b, 754995.5426402274, waypoints);
}


@Test(timeout = 20000)
public void testRouting23RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1558138381l, 1020646149l, 2222940102l, 1063745778l, 311293312l, 2582776290l, 704434356l, 744984041l, 104587313l, 1272248791l, 290683792l, 854761784l, 392292843l, 2058371559l, 445072331l, 1647130944l, 2839981408l, 323717108l, 266365327l, 1906636520l, 2967851589l, 417401072l, 2203789365l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1558138381l, 2203789365l, TravelType.BIKE, false);
    computeRoute(1558138381l, 2203789365l, TravelType.CAR, false);
    Route r2a = computeRoute(1558138381l, 2203789365l, TravelType.FOOT, true);
    checkRoute(r2a, 14906.425325924436, 1558138381l, 2203789365l);
    Route r3a = computeRoute(1558138381l, 2203789365l, TravelType.ANY, true);
    checkRoute(r3a, 14906.425325924436, 1558138381l, 2203789365l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 22);
    checkWaypoints(r2b, 587944.9256494623, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 22);
    checkWaypoints(r3b, 586780.4831148486, waypoints);
}


@Test(timeout = 20000)
public void testRouting24RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 443457116l, 1302739632l, 2410245254l, 1391280181l, 3071090868l, 34584814l, 310433368l, 444390713l, 278701742l, 337990304l, 559661571l, 2260599923l, 319485757l, 349351074l, 266856780l, 281607725l, 2258823457l, 340363031l, 2543990280l, 10705320l, 278065268l, 394564093l, 324165684l, 2464323338l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(443457116l, 2464323338l, TravelType.BIKE, true);
    checkRoute(r0a, 12913.831962507284, 443457116l, 2464323338l);
    computeRoute(443457116l, 2464323338l, TravelType.CAR, false);
    Route r2a = computeRoute(443457116l, 2464323338l, TravelType.FOOT, true);
    checkRoute(r2a, 12107.809251106759, 443457116l, 2464323338l);
    Route r3a = computeRoute(443457116l, 2464323338l, TravelType.ANY, true);
    checkRoute(r3a, 12107.809251106759, 443457116l, 2464323338l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 23);
    checkWaypoints(r3b, 742034.7559455765, waypoints);
}


@Test(timeout = 20000)
public void testRouting25RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3373682113l, 339453156l, 2839891739l, 1551961953l, 293419041l, 418974051l, 380424731l, 907132960l, 254376347l, 2334767515l, 2034428635l, 1939259567l, 264481081l, 963521349l, 2316086132l, 278065586l, 2192729217l, 288153174l, 253902647l, 395399764l, 443704808l, 266850542l, 452996664l, 497267832l, 352946371l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(3373682113l, 352946371l, TravelType.BIKE, false);
    computeRoute(3373682113l, 352946371l, TravelType.CAR, false);
    Route r2a = computeRoute(3373682113l, 352946371l, TravelType.FOOT, true);
    checkRoute(r2a, 16283.84060016648, 3373682113l, 352946371l);
    Route r3a = computeRoute(3373682113l, 352946371l, TravelType.ANY, true);
    checkRoute(r3a, 16283.84060016648, 3373682113l, 352946371l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 24);
    checkWaypoints(r2b, 725926.3798402603, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 24);
    checkWaypoints(r3b, 723386.3776700671, waypoints);
}


@Test(timeout = 20000)
public void testRouting26RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1586177536l, 1400094759l, 1380440917l, 582806216l, 1484634194l, 262169086l, 1421857699l, 278462440l, 536131l, 1363399960l, 908874051l, 350028213l, 510646205l, 440800612l, 297486818l, 865180578l, 1482070286l, 499516914l, 493974215l, 1801212806l, 296878722l, 263040470l, 370412987l, 2246487468l, 266516752l, 446196451l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1586177536l, 446196451l, TravelType.BIKE, true);
    checkRoute(r0a, 33439.290514691784, 1586177536l, 446196451l);
    computeRoute(1586177536l, 446196451l, TravelType.CAR, false);
    Route r2a = computeRoute(1586177536l, 446196451l, TravelType.FOOT, true);
    checkRoute(r2a, 32630.721506765654, 1586177536l, 446196451l);
    Route r3a = computeRoute(1586177536l, 446196451l, TravelType.ANY, true);
    checkRoute(r3a, 32630.721506765654, 1586177536l, 446196451l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 25);
    checkWaypoints(r3b, 757587.4992519263, waypoints);
}


@Test(timeout = 20000)
public void testRouting27RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 292087423l, 414937302l, 1512916992l, 3447317992l, 1312649552l, 1247375664l, 2449688376l, 3452123305l, 1520343754l, 3345406190l, 2449604050l, 1315139827l, 2382876095l, 567284356l, 339402115l, 431249675l, 1270651413l, 2788603480l, 1727368586l, 1388222586l, 831530912l, 1392516043l, 273446024l, 706621883l, 2805700095l, 309437644l, 1430019803l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(292087423l, 1430019803l, TravelType.BIKE, true);
    checkRoute(r0a, 48945.20980660454, 292087423l, 1430019803l);
    computeRoute(292087423l, 1430019803l, TravelType.CAR, false);
    Route r2a = computeRoute(292087423l, 1430019803l, TravelType.FOOT, true);
    checkRoute(r2a, 47943.17561142783, 292087423l, 1430019803l);
    Route r3a = computeRoute(292087423l, 1430019803l, TravelType.ANY, true);
    checkRoute(r3a, 47799.17986018013, 292087423l, 1430019803l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 26);
    checkWaypoints(r3b, 763848.6037434586, waypoints);
}


@Test(timeout = 20000)
public void testRouting28RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 292746544l, 3016392270l, 918639454l, 316521309l, 410112165l, 2406012608l, 655350115l, 830359381l, 945405117l, 264850255l, 907145698l, 1450863171l, 374388094l, 2964056996l, 290270535l, 351180853l, 473124571l, 1505088980l, 2260599948l, 360388727l, 560975830l, 2114987813l, 432715084l, 2124615854l, 2199532993l, 617989470l, 316854451l, 1504118644l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(292746544l, 1504118644l, TravelType.BIKE, true);
    checkRoute(r0a, 40796.62063347315, 292746544l, 1504118644l);
    computeRoute(292746544l, 1504118644l, TravelType.CAR, false);
    Route r2a = computeRoute(292746544l, 1504118644l, TravelType.FOOT, true);
    checkRoute(r2a, 39272.20182731118, 292746544l, 1504118644l);
    Route r3a = computeRoute(292746544l, 1504118644l, TravelType.ANY, true);
    checkRoute(r3a, 39272.20182731118, 292746544l, 1504118644l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 27);
    checkWaypoints(r3b, 947015.4364576368, waypoints);
}


@Test(timeout = 20000)
public void testRouting29RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 430153927l, 710726031l, 997549016l, 281390449l, 305702933l, 1329323418l, 322993386l, 1221007772l, 267626801l, 2471551217l, 1365447182l, 2962554648l, 262829531l, 318763586l, 2321850330l, 386796056l, 919752649l, 351167966l, 1225674932l, 3066545931l, 2728364377l, 2457377530l, 2075889668l, 430458519l, 963521384l, 269476442l, 1538747699l, 372940601l, 2203903446l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(430153927l, 2203903446l, TravelType.BIKE, false);
    computeRoute(430153927l, 2203903446l, TravelType.CAR, false);
    Route r2a = computeRoute(430153927l, 2203903446l, TravelType.FOOT, true);
    checkRoute(r2a, 18722.772990916164, 430153927l, 2203903446l);
    Route r3a = computeRoute(430153927l, 2203903446l, TravelType.ANY, true);
    checkRoute(r3a, 18722.772990916164, 430153927l, 2203903446l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 28);
    checkWaypoints(r3b, 888082.3739839492, waypoints);
}


@Test(timeout = 20000)
public void testRouting30RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3306483512l, 777996931l, 273502053l, 343444284l, 1144109764l, 278803400l, 835711716l, 286786396l, 393743946l, 618767498l, 2964148539l, 313331286l, 1007606819l, 300034812l, 678564471l, 958544970l, 1861339648l, 312302225l, 395109456l, 1649175761l, 310037018l, 1728783299l, 322051388l, 315139240l, 2136506899l, 703281580l, 2321855656l, 1394545434l, 1237747073l, 354472014l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(3306483512l, 354472014l, TravelType.BIKE, true);
    checkRoute(r0a, 13100.304965394449, 3306483512l, 354472014l);
    computeRoute(3306483512l, 354472014l, TravelType.CAR, false);
    Route r2a = computeRoute(3306483512l, 354472014l, TravelType.FOOT, true);
    checkRoute(r2a, 12934.152346785324, 3306483512l, 354472014l);
    Route r3a = computeRoute(3306483512l, 354472014l, TravelType.ANY, true);
    checkRoute(r3a, 11433.27932410967, 3306483512l, 354472014l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 29);
    checkWaypoints(r2b, 706839.3023090858, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 29);
    checkWaypoints(r3b, 706349.381970557, waypoints);
}


@Test(timeout = 20000)
public void testRouting31RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 341072294l, 759465352l, 672460067l, 2491384078l, 1298154787l, 1334731504l, 408561306l, 492788544l, 1744220424l, 2835269419l, 2506183497l, 421822268l, 1598221859l, 418018688l, 2384953362l, 359963178l, 1267402553l, 388563345l, 506294611l, 339073831l, 267669854l, 758928331l, 350028282l, 1919069061l, 1735109912l, 276928956l, 988067744l, 361508095l, 2464138886l, 1347615983l, 2737387606l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(341072294l, 2737387606l, TravelType.BIKE, true);
    checkRoute(r0a, 20799.415635346973, 341072294l, 2737387606l);
    computeRoute(341072294l, 2737387606l, TravelType.CAR, false);
    Route r2a = computeRoute(341072294l, 2737387606l, TravelType.FOOT, true);
    checkRoute(r2a, 20392.181553658007, 341072294l, 2737387606l);
    Route r3a = computeRoute(341072294l, 2737387606l, TravelType.ANY, true);
    checkRoute(r3a, 20303.79374562715, 341072294l, 2737387606l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 30);
    checkWaypoints(r2b, 890006.4330702358, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 30);
    checkWaypoints(r3b, 888293.5409359239, waypoints);
}


@Test(timeout = 20000)
public void testRouting32RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 259819745l, 440800328l, 387706903l, 261740887l, 457565351l, 309587425l, 1363779563l, 1520262952l, 455533744l, 418784633l, 2962602042l, 415882956l, 302081303l, 1547313441l, 518564769l, 568605931l, 1534218733l, 907056077l, 429288210l, 429905842l, 2599488477l, 271109902l, 443795132l, 457131129l, 1614230963l, 2045093405l, 78815714l, 678590153l, 1352870440l, 395399762l, 285903777l, 1538803828l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(259819745l, 1538803828l, TravelType.BIKE, false);
    Route r1a = computeRoute(259819745l, 1538803828l, TravelType.CAR, true);
    checkRoute(r1a, 64958.26578612889, 259819745l, 1538803828l);
    computeRoute(259819745l, 1538803828l, TravelType.FOOT, false);
    Route r3a = computeRoute(259819745l, 1538803828l, TravelType.ANY, true);
    checkRoute(r3a, 63768.44800392446, 259819745l, 1538803828l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 31);
    checkWaypoints(r3b, 955589.7330115474, waypoints);
}


@Override
public String getMapFileName() {
    return "saarland.osm.nae";
}


}