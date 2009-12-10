
package com.smartgwt.sample.showcase.client.sections;

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

public class SectionsAddRemoveSample extends ShowcasePanel {

    int lastSectionIndex;
    private static final String DESCRIPTION = "Press the \"Add Section\" and \"Remove Section\" buttons to add or remove sections.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            SectionsAddRemoveSample panel = new SectionsAddRemoveSample();
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
        final SectionStack sectionStack = new SectionStack();
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
        sectionStack.setWidth(300);
        sectionStack.setHeight(350);

        SectionStackSection section1 = new SectionStackSection("Blue Pawn");
        section1.setID("blueSection");
        section1.setExpanded(true);
        section1.addItem(new Img("pieces/48/pawn_blue.png", 48, 48));
        sectionStack.addSection(section1);

        SectionStackSection section2 = new SectionStackSection("Green Cube");
        section2.setExpanded(true);
        section2.setCanCollapse(false);
        section2.addItem(new Img("pieces/48/cube_green.png", 48, 48));
        sectionStack.addSection(section2);

        SectionStackSection section3 = new SectionStackSection("Blue Cube");
        section3.setExpanded(false);
        section3.addItem(new Img("pieces/48/cube_blue.png", 48, 48));
        sectionStack.addSection(section3);

        lastSectionIndex = 2;

        IButton addButton = new IButton("Add Section");
        addButton.setWidth(150);
        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

                SectionStackSection section2 = sectionStack.getSection("blueSection");
                String title = lastSectionIndex % 2 == 0 ? "Yellow Piece" : "Blue Cube";
                String iconName = lastSectionIndex % 2 == 0 ? "piece_yellow" : "cube_blue";
                SectionStackSection section = new SectionStackSection(title);
                section.setExpanded(lastSectionIndex % 2 == 0);
                section.addItem(new Img("pieces/48/" + iconName + ".png", 48, 48));
                sectionStack.addSection(section);
                ++lastSectionIndex;
            }
        });

        IButton removeButton = new IButton("Remove Section");
        removeButton.setWidth(150);
        removeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                sectionStack.removeSection(lastSectionIndex);
                --lastSectionIndex;
            }
        });

        HLayout layout = new HLayout();
        layout.setMembersMargin(20);
        layout.addMember(sectionStack);

        VLayout buttons = new VLayout();
        buttons.setMembersMargin(10);
        buttons.addMember(addButton);
        buttons.addMember(removeButton);

        layout.addMember(buttons);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}