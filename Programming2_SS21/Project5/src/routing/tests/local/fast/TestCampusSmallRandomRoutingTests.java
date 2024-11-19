package routing.tests.local.fast;

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
public class TestCampusSmallRandomRoutingTests extends TestingBase {

@Test(timeout = 1000)
public void testSmallRouting0RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926387l, 374392614l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1422926387l, 374392614l, TravelType.BIKE, false);
    computeRoute(1422926387l, 374392614l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926387l, 374392614l, TravelType.FOOT, true);
    checkRoute(r2a, 1590.2415860851906, 1422926387l, 374392614l);
    Route r3a = computeRoute(1422926387l, 374392614l, TravelType.ANY, true);
    checkRoute(r3a, 1590.2415860851906, 1422926387l, 374392614l);
}


@Test(timeout = 1000)
public void testSmallRouting1RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 417401191l, 1424436119l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(417401191l, 1424436119l, TravelType.BIKE, false);
    computeRoute(417401191l, 1424436119l, TravelType.CAR, false);
    Route r2a = computeRoute(417401191l, 1424436119l, TravelType.FOOT, true);
    checkRoute(r2a, 1391.5023307502795, 417401191l, 1424436119l);
    Route r3a = computeRoute(417401191l, 1424436119l, TravelType.ANY, true);
    checkRoute(r3a, 1391.5023307502795, 417401191l, 1424436119l);
}


@Test(timeout = 1000)
public void testSmallRouting2RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2632374131l, 374392231l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2632374131l, 374392231l, TravelType.BIKE, false);
    computeRoute(2632374131l, 374392231l, TravelType.CAR, false);
    Route r2a = computeRoute(2632374131l, 374392231l, TravelType.FOOT, true);
    checkRoute(r2a, 2390.8767901444667, 2632374131l, 374392231l);
    Route r3a = computeRoute(2632374131l, 374392231l, TravelType.ANY, true);
    checkRoute(r3a, 2389.868259422879, 2632374131l, 374392231l);
}


@Test(timeout = 1000)
public void testSmallRouting3RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 156936402l, 997708276l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(156936402l, 997708276l, TravelType.BIKE, true);
    checkRoute(r0a, 4019.619316748732, 156936402l, 997708276l);
    computeRoute(156936402l, 997708276l, TravelType.CAR, false);
    Route r2a = computeRoute(156936402l, 997708276l, TravelType.FOOT, true);
    checkRoute(r2a, 3468.1262629492244, 156936402l, 997708276l);
    Route r3a = computeRoute(156936402l, 997708276l, TravelType.ANY, true);
    checkRoute(r3a, 3468.1262629492244, 156936402l, 997708276l);
}


@Test(timeout = 1000)
public void testSmallRouting4RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1698366964l, 698533326l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1698366964l, 698533326l, TravelType.BIKE, false);
    computeRoute(1698366964l, 698533326l, TravelType.CAR, false);
    Route r2a = computeRoute(1698366964l, 698533326l, TravelType.FOOT, true);
    checkRoute(r2a, 676.395301620899, 1698366964l, 698533326l);
    Route r3a = computeRoute(1698366964l, 698533326l, TravelType.ANY, true);
    checkRoute(r3a, 676.395301620899, 1698366964l, 698533326l);
}


@Test(timeout = 1000)
public void testSmallRouting5RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1699987786l, 1391280390l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1699987786l, 1391280390l, TravelType.BIKE, false);
    computeRoute(1699987786l, 1391280390l, TravelType.CAR, false);
    Route r2a = computeRoute(1699987786l, 1391280390l, TravelType.FOOT, true);
    checkRoute(r2a, 1608.7303719492124, 1699987786l, 1391280390l);
    Route r3a = computeRoute(1699987786l, 1391280390l, TravelType.ANY, true);
    checkRoute(r3a, 1608.7303719492124, 1699987786l, 1391280390l);
}


@Test(timeout = 1000)
public void testSmallRouting6RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 417401229l, 1558424893l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(417401229l, 1558424893l, TravelType.BIKE, true);
    checkRoute(r0a, 2489.5687466489644, 417401229l, 1558424893l);
    computeRoute(417401229l, 1558424893l, TravelType.CAR, false);
    Route r2a = computeRoute(417401229l, 1558424893l, TravelType.FOOT, true);
    checkRoute(r2a, 1419.794192673069, 417401229l, 1558424893l);
    Route r3a = computeRoute(417401229l, 1558424893l, TravelType.ANY, true);
    checkRoute(r3a, 1419.794192673069, 417401229l, 1558424893l);
}


@Test(timeout = 1000)
public void testSmallRouting7RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 295136602l, 1309264708l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(295136602l, 1309264708l, TravelType.BIKE, true);
    checkRoute(r0a, 157.9176042236345, 295136602l, 1309264708l);
    computeRoute(295136602l, 1309264708l, TravelType.CAR, false);
    Route r2a = computeRoute(295136602l, 1309264708l, TravelType.FOOT, true);
    checkRoute(r2a, 157.9176042236345, 295136602l, 1309264708l);
    Route r3a = computeRoute(295136602l, 1309264708l, TravelType.ANY, true);
    checkRoute(r3a, 157.9176042236345, 295136602l, 1309264708l);
}


@Test(timeout = 1000)
public void testSmallRouting8RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2627125370l, 417401227l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2627125370l, 417401227l, TravelType.BIKE, true);
    checkRoute(r0a, 1028.464404454585, 2627125370l, 417401227l);
    computeRoute(2627125370l, 417401227l, TravelType.CAR, false);
    Route r2a = computeRoute(2627125370l, 417401227l, TravelType.FOOT, true);
    checkRoute(r2a, 1028.464404454585, 2627125370l, 417401227l);
    Route r3a = computeRoute(2627125370l, 417401227l, TravelType.ANY, true);
    checkRoute(r3a, 1028.464404454585, 2627125370l, 417401227l);
}


@Test(timeout = 1000)
public void testSmallRouting9RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374390224l, 374391874l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374390224l, 374391874l, TravelType.BIKE, true);
    checkRoute(r0a, 1288.7488413297233, 374390224l, 374391874l);
    computeRoute(374390224l, 374391874l, TravelType.CAR, false);
    Route r2a = computeRoute(374390224l, 374391874l, TravelType.FOOT, true);
    checkRoute(r2a, 1288.7488413297233, 374390224l, 374391874l);
    Route r3a = computeRoute(374390224l, 374391874l, TravelType.ANY, true);
    checkRoute(r3a, 1288.7488413297233, 374390224l, 374391874l);
}


@Test(timeout = 1000)
public void testSmallRouting10RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926762l, 375768662l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1422926762l, 375768662l, TravelType.BIKE, true);
    checkRoute(r0a, 1566.7387714617457, 1422926762l, 375768662l);
    computeRoute(1422926762l, 375768662l, TravelType.CAR, false);
    computeRoute(1422926762l, 375768662l, TravelType.FOOT, false);
    Route r3a = computeRoute(1422926762l, 375768662l, TravelType.ANY, true);
    checkRoute(r3a, 1566.7387714617457, 1422926762l, 375768662l);
}


@Test(timeout = 1000)
public void testSmallRouting11RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 156936402l, 1914458681l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(156936402l, 1914458681l, TravelType.BIKE, true);
    checkRoute(r0a, 2080.3278226849447, 156936402l, 1914458681l);
    computeRoute(156936402l, 1914458681l, TravelType.CAR, false);
    Route r2a = computeRoute(156936402l, 1914458681l, TravelType.FOOT, true);
    checkRoute(r2a, 1567.4908021206363, 156936402l, 1914458681l);
    Route r3a = computeRoute(156936402l, 1914458681l, TravelType.ANY, true);
    checkRoute(r3a, 1567.4908021206363, 156936402l, 1914458681l);
}


@Test(timeout = 1000)
public void testSmallRouting12RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 704434407l, 384641314l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(704434407l, 384641314l, TravelType.BIKE, false);
    computeRoute(704434407l, 384641314l, TravelType.CAR, false);
    Route r2a = computeRoute(704434407l, 384641314l, TravelType.FOOT, true);
    checkRoute(r2a, 2574.437818778287, 704434407l, 384641314l);
    Route r3a = computeRoute(704434407l, 384641314l, TravelType.ANY, true);
    checkRoute(r3a, 2574.437818778287, 704434407l, 384641314l);
}


@Test(timeout = 1000)
public void testSmallRouting13RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1426601022l, 1700009719l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1426601022l, 1700009719l, TravelType.BIKE, true);
    checkRoute(r0a, 1736.5116189181404, 1426601022l, 1700009719l);
    computeRoute(1426601022l, 1700009719l, TravelType.CAR, false);
    Route r2a = computeRoute(1426601022l, 1700009719l, TravelType.FOOT, true);
    checkRoute(r2a, 1691.1956377343283, 1426601022l, 1700009719l);
    Route r3a = computeRoute(1426601022l, 1700009719l, TravelType.ANY, true);
    checkRoute(r3a, 1674.0852080490615, 1426601022l, 1700009719l);
}


@Test(timeout = 1000)
public void testSmallRouting14RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 289243589l, 267628547l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(289243589l, 267628547l, TravelType.BIKE, false);
    computeRoute(289243589l, 267628547l, TravelType.CAR, false);
    Route r2a = computeRoute(289243589l, 267628547l, TravelType.FOOT, true);
    checkRoute(r2a, 992.3877760955983, 289243589l, 267628547l);
    Route r3a = computeRoute(289243589l, 267628547l, TravelType.ANY, true);
    checkRoute(r3a, 992.3877760955983, 289243589l, 267628547l);
}


@Test(timeout = 1000)
public void testSmallRouting15RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424435938l, 374384581l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1424435938l, 374384581l, TravelType.BIKE, true);
    checkRoute(r0a, 1876.7615792997765, 1424435938l, 374384581l);
    computeRoute(1424435938l, 374384581l, TravelType.CAR, false);
    Route r2a = computeRoute(1424435938l, 374384581l, TravelType.FOOT, true);
    checkRoute(r2a, 1048.8226851198797, 1424435938l, 374384581l);
    Route r3a = computeRoute(1424435938l, 374384581l, TravelType.ANY, true);
    checkRoute(r3a, 1048.8226851198797, 1424435938l, 374384581l);
}


@Test(timeout = 1000)
public void testSmallRouting16RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 332308662l, 324406018l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(332308662l, 324406018l, TravelType.BIKE, false);
    computeRoute(332308662l, 324406018l, TravelType.CAR, false);
    Route r2a = computeRoute(332308662l, 324406018l, TravelType.FOOT, true);
    checkRoute(r2a, 2566.264342236139, 332308662l, 324406018l);
    Route r3a = computeRoute(332308662l, 324406018l, TravelType.ANY, true);
    checkRoute(r3a, 2566.264342236139, 332308662l, 324406018l);
}


@Test(timeout = 1000)
public void testSmallRouting17RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 784627641l, 332083227l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(784627641l, 332083227l, TravelType.BIKE, true);
    checkRoute(r0a, 284.9949551548872, 784627641l, 332083227l);
    computeRoute(784627641l, 332083227l, TravelType.CAR, false);
    Route r2a = computeRoute(784627641l, 332083227l, TravelType.FOOT, true);
    checkRoute(r2a, 284.9949551548872, 784627641l, 332083227l);
    Route r3a = computeRoute(784627641l, 332083227l, TravelType.ANY, true);
    checkRoute(r3a, 284.9949551548872, 784627641l, 332083227l);
}


@Test(timeout = 1000)
public void testSmallRouting18RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 472416466l, 374382410l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(472416466l, 374382410l, TravelType.BIKE, true);
    checkRoute(r0a, 1278.5915717513315, 472416466l, 374382410l);
    computeRoute(472416466l, 374382410l, TravelType.CAR, false);
    Route r2a = computeRoute(472416466l, 374382410l, TravelType.FOOT, true);
    checkRoute(r2a, 1002.1667203147658, 472416466l, 374382410l);
    Route r3a = computeRoute(472416466l, 374382410l, TravelType.ANY, true);
    checkRoute(r3a, 1002.1667203147658, 472416466l, 374382410l);
}


@Test(timeout = 1000)
public void testSmallRouting19RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424436168l, 1424435932l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1424436168l, 1424435932l, TravelType.BIKE, false);
    computeRoute(1424436168l, 1424435932l, TravelType.CAR, false);
    Route r2a = computeRoute(1424436168l, 1424435932l, TravelType.FOOT, true);
    checkRoute(r2a, 1039.3253041637824, 1424436168l, 1424435932l);
    Route r3a = computeRoute(1424436168l, 1424435932l, TravelType.ANY, true);
    checkRoute(r3a, 1022.214874478515, 1424436168l, 1424435932l);
}


@Test(timeout = 1000)
public void testSmallRouting20RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1499967566l, 401505803l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1499967566l, 401505803l, TravelType.BIKE, true);
    checkRoute(r0a, 2604.236481178764, 1499967566l, 401505803l);
    Route r1a = computeRoute(1499967566l, 401505803l, TravelType.CAR, true);
    checkRoute(r1a, 2643.3788771161394, 1499967566l, 401505803l);
    Route r2a = computeRoute(1499967566l, 401505803l, TravelType.FOOT, true);
    checkRoute(r2a, 2042.5044142528232, 1499967566l, 401505803l);
    Route r3a = computeRoute(1499967566l, 401505803l, TravelType.ANY, true);
    checkRoute(r3a, 2041.7502291406865, 1499967566l, 401505803l);
}


@Test(timeout = 1000)
public void testSmallRouting21RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1391279995l, 332083222l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1391279995l, 332083222l, TravelType.BIKE, false);
    computeRoute(1391279995l, 332083222l, TravelType.CAR, false);
    Route r2a = computeRoute(1391279995l, 332083222l, TravelType.FOOT, true);
    checkRoute(r2a, 940.7767129382905, 1391279995l, 332083222l);
    Route r3a = computeRoute(1391279995l, 332083222l, TravelType.ANY, true);
    checkRoute(r3a, 940.7767129382905, 1391279995l, 332083222l);
}


@Test(timeout = 1000)
public void testSmallRouting22RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1558424852l, 784627686l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1558424852l, 784627686l, TravelType.BIKE, true);
    checkRoute(r0a, 2306.6004887121353, 1558424852l, 784627686l);
    computeRoute(1558424852l, 784627686l, TravelType.CAR, false);
    Route r2a = computeRoute(1558424852l, 784627686l, TravelType.FOOT, true);
    checkRoute(r2a, 2272.688615990832, 1558424852l, 784627686l);
    Route r3a = computeRoute(1558424852l, 784627686l, TravelType.ANY, true);
    checkRoute(r3a, 2272.688615990832, 1558424852l, 784627686l);
}


@Test(timeout = 1000)
public void testSmallRouting23RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2337468664l, 704316297l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2337468664l, 704316297l, TravelType.BIKE, true);
    checkRoute(r0a, 1484.079473636798, 2337468664l, 704316297l);
    computeRoute(2337468664l, 704316297l, TravelType.CAR, false);
    Route r2a = computeRoute(2337468664l, 704316297l, TravelType.FOOT, true);
    checkRoute(r2a, 1495.6805874166503, 2337468664l, 704316297l);
    Route r3a = computeRoute(2337468664l, 704316297l, TravelType.ANY, true);
    checkRoute(r3a, 1484.079473636798, 2337468664l, 704316297l);
}


@Test(timeout = 1000)
public void testSmallRouting24RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2496440424l, 1422926261l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2496440424l, 1422926261l, TravelType.BIKE, false);
    computeRoute(2496440424l, 1422926261l, TravelType.CAR, false);
    Route r2a = computeRoute(2496440424l, 1422926261l, TravelType.FOOT, true);
    checkRoute(r2a, 1289.8595609874903, 2496440424l, 1422926261l);
    Route r3a = computeRoute(2496440424l, 1422926261l, TravelType.ANY, true);
    checkRoute(r3a, 1289.8595609874903, 2496440424l, 1422926261l);
}


@Test(timeout = 1000)
public void testSmallRouting25RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 441616659l, 1424436121l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(441616659l, 1424436121l, TravelType.BIKE, true);
    checkRoute(r0a, 965.2809207644995, 441616659l, 1424436121l);
    computeRoute(441616659l, 1424436121l, TravelType.CAR, false);
    Route r2a = computeRoute(441616659l, 1424436121l, TravelType.FOOT, true);
    checkRoute(r2a, 924.9810983699097, 441616659l, 1424436121l);
    Route r3a = computeRoute(441616659l, 1424436121l, TravelType.ANY, true);
    checkRoute(r3a, 924.9810983699097, 441616659l, 1424436121l);
}


@Test(timeout = 1000)
public void testSmallRouting26RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374384043l, 112445319l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374384043l, 112445319l, TravelType.BIKE, true);
    checkRoute(r0a, 2309.3205480647853, 374384043l, 112445319l);
    computeRoute(374384043l, 112445319l, TravelType.CAR, false);
    Route r2a = computeRoute(374384043l, 112445319l, TravelType.FOOT, true);
    checkRoute(r2a, 748.5716791117102, 374384043l, 112445319l);
    Route r3a = computeRoute(374384043l, 112445319l, TravelType.ANY, true);
    checkRoute(r3a, 748.5716791117102, 374384043l, 112445319l);
}


@Test(timeout = 1000)
public void testSmallRouting27RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374404645l, 105825635l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374404645l, 105825635l, TravelType.BIKE, true);
    checkRoute(r0a, 3025.486193975639, 374404645l, 105825635l);
    computeRoute(374404645l, 105825635l, TravelType.CAR, false);
    Route r2a = computeRoute(374404645l, 105825635l, TravelType.FOOT, true);
    checkRoute(r2a, 2542.758747415446, 374404645l, 105825635l);
    Route r3a = computeRoute(374404645l, 105825635l, TravelType.ANY, true);
    checkRoute(r3a, 2542.758747415446, 374404645l, 105825635l);
}


@Test(timeout = 1000)
public void testSmallRouting28RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 616884088l, 376491788l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(616884088l, 376491788l, TravelType.BIKE, true);
    checkRoute(r0a, 1166.5425175287942, 616884088l, 376491788l);
    computeRoute(616884088l, 376491788l, TravelType.CAR, false);
    Route r2a = computeRoute(616884088l, 376491788l, TravelType.FOOT, true);
    checkRoute(r2a, 1118.7135428645436, 616884088l, 376491788l);
    Route r3a = computeRoute(616884088l, 376491788l, TravelType.ANY, true);
    checkRoute(r3a, 1113.336672595692, 616884088l, 376491788l);
}


@Test(timeout = 1000)
public void testSmallRouting29RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2962747401l, 374382425l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2962747401l, 374382425l, TravelType.BIKE, true);
    checkRoute(r0a, 1624.292712352353, 2962747401l, 374382425l);
    computeRoute(2962747401l, 374382425l, TravelType.CAR, false);
    Route r2a = computeRoute(2962747401l, 374382425l, TravelType.FOOT, true);
    checkRoute(r2a, 1516.7372966382204, 2962747401l, 374382425l);
    Route r3a = computeRoute(2962747401l, 374382425l, TravelType.ANY, true);
    checkRoute(r3a, 1516.7372966382204, 2962747401l, 374382425l);
}


@Test(timeout = 1000)
public void testSmallRouting30RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926136l, 493962577l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1422926136l, 493962577l, TravelType.BIKE, true);
    checkRoute(r0a, 820.9340633729954, 1422926136l, 493962577l);
    computeRoute(1422926136l, 493962577l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926136l, 493962577l, TravelType.FOOT, true);
    checkRoute(r2a, 806.9153340629128, 1422926136l, 493962577l);
    Route r3a = computeRoute(1422926136l, 493962577l, TravelType.ANY, true);
    checkRoute(r3a, 806.9153340629128, 1422926136l, 493962577l);
}


@Test(timeout = 1000)
public void testSmallRouting31RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 344446179l, 1217435034l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(344446179l, 1217435034l, TravelType.BIKE, false);
    computeRoute(344446179l, 1217435034l, TravelType.CAR, false);
    Route r2a = computeRoute(344446179l, 1217435034l, TravelType.FOOT, true);
    checkRoute(r2a, 472.3255165988068, 344446179l, 1217435034l);
    Route r3a = computeRoute(344446179l, 1217435034l, TravelType.ANY, true);
    checkRoute(r3a, 472.3255165988068, 344446179l, 1217435034l);
}


@Test(timeout = 1000)
public void testSmallRouting32RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1391319384l, 1700009730l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1391319384l, 1700009730l, TravelType.BIKE, true);
    checkRoute(r0a, 1812.7378155447248, 1391319384l, 1700009730l);
    computeRoute(1391319384l, 1700009730l, TravelType.CAR, false);
    Route r2a = computeRoute(1391319384l, 1700009730l, TravelType.FOOT, true);
    checkRoute(r2a, 1114.3191850860387, 1391319384l, 1700009730l);
    Route r3a = computeRoute(1391319384l, 1700009730l, TravelType.ANY, true);
    checkRoute(r3a, 1114.3191850860387, 1391319384l, 1700009730l);
}


@Test(timeout = 1000)
public void testSmallRouting33RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926584l, 1426014715l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1422926584l, 1426014715l, TravelType.BIKE, false);
    computeRoute(1422926584l, 1426014715l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926584l, 1426014715l, TravelType.FOOT, true);
    checkRoute(r2a, 988.4353559083636, 1422926584l, 1426014715l);
    Route r3a = computeRoute(1422926584l, 1426014715l, TravelType.ANY, true);
    checkRoute(r3a, 988.1885082148806, 1422926584l, 1426014715l);
}


@Test(timeout = 1000)
public void testSmallRouting34RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2962755879l, 267461498l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2962755879l, 267461498l, TravelType.BIKE, true);
    checkRoute(r0a, 1279.634095594658, 2962755879l, 267461498l);
    computeRoute(2962755879l, 267461498l, TravelType.CAR, false);
    Route r2a = computeRoute(2962755879l, 267461498l, TravelType.FOOT, true);
    checkRoute(r2a, 1271.091169191683, 2962755879l, 267461498l);
    Route r3a = computeRoute(2962755879l, 267461498l, TravelType.ANY, true);
    checkRoute(r3a, 1271.091169191683, 2962755879l, 267461498l);
}


@Test(timeout = 1000)
public void testSmallRouting35RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 384631331l, 1388219601l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(384631331l, 1388219601l, TravelType.BIKE, true);
    checkRoute(r0a, 2855.2692318274694, 384631331l, 1388219601l);
    Route r1a = computeRoute(384631331l, 1388219601l, TravelType.CAR, true);
    checkRoute(r1a, 2862.8923818747903, 384631331l, 1388219601l);
    Route r2a = computeRoute(384631331l, 1388219601l, TravelType.FOOT, true);
    checkRoute(r2a, 2303.7761780279616, 384631331l, 1388219601l);
    Route r3a = computeRoute(384631331l, 1388219601l, TravelType.ANY, true);
    checkRoute(r3a, 2303.7761780279616, 384631331l, 1388219601l);
}


@Test(timeout = 1000)
public void testSmallRouting36RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 295135823l, 344587462l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(295135823l, 344587462l, TravelType.BIKE, true);
    checkRoute(r0a, 2591.3170739974626, 295135823l, 344587462l);
    computeRoute(295135823l, 344587462l, TravelType.CAR, false);
    Route r2a = computeRoute(295135823l, 344587462l, TravelType.FOOT, true);
    checkRoute(r2a, 1414.3657198146639, 295135823l, 344587462l);
    Route r3a = computeRoute(295135823l, 344587462l, TravelType.ANY, true);
    checkRoute(r3a, 1414.3657198146639, 295135823l, 344587462l);
}


@Test(timeout = 1000)
public void testSmallRouting37RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 254511516l, 360323000l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(254511516l, 360323000l, TravelType.BIKE, false);
    computeRoute(254511516l, 360323000l, TravelType.CAR, false);
    Route r2a = computeRoute(254511516l, 360323000l, TravelType.FOOT, true);
    checkRoute(r2a, 578.5432193304939, 254511516l, 360323000l);
    Route r3a = computeRoute(254511516l, 360323000l, TravelType.ANY, true);
    checkRoute(r3a, 578.5432193304939, 254511516l, 360323000l);
}


@Test(timeout = 1000)
public void testSmallRouting38RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926616l, 2384367672l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1422926616l, 2384367672l, TravelType.BIKE, false);
    computeRoute(1422926616l, 2384367672l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926616l, 2384367672l, TravelType.FOOT, true);
    checkRoute(r2a, 1060.7446078282185, 1422926616l, 2384367672l);
    Route r3a = computeRoute(1422926616l, 2384367672l, TravelType.ANY, true);
    checkRoute(r3a, 1059.7360771066308, 1422926616l, 2384367672l);
}


@Test(timeout = 1000)
public void testSmallRouting39RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1388219602l, 2962755864l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1388219602l, 2962755864l, TravelType.BIKE, true);
    checkRoute(r0a, 473.5476795946134, 1388219602l, 2962755864l);
    computeRoute(1388219602l, 2962755864l, TravelType.CAR, false);
    Route r2a = computeRoute(1388219602l, 2962755864l, TravelType.FOOT, true);
    checkRoute(r2a, 230.67589044955065, 1388219602l, 2962755864l);
    Route r3a = computeRoute(1388219602l, 2962755864l, TravelType.ANY, true);
    checkRoute(r3a, 230.67589044955065, 1388219602l, 2962755864l);
}


@Test(timeout = 1000)
public void testSmallRouting40RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1388222551l, 1312868220l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1388222551l, 1312868220l, TravelType.BIKE, true);
    checkRoute(r0a, 1114.7333600542004, 1388222551l, 1312868220l);
    computeRoute(1388222551l, 1312868220l, TravelType.CAR, false);
    Route r2a = computeRoute(1388222551l, 1312868220l, TravelType.FOOT, true);
    checkRoute(r2a, 796.4404706206335, 1388222551l, 1312868220l);
    Route r3a = computeRoute(1388222551l, 1312868220l, TravelType.ANY, true);
    checkRoute(r3a, 796.4404706206335, 1388222551l, 1312868220l);
}


@Test(timeout = 1000)
public void testSmallRouting41RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926146l, 2458446101l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1422926146l, 2458446101l, TravelType.BIKE, true);
    checkRoute(r0a, 2492.7149563791045, 1422926146l, 2458446101l);
    computeRoute(1422926146l, 2458446101l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926146l, 2458446101l, TravelType.FOOT, true);
    checkRoute(r2a, 2259.065611250178, 1422926146l, 2458446101l);
    Route r3a = computeRoute(1422926146l, 2458446101l, TravelType.ANY, true);
    checkRoute(r3a, 2258.3114261380415, 1422926146l, 2458446101l);
}


@Test(timeout = 1000)
public void testSmallRouting42RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 267628544l, 784627748l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(267628544l, 784627748l, TravelType.BIKE, false);
    computeRoute(267628544l, 784627748l, TravelType.CAR, false);
    Route r2a = computeRoute(267628544l, 784627748l, TravelType.FOOT, true);
    checkRoute(r2a, 1183.3125125010743, 267628544l, 784627748l);
    Route r3a = computeRoute(267628544l, 784627748l, TravelType.ANY, true);
    checkRoute(r3a, 1183.3125125010743, 267628544l, 784627748l);
}


@Test(timeout = 1000)
public void testSmallRouting43RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424435902l, 344240626l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1424435902l, 344240626l, TravelType.BIKE, false);
    computeRoute(1424435902l, 344240626l, TravelType.CAR, false);
    Route r2a = computeRoute(1424435902l, 344240626l, TravelType.FOOT, true);
    checkRoute(r2a, 1230.0451988667805, 1424435902l, 344240626l);
    Route r3a = computeRoute(1424435902l, 344240626l, TravelType.ANY, true);
    checkRoute(r3a, 1230.0451988667805, 1424435902l, 344240626l);
}


@Test(timeout = 1000)
public void testSmallRouting44RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1391280172l, 156965532l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1391280172l, 156965532l, TravelType.BIKE, false);
    computeRoute(1391280172l, 156965532l, TravelType.CAR, false);
    Route r2a = computeRoute(1391280172l, 156965532l, TravelType.FOOT, true);
    checkRoute(r2a, 1026.4542369415974, 1391280172l, 156965532l);
    Route r3a = computeRoute(1391280172l, 156965532l, TravelType.ANY, true);
    checkRoute(r3a, 1026.4542369415974, 1391280172l, 156965532l);
}


@Test(timeout = 1000)
public void testSmallRouting45RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 332308662l, 156965427l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(332308662l, 156965427l, TravelType.BIKE, false);
    computeRoute(332308662l, 156965427l, TravelType.CAR, false);
    Route r2a = computeRoute(332308662l, 156965427l, TravelType.FOOT, true);
    checkRoute(r2a, 230.81820034451144, 332308662l, 156965427l);
    Route r3a = computeRoute(332308662l, 156965427l, TravelType.ANY, true);
    checkRoute(r3a, 230.81820034451144, 332308662l, 156965427l);
}


@Test(timeout = 1000)
public void testSmallRouting46RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424435946l, 401359712l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1424435946l, 401359712l, TravelType.BIKE, true);
    checkRoute(r0a, 580.4226540511022, 1424435946l, 401359712l);
    computeRoute(1424435946l, 401359712l, TravelType.CAR, false);
    computeRoute(1424435946l, 401359712l, TravelType.FOOT, false);
    Route r3a = computeRoute(1424435946l, 401359712l, TravelType.ANY, true);
    checkRoute(r3a, 580.4226540511022, 1424435946l, 401359712l);
}


@Test(timeout = 1000)
public void testSmallRouting47RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 784650241l, 389976485l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(784650241l, 389976485l, TravelType.BIKE, true);
    checkRoute(r0a, 327.27863324820555, 784650241l, 389976485l);
    computeRoute(784650241l, 389976485l, TravelType.CAR, false);
    Route r2a = computeRoute(784650241l, 389976485l, TravelType.FOOT, true);
    checkRoute(r2a, 327.27863324820555, 784650241l, 389976485l);
    Route r3a = computeRoute(784650241l, 389976485l, TravelType.ANY, true);
    checkRoute(r3a, 327.27863324820555, 784650241l, 389976485l);
}


@Test(timeout = 1000)
public void testSmallRouting48RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424435996l, 1391280389l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1424435996l, 1391280389l, TravelType.BIKE, false);
    computeRoute(1424435996l, 1391280389l, TravelType.CAR, false);
    Route r2a = computeRoute(1424435996l, 1391280389l, TravelType.FOOT, true);
    checkRoute(r2a, 1862.32935274551, 1424435996l, 1391280389l);
    Route r3a = computeRoute(1424435996l, 1391280389l, TravelType.ANY, true);
    checkRoute(r3a, 1862.32935274551, 1424435996l, 1391280389l);
}


@Test(timeout = 1000)
public void testSmallRouting49RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374398780l, 1699983533l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374398780l, 1699983533l, TravelType.BIKE, true);
    checkRoute(r0a, 2282.875415496271, 374398780l, 1699983533l);
    computeRoute(374398780l, 1699983533l, TravelType.CAR, false);
    Route r2a = computeRoute(374398780l, 1699983533l, TravelType.FOOT, true);
    checkRoute(r2a, 1454.9365213163735, 374398780l, 1699983533l);
    Route r3a = computeRoute(374398780l, 1699983533l, TravelType.ANY, true);
    checkRoute(r3a, 1454.9365213163735, 374398780l, 1699983533l);
}


@Test(timeout = 1000)
public void testSmallRouting50RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 704316334l, 1391280117l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(704316334l, 1391280117l, TravelType.BIKE, false);
    computeRoute(704316334l, 1391280117l, TravelType.CAR, false);
    Route r2a = computeRoute(704316334l, 1391280117l, TravelType.FOOT, true);
    checkRoute(r2a, 1980.9955976650224, 704316334l, 1391280117l);
    Route r3a = computeRoute(704316334l, 1391280117l, TravelType.ANY, true);
    checkRoute(r3a, 1979.9870669434347, 704316334l, 1391280117l);
}


@Test(timeout = 1000)
public void testSmallRouting51RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1289529864l, 2962755863l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1289529864l, 2962755863l, TravelType.BIKE, true);
    checkRoute(r0a, 3845.3723016210524, 1289529864l, 2962755863l);
    Route r1a = computeRoute(1289529864l, 2962755863l, TravelType.CAR, true);
    checkRoute(r1a, 3852.995451668373, 1289529864l, 2962755863l);
    Route r2a = computeRoute(1289529864l, 2962755863l, TravelType.FOOT, true);
    checkRoute(r2a, 2684.9489597470524, 1289529864l, 2962755863l);
    Route r3a = computeRoute(1289529864l, 2962755863l, TravelType.ANY, true);
    checkRoute(r3a, 2684.9489597470524, 1289529864l, 2962755863l);
}


@Test(timeout = 1000)
public void testSmallRouting52RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926891l, 277371523l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1422926891l, 277371523l, TravelType.BIKE, true);
    checkRoute(r0a, 1268.392988713156, 1422926891l, 277371523l);
    Route r1a = computeRoute(1422926891l, 277371523l, TravelType.CAR, true);
    checkRoute(r1a, 1274.268786228815, 1422926891l, 277371523l);
    Route r2a = computeRoute(1422926891l, 277371523l, TravelType.FOOT, true);
    checkRoute(r2a, 1189.2545817767634, 1422926891l, 277371523l);
    Route r3a = computeRoute(1422926891l, 277371523l, TravelType.ANY, true);
    checkRoute(r3a, 1172.1441520914962, 1422926891l, 277371523l);
}


@Test(timeout = 1000)
public void testSmallRouting53RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 784650249l, 784627574l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(784650249l, 784627574l, TravelType.BIKE, true);
    checkRoute(r0a, 2262.855847912213, 784650249l, 784627574l);
    computeRoute(784650249l, 784627574l, TravelType.CAR, false);
    Route r2a = computeRoute(784650249l, 784627574l, TravelType.FOOT, true);
    checkRoute(r2a, 1520.9068802325116, 784650249l, 784627574l);
    Route r3a = computeRoute(784650249l, 784627574l, TravelType.ANY, true);
    checkRoute(r3a, 1520.9068802325116, 784650249l, 784627574l);
}


@Test(timeout = 1000)
public void testSmallRouting54RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374392189l, 401505793l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374392189l, 401505793l, TravelType.BIKE, true);
    checkRoute(r0a, 3814.4702094886943, 374392189l, 401505793l);
    computeRoute(374392189l, 401505793l, TravelType.CAR, false);
    Route r2a = computeRoute(374392189l, 401505793l, TravelType.FOOT, true);
    checkRoute(r2a, 2991.361000072998, 374392189l, 401505793l);
    Route r3a = computeRoute(374392189l, 401505793l, TravelType.ANY, true);
    checkRoute(r3a, 2990.6068149608614, 374392189l, 401505793l);
}


@Test(timeout = 1000)
public void testSmallRouting55RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926333l, 374383357l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1422926333l, 374383357l, TravelType.BIKE, true);
    checkRoute(r0a, 1287.0133372844462, 1422926333l, 374383357l);
    computeRoute(1422926333l, 374383357l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926333l, 374383357l, TravelType.FOOT, true);
    checkRoute(r2a, 1229.7859260278174, 1422926333l, 374383357l);
    Route r3a = computeRoute(1422926333l, 374383357l, TravelType.ANY, true);
    checkRoute(r3a, 1229.7859260278174, 1422926333l, 374383357l);
}


@Test(timeout = 1000)
public void testSmallRouting56RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374385016l, 1035351767l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(374385016l, 1035351767l, TravelType.BIKE, false);
    computeRoute(374385016l, 1035351767l, TravelType.CAR, false);
    Route r2a = computeRoute(374385016l, 1035351767l, TravelType.FOOT, true);
    checkRoute(r2a, 363.986536669967, 374385016l, 1035351767l);
    Route r3a = computeRoute(374385016l, 1035351767l, TravelType.ANY, true);
    checkRoute(r3a, 363.986536669967, 374385016l, 1035351767l);
}


@Test(timeout = 1000)
public void testSmallRouting57RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374389930l, 1535754824l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374389930l, 1535754824l, TravelType.BIKE, true);
    checkRoute(r0a, 1749.2153358620412, 374389930l, 1535754824l);
    computeRoute(374389930l, 1535754824l, TravelType.CAR, false);
    Route r2a = computeRoute(374389930l, 1535754824l, TravelType.FOOT, true);
    checkRoute(r2a, 1749.2153358620412, 374389930l, 1535754824l);
    Route r3a = computeRoute(374389930l, 1535754824l, TravelType.ANY, true);
    checkRoute(r3a, 1749.2153358620412, 374389930l, 1535754824l);
}


@Test(timeout = 1000)
public void testSmallRouting58RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2425479734l, 292133931l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2425479734l, 292133931l, TravelType.BIKE, true);
    checkRoute(r0a, 1632.0980027198668, 2425479734l, 292133931l);
    Route r1a = computeRoute(2425479734l, 292133931l, TravelType.CAR, true);
    checkRoute(r1a, 1648.1285542320973, 2425479734l, 292133931l);
    Route r2a = computeRoute(2425479734l, 292133931l, TravelType.FOOT, true);
    checkRoute(r2a, 1627.2461111506425, 2425479734l, 292133931l);
    Route r3a = computeRoute(2425479734l, 292133931l, TravelType.ANY, true);
    checkRoute(r3a, 1627.2461111506425, 2425479734l, 292133931l);
}


@Test(timeout = 1000)
public void testSmallRouting59RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2410017211l, 1698369099l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2410017211l, 1698369099l, TravelType.BIKE, true);
    checkRoute(r0a, 2824.294304317222, 2410017211l, 1698369099l);
    computeRoute(2410017211l, 1698369099l, TravelType.CAR, false);
    Route r2a = computeRoute(2410017211l, 1698369099l, TravelType.FOOT, true);
    checkRoute(r2a, 2356.7649359070065, 2410017211l, 1698369099l);
    Route r3a = computeRoute(2410017211l, 1698369099l, TravelType.ANY, true);
    checkRoute(r3a, 2356.7649359070065, 2410017211l, 1698369099l);
}


@Test(timeout = 1000)
public void testSmallRouting60RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 408089274l, 1424435922l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(408089274l, 1424435922l, TravelType.BIKE, true);
    checkRoute(r0a, 208.494701990049, 408089274l, 1424435922l);
    computeRoute(408089274l, 1424435922l, TravelType.CAR, false);
    computeRoute(408089274l, 1424435922l, TravelType.FOOT, false);
    Route r3a = computeRoute(408089274l, 1424435922l, TravelType.ANY, true);
    checkRoute(r3a, 208.494701990049, 408089274l, 1424435922l);
}


@Test(timeout = 1000)
public void testSmallRouting61RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926108l, 1422926621l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1422926108l, 1422926621l, TravelType.BIKE, false);
    computeRoute(1422926108l, 1422926621l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926108l, 1422926621l, TravelType.FOOT, true);
    checkRoute(r2a, 384.7325622198864, 1422926108l, 1422926621l);
    Route r3a = computeRoute(1422926108l, 1422926621l, TravelType.ANY, true);
    checkRoute(r3a, 377.148818113751, 1422926108l, 1422926621l);
}


@Test(timeout = 1000)
public void testSmallRouting62RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 289243622l, 1700056370l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(289243622l, 1700056370l, TravelType.BIKE, true);
    checkRoute(r0a, 2804.7309105393574, 289243622l, 1700056370l);
    computeRoute(289243622l, 1700056370l, TravelType.CAR, false);
    Route r2a = computeRoute(289243622l, 1700056370l, TravelType.FOOT, true);
    checkRoute(r2a, 2059.1298576670233, 289243622l, 1700056370l);
    Route r3a = computeRoute(289243622l, 1700056370l, TravelType.ANY, true);
    checkRoute(r3a, 2059.1298576670233, 289243622l, 1700056370l);
}


@Test(timeout = 1000)
public void testSmallRouting63RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 279897193l, 1035351797l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(279897193l, 1035351797l, TravelType.BIKE, false);
    computeRoute(279897193l, 1035351797l, TravelType.CAR, false);
    Route r2a = computeRoute(279897193l, 1035351797l, TravelType.FOOT, true);
    checkRoute(r2a, 1651.8813005256952, 279897193l, 1035351797l);
    Route r3a = computeRoute(279897193l, 1035351797l, TravelType.ANY, true);
    checkRoute(r3a, 1651.8813005256952, 279897193l, 1035351797l);
}


@Test(timeout = 1000)
public void testSmallRouting64RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 344240692l, 784627740l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(344240692l, 784627740l, TravelType.BIKE, true);
    checkRoute(r0a, 1264.0332988341254, 344240692l, 784627740l);
    computeRoute(344240692l, 784627740l, TravelType.CAR, false);
    Route r2a = computeRoute(344240692l, 784627740l, TravelType.FOOT, true);
    checkRoute(r2a, 681.1077183353474, 344240692l, 784627740l);
    Route r3a = computeRoute(344240692l, 784627740l, TravelType.ANY, true);
    checkRoute(r3a, 681.1077183353474, 344240692l, 784627740l);
}


@Test(timeout = 1000)
public void testSmallRouting65RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1744624289l, 1154064666l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1744624289l, 1154064666l, TravelType.BIKE, false);
    computeRoute(1744624289l, 1154064666l, TravelType.CAR, false);
    Route r2a = computeRoute(1744624289l, 1154064666l, TravelType.FOOT, true);
    checkRoute(r2a, 1945.231037632579, 1744624289l, 1154064666l);
    Route r3a = computeRoute(1744624289l, 1154064666l, TravelType.ANY, true);
    checkRoute(r3a, 1939.8541673637278, 1744624289l, 1154064666l);
}


@Test(timeout = 1000)
public void testSmallRouting66RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1026110110l, 1312868222l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1026110110l, 1312868222l, TravelType.BIKE, false);
    computeRoute(1026110110l, 1312868222l, TravelType.CAR, false);
    Route r2a = computeRoute(1026110110l, 1312868222l, TravelType.FOOT, true);
    checkRoute(r2a, 734.1442857394766, 1026110110l, 1312868222l);
    Route r3a = computeRoute(1026110110l, 1312868222l, TravelType.ANY, true);
    checkRoute(r3a, 734.1442857394766, 1026110110l, 1312868222l);
}


@Test(timeout = 1000)
public void testSmallRouting67RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374383927l, 704316295l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(374383927l, 704316295l, TravelType.BIKE, false);
    computeRoute(374383927l, 704316295l, TravelType.CAR, false);
    Route r2a = computeRoute(374383927l, 704316295l, TravelType.FOOT, true);
    checkRoute(r2a, 1300.6968058619939, 374383927l, 704316295l);
    Route r3a = computeRoute(374383927l, 704316295l, TravelType.ANY, true);
    checkRoute(r3a, 1300.6968058619939, 374383927l, 704316295l);
}


@Test(timeout = 1000)
public void testSmallRouting68RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 628644612l, 374379164l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(628644612l, 374379164l, TravelType.BIKE, false);
    computeRoute(628644612l, 374379164l, TravelType.CAR, false);
    Route r2a = computeRoute(628644612l, 374379164l, TravelType.FOOT, true);
    checkRoute(r2a, 2449.5720805997607, 628644612l, 374379164l);
    Route r3a = computeRoute(628644612l, 374379164l, TravelType.ANY, true);
    checkRoute(r3a, 2449.5720805997607, 628644612l, 374379164l);
}


@Test(timeout = 1000)
public void testSmallRouting69RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2384341054l, 1422926910l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2384341054l, 1422926910l, TravelType.BIKE, false);
    computeRoute(2384341054l, 1422926910l, TravelType.CAR, false);
    Route r2a = computeRoute(2384341054l, 1422926910l, TravelType.FOOT, true);
    checkRoute(r2a, 828.7675599521799, 2384341054l, 1422926910l);
    Route r3a = computeRoute(2384341054l, 1422926910l, TravelType.ANY, true);
    checkRoute(r3a, 827.7590292305921, 2384341054l, 1422926910l);
}


@Test(timeout = 1000)
public void testSmallRouting70RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1398578640l, 1391319370l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1398578640l, 1391319370l, TravelType.BIKE, false);
    computeRoute(1398578640l, 1391319370l, TravelType.CAR, false);
    Route r2a = computeRoute(1398578640l, 1391319370l, TravelType.FOOT, true);
    checkRoute(r2a, 1977.3553108842218, 1398578640l, 1391319370l);
    Route r3a = computeRoute(1398578640l, 1391319370l, TravelType.ANY, true);
    checkRoute(r3a, 1977.3553108842218, 1398578640l, 1391319370l);
}


@Test(timeout = 1000)
public void testSmallRouting71RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3181272417l, 1597767482l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(3181272417l, 1597767482l, TravelType.BIKE, false);
    computeRoute(3181272417l, 1597767482l, TravelType.CAR, false);
    Route r2a = computeRoute(3181272417l, 1597767482l, TravelType.FOOT, true);
    checkRoute(r2a, 1074.7809209505588, 3181272417l, 1597767482l);
    Route r3a = computeRoute(3181272417l, 1597767482l, TravelType.ANY, true);
    checkRoute(r3a, 1074.7809209505588, 3181272417l, 1597767482l);
}


@Test(timeout = 1000)
public void testSmallRouting72RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1698369039l, 1502128183l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1698369039l, 1502128183l, TravelType.BIKE, true);
    checkRoute(r0a, 3092.2604127727427, 1698369039l, 1502128183l);
    computeRoute(1698369039l, 1502128183l, TravelType.CAR, false);
    Route r2a = computeRoute(1698369039l, 1502128183l, TravelType.FOOT, true);
    checkRoute(r2a, 2189.7342577856593, 1698369039l, 1502128183l);
    Route r3a = computeRoute(1698369039l, 1502128183l, TravelType.ANY, true);
    checkRoute(r3a, 2189.7342577856593, 1698369039l, 1502128183l);
}


@Test(timeout = 1000)
public void testSmallRouting73RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 344240640l, 344240649l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(344240640l, 344240649l, TravelType.BIKE, false);
    computeRoute(344240640l, 344240649l, TravelType.CAR, false);
    Route r2a = computeRoute(344240640l, 344240649l, TravelType.FOOT, true);
    checkRoute(r2a, 553.319521944479, 344240640l, 344240649l);
    Route r3a = computeRoute(344240640l, 344240649l, TravelType.ANY, true);
    checkRoute(r3a, 553.319521944479, 344240640l, 344240649l);
}


@Test(timeout = 1000)
public void testSmallRouting74RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424435980l, 535628855l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1424435980l, 535628855l, TravelType.BIKE, false);
    computeRoute(1424435980l, 535628855l, TravelType.CAR, false);
    Route r2a = computeRoute(1424435980l, 535628855l, TravelType.FOOT, true);
    checkRoute(r2a, 1237.5479520654992, 1424435980l, 535628855l);
    Route r3a = computeRoute(1424435980l, 535628855l, TravelType.ANY, true);
    checkRoute(r3a, 1237.5479520654992, 1424435980l, 535628855l);
}


@Test(timeout = 1000)
public void testSmallRouting75RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1298565100l, 1424436139l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1298565100l, 1424436139l, TravelType.BIKE, true);
    checkRoute(r0a, 1536.4369849664454, 1298565100l, 1424436139l);
    computeRoute(1298565100l, 1424436139l, TravelType.CAR, false);
    Route r2a = computeRoute(1298565100l, 1424436139l, TravelType.FOOT, true);
    checkRoute(r2a, 1161.131274453461, 1298565100l, 1424436139l);
    Route r3a = computeRoute(1298565100l, 1424436139l, TravelType.ANY, true);
    checkRoute(r3a, 1158.9117813326263, 1298565100l, 1424436139l);
}


@Test(timeout = 1000)
public void testSmallRouting76RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 823700193l, 455620299l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(823700193l, 455620299l, TravelType.BIKE, true);
    checkRoute(r0a, 2552.7328393890384, 823700193l, 455620299l);
    computeRoute(823700193l, 455620299l, TravelType.CAR, false);
    Route r2a = computeRoute(823700193l, 455620299l, TravelType.FOOT, true);
    checkRoute(r2a, 2129.2816278683254, 823700193l, 455620299l);
    Route r3a = computeRoute(823700193l, 455620299l, TravelType.ANY, true);
    checkRoute(r3a, 2129.2816278683254, 823700193l, 455620299l);
}


@Test(timeout = 1000)
public void testSmallRouting77RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 417401202l, 356280755l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(417401202l, 356280755l, TravelType.BIKE, false);
    computeRoute(417401202l, 356280755l, TravelType.CAR, false);
    computeRoute(417401202l, 356280755l, TravelType.FOOT, false);
    Route r3a = computeRoute(417401202l, 356280755l, TravelType.ANY, true);
    checkRoute(r3a, 2144.324424217538, 417401202l, 356280755l);
}


@Test(timeout = 1000)
public void testSmallRouting78RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374383357l, 1698368057l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374383357l, 1698368057l, TravelType.BIKE, true);
    checkRoute(r0a, 2404.0596058460646, 374383357l, 1698368057l);
    computeRoute(374383357l, 1698368057l, TravelType.CAR, false);
    Route r2a = computeRoute(374383357l, 1698368057l, TravelType.FOOT, true);
    checkRoute(r2a, 1994.7872890315782, 374383357l, 1698368057l);
    Route r3a = computeRoute(374383357l, 1698368057l, TravelType.ANY, true);
    checkRoute(r3a, 1994.7872890315782, 374383357l, 1698368057l);
}


@Test(timeout = 1000)
public void testSmallRouting79RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 295136483l, 2962747392l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(295136483l, 2962747392l, TravelType.BIKE, true);
    checkRoute(r0a, 2779.933605045448, 295136483l, 2962747392l);
    computeRoute(295136483l, 2962747392l, TravelType.CAR, false);
    Route r2a = computeRoute(295136483l, 2962747392l, TravelType.FOOT, true);
    checkRoute(r2a, 1906.2485196210662, 295136483l, 2962747392l);
    Route r3a = computeRoute(295136483l, 2962747392l, TravelType.ANY, true);
    checkRoute(r3a, 1906.2485196210662, 295136483l, 2962747392l);
}


@Test(timeout = 1000)
public void testSmallRouting80RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374384043l, 2632374130l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(374384043l, 2632374130l, TravelType.BIKE, false);
    computeRoute(374384043l, 2632374130l, TravelType.CAR, false);
    Route r2a = computeRoute(374384043l, 2632374130l, TravelType.FOOT, true);
    checkRoute(r2a, 1260.49745070505, 374384043l, 2632374130l);
    Route r3a = computeRoute(374384043l, 2632374130l, TravelType.ANY, true);
    checkRoute(r3a, 1260.49745070505, 374384043l, 2632374130l);
}


@Test(timeout = 1000)
public void testSmallRouting81RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1410392573l, 2458446104l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1410392573l, 2458446104l, TravelType.BIKE, false);
    computeRoute(1410392573l, 2458446104l, TravelType.CAR, false);
    Route r2a = computeRoute(1410392573l, 2458446104l, TravelType.FOOT, true);
    checkRoute(r2a, 529.3696595160337, 1410392573l, 2458446104l);
    Route r3a = computeRoute(1410392573l, 2458446104l, TravelType.ANY, true);
    checkRoute(r3a, 529.3696595160337, 1410392573l, 2458446104l);
}


@Test(timeout = 1000)
public void testSmallRouting82RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 417401111l, 1914458680l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(417401111l, 1914458680l, TravelType.BIKE, false);
    computeRoute(417401111l, 1914458680l, TravelType.CAR, false);
    Route r2a = computeRoute(417401111l, 1914458680l, TravelType.FOOT, true);
    checkRoute(r2a, 1198.3328056651933, 417401111l, 1914458680l);
    Route r3a = computeRoute(417401111l, 1914458680l, TravelType.ANY, true);
    checkRoute(r3a, 1198.3328056651933, 417401111l, 1914458680l);
}


@Test(timeout = 1000)
public void testSmallRouting83RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374378018l, 1398578644l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(374378018l, 1398578644l, TravelType.BIKE, false);
    computeRoute(374378018l, 1398578644l, TravelType.CAR, false);
    Route r2a = computeRoute(374378018l, 1398578644l, TravelType.FOOT, true);
    checkRoute(r2a, 1424.408751836669, 374378018l, 1398578644l);
    Route r3a = computeRoute(374378018l, 1398578644l, TravelType.ANY, true);
    checkRoute(r3a, 1423.7810094620718, 374378018l, 1398578644l);
}


@Test(timeout = 1000)
public void testSmallRouting84RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 384641272l, 374404672l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(384641272l, 374404672l, TravelType.BIKE, false);
    computeRoute(384641272l, 374404672l, TravelType.CAR, false);
    Route r2a = computeRoute(384641272l, 374404672l, TravelType.FOOT, true);
    checkRoute(r2a, 714.3922337061334, 384641272l, 374404672l);
    Route r3a = computeRoute(384641272l, 374404672l, TravelType.ANY, true);
    checkRoute(r3a, 714.3922337061334, 384641272l, 374404672l);
}


@Test(timeout = 1000)
public void testSmallRouting85RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1391319384l, 417783898l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1391319384l, 417783898l, TravelType.BIKE, true);
    checkRoute(r0a, 384.41992283254893, 1391319384l, 417783898l);
    computeRoute(1391319384l, 417783898l, TravelType.CAR, false);
    Route r2a = computeRoute(1391319384l, 417783898l, TravelType.FOOT, true);
    checkRoute(r2a, 310.5681901921561, 1391319384l, 417783898l);
    Route r3a = computeRoute(1391319384l, 417783898l, TravelType.ANY, true);
    checkRoute(r3a, 310.5681901921561, 1391319384l, 417783898l);
}


@Test(timeout = 1000)
public void testSmallRouting86RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 359725657l, 413037914l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(359725657l, 413037914l, TravelType.BIKE, false);
    computeRoute(359725657l, 413037914l, TravelType.CAR, false);
    Route r2a = computeRoute(359725657l, 413037914l, TravelType.FOOT, true);
    checkRoute(r2a, 1277.687382229855, 359725657l, 413037914l);
    Route r3a = computeRoute(359725657l, 413037914l, TravelType.ANY, true);
    checkRoute(r3a, 1277.687382229855, 359725657l, 413037914l);
}


@Test(timeout = 1000)
public void testSmallRouting87RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1035351689l, 1424436119l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1035351689l, 1424436119l, TravelType.BIKE, false);
    computeRoute(1035351689l, 1424436119l, TravelType.CAR, false);
    Route r2a = computeRoute(1035351689l, 1424436119l, TravelType.FOOT, true);
    checkRoute(r2a, 922.7028643004854, 1035351689l, 1424436119l);
    Route r3a = computeRoute(1035351689l, 1424436119l, TravelType.ANY, true);
    checkRoute(r3a, 922.7028643004854, 1035351689l, 1424436119l);
}


@Test(timeout = 1000)
public void testSmallRouting88RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 105825324l, 441557260l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(105825324l, 441557260l, TravelType.BIKE, false);
    computeRoute(105825324l, 441557260l, TravelType.CAR, false);
    Route r2a = computeRoute(105825324l, 441557260l, TravelType.FOOT, true);
    checkRoute(r2a, 113.77195732548076, 105825324l, 441557260l);
    Route r3a = computeRoute(105825324l, 441557260l, TravelType.ANY, true);
    checkRoute(r3a, 113.77195732548076, 105825324l, 441557260l);
}


@Test(timeout = 1000)
public void testSmallRouting89RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2962690333l, 356280760l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2962690333l, 356280760l, TravelType.BIKE, false);
    computeRoute(2962690333l, 356280760l, TravelType.CAR, false);
    Route r2a = computeRoute(2962690333l, 356280760l, TravelType.FOOT, true);
    checkRoute(r2a, 2661.3591660239117, 2962690333l, 356280760l);
    Route r3a = computeRoute(2962690333l, 356280760l, TravelType.ANY, true);
    checkRoute(r3a, 2661.3591660239117, 2962690333l, 356280760l);
}


@Test(timeout = 1000)
public void testSmallRouting90RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374378056l, 374404700l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374378056l, 374404700l, TravelType.BIKE, true);
    checkRoute(r0a, 1292.89674436868, 374378056l, 374404700l);
    computeRoute(374378056l, 374404700l, TravelType.CAR, false);
    Route r2a = computeRoute(374378056l, 374404700l, TravelType.FOOT, true);
    checkRoute(r2a, 1292.89674436868, 374378056l, 374404700l);
    Route r3a = computeRoute(374378056l, 374404700l, TravelType.ANY, true);
    checkRoute(r3a, 1292.89674436868, 374378056l, 374404700l);
}


@Test(timeout = 1000)
public void testSmallRouting91RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1559033710l, 823700103l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1559033710l, 823700103l, TravelType.BIKE, true);
    checkRoute(r0a, 2884.522852639682, 1559033710l, 823700103l);
    computeRoute(1559033710l, 823700103l, TravelType.CAR, false);
    Route r2a = computeRoute(1559033710l, 823700103l, TravelType.FOOT, true);
    checkRoute(r2a, 1206.8600521733388, 1559033710l, 823700103l);
    Route r3a = computeRoute(1559033710l, 823700103l, TravelType.ANY, true);
    checkRoute(r3a, 1206.8600521733388, 1559033710l, 823700103l);
}


@Test(timeout = 1000)
public void testSmallRouting92RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3024386493l, 374376820l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(3024386493l, 374376820l, TravelType.BIKE, false);
    computeRoute(3024386493l, 374376820l, TravelType.CAR, false);
    Route r2a = computeRoute(3024386493l, 374376820l, TravelType.FOOT, true);
    checkRoute(r2a, 3200.660033442028, 3024386493l, 374376820l);
    Route r3a = computeRoute(3024386493l, 374376820l, TravelType.ANY, true);
    checkRoute(r3a, 3200.660033442028, 3024386493l, 374376820l);
}


@Test(timeout = 1000)
public void testSmallRouting93RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374397845l, 823700161l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374397845l, 823700161l, TravelType.BIKE, true);
    checkRoute(r0a, 3571.4955618321446, 374397845l, 823700161l);
    computeRoute(374397845l, 823700161l, TravelType.CAR, false);
    Route r2a = computeRoute(374397845l, 823700161l, TravelType.FOOT, true);
    checkRoute(r2a, 2809.3354289132803, 374397845l, 823700161l);
    Route r3a = computeRoute(374397845l, 823700161l, TravelType.ANY, true);
    checkRoute(r3a, 2809.3354289132803, 374397845l, 823700161l);
}


@Test(timeout = 1000)
public void testSmallRouting94RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424436205l, 1026109985l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1424436205l, 1026109985l, TravelType.BIKE, false);
    computeRoute(1424436205l, 1026109985l, TravelType.CAR, false);
    Route r2a = computeRoute(1424436205l, 1026109985l, TravelType.FOOT, true);
    checkRoute(r2a, 1847.4099604907556, 1424436205l, 1026109985l);
    Route r3a = computeRoute(1424436205l, 1026109985l, TravelType.ANY, true);
    checkRoute(r3a, 1846.4014297691679, 1424436205l, 1026109985l);
}


@Test(timeout = 1000)
public void testSmallRouting95RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926668l, 374384054l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1422926668l, 374384054l, TravelType.BIKE, false);
    computeRoute(1422926668l, 374384054l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926668l, 374384054l, TravelType.FOOT, true);
    checkRoute(r2a, 1164.3369464262496, 1422926668l, 374384054l);
    Route r3a = computeRoute(1422926668l, 374384054l, TravelType.ANY, true);
    checkRoute(r3a, 1162.1510942557204, 1422926668l, 374384054l);
}


@Test(timeout = 1000)
public void testSmallRouting96RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 997708278l, 1422926559l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(997708278l, 1422926559l, TravelType.BIKE, false);
    computeRoute(997708278l, 1422926559l, TravelType.CAR, false);
    Route r2a = computeRoute(997708278l, 1422926559l, TravelType.FOOT, true);
    checkRoute(r2a, 2484.797404238657, 997708278l, 1422926559l);
    Route r3a = computeRoute(997708278l, 1422926559l, TravelType.ANY, true);
    checkRoute(r3a, 2484.797404238657, 997708278l, 1422926559l);
}


@Test(timeout = 1000)
public void testSmallRouting97RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1391280395l, 417401197l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1391280395l, 417401197l, TravelType.BIKE, false);
    computeRoute(1391280395l, 417401197l, TravelType.CAR, false);
    Route r2a = computeRoute(1391280395l, 417401197l, TravelType.FOOT, true);
    checkRoute(r2a, 967.939448832457, 1391280395l, 417401197l);
    Route r3a = computeRoute(1391280395l, 417401197l, TravelType.ANY, true);
    checkRoute(r3a, 967.939448832457, 1391280395l, 417401197l);
}


@Test(timeout = 1000)
public void testSmallRouting98RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1035351764l, 1324588183l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1035351764l, 1324588183l, TravelType.BIKE, false);
    computeRoute(1035351764l, 1324588183l, TravelType.CAR, false);
    Route r2a = computeRoute(1035351764l, 1324588183l, TravelType.FOOT, true);
    checkRoute(r2a, 431.87484240039896, 1035351764l, 1324588183l);
    Route r3a = computeRoute(1035351764l, 1324588183l, TravelType.ANY, true);
    checkRoute(r3a, 431.87484240039896, 1035351764l, 1324588183l);
}


@Test(timeout = 1000)
public void testSmallRouting99RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2102911329l, 1558424924l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2102911329l, 1558424924l, TravelType.BIKE, false);
    computeRoute(2102911329l, 1558424924l, TravelType.CAR, false);
    Route r2a = computeRoute(2102911329l, 1558424924l, TravelType.FOOT, true);
    checkRoute(r2a, 1073.3603819587404, 2102911329l, 1558424924l);
    Route r3a = computeRoute(2102911329l, 1558424924l, TravelType.ANY, true);
    checkRoute(r3a, 1073.3603819587404, 2102911329l, 1558424924l);
}


@Test(timeout = 1000)
public void testSmallRouting100RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1426601000l, 2962755879l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1426601000l, 2962755879l, TravelType.BIKE, true);
    checkRoute(r0a, 2997.0679920843327, 1426601000l, 2962755879l);
    computeRoute(1426601000l, 2962755879l, TravelType.CAR, false);
    Route r2a = computeRoute(1426601000l, 2962755879l, TravelType.FOOT, true);
    checkRoute(r2a, 2968.043959788521, 1426601000l, 2962755879l);
    Route r3a = computeRoute(1426601000l, 2962755879l, TravelType.ANY, true);
    checkRoute(r3a, 2968.043959788521, 1426601000l, 2962755879l);
}


@Test(timeout = 1000)
public void testSmallRouting101RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 267628530l, 1388219610l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(267628530l, 1388219610l, TravelType.BIKE, false);
    computeRoute(267628530l, 1388219610l, TravelType.CAR, false);
    Route r2a = computeRoute(267628530l, 1388219610l, TravelType.FOOT, true);
    checkRoute(r2a, 239.68026962238616, 267628530l, 1388219610l);
    Route r3a = computeRoute(267628530l, 1388219610l, TravelType.ANY, true);
    checkRoute(r3a, 239.68026962238616, 267628530l, 1388219610l);
}


@Test(timeout = 1000)
public void testSmallRouting102RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424436084l, 267628545l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1424436084l, 267628545l, TravelType.BIKE, false);
    computeRoute(1424436084l, 267628545l, TravelType.CAR, false);
    Route r2a = computeRoute(1424436084l, 267628545l, TravelType.FOOT, true);
    checkRoute(r2a, 1645.0919005115538, 1424436084l, 267628545l);
    Route r3a = computeRoute(1424436084l, 267628545l, TravelType.ANY, true);
    checkRoute(r3a, 1645.0919005115538, 1424436084l, 267628545l);
}


@Test(timeout = 1000)
public void testSmallRouting103RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424435998l, 784650302l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1424435998l, 784650302l, TravelType.BIKE, false);
    computeRoute(1424435998l, 784650302l, TravelType.CAR, false);
    Route r2a = computeRoute(1424435998l, 784650302l, TravelType.FOOT, true);
    checkRoute(r2a, 1941.501890945328, 1424435998l, 784650302l);
    Route r3a = computeRoute(1424435998l, 784650302l, TravelType.ANY, true);
    checkRoute(r3a, 1941.501890945328, 1424435998l, 784650302l);
}


@Test(timeout = 1000)
public void testSmallRouting104RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1058856534l, 1422926193l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1058856534l, 1422926193l, TravelType.BIKE, true);
    checkRoute(r0a, 323.274640724438, 1058856534l, 1422926193l);
    computeRoute(1058856534l, 1422926193l, TravelType.CAR, false);
    Route r2a = computeRoute(1058856534l, 1422926193l, TravelType.FOOT, true);
    checkRoute(r2a, 318.96981311324174, 1058856534l, 1422926193l);
    Route r3a = computeRoute(1058856534l, 1422926193l, TravelType.ANY, true);
    checkRoute(r3a, 318.96981311324174, 1058856534l, 1422926193l);
}


@Test(timeout = 1000)
public void testSmallRouting105RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2384371105l, 823700228l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2384371105l, 823700228l, TravelType.BIKE, true);
    checkRoute(r0a, 2968.240784714531, 2384371105l, 823700228l);
    computeRoute(2384371105l, 823700228l, TravelType.CAR, false);
    Route r2a = computeRoute(2384371105l, 823700228l, TravelType.FOOT, true);
    checkRoute(r2a, 2416.1741673359047, 2384371105l, 823700228l);
    Route r3a = computeRoute(2384371105l, 823700228l, TravelType.ANY, true);
    checkRoute(r3a, 2416.1741673359047, 2384371105l, 823700228l);
}


@Test(timeout = 1000)
public void testSmallRouting106RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926621l, 1410392573l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1422926621l, 1410392573l, TravelType.BIKE, false);
    computeRoute(1422926621l, 1410392573l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926621l, 1410392573l, TravelType.FOOT, true);
    checkRoute(r2a, 326.7912070251387, 1422926621l, 1410392573l);
    Route r3a = computeRoute(1422926621l, 1410392573l, TravelType.ANY, true);
    checkRoute(r3a, 324.11457051033346, 1422926621l, 1410392573l);
}


@Test(timeout = 1000)
public void testSmallRouting107RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1324607770l, 1698343699l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1324607770l, 1698343699l, TravelType.BIKE, true);
    checkRoute(r0a, 2380.576129585177, 1324607770l, 1698343699l);
    computeRoute(1324607770l, 1698343699l, TravelType.CAR, false);
    Route r2a = computeRoute(1324607770l, 1698343699l, TravelType.FOOT, true);
    checkRoute(r2a, 2380.576129585177, 1324607770l, 1698343699l);
    Route r3a = computeRoute(1324607770l, 1698343699l, TravelType.ANY, true);
    checkRoute(r3a, 2380.576129585177, 1324607770l, 1698343699l);
}


@Test(timeout = 1000)
public void testSmallRouting108RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 356280761l, 1422926246l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(356280761l, 1422926246l, TravelType.BIKE, false);
    computeRoute(356280761l, 1422926246l, TravelType.CAR, false);
    Route r2a = computeRoute(356280761l, 1422926246l, TravelType.FOOT, true);
    checkRoute(r2a, 1709.870915804446, 356280761l, 1422926246l);
    Route r3a = computeRoute(356280761l, 1422926246l, TravelType.ANY, true);
    checkRoute(r3a, 1709.11673069231, 356280761l, 1422926246l);
}


@Test(timeout = 1000)
public void testSmallRouting109RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 375768657l, 1698371701l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(375768657l, 1698371701l, TravelType.BIKE, false);
    computeRoute(375768657l, 1698371701l, TravelType.CAR, false);
    Route r2a = computeRoute(375768657l, 1698371701l, TravelType.FOOT, true);
    checkRoute(r2a, 845.9833340443457, 375768657l, 1698371701l);
    Route r3a = computeRoute(375768657l, 1698371701l, TravelType.ANY, true);
    checkRoute(r3a, 845.9833340443457, 375768657l, 1698371701l);
}


@Test(timeout = 1000)
public void testSmallRouting110RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2962747389l, 1700012861l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2962747389l, 1700012861l, TravelType.BIKE, true);
    checkRoute(r0a, 3113.1826203421147, 2962747389l, 1700012861l);
    computeRoute(2962747389l, 1700012861l, TravelType.CAR, false);
    Route r2a = computeRoute(2962747389l, 1700012861l, TravelType.FOOT, true);
    checkRoute(r2a, 2873.5401898995174, 2962747389l, 1700012861l);
    Route r3a = computeRoute(2962747389l, 1700012861l, TravelType.ANY, true);
    checkRoute(r3a, 2873.5401898995174, 2962747389l, 1700012861l);
}


@Test(timeout = 1000)
public void testSmallRouting111RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1026109915l, 1324591101l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1026109915l, 1324591101l, TravelType.BIKE, false);
    computeRoute(1026109915l, 1324591101l, TravelType.CAR, false);
    Route r2a = computeRoute(1026109915l, 1324591101l, TravelType.FOOT, true);
    checkRoute(r2a, 787.4643709127079, 1026109915l, 1324591101l);
    Route r3a = computeRoute(1026109915l, 1324591101l, TravelType.ANY, true);
    checkRoute(r3a, 787.4643709127079, 1026109915l, 1324591101l);
}


@Test(timeout = 1000)
public void testSmallRouting112RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 698533322l, 375768661l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(698533322l, 375768661l, TravelType.BIKE, true);
    checkRoute(r0a, 1709.2987943328299, 698533322l, 375768661l);
    computeRoute(698533322l, 375768661l, TravelType.CAR, false);
    Route r2a = computeRoute(698533322l, 375768661l, TravelType.FOOT, true);
    checkRoute(r2a, 1191.5177350673862, 698533322l, 375768661l);
    Route r3a = computeRoute(698533322l, 375768661l, TravelType.ANY, true);
    checkRoute(r3a, 1191.5177350673862, 698533322l, 375768661l);
}


@Test(timeout = 1000)
public void testSmallRouting113RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 267461345l, 2962755877l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(267461345l, 2962755877l, TravelType.BIKE, true);
    checkRoute(r0a, 1029.5927456698437, 267461345l, 2962755877l);
    computeRoute(267461345l, 2962755877l, TravelType.CAR, false);
    Route r2a = computeRoute(267461345l, 2962755877l, TravelType.FOOT, true);
    checkRoute(r2a, 897.9280185108543, 267461345l, 2962755877l);
    Route r3a = computeRoute(267461345l, 2962755877l, TravelType.ANY, true);
    checkRoute(r3a, 897.9280185108543, 267461345l, 2962755877l);
}


@Test(timeout = 1000)
public void testSmallRouting114RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 256603120l, 1391280393l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(256603120l, 1391280393l, TravelType.BIKE, false);
    computeRoute(256603120l, 1391280393l, TravelType.CAR, false);
    Route r2a = computeRoute(256603120l, 1391280393l, TravelType.FOOT, true);
    checkRoute(r2a, 2020.5767224281788, 256603120l, 1391280393l);
    Route r3a = computeRoute(256603120l, 1391280393l, TravelType.ANY, true);
    checkRoute(r3a, 2020.5767224281788, 256603120l, 1391280393l);
}


@Test(timeout = 1000)
public void testSmallRouting115RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424436080l, 374383366l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1424436080l, 374383366l, TravelType.BIKE, true);
    checkRoute(r0a, 1703.1194891178552, 1424436080l, 374383366l);
    computeRoute(1424436080l, 374383366l, TravelType.CAR, false);
    Route r2a = computeRoute(1424436080l, 374383366l, TravelType.FOOT, true);
    checkRoute(r2a, 647.3810879867492, 1424436080l, 374383366l);
    Route r3a = computeRoute(1424436080l, 374383366l, TravelType.ANY, true);
    checkRoute(r3a, 647.3810879867492, 1424436080l, 374383366l);
}


@Test(timeout = 1000)
public void testSmallRouting116RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 267934189l, 289943752l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(267934189l, 289943752l, TravelType.BIKE, true);
    checkRoute(r0a, 4015.2968142009017, 267934189l, 289943752l);
    computeRoute(267934189l, 289943752l, TravelType.CAR, false);
    Route r2a = computeRoute(267934189l, 289943752l, TravelType.FOOT, true);
    checkRoute(r2a, 3400.013919061662, 267934189l, 289943752l);
    Route r3a = computeRoute(267934189l, 289943752l, TravelType.ANY, true);
    checkRoute(r3a, 3400.013919061662, 267934189l, 289943752l);
}


@Test(timeout = 1000)
public void testSmallRouting117RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1478303877l, 610892373l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1478303877l, 610892373l, TravelType.BIKE, true);
    checkRoute(r0a, 1587.3662340716874, 1478303877l, 610892373l);
    computeRoute(1478303877l, 610892373l, TravelType.CAR, false);
    Route r2a = computeRoute(1478303877l, 610892373l, TravelType.FOOT, true);
    checkRoute(r2a, 1587.3662340716874, 1478303877l, 610892373l);
    Route r3a = computeRoute(1478303877l, 610892373l, TravelType.ANY, true);
    checkRoute(r3a, 1587.3662340716874, 1478303877l, 610892373l);
}


@Test(timeout = 1000)
public void testSmallRouting118RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1035351685l, 1391280100l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1035351685l, 1391280100l, TravelType.BIKE, false);
    computeRoute(1035351685l, 1391280100l, TravelType.CAR, false);
    Route r2a = computeRoute(1035351685l, 1391280100l, TravelType.FOOT, true);
    checkRoute(r2a, 688.9376362264456, 1035351685l, 1391280100l);
    Route r3a = computeRoute(1035351685l, 1391280100l, TravelType.ANY, true);
    checkRoute(r3a, 688.9376362264456, 1035351685l, 1391280100l);
}


@Test(timeout = 1000)
public void testSmallRouting119RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 455620289l, 267461478l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(455620289l, 267461478l, TravelType.BIKE, true);
    checkRoute(r0a, 1737.3647744186296, 455620289l, 267461478l);
    computeRoute(455620289l, 267461478l, TravelType.CAR, false);
    Route r2a = computeRoute(455620289l, 267461478l, TravelType.FOOT, true);
    checkRoute(r2a, 1289.8557389107468, 455620289l, 267461478l);
    Route r3a = computeRoute(455620289l, 267461478l, TravelType.ANY, true);
    checkRoute(r3a, 1289.8557389107468, 455620289l, 267461478l);
}


@Test(timeout = 1000)
public void testSmallRouting120RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 823700161l, 1312868215l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(823700161l, 1312868215l, TravelType.BIKE, true);
    checkRoute(r0a, 2206.6222609675924, 823700161l, 1312868215l);
    computeRoute(823700161l, 1312868215l, TravelType.CAR, false);
    Route r2a = computeRoute(823700161l, 1312868215l, TravelType.FOOT, true);
    checkRoute(r2a, 2170.9166287525354, 823700161l, 1312868215l);
    Route r3a = computeRoute(823700161l, 1312868215l, TravelType.ANY, true);
    checkRoute(r3a, 2170.9166287525354, 823700161l, 1312868215l);
}


@Test(timeout = 1000)
public void testSmallRouting121RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1033294340l, 1034349926l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1033294340l, 1034349926l, TravelType.BIKE, false);
    computeRoute(1033294340l, 1034349926l, TravelType.CAR, false);
    Route r2a = computeRoute(1033294340l, 1034349926l, TravelType.FOOT, true);
    checkRoute(r2a, 233.20117598887654, 1033294340l, 1034349926l);
    Route r3a = computeRoute(1033294340l, 1034349926l, TravelType.ANY, true);
    checkRoute(r3a, 233.20117598887654, 1033294340l, 1034349926l);
}


@Test(timeout = 1000)
public void testSmallRouting122RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1058856540l, 1312868222l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1058856540l, 1312868222l, TravelType.BIKE, false);
    computeRoute(1058856540l, 1312868222l, TravelType.CAR, false);
    Route r2a = computeRoute(1058856540l, 1312868222l, TravelType.FOOT, true);
    checkRoute(r2a, 1686.9339097745226, 1058856540l, 1312868222l);
    Route r3a = computeRoute(1058856540l, 1312868222l, TravelType.ANY, true);
    checkRoute(r3a, 1686.9339097745226, 1058856540l, 1312868222l);
}


@Test(timeout = 1000)
public void testSmallRouting123RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 295136483l, 1324591088l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(295136483l, 1324591088l, TravelType.BIKE, false);
    computeRoute(295136483l, 1324591088l, TravelType.CAR, false);
    Route r2a = computeRoute(295136483l, 1324591088l, TravelType.FOOT, true);
    checkRoute(r2a, 1956.8704599817418, 295136483l, 1324591088l);
    Route r3a = computeRoute(295136483l, 1324591088l, TravelType.ANY, true);
    checkRoute(r3a, 1956.8704599817418, 295136483l, 1324591088l);
}


@Test(timeout = 1000)
public void testSmallRouting124RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 359725627l, 1558424919l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(359725627l, 1558424919l, TravelType.BIKE, false);
    computeRoute(359725627l, 1558424919l, TravelType.CAR, false);
    Route r2a = computeRoute(359725627l, 1558424919l, TravelType.FOOT, true);
    checkRoute(r2a, 1191.2130533686525, 359725627l, 1558424919l);
    Route r3a = computeRoute(359725627l, 1558424919l, TravelType.ANY, true);
    checkRoute(r3a, 1191.2130533686525, 359725627l, 1558424919l);
}


@Test(timeout = 1000)
public void testSmallRouting125RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 295136312l, 384641277l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(295136312l, 384641277l, TravelType.BIKE, false);
    computeRoute(295136312l, 384641277l, TravelType.CAR, false);
    Route r2a = computeRoute(295136312l, 384641277l, TravelType.FOOT, true);
    checkRoute(r2a, 2972.349725740133, 295136312l, 384641277l);
    Route r3a = computeRoute(295136312l, 384641277l, TravelType.ANY, true);
    checkRoute(r3a, 2972.349725740133, 295136312l, 384641277l);
}


@Test(timeout = 1000)
public void testSmallRouting126RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1398578640l, 784650251l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1398578640l, 784650251l, TravelType.BIKE, false);
    computeRoute(1398578640l, 784650251l, TravelType.CAR, false);
    Route r2a = computeRoute(1398578640l, 784650251l, TravelType.FOOT, true);
    checkRoute(r2a, 2527.2840744062883, 1398578640l, 784650251l);
    Route r3a = computeRoute(1398578640l, 784650251l, TravelType.ANY, true);
    checkRoute(r3a, 2527.2840744062883, 1398578640l, 784650251l);
}


@Test(timeout = 1000)
public void testSmallRouting127RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374378903l, 344446139l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374378903l, 344446139l, TravelType.BIKE, true);
    checkRoute(r0a, 3494.5493912975894, 374378903l, 344446139l);
    computeRoute(374378903l, 344446139l, TravelType.CAR, false);
    Route r2a = computeRoute(374378903l, 344446139l, TravelType.FOOT, true);
    checkRoute(r2a, 1597.3884421788484, 374378903l, 344446139l);
    Route r3a = computeRoute(374378903l, 344446139l, TravelType.ANY, true);
    checkRoute(r3a, 1597.3884421788484, 374378903l, 344446139l);
}


@Override
public String getMapFileName() {
    return "campus.osm.nae";
}


}