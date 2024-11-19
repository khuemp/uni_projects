package routing.tests.local.fast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import routing.Coordinate;
import routing.Node;
import routing.NodeFinder;
import routing.tests.TestingBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSaarbrueckenMapRandomNodeFindingSpeedTests extends TestingBase {
	private static final long timeOut=100;

	@Before
	public void setUp() {
		getNodeFinder();
	}
	
	@Override
	public String getMapFileName() {
		return "saarbruecken.osm.nae";
	}
	
	@Test
	public void testAssertNodeFinder() {
      NodeFinder nf = getNodeFinder();
      assertNotNull("NodeFinder was null", nf);
	}

	@Test(timeout = timeOut)
	public void testNodeFinding32RandomNodesInside() {
		NodeFinder nf = getNodeFinder();
		assertNotNull("NodeFinder was null", nf);
		double[] latitudes = { 49.40972227573018, 49.19870688786447,
				49.463848626160726, 49.395235190216724, 49.510540610548695,
				49.27941789168698, 49.54263908066978, 49.30355662049996,
				49.39218655023936, 49.54403073350562, 49.42648566677076,
				49.55012765687369, 49.2838198255075, 49.59689901511734,
				49.66828961537403, 49.58259606522245, 49.628105978639354,
				49.2943996017193, 49.3282470139806, 49.36791962228144,
				49.22477262104921, 49.66566279208867, 49.604612531206044,
				49.203604856724766, 49.25768920571278, 49.599040466951344,
				49.34657282852934, 49.432488230747495, 49.394501350247594,
				49.213172521491074, 49.593092769166276, 49.23400255362043 };
		double[] longitudes = { 7.27614290641637, 7.36229562388127,
				6.984728947229556, 7.357254944907711, 7.270290433168114,
				7.304594999535268, 7.104643178492859, 7.375488297148382,
				7.215136112324803, 6.93500060341856, 7.181508311953596,
				6.8953153131992995, 7.044704345603911, 6.700289428771959,
				6.8955610471325794, 7.356421342067169, 6.794312955964611,
				6.775343163519051, 6.9094093331150725, 7.225724173876446,
				6.820150750489442, 6.933701986557262, 7.374622279327639,
				6.873376972787823, 6.9908190872145965, 7.061734639201396,
				6.723031018617305, 7.070077252134525, 7.151998765030305,
				7.012676554536459, 6.7879083773626485, 7.325811953877451 };
		long[] nodes = { 1629272665l, 1629272638l, 778319991l, 1629272701l,
				1629272685l, 1211141670l, 791627145l, 1629272638l, 1208977060l,
				890999457l, 1208977111l, 1521686733l, 343388706l, 1521687103l,
				1521687351l, 1629272701l, 1521687160l, 1033019782l,
				1029735802l, 1208977060l, 267952855l, 1521687351l, 1629272701l,
				323607530l, 610899996l, 1521687115l, 1029735852l, 791627145l,
				1209109971l, 1137426669l, 1521687111l, 1211141670l };
		for (int i = 0; i < 32; i++) {
			Coordinate c = new Coordinate(latitudes[i], longitudes[i]);
			Node n = nf.getNodeForCoordinates(c);
			assertNotNull("NodeFinder return null for (" + latitudes[i] + "|"
					+ longitudes[i] + ").", n);
			assertEquals("NodeFinder return wrong node for (" + latitudes[i]
					+ "|" + longitudes[i] + ").", nodes[i], n.getId());
		}
		;
	}
}