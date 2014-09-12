package com.smartgwt.sample.showcase.client.grid.expando;

import com.smartgwt.client.core.Rectangle;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;
import com.smartgwt.sample.showcase.client.SourceEntity;

public class GridRowExpansionRelatedRecordsSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>In this grid of Supply Categories, you can expand a row by clicking the special " +
                    "expansionField to see a sub-grid containing the list of Supply Items applicable to the selected Category. </p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridRowExpansionRelatedRecordsSample panel = new GridRowExpansionRelatedRecordsSample();
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

        if (Browser.getIsHandset()) {
            VLayout layout = new VLayout(15);

            layout.addMember(new Label("This is a full-screen example - click the \"Show Example\" button to show fullscreen."));

            final IButton button = new IButton("Show Example");
            button.setWidth(140);
            button.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    Rectangle rect = button.getPageRect();
                    final Canvas animateOutline = new Canvas();
                    animateOutline.setBorder("2px solid black");
                    animateOutline.setTop(rect.getTop());
                    animateOutline.setLeft(rect.getLeft());
                    animateOutline.setWidth(rect.getLeft());
                    animateOutline.setHeight(rect.getHeight());

                    animateOutline.show();
                    animateOutline.animateRect(0, 0, Page.getWidth(), Page.getHeight(), new AnimationCallback() {
                        public void execute(boolean earlyFinish) {
                            animateOutline.hide();
                            final FullScreenSample appWindow = new FullScreenSample();
                            appWindow.addCloseClickHandler(new CloseClickHandler() {
                                public void onCloseClick(CloseClickEvent event) {
                                    animateOutline.setRect(0, 0, Page.getWidth(), Page.getHeight());
                                    animateOutline.show();
                                    appWindow.destroy();
                                    Rectangle targetRect = button.getPageRect();
                                    animateOutline.animateRect(targetRect.getLeft(), targetRect.getTop(), targetRect.getWidth(),
                                            targetRect.getHeight(), new AnimationCallback() {
                                                public void execute(boolean earlyFinish) {
                                                    animateOutline.hide();
                                                }
                                            }, 500);
    
                                }
                            });
                            appWindow.show();
                        }
                    }, 500
                    );
                }
            });

            layout.addMember(button);

            return layout;  
        } else {
            DataSource dataSource = SupplyCategoryXmlDS.getInstance();

            ListGrid listGrid = new ListGrid() {
                public DataSource getRelatedDataSource(ListGridRecord record) {
                    return ItemSupplyXmlDS.getInstance();
                }

                @Override
                protected Canvas getExpansionComponent(final ListGridRecord record) {

                final ListGrid grid = this;

                VLayout layout = new VLayout(5);
                layout.setPadding(5);

                final ListGrid countryGrid = new ListGrid();
                countryGrid.setHeight(224);
                countryGrid.setCellHeight(22);
                countryGrid.setDataSource(getRelatedDataSource(record));
                countryGrid.fetchRelatedData(record, SupplyCategoryXmlDS.getInstance());

                countryGrid.setCanEdit(true);
                countryGrid.setModalEditing(true);
                countryGrid.setEditEvent(ListGridEditEvent.CLICK);
                countryGrid.setListEndEditAction(RowEndEditAction.NEXT);
                countryGrid.setAutoSaveEdits(false);

                layout.addMember(countryGrid);

                HLayout hLayout = new HLayout(10);
                hLayout.setAlign(Alignment.CENTER);

                IButton saveButton = new IButton("Save");
                saveButton.setTop(250);
                saveButton.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        countryGrid.saveAllEdits();
                    }
                });
                hLayout.addMember(saveButton);

                IButton discardButton = new IButton("Discard");
                discardButton.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        countryGrid.discardAllEdits();
                    }
                });
                hLayout.addMember(discardButton);

                IButton closeButton = new IButton("Close");
                closeButton.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        grid.collapseRecord(record);
                    }
                });
                hLayout.addMember(closeButton);
                                               
                layout.addMember(hLayout);

                return layout;
                }
            };

            listGrid.setWidth100();
            listGrid.setHeight(500);
            listGrid.setDrawAheadRatio(4);
            listGrid.setCanExpandRecords(true);

            listGrid.setAutoFetchData(true);
            listGrid.setDataSource(dataSource);
    
            return listGrid;
        }
    }

    class FullScreenSample extends Window {

        FullScreenSample() {
            setTitle("Nested Grid");
            setWidth100();
            setHeight100();
            setShowMinimizeButton(false);
            setShowCloseButton(true);
            setCanDragReposition(false);
            setCanDragResize(false);
            setShowShadow(false);
            addItem(new GridRowExpansionRelatedRecordsPanel());
        }
    }

    @Override
    public SourceEntity[] getSourceUrls() {
        if (!Browser.getIsHandset()) {
            return new SourceEntity[] {
                new SourceEntity("Source", "source/grid/expando/GridRowExpansionRelatedRecordsSample.java.html")
            };
        } else {
            return new SourceEntity[] {
                new SourceEntity("Source", "source/grid/expando/GridRowExpansionRelatedRecordsPanel.java.html")
            };
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
