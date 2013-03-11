package net.sinclair.hexagon;

import java.awt.Point;

import net.sinclair.hexagon.Hexagon.HexPoint;

public class HexagonDrawer {

	private final int lengthOfHorizontalEdge;
	private final int diameterInHexagons;

	public static void main(String... args) {

		HexagonDrawer instance = new HexagonDrawer(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		instance.process();
	}

	public HexagonDrawer(int lengthOfHorizontalEdge, int diameterInHexagons) {
		this.lengthOfHorizontalEdge = lengthOfHorizontalEdge;
		this.diameterInHexagons = diameterInHexagons;
	}

	public void process() {
		int rowsToRender = diameterInHexagons * 2 - 1;
		Hexagon[][] hexagons = new Hexagon[rowsToRender][];

		for (int i = 0; i < rowsToRender; ++i) {
			hexagons[i] = renderRow(i + 1);
		}

		for (int i = 0; i < hexagons.length; ++i) {
			for (int j = 0; j < hexagons[i].length; ++j) {
				renderHexagon(hexagons[i][j]);
			}
		}
	}

	public Hexagon[] renderRow(int row) {

		int sectionCeiling = (diameterInHexagons + 1) / 2;

		int hexagonsThisRow = row;

		// Change a count of [1,2,3,4,5,6,7,8,9] to [1,2,3,4,5,4,3,2,1].
		if (hexagonsThisRow > diameterInHexagons) {
			hexagonsThisRow = diameterInHexagons * 2 - row;
		}

		// Change a count of [1,2,3,4,5,4,3,2,1] to [1,2,3,2,3,2,3,2,1]
		if (hexagonsThisRow > sectionCeiling) {
			hexagonsThisRow = sectionCeiling - (hexagonsThisRow - sectionCeiling) % 2;
		}

		Hexagon[] hexagons = new Hexagon[hexagonsThisRow];

		int hexWidth = Hexagon.calculateWidth(lengthOfHorizontalEdge) + lengthOfHorizontalEdge;

		int hexWidthInterlock = Hexagon.calculateHorizontalInterlockDistance(lengthOfHorizontalEdge);
		int xOffset = (sectionCeiling - hexagonsThisRow) * hexWidthInterlock;
		int yOffset = Hexagon.calculateVerticalInterlockDistance(lengthOfHorizontalEdge) * (row - 1);

		for (int i = 0; i < hexagons.length; ++i) {
			hexagons[i] = new Hexagon(new Point(xOffset, yOffset), lengthOfHorizontalEdge);
			xOffset += hexWidth;
		}
		return hexagons;
	}

	private void renderHexagon(Hexagon hexagon) {

		System.out.println("\t<path id=\"hex-" + hexagon.getPoint(HexPoint.LEFT).x + "-"
				+ hexagon.getPoint(HexPoint.LEFT).y + "\"");
		System.out.println("\t\tfill=\"none\" stroke=\"black\" stroke-width=\"1\"");
		System.out.println("\t\td=\"M");
		System.out.println("\t\t\t" + twiceWithSpaceBetween(extractCoordinatePair(hexagon, HexPoint.LEFT)));
		System.out.println("\t\t\t" + twiceWithSpaceBetween(extractCoordinatePair(hexagon, HexPoint.TOP_LEFT)));
		System.out.println("\t\t\t" + twiceWithSpaceBetween(extractCoordinatePair(hexagon, HexPoint.TOP_RIGHT)));
		System.out.println("\t\t\t" + twiceWithSpaceBetween(extractCoordinatePair(hexagon, HexPoint.RIGHT)));
		System.out.println("\t\t\t" + twiceWithSpaceBetween(extractCoordinatePair(hexagon, HexPoint.BOTTOM_RIGHT)));
		System.out.println("\t\t\t" + twiceWithSpaceBetween(extractCoordinatePair(hexagon, HexPoint.BOTTOM_LEFT)));
		System.out.println("\t\t\t" + twiceWithSpaceBetween(extractCoordinatePair(hexagon, HexPoint.LEFT)));
		System.out.println("\t\t\"/>");
	}

	private String extractCoordinatePair(Hexagon hexagon, HexPoint point) {
		return hexagon.getPoint(point).x + "," + hexagon.getPoint(point).y;
	}

	private String twiceWithSpaceBetween(String string) {
		return string + " " + string;
	}
}
