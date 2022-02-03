package com.smartgwt.sample.showcase.client.reifyIntegration;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.callbacks.LoadProjectCallback;
import com.smartgwt.client.rpc.LoadProjectSettings;
import com.smartgwt.client.rpc.Project;
import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.tools.Reify;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.EdgeName;
import com.smartgwt.client.types.NotifyTransition;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.notify.Notify;
import com.smartgwt.client.widgets.notify.NotifySettings;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;  
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS; 
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.SourceEntity;

public class ProjectLoadingReifySample extends ShowcasePanel {
    private static final String DESCRIPTION = "Loading a Reify project is just a single method call: <code>Reify.loadProject()</code>." +
        "<P>"+
        "If you’ve been using Reify, just type in one of your project names and your credentials below, and we'll load your screen."+
        "<P>"+
        "If you haven't gotten started with Reify yet, just press Load Project - this loads a sample project stored at Reify.com. "+
        "Other sample projects are \"Simple Grid\" (just a grid) and \"Test Loader\" (just a simple Label confirming loading is working)."+
        "<P>"+
        "If you have a Reify OnSite server - which is like having your own private Reify.com, behind your firewall - just enter the server "+
        "address to load projects from that server.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ProjectLoadingReifySample panel = new ProjectLoadingReifySample();
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
        final DataSource supplyCategoryDS = SupplyCategoryXmlDS.getInstance("supplyCategory");  
        final DataSource supplyItemDS = ItemSupplyXmlDS.getInstance("supplyItem", "supplyCategory"); 
        DataSource.get("supplyItem");
        DataSource.get("supplyCategory");

        final VLayout mainLayout = new VLayout();
        mainLayout.setPadding(10);
        mainLayout.setLayoutMargin(5);
        mainLayout.setDefaultLayoutAlign(Alignment.CENTER);
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        mainLayout.setBorder("1px dashed blue");

        final DynamicForm projectForm = new DynamicForm();
        projectForm.setSnapTo("T");
        projectForm.setWidth(250);
        projectForm.setWrapItemTitles(false);
        
        TextItem projectName = new TextItem();
        projectName.setName("projectName");
        projectName.setTitle("Project Name");
        projectName.setDefaultValue("Supply Catalog");
        
        TextItem userName = new TextItem();
        userName.setName("userName");
        userName.setTitle("Email / User Name");
        userName.setDefaultValue("reifySample");
        
        PasswordItem password = new PasswordItem();
        password.setName("password");
        password.setTitle("Password");
        password.setDefaultValue("tryReify");
        
        TextItem serverURL = new TextItem();
        serverURL.setName("serverURL");
        serverURL.setTitle("Server URL");
        serverURL.setDefaultValue("https://create.reify.com");
        
        ButtonItem loadProjectButton = new ButtonItem();
        loadProjectButton.setTitle("Load Project");
        loadProjectButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                final String projectName = projectForm.getValueAsString("projectName");
                
                LoadProjectSettings settings = new LoadProjectSettings();
                settings.setUserName(projectForm.getValueAsString("userName"));
                settings.setPassword(projectForm.getValueAsString("password"));
                settings.setServerURL(projectForm.getValueAsString("serverURL"));
                settings.setWillHandleError(true);
                
                Reify.loadProject(projectName, new LoadProjectCallback() {
                    @Override
                    public void execute(Project project, Project[] projects, RPCResponse rpcResponse) {
                        String message = RPCManager.getLoadProjectErrorMessage(rpcResponse);
                        if (message != null) {
                            SC.warn(message);
                            return;
                        }
                        if (rpcResponse.getStatus() == 0) {
                            if (mainLayout.getMember(1) != null) mainLayout.removeMember(mainLayout.getMember(1));
                            
                            Canvas screen = project.createScreen((project.getScreenNames()[0]));
                            mainLayout.addMember(screen);
                            
                            NotifySettings notifySettings = new NotifySettings();  
                            notifySettings.setCanDismiss(true);  
                            notifySettings.setPosition(EdgeName.C);  
                            notifySettings.setAppearMethod(NotifyTransition.FADE);  
                            notifySettings.setDisappearMethod(NotifyTransition.FADE);  
                            notifySettings.setAutoFitMaxWidth(400);
              
                            Notify.addMessage("Project "+projectName+" loaded from "+projectForm.getValueAsString("serverURL"), 
                                    null, null, notifySettings);  
                        }
                    }
                }, settings);
                
            }
            
        });
        
        projectForm.setFields(projectName, userName, password, serverURL, loadProjectButton);
        
        mainLayout.setMembers(projectForm);

        return mainLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
