package com.smartgwt.client.types;

/**
 * Boundary type for limiting where contiguous selection (via shift+click or drag selection)
 * can be applied across {@link com.smartgwt.client.widgets.cube.Facet#setSelectionBoundary,facets}
 * or {@link com.smartgwt.client.widgets.cube.FacetValue#setSelectionBoundary(),facetValues}
 *
 */
public enum SelectionBoundary implements ValueEnum {
	/**
	 * selection boundary applies to the bottom / right of the cells
	 */
	AFTER("after"),
	/**
	 * selection boundary applies to the top / left of the cells
	 */
	BEFORE("before"),
	/**
	 * selection boundary applies to both edges.
	 */
	BOTH("both");
	
	private String value;
	SelectionBoundary(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
