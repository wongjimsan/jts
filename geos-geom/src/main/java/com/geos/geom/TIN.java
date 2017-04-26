package com.geos.geom;

import com.geos.geom.visitor.GeomVisitor;

public class TIN extends PolyhedralSurface {

	private static final long serialVersionUID = -8870541462672402111L;

	public TIN(int srid) {
		super(srid);
	}
	
	@Override
	public enumGeomType geometryType() {
		return enumGeomType.TIN;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}

}
