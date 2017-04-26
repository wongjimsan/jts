package com.geos.geom.io;

import com.geos.geom.*;
import com.geos.geom.visitor.*;

public class WKTWriterImpl extends DefaultGeomVisitorImpl implements WKTWriter {

	private StringBuilder wktContent;

	@Override
	public void visit(Point point) {
		CoordinateSequence cs = point.coordinateSequence();
		writeCoordiantes(cs);
	}

	@Override
	public void visit(LineString lineString) {
		CoordinateSequence cs = lineString.coordinateSequence();
		writeCoordiantes(cs);
	}

	@Override
	public void visit(Line line) {

	}

	@Override
	public void visit(Polygon polygon) {

	}

	@Override
	public void visit(Triangle triangle) {

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
		wktContent.append(sb.substring(0, sb.length() - 1));
	}

	@Override
	public void visit(MultiPoint multiPoint) {
		CoordinateSequence cs = multiPoint.coordinateSequence();
		writeCoordiantes(cs);
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

	@Override
	public String write(Geometry geometry) {
		StringBuilder wkt = new StringBuilder();
		wkt.append(geometry.geometryType().toWKT());
		process(geometry);
		return wkt.append("(").append(wktContent.toString()).append(")").toString();
	}

	private void process(Geometry geometry) {
		wktContent = new StringBuilder();
		geometry.apply(this);
	}

	private void writeCoordiantes(CoordinateSequence cs) {
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
