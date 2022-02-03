package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.ListGridViewStatePart;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.ViewStateChangedEvent;
import com.smartgwt.client.widgets.grid.events.ViewStateChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridAutomaticPreferencesSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Grid preferences can be automatically saved to "+
        "browser storage, so that as long as the user accesses your application from the same browser, "+
        "a grid will stay configured however the user left it.</p><p>"+
        "In the grid below, try resizing and rearranging columns, adding sort, adding grouping, or "+
        "even adding custom columns, then reload the page. Notice how your customizations have been "+
        "automatically saved. This is enabled by a single property, <code>listGrid.autoPersistViewState"+
        "</code>.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridAutomaticPreferencesSample panel = new GridAutomaticPreferencesSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    private DynamicForm preferenceForm;
    
    private class CountryGrid extends ListGrid {
    	
        private void showSavedViewState () {
            String viewState = this.getSavedViewState();
            if (viewState == null) viewState = "[None]";
            preferenceForm.setValue("state", viewState);
        }
    	
    }

    public Canvas getViewPanel() {
        preferenceForm = new DynamicForm();
        preferenceForm.setHeight(50);
        preferenceForm.setWidth100();
        preferenceForm.setNumCols(2);
		
        StaticTextItem state = new StaticTextItem("state");
        state.setWrapTitle(false);
        state.setTitle("Current view state");
        state.setShouldSaveValue(false);
		
        preferenceForm.setFields(state);
		
        final CountryGrid countryGrid = new CountryGrid();
        countryGrid.setID("countryGrid");
        countryGrid.setWidth100();
        countryGrid.setHeight(200);
        countryGrid.setAutoFitData(Autofit.HORIZONTAL);
        countryGrid.setAutoFitFieldWidths(true);
        countryGrid.setLeaveScrollbarGap(true);
        countryGrid.setCanGroupBy(true);
        countryGrid.setCanFreezeFields(true);
        countryGrid.setCanAddFormulaFields(true);
        countryGrid.setCanAddFormulaFields(true);
        countryGrid.setDataSource(CountryXmlDS.getInstance());
        countryGrid.setAutoFetchData(true);
        countryGrid.setAutoPersistViewState(ListGridViewStatePart.ALL);
        
        ListGridField countryCode = new ListGridField("countryCode", "Title");
        countryCode.setType(ListGridFieldType.IMAGE);
        countryCode.setWidth(50);
        countryCode.setImageURLPrefix("flags/16/");
        countryCode.setImageURLSuffix(".png");
        countryCode.setCanSort(false);
        ListGridField countryName = new ListGridField("countryName", "Country");
        ListGridField capital = new ListGridField("capital", "Capital");
        ListGridField population = new ListGridField("population", "Population");
        ListGridField area = new ListGridField("area", "Area (km&sup2;)");
        
        countryGrid.setFields(countryCode, countryName, capital, population, area);
        
        countryGrid.addViewStateChangedHandler(new ViewStateChangedHandler() {
            @Override
            public void onViewStateChanged(ViewStateChangedEvent event) {
                countryGrid.showSavedViewState();
            }
        });
		
        ToolStripButton formulaBuilder = new ToolStripButton();
        formulaBuilder.setIcon("icons/16/sc_insertformula.png");
        formulaBuilder.setTitle("Formula Builder");
        formulaBuilder.setAutoFit(true);
        formulaBuilder.setShowDownIcon(false);
        formulaBuilder.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                countryGrid.addFormulaField();
            }
        });
		
        ToolStripButton summaryBuilder = new ToolStripButton();
        summaryBuilder.setIcon("icons/16/application_side_tree.png");
        summaryBuilder.setTitle("Summary Builder");
        summaryBuilder.setAutoFit(true);
        summaryBuilder.setShowDownIcon(false);
        summaryBuilder.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                countryGrid.addSummaryField();
            }
        });
		
        ToolStrip preferenceStrip = new ToolStrip();
        preferenceStrip.setWidth100();
        preferenceStrip.addFill();
        preferenceStrip.setAlign(Alignment.RIGHT);
        preferenceStrip.setMembers(formulaBuilder, summaryBuilder);

        ToolStripButton clearState = new ToolStripButton();
        clearState.setTitle("Clear Saved State");
        clearState.setIcon("icons/16/close.png");
        clearState.setAutoFit(true);
        clearState.setShowDownIcon(false);
        clearState.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                countryGrid.clearSavedViewState();
                countryGrid.showSavedViewState();
            }
        });

        ToolStrip restoreStrip = new ToolStrip();
        restoreStrip.setWidth100();
        restoreStrip.addFill();
        restoreStrip.setAlign(Alignment.RIGHT);
        restoreStrip.setMembers(clearState);
		
        VLayout testLayout = new VLayout();
        testLayout.setHeight100();
        testLayout.setMinBreadthMember(countryGrid);
        testLayout.setMembers(preferenceStrip, countryGrid, preferenceForm, restoreStrip);

        countryGrid.showSavedViewState();
        
        return testLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}