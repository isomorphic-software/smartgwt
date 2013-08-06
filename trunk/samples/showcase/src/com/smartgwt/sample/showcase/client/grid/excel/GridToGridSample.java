package com.smartgwt.sample.showcase.client.grid.excel;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.TextImportSettings;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.types.EscapingMode;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.CellSelection;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class GridToGridSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Each tab below holds one data grid component." +
        " Drag to select cells within the grid, then use the <b>Copy</b> button to copy that data" +
        " to the clipboard.  Click the <b>Paste</b>  button below any grid to paste the copied data" +
        " into that grid.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridToGridSample panel = new GridToGridSample();
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

    private GridClipboard board;

    public class GridCanvas extends VLayout {

        final private int GRID_N_ROWS = 10;
        
        final private String[] GRID_FIELD_NAMES = { "A", "B", "C", "D", "E", "F", "G" };

        private ListGrid grid;

        public class CopyButton extends IButton implements ClickHandler {

            public CopyButton(String title) {
                super(title);
                this.addClickHandler(this);
            }        
            public void onClick(ClickEvent event) {
                board.data = grid.getSelectedCellData();
            }
        }

        public class PasteButton extends IButton implements ClickHandler {

            public PasteButton(String title) {
                super(title);
                this.addClickHandler(this);
            }        
            public void onClick(ClickEvent event) {
                grid.applyCellData(board.data);
            }
        }

        public void installInitialValues(Record[] records) {
            Map<String, String> map;
            map = new HashMap();
            map.put(GRID_FIELD_NAMES[1], "text1");
            map.put(GRID_FIELD_NAMES[4], "text2");
            records[2] = new Record(map);

            map = new HashMap();
            map.put(GRID_FIELD_NAMES[2], "text3");
            records[4] = new Record(map);
            
            map = new HashMap();
            map.put(GRID_FIELD_NAMES[6], "text4");
            records[7] = new Record(map);

            map = new HashMap();
            map.put(GRID_FIELD_NAMES[0], "text5");
            map.put(GRID_FIELD_NAMES[5], "text6");
            records[5] = new Record(map);
        }

        public void addListGrid(int index) {
            List<ListGridField> fields = new ArrayList<ListGridField>();

            for(int i = 0; i < GRID_FIELD_NAMES.length; i++ ) {
                fields.add(new ListGridField(GRID_FIELD_NAMES[i]));
            }

            ListGrid grid = new ListGrid();
            grid.setHeight(250);
            grid.setCanEdit(true);
            grid.setCanSelectAll(true);
            grid.setCanDragSelect(true);
            grid.setCanSelectCells(true);
            grid.setLeaveScrollbarGap(false);

            grid.setFields(fields.toArray(new ListGridField[0]));

            Record[] records = new Record[GRID_N_ROWS];
            for (int i = 0; i < GRID_N_ROWS; i++) {
                records[i] = new Record();
            }
            if (0 == index) {
                installInitialValues(records);
            }
            grid.setData(records);

            this.addMember(grid);
            this.grid = grid;
        }

        public void addButtons(int index) {

            final Alignment[] MEMBER_ALIGNMENT = { Alignment.LEFT, 
                                                   Alignment.CENTER, 
                                                   Alignment.RIGHT };

            HLayout layout = new HLayout();
            CopyButton copy = new CopyButton("Copy");
            PasteButton paste = new PasteButton("Paste");
            
            layout.addMember(copy);
            layout.addMember(paste);
            layout.setAlign(MEMBER_ALIGNMENT[index]);
            layout.setHeight(25);
            this.addMember(layout);
        }

        public GridCanvas(int index) {
            super(10);
            this.addListGrid(index);
            this.addButtons(index);
        }
    }

    public class GridClipboard extends TabSet {
        RecordList data;
    };

    public Canvas getViewPanel() {
        this.board = new GridClipboard();

        for (int i = 0; i < 3; i++ ) {
            Tab myTab = new Tab("Sheet " + (i + 1));
            GridCanvas canvas = new GridCanvas(i);
            canvas.setOverflow(Overflow.VISIBLE);
            myTab.setPane(canvas);
            board.addTab(myTab);
        }
        this.board.setHeight(325);
        return board;
    }

   public String getIntro() {
        return DESCRIPTION;
    }
};

