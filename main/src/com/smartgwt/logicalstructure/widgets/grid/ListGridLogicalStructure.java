package com.smartgwt.logicalstructure.widgets.grid;
import com.smartgwt.client.core.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.i18n.*;
import com.smartgwt.client.event.*;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.plugins.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;

public class ListGridLogicalStructure extends VLayoutLogicalStructure {
    public String advancedFieldPickerThreshold;
    public String allowFilterExpressions;
    public String allowFilterOperators;
    public String allowRowSpanning;
    public String alternateBodyStyleName;
    public String alternateFieldFrequency;
    public String alternateFieldStyles;
    public String alternateFieldSuffix;
    public String alternateRecordFrequency;
    public String alternateRecordStyles;
    public String alternateRecordSuffix;
    public String alwaysShowEditors;
    public String alwaysShowOperatorIcon;
    public String animateFolderEffect;
    public String animateFolderMaxRows;
    public String animateFolders;
    public String animateFolderSpeed;
    public String animateFolderTime;
    public String animateRemoveRecord;
    public String animateRemoveSpeed;
    public String animateRemoveTime;
    public String animateRollOver;
    public String animateRollUnder;
    public String animateSelection;
    public String animateSelectionUnder;
    public String applyFormulaAfterSummary;
    public String applyRowNumberStyle;
    public String arrowKeyAction;
    public String asynchGroupingPrompt;
    public String autoComplete;
    public String autoConfirmSaveEdits;
    public String autoFetchDisplayMap;
    public String autoFitAllText;
    public String[] autoFitClipFields;
    public String autoFitData;
    public String autoFitDateFields;
    public String autoFitExpandField;
    public String autoFitExtraRecords;
    public String autoFitFieldsFillViewport;
    public String autoFitFieldText;
    public String autoFitFieldWidths;
    public String autoFitHeaderHeights;
    public String autoFitIconFields;
    public String autoFitMaxColumns;
    public String autoFitMaxHeight;
    public String autoFitMaxRecords;
    public String autoFitMaxWidthAsString;
    public String autoFitTimeFields;
    public String autoFitWidthApproach;
    public String autoSaveEdits;
    public String autoSizeHeaderSpans;
    public String badFormulaResultValue;
    public String baseStyle;
    public String bodyBackgroundColor;
    public String bodyOverflow;
    public String bodyStyleName;
    public String booleanBaseStyle;
    public String booleanFalseImage;
    public String booleanImageHeight;
    public String booleanImageWidth;
    public String booleanPartialImage;
    public String booleanTrueImage;
    public String canAcceptDroppedRecords;
    public String canAutoFitFields;
    public String cancelEditingConfirmationMessage;
    public String canCollapseGroup;
    public String canDragRecordsOut;
    public String canDragSelect;
    public String canDragSelectText;
    public String canDropInEmptyArea;
    public String canEdit;
    public String canEditFieldAttribute;
    public String canEditHilites;
    public String canEditTitles;
    public String canExpandMultipleRecords;
    public String canExpandRecordProperty;
    public String canExpandRecords;
    public String canFocusInEmptyGrid;
    public String canFreezeFields;
    public String canGroupBy;
    public String canHover;
    public String canMultiGroup;
    public String canMultiSort;
    public String canPickFields;
    public String canPickOmittedFields;
    public String canRemoveRecords;
    public String canReorderFields;
    public String canReorderRecords;
    public String canResizeFields;
    public String canSelectAll;
    public String canSelectCells;
    public String canSelectGroups;
    public String canSort;
    public String canTabToHeader;
    public String cellHeight;
    public String cellPadding;
    public String chartConstructor;
    public String chartType;
    public String checkboxFieldFalseImage;
    public String checkboxFieldImageHeight;
    public String checkboxFieldImageWidth;
    public String checkboxFieldPartialImage;
    public String checkboxFieldTrueImage;
    public String childExpansionMode;
    public String clearAllSortingText;
    public String clearFilterText;
    public String clearSortFieldText;
    public String clipHeaderTitles;
    public String collapseGroupOnRowClick;
    public String configureGroupingText;
    public String configureSortText;
    public String confirmCancelEditing;
    public String confirmDiscardEdits;
    public String confirmDiscardEditsMessage;
    public String dataFetchDelay;
    public String dataFetchMode;
    public ResultSet dataProperties;
    public String dateFormatter;
    public String datetimeFormatter;
    public String defaultDateFieldWidth;
    public String defaultDateTimeFieldWidth;
    public String defaultEditableDateFieldWidth;
    public String defaultEditableDateTimeFieldWidth;
    public String defaultFilterOperator;
    public String defaultFilterOperatorSuffix;
    public String defaultTimeFieldWidth;
    public String deferRemoval;
    public String deselectOnPartialCheckboxClick;
    public String detailDS;
    public String detailField;
    public String discardEditsOnHideField;
    public String discardEditsSaveButtonTitle;
    public String dragScrollRedrawDelay;
    public String dragTrackerMode;
    public String drawAllMaxCells;
    public String editByCell;
    public String editEvent;
    public String editFailedBaseStyle;
    public String editFailedCSSText;
    public String editOnF2Keypress;
    public String editOnFocus;
    public String editPendingBaseStyle;
    public String editPendingCSSText;
    public String editProxyConstructor;
    public String editSelectionType;
    public String emptyCellValue;
    public String emptyMessage;
    public String emptyMessageStyle;
    public String enforceVClipping;
    public String enterKeyEditAction;
    public String enumCriteriaAsInitialValues;
    public String errorIconHeight;
    public String errorIconSrc;
    public String errorIconWidth;
    public String escapeKeyEditAction;
    public String expansionCanEdit;
    public String expansionComponentPoolingMode;
    public String expansionEditorCollapseOnSave;
    public String expansionEditorSaveButtonTitle;
    public String expansionEditorSaveDialogPrompt;
    public String expansionEditorShowSaveDialog;
    public String expansionFieldFalseImage;
    public String expansionFieldImageHeight;
    public String expansionFieldImageShowSelected;
    public String expansionFieldImageWidth;
    public String expansionFieldTrueImage;
    public String expansionMode;
    public String exportAlternateRowBGColor;
    public String exportDefaultBGColor;
    public String exportFieldAlignments;
    public String exportFieldWidths;
    public String exportHeaderHeights;
    public String exportRawValues;
    public String exportWidthScale;
    public String exportWrapHeaderTitles;
    public String fetchDelay;
    public String[] fieldPickerFieldProperties;
    public String fieldPickerShowSampleValues;
    public ListGridField[] fields;
    public String fieldState;
    public String fieldVisibilitySubmenuTitle;
    public String filterButtonPrompt;
    public String filterByCell;
    public String filterEditorHeight;
    public String filterLocalData;
    public String filterOnKeypress;
    public String filterUsingText;
    public String fixedFieldWidths;
    public String fixedRecordHeights;
    public String formulaBuilderSpanTitleSeparator;
    public String freezeFieldText;
    public String freezeOnLeftText;
    public String freezeOnRightText;
    public String frozenBaseStyle;
    public String frozenHeaderBaseStyle;
    public String frozenHeaderTitleStyle;
    public Canvas frozenRollOverCanvas;
    public Canvas frozenRollUnderCanvas;
    public String generateClickOnEnter;
    public String generateClickOnSpace;
    public String generateDoubleClickOnEnter;
    public String generateDoubleClickOnSpace;
    public String gridSummaryRecordProperty;
    public String groupByAsyncThreshold;
    public String[] groupByFieldSummaries;
    public String groupByMaxRecords;
    public String groupByText;
    public String groupIcon;
    public String groupIconSize;
    public String groupIndentSize;
    public String groupLeadingIndent;
    public String groupNodeBaseStyle;
    public String groupNodeStyle;
    public String groupSortDirection;
    public String groupStartOpenAsString;
    public String groupState;
    public String groupSummaryRecordProperty;
    public String groupSummaryStyle;
    public String groupTitleField;
    public String headerAutoFitEvent;
    public String headerBackgroundColor;
    public String headerBarStyle;
    public String headerBaseStyle;
    public String headerHeight;
    public String headerHoverAlign;
    public String headerHoverHeight;
    public String headerHoverOpacity;
    public String headerHoverStyle;
    public String headerHoverVAlign;
    public String headerHoverWidth;
    public String headerHoverWrap;
    public String headerMenuButtonHeight;
    public String headerMenuButtonIcon;
    public String headerMenuButtonIconHeight;
    public String headerMenuButtonIconWidth;
    public String headerMenuButtonWidth;
    public String headerShadowColor;
    public String headerShadowHOffset;
    public String headerShadowSoftness;
    public String headerShadowVOffset;
    public String headerSpanHeight;
    public String headerTitleStyle;
    public String hideEmptySummaryRow;
    public String hiliteCanReplaceValue;
    public String hiliteEditorSpanTitleSeparator;
    public String hiliteHTMLAfterFormat;
    public String hiliteIconHeight;
    public String hiliteIconLeftPadding;
    public String hiliteIconPosition;
    public String hiliteIconRightPadding;
    public String[] hiliteIcons;
    public String hiliteIconSize;
    public String hiliteIconWidth;
    public String hiliteReplaceValueFieldTitle;
    public String hiliteRowOnFocus;
    public String hoverMode;
    public String hoverStyle;
    public String iconPadding;
    public String imageSize;
    public String includeHilitesInSummaryFields;
    public String includeInSummaryProperty;
    public SortSpecifier[] initialSort;
    public String instantScrollTrackRedraw;
    public String invalidSummaryValue;
    public String isGrouped;
    public String isSeparatorProperty;
    public String leaveScrollbarGap;
    public String linkTextProperty;
    public String listEndEditAction;
    public String loadingDataMessage;
    public String loadingDataMessageStyle;
    public String loadingMessage;
    public String locateColumnsBy;
    public String locateRowsBy;
    public String longTextEditorThreshold;
    public String longTextEditorType;
    public String maxExpandedRecords;
    public String maxExpandedRecordsPrompt;
    public String minFieldWidth;
    public String minHeight;
    public String minimumCellHeight;
    public String missingSummaryFieldValue;
    public String modalEditing;
    public String navigateOnTab;
    public String neverValidate;
    public String normalBaseStyle;
    public String normalCellHeight;
    public String nullGroupTitle;
    public String offlineMessageStyle;
    public String originBaseStyle;
    public String overflow;
    public String poolComponentsPerColumn;
    public String preserveWhitespace;
    public String printAutoFit;
    public String printBaseStyle;
    public String printBooleanBaseStyle;
    public String printBooleanFalseImage;
    public String printBooleanPartialImage;
    public String printBooleanTrueImage;
    public String printCheckboxFieldFalseImage;
    public String printCheckboxFieldPartialImage;
    public String printCheckboxFieldTrueImage;
    public String printHeaderStyle;
    public String printMaxRows;
    public String printWrapCells;
    public String recordBaseStyleProperty;
    public String recordCanRemoveProperty;
    public String recordCanSelectProperty;
    public String recordComponentHeight;
    public String recordComponentPoolingMode;
    public String recordComponentPosition;
    public String recordDetailDSProperty;
    public String recordDropAppearance;
    public String recordEditProperty;
    public String recordEnabledProperty;
    public String recordSummaryBaseStyle;
    public String removedCSSText;
    public String removeFieldTitle;
    public String removeIcon;
    public String removeIconSize;
    public String reselectOnUpdate;
    public String reselectOnUpdateNotifications;
    public String resizeFieldsInRealTime;
    public String reverseRTLAlign;
    public String rowEndEditAction;
    public String rowNumberStart;
    public String rowNumberStyle;
    public String rowSpanEditMode;
    public String rowSpanSelectionMode;
    public String saveByCell;
    public String saveLocally;
    public String screenReaderCellSeparator;
    public String screenReaderRowSeparator;
    public String scrollRedrawDelay;
    public String scrollToCellXPosition;
    public String scrollToCellYPosition;
    public String scrollWheelRedrawDelay;
    public String selectCellTextOnClick;
    public String selectedState;
    public String selectHeaderOnSort;
    public String selectionAppearance;
    public String selectionProperty;
    public String selectionType;
    public String selectOnEdit;
    public String selectOnExpandRecord;
    public String showAllColumns;
    public String showAllRecords;
    public String showAsynchGroupingPrompt;
    public String showBackgroundComponents;
    public String showCellContextMenus;
    public String showClippedHeaderTitlesOnHover;
    public String showClippedValuesOnHover;
    public String showCollapsedGroupSummary;
    public String showDetailFields;
    public String showEllipsisWhenClipped;
    public String showEmptyMessage;
    public String showErrorIcons;
    public String showExpansionEditorSaveButton;
    public String showFilterEditor;
    public String showGridSummary;
    public String showGroupSummary;
    public String showGroupSummaryInHeader;
    public String showGroupTitleColumn;
    public String showGroupTitleInFrozenBody;
    public String showHeader;
    public String showHeaderContextMenu;
    public String showHeaderMenuButton;
    public String showHeaderPartialSelection;
    public String showHeaderShadow;
    public String showHeaderSpanTitlesInFormulaBuilder;
    public String showHeaderSpanTitlesInHiliteEditor;
    public String showHeaderSpanTitlesInSortEditor;
    public String showHilitesInGroupSummary;
    public String showHover;
    public String showHoverComponents;
    public String showPartialSelection;
    public String showRecordComponents;
    public String showRollOver;
    public String showRollOverCanvas;
    public String showRollOverInExpansion;
    public String showRollUnderCanvas;
    public String showRowNumbers;
    public String showSelectedRollOverCanvas;
    public String showSelectedRollUnderCanvas;
    public String showSelectedStyle;
    public String showSelectionCanvas;
    public String showSelectionUnderCanvas;
    public String showSortArrow;
    public String showSortNumerals;
    public String showTreeColumnPicker;
    public String shrinkForFreeze;
    public String singleCellValueProperty;
    public String skinImgDir;
    public String sortArrowMenuButtonSpaceOffset;
    public ImgProperties sortAscendingImage;
    public String sortBinaryByFileName;
    public String sortByGroupFirst;
    public ImgProperties sortDescendingImage;
    public String sortDirection;
    public String sortEditorSpanTitleSeparator;
    public String sorterButtonTitle;
    public String sortFieldAscendingText;
    public String sortFieldDescendingText;
    public String sortNumeralMenuButtonSpaceOffset;
    public String sortNumeralStyle;
    public String sortState;
    public String spannedHeaderBaseStyle;
    public String stopOnErrors;
    public String styleName;
    public Criteria summaryRowCriteria;
    public DataSource summaryRowDataSource;
    public String summaryRowHeight;
    public String summaryRowStyle;
    public String tallBaseStyle;
    public String touchScrollRedrawDelay;
    public ImgProperties trackerImage;
    public String unfreezeFieldText;
    public String ungroupText;
    public String unremoveIcon;
    public String useAdvancedCriteria;
    public String useAdvancedFieldPicker;
    public String useCellRollOvers;
    public String useCopyPasteShortcuts;
    public String useRemoteValidators;
    public String useRowSpanStyling;
    public String validateByCell;
    public String validateOnChange;
    public String valueIconHeight;
    public String valueIconLeftPadding;
    public String valueIconRightPadding;
    public String valueIconSize;
    public String valueIconWidth;
    public String viewState;
    public String virtualScrolling;
    public String waitForSave;
    public String warnOnRemoval;
    public String warnOnRemovalMessage;
    public String warnOnUnmappedValueFieldChange;
    public String wrapCells;
    public String wrapHeaderSpanTitles;
    public String wrapHeaderTitles;
}
