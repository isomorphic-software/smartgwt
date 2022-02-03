package com.smartgwt.sample.showcase.client.layout;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.EdgeName;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class UserSizingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Resize the outer frame to watch \"Member 1\" and \"Member 2\" split the space. Now resize either member " +
            "and resize the outer frame again. Layouts track sizes which have been set by user action and respect the user's settings.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            UserSizingSample panel = new UserSizingSample();
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
        VLayout layout = new VLayout(15);

        final HLayout mainLayout = new HLayout();
        mainLayout.setWidth(350);

        mainLayout.setShowEdges(true);
        mainLayout.setEdgeImage("edges/custom/sharpframe_10.png");
        mainLayout.setDragAppearance(DragAppearance.TARGET);
        mainLayout.setOverflow(Overflow.HIDDEN);
        mainLayout.setCanDragResize(true);
        mainLayout.setResizeFrom(EdgeName.L, EdgeName.R);
        mainLayout.setLayoutMargin(10);
        mainLayout.setMembersMargin(10);
        mainLayout.setMinWidth(100);
        mainLayout.setMinHeight(50);

        final Label member1 = new Label();
        member1.setContents("Member 1");
        member1.setOverflow(Overflow.HIDDEN);
        member1.setShowEdges(true);
        member1.setCanDragResize(true);
        member1.setResizeFrom(EdgeName.L, EdgeName.R);
        member1.setAlign(Alignment.CENTER);

        Label member2 = new Label();
        member2.setContents("Member 2");
        member2.setOverflow(Overflow.HIDDEN);
        member2.setShowEdges(true);
        member2.setCanDragResize(true);
        member2.setResizeFrom(EdgeName.L, EdgeName.R);
        member2.setAlign(Alignment.CENTER);

        mainLayout.addMember(member1);
        mainLayout.addMember(member2);
        mainLayout.setHeight(100);

        HLayout buttonLayout = new HLayout(15);

        final IButton removeMember = new IButton("Remove Member 1");
        removeMember.setMinWidth(120);
        removeMember.setAutoFit(true);
        
        final IButton addMember = new IButton("Add Member 1");
        addMember.setMinWidth(120);
        addMember.setAutoFit(true);
        addMember.setDisabled(true);

        removeMember.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                mainLayout.removeChild(member1);
                removeMember.disable();
                addMember.enable();
            }
        });
        buttonLayout.addMember(removeMember);


        addMember.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                mainLayout.addMember(member1);
                addMember.disable();
                removeMember.enable();
            }
        });
        buttonLayout.addMember(addMember);

        layout.addMember(mainLayout);
        layout.addMember(buttonLayout);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
