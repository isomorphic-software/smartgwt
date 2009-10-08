
package com.smartgwt.sample.showcase.client.tabs;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TabsTitleChangeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Titles can be changed on the fly. Type in your name to see the \"Preferences\"" +
           " tab change its title to include your name.</p><p>Note that the tab automatically sizes" +
           " to accomodate the longer title - automatic sizing also happens at initialization.</p>";

    public static class Factory implements PanelFactory {
        private String id;
        public Canvas create() {
            TabsTitleChangeSample panel = new TabsTitleChangeSample();
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

        final TabSet topTabSet = new TabSet();
        topTabSet.setTabBarPosition(Side.TOP);
        topTabSet.setTabBarAlign(Side.LEFT);
        topTabSet.setWidth(400);
        topTabSet.setHeight(200);

        final Tab preferencesTab = new Tab("Preferences");
        DynamicForm preferencesForm = new DynamicForm();
        CheckboxItem useTabsCheckbox = new CheckboxItem();
        useTabsCheckbox.setTitle("Use Smart GWT tabs");
        preferencesForm.setFields(useTabsCheckbox);
        preferencesTab.setPane(preferencesForm);

        Tab profileTab = new Tab("Profile");
        DynamicForm profileForm = new DynamicForm();
        TextItem nameTextItem = new TextItem();
        nameTextItem.setTitle("Your Name");
        nameTextItem.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                String newTitle = (event.getValue() == null ? "" : event.getValue() + "'s ") + "Preferences";
                topTabSet.setTabTitle(preferencesTab, newTitle);
            }
        });
        profileForm.setFields(nameTextItem);
        profileTab.setPane(profileForm);

        topTabSet.addTab(profileTab);
        topTabSet.addTab(preferencesTab);

        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(15);
        vLayout.addMember(topTabSet);
        vLayout.setHeight("auto");
        
        return vLayout;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}