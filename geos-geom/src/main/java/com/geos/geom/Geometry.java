package com.geos.geom;

import com.geos.geom.visitor.GeomVisitor;

public class Geometry extends AbstractGeometry {

	private static final long serialVersionUID = 5594065733859514709L;

	private int srid;

	protected Geometry() {
	}

	protected Geometry(int srid) {
		this.srid = srid;
	}

	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}

	public CoordinateSequence coordinateSequence() {
		CoordinateSequenceImpl cs = new CoordinateSequenceImpl();
		apply(cs);
		return cs;
	}

	public int getSrid() {
		return srid;
	}

	public void setSrid(int srid) {
		this.srid = srid;
	}

	public int dimension() {
		return 2;
	}

	public int coordinateDimension() {
		return 2;
	}

	public int spatialDimension() {
		return 2;
	}

	public enumGeomType geometryType() {
		return enumGeomType.Geometry;
	}

	public Geometry envelope() {
		return new Geometry();
	}

	public boolean isEmpty() {
		return true;
	}

	public boolean isSimple() {
		return true;
	}

	public boolean is3D() {
		return false;
	}

	public boolean isMeasured() {
		return false;
	}

	public Geometry boundary() {
		return new Geometry();
	}
}
