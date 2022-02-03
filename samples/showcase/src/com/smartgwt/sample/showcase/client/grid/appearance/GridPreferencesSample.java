package com.smartgwt.sample.showcase.client.grid.appearance;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridPreferencesSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example illustrates how a ListGrid configuration can be saved as a user preference and later restored. " +
            "Notice how the position of custom fields created by the Formula Builder and Summary Builder are also captured and restored.</p>" +
            "<p>The ListGrid configuration comprises of field state, sort state and selection state and these " +
            "can be obtained separately by calling ListGrid.getFieldState(), ListGrid.getSortState() and ListGrid.getSelectionState() respectively. ListGrid.getViewState() can be called to return all " +
            "three states.</p>" +
            "<p>The configuration state is a String which can be sent to the server to store and later retrieve the ListGrid state.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridPreferencesSample panel = new GridPreferencesSample();
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

    private static int PK_COUNTER=0;

    public Canvas getViewPanel() {

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setLeaveScrollbarGap(true);
        countryGrid.setCanFreezeFields(true);
        countryGrid.setCanGroupBy(true);
        countryGrid.setWidth100();
        countryGrid.setHeight(224);
        countryGrid.setDataSource(CountryXmlDS.getInstance());
        countryGrid.setAutoFetchData(true);

        //allow users to add formula and summary fields
        //accessible in the grid header context menu
        countryGrid.setCanAddFormulaFields(true);
        countryGrid.setCanAddSummaryFields(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanSort(false);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");

        ListGridField populationField = new ListGridField("population", "Population");

        ListGridField areaField = new ListGridField("area", "Area (km&sup2;)");
        areaField.setType(ListGridFieldType.INTEGER);
        areaField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) return null;
                String val = null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    val = nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
                return val + "km&sup2";
            }
        });
        countryGrid.setFields(countryCodeField, nameField, capitalField, populationField, areaField);

        //create another grid to display the preference name and viewState string
        final ListGrid preferencesGrid = new ListGrid();
        preferencesGrid.setHeight(300);
        preferencesGrid.setWrapCells(true);
        preferencesGrid.setFixedRecordHeights(false);
        preferencesGrid.setCanEdit(true);
        preferencesGrid.setEmptyMessage("No Saved Preferences");
        preferencesGrid.setSelectionType(SelectionStyle.SINGLE);
        preferencesGrid.setCanRemoveRecords(true);
        final ListGridField name = new ListGridField("name", "Preference");
        ListGridField viewState = new ListGridField("viewState", "View State String");
        viewState.setEditorType(new TextAreaItem());
        viewState.setCellFormatter(new CellFormatter() {
            @Override
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                //prettier display
                return ((String) value).replace("\\r", "");
            }
        });
        preferencesGrid.setFields(name, viewState);
        preferencesGrid.setAutoFetchData(true);

        //create a "preferences" DataSource to bind to SelectItem and Preferences ListGrid
        final DataSource preferencesDS = new DataSource();
        DataSourceIntegerField pkField = new DataSourceIntegerField("pk");
        pkField.setHidden(true);
        pkField.setPrimaryKey(true);

        DataSourceTextField preferenceField = new DataSourceTextField("name", "Name");
        DataSourceTextField stateField = new DataSourceTextField("viewState", "View State");
        preferencesDS.setFields(pkField, preferenceField, stateField);
        preferencesDS.setClientOnly(true);
        preferencesGrid.setDataSource(preferencesDS);

        ToolStripButton formulaButton = new ToolStripButton("Formula Builder", "crystal/oo/sc_insertformula.png");
        formulaButton.setAutoFit(true);
        formulaButton.setShowDownIcon(false);
        formulaButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.addFormulaField();
            }
        });

        ToolStripButton summaryBuilder = new ToolStripButton("Summary Builder", "crystal/16/apps/tooloptions.png");
        summaryBuilder.setAutoFit(true);
        summaryBuilder.setShowDownIcon(false);
        summaryBuilder.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.addSummaryField();
            }
        });

        final SelectItem preferenceSelectItem = new SelectItem("name");
        preferenceSelectItem.setTitle("Preference");
        ListGrid pickListProperties = new ListGrid();
        pickListProperties.setEmptyMessage("No Saved Preferences");
        preferenceSelectItem.setPickListProperties(pickListProperties);
        preferenceSelectItem.setValueField("pk");
        preferenceSelectItem.setDisplayField("name");
        preferenceSelectItem.setOptionDataSource(preferencesDS);

        //apply the selected preference from the SelectItem
        preferenceSelectItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Integer preferencePK = (Integer) preferenceSelectItem.getValue();
                Criteria criteria = new Criterion("pk", OperatorId.EQUALS, preferencePK);
                preferencesDS.fetchData(criteria, new DSCallback() {
                    @Override
                    public void execute(DSResponse response, Object rawData, DSRequest request) {
                        Record[] data = response.getData();
                        if (data.length != 0) {
                            String selectedViewState = data[0].getAttribute("viewState");
                            countryGrid.setViewState(selectedViewState);
                        }
                    }
                });
            }
        });

        ToolStripButton savePreference = new ToolStripButton("Save Preference", "silk/database_gear.png");
        savePreference.setAutoFit(true);
        savePreference.setShowDownIcon(false);
        savePreference.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                SC.askforValue("Enter Preference name :", new ValueCallback() {
                    @Override
                    public void execute(String value) {
                        if (value != null && !value.equals("")) {
                            String viewState = countryGrid.getViewState();
                            PreferenceRecord record = new PreferenceRecord(PK_COUNTER++, value, viewState);
                            preferencesGrid.addData(record);
                            preferenceSelectItem.setValue(value);
                        }
                    }
                });
            }
        });

        //toolstrip to attach to the country grid
        ToolStrip countryGridToolStrip = new ToolStrip();
        countryGridToolStrip.setWidth100();
        countryGridToolStrip.addFill();
        countryGridToolStrip.addButton(formulaButton);
        countryGridToolStrip.addButton(summaryBuilder);
        countryGridToolStrip.addSeparator();
        countryGridToolStrip.addButton(savePreference);
        countryGridToolStrip.addSeparator();
        countryGridToolStrip.addFormItem(preferenceSelectItem);

        //toolstrip to attach to the preferences grid
        ToolStrip preferencesToolStrip = new ToolStrip();
        preferencesToolStrip.setWidth100();
        preferencesToolStrip.addFill();

        ToolStripButton restoreButton = new ToolStripButton("Restore State", "silk/database_gear.png");
        restoreButton.setShowDownIcon(false);
        restoreButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Record record = preferencesGrid.getSelectedRecord();
                if (record != null) {
                    String viewState = record.getAttribute("viewState");
                    preferenceSelectItem.setValue(record.getAttribute("pk"));
                    countryGrid.setViewState(viewState);
                    countryGrid.redraw();
                }
            }
        });
        preferencesToolStrip.addButton(restoreButton);

        VLayout layout = new VLayout();
        layout.setWidth(650);
        layout.setMinBreadthMember(countryGridToolStrip);

        layout.addDrawHandler(new DrawHandler() {
            @Override
            public void onDraw(DrawEvent event) {
                preferencesGrid.addData(new PreferenceRecord(PK_COUNTER++, "Default", countryGrid.getViewState()));
            }
        });

        layout.addMember(countryGridToolStrip);
        layout.addMember(countryGrid);
        layout.addMember(preferencesGrid);
        layout.addMember(preferencesToolStrip);

        return layout;
    }

    /**
     * Record class for capturing grid preference
     */
    class PreferenceRecord extends Record {
        PreferenceRecord(int pk, String name, String viewState) {
            setPk(pk);
            setName(name);
            setViewState(viewState);
        }

        public int getPk() {
            return getAttributeAsInt("pk");
        }

        public void setPk(int pk) {
            setAttribute("pk", pk);
        }

        public String getName() {
            return getAttribute("name");
        }

        public void setName(String name) {
            setAttribute("name", name);
        }

        public String getViewState() {
            return getAttribute("viewState");
        }

        public void setViewState(String viewState) {
            setAttribute("viewState", viewState);
        }
    }
    
    @Override
    protected boolean shouldWrapViewPanel() {
        return true;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}