package com.geos.geom.visitor;

import com.geos.geom.*;

public interface GeomVisitor {
	void visit(Geometry geometry);

	void visit(Point point);

	void visit(LineString lineString);

	void visit(Line line);

	void visit(Polygon polygon);

	void visit(Triangle triangle);

	void visit(GeometryCollection geometryCollection);

	void visit(MultiPoint multiPoint);

	void visit(MultiLineString multiLineString);

	void visit(MultiPolygon multiPolygon);

	void visit(PolyhedralSurface polyhedralSurface);

	void visit(TIN tin);
}
