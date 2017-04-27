package com.geos.geom;

import com.geos.geom.visitor.GeomVisitor;

public class LinearRing extends LineString {

	private static final long serialVersionUID = 6646315907673558749L;

	public LinearRing(int srid) {
		super(srid);
	}

	public void close() {
		if (!isClosed()) {
			Point point = startPoint();
			addPoint(point);
		}
	}

	@Override
	public boolean isRing() {
		return true;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}
}
