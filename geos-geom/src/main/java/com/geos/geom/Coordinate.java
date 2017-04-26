package com.geos.geom;

public class Coordinate {

	private double x;
	private double y;
	private double z = Double.NaN;
	private double m = Double.NaN;
	private boolean is3D = false;
	private boolean isMeasured = false;

	public Coordinate() {
	}

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
		is3D = true;
	}

	public double getM() {
		return m;
	}

	public void setM(double m) {
		this.m = m;
		isMeasured = true;
	}

	public boolean is3D() {
		return is3D;
	}

	public boolean isMeasured() {
		return isMeasured;
	}

	public int dimension() {
		int dimension = 2;
		if (is3D & isMeasured == true)
			dimension = 4;
		else if (is3D ^ isMeasured == true)
			dimension = 3;
		return dimension;
	}
}
