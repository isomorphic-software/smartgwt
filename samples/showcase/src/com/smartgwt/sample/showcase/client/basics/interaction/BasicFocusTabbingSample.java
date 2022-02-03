package com.smartgwt.sample.showcase.client.basics.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.FocusChangedEvent;
import com.smartgwt.client.widgets.events.FocusChangedHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class BasicFocusTabbingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Press the Tab key to cycle through the tab order starting from " + 
    "the blue piece. Then drag reorder either piece, click on the leftmost piece and use Tab to cycle through " + 
    "again. Tab order is automatically updated to reflect the visual order."; 

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	BasicFocusTabbingSample panel = new BasicFocusTabbingSample();
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
        HStack hStack = new HStack();
        hStack.setWidth(300);
        hStack.setHeight(100);
        hStack.setShowEdges(true);
        hStack.setCanAcceptDrop(true);
        hStack.setAnimateMembers(true);
        hStack.setDropLineThickness(4);

        final Label focusLabel = new Label();
        focusLabel.setID("focusLabel");
        focusLabel.setAlign(Alignment.CENTER);
        focusLabel.setTop(150);
        focusLabel.setWidth(300);
        focusLabel.setHeight(50);

        final Img bluePawn = new Img();
        bluePawn.setID("bluePawn");
        bluePawn.setLayoutAlign(Alignment.CENTER);
        bluePawn.setWidth(48);
        bluePawn.setHeight(48);
        bluePawn.setCanFocus(true);
        bluePawn.setSrc("pieces/48/pawn_blue.png");
        bluePawn.setCanDragReposition(true);
        bluePawn.setCanDrop(true);
        bluePawn.setDragAppearance(DragAppearance.TARGET);
        bluePawn.addFocusChangedHandler(new FocusChangedHandler() {
			public void onFocusChanged(FocusChangedEvent event) {
				changeLabel(focusLabel, bluePawn.getID(), event.getHasFocus());
			}
        });

        ComboBoxItem field1 = new ComboBoxItem();
        field1.setName("field1");
        field1.setValueMap("Option 1", "Option 2");

        DateItem field2 = new DateItem();
        field2.setName("field2");

        final DynamicForm simpleForm = new DynamicForm();
        simpleForm.setID("simpleForm");
        simpleForm.setLayoutAlign(Alignment.CENTER);
        simpleForm.setHeight(48);
        simpleForm.setFields(field1, field2);
        simpleForm.addFocusChangedHandler(new FocusChangedHandler() {
			public void onFocusChanged(FocusChangedEvent event) {
				changeLabel(focusLabel, simpleForm.getID(), event.getHasFocus());
			}
        });

        final Img greenPawn = new Img();
        greenPawn.setID("greenPawn");
        greenPawn.setLayoutAlign(Alignment.CENTER);
        greenPawn.setWidth(48);
        greenPawn.setHeight(48);
        greenPawn.setCanFocus(true);
        greenPawn.setSrc("pieces/48/pawn_green.png");
        greenPawn.setCanDragReposition(true);
        greenPawn.setCanDrop(true);
        greenPawn.setDragAppearance(DragAppearance.TARGET);
        greenPawn.addFocusChangedHandler(new FocusChangedHandler() {
			public void onFocusChanged(FocusChangedEvent event) {
				changeLabel(focusLabel, greenPawn.getID(), event.getHasFocus());
			}
        });

        hStack.addMember(bluePawn);
        hStack.addMember(simpleForm);
        hStack.addMember(greenPawn);

        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(10);
        vLayout.addMember(hStack);
        vLayout.addMember(focusLabel);

        return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    private void changeLabel(Label label, String id, boolean hasFocus) {
    	if (hasFocus)
    		label.setContents(id + " has focus");
        else
        	label.setContents("");
    }
}