package net.sinclair.hexagon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HexagonDrawerTest {

	@Test
	public void shouldCalculateAppropriateHorizontalDistancePerRow() {
		HexagonDrawer hexDrawer = new HexagonDrawer(10, 3);

		assertEquals(0, hexDrawer.renderRow(1)[0].getOrigin().y);
		assertEquals(8, hexDrawer.renderRow(2)[0].getOrigin().y);
		assertEquals(16, hexDrawer.renderRow(3)[0].getOrigin().y);
		assertEquals(24, hexDrawer.renderRow(4)[0].getOrigin().y);
		assertEquals(32, hexDrawer.renderRow(5)[0].getOrigin().y);
	}

	@Test
	public void shouldCalculateAppropriateVerticalDistancePerRowForDiameter3() {
		HexagonDrawer hexDrawer = new HexagonDrawer(10, 3);

		assertEquals(16, hexDrawer.renderRow(1)[0].getOrigin().x);
		assertEquals(0, hexDrawer.renderRow(2)[0].getOrigin().x);
		assertEquals(16, hexDrawer.renderRow(3)[0].getOrigin().x);
		assertEquals(0, hexDrawer.renderRow(4)[0].getOrigin().x);
		assertEquals(16, hexDrawer.renderRow(5)[0].getOrigin().x);
	}

	@Test
	public void shouldCalculateAppropriateVerticalDistancePerRowForDiameter5() {
		HexagonDrawer hexDrawer = new HexagonDrawer(10, 5);

		assertEquals(32, hexDrawer.renderRow(1)[0].getOrigin().x);
		assertEquals(16, hexDrawer.renderRow(2)[0].getOrigin().x);
		assertEquals(0, hexDrawer.renderRow(3)[0].getOrigin().x);
		assertEquals(16, hexDrawer.renderRow(4)[0].getOrigin().x);
		assertEquals(0, hexDrawer.renderRow(5)[0].getOrigin().x);
		assertEquals(16, hexDrawer.renderRow(6)[0].getOrigin().x);
		assertEquals(0, hexDrawer.renderRow(7)[0].getOrigin().x);
		assertEquals(16, hexDrawer.renderRow(8)[0].getOrigin().x);
		assertEquals(32, hexDrawer.renderRow(9)[0].getOrigin().x);
	}

	@Test
	public void shouldCalculateAppropriateHorizontalOffsetForHexigonsPerRow() {
		HexagonDrawer hexDrawer = new HexagonDrawer(10, 5);

		Hexagon[] hexagonsOnRow = hexDrawer.renderRow(5);
		for (int i = 1; i < hexagonsOnRow.length; ++i) {
			assertEquals(32, hexagonsOnRow[i].getOrigin().x - hexagonsOnRow[i - 1].getOrigin().x);
		}
	}

	@Test
	public void shouldReturnOneHexagonForFirstRowOfHexagonOfDiamater1() {
		HexagonDrawer hexDrawer = new HexagonDrawer(10, 1);

		assertEquals(1, hexDrawer.renderRow(1).length);
	}

	@Test
	public void shouldReturnCorrectHexagonCountForAllRowOfHexagonOfDiamater3() {
		HexagonDrawer hexDrawer = new HexagonDrawer(10, 3);

		assertEquals(1, hexDrawer.renderRow(1).length);
		assertEquals(2, hexDrawer.renderRow(2).length);
		assertEquals(1, hexDrawer.renderRow(3).length);
		assertEquals(2, hexDrawer.renderRow(4).length);
		assertEquals(1, hexDrawer.renderRow(5).length);
	}

	@Test
	public void shouldReturnCorrectHexagonCountForAllRowOfHexagonOfDiamater5() {
		HexagonDrawer hexDrawer = new HexagonDrawer(10, 5);

		assertEquals(1, hexDrawer.renderRow(1).length);
		assertEquals(2, hexDrawer.renderRow(2).length);
		assertEquals(3, hexDrawer.renderRow(3).length);
		assertEquals(2, hexDrawer.renderRow(4).length);
		assertEquals(3, hexDrawer.renderRow(5).length);
		assertEquals(2, hexDrawer.renderRow(6).length);
		assertEquals(3, hexDrawer.renderRow(7).length);
		assertEquals(2, hexDrawer.renderRow(8).length);
		assertEquals(1, hexDrawer.renderRow(9).length);
	}

	@Test
	public void shouldReturnCorrectHexagonCountForAllRowOfHexagonOfDiamater7() {
		HexagonDrawer hexDrawer = new HexagonDrawer(10, 7);

		assertEquals(1, hexDrawer.renderRow(1).length);
		assertEquals(2, hexDrawer.renderRow(2).length);
		assertEquals(3, hexDrawer.renderRow(3).length);
		assertEquals(4, hexDrawer.renderRow(4).length);
		assertEquals(3, hexDrawer.renderRow(5).length);
		assertEquals(4, hexDrawer.renderRow(6).length);
		assertEquals(3, hexDrawer.renderRow(7).length);
		assertEquals(4, hexDrawer.renderRow(8).length);
		assertEquals(3, hexDrawer.renderRow(9).length);
		assertEquals(4, hexDrawer.renderRow(10).length);
		assertEquals(3, hexDrawer.renderRow(11).length);
		assertEquals(2, hexDrawer.renderRow(12).length);
		assertEquals(1, hexDrawer.renderRow(13).length);
	}

	@Test
	public void shouldIncludeBorderAsOffsetWhenBorderUsed() {
		HexagonDrawer hexDrawerWithoutBorder = new HexagonDrawer(10, 3);
		HexagonDrawer hexDrawerWithBorder = new HexagonDrawer(10, 3);
		hexDrawerWithBorder.setUseBorder(true);

		assertEquals(hexDrawerWithoutBorder.renderRow(2)[0].getOrigin().x + 100,
				hexDrawerWithBorder.renderRow(2)[0].getOrigin().x);
		assertEquals(hexDrawerWithoutBorder.renderRow(2)[0].getOrigin().y + 100,
				hexDrawerWithBorder.renderRow(2)[0].getOrigin().y);
	}
}
