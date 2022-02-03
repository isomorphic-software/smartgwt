package com.smartgwt.sample.showcase.client;

import com.google.gwt.regexp.shared.RegExp;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.HoverHTMLCustomizer;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemValueFormatter;
import com.smartgwt.client.widgets.form.FormItemHoverFormatter;
import com.smartgwt.client.widgets.form.ValueIconMapper;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.tile.SimpleTile;

public class ShowcaseCustomTile extends SimpleTile {

    // Need to place the longer '<sup>BETA</sup>' alternative first because Ecma-262 §15.10.2.3 Disjunction
    // specifies: "The | regular expression operator separates two alternatives. The pattern first
    // tries to match the left Alternative (followed by the sequel of the regular expression);
    // if it fails, it tries to match the right Disjunction (followed by the sequel of the regular
    // expression)."
    private static final RegExp BETA_HTML_REGEXP = RegExp.compile("\\s*<(sup|SUP)[^>]*>\\s*BETA\\s*</\\1[^>]*>|\\s*BETA", "g");
    static boolean useDesktopMode = false;

    private DynamicForm form;
    private String preReleaseVersion = Showcase.getPreReleaseVersion();

    public ShowcaseCustomTile() {
        boolean usingFlatSkin = Showcase.usingFlatSkin();

        setOverflow(Overflow.HIDDEN);
        if (usingFlatSkin) setBaseStyle("showcaseTile");

        form = new DynamicForm();
        form.setFixedColWidths(true);
        form.setOverflow(Overflow.HIDDEN);
        form.setNumCols(1);
        form.setWidth100();
        form.setHeight100();

        StaticTextItem iconField = new ThumbnailItem("thumbnail");
        final int iconWidth = useDesktopMode ? 119 : 59,
                  iconHeight = useDesktopMode ? 89 : 44;
        iconField.setHeight(usingFlatSkin ? iconHeight + 18 : iconHeight);

        iconField.setValueIconWidth(iconWidth);
        iconField.setValueIconHeight(iconHeight);

        final Img betaImage = new Img();
        betaImage.setSrc("beta.png");
        betaImage.setSnapTo("TR");
        betaImage.setWidth(iconWidth);
        betaImage.setHeight(iconHeight);
        betaImage.setHoverStyle("hoverTreeGridCustom");
        betaImage.setShowHover(true);
        betaImage.setCanHover(true);
        betaImage.setHoverHTMLCustomizer(new HoverHTMLCustomizer() {
            @Override
            public String getHoverHTML() {
                String customDiv = "<div style=\"width:200px; " +
                                 "margin-top:10px; "+
                                 "margin-bottom:10px; "+
                                 "margin-left:10px; "+
                                 "margin-right:10px;\">";
                return customDiv +
                       "<b>Sample Description</b>: " + (String)form.getValue("description") +
                       "<br><br><span style='color: red;font-size:11px;font-weight: 700;'>BETA</span> : "+
                       "This sample demonstrates features available in the next available version of "+
                       "Smart GWT, " +preReleaseVersion+ ".  To download a " +preReleaseVersion+" SDK, "+
                       "click on \"Pre-release versions\" on the Download page."+
                       "</div>";
            }
        });

        final StaticTextItem nameField = new StaticTextItem("nodeTitle");
        nameField.setWidth("*");
        nameField.setCanEdit(false);
        nameField.setShowTitle(false);
        nameField.setWrap(!usingFlatSkin);
        nameField.setTextAlign(Alignment.CENTER);
        nameField.setValueFormatter(new FormItemValueFormatter() {
            @Override
            public String formatValue(Object value, Record record, DynamicForm form,
                                      FormItem item) 
            {
                final String nodeHTML = record.getAttribute("nodeHTML");
                if (nodeHTML != null && nodeHTML.contains("BETA")) {
                    addChild(betaImage);
                } else if (getChildren().length > 1) {
                    removeChild(betaImage);
                }
                return value != null ? (String)value : "";
            }
        });
        // Some sample names can push out the <table> on mobile (e.g. the "RestDataSource" and
        // "RestDataSource Edit & Save" samples).
        nameField.setClipValue(true);
        nameField.setClipStaticValue(true);

        if (usingFlatSkin) {
            nameField.setTextBoxStyle("showcaseTileTitle");
            nameField.setCellStyle("showcaseTileTitle");
            nameField.setCellHeight(30);
            nameField.setHeight("*");
        }

        StaticTextItem descriptionField = new StaticTextItem("description");
        descriptionField.setVisible(false);

        StaticTextItem positionField = new StaticTextItem("position");
        positionField.setVisible(false);
        
        form.setFields(iconField, nameField, descriptionField, positionField);
        form.setItemHoverFormatter(new FormItemHoverFormatter() {
            @Override
            public String getHoverHTML(FormItem item, DynamicForm form) {
                // skip the hover if we aren't clipping the title
                boolean showHover = nameField.valueClipped();
                if (showHover) return (String) nameField.getValue();
                return null;
            }
        });

        addChild(form);
    }

    public static class ThumbnailItem extends StaticTextItem {
        public ThumbnailItem(String name) {
            super(name);

            boolean usingFlatSkin = Showcase.usingFlatSkin();

            setCanEdit(false);
            setShowTitle(false);
            setShowValueIconOnly(true);
            setAlign(Alignment.CENTER);

            if (usingFlatSkin) {
                // correct centering for the sample-images
                setTextBoxStyle("normal");
                setCellStyle("normal");
            } else {
                setCellStyle("thumbnail");
            }

            setValueIconMapper(new ValueIconMapper() {
                @Override  
                public String getValueIcon(Object value) {
                    return String.valueOf(value);
                }
            });

            if (usingFlatSkin) customizeValueIconStyle();
        }

        public native void customizeValueIconStyle() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.getValueIconStyle = function (value) {
                // apply a style with a border but no padding/margin
                return "thumbnail";
            };
        }-*/;
    }

    public void applyRecord() {
        form.setValues(getAttributeAsMap("record"));
    }
}
