package com.geos.geom;

import com.geos.geom.visitor.GeomVisitor;

public class MultiLineString extends MultiCurve {

	private static final long serialVersionUID = 8789353483850475564L;

	public MultiLineString(int srid) {
		super(srid);
	}
	
	@Override
	public enumGeomType geometryType() {
		return enumGeomType.MultiLineString;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}
}
