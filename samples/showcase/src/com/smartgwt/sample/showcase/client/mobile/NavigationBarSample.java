package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.FlowLayout;
import com.smartgwt.client.widgets.layout.NavigationBar;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class NavigationBarSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The <code>NavigationBar</code> component features intelligent "+
                    "auto-fitting behavior for the title area, designed to make best use of space for titles "+
                    "that may based on dynamic data, such as a property of the selected record in a grid."+
                    "<p>"+
                    "Press the buttons below the NavigationBar to see the behaviors with different titles:"+
                    "<ul>"+
                    "    <li> the title \"Fa Bai\" fits neatly and is centered "+
                    "    <li> the title \"Abe Jacobs\" is slightly too long to fit with the navigation buttons, "+
                    "         so it is intentionally placed slightly off-center, up to a configurable maximum off-center distance"+
                    "    <li> for a longer title like \"Izabella Chernyak F.\", the title of the left navigation button is "+
                    "         hidden (leaving just the left-pointing arrow)"+
                    "    <li> finally, for a very long title like \"Christine Bergeron Fewell\", the title is clipped "+
                    "         and an ellipsis shown"+
                    "</ul>"+
                    "Note that while auto-fitting works regardless of the skin or browser used, the specific titles chosen "+
                    "for this sample may be slightly shorter or longer in different skins or on computers will less fonts "+
                    "installed, and so may trigger the auto-fitting behaviors described above differently.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            NavigationBarSample panel = new NavigationBarSample();
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
        final NavigationBar navBar = new NavigationBar();
        navBar.setWidth(296);
        navBar.setLeftButtonTitle("Employees");
        navBar.setRightButtonTitle("Action");
        navBar.setShowRightButton(true);
        navBar.setTitle("Fa Bai");
		
        final IButton button1 = new IButton();
        button1.setTitle("Fa Bai");
        button1.setWidth(150);
        button1.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent arg0) {
                navBar.setTitle(button1.getTitle());
            }
        });
        final IButton button2 = new IButton();
        button2.setTitle("Abe Jacobs");
        button2.setWidth(150);
        button2.addClickHandler(new ClickHandler() {
            @Override
             public void onClick(ClickEvent arg0) {
                 navBar.setTitle(button2.getTitle());
             }
        });
        final IButton button3 = new IButton();
        button3.setTitle("Izabella Chernyak F.");
        button3.setWidth(150);
        button3.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent arg0) {
                navBar.setTitle(button3.getTitle());
            }
        });
        final IButton button4 = new IButton();
        button4.setTitle("Christine Bergeron Fewell");
        button4.setWidth(150);
        button4.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent arg0) {
                navBar.setTitle(button4.getTitle());
            }
        });
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setOverflow(Overflow.VISIBLE);
        flowLayout.setWidth100();
        flowLayout.setTileMargin(5);
        flowLayout.setTiles(button1, button2, button3, button4);
		
        VLayout vLayout = new VLayout();
        vLayout.setWidth100();
        vLayout.setMembers(navBar, flowLayout);

        return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
