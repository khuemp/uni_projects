package routing;

import java.util.List;

import routing.utils.JSONHelper;

public abstract class RouteBase implements Route {

	private void appendLegs(StringBuilder sb) {
		JSONHelper.appendEscapedString(sb, "legs");
		JSONHelper.appendColon(sb);
		JSONHelper.openSBlock(sb);
		for (RouteLeg rl : this) {
			sb.append(rl.toJSON());
			JSONHelper.appendComma(sb);
		}

		sb.deleteCharAt(sb.length() - 1);

		JSONHelper.closeSBlock(sb);
	}

	private void appendRoute(StringBuilder sb, long time,
			List<Coordinate> waypoints) {
		JSONHelper.appendEscapedString(sb, "routes");
		JSONHelper.appendColon(sb);
		JSONHelper.openSBlock(sb);
		JSONHelper.openCBlock(sb);

		JSONHelper.appendInfoNumber(sb, "ctime", "s", time / 1000.0);
		JSONHelper.appendComma(sb);
		JSONHelper.appendInfoNumber(sb, "distance", "m", distance());
		JSONHelper.appendComma(sb);
		JSONHelper.appendInfoNumber(sb, "duration", "h", 0);
		JSONHelper.appendComma(sb);
		JSONHelper.appendInfoString(sb, "traveltype", getTravelType().name());
		JSONHelper.appendComma(sb);

		if (waypoints != null) {
			for (int i = 0; i < waypoints.size(); i++) {
				JSONHelper.appendWaypoint(sb, "waypoint" + i, waypoints.get(i));
				if (i + 1 != waypoints.size())
					JSONHelper.appendComma(sb);
			}

			if (waypoints.size() > 0)
				JSONHelper.appendComma(sb);
		}

		JSONHelper.appendLocation(sb, false, getStartNode().getCoordinate());
		JSONHelper.appendComma(sb);
		JSONHelper.appendLocation(sb, true, getEndNode().getCoordinate());
		JSONHelper.appendComma(sb);

		appendLegs(sb);

		JSONHelper.closeCBlock(sb);
		JSONHelper.closeSBlock(sb);
	}

	private void createBoundingBox(StringBuilder sb) {
		double[] min = { Double.MAX_VALUE, Double.MAX_VALUE };
		double[] max = { Double.MIN_VALUE, Double.MIN_VALUE };

		for (RouteLeg rl : this) {
			for (Node n : rl) {
				Coordinate c = n.getCoordinate();
				min[0] = Math.min(min[0], c.getLatitude());
				max[0] = Math.max(max[0], c.getLatitude());
				min[1] = Math.min(min[1], c.getLongitude());
				max[1] = Math.max(max[1], c.getLongitude());
			}
		}

		JSONHelper.appendEscapedString(sb, "boundingBox");
		JSONHelper.appendColon(sb);
		JSONHelper.openCBlock(sb);
		JSONHelper.appendEscapedString(sb, "nw");
		JSONHelper.appendColon(sb);
		JSONHelper.appendCoordinate(sb, new Coordinate(max[0], max[1]));

		JSONHelper.appendComma(sb);

		JSONHelper.appendEscapedString(sb, "se");
		JSONHelper.appendColon(sb);
		JSONHelper.appendCoordinate(sb, new Coordinate(min[0], min[1]));

		JSONHelper.closeCBlock(sb);
	}

	@Override
	public String toJSON(long time, List<Coordinate> waypoints) {
		StringBuilder sb = new StringBuilder();
		JSONHelper.openCBlock(sb);

		createBoundingBox(sb);

		JSONHelper.appendComma(sb);

		appendRoute(sb, time, waypoints);

		JSONHelper.closeCBlock(sb);

		return sb.toString();
	}

}
