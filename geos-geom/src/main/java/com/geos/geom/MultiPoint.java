package com.geos.geom;

import com.geos.geom.visitor.*;

public class MultiPoint extends GeometryCollection {

	private static final long serialVersionUID = -4206522180686962708L;

	public MultiPoint(int srid) {
		super(srid);
	}

	@Override
	public enumGeomType geometryType() {
		return enumGeomType.MultiPoint;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}

}
