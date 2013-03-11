package net.sinclair.hexagon;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import net.sinclair.hexagon.Hexagon.HexPoint;

import org.junit.Test;

public class HexagonTest {

	private final static Point ZERO_ZERO = new Point(0, 0);

	@Test
	public void shouldReturnAValueForEachHexagonPoint() {
		Hexagon hexagon = new Hexagon(ZERO_ZERO, 0);

		for (Hexagon.HexPoint pointName : Hexagon.HexPoint.values()) {
			hexagon.getPoint(pointName);
		}
	}

	@Test
	public void shouldOffsetAllPointsBasedOnHorizontalPosition() {
		Point point = new Point(70, 80);

		Hexagon originHexagon = new Hexagon(ZERO_ZERO, 0);
		Hexagon offsetHexagon = new Hexagon(point, 0);

		assertEquals(originHexagon.getPoint(HexPoint.LEFT).x + 70, offsetHexagon.getPoint(HexPoint.LEFT).x);
		assertEquals(originHexagon.getPoint(HexPoint.TOP_LEFT).x + 70, offsetHexagon.getPoint(HexPoint.TOP_LEFT).x);
		assertEquals(originHexagon.getPoint(HexPoint.TOP_RIGHT).x + 70, offsetHexagon.getPoint(HexPoint.TOP_RIGHT).x);
		assertEquals(originHexagon.getPoint(HexPoint.RIGHT).x + 70, offsetHexagon.getPoint(HexPoint.RIGHT).x);
		assertEquals(originHexagon.getPoint(HexPoint.BOTTOM_RIGHT).x + 70,
				offsetHexagon.getPoint(HexPoint.BOTTOM_RIGHT).x);
		assertEquals(originHexagon.getPoint(HexPoint.BOTTOM_LEFT).x + 70,
				offsetHexagon.getPoint(HexPoint.BOTTOM_LEFT).x);
	}

	@Test
	public void shouldOffsetAllPointsBasedOnVerticalPosition() {
		Point point = new Point(70, 80);

		Hexagon originHexagon = new Hexagon(ZERO_ZERO, 0);
		Hexagon offsetHexagon = new Hexagon(point, 0);

		assertEquals(originHexagon.getPoint(HexPoint.LEFT).y + 80, offsetHexagon.getPoint(HexPoint.LEFT).y);
		assertEquals(originHexagon.getPoint(HexPoint.TOP_LEFT).y + 80, offsetHexagon.getPoint(HexPoint.TOP_LEFT).y);
		assertEquals(originHexagon.getPoint(HexPoint.TOP_RIGHT).y + 80, offsetHexagon.getPoint(HexPoint.TOP_RIGHT).y);
		assertEquals(originHexagon.getPoint(HexPoint.RIGHT).y + 80, offsetHexagon.getPoint(HexPoint.RIGHT).y);
		assertEquals(originHexagon.getPoint(HexPoint.BOTTOM_RIGHT).y + 80,
				offsetHexagon.getPoint(HexPoint.BOTTOM_RIGHT).y);
		assertEquals(originHexagon.getPoint(HexPoint.BOTTOM_LEFT).y + 80,
				offsetHexagon.getPoint(HexPoint.BOTTOM_LEFT).y);
	}

	@Test
	public void shouldCalculateHorizontalDistancesForPoints() {
		Hexagon hexagon = new Hexagon(ZERO_ZERO, 5);

		assertEquals(0, hexagon.getPoint(HexPoint.LEFT).x);
		assertEquals(3, hexagon.getPoint(HexPoint.TOP_LEFT).x);
		assertEquals(3 + 5, hexagon.getPoint(HexPoint.TOP_RIGHT).x);
		assertEquals(3 + 5 + 3, hexagon.getPoint(HexPoint.RIGHT).x);
		assertEquals(3, hexagon.getPoint(HexPoint.BOTTOM_LEFT).x);
		assertEquals(3 + 5, hexagon.getPoint(HexPoint.BOTTOM_RIGHT).x);
	}

	@Test
	public void shouldCalculateVerticalDistancesForPoints() {
		Hexagon hexagon = new Hexagon(ZERO_ZERO, 5);

		assertEquals(4, hexagon.getPoint(HexPoint.LEFT).y);
		assertEquals(0, hexagon.getPoint(HexPoint.TOP_LEFT).y);
		assertEquals(0, hexagon.getPoint(HexPoint.TOP_RIGHT).y);
		assertEquals(4, hexagon.getPoint(HexPoint.RIGHT).y);
		assertEquals(8, hexagon.getPoint(HexPoint.BOTTOM_LEFT).y);
		assertEquals(8, hexagon.getPoint(HexPoint.BOTTOM_RIGHT).y);
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowIllegalArgumentExceptionForNullPoint() {
		new Hexagon(new Point(), 0).getPoint(null);
	}

	@Test
	public void shouldCalculateWidthAppropriately() {
		assertEquals(11, Hexagon.calculateWidth(5));
	}

	@Test
	public void shouldCalculateHeightAppropriately() {
		assertEquals(8, Hexagon.calculateHeight(5));
	}
}
