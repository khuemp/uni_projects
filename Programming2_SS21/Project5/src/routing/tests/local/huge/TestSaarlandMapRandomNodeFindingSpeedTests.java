package routing.tests.local.huge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import routing.Coordinate;
import routing.Node;
import routing.NodeFinder;
import routing.tests.TestingBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSaarlandMapRandomNodeFindingSpeedTests extends TestingBase {
	private static final long timeOut = 200;

	@Override
	public String getMapFileName() {
		return "saarland.osm.nae";
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
		double[] latitudes = { 49.47526705161573, 49.11615104163953,
				49.66346535987365, 49.46145155572808, 49.35532626983149,
				49.58340562545322, 49.12004319250498, 49.60008362762168,
				49.51712854411439, 49.46350814931784, 49.424525707919635,
				49.20590867086803, 49.58997248600027, 49.54864480990787,
				49.32905048196626, 49.36172279662775, 49.263333804398656,
				49.695152683937266, 49.12297878411114, 49.557272508663466,
				49.069289828312364, 49.210330242748505, 49.40202474802998,
				49.85488933650986, 49.08111168030151, 49.505089349530834,
				49.056401410559225, 49.845512092378954, 49.46022191189186,
				49.40257044249144, 49.776781450770756, 49.572666105533365 };
		double[] longitudes = { 6.346744642542367, 6.951795481518291,
				6.3273640340056625, 7.083468398735467, 7.087659641303308,
				6.957131848075044, 7.431344733884212, 7.326387922962493,
				6.597990201817376, 7.239729268711532, 7.197596961469861,
				7.027868187972938, 6.55052513738132, 6.886203366174595,
				6.966016105754447, 6.595773762818047, 7.355885815614867,
				7.382534797184939, 6.422000288148584, 6.988287139078539,
				7.083644857505253, 6.286981103122897, 7.663547352986967,
				6.877024207362433, 6.77436099656096, 6.867078307001119,
				6.780050006590851, 6.699181071034628, 7.2286381110217945,
				7.516960968204184, 6.3921838504688475, 7.116196336746517 };
		long[] nodes = { 264251969l, 1754270995l, 1257672205l, 2308729375l,
				455493612l, 3214584807l, 378066695l, 2841656658l, 456737060l,
				403295215l, 2075168283l, 412248024l, 1357281101l, 3469204983l,
				1504544878l, 1366644239l, 614413620l, 249483454l, 1521581862l,
				391375808l, 2033001542l, 951513418l, 1629272754l, 2970517033l,
				365766836l, 484789064l, 365766836l, 2970517033l, 2126114582l,
				1326350260l, 1648029866l, 2175104654l };
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