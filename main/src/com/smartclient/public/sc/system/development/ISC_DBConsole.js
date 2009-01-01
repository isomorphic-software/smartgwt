
/*

  SmartClient Ajax RIA system
  Version 7.0beta3/LGPL Development Only (2008-12-31)

  Copyright 2000-2007 Isomorphic Software, Inc. All rights reserved.
  "SmartClient" is a trademark of Isomorphic Software, Inc.

  LICENSE NOTICE
     INSTALLATION OR USE OF THIS SOFTWARE INDICATES YOUR ACCEPTANCE OF THE
     SOFTWARE EVALUATION LICENSE AGREEMENT. If you have received this file
     without an Isomorphic Software license file, please see:

         http://www.isomorphic.com/licenses/isc_eval_license_050316.html

     You are not required to accept this agreement, however, nothing else
     grants you the right to copy or use this software. Unauthorized copying
     and use of this software is a violation of international copyright law.

  EVALUATION ONLY
     This software is provided for limited evaluation purposes only. You must
     acquire a deployment license from Isomorphic Software in order to use
     the SmartClient system, or any portion thereof, in any non-evaluation
     application, including internal or non-commercial applications.

  PROPRIETARY & PROTECTED MATERIAL
     This software contains proprietary materials that are protected by
     contract and intellectual property law. YOU ARE EXPRESSLY PROHIBITED
     FROM ATTEMPTING TO REVERSE ENGINEER THIS SOFTWARE OR MODIFY THIS
     SOFTWARE FOR HUMAN READABILITY.

  CONTACT ISOMORPHIC
     For more information regarding license rights and restrictions, or to
     report possible license violations, please contact Isomorphic Software
     by email (licensing@isomorphic.com) or web (www.isomorphic.com).

*/

if(window.isc&&window.isc.module_Core&&!window.isc.module_DBConsole){isc.module_DBConsole=1;isc._moduleStart=isc._DBConsole_start=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc._moduleEnd&&(!isc.Log||(isc.Log && isc.Log.logIsDebugEnabled('loadTime')))){isc._pTM={ message:'DBConsole load/parse time: ' + (isc._moduleStart-isc._moduleEnd) + 'ms', category:'loadTime'};
if(isc.Log && isc.Log.logDebug)isc.Log.logDebug(isc._pTM.message,'loadTime')
else if(isc._preLog)isc._preLog[isc._preLog.length]=isc._pTM
else isc._preLog=[isc._pTM]}isc.InstantDataApp.create({appAssembly:"smartclient",operations:{getDefinedDatabases:{type:"custom",ID:"getDefinedDatabases"},testDB:{type:"custom",ID:"testDB"},saveDBConfig:{type:"custom",ID:"saveDBConfig"},setDefaultDB:{type:"custom",ID:"setDefaultDB"},getDefinedDataSources:{type:"custom",ID:"getDefinedDataSources"},importDataSources:{type:"custom",ID:"importDataSources"}},appImplementer:"com.isomorphic.tools.AdminConsole",ID:"adminConsole"})
isc.defineClass("DBConsole","TabSet");isc.A=isc.DBConsole.getPrototype();isc.A.dbConfiguratorConstructor="DBConfigurator";isc.A.dsImporterConstructor="DSImporter";isc.A=isc.DBConsole.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.creatorName="dbConsole";isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments);if(!this.adminConsole)this.adminConsole=window.adminConsole;this.autoChildDefaults={adminConsole:this.adminConsole};this.dbConfigurator=this.createAutoChild("dbConfigurator");this.dsImporter=this.createAutoChild("dsImporter");var _1=window.location.toString().match(/[?&](?:target)=([^&]*)/);var _2=(_1&&_1[1]=="dsImporter");this.addTabs([{ID:"dbConfigurator",title:"Database Configuration",pane:this.dbConfigurator},{ID:"dsImporter",title:"Import DataSources",pane:this.dsImporter}]);if(_2)this.selectTab("dsImporter");isc.RPCManager.startQueue();this.dbConfigurator.getDefinedDatabases();this.dsImporter.getDefinedDataSources();isc.RPCManager.sendQueue()}
);isc.B._maxIndex=isc.C+1;isc.defineClass("DSImporter","VLayout");isc.A=isc.DSImporter.getPrototype();isc.A.dsListDefaults={_constructor:"ListGrid",sortFieldNum:0,fields:[{name:"dsName",title:"DataSource ID",width:"*"},{name:"dsType",title:"Type",width:100},{name:"testData",title:"Test Data",width:60}],contextMenu:{data:[{title:"Select All",click:"target.selection.selectAll()"},{title:"DeSelect All",click:"target.selection.deselectAll()"},{isSeparator:true},{title:"Refresh",click:"target.dsImporter.getDefinedDataSources()"}]},selectionChanged:function(_1,_2){var _3=this.getSelection(),_4=this.creator.dsViewer;_4.setData(_3);if(_3&&_3.length>0){var _5=this.creator.dsContents;isc.DS.get(_3[0].dsName,function(_6){_5.setDataSource(_6);_5.fetchData(null,function(_7){if(_7.status<0)_5.setData([])},{willHandleError:true})})}}};isc.A.dsListToolbarDefaults={_constructor:"Toolbar",buttons:[{title:"Refresh",width:100,click:"this.parentElement.creator.getDefinedDataSources()"}]};isc.A.dsViewerDefaults={_constructor:"DetailViewer",recordsPerBlock:4,blockSeparator:"",canSelectText:true,overflow:"visible",emptyMessage:"Please select a DataSource",fields:[{name:"dsName",title:"DataSource ID"},{name:"dsType",title:"Type"},{name:"filename",title:"DataSource File"},{name:"testData",title:"Test Data"},{name:"testDataFilename",title:"Test Data File"}]};isc.A.dsContentsToolbarDefaults={_constructor:"Toolbar",membersMargin:10,buttons:[{title:"Refresh",width:100,click:"this.parentElement.creator.dsContents.data.invalidateCache()"},{title:"Delete Selected",width:150,click:"this.parentElement.creator.dsContents.removeSelectedData()"}]};isc.A.dsContentsDefaults={_constructor:"ListGrid",showFilterEditor:true,showHiddenFields:true,showCellContextMenus:true,canEdit:true,listEndEditAction:"next"};isc.A.dsOptionsDefaults={_constructor:"DynamicForm",fields:[{name:"currentDB",type:"blurb"},{name:"importTestData",type:"checkbox",title:"Import Test Data (if present)",defaultValue:true},{name:"replaceTables",type:"checkbox",title:"Replace Existing Table(s) (if present)",defaultValue:true}]};isc.A.dsActionsDefaults={_constructor:"Toolbar",buttons:[{title:"Import",width:100,click:"this.parentElement.creator.importDataSources()"}]};isc.A=isc.DSImporter.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.creatorName="dsImporter";isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments);this.dsList=this.createAutoChild("dsList");this.dsListToolbar=this.createAutoChild("dsListToolbar");this.dsViewer=this.createAutoChild("dsViewer");this.dsContentsToolbar=this.createAutoChild("dsContentsToolbar");this.dsContents=this.createAutoChild("dsContents");this.dsOptions=this.createAutoChild("dsOptions");this.dsActions=this.createAutoChild("dsActions");this.addMembers([isc.VLayout.create({autoDraw:false,height:"33%",showResizeBar:true,members:[this.dsList,this.dsListToolbar]}),isc.VLayout.create({autoDraw:false,members:[this.dsViewer,this.dsContentsToolbar,this.dsContents,this.dsOptions,this.dsActions]})])}
,isc.A.getDefinedDataSources=function(){this.adminConsole.performOperation("getDefinedDataSources",null,this.getID()+".dsList.setData(data)",{prompt:"Please wait - loading list of available DataSources."})}
,isc.A.importDataSources=function(){if(this.dsList.getSelection().length==0){isc.say("Please select a DataSource to work with first.");return}
var _1=this.dsOptions.getValues();_1.dsList=this.dsList.getSelection().getProperty("dsName").getUniqueItems();var _2={appInputs:_1,prompt:"Importing Datasource[s] - This may take a few minutes."};this.adminConsole.performOperation("importDataSources",null,"isc.say(data)",_2)}
);isc.B._maxIndex=isc.C+3;isc.defineClass("DBConfigurator","VLayout");isc.A=isc.DBConfigurator.getPrototype();isc.A.dbListDefaults={_constructor:"ListGrid",selectionType:"single",recordClick:function(_1,_2){this.creator.dbForm.setData(isc.clone(_2));this.creator.dbForm.show();this.creator.dbForm.markForRedraw()},contextMenu:{data:[{title:"Add New",click:"target.dbConfigurator.dbForm.clearValues()"},{isSeparator:true},{title:"Refresh",click:"target.dbConfigurator.getDefinedDatabases()"}]},fields:[{name:"dbName",title:"Database Name",formatCellValue:function(_1,_2,_3,_4,_5){var _6=_2.isDefault;return _6?"<b>"+_1+"</b> (default)":_1}},{name:"database.type",title:"Database type"},{name:"driver.serverName",title:"Server Name"},{name:"dbStatus",title:"Status"}]};isc.A.dbListButtonsDefaults={_constructor:"Toolbar",buttons:[{title:"Refresh",width:100,click:"this.dbConfigurator.getDefinedDatabases()"},{title:"Add New Configuration",width:150,click:"this.dbConfigurator.dbForm.clearValues(); this.dbConfigurator.dbForm.show()"},{title:"Set As Default Database",width:150,click:function(){var _1=this.dbConfigurator.dbList.getSelectedRecord();if(_1)this.dbConfigurator.setDefaultDB(_1.dbName)}}]};isc.A.dbFormConstructor="DBForm";isc.A.dbFormButtonsDefaults={_constructor:"Toolbar",cellSpacing:10,buttons:[{title:"Test",width:100,click:"this.dbConfigurator.testDB()"},{title:"Save",width:100,click:"this.dbConfigurator.saveDB()"},{title:"Cancel",width:100,click:"this.dbConfigurator.dbForm.clearValues()"}]};isc.A=isc.DBConfigurator.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.creatorName="dsConfigurator";isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments);this.dbList=this.createAutoChild("dbList");this.dbListButtons=this.createAutoChild("dbListButtons",{buttonProperties:{dbConfigurator:this}});this.dbForm=this.createAutoChild("dbForm");this.dbFormButtons=this.createAutoChild("dbFormButtons",{buttonProperties:{dbConfigurator:this}});this.addMembers([isc.VLayout.create({autoDraw:false,showResizeBar:true,members:[this.dbList,this.dbListButtons]}),isc.VLayout.create({autoDraw:false,members:[this.dbForm,this.dbFormButtons]})])}
,isc.A.getDefinedDatabases=function(){this.adminConsole.performOperation("getDefinedDatabases",null,this.getID()+".getDefinedDatabasesCallback(data)",{prompt:"Please wait - getting list and status of configured database."})}
,isc.A.getDefinedDatabasesCallback=function(_1){for(var i=0;i<_1.length;i++){if(_1[i].isDefault)this.creator.defaultDatabaseID=_1[i].dbName;if(_1[i]['driver.url']){_1[i].useURL=true;_1[i]["driver.serverName"]="Embedded in JDBC URL"}}
this.dbList.setData(_1)}
,isc.A.setDefaultDB=function(_1){var _2={appInputs:{dbName:_1}};this.adminConsole.performOperation("setDefaultDB",null,this.getID()+".setDefaultDBCallback(data)",_2)}
,isc.A.setDefaultDBCallback=function(_1){isc.say("Default database is now: <b>"+_1+"<p><i>Please wait for the container to reload before continuing."+"<br>Note that you may need to explicitly restart your servlet engine if you"+" encounter difficulty accessing this database.</i>")}
,isc.A.testDB=function(){if(!this.dbForm.validate())return;var _1=this.dbForm.getValue("dbName");var _2=this.dbForm.getValues();var _3={appInputs:{dbName:_1,dbConfig:_2},willHandleError:true};this.adminConsole.performOperation("testDB",null,this.getID()+".testDBCallback(data)",_3)}
,isc.A.testDBCallback=function(_1){isc.say(_1,{title:"Result of test"})}
,isc.A.saveDB=function(){if(!this.dbForm.validate())return;isc.RPCManager.startQueue();this.adminConsole.performOperation("saveDBConfig",this.dbForm.getValues(),this.getID()+".saveDBCallback(data)");this.getDefinedDatabases();isc.RPCManager.sendQueue()}
,isc.A.saveDBCallback=function(_1){var _2=this.dbForm.getValue('dbName');isc.say("Saved configuration for database '"+_2+"."+"<p><i>Please wait for the container to reload before continuing."+"<br>Note that you may need to explicitly restart your servlet engine if you"+" encounter difficulty accessing this database.</i>")}
);isc.B._maxIndex=isc.C+9;isc.defineClass("DBForm","DynamicForm");isc.A=isc.DBForm.getPrototype();isc.A.titleWidth=200;isc.A.items=[{type:"text",title:"Database Name",name:"dbName",required:true},{change:"form.setDBFormDefaults()",type:"select",valueMap:{db2:"DB2",hsqldb:"HSQLDB",mysql:"MySQL",oracle:"Oracle",postgresql:"PostgreSQL",sqlserver:"SQLServer"},title:"Database Type",name:"database.type",required:true,redrawOnChange:true},{change:"form.setDBFormDefaults()",type:"select",valueMap:{dataSource:"DataSource",driverManager:"DriverManager",jndi:"App Server (JNDI)"},title:"Obtain Connections Using",name:"interface.type",required:true,redrawOnChange:true},{type:"hidden",defaultValue:"_container_",name:"driver.context"},{type:"text",hint:"e.g. jdbc/myDB",title:"JNDI Name",name:"name",showIf:"form.getValue('interface.type') == 'jndi'",validators:[{type:"requiredIf",expression:"item.isVisible()"}]},{type:"text",width:300,title:"Driver Implementer",name:"driver",validators:[{type:"requiredIf",expression:"item.isVisible()"}],showIf:"form.getValue('interface.type') != 'jndi'"},{change:"form.setDBFormDefaults()",type:"checkbox",title:"Specify explicit JDBC URL",name:"useURL",redrawOnChange:true,showIf:"form.getValue('interface.type') == 'driverManager'",_constructor:"FormItem"},{type:"text",width:400,title:"Driver URL",name:"driver.url",validators:[{type:"requiredIf",expression:"item.isVisible()"}],showIf:"form.getValue('useURL') && form.getValue('interface.type') != 'jndi'"},{type:"text",defaultValue:"localhost",title:"Server Name",name:"driver.serverName",validators:[{type:"requiredIf",expression:"item.isVisible()"}],showIf:"form.dsShowIf()"},{type:"text",title:"Port Number",name:"driver.portNumber",validators:[{type:"requiredIf",expression:"item.isVisible()"}],showIf:"form.dsShowIf()"},{type:"text",title:"Database Name/SID",name:"driver.databaseName",validators:[{type:"requiredIf",expression:"item.isVisible()"}],showIf:"form.dsShowIf()"},{type:"text",title:"User",name:"driver.user",validators:[{type:"requiredIf",expression:"item.isVisible()"}],showIf:"form.dsShowIf()"},{type:"text",title:"Password",name:"driver.password",required:false,showIf:"form.dsShowIf()"},{title:"Driver Name",name:"driver.driverName",validators:[{type:"requiredIf",expression:"item.isVisible()"}],showIf:"form.getValue('interface.type') == 'driverManager' && !form.getValue('useURL')"},{defaultValue:"thin",title:"Driver Type",name:"driver.driverType",validators:[{type:"requiredIf",expression:"item.isVisible()"}],showIf:"form.getValue('interface.type') == 'dataSource' && form.getValue('database.type') == 'oracle'"},{defaultValue:"tcp",title:"Network Protocol",name:"driver.networkProtocol",showIf:"form.getValue('interface.type') == 'dataSource'"},{type:"checkbox",title:"Enable ISC Connection Pooling",name:"pool.enabled",showIf:"form.getValue('interface.type') != 'jndi'"}];isc.A=isc.DBForm.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.dsShowIf=function(){return(this.getValue('interface.type')!='jndi'&&!this.getValue('useURL'))}
,isc.A.setDBFormDefaults=function(){var _1=this;var _2=_1.getValue('database.type');var _3=_1.getValue('interface.type');if(_3=='jndi')return;var _4='';if(_2=='mysql')_4='3306';else if(_2=='postgresql')_4='5432';else if(_2=='oracle')_4='1521';else if(_2=='sqlserver')_4='1433';else if(_2=='db2')_4='6789'
_1.setValue('driver.portNumber',_4);var _5='';if(_3=='dataSource'){if(_2=='oracle')_5='oracle.jdbc.pool.OracleDataSource';if(_2=='mysql')_5='com.mysql.jdbc.jdbc2.optional.MysqlDataSource';if(_2=='sqlserver')_5='com.microsoft.sqlserver.jdbc.SQLServerDriver';if(_2=='postgresql')_5='';if(_2=='db2')_5='COM.ibm.db2.jdbc.DB2DataSource'}
if(_3=='driverManager'){if(_2=='oracle')_5='oracle.jdbc.driver.OracleDriver';if(_2=='mysql')_5='org.gjt.mm.mysql.Driver';if(_2=='sqlserver')_5='';if(_2=='postgresql')_5='org.postgresql.Driver';if(_2=='db2')_5=''}else{_1.setValue('useURL',false)}
_1.setValue('driver',_5);var _6=_1.getValue('driver.serverName');if(_6=='Embedded in JDBC URL')_1.setValue('driver.serverName','');if(_1.getValue('useURL')==false)_1.setValue('driver.url','');var _7='';if(_3=='driverManager')_7=_2;_1.setValue('driverName',_7)}
);isc.B._maxIndex=isc.C+2;isc._moduleEnd=isc._DBConsole_end=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc.Log&&isc.Log.logIsInfoEnabled('loadTime'))isc.Log.logInfo('DBConsole module init time: ' + (isc._moduleEnd-isc._moduleStart) + 'ms','loadTime');}else{if(window.isc && isc.Log && isc.Log.logWarn)isc.Log.logWarn("Duplicate load of module 'DBConsole'.");}

/*

  SmartClient Ajax RIA system
  Version 7.0beta3/LGPL Development Only (2008-12-31)

  Copyright 2000-2007 Isomorphic Software, Inc. All rights reserved.
  "SmartClient" is a trademark of Isomorphic Software, Inc.

  LICENSE NOTICE
     INSTALLATION OR USE OF THIS SOFTWARE INDICATES YOUR ACCEPTANCE OF THE
     SOFTWARE EVALUATION LICENSE AGREEMENT. If you have received this file
     without an Isomorphic Software license file, please see:

         http://www.isomorphic.com/licenses/isc_eval_license_050316.html

     You are not required to accept this agreement, however, nothing else
     grants you the right to copy or use this software. Unauthorized copying
     and use of this software is a violation of international copyright law.

  EVALUATION ONLY
     This software is provided for limited evaluation purposes only. You must
     acquire a deployment license from Isomorphic Software in order to use
     the SmartClient system, or any portion thereof, in any non-evaluation
     application, including internal or non-commercial applications.

  PROPRIETARY & PROTECTED MATERIAL
     This software contains proprietary materials that are protected by
     contract and intellectual property law. YOU ARE EXPRESSLY PROHIBITED
     FROM ATTEMPTING TO REVERSE ENGINEER THIS SOFTWARE OR MODIFY THIS
     SOFTWARE FOR HUMAN READABILITY.

  CONTACT ISOMORPHIC
     For more information regarding license rights and restrictions, or to
     report possible license violations, please contact Isomorphic Software
     by email (licensing@isomorphic.com) or web (www.isomorphic.com).

*/

