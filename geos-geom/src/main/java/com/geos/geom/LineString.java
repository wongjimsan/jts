package com.geos.geom;

import java.util.*;

import com.geos.geom.visitor.GeomVisitor;

public class LineString extends Curve {

	private static final long serialVersionUID = -8907208844625565572L;
	private final List<Point> vertex;

	public LineString(int srid) {
		super(srid);
		vertex = new ArrayList<Point>();
	}


	@Override
	public enumGeomType geometryType() {
		return enumGeomType.LineString;
	}
	
	@Override
	public void apply(GeomVisitor visitor) {
		visitor.visit(this);
	}

	public int numPoints() {
		return vertex.size();
	}

	public void addPoint(Point point) {
		vertex.add(point);
	}

	public Point pointN(int index) {
		return vertex.get(index);
	}

	@Override
	public Point startPoint() {
		return vertex.get(0);
	}

	@Override
	public Point endPoint() {
		int num = numPoints();
		return vertex.get(num - 1);
	}
}
