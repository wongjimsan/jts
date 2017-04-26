package com.geos.geom;

import java.util.*;

import com.geos.geom.visitor.GeomVisitor;

public class PolyhedralSurface extends Surface {

	private final List<Polygon> patchs;

	private static final long serialVersionUID = -4244106348263147023L;

	public PolyhedralSurface(int srid) {
		super(srid);
		patchs = new ArrayList<Polygon>();
	}

	public int numPatches() {
		return patchs.size();
	}

	public Polygon patchN(int index) {
		return patchs.get(index);
	}

	public MultiPolygon boundingPolygons(Polygon polygon) {
		return null;
	}

	@Override
	public enumGeomType geometryType() {
		return enumGeomType.PolyhedralSurface;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}

}
