package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import java.util.LinkedHashMap;

public class DragSnapToGridSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag the box around the grid. It will snap into alignment according to the values "+
    "set in the radio buttons below. Snap-to-grid dragging can be enabled separately for moving and resizing. Toggle the checkboxes "+
    "to see this working.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DragSnapToGridSample panel = new DragSnapToGridSample();
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
        final Canvas gridCanvas = new Canvas();
		gridCanvas.setBorder("1px solid blue");
		gridCanvas.setWidth(400);
		gridCanvas.setHeight(300);
		gridCanvas.setChildrenSnapResizeToGrid(true);
		gridCanvas.setChildrenSnapToGrid(true);
		gridCanvas.setOverflow(Overflow.HIDDEN);
		gridCanvas.setShowSnapGrid(true);
		
		Label label = new Label();
		label.setWidth(80);
		label.setHeight(40);
		label.setAlign(Alignment.CENTER);
		label.setContents("Drag or Resize me");
		label.setBackgroundColor("white");
		label.setShowEdges(true);
		label.setCanDragReposition(true);
		label.setCanDragResize(true);
		label.setDragAppearance(DragAppearance.TARGET);
		label.setKeepInParentRect(true);
		
		gridCanvas.addChild(label);
		
		DynamicForm gridForm = new DynamicForm();
		gridForm.setWidth(400);
		gridForm.setNumCols(4);
		
		CheckboxItem snapDrag = new CheckboxItem();
		snapDrag.setValue(true);
		snapDrag.setTitle("Enable Snap-To-Grid Move");
		snapDrag.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				gridCanvas.setProperty("childrenSnapToGrid", !gridCanvas.getChildrenSnapToGrid());
			}
			
		});
		CheckboxItem snapResize = new CheckboxItem();
		snapResize.setValue(true);
		snapResize.setTitle("Enable Snap To Grid Resize");
		snapResize.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				gridCanvas.setProperty("childrenSnapResizeToGrid", !gridCanvas.getChildrenSnapResizeToGrid());
			}
			
		});

		RadioGroupItem radioGroupHGap = new RadioGroupItem();
		radioGroupHGap.setTitle("Horizontal snap-to gap");
		LinkedHashMap<Integer,String> hGapMap = new LinkedHashMap<Integer,String>();
		hGapMap.put(10, "10 pixels");
		hGapMap.put(20, "20 pixels");
		hGapMap.put(50, "50 pixels");
		radioGroupHGap.setValueMap(hGapMap);
		radioGroupHGap.setDefaultValue(20);
		radioGroupHGap.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				gridCanvas.setProperty("snapHGap", Integer.parseInt(String.valueOf(event.getValue())));
			}
			
		});
		RadioGroupItem radioGroupVGap = new RadioGroupItem();
		radioGroupVGap.setTitle("Vertical snap-to gap");
		LinkedHashMap<Integer,String> vGapMap = new LinkedHashMap<Integer,String>();
		vGapMap.put(10, "10 pixels");
		vGapMap.put(20, "20 pixels");
		vGapMap.put(50, "50 pixels");
		radioGroupVGap.setValueMap(vGapMap);
		radioGroupVGap.setDefaultValue(20);
		radioGroupVGap.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				gridCanvas.setProperty("snapVGap", Integer.parseInt(String.valueOf(event.getValue())));
			}
			
		});
		gridForm.setFields(snapDrag,snapResize,radioGroupHGap,radioGroupVGap);
		
		VLayout vl = new VLayout();
		vl.setMembersMargin(10);
		vl.addMember(gridCanvas);
		vl.addMember(gridForm);

        return vl;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
