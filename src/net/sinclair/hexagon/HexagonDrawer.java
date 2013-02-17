package net.sinclair.hexagon;

public class HexagonDrawer {

	private final static int BORDER = 100;
	private final int lengthOfHorizontalEdge;
	private final int hexesPerHorizontalEdge;
	private final int shortLegOfTriangleEdge;
	private final int longLegOfTriangleEdge;
	private final int hexWidth;
	private final int hexHeight;

	public static void main(String... args) {

		args = new String[] { "50", "1" };
		HexagonDrawer instance = new HexagonDrawer(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

		instance.process();
	}

	public HexagonDrawer(int lengthPerEdge, int hexesPerEdge) {
		lengthOfHorizontalEdge = lengthPerEdge;
		hexesPerHorizontalEdge = hexesPerEdge;
		shortLegOfTriangleEdge = (int) (lengthPerEdge * 0.6);
		longLegOfTriangleEdge = (int) (lengthPerEdge * 0.8);
		hexWidth = shortLegOfTriangleEdge * 2 + lengthPerEdge;
		hexHeight = longLegOfTriangleEdge * 2;
	}

	public void process() {

		// 2 --> 1..3, 4 --> 1..7, 1 --> 1...2
		// for (int i = 1; i < hexesPerHorizontalEdge * 2; ++i) {
		// int xInset = BORDER + Math.abs(hexesPerHorizontalEdge - i) *
		// }
		// renderHex(BORDER, BORDER);

		// Row 1
		renderHex(BORDER + shortLegOfTriangleEdge + lengthOfHorizontalEdge,
				BORDER);
		// Row 2
		renderHex(BORDER,
				BORDER + longLegOfTriangleEdge);
		renderHex(BORDER + shortLegOfTriangleEdge + lengthOfHorizontalEdge,
				BORDER + hexHeight);
		renderHex(BORDER + hexWidth + lengthOfHorizontalEdge,
				BORDER + longLegOfTriangleEdge);
		// Row 3
		renderHex(BORDER,
				BORDER + longLegOfTriangleEdge + hexHeight);
		renderHex(BORDER + shortLegOfTriangleEdge + lengthOfHorizontalEdge,
				BORDER + hexHeight + hexHeight);
		renderHex(BORDER + hexWidth + lengthOfHorizontalEdge,
				BORDER + longLegOfTriangleEdge + hexHeight);
	}

	private void renderHex(int xBound, int yBound) {

		System.out.println("\t<path id=\"hex-" + xBound + "-" + yBound + "\"");
		System.out.println("\t\tfill=\"none\" stroke=\"black\" stroke-width=\"1\"");
		System.out.println("\t\td=\"M");
		// Top-Left
		System.out.println("\t\t\t" + twice(xBound + shortLegOfTriangleEdge
				+ "," + yBound));
		// Top-Right
		System.out.println("\t\t\t" + twice(xBound + shortLegOfTriangleEdge + lengthOfHorizontalEdge
				+ "," + yBound));
		// Right
		System.out.println("\t\t\t" + twice(xBound + hexWidth
				+ "," + (yBound + longLegOfTriangleEdge)));
		// Bottom-Right
		System.out.println("\t\t\t" + twice(xBound + shortLegOfTriangleEdge + lengthOfHorizontalEdge
				+ "," + (yBound + hexHeight)));
		// Bottom-Left
		System.out.println("\t\t\t" + twice(xBound + shortLegOfTriangleEdge
				+ "," + (yBound + hexHeight)));
		// Left
		System.out.println("\t\t\t" + twice(xBound
				+ "," + (yBound + longLegOfTriangleEdge)));
		// Top-Left (again)
		System.out.println("\t\t\t" + twice(xBound + shortLegOfTriangleEdge
				+ "," + yBound));
		System.out.println("\t\t\"/>");
	}

	private String twice(String string) {
		return string + " " + string;
	}
}
