package com.smartgwt.sample.showcase.client.sections;

import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SectionsCustomControlsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Custom controls may appear on section headers.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            SectionsCustomControlsSample panel = new SectionsCustomControlsSample();
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
        final ListGrid listGrid = new ListGrid();
        listGrid.setCanEdit(true);
        listGrid.setEditEvent(ListGridEditEvent.CLICK);
        listGrid.setFields(new ListGridField("system", "System"),
                new ListGridField("monitor", "Monitor"));

        final StatusCanvas statusReport = new StatusCanvas();

        ImgButton addButton = new ImgButton();
        addButton.setSrc("[SKIN]actions/add.png");
        addButton.setSize(16);
        addButton.setShowFocused(false);
        addButton.setShowRollOver(false);
        addButton.setShowDown(false);
        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                listGrid.startEditingNew();
            }
        });

        ImgButton removeButton = new ImgButton();
        removeButton.setSrc("[SKIN]actions/remove.png");
        removeButton.setSize(16);
        removeButton.setShowFocused(false);
        removeButton.setShowRollOver(false);
        removeButton.setShowDown(false);
        removeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                listGrid.removeSelectedData();
            }
        });

        DynamicForm form = new DynamicForm();
        form.setHeight(1);
        form.setWidth(75);
        form.setNumCols(1);

        SelectItem selectItem = new SelectItem();
        selectItem.setWidth(120);
        selectItem.setShowTitle(false);
        selectItem.setValueMap("Development", "Staging", "Production");
        selectItem.setDefaultValue("Development");
        selectItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                statusReport.setNewStatus((String)event.getValue());
            }
        });

        form.setFields(selectItem);


        SectionStack sectionStack = new SectionStack();

        SectionStackSection section1 = new SectionStackSection();
        section1.setTitle("Monitors");
        section1.setItems(listGrid);
        section1.setControls(addButton, removeButton);
        section1.setExpanded(true);

        SectionStackSection section2 = new SectionStackSection();
        section2.setTitle("Status");
        section2.setItems(statusReport);
        section2.setControls(form);
        section2.setExpanded(true);

        sectionStack.setSections(section1, section2);
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
        sectionStack.setAnimateSections(true);
        sectionStack.setWidth(300);
        sectionStack.setHeight(400);
        sectionStack.setOverflow(Overflow.HIDDEN);

        return sectionStack;
    }

    class StatusCanvas extends Canvas {
        StatusCanvas() {
            setPadding(5);

        }

        public void setNewStatus(String status) {
            setContents(status + ": <span style='color:green;font-weight:bold'>Normal</span><br>");
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}