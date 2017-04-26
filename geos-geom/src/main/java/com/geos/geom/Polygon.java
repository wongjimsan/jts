package com.geos.geom;

import java.util.*;

import com.geos.geom.visitor.GeomVisitor;

public class Polygon extends Surface {

	private static final long serialVersionUID = -365994711439639146L;
	private final LinearRing exterorRing;
	private final List<LinearRing> interiorRings;

	public Polygon(LinearRing exterorRing, int srid) {
		super(srid);
		this.exterorRing = exterorRing;
		interiorRings = new ArrayList<LinearRing>();
	}

	@Override
	public enumGeomType geometryType() {
		return enumGeomType.Polygon;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}

	public LinearRing getExterorRing() {
		return exterorRing;
	}

	public int numInteriorRings() {
		return interiorRings.size();
	}

	public void addInteriorRing(LinearRing interiorRing) {
		interiorRings.add(interiorRing);
	}

	public LinearRing interiorRingN(int index) {
		return interiorRings.get(index);
	}

}
