package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.types.ListGridComponent;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.ScrolledEvent;
import com.smartgwt.client.widgets.events.ScrolledHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.DataChangedEvent;
import com.smartgwt.client.widgets.grid.events.DataChangedHandler;
import com.smartgwt.client.widgets.grid.events.CriteriaChangedEvent;
import com.smartgwt.client.widgets.grid.events.CriteriaChangedHandler;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripSeparator;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;


public class CustomToolbarSample extends ShowcasePanel {
    private static final String DESCRIPTION = "If you have standard actions that you want to make available on all of your grids, "+
    "it's easy to implement those as a custom toolbar."+
    "<p>"+
    "In the sample below, the currently visible range of rows and total number of rows "+
    "is displayed, and there are controls for adding a new record, removing selected records, adding advanced filter criteria, "+
    "clearing all filter criteria, and refreshing data."+
    "<p>"+
    "Using the <code>gridComponents</code> feature, you can make your toolbar a part of "+
    "the grid itself, so that your grid-with-toolbar component is still a subclass of "+
    "<code>ListGrid</code> and supports the <code>ListGrid</code> API directly.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            CustomToolbarSample panel = new CustomToolbarSample();
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

    public Canvas getViewPanel() {
        CustomListGrid categoryList = new CustomListGrid();
        categoryList.setShowFilterEditor(true);
        categoryList.setWidth100();
        categoryList.setHeight(500);
        categoryList.setDataSource(ItemSupplyXmlDS.getInstance());
        categoryList.setAutoFetchData(true);

        return categoryList;
    }

    private class CustomImgButton extends ImgButton {
        public CustomImgButton() {
            setShowRollOver(false);
            setShowDown(false);
            setWidth(24);
            setHeight(24);
        }
    }
    
    private class RowRangeLabel extends Label {
        
        public RowRangeLabel() {
        }

        private String getRowRangeText(Integer[] arrayVisibleRows, int totalRows, boolean lengthIsKnown) {
            if (!lengthIsKnown) return "Loading...";
            else if (arrayVisibleRows[0] != -1) return (arrayVisibleRows[0]+1) + " to "+ (arrayVisibleRows[1]+1) + " of " + totalRows;
            else return "0 to 0 of 0";
        }
        
        public void updateRowRangeDisplay(ListGrid grid) {
            this.setContents(getRowRangeText(grid.getVisibleRows(), grid.getTotalRows(), grid.getResultSet().lengthIsKnown()));
        }
                
    }
    
    private class CustomListGrid extends ListGrid {
        
        private ListGrid grid = this;
        
        public CustomListGrid() {
            
            final RowRangeLabel label = new RowRangeLabel();
            label.setWrap(false);
            label.setPadding(5);
            label.setContents("0 to 0 of 0");
                        
            final CustomImgButton imgAdd = new CustomImgButton();
            imgAdd.setSrc("[SKIN]/actions/add.png");
            imgAdd.setPrompt("Add");
            imgAdd.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    grid.startEditingNew();
                }
            });

            final CustomImgButton imgRemove = new CustomImgButton();
            imgRemove.setSrc("[SKIN]/actions/remove.png");
            imgRemove.setPrompt("Remove");
            imgRemove.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    grid.removeSelectedData();
                }
            });
            
            final CustomImgButton imgFilterWindow = new CustomImgButton();
            imgFilterWindow.setSrc("[SKIN]/actions/filter.png");
            imgFilterWindow.setHoverWidth(220);
            imgFilterWindow.setHoverOpacity(85);
            imgFilterWindow.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    grid.showFilterWindow();
                }
            });

            final CustomImgButton imgClearFilter = new CustomImgButton();
            imgClearFilter.setSrc("[SKIN]/actions/clearFilter.png");
            imgClearFilter.setPrompt("Clear Filter");
            imgClearFilter.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    grid.setFilterEditorCriteria(null);
                    grid.filterByEditor();
                }
            });
            
            final CustomImgButton imgRefresh = new CustomImgButton();
            imgRefresh.setSrc("[SKIN]/actions/refresh.png");
            imgRefresh.setPrompt("Refresh");
            imgRefresh.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    grid.refreshData();
                }
            });

            LayoutSpacer layoutSpacer = new LayoutSpacer();
            layoutSpacer.setWidth("*");
             
            ToolStrip toolStrip = new ToolStrip();
            toolStrip.setMembersMargin(5);
            toolStrip.setMembers(label, layoutSpacer, imgAdd, imgRemove, new ToolStripSeparator(), 
                imgFilterWindow, imgClearFilter, imgRefresh);
             
            this.setGridComponents(ListGridComponent.FILTER_EDITOR, ListGridComponent.HEADER, ListGridComponent.BODY,
                     ListGridComponent.SUMMARY_ROW, toolStrip);
        
            this.addDataChangedHandler(new DataChangedHandler() {
                
                @Override
                public void onDataChanged(DataChangedEvent event) {
                    label.updateRowRangeDisplay(grid);
                }
                
             });
             
            this.addScrolledHandler(new ScrolledHandler() {

                @Override
                public void onScrolled(ScrolledEvent event) {
                    label.updateRowRangeDisplay(grid);
                }
                 
            });

            this.addCriteriaChangedHandler(new CriteriaChangedHandler() {

                @Override
                public void onCriteriaChanged(CriteriaChangedEvent event) {
                    AdvancedCriteria additionalCriteria = grid.getFilterEditorCriteriaAsAdvancedCriteria();
                    if (additionalCriteria != null) {
                        imgFilterWindow.setSrc("[SKIN]/actions/filterActive.png");
                        imgFilterWindow.setPrompt("Additional criteria:<br>"+
                            DataSource.getAdvancedCriteriaDescription(additionalCriteria, grid.getDataSource())+
                            "<br><hr>Click to edit");
                    } else {
                        imgFilterWindow.setSrc("[SKIN]/actions/filter.png");
                        imgFilterWindow.setPrompt("");
                    }
                }
                
            });
        }
    }

    @Override  
    protected boolean isTopIntro() {  
        return true;  
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}