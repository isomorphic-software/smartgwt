package com.smartgwt.sample.showcase.client.reifyIntegration;

import java.util.Map;
import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.callbacks.LoadProjectCallback;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.rpc.LoadProjectSettings;
import com.smartgwt.client.rpc.Project;
import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.tools.Reify;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.data.ExtraFieldSupplyItemXmlDS;  
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class VerifyingScreensReifySample extends ShowcasePanel {
    private static final String DESCRIPTION = "You can declare your code's specific dependencies on "+
    "Reify projects, so that if incompatible changes are made in Reify, you know about them immediately."+
    "<p>"+
    "Turn on <code>verifyDataSources</code> to have DataSources loaded from a Reify project compared "+
    "against local DataSources.  Missing fields, incompatible types and other issues will be reported."+
    "<p>"+
    "Declare <code>verifyComponents</code> when creating a screen to get a warning if a loaded screen "+
    "is missing expected components, or if they have the wrong types."+
    "<p>"+
    "Click on \"Load Project\" below to see warnings of both kinds.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            VerifyingScreensReifySample panel = new VerifyingScreensReifySample();
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
        final DataSource ds = ExtraFieldSupplyItemXmlDS.getInstance();
        
        final VLayout container = new VLayout();  
        container.setWidth100();  
        container.setHeight100(); 
        container.setMembersMargin(20);
        
        final IButton button = new IButton();  
        button.setTitle("Load Project");  
        button.setWidth(100);  
        button.addClickHandler(new ClickHandler() {  
            @Override  
            public void onClick(ClickEvent event) {  

                LoadProjectSettings settings = new LoadProjectSettings();  
                settings.setUserName("reifySample");  
                settings.setPassword("tryReify");  
                settings.setServerURL("https://create.reify.com");
                settings.setWillHandleError(true);
                settings.setVerifyAsError(true);
                settings.setVerifyDataSources(true);
                Map<String,String> componentsMap = new HashMap<String,String>();
                componentsMap.put("simpleForm.saveDataButton", "ButtonItem");
                settings.setVerifyComponents(componentsMap);
                      
                Reify.loadProject("Incompatible Simple Form", new LoadProjectCallback() {  
                    @Override  
                    public void execute(Project project, Project[] projects, RPCResponse rpcResponse) {  
                        String message = RPCManager.getLoadProjectErrorMessage(rpcResponse);  
                        if (message != null) {  
                            SC.warn(message);  
                            return;  
                        }  
                        if (rpcResponse.getStatus() == 0) {  
                            Canvas screen = project.createScreen((project.getScreenNames()[0]));  
                            final DynamicForm saveForm = (DynamicForm)screen.getByLocalId("simpleForm");  
                            ButtonItem saveButton = (ButtonItem)saveForm.getField("saveDataButton");  
                            if (saveButton != null) {
                                saveButton.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {  
                                    @Override  
                                    public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {  
                                        Map values = saveForm.getValues();  
                                        if (!Boolean.TRUE.equals((Boolean)values.get("inStock")) && values.get("nextShipment") == null) {    
                                            SC.warn("New stock items which are not already stocked must have a Stock Date");    
                                        }  
                                    }  
                                });
                            }
                            Canvas target = container.getMember(1);
                            if (target != null) container.replaceMember(target, screen);
                            else container.addMember(screen);  
                        }  
                    }
                }, settings);
            }  
        });  
        container.addMember(button);

        return container;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    @Override  
    protected boolean isTopIntro() {  
        return true;  
    }

}
