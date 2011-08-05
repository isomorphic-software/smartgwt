package com.smartgwt.sample.showcase.client.windows;

import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClientEvent;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class WindowModalitySample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Click on \"Show Window\" to show a modal window.</p><p>Note that the \"Touch This\" button no "
            + "longer shows rollovers or an interactive cursor, nothing outside the window can be clicked, clicks outside the window cause "
            + "the window to flash, and tabbing remains in a closed loop cycling through only the contents of the window.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            WindowModalitySample panel = new WindowModalitySample();
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
        final IButton buttonTouchThis = new IButton("Touch This");
        buttonTouchThis.setAutoFit(true);
        buttonTouchThis.setShowRollOver(true);
        buttonTouchThis.setShowDown(true);
        buttonTouchThis.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                buttonTouchThis.focus();
            }
        });
        
        HTMLPane paneLink = new HTMLPane();
        paneLink.setContents("<a href=\"http://google.com\" target=\"_blank\">Open Google</a>");
        
        IButton buttonShowWindow = new IButton("Show Window");
        buttonShowWindow.setShowRollOver(true);
        buttonShowWindow.setShowDown(true);
        buttonShowWindow.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                buttonTouchThis.setTitle("Can't Touch This");
                final Window winModal = new Window();
                winModal.setWidth(360);
                winModal.setHeight(115);
                winModal.setTitle("Modal Window");
                winModal.setShowMinimizeButton(false);
                winModal.setIsModal(true);
                winModal.setShowModalMask(true);
                winModal.centerInPage();
                winModal.addCloseClickHandler(new CloseClickHandler() {
                    public void onCloseClick(CloseClientEvent event) {
                        buttonTouchThis.setTitle("Touch This");
                        winModal.destroy();
                    }
                });
                DynamicForm form = new DynamicForm();
                form.setHeight100();
                form.setWidth100();
                form.setPadding(5);
                form.setLayoutAlign(VerticalAlignment.BOTTOM);
                TextItem textItem = new TextItem();
                textItem.setTitle("Text");
                DateItem dateItem = new DateItem();
                dateItem.setTitle("Date");
                DateItem dateItem2 = new DateItem();
                dateItem2.setTitle("Date");
                dateItem2.setUseTextField(true);
                form.setFields(textItem, dateItem, dateItem2);
                winModal.addItem(form);
                winModal.show();
            }
        });
        
        HStack layoutTopRow = new HStack(10);
        layoutTopRow.setHeight(50);
        layoutTopRow.addMember(buttonTouchThis);
        layoutTopRow.addMember(paneLink);
        
        VLayout layoutMain = new VLayout();
        layoutMain.addMember(layoutTopRow);
        layoutMain.addMember(buttonShowWindow);
        
        return layoutMain;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}