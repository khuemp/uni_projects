package routing.tests.local.fast;

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
public class TestCampusMapRandomRoutingTests extends TestingBase {

@Test(timeout = 1000)
public void testRouting2RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1139485988l, 1422926313l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1139485988l, 1422926313l, TravelType.BIKE, false);
    computeRoute(1139485988l, 1422926313l, TravelType.CAR, false);
    Route r2a = computeRoute(1139485988l, 1422926313l, TravelType.FOOT, true);
    checkRoute(r2a, 2628.103218886209, 1139485988l, 1422926313l);
    Route r3a = computeRoute(1139485988l, 1422926313l, TravelType.ANY, true);
    checkRoute(r3a, 2628.103218886209, 1139485988l, 1422926313l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 1);
    checkWaypoints(r2b, 2628.103218886209, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 1);
    checkWaypoints(r3b, 2628.103218886209, waypoints);
}


@Test(timeout = 1000)
public void testRouting3RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1559033731l, 1309264720l, 374398474l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1559033731l, 374398474l, TravelType.BIKE, true);
    checkRoute(r0a, 634.6874137685676, 1559033731l, 374398474l);
    computeRoute(1559033731l, 374398474l, TravelType.CAR, false);
    Route r2a = computeRoute(1559033731l, 374398474l, TravelType.FOOT, true);
    checkRoute(r2a, 634.6874137685676, 1559033731l, 374398474l);
    Route r3a = computeRoute(1559033731l, 374398474l, TravelType.ANY, true);
    checkRoute(r3a, 634.6874137685676, 1559033731l, 374398474l);
    Route r0b = computeRoute(waypointsList, TravelType.BIKE, true);
    assertEquals("Route did not have waypoints many legs", r0b.size(), 2);
    checkWaypoints(r0b, 634.6874137685675, waypoints);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 2);
    checkWaypoints(r2b, 634.6874137685675, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 2);
    checkWaypoints(r3b, 634.6874137685675, waypoints);
}


@Test(timeout = 1000)
public void testRouting4RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 295136544l, 2962747392l, 374392231l, 384641282l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(295136544l, 384641282l, TravelType.BIKE, false);
    computeRoute(295136544l, 384641282l, TravelType.CAR, false);
    Route r2a = computeRoute(295136544l, 384641282l, TravelType.FOOT, true);
    checkRoute(r2a, 3276.1056396350014, 295136544l, 384641282l);
    Route r3a = computeRoute(295136544l, 384641282l, TravelType.ANY, true);
    checkRoute(r3a, 3276.1056396350014, 295136544l, 384641282l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 3);
    checkWaypoints(r2b, 6423.817608619176, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 3);
    checkWaypoints(r3b, 6423.817608619176, waypoints);
}


@Test(timeout = 1000)
public void testRouting5RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 401359711l, 1391329181l, 1289529875l, 256603106l, 1424435910l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(401359711l, 1424435910l, TravelType.BIKE, false);
    computeRoute(401359711l, 1424435910l, TravelType.CAR, false);
    Route r2a = computeRoute(401359711l, 1424435910l, TravelType.FOOT, true);
    checkRoute(r2a, 890.9104473359242, 401359711l, 1424435910l);
    Route r3a = computeRoute(401359711l, 1424435910l, TravelType.ANY, true);
    checkRoute(r3a, 890.9104473359242, 401359711l, 1424435910l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 4);
    checkWaypoints(r2b, 4075.641290860166, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 4);
    checkWaypoints(r3b, 4074.88710574803, waypoints);
}


@Test(timeout = 1000)
public void testRouting6RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 105825800l, 784627891l, 1558424921l, 292134474l, 1391280231l, 324406131l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(105825800l, 324406131l, TravelType.BIKE, true);
    checkRoute(r0a, 3812.53392300134, 105825800l, 324406131l);
    computeRoute(105825800l, 324406131l, TravelType.CAR, false);
    Route r2a = computeRoute(105825800l, 324406131l, TravelType.FOOT, true);
    checkRoute(r2a, 3287.9857131082626, 105825800l, 324406131l);
    Route r3a = computeRoute(105825800l, 324406131l, TravelType.ANY, true);
    checkRoute(r3a, 3287.9857131082626, 105825800l, 324406131l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 5);
    checkWaypoints(r2b, 5012.842907145255, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 5);
    checkWaypoints(r3b, 5012.842907145255, waypoints);
}


@Test(timeout = 1000)
public void testRouting7RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 643709813l, 295136284l, 1422926667l, 374382410l, 105825555l, 704434353l, 1424436080l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(643709813l, 1424436080l, TravelType.BIKE, true);
    checkRoute(r0a, 1684.465502501245, 643709813l, 1424436080l);
    computeRoute(643709813l, 1424436080l, TravelType.CAR, false);
    Route r2a = computeRoute(643709813l, 1424436080l, TravelType.FOOT, true);
    checkRoute(r2a, 1220.385362540938, 643709813l, 1424436080l);
    Route r3a = computeRoute(643709813l, 1424436080l, TravelType.ANY, true);
    checkRoute(r3a, 1220.385362540938, 643709813l, 1424436080l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 6);
    checkWaypoints(r2b, 9883.640329558824, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 6);
    checkWaypoints(r3b, 9881.454477388295, waypoints);
}


@Test(timeout = 1000)
public void testRouting8RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374376145l, 279897251l, 254511516l, 1422926215l, 344240689l, 2962755882l, 374392218l, 1558424962l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(374376145l, 1558424962l, TravelType.BIKE, false);
    computeRoute(374376145l, 1558424962l, TravelType.CAR, false);
    Route r2a = computeRoute(374376145l, 1558424962l, TravelType.FOOT, true);
    checkRoute(r2a, 2360.089010423251, 374376145l, 1558424962l);
    Route r3a = computeRoute(374376145l, 1558424962l, TravelType.ANY, true);
    checkRoute(r3a, 2360.089010423251, 374376145l, 1558424962l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 7);
    checkWaypoints(r2b, 9186.81113001684, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 7);
    checkWaypoints(r3b, 9186.81113001684, waypoints);
}


@Test(timeout = 1000)
public void testRouting9RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 401505795l, 1700040402l, 384641274l, 374382978l, 2489113113l, 384641306l, 704434385l, 1422926793l, 1422926585l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(401505795l, 1422926585l, TravelType.BIKE, false);
    computeRoute(401505795l, 1422926585l, TravelType.CAR, false);
    Route r2a = computeRoute(401505795l, 1422926585l, TravelType.FOOT, true);
    checkRoute(r2a, 1506.4441077517483, 401505795l, 1422926585l);
    Route r3a = computeRoute(401505795l, 1422926585l, TravelType.ANY, true);
    checkRoute(r3a, 1499.2079407841406, 401505795l, 1422926585l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 8);
    checkWaypoints(r2b, 16763.35634012943, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 8);
    checkWaypoints(r3b, 16762.60294784816, waypoints);
}


@Test(timeout = 1000)
public void testRouting10RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 417401174l, 784650283l, 1035552863l, 401359085l, 1422926914l, 1422926653l, 784650246l, 438221422l, 292133957l, 823700208l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(417401174l, 823700208l, TravelType.BIKE, false);
    computeRoute(417401174l, 823700208l, TravelType.CAR, false);
    Route r2a = computeRoute(417401174l, 823700208l, TravelType.FOOT, true);
    checkRoute(r2a, 2592.6220067501154, 417401174l, 823700208l);
    Route r3a = computeRoute(417401174l, 823700208l, TravelType.ANY, true);
    checkRoute(r3a, 2592.6220067501154, 417401174l, 823700208l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 9);
    checkWaypoints(r3b, 15012.798630383415, waypoints);
}


@Test(timeout = 1000)
public void testRouting11RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374382966l, 104591459l, 374376112l, 1914458683l, 784650299l, 375768662l, 1422926213l, 1698384739l, 344240697l, 704434399l, 784650326l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374382966l, 784650326l, TravelType.BIKE, true);
    checkRoute(r0a, 2363.884544212425, 374382966l, 784650326l);
    computeRoute(374382966l, 784650326l, TravelType.CAR, false);
    Route r2a = computeRoute(374382966l, 784650326l, TravelType.FOOT, true);
    checkRoute(r2a, 1725.0028344883995, 374382966l, 784650326l);
    Route r3a = computeRoute(374382966l, 784650326l, TravelType.ANY, true);
    checkRoute(r3a, 1725.0028344883995, 374382966l, 784650326l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 10);
    checkWaypoints(r2b, 11552.643529200672, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 10);
    checkWaypoints(r3b, 11551.889344088537, waypoints);
}


@Test(timeout = 1000)
public void testRouting12RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1698370321l, 1698343699l, 360322968l, 324406383l, 1035351720l, 2425479734l, 374385255l, 417401101l, 441616659l, 1700009877l, 104591447l, 1298564996l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1698370321l, 1298564996l, TravelType.BIKE, true);
    checkRoute(r0a, 3334.626845681578, 1698370321l, 1298564996l);
    computeRoute(1698370321l, 1298564996l, TravelType.CAR, false);
    Route r2a = computeRoute(1698370321l, 1298564996l, TravelType.FOOT, true);
    checkRoute(r2a, 2842.086201855125, 1698370321l, 1298564996l);
    Route r3a = computeRoute(1698370321l, 1298564996l, TravelType.ANY, true);
    checkRoute(r3a, 2842.086201855125, 1698370321l, 1298564996l);
    Route r0b = computeRoute(waypointsList, TravelType.BIKE, true);
    assertEquals("Route did not have waypoints many legs", r0b.size(), 11);
    checkWaypoints(r0b, 18698.53747309837, waypoints);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 11);
    checkWaypoints(r2b, 13536.18869369839, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 11);
    checkWaypoints(r3b, 13536.18869369839, waypoints);
}


@Test(timeout = 1000)
public void testRouting13RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1391280222l, 156965317l, 704434320l, 823700260l, 1422926635l, 374384926l, 267628545l, 1422926092l, 332083198l, 1559033698l, 1391280147l, 1422926601l, 441618521l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1391280222l, 441618521l, TravelType.BIKE, false);
    computeRoute(1391280222l, 441618521l, TravelType.CAR, false);
    Route r2a = computeRoute(1391280222l, 441618521l, TravelType.FOOT, true);
    checkRoute(r2a, 929.6109575030404, 1391280222l, 441618521l);
    Route r3a = computeRoute(1391280222l, 441618521l, TravelType.ANY, true);
    checkRoute(r3a, 929.6109575030404, 1391280222l, 441618521l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 12);
    checkWaypoints(r2b, 19751.00265584022, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 12);
    checkWaypoints(r3b, 19743.579414428856, waypoints);
}


@Test(timeout = 1000)
public void testRouting14RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 784650302l, 733220968l, 1422926424l, 441617447l, 1502128180l, 1422926621l, 417401190l, 2458446112l, 1026109915l, 698533322l, 374379064l, 374382978l, 3024386490l, 1391317079l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(784650302l, 1391317079l, TravelType.BIKE, true);
    checkRoute(r0a, 918.1927622016403, 784650302l, 1391317079l);
    computeRoute(784650302l, 1391317079l, TravelType.CAR, false);
    Route r2a = computeRoute(784650302l, 1391317079l, TravelType.FOOT, true);
    checkRoute(r2a, 874.7978919910951, 784650302l, 1391317079l);
    Route r3a = computeRoute(784650302l, 1391317079l, TravelType.ANY, true);
    checkRoute(r3a, 874.7978919910951, 784650302l, 1391317079l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 13);
    checkWaypoints(r2b, 16027.354524531049, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 13);
    checkWaypoints(r3b, 15992.350288359281, waypoints);
}


@Test(timeout = 1000)
public void testRouting15RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 417401126l, 1422926791l, 374377072l, 374385296l, 1324588185l, 1391319382l, 784627800l, 493962581l, 332083230l, 105825800l, 1391317083l, 946846210l, 1422926629l, 2384341055l, 374376460l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(417401126l, 374376460l, TravelType.BIKE, true);
    checkRoute(r0a, 1993.2213682050672, 417401126l, 374376460l);
    computeRoute(417401126l, 374376460l, TravelType.CAR, false);
    Route r2a = computeRoute(417401126l, 374376460l, TravelType.FOOT, true);
    checkRoute(r2a, 1468.6731583119874, 417401126l, 374376460l);
    Route r3a = computeRoute(417401126l, 374376460l, TravelType.ANY, true);
    checkRoute(r3a, 1468.6731583119874, 417401126l, 374376460l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 14);
    checkWaypoints(r3b, 13149.100015480473, waypoints);
}


@Test(timeout = 1000)
public void testRouting16RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424436106l, 1422926689l, 1558424940l, 441907452l, 628644618l, 1422926597l, 698533322l, 104591413l, 2466291022l, 256603117l, 1035351697l, 1699983546l, 156965353l, 267461495l, 1391280121l, 1424435967l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1424436106l, 1424435967l, TravelType.BIKE, true);
    checkRoute(r0a, 400.4522625494927, 1424436106l, 1424435967l);
    computeRoute(1424436106l, 1424435967l, TravelType.CAR, false);
    computeRoute(1424436106l, 1424435967l, TravelType.FOOT, false);
    Route r3a = computeRoute(1424436106l, 1424435967l, TravelType.ANY, true);
    checkRoute(r3a, 400.4522625494927, 1424436106l, 1424435967l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 15);
    checkWaypoints(r3b, 16711.953196339968, waypoints);
}


@Test(timeout = 1000)
public void testRouting17RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2384367671l, 643709828l, 1422926625l, 1558424898l, 1422926136l, 1422926591l, 441557273l, 1698368067l, 1422926691l, 441136387l, 1699987793l, 359725653l, 1422926827l, 2962755881l, 493962586l, 1422926313l, 733220960l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2384367671l, 733220960l, TravelType.BIKE, false);
    computeRoute(2384367671l, 733220960l, TravelType.CAR, false);
    Route r2a = computeRoute(2384367671l, 733220960l, TravelType.FOOT, true);
    checkRoute(r2a, 968.7887944812512, 2384367671l, 733220960l);
    Route r3a = computeRoute(2384367671l, 733220960l, TravelType.ANY, true);
    checkRoute(r3a, 968.7887944812512, 2384367671l, 733220960l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 16);
    checkWaypoints(r3b, 17007.226292867635, waypoints);
}


@Test(timeout = 1000)
public void testRouting18RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424435938l, 271388282l, 2962747388l, 1424436027l, 401505819l, 1422926109l, 1422926394l, 1700056360l, 1698335939l, 1035351720l, 441617447l, 1410392675l, 784650294l, 344446185l, 1422926803l, 1035351690l, 1653457586l, 1422926146l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1424435938l, 1422926146l, TravelType.BIKE, true);
    checkRoute(r0a, 1529.8983940034277, 1424435938l, 1422926146l);
    computeRoute(1424435938l, 1422926146l, TravelType.CAR, false);
    Route r2a = computeRoute(1424435938l, 1422926146l, TravelType.FOOT, true);
    checkRoute(r2a, 1291.4193641103016, 1424435938l, 1422926146l);
    Route r3a = computeRoute(1424435938l, 1422926146l, TravelType.ANY, true);
    checkRoute(r3a, 1291.4193641103016, 1424435938l, 1422926146l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 17);
    checkWaypoints(r3b, 19369.963873232573, waypoints);
}


@Test(timeout = 1000)
public void testRouting19RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1324588185l, 374379029l, 1422926342l, 517549850l, 1424436053l, 2337468662l, 1558424946l, 374393410l, 1035351800l, 1744624308l, 1410392560l, 401359102l, 1699987791l, 2962689731l, 344240626l, 1424435910l, 360322965l, 1388219601l, 374395527l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1324588185l, 374395527l, TravelType.BIKE, false);
    computeRoute(1324588185l, 374395527l, TravelType.CAR, false);
    Route r2a = computeRoute(1324588185l, 374395527l, TravelType.FOOT, true);
    checkRoute(r2a, 2079.4318617360345, 1324588185l, 374395527l);
    Route r3a = computeRoute(1324588185l, 374395527l, TravelType.ANY, true);
    checkRoute(r3a, 2079.4318617360345, 1324588185l, 374395527l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 18);
    checkWaypoints(r3b, 23513.2372862036, waypoints);
}


@Test(timeout = 1000)
public void testRouting20RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 746808541l, 1324607760l, 267461716l, 2425479732l, 279897243l, 417401164l, 374382966l, 1914458697l, 3024386489l, 374376994l, 374379100l, 1093768777l, 1388222553l, 374376994l, 1410392536l, 1426601023l, 1422926360l, 1324585648l, 1478303877l, 1391280231l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(746808541l, 1391280231l, TravelType.BIKE, false);
    computeRoute(746808541l, 1391280231l, TravelType.CAR, false);
    Route r2a = computeRoute(746808541l, 1391280231l, TravelType.FOOT, true);
    checkRoute(r2a, 1205.860558649218, 746808541l, 1391280231l);
    Route r3a = computeRoute(746808541l, 1391280231l, TravelType.ANY, true);
    checkRoute(r3a, 1205.860558649218, 746808541l, 1391280231l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 19);
    checkWaypoints(r2b, 30615.74272746245, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 19);
    checkWaypoints(r3b, 30615.74272746245, waypoints);
}


@Test(timeout = 1000)
public void testRouting21RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374383015l, 1558424882l, 610892376l, 1424436071l, 1410392678l, 784627629l, 419540996l, 1035552891l, 267461716l, 704316321l, 374383867l, 2627125373l, 610892373l, 1502128180l, 105825555l, 344240700l, 1422926665l, 401506221l, 375768648l, 1324607761l, 374382815l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374383015l, 374382815l, TravelType.BIKE, true);
    checkRoute(r0a, 196.03006898295143, 374383015l, 374382815l);
    computeRoute(374383015l, 374382815l, TravelType.CAR, false);
    Route r2a = computeRoute(374383015l, 374382815l, TravelType.FOOT, true);
    checkRoute(r2a, 196.03006898295143, 374383015l, 374382815l);
    Route r3a = computeRoute(374383015l, 374382815l, TravelType.ANY, true);
    checkRoute(r3a, 196.03006898295143, 374383015l, 374382815l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 20);
    checkWaypoints(r3b, 30761.935752700687, waypoints);
}


@Test(timeout = 1000)
public void testRouting22RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 344446179l, 517549843l, 374391874l, 784627761l, 1020924360l, 1410392536l, 324406131l, 1035351803l, 823700208l, 1422926705l, 324406247l, 374385002l, 441557275l, 1391280218l, 374399209l, 1410392593l, 784627692l, 374384427l, 1391317058l, 374383311l, 1422926629l, 535606975l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(344446179l, 535606975l, TravelType.BIKE, false);
    computeRoute(344446179l, 535606975l, TravelType.CAR, false);
    Route r2a = computeRoute(344446179l, 535606975l, TravelType.FOOT, true);
    checkRoute(r2a, 295.99288277851633, 344446179l, 535606975l);
    Route r3a = computeRoute(344446179l, 535606975l, TravelType.ANY, true);
    checkRoute(r3a, 295.99288277851633, 344446179l, 535606975l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 21);
    checkWaypoints(r3b, 30470.437933653182, waypoints);
}


@Test(timeout = 1000)
public void testRouting23RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1580688707l, 267461502l, 374404700l, 401359079l, 1551745847l, 3024386491l, 1700012863l, 105825863l, 1535754831l, 1324585645l, 1501590537l, 1324591111l, 1558424904l, 2632374133l, 324406135l, 1424435896l, 1309264708l, 1422926417l, 1551745835l, 1324585645l, 535987923l, 1324591111l, 2962747383l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1580688707l, 2962747383l, TravelType.BIKE, false);
    computeRoute(1580688707l, 2962747383l, TravelType.CAR, false);
    Route r2a = computeRoute(1580688707l, 2962747383l, TravelType.FOOT, true);
    checkRoute(r2a, 987.508424148791, 1580688707l, 2962747383l);
    Route r3a = computeRoute(1580688707l, 2962747383l, TravelType.ANY, true);
    checkRoute(r3a, 975.8718724154168, 1580688707l, 2962747383l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 22);
    checkWaypoints(r2b, 37086.04158918627, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 22);
    checkWaypoints(r3b, 37078.40566629882, waypoints);
}


@Test(timeout = 1000)
public void testRouting24RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 455620283l, 1424435964l, 1422926803l, 344240626l, 1698369039l, 401505794l, 374385255l, 384631339l, 1424436100l, 279897195l, 374404645l, 784627871l, 289243595l, 1324591091l, 417401186l, 374378029l, 344240690l, 374383329l, 417401101l, 1744624319l, 1424435981l, 1422926859l, 1422926916l, 417401195l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(455620283l, 417401195l, TravelType.BIKE, true);
    checkRoute(r0a, 969.0665866388007, 455620283l, 417401195l);
    computeRoute(455620283l, 417401195l, TravelType.CAR, false);
    Route r2a = computeRoute(455620283l, 417401195l, TravelType.FOOT, true);
    checkRoute(r2a, 759.7762133172467, 455620283l, 417401195l);
    Route r3a = computeRoute(455620283l, 417401195l, TravelType.ANY, true);
    checkRoute(r3a, 759.7762133172467, 455620283l, 417401195l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 23);
    checkWaypoints(r3b, 31594.37844852449, waypoints);
}


@Test(timeout = 1000)
public void testRouting25RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926417l, 441616669l, 1422926290l, 105825119l, 535987907l, 534951767l, 1422926820l, 267260791l, 2384367669l, 2257446578l, 374376986l, 1425519155l, 1698371689l, 1426601000l, 1324619380l, 1422926366l, 968276422l, 1422926184l, 344240660l, 267461723l, 324406150l, 1346174756l, 277371523l, 295136312l, 1535754821l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1422926417l, 1535754821l, TravelType.BIKE, false);
    computeRoute(1422926417l, 1535754821l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926417l, 1535754821l, TravelType.FOOT, true);
    checkRoute(r2a, 2138.914579588691, 1422926417l, 1535754821l);
    Route r3a = computeRoute(1422926417l, 1535754821l, TravelType.ANY, true);
    checkRoute(r3a, 2138.914579588691, 1422926417l, 1535754821l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 24);
    checkWaypoints(r2b, 27480.384781221575, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 24);
    checkWaypoints(r3b, 27435.319377097214, waypoints);
}


@Test(timeout = 1000)
public void testRouting26RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 256603113l, 1580728663l, 2962689726l, 262498729l, 359725666l, 289943752l, 401505802l, 1700056360l, 1298565100l, 267628540l, 267461345l, 1580688708l, 1424435947l, 254511515l, 1558424922l, 1982644204l, 156936310l, 1424436114l, 1391280145l, 704316352l, 417401123l, 628641428l, 417401067l, 2487368365l, 1324607741l, 1388219607l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(256603113l, 1388219607l, TravelType.BIKE, true);
    checkRoute(r0a, 3040.6310020671103, 256603113l, 1388219607l);
    Route r1a = computeRoute(256603113l, 1388219607l, TravelType.CAR, true);
    checkRoute(r1a, 3225.7709835988207, 256603113l, 1388219607l);
    Route r2a = computeRoute(256603113l, 1388219607l, TravelType.FOOT, true);
    checkRoute(r2a, 2004.3424634493915, 256603113l, 1388219607l);
    Route r3a = computeRoute(256603113l, 1388219607l, TravelType.ANY, true);
    checkRoute(r3a, 2003.5882783372556, 256603113l, 1388219607l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 25);
    checkWaypoints(r2b, 33837.52099329851, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 25);
    checkWaypoints(r3b, 33819.60397853678, waypoints);
}


@Test(timeout = 1000)
public void testRouting27RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 472416466l, 401359712l, 401505819l, 266943515l, 784650288l, 1424435910l, 1324591102l, 292133957l, 1698370146l, 374383357l, 104591413l, 517549890l, 332083198l, 704434362l, 374384548l, 374376316l, 1424436127l, 1289529969l, 374379129l, 1391280117l, 289243625l, 3024386491l, 413037909l, 1424435974l, 295136503l, 1424435970l, 401505797l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(472416466l, 401505797l, TravelType.BIKE, true);
    checkRoute(r0a, 2666.3550732285444, 472416466l, 401505797l);
    Route r1a = computeRoute(472416466l, 401505797l, TravelType.CAR, true);
    checkRoute(r1a, 3404.858375533689, 472416466l, 401505797l);
    Route r2a = computeRoute(472416466l, 401505797l, TravelType.FOOT, true);
    checkRoute(r2a, 2209.180061724977, 472416466l, 401505797l);
    Route r3a = computeRoute(472416466l, 401505797l, TravelType.ANY, true);
    checkRoute(r3a, 2208.42587661284, 472416466l, 401505797l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    computeRoute(waypointsList, TravelType.FOOT, false);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 26);
    checkWaypoints(r3b, 39398.87758538811, waypoints);
}


@Test(timeout = 1000)
public void testRouting28RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 823700144l, 374398254l, 1551745840l, 1217435033l, 1278631627l, 1391280042l, 374377884l, 1388219601l, 374376757l, 384641265l, 374382874l, 1558424898l, 105825462l, 292134121l, 401359085l, 417401121l, 455620288l, 1424436575l, 267461498l, 384650540l, 1424436204l, 3181272410l, 492238616l, 1558424957l, 344446144l, 1324607752l, 374376460l, 1597747641l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(823700144l, 1597747641l, TravelType.BIKE, false);
    computeRoute(823700144l, 1597747641l, TravelType.CAR, false);
    Route r2a = computeRoute(823700144l, 1597747641l, TravelType.FOOT, true);
    checkRoute(r2a, 1673.844283857365, 823700144l, 1597747641l);
    Route r3a = computeRoute(823700144l, 1597747641l, TravelType.ANY, true);
    checkRoute(r3a, 1672.472906200876, 823700144l, 1597747641l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 27);
    checkWaypoints(r2b, 44203.84925701492, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 27);
    checkWaypoints(r3b, 44186.685634534464, waypoints);
}


@Test(timeout = 1000)
public void testRouting29RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 267461704l, 1424436099l, 1422926568l, 413037913l, 643709828l, 784627878l, 1422926232l, 401505794l, 375768659l, 442366072l, 1422926507l, 267461709l, 289243598l, 324406073l, 1324607714l, 1426014712l, 374390245l, 417783928l, 374404605l, 1422926290l, 1391280420l, 1558424959l, 374382815l, 374378044l, 1324591109l, 1424435894l, 1324591098l, 1388222547l, 784650294l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(267461704l, 784650294l, TravelType.BIKE, true);
    checkRoute(r0a, 1012.6981438367144, 267461704l, 784650294l);
    computeRoute(267461704l, 784650294l, TravelType.CAR, false);
    Route r2a = computeRoute(267461704l, 784650294l, TravelType.FOOT, true);
    checkRoute(r2a, 1012.6981438367144, 267461704l, 784650294l);
    Route r3a = computeRoute(267461704l, 784650294l, TravelType.ANY, true);
    checkRoute(r3a, 1012.6981438367144, 267461704l, 784650294l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 28);
    checkWaypoints(r2b, 45896.63112992863, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 28);
    checkWaypoints(r3b, 45866.57337851959, waypoints);
}


@Test(timeout = 1000)
public void testRouting30RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1030669079l, 784627703l, 289243599l, 1035553034l, 784627878l, 289243589l, 292133957l, 1501590539l, 1034349827l, 389976446l, 1422926793l, 1424436078l, 1391280098l, 267461715l, 1551745834l, 784627765l, 265664962l, 417401219l, 1698385071l, 2410017218l, 1410392593l, 419540578l, 535628855l, 704316300l, 374394264l, 784650283l, 704434378l, 1699987790l, 1309264720l, 1424436134l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1030669079l, 1424436134l, TravelType.BIKE, false);
    computeRoute(1030669079l, 1424436134l, TravelType.CAR, false);
    Route r2a = computeRoute(1030669079l, 1424436134l, TravelType.FOOT, true);
    checkRoute(r2a, 1320.0243281286387, 1030669079l, 1424436134l);
    Route r3a = computeRoute(1030669079l, 1424436134l, TravelType.ANY, true);
    checkRoute(r3a, 1309.7403502684574, 1030669079l, 1424436134l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 29);
    checkWaypoints(r2b, 39285.06465291177, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 29);
    checkWaypoints(r3b, 39273.57201906767, waypoints);
}


@Test(timeout = 1000)
public void testRouting31RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1324607723l, 704316311l, 704316323l, 1424435895l, 1551745851l, 643709806l, 517549840l, 413037913l, 1698385067l, 1422926125l, 374383194l, 374377072l, 324406051l, 1410392655l, 374383000l, 784627768l, 704434361l, 417401196l, 105825694l, 1312868220l, 1422926193l, 267628549l, 535987918l, 374390245l, 1424436141l, 1700061833l, 374389957l, 968276422l, 1424436008l, 628644612l, 112445452l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1324607723l, 112445452l, TravelType.BIKE, false);
    computeRoute(1324607723l, 112445452l, TravelType.CAR, false);
    Route r2a = computeRoute(1324607723l, 112445452l, TravelType.FOOT, true);
    checkRoute(r2a, 2433.9977761094574, 1324607723l, 112445452l);
    Route r3a = computeRoute(1324607723l, 112445452l, TravelType.ANY, true);
    checkRoute(r3a, 2433.2435909973206, 1324607723l, 112445452l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 30);
    checkWaypoints(r2b, 43628.99153209604, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 30);
    checkWaypoints(r3b, 43614.720663728614, waypoints);
}


@Test(timeout = 1000)
public void testRouting32RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2337468665l, 417401192l, 1424435915l, 784627660l, 417401185l, 267934206l, 344240638l, 1324607670l, 455620299l, 374377802l, 401359087l, 289243592l, 374384054l, 1324585646l, 344240659l, 417401229l, 1699983543l, 2257446557l, 374383030l, 245781601l, 374398254l, 1422926237l, 628644611l, 1744624318l, 1410392593l, 1597498159l, 374378766l, 698533320l, 374382815l, 417783898l, 1035351682l, 1535754821l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2337468665l, 1535754821l, TravelType.BIKE, true);
    checkRoute(r0a, 2494.173678267742, 2337468665l, 1535754821l);
    computeRoute(2337468665l, 1535754821l, TravelType.CAR, false);
    Route r2a = computeRoute(2337468665l, 1535754821l, TravelType.FOOT, true);
    checkRoute(r2a, 2434.4466483274146, 2337468665l, 1535754821l);
    Route r3a = computeRoute(2337468665l, 1535754821l, TravelType.ANY, true);
    checkRoute(r3a, 2434.4466483274146, 2337468665l, 1535754821l);
    computeRoute(waypointsList, TravelType.BIKE, false);
    computeRoute(waypointsList, TravelType.CAR, false);
    Route r2b = computeRoute(waypointsList, TravelType.FOOT, true);
    assertEquals("Route did not have waypoints many legs", r2b.size(), 31);
    checkWaypoints(r2b, 40380.6160585207, waypoints);
    Route r3b = computeRoute(waypointsList, TravelType.ANY, true);
    assertEquals("Route did not have waypoints many legs", r3b.size(), 31);
    checkWaypoints(r3b, 40377.60248939563, waypoints);
}


@Override
public String getMapFileName() {
    return "campus.osm.nae";
}


}