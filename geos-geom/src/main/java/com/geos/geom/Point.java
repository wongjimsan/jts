package com.geos.geom;

import com.geos.geom.visitor.GeomVisitor;

public class Point extends Geometry {

	private static final long serialVersionUID = -5746654819330036683L;
	private final Coordinate coordinate;

	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Point(Coordinate coordinate, int srid) {
		super(srid);
		this.coordinate = coordinate;
	}

	@Override
	public enumGeomType geometryType() {
		return enumGeomType.Point;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean is3D() {
		return coordinate.is3D();
	}

	@Override
	public boolean isMeasured() {
		return coordinate.isMeasured();
	}

	@Override
	public int dimension() {
		return coordinate.dimension();
	}

	public double getX() {
		return coordinate.getX();
	}

	public double getY() {
		return coordinate.getY();
	}

	public double getZ() {
		return coordinate.getZ();
	}

	public double getM() {
		return coordinate.getM();
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
}
