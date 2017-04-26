package com.geos.geom.io;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.geos.geom.*;

@FixMethodOrder(MethodSorters.JVM)
public class WKTWriterTest {

	private final WKTWriter writer;
	private Point point;
	private Line line;
	private LineString lineString;
	private GeometryCollection geometryCollection;
	private MultiPoint multiPoint;

	public WKTWriterTest() {

		writer = new WKTWriterImpl();
	}

	@Test
	public void pointTest() {
		createPoint();
		System.out.println(writer.write(point));
	}

	private void createPoint() {
		Coordinate coordinate = new Coordinate(9.9, 9.9);
		point = new Point(coordinate);
	}

	@Test
	public void lineTest() {
		createLine();
		System.out.println(writer.write(line));
	}

	private void createLine() {
		createPoint();
		line = new Line(4326);
		line.addPoint(point);
		line.addPoint(point);
		line.addPoint(point);
		line.addPoint(point);
	}

	@Test
	public void lineStringTest() {
		createLineString();
		System.out.println(writer.write(lineString));
	}

	private void createLineString() {
		createPoint();
		lineString = new LineString(4326);
		lineString.addPoint(point);
		lineString.addPoint(point);
		lineString.addPoint(point);
		lineString.addPoint(point);
	}

	@Test
	public void geometryCollectionTest() {
		createGeometryCollection();
		System.out.println(writer.write(geometryCollection));
	}

	private void createGeometryCollection() {
		geometryCollection = new GeometryCollection(4326);
		createLineString();
		geometryCollection.addGeometry(lineString);
		createLine();
		geometryCollection.addGeometry(line);
		createMultiPoint();
		geometryCollection.addGeometry(multiPoint);
	}

	@Test
	public void multiPointTest() {
		createMultiPoint();
		System.out.println(writer.write(multiPoint));
	}

	private void createMultiPoint() {
		createPoint();
		multiPoint = new MultiPoint(4326);
		multiPoint.addGeometry(point);
		multiPoint.addGeometry(point);
		multiPoint.addGeometry(point);
		multiPoint.addGeometry(point);
	}
}
