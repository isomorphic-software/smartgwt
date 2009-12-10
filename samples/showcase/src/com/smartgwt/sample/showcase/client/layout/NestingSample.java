package com.smartgwt.sample.showcase.client.layout;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class NestingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Use the resize bars to reallocate space between the 3 panes. Layouts can be nested to create standard " +
            "application views. Resize bars are built-in.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            NestingSample panel = new NestingSample();
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
        HLayout mainLayout = new HLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();

        Label navigationLabel = new Label();
        navigationLabel.setContents("Navigation");
        navigationLabel.setAlign(Alignment.CENTER);
        navigationLabel.setOverflow(Overflow.HIDDEN);
        navigationLabel.setWidth("30%");
        navigationLabel.setShowResizeBar(true);

        mainLayout.addMember(navigationLabel);

        VLayout vLayout = new VLayout();
        vLayout.setWidth("70%");

        Label listingLabel = new Label();
        listingLabel.setContents("Listing");
        listingLabel.setAlign(Alignment.CENTER);
        listingLabel.setOverflow(Overflow.HIDDEN);
        listingLabel.setHeight("30%");
        listingLabel.setShowResizeBar(true);

        Label detailsLabel = new Label();
        detailsLabel.setContents("Details");
        detailsLabel.setAlign(Alignment.CENTER);
        detailsLabel.setOverflow(Overflow.HIDDEN);
        detailsLabel.setHeight("70%");

        vLayout.addMember(listingLabel);
        vLayout.addMember(detailsLabel);

        mainLayout.addMember(vLayout);
        return mainLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}