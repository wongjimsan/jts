package com.geos.geom;

import java.io.Serializable;

import com.geos.geom.spatial.*;
import com.geos.geom.visitor.*;

public abstract class AbstractGeometry implements Serializable, GeomSpatialRelations, GeomSpatialAnalysis {

	private static final long serialVersionUID = 5299754819134896917L;

	protected AbstractGeometry() {
	}

	public abstract void apply(GeomVisitor visitor);
}
