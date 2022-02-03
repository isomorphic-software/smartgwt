package com.smartgwt.client.widgets.cube;

import com.smartgwt.client.widgets.cube.CubeGrid;
import com.smartgwt.client.widgets.cube.FacetValueMap;

/**
 * Hover customizer object for returning custom HTML to display in a hover prompt for CubeGrid facetValues
 */
public abstract class FacetValueHoverCustomizer {
    
    private CubeGrid grid;

    public void setGrid(CubeGrid grid) {
        this.grid = grid;
    }    

    /**
     * Returns the CubeGrid over which the hover occurred
     * @return CubeGrid over which the hover occurred
     */
    public CubeGrid getGrid() {
        return this.grid;
    }    
    
    /**
     * hoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over CubeGrid facets
     * @param facetValues
     * @return HTML to display
     */
    public abstract String hoverHTML(FacetValueMap facetValueMap);
}
