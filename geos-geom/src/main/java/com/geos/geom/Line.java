package com.geos.geom;

public class Line extends LineString {

	private static final long serialVersionUID = -6958471671889533156L;

	public Line(int srid) {
		super(srid);
	}

	@Override
	public void addPoint(Point point) {
		int num = numPoints();
		if (num >= 2)
			return;
		super.addPoint(point);
	}
}
