package com.smartgwt.sample.showcase.client.mobile;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.BlurbItem;
import com.smartgwt.client.widgets.form.fields.ColorItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.RowSpacerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AdaptiveFormsSample extends ShowcasePanel {
    private static final String DESCRIPTION = 
        "By specifying <code>linearOnMobile:true</code> on a form, a form that would normally render in multiple "+
        "columns on desktop will automatically render in Linear Mode on mobile, so that all items are "+
        "stacked in a single column, with item widths and column spans assumed by default to be \"*\", "+
        "potentially avoiding the need to scroll the viewport horizontally to fill out the form."+
        "<p>"+
        "From a mobile target, click \"Toggle Layout Mode\" below to switch to desktop mode where the "+
        "form may require horizontal scrolling. From a desktop system, toggle the layout to see how the "+
        "form will look on a mobile target."+
        "<p>"+
        "Properties <code>linearNumCols</code> on the form, and <code>linearWidth</code>, <code>linearColSpan</code>, "+
        "<code>linearStartRow</code> and "+
        "linearEndRow on the item are available for more precise control over item layout in Linear Mode, "+
        "where they override the corresponding property without the \"linear\" prefix.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            AdaptiveFormsSample panel = new AdaptiveFormsSample();
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

    private DynamicForm adaptiveForm;
	
	private String helpText = "<br><b>Severity 1</b> - Critical problem<br>System is unavailable in production or " +
    "is corrupting data, and the error severely impacts the user's operations." +
    "<br><br><b>Severity 2</b> - Major problem<br>An important function of the system " +
    "is not available in production, and the user's operations are restricted." +
    "<br><br><b>Severity 3</b> - Minor problem<br>Inability to use a function of the " +
    "system occurs, but it does not seriously affect the user's operations.";
    
    private void updateGroupTitle () {
        String mode = adaptiveForm.getLinearMode() ? "Linear" : "Normal";
        adaptiveForm.setGroupTitle("Form Item Icons <i>(" + mode + " Mode)</i>");
    }

    public Canvas getViewPanel() {
        Map<String,String> countryMap = new HashMap<String,String>();
		countryMap.put("US","United States");
		countryMap.put("CH","China");
		countryMap.put("JA","Japan");
		countryMap.put("IN","India");
		countryMap.put("GM","Germany");
		countryMap.put("FR","France");
		countryMap.put("IT","Italy");
		countryMap.put("RS","Russia");
		countryMap.put("BR","Brazil");
		countryMap.put("CA","Canada");
		countryMap.put("MX","Mexico");
		countryMap.put("SP","Spain");
				
		adaptiveForm = new DynamicForm() {
			@Override
			public DynamicForm setLinearMode(Boolean linearMode) {
				super.setLinearMode(linearMode);
				updateGroupTitle();
				return this;
			}
		};
		adaptiveForm.setWidth100();
		adaptiveForm.setNumCols(4);
		adaptiveForm.setMaxWidth(400);
		adaptiveForm.setMinWidth(300);
		adaptiveForm.setIsGroup(true);
		adaptiveForm.setPadding(5);
		adaptiveForm.setCanTabToIcons(false); 
		adaptiveForm.setLinearOnMobile(true);
		adaptiveForm.setWrapHintText(false);
		adaptiveForm.setWrapItemTitles(false);
		adaptiveForm.setLinearMode(false);
		
		BlurbItem blurbItem = new BlurbItem();
		blurbItem.setValue("Picker Icons");
		
		ComboBoxItem comboBoxItem = new ComboBoxItem();
		comboBoxItem.setTitle("Combo Box");
		comboBoxItem.setValueMap(countryMap);
		comboBoxItem.setHint("pick a country");
		
		DateItem dateItem = new DateItem();
		dateItem.setTextAlign(Alignment.LEFT);
		dateItem.setUseTextField(true);
		dateItem.setTitle("Date Item");
		dateItem.setHint("travel when?");
	    
		ColorItem colorItem = new ColorItem();
		colorItem.setTitle("Color Item");
		colorItem.setHint("pick a color");
		
		SpinnerItem spinnerItem = new SpinnerItem();
		spinnerItem.setWriteStackedIcons(true);
		spinnerItem.setTitle("Spinner Item");
		spinnerItem.setMin(1);
		spinnerItem.setMax(10);
		spinnerItem.setHint("how many people?");
		
		RowSpacerItem rowSpacerItem = new RowSpacerItem();
		
		BlurbItem blurbItem2 = new BlurbItem();
		blurbItem2.setValue("Custom Icons");

		// Show custom icons on focus
		SelectItem customIcon = new SelectItem();
		customIcon.setTitle("External Icon");
		customIcon.setValue("2");
		Map<String,String> valueIconMap = new HashMap<String,String>();
		valueIconMap.put("1", "Severity 1");
		valueIconMap.put("2", "Severity 2");
		valueIconMap.put("3", "Severity 3");
		customIcon.setValueMap(valueIconMap);
		FormItemIcon icon = new FormItemIcon();
		icon.setSrc("other/help.png");
		icon.addFormItemClickHandler(new FormItemClickHandler() {
			@Override
			public void onFormItemClick(FormItemIconClickEvent event) {
				SC.say(helpText);
			}
		});
		customIcon.setIcons(icon);
		
		TextItem inlineIcons = new TextItem();
		inlineIcons.setTitle("Inline Icons");
		inlineIcons.setSuppressBrowserClearIcon(true);
		inlineIcons.setIconHeight(16);
		inlineIcons.setIconWidth(16);
		FormItemIcon viewIcon = new FormItemIcon();
		viewIcon.setSrc("[SKINIMG]actions/view.png");
		viewIcon.setHspace(5);
		viewIcon.setInline(true);
		viewIcon.setBaseStyle("roundedTextItemIcon");
		viewIcon.setShowRTL(true);
		FormItemIcon clearIcon = new FormItemIcon();
		clearIcon.setSrc("[SKINIMG]actions/close.png");
		clearIcon.setWidth(10);
		clearIcon.setHeight(10);
		clearIcon.setInline(true);
		clearIcon.setPrompt("Clear this field");
		clearIcon.addFormItemClickHandler(new FormItemClickHandler() {
			@Override
			public void onFormItemClick(FormItemIconClickEvent event) {
				event.getItem().clearValue();
				event.getItem().focusInItem();
			}
		});
		inlineIcons.setIcons(viewIcon, clearIcon);
		
		adaptiveForm.setFields(blurbItem, comboBoxItem, dateItem, colorItem, spinnerItem, rowSpacerItem, blurbItem2,
				customIcon, inlineIcons);
		
		IButton toggle = new IButton();
		toggle.setAutoFit(true);
		toggle.setTitle("Toggle Layout Mode");
		toggle.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				adaptiveForm.setLinearMode(!adaptiveForm.getLinearMode());
			}
		});
		
		VLayout vLayout = new VLayout();
		vLayout.setMembersMargin(15);
		vLayout.addMember(toggle);
		vLayout.addMember(adaptiveForm);

        updateGroupTitle();

		return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
    
    @Override
    protected boolean isTopIntro() {
        return true;
    }
}
