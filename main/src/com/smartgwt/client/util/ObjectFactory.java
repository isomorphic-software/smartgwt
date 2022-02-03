/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
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
            "DrawShape": @com.smartgwt.client.widgets.drawing.DrawShape::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ZoneCanvas": @com.smartgwt.client.widgets.calendar.ZoneCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HStack": @com.smartgwt.client.widgets.layout.HStack::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Timeline": @com.smartgwt.client.widgets.calendar.Timeline::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FieldPicker": @com.smartgwt.client.widgets.FieldPicker::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripMenuButton": @com.smartgwt.client.widgets.toolbar.ToolStripMenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "EdgedCanvas": @com.smartgwt.client.widgets.EdgedCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TabSet": @com.smartgwt.client.widgets.tab.TabSet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawKnob": @com.smartgwt.client.widgets.drawing.DrawKnob::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Label": @com.smartgwt.client.widgets.Label::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MenuButton": @com.smartgwt.client.widgets.menu.MenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "BaseWidget": @com.smartgwt.client.widgets.BaseWidget::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Window": @com.smartgwt.client.widgets.Window::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "IconButton": @com.smartgwt.client.widgets.IconButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SectionHeader": @com.smartgwt.client.widgets.layout.SectionHeader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DateGrid": @com.smartgwt.client.widgets.grid.DateGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "StatefulCanvas": @com.smartgwt.client.widgets.StatefulCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "GridRenderer": @com.smartgwt.client.widgets.grid.GridRenderer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawPath": @com.smartgwt.client.widgets.drawing.DrawPath::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "BrowserPlugin": @com.smartgwt.client.widgets.plugins.BrowserPlugin::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FieldPickerWindow": @com.smartgwt.client.widgets.FieldPickerWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MenuBar": @com.smartgwt.client.widgets.menu.MenuBar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RangeSlider": @com.smartgwt.client.widgets.RangeSlider::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Button": @com.smartgwt.client.widgets.Button::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Portlet": @com.smartgwt.client.widgets.layout.Portlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Scrollbar": @com.smartgwt.client.widgets.Scrollbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawPolygon": @com.smartgwt.client.widgets.drawing.DrawPolygon::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DateRangeDialog": @com.smartgwt.client.widgets.DateRangeDialog::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawItem": @com.smartgwt.client.widgets.drawing.DrawItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HTMLFlow": @com.smartgwt.client.widgets.HTMLFlow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TabBar": @com.smartgwt.client.widgets.tab.TabBar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DetailViewer": @com.smartgwt.client.widgets.viewer.DetailViewer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MultiSortDialog": @com.smartgwt.client.widgets.MultiSortDialog::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HiliteRule": @com.smartgwt.client.widgets.grid.HiliteRule::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "PortalLayout": @com.smartgwt.client.widgets.layout.PortalLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Progressbar": @com.smartgwt.client.widgets.Progressbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "IButton": @com.smartgwt.client.widgets.IButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FilterBuilder": @com.smartgwt.client.widgets.form.FilterBuilder::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStrip": @com.smartgwt.client.widgets.toolbar.ToolStrip::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MultiGroupPanel": @com.smartgwt.client.widgets.MultiGroupPanel::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FilterClause": @com.smartgwt.client.widgets.form.FilterClause::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ImgSplitbar": @com.smartgwt.client.widgets.ImgSplitbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TreeGrid": @com.smartgwt.client.widgets.tree.TreeGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Snapbar": @com.smartgwt.client.widgets.Snapbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ListPalette": @com.smartgwt.client.tools.ListPalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "AdvancedHiliteEditor": @com.smartgwt.client.widgets.grid.AdvancedHiliteEditor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "NavigationButton": @com.smartgwt.client.widgets.NavigationButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "VStack": @com.smartgwt.client.widgets.layout.VStack::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ViewLoader": @com.smartgwt.client.widgets.ViewLoader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Slider": @com.smartgwt.client.widgets.Slider::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ListPropertiesDialog": @com.smartgwt.client.widgets.rte.ListPropertiesDialog::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "PrintWindow": @com.smartgwt.client.widgets.PrintWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "StretchImg": @com.smartgwt.client.widgets.StretchImg::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TilePalette": @com.smartgwt.client.tools.TilePalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MultiFilePicker": @com.smartgwt.client.widgets.MultiFilePicker::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "PropertySheet": @com.smartgwt.client.widgets.form.PropertySheet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SearchForm": @com.smartgwt.client.widgets.form.SearchForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ListPropertiesPane": @com.smartgwt.client.widgets.rte.ListPropertiesPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripSpacer": @com.smartgwt.client.widgets.toolbar.ToolStripSpacer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "EventCanvas": @com.smartgwt.client.widgets.calendar.EventCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "PickListMenu": @com.smartgwt.client.widgets.form.PickListMenu::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ActiveXControl": @com.smartgwt.client.widgets.plugins.ActiveXControl::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DateChooser": @com.smartgwt.client.widgets.DateChooser::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "BatchUploader": @com.smartgwt.client.widgets.BatchUploader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "StretchImgButton": @com.smartgwt.client.widgets.StretchImgButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawLine": @com.smartgwt.client.widgets.drawing.DrawLine::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Dialog": @com.smartgwt.client.widgets.Dialog::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TableView": @com.smartgwt.client.widgets.tableview.TableView::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "IconMenuButton": @com.smartgwt.client.widgets.menu.IconMenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "VisualBuilder": @com.smartgwt.client.tools.VisualBuilder::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawDiamond": @com.smartgwt.client.widgets.drawing.DrawDiamond::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MiniNavControl": @com.smartgwt.client.widgets.MiniNavControl::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TileGrid": @com.smartgwt.client.widgets.tile.TileGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "NavigationBar": @com.smartgwt.client.widgets.layout.NavigationBar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Sound": @com.smartgwt.client.widgets.Sound::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ColorPicker": @com.smartgwt.client.widgets.form.ColorPicker::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "EditPane": @com.smartgwt.client.tools.EditPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Deck": @com.smartgwt.client.widgets.layout.Deck::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Toolbar": @com.smartgwt.client.widgets.toolbar.Toolbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawLinePath": @com.smartgwt.client.widgets.drawing.DrawLinePath::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawImage": @com.smartgwt.client.widgets.drawing.DrawImage::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RichTextEditor": @com.smartgwt.client.widgets.RichTextEditor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawBlockConnector": @com.smartgwt.client.widgets.drawing.DrawBlockConnector::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SplitPane": @com.smartgwt.client.widgets.layout.SplitPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ImgSectionHeader": @com.smartgwt.client.widgets.layout.ImgSectionHeader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RibbonBar": @com.smartgwt.client.widgets.toolbar.RibbonBar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HLayout": @com.smartgwt.client.widgets.layout.HLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Calendar": @com.smartgwt.client.widgets.calendar.Calendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HiliteEditor": @com.smartgwt.client.widgets.grid.HiliteEditor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ListGrid": @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FlowLayout": @com.smartgwt.client.widgets.layout.FlowLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "EventWindow": @com.smartgwt.client.widgets.calendar.EventWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "AdaptiveMenu": @com.smartgwt.client.widgets.menu.AdaptiveMenu::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Gauge": @com.smartgwt.client.widgets.drawing.Gauge::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawOval": @com.smartgwt.client.widgets.drawing.DrawOval::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawTriangle": @com.smartgwt.client.widgets.drawing.DrawTriangle::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ImgButton": @com.smartgwt.client.widgets.ImgButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripGroup": @com.smartgwt.client.widgets.toolbar.ToolStripGroup::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "CubeGrid": @com.smartgwt.client.widgets.cube.CubeGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SVG": @com.smartgwt.client.widgets.plugins.SVG::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "IMenuButton": @com.smartgwt.client.widgets.menu.IMenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawRect": @com.smartgwt.client.widgets.drawing.DrawRect::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TreePalette": @com.smartgwt.client.tools.TreePalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TileLayout": @com.smartgwt.client.widgets.tile.TileLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SelectionTreeMenu": @com.smartgwt.client.widgets.menu.SelectionTreeMenu::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DynamicForm": @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ImgTab": @com.smartgwt.client.widgets.tab.ImgTab::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "LayoutSpacer": @com.smartgwt.client.widgets.layout.LayoutSpacer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "FacetChart": @com.smartgwt.client.widgets.chart.FacetChart::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SimpleTile": @com.smartgwt.client.widgets.tile.SimpleTile::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MenuPalette": @com.smartgwt.client.tools.MenuPalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawGroup": @com.smartgwt.client.widgets.drawing.DrawGroup::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawSector": @com.smartgwt.client.widgets.drawing.DrawSector::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawPane": @com.smartgwt.client.widgets.drawing.DrawPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Menu": @com.smartgwt.client.widgets.menu.Menu::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Layout": @com.smartgwt.client.widgets.layout.Layout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MultiSortPanel": @com.smartgwt.client.widgets.MultiSortPanel::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripResizer": @com.smartgwt.client.widgets.toolbar.ToolStripResizer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "NavPanel": @com.smartgwt.client.widgets.layout.NavPanel::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Canvas": @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "MultiGroupDialog": @com.smartgwt.client.widgets.MultiGroupDialog::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripSeparator": @com.smartgwt.client.widgets.toolbar.ToolStripSeparator::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "HTMLPane": @com.smartgwt.client.widgets.HTMLPane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "SectionStack": @com.smartgwt.client.widgets.layout.SectionStack::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "AceEditor": @com.smartgwt.client.widgets.ace.AceEditor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DataView": @com.smartgwt.client.widgets.layout.DataView::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "TreeMenuButton": @com.smartgwt.client.widgets.menu.TreeMenuButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawCurve": @com.smartgwt.client.widgets.drawing.DrawCurve::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "IndicatorCanvas": @com.smartgwt.client.widgets.calendar.IndicatorCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ColumnTree": @com.smartgwt.client.widgets.grid.ColumnTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "PrintCanvas": @com.smartgwt.client.widgets.PrintCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RibbonGroup": @com.smartgwt.client.widgets.toolbar.RibbonGroup::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "VLayout": @com.smartgwt.client.widgets.layout.VLayout::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "CalendarView": @com.smartgwt.client.widgets.calendar.CalendarView::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Splitbar": @com.smartgwt.client.widgets.Splitbar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "ToolStripButton": @com.smartgwt.client.widgets.toolbar.ToolStripButton::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "EditTree": @com.smartgwt.client.tools.EditTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Img": @com.smartgwt.client.widgets.Img::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "Flashlet": @com.smartgwt.client.widgets.plugins.Flashlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "DrawLabel": @com.smartgwt.client.widgets.drawing.DrawLabel::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
            , "RecordEditor": @com.smartgwt.client.widgets.grid.RecordEditor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)
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
            if ($wnd.isc.isA.BaseWidget(javaScriptObject)) {
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
        if ("SpacerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SpacerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("BlurbItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.BlurbItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("NativeCheckboxItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.NativeCheckboxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AutoFitTextAreaItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SpinnerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SpinnerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("IPickTreeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.IPickTreeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SectionItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SectionItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ResetItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ResetItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("LinkItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.LinkItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RichTextItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.RichTextItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RowSpacerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.RowSpacerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TimeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.TimeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CanvasItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.CanvasItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.TextItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UploadItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.UploadItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ViewFileItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ViewFileItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DateRangeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.DateRangeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SelectItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SelectItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SliderItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SliderItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextAreaItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.TextAreaItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FileItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.FileItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ComboBoxItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ComboBoxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PickTreeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.PickTreeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ColorPickerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ColorPickerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SubmitItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SubmitItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StaticTextItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.StaticTextItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HiddenItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.HiddenItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("BooleanItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.BooleanItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RadioGroupItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.RadioGroupItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RelativeDateItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.RelativeDateItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DateTimeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.DateTimeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FloatItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.FloatItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HeaderItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.HeaderItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PasswordItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.PasswordItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ToolbarItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ToolbarItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("IntegerItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.IntegerItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DateItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.DateItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MiniDateRangeItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.MiniDateRangeItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DoubleItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.DoubleItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CheckboxItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.CheckboxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ColorItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ColorItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SelectOtherItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.SelectOtherItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MultiComboBoxItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.MultiComboBoxItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ButtonItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.fields.ButtonItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PresetCriteriaItem" === smartClientClassName) {
            type = @com.smartgwt.client.widgets.form.PresetCriteriaItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
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
        var dataJsObj = null;
        if ("SimpleGradient" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.SimpleGradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("NavItem" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.layout.NavItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RelativeDate" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.RelativeDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AnimateShowEffect" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.AnimateShowEffect::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Facet" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.cube.Facet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SerializationSettings" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.tools.SerializationSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FacetValue" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.cube.FacetValue::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("NotifyAction" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.notify.NotifyAction::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FiscalCalendar" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.FiscalCalendar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CreateScreenSettings" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.rpc.CreateScreenSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Shadow" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.Shadow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ListProperties" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.rte.ListProperties::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GroupSummary" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.grid.GroupSummary::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Point" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.Point::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSResponse" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSRequest" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RPCResponse" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SortSpecifier" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.SortSpecifier::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MetricSettings" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.chart.MetricSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Hilite" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.Hilite::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormItem" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PortalPosition" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.layout.PortalPosition::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Record" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.Record::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HeaderLevel" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.calendar.HeaderLevel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RPCRequest" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Gradient" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.Gradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawShapeCommand" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.DrawShapeCommand::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSLoadSettings" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.DSLoadSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DiscoverTreeSettings" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.tree.DiscoverTreeSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("LoadProjectSettings" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.rpc.LoadProjectSettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("EditNode" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.tools.EditNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawnValue" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.chart.DrawnValue::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GroupSpecifier" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.GroupSpecifier::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("LinearGradient" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.LinearGradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CellRecord" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.cube.CellRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AceCompletionResult" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.ace.AceCompletionResult::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SectionStackSection" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.layout.SectionStackSection::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("OperationBinding" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.OperationBinding::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DataSourceField" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.DataSourceField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("QualityIndicatedLocator" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.util.QualityIndicatedLocator::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RadialGradient" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.RadialGradient::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("KeyIdentifier" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.core.KeyIdentifier::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MenuItem" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.menu.MenuItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PrintProperties" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.util.PrintProperties::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Lane" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.calendar.Lane::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HeaderSpan" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.grid.HeaderSpan::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FacetValueMap" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.cube.FacetValueMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UserFormula" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.UserFormula::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("NavigationBarViewState" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.layout.NavigationBarViewState::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ImgProperties" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.ImgProperties::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ListGridRecord" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ColorStop" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.ColorStop::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Criterion" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TreeGridField" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.tree.TreeGridField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ListGridField" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.grid.ListGridField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TreeNode" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AdvancedCriteria" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.AdvancedCriteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CalendarEvent" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.calendar.CalendarEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StretchItem" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.StretchItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SCStatefulImgConfig" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.SCStatefulImgConfig::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("NotifySettings" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.notify.NotifySettings::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FileSpec" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.data.FileSpec::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FiscalYear" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.FiscalYear::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AcePosition" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.ace.AcePosition::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DetailViewerField" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.viewer.DetailViewerField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Tab" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.tab.Tab::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UserSummary" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.UserSummary::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PaletteNode" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.tools.PaletteNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GaugeSector" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.drawing.GaugeSector::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormItemIcon" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.form.fields.FormItemIcon::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TileRecord" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.tile.TileRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Validator" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.form.validator.Validator::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DetailViewerRecord" === smartClientClassName) {
            dataJsObj = @com.smartgwt.client.widgets.viewer.DetailViewerRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else 
        if ($wnd.isc.isAn.Object(javaScriptObject) && createDefault) {
            dataJsObj = @com.smartgwt.client.core.DataClass::new(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        }
        return dataJsObj;
    }-*/;

    public static native <T extends com.smartgwt.client.core.BaseClass> T createBaseClass(String smartClientClassName,
                                                                                          JavaScriptObject javaScriptObject,
                                                                                          boolean createDefault)
    /*-{
        var instance = null;
        if ("ResetPasswordTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ResetPasswordTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SectionStackEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.SectionStackEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SimpleType" === smartClientClassName) {
            instance = @com.smartgwt.client.data.SimpleType::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSUpdateTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.DSUpdateTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AceCompleter" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ace.AceCompleter::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawPaneEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.DrawPaneEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CellSelection" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.grid.CellSelection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawItemEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.DrawItemEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MenuEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.MenuEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.DataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormItemEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.FormItemEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StatefulCanvasEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.StatefulCanvasEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AceRenderer" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ace.AceRenderer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AceAnchor" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ace.AceAnchor::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CheckboxItemEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.CheckboxItemEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GridRemoveSelectedDataTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("CanvasEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.CanvasEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AceEditSession" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ace.AceEditSession::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("MockDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.MockDataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AskForValueTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.AskForValueTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("NavigateDetailPaneTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.NavigateDetailPaneTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DetailViewerEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.DetailViewerEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UserTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.UserTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("LabelEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.LabelEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ResultSet" === smartClientClassName) {
            instance = @com.smartgwt.client.data.ResultSet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Task" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.Task::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SetLabelTextTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.SetLabelTextTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SelectItemEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.SelectItemEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Process" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.Process::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SetButtonTitleTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.SetButtonTitleTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GridEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.GridEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SyntaxHiliter" === smartClientClassName) {
            instance = @com.smartgwt.client.util.SyntaxHiliter::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormHideFieldTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormHideFieldTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("EditContext" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.EditContext::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("Tree" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ComponentTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ComponentTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.data.TextSettings::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ShowComponentTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ShowComponentTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DecisionGateway" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.DecisionGateway::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HideComponentTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.HideComponentTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("XJSONDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.XJSONDataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ImgEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.ImgEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("WSDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.WSDataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("WindowEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.WindowEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GridSaveAllEditsTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.GridSaveAllEditsTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ShowNextToComponentTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ShowNextToComponentTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("JSONEncoder" === smartClientClassName) {
            instance = @com.smartgwt.client.util.JSONEncoder::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StartTransactionTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.StartTransactionTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FacadeDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.FacadeDataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("HiddenPalette" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.HiddenPalette::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ProcessElement" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ProcessElement::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DateItemEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.DateItemEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextAreaItemEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.TextAreaItemEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DrawLabelEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.DrawLabelEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GridExportDataTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.GridExportDataTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("LayoutEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.LayoutEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextExportSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.data.TextExportSettings::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ProcessSequence" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ProcessSequence::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FileItemEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.FileItemEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormSetFieldValueTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormSetFieldValueTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("EndProcessTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.EndProcessTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StartProcessTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.StartProcessTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextItemEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.TextItemEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GridSetEditValueTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.GridSetEditValueTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AceUndoManager" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ace.AceUndoManager::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSRemoveTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.DSRemoveTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ResultTree" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.ResultTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TextImportSettings" === smartClientClassName) {
            instance = @com.smartgwt.client.data.TextImportSettings::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("RestDataSource" === smartClientClassName) {
            instance = @com.smartgwt.client.data.RestDataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormValidateValuesTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormValidateValuesTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ValuesManager" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.form.ValuesManager::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("XMLSyntaxHiliter" === smartClientClassName) {
            instance = @com.smartgwt.client.util.XMLSyntaxHiliter::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("PrintCanvasTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.PrintCanvasTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("LogOutTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.LogOutTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GridExportClientDataTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.GridExportClientDataTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ShowMessageTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ShowMessageTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("UserConfirmationGateway" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.UserConfirmationGateway::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormResetValuesTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormResetValuesTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ShowNotificationTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ShowNotificationTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AceMarker" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ace.AceMarker::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SplitPaneEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.SplitPaneEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GridFetchDataTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.GridFetchDataTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("NavigateListPaneTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.NavigateListPaneTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.FormEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FacetChartEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.FacetChartEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("StateTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.StateTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("EditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.EditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ScriptTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ScriptTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GridFetchRelatedDataTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.GridFetchRelatedDataTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSAddTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.DSAddTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SetSectionTitleTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.SetSectionTitleTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SendTransactionTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.SendTransactionTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("SectionStackSectionEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.SectionStackSectionEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormSaveDataTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormSaveDataTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormEditNewRecordTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormEditNewRecordTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("DSFetchTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.DSFetchTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AceRange" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ace.AceRange::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormEditRecordTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormEditRecordTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("XORGateway" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.XORGateway::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormClearValuesTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormClearValuesTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormSetValuesTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormSetValuesTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("GridStartEditingTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.GridStartEditingTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TabSetEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.TabSetEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ProgressbarEditProxy" === smartClientClassName) {
            instance = @com.smartgwt.client.tools.ProgressbarEditProxy::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("NodeLocator" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.tree.NodeLocator::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormDisableFieldTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormDisableFieldTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("ServiceTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.ServiceTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("FormEditSelectedTask" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.FormEditSelectedTask::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("AceDocument" === smartClientClassName) {
            instance = @com.smartgwt.client.widgets.ace.AceDocument::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("JSSyntaxHiliter" === smartClientClassName) {
            instance = @com.smartgwt.client.util.JSSyntaxHiliter::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
        } else         if ("TaskDecision" === smartClientClassName) {
            instance = @com.smartgwt.client.util.workflow.TaskDecision::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(javaScriptObject);
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
    	if("DrawShape"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawShape";
		} else     	if("ZoneCanvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.ZoneCanvas";
		} else     	if("SpacerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SpacerItem";
		} else     	if("BlurbItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.BlurbItem";
		} else     	if("HStack"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.HStack";
		} else     	if("Timeline"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.Timeline";
		} else     	if("FieldPicker"===smartClientClassName) {
			return "com.smartgwt.client.widgets.FieldPicker";
		} else     	if("NativeCheckboxItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.NativeCheckboxItem";
		} else     	if("ToolStripMenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripMenuButton";
		} else     	if("EdgedCanvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.EdgedCanvas";
		} else     	if("AutoFitTextAreaItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem";
		} else     	if("TabSet"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tab.TabSet";
		} else     	if("DrawKnob"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawKnob";
		} else     	if("Label"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Label";
		} else     	if("MenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.MenuButton";
		} else     	if("SpinnerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SpinnerItem";
		} else     	if("IPickTreeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.IPickTreeItem";
		} else     	if("BaseWidget"===smartClientClassName) {
			return "com.smartgwt.client.widgets.BaseWidget";
		} else     	if("SectionItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SectionItem";
		} else     	if("ResetItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ResetItem";
		} else     	if("Window"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Window";
		} else     	if("IconButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.IconButton";
		} else     	if("SectionHeader"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.SectionHeader";
		} else     	if("DateGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.DateGrid";
		} else     	if("StatefulCanvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.StatefulCanvas";
		} else     	if("LinkItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.LinkItem";
		} else     	if("RichTextItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.RichTextItem";
		} else     	if("GridRenderer"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.GridRenderer";
		} else     	if("DrawPath"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawPath";
		} else     	if("BrowserPlugin"===smartClientClassName) {
			return "com.smartgwt.client.widgets.plugins.BrowserPlugin";
		} else     	if("FieldPickerWindow"===smartClientClassName) {
			return "com.smartgwt.client.widgets.FieldPickerWindow";
		} else     	if("MenuBar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.MenuBar";
		} else     	if("RangeSlider"===smartClientClassName) {
			return "com.smartgwt.client.widgets.RangeSlider";
		} else     	if("Button"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Button";
		} else     	if("RowSpacerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.RowSpacerItem";
		} else     	if("TimeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.TimeItem";
		} else     	if("CanvasItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.CanvasItem";
		} else     	if("Portlet"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.Portlet";
		} else     	if("Scrollbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Scrollbar";
		} else     	if("DrawPolygon"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawPolygon";
		} else     	if("DateRangeDialog"===smartClientClassName) {
			return "com.smartgwt.client.widgets.DateRangeDialog";
		} else     	if("DrawItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawItem";
		} else     	if("HTMLFlow"===smartClientClassName) {
			return "com.smartgwt.client.widgets.HTMLFlow";
		} else     	if("TabBar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tab.TabBar";
		} else     	if("DetailViewer"===smartClientClassName) {
			return "com.smartgwt.client.widgets.viewer.DetailViewer";
		} else     	if("MultiSortDialog"===smartClientClassName) {
			return "com.smartgwt.client.widgets.MultiSortDialog";
		} else     	if("HiliteRule"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.HiliteRule";
		} else     	if("TextItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.TextItem";
		} else     	if("UploadItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.UploadItem";
		} else     	if("PortalLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.PortalLayout";
		} else     	if("Progressbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Progressbar";
		} else     	if("ViewFileItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ViewFileItem";
		} else     	if("IButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.IButton";
		} else     	if("FilterBuilder"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.FilterBuilder";
		} else     	if("ToolStrip"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStrip";
		} else     	if("MultiGroupPanel"===smartClientClassName) {
			return "com.smartgwt.client.widgets.MultiGroupPanel";
		} else     	if("FilterClause"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.FilterClause";
		} else     	if("DateRangeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.DateRangeItem";
		} else     	if("ImgSplitbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.ImgSplitbar";
		} else     	if("TreeGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tree.TreeGrid";
		} else     	if("SelectItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SelectItem";
		} else     	if("Snapbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Snapbar";
		} else     	if("ListPalette"===smartClientClassName) {
			return "com.smartgwt.client.tools.ListPalette";
		} else     	if("AdvancedHiliteEditor"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.AdvancedHiliteEditor";
		} else     	if("SliderItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SliderItem";
		} else     	if("NavigationButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.NavigationButton";
		} else     	if("VStack"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.VStack";
		} else     	if("ViewLoader"===smartClientClassName) {
			return "com.smartgwt.client.widgets.ViewLoader";
		} else     	if("TextAreaItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.TextAreaItem";
		} else     	if("Slider"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Slider";
		} else     	if("FileItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.FileItem";
		} else     	if("ComboBoxItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ComboBoxItem";
		} else     	if("ListPropertiesDialog"===smartClientClassName) {
			return "com.smartgwt.client.widgets.rte.ListPropertiesDialog";
		} else     	if("PickTreeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.PickTreeItem";
		} else     	if("PrintWindow"===smartClientClassName) {
			return "com.smartgwt.client.widgets.PrintWindow";
		} else     	if("ColorPickerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ColorPickerItem";
		} else     	if("StretchImg"===smartClientClassName) {
			return "com.smartgwt.client.widgets.StretchImg";
		} else     	if("TilePalette"===smartClientClassName) {
			return "com.smartgwt.client.tools.TilePalette";
		} else     	if("MultiFilePicker"===smartClientClassName) {
			return "com.smartgwt.client.widgets.MultiFilePicker";
		} else     	if("PropertySheet"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.PropertySheet";
		} else     	if("SearchForm"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.SearchForm";
		} else     	if("PresetDateRangeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.PresetDateRangeItem";
		} else     	if("ListPropertiesPane"===smartClientClassName) {
			return "com.smartgwt.client.widgets.rte.ListPropertiesPane";
		} else     	if("ToolStripSpacer"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripSpacer";
		} else     	if("EventCanvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.EventCanvas";
		} else     	if("SubmitItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SubmitItem";
		} else     	if("PickListMenu"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.PickListMenu";
		} else     	if("ActiveXControl"===smartClientClassName) {
			return "com.smartgwt.client.widgets.plugins.ActiveXControl";
		} else     	if("DateChooser"===smartClientClassName) {
			return "com.smartgwt.client.widgets.DateChooser";
		} else     	if("BatchUploader"===smartClientClassName) {
			return "com.smartgwt.client.widgets.BatchUploader";
		} else     	if("StretchImgButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.StretchImgButton";
		} else     	if("DrawLine"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawLine";
		} else     	if("Dialog"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Dialog";
		} else     	if("TableView"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tableview.TableView";
		} else     	if("StaticTextItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.StaticTextItem";
		} else     	if("IconMenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.IconMenuButton";
		} else     	if("VisualBuilder"===smartClientClassName) {
			return "com.smartgwt.client.tools.VisualBuilder";
		} else     	if("DrawDiamond"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawDiamond";
		} else     	if("MiniNavControl"===smartClientClassName) {
			return "com.smartgwt.client.widgets.MiniNavControl";
		} else     	if("TileGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tile.TileGrid";
		} else     	if("NavigationBar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.NavigationBar";
		} else     	if("Sound"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Sound";
		} else     	if("ColorPicker"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.ColorPicker";
		} else     	if("EditPane"===smartClientClassName) {
			return "com.smartgwt.client.tools.EditPane";
		} else     	if("HiddenItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.HiddenItem";
		} else     	if("Deck"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.Deck";
		} else     	if("Toolbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.Toolbar";
		} else     	if("DrawLinePath"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawLinePath";
		} else     	if("DrawImage"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawImage";
		} else     	if("RichTextEditor"===smartClientClassName) {
			return "com.smartgwt.client.widgets.RichTextEditor";
		} else     	if("BooleanItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.BooleanItem";
		} else     	if("RadioGroupItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.RadioGroupItem";
		} else     	if("DrawBlockConnector"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawBlockConnector";
		} else     	if("SplitPane"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.SplitPane";
		} else     	if("ImgSectionHeader"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.ImgSectionHeader";
		} else     	if("RibbonBar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.RibbonBar";
		} else     	if("RelativeDateItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.RelativeDateItem";
		} else     	if("HLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.HLayout";
		} else     	if("Calendar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.Calendar";
		} else     	if("HiliteEditor"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.HiliteEditor";
		} else     	if("ListGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.ListGrid";
		} else     	if("FlowLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.FlowLayout";
		} else     	if("EventWindow"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.EventWindow";
		} else     	if("DateTimeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.DateTimeItem";
		} else     	if("AdaptiveMenu"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.AdaptiveMenu";
		} else     	if("FloatItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.FloatItem";
		} else     	if("Gauge"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.Gauge";
		} else     	if("HeaderItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.HeaderItem";
		} else     	if("DrawOval"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawOval";
		} else     	if("MultiFileItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.MultiFileItem";
		} else     	if("DrawTriangle"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawTriangle";
		} else     	if("ImgButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.ImgButton";
		} else     	if("ToolStripGroup"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripGroup";
		} else     	if("CubeGrid"===smartClientClassName) {
			return "com.smartgwt.client.widgets.cube.CubeGrid";
		} else     	if("SVG"===smartClientClassName) {
			return "com.smartgwt.client.widgets.plugins.SVG";
		} else     	if("IMenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.IMenuButton";
		} else     	if("DrawRect"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawRect";
		} else     	if("TreePalette"===smartClientClassName) {
			return "com.smartgwt.client.tools.TreePalette";
		} else     	if("TileLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tile.TileLayout";
		} else     	if("SelectionTreeMenu"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.SelectionTreeMenu";
		} else     	if("DynamicForm"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.DynamicForm";
		} else     	if("PasswordItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.PasswordItem";
		} else     	if("ImgTab"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tab.ImgTab";
		} else     	if("LayoutSpacer"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.LayoutSpacer";
		} else     	if("ToolbarItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ToolbarItem";
		} else     	if("FacetChart"===smartClientClassName) {
			return "com.smartgwt.client.widgets.chart.FacetChart";
		} else     	if("IntegerItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.IntegerItem";
		} else     	if("SimpleTile"===smartClientClassName) {
			return "com.smartgwt.client.widgets.tile.SimpleTile";
		} else     	if("DateItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.DateItem";
		} else     	if("MenuPalette"===smartClientClassName) {
			return "com.smartgwt.client.tools.MenuPalette";
		} else     	if("DrawGroup"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawGroup";
		} else     	if("DrawSector"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawSector";
		} else     	if("MiniDateRangeItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.MiniDateRangeItem";
		} else     	if("DoubleItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.DoubleItem";
		} else     	if("DrawPane"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawPane";
		} else     	if("CheckboxItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.CheckboxItem";
		} else     	if("Menu"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.Menu";
		} else     	if("Layout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.Layout";
		} else     	if("MultiSortPanel"===smartClientClassName) {
			return "com.smartgwt.client.widgets.MultiSortPanel";
		} else     	if("ToolStripResizer"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripResizer";
		} else     	if("NavPanel"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.NavPanel";
		} else     	if("Canvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Canvas";
		} else     	if("ColorItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ColorItem";
		} else     	if("SelectOtherItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.SelectOtherItem";
		} else     	if("MultiGroupDialog"===smartClientClassName) {
			return "com.smartgwt.client.widgets.MultiGroupDialog";
		} else     	if("ToolStripSeparator"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripSeparator";
		} else     	if("HTMLPane"===smartClientClassName) {
			return "com.smartgwt.client.widgets.HTMLPane";
		} else     	if("MultiComboBoxItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.MultiComboBoxItem";
		} else     	if("SectionStack"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.SectionStack";
		} else     	if("AceEditor"===smartClientClassName) {
			return "com.smartgwt.client.widgets.ace.AceEditor";
		} else     	if("DataView"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.DataView";
		} else     	if("TreeMenuButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.menu.TreeMenuButton";
		} else     	if("DrawCurve"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawCurve";
		} else     	if("IndicatorCanvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.IndicatorCanvas";
		} else     	if("ColumnTree"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.ColumnTree";
		} else     	if("PrintCanvas"===smartClientClassName) {
			return "com.smartgwt.client.widgets.PrintCanvas";
		} else     	if("RibbonGroup"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.RibbonGroup";
		} else     	if("VLayout"===smartClientClassName) {
			return "com.smartgwt.client.widgets.layout.VLayout";
		} else     	if("CalendarView"===smartClientClassName) {
			return "com.smartgwt.client.widgets.calendar.CalendarView";
		} else     	if("Splitbar"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Splitbar";
		} else     	if("ToolStripButton"===smartClientClassName) {
			return "com.smartgwt.client.widgets.toolbar.ToolStripButton";
		} else     	if("EditTree"===smartClientClassName) {
			return "com.smartgwt.client.tools.EditTree";
		} else     	if("ButtonItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.fields.ButtonItem";
		} else     	if("Img"===smartClientClassName) {
			return "com.smartgwt.client.widgets.Img";
		} else     	if("PresetCriteriaItem"===smartClientClassName) {
			return "com.smartgwt.client.widgets.form.PresetCriteriaItem";
		} else     	if("Flashlet"===smartClientClassName) {
			return "com.smartgwt.client.widgets.plugins.Flashlet";
		} else     	if("DrawLabel"===smartClientClassName) {
			return "com.smartgwt.client.widgets.drawing.DrawLabel";
		} else     	if("RecordEditor"===smartClientClassName) {
			return "com.smartgwt.client.widgets.grid.RecordEditor";
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
    	if("DrawShape".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawShape.class;
		} else     	if("ZoneCanvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.ZoneCanvas.class;
		} else     	if("SpacerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SpacerItem.class;
		} else     	if("BlurbItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.BlurbItem.class;
		} else     	if("HStack".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.HStack.class;
		} else     	if("Timeline".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.Timeline.class;
		} else     	if("FieldPicker".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.FieldPicker.class;
		} else     	if("NativeCheckboxItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.NativeCheckboxItem.class;
		} else     	if("ToolStripMenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripMenuButton.class;
		} else     	if("EdgedCanvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.EdgedCanvas.class;
		} else     	if("AutoFitTextAreaItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem.class;
		} else     	if("TabSet".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tab.TabSet.class;
		} else     	if("DrawKnob".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawKnob.class;
		} else     	if("Label".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Label.class;
		} else     	if("MenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.MenuButton.class;
		} else     	if("SpinnerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SpinnerItem.class;
		} else     	if("IPickTreeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.IPickTreeItem.class;
		} else     	if("BaseWidget".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.BaseWidget.class;
		} else     	if("SectionItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SectionItem.class;
		} else     	if("ResetItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ResetItem.class;
		} else     	if("Window".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Window.class;
		} else     	if("IconButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.IconButton.class;
		} else     	if("SectionHeader".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.SectionHeader.class;
		} else     	if("DateGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.DateGrid.class;
		} else     	if("StatefulCanvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.StatefulCanvas.class;
		} else     	if("LinkItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.LinkItem.class;
		} else     	if("RichTextItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.RichTextItem.class;
		} else     	if("GridRenderer".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.GridRenderer.class;
		} else     	if("DrawPath".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawPath.class;
		} else     	if("BrowserPlugin".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.plugins.BrowserPlugin.class;
		} else     	if("FieldPickerWindow".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.FieldPickerWindow.class;
		} else     	if("MenuBar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.MenuBar.class;
		} else     	if("RangeSlider".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.RangeSlider.class;
		} else     	if("Button".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Button.class;
		} else     	if("RowSpacerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.RowSpacerItem.class;
		} else     	if("TimeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.TimeItem.class;
		} else     	if("CanvasItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.CanvasItem.class;
		} else     	if("Portlet".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.Portlet.class;
		} else     	if("Scrollbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Scrollbar.class;
		} else     	if("DrawPolygon".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawPolygon.class;
		} else     	if("DateRangeDialog".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.DateRangeDialog.class;
		} else     	if("DrawItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawItem.class;
		} else     	if("HTMLFlow".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.HTMLFlow.class;
		} else     	if("TabBar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tab.TabBar.class;
		} else     	if("DetailViewer".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.viewer.DetailViewer.class;
		} else     	if("MultiSortDialog".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.MultiSortDialog.class;
		} else     	if("HiliteRule".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.HiliteRule.class;
		} else     	if("TextItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.TextItem.class;
		} else     	if("UploadItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.UploadItem.class;
		} else     	if("PortalLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.PortalLayout.class;
		} else     	if("Progressbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Progressbar.class;
		} else     	if("ViewFileItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ViewFileItem.class;
		} else     	if("IButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.IButton.class;
		} else     	if("FilterBuilder".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.FilterBuilder.class;
		} else     	if("ToolStrip".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStrip.class;
		} else     	if("MultiGroupPanel".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.MultiGroupPanel.class;
		} else     	if("FilterClause".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.FilterClause.class;
		} else     	if("DateRangeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.DateRangeItem.class;
		} else     	if("ImgSplitbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.ImgSplitbar.class;
		} else     	if("TreeGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tree.TreeGrid.class;
		} else     	if("SelectItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SelectItem.class;
		} else     	if("Snapbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Snapbar.class;
		} else     	if("ListPalette".equals(smartClientClassName)){
			return com.smartgwt.client.tools.ListPalette.class;
		} else     	if("AdvancedHiliteEditor".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.AdvancedHiliteEditor.class;
		} else     	if("SliderItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SliderItem.class;
		} else     	if("NavigationButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.NavigationButton.class;
		} else     	if("VStack".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.VStack.class;
		} else     	if("ViewLoader".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.ViewLoader.class;
		} else     	if("TextAreaItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.TextAreaItem.class;
		} else     	if("Slider".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Slider.class;
		} else     	if("FileItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.FileItem.class;
		} else     	if("ComboBoxItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ComboBoxItem.class;
		} else     	if("ListPropertiesDialog".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.rte.ListPropertiesDialog.class;
		} else     	if("PickTreeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.PickTreeItem.class;
		} else     	if("PrintWindow".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.PrintWindow.class;
		} else     	if("ColorPickerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ColorPickerItem.class;
		} else     	if("StretchImg".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.StretchImg.class;
		} else     	if("TilePalette".equals(smartClientClassName)){
			return com.smartgwt.client.tools.TilePalette.class;
		} else     	if("MultiFilePicker".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.MultiFilePicker.class;
		} else     	if("PropertySheet".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.PropertySheet.class;
		} else     	if("SearchForm".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.SearchForm.class;
		} else     	if("PresetDateRangeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.PresetDateRangeItem.class;
		} else     	if("ListPropertiesPane".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.rte.ListPropertiesPane.class;
		} else     	if("ToolStripSpacer".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripSpacer.class;
		} else     	if("EventCanvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.EventCanvas.class;
		} else     	if("SubmitItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SubmitItem.class;
		} else     	if("PickListMenu".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.PickListMenu.class;
		} else     	if("ActiveXControl".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.plugins.ActiveXControl.class;
		} else     	if("DateChooser".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.DateChooser.class;
		} else     	if("BatchUploader".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.BatchUploader.class;
		} else     	if("StretchImgButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.StretchImgButton.class;
		} else     	if("DrawLine".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawLine.class;
		} else     	if("Dialog".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Dialog.class;
		} else     	if("TableView".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tableview.TableView.class;
		} else     	if("StaticTextItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.StaticTextItem.class;
		} else     	if("IconMenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.IconMenuButton.class;
		} else     	if("VisualBuilder".equals(smartClientClassName)){
			return com.smartgwt.client.tools.VisualBuilder.class;
		} else     	if("DrawDiamond".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawDiamond.class;
		} else     	if("MiniNavControl".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.MiniNavControl.class;
		} else     	if("TileGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tile.TileGrid.class;
		} else     	if("NavigationBar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.NavigationBar.class;
		} else     	if("Sound".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Sound.class;
		} else     	if("ColorPicker".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.ColorPicker.class;
		} else     	if("EditPane".equals(smartClientClassName)){
			return com.smartgwt.client.tools.EditPane.class;
		} else     	if("HiddenItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.HiddenItem.class;
		} else     	if("Deck".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.Deck.class;
		} else     	if("Toolbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.Toolbar.class;
		} else     	if("DrawLinePath".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawLinePath.class;
		} else     	if("DrawImage".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawImage.class;
		} else     	if("RichTextEditor".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.RichTextEditor.class;
		} else     	if("BooleanItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.BooleanItem.class;
		} else     	if("RadioGroupItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.RadioGroupItem.class;
		} else     	if("DrawBlockConnector".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawBlockConnector.class;
		} else     	if("SplitPane".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.SplitPane.class;
		} else     	if("ImgSectionHeader".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.ImgSectionHeader.class;
		} else     	if("RibbonBar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.RibbonBar.class;
		} else     	if("RelativeDateItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.RelativeDateItem.class;
		} else     	if("HLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.HLayout.class;
		} else     	if("Calendar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.Calendar.class;
		} else     	if("HiliteEditor".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.HiliteEditor.class;
		} else     	if("ListGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.ListGrid.class;
		} else     	if("FlowLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.FlowLayout.class;
		} else     	if("EventWindow".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.EventWindow.class;
		} else     	if("DateTimeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.DateTimeItem.class;
		} else     	if("AdaptiveMenu".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.AdaptiveMenu.class;
		} else     	if("FloatItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.FloatItem.class;
		} else     	if("Gauge".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.Gauge.class;
		} else     	if("HeaderItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.HeaderItem.class;
		} else     	if("DrawOval".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawOval.class;
		} else     	if("MultiFileItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.MultiFileItem.class;
		} else     	if("DrawTriangle".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawTriangle.class;
		} else     	if("ImgButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.ImgButton.class;
		} else     	if("ToolStripGroup".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripGroup.class;
		} else     	if("CubeGrid".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.cube.CubeGrid.class;
		} else     	if("SVG".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.plugins.SVG.class;
		} else     	if("IMenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.IMenuButton.class;
		} else     	if("DrawRect".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawRect.class;
		} else     	if("TreePalette".equals(smartClientClassName)){
			return com.smartgwt.client.tools.TreePalette.class;
		} else     	if("TileLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tile.TileLayout.class;
		} else     	if("SelectionTreeMenu".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.SelectionTreeMenu.class;
		} else     	if("DynamicForm".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.DynamicForm.class;
		} else     	if("PasswordItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.PasswordItem.class;
		} else     	if("ImgTab".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tab.ImgTab.class;
		} else     	if("LayoutSpacer".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.LayoutSpacer.class;
		} else     	if("ToolbarItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ToolbarItem.class;
		} else     	if("FacetChart".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.chart.FacetChart.class;
		} else     	if("IntegerItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.IntegerItem.class;
		} else     	if("SimpleTile".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.tile.SimpleTile.class;
		} else     	if("DateItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.DateItem.class;
		} else     	if("MenuPalette".equals(smartClientClassName)){
			return com.smartgwt.client.tools.MenuPalette.class;
		} else     	if("DrawGroup".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawGroup.class;
		} else     	if("DrawSector".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawSector.class;
		} else     	if("MiniDateRangeItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.MiniDateRangeItem.class;
		} else     	if("DoubleItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.DoubleItem.class;
		} else     	if("DrawPane".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawPane.class;
		} else     	if("CheckboxItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.CheckboxItem.class;
		} else     	if("Menu".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.Menu.class;
		} else     	if("Layout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.Layout.class;
		} else     	if("MultiSortPanel".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.MultiSortPanel.class;
		} else     	if("ToolStripResizer".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripResizer.class;
		} else     	if("NavPanel".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.NavPanel.class;
		} else     	if("Canvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Canvas.class;
		} else     	if("ColorItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ColorItem.class;
		} else     	if("SelectOtherItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.SelectOtherItem.class;
		} else     	if("MultiGroupDialog".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.MultiGroupDialog.class;
		} else     	if("ToolStripSeparator".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripSeparator.class;
		} else     	if("HTMLPane".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.HTMLPane.class;
		} else     	if("MultiComboBoxItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.MultiComboBoxItem.class;
		} else     	if("SectionStack".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.SectionStack.class;
		} else     	if("AceEditor".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.ace.AceEditor.class;
		} else     	if("DataView".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.DataView.class;
		} else     	if("TreeMenuButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.menu.TreeMenuButton.class;
		} else     	if("DrawCurve".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawCurve.class;
		} else     	if("IndicatorCanvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.IndicatorCanvas.class;
		} else     	if("ColumnTree".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.ColumnTree.class;
		} else     	if("PrintCanvas".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.PrintCanvas.class;
		} else     	if("RibbonGroup".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.RibbonGroup.class;
		} else     	if("VLayout".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.layout.VLayout.class;
		} else     	if("CalendarView".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.calendar.CalendarView.class;
		} else     	if("Splitbar".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Splitbar.class;
		} else     	if("ToolStripButton".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.toolbar.ToolStripButton.class;
		} else     	if("EditTree".equals(smartClientClassName)){
			return com.smartgwt.client.tools.EditTree.class;
		} else     	if("ButtonItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.fields.ButtonItem.class;
		} else     	if("Img".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.Img.class;
		} else     	if("PresetCriteriaItem".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.form.PresetCriteriaItem.class;
		} else     	if("Flashlet".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.plugins.Flashlet.class;
		} else     	if("DrawLabel".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.drawing.DrawLabel.class;
		} else     	if("RecordEditor".equals(smartClientClassName)){
			return com.smartgwt.client.widgets.grid.RecordEditor.class;
		} else 
        { return null; }
    };

    /* No need to create instances of this class. */
    private ObjectFactory(){}
}
