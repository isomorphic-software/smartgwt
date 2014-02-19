package com.smartgwt.sample.showcase.client.sections;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SectionsReorderSample  extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>This example illustrates the ability to drag-reorder sections. Simply drag the headers of the sections to reorder.</p>";


    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            SectionsReorderSample panel = new SectionsReorderSample();
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
        HTMLFlow htmlFlow = new HTMLFlow();
        htmlFlow.setOverflow(Overflow.AUTO);
        htmlFlow.setPadding(10);

        String contents = "<b>Severity 1</b> - Critical problem<br>System is unavailable in production or " +
                "is corrupting data, and the error severely impacts the user's operations." +
                "<br><br><b>Severity 2</b> - Major problem<br>An important function of the system " +
                "is not available in production, and the user's operations are restricted." +
                "<br><br><b>Severity 3</b> - Minor problem<br>Inability to use a function of the " +
                "system occurs, but it does not seriously affect the user's operations.";

        htmlFlow.setContents(contents);

        final SectionStack sectionStack = new SectionStack();
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
        sectionStack.setCanReorderSections(true);
        sectionStack.setCanResizeSections(false);
        sectionStack.setWidth(300);
        sectionStack.setHeight(350);


        SectionStackSection section1 = new SectionStackSection("Blue Pawn");
        section1.setExpanded(true);
        section1.addItem(new Img("pieces/48/pawn_blue.png", 48, 48));
        sectionStack.addSection(section1);

        SectionStackSection section2 = new SectionStackSection("HTML Flow");
        section2.setExpanded(true);
        section2.setCanCollapse(true);
        section2.addItem(htmlFlow);
        sectionStack.addSection(section2);

        SectionStackSection section3 = new SectionStackSection("Green Pawn");
        section3.setExpanded(true);
        section3.setCanCollapse(false);
        section3.addItem(new Img("pieces/48/pawn_green.png", 48, 48));
        sectionStack.addSection(section3);

        SectionStackSection section4 = new SectionStackSection("Yellow Piece");
        section4.setExpanded(false);
        section4.addItem(new Img("pieces/48/piece_yellow.png", 48, 48));
        sectionStack.addSection(section4);

        return sectionStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
