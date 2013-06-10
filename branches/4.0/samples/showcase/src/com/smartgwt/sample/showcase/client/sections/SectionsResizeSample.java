
package com.smartgwt.sample.showcase.client.sections;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SectionsResizeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag the \"Help 2\" header to resize sections, or press \"Resize Help 1\" to" +
           " resize to fixed height. The \"Blue Pawn\" section is marked not resizeable.";


    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            SectionsResizeSample panel = new SectionsResizeSample();
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
        final HelpCanvas help1 = new HelpCanvas("help1");
        final HelpCanvas help2 = new HelpCanvas("help2");

        final SectionStack sectionStack = new SectionStack();
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
        sectionStack.setWidth(300);
        sectionStack.setHeight(350);

        SectionStackSection section1 = new SectionStackSection("Blue Pawn");
        section1.setExpanded(true);
        section1.setResizeable(false);
        section1.addItem(new Img("pieces/48/pawn_blue.png", 48, 48));
        sectionStack.addSection(section1);

        SectionStackSection section2 = new SectionStackSection("Help 1");
        section2.setExpanded(true);
        section2.setCanCollapse(true);

        section2.addItem(help1);
        sectionStack.addSection(section2);
        SectionStackSection section3 = new SectionStackSection("Help 2");
        section3.setExpanded(true);
        section3.setCanCollapse(true);
        section3.addItem(help2);
        sectionStack.addSection(section3);

        IButton resizeButton = new IButton("Resize Help 1");
        resizeButton.setWidth(150);
        resizeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                help1.setHeight(200);
            }
        });

        HLayout layout = new HLayout();
        layout.setMembersMargin(20);
        layout.addMember(sectionStack);

        VLayout buttons = new VLayout();
        buttons.setMembersMargin(10);
        buttons.addMember(resizeButton);

        layout.addMember(buttons);
        return layout;
    }

    class HelpCanvas extends Canvas {
        private String contents =  "<b>Severity 1</b> - Critical problem<br>System is unavailable in production or " +
              "is corrupting data, and the error severely impacts the user's operations." +
              "<br><br><b>Severity 2</b> - Major problem<br>An important function of the system " +
              "is not available in production, and the user's operations are restricted." +
              "<br><br><b>Severity 3</b> - Minor problem<br>Inability to use a function of the " +
              "system occurs, but it does not seriously affect the user's operations.";

        public HelpCanvas(String id) {
            setID(id);
            setPadding(10);
            setOverflow(Overflow.AUTO);
            setContents(contents);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}