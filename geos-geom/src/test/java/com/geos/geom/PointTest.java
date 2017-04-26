package com.geos.geom;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class PointTest {

	private final Point point;

	public PointTest() {
		Coordinate coordinate = new Coordinate(9.9, 9.9);
		point = new Point(coordinate);
	}

	@Test
	public void visitTest() {
		CoordinateSequence cs = point.coordinateSequence();
		int size = cs.size();
		assertSame(size, 1);
	}
}
