package com.geos.geom.spatial;

import com.geos.geom.*;

public interface GeomSpatialRelations {
	public default boolean equals(Geometry other) {
		return false;
	}

	public default boolean disjoint(Geometry other) {
		return false;
	}

	public default boolean intersects(Geometry other) {
		return false;
	}

	public default boolean touches(Geometry other) {
		return false;
	}

	public default boolean crosses(Geometry other) {
		return false;
	}

	public default boolean within(Geometry other) {
		return false;
	}

	public default boolean contains(Geometry other) {
		return false;
	}

	public default boolean overlaps(Geometry other) {
		return false;
	}

	public default boolean relate(Geometry other, String matrix) {
		return false;
	}

	public default Geometry locateAlong(double value) {
		return null;
	}

	public default Geometry locateBetween(double start, double end) {
		return null;
	}
}
