package com.geos.geom.io;

import com.geos.geom.*;
import com.geos.geom.visitor.*;

public class WKTWriterImpl extends DefaultGeomVisitorImpl implements WKTWriter {

	private StringBuilder wktContent;

	public WKTWriterImpl() {
	}

	@Override
	public String write(Geometry geometry) {
		StringBuilder wkt = new StringBuilder();
		wkt.append(geometry.geometryType().toWKT());
		wktContent = new StringBuilder();
		geometry.apply(this);
		return wkt.append("(").append(wktContent.toString()).append(")").toString();
	}

	@Override
	public void visit(Point point) {
		writeG(point);
	}

	@Override
	public void visit(LineString lineString) {
		writeG(lineString);
	}

	@Override
	public void visit(LinearRing linearRing) {
		wktContent.append("(");
		writeG(linearRing);
		wktContent.append("),");
	}

	@Override
	public void visit(Polygon polygon) {
		LinearRing exteror = polygon.getExterorRing();
		visit(exteror);
		int size = polygon.numInteriorRings();
		for (int i = 0; i < size; i++) {
			visit(polygon.interiorRingN(i));
		}
		int length = wktContent.length();
		wktContent.deleteCharAt(length - 1);
	}

	@Override
	public void visit(GeometryCollection geometryCollection) {
		StringBuilder sb = new StringBuilder();
		int size = geometryCollection.numGeometries();
		for (int i = 0; i < size; i++) {
			Geometry geometry = geometryCollection.geometryN(i);
			WKTWriter writer = new WKTWriterImpl();
			sb.append(writer.write(geometry)).append(",");
		}
		int length = sb.length();
		sb.deleteCharAt(length - 1);
		wktContent.append(sb.toString());
	}

	@Override
	public void visit(MultiPoint multiPoint) {
		writeG(multiPoint);
	}

	@Override
	public void visit(MultiLineString multiLineString) {
		writeGC(multiLineString);
	}

	@Override
	public void visit(MultiPolygon multiPolygon) {
		writeGC(multiPolygon);
	}

	private void writeGC(GeometryCollection geometryCollection) {
		int size = geometryCollection.numGeometries();
		for (int i = 0; i < size; i++) {
			Geometry geometry = geometryCollection.geometryN(i);
			wktContent.append("(");
			geometry.apply(this);
			wktContent.append("),");
		}
		int length = wktContent.length();
		wktContent.deleteCharAt(length - 1);
	}

	private void writeG(Geometry geometry) {
		CoordinateSequence cs = geometry.coordinateSequence();
		writeCoordinates(cs);
	}

	private void writeCoordinates(CoordinateSequence cs) {
		StringBuilder sb = new StringBuilder();
		int size = cs.size();
		for (int i = 0; i < size; i++) {
			Coordinate coordinate = cs.get(i);
			writeCoordinate(sb, coordinate);
			sb.append(",");
		}
		wktContent.append(sb.substring(1, sb.length() - 1));
	}

	private void writeCoordinate(StringBuilder sb, Coordinate coordinate) {
		sb.append(" ").append(coordinate.getX());
		sb.append(" ").append(coordinate.getY());
		if (coordinate.is3D())
			sb.append(" ").append(coordinate.getZ());
		if (coordinate.isMeasured())
			sb.append(" ").append(coordinate.getM());
	}
}
