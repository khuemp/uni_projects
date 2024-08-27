package routing;

import routing.utils.JSONHelper;

public abstract class RouteLegBase implements RouteLeg {

	private void appendInfo(StringBuilder sb) {
		JSONHelper.appendInfoNumber(sb, "distance", "km", getDistance());
		JSONHelper.appendComma(sb);
		JSONHelper.appendInfoNumber(sb, "duration", "h", 0);
		JSONHelper.appendComma(sb);
		JSONHelper.appendLocation(sb, false, getStartNode().getCoordinate());
		JSONHelper.appendComma(sb);
		JSONHelper.appendLocation(sb, true, getEndNode().getCoordinate());
	}

	private void appendPolyline(StringBuilder sb) {
		JSONHelper.appendEscapedString(sb, "polyline");
		JSONHelper.appendColon(sb);
		JSONHelper.openSBlock(sb);

		for (Node n : this) {
			JSONHelper.appendCoordinate(sb, n.getCoordinate());
			JSONHelper.appendComma(sb);
		}

		sb.deleteCharAt(sb.length() - 1);

		JSONHelper.closeSBlock(sb);
	}

	private void appendStep(StringBuilder sb) {
		JSONHelper.appendEscapedString(sb, "steps");
		JSONHelper.appendColon(sb);
		JSONHelper.openSBlock(sb);
		JSONHelper.openCBlock(sb);

		appendInfo(sb);

		JSONHelper.appendComma(sb);

		appendPolyline(sb);

		JSONHelper.closeCBlock(sb);
		JSONHelper.closeSBlock(sb);
	}

	@Override
	public String toJSON() {
		StringBuilder sb = new StringBuilder();
		JSONHelper.openCBlock(sb);

		appendInfo(sb);

		JSONHelper.appendComma(sb);

		appendStep(sb);

		JSONHelper.closeCBlock(sb);

		return sb.toString();
	}

}
