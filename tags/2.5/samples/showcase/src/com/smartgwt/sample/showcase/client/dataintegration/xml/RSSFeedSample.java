package com.smartgwt.sample.showcase.client.dataintegration.xml;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class RSSFeedSample extends ShowcasePanel {

    private static final String DESCRIPTION = "DataSources can bind directly to simple XML documents where field values" +
            " appear as attributes or subelements.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            RSSFeedSample panel = new RSSFeedSample();
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
        DataSource dataSource = new DataSource();
        dataSource.setRecordXPath("//default:item");
        dataSource.setDataURL("http://rss.slashdot.org/Slashdot/slashdot");

        DataSourceTextField titleField = new DataSourceTextField("title", "Title");
        DataSourceLinkField linkField = new DataSourceLinkField("link", "URL");

        dataSource.setFields(titleField, linkField);

        ListGrid grid = new ListGrid();
        grid.setDataSource(dataSource);
        grid.setWidth100();
        grid.setHeight(300);
        grid.setAutoFetchData(true);
        return grid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}