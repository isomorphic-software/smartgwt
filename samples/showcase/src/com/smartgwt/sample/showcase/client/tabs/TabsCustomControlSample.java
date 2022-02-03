
package com.smartgwt.sample.showcase.client.tabs;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TabsCustomControlSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "<p>Custom controls may appear on Tab Bars.</p>";

    public static class Factory implements PanelFactory {
        private String id;
        public ShowcasePanel create() {
            TabsCustomControlSample panel = new TabsCustomControlSample();
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

        final TabSet tabSet = new TabSet();
        tabSet.setTabBarPosition(Side.TOP);

        //required so that the select item doesnt touch the tab pane
        tabSet.setTabBarAlign(Side.LEFT);
        tabSet.setWidth(400);
        tabSet.setHeight(200);

        final Tab statusTab = new Tab("Status");

        final Canvas statusPane = new Canvas();
        statusTab.setPane(statusPane);
        tabSet.addTab(statusTab);
        
        SelectItem selectItem = new SelectItem();
        selectItem.setValueMap("Development", "Staging", "Production");
        selectItem.setShowTitle(false);

        selectItem.setDefaultValue("Development");
        selectItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                statusPane.setContents(event.getValue() + ": <span style='color:green;font-weight:bold'>Normal</span><br>");
            }
        });

        DynamicForm form = new DynamicForm();
        //form.setHeight(1);
        form.setPadding(0);
        form.setMargin(0);
        form.setCellPadding(1);
        form.setNumCols(1);
        form.setFields(selectItem);

        tabSet.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER, form);
        return tabSet;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}