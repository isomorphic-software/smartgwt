
package com.smartgwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.core.BaseClass;

/**
 * This class contains static utility methods to map between SmartClient objects/types and Smart GWT objects/classes.
 */
public final class ObjectFactory {

    private static final JavaScriptObject CANVAS_GET_OR_CREATE_REF_METHODS = createCanvasGetOrCreateRefMethodMap();

    private static native JavaScriptObject createCanvasGetOrCreateRefMethodMap() /*-{
        return {
            "ImgTab": @com.smartgwt.client.widgets.tab.ImgTab::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SplitPane": @com.smartgwt.client.widgets.layout.SplitPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MultiFilePicker": @com.smartgwt.client.widgets.MultiFilePicker::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Label": @com.smartgwt.client.widgets.Label::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Portlet": @com.smartgwt.client.widgets.layout.Portlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RibbonBar": @com.smartgwt.client.widgets.toolbar.RibbonBar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "PortalLayout": @com.smartgwt.client.widgets.layout.PortalLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Splitbar": @com.smartgwt.client.widgets.Splitbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "EdgedCanvas": @com.smartgwt.client.widgets.EdgedCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ListGrid": @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "CubeGrid": @com.smartgwt.client.widgets.cube.CubeGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripResizer": @com.smartgwt.client.widgets.toolbar.ToolStripResizer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Window": @com.smartgwt.client.widgets.Window::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "EditTree": @com.smartgwt.client.tools.EditTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RangeSlider": @com.smartgwt.client.widgets.RangeSlider::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "StatefulCanvas": @com.smartgwt.client.widgets.StatefulCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "NavigationButton": @com.smartgwt.client.widgets.NavigationButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Applet": @com.smartgwt.client.widgets.plugins.Applet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TableView": @com.smartgwt.client.widgets.tableview.TableView::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "IconButton": @com.smartgwt.client.widgets.IconButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ColorPicker": @com.smartgwt.client.widgets.form.ColorPicker::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "PrintWindow": @com.smartgwt.client.widgets.PrintWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DateChooser": @com.smartgwt.client.widgets.DateChooser::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "PropertySheet": @com.smartgwt.client.widgets.form.PropertySheet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TreeMenuButton": @com.smartgwt.client.widgets.menu.TreeMenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DateGrid": @com.smartgwt.client.widgets.grid.DateGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ImgButton": @com.smartgwt.client.widgets.ImgButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripButton": @com.smartgwt.client.widgets.toolbar.ToolStripButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HiliteRule": @com.smartgwt.client.widgets.grid.HiliteRule::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DateRangeDialog": @com.smartgwt.client.widgets.DateRangeDialog::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Canvas": @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SVG": @com.smartgwt.client.widgets.plugins.SVG::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MenuBar": @com.smartgwt.client.widgets.menu.MenuBar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Scrollbar": @com.smartgwt.client.widgets.Scrollbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "BatchUploader": @com.smartgwt.client.widgets.BatchUploader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TileLayout": @com.smartgwt.client.widgets.tile.TileLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Slider": @com.smartgwt.client.widgets.Slider::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Progressbar": @com.smartgwt.client.widgets.Progressbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "EditPane": @com.smartgwt.client.tools.EditPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DetailViewer": @com.smartgwt.client.widgets.viewer.DetailViewer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FilterClause": @com.smartgwt.client.widgets.form.FilterClause::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Flashlet": @com.smartgwt.client.widgets.plugins.Flashlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SectionHeader": @com.smartgwt.client.widgets.layout.SectionHeader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStrip": @com.smartgwt.client.widgets.toolbar.ToolStrip::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RibbonGroup": @com.smartgwt.client.widgets.toolbar.RibbonGroup::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ViewLoader": @com.smartgwt.client.widgets.ViewLoader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MultiGroupDialog": @com.smartgwt.client.widgets.MultiGroupDialog::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FlowLayout": @com.smartgwt.client.widgets.layout.FlowLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Gauge": @com.smartgwt.client.widgets.drawing.Gauge::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "AdvancedHiliteEditor": @com.smartgwt.client.widgets.grid.AdvancedHiliteEditor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Button": @com.smartgwt.client.widgets.Button::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Calendar": @com.smartgwt.client.widgets.calendar.Calendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Snapbar": @com.smartgwt.client.widgets.Snapbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawPane": @com.smartgwt.client.widgets.drawing.DrawPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FilterBuilder": @com.smartgwt.client.widgets.form.FilterBuilder::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ImgSplitbar": @com.smartgwt.client.widgets.ImgSplitbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "LayoutSpacer": @com.smartgwt.client.widgets.layout.LayoutSpacer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SimpleTile": @com.smartgwt.client.widgets.tile.SimpleTile::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HTMLFlow": @com.smartgwt.client.widgets.HTMLFlow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HStack": @com.smartgwt.client.widgets.layout.HStack::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TileGrid": @com.smartgwt.client.widgets.tile.TileGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TilePalette": @com.smartgwt.client.tools.TilePalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "IconMenuButton": @com.smartgwt.client.widgets.menu.IconMenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ColumnTree": @com.smartgwt.client.widgets.grid.ColumnTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ActiveXControl": @com.smartgwt.client.widgets.plugins.ActiveXControl::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "NavigationBar": @com.smartgwt.client.widgets.layout.NavigationBar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HLayout": @com.smartgwt.client.widgets.layout.HLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FacetChart": @com.smartgwt.client.widgets.chart.FacetChart::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripSeparator": @com.smartgwt.client.widgets.toolbar.ToolStripSeparator::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "StretchImgButton": @com.smartgwt.client.widgets.StretchImgButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripGroup": @com.smartgwt.client.widgets.toolbar.ToolStripGroup::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MenuPalette": @com.smartgwt.client.tools.MenuPalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripMenuButton": @com.smartgwt.client.widgets.toolbar.ToolStripMenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RichTextEditor": @com.smartgwt.client.widgets.RichTextEditor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TreeGrid": @com.smartgwt.client.widgets.tree.TreeGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TabSet": @com.smartgwt.client.widgets.tab.TabSet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "EventWindow": @com.smartgwt.client.widgets.calendar.EventWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "VLayout": @com.smartgwt.client.widgets.layout.VLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ListPropertiesPane": @com.smartgwt.client.widgets.rte.ListPropertiesPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DynamicForm": @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Menu": @com.smartgwt.client.widgets.menu.Menu::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ListPalette": @com.smartgwt.client.tools.ListPalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MenuButton": @com.smartgwt.client.widgets.menu.MenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "BrowserPlugin": @com.smartgwt.client.widgets.plugins.BrowserPlugin::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HTMLPane": @com.smartgwt.client.widgets.HTMLPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Img": @com.smartgwt.client.widgets.Img::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TabBar": @com.smartgwt.client.widgets.tab.TabBar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Dialog": @com.smartgwt.client.widgets.Dialog::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TreePalette": @com.smartgwt.client.tools.TreePalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RecordEditor": @com.smartgwt.client.widgets.grid.RecordEditor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Timeline": @com.smartgwt.client.widgets.calendar.Timeline::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ListPropertiesDialog": @com.smartgwt.client.widgets.rte.ListPropertiesDialog::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "PrintCanvas": @com.smartgwt.client.widgets.PrintCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Layout": @com.smartgwt.client.widgets.layout.Layout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SearchForm": @com.smartgwt.client.widgets.form.SearchForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "VStack": @com.smartgwt.client.widgets.layout.VStack::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HiliteEditor": @com.smartgwt.client.widgets.grid.HiliteEditor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "StretchImg": @com.smartgwt.client.widgets.StretchImg::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SectionStack": @com.smartgwt.client.widgets.layout.SectionStack::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FieldPickerWindow": @com.smartgwt.client.widgets.FieldPickerWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ImgSectionHeader": @com.smartgwt.client.widgets.layout.ImgSectionHeader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "IMenuButton": @com.smartgwt.client.widgets.menu.IMenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "IButton": @com.smartgwt.client.widgets.IButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
        };
    }-*/;

    /**
     * This method will create a Smart GWT object from the provided javaScriptObject and
     * smartClientClassName. It is possible that null will be returned.
     *
     * @return
     */
    public native static final <T extends com.smartgwt.client.widgets.BaseWidget> T createCanvas(String smartClientClassName, JavaScriptObject javaScriptObject) /*-{
        var getOrCreateRefMethod = @com.smartgwt.client.util.ObjectFactory::CANVAS_GET_OR_CREATE_REF_METHODS[smartClientClassName];
        ifNoGetOrCreateRefMethod: if (getOrCreateRefMethod == null) {
            if ($wnd.isc.isA.Canvas(javaScriptObject)) {
                // Check the class hierarchy looking for the closest SGWT standard Canvas class.
                // Eventually we'll get to the Canvas class itself if there is nothing more specific.
                var superClass = javaScriptObject.getSuperClass();
                for (;;) {
                    var superClassName = superClass.getScClassName();
                    getOrCreateRefMethod = @com.smartgwt.client.util.ObjectFactory::CANVAS_GET_OR_CREATE_REF_METHODS[superClassName];
                    if (getOrCreateRefMethod != null) {
                        // Remember the mapping from the unknown SmartClient class name to the corresponding
                        // SGWT class' getOrCreateRef() static method that we'll be using from now on.
                        @com.smartgwt.client.util.ObjectFactory::CANVAS_GET_OR_CREATE_REF_METHODS[smartClientClassName] = getOrCreateRefMethod;

                        // Break from the `if (getOrCreateRefMethod == null)' statement because
                        // now we have a non-null getOrCreateRefMethod.
                        break ifNoGetOrCreateRefMethod;
                    }

                    superClass = superClass.getSuperClass();
                }
            }

            return null;
        }

        return getOrCreateRefMethod(javaScriptObject);
    }-*/;

	/**
     * This method will create a SmartGWT class from the javaScriptObject and smartClientClassName
     *  provided. It is possible that null will be returned.
     *
     * @return
     */
    public native static final <T extends com.smartgwt.client.core.RefDataClass> T createFormItem(String smartClientClassName, JavaScriptObject javaScriptObject) /*-{
        var type = null;
        if ("BooleanItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.BooleanItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ToolbarItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ToolbarItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DateTimeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.DateTimeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DoubleItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.DoubleItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SectionItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SectionItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HiddenItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.HiddenItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("IntegerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.IntegerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FloatItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.FloatItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("BlurbItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.BlurbItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PickTreeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.PickTreeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ViewFileItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ViewFileItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AutoFitTextAreaItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FileItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.FileItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RowSpacerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.RowSpacerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MultiComboBoxItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.MultiComboBoxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CanvasItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.CanvasItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HeaderItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.HeaderItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DateRangeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.DateRangeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.TextItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PasswordItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.PasswordItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StaticTextItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.StaticTextItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ColorPickerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ColorPickerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ComboBoxItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ComboBoxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ColorItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ColorItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SubmitItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SubmitItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SelectItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SelectItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SpacerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SpacerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RelativeDateItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.RelativeDateItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("LinkItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.LinkItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TimeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.TimeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MiniDateRangeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.MiniDateRangeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UploadItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.UploadItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("NativeCheckboxItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.NativeCheckboxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("IPickTreeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.IPickTreeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SelectOtherItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SelectOtherItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DateItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.DateItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SpinnerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SpinnerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ButtonItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ButtonItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ResetItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ResetItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CheckboxItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.CheckboxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RichTextItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.RichTextItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SliderItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SliderItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PresetCriteriaItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.PresetCriteriaItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RadioGroupItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.RadioGroupItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextAreaItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.TextAreaItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else 
        if ($wnd.isc.isA.FormItem(javaScriptObject)) {
            type = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        }

		return type;
    }-*/;

    public static native <T extends com.smartgwt.client.core.DataClass> T createDataClass(String smartClientClassName,
                                                                                          JavaScriptObject javaScriptObject,
                                                                                          boolean createDefault)
    /*-{
        var instance = null;
        if ("LinearGradient" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.LinearGradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("EditNode" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.EditNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PortalPosition" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.layout.PortalPosition::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AdvancedCriteria" === smartClientClassName) {
            instance = @com.smartgwt.client.data.AdvancedCriteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ServerObject" === smartClientClassName) {
            instance = @com.smartgwt.client.docs.serverds.ServerObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormItemIcon" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.form.fields.FormItemIcon::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FacetValue" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.cube.FacetValue::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FacetValueMap" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.cube.FacetValueMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("OperationBinding" === smartClientClassName) {
            instance = @com.smartgwt.client.data.OperationBinding::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ColorStop" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.ColorStop::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawShapeCommand" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawShapeCommand::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HeaderLevel" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.calendar.HeaderLevel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DetailViewerField" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.viewer.DetailViewerField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSRequest" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Facet" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.cube.Facet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GaugeSector" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.GaugeSector::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TileRecord" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tile.TileRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ImgProperties" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ImgProperties::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
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
        } else         if ("Hilite" === smartClientClassName) {
            instance = @com.smartgwt.client.data.Hilite::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
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
        } else         if ("DrawnValue" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.chart.DrawnValue::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MetricSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.chart.MetricSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CellRecord" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.cube.CellRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CalendarEvent" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.calendar.CalendarEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DetailViewerRecord" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.viewer.DetailViewerRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SimpleGradient" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.SimpleGradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TreeNode" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Lane" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.calendar.Lane::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Gradient" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.Gradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Tab" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tab.Tab::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Criterion" === smartClientClassName) {
            instance = @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Shadow" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.Shadow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AnimateShowEffect" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.AnimateShowEffect::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StretchItem" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.StretchItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSRequestModifier" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DSRequestModifier::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RPCResponse" === smartClientClassName) {
            instance = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ListProperties" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.rte.ListProperties::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormItem" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GroupSummary" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.grid.GroupSummary::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DataSourceField" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DataSourceField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RPCRequest" === smartClientClassName) {
            instance = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ListGridField" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.grid.ListGridField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MenuItem" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.menu.MenuItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FiscalCalendar" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.FiscalCalendar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UserSummary" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.UserSummary::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FiscalYear" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.FiscalYear::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PaletteNode" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.PaletteNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else 
        if ($wnd.isc.isAn.Instance(javaScriptObject) && createDefault) {
            instance = @com.smartgwt.client.core.DataClass::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        }
        return instance;
    }-*/;

    public static native <T extends com.smartgwt.client.core.BaseClass> T createBaseClass(String smartClientClassName,
                                                                                          JavaScriptObject javaScriptObject,
                                                                                          boolean createDefault)
    /*-{
        var instance = null;
        if ("XJSONDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.XJSONDataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.data.TextSettings::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawLabel" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawLabel::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ValuesManager" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.form.ValuesManager::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Process" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.Process::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ServiceTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ServiceTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DecisionGateway" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.DecisionGateway::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawGroup" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawGroup::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ProcessSequence" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ProcessSequence::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HiddenPalette" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.HiddenPalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawOval" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawOval::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ScriptTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ScriptTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawLinePath" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawLinePath::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawShape" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawShape::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CellSelection" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.grid.CellSelection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Tree" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ResultTree" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.ResultTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("XORGateway" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.XORGateway::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Task" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.Task::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawRect" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawRect::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UserTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.UserTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawPolygon" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawPolygon::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawSector" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawSector::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawPath" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawPath::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawLine" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawLine::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawCurve" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawCurve::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawImage" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawImage::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("JSONEncoder" === smartClientClassName) {
            instance = @com.smartgwt.client.util.JSONEncoder::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SimpleType" === smartClientClassName) {
            instance = @com.smartgwt.client.data.SimpleType::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StateTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.StateTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("WSDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.WSDataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawItem" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RestDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.RestDataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawTriangle" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawTriangle::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextImportSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.data.TextImportSettings::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextExportSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.data.TextExportSettings::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ProcessElement" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ProcessElement::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawBlockConnector" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.drawing.DrawBlockConnector::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else 
        if ($wnd.isc.isAn.Instance(javaScriptObject) && createDefault) {
            instance = @com.smartgwt.client.core.BaseClass::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        }
        return instance;
    }-*/;

    public static Object createInstance(String scClassName, JavaScriptObject jsObj) {
        Object              object = ObjectFactory.createBaseClass(scClassName, jsObj, false);
        if (object == null) object = ObjectFactory.createDataClass(scClassName, jsObj, true);
        return object;
    }

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
    	if("BooleanItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.BooleanItem";
		} else     	if("ImgTab"===smartClientClassName) {
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
		} else     	if("IntegerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.IntegerItem";
		} else     	if("FloatItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.FloatItem";
		} else     	if("ToolStripResizer"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripResizer";
		} else     	if("Window"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Window";
		} else     	if("BlurbItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.BlurbItem";
		} else     	if("EditTree"===smartClientClassName) {
			return "com.smartgwt.client.tools.EditTree";
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
		} else     	if("EditPane"===smartClientClassName) {
			return "com.smartgwt.client.tools.EditPane";
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
		} else     	if("ColorPickerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ColorPickerItem";
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
		} else     	if("ColorItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ColorItem";
		} else     	if("TilePalette"===smartClientClassName) {
			return "com.smartgwt.client.tools.TilePalette";
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
		} else     	if("PresetDateRangeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.PresetDateRangeItem";
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
		} else     	if("MenuPalette"===smartClientClassName) {
			return "com.smartgwt.client.tools.MenuPalette";
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
		} else     	if("ListPropertiesPane"===smartClientClassName) {
			return "com.smartgwt.client.widgets.rte.ListPropertiesPane";
		} else     	if("SpinnerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SpinnerItem";
		} else     	if("DynamicForm"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.DynamicForm";
		} else     	if("ButtonItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ButtonItem";
		} else     	if("Menu"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.Menu";
		} else     	if("ListPalette"===smartClientClassName) {
			return "com.smartgwt.client.tools.ListPalette";
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
		} else     	if("TreePalette"===smartClientClassName) {
			return "com.smartgwt.client.tools.TreePalette";
		} else     	if("RecordEditor"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.RecordEditor";
		} else     	if("Timeline"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.Timeline";
		} else     	if("CheckboxItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.CheckboxItem";
		} else     	if("ListPropertiesDialog"===smartClientClassName) {
			return "com.smartgwt.client.widgets.rte.ListPropertiesDialog";
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
		} else     	if("PresetCriteriaItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.PresetCriteriaItem";
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
    	if("BooleanItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.BooleanItem.class;
		} else     	if("ImgTab".equals(smartClientClassName)){
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
		} else     	if("IntegerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.IntegerItem.class;
		} else     	if("FloatItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.FloatItem.class;
		} else     	if("ToolStripResizer".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripResizer.class;
		} else     	if("Window".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Window.class;
		} else     	if("BlurbItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.BlurbItem.class;
		} else     	if("EditTree".equals(smartClientClassName)){
			return com.smartgwt.client.tools.EditTree.class;
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
		} else     	if("EditPane".equals(smartClientClassName)){
			return com.smartgwt.client.tools.EditPane.class;
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
		} else     	if("ColorPickerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ColorPickerItem.class;
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
		} else     	if("ColorItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ColorItem.class;
		} else     	if("TilePalette".equals(smartClientClassName)){
			return com.smartgwt.client.tools.TilePalette.class;
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
		} else     	if("PresetDateRangeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.PresetDateRangeItem.class;
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
		} else     	if("MenuPalette".equals(smartClientClassName)){
			return com.smartgwt.client.tools.MenuPalette.class;
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
		} else     	if("ListPropertiesPane".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.rte.ListPropertiesPane.class;
		} else     	if("SpinnerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SpinnerItem.class;
		} else     	if("DynamicForm".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.DynamicForm.class;
		} else     	if("ButtonItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ButtonItem.class;
		} else     	if("Menu".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.Menu.class;
		} else     	if("ListPalette".equals(smartClientClassName)){
			return com.smartgwt.client.tools.ListPalette.class;
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
		} else     	if("TreePalette".equals(smartClientClassName)){
			return com.smartgwt.client.tools.TreePalette.class;
		} else     	if("RecordEditor".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.RecordEditor.class;
		} else     	if("Timeline".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.Timeline.class;
		} else     	if("CheckboxItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.CheckboxItem.class;
		} else     	if("ListPropertiesDialog".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.rte.ListPropertiesDialog.class;
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
		} else     	if("PresetCriteriaItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.PresetCriteriaItem.class;
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

    /* No need to create instances of this class. */
    private ObjectFactory(){}
}
