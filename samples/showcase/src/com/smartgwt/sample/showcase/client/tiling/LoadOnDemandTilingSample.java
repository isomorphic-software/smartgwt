package com.smartgwt.sample.showcase.client.tiling;

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
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LoadOnDemandTilingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Tiled views can load data from services via DataSources, just like other " +
            "data-aware components. Enter a search term to search Yahoo Images and display available images as tiles.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            LoadOnDemandTilingSample panel = new LoadOnDemandTilingSample();
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

        final TileGrid tileGrid = new TileGrid();
        tileGrid.setTop(120);
        tileGrid.setWidth(500);
        tileGrid.setHeight(400);
        tileGrid.setTileWidth(150);
        tileGrid.setTileHeight(160);
        tileGrid.setCanDrag(true);
        tileGrid.setCanAcceptDrop(true);
        tileGrid.setShowAllRecords(true);
        tileGrid.setDataSource(yahooDS);

        DetailViewerField thumbnailField = new DetailViewerField("Thumbnail");
        thumbnailField.setType("image");
        DetailViewerField titleField = new DetailViewerField("Title");
        tileGrid.setFields(thumbnailField, titleField);

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
                tileGrid.fetchData(form.getValuesAsCriteria());
            }
        });

        form.setItems(query, button);

        canvas.addChild(form);
        canvas.addChild(tileGrid);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}