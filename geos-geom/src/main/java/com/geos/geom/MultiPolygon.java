package com.geos.geom;

import com.geos.geom.visitor.GeomVisitor;

public class MultiPolygon extends MultiSurface {

	private static final long serialVersionUID = -8538253533188517173L;

	public MultiPolygon(int srid) {
		super(srid);
	}
	
	@Override
	public enumGeomType geometryType() {
		return enumGeomType.MultiPolygon;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}

}
