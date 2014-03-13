package com.smartgwt.sample.showcase.client.other;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.DataBoundComponent;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SimpleTypeParsingFormattingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example demonstrates the use of a custom SimpleType to represent a currency. The CurrencyType has custom formatters " +
            "and parsers and therefore allows display of currency symbols while the underlying data value is still numeric</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            SimpleTypeParsingFormattingSample panel = new SimpleTypeParsingFormattingSample();
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

    protected boolean isTopIntro() {
        return true;
    }

    public Canvas getViewPanel() {
        DataSource supplyItem = new DataSource();
        DataSourceField itemID = new DataSourceField("itemID", FieldType.SEQUENCE);
        itemID.setHidden(true);
        itemID.setPrimaryKey(true);

        DataSourceField itemName = new DataSourceField("itemName", FieldType.TEXT);

        DataSourceField unitCost = new DataSourceField();
        unitCost.setName("unitCost");

        //set the type
        unitCost.setType(new CurrencyType());

        supplyItem.setFields(itemID, itemName, unitCost);
        supplyItem.setClientOnly(true);

        ListGridRecord[] sampleData = getSampleData();
        supplyItem.setTestData(sampleData);

        VLayout editLayout = new VLayout();
        editLayout.setWidth100();
        editLayout.setHeight100();
        editLayout.setDefaultLayoutAlign(Alignment.CENTER);
        editLayout.setMembersMargin(5);

        final ListGrid supplyGrid = new ListGrid();
        final DynamicForm supplyForm = new DynamicForm();

        supplyGrid.setDataSource(supplyItem);
        supplyGrid.setAutoFetchData(true);
        supplyGrid.setCanEdit(true);
        supplyGrid.setHeight(200);
        supplyGrid.addRecordClickHandler(new RecordClickHandler() {
            @Override
            public void onRecordClick(RecordClickEvent event) {
                supplyForm.editRecord(event.getRecord());
            }
        });

        supplyForm.setDataSource(supplyItem);

        IButton saveBtn = new IButton("Save");
        saveBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                supplyForm.saveData();
            }
        });

        editLayout.setMembers(supplyGrid, supplyForm, saveBtn);
        return editLayout;
    }

    public static class CurrencyType extends SimpleType {
        public CurrencyType() {
            super("currency", FieldType.INTEGER);

            setNormalDisplayFormatter(new SimpleTypeFormatter() {
                @Override
                public String format(Object value, DataClass field,
                                     DataBoundComponent component, Record record) {

                    if (value instanceof Float) {
                        NumberFormat fmt = NumberFormat.getFormat("$0.00 (US)");
                        return fmt.format(((Float) value).doubleValue());
                    }
                    return value == null ? "" : value.toString();

                }
            });

            setShortDisplayFormatter(new SimpleTypeFormatter() {

                @Override
                public String format(Object value, DataClass field,
                                     DataBoundComponent component, Record record) {

                    if (value instanceof Float) {
                        NumberFormat fmt = NumberFormat.getFormat("$0.00");
                        return fmt.format(((Float) value).doubleValue());
                    }
                    return value == null ? "" : value.toString();

                }
            });

            setEditFormatter(new SimpleTypeFormatter() {
                @Override
                public String format(Object value, DataClass field,
                                     DataBoundComponent component, Record record) {

                    if (value instanceof Float) {

                        NumberFormat fmt = NumberFormat.getFormat("0.00");
                        return fmt.format(((Float) value).doubleValue());
                    }
                    return value == null ? "" : value.toString();
                }
            });

            setEditParser(new SimpleTypeParser() {

                @Override
                public Object parseInput(String value, DataClass field,
                                         DataBoundComponent component, Record record) {

                    if (value == null) return null;
                    if (value.startsWith("$")) value = value.substring(1);
                    try {
                        Float floatVal = Float.parseFloat(value);
                        return floatVal;
                    } catch (Exception e) {
                        return value;
                    }
                }
            });
        }
    }

    public static class SupplyItem extends ListGridRecord {
        public SupplyItem(int itemID, String itemName, Float unitCost) {
            setAttribute("itemID", itemID);
            setAttribute("itemName", itemName);
            setAttribute("unitCost", unitCost);
        }
    }

    private ListGridRecord[] getSampleData() {
        ListGridRecord[] testData = new ListGridRecord[6];
        testData[0] = new SupplyItem(0, "Indices White Polypropylene A4 1-5", new Float(1.03));
        testData[1] = new SupplyItem(1, "Paper Acid Free Tissue 400 x 660mm", new Float(20.73));
        testData[2] = new SupplyItem(1, "Envelopes White 90 x 145mm", new Float(12.13));
        testData[3] = new SupplyItem(1, "Vehicle and Expenses Book Wildon No.86", new Float(1.92));
        testData[4] = new SupplyItem(1, "Document Holder A4 Multi Punched", new Float(3.07));
        testData[5] = new SupplyItem(1, "File Spiral Spring F/c Buff Plain", new Float(1.58));
        return testData;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}