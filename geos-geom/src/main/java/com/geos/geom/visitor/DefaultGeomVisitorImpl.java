package com.geos.geom.visitor;

import com.geos.geom.*;

public class DefaultGeomVisitorImpl implements GeomVisitor {

	protected DefaultGeomVisitorImpl() {
	}

	@Override
	public void visit(Geometry geometry) {
	}

	@Override
	public void visit(Point point) {
	}

	@Override
	public void visit(LineString lineString) {
	}

	@Override
	public void visit(Line line) {
	}

	@Override
	public void visit(LinearRing lineraRing) {
	}
	
	@Override
	public void visit(Polygon polygon) {
	}

	@Override
	public void visit(Triangle triangle) {
	}

	@Override
	public void visit(GeometryCollection geometryCollection) {
	}

	@Override
	public void visit(MultiPoint multiPoint) {
	}

	@Override
	public void visit(MultiLineString multiLineString) {
	}

	@Override
	public void visit(MultiPolygon multiPolygon) {
	}

	@Override
	public void visit(PolyhedralSurface polyhedralSurface) {
	}

	@Override
	public void visit(TIN tin) {
	}
}
