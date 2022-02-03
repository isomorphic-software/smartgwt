package com.smartgwt.sample.showcase.client.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.smartgwt.client.util.SC;
import com.smartgwt.sample.showcase.client.DebugConsoleCommand;
import com.smartgwt.sample.showcase.client.ShowcaseConfiguration;
import com.smartgwt.sample.showcase.client.ShowcaseMessages;
import com.smartgwt.sample.showcase.client.autotest.effects.dragdrop.TestablePortletAcrossWindowsSample;
import com.smartgwt.sample.showcase.client.autotest.effects.dragdrop.TestableRecordsAcrossWindowsSample;
import com.smartgwt.sample.showcase.client.basics.components.CreateSample;
import com.smartgwt.sample.showcase.client.basics.components.LayerSample;
import com.smartgwt.sample.showcase.client.basics.components.LayoutSample;
import com.smartgwt.sample.showcase.client.basics.components.MoveSample;
import com.smartgwt.sample.showcase.client.basics.components.ResizeSample;
import com.smartgwt.sample.showcase.client.basics.components.ShowHideSample;
import com.smartgwt.sample.showcase.client.basics.components.StackSample;
import com.smartgwt.sample.showcase.client.basics.html.DynamicHTMLSample;
import com.smartgwt.sample.showcase.client.basics.html.HTMLFlowSample;
import com.smartgwt.sample.showcase.client.basics.html.HTMLPaneSample;
import com.smartgwt.sample.showcase.client.basics.html.IFramesSample;
import com.smartgwt.sample.showcase.client.basics.html.ImgSample;
import com.smartgwt.sample.showcase.client.basics.html.LabelSample;
import com.smartgwt.sample.showcase.client.basics.html.LoadImagesSample;
import com.smartgwt.sample.showcase.client.basics.html.RichTextEditorSample;
import com.smartgwt.sample.showcase.client.basics.html.SVGImgSample;
import com.smartgwt.sample.showcase.client.basics.interaction.BasicCustomTabOrderSample;
import com.smartgwt.sample.showcase.client.basics.interaction.BasicFocusTabbingSample;
import com.smartgwt.sample.showcase.client.basics.interaction.ContextMenuSample;
import com.smartgwt.sample.showcase.client.basics.interaction.CustomComponentTabOrderSample;
import com.smartgwt.sample.showcase.client.basics.interaction.DragEventsSample;
import com.smartgwt.sample.showcase.client.basics.interaction.HoversTooltipsSample;
import com.smartgwt.sample.showcase.client.basics.interaction.MouseEventsSample;
import com.smartgwt.sample.showcase.client.basics.interaction.SelectContentSample;
import com.smartgwt.sample.showcase.client.basics.sounds.AudioPlaybackSample;
import com.smartgwt.sample.showcase.client.basics.sounds.AudioNotificationsSample;
import com.smartgwt.sample.showcase.client.buttons.ButtonAppearanceSample;
import com.smartgwt.sample.showcase.client.buttons.ButtonAutoFitSample;
import com.smartgwt.sample.showcase.client.buttons.ButtonIconsSample;
import com.smartgwt.sample.showcase.client.buttons.ButtonRadioToggleSample;
import com.smartgwt.sample.showcase.client.buttons.ButtonStatesSample;
import com.smartgwt.sample.showcase.client.buttons.ButtonAdaptiveWidthSample;
import com.smartgwt.sample.showcase.client.calendar.AutoArrangeEventsCalendarSample;
import com.smartgwt.sample.showcase.client.calendar.CalendarDateTimeFormatSample;
import com.smartgwt.sample.showcase.client.calendar.CompactCalendarSample;
import com.smartgwt.sample.showcase.client.calendar.CustomEventCalendarSample;
import com.smartgwt.sample.showcase.client.calendar.DataBoundCalendarSample;
import com.smartgwt.sample.showcase.client.calendar.DataBoundTimelineSample;
import com.smartgwt.sample.showcase.client.calendar.OverlappingEventsCalendarSample;
import com.smartgwt.sample.showcase.client.calendar.SimpleCalendarSample;
import com.smartgwt.sample.showcase.client.calendar.EventSelectionCalendarSample;
import com.smartgwt.sample.showcase.client.calendar.SimpleTimelineSample;
import com.smartgwt.sample.showcase.client.calendar.ColumnLayoutsSample;
import com.smartgwt.sample.showcase.client.calendar.SimpleEventComponentsSample;
import com.smartgwt.sample.showcase.client.calendar.TimelineFilteringSample;
import com.smartgwt.sample.showcase.client.calendar.TimelineGroupingSample;
import com.smartgwt.sample.showcase.client.calendar.TimelineResolutionSample;
import com.smartgwt.sample.showcase.client.calendar.TimelineZonesAndIndicatorsSample;
import com.smartgwt.sample.showcase.client.calendar.WorkdayCalendarSample;
import com.smartgwt.sample.showcase.client.combobox.ComboBoxSpecialValuesSample;
import com.smartgwt.sample.showcase.client.combobox.SelectCustomInlineControlsSample;
import com.smartgwt.sample.showcase.client.combobox.ComboBoxStyledSample;
import com.smartgwt.sample.showcase.client.combobox.DropdownListGridSample;
import com.smartgwt.sample.showcase.client.combobox.FormatDropDownSample;
import com.smartgwt.sample.showcase.client.combobox.FormatRelatedValueSample;
import com.smartgwt.sample.showcase.client.combobox.LocalAndDataboundComboBoxSample;
import com.smartgwt.sample.showcase.client.combobox.MultiComboBoxSample;
import com.smartgwt.sample.showcase.client.combobox.MultiFieldSearchSample;
import com.smartgwt.sample.showcase.client.combobox.PickTreeFieldSample;
import com.smartgwt.sample.showcase.client.combobox.DropdownTreeSample;
import com.smartgwt.sample.showcase.client.combobox.SelectMultipleSample;
import com.smartgwt.sample.showcase.client.combobox.SelectOtherFieldSample;
import com.smartgwt.sample.showcase.client.combobox.SelectedValueComboBoxSample;
import com.smartgwt.sample.showcase.client.dataintegration.json.FormServerJsonValidationSample;
import com.smartgwt.sample.showcase.client.dataintegration.json.JsonSimpleSample;
import com.smartgwt.sample.showcase.client.dataintegration.json.JsonXPathSample;
import com.smartgwt.sample.showcase.client.dataintegration.json.RestfulJsonDataSourceSample;
import com.smartgwt.sample.showcase.client.dataintegration.xml.FormServerXmlValidationSample;
import com.smartgwt.sample.showcase.client.dataintegration.xml.RestfulDataSourceSample;
import com.smartgwt.sample.showcase.client.dataintegration.xml.XmlXPathSample;
import com.smartgwt.sample.showcase.client.drawing.DrawingMouseEventsSample;
import com.smartgwt.sample.showcase.client.drawing.DrawItemKnobsSample;
import com.smartgwt.sample.showcase.client.drawing.GaugeSample;
import com.smartgwt.sample.showcase.client.drawing.LinesAndArrowheadsSample;
import com.smartgwt.sample.showcase.client.drawing.RotationSample;
import com.smartgwt.sample.showcase.client.drawing.TitleRotationModeSample;
import com.smartgwt.sample.showcase.client.drawing.ShapeGallerySample;
import com.smartgwt.sample.showcase.client.drawing.CustomCanvasSample;
import com.smartgwt.sample.showcase.client.drawing.ZoomAndPanSample;
import com.smartgwt.sample.showcase.client.drawing.gradients.LinearGradientSample;
import com.smartgwt.sample.showcase.client.drawing.gradients.RadialGradientSample;
import com.smartgwt.sample.showcase.client.drawing.gradients.SimpleGradientSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateComplexSequenceSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateFadeSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateLayoutSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateMoveSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateResizeSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateSequenceSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateSlideSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateTreeSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateWindowMinimizeSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateWipeSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimateZoomSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimationCustomSample;
import com.smartgwt.sample.showcase.client.effects.animation.AnimationPlaypenSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragCreateSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragEffectsSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragListCopySample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragListMoveSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragListSelectSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragMenuGridSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragMoveImageSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragPanSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragResizeSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragSnapToGridSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragTilesMoveSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragTrackerSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.DragTypesSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.NativeDragCreateSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.PortletAcrossWindowsSample;
import com.smartgwt.sample.showcase.client.effects.dragdrop.RecordsAcrossWindowsSample;
import com.smartgwt.sample.showcase.client.effects.looknfeel.CornersSample;
import com.smartgwt.sample.showcase.client.effects.looknfeel.CssStylesSample;
import com.smartgwt.sample.showcase.client.effects.looknfeel.EdgesSample;
import com.smartgwt.sample.showcase.client.effects.looknfeel.ShadowsSample;
import com.smartgwt.sample.showcase.client.effects.looknfeel.TranslucencySample;
import com.smartgwt.sample.showcase.client.forms.CustomPickerSample;
import com.smartgwt.sample.showcase.client.forms.FormDataBindingSample;
import com.smartgwt.sample.showcase.client.forms.FormFocusFirstSample;
import com.smartgwt.sample.showcase.client.forms.ListGridItemSample;
import com.smartgwt.sample.showcase.client.forms.NestedEditorSample;
import com.smartgwt.sample.showcase.client.forms.PickerControlsSample;
import com.smartgwt.sample.showcase.client.forms.TextMaskingSample;
import com.smartgwt.sample.showcase.client.forms.PickTreeSample;
import com.smartgwt.sample.showcase.client.forms.controls.FormVariousControlsSample;
import com.smartgwt.sample.showcase.client.forms.dependencies.FormConditionallyRequiredSample;
import com.smartgwt.sample.showcase.client.forms.dependencies.FormDataboundDependentSelectsSample;
import com.smartgwt.sample.showcase.client.forms.dependencies.FormDependentSelectsSample;
import com.smartgwt.sample.showcase.client.forms.dependencies.FormEnableDisableSample;
import com.smartgwt.sample.showcase.client.forms.dependencies.FormMatchValueSample;
import com.smartgwt.sample.showcase.client.forms.dependencies.FormShowHideSample;
import com.smartgwt.sample.showcase.client.forms.dependencies.FormFormulaFieldsSample;
import com.smartgwt.sample.showcase.client.forms.details.FormHintsSample;
import com.smartgwt.sample.showcase.client.forms.details.FormHoversSample;
import com.smartgwt.sample.showcase.client.forms.details.FormIconsSample;
import com.smartgwt.sample.showcase.client.forms.details.ShowIconsOnFocusSample;
import com.smartgwt.sample.showcase.client.forms.details.KeyPressFiltersSample;
import com.smartgwt.sample.showcase.client.forms.details.PendingValuesSample;
import com.smartgwt.sample.showcase.client.forms.details.CanvasItemShowPendingSupportSample;
import com.smartgwt.sample.showcase.client.forms.layout.FormFillingSample;
import com.smartgwt.sample.showcase.client.forms.layout.FormSectionsSample;
import com.smartgwt.sample.showcase.client.forms.layout.FormSpanningSample;
import com.smartgwt.sample.showcase.client.forms.layout.FormSplittingSample;
import com.smartgwt.sample.showcase.client.forms.layout.FormTitlesSample;
import com.smartgwt.sample.showcase.client.forms.validation.FormBuiltinsSample;
import com.smartgwt.sample.showcase.client.forms.validation.FormRegularExpressionSample;
import com.smartgwt.sample.showcase.client.forms.validation.FormTypeSample;
import com.smartgwt.sample.showcase.client.forms.validation.FormValueTransformSample;
import com.smartgwt.sample.showcase.client.grid.GridCellWidgetsSample;
import com.smartgwt.sample.showcase.client.grid.GridDataBoundDragDropSample;
import com.smartgwt.sample.showcase.client.grid.GridDependentSelectsSample;
import com.smartgwt.sample.showcase.client.grid.GridFilterBulderSample;
import com.smartgwt.sample.showcase.client.grid.GridMultiLineSummariesSample;
import com.smartgwt.sample.showcase.client.grid.GridNestedFilterBulderSample;
import com.smartgwt.sample.showcase.client.grid.AdditiveFilterSample;
import com.smartgwt.sample.showcase.client.grid.GridSummariesInHeaderSample;
import com.smartgwt.sample.showcase.client.grid.GridSummariesSample;
import com.smartgwt.sample.showcase.client.grid.LiveGridFetchSample;
import com.smartgwt.sample.showcase.client.grid.appearance.AlternateRecordStyleSample;
import com.smartgwt.sample.showcase.client.grid.appearance.AnimatedSelectionSample;
import com.smartgwt.sample.showcase.client.grid.appearance.CellStylesSample;
import com.smartgwt.sample.showcase.client.grid.appearance.ColumnAlignSample;
import com.smartgwt.sample.showcase.client.grid.appearance.ColumnHeadersSample;
import com.smartgwt.sample.showcase.client.grid.appearance.ColumnOrderSample;
import com.smartgwt.sample.showcase.client.grid.appearance.ColumnSizeSample;
import com.smartgwt.sample.showcase.client.grid.appearance.ColumnTitlesSample;
import com.smartgwt.sample.showcase.client.grid.appearance.RotatedTitlesSample;
import com.smartgwt.sample.showcase.client.grid.appearance.CustomHeaderMenuSample;
import com.smartgwt.sample.showcase.client.grid.appearance.EmptyGridSample;
import com.smartgwt.sample.showcase.client.grid.appearance.EmptyValuesSample;
import com.smartgwt.sample.showcase.client.grid.appearance.FieldPickerSample;
import com.smartgwt.sample.showcase.client.grid.appearance.FormatValuesBuiltinSample;
import com.smartgwt.sample.showcase.client.grid.appearance.FormatValuesSample;
import com.smartgwt.sample.showcase.client.grid.appearance.FormulaSummaryBuilderSample;
import com.smartgwt.sample.showcase.client.grid.appearance.GridComponentsSample;
import com.smartgwt.sample.showcase.client.grid.appearance.GridHeaderSpansSample;
import com.smartgwt.sample.showcase.client.grid.appearance.GridPreferencesSample;
import com.smartgwt.sample.showcase.client.grid.appearance.GridAutomaticPreferencesSample;
import com.smartgwt.sample.showcase.client.grid.appearance.GridTopHeaderSample;
import com.smartgwt.sample.showcase.client.grid.appearance.HiliteCellsAddStyleSample;
import com.smartgwt.sample.showcase.client.grid.appearance.HiliteCellsReplaceStyleSample;
import com.smartgwt.sample.showcase.client.grid.appearance.MultilineSample;
import com.smartgwt.sample.showcase.client.grid.appearance.RollOverControlsSample;
import com.smartgwt.sample.showcase.client.grid.appearance.RowNumberingSample;
import com.smartgwt.sample.showcase.client.grid.appearance.CustomToolbarSample;
import com.smartgwt.sample.showcase.client.grid.autofit.AutofitColumnWidthsSample;
import com.smartgwt.sample.showcase.client.grid.autofit.AutofitWrappedTitlesSample;
import com.smartgwt.sample.showcase.client.grid.autofit.AutofitColumnsSample;
import com.smartgwt.sample.showcase.client.grid.autofit.AutofitFilterSample;
import com.smartgwt.sample.showcase.client.grid.autofit.AutofitNewRecordsSample;
import com.smartgwt.sample.showcase.client.grid.autofit.AutofitRowsSample;
import com.smartgwt.sample.showcase.client.grid.autofit.AutofitValuesSample;
import com.smartgwt.sample.showcase.client.grid.autofit.FreeSpaceSample;
import com.smartgwt.sample.showcase.client.grid.autofit.AutofitMinsMaxsSample;
import com.smartgwt.sample.showcase.client.menu.*;
import com.smartgwt.sample.showcase.client.mobile.DialingSample;
import com.smartgwt.sample.showcase.client.mobile.ResponsiveDesign;
import com.smartgwt.sample.showcase.client.mobile.NavigationBarSample;
import com.smartgwt.sample.showcase.client.mobile.MobileAnimatedTransitionsSample;
import com.smartgwt.sample.showcase.client.mobile.SpinnerControlSample;
import com.smartgwt.sample.showcase.client.mobile.MobileMenusSample;
import com.smartgwt.sample.showcase.client.mobile.MobileSelectListSample;
import com.smartgwt.sample.showcase.client.mobile.MobileComboBoxSample;
import com.smartgwt.sample.showcase.client.mobile.MobileWindowsDialogsSample;
import com.smartgwt.sample.showcase.client.mobile.MobileCalendarSample;
import com.smartgwt.sample.showcase.client.mobile.AdaptiveMenuSample;
import com.smartgwt.sample.showcase.client.mobile.InlinedMenuSample;
import com.smartgwt.sample.showcase.client.mobile.AdaptiveFormsSample;
import com.smartgwt.sample.showcase.client.grid.databinding.GridDataBindingDataSourceFieldsSample;
import com.smartgwt.sample.showcase.client.grid.databinding.GridDataBindingInlineDataSample;
import com.smartgwt.sample.showcase.client.grid.databinding.GridDataBindingJSONDataSourceSample;
import com.smartgwt.sample.showcase.client.grid.databinding.GridDataBindingListGridFieldsSample;
import com.smartgwt.sample.showcase.client.grid.databinding.GridDataBindingLocalDataSourceSample;
import com.smartgwt.sample.showcase.client.grid.databinding.GridDataBindingRecategorizeSample;
import com.smartgwt.sample.showcase.client.grid.databinding.GridDataBindingMergedFieldsSample;
import com.smartgwt.sample.showcase.client.grid.databinding.GridDataBindingXMLDataSourceSample;
import com.smartgwt.sample.showcase.client.grid.dataoperation.GridDataBoundAddSample;
import com.smartgwt.sample.showcase.client.grid.dataoperation.GridDataBoundFetchSample;
import com.smartgwt.sample.showcase.client.grid.dataoperation.GridDataBoundFilterSample;
import com.smartgwt.sample.showcase.client.grid.dataoperation.GridDataBoundRemoveSample;
import com.smartgwt.sample.showcase.client.grid.dataoperation.GridDataBoundUpdateSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesBooleanSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesCalculatedSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesDateSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesDecimalSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesImageSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesIntegerSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesLinkImageSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesLinkTextSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesListSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesLongTextSample;
import com.smartgwt.sample.showcase.client.grid.datatypes.GridDataTypesTextSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridCellEditorCustomizerSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridCustomEditorsSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridDataValidationSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridDisableEditingSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridEditAllRowsSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridEditByCellSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridEditByRowSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridEnterNewRowSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridMassUpdateSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridModalEditingSample;
import com.smartgwt.sample.showcase.client.grid.editing.GridEditorFormulaSample;
import com.smartgwt.sample.showcase.client.grid.excel.ExcelToGridSample;
import com.smartgwt.sample.showcase.client.grid.excel.GridToExcelSample;
import com.smartgwt.sample.showcase.client.grid.excel.GridToGridSample;
import com.smartgwt.sample.showcase.client.grid.expando.GridRowExpansionDetailFieldSample;
import com.smartgwt.sample.showcase.client.grid.expando.GridRowExpansionDetailsSample;
import com.smartgwt.sample.showcase.client.grid.expando.GridRowExpansionEditorSample;
import com.smartgwt.sample.showcase.client.grid.expando.GridRowExpansionRelatedRecordsSample;
import com.smartgwt.sample.showcase.client.grid.frozen.GridDragDropFreezeSample;
import com.smartgwt.sample.showcase.client.grid.frozen.GridDynamicFreezeSample;
import com.smartgwt.sample.showcase.client.grid.frozen.GridEditFreezeSample;
import com.smartgwt.sample.showcase.client.grid.frozen.GridSimpleFreezeSample;
import com.smartgwt.sample.showcase.client.grid.gridform.GridFormAddSample;
import com.smartgwt.sample.showcase.client.grid.gridform.GridFormUpdateSample;
import com.smartgwt.sample.showcase.client.grid.gridform.GridRecordRemoveSample;
import com.smartgwt.sample.showcase.client.grid.gridform.XsdDataSourceSample;
import com.smartgwt.sample.showcase.client.grid.grouping.GridCustomGroupingSample;
import com.smartgwt.sample.showcase.client.grid.grouping.GridDynamicGroupingSample;
import com.smartgwt.sample.showcase.client.grid.grouping.GridGroupingModesSample;
import com.smartgwt.sample.showcase.client.grid.grouping.GroupedEditingSample;
import com.smartgwt.sample.showcase.client.grid.grouping.MultiGroupingSample;
import com.smartgwt.sample.showcase.client.grid.grouping.CustomGroupSortingSample;
import com.smartgwt.sample.showcase.client.grid.hiliting.GridDataDrivenHilitingSample;
import com.smartgwt.sample.showcase.client.grid.hiliting.GridFormulaHilitingSample;
import com.smartgwt.sample.showcase.client.grid.hiliting.GridPredefinedHilitingSample;
import com.smartgwt.sample.showcase.client.grid.hiliting.GridUserDefinedHilitingSample;
import com.smartgwt.sample.showcase.client.grid.cellWidgets.ReplacingRowsSample;
import com.smartgwt.sample.showcase.client.grid.cellWidgets.RecordWidgetsSample;
import com.smartgwt.sample.showcase.client.grid.hover.GridCustomHoverSample;
import com.smartgwt.sample.showcase.client.grid.hover.GridHoverRelatedRecordsSample;
import com.smartgwt.sample.showcase.client.grid.interaction.CellClicksSample;
import com.smartgwt.sample.showcase.client.grid.interaction.CellSelectionSample;
import com.smartgwt.sample.showcase.client.grid.interaction.SelectCellTextClickSample;
import com.smartgwt.sample.showcase.client.grid.interaction.SelectCellTextDragSample;
import com.smartgwt.sample.showcase.client.grid.interaction.CheckboxSelectSample;
import com.smartgwt.sample.showcase.client.grid.interaction.DisabledRowsSample;
import com.smartgwt.sample.showcase.client.grid.interaction.DragCopySample;
import com.smartgwt.sample.showcase.client.grid.interaction.TouchDragSample;
import com.smartgwt.sample.showcase.client.grid.interaction.DragMoveSample;
import com.smartgwt.sample.showcase.client.grid.interaction.DragReorderSample;
import com.smartgwt.sample.showcase.client.grid.interaction.DragSelectSample;
import com.smartgwt.sample.showcase.client.grid.interaction.HeaderHoverTipsSample;
import com.smartgwt.sample.showcase.client.grid.interaction.MultipleSelectSample;
import com.smartgwt.sample.showcase.client.grid.interaction.RecordClicksSample;
import com.smartgwt.sample.showcase.client.grid.interaction.RolloverSample;
import com.smartgwt.sample.showcase.client.grid.interaction.SimpleSelectSample;
import com.smartgwt.sample.showcase.client.grid.interaction.SingleSelectSample;
import com.smartgwt.sample.showcase.client.grid.interaction.ValueHoverTipsSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.AdaptiveFilterSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.GridInlineOperatorFilterSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.AdaptiveSortSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.DisableSortSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.GridBigFilterSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.GridDateRangeFilterSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.GridDateRangePresetsSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.GridDisableFilterSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.GridExpressionFilter;
import com.smartgwt.sample.showcase.client.grid.sortfilter.LoadedValuesSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.GridFilterSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.GridLiveFilterSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.GridSortSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.MultiLevelSortSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.SortArrowsSample;
import com.smartgwt.sample.showcase.client.grid.sortfilter.SortDataTypesSample;
import com.smartgwt.sample.showcase.client.reifyIntegration.ProjectLoadingReifySample;
import com.smartgwt.sample.showcase.client.reifyIntegration.DataSourceSwapReifySample;
import com.smartgwt.sample.showcase.client.reifyIntegration.ExtendingScreensReifySample;
import com.smartgwt.sample.showcase.client.reifyIntegration.ScreenReuseReifySample;
import com.smartgwt.sample.showcase.client.reifyIntegration.HybridDevelopmentReifySample;
import com.smartgwt.sample.showcase.client.reifyIntegration.ScreenInputsReifySample;
import com.smartgwt.sample.showcase.client.reifyIntegration.VerifyingScreensReifySample;
import com.smartgwt.sample.showcase.client.gwtintegration.GwtShowcaseSample;
import com.smartgwt.sample.showcase.client.layout.CenterAlignSample;
import com.smartgwt.sample.showcase.client.layout.NestingSample;
import com.smartgwt.sample.showcase.client.layout.UserSizingSample;
import com.smartgwt.sample.showcase.client.layout.SplitPaneSample;
import com.smartgwt.sample.showcase.client.layout.SplitPaneAutoNavigateSample;
import com.smartgwt.sample.showcase.client.layout.LayoutMinsMaxsSample;
import com.smartgwt.sample.showcase.client.layout.LayoutSnapToSample;
import com.smartgwt.sample.showcase.client.miniapp.MiniAppSample;
import com.smartgwt.sample.showcase.client.mvc.PatternReuseSample;
import com.smartgwt.sample.showcase.client.offline.OfflinePreferencesSample;
import com.smartgwt.sample.showcase.client.other.NotificationSample;
import com.smartgwt.sample.showcase.client.other.DateChooserSample;
import com.smartgwt.sample.showcase.client.other.DialogsSample;
import com.smartgwt.sample.showcase.client.other.ProgressBarSample;
import com.smartgwt.sample.showcase.client.other.SliderSample;
import com.smartgwt.sample.showcase.client.other.TypeReuseSample;
import com.smartgwt.sample.showcase.client.portal.SimplePortalManualSample;
import com.smartgwt.sample.showcase.client.portalLayout.AddRemoveColumnsSample;
import com.smartgwt.sample.showcase.client.portalLayout.PortletAnimationSample;
import com.smartgwt.sample.showcase.client.portalLayout.PortletEventsSample;
import com.smartgwt.sample.showcase.client.portalLayout.RearrangeSample;
import com.smartgwt.sample.showcase.client.portalLayout.portletContents.DragComponentsSample;
import com.smartgwt.sample.showcase.client.portalLayout.portletContents.WindowContentsSample;
import com.smartgwt.sample.showcase.client.portalLayout.sizing.ColumnHeightSample;
import com.smartgwt.sample.showcase.client.portalLayout.sizing.ColumnWidthSample;
import com.smartgwt.sample.showcase.client.portalLayout.sizing.PortletHeightSample;
import com.smartgwt.sample.showcase.client.portalLayout.sizing.PortletResizeSample;
import com.smartgwt.sample.showcase.client.portalLayout.sizing.PortletWidthSample;
import com.smartgwt.sample.showcase.client.printing.PrintingSample;
import com.smartgwt.sample.showcase.client.sections.ExpandCollapseSample;
import com.smartgwt.sample.showcase.client.sections.SectionsAddRemoveSample;
import com.smartgwt.sample.showcase.client.sections.SectionsCustomControlsSample;
import com.smartgwt.sample.showcase.client.sections.SectionsReorderSample;
import com.smartgwt.sample.showcase.client.sections.SectionsResizeSample;
import com.smartgwt.sample.showcase.client.sections.SectionsShowHideSample;
import com.smartgwt.sample.showcase.client.tabs.AddRemoveSample;
import com.smartgwt.sample.showcase.client.tabs.OrientationSample;
import com.smartgwt.sample.showcase.client.tabs.TabsAlignSample;
import com.smartgwt.sample.showcase.client.tabs.TabsCloseableSample;
import com.smartgwt.sample.showcase.client.tabs.TabsCustomControlSample;
import com.smartgwt.sample.showcase.client.tabs.TabsEditableTitlesSample;
import com.smartgwt.sample.showcase.client.tabs.TabsTitleChangeSample;
import com.smartgwt.sample.showcase.client.tabs.TabsSelectionDeselectionSample;
import com.smartgwt.sample.showcase.client.tiling.BasicTilingSample;
import com.smartgwt.sample.showcase.client.tiling.CustomTilesSample;
import com.smartgwt.sample.showcase.client.tiling.FilterSortTilingSample;
import com.smartgwt.sample.showcase.client.tiling.RecategorizeTilingSample;
import com.smartgwt.sample.showcase.client.tiling.LoadOnDemandTilingSample;
import com.smartgwt.sample.showcase.client.tiling.TileEditingSample;
import com.smartgwt.sample.showcase.client.toolstrip.RibbonBarSample;
import com.smartgwt.sample.showcase.client.toolstrip.ToolStripSample;
import com.smartgwt.sample.showcase.client.toolstrip.ToolStripVerticalSample;
import com.smartgwt.sample.showcase.client.tree.CheckboxTreeSample;
import com.smartgwt.sample.showcase.client.tree.FrozenColumnsSample;
import com.smartgwt.sample.showcase.client.tree.MillerColumnsSample;
import com.smartgwt.sample.showcase.client.tree.TreeEditingSample;
import com.smartgwt.sample.showcase.client.tree.TreeSortingSample;
import com.smartgwt.sample.showcase.client.tree.appearance.MultipleColumnsSample;
import com.smartgwt.sample.showcase.client.tree.appearance.NodeTitlesTreeSample;
import com.smartgwt.sample.showcase.client.tree.appearance.TreeConnectorsSample;
import com.smartgwt.sample.showcase.client.tree.appearance.TreePreferencesSample;
import com.smartgwt.sample.showcase.client.tree.databinding.ChildrenArraysTreeSample;
import com.smartgwt.sample.showcase.client.tree.databinding.LoadOnDemandTreeSample;
import com.smartgwt.sample.showcase.client.tree.databinding.LocalDataTreeSample;
import com.smartgwt.sample.showcase.client.tree.databinding.ParentLinkingTreeSample;
import com.smartgwt.sample.showcase.client.tree.databinding.RecategorizeTreeSample;
import com.smartgwt.sample.showcase.client.tree.interaction.TreeDragNodesSample;
import com.smartgwt.sample.showcase.client.tree.interaction.TreeDragReparentSample;
import com.smartgwt.sample.showcase.client.tree.interaction.TreeSpringloadedFoldersSample;
import com.smartgwt.sample.showcase.client.windows.WindowAutoSizeSample;
import com.smartgwt.sample.showcase.client.windows.WindowDraggingSample;
import com.smartgwt.sample.showcase.client.windows.WindowFooterSample;
import com.smartgwt.sample.showcase.client.windows.WindowHeaderControlsSample;
import com.smartgwt.sample.showcase.client.windows.WindowHeaderIconsSample;
import com.smartgwt.sample.showcase.client.windows.WindowMinimizeSample;
import com.smartgwt.sample.showcase.client.windows.WindowModalitySample;

public class ShowcaseData {
    private static final ShowcaseMessages M = ShowcaseMessages.INSTANCE;
    private String idSuffix;

    public ShowcaseData(String idSuffix) {
        this.idSuffix = idSuffix;
    }

    private List<ExplorerTreeNode> data;

    private ExplorerTreeNode[] getData() {
        if (data == null) {
            data = new ArrayList<ExplorerTreeNode>();
            data.addAll(Arrays.asList(new ExplorerTreeNode[] {
                    new ExplorerTreeNode(M.homeNodeName(), "main", "root", "silk/house.png", "silk/house_white.png", true, null, true, idSuffix),
                    new ExplorerTreeNode("Featured Samples", "featured-category", "root", "exampleTree/cube_green.png", null, true, idSuffix),
                    // this is a shortcut to "New samples in XX"
                    new ExplorerTreeNode("New Samples in " + getNewSamplesSuffix(), "new-category-fs", "featured-category", "silk/new.png", null, true, idSuffix),
                    new ExplorerTreeNode("Demo Application", "featured-complete-app", "featured-category", "silk/layout_content.png", new MiniAppSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Smart GWT MVC", "featured-smartgwt-mvc", "featured-category", "silk/arrow_join.png", new TreeEditingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Cell Widgets", "featured-grid-cell-widgets", "featured-category", "silk/application_view_list.png", "silk/application_view_list_bgwhite.png", new GridCellWidgetsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Miller Columns", "featured-miller-columns", "featured-category", "silk/ipod.png", new MillerColumnsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Nested Grid", "featured-nested-grid", "featured-category", "crystal/16/mimetypes/widget_doc.png", new GridRowExpansionRelatedRecordsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Tile Sort &amp; Filtering", "featured-tile-filtering", "featured-category", "silk/application_view_tile.png", "silk/application_view_tile_bgwhite.png", new FilterSortTilingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Print Grid", "featured-print-grid", "featured-category", "silk/printer.png", "silk/printer_bgwhite.png", true, new PrintingSample.Factory(), true, idSuffix),

                    new FolderTreeNode("Reify Integration", "reify-integration", "root", "silk/application_osx.png", true, idSuffix) {{
                                                setDescription(
                                                        "Reify is a “low code” tool that allows non-programmers to build applications in a collaborative, "+
                                                        "web-based environment."+
                                                        "<P>"+
                                                        "Projects created in Reify can be loaded into a SmartClient application with just a single method "+
                                                        "call: <code>Reify.loadProject()</code>."+
                                                        "<P>"+
                                                        "You can use multiple Reify projects as part of a single, larger application.  This approach - "+
                                                        "called hybrid development - lets non-programmers build the simpler parts of your application in a "+
                                                        "visual tool, while developers build other parts with code, as usual."+
                                                        "<P>"+
                                                        "You can even add code to the screens that were built inside Reify, while keeping the screen definition "+
                                                        "in Reify, still able to be edited visually."+
                                                        "<P>"+
                                                        "And, if any screen that was built in Reify need to be taken over by developers, that's easy too - "+
                                                        "Reify just creates standard Component XML screen definitions: concise, easy to understand, and easy to extend."
                                                );
                                            }},                  
                    new ExplorerTreeNode("Project Loading", "project-loading-reify", "reify-integration", "silk/application_osx.png", new ProjectLoadingReifySample.Factory(), false, idSuffix, "13.0"),
                    new ExplorerTreeNode("DataSource Swap", "dataSource-swap-reify", "reify-integration", "silk/application_osx.png", new DataSourceSwapReifySample.Factory(), false, idSuffix, "13.0"),
                    new ExplorerTreeNode("Extending Screens", "extending-screens-reify", "reify-integration", "silk/application_osx.png", new ExtendingScreensReifySample.Factory(), false, idSuffix, "13.0"),
                    new ExplorerTreeNode("Screen Reuse", "screen-reuse-reify", "reify-integration", "silk/application_osx.png", new ScreenReuseReifySample.Factory(), false, idSuffix, "13.0"),
                    new ExplorerTreeNode("Hybrid Development", "hybrid-development-reify", "reify-integration", "silk/application_osx.png", new HybridDevelopmentReifySample.Factory(), false, idSuffix, "13.0"),
                    new ExplorerTreeNode("Screen Inputs", "screen-inputs-reify", "reify-integration", "silk/application_osx.png", new ScreenInputsReifySample.Factory(), false, idSuffix, "13.0"),
                    new ExplorerTreeNode("Verifying Screens", "verifying-screens-reify", "reify-integration", "silk/application_osx.png", new VerifyingScreensReifySample.Factory(), false, idSuffix, "13.0"),
                    new CommandTreeNode("More samples in EE Showcase", "more-samples-in-EE-Showcase", "reify-integration", "silk/application_osx.png", new com.smartgwt.sample.showcase.client.SmartGwtEEReifyCommand(), true, idSuffix),

                    // Disabled for now. We don't want to expose this folder until we have a certain number of samples complete.
                    new ExplorerTreeNode("Mobile samples", "mobile", "root", "silk/phone.png", null, true, idSuffix),   
                    new ExplorerTreeNode("Responsive Design", "responsive-design", "mobile", "silk/calendar.png", new ResponsiveDesign.Factory(), false, idSuffix, "5.0"),
                    new ExplorerTreeNode("Dialing", "dialing", "mobile", "silk/phone.png", new DialingSample.Factory(), false, idSuffix, "5.0"),
                    new FolderTreeNode("Adaptive UI", "adaptive-ui-ms", "mobile", "silk/phone.png", true, idSuffix) {{
                            setDescription(
                                    "Smart GWT components automatically adapt to the smaller screen size and "+
                                    "different pointing behavior of mobile devices. "+
                                    "<p>"+
                                    "Components like Combo Boxes, Menus and Dialogs will automatically use the entire screen "+
                                    "and offer alternative UI for dismissal and navigation (for example: submenus slide in)."+
                                    "<p>"+
                                    "Context menus and hovers can be triggered by finger taps or long touches. "+
                                    "<p>"+
                                    "Because of these and many other automatic behavior changes for mobile devices, you really "+
                                    "can build cross-device applications with a single technology and single codebase."
                            );
                        }},                  
                    new ExplorerTreeNode("Combo Box", "combobox-ms", "adaptive-ui-ms", null, new MobileComboBoxSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Select List", "selectlist-ms", "adaptive-ui-ms", null, new MobileSelectListSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Adaptive Forms", "adaptive-forms-ms", "adaptive-ui-ms", null, new AdaptiveFormsSample.Factory(), true, idSuffix, "13.0"),
                    new ExplorerTreeNode("Menus", "menus-ms", "adaptive-ui-ms", null, new MobileMenusSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Windows &amp; Dialogs", "windows-dialogs-ms", "adaptive-ui-ms", null, new MobileWindowsDialogsSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Calendar", "mobile-calendar-ms", "adaptive-ui-ms", null, new MobileCalendarSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Spinner Control", "spinner-control-ms", "adaptive-ui-ms", null, new SpinnerControlSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Adaptive Menu", "adaptive-menu-ms", "adaptive-ui-ms", null, new AdaptiveMenuSample.Factory(), true, idSuffix, "6.0"),
                    new ExplorerTreeNode("Custom Adaptation", "custom-adaptation-ms", "adaptive-ui-ms", null, new InlinedMenuSample.Factory(), true, idSuffix, "6.0"),
                    new FolderTreeNode("Navigation Bar", "navigation-bar-folder-ms", "mobile", "silk/phone.png", true, idSuffix) {{
                        setDescription(
                                "NavigationBar implements the title and navigation behaviors commonly seem in mobile applications, "+
                                "and is a subcomponent used in the mobile rendering of other mobile-aware component such as " +
                                "SplitPane and Menu."
                        );
                    }},   
                    new ExplorerTreeNode("Title Auto-Fit", "navigation-bar-ms", "navigation-bar-folder-ms", "silk/phone.png", new NavigationBarSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Animated Transitions", "animated-transitions-ms", "navigation-bar-folder-ms", "silk/phone.png", new MobileAnimatedTransitionsSample.Factory(), true, idSuffix, "5.1"),
                    new ExplorerTreeNode("Touch Drag", "grid-interaction-touch-drag-ms", "mobile", null, new TouchDragSample.Factory(), true, idSuffix, "12.0"),

                    new ExplorerTreeNode("Adv. Filter Builder", "featured-filter-builder-grid", "featured-category", "crystal/oo/sc_insertformula.png", "crystal/oo/sc_insertformula_white.png", new GridNestedFilterBulderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Frozen Columns", "featured-tree-grid", "featured-category", "silk/chart_organisation.png", "silk/chart_organisation_white.png", new FrozenColumnsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid Header Spans", "featured-grid-header-span", "featured-category", null, new GridHeaderSpansSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Live Grid", "featured-grid-live", "featured-category", "silk/application_put.png", "silk/application_put_white.png", new LiveGridFetchSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Vertical Tabs", "featured-vertical-tabs", "featured-category", "silk/tab.png", new OrientationSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Calendar", "featured-databound-calendar-category", "featured-category", "crystal/16/apps/cal.png", "crystal/16/apps/cal_white.png", new DataBoundCalendarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dropdown Grid", "featured-dropdown-grid-category", "featured-category", "crystal/16/actions/completion.png", new DropdownListGridSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dynamic Grouping", "featured-dynamic-grouping", "featured-category", "silk/application_side_tree.png", "silk/application_side_tree_bgwhite.png", new GridDynamicGroupingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Animation Playpen", "featured-animation-playpen", "featured-category", "silk/layers.png", new AnimationPlaypenSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Master Detail", "featured-master-detail", "featured-category", "silk/application_split.png", "silk/application_split_white.png", new GridFormUpdateSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("RestDataSource", "featured-restfulds", "featured-category", "silk/arrow_refresh_small.png", new RestfulDataSourceSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Yahoo! JSON Service", "featured-json-integration-category-yahoo", "featured-category", "crystal/16/apps/yahoo_protocol.png", new YahooJsonServicesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Pattern Reuse", "featured-pattern-reuse", "featured-category", "silk/database_table.png", new PatternReuseSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("XSD DataSource", "featured-xsd-ds", "featured-category", "silk/database_gear.png", new XsdDataSourceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("GWT Integration", "featured-gwt-integration", "featured-category", "gwt/icon16.png", new GwtShowcaseSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Dragging", "grid-db-dragging-featured-category", "featured-category", "silk/database_link.png", new GridDataBoundDragDropSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Adaptive Filter", "grid-adaptive-filter-featured-category", "featured-category", "silk/funnel.png", "silk/funnel_white.png", true, new AdaptiveFilterSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Formula &amp; Summary Builder", "formula-sumamry-builder-featured-category", "featured-category", "crystal/oo/sc_insertformula.png", "crystal/oo/sc_insertformula_white.png", new FormulaSummaryBuilderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid Summaries", "grid-summaries-featured-category", "featured-category", "crystal/16/apps/tooloptions.png", "crystal/16/apps/tooloptions_white.png", new GridSummariesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Offline Preferences", "grid-offline-pref-featured-category", "featured-category", "crystal/16/apps/tooloptions.png", new OfflinePreferencesSample.Factory(), true, idSuffix),

                    // New samples since previous release
                    // Note: this node is auto-populated with copies of each node tagged with the current release
                    new ExplorerTreeNode("New Samples in " + getNewSamplesSuffix(), "new-category", "root", "silk/new.png", null, true, idSuffix),

                    // End of new samples
                    
                    new CommandTreeNode("New Enterprise Samples", "smartgwtee-category", "root", "exampleTree/cube_yellow.png", new com.smartgwt.sample.showcase.client.SmartGwtEECommand(), true, idSuffix),

                    new ExplorerTreeNode("ComboBox &amp; Family", "combobox-category", "root", "widgets/combo_box.gif", null, true, idSuffix),
                    new ExplorerTreeNode("Data Binding", "local-db-combobox-combobox-category", "combobox-category", null, new LocalAndDataboundComboBoxSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Related Records", "selected-value-combobox-category", "combobox-category", null, new SelectedValueComboBoxSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dropdown Grid", "dropdown-grid-combobox-category", "combobox-category", null, new DropdownListGridSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Multi-Field Search", "combobox-multifield-search", "combobox-category", null, new MultiFieldSearchSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Multi ComboBox", "multicombobox-category", "combobox-category", null, new MultiComboBoxSample.Factory(), true, idSuffix, "4.1"),
                    new ExplorerTreeNode("Multi-Select", "multi-select-combobox-category", "combobox-category", null, new SelectMultipleSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dropdown Tree", "dropdownTree-combobox-category", "combobox-category", null, new DropdownTreeSample.Factory(), true, idSuffix, "12.0"),    
                    new ExplorerTreeNode("Tree Picker", "picktree-combobox-category", "combobox-category", null, new PickTreeFieldSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dependent Selects (Local)", "dep-selectects-combobox-category", "combobox-category", null, new FormDependentSelectsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dependent Selects (Databound)", "dep-selectects-db-combobox-category", "combobox-category", null, new FormDataboundDependentSelectsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Format Related Value", "format-related-value", "combobox-category", null, new FormatRelatedValueSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Format Dropdown", "format-dropdown", "combobox-category", null, new FormatDropDownSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Styled ComboBox", "styled-combobox-category", "combobox-category", null, new ComboBoxStyledSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Special Values", "specialvalues-combobox-category", "combobox-category", null, new ComboBoxSpecialValuesSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Custom Inline Controls", "custom-inline-controls-combobox-category", "combobox-category", null, new SelectCustomInlineControlsSample.Factory(), true, idSuffix, "6.0"),
                    new ExplorerTreeNode("Add on the fly", "select-other-combobox-category", "combobox-category", null, new SelectOtherFieldSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grids", "grid-category", "root", "silk/application_view_detail.png", null, true, idSuffix),
                    new ExplorerTreeNode("Appearance", "grid-appearance-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Column Order", "grid-appearance-columnorder", "grid-appearance-category", null, new ColumnOrderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Column Size", "grid-appearance-columnsize", "grid-appearance-category", null, new ColumnSizeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Multiline Values", "grid-appearance-multiline", "grid-appearance-category", null, new MultilineSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Header Spans", "grid-appearance-header-spans", "grid-appearance-category", null, new GridHeaderSpansSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Cell Styles", "grid-appearance-cell-styles", "grid-appearance-category", null, new CellStylesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Style Cells (add style)", "grid-appearance-hilite-add", "grid-appearance-category", null, new HiliteCellsAddStyleSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Style Cells (replace style)", "grid-appearance-hilite-replace", "grid-appearance-category", null, new HiliteCellsReplaceStyleSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Rounded Selection", "grid-appearance-rounded-selection", "grid-appearance-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Field Picker", "grid-appearance-field-picker", "grid-appearance-category", null, new FieldPickerSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Animated Selection", "grid-appearance-animated-selection", "grid-appearance-category", null, new AnimatedSelectionSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("RollOver Reticle Effect", "grid-appearance-reticle-selection", "grid-appearance-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("RollOver Controls", "grid-appearance-rollover-controls", "grid-appearance-category", null, new RollOverControlsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Format Values (Declared Formats)", "grid-appearance-format-values-builtin", "grid-appearance-category", null, new FormatValuesBuiltinSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Format Values (Custom Formatting)", "grid-appearance-format-values", "grid-appearance-category", null, new FormatValuesSample.Factory(), true, idSuffix),
                    
                    new ExplorerTreeNode("Empty Values", "grid-appearance-empty-values", "grid-appearance-category", null, new EmptyValuesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Empty Grid", "grid-appearance-empty-grid", "grid-appearance-category", null, new EmptyGridSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Alternate Records", "grid-appearance-alternate", "grid-appearance-category", null, new AlternateRecordStyleSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Column Align", "grid-appearance-columnalign", "grid-appearance-category", null, new ColumnAlignSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Column Header", "grid-appearance-columnheader", "grid-appearance-category", null, new ColumnHeadersSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Column Titles", "grid-appearance-columntitles", "grid-appearance-category", null, new ColumnTitlesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Rotated Titles", "grid-appearance-rotated-titles", "grid-appearance-category", null, new RotatedTitlesSample.Factory(), true, idSuffix, "12.1"),
                    new ExplorerTreeNode("Formula &amp; Summary Builder", "grid-appearance-formula-sumamry-builder", "grid-appearance-category", "crystal/oo/sc_insertformula.png", "crystal/oo/sc_insertformula_white.png", new FormulaSummaryBuilderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Header Context Menu", "grid-appearance-custom-menu", "grid-appearance-category", null, new CustomHeaderMenuSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid Top Header", "grid-top-header", "grid-appearance-category", null, new GridTopHeaderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Row Numbering", "grid-row-numbering", "grid-appearance-category", null, new RowNumberingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Layout", "grid-components", "grid-appearance-category", null, new GridComponentsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Toolbar", "grid-appearance-custom-toolbar", "grid-appearance-category", null, new CustomToolbarSample.Factory(), true, idSuffix, "12.1"),

                    new ExplorerTreeNode("Interaction", "grid-interaction-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Rollover", "grid-interaction-rollover", "grid-interaction-category", null, new RolloverSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Single Select", "grid-interaction-singleselect", "grid-interaction-category", null, new SingleSelectSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Simple Select", "grid-interaction-simpleselect", "grid-interaction-category", null, new SimpleSelectSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Checkbox Select", "grid-interaction-checkboxselect", "grid-interaction-category", "silk/application_side_boxes.png", "silk/application_side_boxes_bgwhite.png", new CheckboxSelectSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Multiple Select", "grid-interaction-multiselect", "grid-interaction-category", null, new MultipleSelectSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Cell Selection", "grid-interaction-cellselection", "grid-interaction-category", null, new CellSelectionSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Select Text (Click)", "grid-interaction-select-text-click", "grid-interaction-category", null, new SelectCellTextClickSample.Factory(), true, idSuffix, "12.1"),
                    new ExplorerTreeNode("Select Text (Drag)", "grid-interaction-select-text-drag", "grid-interaction-category", null, new SelectCellTextDragSample.Factory(), true, idSuffix, "12.1"),
                    new ExplorerTreeNode("Drag Select", "grid-interaction-dragselect", "grid-interaction-category", null, new DragSelectSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Value Hover Tips", "grid-interaction-value-hover", "grid-interaction-category", null, new ValueHoverTipsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Header Hover Tips", "grid-interaction-header-hover", "grid-interaction-category", null, new HeaderHoverTipsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Reorder", "grid-interaction-drag-reorder", "grid-interaction-category", null, new DragReorderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Move", "grid-interaction-drag-move", "grid-interaction-category", null, new DragMoveSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Copy", "grid-interaction-drag-copy", "grid-interaction-category", null, new DragCopySample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Touch Drag", "grid-interaction-touch-drag", "grid-interaction-category", null, new TouchDragSample.Factory(), true, idSuffix, "12.0"),
                    new ExplorerTreeNode("Disabled Rows", "grid-interaction-disabled-rows", "grid-interaction-category", null, new DisabledRowsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Record Clicks", "grid-interaction-record-click", "grid-interaction-category", null, new RecordClicksSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Cell Clicks", "grid-interaction-cell-click", "grid-interaction-category", null, new CellClicksSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Autofit", "grid-autofit-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Free Space", "grid-autofit-space", "grid-autofit-category", null, new FreeSpaceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Cell Values", "grid-autofit-values", "grid-autofit-category", null, new AutofitValuesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Rows", "grid-autofit-rows", "grid-autofit-category", null, new AutofitRowsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Columns", "grid-autofit-columns", "grid-autofit-category", null, new AutofitColumnsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Titles &amp; Data", "grid-autofit-column-widths", "grid-autofit-category", null, new AutofitColumnWidthsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Wrapped Titles", "grid-autofit-wrapped-titles", "grid-autofit-category", null, new AutofitWrappedTitlesSample.Factory(), true, idSuffix, "6.1"),
                    new ExplorerTreeNode("New Records", "grid-autofit-new-records", "grid-autofit-category", null, new AutofitNewRecordsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Filter", "grid-autofit-filter", "grid-autofit-category", null, new AutofitFilterSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Autofit Mins &amp; Maxs", "grid-autofit-mins-maxs", "grid-autofit-category", null, new AutofitMinsMaxsSample.Factory(), true, idSuffix, "6.0"),

                    new ExplorerTreeNode("Sorting", "grid-sort-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Sort", "grid-sort-sort", "grid-sort-category", null, new GridSortSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Multilevel Sort", "grid-multilevel-sort", "grid-sort-category", null, new MultiLevelSortSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Disable Sort", "grid-sort-disable-sort", "grid-sort-category", null, new DisableSortSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Sort Arrows", "grid-sort-sort-arrows", "grid-sort-category", null, new SortArrowsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Data-Aware Sort", "grid-sort-datatypes", "grid-sort-category", null, new SortDataTypesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Adaptive Sort", "grid-sort-adaptive-sort", "grid-sort-category", "silk/table_relationship.png", new AdaptiveSortSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Filtering", "grid-filter-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Filter", "grid-sortfilter-filter", "grid-filter-category", null, new GridFilterSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Live Filter", "grid-sortfilter-live-filter", "grid-filter-category", null, new GridLiveFilterSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Adaptive Filter", "grid-sortfilter-adaptive-filter", "grid-filter-category", "silk/funnel.png", "silk/funnel_white.png", true, new AdaptiveFilterSample.Factory(), true, idSuffix),
                new ExplorerTreeNode("Inline Operator Filter", "grid-sortfilter-inline-operator-filter", "grid-filter-category", null, new GridInlineOperatorFilterSample.Factory(), true, idSuffix, "6.0"),
                    new ExplorerTreeNode("Custom Filter", "grid-custom-filter-builder", "grid-filter-category", null, new GridFilterBulderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Nested Filter", "grid-nested-filter-builder", "grid-filter-category", null, new GridNestedFilterBulderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Additive Filter", "grid-additive-filter-builder", "grid-filter-category", null, new AdditiveFilterSample.Factory(), true, idSuffix, "12.1"),
                    new ExplorerTreeNode("Big Filter", "grid-big-filter", "grid-filter-category", null, new GridBigFilterSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Disable Filter", "grid-sortfilter-disable-filter", "grid-filter-category", null, new GridDisableFilterSample.Factory(), true, idSuffix),
                    
                    new ExplorerTreeNode("Date Range Filtering", "grid-daterange-filtering", "grid-filter-category", null, new GridDateRangeFilterSample.Factory(), true, idSuffix),
                    
                    new ExplorerTreeNode("Date Range (Presets)", "grid-daterange-presets", "grid-filter-category", null, new GridDateRangePresetsSample.Factory(), true, idSuffix),
                    
                    
                    new ExplorerTreeNode("Expression Filter", "grid-exp-filter", "grid-filter-category", null, new GridExpressionFilter.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Loaded Values", "loaded-values-filter", "grid-filter-category", null, new LoadedValuesSample.Factory(), true, idSuffix, "13.0"),

                    new ExplorerTreeNode("Editing", "grid-editing-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Edit by Row", "grid-editing-row", "grid-editing-category", null, new GridEditByRowSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Edit by Cell", "grid-editing-cell", "grid-editing-category", null, new GridEditByCellSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Cell Editors", "grid-custom-editing-cell", "grid-editing-category", null, new GridCellEditorCustomizerSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Enter New Rows", "grid-editing-new-row", "grid-editing-category", null, new GridEnterNewRowSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Mass Update", "grid-editing-mass-update", "grid-editing-category", null, new GridMassUpdateSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Modal Editing", "grid-editing-modal", "grid-editing-category", null, new GridModalEditingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Disable Editing", "grid-editing-disable", "grid-editing-category", null, new GridDisableEditingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Column Editors", "grid-editing-custom-editors", "grid-editing-category", null, new GridCustomEditorsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Data Validation", "grid-editing-data-validation", "grid-editing-category", null, new GridDataValidationSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dependent Selects (Grid)", "grid-editing-dependent-selects", "grid-editing-category", null, new GridDependentSelectsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid All Editors", "grid-all-editors", "grid-editing-category", null, new GridEditAllRowsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Editor Formula", "grid-editor-formula", "grid-editing-category", null, new GridEditorFormulaSample.Factory(), true, idSuffix, "6.0"),

                    new ExplorerTreeNode("Frozen Columns", "grid-frozen-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Simple Freeze", "grid-frozen-simple", "grid-frozen-category", null, new GridSimpleFreezeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dynamic Freeze", "grid-frozen-dynamic", "grid-frozen-category", null, new GridDynamicFreezeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Editing", "grid-frozen-editing", "grid-frozen-category", null, new GridEditFreezeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Drop", "grid-frozen-dd", "grid-frozen-category", null, new GridDragDropFreezeSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Expanding Rows", "grid-expanding-rows-category", "grid-category", "crystal/16/apps/tooloptions.png", null, true, idSuffix),
                    new ExplorerTreeNode("Memo Rows", "grid-memo-rows", "grid-expanding-rows-category", null, new GridRowExpansionDetailFieldSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Details", "grid-expanding-details", "grid-expanding-rows-category", null, new GridRowExpansionDetailsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Nested Form", "grid-nested-form", "grid-expanding-rows-category", null, new GridRowExpansionEditorSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Nested Grid", "grid-nested-grid", "grid-expanding-rows-category", null, new GridRowExpansionRelatedRecordsSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Hover Components", "grid-hover-category", "grid-category", "silk/chart_organisation.png", null, true, idSuffix),
                    new ExplorerTreeNode("Related Records", "grid-hover-related-records", "grid-hover-category", null, new GridHoverRelatedRecordsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Component", "grid-hover-custom", "grid-hover-category", null, new GridCustomHoverSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Grouping &amp; Summaries", "grid-grouping-category", "grid-category", "silk/chart_organisation.png", null, true, idSuffix),
                    new ExplorerTreeNode("Dynamic Grouping", "grid-grouping-dynamic", "grid-grouping-category", null, new GridDynamicGroupingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grouped Editing", "grid-grouping-editing", "grid-grouping-category", null, new GroupedEditingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Grouping", "grid-grouping-custom", "grid-grouping-category", null, new GridCustomGroupingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Multi Grouping", "grid-grouping-multi", "grid-grouping-category", null, new MultiGroupingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grouping Modes", "grid-grouping-modes", "grid-grouping-category", null, new GridGroupingModesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Group Sorting", "grid-grouping-sort", "grid-grouping-category", null, new CustomGroupSortingSample.Factory(), true, idSuffix, "12.1"),
                    new ExplorerTreeNode("Grid Summaries", "grid-summaries", "grid-grouping-category", "crystal/16/apps/tooloptions.png", "crystal/16/apps/tooloptions_white.png", new GridSummariesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid Header Summaries", "grid-header-summaries", "grid-grouping-category", "crystal/16/apps/tooloptions.png", new GridSummariesInHeaderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Multiline Summaries", "grid-ml-summaries", "grid-grouping-category", "crystal/16/apps/tooloptions.png", new GridMultiLineSummariesSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Hiliting", "grid-hiliting-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("User Defined", "grid-hiliting-user-defined", "grid-hiliting-category", null, new GridUserDefinedHilitingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Pre-Defined", "grid-hiliting-pre-defined", "grid-hiliting-category", null, new GridPredefinedHilitingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Data Driven", "grid-hiliting-data-driven", "grid-hiliting-category", null, new GridDataDrivenHilitingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Formula Hilites", "grid-hiliting-formula", "grid-hiliting-category", null, new GridFormulaHilitingSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Row &amp; Cell Widgets", "grid-row-cell-widgets-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Cell Widgets", "grid-cell-widgets", "grid-row-cell-widgets-category", "silk/application_view_list.png", "silk/application_view_list_bgwhite.png", new GridCellWidgetsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Record Widgets", "grid-record-widgets", "grid-row-cell-widgets-category", "silk/application_view_list.png", "silk/application_view_list_bgwhite.png", new RecordWidgetsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Replacing Rows", "grid-row-cell-replacing-rows", "grid-row-cell-widgets-category", null, new ReplacingRowsSample.Factory(), true, idSuffix, "13.0"),

                    new ExplorerTreeNode("Data Types", "grid-datatypes-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Text", "grid-datatypes-text", "grid-datatypes-category", null, new GridDataTypesTextSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Image", "grid-datatypes-image", "grid-datatypes-category", null, new GridDataTypesImageSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Long Text", "grid-datatypes-longtext", "grid-datatypes-category", null, new GridDataTypesLongTextSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Date", "grid-datatypes-date", "grid-datatypes-category", null, new GridDataTypesDateSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Integer", "grid-datatypes-integer", "grid-datatypes-category", null, new GridDataTypesIntegerSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Decimal", "grid-datatypes-decimal", "grid-datatypes-category", null, new GridDataTypesDecimalSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Boolean", "grid-datatypes-boolean", "grid-datatypes-category", null, new GridDataTypesBooleanSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Link (text)", "grid-datatypes-link-text", "grid-datatypes-category", null, new GridDataTypesLinkTextSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Link (image)", "grid-datatypes-link-image", "grid-datatypes-category", null, new GridDataTypesLinkImageSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("List", "grid-datatypes-list", "grid-datatypes-category", null, new GridDataTypesListSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Calculated", "grid-datatypes-calculated", "grid-datatypes-category", null, new GridDataTypesCalculatedSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Data Binding", "grid-databinding-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("ListGrid Fields", "grid-databinding-lg-fields", "grid-databinding-category", null, new GridDataBindingListGridFieldsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("DataSource Fields", "grid-databinding-ds-fields", "grid-databinding-category", null, new GridDataBindingDataSourceFieldsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Merged Fields", "grid-databinding-merged-fields", "grid-databinding-category", null, new GridDataBindingMergedFieldsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Inline Data", "grid-databinding-inline-data", "grid-databinding-category", null, new GridDataBindingInlineDataSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Local Data", "grid-databinding-local-data", "grid-databinding-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Local DataSource", "grid-databinding-local-datasource", "grid-databinding-category", null, 
                    new GridDataBindingLocalDataSourceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("JSON DataSource", "grid-databinding-json-datasource", "grid-databinding-category", null, new GridDataBindingJSONDataSourceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("XML DataSource", "grid-databinding-xml-datasource", "grid-databinding-category", null, new GridDataBindingXMLDataSourceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Recategorize", "grid-databinding-recategorize", "grid-databinding-category", null, new GridDataBindingRecategorizeSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Data Operations", "grid-dataoperations-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    //new ExplorerTreeNode("Local Set", "grid-dataoperations-local-set", "grid-dataoperations-category", null, null, false, idSuffix),
                    //new ExplorerTreeNode("Local Add", "grid-dataoperations-local-add", "grid-dataoperations-category", null, null, false, idSuffix),
                    //new ExplorerTreeNode("Local Remove", "grid-dataoperations-local-remove", "grid-dataoperations-category", null, null, false, idSuffix),
                    //new ExplorerTreeNode("Local Update", "grid-dataoperations-local-update", "grid-dataoperations-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Databound Fetch", "grid-dataoperations-fetch", "grid-dataoperations-category", null, new GridDataBoundFetchSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Filter", "grid-dataoperations-filter", "grid-dataoperations-category", null, new GridDataBoundFilterSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Add", "grid-dataoperations-add", "grid-dataoperations-category", null, new GridDataBoundAddSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Remove", "grid-dataoperations-remove", "grid-dataoperations-category", null, new GridDataBoundRemoveSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Update", "grid-dataoperations-update", "grid-dataoperations-category", null, new GridDataBoundUpdateSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Grid-Form Binding", "grid-form-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Add", "add-grid-form-category", "grid-form-category", "exampleTree/cube_blue.png", new GridFormAddSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Update", "update-grid-form-category", "grid-form-category", "exampleTree/cube_blue.png", new GridFormUpdateSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Remove", "remove-grid-form-category", "grid-form-category", "exampleTree/cube_blue.png", new GridRecordRemoveSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Pattern Reuse", "pattern-reuse-grid-form-category", "grid-form-category", "silk/database_table.png", new PatternReuseSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Copy &amp; Paste", "grid-copy-paste-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Grid to Excel", "grid-to-excel-category", "grid-copy-paste-category", null, new GridToExcelSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid to Grid", "grid-to-grid-category", "grid-copy-paste-category", null, new GridToGridSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Excel to Grid", "excel-to-grid-category", "grid-copy-paste-category", null, new ExcelToGridSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Preferences", "grid-preferences-category", "grid-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Saving Preferences", "grid-appearance-preferences", "grid-preferences-category", null, new GridPreferencesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Automatic Preferences", "grid-appearance-automatic-preferences", "grid-preferences-category", null, new GridAutomaticPreferencesSample.Factory(), true, idSuffix, "12.1"),
                
                    new ExplorerTreeNode("Live Grid", "live-grid", "grid-category", null, new LiveGridFetchSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dependent Selects (Grid)", "dependent-selects-grid", "grid-category", null, new GridDependentSelectsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Dragging", "grid-db-dragging", "grid-category", "silk/database_link.png", new GridDataBoundDragDropSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Printing", "grid-print-grid", "grid-category", "silk/printer.png", new PrintingSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Tree", "tree-category", "root", "silk/chart_organisation.png", null, true, idSuffix),
                    new ExplorerTreeNode("Appearance", "tree-appearance-category", "tree-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Preferences", "tree-apperannce-preferneces", "tree-appearance-category", null, new TreePreferencesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Node Titles", "tree-appearance-node-titles", "tree-appearance-category", null, new NodeTitlesTreeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Multiple Columns", "tree-appearance-multicolumns", "tree-appearance-category", null, new MultipleColumnsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Connectors", "tree-appearance-connectors", "tree-appearance-category", null, new TreeConnectorsSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Interaction", "tree-interaction-category", "tree-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Drag Reparent", "tree-interaction-drag-reparent", "tree-interaction-category", null, new TreeDragReparentSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Nodes", "tree-interaction-drag-nodes", "tree-interaction-category", null, new TreeDragNodesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Springloaded Folders", "tree-interaction-sl-folders", "tree-interaction-category", null, new TreeSpringloadedFoldersSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Drop Events", "tree-interaction-drop-events", "tree-interaction-category", null, null, false, idSuffix),

                    new ExplorerTreeNode("Data Binding", "tree-databinding-category", "tree-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Load from Local Data", "tree-databinding-local", "tree-databinding-category", null, new LocalDataTreeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Parent Linking", "tree-databinding-parentlinking", "tree-databinding-category", null, new ParentLinkingTreeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Children Arrays", "tree-databinding-children-arrays", "tree-databinding-category", null, new ChildrenArraysTreeSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Load XML (Parent Linking)", "tree-databinding-xml-parent-linking", "tree-databinding-category", null, null, false, idSuffix),
                    //new ExplorerTreeNode("Load XML (Child Array)", "tree-databinding-xml-child-array", "tree-databinding-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Load on Demand", "tree-databinding-ondemand", "tree-databinding-category", null, new LoadOnDemandTreeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Recategorize", "tree-databinding-recategorize", "tree-databinding-category", null, new RecategorizeTreeSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Initial Data &amp; Load on Demand", "tree-databinding-init-ondemand", "tree-databinding-category", null, null, false, idSuffix),

                    new ExplorerTreeNode("Sorting", "tree-sorting", "tree-category", null, new TreeSortingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Editing", "tree-editing", "tree-category", null, new TreeEditingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Frozen Columns", "tree-frozen-columns", "tree-category", null, new FrozenColumnsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Miller Columns", "tree-miller-columns", "tree-category", null, new MillerColumnsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Checkbox Tree", "tree-checkbox", "tree-category", null, new CheckboxTreeSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Calendar", "calendar-category", "root", "crystal/16/apps/cal.png", null, true, idSuffix),
                    new ExplorerTreeNode("Simple Calendar", "simple-calendar-category", "calendar-category", "silk/calendar_view_day.png", "silk/calendar_view_day_white.png", new SimpleCalendarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Calendar", "databound-calendar-category", "calendar-category", "silk/calendar_view_day.png", new DataBoundCalendarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Compact Calendar", "compact-calendar-category", "calendar-category", "widgets/date_time.png", "widgets/date_time_white.png", new CompactCalendarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Workday Calendar", "workday-calendar-category", "calendar-category", "crystal/16/actions/5days.png", "crystal/16/actions/5days_white.png", new WorkdayCalendarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Event Editing", "custom-editing-calendar-category", "calendar-category", "crystal/16/apps/date.png", new CustomEventCalendarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Event Auto-Arranging", "event-autoarranging-calendar-category", "calendar-category", "crystal/16/actions/5days.png", new AutoArrangeEventsCalendarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Event Overlapping", "event-overlapping-calendar-category", "calendar-category", "crystal/16/actions/5days.png", new OverlappingEventsCalendarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Event Selection", "event-selection-calendar-category", "calendar-category", "crystal/16/actions/5days.png", new EventSelectionCalendarSample.Factory(), true, idSuffix, "12.0"),
                    new ExplorerTreeNode("24h based Calendar", "calendar-24h", "calendar-category", null, new CalendarDateTimeFormatSample.Factory(), true, idSuffix),
                    
                    new ExplorerTreeNode("Event Components", "simple-event-components-calendar", "calendar-category", null, new SimpleEventComponentsSample.Factory(), true, idSuffix,"13.0"),
                    new ExplorerTreeNode("Event Auto size and Stacking", "column-layouts-calendar", "calendar-category", null, new ColumnLayoutsSample.Factory(), true, idSuffix, "13.0"),
                
                    new ExplorerTreeNode("Simple Timeline", "simple-timeline", "calendar-category", null, new SimpleTimelineSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Timeline", "databound-timeline", "calendar-category", null, new DataBoundTimelineSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Timeline Filtering", "timeline-filtering", "calendar-category", null, new TimelineFilteringSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Timeline Resolution", "timeline-resolution", "calendar-category", null, new TimelineResolutionSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Timeline Grouping", "timeline-grouping", "calendar-category", null, new TimelineGroupingSample.Factory(), true, idSuffix, "5.0"),
                    new ExplorerTreeNode("Timeline Zones and Indicators", "timeline-zones-and-indicators", "calendar-category", null, new TimelineZonesAndIndicatorsSample.Factory(), true, idSuffix, "5.0"),

                    new ExplorerTreeNode("Data View / Tiling", "tiling-category", "root", "crystal/16/actions/view_icon.png", null, true, idSuffix),
                    new ExplorerTreeNode("Basic", "tiling-basic", "tiling-category", null, new BasicTilingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Filter &amp; Sort", "tiling-filter-sort", "tiling-category", null, new FilterSortTilingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Tile Editing", "tiling-editing", "tiling-category", null, new TileEditingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Tiles", "tiling-custom", "tiling-category", null, new CustomTilesSample.Factory(), true, idSuffix, "4.1"),
                    new ExplorerTreeNode("Drag Recategorize", "tiling-recategorize", "tiling-category", null, new RecategorizeTilingSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Forms", "form-category", "root", "silk/vcard_edit.png", null, true, idSuffix),

                    new ExplorerTreeNode("Form Layout", "layout-form-category", "form-category", "silk/vcard_edit.png", null, true, idSuffix),
                    new ExplorerTreeNode("Titles", "layout-form-titles", "layout-form-category", null, new FormTitlesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Spanning", "layout-form-spanning", "layout-form-category", null, new FormSpanningSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Filling", "layout-form-filling", "layout-form-category", null, new FormFillingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Splitting", "layout-form-splitting", "layout-form-category", null, new FormSplittingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Sections", "layout-form-sections", "layout-form-category", null, new FormSectionsSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Field Dependencies", "form-dep-category", "form-category", "silk/vcard_edit.png", null, true, idSuffix),
                    new ExplorerTreeNode("Show &amp; Hide", "form-dep-show-hide", "form-dep-category", null, new FormShowHideSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Enable &amp; Disable", "form-dep-enable-disable", "form-dep-category", null, new FormEnableDisableSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Conditionally Required", "form-dep-conditionally", "form-dep-category", null, new FormConditionallyRequiredSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Match Value", "form-dep-match-value", "form-dep-category", null, new FormMatchValueSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dependent Selects (Local)", "form-dep-dep-selects", "form-dep-category", null, new FormDependentSelectsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dependent Selects (Databound)", "form-dep-db-dep-selects", "form-dep-category", null, new FormDataboundDependentSelectsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Formula Fields", "form-formula-fields", "form-dep-category", null, new FormFormulaFieldsSample.Factory(), true, idSuffix, "6.0"),                

                    new ExplorerTreeNode("Various Controls", "form-controls-various", "form-category", null, new FormVariousControlsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Rich Text Editor", "form-controls-richedit", "form-category", null, new RichTextEditorSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Validation", "form-validation-category", "form-category", "silk/vcard_edit.png", null, true, idSuffix),
                    new ExplorerTreeNode("Type", "form-validation-type", "form-validation-category", null, new FormTypeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Built-ins", "form-validation-builtins", "form-validation-category", null, new FormBuiltinsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Regular Expression", "form-validation-regexp", "form-validation-category", null, new FormRegularExpressionSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Value Transform", "form-validation-value-transform", "form-validation-category", null, new FormValueTransformSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Custom Types", "form-validation-custom-types", "form-validation-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Customized Binding", "form-validation-customized-binding", "form-validation-category", null, new FormDataBindingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Server JSON Validation", "form-validation-server-json", "form-validation-category", null, new FormServerJsonValidationSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Server XML Validation", "form-validation-server-xml", "form-validation-category", null, new FormServerXmlValidationSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Icons", "form-details-icons", "form-category", "silk/vcard_edit.png", new FormIconsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Show Icons On Focus", "form-show-icons-on-focus", "form-category", "silk/vcard_edit.png", new ShowIconsOnFocusSample.Factory(), true, idSuffix, "12.0"),
                    new ExplorerTreeNode("Hovers", "form-details-hovers", "form-category", "silk/vcard_edit.png", new FormHoversSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Hints", "form-details-hints", "form-category", "silk/vcard_edit.png", new FormHintsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("KeyPress Filters", "form-keypress-filter", "form-category", "silk/vcard_edit.png", new KeyPressFiltersSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Pending Values", "form-pending-values", "form-category", "silk/vcard_edit.png", new PendingValuesSample.Factory(), true, idSuffix, "6.1"),
                    new ExplorerTreeNode("CanvasItem showPending Support", "form-canvasItem-showPending-support", "form-category", "silk/vcard_edit.png", new CanvasItemShowPendingSupportSample.Factory(), true, idSuffix, "6.1"),

                    new ExplorerTreeNode("Data Binding", "layout-form-databinding", "form-category", null, new FormDataBindingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Focus First Field", "form-category-focus-first", "form-category", null, new FormFocusFirstSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Picker", "form-category-custom-picker", "form-category", null, new CustomPickerSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Picker Icons", "form-category-picker-icons", "form-category", null, new PickerControlsSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("DataType Reuse", "form-type-reuse", "form-category", "silk/database_table.png", new TypeReuseSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Text Masking", "form-masking", "form-category", "silk/vcard_edit.png", new TextMaskingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Nested Editor", "nested-editor", "form-category", "silk/vcard_edit.png", new NestedEditorSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("ListGrid Item", "form-grid-item", "form-category", "silk/vcard_edit.png", new ListGridItemSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Tree", "form-picktree-item", "form-category", null, new PickTreeSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Layout", "layout-category", "root", "widgets/container.png", null, true, idSuffix),
                    new ExplorerTreeNode("SplitPane", "layout-splitpane", "layout-category", null, new SplitPaneSample.Factory(), false, idSuffix, "5.0"),              
                    new ExplorerTreeNode("SplitPane Auto-Navigate", "layout-splitpane-auto-navigate", "layout-category", null, new SplitPaneAutoNavigateSample.Factory(), false, idSuffix, "13.0"),
                    new ExplorerTreeNode("Stack", "layout-stack", "layout-category", null, new StackSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Layout", "layout-layout", "layout-category", null, new LayoutSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Nesting", "layout-nesting", "layout-category", null, new NestingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("User Sizing", "layout-user-sizing", "layout-category", null, new UserSizingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Border Layout", "layout-border", "layout-category", null, new FreeSpaceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Center Align", "layout-center-align", "layout-category", "crystal/16/actions/show_table_row.png", "crystal/16/actions/show_table_row_white.png", new CenterAlignSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Snap To", "layout-snap-to", "layout-category", null, new LayoutSnapToSample.Factory(), true, idSuffix, "6.0"),
                    new ExplorerTreeNode("Layout Mins &amp; Maxs", "layout-mins-maxs", "layout-category", null, new LayoutMinsMaxsSample.Factory(), true, idSuffix, "6.0"),
                    new ExplorerTreeNode("Portal(manual)", "layout-portal-manual", "layout-category", "silk/application_view_tile.png", new SimplePortalManualSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Windows", "layout-windows-category", "root", "silk/application_cascade.png", null, true, idSuffix),
                    new ExplorerTreeNode("Auto Size", "layout-windows-autosize", "layout-windows-category", null, new WindowAutoSizeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Modality", "layout-windows-modality", "layout-windows-category", null, new WindowModalitySample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dragging", "layout-windows-dragging", "layout-windows-category", null, new WindowDraggingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Minimize", "layout-windows-minimize", "layout-windows-category", null, new WindowMinimizeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Header Icons", "layout-windows-header-icons", "layout-windows-category", null, new WindowHeaderIconsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Header Controls", "layout-windows-header-controls", "layout-windows-category", null, new WindowHeaderControlsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Footer", "layout-windows-footer", "layout-windows-category", null, new WindowFooterSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Tabs", "layout-tabs-category", "root", "silk/tab.png", null, true, idSuffix),
                    new ExplorerTreeNode("Orientation", "layout-tabs-orientation", "layout-tabs-category", null, new OrientationSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Align", "layout-tabs-align", "layout-tabs-category", null, new TabsAlignSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Add & Remove", "layout-tabs-add-remove", "layout-tabs-category", null, new AddRemoveSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Closeable Tabs", "layout-tabs-closeable", "layout-tabs-category", null, new TabsCloseableSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Title Change", "layout-tabs-title-change", "layout-tabs-category", null, new TabsTitleChangeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("User-Editable Titles", "layout-tabs-title-editable", "layout-tabs-category", null, new TabsEditableTitlesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Controls", "layout-tabs-custom-controls", "layout-tabs-category", null, new TabsCustomControlSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Selection and Deselection Handling", "layout-tabs-selection-deselection-handling", "layout-tabs-category", null, new TabsSelectionDeselectionSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Accordion / Sections", "layout-sections-category", "root", "widgets/stack_panel.gif", null, true, idSuffix),
                    new ExplorerTreeNode("Expand / Collapse", "layout-sections-expand-collapse", "layout-sections-category", null, new ExpandCollapseSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Resize Sections", "layout-sections-resize", "layout-sections-category", null, new SectionsResizeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Controls", "layout-sections-custom-controls", "layout-sections-category", null, new SectionsCustomControlsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Add & Remove", "layout-sections-add-remove", "layout-sections-category", null, new SectionsAddRemoveSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Show & Hide", "layout-sections-show-hide", "layout-sections-category", null, new SectionsShowHideSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Reorder", "layout-sections-drag-reorder", "layout-sections-category", null, new SectionsReorderSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Portal Layout", "portal-layout-category", "root", "silk/application_view_tile.png", null, true, idSuffix),
                    new ExplorerTreeNode("Repositioning", "repositioning-portal-layout", "portal-layout-category", null, new RearrangeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Add/Remove Columns", "add-remove-columns-portal-layout", "portal-layout-category", null, new AddRemoveColumnsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Portlet Contents", "portlet-contents-portal-layout", "portal-layout-category", "silk/application_view_tile.png", null, true, idSuffix),
                    new ExplorerTreeNode("Window contents", "window-contents-portal-layout", "portlet-contents-portal-layout", null, new WindowContentsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dragging components", "drag-components-portal-layout", "portlet-contents-portal-layout", null, new DragComponentsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Sizing", "sizing-portal-layout", "portal-layout-category", "silk/application_view_tile.png", null, true, idSuffix),
                    new ExplorerTreeNode("Column height", "column-height-portal-layout", "sizing-portal-layout", null, new ColumnHeightSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Column width", "column-width-portal-layout", "sizing-portal-layout", null, new ColumnWidthSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Portlet height", "portlet-height-portal-layout", "sizing-portal-layout", null, new PortletHeightSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Portlet width", "portlet-width-portal-layout", "sizing-portal-layout", null, new PortletWidthSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Portlet resizing", "portlet-resizing-portal-layout", "sizing-portal-layout", null, new PortletResizeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Portlet Animation", "portlet-animation-portal-layout", "portal-layout-category", null, new PortletAnimationSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Portlet Events", "portlet-events-portal-layout", "portal-layout-category", null, new PortletEventsSample.Factory(), true, idSuffix, "4.1"),

                    new ExplorerTreeNode("Buttons", "buttons-category", "root", "silk/brick.png", null, true, idSuffix),
                    new ExplorerTreeNode("Appearance", "buttons-category-appearance", "buttons-category", null, new ButtonAppearanceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("States", "buttons-category-states", "buttons-category", null, new ButtonStatesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Icons", "buttons-category-icons", "buttons-category", null, new ButtonIconsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Auto Fit", "buttons-category-autofit", "buttons-category", null, new ButtonAutoFitSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Radio / Toggle Behavior", "buttons-category-toggle", "buttons-category", null, new ButtonRadioToggleSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Adaptive Width", "buttons-adaptive-width", "buttons-category", null, new ButtonAdaptiveWidthSample.Factory(), true, idSuffix, "6.0"),

                    new ExplorerTreeNode("Menus", "menus-category", "root", "silk/application_osx.png", null, true, idSuffix),
                    new ExplorerTreeNode("Appearance", "menus-category-appearance", "menus-category", null, new MenuAppearanceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dynamic Items", "menus-category-dynamic", "menus-category", null, new MenuDynamicItemsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Submenus", "menus-category-submenus", "menus-category", null, new MenuSubmenusSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Columns", "menus-category-customcolumns", "menus-category", "silk/application_view_detail.png", new MenuCustomColumnsSample.Factory(), true, idSuffix, "4.1"),
                    new ExplorerTreeNode("Embedded Components", "menus-category-embeddedcomponents", "menus-category", null, new MenuEmbeddedComponentsSample.Factory(), true, idSuffix, "6.0"),
                    new ExplorerTreeNode("Tree Binding", "menus-category-treebinding", "menus-category", "silk/chart_organisation.png", new MenuTreeBindingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Adaptive Menu", "menus-category-adaptive-menu-ms", "menus-category", null, new AdaptiveMenuSample.Factory(), true, idSuffix, "6.0"),
                    // this sample is hidden because the "Mobile Samples" folder is hidden as well.
                    //new ExplorerTreeNode("Mobile UI", "menus-mobile-ui", "menus-category", null, new MobileMenusSample.Factory(), true, idSuffix, "5.0"),

                    new ExplorerTreeNode("ToolStrip", "toolstrip-category", "root", "silk/application_view_list.png", null, true, idSuffix),
                    new ExplorerTreeNode("ToolStrip", "toolstrip", "toolstrip-category", null, new ToolStripSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("ToolStrip (Vertical)", "toolstrip-vertical", "toolstrip-category", null, new ToolStripVerticalSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("RibbonBar", "ribbonbar", "toolstrip-category", null, new RibbonBarSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Other Controls", "controls-category", "root", "silk/timeline_marker.png", null, true, idSuffix),
                    new ExplorerTreeNode("Notifications", "controls-category-notifications", "controls-category", null, new NotificationSample.Factory(), true, idSuffix, "12.1"),
                    new ExplorerTreeNode("Dialogs", "controls-category-dialogs", "controls-category", null, new DialogsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Slider", "controls-category-slider", "controls-category", null, new SliderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Progressbar", "controls-category-progressbar", "controls-category", null, new ProgressBarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Date Chooser", "controls-category-datechooser", "controls-category", null, new DateChooserSample.Factory(), true, idSuffix),


                    new ExplorerTreeNode("Data Integration", "data-integration-category", "root", "silk/connect.png", null, true, idSuffix),
                    new ExplorerTreeNode("XML", "xml-integration-category", "data-integration-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    //new ExplorerTreeNode("RSS Feed", "rss-xml-integration-category", "xml-integration-category", null, new RSSFeedSample.Factory(), true),
                    new ExplorerTreeNode("XPath Binding", "xpath-xml-integration-category", "xml-integration-category", null, new XmlXPathSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Edit &amp; Save", "edit-save-xml-integration-category", "xml-integration-category", null, new FormXmlEditAndSaveSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("RestDataSource Edit &amp; Save", "restfulds-xml-integration-category", "xml-integration-category", null, new RestfulDataSourceSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("WSDL WebService", "wsdl-xml-integration-category", "xml-integration-category", null, new WSDLWebServiceSample.Factory(), true),

                    new ExplorerTreeNode("JSON", "json-integration-category", "data-integration-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Simple JSON", "json-integration-category-simple", "json-integration-category", null, new JsonSimpleSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("RestDataSource Edit &amp; Save", "restfulds-json-integration-category", "json-integration-category", null, new RestfulJsonDataSourceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("XPath Binding", "json-integration-category-xpath", "json-integration-category", null, new JsonXPathSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Yahoo! JSON Services", "json-integration-category-yahoo", "json-integration-category", "crystal/16/apps/yahoo_protocol.png", new YahooJsonServicesSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Offline Support", "offline-category", "root", "silk/application_view_detail.png", null, true, idSuffix),
                    new ExplorerTreeNode("Offline Preferences", "grid-offline-pref", "offline-category", "crystal/16/apps/tooloptions.png", new OfflinePreferencesSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Drag & Drop", "effects-dd-category", "root", "silk/layers.png", null, true, idSuffix),
                    new ExplorerTreeNode("Drag List (copy)", "effects-dd-copy-list", "effects-dd-category", null, new DragListCopySample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag List (move)", "effects-dd-move-list", "effects-dd-category", null, new DragListMoveSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag List (select)", "effects-dd-select-list", "effects-dd-category", null, new DragListSelectSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Tree (move)", "effects-dd-tree-move-drag-nodes", "effects-dd-category", null, new TreeDragNodesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Tiles (move)", "effects-dd-tiles-move", "effects-dd-category", null, new DragTilesMoveSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Drag Move", "effects-dd-move", "effects-dd-category", null, new DragMoveImageSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag from Menu", "effects-drag-menu-grid", "effects-dd-category", null, new DragMenuGridSample.Factory(), true, idSuffix),

                    //new ExplorerTreeNode("Drag Reorder", "effects-dd-reorder", "effects-dd-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Drag Types", "effects-dd-types", "effects-dd-category", null, new DragTypesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Create", "effects-dd-create", "effects-dd-category", null, new DragCreateSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Effects", "effects-dd-effects", "effects-dd-category", null, new DragEffectsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Resize", "effects-dd-resize", "effects-dd-category", null, new DragResizeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Tracker", "effects-dd-tracker", "effects-dd-category", null, new DragTrackerSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Pan", "effects-dd-pan", "effects-dd-category", null, new DragPanSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Snap-to-Grid Dragging", "effects-dd-snap-to-grid", "effects-dd-category", null, new DragSnapToGridSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Cross-Window Drag", "effects-cross-window-dd-category", "effects-dd-category", null, null, true, idSuffix, "4.1"),
                    new ExplorerTreeNode("Native Drag Create", "effects-dd-native-drag-create", "effects-cross-window-dd-category", null, new NativeDragCreateSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Records across Windows", "effects-dd-records-across-windows", "effects-cross-window-dd-category", null, new RecordsAcrossWindowsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Portlet across Windows", "effects-dd-portlet-across-windows", "effects-cross-window-dd-category", null, new PortletAcrossWindowsSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Basics", "basics-category", "root", "silk/overlays.png", null, true, idSuffix),
                    new ExplorerTreeNode("Components", "basics-components-category", "basics-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Create", "basics-components-create", "basics-components-category", null, new CreateSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Show & Hide", "basics-components-showhide", "basics-components-category", null, new ShowHideSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Move", "basics-components-move", "basics-components-category", null, new MoveSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Resize", "basics-components-resize", "basics-components-category", null, new ResizeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Layer", "basics-components-layer", "basics-components-category", null, new LayerSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Stack", "basics-components-stack", "basics-components-category", null, new StackSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Layout", "basics-components-layout", "basics-components-category", null, new LayoutSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("HTML", "basics-html-category", "basics-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("HTMLFlow", "basics-html-flow", "basics-html-category", null, new HTMLFlowSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("HTMLPane", "basics-html-pane", "basics-html-category", null, new HTMLPaneSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Label", "basics-html-label", "basics-html-category", null, new LabelSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Rich Text Editor", "basics-html-editor", "basics-html-category", null, new RichTextEditorSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Img", "basics-html-img", "basics-html-category", null, new ImgSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("SVG Img", "basics-html-svg-img", "basics-html-category", null, new SVGImgSample.Factory(), true, idSuffix, "12.0"),    
                    new ExplorerTreeNode("Dynamic HTML (set)", "basics-html-dyn", "basics-html-category", null, new DynamicHTMLSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Load Images", "basics-html-load-images", "basics-html-category", null, new LoadImagesSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Load HTML chunks", "basics-html-load-chunks", "basics-html-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Load HTML pages (IFrame)", "basics-html-load-pages", "basics-html-category", null, new IFramesSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Interaction", "basics-interaction-category", "basics-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Mouse Events", "basics-interaction-mouse-events", "basics-interaction-category", null, new MouseEventsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Drag Events", "basics-interaction-drag-events", "basics-interaction-category", null, new DragEventsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Hovers / Tooltips", "basics-interaction-hovers", "basics-interaction-category", null, new HoversTooltipsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Context Menus", "basics-interaction-contextmenu", "basics-interaction-category", null, new ContextMenuSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Focus & Tabbing", "basics-interaction-focus-tabbing", "basics-interaction-category", null, new BasicFocusTabbingSample.Factory(), true, idSuffix, "6.1"),
                    new ExplorerTreeNode("Custom Tab order", "basics-interaction-custom-tabbing", "basics-interaction-category", null, new BasicCustomTabOrderSample.Factory(), true, idSuffix, "6.1"),
                    new ExplorerTreeNode("Custom Component Tab order", "basics-interaction-custom-component-tabbing", "basics-interaction-category", null, new CustomComponentTabOrderSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Cursors", "basics-interaction-cursors", "basics-interaction-category", null, null, false, idSuffix),
                    //new ExplorerTreeNode("Keyboard Events", "basics-interaction-keyboard", "basics-interaction-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Modality", "basics-interaction-modality", "basics-interaction-category", null, new WindowModalitySample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Select Content", "basics-interaction-select-content", "basics-interaction-category", null, new SelectContentSample.Factory(), true, idSuffix),

                    new ExplorerTreeNode("Sounds", "basics-sounds-category", "basics-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Audio Playback", "basics-sounds-playback", "basics-sounds-category", null, new AudioPlaybackSample.Factory(), true, idSuffix, "6.1"),
                    new ExplorerTreeNode("Audio Notifications", "basics-sounds-notifications", "basics-sounds-category", null, new AudioNotificationsSample.Factory(), true, idSuffix, "6.1"),
                
                    new ExplorerTreeNode("Drawing", "drawing", "root", "silk/palette.png", null, true, idSuffix),
                    new ExplorerTreeNode("Shape Gallery", "shape-gallery", "drawing", "silk/palette.png", new ShapeGallerySample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Rotation", "rotation", "drawing", "silk/palette.png", new RotationSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Title Rotation Mode", "title-rotation-mode", "drawing", "silk/palette.png", new TitleRotationModeSample.Factory(), true, idSuffix, "5.1"),
                    new ExplorerTreeNode("Zoom &amp; Pan", "zoom-and-pan", "drawing", "silk/arrow_out.png", new ZoomAndPanSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Lines &amp; Arrowheads", "lines-and-arrowheads", "drawing", "silk/palette.png", new LinesAndArrowheadsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Mouse Events", "mouse-events", "drawing", "silk/palette.png", new DrawingMouseEventsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Gradients", "gradients", "drawing", "silk/palette.png", null, true, idSuffix),
                    new ExplorerTreeNode("Simple Gradient", "simple-gradient", "gradients", "silk/palette.png", new SimpleGradientSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Linear Gradient", "linear-gradient", "gradients", "silk/palette.png", new LinearGradientSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Radial Gradient", "radial-gradient", "gradients", "silk/palette.png", new RadialGradientSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Gauge", "gauge", "drawing", "silk/color_wheel.png", new GaugeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("DrawItem Knobs", "knobs", "drawing", "silk/palette.png", new DrawItemKnobsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom &lt;canvas&gt;", "custom-canvas", "drawing", "silk/palette.png", new CustomCanvasSample.Factory(), true, idSuffix, "6.1"),


                    new ExplorerTreeNode("Effects", "effects-category", "root", "silk/shape_move_front.png", null, true, idSuffix),
                    new ExplorerTreeNode("Animation", "effects-animation-category", "effects-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Animation Playpen", "effects-animation-playpen", "effects-animation-category", null, new AnimationPlaypenSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Tree Folders", "effects-animation-tree", "effects-animation-category", null, new AnimateTreeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Window Minimize", "effects-animation-minimize", "effects-animation-category", null, new AnimateWindowMinimizeSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Section Reveal", "effects-animation-sections", "effects-animation-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Layout Add &amp; Remove", "effects-animation-layout", "effects-animation-category", null, new AnimateLayoutSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Fly Onscreen", "effects-animation-move", "effects-animation-category", null, new AnimateMoveSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Resize", "effects-animation-resize", "effects-animation-category", null, new AnimateResizeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Wipe Show &amp; Hide", "effects-animation-wipe", "effects-animation-category", null, new AnimateWipeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Slide Show &amp; Hide", "effects-animation-slide", "effects-animation-category", null, new AnimateSlideSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Fade Show &amp; Hide", "effects-animation-fade", "effects-animation-category", null, new AnimateFadeSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Zoom &amp; Shrink", "effects-animation-zoom", "effects-animation-category", null, new AnimateZoomSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Sequence (simple)", "effects-animation-seq-simple", "effects-animation-category", null, new AnimateSequenceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Sequence (complex)", "effects-animation-seq-complex", "effects-animation-category", null, new AnimateComplexSequenceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom Animation", "effects-animation-custom", "effects-animation-category", null, new AnimationCustomSample.Factory(), true, idSuffix),
                    //Tile Filter and Sort

                    new ExplorerTreeNode("Look & Feel", "effects-lf-category", "effects-category", "exampleTree/cube_blue.png", null, true, idSuffix),
                    new ExplorerTreeNode("Edges", "effects-lf-edges", "effects-lf-category", null, new EdgesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Corners", "effects-lf-corners", "effects-lf-category", null, new CornersSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Shadows", "effects-lf-shadows", "effects-lf-category", null, new ShadowsSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Background Color", "effects-lf-background-color", "effects-lf-category", null, null, false, idSuffix),
                    //new ExplorerTreeNode("Background Texture", "effects-lf-background-texture", "effects-lf-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("Translucency", "effects-lf-translucency", "effects-lf-category", null, new TranslucencySample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Box Attributes", "effects-lf-box-attributes", "effects-lf-category", null, null, false, idSuffix),
                    new ExplorerTreeNode("CSS Styles", "effects-lf-css", "effects-lf-category", null, new CssStylesSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Consistent Sizing", "effects-lf-sizing", "effects-lf-category", null, null, false, idSuffix),
                    //new ExplorerTreeNode("Grid Cells", "effects-lf-grid-cells", "effects-lf-category", null, null, false, idSuffix),

                    new CommandTreeNode("Developer Console", "debug-category", "root", "silk/bug.png", new DebugConsoleCommand(), true, idSuffix)
            }));

            if (ShowcaseConfiguration.getSingleton().isOpenForTesting()) {
                data.add(new ExplorerTreeNode("Testable Records across Windows", "testable-effects-dd-records-across-windows", "effects-cross-window-dd-category", null, new TestableRecordsAcrossWindowsSample.Factory(), true, idSuffix));
                data.add(new ExplorerTreeNode("Testable Portlet across Windows", "testable-effects-dd-portlet-across-windows", "effects-cross-window-dd-category", null, new TestablePortletAcrossWindowsSample.Factory(), true, idSuffix));
            }
        }
        return data.toArray(new ExplorerTreeNode[data.size()]);
    }

    public static ExplorerTreeNode[] getData(String idSuffix) {
        return new ShowcaseData(idSuffix).getData();
    }

    public static String getNewSamplesSuffix() {
        String sgwtVersion = SC.getSgwtVersion();
        return SC.getSgwtVersionNumber();
    }
}
