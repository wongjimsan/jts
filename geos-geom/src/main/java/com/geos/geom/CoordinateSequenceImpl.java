package com.geos.geom;

import java.util.*;

import com.geos.geom.visitor.*;

public class CoordinateSequenceImpl extends DefaultGeomVisitorImpl implements CoordinateSequence {

	private final List<Coordinate> coordinates;

	public CoordinateSequenceImpl() {
		coordinates = new ArrayList<Coordinate>();
	}

	@Override
	public int size() {
		return coordinates.size();
	}
	
	@Override
	public Coordinate get(int index) {
		return coordinates.get(index);
	}

	@Override
	public void visit(Point point) {
		Coordinate coordinate = point.getCoordinate();
		coordinates.add(coordinate);
	}

	@Override
	public void visit(LineString lineString) {
		int size = lineString.numPoints();
		for (int i = 0; i < size; i++) {
			Point point = lineString.pointN(i);
			point.apply(this);
		}
	}

	@Override
	public void visit(Polygon polygon) {
		LinearRing exterorRing = polygon.getExterorRing();
		exterorRing.apply(this);
		int size = polygon.numInteriorRings();
		for (int i = 0; i < size; i++) {
			LinearRing interiorRing = polygon.interiorRingN(i);
			interiorRing.apply(this);
		}
	}

	@Override
	public void visit(GeometryCollection geometryCollection) {
		visitGC(geometryCollection);
	}

	@Override
	public void visit(MultiPoint multiPoint) {
		visitGC(multiPoint);
	}

	@Override
	public void visit(MultiLineString multiLineString) {
		visitGC(multiLineString);
	}

	@Override
	public void visit(MultiPolygon multiPolygon) {
		visitGC(multiPolygon);
	}

	private void visitGC(GeometryCollection geometryCollection) {
		int size = geometryCollection.numGeometries();
		for (int i = 0; i < size; i++) {
			Geometry geometry = geometryCollection.geometryN(i);
			geometry.apply(this);
		}
	}
}
