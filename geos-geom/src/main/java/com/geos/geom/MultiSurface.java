package com.geos.geom;

public class MultiSurface extends GeometryCollection {

	private static final long serialVersionUID = -576621089666334510L;

	public MultiSurface(int srid) {
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

}
