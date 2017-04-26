package com.geos.geom;

public class Curve extends Geometry {

	private static final long serialVersionUID = -5925605665311300225L;

	protected Curve(int srid) {
		super(srid);
	}

	public double length() {
		return 0.0F;
	}

	public Point startPoint() {
		return null;
	}

	public Point endPoint() {
		return null;
	}

	public boolean isClosed() {
		return false;
	}

	public boolean isRing() {
		return false;
	}
}
