package routing.utils;

import routing.Coordinate;

public class JSONHelper {

	public static void appendColon(StringBuilder sb) {
		sb.append(":");
	}

	public static void appendComma(StringBuilder sb) {
		sb.append(",");
	}

	public static void appendCoordinate(StringBuilder sb, Coordinate c) {
		sb.append("[");
		sb.append(c.getLatitude());
		appendComma(sb);
		sb.append(c.getLongitude());
		sb.append("]");
	}

	public static void appendEscapedString(StringBuilder sb, String s) {
		sb.append("\"");
		sb.append(s);
		sb.append("\"");
	}

	public static void appendInfoNumber(StringBuilder sb, String key,
			String unit, double number) {

		appendEscapedString(sb, key);
		appendColon(sb);
		openCBlock(sb);
		appendEscapedString(sb, "text");
		appendColon(sb);
		appendEscapedString(sb, String.format("%.3f %s", number, unit));

		appendComma(sb);

		appendEscapedString(sb, "value");
		appendColon(sb);
		sb.append(number);

		closeCBlock(sb);
	}

	public static void appendInfoString(StringBuilder sb, String key,
			String value) {
		appendEscapedString(sb, key);
		appendColon(sb);
		openCBlock(sb);
		appendEscapedString(sb, "text");
		appendColon(sb);
		appendEscapedString(sb, value);
		closeCBlock(sb);
	}

	public static void appendLocation(StringBuilder sb, boolean end,
			Coordinate c) {
		if (end)
			appendEscapedString(sb, "end_location");
		else
			appendEscapedString(sb, "start_location");
		appendColon(sb);
		appendCoordinate(sb, c);
	}

	public static void appendWaypoint(StringBuilder sb, String key, Coordinate c) {
		appendEscapedString(sb, key);
		appendColon(sb);

		appendCoordinate(sb, c);
	}

	public static void closeCBlock(StringBuilder sb) {
		sb.append("}");
	}

	public static void closeSBlock(StringBuilder sb) {
		sb.append("]");
	}

	public static void openCBlock(StringBuilder sb) {
		sb.append("{");
	}

	public static void openSBlock(StringBuilder sb) {
		sb.append("[");
	}

}
