package com.smartgwt.sample.showcase.client.forms.details;

import java.util.LinkedHashMap;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.ColorItem;
import com.smartgwt.client.widgets.form.fields.RowSpacerItem;
import com.smartgwt.client.widgets.form.fields.BlurbItem;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ShowIconsOnFocusSample extends ShowcasePanel {

    private static final String DESCRIPTION = "FormItem icons can be configured to be shown only when the "+
            "item has focus, creating a cleaner look for your forms while still allowing you to add common "+
            "actions.<p>"+
            "Tab through the items in the DynamicForm to see the icons showing and hiding automatically.";

    private static final String HELPTEXT = "<br><b>Severity 1</b> - Critical problem<br>System is unavailable in production or " +
		    "is corrupting data, and the error severely impacts the user's operations." +
		    "<br><br><b>Severity 2</b> - Major problem<br>An important function of the system " +
		    "is not available in production, and the user's operations are restricted." +
		    "<br><br><b>Severity 3</b> - Minor problem<br>Inability to use a function of the " +
		    "system occurs, but it does not seriously affect the user's operations.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ShowIconsOnFocusSample panel = new ShowIconsOnFocusSample();
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
    	
        DynamicForm showIconsOnFocusForm = new DynamicForm();  
        showIconsOnFocusForm.setWidth(350);  
        showIconsOnFocusForm.setHeight(300);
        showIconsOnFocusForm.setIsGroup(true);  
        showIconsOnFocusForm.setGroupTitle("Show Icons On Focus");
        showIconsOnFocusForm.setPadding(5);
        showIconsOnFocusForm.setCanTabToIcons(false);
  
        BlurbItem blurbItem = new BlurbItem();
        blurbItem.setValue("Picker Icons");
        
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();  
        valueMap.put("US", "United States");  
        valueMap.put("CH", "China");  
        valueMap.put("JA", "Japan");  
        valueMap.put("IN", "India");  
        valueMap.put("GM", "Germany");  
        valueMap.put("FR", "France");  
        valueMap.put("IT", "Italy");  
        valueMap.put("RS", "Russia");  
        valueMap.put("BR", "Brazil");  
        valueMap.put("CA", "Canada");  
        valueMap.put("MX", "Mexico");  
        valueMap.put("SP", "Spain");  

        ComboBoxItem comboBoxItem = new ComboBoxItem();  
        comboBoxItem.setTitle("Combo Box");  
        comboBoxItem.setShowPickerIconOnFocus(true);
        comboBoxItem.setValueMap(valueMap);  
        
        DateItem dateItem = new DateItem();  
        dateItem.setTitle("Date Item");  
        dateItem.setUseTextField(true); 
        dateItem.setShowPickerIconOnFocus(true);
        
        ColorItem colorItem = new ColorItem();  
        colorItem.setTitle("Color Item");  
        colorItem.setShowPickerIconOnFocus(true);
            
        RowSpacerItem spacerItem = new RowSpacerItem();
        
        BlurbItem blurbItem2 = new BlurbItem();
        blurbItem2.setValue("Custom Icons");
        
        LinkedHashMap<String, String> valueMapSeverity = new LinkedHashMap<String, String>();  
        valueMapSeverity.put("1", "Severity 1");  
        valueMapSeverity.put("2", "Severity 2");  
        valueMapSeverity.put("3", "Severity 3"); 
        
        FormItemIcon icon = new FormItemIcon();
        icon.setSrc("other/help.png");
        icon.addFormItemClickHandler(new FormItemClickHandler() {
            @Override
            public void onFormItemClick(FormItemIconClickEvent event) {
                SC.say(HELPTEXT);
            }
        });
        
        SelectItem customIcon = new SelectItem();  
        customIcon.setTitle("External Icon");  
        customIcon.setValueMap(valueMapSeverity);  
        customIcon.setIcons(icon); 
        customIcon.setShowIconsOnFocus(true);
        customIcon.setValue(2);
        
        TextItem inclineIcons = new TextItem();
        inclineIcons.setTitle("Inline Icons");
        inclineIcons.setSuppressBrowserClearIcon(true);
        inclineIcons.setShowIconsOnFocus(true);
        
        FormItemIcon viewIcon = new FormItemIcon();
        viewIcon.setSrc("[SKIN]/actions/view.png");
        viewIcon.setHspace(5);
        viewIcon.setInline(true);
        viewIcon.setBaseStyle("roundedTextItemIcon");
        viewIcon.setShowRTL(true);
        
        FormItemIcon clearIcon = new FormItemIcon();
        clearIcon.setSrc("[SKIN]actions/close.png");
        clearIcon.setWidth(10);
        clearIcon.setHeight(10);
        clearIcon.setInline(true);
        clearIcon.setPrompt("Clear this field");
        clearIcon.addFormItemClickHandler(new FormItemClickHandler() {
            @Override
            public void onFormItemClick(FormItemIconClickEvent event) {
                FormItem item = event.getItem();
                item.clearValue();
                item.focusInItem();
            }
        });
        
        inclineIcons.setIcons(viewIcon, clearIcon);
        inclineIcons.setIconWidth(16);
        inclineIcons.setIconHeight(16);
        
        showIconsOnFocusForm.setFields(blurbItem, comboBoxItem, dateItem, colorItem, spacerItem, 
                                       blurbItem2, customIcon, inclineIcons);

        return showIconsOnFocusForm;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
