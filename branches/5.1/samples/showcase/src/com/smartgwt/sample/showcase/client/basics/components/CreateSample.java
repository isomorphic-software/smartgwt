package com.smartgwt.sample.showcase.client.basics.components;

import com.google.gwt.user.client.Random;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class CreateSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the button to create new cube objects.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            CreateSample panel = new CreateSample();
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

        VLayout layout = new VLayout();
        layout.setMembersMargin(10);

        final Canvas cubeBin = new Canvas("cubeBin");
        cubeBin.setTop(40);
        cubeBin.setWidth(400);
        cubeBin.setHeight(300);
        cubeBin.setShowEdges(true);

        IButton button = new IButton();
        button.setTitle("Create");
        button.setIcon("pieces/16/cube_blue.png");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                final Img img = new Img();
                img.setLeft(Random.nextInt(340));
                img.setTop(Random.nextInt(240));
                img.setWidth(48);
                img.setHeight(48);
                img.setParentElement(cubeBin);
                img.setSrc("pieces/48/cube_blue.png");
                img.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        img.destroy();
                    }
                });
                img.draw();
            }
        });
        layout.addMember(button);
        layout.addMember(cubeBin);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
