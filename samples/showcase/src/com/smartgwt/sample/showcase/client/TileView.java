package com.smartgwt.sample.showcase.client;

import com.google.gwt.user.client.History;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.IconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.IconClickHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.RecordClickEvent;
import com.smartgwt.client.widgets.tile.events.RecordClickHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.viewer.DetailFormatter;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.sample.showcase.client.data.CommandTreeNode;
import com.smartgwt.sample.showcase.client.data.ExplorerTreeNode;
import com.smartgwt.sample.showcase.client.data.ShowcaseData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TileView extends VLayout {
    private TileGrid tileGrid;
    private String idSuffix = "_tileView";
    private TreeNode[] showcaseData = ShowcaseData.getData(idSuffix);
    private Canvas parentPanel;
    private SliderItem numSamplesItem;
    private DynamicForm filterForm;

    private CheckboxItem featuredCB;
    private CheckboxItem newSamplesCB;
    private CheckboxItem comboBoxCB;
    private CheckboxItem gridsCB;
    private CheckboxItem treeCB;
    private CheckboxItem calendarCB;
    private CheckboxItem tilesCB;
    private CheckboxItem formsCB;
    private CheckboxItem layoutCB;
    private CheckboxItem windowsCB;
    private CheckboxItem tabsCB;
    private CheckboxItem accordionCB;
    private CheckboxItem portalLayoutCB;
    private CheckboxItem buttonsCB;
    private CheckboxItem menusCB;
    private CheckboxItem toolStripCB;
    private CheckboxItem otherControlsCB;
    private CheckboxItem dataIntegrationCB;
    private CheckboxItem dragDropCB;
    private CheckboxItem basicsCB;
    private CheckboxItem drawingCB;
    private CheckboxItem effectsCB;
    private CheckboxItem ascendingItem;
    private CheckboxItem disabledModeCB;
    private TextItem searchItem;

    private Tree tree;


    public TileView(Canvas parentPanel) {
        setMargin(3);
        tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setNameProperty("name");
        tree.setOpenProperty("isOpen");
        tree.setIdField("nodeID");
        tree.setParentIdField("parentNodeID");

        tree.setRootValue("root" + idSuffix);

        tree.setData(showcaseData);

        this.parentPanel = parentPanel;
        setMembersMargin(10);

        setWidth100();

        tileGrid = new TileGrid();
        tileGrid.setShowEdges(true);
        tileGrid.setTileWidth(140);
        tileGrid.setTileHeight(120);
        tileGrid.setWidth100();
        tileGrid.setHeight100();
        tileGrid.setShowAllRecords(true);

        tileGrid.setAutoFetchData(false);
        tileGrid.setAnimateTileChange(true);

        DetailViewerField nameField = new DetailViewerField("nodeTitle");
        nameField.setDetailFormatter(new DetailFormatter() {
            public String format(Object value, Record record, DetailViewerField field) {
                return value.toString();
            }
        });
        nameField.setCellStyle("thumbnailTitle");
        
        DetailViewerField iconField = new DetailViewerField("thumbnail");
        iconField.setType("image");
        iconField.setImageHeight(89);
        iconField.setImageWidth(119);
        iconField.setCellStyle("thumbnail");


        tileGrid.setFields(iconField, nameField);


        tileGrid.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
                Record record = event.getRecord();
                showSample(record);
            }
        });

        filterForm = new DynamicForm();
        filterForm.setBorder("1px solid #9C9C9C");
        filterForm.setNumCols(8);
        filterForm.setColWidths(16, "*", 16, "*", 16, "*", 16, "*");
        filterForm.setAutoFocus(false);
        filterForm.setPadding(5);

        addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent event) {
                updateTiles();

            }
        });

        searchItem = new TextItem("description", "Search");
        searchItem.setTitleOrientation(TitleOrientation.TOP);
        searchItem.setColSpan(2);
        searchItem.setTitleAlign(Alignment.LEFT);
        searchItem.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if("enter".equalsIgnoreCase(event.getKeyName())) {
                    updateTiles();
                }
            }
        });
        final PickerIcon findIcon = new PickerIcon(PickerIcon.SEARCH);
        final PickerIcon cancelIcon = new PickerIcon(PickerIcon.CLEAR);
        searchItem.setIcons(findIcon, cancelIcon);

        searchItem.addIconClickHandler(new IconClickHandler() {
            public void onIconClick(IconClickEvent event) {
                FormItemIcon icon = event.getIcon();
                if(icon.getSrc().equals(cancelIcon.getSrc())) {
                    filterForm.reset();
                    featuredCB.setValue(true);
                }
                updateTiles();
            }
        });

        numSamplesItem = new SliderItem("numSamples");
        numSamplesItem.setTitle("# of Samples");
        numSamplesItem.setTitleOrientation(TitleOrientation.TOP);
        numSamplesItem.setColSpan(2);
        numSamplesItem.setTitleAlign(Alignment.LEFT);
        numSamplesItem.setMinValue(1);
        // grep '^ *new ExplorerTreeNode' ShowcaseData.java | grep -o 'new [^.,]*\.Factory()' | sort | uniq | wc
        numSamplesItem.setMaxValue(308);
        numSamplesItem.setDefaultValue(100);
        numSamplesItem.setHeight(50);
        numSamplesItem.setOperator(OperatorId.LESS_THAN);
        
        featuredCB = new CheckboxItem("featuredCB", "Featured Samples");
        featuredCB.setValue(true);

        newSamplesCB = new CheckboxItem("newSamplesCB", "New Samples");
        comboBoxCB = new CheckboxItem("comboBoxCB", "ComboBox &amp; Family");
        gridsCB = new CheckboxItem("gridsCB", "Grids");
        treeCB = new CheckboxItem("treeCB", "Tree");
        calendarCB = new CheckboxItem("calendarCB", "Calendar");
        tilesCB = new CheckboxItem("tilesCB", "Data View / Tiling");
        formsCB = new CheckboxItem("formsCB", "Forms");
        layoutCB = new CheckboxItem("layoutCB", "Layouts");
        windowsCB = new CheckboxItem("windowsCB", "Windows");
        tabsCB = new CheckboxItem("tabsCB", "Tabs");
        accordionCB = new CheckboxItem("accordionCB", "Accordion / Sections");
        portalLayoutCB = new CheckboxItem("portalLayoutCB", "Portal Layout");
        buttonsCB = new CheckboxItem("buttonsCB", "Buttons");
        menusCB = new CheckboxItem("menusCB", "Menus");
        toolStripCB = new CheckboxItem("toolStripCB", "ToolStrip");
        otherControlsCB = new CheckboxItem("otherControlsCB", "Other Controls");
        dataIntegrationCB = new CheckboxItem("dataIntegrationCB", "Data Integration");
        dragDropCB = new CheckboxItem("dragDropCB", "Drag &amp; Drop");
        basicsCB = new CheckboxItem("basicsCB", "Basics");
        drawingCB = new CheckboxItem("drawingCB", "Drawing");
        effectsCB = new CheckboxItem("effectsCB", "Effects &amp; Animation");

        ascendingItem = new CheckboxItem("chkSortDir");
        ascendingItem.setTitle("Ascending");

        disabledModeCB = new CheckboxItem("disabledModeCB", "Disabled Mode");



        filterForm.setFields(searchItem, numSamplesItem, ascendingItem, disabledModeCB, 
            featuredCB, newSamplesCB, comboBoxCB, gridsCB, treeCB, calendarCB, tilesCB,
            formsCB, layoutCB, windowsCB, tabsCB, accordionCB, portalLayoutCB, buttonsCB, menusCB,
            toolStripCB, otherControlsCB, dataIntegrationCB, dragDropCB, basicsCB, drawingCB,
            effectsCB);

        filterForm.addItemChangedHandler(new ItemChangedHandler() {
            public void onItemChanged(ItemChangedEvent event) {
                FormItem item = event.getItem();
                if (item instanceof CheckboxItem || item instanceof SliderItem) {
                    updateTiles();
                }
            }
        });

        addMember(filterForm);

        addMember(tileGrid);

    }

    private void updateTiles() {
        String searchText = (String) searchItem.getValue();

        List<String> categories = new ArrayList<String>();
        if (featuredCB.getValueAsBoolean()) categories.add("featured_category");
        if (newSamplesCB.getValueAsBoolean()) categories.add("new_category");
        if (comboBoxCB.getValueAsBoolean()) categories.add("combobox_category");
        if (gridsCB.getValueAsBoolean()) categories.add("grid_category");
        if (treeCB.getValueAsBoolean()) categories.add("tree_category");
        if (calendarCB.getValueAsBoolean()) categories.add("calendar_category");
        if (tilesCB.getValueAsBoolean()) categories.add("tiling_category");
        if (formsCB.getValueAsBoolean()) categories.add("form_category");
        if (layoutCB.getValueAsBoolean()) categories.add("layout_category");
        if (windowsCB.getValueAsBoolean()) categories.add("layout_windows_category");
        if (tabsCB.getValueAsBoolean()) categories.add("layout_tabs_category");
        if (accordionCB.getValueAsBoolean()) categories.add("layout_sections_category");
        if (portalLayoutCB.getValueAsBoolean()) categories.add("layout_portal_category");
        if (buttonsCB.getValueAsBoolean()) categories.add("buttons_category");
        if (menusCB.getValueAsBoolean()) categories.add("menus_category");
        if (toolStripCB.getValueAsBoolean()) categories.add("toolstrip_category");
        if (otherControlsCB.getValueAsBoolean()) categories.add("controls_category");
        if (dataIntegrationCB.getValueAsBoolean()) categories.add("data_integration_category");
        if (dragDropCB.getValueAsBoolean()) categories.add("effects_dd_category");
        if (basicsCB.getValueAsBoolean()) categories.add("basics_category");
        if (drawingCB.getValueAsBoolean()) categories.add("drawing");
        if (effectsCB.getValueAsBoolean()) categories.add("effects_category");


        showTiles(searchText, categories);

        Boolean sortDir = ascendingItem.getValueAsBoolean();
        tileGrid.sortByProperty("name", sortDir);
    }

    private void showSample(Record node) {

        boolean isExplorerTreeNode = node instanceof ExplorerTreeNode;
        if (node instanceof CommandTreeNode) {
            CommandTreeNode commandTreeNode = (CommandTreeNode) node;
            commandTreeNode.getCommand().execute();
        } else if (isExplorerTreeNode) {
            ExplorerTreeNode explorerTreeNode = (ExplorerTreeNode) node;
            PanelFactory factory = explorerTreeNode.getFactory();
            if (factory != null) {

                Canvas panel = factory.create();
                panel.setDisabled(disabledModeCB.getValueAsBoolean());
                
                String sampleName = explorerTreeNode.getName();

                String icon = explorerTreeNode.getIcon();
                if (icon == null) {
                    icon = "silk/plugin.png";
                }

                final Window window = new Window();
                window.setKeepInParentRect(true);
                window.setHeaderIcon(icon, 16, 16);
                window.setTitle(sampleName);
                window.setWidth100();
                window.setHeight100();
                window.setShowMinimizeButton(false);
                window.setShowCloseButton(true);
                window.setCanDragReposition(false);
                window.setCanDragResize(false);
                window.setShowShadow(false);
                window.addItem(panel);
                window.setParentElement(parentPanel);
                String nodeID = explorerTreeNode.getNodeID();
                String historyToken = nodeID.substring(0, nodeID.indexOf(idSuffix));
                History.newItem(historyToken, false);
                window.addCloseClickHandler(new CloseClickHandler() {
                    public void onCloseClick(CloseClickEvent event) {
                        History.newItem("", false);
                        window.destroy();
                    }
                });
                window.show();
            }
        }
    }


    private void showTiles(String searchText, List<String> categories) {


        Set data = new HashSet();

        int maxResults = ((Number)numSamplesItem.getValue()).intValue();

        if(searchText != null) {
            TreeNode[] children = tree.getAllNodes();
            applyFilter(tree, children, data, searchText, maxResults, true);
        } else {
            for (String category : categories) {
                TreeNode categoryNode = tree.find("nodeID", category + idSuffix);
                TreeNode[] children = tree.getChildren(categoryNode);

                applyFilter(tree, children, data, searchText, maxResults, false);
            }
        }
        tileGrid.setData((Record[]) data.toArray(new Record[data.size()]));
    }

    private void applyFilter(Tree tree, TreeNode[] children, Set data, String searchText,int maxResults, boolean skipCategories) {
        for (int i = 0; i < children.length; i++) {
            if(data.size() == maxResults) return;
            TreeNode child = children[i];
            if (!tree.hasChildren(child)) {
                if (searchText != null) {
                    searchText = searchText.toLowerCase();
                    boolean isExplorerTreeNode = child instanceof ExplorerTreeNode;
                    if (isExplorerTreeNode) {
                        ExplorerTreeNode explorerTreeNode = (ExplorerTreeNode) child;
                        //when searching through all nodes, skip the featured section to avoid duplicates
                        if(explorerTreeNode.getNodeID().contains("featured")) continue;
                        if (explorerTreeNode.getName().toLowerCase().contains(searchText)) {
                            data.add(child);
                        } else {
                            PanelFactory factory = explorerTreeNode.getFactory();
                            if (factory != null) {
                                String description = factory.getDescription();
                                if (description != null && description.toLowerCase().contains(searchText)) {
                                    data.add(child);
                                }
                            }
                        }
                    }
                } else {
                    data.add(child);
                }
            } else if(!skipCategories) {
                //skip categories when searching all nodes so that duplicates that exist in featured section and category are
                //both not included
                applyFilter(tree, tree.getChildren(child), data, searchText, maxResults, skipCategories);
            }
        }
    }
}
