package com.smartgwt.sample.showcase.client.dataintegration.xml;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.XmlNamespaces;
import com.smartgwt.client.data.fields.DataSourceImageField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class YahooXmlServicesSample extends ShowcasePanel {

    private static final String DESCRIPTION = "XPath binding allows declarative integration with web services. Note how the " +
            "height and width for the thumbnail images have been declaratively extracted from the \"Thumbnail\" subobject.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            YahooXmlServicesSample panel = new YahooXmlServicesSample();
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

        Canvas canvas = new Canvas();

        Canvas yahooAttribution = new Canvas();
        yahooAttribution.setHeight(31);
        yahooAttribution.setContents("<a href='http://developer.yahoo.net/about'>"
                + "<img src='http://l.yimg.com/a/i/us/nt/bdg/websrv_88_1.gif' border='0'>"
                + "</a>");
        canvas.addChild(yahooAttribution);

        DataSource yahooDS = new DataSource();
        yahooDS.setDataURL("http://api.search.yahoo.com/ImageSearchService/V1/imageSearch");
        yahooDS.setRecordXPath("/yahoo:ResultSet/yahoo:Result");

        XmlNamespaces xmlNamespaces = new XmlNamespaces();
        xmlNamespaces.addNamespace("yahoo", "urn:yahoo:srchmi");
        yahooDS.setXmlNamespaces(xmlNamespaces);

        DataSourceImageField thumbnail = new DataSourceImageField("Thumbnail", "Thumbnail");
        thumbnail.setWidth(150);
        thumbnail.setImageHeight("imageHeight");
        thumbnail.setImageWidth("imageWidth");
        thumbnail.setValueXPath("yahoo:Thumbnail/yahoo:Url");

        DataSourceIntegerField imageWidth = new DataSourceIntegerField("imageWidth");
        imageWidth.setValueXPath("yahoo:Thumbnail/yahoo:Width");
        imageWidth.setAttribute("hidden", true);

        DataSourceIntegerField imageHeight = new DataSourceIntegerField("imageHeight");
        imageHeight.setValueXPath("yahoo:Thumbnail/yahoo:Height");
        imageHeight.setAttribute("hidden", true);

        DataSourceField title = new DataSourceField("Title", FieldType.TEXT);
        DataSourceField summary = new DataSourceField("Summary", FieldType.TEXT);

        DataSourceLinkField fullImage = new DataSourceLinkField("link", "Full Image");
        fullImage.setValueXPath("yahoo:Url");
        fullImage.setAttribute("target", "_blank");

        yahooDS.addField(thumbnail);
        yahooDS.addField(imageWidth);
        yahooDS.addField(imageHeight);
        yahooDS.addField(title);
        yahooDS.addField(summary);
        yahooDS.addField(fullImage);

        final ListGrid grid = new ListGrid();
        grid.setTop(120);
        grid.setWidth100();
        grid.setHeight(300);
        grid.setWrapCells(true);
        grid.setFixedRecordHeights(false);
        grid.setShowAllRecords(true);
        grid.setDataSource(yahooDS);

        final SearchForm form = new SearchForm();
        form.setTop(50);
        form.setNumCols(3);
        TextItem query = new TextItem();
        query.setName("query");
        query.setTitle("Query");
        query.setDefaultValue("snowboarding");

        ButtonItem button = new ButtonItem();
        button.setTitle("Search");
        button.setStartRow(false);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                grid.fetchData(form.getValuesAsCriteria());
            }
        });

        form.setItems(query, button);

        canvas.addChild(form);
        canvas.addChild(grid);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}