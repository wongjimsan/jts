package com.geos.geom;

public class Surface extends Geometry {

	private static final long serialVersionUID = -6075485091792226407L;

	protected Surface(int srid) {
		super(srid);
	}
	
	public double area() {
		return 0.0F;
	}
	
	public Point centroid() {
		return null;
	}
	
	public Point pointOnSurface() {
		return null;
	}
	
	public MultiCurve boundary() {
		return null;
	}
}
