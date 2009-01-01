
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

if(window.isc&&window.isc.module_Core&&!window.isc.module_FileBrowser){isc.module_FileBrowser=1;isc._moduleStart=isc._FileBrowser_start=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc._moduleEnd&&(!isc.Log||(isc.Log && isc.Log.logIsDebugEnabled('loadTime')))){isc._pTM={ message:'FileBrowser load/parse time: ' + (isc._moduleStart-isc._moduleEnd) + 'ms', category:'loadTime'};
if(isc.Log && isc.Log.logDebug)isc.Log.logDebug(isc._pTM.message,'loadTime')
else if(isc._preLog)isc._preLog[isc._preLog.length]=isc._pTM
else isc._preLog=[isc._pTM]}isc.DataSource.create({
criteriaPolicy:"dropOnChange",
serverConstructor:"com.isomorphic.datasource.FilesystemDataSource",
ID:"Filesystem",
fields:{
path:{
type:"text",
title:"Path",
name:"path",
length:2000,
required:true,
primaryKey:true
},
parentID:{type:"text",name:"parentID",required:true,foreignKey:"Filesystem.path",rootValue:"/",
hidden:true},
name:{type:"text",name:"name"},
isFolder:{type:"boolean",name:"isFolder"},
size:{type:"long",name:"size"},
lastModified:{type:"lastModified",name:"lastModified"},
mimeType:{type:"text",name:"mimeType"}
}
})
isc.defineClass("FileBrowser","Window");isc.A=isc.FileBrowser;isc.A.dsDir="/shared/ds";isc.A.appDir="/shared/app";isc.A.uiDir="/shared/ui";isc.A=isc.FileBrowser.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.autoCenter=true;isc.A.modal=true;isc.A.width=400;isc.A.height=300;isc.A.canDragResize=true;isc.A.actionStripConstructor="ToolStrip";isc.A.actionStripDefaults={height:24,autoParent:"body"};isc.A.actionStripControls=["spacer:10","pathLabel","previousFolderButton","spacer:10","upOneLevelButton","spacer:10","createNewFolderButton","spacer:10","refreshButton","spacer:2"];isc.A.pathLabelConstructor="Label";isc.A.pathLabelDefaults={width:"*",autoParent:"actionStrip"};isc.A.previousFolderButtonConstructor="ImgButton";isc.A.previousFolderButtonDefaults={size:16,layoutAlign:"center",src:"[SKIN]/previousFolder.png",showRollOver:false,showDown:false,prompt:"Go To Last Folder Visited",click:"this.creator.previousFolder()"};isc.A.upOneLevelButtonConstructor="ImgButton";isc.A.upOneLevelButtonDefaults={autoParent:"actionStrip",size:16,layoutAlign:"center",src:"[SKIN]/upOneLevel.png",showRollOver:false,showDown:false,prompt:"Up One Level",click:"this.creator.upOneLevel()"};isc.A.createNewFolderButtonConstructor="ImgButton";isc.A.createNewFolderButtonDefaults={autoParent:"actionStrip",size:16,layoutAlign:"center",src:"[SKIN]/createNewFolder.png",showRollOver:false,showDown:false,prompt:"Create New Folder",click:"this.creator.createNewFolder()"};isc.A.refreshButtonConstructor="ImgButton";isc.A.refreshButtonDefaults={autoParent:"actionStrip",size:16,layoutAlign:"center",src:"[SKIN]/refresh.png",showRollOver:false,showDown:false,prompt:"Refresh",click:"this.creator.refresh()"};isc.A.directoryListingConstructor="ListGrid";isc.A.directoryListingDefaults={dataSource:"Filesystem",sortFieldNum:1,canEdit:true,folderIcon:"[SKIN]/FileBrowser/folder.png",fileIcon:"[SKIN]/FileBrowser/file.png",loadingDataMessage:"&nbsp;",emptyMessage:"&nbsp;",fileBrowser:this,showHeader:false,selectionStyle:"single",recordClick:function(_1,_2,_3){_2._canEdit=false;if(!_2.isFolder){this.creator.actionForm.setValue("fileName",_2.name)}
if(_2==this.$48r){delete _2._canEdit;if(this.canEdit)this.startEditing(_3,1);return}
this.$48r=_2;return false},recordDoubleClick:function(_1,_2){if(_2.isFolder){this.creator.setDir(_2.path)}else{this.creator.fileSelected(_2.name)}
return false},rowContextClick:function(_1){this.$48s=_1;if(!this.$48t)this.$48t=isc.Menu.create({grid:this,deleteFile:function(){this.grid.creator.confirmRemoveFile(this.grid.$48s.path)},newFolder:function(){this.grid.creator.createNewFolder()},data:[{title:"Delete file (recursive)",click:"menu.deleteFile()"}]});this.$48t.showContextMenu();return false},fields:[{name:"isFolder",canEdit:false,formatCellValue:function(_1,_2,_3,_4,_5){var _6=_1?_5.folderIcon:_5.fileIcon
return _5.$30s(_6,this,_5,_2,_3,_4)},width:20},{name:"name",width:"*"}]};isc.A.showDirectoryShortcuts=false;isc.A.directoryShortcutsConstructor="VLayout";isc.A.directoryShortcutsDefaults={width:60};isc.A.actionFormConstructor="DynamicForm";isc.A.actionFormDefaults={overflow:"hidden",autoParent:"body",numCols:3,height:45,colWidths:[100,"*",120],browserSpellCheck:false,process:function(){if(this.validate())this.creator.fileSelected(this.getValue("fileName"))},fields:[{name:"fileName",type:"text",width:"*",title:"File name",keyPress:"if (keyName == 'Enter') form.process()",validators:[{type:"lengthRange",max:255,min:1},{type:"regexp",expression:"([^:\\*\\?<>\\|\\/\"'])+",errorMessage:"Can't contain \\/:*?\"'<>|"}]},{name:"button",type:"button",startRow:false,click:"form.process()"}]};isc.A.skinImgDir="images/FileBrowser/";isc.A.rootDir="/";isc.A.initialDir="/";isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments)}
,isc.A.draw=function(){this.Super("draw",arguments);if(this.$48u)return;this.addAutoChild("actionStrip");if(this.actionStripControls){for(var i=0;i<this.actionStripControls.length;i++){var _2=this.actionStripControls[i];if(_2.startsWith("spacer:")){this.actionStrip.addMember(isc.LayoutSpacer.create({width:_2.substring(_2.indexOf(":")+1)}))}else if(_2=="separator"){}else{if(isc.isA.String(_2)){this.addAutoChild(_2,{skinImgDir:this.skinImgDir},null,this.actionStrip)}else{this.actionStrip.addMember(_2)}}}}
if(this.showDirectoryShortcuts!==false){this.directoryLayout=isc.HLayout.create();this.addItem(this.directoryLayout);this.addAutoChild("directoryShortcuts",null,null,this.directoryLayout);this.addAutoChild("directoryListing",null,null,this.directoryLayout)}else{this.addAutoChild("directoryListing",null,null,this.body)}
this.addItem(isc.LayoutSpacer.create({height:10}));this.addAutoChild("actionForm");this.actionForm.getField("button").setTitle(this.actionButtonTitle);if(this.initialDir)this.setDir(this.initialDir);this.$48u=true}
,isc.A.$48v=function(_1,_2){if(!_1.endsWith("/"))_1+="/";return _1+_2}
,isc.A.setFileName=function(_1){this.actionForm.setValue("fileName",_1)}
,isc.A.setDir=function(_1,_2){if(!_1)return;if(_1!=this.rootDir&&_1.endsWith("/"))_1=_1.substring(0,_1.length-1);if(_1.length<this.rootDir.length){isc.say("You cannot go up any further.");return}
if(!_2){if(!this.folderHistory)this.folderHistory=[];if(this.currentDir)this.folderHistory.add(this.currentDir)}
this.currentDir=_1;this.pathLabel.setContents(this.currentDir);this.directoryListing.filterData({fileFilter:this.fileFilter,parentID:_1},null,{promptStyle:"cursor"})}
,isc.A.upOneLevel=function(){if(!this.currentDir){this.logWarn("upOneLevel() called without currentDir");return}
if(this.currentDir=="/"){this.logWarn("upOneLevel() called on rootDir");return}
var _1=this.currentDir.lastIndexOf("/");var _2=this.currentDir.substring(0,_1);if(_2==isc.emptyString)_2="/";this.setDir(_2)}
,isc.A.previousFolder=function(){if(!this.folderHistory||this.folderHistory.length==0)return;this.setDir(this.folderHistory.pop(),true)}
,isc.A.refresh=function(){if(this.directoryListing.data)this.directoryListing.data.invalidateCache();this.setDir(this.currentDir)}
,isc.A.createNewFolder=function(){this.directoryListing.startEditingNew({path:this.currentDir,isFolder:true})}
,isc.A.confirmRemoveFile=function(_1){isc.confirm("Are you sure you want to recursively delete "+_1+"?","value ?"+this.getID()+".removeFile('"+_1+"'):false")}
,isc.A.removeFile=function(_1){this.directoryListing.removeData({path:_1})}
);isc.B._maxIndex=isc.C+11;isc.FileBrowser.registerStringMethods({fileSelected:"fileName"});isc.defineClass("SaveFileDialog","FileBrowser");isc.A=isc.SaveFileDialog.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.title="Save File";isc.A.actionButtonTitle="Save";isc.B.push(isc.A.getFileName=function(_1){return _1}
,isc.A.fileSelected=function(_1){var _1=this.getFileName(_1);if(_1===false||_1==null)return;this.confirmAction(_1)}
,isc.A.confirmAction=function(_1){if(this.directoryListing.data.find("name",_1)!=null){isc.confirm(this.$48v(this.currentDir,_1)+" already exists.  Do you want to replace it?","value ? "+this.getID()+".saveFile('"+_1+"'):false")}else{this.saveFile(_1)}}
,isc.A.getFileContents=function(_1){return this.fileContents}
,isc.A.saveFile=function(_1){this.fileName=_1;this.fileContents=this.getFileContents(_1);if(this.fileContents==null){this.logWarn("attempt to save with null fileContents");return}
isc.DMI.callBuiltin({methodName:"saveFile",arguments:[this.$48v(this.currentDir,_1),this.fileContents],callback:this.getID()+".saveFileCallback(rpcResponse)"})}
,isc.A.saveFileCallback=function(_1){delete this.fileContents;this.saveComplete(this.fileName)}
,isc.A.saveComplete=function(_1){isc.say("File saved.",this.getID()+".hide()")}
,isc.A.show=function(_1,_2){if(_1!=null)this.fileContents=_1;if(_2!=null)this.setFileName(_2);this.Super("show",arguments);this.actionForm.delayCall("focusInItem",["fileName"])}
);isc.B._maxIndex=isc.C+8;isc.defineClass("LoadFileDialog","FileBrowser");isc.A=isc.LoadFileDialog.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.title="Load File";isc.A.actionButtonTitle="Load";isc.B.push(isc.A.fileSelected=function(_1){if(_1==null)return;this.loadFile(_1)}
,isc.A.loadFile=function(_1){this.fileName=_1;isc.DMI.callBuiltin({methodName:"loadFile",arguments:[this.makePath(this.currentDir,_1)],callback:this.getID()+".loadFileCallback(data)"})}
,isc.A.loadFileCallback=function(_1){this.fireCallback("fileLoaded","fileContents,fileName",[_1,this.fileName])}
);isc.B._maxIndex=isc.C+3;isc.LoadFileDialog.registerStringMethods({fileLoaded:"fileContents,fileName"});isc._moduleEnd=isc._FileBrowser_end=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc.Log&&isc.Log.logIsInfoEnabled('loadTime'))isc.Log.logInfo('FileBrowser module init time: ' + (isc._moduleEnd-isc._moduleStart) + 'ms','loadTime');}else{if(window.isc && isc.Log && isc.Log.logWarn)isc.Log.logWarn("Duplicate load of module 'FileBrowser'.");}

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

