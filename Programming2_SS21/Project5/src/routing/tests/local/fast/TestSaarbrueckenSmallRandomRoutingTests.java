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
public class TestSaarbrueckenSmallRandomRoutingTests extends TestingBase {

@Test(timeout = 3000)
public void testSmallRouting0RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 267035004l, 1520395047l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(267035004l, 1520395047l, TravelType.BIKE, false);
    computeRoute(267035004l, 1520395047l, TravelType.CAR, false);
    computeRoute(267035004l, 1520395047l, TravelType.FOOT, false);
    Route r3a = computeRoute(267035004l, 1520395047l, TravelType.ANY, true);
    checkRoute(r3a, 4235.258942140828, 267035004l, 1520395047l);
}


@Test(timeout = 3000)
public void testSmallRouting1RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2269763267l, 814664333l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2269763267l, 814664333l, TravelType.BIKE, false);
    computeRoute(2269763267l, 814664333l, TravelType.CAR, false);
    Route r2a = computeRoute(2269763267l, 814664333l, TravelType.FOOT, true);
    checkRoute(r2a, 3441.5897916009903, 2269763267l, 814664333l);
    Route r3a = computeRoute(2269763267l, 814664333l, TravelType.ANY, true);
    checkRoute(r3a, 3441.5897916009903, 2269763267l, 814664333l);
}


@Test(timeout = 3000)
public void testSmallRouting2RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 415795050l, 470283288l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(415795050l, 470283288l, TravelType.BIKE, false);
    computeRoute(415795050l, 470283288l, TravelType.CAR, false);
    computeRoute(415795050l, 470283288l, TravelType.FOOT, false);
    Route r3a = computeRoute(415795050l, 470283288l, TravelType.ANY, true);
    checkRoute(r3a, 6619.762823922266, 415795050l, 470283288l);
}


@Test(timeout = 3000)
public void testSmallRouting3RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424436215l, 2291806784l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1424436215l, 2291806784l, TravelType.BIKE, false);
    computeRoute(1424436215l, 2291806784l, TravelType.CAR, false);
    Route r2a = computeRoute(1424436215l, 2291806784l, TravelType.FOOT, true);
    checkRoute(r2a, 3622.661393856044, 1424436215l, 2291806784l);
    Route r3a = computeRoute(1424436215l, 2291806784l, TravelType.ANY, true);
    checkRoute(r3a, 3622.661393856044, 1424436215l, 2291806784l);
}


@Test(timeout = 3000)
public void testSmallRouting4RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 472416466l, 2889705383l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(472416466l, 2889705383l, TravelType.BIKE, true);
    checkRoute(r0a, 5328.431430937195, 472416466l, 2889705383l);
    computeRoute(472416466l, 2889705383l, TravelType.CAR, false);
    Route r2a = computeRoute(472416466l, 2889705383l, TravelType.FOOT, true);
    checkRoute(r2a, 4586.429971797672, 472416466l, 2889705383l);
    Route r3a = computeRoute(472416466l, 2889705383l, TravelType.ANY, true);
    checkRoute(r3a, 4586.429971797672, 472416466l, 2889705383l);
}


@Test(timeout = 3000)
public void testSmallRouting5RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1392066844l, 1123424747l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1392066844l, 1123424747l, TravelType.BIKE, false);
    computeRoute(1392066844l, 1123424747l, TravelType.CAR, false);
    Route r2a = computeRoute(1392066844l, 1123424747l, TravelType.FOOT, true);
    checkRoute(r2a, 8058.659987159245, 1392066844l, 1123424747l);
    Route r3a = computeRoute(1392066844l, 1123424747l, TravelType.ANY, true);
    checkRoute(r3a, 8057.25779252744, 1392066844l, 1123424747l);
}


@Test(timeout = 3000)
public void testSmallRouting6RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1424237531l, 1551745822l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1424237531l, 1551745822l, TravelType.BIKE, true);
    checkRoute(r0a, 5653.9522070302, 1424237531l, 1551745822l);
    computeRoute(1424237531l, 1551745822l, TravelType.CAR, false);
    Route r2a = computeRoute(1424237531l, 1551745822l, TravelType.FOOT, true);
    checkRoute(r2a, 4701.780351217257, 1424237531l, 1551745822l);
    Route r3a = computeRoute(1424237531l, 1551745822l, TravelType.ANY, true);
    checkRoute(r3a, 4701.780351217257, 1424237531l, 1551745822l);
}


@Test(timeout = 3000)
public void testSmallRouting7RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 500789117l, 1754018194l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(500789117l, 1754018194l, TravelType.BIKE, false);
    computeRoute(500789117l, 1754018194l, TravelType.CAR, false);
    Route r2a = computeRoute(500789117l, 1754018194l, TravelType.FOOT, true);
    checkRoute(r2a, 1439.2868899887342, 500789117l, 1754018194l);
    Route r3a = computeRoute(500789117l, 1754018194l, TravelType.ANY, true);
    checkRoute(r3a, 1439.2868899887342, 500789117l, 1754018194l);
}


@Test(timeout = 3000)
public void testSmallRouting8RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1267452614l, 2199186783l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1267452614l, 2199186783l, TravelType.BIKE, false);
    computeRoute(1267452614l, 2199186783l, TravelType.CAR, false);
    Route r2a = computeRoute(1267452614l, 2199186783l, TravelType.FOOT, true);
    checkRoute(r2a, 6998.876456573215, 1267452614l, 2199186783l);
    Route r3a = computeRoute(1267452614l, 2199186783l, TravelType.ANY, true);
    checkRoute(r3a, 6997.472897924688, 1267452614l, 2199186783l);
}


@Test(timeout = 3000)
public void testSmallRouting9RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1535754791l, 1428397905l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1535754791l, 1428397905l, TravelType.BIKE, false);
    computeRoute(1535754791l, 1428397905l, TravelType.CAR, false);
    Route r2a = computeRoute(1535754791l, 1428397905l, TravelType.FOOT, true);
    checkRoute(r2a, 4219.94738351103, 1535754791l, 1428397905l);
    Route r3a = computeRoute(1535754791l, 1428397905l, TravelType.ANY, true);
    checkRoute(r3a, 4219.94738351103, 1535754791l, 1428397905l);
}


@Test(timeout = 3000)
public void testSmallRouting10RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1376542035l, 294888522l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1376542035l, 294888522l, TravelType.BIKE, false);
    computeRoute(1376542035l, 294888522l, TravelType.CAR, false);
    Route r2a = computeRoute(1376542035l, 294888522l, TravelType.FOOT, true);
    checkRoute(r2a, 3097.049071908245, 1376542035l, 294888522l);
    Route r3a = computeRoute(1376542035l, 294888522l, TravelType.ANY, true);
    checkRoute(r3a, 3097.049071908245, 1376542035l, 294888522l);
}


@Test(timeout = 3000)
public void testSmallRouting11RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2027712856l, 773561691l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2027712856l, 773561691l, TravelType.BIKE, false);
    computeRoute(2027712856l, 773561691l, TravelType.CAR, false);
    Route r2a = computeRoute(2027712856l, 773561691l, TravelType.FOOT, true);
    checkRoute(r2a, 3598.510792963303, 2027712856l, 773561691l);
    Route r3a = computeRoute(2027712856l, 773561691l, TravelType.ANY, true);
    checkRoute(r3a, 3598.1961143073313, 2027712856l, 773561691l);
}


@Test(timeout = 3000)
public void testSmallRouting12RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1426027517l, 1559582642l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1426027517l, 1559582642l, TravelType.BIKE, false);
    computeRoute(1426027517l, 1559582642l, TravelType.CAR, false);
    Route r2a = computeRoute(1426027517l, 1559582642l, TravelType.FOOT, true);
    checkRoute(r2a, 8219.107259925215, 1426027517l, 1559582642l);
    Route r3a = computeRoute(1426027517l, 1559582642l, TravelType.ANY, true);
    checkRoute(r3a, 8218.793337155497, 1426027517l, 1559582642l);
}


@Test(timeout = 3000)
public void testSmallRouting13RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 814707146l, 169541607l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(814707146l, 169541607l, TravelType.BIKE, false);
    computeRoute(814707146l, 169541607l, TravelType.CAR, false);
    Route r2a = computeRoute(814707146l, 169541607l, TravelType.FOOT, true);
    checkRoute(r2a, 2835.5922130753297, 814707146l, 169541607l);
    Route r3a = computeRoute(814707146l, 169541607l, TravelType.ANY, true);
    checkRoute(r3a, 2835.5922130753297, 814707146l, 169541607l);
}


@Test(timeout = 3000)
public void testSmallRouting14RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 274809829l, 1990238911l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(274809829l, 1990238911l, TravelType.BIKE, true);
    checkRoute(r0a, 4641.905119231283, 274809829l, 1990238911l);
    Route r1a = computeRoute(274809829l, 1990238911l, TravelType.CAR, true);
    checkRoute(r1a, 5023.672153213733, 274809829l, 1990238911l);
    Route r2a = computeRoute(274809829l, 1990238911l, TravelType.FOOT, true);
    checkRoute(r2a, 4406.867345170679, 274809829l, 1990238911l);
    Route r3a = computeRoute(274809829l, 1990238911l, TravelType.ANY, true);
    checkRoute(r3a, 4406.867345170679, 274809829l, 1990238911l);
}


@Test(timeout = 3000)
public void testSmallRouting15RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 142631369l, 790024551l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(142631369l, 790024551l, TravelType.BIKE, true);
    checkRoute(r0a, 3026.3191152327695, 142631369l, 790024551l);
    Route r1a = computeRoute(142631369l, 790024551l, TravelType.CAR, true);
    checkRoute(r1a, 3072.512419311892, 142631369l, 790024551l);
    Route r2a = computeRoute(142631369l, 790024551l, TravelType.FOOT, true);
    checkRoute(r2a, 2842.611331938181, 142631369l, 790024551l);
    Route r3a = computeRoute(142631369l, 790024551l, TravelType.ANY, true);
    checkRoute(r3a, 2842.611331938181, 142631369l, 790024551l);
}


@Test(timeout = 3000)
public void testSmallRouting16RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1390041145l, 709962046l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1390041145l, 709962046l, TravelType.BIKE, false);
    computeRoute(1390041145l, 709962046l, TravelType.CAR, false);
    Route r2a = computeRoute(1390041145l, 709962046l, TravelType.FOOT, true);
    checkRoute(r2a, 4045.6579218447205, 1390041145l, 709962046l);
    Route r3a = computeRoute(1390041145l, 709962046l, TravelType.ANY, true);
    checkRoute(r3a, 4045.6579218447205, 1390041145l, 709962046l);
}


@Test(timeout = 3000)
public void testSmallRouting17RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1195845838l, 2889672374l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1195845838l, 2889672374l, TravelType.BIKE, false);
    computeRoute(1195845838l, 2889672374l, TravelType.CAR, false);
    Route r2a = computeRoute(1195845838l, 2889672374l, TravelType.FOOT, true);
    checkRoute(r2a, 1715.2469874560948, 1195845838l, 2889672374l);
    Route r3a = computeRoute(1195845838l, 2889672374l, TravelType.ANY, true);
    checkRoute(r3a, 1715.2469874560948, 1195845838l, 2889672374l);
}


@Test(timeout = 3000)
public void testSmallRouting18RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 287875674l, 271054647l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(287875674l, 271054647l, TravelType.BIKE, false);
    computeRoute(287875674l, 271054647l, TravelType.CAR, false);
    Route r2a = computeRoute(287875674l, 271054647l, TravelType.FOOT, true);
    checkRoute(r2a, 3390.2693223574074, 287875674l, 271054647l);
    Route r3a = computeRoute(287875674l, 271054647l, TravelType.ANY, true);
    checkRoute(r3a, 3390.2693223574074, 287875674l, 271054647l);
}


@Test(timeout = 3000)
public void testSmallRouting19RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 274813869l, 1195448564l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(274813869l, 1195448564l, TravelType.BIKE, true);
    checkRoute(r0a, 6128.340666514838, 274813869l, 1195448564l);
    computeRoute(274813869l, 1195448564l, TravelType.CAR, false);
    Route r2a = computeRoute(274813869l, 1195448564l, TravelType.FOOT, true);
    checkRoute(r2a, 3135.649272689128, 274813869l, 1195448564l);
    Route r3a = computeRoute(274813869l, 1195448564l, TravelType.ANY, true);
    checkRoute(r3a, 3135.649272689128, 274813869l, 1195448564l);
}


@Test(timeout = 3000)
public void testSmallRouting20RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1551970936l, 295052830l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1551970936l, 295052830l, TravelType.BIKE, true);
    checkRoute(r0a, 7152.8902579860005, 1551970936l, 295052830l);
    Route r1a = computeRoute(1551970936l, 295052830l, TravelType.CAR, true);
    checkRoute(r1a, 10179.497028835978, 1551970936l, 295052830l);
    Route r2a = computeRoute(1551970936l, 295052830l, TravelType.FOOT, true);
    checkRoute(r2a, 6988.032269739725, 1551970936l, 295052830l);
    Route r3a = computeRoute(1551970936l, 295052830l, TravelType.ANY, true);
    checkRoute(r3a, 6988.032269739725, 1551970936l, 295052830l);
}


@Test(timeout = 3000)
public void testSmallRouting21RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374385401l, 1267801743l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374385401l, 1267801743l, TravelType.BIKE, true);
    checkRoute(r0a, 1245.5253232196792, 374385401l, 1267801743l);
    Route r1a = computeRoute(374385401l, 1267801743l, TravelType.CAR, true);
    checkRoute(r1a, 1245.5253232196792, 374385401l, 1267801743l);
    Route r2a = computeRoute(374385401l, 1267801743l, TravelType.FOOT, true);
    checkRoute(r2a, 534.8478080921109, 374385401l, 1267801743l);
    Route r3a = computeRoute(374385401l, 1267801743l, TravelType.ANY, true);
    checkRoute(r3a, 534.8478080921109, 374385401l, 1267801743l);
}


@Test(timeout = 3000)
public void testSmallRouting22RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1559582764l, 791845044l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1559582764l, 791845044l, TravelType.BIKE, false);
    computeRoute(1559582764l, 791845044l, TravelType.CAR, false);
    Route r2a = computeRoute(1559582764l, 791845044l, TravelType.FOOT, true);
    checkRoute(r2a, 1575.1747168795414, 1559582764l, 791845044l);
    Route r3a = computeRoute(1559582764l, 791845044l, TravelType.ANY, true);
    checkRoute(r3a, 1575.1747168795414, 1559582764l, 791845044l);
}


@Test(timeout = 3000)
public void testSmallRouting23RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2140385744l, 269200631l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2140385744l, 269200631l, TravelType.BIKE, true);
    checkRoute(r0a, 1089.1324049529992, 2140385744l, 269200631l);
    computeRoute(2140385744l, 269200631l, TravelType.CAR, false);
    Route r2a = computeRoute(2140385744l, 269200631l, TravelType.FOOT, true);
    checkRoute(r2a, 1006.0411543801947, 2140385744l, 269200631l);
    Route r3a = computeRoute(2140385744l, 269200631l, TravelType.ANY, true);
    checkRoute(r3a, 1006.0411543801947, 2140385744l, 269200631l);
}


@Test(timeout = 3000)
public void testSmallRouting24RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2580511976l, 1551953946l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2580511976l, 1551953946l, TravelType.BIKE, false);
    computeRoute(2580511976l, 1551953946l, TravelType.CAR, false);
    Route r2a = computeRoute(2580511976l, 1551953946l, TravelType.FOOT, true);
    checkRoute(r2a, 3723.7170108844048, 2580511976l, 1551953946l);
    Route r3a = computeRoute(2580511976l, 1551953946l, TravelType.ANY, true);
    checkRoute(r3a, 3723.7170108844048, 2580511976l, 1551953946l);
}


@Test(timeout = 3000)
public void testSmallRouting25RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 797645930l, 2291792036l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(797645930l, 2291792036l, TravelType.BIKE, true);
    checkRoute(r0a, 7459.615257389362, 797645930l, 2291792036l);
    computeRoute(797645930l, 2291792036l, TravelType.CAR, false);
    Route r2a = computeRoute(797645930l, 2291792036l, TravelType.FOOT, true);
    checkRoute(r2a, 6638.776886328271, 797645930l, 2291792036l);
    Route r3a = computeRoute(797645930l, 2291792036l, TravelType.ANY, true);
    checkRoute(r3a, 6638.776886328271, 797645930l, 2291792036l);
}


@Test(timeout = 3000)
public void testSmallRouting26RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1324588185l, 1207820469l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1324588185l, 1207820469l, TravelType.BIKE, false);
    computeRoute(1324588185l, 1207820469l, TravelType.CAR, false);
    Route r2a = computeRoute(1324588185l, 1207820469l, TravelType.FOOT, true);
    checkRoute(r2a, 5572.3732437437575, 1324588185l, 1207820469l);
    Route r3a = computeRoute(1324588185l, 1207820469l, TravelType.ANY, true);
    checkRoute(r3a, 5572.3732437437575, 1324588185l, 1207820469l);
}


@Test(timeout = 3000)
public void testSmallRouting27RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 155519491l, 1388442265l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(155519491l, 1388442265l, TravelType.BIKE, false);
    computeRoute(155519491l, 1388442265l, TravelType.CAR, false);
    Route r2a = computeRoute(155519491l, 1388442265l, TravelType.FOOT, true);
    checkRoute(r2a, 3368.9389933667435, 155519491l, 1388442265l);
    Route r3a = computeRoute(155519491l, 1388442265l, TravelType.ANY, true);
    checkRoute(r3a, 3368.9389933667435, 155519491l, 1388442265l);
}


@Test(timeout = 3000)
public void testSmallRouting28RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 263040718l, 1558424848l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(263040718l, 1558424848l, TravelType.BIKE, true);
    checkRoute(r0a, 6577.396337315512, 263040718l, 1558424848l);
    computeRoute(263040718l, 1558424848l, TravelType.CAR, false);
    Route r2a = computeRoute(263040718l, 1558424848l, TravelType.FOOT, true);
    checkRoute(r2a, 6392.251709283891, 263040718l, 1558424848l);
    Route r3a = computeRoute(263040718l, 1558424848l, TravelType.ANY, true);
    checkRoute(r3a, 6363.28581062646, 263040718l, 1558424848l);
}


@Test(timeout = 3000)
public void testSmallRouting29RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2247070843l, 1654313456l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2247070843l, 1654313456l, TravelType.BIKE, false);
    computeRoute(2247070843l, 1654313456l, TravelType.CAR, false);
    Route r2a = computeRoute(2247070843l, 1654313456l, TravelType.FOOT, true);
    checkRoute(r2a, 4807.248831204717, 2247070843l, 1654313456l);
    Route r3a = computeRoute(2247070843l, 1654313456l, TravelType.ANY, true);
    checkRoute(r3a, 4790.855814467959, 2247070843l, 1654313456l);
}


@Test(timeout = 3000)
public void testSmallRouting30RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 374401729l, 1404314215l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(374401729l, 1404314215l, TravelType.BIKE, true);
    checkRoute(r0a, 5552.713163143275, 374401729l, 1404314215l);
    computeRoute(374401729l, 1404314215l, TravelType.CAR, false);
    Route r2a = computeRoute(374401729l, 1404314215l, TravelType.FOOT, true);
    checkRoute(r2a, 5435.475049870575, 374401729l, 1404314215l);
    Route r3a = computeRoute(374401729l, 1404314215l, TravelType.ANY, true);
    checkRoute(r3a, 5432.848295045235, 374401729l, 1404314215l);
}


@Test(timeout = 3000)
public void testSmallRouting31RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 155519870l, 1610660219l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(155519870l, 1610660219l, TravelType.BIKE, true);
    checkRoute(r0a, 6085.856479513409, 155519870l, 1610660219l);
    computeRoute(155519870l, 1610660219l, TravelType.CAR, false);
    Route r2a = computeRoute(155519870l, 1610660219l, TravelType.FOOT, true);
    checkRoute(r2a, 5347.378357804542, 155519870l, 1610660219l);
    Route r3a = computeRoute(155519870l, 1610660219l, TravelType.ANY, true);
    checkRoute(r3a, 5347.378357804542, 155519870l, 1610660219l);
}


@Test(timeout = 3000)
public void testSmallRouting32RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2721936255l, 1121235956l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2721936255l, 1121235956l, TravelType.BIKE, false);
    computeRoute(2721936255l, 1121235956l, TravelType.CAR, false);
    Route r2a = computeRoute(2721936255l, 1121235956l, TravelType.FOOT, true);
    checkRoute(r2a, 4010.4320609632755, 2721936255l, 1121235956l);
    Route r3a = computeRoute(2721936255l, 1121235956l, TravelType.ANY, true);
    checkRoute(r3a, 4010.4320609632755, 2721936255l, 1121235956l);
}


@Test(timeout = 3000)
public void testSmallRouting33RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2146414963l, 411285920l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2146414963l, 411285920l, TravelType.BIKE, false);
    computeRoute(2146414963l, 411285920l, TravelType.CAR, false);
    Route r2a = computeRoute(2146414963l, 411285920l, TravelType.FOOT, true);
    checkRoute(r2a, 5408.829276693932, 2146414963l, 411285920l);
    Route r3a = computeRoute(2146414963l, 411285920l, TravelType.ANY, true);
    checkRoute(r3a, 5408.829276693932, 2146414963l, 411285920l);
}


@Test(timeout = 3000)
public void testSmallRouting34RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2262617268l, 2027744865l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2262617268l, 2027744865l, TravelType.BIKE, false);
    computeRoute(2262617268l, 2027744865l, TravelType.CAR, false);
    Route r2a = computeRoute(2262617268l, 2027744865l, TravelType.FOOT, true);
    checkRoute(r2a, 2173.4768106362626, 2262617268l, 2027744865l);
    Route r3a = computeRoute(2262617268l, 2027744865l, TravelType.ANY, true);
    checkRoute(r3a, 2172.474966909713, 2262617268l, 2027744865l);
}


@Test(timeout = 3000)
public void testSmallRouting35RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 660392738l, 1270161772l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(660392738l, 1270161772l, TravelType.BIKE, false);
    computeRoute(660392738l, 1270161772l, TravelType.CAR, false);
    Route r2a = computeRoute(660392738l, 1270161772l, TravelType.FOOT, true);
    checkRoute(r2a, 2878.8246034766908, 660392738l, 1270161772l);
    Route r3a = computeRoute(660392738l, 1270161772l, TravelType.ANY, true);
    checkRoute(r3a, 2878.8246034766908, 660392738l, 1270161772l);
}


@Test(timeout = 3000)
public void testSmallRouting36RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1368711471l, 2338046189l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1368711471l, 2338046189l, TravelType.BIKE, true);
    checkRoute(r0a, 5756.740319373849, 1368711471l, 2338046189l);
    computeRoute(1368711471l, 2338046189l, TravelType.CAR, false);
    Route r2a = computeRoute(1368711471l, 2338046189l, TravelType.FOOT, true);
    checkRoute(r2a, 5728.158360589333, 1368711471l, 2338046189l);
    Route r3a = computeRoute(1368711471l, 2338046189l, TravelType.ANY, true);
    checkRoute(r3a, 5728.158360589333, 1368711471l, 2338046189l);
}


@Test(timeout = 3000)
public void testSmallRouting37RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1270494653l, 167170515l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1270494653l, 167170515l, TravelType.BIKE, true);
    checkRoute(r0a, 5092.169283600517, 1270494653l, 167170515l);
    Route r1a = computeRoute(1270494653l, 167170515l, TravelType.CAR, true);
    checkRoute(r1a, 5114.838643706615, 1270494653l, 167170515l);
    Route r2a = computeRoute(1270494653l, 167170515l, TravelType.FOOT, true);
    checkRoute(r2a, 4700.486055220857, 1270494653l, 167170515l);
    Route r3a = computeRoute(1270494653l, 167170515l, TravelType.ANY, true);
    checkRoute(r3a, 4700.486055220857, 1270494653l, 167170515l);
}


@Test(timeout = 3000)
public void testSmallRouting38RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1387922823l, 2143164704l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1387922823l, 2143164704l, TravelType.BIKE, false);
    computeRoute(1387922823l, 2143164704l, TravelType.CAR, false);
    Route r2a = computeRoute(1387922823l, 2143164704l, TravelType.FOOT, true);
    checkRoute(r2a, 7393.3423807705885, 1387922823l, 2143164704l);
    Route r3a = computeRoute(1387922823l, 2143164704l, TravelType.ANY, true);
    checkRoute(r3a, 7393.3423807705885, 1387922823l, 2143164704l);
}


@Test(timeout = 3000)
public void testSmallRouting39RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2216424928l, 1264076549l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2216424928l, 1264076549l, TravelType.BIKE, true);
    checkRoute(r0a, 729.9097447886465, 2216424928l, 1264076549l);
    computeRoute(2216424928l, 1264076549l, TravelType.CAR, false);
    Route r2a = computeRoute(2216424928l, 1264076549l, TravelType.FOOT, true);
    checkRoute(r2a, 589.219437215309, 2216424928l, 1264076549l);
    Route r3a = computeRoute(2216424928l, 1264076549l, TravelType.ANY, true);
    checkRoute(r3a, 589.219437215309, 2216424928l, 1264076549l);
}


@Test(timeout = 3000)
public void testSmallRouting40RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1225723900l, 493962577l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1225723900l, 493962577l, TravelType.BIKE, true);
    checkRoute(r0a, 7918.509783693398, 1225723900l, 493962577l);
    computeRoute(1225723900l, 493962577l, TravelType.CAR, false);
    Route r2a = computeRoute(1225723900l, 493962577l, TravelType.FOOT, true);
    checkRoute(r2a, 6859.815358884241, 1225723900l, 493962577l);
    Route r3a = computeRoute(1225723900l, 493962577l, TravelType.ANY, true);
    checkRoute(r3a, 6696.915598101932, 1225723900l, 493962577l);
}


@Test(timeout = 3000)
public void testSmallRouting41RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 252284380l, 2269695460l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(252284380l, 2269695460l, TravelType.BIKE, true);
    checkRoute(r0a, 7923.620446711339, 252284380l, 2269695460l);
    Route r1a = computeRoute(252284380l, 2269695460l, TravelType.CAR, true);
    checkRoute(r1a, 8311.51734146135, 252284380l, 2269695460l);
    Route r2a = computeRoute(252284380l, 2269695460l, TravelType.FOOT, true);
    checkRoute(r2a, 7552.4008374473, 252284380l, 2269695460l);
    Route r3a = computeRoute(252284380l, 2269695460l, TravelType.ANY, true);
    checkRoute(r3a, 7552.4008374473, 252284380l, 2269695460l);
}


@Test(timeout = 3000)
public void testSmallRouting42RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1268918006l, 2764618299l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1268918006l, 2764618299l, TravelType.BIKE, false);
    computeRoute(1268918006l, 2764618299l, TravelType.CAR, false);
    computeRoute(1268918006l, 2764618299l, TravelType.FOOT, false);
    Route r3a = computeRoute(1268918006l, 2764618299l, TravelType.ANY, true);
    checkRoute(r3a, 4211.902062415164, 1268918006l, 2764618299l);
}


@Test(timeout = 3000)
public void testSmallRouting43RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1390041163l, 1324607749l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1390041163l, 1324607749l, TravelType.BIKE, false);
    computeRoute(1390041163l, 1324607749l, TravelType.CAR, false);
    Route r2a = computeRoute(1390041163l, 1324607749l, TravelType.FOOT, true);
    checkRoute(r2a, 5320.121730303974, 1390041163l, 1324607749l);
    Route r3a = computeRoute(1390041163l, 1324607749l, TravelType.ANY, true);
    checkRoute(r3a, 5320.121730303974, 1390041163l, 1324607749l);
}


@Test(timeout = 3000)
public void testSmallRouting44RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2219398769l, 1520395072l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2219398769l, 1520395072l, TravelType.BIKE, false);
    computeRoute(2219398769l, 1520395072l, TravelType.CAR, false);
    computeRoute(2219398769l, 1520395072l, TravelType.FOOT, false);
    Route r3a = computeRoute(2219398769l, 1520395072l, TravelType.ANY, true);
    checkRoute(r3a, 6660.956187850306, 2219398769l, 1520395072l);
}


@Test(timeout = 3000)
public void testSmallRouting45RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1392049935l, 167167044l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1392049935l, 167167044l, TravelType.BIKE, false);
    computeRoute(1392049935l, 167167044l, TravelType.CAR, false);
    Route r2a = computeRoute(1392049935l, 167167044l, TravelType.FOOT, true);
    checkRoute(r2a, 5892.31361927996, 1392049935l, 167167044l);
    Route r3a = computeRoute(1392049935l, 167167044l, TravelType.ANY, true);
    checkRoute(r3a, 5892.31361927996, 1392049935l, 167167044l);
}


@Test(timeout = 3000)
public void testSmallRouting46RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 895722345l, 619895l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(895722345l, 619895l, TravelType.BIKE, true);
    checkRoute(r0a, 2750.6018686810953, 895722345l, 619895l);
    computeRoute(895722345l, 619895l, TravelType.CAR, false);
    Route r2a = computeRoute(895722345l, 619895l, TravelType.FOOT, true);
    checkRoute(r2a, 2540.9843968318864, 895722345l, 619895l);
    Route r3a = computeRoute(895722345l, 619895l, TravelType.ANY, true);
    checkRoute(r3a, 2540.9843968318864, 895722345l, 619895l);
}


@Test(timeout = 3000)
public void testSmallRouting47RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2146467328l, 1521938621l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2146467328l, 1521938621l, TravelType.BIKE, false);
    computeRoute(2146467328l, 1521938621l, TravelType.CAR, false);
    Route r2a = computeRoute(2146467328l, 1521938621l, TravelType.FOOT, true);
    checkRoute(r2a, 967.0690652026818, 2146467328l, 1521938621l);
    Route r3a = computeRoute(2146467328l, 1521938621l, TravelType.ANY, true);
    checkRoute(r3a, 967.0690652026818, 2146467328l, 1521938621l);
}


@Test(timeout = 3000)
public void testSmallRouting48RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2145183508l, 449201856l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2145183508l, 449201856l, TravelType.BIKE, false);
    computeRoute(2145183508l, 449201856l, TravelType.CAR, false);
    Route r2a = computeRoute(2145183508l, 449201856l, TravelType.FOOT, true);
    checkRoute(r2a, 4384.958190819527, 2145183508l, 449201856l);
    Route r3a = computeRoute(2145183508l, 449201856l, TravelType.ANY, true);
    checkRoute(r3a, 4384.958190819527, 2145183508l, 449201856l);
}


@Test(timeout = 3000)
public void testSmallRouting49RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 138113168l, 1266981686l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(138113168l, 1266981686l, TravelType.BIKE, false);
    computeRoute(138113168l, 1266981686l, TravelType.CAR, false);
    Route r2a = computeRoute(138113168l, 1266981686l, TravelType.FOOT, true);
    checkRoute(r2a, 3950.7187608861077, 138113168l, 1266981686l);
    Route r3a = computeRoute(138113168l, 1266981686l, TravelType.ANY, true);
    checkRoute(r3a, 3950.7187608861077, 138113168l, 1266981686l);
}


@Test(timeout = 3000)
public void testSmallRouting50RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 342911791l, 266483242l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(342911791l, 266483242l, TravelType.BIKE, true);
    checkRoute(r0a, 3925.005151667547, 342911791l, 266483242l);
    computeRoute(342911791l, 266483242l, TravelType.CAR, false);
    Route r2a = computeRoute(342911791l, 266483242l, TravelType.FOOT, true);
    checkRoute(r2a, 2708.0869525374383, 342911791l, 266483242l);
    Route r3a = computeRoute(342911791l, 266483242l, TravelType.ANY, true);
    checkRoute(r3a, 2708.0869525374383, 342911791l, 266483242l);
}


@Test(timeout = 3000)
public void testSmallRouting51RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1388620474l, 1266832053l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1388620474l, 1266832053l, TravelType.BIKE, false);
    computeRoute(1388620474l, 1266832053l, TravelType.CAR, false);
    Route r2a = computeRoute(1388620474l, 1266832053l, TravelType.FOOT, true);
    checkRoute(r2a, 5823.68976888399, 1388620474l, 1266832053l);
    Route r3a = computeRoute(1388620474l, 1266832053l, TravelType.ANY, true);
    checkRoute(r3a, 5823.68976888399, 1388620474l, 1266832053l);
}


@Test(timeout = 3000)
public void testSmallRouting52RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1551977024l, 1368814619l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1551977024l, 1368814619l, TravelType.BIKE, false);
    computeRoute(1551977024l, 1368814619l, TravelType.CAR, false);
    Route r2a = computeRoute(1551977024l, 1368814619l, TravelType.FOOT, true);
    checkRoute(r2a, 2746.6898866769493, 1551977024l, 1368814619l);
    Route r3a = computeRoute(1551977024l, 1368814619l, TravelType.ANY, true);
    checkRoute(r3a, 2746.6898866769493, 1551977024l, 1368814619l);
}


@Test(timeout = 3000)
public void testSmallRouting53RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1270095991l, 1175403092l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1270095991l, 1175403092l, TravelType.BIKE, false);
    computeRoute(1270095991l, 1175403092l, TravelType.CAR, false);
    Route r2a = computeRoute(1270095991l, 1175403092l, TravelType.FOOT, true);
    checkRoute(r2a, 1846.5481471191738, 1270095991l, 1175403092l);
    Route r3a = computeRoute(1270095991l, 1175403092l, TravelType.ANY, true);
    checkRoute(r3a, 1846.5481471191738, 1270095991l, 1175403092l);
}


@Test(timeout = 3000)
public void testSmallRouting54RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2146296993l, 401505799l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2146296993l, 401505799l, TravelType.BIKE, true);
    checkRoute(r0a, 6012.694296813326, 2146296993l, 401505799l);
    Route r1a = computeRoute(2146296993l, 401505799l, TravelType.CAR, true);
    checkRoute(r1a, 9284.413654024022, 2146296993l, 401505799l);
    Route r2a = computeRoute(2146296993l, 401505799l, TravelType.FOOT, true);
    checkRoute(r2a, 5829.953948955141, 2146296993l, 401505799l);
    Route r3a = computeRoute(2146296993l, 401505799l, TravelType.ANY, true);
    checkRoute(r3a, 5829.199763843003, 2146296993l, 401505799l);
}


@Test(timeout = 3000)
public void testSmallRouting55RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2282845151l, 2134764319l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2282845151l, 2134764319l, TravelType.BIKE, false);
    computeRoute(2282845151l, 2134764319l, TravelType.CAR, false);
    Route r2a = computeRoute(2282845151l, 2134764319l, TravelType.FOOT, true);
    checkRoute(r2a, 2746.463602975696, 2282845151l, 2134764319l);
    Route r3a = computeRoute(2282845151l, 2134764319l, TravelType.ANY, true);
    checkRoute(r3a, 2746.463602975696, 2282845151l, 2134764319l);
}


@Test(timeout = 3000)
public void testSmallRouting56RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2145165187l, 1558470696l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2145165187l, 1558470696l, TravelType.BIKE, true);
    checkRoute(r0a, 5422.774790693941, 2145165187l, 1558470696l);
    Route r1a = computeRoute(2145165187l, 1558470696l, TravelType.CAR, true);
    checkRoute(r1a, 7564.019424811852, 2145165187l, 1558470696l);
    Route r2a = computeRoute(2145165187l, 1558470696l, TravelType.FOOT, true);
    checkRoute(r2a, 4971.335996725527, 2145165187l, 1558470696l);
    Route r3a = computeRoute(2145165187l, 1558470696l, TravelType.ANY, true);
    checkRoute(r3a, 4971.335996725527, 2145165187l, 1558470696l);
}


@Test(timeout = 3000)
public void testSmallRouting57RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3455247902l, 363225786l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(3455247902l, 363225786l, TravelType.BIKE, true);
    checkRoute(r0a, 7222.728287629563, 3455247902l, 363225786l);
    Route r1a = computeRoute(3455247902l, 363225786l, TravelType.CAR, true);
    checkRoute(r1a, 7232.825469589508, 3455247902l, 363225786l);
    Route r2a = computeRoute(3455247902l, 363225786l, TravelType.FOOT, true);
    checkRoute(r2a, 7221.579701944443, 3455247902l, 363225786l);
    Route r3a = computeRoute(3455247902l, 363225786l, TravelType.ANY, true);
    checkRoute(r3a, 7219.039947097271, 3455247902l, 363225786l);
}


@Test(timeout = 3000)
public void testSmallRouting58RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2228968756l, 331862598l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2228968756l, 331862598l, TravelType.BIKE, false);
    computeRoute(2228968756l, 331862598l, TravelType.CAR, false);
    Route r2a = computeRoute(2228968756l, 331862598l, TravelType.FOOT, true);
    checkRoute(r2a, 1994.210372902091, 2228968756l, 331862598l);
    Route r3a = computeRoute(2228968756l, 331862598l, TravelType.ANY, true);
    checkRoute(r3a, 1994.210372902091, 2228968756l, 331862598l);
}


@Test(timeout = 3000)
public void testSmallRouting59RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1225687088l, 2161740264l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1225687088l, 2161740264l, TravelType.BIKE, true);
    checkRoute(r0a, 6449.894976639988, 1225687088l, 2161740264l);
    computeRoute(1225687088l, 2161740264l, TravelType.CAR, false);
    Route r2a = computeRoute(1225687088l, 2161740264l, TravelType.FOOT, true);
    checkRoute(r2a, 5873.048727205384, 1225687088l, 2161740264l);
    Route r3a = computeRoute(1225687088l, 2161740264l, TravelType.ANY, true);
    checkRoute(r3a, 5841.529635641039, 1225687088l, 2161740264l);
}


@Test(timeout = 3000)
public void testSmallRouting60RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2144833941l, 167124807l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2144833941l, 167124807l, TravelType.BIKE, false);
    computeRoute(2144833941l, 167124807l, TravelType.CAR, false);
    Route r2a = computeRoute(2144833941l, 167124807l, TravelType.FOOT, true);
    checkRoute(r2a, 4220.156203820309, 2144833941l, 167124807l);
    Route r3a = computeRoute(2144833941l, 167124807l, TravelType.ANY, true);
    checkRoute(r3a, 4220.156203820309, 2144833941l, 167124807l);
}


@Test(timeout = 3000)
public void testSmallRouting61RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 808001143l, 332340836l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(808001143l, 332340836l, TravelType.BIKE, false);
    computeRoute(808001143l, 332340836l, TravelType.CAR, false);
    Route r2a = computeRoute(808001143l, 332340836l, TravelType.FOOT, true);
    checkRoute(r2a, 3018.7478352033936, 808001143l, 332340836l);
    Route r3a = computeRoute(808001143l, 332340836l, TravelType.ANY, true);
    checkRoute(r3a, 3018.7478352033936, 808001143l, 332340836l);
}


@Test(timeout = 3000)
public void testSmallRouting62RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1385930695l, 1550994648l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1385930695l, 1550994648l, TravelType.BIKE, true);
    checkRoute(r0a, 1381.7864977324668, 1385930695l, 1550994648l);
    computeRoute(1385930695l, 1550994648l, TravelType.CAR, false);
    Route r2a = computeRoute(1385930695l, 1550994648l, TravelType.FOOT, true);
    checkRoute(r2a, 1372.288324301967, 1385930695l, 1550994648l);
    Route r3a = computeRoute(1385930695l, 1550994648l, TravelType.ANY, true);
    checkRoute(r3a, 1372.288324301967, 1385930695l, 1550994648l);
}


@Test(timeout = 3000)
public void testSmallRouting63RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1550893988l, 1275874559l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1550893988l, 1275874559l, TravelType.BIKE, false);
    computeRoute(1550893988l, 1275874559l, TravelType.CAR, false);
    Route r2a = computeRoute(1550893988l, 1275874559l, TravelType.FOOT, true);
    checkRoute(r2a, 1281.9067309185373, 1550893988l, 1275874559l);
    Route r3a = computeRoute(1550893988l, 1275874559l, TravelType.ANY, true);
    checkRoute(r3a, 1281.9067309185373, 1550893988l, 1275874559l);
}


@Test(timeout = 3000)
public void testSmallRouting64RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 410229005l, 1083330596l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(410229005l, 1083330596l, TravelType.BIKE, false);
    computeRoute(410229005l, 1083330596l, TravelType.CAR, false);
    Route r2a = computeRoute(410229005l, 1083330596l, TravelType.FOOT, true);
    checkRoute(r2a, 5173.130998225896, 410229005l, 1083330596l);
    Route r3a = computeRoute(410229005l, 1083330596l, TravelType.ANY, true);
    checkRoute(r3a, 5173.02354792863, 410229005l, 1083330596l);
}


@Test(timeout = 3000)
public void testSmallRouting65RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1033326997l, 813987649l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1033326997l, 813987649l, TravelType.BIKE, false);
    computeRoute(1033326997l, 813987649l, TravelType.CAR, false);
    Route r2a = computeRoute(1033326997l, 813987649l, TravelType.FOOT, true);
    checkRoute(r2a, 3932.596311404016, 1033326997l, 813987649l);
    Route r3a = computeRoute(1033326997l, 813987649l, TravelType.ANY, true);
    checkRoute(r3a, 3932.596311404016, 1033326997l, 813987649l);
}


@Test(timeout = 3000)
public void testSmallRouting66RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 503580893l, 178993718l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(503580893l, 178993718l, TravelType.BIKE, true);
    checkRoute(r0a, 3472.618041832574, 503580893l, 178993718l);
    Route r1a = computeRoute(503580893l, 178993718l, TravelType.CAR, true);
    checkRoute(r1a, 3559.315594132284, 503580893l, 178993718l);
    Route r2a = computeRoute(503580893l, 178993718l, TravelType.FOOT, true);
    checkRoute(r2a, 3277.7014083822123, 503580893l, 178993718l);
    Route r3a = computeRoute(503580893l, 178993718l, TravelType.ANY, true);
    checkRoute(r3a, 3277.7014083822123, 503580893l, 178993718l);
}


@Test(timeout = 3000)
public void testSmallRouting67RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1195765352l, 1269160699l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1195765352l, 1269160699l, TravelType.BIKE, false);
    computeRoute(1195765352l, 1269160699l, TravelType.CAR, false);
    Route r2a = computeRoute(1195765352l, 1269160699l, TravelType.FOOT, true);
    checkRoute(r2a, 6591.245723414068, 1195765352l, 1269160699l);
    Route r3a = computeRoute(1195765352l, 1269160699l, TravelType.ANY, true);
    checkRoute(r3a, 6589.0220659686665, 1195765352l, 1269160699l);
}


@Test(timeout = 3000)
public void testSmallRouting68RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1287613859l, 404468111l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1287613859l, 404468111l, TravelType.BIKE, false);
    computeRoute(1287613859l, 404468111l, TravelType.CAR, false);
    Route r2a = computeRoute(1287613859l, 404468111l, TravelType.FOOT, true);
    checkRoute(r2a, 7394.448677492357, 1287613859l, 404468111l);
    Route r3a = computeRoute(1287613859l, 404468111l, TravelType.ANY, true);
    checkRoute(r3a, 7394.448677492357, 1287613859l, 404468111l);
}


@Test(timeout = 3000)
public void testSmallRouting69RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1033102005l, 731437606l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1033102005l, 731437606l, TravelType.BIKE, true);
    checkRoute(r0a, 2973.0422260300843, 1033102005l, 731437606l);
    computeRoute(1033102005l, 731437606l, TravelType.CAR, false);
    Route r2a = computeRoute(1033102005l, 731437606l, TravelType.FOOT, true);
    checkRoute(r2a, 2956.565759220909, 1033102005l, 731437606l);
    Route r3a = computeRoute(1033102005l, 731437606l, TravelType.ANY, true);
    checkRoute(r3a, 2956.565759220909, 1033102005l, 731437606l);
}


@Test(timeout = 3000)
public void testSmallRouting70RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1382935220l, 262170680l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1382935220l, 262170680l, TravelType.BIKE, false);
    computeRoute(1382935220l, 262170680l, TravelType.CAR, false);
    Route r2a = computeRoute(1382935220l, 262170680l, TravelType.FOOT, true);
    checkRoute(r2a, 623.9316504507561, 1382935220l, 262170680l);
    Route r3a = computeRoute(1382935220l, 262170680l, TravelType.ANY, true);
    checkRoute(r3a, 623.9316504507561, 1382935220l, 262170680l);
}


@Test(timeout = 3000)
public void testSmallRouting71RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2291761990l, 1267354222l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2291761990l, 1267354222l, TravelType.BIKE, false);
    computeRoute(2291761990l, 1267354222l, TravelType.CAR, false);
    Route r2a = computeRoute(2291761990l, 1267354222l, TravelType.FOOT, true);
    checkRoute(r2a, 4246.8387413539385, 2291761990l, 1267354222l);
    Route r3a = computeRoute(2291761990l, 1267354222l, TravelType.ANY, true);
    checkRoute(r3a, 4246.8387413539385, 2291761990l, 1267354222l);
}


@Test(timeout = 3000)
public void testSmallRouting72RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 322993406l, 286198734l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(322993406l, 286198734l, TravelType.BIKE, true);
    checkRoute(r0a, 9718.442972537152, 322993406l, 286198734l);
    computeRoute(322993406l, 286198734l, TravelType.CAR, false);
    Route r2a = computeRoute(322993406l, 286198734l, TravelType.FOOT, true);
    checkRoute(r2a, 9557.99306620223, 322993406l, 286198734l);
    Route r3a = computeRoute(322993406l, 286198734l, TravelType.ANY, true);
    checkRoute(r3a, 9557.99306620223, 322993406l, 286198734l);
}


@Test(timeout = 3000)
public void testSmallRouting73RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1270334275l, 1268892929l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1270334275l, 1268892929l, TravelType.BIKE, true);
    checkRoute(r0a, 3235.0439898000764, 1270334275l, 1268892929l);
    computeRoute(1270334275l, 1268892929l, TravelType.CAR, false);
    Route r2a = computeRoute(1270334275l, 1268892929l, TravelType.FOOT, true);
    checkRoute(r2a, 3039.484376578444, 1270334275l, 1268892929l);
    Route r3a = computeRoute(1270334275l, 1268892929l, TravelType.ANY, true);
    checkRoute(r3a, 3039.484376578444, 1270334275l, 1268892929l);
}


@Test(timeout = 3000)
public void testSmallRouting74RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 142656152l, 119721227l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(142656152l, 119721227l, TravelType.BIKE, false);
    Route r1a = computeRoute(142656152l, 119721227l, TravelType.CAR, true);
    checkRoute(r1a, 2116.714098424812, 142656152l, 119721227l);
    computeRoute(142656152l, 119721227l, TravelType.FOOT, false);
    Route r3a = computeRoute(142656152l, 119721227l, TravelType.ANY, true);
    checkRoute(r3a, 2107.5212801955954, 142656152l, 119721227l);
}


@Test(timeout = 3000)
public void testSmallRouting75RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1368809628l, 410276319l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1368809628l, 410276319l, TravelType.BIKE, false);
    computeRoute(1368809628l, 410276319l, TravelType.CAR, false);
    Route r2a = computeRoute(1368809628l, 410276319l, TravelType.FOOT, true);
    checkRoute(r2a, 3950.8355307475504, 1368809628l, 410276319l);
    Route r3a = computeRoute(1368809628l, 410276319l, TravelType.ANY, true);
    checkRoute(r3a, 3950.8355307475504, 1368809628l, 410276319l);
}


@Test(timeout = 3000)
public void testSmallRouting76RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 316522222l, 1023360795l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(316522222l, 1023360795l, TravelType.BIKE, true);
    checkRoute(r0a, 11843.586526863353, 316522222l, 1023360795l);
    computeRoute(316522222l, 1023360795l, TravelType.CAR, false);
    Route r2a = computeRoute(316522222l, 1023360795l, TravelType.FOOT, true);
    checkRoute(r2a, 11479.25230790139, 316522222l, 1023360795l);
    Route r3a = computeRoute(316522222l, 1023360795l, TravelType.ANY, true);
    checkRoute(r3a, 11478.940353068308, 316522222l, 1023360795l);
}


@Test(timeout = 3000)
public void testSmallRouting77RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1225674934l, 1853941038l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1225674934l, 1853941038l, TravelType.BIKE, false);
    computeRoute(1225674934l, 1853941038l, TravelType.CAR, false);
    Route r2a = computeRoute(1225674934l, 1853941038l, TravelType.FOOT, true);
    checkRoute(r2a, 7253.438827966094, 1225674934l, 1853941038l);
    Route r3a = computeRoute(1225674934l, 1853941038l, TravelType.ANY, true);
    checkRoute(r3a, 7253.438827966094, 1225674934l, 1853941038l);
}


@Test(timeout = 3000)
public void testSmallRouting78RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1387914575l, 3427852174l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1387914575l, 3427852174l, TravelType.BIKE, false);
    computeRoute(1387914575l, 3427852174l, TravelType.CAR, false);
    Route r2a = computeRoute(1387914575l, 3427852174l, TravelType.FOOT, true);
    checkRoute(r2a, 4511.967602432915, 1387914575l, 3427852174l);
    Route r3a = computeRoute(1387914575l, 3427852174l, TravelType.ANY, true);
    checkRoute(r3a, 4511.967602432915, 1387914575l, 3427852174l);
}


@Test(timeout = 3000)
public void testSmallRouting79RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 317992440l, 1389391043l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(317992440l, 1389391043l, TravelType.BIKE, false);
    computeRoute(317992440l, 1389391043l, TravelType.CAR, false);
    Route r2a = computeRoute(317992440l, 1389391043l, TravelType.FOOT, true);
    checkRoute(r2a, 8803.47285026168, 317992440l, 1389391043l);
    Route r3a = computeRoute(317992440l, 1389391043l, TravelType.ANY, true);
    checkRoute(r3a, 8803.154469479094, 317992440l, 1389391043l);
}


@Test(timeout = 3000)
public void testSmallRouting80RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 276135503l, 429503681l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(276135503l, 429503681l, TravelType.BIKE, false);
    computeRoute(276135503l, 429503681l, TravelType.CAR, false);
    computeRoute(276135503l, 429503681l, TravelType.FOOT, false);
    Route r3a = computeRoute(276135503l, 429503681l, TravelType.ANY, true);
    checkRoute(r3a, 3135.782381699926, 276135503l, 429503681l);
}


@Test(timeout = 3000)
public void testSmallRouting81RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 972640318l, 313211968l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(972640318l, 313211968l, TravelType.BIKE, true);
    checkRoute(r0a, 7552.036064054315, 972640318l, 313211968l);
    Route r1a = computeRoute(972640318l, 313211968l, TravelType.CAR, true);
    checkRoute(r1a, 7450.8526017119775, 972640318l, 313211968l);
    Route r2a = computeRoute(972640318l, 313211968l, TravelType.FOOT, true);
    checkRoute(r2a, 6951.208326721936, 972640318l, 313211968l);
    Route r3a = computeRoute(972640318l, 313211968l, TravelType.ANY, true);
    checkRoute(r3a, 6850.024864379598, 972640318l, 313211968l);
}


@Test(timeout = 3000)
public void testSmallRouting82RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 335911125l, 1375539775l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(335911125l, 1375539775l, TravelType.BIKE, false);
    computeRoute(335911125l, 1375539775l, TravelType.CAR, false);
    Route r2a = computeRoute(335911125l, 1375539775l, TravelType.FOOT, true);
    checkRoute(r2a, 1859.7075979728331, 335911125l, 1375539775l);
    Route r3a = computeRoute(335911125l, 1375539775l, TravelType.ANY, true);
    checkRoute(r3a, 1859.7075979728331, 335911125l, 1375539775l);
}


@Test(timeout = 3000)
public void testSmallRouting83RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1422926584l, 1225683859l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1422926584l, 1225683859l, TravelType.BIKE, false);
    computeRoute(1422926584l, 1225683859l, TravelType.CAR, false);
    Route r2a = computeRoute(1422926584l, 1225683859l, TravelType.FOOT, true);
    checkRoute(r2a, 5913.26585460265, 1422926584l, 1225683859l);
    Route r3a = computeRoute(1422926584l, 1225683859l, TravelType.ANY, true);
    checkRoute(r3a, 5903.4571733003, 1422926584l, 1225683859l);
}


@Test(timeout = 3000)
public void testSmallRouting84RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1382879947l, 2199167222l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1382879947l, 2199167222l, TravelType.BIKE, false);
    computeRoute(1382879947l, 2199167222l, TravelType.CAR, false);
    Route r2a = computeRoute(1382879947l, 2199167222l, TravelType.FOOT, true);
    checkRoute(r2a, 3089.436554572226, 1382879947l, 2199167222l);
    Route r3a = computeRoute(1382879947l, 2199167222l, TravelType.ANY, true);
    checkRoute(r3a, 3089.436554572226, 1382879947l, 2199167222l);
}


@Test(timeout = 3000)
public void testSmallRouting85RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 641954172l, 1535680179l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(641954172l, 1535680179l, TravelType.BIKE, false);
    computeRoute(641954172l, 1535680179l, TravelType.CAR, false);
    Route r2a = computeRoute(641954172l, 1535680179l, TravelType.FOOT, true);
    checkRoute(r2a, 2397.295088027213, 641954172l, 1535680179l);
    Route r3a = computeRoute(641954172l, 1535680179l, TravelType.ANY, true);
    checkRoute(r3a, 2397.295088027213, 641954172l, 1535680179l);
}


@Test(timeout = 3000)
public void testSmallRouting86RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1558430706l, 1499986204l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1558430706l, 1499986204l, TravelType.BIKE, true);
    checkRoute(r0a, 6378.6796593405825, 1558430706l, 1499986204l);
    computeRoute(1558430706l, 1499986204l, TravelType.CAR, false);
    Route r2a = computeRoute(1558430706l, 1499986204l, TravelType.FOOT, true);
    checkRoute(r2a, 4958.5450495079585, 1558430706l, 1499986204l);
    Route r3a = computeRoute(1558430706l, 1499986204l, TravelType.ANY, true);
    checkRoute(r3a, 4958.5450495079585, 1558430706l, 1499986204l);
}


@Test(timeout = 3000)
public void testSmallRouting87RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 288285995l, 1375597237l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(288285995l, 1375597237l, TravelType.BIKE, false);
    computeRoute(288285995l, 1375597237l, TravelType.CAR, false);
    Route r2a = computeRoute(288285995l, 1375597237l, TravelType.FOOT, true);
    checkRoute(r2a, 5037.3651727675915, 288285995l, 1375597237l);
    Route r3a = computeRoute(288285995l, 1375597237l, TravelType.ANY, true);
    checkRoute(r3a, 4693.912036504627, 288285995l, 1375597237l);
}


@Test(timeout = 3000)
public void testSmallRouting88RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1504154055l, 867283469l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1504154055l, 867283469l, TravelType.BIKE, false);
    computeRoute(1504154055l, 867283469l, TravelType.CAR, false);
    Route r2a = computeRoute(1504154055l, 867283469l, TravelType.FOOT, true);
    checkRoute(r2a, 6073.395029043052, 1504154055l, 867283469l);
    Route r3a = computeRoute(1504154055l, 867283469l, TravelType.ANY, true);
    checkRoute(r3a, 6073.395029043052, 1504154055l, 867283469l);
}


@Test(timeout = 3000)
public void testSmallRouting89RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1426600917l, 247313914l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1426600917l, 247313914l, TravelType.BIKE, true);
    checkRoute(r0a, 7623.593394681682, 1426600917l, 247313914l);
    computeRoute(1426600917l, 247313914l, TravelType.CAR, false);
    Route r2a = computeRoute(1426600917l, 247313914l, TravelType.FOOT, true);
    checkRoute(r2a, 5881.58209239938, 1426600917l, 247313914l);
    Route r3a = computeRoute(1426600917l, 247313914l, TravelType.ANY, true);
    checkRoute(r3a, 5881.58209239938, 1426600917l, 247313914l);
}


@Test(timeout = 3000)
public void testSmallRouting90RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 318101371l, 816406369l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(318101371l, 816406369l, TravelType.BIKE, false);
    computeRoute(318101371l, 816406369l, TravelType.CAR, false);
    Route r2a = computeRoute(318101371l, 816406369l, TravelType.FOOT, true);
    checkRoute(r2a, 4014.1149370951757, 318101371l, 816406369l);
    Route r3a = computeRoute(318101371l, 816406369l, TravelType.ANY, true);
    checkRoute(r3a, 4014.1149370951757, 318101371l, 816406369l);
}


@Test(timeout = 3000)
public void testSmallRouting91RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1382935287l, 2270402726l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1382935287l, 2270402726l, TravelType.BIKE, false);
    computeRoute(1382935287l, 2270402726l, TravelType.CAR, false);
    Route r2a = computeRoute(1382935287l, 2270402726l, TravelType.FOOT, true);
    checkRoute(r2a, 5211.383120715335, 1382935287l, 2270402726l);
    Route r3a = computeRoute(1382935287l, 2270402726l, TravelType.ANY, true);
    checkRoute(r3a, 5211.383120715335, 1382935287l, 2270402726l);
}


@Test(timeout = 3000)
public void testSmallRouting92RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1037642511l, 3453682579l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1037642511l, 3453682579l, TravelType.BIKE, false);
    computeRoute(1037642511l, 3453682579l, TravelType.CAR, false);
    Route r2a = computeRoute(1037642511l, 3453682579l, TravelType.FOOT, true);
    checkRoute(r2a, 2543.502246160909, 1037642511l, 3453682579l);
    Route r3a = computeRoute(1037642511l, 3453682579l, TravelType.ANY, true);
    checkRoute(r3a, 2543.502246160909, 1037642511l, 3453682579l);
}


@Test(timeout = 3000)
public void testSmallRouting93RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1388219606l, 151337064l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1388219606l, 151337064l, TravelType.BIKE, true);
    checkRoute(r0a, 4363.903719192533, 1388219606l, 151337064l);
    Route r1a = computeRoute(1388219606l, 151337064l, TravelType.CAR, true);
    checkRoute(r1a, 4453.376203809065, 1388219606l, 151337064l);
    Route r2a = computeRoute(1388219606l, 151337064l, TravelType.FOOT, true);
    checkRoute(r2a, 4066.1881158352166, 1388219606l, 151337064l);
    Route r3a = computeRoute(1388219606l, 151337064l, TravelType.ANY, true);
    checkRoute(r3a, 4066.1881158352166, 1388219606l, 151337064l);
}


@Test(timeout = 3000)
public void testSmallRouting94RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1113724226l, 1422926527l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1113724226l, 1422926527l, TravelType.BIKE, false);
    computeRoute(1113724226l, 1422926527l, TravelType.CAR, false);
    Route r2a = computeRoute(1113724226l, 1422926527l, TravelType.FOOT, true);
    checkRoute(r2a, 8315.984992627098, 1113724226l, 1422926527l);
    Route r3a = computeRoute(1113724226l, 1422926527l, TravelType.ANY, true);
    checkRoute(r3a, 8315.984992627098, 1113724226l, 1422926527l);
}


@Test(timeout = 3000)
public void testSmallRouting95RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 483353166l, 1268893009l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(483353166l, 1268893009l, TravelType.BIKE, false);
    computeRoute(483353166l, 1268893009l, TravelType.CAR, false);
    Route r2a = computeRoute(483353166l, 1268893009l, TravelType.FOOT, true);
    checkRoute(r2a, 8465.42354088948, 483353166l, 1268893009l);
    Route r3a = computeRoute(483353166l, 1268893009l, TravelType.ANY, true);
    checkRoute(r3a, 8465.42354088948, 483353166l, 1268893009l);
}


@Test(timeout = 3000)
public void testSmallRouting96RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 389957206l, 318101473l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(389957206l, 318101473l, TravelType.BIKE, false);
    computeRoute(389957206l, 318101473l, TravelType.CAR, false);
    Route r2a = computeRoute(389957206l, 318101473l, TravelType.FOOT, true);
    checkRoute(r2a, 4769.873298530903, 389957206l, 318101473l);
    Route r3a = computeRoute(389957206l, 318101473l, TravelType.ANY, true);
    checkRoute(r3a, 4769.873298530903, 389957206l, 318101473l);
}


@Test(timeout = 3000)
public void testSmallRouting97RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 313211968l, 281590981l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(313211968l, 281590981l, TravelType.BIKE, true);
    checkRoute(r0a, 7008.113985801118, 313211968l, 281590981l);
    computeRoute(313211968l, 281590981l, TravelType.CAR, false);
    Route r2a = computeRoute(313211968l, 281590981l, TravelType.FOOT, true);
    checkRoute(r2a, 6411.9034513000815, 313211968l, 281590981l);
    Route r3a = computeRoute(313211968l, 281590981l, TravelType.ANY, true);
    checkRoute(r3a, 6411.9034513000815, 313211968l, 281590981l);
}


@Test(timeout = 3000)
public void testSmallRouting98RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1139457161l, 2282914691l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1139457161l, 2282914691l, TravelType.BIKE, false);
    computeRoute(1139457161l, 2282914691l, TravelType.CAR, false);
    Route r2a = computeRoute(1139457161l, 2282914691l, TravelType.FOOT, true);
    checkRoute(r2a, 2988.2880825304173, 1139457161l, 2282914691l);
    Route r3a = computeRoute(1139457161l, 2282914691l, TravelType.ANY, true);
    checkRoute(r3a, 2988.2880825304173, 1139457161l, 2282914691l);
}


@Test(timeout = 3000)
public void testSmallRouting99RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1050901730l, 1808643080l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1050901730l, 1808643080l, TravelType.BIKE, false);
    computeRoute(1050901730l, 1808643080l, TravelType.CAR, false);
    Route r2a = computeRoute(1050901730l, 1808643080l, TravelType.FOOT, true);
    checkRoute(r2a, 4239.92315670436, 1050901730l, 1808643080l);
    Route r3a = computeRoute(1050901730l, 1808643080l, TravelType.ANY, true);
    checkRoute(r3a, 4239.92315670436, 1050901730l, 1808643080l);
}


@Test(timeout = 3000)
public void testSmallRouting100RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 317992393l, 1388224140l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(317992393l, 1388224140l, TravelType.BIKE, true);
    checkRoute(r0a, 5518.4893477351125, 317992393l, 1388224140l);
    computeRoute(317992393l, 1388224140l, TravelType.CAR, false);
    Route r2a = computeRoute(317992393l, 1388224140l, TravelType.FOOT, true);
    checkRoute(r2a, 5521.935540636838, 317992393l, 1388224140l);
    Route r3a = computeRoute(317992393l, 1388224140l, TravelType.ANY, true);
    checkRoute(r3a, 5518.4893477351125, 317992393l, 1388224140l);
}


@Test(timeout = 3000)
public void testSmallRouting101RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3309384444l, 2039821025l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(3309384444l, 2039821025l, TravelType.BIKE, false);
    computeRoute(3309384444l, 2039821025l, TravelType.CAR, false);
    computeRoute(3309384444l, 2039821025l, TravelType.FOOT, false);
    Route r3a = computeRoute(3309384444l, 2039821025l, TravelType.ANY, true);
    checkRoute(r3a, 4769.2936437253165, 3309384444l, 2039821025l);
}


@Test(timeout = 3000)
public void testSmallRouting102RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1620517920l, 1744643156l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1620517920l, 1744643156l, TravelType.BIKE, false);
    computeRoute(1620517920l, 1744643156l, TravelType.CAR, false);
    Route r2a = computeRoute(1620517920l, 1744643156l, TravelType.FOOT, true);
    checkRoute(r2a, 5804.53742430292, 1620517920l, 1744643156l);
    Route r3a = computeRoute(1620517920l, 1744643156l, TravelType.ANY, true);
    checkRoute(r3a, 5804.53742430292, 1620517920l, 1744643156l);
}


@Test(timeout = 3000)
public void testSmallRouting103RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1224171423l, 815249551l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1224171423l, 815249551l, TravelType.BIKE, false);
    computeRoute(1224171423l, 815249551l, TravelType.CAR, false);
    Route r2a = computeRoute(1224171423l, 815249551l, TravelType.FOOT, true);
    checkRoute(r2a, 956.869059141135, 1224171423l, 815249551l);
    Route r3a = computeRoute(1224171423l, 815249551l, TravelType.ANY, true);
    checkRoute(r3a, 956.869059141135, 1224171423l, 815249551l);
}


@Test(timeout = 3000)
public void testSmallRouting104RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 268640538l, 2146599004l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(268640538l, 2146599004l, TravelType.BIKE, false);
    computeRoute(268640538l, 2146599004l, TravelType.CAR, false);
    computeRoute(268640538l, 2146599004l, TravelType.FOOT, false);
    Route r3a = computeRoute(268640538l, 2146599004l, TravelType.ANY, true);
    checkRoute(r3a, 2005.286974032199, 268640538l, 2146599004l);
}


@Test(timeout = 3000)
public void testSmallRouting105RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 618927463l, 119368728l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(618927463l, 119368728l, TravelType.BIKE, true);
    checkRoute(r0a, 6787.203767484596, 618927463l, 119368728l);
    computeRoute(618927463l, 119368728l, TravelType.CAR, false);
    Route r2a = computeRoute(618927463l, 119368728l, TravelType.FOOT, true);
    checkRoute(r2a, 6242.654204587485, 618927463l, 119368728l);
    Route r3a = computeRoute(618927463l, 119368728l, TravelType.ANY, true);
    checkRoute(r3a, 6242.654204587485, 618927463l, 119368728l);
}


@Test(timeout = 3000)
public void testSmallRouting106RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1930664014l, 2228800164l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1930664014l, 2228800164l, TravelType.BIKE, true);
    checkRoute(r0a, 4341.725339227576, 1930664014l, 2228800164l);
    computeRoute(1930664014l, 2228800164l, TravelType.CAR, false);
    Route r2a = computeRoute(1930664014l, 2228800164l, TravelType.FOOT, true);
    checkRoute(r2a, 3550.3136405058544, 1930664014l, 2228800164l);
    Route r3a = computeRoute(1930664014l, 2228800164l, TravelType.ANY, true);
    checkRoute(r3a, 3550.3136405058544, 1930664014l, 2228800164l);
}


@Test(timeout = 3000)
public void testSmallRouting107RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1911438497l, 419241346l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1911438497l, 419241346l, TravelType.BIKE, false);
    computeRoute(1911438497l, 419241346l, TravelType.CAR, false);
    Route r2a = computeRoute(1911438497l, 419241346l, TravelType.FOOT, true);
    checkRoute(r2a, 1894.977279640999, 1911438497l, 419241346l);
    Route r3a = computeRoute(1911438497l, 419241346l, TravelType.ANY, true);
    checkRoute(r3a, 1894.977279640999, 1911438497l, 419241346l);
}


@Test(timeout = 3000)
public void testSmallRouting108RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2162404609l, 393956904l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(2162404609l, 393956904l, TravelType.BIKE, true);
    checkRoute(r0a, 6892.413487361246, 2162404609l, 393956904l);
    computeRoute(2162404609l, 393956904l, TravelType.CAR, false);
    Route r2a = computeRoute(2162404609l, 393956904l, TravelType.FOOT, true);
    checkRoute(r2a, 5611.136599316783, 2162404609l, 393956904l);
    Route r3a = computeRoute(2162404609l, 393956904l, TravelType.ANY, true);
    checkRoute(r3a, 5611.136599316783, 2162404609l, 393956904l);
}


@Test(timeout = 3000)
public void testSmallRouting109RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3419935260l, 2314428731l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(3419935260l, 2314428731l, TravelType.BIKE, false);
    computeRoute(3419935260l, 2314428731l, TravelType.CAR, false);
    Route r2a = computeRoute(3419935260l, 2314428731l, TravelType.FOOT, true);
    checkRoute(r2a, 4731.100099746887, 3419935260l, 2314428731l);
    Route r3a = computeRoute(3419935260l, 2314428731l, TravelType.ANY, true);
    checkRoute(r3a, 4547.917230448606, 3419935260l, 2314428731l);
}


@Test(timeout = 3000)
public void testSmallRouting110RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 663649265l, 2161778957l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(663649265l, 2161778957l, TravelType.BIKE, false);
    computeRoute(663649265l, 2161778957l, TravelType.CAR, false);
    Route r2a = computeRoute(663649265l, 2161778957l, TravelType.FOOT, true);
    checkRoute(r2a, 3756.6009929170023, 663649265l, 2161778957l);
    Route r3a = computeRoute(663649265l, 2161778957l, TravelType.ANY, true);
    checkRoute(r3a, 3756.6009929170023, 663649265l, 2161778957l);
}


@Test(timeout = 3000)
public void testSmallRouting111RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1507340012l, 374404962l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1507340012l, 374404962l, TravelType.BIKE, false);
    computeRoute(1507340012l, 374404962l, TravelType.CAR, false);
    Route r2a = computeRoute(1507340012l, 374404962l, TravelType.FOOT, true);
    checkRoute(r2a, 5484.207247994923, 1507340012l, 374404962l);
    Route r3a = computeRoute(1507340012l, 374404962l, TravelType.ANY, true);
    checkRoute(r3a, 5478.830377726071, 1507340012l, 374404962l);
}


@Test(timeout = 3000)
public void testSmallRouting112RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2278326276l, 155520863l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2278326276l, 155520863l, TravelType.BIKE, false);
    computeRoute(2278326276l, 155520863l, TravelType.CAR, false);
    Route r2a = computeRoute(2278326276l, 155520863l, TravelType.FOOT, true);
    checkRoute(r2a, 4997.342363820334, 2278326276l, 155520863l);
    Route r3a = computeRoute(2278326276l, 155520863l, TravelType.ANY, true);
    checkRoute(r3a, 4997.342363820334, 2278326276l, 155520863l);
}


@Test(timeout = 3000)
public void testSmallRouting113RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 784745228l, 2146389768l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(784745228l, 2146389768l, TravelType.BIKE, false);
    computeRoute(784745228l, 2146389768l, TravelType.CAR, false);
    Route r2a = computeRoute(784745228l, 2146389768l, TravelType.FOOT, true);
    checkRoute(r2a, 3022.2033370213744, 784745228l, 2146389768l);
    Route r3a = computeRoute(784745228l, 2146389768l, TravelType.ANY, true);
    checkRoute(r3a, 3022.2033370213744, 784745228l, 2146389768l);
}


@Test(timeout = 3000)
public void testSmallRouting114RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 276258816l, 989228078l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(276258816l, 989228078l, TravelType.BIKE, true);
    checkRoute(r0a, 4783.952543906595, 276258816l, 989228078l);
    computeRoute(276258816l, 989228078l, TravelType.CAR, false);
    Route r2a = computeRoute(276258816l, 989228078l, TravelType.FOOT, true);
    checkRoute(r2a, 4032.4999076707577, 276258816l, 989228078l);
    Route r3a = computeRoute(276258816l, 989228078l, TravelType.ANY, true);
    checkRoute(r3a, 4032.4999076707577, 276258816l, 989228078l);
}


@Test(timeout = 3000)
public void testSmallRouting115RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 281591006l, 1963402307l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(281591006l, 1963402307l, TravelType.BIKE, true);
    checkRoute(r0a, 3019.3806510702952, 281591006l, 1963402307l);
    computeRoute(281591006l, 1963402307l, TravelType.CAR, false);
    Route r2a = computeRoute(281591006l, 1963402307l, TravelType.FOOT, true);
    checkRoute(r2a, 2929.1180008263873, 281591006l, 1963402307l);
    Route r3a = computeRoute(281591006l, 1963402307l, TravelType.ANY, true);
    checkRoute(r3a, 2929.1180008263873, 281591006l, 1963402307l);
}


@Test(timeout = 3000)
public void testSmallRouting116RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2134677083l, 823700230l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2134677083l, 823700230l, TravelType.BIKE, false);
    computeRoute(2134677083l, 823700230l, TravelType.CAR, false);
    Route r2a = computeRoute(2134677083l, 823700230l, TravelType.FOOT, true);
    checkRoute(r2a, 6320.743857119699, 2134677083l, 823700230l);
    Route r3a = computeRoute(2134677083l, 823700230l, TravelType.ANY, true);
    checkRoute(r3a, 6320.743857119699, 2134677083l, 823700230l);
}


@Test(timeout = 3000)
public void testSmallRouting117RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 267041500l, 262169095l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(267041500l, 262169095l, TravelType.BIKE, false);
    computeRoute(267041500l, 262169095l, TravelType.CAR, false);
    Route r2a = computeRoute(267041500l, 262169095l, TravelType.FOOT, true);
    checkRoute(r2a, 2198.0229963411784, 267041500l, 262169095l);
    Route r3a = computeRoute(267041500l, 262169095l, TravelType.ANY, true);
    checkRoute(r3a, 2198.0229963411784, 267041500l, 262169095l);
}


@Test(timeout = 3000)
public void testSmallRouting118RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2027894524l, 1425534095l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2027894524l, 1425534095l, TravelType.BIKE, false);
    computeRoute(2027894524l, 1425534095l, TravelType.CAR, false);
    Route r2a = computeRoute(2027894524l, 1425534095l, TravelType.FOOT, true);
    checkRoute(r2a, 4057.5803577194524, 2027894524l, 1425534095l);
    Route r3a = computeRoute(2027894524l, 1425534095l, TravelType.ANY, true);
    checkRoute(r3a, 4057.5803577194524, 2027894524l, 1425534095l);
}


@Test(timeout = 3000)
public void testSmallRouting119RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1517555457l, 2228279195l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1517555457l, 2228279195l, TravelType.BIKE, false);
    computeRoute(1517555457l, 2228279195l, TravelType.CAR, false);
    Route r2a = computeRoute(1517555457l, 2228279195l, TravelType.FOOT, true);
    checkRoute(r2a, 4255.65617909033, 1517555457l, 2228279195l);
    Route r3a = computeRoute(1517555457l, 2228279195l, TravelType.ANY, true);
    checkRoute(r3a, 4255.65617909033, 1517555457l, 2228279195l);
}


@Test(timeout = 3000)
public void testSmallRouting120RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 2270441168l, 2278352393l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(2270441168l, 2278352393l, TravelType.BIKE, false);
    computeRoute(2270441168l, 2278352393l, TravelType.CAR, false);
    Route r2a = computeRoute(2270441168l, 2278352393l, TravelType.FOOT, true);
    checkRoute(r2a, 4138.232144296137, 2270441168l, 2278352393l);
    Route r3a = computeRoute(2270441168l, 2278352393l, TravelType.ANY, true);
    checkRoute(r3a, 4137.920059342612, 2270441168l, 2278352393l);
}


@Test(timeout = 3000)
public void testSmallRouting121RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 3453552267l, 308944363l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(3453552267l, 308944363l, TravelType.BIKE, false);
    computeRoute(3453552267l, 308944363l, TravelType.CAR, false);
    Route r2a = computeRoute(3453552267l, 308944363l, TravelType.FOOT, true);
    checkRoute(r2a, 2790.9559441788065, 3453552267l, 308944363l);
    Route r3a = computeRoute(3453552267l, 308944363l, TravelType.ANY, true);
    checkRoute(r3a, 2790.9559441788065, 3453552267l, 308944363l);
}


@Test(timeout = 3000)
public void testSmallRouting122RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 344240733l, 1597767482l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(344240733l, 1597767482l, TravelType.BIKE, false);
    computeRoute(344240733l, 1597767482l, TravelType.CAR, false);
    Route r2a = computeRoute(344240733l, 1597767482l, TravelType.FOOT, true);
    checkRoute(r2a, 2298.8696019695603, 344240733l, 1597767482l);
    Route r3a = computeRoute(344240733l, 1597767482l, TravelType.ANY, true);
    checkRoute(r3a, 2298.8696019695603, 344240733l, 1597767482l);
}


@Test(timeout = 3000)
public void testSmallRouting123RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 252104676l, 104580640l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(252104676l, 104580640l, TravelType.BIKE, false);
    Route r1a = computeRoute(252104676l, 104580640l, TravelType.CAR, true);
    checkRoute(r1a, 5193.288177794905, 252104676l, 104580640l);
    computeRoute(252104676l, 104580640l, TravelType.FOOT, false);
    Route r3a = computeRoute(252104676l, 104580640l, TravelType.ANY, true);
    checkRoute(r3a, 5167.252127690875, 252104676l, 104580640l);
}


@Test(timeout = 3000)
public void testSmallRouting124RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1393920962l, 705152344l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1393920962l, 705152344l, TravelType.BIKE, false);
    computeRoute(1393920962l, 705152344l, TravelType.CAR, false);
    Route r2a = computeRoute(1393920962l, 705152344l, TravelType.FOOT, true);
    checkRoute(r2a, 6578.503226911106, 1393920962l, 705152344l);
    Route r3a = computeRoute(1393920962l, 705152344l, TravelType.ANY, true);
    checkRoute(r3a, 6578.503226911106, 1393920962l, 705152344l);
}


@Test(timeout = 3000)
public void testSmallRouting125RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 411285915l, 277448734l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(411285915l, 277448734l, TravelType.BIKE, false);
    computeRoute(411285915l, 277448734l, TravelType.CAR, false);
    Route r2a = computeRoute(411285915l, 277448734l, TravelType.FOOT, true);
    checkRoute(r2a, 11145.387090106049, 411285915l, 277448734l);
    Route r3a = computeRoute(411285915l, 277448734l, TravelType.ANY, true);
    checkRoute(r3a, 11143.988253161682, 411285915l, 277448734l);
}


@Test(timeout = 3000)
public void testSmallRouting126RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1550886853l, 1269196882l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    Route r0a = computeRoute(1550886853l, 1269196882l, TravelType.BIKE, true);
    checkRoute(r0a, 12751.521524112375, 1550886853l, 1269196882l);
    computeRoute(1550886853l, 1269196882l, TravelType.CAR, false);
    Route r2a = computeRoute(1550886853l, 1269196882l, TravelType.FOOT, true);
    checkRoute(r2a, 10860.604682212725, 1550886853l, 1269196882l);
    Route r3a = computeRoute(1550886853l, 1269196882l, TravelType.ANY, true);
    checkRoute(r3a, 10860.604682212725, 1550886853l, 1269196882l);
}


@Test(timeout = 3000)
public void testSmallRouting127RandomNodes() {
	   Graph g = getGraph();
    long[] waypoints = { 1377479736l, 408092580l };
    List<Node> waypointsList = new ArrayList<>(waypoints.length);
    for (long id : waypoints)
    	waypointsList.add(g.getNode(id));

    computeRoute(1377479736l, 408092580l, TravelType.BIKE, false);
    computeRoute(1377479736l, 408092580l, TravelType.CAR, false);
    Route r2a = computeRoute(1377479736l, 408092580l, TravelType.FOOT, true);
    checkRoute(r2a, 2302.107808210699, 1377479736l, 408092580l);
    Route r3a = computeRoute(1377479736l, 408092580l, TravelType.ANY, true);
    checkRoute(r3a, 2302.107808210699, 1377479736l, 408092580l);
}


@Override
public String getMapFileName() {
    return "saarbruecken.osm.nae";
}


}