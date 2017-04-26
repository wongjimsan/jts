package com.geos.geom;

import java.util.*;

import com.geos.geom.visitor.GeomVisitor;

public class GeometryCollection extends Geometry {

	private static final long serialVersionUID = -4110148892147283192L;
	private final List<Geometry> geometries;

	public GeometryCollection(int srid) {
		super(srid);
		geometries = new ArrayList<Geometry>();
	}

	@Override
	public enumGeomType geometryType() {
		return enumGeomType.GeometryCollection;
	}
	
	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}
	
	public int numGeometries() {
		return geometries.size();
	}

	public Geometry geometryN(int index) {
		return geometries.get(index);
	}

	public void addGeometry(Geometry geometry) {
		geometries.add(geometry);
	}
}
