package com.smartgwt.sample.showcase.client.dataintegration.json;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.XJSONDataSource;
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

public class YahooJsonServicesSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Enter a search term in the Query input field to see images from Yahoo Image Search. " +
            "<b>XPath</b> binding allows declarative integration with web services.</p><p>Note how the height and width for the thumbnail images " +
            "have been declaratively extracted from the \"Thumbnail\" sub-object.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            YahooJsonServicesSample panel = new YahooJsonServicesSample();
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

        XJSONDataSource yahooDS = new XJSONDataSource();
        yahooDS.setDataURL("http://api.search.yahoo.com/ImageSearchService/V1/imageSearch?appid=YahooDemo&output=json");
        yahooDS.setRecordXPath("/ResultSet/Result");
        DataSourceImageField thumbnail = new DataSourceImageField("Thumbnail", "Thumbnail");
        thumbnail.setWidth(150);
        thumbnail.setImageHeight("imageHeight");
        thumbnail.setImageWidth("imageWidth");
        thumbnail.setValueXPath("Thumbnail/Url");

        DataSourceIntegerField imageWidth = new DataSourceIntegerField("imageWidth");
        imageWidth.setValueXPath("Thumbnail/Width");
        imageWidth.setAttribute("hidden", true);

        DataSourceIntegerField imageHeight = new DataSourceIntegerField("imageHeight");
        imageHeight.setValueXPath("Thumbnail/Height");
        imageHeight.setAttribute("hidden", true);

        DataSourceField title = new DataSourceField("Title", FieldType.TEXT);
        DataSourceField summary = new DataSourceField("Summary", FieldType.TEXT);

        DataSourceLinkField fullImage = new DataSourceLinkField("link", "Full Image");
        fullImage.setValueXPath("Url");
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