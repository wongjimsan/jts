package com.geos.geom.spatial;

import com.geos.geom.*;

public interface GeomSpatialAnalysis {
	public default double distance(Geometry other) {
		return 0;
	}

	public default Geometry buffer(double distance) {
		return null;
	}

	public default Geometry convexHull() {
		return null;
	}

	public default Geometry intersection(Geometry other) {
		return null;
	}

	public default Geometry union(Geometry other) {
		return null;
	}

	public default Geometry difference(Geometry other) {
		return null;
	}

	public default Geometry symDifference(Geometry other) {
		return null;
	}
}
