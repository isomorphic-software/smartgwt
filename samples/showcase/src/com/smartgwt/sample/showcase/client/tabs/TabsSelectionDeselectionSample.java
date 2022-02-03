
package com.smartgwt.sample.showcase.client.tabs;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabDeselectedEvent;
import com.smartgwt.client.widgets.tab.events.TabDeselectedHandler;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TabsSelectionDeselectionSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Developers can apply custom event handler "+
        "logic to fire when the user selects tabs. "+
        "The preferences pane in this example has a <code>tabSelected</code> handler which will create "+
        "its pane lazily the first time the tab is selected, and a <code>tabDeselected</code> handler "+
        "which returns false to stop the user changing tabs if the form item is unchecked.</p>";

    public static class Factory implements PanelFactory {
        private String id;
        public ShowcasePanel create() {
            TabsSelectionDeselectionSample panel = new TabsSelectionDeselectionSample();
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

        final Label welcomePane = new Label();
        welcomePane.setContents("Welcome to the application");
        welcomePane.setWidth100();
        welcomePane.setAlign(Alignment.CENTER);
		
        final TabSet tabSet = new TabSet();
        tabSet.setWidth(400);
        tabSet.setHeight(200);
		
        final Tab tabWelcome = new Tab();
        tabWelcome.setTitle("Welcome");
        tabWelcome.setPane(welcomePane);
		
        final Tab preferences = new Tab();
        preferences.setTitle("Preferences");
        preferences.addTabSelectedHandler(new TabSelectedHandler() {
            @Override
            public void onTabSelected(TabSelectedEvent event) {
                if (event.getTabPane() == null) {
                    DynamicForm preferencesPane = new DynamicForm();
                    CheckboxItem useISCTabs = new CheckboxItem("useISCTabs");
                    useISCTabs.setTitle("Use SmartGWT tabs");
                    useISCTabs.setDefaultValue(false);
                    useISCTabs.setRequired(true);
                    preferencesPane.setFields(useISCTabs);
					
                    tabSet.updateTab(event.getTab(), preferencesPane);
                }
            }			
        });
        preferences.addTabDeselectedHandler(new TabDeselectedHandler() {
            @Override
            public void onTabDeselected(TabDeselectedEvent event) {
                Object checked = ((DynamicForm)event.getTab().getPane()).getValue("useISCTabs");
                if (checked.toString().equals("false")) {
                    event.cancel();
                }
            }
        });
		
        tabSet.setTabs(tabWelcome, preferences);
        
        return tabSet;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}