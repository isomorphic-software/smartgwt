package com.smartgwt.sample.showcase.client.dataintegration.xml;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.WSDLLoadCallback;
import com.smartgwt.client.data.WebService;
import com.smartgwt.client.data.WebServiceCallback;
import com.smartgwt.client.data.XMLTools;
import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class WSDLWebServiceSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Smart GWT can load WSDL service definitions and call web service " +
            "operations with automatic JSON<->XML translation. SOAP encoding rules, namespacing, and element ordering " +
            "are handled automatically for your inputs and outputs.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            WSDLWebServiceSample panel = new WSDLWebServiceSample();
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

    private WebService zipCodeService;

    public Canvas getViewPanel() {
        final ZipForm form = new ZipForm();
        form.setLeft(50);
        form.setTop(50);
        form.setNumCols(3);
        form.setCellSpacing(5);

        TextItem zipField = new TextItem();
        zipField.setName("ZipCode");
        zipField.addKeyPressHandler(new KeyPressHandler() {
            public void onKeyPress(KeyPressEvent event) {
                if(event.getKeyName().equals("Enter")) {
                    form.callService();
                }
            }
        });

        ButtonItem findButton = new ButtonItem("findCity", "Find City");
        findButton.setStartRow(false);
        findButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                form.callService();
            }
        });

        StaticTextItem cityText = new StaticTextItem();
        cityText.setName("City");
        form.setItems(zipField, findButton, cityText);

        XMLTools.loadWSDL("http://www.webservicex.net/uszip.asmx?WSDL", new WSDLLoadCallback() {
            public void execute(WebService webService) {
                zipCodeService = webService;
            }
        });

        return form;

    }

    class ZipForm extends DynamicForm {
         public void callService() {
             if(zipCodeService == null) {
                 SC.say("Please try again in a moment  - still loading web service descriptor");
             } else {
                 setValue("City", "Loading...");
                 Map data = new LinkedHashMap();
                 data.put("USZip", getValueAsString("ZipCode"));
                 zipCodeService.callOperation("GetInfoByZIP", data, "//CITY", new WebServiceCallback() {

                     public void execute(Object[] data, JavaScriptObject xmlDoc, RPCResponse rpcResponse, JavaScriptObject wsRequest) {                    
                         ZipForm.this.setValue("City", (String)data[0]);
                     }
                 });
             }
        }
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}