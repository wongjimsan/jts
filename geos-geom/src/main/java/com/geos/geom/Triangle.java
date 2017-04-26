package com.geos.geom;

import com.geos.geom.visitor.GeomVisitor;

public class Triangle extends Polygon {

	private static final long serialVersionUID = -574969820626952180L;

	public Triangle(LinearRing exterorRing, int srid) {
		super(exterorRing, srid);
	}

	@Override
	public enumGeomType geometryType() {
		return enumGeomType.Triangle;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}
}
