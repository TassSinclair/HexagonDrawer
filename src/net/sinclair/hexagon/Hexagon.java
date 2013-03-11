package net.sinclair.hexagon;

import java.awt.Point;

public class Hexagon {

	private final Point[] points;
	private final Point origin;

	public static enum HexPoint {
		LEFT,
		TOP_LEFT,
		TOP_RIGHT,
		RIGHT,
		BOTTOM_RIGHT,
		BOTTOM_LEFT
	}

	public Hexagon(Point origin, int edgeLength) {
		this.origin = origin;
		points = new Point[HexPoint.values().length];
		points[HexPoint.LEFT.ordinal()] = new Point(
				origin.x,
				(int) (edgeLength * .8) + origin.y);
		points[HexPoint.TOP_LEFT.ordinal()] = new Point(
				(int) (edgeLength * .6) + origin.x,
				origin.y);
		points[HexPoint.TOP_RIGHT.ordinal()] = new Point(
				(int) (edgeLength * .6) + edgeLength + origin.x,
				origin.y);
		points[HexPoint.RIGHT.ordinal()] = new Point(
				2 * (int) (edgeLength * .6) + edgeLength + origin.x,
				(int) (edgeLength * .8) + origin.y);
		points[HexPoint.BOTTOM_RIGHT.ordinal()] = new Point(
				(int) (edgeLength * .6) + edgeLength + origin.x,
				2 * (int) (edgeLength * .8) + origin.y);
		points[HexPoint.BOTTOM_LEFT.ordinal()] = new Point(
				(int) (edgeLength * .6) + origin.x,
				2 * (int) (edgeLength * .8) + origin.y);
	}

	public Point getOrigin() {
		return origin;
	}

	public static int calculateVerticalInterlockDistance(int edgeLength) {
		return (int) (edgeLength * .8);
	}

	public static int calculateHorizontalInterlockDistance(int edgeLength) {
		return (int) (edgeLength * .6) + edgeLength;
	}

	public static int calculateWidth(int edgeLength) {
		return (int) (edgeLength * 2.2);
	}

	public static int calculateHeight(int edgeLength) {
		return (int) (edgeLength * 1.6);
	}

	public Point getPoint(HexPoint point) {
		return points[point.ordinal()];
	}
}
