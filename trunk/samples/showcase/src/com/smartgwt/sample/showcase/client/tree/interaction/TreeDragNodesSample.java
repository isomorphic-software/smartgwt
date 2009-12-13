package com.smartgwt.sample.showcase.client.tree.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TreeDragNodesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Drag and drop to move parts and folders within and between the trees. "
            + "You can open a closed folder by pausing over it during a drag interaction (aka \"spring loaded folders\").</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            TreeDragNodesSample panel = new TreeDragNodesSample();
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

        Tree grid1Tree = new Tree();
        grid1Tree.setModelType(TreeModelType.CHILDREN);
        grid1Tree.setNameProperty("Name");
        grid1Tree.setRoot(new PartsTreeNode("Root",
                new PartsTreeNode("Bin 1",
                        new PartsTreeNode("Blue Cube", "cube_blue.png"),
                        new PartsTreeNode("Yellow Cube", "cube_yellow.png"),
                        new PartsTreeNode("Green Cube", "cube_green.png")
                ),
                new PartsTreeNode("Bin 2",
                        new PartsTreeNode("Blue Piece", "pawn_blue.png"),
                        new PartsTreeNode("Green Piece", "pawn_green.png"),
                        new PartsTreeNode("Yellow Piece", "pawn_yellow.png")
                )
        ));

        final PartsTreeGrid grid1 = new PartsTreeGrid();
        grid1.setDragDataAction(DragDataAction.MOVE);
        grid1.setData(grid1Tree);
        grid1.getData().openAll();

        Tree grid2Tree = new Tree();
        grid2Tree.setModelType(TreeModelType.CHILDREN);
        grid2Tree.setNameProperty("Name");
        grid2Tree.setRoot(new PartsTreeNode("Root",
                new PartsTreeNode("Bin 3",
                        new PartsTreeNode("Blue Part", "piece_blue.png"),
                        new PartsTreeNode("Green Part", "piece_green.png"),
                        new PartsTreeNode("Yellow Part", "piece_yellow.png")
                )
        ));

        final PartsTreeGrid grid2 = new PartsTreeGrid();
        grid2.setLeft(250);
        grid2.setData(grid2Tree);
        grid2.getData().openAll();

        VStack moveControls = new VStack(10);
        moveControls.setWidth(32);
        moveControls.setHeight(74);
        moveControls.setLayoutAlign(Alignment.CENTER);

        TransferImgButton rightArrow = new TransferImgButton(TransferImgButton.RIGHT, new ClickHandler() {
            public void onClick(ClickEvent event) {
                grid2.transferSelectedData(grid1);
            }
        });
        moveControls.addMember(rightArrow);

        TransferImgButton leftArrow = new TransferImgButton(TransferImgButton.LEFT, new ClickHandler() {
            public void onClick(ClickEvent event) {
                grid1.transferSelectedData(grid2);
            }
        });
        moveControls.addMember(leftArrow);

        HStack grids = new HStack(10);
        grids.setHeight(160);
        grids.addMember(grid1);
        grids.addMember(moveControls);
        grids.addMember(grid2);

        return grids;
    }

    public static class PartsTreeGrid extends TreeGrid {
        public PartsTreeGrid() {
            setWidth(200);
            setHeight(200);
            setShowEdges(true);
            setBorder("0px");
            setBodyStyleName("normal");
            setShowHeader(false);
            setLeaveScrollbarGap(false);
            setEmptyMessage("<br>Drag &amp; drop parts here");
            setManyItemsImage("cubes_all.png");
            setAppImgDir("pieces/16/");
            setCanReorderRecords(true);
            setCanAcceptDroppedRecords(true);
            setCanDragRecordsOut(true);
        }
    }

    public static class PartsTreeNode extends TreeNode {
        public PartsTreeNode(String name, String icon) {
            this(name, icon, new PartsTreeNode[]{});
        }

        public PartsTreeNode(String name, PartsTreeNode... children) {
            this(name, null, children);
        }

        public PartsTreeNode(String name, String icon, PartsTreeNode... children) {
            setAttribute("Name", name);
            setAttribute("children", children);
            if (icon != null)
                setAttribute("icon", icon);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}