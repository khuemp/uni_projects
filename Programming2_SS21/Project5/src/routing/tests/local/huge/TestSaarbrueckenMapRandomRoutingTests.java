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
public class TestSaarbrueckenMapRandomRoutingTests extends TestingBase {

@Test(timeout = 3000)
public void testRouting2RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3451523643l, 2260307529l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(3451523643l, 2260307529l, TravelType.BIKE, false);
    computeRoute(3451523643l, 2260307529l, TravelType.CAR, false);
    Route r2a = computeRoute(3451523643l, 2260307529l, TravelType.FOOT, true);
    checkRoute(r2a, 2243.984505968514, 3451523643l, 2260307529l);
    Route r3a = computeRoute(3451523643l, 2260307529l, TravelType.ANY, true);
    checkRoute(r3a, 2243.984505968514, 3451523643l, 2260307529l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 1);
    checkWaypoints(r2b, 2243.984505968514, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 1);
    checkWaypoints(r3b, 2243.984505968514, waypoints);
}


@Test(timeout = 3000)
public void testRouting3RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1381418689l, 1551937707l, 2162382268l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1381418689l, 2162382268l, TravelType.BIKE, false);
    computeRoute(1381418689l, 2162382268l, TravelType.CAR, false);
    Route r2a = computeRoute(1381418689l, 2162382268l, TravelType.FOOT, true);
    checkRoute(r2a, 3182.98121487233, 1381418689l, 2162382268l);
    Route r3a = computeRoute(1381418689l, 2162382268l, TravelType.ANY, true);
    checkRoute(r3a, 3182.98121487233, 1381418689l, 2162382268l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 2);
    checkWaypoints(r2b, 8186.75183533547, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 2);
    checkWaypoints(r3b, 8146.686685526507, waypoints);
}


@Test(timeout = 3000)
public void testRouting4RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1270279265l, 287875999l, 2134646994l, 823700234l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1270279265l, 823700234l, TravelType.BIKE, false);
    computeRoute(1270279265l, 823700234l, TravelType.CAR, false);
    Route r2a = computeRoute(1270279265l, 823700234l, TravelType.FOOT, true);
    checkRoute(r2a, 6420.931500686924, 1270279265l, 823700234l);
    Route r3a = computeRoute(1270279265l, 823700234l, TravelType.ANY, true);
    checkRoute(r3a, 6420.931500686924, 1270279265l, 823700234l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 3);
    checkWaypoints(r2b, 11524.258350906164, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 3);
    checkWaypoints(r3b, 11524.258350906164, waypoints);
}


@Test(timeout = 3000)
public void testRouting5RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2162498104l, 280569592l, 2216411816l, 1388601312l, 1345960214l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2162498104l, 1345960214l, TravelType.BIKE, false);
    computeRoute(2162498104l, 1345960214l, TravelType.CAR, false);
    Route r2a = computeRoute(2162498104l, 1345960214l, TravelType.FOOT, true);
    checkRoute(r2a, 5899.859220677517, 2162498104l, 1345960214l);
    Route r3a = computeRoute(2162498104l, 1345960214l, TravelType.ANY, true);
    checkRoute(r3a, 5899.859220677517, 2162498104l, 1345960214l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 4);
    checkWaypoints(r2b, 24717.158317512185, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 4);
    checkWaypoints(r3b, 24717.158317512185, waypoints);
}


@Test(timeout = 3000)
public void testRouting6RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 313211914l, 797645903l, 313211955l, 274814175l, 319853619l, 1981026725l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(313211914l, 1981026725l, TravelType.BIKE, false);
    computeRoute(313211914l, 1981026725l, TravelType.CAR, false);
    Route r2a = computeRoute(313211914l, 1981026725l, TravelType.FOOT, true);
    checkRoute(r2a, 5164.988553580752, 313211914l, 1981026725l);
    Route r3a = computeRoute(313211914l, 1981026725l, TravelType.ANY, true);
    checkRoute(r3a, 5163.553978348105, 313211914l, 1981026725l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 5);
    checkWaypoints(r2b, 30230.105942509304, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 5);
    checkWaypoints(r3b, 30185.249075543987, waypoints);
}


@Test(timeout = 3000)
public void testRouting7RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1225730614l, 2145288625l, 2234999888l, 1436296924l, 178919575l, 1734971246l, 1653457506l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1225730614l, 1653457506l, TravelType.BIKE, false);
    computeRoute(1225730614l, 1653457506l, TravelType.CAR, false);
    Route r2a = computeRoute(1225730614l, 1653457506l, TravelType.FOOT, true);
    checkRoute(r2a, 6221.562599019606, 1225730614l, 1653457506l);
    Route r3a = computeRoute(1225730614l, 1653457506l, TravelType.ANY, true);
    checkRoute(r3a, 6221.562599019606, 1225730614l, 1653457506l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 6);
    checkWaypoints(r2b, 21021.710594841352, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 6);
    checkWaypoints(r3b, 21021.710594841352, waypoints);
}


@Test(timeout = 3000)
public void testRouting8RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2292566447l, 374382002l, 2285460545l, 1023171051l, 1424436254l, 1676311707l, 1422926333l, 3283890146l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2292566447l, 3283890146l, TravelType.BIKE, false);
    computeRoute(2292566447l, 3283890146l, TravelType.CAR, false);
    Route r2a = computeRoute(2292566447l, 3283890146l, TravelType.FOOT, true);
    checkRoute(r2a, 688.3023396635396, 2292566447l, 3283890146l);
    Route r3a = computeRoute(2292566447l, 3283890146l, TravelType.ANY, true);
    checkRoute(r3a, 688.3023396635396, 2292566447l, 3283890146l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 7);
    checkWaypoints(r2b, 39043.986686457865, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 7);
    checkWaypoints(r3b, 39042.003223213476, waypoints);
}


@Test(timeout = 3000)
public void testRouting9RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1389281483l, 1157780361l, 1034350030l, 1580728663l, 1376499852l, 1935266673l, 703267753l, 262671765l, 1501845702l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1389281483l, 1501845702l, TravelType.BIKE, false);
    computeRoute(1389281483l, 1501845702l, TravelType.CAR, false);
    Route r2a = computeRoute(1389281483l, 1501845702l, TravelType.FOOT, true);
    checkRoute(r2a, 10956.38459943823, 1389281483l, 1501845702l);
    Route r3a = computeRoute(1389281483l, 1501845702l, TravelType.ANY, true);
    checkRoute(r3a, 10951.007729169372, 1389281483l, 1501845702l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 8);
    checkWaypoints(r3b, 29381.855171714815, waypoints);
}


@Test(timeout = 3000)
public void testRouting10RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2462714231l, 299316145l, 663649223l, 291353052l, 1551719396l, 3419934801l, 263875937l, 298159330l, 1281411632l, 112433038l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2462714231l, 112433038l, TravelType.BIKE, false);
    computeRoute(2462714231l, 112433038l, TravelType.CAR, false);
    Route r2a = computeRoute(2462714231l, 112433038l, TravelType.FOOT, true);
    checkRoute(r2a, 1859.998587774308, 2462714231l, 112433038l);
    Route r3a = computeRoute(2462714231l, 112433038l, TravelType.ANY, true);
    checkRoute(r3a, 1859.998587774308, 2462714231l, 112433038l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 9);
    checkWaypoints(r2b, 41683.44786359973, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 9);
    checkWaypoints(r3b, 41681.73611143478, waypoints);
}


@Test(timeout = 3000)
public void testRouting11RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 446272095l, 455620281l, 1756623825l, 322992724l, 3455224486l, 299316099l, 610892992l, 779750758l, 263876862l, 1321460890l, 797645918l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(446272095l, 797645918l, TravelType.BIKE, true);
    checkRoute(r0a, 5787.813088218567, 446272095l, 797645918l);
    computeRoute(446272095l, 797645918l, TravelType.CAR, false);
    Route r2a = computeRoute(446272095l, 797645918l, TravelType.FOOT, true);
    checkRoute(r2a, 4062.583114476861, 446272095l, 797645918l);
    Route r3a = computeRoute(446272095l, 797645918l, TravelType.ANY, true);
    checkRoute(r3a, 4062.583114476861, 446272095l, 797645918l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 10);
    checkWaypoints(r2b, 50654.67381351911, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 10);
    checkWaypoints(r3b, 50647.54494668555, waypoints);
}


@Test(timeout = 3000)
public void testRouting12RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 320495136l, 472447572l, 2889752311l, 1327605185l, 2926486118l, 1654313461l, 661117071l, 1422926612l, 2274250934l, 156936050l, 266653584l, 263875954l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(320495136l, 263875954l, TravelType.BIKE, true);
    checkRoute(r0a, 9715.048603434368, 320495136l, 263875954l);
    Route r1a = computeRoute(320495136l, 263875954l, TravelType.CAR, true);
    checkRoute(r1a, 11396.28417384886, 320495136l, 263875954l);
    Route r2a = computeRoute(320495136l, 263875954l, TravelType.FOOT, true);
    checkRoute(r2a, 9450.242852813502, 320495136l, 263875954l);
    Route r3a = computeRoute(320495136l, 263875954l, TravelType.ANY, true);
    checkRoute(r3a, 9448.837584880792, 320495136l, 263875954l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 11);
    checkWaypoints(r2b, 46898.03435936919, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 11);
    checkWaypoints(r3b, 46715.48915260046, waypoints);
}


@Test(timeout = 3000)
public void testRouting13RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2216318009l, 318921869l, 2146284584l, 1559582742l, 1990692904l, 1401195769l, 1263141989l, 252319921l, 324406395l, 1388292285l, 2232445223l, 513675046l, 703267775l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2216318009l, 703267775l, TravelType.BIKE, false);
    computeRoute(2216318009l, 703267775l, TravelType.CAR, false);
    Route r2a = computeRoute(2216318009l, 703267775l, TravelType.FOOT, true);
    checkRoute(r2a, 3790.3853379109028, 2216318009l, 703267775l);
    Route r3a = computeRoute(2216318009l, 703267775l, TravelType.ANY, true);
    checkRoute(r3a, 3790.3853379109028, 2216318009l, 703267775l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 12);
    checkWaypoints(r3b, 48531.12896712464, waypoints);
}


@Test(timeout = 3000)
public void testRouting14RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 666802989l, 1368738585l, 432714908l, 1504154062l, 1558424853l, 1368339208l, 1388929030l, 316522159l, 1389391027l, 157077978l, 784650241l, 267041498l, 2444648761l, 2146658806l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(666802989l, 2146658806l, TravelType.BIKE, true);
    checkRoute(r0a, 1210.0586171435652, 666802989l, 2146658806l);
    computeRoute(666802989l, 2146658806l, TravelType.CAR, false);
    Route r2a = computeRoute(666802989l, 2146658806l, TravelType.FOOT, true);
    checkRoute(r2a, 1198.527286298737, 666802989l, 2146658806l);
    Route r3a = computeRoute(666802989l, 2146658806l, TravelType.ANY, true);
    checkRoute(r3a, 1198.527286298737, 666802989l, 2146658806l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 13);
    checkWaypoints(r2b, 71056.57170435111, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 13);
    checkWaypoints(r3b, 71052.81364643543, waypoints);
}


@Test(timeout = 3000)
public void testRouting15RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1670293247l, 1039316089l, 895722331l, 1270234513l, 415795033l, 1423923967l, 1184692339l, 2146402460l, 281591053l, 639125701l, 893127300l, 1539371847l, 178903539l, 1580688704l, 1550994623l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1670293247l, 1550994623l, TravelType.BIKE, true);
    checkRoute(r0a, 4935.422749687875, 1670293247l, 1550994623l);
    computeRoute(1670293247l, 1550994623l, TravelType.CAR, false);
    Route r2a = computeRoute(1670293247l, 1550994623l, TravelType.FOOT, true);
    checkRoute(r2a, 4241.9114571540795, 1670293247l, 1550994623l);
    Route r3a = computeRoute(1670293247l, 1550994623l, TravelType.ANY, true);
    checkRoute(r3a, 4241.9114571540795, 1670293247l, 1550994623l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 14);
    checkWaypoints(r3b, 83212.65210675409, waypoints);
}


@Test(timeout = 3000)
public void testRouting16RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2291553673l, 997708221l, 1373613411l, 1404343133l, 3455290026l, 266648748l, 610892989l, 3452114815l, 2146303250l, 1240257632l, 1327913388l, 2291418101l, 1139330826l, 2146402484l, 261019495l, 1268032492l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2291553673l, 1268032492l, TravelType.BIKE, false);
    computeRoute(2291553673l, 1268032492l, TravelType.CAR, false);
    Route r2a = computeRoute(2291553673l, 1268032492l, TravelType.FOOT, true);
    checkRoute(r2a, 1263.9140159796177, 2291553673l, 1268032492l);
    Route r3a = computeRoute(2291553673l, 1268032492l, TravelType.ANY, true);
    checkRoute(r3a, 1263.9140159796177, 2291553673l, 1268032492l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 15);
    checkWaypoints(r2b, 61578.670881571205, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 15);
    checkWaypoints(r3b, 61219.36478278409, waypoints);
}


@Test(timeout = 3000)
public void testRouting17RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 271054927l, 3451634302l, 560137465l, 344240640l, 639125651l, 2248745961l, 3467077786l, 2234549740l, 1389385638l, 297515255l, 427009939l, 804034328l, 310137685l, 349881784l, 178993823l, 374384944l, 1327917836l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(271054927l, 1327917836l, TravelType.BIKE, true);
    checkRoute(r0a, 2873.8160456679975, 271054927l, 1327917836l);
    Route r1a = computeRoute(271054927l, 1327917836l, TravelType.CAR, true);
    checkRoute(r1a, 3013.4636374714137, 271054927l, 1327917836l);
    Route r2a = computeRoute(271054927l, 1327917836l, TravelType.FOOT, true);
    checkRoute(r2a, 2548.658458945812, 271054927l, 1327917836l);
    Route r3a = computeRoute(271054927l, 1327917836l, TravelType.ANY, true);
    checkRoute(r3a, 2548.658458945812, 271054927l, 1327917836l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 16);
    checkWaypoints(r2b, 59469.39550986669, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 16);
    checkWaypoints(r3b, 59450.54148230443, waypoints);
}


@Test(timeout = 3000)
public void testRouting18RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 259035215l, 1077033009l, 3249259916l, 410228986l, 1315139594l, 324406460l, 989228166l, 1582352670l, 1509634478l, 2889703495l, 1392376551l, 1042369726l, 167169111l, 435641864l, 261040314l, 506454302l, 1374679238l, 383764019l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(259035215l, 383764019l, TravelType.BIKE, false);
    computeRoute(259035215l, 383764019l, TravelType.CAR, false);
    Route r2a = computeRoute(259035215l, 383764019l, TravelType.FOOT, true);
    checkRoute(r2a, 5367.7971801271415, 259035215l, 383764019l);
    Route r3a = computeRoute(259035215l, 383764019l, TravelType.ANY, true);
    checkRoute(r3a, 5367.7971801271415, 259035215l, 383764019l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 17);
    checkWaypoints(r2b, 69512.9199236481, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 17);
    checkWaypoints(r3b, 69496.38259296963, waypoints);
}


@Test(timeout = 3000)
public void testRouting19RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1520395014l, 417949795l, 1263141996l, 427009728l, 1391332365l, 2198314237l, 1550994661l, 2278345333l, 389949053l, 618767494l, 1112607106l, 1425533841l, 1853981722l, 1272869363l, 1392097618l, 322602006l, 427009536l, 294864810l, 1270364235l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1520395014l, 1270364235l, TravelType.BIKE, false);
    computeRoute(1520395014l, 1270364235l, TravelType.CAR, false);
    Route r2a = computeRoute(1520395014l, 1270364235l, TravelType.FOOT, true);
    checkRoute(r2a, 4186.051577787296, 1520395014l, 1270364235l);
    Route r3a = computeRoute(1520395014l, 1270364235l, TravelType.ANY, true);
    checkRoute(r3a, 4186.051577787296, 1520395014l, 1270364235l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 18);
    checkWaypoints(r3b, 83596.07935185358, waypoints);
}


@Test(timeout = 3000)
public void testRouting20RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2282478542l, 1050877034l, 2721990510l, 2288467797l, 281384878l, 412742769l, 3451523627l, 283245323l, 1751470489l, 293863142l, 2291806776l, 1551953919l, 1535754821l, 1373516577l, 374402395l, 3454461062l, 3246037892l, 1444992598l, 1558424881l, 1504064602l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2282478542l, 1504064602l, TravelType.BIKE, false);
    computeRoute(2282478542l, 1504064602l, TravelType.CAR, false);
    Route r2a = computeRoute(2282478542l, 1504064602l, TravelType.FOOT, true);
    checkRoute(r2a, 3422.1141158753494, 2282478542l, 1504064602l);
    Route r3a = computeRoute(2282478542l, 1504064602l, TravelType.ANY, true);
    checkRoute(r3a, 3422.1141158753494, 2282478542l, 1504064602l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 19);
    checkWaypoints(r2b, 78508.71484221613, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 19);
    checkWaypoints(r3b, 78503.66130325072, waypoints);
}


@Test(timeout = 3000)
public void testRouting21RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1052013011l, 297736131l, 374403256l, 1291360341l, 1267045034l, 162978202l, 262881774l, 1269089970l, 1266981711l, 1547766215l, 508304024l, 1558470690l, 704434334l, 374402008l, 1610659935l, 2505278354l, 263046138l, 1395833285l, 1670226055l, 108381706l, 2505260007l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1052013011l, 2505260007l, TravelType.BIKE, false);
    computeRoute(1052013011l, 2505260007l, TravelType.CAR, false);
    Route r2a = computeRoute(1052013011l, 2505260007l, TravelType.FOOT, true);
    checkRoute(r2a, 5579.565421288135, 1052013011l, 2505260007l);
    Route r3a = computeRoute(1052013011l, 2505260007l, TravelType.ANY, true);
    checkRoute(r3a, 5578.166314800315, 1052013011l, 2505260007l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 20);
    checkWaypoints(r3b, 92035.59213266536, waypoints);
}


@Test(timeout = 3000)
public void testRouting22RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1268590214l, 366931798l, 1111849254l, 1278177208l, 1374477416l, 1409585780l, 427637494l, 262665165l, 257727282l, 3452128141l, 1225687086l, 301432435l, 297991961l, 266653473l, 797645898l, 703267752l, 295101187l, 374392866l, 1382935162l, 269466071l, 1184695186l, 1267925985l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1268590214l, 1267925985l, TravelType.BIKE, false);
    computeRoute(1268590214l, 1267925985l, TravelType.CAR, false);
    Route r2a = computeRoute(1268590214l, 1267925985l, TravelType.FOOT, true);
    checkRoute(r2a, 2712.062947701291, 1268590214l, 1267925985l);
    Route r3a = computeRoute(1268590214l, 1267925985l, TravelType.ANY, true);
    checkRoute(r3a, 2712.062947701291, 1268590214l, 1267925985l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 21);
    checkWaypoints(r3b, 91518.41430314996, waypoints);
}


@Test(timeout = 3000)
public void testRouting23RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1501259882l, 364362280l, 1225683850l, 1372569467l, 3283890372l, 498793929l, 814132423l, 3451512776l, 804679746l, 2282914697l, 1507336781l, 2144833952l, 1756623828l, 1373631119l, 2300468212l, 430281400l, 470215250l, 1614258788l, 3309228680l, 1346009478l, 401359712l, 1335524148l, 271054600l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1501259882l, 271054600l, TravelType.BIKE, true);
    checkRoute(r0a, 1686.0044868099735, 1501259882l, 271054600l);
    Route r1a = computeRoute(1501259882l, 271054600l, TravelType.CAR, true);
    checkRoute(r1a, 1711.0221925932838, 1501259882l, 271054600l);
    Route r2a = computeRoute(1501259882l, 271054600l, TravelType.FOOT, true);
    checkRoute(r2a, 1626.3944276012803, 1501259882l, 271054600l);
    Route r3a = computeRoute(1501259882l, 271054600l, TravelType.ANY, true);
    checkRoute(r3a, 1626.3944276012803, 1501259882l, 271054600l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 22);
    checkWaypoints(r2b, 95356.18492026647, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 22);
    checkWaypoints(r3b, 94801.33262803206, waypoints);
}


@Test(timeout = 3000)
public void testRouting24RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 274813184l, 1808643087l, 115946264l, 279897266l, 1375458190l, 1504064613l, 2288307163l, 368319768l, 297515246l, 446271988l, 3282143803l, 162977096l, 2145288704l, 2143191813l, 1392122661l, 1270157537l, 2028046898l, 1268599575l, 294835644l, 322993351l, 1324607657l, 256603131l, 1347290762l, 784650305l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(274813184l, 784650305l, TravelType.BIKE, true);
    checkRoute(r0a, 6966.471088063391, 274813184l, 784650305l);
    computeRoute(274813184l, 784650305l, TravelType.CAR, false);
    Route r2a = computeRoute(274813184l, 784650305l, TravelType.FOOT, true);
    checkRoute(r2a, 6691.397511849428, 274813184l, 784650305l);
    Route r3a = computeRoute(274813184l, 784650305l, TravelType.ANY, true);
    checkRoute(r3a, 6691.397511849428, 274813184l, 784650305l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 23);
    checkWaypoints(r3b, 97925.11381358394, waypoints);
}


@Test(timeout = 3000)
public void testRouting25RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1558470710l, 618927472l, 1684858479l, 869341547l, 2948502179l, 2287058382l, 297736121l, 2278297886l, 1391992968l, 1392073661l, 417949764l, 2271713715l, 1346009499l, 667380331l, 2889642099l, 2027803194l, 1552007176l, 2199218459l, 837542592l, 417401116l, 2282845172l, 1425404747l, 374403354l, 814806355l, 349869652l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1558470710l, 349869652l, TravelType.BIKE, true);
    checkRoute(r0a, 8623.28236922375, 1558470710l, 349869652l);
    Route r1a = computeRoute(1558470710l, 349869652l, TravelType.CAR, true);
    checkRoute(r1a, 9334.954875747413, 1558470710l, 349869652l);
    Route r2a = computeRoute(1558470710l, 349869652l, TravelType.FOOT, true);
    checkRoute(r2a, 8261.375970298708, 1558470710l, 349869652l);
    Route r3a = computeRoute(1558470710l, 349869652l, TravelType.ANY, true);
    checkRoute(r3a, 8261.375970298708, 1558470710l, 349869652l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 24);
    checkWaypoints(r2b, 101080.90686432752, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 24);
    checkWaypoints(r3b, 101076.25093029276, waypoints);
}


@Test(timeout = 3000)
public void testRouting26RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3076580396l, 1390041187l, 2505278352l, 1524457340l, 1580795290l, 1290686745l, 886194006l, 1550366202l, 2270406204l, 2145180051l, 1389385607l, 291248586l, 402850989l, 404467955l, 3467126179l, 1699758818l, 324422538l, 374384131l, 1808643099l, 2962755857l, 2282442872l, 156864705l, 2278767546l, 2283360340l, 1324650499l, 1139330867l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(3076580396l, 1139330867l, TravelType.BIKE, true);
    checkRoute(r0a, 9489.786610180463, 3076580396l, 1139330867l);
    computeRoute(3076580396l, 1139330867l, TravelType.CAR, false);
    Route r2a = computeRoute(3076580396l, 1139330867l, TravelType.FOOT, true);
    checkRoute(r2a, 8748.292513759658, 3076580396l, 1139330867l);
    Route r3a = computeRoute(3076580396l, 1139330867l, TravelType.ANY, true);
    checkRoute(r3a, 8748.292513759658, 3076580396l, 1139330867l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 25);
    checkWaypoints(r2b, 106889.43153937478, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 25);
    checkWaypoints(r3b, 106866.45773180536, waypoints);
}


@Test(timeout = 3000)
public void testRouting27RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 289243670l, 3455218468l, 316522138l, 1582370836l, 2278702132l, 280569899l, 294888837l, 178885915l, 374382874l, 1551884012l, 997968171l, 1756488799l, 254400941l, 1392511722l, 316522130l, 427624037l, 1388481913l, 1123670892l, 1403452945l, 1670293050l, 1389281482l, 278126261l, 169483280l, 2283355210l, 1157780347l, 2174768479l, 167170376l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(289243670l, 167170376l, TravelType.BIKE, true);
    checkRoute(r0a, 5499.8102721191335, 289243670l, 167170376l);
    computeRoute(289243670l, 167170376l, TravelType.CAR, false);
    Route r2a = computeRoute(289243670l, 167170376l, TravelType.FOOT, true);
    checkRoute(r2a, 5049.294701155716, 289243670l, 167170376l);
    Route r3a = computeRoute(289243670l, 167170376l, TravelType.ANY, true);
    checkRoute(r3a, 5049.294701155716, 289243670l, 167170376l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 26);
    checkWaypoints(r3b, 120029.2795884106, waypoints);
}


@Test(timeout = 3000)
public void testRouting28RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1551977032l, 1267557676l, 2145420243l, 1389281433l, 1267890145l, 364096672l, 1853235108l, 1580035032l, 797645915l, 178920000l, 1386013695l, 295718007l, 1394545442l, 1393464490l, 1382907948l, 902759529l, 1504154141l, 427040581l, 2634157024l, 427040576l, 1270374379l, 1698368061l, 997708260l, 1383259004l, 2291448862l, 1352831466l, 1041072251l, 1382841955l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1551977032l, 1382841955l, TravelType.BIKE, false);
    computeRoute(1551977032l, 1382841955l, TravelType.CAR, false);
    Route r2a = computeRoute(1551977032l, 1382841955l, TravelType.FOOT, true);
    checkRoute(r2a, 3513.581946618972, 1551977032l, 1382841955l);
    Route r3a = computeRoute(1551977032l, 1382841955l, TravelType.ANY, true);
    checkRoute(r3a, 3513.581946618972, 1551977032l, 1382841955l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 27);
    checkWaypoints(r2b, 117283.13389018337, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 27);
    checkWaypoints(r3b, 117110.1841908548, waypoints);
}


@Test(timeout = 3000)
public void testRouting29RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1385930685l, 1582359040l, 157409592l, 989228109l, 1270094546l, 2162444706l, 2279710767l, 1389492781l, 271343088l, 3455290028l, 1552899945l, 2291757006l, 155519598l, 298196920l, 1551921768l, 332340905l, 869341566l, 703281564l, 1270177479l, 2027834446l, 2259805127l, 2146643878l, 2999874726l, 1389306876l, 1392066768l, 1424436135l, 1552007132l, 2232445221l, 2326136109l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1385930685l, 2326136109l, TravelType.BIKE, false);
    computeRoute(1385930685l, 2326136109l, TravelType.CAR, false);
    Route r2a = computeRoute(1385930685l, 2326136109l, TravelType.FOOT, true);
    checkRoute(r2a, 4175.7540858705, 1385930685l, 2326136109l);
    Route r3a = computeRoute(1385930685l, 2326136109l, TravelType.ANY, true);
    checkRoute(r3a, 4175.7540858705, 1385930685l, 2326136109l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 28);
    checkWaypoints(r2b, 103403.29937566498, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 28);
    checkWaypoints(r3b, 103359.61601622183, waypoints);
}


@Test(timeout = 3000)
public void testRouting30RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1392996255l, 2028018795l, 1225689699l, 649072444l, 3454143558l, 2205453619l, 2444648765l, 924215382l, 2134775716l, 1388467603l, 2228491447l, 262887497l, 1551884007l, 297515246l, 2145165199l, 1267354206l, 1388222551l, 1388273621l, 2291851330l, 413715099l, 108382480l, 1424436594l, 374377460l, 322993505l, 1394768081l, 108381322l, 1551996335l, 1388134569l, 2282370404l, 1393982822l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1392996255l, 1393982822l, TravelType.BIKE, true);
    checkRoute(r0a, 2353.2849852577006, 1392996255l, 1393982822l);
    Route r1a = computeRoute(1392996255l, 1393982822l, TravelType.CAR, true);
    checkRoute(r1a, 2408.4913790242326, 1392996255l, 1393982822l);
    Route r2a = computeRoute(1392996255l, 1393982822l, TravelType.FOOT, true);
    checkRoute(r2a, 1971.9270413018037, 1392996255l, 1393982822l);
    Route r3a = computeRoute(1392996255l, 1393982822l, TravelType.ANY, true);
    checkRoute(r3a, 1971.9270413018037, 1392996255l, 1393982822l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 29);
    checkWaypoints(r3b, 109915.54780646291, waypoints);
}


@Test(timeout = 3000)
public void testRouting31RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1426600893l, 1270236835l, 262173025l, 1670310309l, 2134756753l, 1426600931l, 826186168l, 2284654423l, 1551885826l, 1552007137l, 1387548795l, 429503721l, 807653913l, 389908175l, 1267863071l, 257727129l, 778167167l, 997963397l, 1282702701l, 2933057272l, 2278352422l, 273455413l, 322993360l, 1551882222l, 2145434865l, 298196955l, 342783787l, 609761031l, 290718961l, 157436726l, 1504131796l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1426600893l, 1504131796l, TravelType.BIKE, true);
    checkRoute(r0a, 5649.509917440077, 1426600893l, 1504131796l);
    computeRoute(1426600893l, 1504131796l, TravelType.CAR, false);
    Route r2a = computeRoute(1426600893l, 1504131796l, TravelType.FOOT, true);
    checkRoute(r2a, 5649.509917440077, 1426600893l, 1504131796l);
    Route r3a = computeRoute(1426600893l, 1504131796l, TravelType.ANY, true);
    checkRoute(r3a, 5649.509917440077, 1426600893l, 1504131796l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 30);
    checkWaypoints(r3b, 91983.32091605892, waypoints);
}


@Test(timeout = 3000)
public void testRouting32RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1269179745l, 596510296l, 278788922l, 2291586723l, 273455404l, 2284550259l, 319853637l, 979367181l, 264464930l, 1269157619l, 1392117617l, 2283355196l, 1281108395l, 1287613848l, 3455253308l, 1374048103l, 1559582726l, 2145155941l, 1270541243l, 327240634l, 322993371l, 703286334l, 3451636287l, 2999874724l, 1396398205l, 481247719l, 2291586737l, 352906787l, 2271704461l, 705152345l, 1403184064l, 1425533845l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1269179745l, 1425533845l, TravelType.BIKE, false);
    computeRoute(1269179745l, 1425533845l, TravelType.CAR, false);
    Route r2a = computeRoute(1269179745l, 1425533845l, TravelType.FOOT, true);
    checkRoute(r2a, 8311.64989774878, 1269179745l, 1425533845l);
    Route r3a = computeRoute(1269179745l, 1425533845l, TravelType.ANY, true);
    checkRoute(r3a, 8311.64989774878, 1269179745l, 1425533845l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 31);
    checkWaypoints(r2b, 140951.1406378634, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 31);
    checkWaypoints(r3b, 140830.2374623625, waypoints);
}


@Override
public String getMapFileName() {
    return "saarbruecken.osm.nae";
}


}