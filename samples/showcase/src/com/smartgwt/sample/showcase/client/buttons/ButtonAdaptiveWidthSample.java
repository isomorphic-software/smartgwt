package com.smartgwt.sample.showcase.client.buttons;

import com.smartgwt.client.util.Page;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Splitbar;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ButtonAdaptiveWidthSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The Button class has built-in adaptive width support, enabled by "+
            "setting the canAdaptWidth property to true. If the parent container will overflow, an "+
            "adaptive-width Button will hide its title in an attempt to prevent the parent "+
            "container from overflowing. "+
            "<p>"+
            "An adaptive-width Button is shown here. Drag the resize bar to simulate "+
            "varying widths of the parent container and see how the Button reacts.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ButtonAdaptiveWidthSample panel = new ButtonAdaptiveWidthSample();
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

        final DynamicForm form = new DynamicForm();
		form.setWidth("*");
		form.setMinWidth(200);
		form.setHeight100();
		form.setOverflow(Overflow.HIDDEN);
		form.setNumCols(1);
		form.setCellPadding(0);
		
		final TextItem item = new TextItem();
		item.setName("q");
		item.setShowTitle(false);
		item.setWidth("100%");
		item.setHeight("100%");
		item.setHint("Related search terms");
		item.setShowHintInField(true);
		
		form.setItems(item);

		final boolean isRTL = Page.isRTL();
		Button adaptiveButton = new Button();
		adaptiveButton.setWidth(140);
		adaptiveButton.setCanAdaptWidth(true);
		adaptiveButton.setHeight100();
		adaptiveButton.setTitle("Find Related");
		adaptiveButton.setIcon("icons/16/find.png");
		adaptiveButton.setShowFocusedAsOver(false);
		adaptiveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String q = form.getValueAsString("q");
				if (q != null) { 
					SC.say("This is when the logic to search for <q>" + q + "</q> would run&hellip;");
				}
			}
		});
		
		final HLayout hLayout = new HLayout();
		hLayout.setWidth100();
		hLayout.setMinWidth(250);
		hLayout.setHeight100();
		hLayout.setOverflow(Overflow.HIDDEN);
		hLayout.setLayoutRightMargin(isRTL ? 0 : 6);
		hLayout.setLayoutLeftMargin(isRTL ? 6 : 0);
		hLayout.setMembers(adaptiveButton, form);
		hLayout.setShowResizeBar(true);
		
		final LayoutSpacer spacer = new LayoutSpacer();
		spacer.setWidth("*");
		
		final HLayout mainHLayout = new HLayout();
		mainHLayout.setWidth100();
		mainHLayout.setHeight(40);
		mainHLayout.setOverflow(Overflow.HIDDEN);
        final Splitbar resizeBarProperties = new Splitbar();
        resizeBarProperties.setCanCollapse(false);
        resizeBarProperties.setGripLength(36);
        mainHLayout.setAutoChildProperties("resizeBar", resizeBarProperties);
		mainHLayout.setMembers(hLayout, spacer);
		
        return mainHLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    @Override
    protected boolean shouldWrapViewPanel() {
        return true;
    }

}
