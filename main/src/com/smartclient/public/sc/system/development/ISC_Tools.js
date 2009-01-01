
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

if(window.isc&&window.isc.module_Core&&!window.isc.module_Tools){isc.module_Tools=1;isc._moduleStart=isc._Tools_start=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc._moduleEnd&&(!isc.Log||(isc.Log && isc.Log.logIsDebugEnabled('loadTime')))){isc._pTM={ message:'Tools load/parse time: ' + (isc._moduleStart-isc._moduleEnd) + 'ms', category:'loadTime'};
if(isc.Log && isc.Log.logDebug)isc.Log.logDebug(isc._pTM.message,'loadTime')
else if(isc._preLog)isc._preLog[isc._preLog.length]=isc._pTM
else isc._preLog=[isc._pTM]}if(!isc.TScrollbar)isc.defineClass("TScrollbar","Scrollbar");if(!isc.TPropertySheet)isc.defineClass("TPropertySheet","PropertySheet");if(!isc.TSectionItem)isc.defineClass("TSectionItem","SectionItem");if(!isc.TSectionStack)isc.defineClass("TSectionStack","SectionStack");if(!isc.TSectionHeader)isc.defineClass("TSectionHeader","SectionHeader");if(!isc.TImgSectionHeader)isc.defineClass("TImgSectionHeader","ImgSectionHeader");if(!isc.TButton)isc.defineClass("TButton","StretchImgButton");if(!isc.TAutoFitButton)isc.defineClass("TAutoFitButton","TButton");if(!isc.TMenuButton)isc.defineClass("TMenuButton","MenuButton");if(!isc.TMenu)isc.defineClass("TMenu","Menu");if(!isc.TTabSet)isc.defineClass("TTabSet","TabSet")
isc.defineClass("ComponentEditor","PropertySheet");isc.A=isc.ComponentEditor.getPrototype();isc.A.immediateSave=false;isc.A.itemHoverWidth=500;isc.A.showSuperClassEvents=true;isc.A.initialGroups=3;isc.A.showAttributes=true;isc.A.showMethods=false;isc.A=isc.ComponentEditor.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.handlerFieldBase={validateOnChange:true,validators:[{type:"isFunction"}],itemHoverHTML:function(){var _1=this.mapValueToDisplay(this.getValue());if(_1==null)return _1;if(_1=="&nbsp;"||_1.match(/^\W+$/))_1="";return _1.asHTML()}};isc.A.itemHoverStyle="docHover";isc.B.push(isc.A.shouldUseField=function(_1){if(!this.Super("shouldUseField",arguments)){return false}
if(_1.hidden||_1.inapplicable||_1.advanced)return false;if(_1.type&&isc.DS.isLoaded(_1.type)&&_1.type!="ValueMap"&&_1.type!="Action")
{return false}
var _2=isc.DS.get(this.dataSource);if(!_2)return true;var _3=_2.ID,_4=_1[this.fieldIdProperty];if(isc.jsdoc.hasData()){var _5=isc.jsdoc.getDocItem(_3,_4,true);if(_1.visibility!=null&&_5==null)return false;if(isc.isAn.XMLNode(_5)&&_5.getAttribute("deprecated"))return false;if(_5&&isc.jsdoc.isAdvancedAttribute(_5))return false}
return true}
,isc.A.bindToDataSource=function(_1,_2){var _3=this.$46d=this.Super("bindToDataSource",arguments);var _4=this.dataSource?isc.DS.get(this.dataSource):null;if(_1&&_1.length>0)return _3;if(_4==null||this.$46d==null)return _3;for(var i=0;i<_3.length;i++){var _6=_3[i],_7=_6.defaultValue;if(_7==null)continue;if(_7=="false")_7=false;else if(_7=="true")_7=true;else if(parseInt(_7).toString()==_7){_7=parseInt(_7)}
_6.defaultValue=_7}
if(!isc.jsdoc.hasData())return _3;var _8={},_9=false;if(this.showAttributes){for(var i=0;i<_3.length;i++){var _6=_3[i],_10=_6[this.fieldIdProperty];var _11=isc.jsdoc.getGroupForAttribute(_4.ID,_10)||_6.group||"other";if(_11==null)_11="other";if(_11!="other")_9=true;if(!_8[_11])_8[_11]=[];_8[_11].add(_6)}}
if(this.showMethods){if(!this.createMethodGroups(_8,_4)&&!this.showAttributes){return[]}else{_9=true}}
if(!_9){if(this.sortFields)_3.sortByProperty("name",Array.ASCENDING);return _3}
var _12=isc.getKeys(_8),_13=_4.getGroups(),_14=[];if(_13!=null){for(var i=0;i<_13.length;i++){var _15=_12.indexOf(_13[i]);if(_15==-1)continue;_12.removeAt(_15);_14.add(_13[i])}
_14.addList(_12)}else{_14=_12}
var _15=_14.indexOf("other");if(_15!=-1){_14.removeAt(_15);_14.add("other")}
_1=[];for(var i=0;i<_14.length;i++){var _11=_14[i],_16=_8[_11],_17=isc.jsdoc.getGroupItem(_11),_18=_17&&_17.title?_17.title:_11.substring(0,1).toLocaleUpperCase()+_11.substring(1);if(this.sortFields)_16.sortByProperty("name",Array.ASCENDING);_1[_1.length]={editorType:"TSectionItem",defaultValue:_18,sectionExpanded:(i<this.initialGroups),items:_16}}
return _1}
,isc.A.createMethodGroups=function(_1,_2){var _3=isc.ClassFactory.getClass(_2.ID);this.$46e=[];if(_3&&_3._stringMethodRegistry&&!isc.isAn.emptyObject(_3._stringMethodRegistry))
{var _4=[_3];var _5=this.$du(_2.showSuperClassEvents,this.showSuperClassEvents);if(_5&&(_3.isA("Canvas")||_3.isA("FormItem"))){for(var _6=_3;_6!=isc.Class;_6=_6.getSuperClass())
{_4.add(_6)}}
_4.reverse();var _7,_8=[],_9,_10={};for(var i=0;i<_4.length;i++){var _6=_4[i];_7=isc.getKeys(_6._stringMethodRegistry);_9=_7.duplicate()
_9.removeList(_8);_8=_7;if(_9.length==0)continue;var _12=(_6==isc.Canvas?"Basic":_6.getClassName())+" Methods";_10[_12]=[];for(var j=0;j<_9.length;j++){var _14=_9[j];var _15="method:"+_6.getClassName()+"."+_14,_16=isc.jsdoc.getDocItem(_15);if(!_16){if(!_2.methods||!_2.methods.find("name",_14)){continue}}
if(_16&&isc.jsdoc.getAttribute(_16,"deprecated"))continue;var _17=this.getMethodField(_9[j]);_10[_12].add(_17)}
if(_10[_12].length==0){delete _10[_12];delete _1[_12]}}
var _18=isc.getKeys(_10).reverse();for(var i=0;i<_18.length;i++){_1[_18[i]]=_10[_18[i]]}
return true}
if(_2.methods&&_2.methods.length>0){var _19=_1[_2.ID+" Methods"]=[];for(var i=0;i<_2.methods.length;i++){var _20=_2.methods[i];var _17=this.getMethodField(_20.name);_19.add(_17)}
return true}
return false}
,isc.A.getMethodField=function(_1){var _2=isc.clone(this.handlerFieldBase);_2[this.fieldIdProperty]=_1;_2.type=this.canEditExpressions?"expression":"action";this.$46e.add(_2);return _2}
,isc.A.clearComponent=function(){var _1=this.currentComponent;if(_1==null)return;delete this.currentComponent;delete this.dataSource;this.setFields([])}
,isc.A.editComponent=function(_1,_2){var _3=_1.type,_2=_2||_1.liveObject;if(this.logIsInfoEnabled("editing")){this.logInfo("Editing component of type: "+_3+", initData: "+this.echo(_1.initData),"editing")}
this.currentComponent=_1;this.setDataSource(_3);var _4={},_5=this.$46d;if(this.$46e){_5=_5.concat(this.$46e)}
for(var i=0;i<_5.length;i++){var _7=_5[i];if(_7.advanced){_7.showIf=this.$46f}
if(!_7.name)continue;var _8=_7.name,_9;if(_2)_9=_2[_8];var _10;if(_9===_10)continue;if(isc.isA.Function(_9)){if(!_2.getClass)continue;var _11=_2.getClass().getInstanceProperty(_8);if(_11==_9)continue}
_4[_8]=_9}
if(this.logIsDebugEnabled("editing")){this.logDebug("Live values: "+this.echo(_4),"editing")}
this.setValues(_4)}
,isc.A.$46f=function(){return false}
,isc.A.wrapEditorColumns=function(){if(!this.items)return;var _1=0;for(var i=0;i<this.items.length;i++){var _3=this.items[i];if(_3.visible&&!_3.advanced)_1++}
if(_1>10)this.numCols=4;if(_1>20)this.numCols=6}
,isc.A.titleHoverHTML=function(_1){if(isc.jsdoc.hasData()){var _2=isc.jsdoc.hoverHTML(this.dataSource,_1.name);if(!_2){if(this.showMethods){var _3=isc.jsdoc.docItemForDSMethod(this.dataSource,_1.name);if(_3)_2=isc.MethodFormatter.hoverHTML(_3)}else{var _4=isc.jsdoc.docItemForDSField(this.dataSource,_1.name);if(_4)_2=isc.AttrFormatter.hoverHTML(_4)}}
if(_2)return _2}
return"<nobr><code><b>"+_1.name+"</b></code> (no doc available)</nobr>"}
,isc.A.getEditorType=function(_1){var _2=this.Super("getEditorType",arguments);_2=isc.FormItemFactory.getItemClass(_2).getClassName();var _3="T"+_2;if(isc[_3]!=null&&isc.isA.FormItem(isc[_3]))return _3;return _2}
);isc.B._maxIndex=isc.C+10;isc.defineClass("Wizard","VLayout");isc.A=isc.Wizard.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.stepInstructionsDefaults={_constructor:"Label",contents:"Instructions",padding:10,height:20};isc.A.stepPaneDefaults={_constructor:"VLayout",padding:10};isc.A.showStepIndicator=false;isc.A.stepIndicatorDefaults={_constructor:"HLayout",height:22,layoutMargin:0,layoutLeftMargin:10,membersMargin:2};isc.A.stepIndicatorItems=[];isc.A.stepButtonDefaults={_constructor:"Img",layoutAlign:"center",showRollOver:false,height:18,width:18};isc.A.stepSeparatorDefaults={_constructor:"Img",layoutAlign:"center",height:16,width:16,src:"[SKIN]/TreeGrid/opener_closed.gif"};isc.A.navButtonsDefaults={_constructor:"ToolStrip",height:22,layoutMargin:5,membersMargin:10};isc.A.navButtonsItems=["previousButton","nextButton","finishButton","cancelButton"];isc.A.previousButtonDefaults={_constructor:"Button",layoutAlign:"center",title:"Previous",click:"this.creator.previousStep()",visibility:"hidden"};isc.A.nextButtonDefaults={_constructor:"Button",layoutAlign:"center",title:"Next",click:"this.creator.nextStep()"};isc.A.finishButtonDefaults={_constructor:"Button",layoutAlign:"center",title:"Finish",click:"this.creator.finished()",visibility:"hidden"};isc.A.cancelButtonDefaults={_constructor:"Button",layoutAlign:"center",title:"Cancel",click:"this.creator.cancel()"};isc.A.autoChildParentMap={nextButton:"navButtons",previousButton:"navButtons",finishButton:"navButtons"};isc.A.$46g="_stepButton_";isc.B.push(isc.A.initWidget=function(){this.Super("initWidget");this.createSteps();this.addAutoChild("stepInstructions");this.addAutoChild("stepPane");this.addAutoChild("navButtons");this.addAutoChildren(this.navButtonsItems,this.navButtons);if(this.showStepIndicator){this.addAutoChild("stepIndicator");for(var i=0;i<this.steps.length;i++){var _2=this.steps[i].stepName,_3={src:_2};var _4=this.createAutoChild("stepButton",_3);this.stepIndicator.addMember(_4);this.steps[i].$46h=_4;if(i+1<this.steps.length){this.stepIndicator.addMember(this.createAutoChild("stepSeparator"))}}
this.navButtons.addMember(this.stepIndicator,0)}
this.goToStep(0,true)}
,isc.A.draw=function(_1){var _2=this.Super("draw",arguments);this.updateButtons();return _2}
,isc.A.createSteps=function(_1){if(!_1)_1=this.steps;if(!_1)return;if(!isc.isAn.Array(_1))_1=[_1];for(var i=0;i<_1.length;i++){_1[i]=isc.WizardStep.create(_1[i],{wizard:this})}}
,isc.A.getStep=function(_1){return isc.Class.getArrayItem(_1,this.steps)}
,isc.A.getCurrentStep=function(){return this.getStep(this.currentStepNum)}
,isc.A.getCurrentStepIndex=function(){return this.currentStepNum}
,isc.A.getStepIndex=function(_1){return isc.Class.getArrayItemIndex(_1,this.steps)}
,isc.A.getStepPane=function(_1){return this.getStep(_1).pane}
,isc.A.goToStep=function(_1,_2){if(!_2){if(!this.getCurrentStep().exitStep(_1))return;this.getStepPane(this.currentStepNum).hide()}
var _3=this.getStep(_1);_3.enterStep(this.currentStepNum);this.currentStepNum=this.getStepIndex(_3);var _4=this.getStepPane(_1);if(_3.instructions)this.stepInstructions.setContents(_3.instructions);else this.stepInstructions.hide();this.stepPane.addMember(_4,0);_4.show();this.updateButtons()}
,isc.A.go=function(_1){var _2=this.getStepIndex(this.currentStepNum);_2+=_1;this.goToStep(this.getStep(_2))}
,isc.A.nextStep=function(){var _1=this.getStep(this.currentStepNum);if(_1.hasNextStep())this.goToStep(_1.getNextStep());else this.go(1)}
,isc.A.previousStep=function(){var _1=this.getStep(this.currentStepNum);if(_1.hasPreviousStep())this.goToStep(_1.getPreviousStep());else this.go(-1)}
,isc.A.finished=function(){this.resetWizard()}
,isc.A.cancel=function(){this.resetWizard()}
,isc.A.updateButtons=function(){var _1=this.getStepIndex(this.currentStepNum),_2=this.getCurrentStep();if(this.stepIndicator){for(var i=0;i<this.steps.length;i++){var _4=this.steps[i].$46h;if(_1>i){_4.setState("")}else if(_1==i){_4.setState("Down")}else{_4.setState("Disabled")}}}
if(_1==0||this.forwardOnly||!_2.hasPreviousStep())this.previousButton.hide();else this.previousButton.show();if(!_2.hasNextStep()||_1==this.steps.length-1){this.nextButton.hide();this.finishButton.show()}else{this.nextButton.show();this.finishButton.hide()}}
,isc.A.resetWizard=function(){this.goToStep(0)}
);isc.B._maxIndex=isc.C+16;isc.defineClass("WizardStep").addMethods({enterStep:function(_1){},exitStep:function(_1){return true},hasNextStep:function(){return this.wizard.getStepIndex(this.ID)<this.wizard.steps.length-1},getNextStep:function(){return this.wizard.getStepIndex(this.ID)+1},hasPreviousStep:function(){return this.wizard.getStepIndex(this.ID)>0},getPreviousStep:function(){return this.wizard.getStepIndex(this.ID)-1}});isc.DataSource.create({ID:"isc_XMethodsServices",dataURL:"shortServiceListing.xml",recordName:"service",recordXPath:"/default:inspection/default:service",fields:[{name:"abstract",title:"Description"},{name:"xMethodsPage",title:"Site",type:"link",width:50,valueXPath:".//wsilxmethods:serviceDetailPage/@location"},{name:"wsdlURL",title:"WSDL",type:"link",width:50,valueXPath:"default:description[@referencedNamespace='http://schemas.xmlsoap.org/wsdl/']/@location"}]});isc.defineClass("DSWizardBase","VLayout");isc.A=isc.DSWizardBase.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.autoChildParentMap={nextButton:"navToolbar",previousButton:"navToolbar",finishButton:"navToolbar"};isc.B.push(isc.A.initWidget=function(){this.Super("initWidget");this.addAutoChild("stepInstructions",{contents:"Instructions",padding:4,height:20,wrap:false,overflow:"visible"},isc.Label);this.addAutoChild("navToolbar",{height:22,layoutMargin:10,membersMargin:10},isc.HLayout);this.addAutoChild("previousButton",{title:"< Previous",click:"this.creator.previousPage()",visibility:"hidden"},isc.Button);this.navToolbar.addMember(isc.LayoutSpacer.create());this.addAutoChild("nextButton",{title:"Next >",click:"this.creator.nextPage()",disabled:true,setDisabled:function(_2){var _1=this.Super('setDisabled',arguments);this.creator.$46i(_2)}},isc.Button);this.addAutoChild("finishButton",{title:"Finish",click:"this.creator.finish()",visibility:"hidden"},isc.Button);this.goToPage(0,true)}
,isc.A.getPage=function(_1){return isc.Class.getArrayItem(_1,this.pages)}
,isc.A.getCurrentPage=function(){return this.getPage(this.currentPageNum)}
,isc.A.getPageIndex=function(_1){return isc.Class.getArrayItemIndex(_1,this.pages)}
,isc.A.getPageView=function(_1,_2){var _3=this.getPage(_1),_4=_3.ID;if(!_4)return _3.view;if(_2){var _5="enter"+_4;if(this[_5])this[_5](_3,_4);else this.enterPage(_3,_4)}
this.logWarn("for page: "+this.echoLeaf(_1)+" got pageId: "+_4+(_2&&this[_5]?" called enter function: "+_5:"")+", view is: "+_3.view);return _3.view}
,isc.A.enterPage=function(_1,_2){}
,isc.A.goToPage=function(_1,_2){if(!_2){this.getPageView(this.currentPageNum).hide()}
var _3=this.getPage(_1);this.currentPageNum=this.getPageIndex(_3);var _4=this.getPageView(_1,true);if(_3.instructions)this.stepInstructions.setContents(_3.instructions);else this.stepInstructions.hide();this.addMember(_4,1);_4.show();this.updateButtons()}
,isc.A.go=function(_1){var _2=this.getPageIndex(this.currentPageNum);_2+=_1;this.goToPage(this.getPage(_2))}
,isc.A.nextPage=function(){var _1=this.getPage(this.currentPageNum);if(_1.nextPage)this.goToPage(_1.nextPage);else this.go(1)}
,isc.A.previousPage=function(){var _1=this.getPage(this.currentPageNum);if(_1.previousPage)this.goToPage(_1.previousPage);else this.go(-1)}
,isc.A.finish=function(){this.hide();this.resetWizard()}
,isc.A.updateButtons=function(){var _1=this.getPageIndex(this.currentPageNum);if(_1==0)this.previousButton.hide();else this.previousButton.show();if(this.getPage(_1).endPage||_1==this.pages.length-1){this.nextButton.hide();this.finishButton.show()}else{this.nextButton.setDisabled(this.nextButtonIsDisabled(_1));this.nextButton.show();this.finishButton.hide()}}
,isc.A.$46i=function(_1){if(!this.$46j)this.$46j=[];this.$46j[this.currentPageNum]=!_1}
,isc.A.nextButtonIsDisabled=function(_1){return this.$46j?!this.$46j[_1]:true}
,isc.A.resetWizard=function(){delete this.$46j;this.goToPage(0)}
);isc.B._maxIndex=isc.C+15;isc.defineClass("DSWizard","DSWizardBase");isc.A=isc.DSWizard.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.pages=[{ID:"StartPage",instructions:"Select the source of data to bind to:"},{ID:"PickOperationPage",instructions:"Select a public Web Service, or enter a WSDL file URL.  Then select"+" the operation to invoke"},{ID:"CallServicePage",instructions:"Use the provided form to invoke the web service and obtain a sample"+" result, then select an approriate element set for list binding"},{ID:"BindingPage",instructions:"Below is a default binding to a ListGrid.  Use the field editor to "+"customize the binding",endPage:true},{ID:"SFPickEntityPage",instructions:"Choose an object type you would like to use in SmartClient applications"},{ID:"SFDonePage",instructions:"Below is an example of a grid bound to the chosen SForce Object",endPage:true},{ID:"KapowPickRobotPage",instructions:"Choose the Kapow Robot(s) you would like to use in SmartClient applications"}];isc.A.servicePickerDefaults={recordClick:function(_1,_2,_3){var _4=this.getRawCellValue(_2,_3,this.getFieldNum("wsdlURL"));this.logWarn("wsdlURL is: "+_4);this.creator.fetchWSDL(_4)}};isc.A.operationPickerDefaults={recordClick:function(_1,_2,_3){var _4=this.getRawCellValue(_2,_3,this.getFieldNum("name"));this.creator.wsdlDoc=this.data.document;this.creator.operationName=_4;this.creator.nextButton.enable()},alternateRecordStyles:true};isc.B.push(isc.A.enterStartPage=function(_1){if(!this.dsTypePicker){this.createDSTypePicker();_1.view=this.dsTypePicker}
this.nextButton.setDisabled(this.dsTypePicker.getValue("dsType")==null)}
,isc.A.createDSTypePicker=function(){this.dsTypePicker=this.createAutoChild("dsTypePicker",{layoutAlign:"center",width:350,showHeader:false,selectionType:"single",leaveScrollbarGap:false,width:300,showAllRecords:true,bodyOverflow:"visible",overflow:"visible",data:isc.Tree.create({root:{children:[{name:"databases",canSelect:false,icon:"database.png",title:"Databases",children:[{name:"newHibernate",icon:"hibernate.ico",title:"New SQL Table (via Hibernate)"},{name:"existingHibernate",icon:"hibernate.ico",title:"Existing SQL Table (via Hibernate)"},{name:"newSQL",icon:"isomorphic.ico",title:"New SQL Table (Isomorphic RAD)"},{name:"existingSQL",icon:"isomorphic.ico",title:"Existing SQL Table (Isomorphic RAD)"}]},{name:"rss",icon:"rss.jpg",title:"RSS Feed"},{name:"google",icon:"google.ico",title:"Google",children:[{name:"googleMaps",icon:"map.png",title:"Google Maps"},{name:"googleSearch",icon:"search.png",title:"Google Search"},{name:"googleFeed",icon:"rss.jpg",title:"Google Feed"},{name:"googleVisualization",icon:"visualization.png",title:"Google Visualization"},{name:"googleLanguage",icon:"language.png",title:"Google Language"}]},{name:"yahoo",icon:"yahoo.ico",title:"Yahoo",children:[{name:"yahooMaps",icon:"map.png",title:"Yahoo Maps Search"},{name:"yahooWeb",icon:"search.png",title:"Yahoo Web Search"},{name:"yahooImage",icon:"image.png",title:"Yahoo Image Search"},{name:"yahooNews",icon:"news.png",title:"Yahoo News Search"},{name:"yahooVideo",icon:"video.png",title:"Yahoo Video Search"}]},{name:"ebay",icon:"ebay.ico",title:"eBay"},{name:"sforce",icon:"sforce.ico",title:"SalesForce"},{name:"kapow",icon:"kapow.ico",title:"Kapow Robot"},{name:"strikeIron",icon:"strikeiron.ico",title:"StrikeIron Service"},{name:"rest",title:"REST Service",children:[{name:"simpleXML",icon:"xml.gif",title:"XML service or flat file (non-WSDL)"},{name:"json",icon:"json.jpg",title:"JSON service or flat file"}]},{name:"webService",icon:"wsdl.png",title:"WSDL Web Service"},{name:"java",icon:"java.png",title:"Java",children:[{name:"javaBean",icon:"bean.png",title:"Java Bean / EJB / JDO"},{name:"strutsForm",icon:"struts.ico",title:"Struts ActionForm"}]}]}}),selectionChanged:function(){this.creator.nextButton.setDisabled(!this.anySelected())},getValue:function(){var _1=this.getSelectedRecord();if(!_1)return null;return _1.name},clearValues:function(){this.deselectAllRecords()}},isc.TreeGrid);this.dsTypePicker.data.openAll()}
,isc.A.nextPage=function(){var _1=this.dsTypePicker.getValue();if(this.currentPageNum==0){if(_1=="sforce"){var _2=this,_3=isc.WebService.get("urn:partner.soap.sforce.com");_3.ensureLoggedIn(function(){_2.goToPage("SFPickEntityPage")},true);return}else if(_1=="kapow"){var _2=this;if(!this.robotServerPicker)this.robotServerPicker=isc.RobotServerPicker.create({robotServerSelected:function(){_2.goToPage("KapowPickRobotPage")}});this.robotServerPicker.show();return}else if(_1!="webService"){var _4,_5;if(_1.contains("Hibernate")){_5="Each field you enter below corresponds to a database column "+"of the same name.  The table name will be the same as the DataSource ID by default, or you "+"may enter a Table Name below.  Hibernate database settings are in "+"[webroot]/WEB-INF/classes/hibernate.cfg.xml"
_4={dataFormat:"iscServer",serverType:"hibernate"}}else if(_1.contains("SQL")){_5="Each field you enter below corresponds to a database column "+"of the same name.  The table name will be the same as the DataSource ID by default, or you "+"may enter a Table Name below.  By default, the default DataBase shown in the Admin Console "+"will be used, or you may enter \"dbName\" below.";_4={dataFormat:"iscServer",serverType:"sql"}}else if(_1=="simpleXML"){_5="For \"dataURL\", enter a URL which will return XML data.<P>"+"For \"recordXPath\", enter an XPath that will select the XML tags you wish to use as rows. "+"For example, if the tag you want is named \"Person\", a recordXPath of \"//Person\" will "+"work for most simple XML formats.<P>"+"Enter fields named after the subelements and attributes of the tag used for rows.  Click "+"the \"More\" button to see more field properties and documentation, particularly \"valueXPath\"";_4={dataFormat:"xml"}}else if(_1=="json"){_5="For \"dataURL\", enter a URL which will return JSON data.<P>"+"For \"recordXPath\", enter an XPath to an Array of Objects in the JSON data, then enter fields for each property of those Objects which you want to display, and its type.<P>"+"Click the \"More\" button to see more field properties and documentation, particularly \"valueXPath\"";_4={dataFormat:"json"}}else if(_1=="rss"){_5="Enter the URL of the RSS feed as \"dataURL\" below, then add or remove fields.";_4={dataFormat:"xml",recordXPath:"//default:item|//item",fields:[{name:"title",title:"Title"},{name:"link",title:"Story",type:"link"},{name:"description",title:"Description"},{name:"pubDate",title:"Published"}]}}
this.showDSEditor(_4,true,_5);return}}
this.Super("nextPage")}
,isc.A.enterPickOperationPage=function(_1){var _2=this.dsTypePicker.getValue();if(!this.servicePicker)this.setUpPickOperationPage(_1);this.nextButton.setDisabled(this.operationPicker.getSelectedRecord()==null)}
,isc.A.setUpPickOperationPage=function(_1){var _2=this.createAutoChild("pickOperationPage",{visibilityMode:"multiple"},isc.SectionStack);_1.view=_2;this.wsdlURLForm=this.createAutoChild("wsdlURLForm",{numCols:3,colWidths:[100,"*",50],fields:[{name:"url",title:"WSDL URL",width:"*"},{type:"button",title:"Fetch",startRow:false,width:"*",click:function(){this.form.creator.fetchWSDL(this.form.getValue("url"))}}]},isc.DynamicForm);this.servicePicker=this.createAutoChild("servicePicker",{dataSource:"isc_XMethodsServices"},isc.ListGrid);this.servicePicker.fetchData();this.operationPicker=this.createAutoChild("operationPicker",{dataSource:isc.DataSource.create({recordXPath:"default:portType/default:operation",fields:[{name:"name",title:"Name",width:"150"},{name:"documentation",title:"Description"}]})},isc.ListGrid);_2.addSection({title:"Services",autoShow:true,items:[this.wsdlURLForm,this.servicePicker]});_2.addSection({title:"Operations",autoShow:true,items:[this.operationPicker]})}
,isc.A.fetchWSDL=function(_1){this.wsdlURL=_1;if(_1!=null){if(isc.isA.ResultSet(this.operationPicker.data)){this.operationPicker.data.invalidateCache()}
this.operationPicker.fetchData(null,null,{dataURL:_1})}}
,isc.A.enterCallServicePage=function(_1){var _2=this.wsdlURL;isc.xml.loadWSDL(_2,this.getID()+".$46k(service)");if(this.serviceInput!=null)return;var _3=this.createAutoChild("callServicePage",{visibilityMode:"multiple"},isc.SectionStack);_1.view=_3;this.serviceInput=this.createAutoChild("serviceInput",{},isc.DynamicForm);var _4=this.createAutoChild("callServiceButton",{title:"Call Service",click:"this.creator.callService()",resizeable:false},isc.Button);_3.addSection({title:"Service Inputs",autoShow:true,items:[this.serviceInput,_4]});this.requestEditor=this.createAutoChild("requestEditor",{height:250,fields:[{name:"useEditedMessage",title:"Use Edited Message",type:"checkbox",defaultValue:false},{name:"requestBody",showTitle:false,type:"textArea",width:"*",height:"*",colSpan:"*"}]},isc.DynamicForm);_3.addSection({title:"Request Editor",items:[this.requestEditor]});this.serviceOutput=this.createAutoChild("serviceOutput",{showHeader:false,wrapCells:true,fixedRecordHeights:false},isc.DOMGrid);_3.addSection({title:"Service Output",autoShow:true,items:[this.serviceOutput]});this.expressionForm=this.createAutoChild("expressionForm",{numCols:4,colWidths:[120,150,"*",50],items:[{name:"selectBy",title:"Select Records By",width:"*",valueMap:{tagName:"Tag Name",xpath:"XPath Expression"},defaultValue:"xpath"},{name:"expression",showTitle:false,width:"*"},{type:"button",title:"Select",width:"*",startRow:false,click:"form.creator.selectNodes()"}]},isc.DynamicForm);this.selectedNodesView=this.createAutoChild("selectedNodesView",{showHeader:false,showRoot:false,wrapCells:true,fixedRecordHeights:false},isc.DOMGrid);_3.addSection({title:"Select Elements",autoShow:true,items:[this.expressionForm,this.selectedNodesView]})}
,isc.A.$46k=function(_1){this.service=_1;this.serviceInput.setDataSource(this.service.getInputDS(this.operationName))}
,isc.A.callService=function(){if(!this.serviceInput.validate())return;var _1=this.serviceInput.dataSource,_2=this.serviceInput.getValuesAsCriteria(),_3=this.serviceInputs=_1.getServiceInputs({data:_2});if(this.requestEditor){if(this.requestEditor.getValue("useEditedMessage")){var _4=this.requestEditor.getValue("requestBody");_3.requestBody=_4}else{this.requestEditor.setValue("requestBody",_3.requestBody)}}
_3.callback=this.getID()+".serviceOutput.setRootElement(xmlDoc.documentElement)";isc.xml.getXMLResponse(_3)}
,isc.A.selectNodes=function(){var _1=this.expressionForm,_2=this.serviceOutput.rootElement,_3;this.selectBy=_1.getValue("selectBy");if(this.selectBy=="xpath"){this.recordName=null;this.recordXPath=_1.getValue("expression");_3=isc.xml.selectNodes(_2,this.recordXPath)}else{this.recordXPath=null;this.recordName=_1.getValue("expression");var _4=_2.getElementsByTagName(this.recordName);_3=[];for(var i=0;i<_4.length;i++)_3.add(_4[i])}
this.selectedNodesView.setRootElement({childNodes:_3});this.selectedNodes=_3;this.nextButton.enable()}
,isc.A.enterBindingPage=function(_1){var _2=this.selectedNodesView.data,_3=_2.get(0).$9b,_4=_3.getAttribute("xsi:type")||_3.tagName;if(_4.contains(":"))_4=_4.substring(_4.indexOf(":")+1);var _5=this.outputDS=isc.DS.get(_4);this.logWarn("nodeType is: "+_4+", ds is: "+_5);this.boundGrid=this.createAutoChild("boundGrid",{dataSource:_5,data:this.selectedNodes,alternateRecordStyles:true},isc.ListGrid)
_1.view=this.boundGrid}
,isc.A.enterKapowPickRobotPage=function(_1){if(!this.kapowRobotList){this.kapowRobotList=this.createAutoChild("kapowRobotList",{selectionChanged:function(){var _2=this.getSelectedRecord()!=null;this.creator.nextButton.setDisabled(!_2)}},isc.ListGrid);_1.view=this.kapowRobotList}
isc.XJSONDataSource.create({ID:"kapowRobotListDS",callbackParam:"json.callback",dataURL:robotServerURL+"/ISCVBListAllRobots?format=JSON",fields:[{name:"name",title:"Robot"},{name:"type",title:"Type"}],transformResponse:function(_6){var _3=[];for(var i=0;i<_6.data.length;i++){var _5=_6.data[i];if(_5.name.startsWith("ISCVB"))continue;_3.add(_5)}
_6.data=_3;_6.totalRows=_6.data.length;_6.endRow=_6.data.length-1;return _6}});this.kapowRobotList.setDataSource(kapowRobotListDS);this.kapowRobotList.fetchData()}
,isc.A.kapowFinish=function(){var _1=this.kapowRobotList.getSelection();for(var i=0;i<_1.length;i++){var _3=_1[i];isc.XMLTools.loadXML(robotServerURL+"/admin/"+_3.name+".robot",this.getID()+".kapowRobotLoaded(xmlDoc,'"+_3.name+"','"+_3.type+"')")}}
,isc.A.saveDataSource=function(_1){var _2=_1.getClassName();var _3;if(isc.DS.isRegistered(_2)){_3=isc.DS.get(_2)}else{_3=isc.DS.get("DataSource");_1._constructor=_2}
var _4=_3.xmlSerialize(_1);this.logWarn("saving DS with XML: "+_4);isc.DMI.callBuiltin({methodName:"saveSharedXML",arguments:["DS",_1.ID,_4]})}
,isc.A.kapowRobotLoaded=function(_1,_2,_3){this.logInfo("loaded robot: "+_2);var _4=isc.xml.selectNodes(_1,"//property[@name='startModelObjects']/element[@class='kapow.robot.common.domain.Entity']/property");_4=isc.xml.toJS(_4);var _5=[];for(var i=0;i<_4.length;i++){var _7=_4[i];if(!_7.xmlTextContent)continue;_5.add({name:_7.xmlTextContent,type:this.fieldTypeForJavaClass(_7["class"])})}
this.logWarn("Robot: "+_2+" - derived outputFields: "+isc.echoAll(_5));var _8;if(_5.length){_8=isc.DataSource.create({ID:_2+"DS",callbackParam:"json.callback",dataURL:robotServerURL+"/"+_2+"?format=JSON",noAutoFetch:true,fields:_5,dataFormat:"json",dataTransport:"scriptInclude"})}else if(_3=="rss"){var _8=isc.DataSource.create({ID:_2+"DS",dataURL:robotServerURL+"/"+_2,recordXPath:"//default:item",noAutoFetch:true,fields:[{name:"title"},{name:"link",type:"link"},{name:"description"},{name:"created"},{name:"category"},{name:"email"},{name:"name"},{name:"rights"}]})}
if(_8){window.addDataSource(_8);this.saveDataSource(_8)}
var _9=isc.xml.selectNodes(_1,"//property[@name='queryParameters']/element[@class='kapow.robot.common.domain.Entity']/property");_9=isc.xml.toJS(_9);var _10=[];for(var i=0;i<_9.length;i++){var _7=_9[i];if(!_7.xmlTextContent)continue;if(_7.name&&_7.name.startsWith("value"))continue;_10.add({name:_7.xmlTextContent,type:this.fieldTypeForJavaClass(_7["class"])})}
this.logWarn("Robot: "+_2+" - derived inputFields: "+isc.echoAll(_10));if(_10.length){var _11=isc.DataSource.create({ID:_2+"InputDS",type:"generic",fields:_10});window.addDataSource(_11);this.saveDataSource(_11)}
window.wizardWindow.hide();this.resetWizard()}
,isc.A.fieldTypeForJavaClass=function(_1){switch(_1){case"java.lang.Boolean":return"boolean";case"java.util.Date":return"date";case"java.lang.Byte":case"java.lang.Short":case"java.lang.Integer":case"java.lang.Long":case"java.lang.BigInteger":return"integer";case"java.lang.Float":case"java.lang.Double":case"java.lang.BigDecimal":return"float";default:return"text"}}
,isc.A.enterSFPickEntityPage=function(_1){this.sfService=isc.WebService.get("urn:partner.soap.sforce.com");if(!this.sfEntityList){this.sfEntityList=this.createAutoChild("sfEntityList",{fields:[{name:"objectType",title:"Object Type"}],selectionChanged:function(){var _2=this.getSelectedRecord()!=null;this.creator.nextButton.setDisabled(!_2)}},isc.ListGrid);_1.view=this.sfEntityList}
this.sfService.getEntityList({target:this,methodName:"getEntityListReply"})}
,isc.A.getEntityListReply=function(_1){var _2=[];for(var i=0;i<_1.length;i++){_2.add({objectType:_1[i]})}
this.sfEntityList.setData(_2)}
,isc.A.enterSFDonePage=function(_1){var _2=this.sfEntityList.getSelectedRecord().objectType;if(!this.sfGrid){this.sfGrid=this.createAutoChild("sfGrid",{},isc.ListGrid)}
this.sfService.getEntity(_2,{target:this,methodName:"showSFBoundGrid"});_1.view=this.sfGrid}
,isc.A.showSFBoundGrid=function(_1){this.sfGrid.setDataSource(_1);this.sfGrid.fetchData()}
,isc.A.sfFinish=function(){this.showDSEditor(this.sfGrid.dataSource,true,"You can remove fields below to prevent them from being shown, "+"and alter user-visible titles.")}
,isc.A.finish=function(){if(this.getCurrentPage().ID=="SFDonePage")return this.sfFinish();if(this.getCurrentPage().ID=="KapowPickRobotPage")return this.kapowFinish();this.logWarn("passing output DS: "+this.echo(this.outputDS));var _1=this.service.getFetchDS(this.operationName,this.outputDS);_1.recordXPath=this.recordXPath;_1.recordName=this.recordName;_1.fetchSchema.defaultCriteria=isc.addProperties({},this.serviceInput.getValues());this.logWarn("created DataSource with props: "+this.echo(_1));this.showDSEditor(_1)}
,isc.A.showDSEditor=function(_1,_2,_3){window.showDSEditor(_1,_2,_3);window.wizardWindow.hide();this.resetWizard()}
,isc.A.closeClick=function(){this.Super("closeClick",arguments);this.resetWizard()}
,isc.A.resetWizard=function(){if(this.dsTypePicker)this.dsTypePicker.clearValues();if(this.servicePicker&&this.servicePicker.selection)
this.servicePicker.selection.deselectAll();if(this.operationPicker)this.operationPicker.setData([]);if(this.callServicePage){this.serviceInput.clearValues();this.serviceOutput.setData([]);this.expressionForm.clearValues();this.selectedNodesView.setData([])}
this.Super("resetWizard",arguments)}
);isc.B._maxIndex=isc.C+25;isc.defineClass("SchemaViewer","VLayout");isc.A=isc.SchemaViewer;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.getTreeFromService=function(_1){return isc.Tree.create({service:_1,nameProperty:"$46l",titleProperty:"name",loadChildren:function(_8){if(this.isLoaded(_8))return;if(_8==this.root){this.service.operations.setProperty("type","Operation");this.addList(this.service.operations,_8)}else if(_8.inputMessage){this.add(this.getMessageNode(_8,true),_8);this.add(this.getMessageNode(_8,false),_8)}else if(_8.isComplexType){var _2=_8.liveSchema;for(var _3 in _2.getFields()){var _4=_2.getField(_3);if(!_2.fieldIsComplexType(_3)){this.add(isc.addProperties({},_4),_8)}else{var _5=_2.getSchema(_4.type),_6={name:_4.name,type:_4.type,isComplexType:true,liveSchema:_5,minOccurs:_4.minOccurs,maxOccurs:_4.maxOccurs};this.add(_6,_8)}}}
this.setLoadState(_8,isc.Tree.LOADED)},isFolder:function(_8){return(_8==this.root||_8.inputMessage||_8.isComplexType)},getMessageNode:function(_8,_9){var _7=_9?this.service.getRequestMessage(_8):this.service.getResponseMessage(_8);return{name:_7.ID,type:_7.ID,isComplexType:true,liveSchema:_7}}})}
);isc.B._maxIndex=isc.C+1;isc.A=isc.SchemaViewer.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.showTestUI=true;isc.A.operationIcon="[SKINIMG]/SchemaViewer/operation.png";isc.A.complexTypeIcon="[SKINIMG]/SchemaViewer/complexType.gif";isc.A.simpleTypeIcon="[SKINIMG]/SchemaViewer/simpleType.png";isc.B.push(isc.A.setWsdlURL=function(_1){this.wsdlURL=_1;this.urlForm.setValue("url",_1)}
,isc.A.getWsdlURLs=function(){var _1=isc.getKeys(isc.WebService.services),_2=this.wsdlURLs;if(_2==null&&_1.length==0)return;if(_2==null)_2=[];_2.addList(_1);return _2}
,isc.A.initWidget=function(){this.Super("initWidget",arguments);this.createChildren()}
,isc.A.createChildren=function(){var _1=this.getWsdlURLs();this.addAutoChild("urlForm",{numCols:4,colWidths:[100,"*",100,100],itemHoverWidth:300,saveOnEnter:true,saveData:function(){this.creator.fetchSchema()},items:[{name:"url",title:"WSDL",width:"*",defaultValue:this.wsdlURL,editorType:(_1!=null?"ComboBoxItem":"TextItem"),autoComplete:(_1!=null?"smart":null),showAllOptions:true,textMatchStyle:"substring",valueMap:_1},{type:"submit",title:"Show Messages",startRow:false,colSpan:1,endRow:false,width:"*"},{showTitle:false,startRow:false,width:"*",formItemType:"pickTree",shouldSaveValue:false,buttonProperties:{unselectedTitle:"Download",itemSelected:function(_2){this.canvasItem.form.creator.download(_2.name);return false}},valueTree:isc.Tree.create({root:{name:"download",title:"Download",children:[{name:"js",title:"as JS"},{name:"xml",title:"as XML"}]}}),icons:[{src:"[SKIN]/actions/help.png",width:16,height:16,prompt:"You can use the <b>Download</b> feature to download a SmartClient"+" WebService definition for the specified WSDL file in either XML"+" or JS format.  <p>You can achieve the same result by calling"+" <i>XMLTools.loadWSDL()</i> or by using the <code>&lt;isomorphic"+":loadWSDL&gt;</code> JSP tag, however, for non-Java backends or"+" for production use, a .js file should be obtained from this"+" interface and loaded via &lt;SCRIPT SRC=&gt; either individually"+" or combined with other files.  <p>See the reference documentation"+" for details.",click:"isc.say(this.prompt)"}]}]},isc.DynamicForm);this.addMember(isc.VLayout.create({autoDraw:false,members:[isc.HLayout.create({autoDraw:false,members:[this.addAutoChild("treeGrid",{fields:[{treeField:true},{name:"type",title:"Type",width:140},{name:"maxOccurs",width:80}],nodeClick:function(_2,_3,_4){if(this.creator.showTestUI){this.creator.updateInputStack(_3)}},getIcon:function(_2){if(_2.type=="Operation")return this.creator.operationIcon;else if(_2.isComplexType)return this.creator.complexTypeIcon;else return this.creator.simpleTypeIcon}},isc.TreeGrid),isc.VLayout.create({visibility:(this.showTestUI?"inherit":"hidden"),members:[this.addAutoChild("inputStack",{overflow:"auto",visibilityMode:"multiple",autoDraw:false,sections:[{showHeader:true,title:"Input Message (Body)",items:[this.addAutoChild("inputBodyForm",{useFlatFields:true},isc.DynamicForm)]}]},isc.SectionStack),isc.IButton.create({creator:this,autoDraw:false,title:"Invoke",click:function(){this.creator.updateResponseTree()}})]})]}),this.addAutoChild("responseStack",{visibility:(this.showTestUI?"inherit":"hidden"),autoDraw:false,visibilityMode:"multiple",sections:[this.getResponseSectionConfig()]},isc.SectionStack)]}))}
,isc.A.download=function(_1){var _2=this.urlForm.getValue("url");if(!_2){isc.warn("Please type in a WSDL URL");return}
var _3=_2.replace(/(.*\/)?(.*)/,"$2").replace(/(.*?)\?.*/,"$1").replace(/(.*)\..*/,"$1")+"."+_1;isc.DMI.callBuiltin({methodName:"downloadWSDL",arguments:[_2,_1,_3],requestParams:{showPrompt:false,useXmlHttpRequest:false,timeout:0}})}
,isc.A.fetchSchema=function(){var _1=this.urlForm.getValue("url");if(_1==null||_1=="")return;if(isc.WebService.get(_1))return this.fetchSchemaReply(isc.WebService.get(_1));isc.RPCManager.addClassProperties({defaultPrompt:"Loading WSDL Schema",showPrompt:true})
isc.xml.loadWSDL(_1,this.getID()+".fetchSchemaReply(service)")}
,isc.A.fetchSchemaReply=function(_1){isc.RPCManager.addClassProperties({defaultPrompt:"Contacting Server..."});this.service=_1;delete this.operationName;var _2=isc.SchemaViewer.getTreeFromService(_1);this.treeGrid.setData(_2);this.clearInputStack();this.clearResponseTree()}
,isc.A.clearInputStack=function(){var _1=this.inputStack,_2=_1.sections.duplicate(),_3=[];for(var i=0;i<_2.length;i++){if(_2[i].isHeaderSection)_1.removeSection(_2[i])}
this.inputBodyForm.hide();this.inputBodyForm.clearValues()}
,isc.A.updateInputStack=function(_1){this.clearInputStack();var _2=_1;while(_2.type!="Operation"){_2=this.treeGrid.data.getParent(_2)}
if(!_2)return;var _3=_2.name;this.operationName=_3;var _4=this.service.getInputHeaderSchema(_3);if(_4!=null){var _5=0;for(var _6 in _4){var _7=_4[_6],_8;if(isc.isA.DataSource(_7)){_8=isc.DynamicForm.create({useFlatFields:true,dataSource:_7})}else{_8=isc.DynamicForm.create({$46m:true,fields:[_7]})}
this.inputStack.addSection({showHeader:true,isHeaderSection:true,schemaName:_6,title:"Header: "+_6,items:[_8]},_5);_5+=1}}
var _9=this.service.getInputDS(_3);this.inputBodyForm.setDataSource(_9);if(!this.inputBodyForm.isVisible())this.inputBodyForm.show()}
,isc.A.updateResponseTree=function(){if(this.operationName==null)return;var _1=this.inputBodyForm.getValues(),_2,_3=this.service;for(var i=0;i<this.inputStack.sections.length;i++){var _5=this.inputStack.sections[i];if(!_5.isHeaderSection)continue;if(_2==null)_2={};var _6=_5.items[0];if(_6.$46m){_2[_5.schemaName]=_6.getValue(_6.getItem(0))}else{_2[_5.schemaName]=_6.getValues()}}
if(this.logIsDebugEnabled())
this.logDebug("operation:"+this.operationName+", body params:"+this.echoAll(_1)+", headerParams:"+this.echoAll(_2));_3.callOperation(this.operationName,_1,null,this.getID()+".setResponseTreeDoc(xmlDoc, rpcResponse, wsRequest)",{willHandleError:true,headerData:_2,useFlatFields:true,useFlatHeaderFields:true})}
,isc.A.getResponseSectionConfig=function(){return{expanded:true,title:"Service Response",headerControls:[isc.LayoutSpacer.create(),isc.IButton.create({width:200,title:"Generate Sample Response",creator:this,click:function(){if(!this.creator.operationName)return;var _1=this.creator.service.getSampleResponse(this.creator.operationName);_1=isc.XMLTools.parseXML(_1);this.creator.setResponseTreeDoc(_1);this.creator.responseStack.setSectionTitle(0,"Service Response [Generated Sample]");return false},height:16,layoutAlign:"center",extraSpace:4,autoDraw:false}),isc.IButton.create({width:200,title:"Generate Sample Request",creator:this,click:function(){if(!this.creator.operationName)return;var _1=this.creator.service.getSampleRequest(this.creator.operationName);_1=isc.XMLTools.parseXML(_1);this.creator.showSampleRequest(_1);return false},height:16,layoutAlign:"center",extraSpace:4,autoDraw:false})],items:[]}}
,isc.A.setResponseTreeDoc=function(_1,_2,_3){if(_2&&_2.status<0){var _4;if(_2.httpResponseCode==500){_4=_1.selectNodes("//faultstring");if(_4!=null)_4=isc.XML.toJS(_4);if(_4.length==0)_4=null}
if(_4){isc.warn("<b>Server Returned HTTP Code 500 (Internal Error)</b>"+(_4&&_4.length>0?("<br><br>"+_4.join("<br>")):""))}else{isc.RPCManager.handleError(_2,_3)}
return}
this.logInfo("showing a tree response");if(this.logIsDebugEnabled())this.logDebug("response data:"+this.echoAll(_1));this.clearSampleRequest();this.xmlDoc=_1;var _5=isc.DOMTree.create({rootElement:_1.documentElement});if(this.responseTree){this.responseTree.setData(_5)}else{this.addAutoChild("responseTree",{data:_5},isc.DOMGrid)}
if(!this.showingResponseTree){this.responseStack.removeSection(0);this.responseStack.addSection(isc.addProperties(this.getResponseSectionConfig(),{items:[this.responseTree]}),0)}
this.showingResponseTree=true}
,isc.A.clearResponseTree=function(){this.clearSampleRequest();if(!this.showingResponseTree)return;this.responseStack.removeSection(0);this.responseStack.addSection(this.getResponseSectionConfig())
delete this.showingResponseTree}
,isc.A.showSampleRequest=function(_1){this.logInfo("showing a sample request");if(this.logIsDebugEnabled())this.logDebug("sample request data:"+this.echoAll(_1));var _2=isc.DOMTree.create({rootElement:_1.documentElement});if(!this.showingSampleRequest){this.responseStack.addSection({isSampleRequest:true,expanded:true,resizable:true,title:"Generated Sample Service Request",items:[this.addAutoChild("requestTree",{data:_2},isc.DOMGrid)]})}else{this.requestTree.setData(_2)}
this.showingSampleRequest=true}
,isc.A.clearSampleRequest=function(){if(this.showingSampleRequest){for(var i=0;i<this.responseStack.sections.length;i++){if(this.responseStack.sections[i].isSampleRequest){this.responseStack.removeSection(i);break}}}delete this.showingSampleRequest}
);isc.B._maxIndex=isc.C+15;isc.ClassFactory.defineClass("DatabaseBrowser","Layout");isc.A=isc.DatabaseBrowser.getPrototype();isc.A.orientation="horizontal";isc.A.serverType="sql";isc.A.showSchemaTree=true;isc.A.schemaTreeConstructor="TreeGrid";isc.A.schemaTreeDefaults={showConnectors:true,showOpenIcons:false,showDropIcons:false,customIconProperty:"customIcon",fields:[{name:"name",title:"Loading schema, please wait..."}],selectionChanged:function(_1,_2){if(_2&&this.data.getLevel(_1)==1){this.creator.getDataSourceFromTable(_1.name)}},openFolder:function(_1){if(this.data.getLevel(_1)>1){return this.Super("openFolder",arguments)}
this.Super("openFolder",arguments);var _2=this;isc.DMI.call("isc_builtin","com.isomorphic.tools.BuiltinRPC","getFieldsFromTable",_1.name,this.creator.serverType,this.creator.dbName,function(_3){_2.populateFields(_1,_3.data)})},populateFields:function(_1,_2){var _3=isc.clone(_2)
for(var i=0;i<_3.length;i++){datum=_3[i];datum.children=[];for(var _5 in datum){if(_5!="name"&&_5!="children"){datum.children.add({name:_5+"="+datum[_5],customIcon:"[SKIN]file.png"})}}
datum.customIcon="[SKIN]../DatabaseBrowser/column.png"}
this.data.addList(_3,_1)}};isc.A.showDataGrid=true;isc.A.dataGridConstructor="ListGrid";isc.A.dataGridDefaults={};isc.A=isc.DatabaseBrowser.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments);this.addAutoChild("schemaTree",{showResizeBar:this.showDataGrid,title:this.title});var _1=this;var _2=this.includeSubstring;if(_2&&!isc.isAn.Array(_2))_2=[_2];var _3=this.excludeSubstring;if(_3&&!isc.isAn.Array(_3))_3=[_3];isc.DMI.call("isc_builtin","com.isomorphic.tools.BuiltinRPC","getTables",this.serverType,this.dbName,this.catalog,this.schema,_2,_3,function(_4){_1.populateSchemaTree(_4.data);isc.DMI.call("isc_builtin","com.isomorphic.tools.BuiltinRPC","getDatabaseProductNameAndVersion",_1.serverType,_1.dbName,function(_5,_4){_1.databaseNameCallback(_4)})});this.addAutoChild("dataGrid")}
,isc.A.populateSchemaTree=function(_1){for(var i=0;i<_1.length;i++){_1[i].name=_1[i].TABLE_NAME;_1[i].isFolder=true;_1[i].customIcon="[SKIN]../DatabaseBrowser/data.png"}
this.schemaTree.setData(isc.Tree.create({modelType:"children",root:{children:_1}}));if(this.schemaTreeTitle){this.populateSchemaTreeHeader()}
this.tablesRetrieved=true}
,isc.A.databaseNameCallback=function(_1){if(this.title){this.schemaTreeTitle=this.title}else{this.schemaTreeTitle=_1.productName+" "+_1.productVersion}
if(this.tablesRetrieved){this.populateSchemaTreeHeader()}}
,isc.A.populateSchemaTreeHeader=function(){this.schemaTree.setFieldProperties(0,{title:this.schemaTreeTitle})}
,isc.A.getDataSourceFromTable=function(_1){var _2=this;isc.DMI.call("isc_builtin","com.isomorphic.tools.BuiltinRPC","getDataSourceJSONFromTable",_1,this.serverType,this.dbName,function(_4,_5){var _3="$629.generatedDataSourceObject = "+_5;eval(_3);_2.generatedDataSource=isc.DataSource.create(_2.generatedDataSourceObject);if(_2.showDataGrid){_2.dataGrid.setDataSource(_2.generatedDataSource);_2.dataGrid.fetchData()}})}
,isc.A.getGeneratedDataSource=function(){return this.generatedDataSource}
,isc.A.getGeneratedDataSourceObject=function(){return this.generatedDataSourceObject}
);isc.B._maxIndex=isc.C+7;isc._moduleEnd=isc._Tools_end=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc.Log&&isc.Log.logIsInfoEnabled('loadTime'))isc.Log.logInfo('Tools module init time: ' + (isc._moduleEnd-isc._moduleStart) + 'ms','loadTime');}else{if(window.isc && isc.Log && isc.Log.logWarn)isc.Log.logWarn("Duplicate load of module 'Tools'.");}

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

