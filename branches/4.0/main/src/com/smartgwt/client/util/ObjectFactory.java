
package com.smartgwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.core.DataClass;

/**
 * This object contains mappings between the Smartclient object types and SmartGWT class types.
 */
public final class ObjectFactory {

    /* No need to create instances of this class. */
    private ObjectFactory(){}

    /**
     * This method will create a SmartGWT class from the javaScriptObject and smartClientClassName
     *  provided. It is possible that null will be returned.
     *
     * @return
     */
    public native static final <T extends com.smartgwt.client.widgets.BaseWidget> T createCanvas(String smartClientClassName, JavaScriptObject javaScriptObject) /*-{
        var instance = null;
		if ("ImgTab" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.tab.ImgTab::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SplitPane" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.SplitPane::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("MultiFilePicker" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.MultiFilePicker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Label" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Label::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Portlet" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.Portlet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("RibbonBar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.toolbar.RibbonBar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("PortalLayout" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.PortalLayout::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Splitbar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Splitbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("EdgedCanvas" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.EdgedCanvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ListGrid" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.grid.ListGrid::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("CubeGrid" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.cube.CubeGrid::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ToolStripResizer" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.toolbar.ToolStripResizer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Window" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Window::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("RangeSlider" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.RangeSlider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("StatefulCanvas" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.StatefulCanvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("NavigationButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.NavigationButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Applet" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.plugins.Applet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TableView" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.tableview.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("IconButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.IconButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ColorPicker" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.form.ColorPicker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("PrintWindow" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.PrintWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DateChooser" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.DateChooser::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("PropertySheet" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.form.PropertySheet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TreeMenuButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.menu.TreeMenuButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DateGrid" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.grid.DateGrid::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ImgButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.ImgButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ToolStripButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.toolbar.ToolStripButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("HiliteRule" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.grid.HiliteRule::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DateRangeDialog" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.DateRangeDialog::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Canvas" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SVG" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.plugins.SVG::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("MenuBar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.menu.MenuBar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Scrollbar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Scrollbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("BatchUploader" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.BatchUploader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TileLayout" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.tile.TileLayout::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Slider" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Slider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Progressbar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Progressbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DetailViewer" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.viewer.DetailViewer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("FilterClause" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.form.FilterClause::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Flashlet" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.plugins.Flashlet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SectionHeader" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.SectionHeader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ToolStrip" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.toolbar.ToolStrip::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("RibbonGroup" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.toolbar.RibbonGroup::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ViewLoader" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.ViewLoader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("MultiGroupDialog" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.MultiGroupDialog::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("FlowLayout" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.FlowLayout::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Gauge" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.drawing.Gauge::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("AdvancedHiliteEditor" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.grid.AdvancedHiliteEditor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Button" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Calendar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.calendar.Calendar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Snapbar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Snapbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DrawPane" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.drawing.DrawPane::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("FilterBuilder" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.form.FilterBuilder::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ImgSplitbar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.ImgSplitbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("LayoutSpacer" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.LayoutSpacer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SimpleTile" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.tile.SimpleTile::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("HTMLFlow" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.HTMLFlow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("HStack" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.HStack::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TileGrid" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.tile.TileGrid::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("IconMenuButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.menu.IconMenuButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ColumnTree" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.grid.ColumnTree::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ActiveXControl" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.plugins.ActiveXControl::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("NavigationBar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.NavigationBar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("HLayout" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.HLayout::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("FacetChart" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.chart.FacetChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ToolStripSeparator" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.toolbar.ToolStripSeparator::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("StretchImgButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.StretchImgButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ToolStripGroup" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.toolbar.ToolStripGroup::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ToolStripMenuButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.toolbar.ToolStripMenuButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("RichTextEditor" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.RichTextEditor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TreeGrid" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.tree.TreeGrid::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TabSet" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.tab.TabSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("EventWindow" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.calendar.EventWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("VLayout" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.VLayout::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DynamicForm" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.form.DynamicForm::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Menu" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.menu.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("MenuButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.menu.MenuButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("BrowserPlugin" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.plugins.BrowserPlugin::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("HTMLPane" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.HTMLPane::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Img" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Img::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TabBar" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.tab.TabBar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Dialog" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.Dialog::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Timeline" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.calendar.Timeline::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("PrintCanvas" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.PrintCanvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("Layout" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.Layout::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SearchForm" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.form.SearchForm::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("VStack" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.VStack::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("HiliteEditor" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.grid.HiliteEditor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("StretchImg" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.StretchImg::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SectionStack" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.SectionStack::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("FieldPickerWindow" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.FieldPickerWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ImgSectionHeader" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.layout.ImgSectionHeader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("IMenuButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.menu.IMenuButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("IButton" === smartClientClassName ){
			instance = @com.smartgwt.client.widgets.IButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 
        if ($wnd.isc.isA.Canvas(javaScriptObject)) {
            instance = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        }

		return instance;
    }-*/;

	/**
     * This method will create a SmartGWT class from the javaScriptObject and smartClientClassName
     *  provided. It is possible that null will be returned.
     *
     * @return
     */
    public native static final <T extends com.smartgwt.client.core.RefDataClass> T createFormItem(String smartClientClassName, JavaScriptObject javaScriptObject) /*-{
        var type = null;
		if ("ToolbarItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.ToolbarItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DateTimeItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.DateTimeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DoubleItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.DoubleItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SectionItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.SectionItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("HiddenItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.HiddenItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("BlurbItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.BlurbItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("PickTreeItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.PickTreeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ViewFileItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.ViewFileItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("AutoFitTextAreaItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("RowSpacerItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.RowSpacerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("MultiComboBoxItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.MultiComboBoxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("CanvasItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.CanvasItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("HeaderItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.HeaderItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DateRangeItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.DateRangeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TextItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.TextItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("PasswordItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.PasswordItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("StaticTextItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.StaticTextItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ComboBoxItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.ComboBoxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SubmitItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.SubmitItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SelectItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.SelectItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SpacerItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.SpacerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("RelativeDateItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.RelativeDateItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("LinkItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.LinkItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TimeItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.TimeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("MiniDateRangeItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.MiniDateRangeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("UploadItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.UploadItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("NativeCheckboxItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.NativeCheckboxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("IPickTreeItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.IPickTreeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SelectOtherItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.SelectOtherItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("DateItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.DateItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SpinnerItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.SpinnerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ButtonItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.ButtonItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("ResetItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.ResetItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("CheckboxItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.CheckboxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("RichTextItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.RichTextItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("SliderItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.SliderItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 		if ("TextAreaItem" === smartClientClassName ){
			type = @com.smartgwt.client.widgets.form.fields.TextAreaItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
		} else 
        if ($wnd.isc.isA.FormItem(javaScriptObject)) {
            type = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        }

		return type;
    }-*/;

    public static native DataClass createInstance(String smartClientClassName, JavaScriptObject javaScriptObject) /*-{
        var instance = null;
        if ("XJSONDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.XJSONDataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("LinearGradient" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.LinearGradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ValuesManager" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.form.ValuesManager::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AdvancedCriteria" === smartClientClassName) {
            instance = @com.smartgwt.client.data.AdvancedCriteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.data.TextSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ServerObject" === smartClientClassName) {
            instance = @com.smartgwt.client.docs.serverds.ServerObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Process" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.Process::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ServiceTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ServiceTask::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormItemIcon" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.form.fields.FormItemIcon::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FacetValue" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.cube.FacetValue::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextExportSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.data.TextExportSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FacetValueMap" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.cube.FacetValueMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DecisionGateway" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.DecisionGateway::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("OperationBinding" === smartClientClassName) {
            instance = @com.smartgwt.client.data.OperationBinding::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ColorStop" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.ColorStop::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ProcessSequence" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ProcessSequence::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HeaderLevel" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.calendar.HeaderLevel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DetailViewerField" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.viewer.DetailViewerField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSRequest" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Facet" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.cube.Facet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ScriptTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ScriptTask::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawLinePath" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawLinePath::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TileRecord" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tile.TileRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CellSelection" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.grid.CellSelection::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Tree" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.Tree::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ResultTree" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.ResultTree::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ImgProperties" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ImgProperties::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("XORGateway" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.XORGateway::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ListGridRecord" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RadialGradient" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.RadialGradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Validator" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.form.validator.Validator::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Point" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.Point::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UserFormula" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.UserFormula::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Task" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.Task::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Hilite" === smartClientClassName) {
            instance = @com.smartgwt.client.data.Hilite::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UserTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.UserTask::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SectionStackSection" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.layout.SectionStackSection::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HeaderSpan" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.grid.HeaderSpan::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PrintProperties" === smartClientClassName) {
            instance = @com.smartgwt.client.util.PrintProperties::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSResponse" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TreeGridField" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.TreeGridField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GaugeSector" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.GaugeSector::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawnValue" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.chart.DrawnValue::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MetricSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.chart.MetricSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CellRecord" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.cube.CellRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CalendarEvent" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.calendar.CalendarEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("JSONEncoder" === smartClientClassName) {
            instance = @com.smartgwt.client.util.JSONEncoder::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DetailViewerRecord" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.viewer.DetailViewerRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SimpleGradient" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.SimpleGradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TreeNode" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SimpleType" === smartClientClassName) {
            instance = @com.smartgwt.client.data.SimpleType::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StateTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.StateTask::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Lane" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.calendar.Lane::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("WSDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.WSDataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Gradient" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.Gradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Tab" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tab.Tab::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Criterion" === smartClientClassName) {
            instance = @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Shadow" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.Shadow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StretchItem" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.StretchItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSRequestModifier" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DSRequestModifier::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RPCResponse" === smartClientClassName) {
            instance = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawItem" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormItem" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RestDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.RestDataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GroupSummary" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.grid.GroupSummary::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DataSourceField" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DataSourceField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextImportSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.data.TextImportSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RPCRequest" === smartClientClassName) {
            instance = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ListGridField" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.grid.ListGridField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MenuItem" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.menu.MenuItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ProcessElement" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ProcessElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FiscalCalendar" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.FiscalCalendar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UserSummary" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.UserSummary::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FiscalYear" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.FiscalYear::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else 
        if ($wnd.isc.isAn.Instance(javaScriptObject)) {
            instance = @com.smartgwt.client.core.DataClass::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        }

        return instance;
    }-*/;

    /**
     * The SmartClient class name used to lookup the corresponding SmartGWT class, which is then returned. Because
     *  this method is generic you can return whatever type you'are expecting. So it is completely appropriate to do
     *  the following, as no casting is necessary.
     *<code><pre>
     * Button myButton = ObjectRegistry.getSmartGWTClass("Button");
     *</pre><code>
     *
     * @param smartClientClassName
     * @return SmartGWT class or null
     */
    public native static final String getSmartGWTClassFQN(String smartClientClassName) /*-{
    	if("ImgTab"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tab.ImgTab";
		} else     	if("SplitPane"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.SplitPane";
		} else     	if("MultiFilePicker"===smartClientClassName) {
			return "com.smartgwt.client.widgets.MultiFilePicker";
		} else     	if("Label"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Label";
		} else     	if("Portlet"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.Portlet";
		} else     	if("RibbonBar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.RibbonBar";
		} else     	if("PortalLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.PortalLayout";
		} else     	if("Splitbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Splitbar";
		} else     	if("ToolbarItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ToolbarItem";
		} else     	if("DateTimeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.DateTimeItem";
		} else     	if("DoubleItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.DoubleItem";
		} else     	if("EdgedCanvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.EdgedCanvas";
		} else     	if("SectionItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SectionItem";
		} else     	if("HiddenItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.HiddenItem";
		} else     	if("ListGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.ListGrid";
		} else     	if("CubeGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.cube.CubeGrid";
		} else     	if("ToolStripResizer"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripResizer";
		} else     	if("Window"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Window";
		} else     	if("BlurbItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.BlurbItem";
		} else     	if("RangeSlider"===smartClientClassName) {
			return "com.smartgwt.client.widgets.RangeSlider";
		} else     	if("StatefulCanvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.StatefulCanvas";
		} else     	if("NavigationButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.NavigationButton";
		} else     	if("Applet"===smartClientClassName) {
			return "com.smartgwt.client.widgets.plugins.Applet";
		} else     	if("TableView"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tableview.TableView";
		} else     	if("IconButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.IconButton";
		} else     	if("ColorPicker"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.ColorPicker";
		} else     	if("PrintWindow"===smartClientClassName) {
			return "com.smartgwt.client.widgets.PrintWindow";
		} else     	if("PickTreeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.PickTreeItem";
		} else     	if("DateChooser"===smartClientClassName) {
			return "com.smartgwt.client.widgets.DateChooser";
		} else     	if("PropertySheet"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.PropertySheet";
		} else     	if("TreeMenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.TreeMenuButton";
		} else     	if("ViewFileItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ViewFileItem";
		} else     	if("DateGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.DateGrid";
		} else     	if("AutoFitTextAreaItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem";
		} else     	if("ImgButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.ImgButton";
		} else     	if("ToolStripButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripButton";
		} else     	if("HiliteRule"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.HiliteRule";
		} else     	if("DateRangeDialog"===smartClientClassName) {
			return "com.smartgwt.client.widgets.DateRangeDialog";
		} else     	if("FileItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.FileItem";
		} else     	if("Canvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Canvas";
		} else     	if("SVG"===smartClientClassName) {
			return "com.smartgwt.client.widgets.plugins.SVG";
		} else     	if("RowSpacerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.RowSpacerItem";
		} else     	if("MultiComboBoxItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.MultiComboBoxItem";
		} else     	if("CanvasItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.CanvasItem";
		} else     	if("HeaderItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.HeaderItem";
		} else     	if("MenuBar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.MenuBar";
		} else     	if("Scrollbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Scrollbar";
		} else     	if("BatchUploader"===smartClientClassName) {
			return "com.smartgwt.client.widgets.BatchUploader";
		} else     	if("DateRangeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.DateRangeItem";
		} else     	if("TileLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tile.TileLayout";
		} else     	if("Slider"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Slider";
		} else     	if("Progressbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Progressbar";
		} else     	if("TextItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.TextItem";
		} else     	if("DetailViewer"===smartClientClassName) {
			return "com.smartgwt.client.widgets.viewer.DetailViewer";
		} else     	if("FilterClause"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.FilterClause";
		} else     	if("Flashlet"===smartClientClassName) {
			return "com.smartgwt.client.widgets.plugins.Flashlet";
		} else     	if("SectionHeader"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.SectionHeader";
		} else     	if("ToolStrip"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStrip";
		} else     	if("RibbonGroup"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.RibbonGroup";
		} else     	if("ViewLoader"===smartClientClassName) {
			return "com.smartgwt.client.widgets.ViewLoader";
		} else     	if("PasswordItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.PasswordItem";
		} else     	if("StaticTextItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.StaticTextItem";
		} else     	if("MultiGroupDialog"===smartClientClassName) {
			return "com.smartgwt.client.widgets.MultiGroupDialog";
		} else     	if("FlowLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.FlowLayout";
		} else     	if("Gauge"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.Gauge";
		} else     	if("AdvancedHiliteEditor"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.AdvancedHiliteEditor";
		} else     	if("Button"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Button";
		} else     	if("Calendar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.Calendar";
		} else     	if("Snapbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Snapbar";
		} else     	if("DrawPane"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawPane";
		} else     	if("FilterBuilder"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.FilterBuilder";
		} else     	if("ImgSplitbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.ImgSplitbar";
		} else     	if("ComboBoxItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ComboBoxItem";
		} else     	if("LayoutSpacer"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.LayoutSpacer";
		} else     	if("SimpleTile"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tile.SimpleTile";
		} else     	if("HTMLFlow"===smartClientClassName) {
			return "com.smartgwt.client.widgets.HTMLFlow";
		} else     	if("HStack"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.HStack";
		} else     	if("TileGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tile.TileGrid";
		} else     	if("SubmitItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SubmitItem";
		} else     	if("SelectItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SelectItem";
		} else     	if("IconMenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.IconMenuButton";
		} else     	if("SpacerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SpacerItem";
		} else     	if("RelativeDateItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.RelativeDateItem";
		} else     	if("LinkItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.LinkItem";
		} else     	if("TimeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.TimeItem";
		} else     	if("ColumnTree"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.ColumnTree";
		} else     	if("ActiveXControl"===smartClientClassName) {
			return "com.smartgwt.client.widgets.plugins.ActiveXControl";
		} else     	if("NavigationBar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.NavigationBar";
		} else     	if("HLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.HLayout";
		} else     	if("FacetChart"===smartClientClassName) {
			return "com.smartgwt.client.widgets.chart.FacetChart";
		} else     	if("ToolStripSeparator"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripSeparator";
		} else     	if("StretchImgButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.StretchImgButton";
		} else     	if("MiniDateRangeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.MiniDateRangeItem";
		} else     	if("UploadItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.UploadItem";
		} else     	if("ToolStripGroup"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripGroup";
		} else     	if("NativeCheckboxItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.NativeCheckboxItem";
		} else     	if("IPickTreeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.IPickTreeItem";
		} else     	if("SelectOtherItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SelectOtherItem";
		} else     	if("ToolStripMenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripMenuButton";
		} else     	if("RichTextEditor"===smartClientClassName) {
			return "com.smartgwt.client.widgets.RichTextEditor";
		} else     	if("MultiFileItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.MultiFileItem";
		} else     	if("TreeGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tree.TreeGrid";
		} else     	if("TabSet"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tab.TabSet";
		} else     	if("DateItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.DateItem";
		} else     	if("EventWindow"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.EventWindow";
		} else     	if("VLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.VLayout";
		} else     	if("SpinnerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SpinnerItem";
		} else     	if("DynamicForm"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.DynamicForm";
		} else     	if("ButtonItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ButtonItem";
		} else     	if("Menu"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.Menu";
		} else     	if("MenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.MenuButton";
		} else     	if("BrowserPlugin"===smartClientClassName) {
			return "com.smartgwt.client.widgets.plugins.BrowserPlugin";
		} else     	if("HTMLPane"===smartClientClassName) {
			return "com.smartgwt.client.widgets.HTMLPane";
		} else     	if("Img"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Img";
		} else     	if("TabBar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tab.TabBar";
		} else     	if("Dialog"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Dialog";
		} else     	if("ResetItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ResetItem";
		} else     	if("Timeline"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.Timeline";
		} else     	if("CheckboxItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.CheckboxItem";
		} else     	if("RichTextItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.RichTextItem";
		} else     	if("PrintCanvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.PrintCanvas";
		} else     	if("Layout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.Layout";
		} else     	if("SearchForm"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.SearchForm";
		} else     	if("VStack"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.VStack";
		} else     	if("HiliteEditor"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.HiliteEditor";
		} else     	if("SliderItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SliderItem";
		} else     	if("StretchImg"===smartClientClassName) {
			return "com.smartgwt.client.widgets.StretchImg";
		} else     	if("SectionStack"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.SectionStack";
		} else     	if("FieldPickerWindow"===smartClientClassName) {
			return "com.smartgwt.client.widgets.FieldPickerWindow";
		} else     	if("ImgSectionHeader"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.ImgSectionHeader";
		} else     	if("RadioGroupItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.RadioGroupItem";
		} else     	if("IMenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.IMenuButton";
		} else     	if("IButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.IButton";
		} else     	if("TextAreaItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.TextAreaItem";
		} else 
        { return null; }
    }-*/;

    /**
     * This method is a convenience for calling @{link #getSmartGWTClass}.getName();
     *
     * @param smartClientClassName
     * @return SmartGWT class fully qualified name or null
     */
    public static final Class<?> getSmartGWTClass(String smartClientClassName) {
    	if("ImgTab".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tab.ImgTab.class;
		} else     	if("SplitPane".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.SplitPane.class;
		} else     	if("MultiFilePicker".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.MultiFilePicker.class;
		} else     	if("Label".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Label.class;
		} else     	if("Portlet".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.Portlet.class;
		} else     	if("RibbonBar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.RibbonBar.class;
		} else     	if("PortalLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.PortalLayout.class;
		} else     	if("Splitbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Splitbar.class;
		} else     	if("ToolbarItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ToolbarItem.class;
		} else     	if("DateTimeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.DateTimeItem.class;
		} else     	if("DoubleItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.DoubleItem.class;
		} else     	if("EdgedCanvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.EdgedCanvas.class;
		} else     	if("SectionItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SectionItem.class;
		} else     	if("HiddenItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.HiddenItem.class;
		} else     	if("ListGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.ListGrid.class;
		} else     	if("CubeGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.cube.CubeGrid.class;
		} else     	if("ToolStripResizer".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripResizer.class;
		} else     	if("Window".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Window.class;
		} else     	if("BlurbItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.BlurbItem.class;
		} else     	if("RangeSlider".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.RangeSlider.class;
		} else     	if("StatefulCanvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.StatefulCanvas.class;
		} else     	if("NavigationButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.NavigationButton.class;
		} else     	if("Applet".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.plugins.Applet.class;
		} else     	if("TableView".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tableview.TableView.class;
		} else     	if("IconButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.IconButton.class;
		} else     	if("ColorPicker".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.ColorPicker.class;
		} else     	if("PrintWindow".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.PrintWindow.class;
		} else     	if("PickTreeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.PickTreeItem.class;
		} else     	if("DateChooser".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.DateChooser.class;
		} else     	if("PropertySheet".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.PropertySheet.class;
		} else     	if("TreeMenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.TreeMenuButton.class;
		} else     	if("ViewFileItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ViewFileItem.class;
		} else     	if("DateGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.DateGrid.class;
		} else     	if("AutoFitTextAreaItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem.class;
		} else     	if("ImgButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.ImgButton.class;
		} else     	if("ToolStripButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripButton.class;
		} else     	if("HiliteRule".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.HiliteRule.class;
		} else     	if("DateRangeDialog".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.DateRangeDialog.class;
		} else     	if("FileItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.FileItem.class;
		} else     	if("Canvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Canvas.class;
		} else     	if("SVG".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.plugins.SVG.class;
		} else     	if("RowSpacerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.RowSpacerItem.class;
		} else     	if("MultiComboBoxItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.MultiComboBoxItem.class;
		} else     	if("CanvasItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.CanvasItem.class;
		} else     	if("HeaderItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.HeaderItem.class;
		} else     	if("MenuBar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.MenuBar.class;
		} else     	if("Scrollbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Scrollbar.class;
		} else     	if("BatchUploader".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.BatchUploader.class;
		} else     	if("DateRangeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.DateRangeItem.class;
		} else     	if("TileLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tile.TileLayout.class;
		} else     	if("Slider".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Slider.class;
		} else     	if("Progressbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Progressbar.class;
		} else     	if("TextItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.TextItem.class;
		} else     	if("DetailViewer".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.viewer.DetailViewer.class;
		} else     	if("FilterClause".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.FilterClause.class;
		} else     	if("Flashlet".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.plugins.Flashlet.class;
		} else     	if("SectionHeader".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.SectionHeader.class;
		} else     	if("ToolStrip".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStrip.class;
		} else     	if("RibbonGroup".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.RibbonGroup.class;
		} else     	if("ViewLoader".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.ViewLoader.class;
		} else     	if("PasswordItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.PasswordItem.class;
		} else     	if("StaticTextItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.StaticTextItem.class;
		} else     	if("MultiGroupDialog".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.MultiGroupDialog.class;
		} else     	if("FlowLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.FlowLayout.class;
		} else     	if("Gauge".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.Gauge.class;
		} else     	if("AdvancedHiliteEditor".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.AdvancedHiliteEditor.class;
		} else     	if("Button".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Button.class;
		} else     	if("Calendar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.Calendar.class;
		} else     	if("Snapbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Snapbar.class;
		} else     	if("DrawPane".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawPane.class;
		} else     	if("FilterBuilder".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.FilterBuilder.class;
		} else     	if("ImgSplitbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.ImgSplitbar.class;
		} else     	if("ComboBoxItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ComboBoxItem.class;
		} else     	if("LayoutSpacer".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.LayoutSpacer.class;
		} else     	if("SimpleTile".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tile.SimpleTile.class;
		} else     	if("HTMLFlow".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.HTMLFlow.class;
		} else     	if("HStack".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.HStack.class;
		} else     	if("TileGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tile.TileGrid.class;
		} else     	if("SubmitItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SubmitItem.class;
		} else     	if("SelectItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SelectItem.class;
		} else     	if("IconMenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.IconMenuButton.class;
		} else     	if("SpacerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SpacerItem.class;
		} else     	if("RelativeDateItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.RelativeDateItem.class;
		} else     	if("LinkItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.LinkItem.class;
		} else     	if("TimeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.TimeItem.class;
		} else     	if("ColumnTree".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.ColumnTree.class;
		} else     	if("ActiveXControl".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.plugins.ActiveXControl.class;
		} else     	if("NavigationBar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.NavigationBar.class;
		} else     	if("HLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.HLayout.class;
		} else     	if("FacetChart".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.chart.FacetChart.class;
		} else     	if("ToolStripSeparator".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripSeparator.class;
		} else     	if("StretchImgButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.StretchImgButton.class;
		} else     	if("MiniDateRangeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.MiniDateRangeItem.class;
		} else     	if("UploadItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.UploadItem.class;
		} else     	if("ToolStripGroup".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripGroup.class;
		} else     	if("NativeCheckboxItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.NativeCheckboxItem.class;
		} else     	if("IPickTreeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.IPickTreeItem.class;
		} else     	if("SelectOtherItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SelectOtherItem.class;
		} else     	if("ToolStripMenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripMenuButton.class;
		} else     	if("RichTextEditor".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.RichTextEditor.class;
		} else     	if("MultiFileItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.MultiFileItem.class;
		} else     	if("TreeGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tree.TreeGrid.class;
		} else     	if("TabSet".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tab.TabSet.class;
		} else     	if("DateItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.DateItem.class;
		} else     	if("EventWindow".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.EventWindow.class;
		} else     	if("VLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.VLayout.class;
		} else     	if("SpinnerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SpinnerItem.class;
		} else     	if("DynamicForm".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.DynamicForm.class;
		} else     	if("ButtonItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ButtonItem.class;
		} else     	if("Menu".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.Menu.class;
		} else     	if("MenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.MenuButton.class;
		} else     	if("BrowserPlugin".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.plugins.BrowserPlugin.class;
		} else     	if("HTMLPane".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.HTMLPane.class;
		} else     	if("Img".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Img.class;
		} else     	if("TabBar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tab.TabBar.class;
		} else     	if("Dialog".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Dialog.class;
		} else     	if("ResetItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ResetItem.class;
		} else     	if("Timeline".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.Timeline.class;
		} else     	if("CheckboxItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.CheckboxItem.class;
		} else     	if("RichTextItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.RichTextItem.class;
		} else     	if("PrintCanvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.PrintCanvas.class;
		} else     	if("Layout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.Layout.class;
		} else     	if("SearchForm".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.SearchForm.class;
		} else     	if("VStack".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.VStack.class;
		} else     	if("HiliteEditor".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.HiliteEditor.class;
		} else     	if("SliderItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SliderItem.class;
		} else     	if("StretchImg".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.StretchImg.class;
		} else     	if("SectionStack".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.SectionStack.class;
		} else     	if("FieldPickerWindow".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.FieldPickerWindow.class;
		} else     	if("ImgSectionHeader".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.ImgSectionHeader.class;
		} else     	if("RadioGroupItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.RadioGroupItem.class;
		} else     	if("IMenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.IMenuButton.class;
		} else     	if("IButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.IButton.class;
		} else     	if("TextAreaItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.TextAreaItem.class;
		} else 
        { return null; }
    };
}
