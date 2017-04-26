package com.geos.geom;

public enum enumGeomType {

	Geometry {
		@Override
		protected String typeWKT() {
			return "GEOMETRY";
		}

		@Override
		protected int typeWKB() {
			return 0;
		}
	},
	Point {
		@Override
		protected String typeWKT() {
			return "POINT";
		}

		@Override
		protected int typeWKB() {
			return 1;
		}
	},
	LineString {
		@Override
		protected String typeWKT() {
			return "LINESTRING";
		}

		@Override
		protected int typeWKB() {
			return 2;
		}
	},
	Polygon {
		@Override
		protected String typeWKT() {
			return "POLYGON";
		}

		@Override
		protected int typeWKB() {
			return 3;
		}
	},
	MultiPoint {
		@Override
		protected String typeWKT() {
			return "MULTIPOINT";
		}

		@Override
		protected int typeWKB() {
			return 4;
		}
	},
	MultiLineString {
		@Override
		protected String typeWKT() {
			return "MULTILINESTRING";
		}

		@Override
		protected int typeWKB() {
			return 5;
		}
	},
	MultiPolygon {
		@Override
		protected String typeWKT() {
			return "MULTIPOLYGON";
		}

		@Override
		protected int typeWKB() {
			return 6;
		}
	},
	GeometryCollection {
		@Override
		protected String typeWKT() {
			return "GEOMETRYCOLLECTION";
		}

		@Override
		protected int typeWKB() {
			return 7;
		}
	},
	PolyhedralSurface {
		@Override
		protected String typeWKT() {
			return "POLYGON";
		}

		@Override
		protected int typeWKB() {
			return 15;
		}
	},
	TIN {
		@Override
		protected String typeWKT() {
			return "POLYGON";
		}

		@Override
		protected int typeWKB() {
			return 16;
		}
	},
	Triangle {
		@Override
		protected String typeWKT() {
			return "POLYGON";
		}

		@Override
		protected int typeWKB() {
			return 17;
		}
	};

	protected abstract String typeWKT();

	protected abstract int typeWKB();

	public String toWKT() {
		return typeWKT();
	}

	public String toString() {
		return typeWKT();
	}

	public byte[] toWKB() {
		return null;
	}
}
