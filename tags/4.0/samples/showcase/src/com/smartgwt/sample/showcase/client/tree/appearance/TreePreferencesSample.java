package com.smartgwt.sample.showcase.client.tree.appearance;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
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
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class TreePreferencesSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example illustrates how a TreeGrid configuration can be saved as a user preference and later restored. " +
            "Notice how the expansion of the nodes and the position of custom fields created by the Formula Builder and Summary Builder are also captured and restored.</p>" +
            "<p>The TreeGrid configuration comprises of field state, sort state and selection state and these can be obtained separately by calling TreeGrid.getFieldState(), " +
            "TreeGrid.getSortState() and TreeGrid.getSelectionState() respectively. TreeGrid.getViewState() can be called to return all " +
            "three states.</p>" +
            "<p>The configuration state is a String which can be sent to the server to store and later retrieve the TreeGrid state.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            TreePreferencesSample panel = new TreePreferencesSample();
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

    private static int PK_COUNTER;

    public Canvas getViewPanel() {

        VLayout layout = new VLayout(15);
        layout.setWidth(650);
        layout.setAutoHeight();

        EmployeeXmlDS employeesDS = EmployeeXmlDS.getInstance();

        final TreeGrid treeGrid = new TreeGrid();
        treeGrid.setCanEdit(true);
        treeGrid.setLoadDataOnDemand(false);
        treeGrid.setWidth100();
        treeGrid.setHeight(400);
        treeGrid.setDataSource(employeesDS);
        treeGrid.setNodeIcon("icons/16/person.png");
        treeGrid.setFolderIcon("icons/16/person.png");
        treeGrid.setShowOpenIcons(false);
        treeGrid.setShowDropIcons(false);
        treeGrid.setClosedIconSuffix("");
        treeGrid.setAutoFetchData(true);

        TreeGridField nameField = new TreeGridField("Name");
        TreeGridField jobField = new TreeGridField("Job");
        TreeGridField salaryField = new TreeGridField("Salary");
        salaryField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value != null) {
                    NumberFormat nf = NumberFormat.getFormat("#,##0");
                    try {
                        return "$" + nf.format(((Number) value).longValue());
                    } catch (Exception e) {
                        return value.toString();
                    }
                } else {
                    return null;
                }
            }
        });

        treeGrid.setFields(nameField, jobField, salaryField);

        //create another grid to display the preference name and viewState string
        final ListGrid preferecesGrid = new ListGrid();
        preferecesGrid.setHeight(300);
        preferecesGrid.setWrapCells(true);
        preferecesGrid.setFixedRecordHeights(false);
        preferecesGrid.setCanEdit(true);
        preferecesGrid.setEmptyMessage("No Saved Preferences");
        preferecesGrid.setSelectionType(SelectionStyle.SINGLE);
        preferecesGrid.setCanRemoveRecords(true);
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
        preferecesGrid.setFields(name, viewState);
        preferecesGrid.setAutoFetchData(true);

        //create a "preferences" DataSource to bind to SelectItem and Preferences ListGrid
        final DataSource preferencesDS = new DataSource();
        DataSourceIntegerField pkField = new DataSourceIntegerField("pk");
        pkField.setHidden(true);
        pkField.setPrimaryKey(true);

        DataSourceTextField preferenceField = new DataSourceTextField("name", "Name");
        DataSourceTextField stateField = new DataSourceTextField("viewState", "View State");
        preferencesDS.setFields(pkField, preferenceField, stateField);
        preferencesDS.setClientOnly(true);
        preferecesGrid.setDataSource(preferencesDS);

        ToolStripButton formulaButton = new ToolStripButton("Formula Builder", "crystal/oo/sc_insertformula.png");
        formulaButton.setAutoFit(true);
        formulaButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                treeGrid.addFormulaField();
            }
        });

        ToolStripButton summaryBuilder = new ToolStripButton("Summary Builder", "crystal/16/apps/tooloptions.png");
        summaryBuilder.setAutoFit(true);
        summaryBuilder.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                treeGrid.addSummaryField();
            }
        });

        final SelectItem preferenceSelectItem = new SelectItem("name");
        preferenceSelectItem.setTitle("Preference");
        ListGrid pickListProperties = new ListGrid();
        pickListProperties.setEmptyMessage("No Saved Preferences");
        preferenceSelectItem.setPickListProperties(pickListProperties);
        preferenceSelectItem.setOptionDataSource(preferencesDS);

        //apply the selected preference from the SelectItem
        preferenceSelectItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                String preferenceName = (String) preferenceSelectItem.getValue();
                Criteria criteria = new Criteria("name", preferenceName);
                preferencesDS.fetchData(criteria, new DSCallback() {
                    @Override
                    public void execute(DSResponse response, Object rawData, DSRequest request) {
                        Record[] data = response.getData();
                        if (data.length != 0) {
                            PreferenceRecord record = (PreferenceRecord) data[0];
                            treeGrid.setViewState(record.getViewState());
                        }
                    }
                });
            }
        });
        preferenceSelectItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            @Override
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
                String preferenceName = (String) preferenceSelectItem.getValue();
                Criteria criteria = new Criteria("name", preferenceName);
                preferencesDS.fetchData(criteria, new DSCallback() {
                    @Override
                    public void execute(DSResponse response, Object rawData, DSRequest request) {
                        Record[] data = response.getData();
                        if (data.length != 0) {
                            PreferenceRecord record = (PreferenceRecord) data[0];
                            treeGrid.setViewState(record.getViewState());
                        }
                    }
                });
            }
        });

        ToolStripButton savePreference = new ToolStripButton("Save Preference", "silk/database_gear.png");
        savePreference.setAutoFit(true);
        savePreference.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                SC.askforValue("Enter Preference name :", new ValueCallback() {
                    @Override
                    public void execute(String value) {
                        if (value != null && !value.equals("")) {
                            String viewState = treeGrid.getViewState();
                            PreferenceRecord record = new PreferenceRecord(PK_COUNTER++, value, viewState);
                            preferecesGrid.addData(record);
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

        VLayout countryGridLayout = new VLayout(0);
        countryGridLayout.setWidth(650);
        countryGridLayout.addMember(countryGridToolStrip);
        countryGridLayout.addMember(treeGrid);
        layout.addMember(countryGridLayout);

        VLayout preferencesGridLayout = new VLayout(0);
        preferencesGridLayout.setWidth(650);
        preferencesGridLayout.addMember(preferecesGrid);

        //toolstrip to attach to the preferences grid
        ToolStrip preferencesToolStrip = new ToolStrip();
        preferencesToolStrip.setWidth100();
        preferencesToolStrip.addFill();

        ToolStripButton restoreButton = new ToolStripButton("Restore State", "silk/database_gear.png");
        restoreButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Record record = preferecesGrid.getSelectedRecord();
                if (record != null) {
                    String viewState = record.getAttribute("viewState");
                    treeGrid.setViewState(viewState);
                }
            }
        });
        preferencesToolStrip.addButton(restoreButton);
        preferencesGridLayout.addMember(preferencesToolStrip);

        layout.addMember(preferencesGridLayout);

        layout.addDrawHandler(new DrawHandler() {
            @Override
            public void onDraw(DrawEvent event) {
                preferecesGrid.addData(new PreferenceRecord(PK_COUNTER++, "Default", treeGrid.getViewState()));
            }
        });

        return layout;
    }

    /**
     * Record class for capturing grid preference
     */
    class PreferenceRecord extends ListGridRecord {
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

    public String getIntro() {
        return DESCRIPTION;
    }
}
