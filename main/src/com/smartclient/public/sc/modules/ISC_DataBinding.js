/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

if(window.isc&&window.isc.module_Core&&!window.isc.module_DataBinding){isc.module_DataBinding=1;isc._moduleStart=isc._DataBinding_start=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc._moduleEnd&&(!isc.Log||(isc.Log && isc.Log.logIsDebugEnabled('loadTime')))){isc._pTM={ message:'DataBinding load/parse time: ' + (isc._moduleStart-isc._moduleEnd) + 'ms', category:'loadTime'};
if(isc.Log && isc.Log.logDebug)isc.Log.logDebug(isc._pTM.message,'loadTime')
else if(isc._preLog)isc._preLog[isc._preLog.length]=isc._pTM
else isc._preLog=[isc._pTM]}if(!isc.Comm)isc.defineClass("Comm");isc.A=isc.Comm;isc.A.XML_BACKREF_PREFIX="$$BACKREF$$:";isc.A.$36r=/^([_:A-Za-z])([_:.A-Za-z0-9]|-)*$/;isc.A=isc.Comm;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.xmlSerialize=function(_1,_2,_3){return isc.Comm.$ew(_1,_2,_3?"":null)}
,isc.A.$ew=function(_1,_2,_3,_4){var _5=_1!=null;if(!_4||!_4.objRefs){_4=isc.addProperties({},_4);_4.objRefs={obj:[],path:[]};if(!_4.objPath){if(_2&&_2.getID)_4.objPath=_2.getID();else _4.objPath=""}
if(_1==null){if(isc.isA.Class(_2))_1=_2.getClassName();else if(isc.isAn.Array(_2))_1="Array";else if(isc.isA.Object(_2))_1=_2.$schemaId||"Object";else _1="ISC_Auto"}}
if(_2==null)return isc.Comm.$ex(_1,"");if(isc.isA.String(_2)){return isc.Comm.$ex(_1,isc.makeXMLSafe(_2),(isc.Comm.xmlSchemaMode?"string":null))}
if(isc.isA.Function(_2)){if(_2.iscAction)return isc.StringMethod.$41u(_2.iscAction);return null}
if(_2==window){this.logWarn("Serializer encountered the window object at path: "+_4.objPath+" - returning null for this slot.");return null}
if(isc.RPCManager.preserveTypes){if(isc.isA.Number(_2)||isc.isA.SpecialNumber(_2)){if(_2.toString().contains("."))
return isc.Comm.$ex(_1,_2,"double");return isc.Comm.$ex(_1,_2,"long")}
if(isc.isA.Boolean(_2))return isc.Comm.$ex(_1,_2,"boolean")}else{if(isc.isA.Number(_2)||isNaN(_2)){return isc.Comm.$ex(_1,_2)}
if(isc.isA.Boolean(_2))return isc.Comm.$ex(_1,_2)}
var _6=isc.Comm.$zl(_4.objRefs,_2);if(_6!=null&&_4.objPath.contains(_6)){var _7=_4.objPath.substring(_6.length,_6.length+1);if(_7=="."||_7=="["||_7=="]"){if(this.serializeBackrefs){return isc.Comm.$36u(_1)+isc.Comm.XML_BACKREF_PREFIX+_6+isc.Comm.$36v(_1)}
return isc.emptyString}}
isc.Comm.$zm(_4.objRefs,_2,_4.objPath);if(isc.isA.Function(_2.$ew)){return _2.$ew(_1,null,null,_3,_4.objRefs,_4.objPath)}else if(isc.isA.Class(_2)){this.logWarn("Attempt to serialize class of type: "+_2.getClassName()+" at path: "+_4.objPath+" - returning null for this slot.");return null}
var _8=_4.isRoot==false?false:true;if(isc.isAn.Array(_2))
return isc.Comm.$36s(_1,_2,_4.objPath,_4.objRefs,_3,_8);var _9;if(_2.getSerializeableFields){_9=_2.getSerializeableFields([],[])}else{_9=_2}
return isc.Comm.$36t(_1,_9,_4.objPath,_4.objRefs,_3,_8)}
,isc.A.$36s=function(_1,_2,_3,_4,_5,_6){var _7=isc.Comm.$36u(_1,"List",null,null,null,_6);for(var i=0,_9=_2.length;i<_9;i++){var _10=_2[i];var _11={objRefs:_4,objPath:isc.Comm.$zp(_3,i),isRoot:false};_7=isc.StringBuffer.concat(_7,(_5!=null?isc.StringBuffer.concat("\r",_5,"\t"):""),isc.Comm.$ew((_10!=null?_10.$schemaId:null)||"elem",_10,(_5!=null?isc.StringBuffer.concat(_5,"\t"):null),_11))}
_7=isc.StringBuffer.concat(_7,(_5!=null?isc.StringBuffer.concat("\r",_5):""),isc.Comm.$36v(_1));return _7}
,isc.A.$36w=function(_1){return isc.Comm.xmlSchemaMode||_1.match(this.$36r)}
,isc.A.$36t=function(_1,_2,_3,_4,_5,_6){if(isc.isAn.Instance(_2))_1=_2.getClassName();else if(_2._constructor&&_2._constructor!="AdvancedCriteria")_1=_2._constructor;var _7=isc.Comm.$36u(_1,"Object",null,null,null,_6);var _8;_2=this.$42b(_2);for(var _9 in _2){if(_9==null)continue;if(_9.startsWith('$'))continue;var _10=_2[_9];if(_10===_8)continue;if(isc.isA.Function(_10)&&!_10.iscAction)continue;var _11=_9.toString();var _12={objRefs:_4,objPath:isc.Comm.$zp(_3,_9),isRoot:false};_7=isc.StringBuffer.concat(_7,(_5!=null?isc.StringBuffer.concat("\r",_5,"\t"):""),isc.Comm.$ew(_11,_10,(_5!=null?isc.StringBuffer.concat(_5,"\t"):null),_12))}
_7=isc.StringBuffer.concat(_7,(_5!=null?isc.StringBuffer.concat("\r",_5):""),isc.Comm.$36v(_1));return _7}
,isc.A.$36x=function(_1,_2){if(_1[_2]!=null){return _1[_2]}else{if(_1.$36y==null)_1.$36y=0;return(_1[_2]="ns"+_1.$36y++)}}
,isc.A.$36u=function(_1,_2,_3,_4,_5,_6){var _7=isc.SB.create();var _8=_3!=null;if(_3!=null&&isc.isAn.Object(_4)){_8=false;_4=this.$36x(_4,_3)}
var _9='';if(!this.$36w(_1)){_9=' _isc_name="'+_1+'"';_1="Object"}
if(_3){_4=_4||"schNS";_7.append("<",_4,":",_1);if(_8)_7.append(" xmlns:",_4,"=\"",_3,"\"")}else{_7.append("<",_1)}
if(_9)_7.append(_9);if(_6&&!this.omitXSI){_7.append(" xmlns:xsi=\"http://www.w3.org/2000/10/XMLSchema-instance\"")}
if(_2&&!this.omitXSI){_7.append(" xsi:type=\"xsd:",isc.makeXMLSafe(_2),"\"")}
if(!_5)_7.append(">");return _7.toString()}
,isc.A.$36v=function(_1,_2,_3){if(_2!=null&&isc.isAn.Object(_3)){_3=this.$36x(_3,_2)}
if(!this.$36w(_1))_1="Object";if(_2){_3=_3||"schNS";return isc.SB.concat("</",_3,":",_1,">")}else{return isc.SB.concat("</",_1,">")}}
,isc.A.$ex=function(_1,_2,_3,_4,_5){if(_3=="base64Binary"){_2="<xop:Include xmlns:xop=\"http://www.w3.org/2004/08/xop/include\" href=\""+_2+"\"/>"}
return isc.StringBuffer.concat(isc.Comm.$36u(_1,_3,_4,_5),_2,isc.Comm.$36v(_1,_4,_5))}
);isc.B._maxIndex=isc.C+9;isc.addGlobal("clone",function(_1,_2){return isc.Comm.$360(_1)});isc.A=isc.Comm;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.clone=isc.clone;isc.B.push(isc.A.$360=function(_1){var _2;if(_1===_2)return _2;if(_1==null)return null;if(isc.isA.String(_1)||isc.isA.Boolean(_1)||isc.isA.Number(_1)||isc.isA.Function(_1))return _1;if(isc.isA.Date(_1)){var _3=new Date(_1.getTime());_3.logicalDate=_1.logicalDate;return _3}
if(isc.isAn.Array(_1))return isc.Comm.$361(_1);if(isc.isA.Function(_1.clone))return _1.clone();return isc.Comm.$362(_1)}
,isc.A.$361=function(_1){var _2=[];for(var i=0,_4=_1.length;i<_4;i++){_2[i]=isc.Comm.$360(_1[i])}
return _2}
,isc.A.$362=function(_1){var _2={};for(var _3 in _1){var _4=_1[_3];_2[_3]=isc.Comm.$360(_4)}
return _2}
);isc.B._maxIndex=isc.C+3;isc.defineClass("XMLDoc").addMethods({addPropertiesOnCreate:false,init:function(_1,_2){this.nativeDoc=_1;this.namespaces=_2;this.documentElement=this.nativeDoc.documentElement},hasParseError:function(){if(isc.Browser.isIE)return this.nativeDoc.parseError!=null;return this.nativeDoc.documentElement&&this.nativeDoc.documentElement.tagName=="parsererror"},addNamespaces:function(_1){this.namespaces=this.$363(_1);if(this.$364){var _2=isc.xml.xmlResponses.find("ID",this.$364);if(_2)_2.xmlNamespaces=this.namespaces}},$363:function(_1){if(_1==null)return this.namespaces;if(this.namespaces==null)return _1;return isc.addProperties({},this.namespaces,_1)},selectNodes:function(_1,_2,_3){return isc.xml.selectNodes(this.nativeDoc,_1,this.$363(_2),_3)},selectString:function(_1,_2){return isc.xml.selectString(this.nativeDoc,_1,this.$363(_2))},selectNumber:function(_1,_2){return isc.xml.selectNumber(this.nativeDoc,_1,this.$363(_2))},selectScalar:function(_1,_2,_3){return isc.xml.selectScalar(this.nativeDoc,_1,this.$363(_2),_3)},selectScalarList:function(_1,_2){return isc.xml.selectScalarList(this.nativeDoc,_1,this.$363(_2))},getElementById:function(_1){return this.nativeDoc.getElementById(_1)},getElementsByTagName:function(_1){return this.nativeDoc.getElementsByTagName(_1)}});isc.XMLDoc.getPrototype().toString=function(){return"[XMLDoc <"+this.documentElement.tagName+">]"};isc.defineClass("XMLTools").addClassProperties({httpProxyURL:"[ISOMORPHIC]/HttpProxy"});isc.A=isc.XMLTools;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.xmlResponses=[];isc.A.$365=0;isc.A.xmlDOMConstructors=["MSXML2.DOMDocument","MSXML.DOMDocument","Microsoft.XMLDOM"];isc.A.mozAnchorBug=isc.Browser.isMoz&&(isc.Browser.geckoVersion<20080205)&&window.location.href.indexOf("#")!=-1;isc.A.$pa="*";isc.A.$366=":";isc.A.$27c="List";isc.A.$45s="xmlToJS";isc.A.$45t="type";isc.A.$367="xsi:type";isc.A.$gy="number";isc.A.$45u={nil:"xsi:nil","null":"xsi:null",type:"xsi:type"};isc.A.xsiNamespaces=["http://www.w3.org/2001/XMLSchema-instance","http://www.w3.org/1999/XMLSchema-instance"];isc.A.$45v="nil";isc.A.$45w="null";isc.A.$18r="false";isc.A.$w0="0";isc.A.$ho="[";isc.A.useClientXML=true;isc.B.push(isc.A.loadXML=function(_1,_2,_3){this.getXMLResponse(isc.addProperties({actionURL:_1,httpMethod:"GET",callback:_2},_3))}
,isc.A.getXMLResponse=function(_1){_1.$37b=_1.callback;_1.callback={target:this,methodName:"$37c"};_1.httpMethod=_1.httpMethod||"POST";this.logInfo("loading XML from: "+_1.actionURL,"xmlComm");isc.rpc.sendProxied(_1)}
,isc.A.$37c=function(_1,_2,_3){var _4=_1.httpResponseText,_5=this.parseXML(_4);if(this.logIsInfoEnabled("xmlComm")){this.logInfo("XML reply with text: "+(this.logIsDebugEnabled("xmlComm")?_4:this.echoLeaf(_4)),"xmlComm")}
var _6=this.xmlResponses;var _7=isc.Log.logViewer;if(this.logIsDebugEnabled("xmlComm")||(isc.Page.isLoaded()&&_7&&_7.logWindowLoaded()))
{var _8=this.$365++;_6.add({ID:_8,text:_4});_5.$364=_8;if(_6.length>10)_6.shift();if(_7&&_7.logWindowLoaded()&&_7._logWindow!=null){_7._logWindow.updateCommWatcher()}}else{_6.length=0}
this.fireCallback(_3.$37b,"xmlDoc,xmlText,rpcResponse,rpcRequest",[_5,_4,_1,_3])}
,isc.A.parseXML=function(_1,_2){if(_1==null)return;_1=this.trimXMLStart(_1);var _3;if(!isc.Browser.isIE){try{if((this.mozAnchorBug||this.useAnchorWorkaround)&&this.useAnchorWorkaround!==false)
{var _4="<IFRAME STYLE='position:absolute;visibility:hidden;top:-1000px'"+" ID='isc_parseXMLFrame'></IFRAME>";if(!isc.Page.isLoaded()){document.write(_4)}else{isc.Element.insertAdjacentHTML(document.getElementsByTagName("body")[0],"beforeEnd",_4)}
var _5=document.getElementById("isc_parseXMLFrame");var _6=_5.contentWindow;window.isc.xmlSource=_1;_6.location.href="javascript:top.isc.parsedXML="+"new top.isc.XMLTools.getXMLParser().parseFromString(top.isc.xmlSource, 'text/xml')";_3=window.isc.parsedXML;isc.xmlSource=isc.parsedXML=null;_5.parentNode.removeChild(_5)}else{_3=this.getXMLParser().parseFromString(_1,"text/xml")}}catch(e){if(!_2)this.$37d(this.echo(e));return null}
if(!_2&&_3.documentElement&&_3.documentElement.tagName=="parsererror")
{this.$37d(_3.documentElement.textContent);return null}
return isc.XMLDoc.create(_3)}
_3=this.getXMLParser();if(!_3){this.$37a("XMLTools.parseXML()");return}
_3.loadXML(_1);if(_3.parseError!=0){var _7=_3.parseError;if(!_2){this.$37d("\rReason: "+_7.reason+"Line number: "+_7.line+", character: "+_7.linepos+"\rLine contents: "+_7.srcText+(!isc.isA.emptyString(_7.url)?"\rSource URL: "+_7.url:""))}
return null}
return isc.XMLDoc.create(_3)}
,isc.A.trimXMLStart=function(_1){if(_1.indexOf("<?xml")!=-1)
{var _2=_1.match(new RegExp("^\\s*<\\?.*\\?>"));if(_2){_1=_1.substring(_2[0].length)}}
if(isc.Browser.isIE&&_1.indexOf("<!DOCTYPE")!=-1){var _2=_1.match(new RegExp("^\\s*<!DOCTYPE .*>"));if(_2){_1=_1.substring(_2[0].length)}}
return _1}
,isc.A.$37d=function(_1,_2){this.logWarn("Error parsing XML: "+_1+(this.logIsDebugEnabled("parseXML")?"\rXML was:\r"+_2+"\rTrace:"+this.getStackTrace():""),"parseXML")}
,isc.A.getXMLParser=function(){if(!isc.Browser.isIE){if(!this.$37e)this.$37e=new DOMParser();return this.$37e}
var _1;if(this.$37f){_1=new ActiveXObject(this.$37f)}else{for(var i=0;i<this.xmlDOMConstructors.length;i++){try{var _3=this.xmlDOMConstructors[i];_1=new ActiveXObject(_3);if(_1){this.logInfo("Using XML DOM constructor: "+_3);this.$37f=_3;break}}catch(e){}}
if(!_1){this.logWarn("Couldn't create XML DOM parser - tried the following"+" constructors: "+this.echoAll(this.xmlDOMConstructors))}}
return _1}
,isc.A.nativeXMLAvailable=function(){if(isc.Browser.isSafari&&!isc.Browser.isApollo&&(isc.Browser.safariVersion<522))
return false;return this.$37e!=null||this.getXMLParser()!=null}
,isc.A.$37a=function(_1){if(this.nativeXMLAvailable()||!this.logIsWarnEnabled())return false;var _2="Feature "+_1+" requires a native XML parser which is "+"not available ";if(isc.Browser.isSafari){_2+="because this version of Safari does not support native XML processing."}else{_2+="because ActiveX is currently disabled."}
_2+=" Please see the 'Features requiring ActiveX or Native support'"+" topic in the client-side reference under Client Reference/System"+" for more information";this.logWarn(_2);return true}
,isc.A.serverToJS=function(_1,_2,_3){isc.DMI.callBuiltin({methodName:"xmlToJS",callback:_2,arguments:_1,requestParams:{evalVars:_3,evalResult:true}})}
,isc.A.toJSCode=function(_1,_2){isc.DMI.callBuiltin("xmlToJS",_1,_2)}
,isc.A.elementToObject=function(_1){if(_1==null)return null;var _2=this.getAttributes(_1);var _3=_1.getElementsByTagName(this.$pa);for(var i=0;i<_3.length;i++){var _5=_3[i];_2[_5.tagName]=this.getElementText(_5)}
return _2}
,isc.A.getLocalName=function(_1){if(!isc.Browser.isIE){var _2=_1.localName;if(_2==null)return _1.nodeName;return _2}
var _3=_1.nodeName,_4=_3.indexOf(this.$366);if(_4!=-1)return _3.substring(_4+1);return _3}
,isc.A.toJS=function(_1,_2,_3,_4,_5){if(_1==null)return null;if(isc.isAn.XMLDoc(_1))_1=_1.nativeDoc;if(_1.documentElement)_1=_1.documentElement;_5=_5||isc.emptyObject;if(isc.isAn.Array(_1)){var _6=[];for(var i=0;i<_1.length;i++){_6[i]=this.toJS(_1[i],_2,_3,_4,_5)}
return _6}
var _8,_9;var _10=this.getExplicitType(_1);if(_4||!_3||(_3&&isc.DS.get(_10)==null)){if(!_10&&_4){var _11=_1.tagName;if(_11==this.$27c||isc.DS.get(_11))_10=_1.tagName}
if(_10!=null&&_10==this.$27c){var _12=this.getElementChildren(_1);return this.toJS(_12,_2,_3,_4,_5)}
if(_10){if(isc.DS.get(_10)!=null){_3=isc.DS.get(_10)}else{return isc.SimpleType.validateValue(_10,this.getElementText(_1))}}}
if(_3&&_3.xmlToJS)return _3.xmlToJS(_1,_5);if(this.elementIsNil(_1))return null;if(_3){_9=_2||_3.getFieldNames();_8={};for(var i=0;i<_9.length;i++){var _13=_9[i],_14=_3.getField(_13);if(_14==null||(_14.valueXPath==null&&_14.getFieldValue==null))continue;var _15=_3.getFieldValue(_1,_13,_14);if(_15!=null){if(this.logIsDebugEnabled(this.$45s)){this.logDebug("valueXPath / getFieldValue() field: "+_3.ID+"."+_13+" on element: "+this.echoLeaf(_1)+" got value: "+_15,"xmlToJS")}
_8[_13]=_15}}}
_8=this.getAttributes(_1,_2,_8,_3!=null,_3);if(!this.$37g(_8)&&!this.hasElementChildren(_1))
{return this.getElementText(_1)}
if(_8[this.$367]&&_8[this.$367]=="xsd:Object"){delete _8[this.$367]}
var _12=_1.childNodes;var _16=false;for(var i=0;i<_12.length;i++){var _17=_12[i];var _18=this.getLocalName(_17);if(this.isTextNode(_17))continue;_16=true;if(_2&&!_2.contains(_18))continue;var _14=_3?_3.getField(_18):null;if(_14&&(_14.valueXPath||_14.getFieldValue))continue;var _19;if(this.logIsInfoEnabled(this.$45s)){this.logInfo("dataSource: "+_3+", field: "+this.echoLeaf(_14)+(_14!=null?" type: "+_14.type:"")+", XML element: "+this.echoLeaf(_17),"xmlToJS")}
var _20=_17;if(_14&&_14.multiple){var _21=this.getElementChildren(_17);if(_21.length>0)_20=_21}
if(!_3||_14==null||_14.type==null){if(this.logIsDebugEnabled(this.$45s)){this.logDebug("applying schemaless transform at: "+(_3?_3.ID:"[schemaless]")+"."+_18,"xmlToJS")}
_19=this.toJS(_20,null,null,_4,_5)}else{var _22=_3.getSchema(_14.type);if(_22!=null){var _23=_14.propertiesOnly?{propertiesOnly:true}:_5;_19=this.toJS(_20,null,_22,_4,_23);if(this.logIsDebugEnabled(this.$45s)){this.logDebug("complexType field: "+this.echoLeaf(_14)+" got value: "+this.echoLeaf(_19),"xmlToJS")}}else{if(isc.isAn.Array(_20)){_19=[];for(var j=0;j<_20.length;j++){_19.add(_3.validateFieldValue(_14,this.getElementText(_20[j])))}}else{_19=_3.validateFieldValue(_14,this.getElementText(_20))}
if(this.logIsDebugEnabled(this.$45s)){this.logDebug("simpleType field: "+this.echoLeaf(_14)+" got value: "+this.echoLeaf(_19),"xmlToJS")}}}
if(_14&&_14.multiple){if(_19==null||isc.isA.emptyString(_19))_19=[];else if(!isc.isAn.Array(_19))_19=[_19]}
if(_8[_18]){if(!isc.isAn.Array(_8[_18]))_8[_18]=[_8[_18]];if(_14&&_14.multiple&&isc.isAn.Array(_19)){_8[_18].addList(_19)}else{_8[_18].add(_19)}}else{_8[_18]=_19}}
if(!_16){var _25=this.getElementText(_1),_26=_5.textContentProperty||(_3?_3.textContentProperty:"xmlTextContent");if(_3){_14=_3.getTextContentField();if(_14)_25=_3.validateFieldValue(_14,_25)}
if(_25!=null&&!isc.isAn.emptyString(_25)){_8[_26]=_25}}
if(_3&&(_3.instanceConstructor||_3.Constructor)){var _27=_3.instanceConstructor||_3.Constructor;if(_5!=null&&_5.propertiesOnly){_8._constructor=_27}else if(isc.ClassFactory.getClass(_27)!=null){return isc.ClassFactory.newInstance(_27,_8)}}
return _8}
,isc.A.getExplicitType=function(_1){if(_1==null||this.isTextNode(_1))return;var _2=this.getXSIAttribute(_1,this.$45t);if(_2){if(_2.contains(isc.colon))_2=_2.substring(_2.indexOf(isc.colon)+1);return _2}
_2=_1.getAttribute("constructor");return _2}
,isc.A.toComponents=function(_1,_2){if(isc.DS.get("Canvas")==null){this.logWarn("Can't find schema for Canvas - make sure you've loaded"+" component schema via <isomorphic:loadSystemSchema/> jsp tag"+" or by some other mechanism")}
if(isc.isA.String(_1)){var _3=this.parseXML(_1,true);if(_3.hasParseError()){this.logWarn("xml failed to parse xmlDoc, wrapping in root node.");_3=this.parseXML("<isomorphicXML>"+_1+"</isomorphicXML>")}
_1=_3}
return this.toJS(_1,null,null,true,_2)}
,isc.A.getFieldValue=function(_1,_2,_3,_4,_5){if(_1.ownerDocument==null)return _1[_2];_3=_3||(_4?_4.getField(_2):isc.emptyObject);try{var _6;if(_3.valueXPath){var _7=(_4?_4.getSchema(_3.type):isc.DS.get(_3.type));if(_7){var _8=isc.xml.selectNodes(_1,_3.valueXPath,_5),_9=isc.xml.toJS(_8,null,_7);if(!_3.multiple&&_9.length==1)_9=_9[0];return _9}else{_6=isc.xml.selectScalar(_1,_3.valueXPath,_5)}}else{_6=isc.xml.getXMLFieldValue(_1,_2)}
_4=_4||isc.DS.get("Object");_6=_4.validateFieldValue(_3,_6);return _6}catch(e){this.logWarn("error getting value for field: '"+_2+(_3.valueXPath?"', valueXPath: '"+_3.valueXPath:"")+"' in record: "+this.echo(_1)+"\r: "+this.echo(e)+this.getStackTrace());return null}}
,isc.A.getXMLFieldValue=function(_1,_2){var _3=_1.getAttribute(_2);if(_3!=null)return _3;var _4=_1.getElementsByTagName(_2)[0];if(_4==null)return null;return(isc.Browser.isIE?_4.text:_4.textContent)}
,isc.A.$37g=function(_1){for(var _2 in _1){if(_2==this.$367)continue;return true}
return false}
,isc.A.getAttributes=function(_1,_2,_3,_4,_5){_3=_3||{};var _6;if(_2){if(!isc.isAn.Array(_2))_2=[_2];for(var i=0;i<_2.length;i++){var _8=_2[i];if(_4&&_3[_8]!==_6)continue;var _9=_1.getAttribute(_8);if(_9==null||isc.isAn.emptyString(_9))continue;if(_5&&_5.getField(_8)){_9=_5.validateFieldValue(_5.getField(_8),_9)}
_3[_8]=_9}
return _3}
var _10=_1.attributes;if(_10!=null){for(var i=0;i<_10.length;i++){var _11=_10[i],_8=_11.name;if(_4&&_3[_8]!==_6)continue;var _9=_11.value;if(_9==null||isc.isAn.emptyString(_9))continue;if(_5&&_5.getField(_8)){_9=_5.validateFieldValue(_5.getField(_8),_9)}
_3[_8]=_9}}
return _3}
,isc.A.getXSIAttribute=function(_1,_2){var _3;if(isc.Browser.isOpera){for(var i=0;i<this.xsiNamespaces.length;i++){_3=_1.getAttributeNS(this.xsiNamespaces[i],_2);if(_3!=null)return _3}
return _3}
return _1.getAttribute(this.$45u[_2])}
,isc.A.elementIsNil=function(_1){if(_1==null||!isc.isA.XMLNode(_1)||_1.nodeType!=1)return false;var _2=this.getXSIAttribute(_1,this.$45v);if(_2&&_2!=this.$18r&&_2!=this.$w0)return true;var _2=this.getXSIAttribute(_1,this.$45w);if(_2&&_2!=this.$18r&&_2!=this.$w0)return true;return false}
,isc.A.getElementText=function(_1){if(this.elementIsNil(_1))return null;if(!_1)return null;var _2=_1.firstChild;if(!_2)return isc.emptyString;var _3=_2.data;if(isc.Browser.isMoz&&_3.length>4000)return _1.textContent;return _3}
,isc.A.isTextNode=function(_1){if(_1==null)return false;var _2=_1.nodeType;return(_2==3||_2==4||_2==8)}
,isc.A.hasElementChildren=function(_1){if(_1==null||(_1.hasChildNodes!=null&&_1.hasChildNodes()==false))return false;var _2=_1.childNodes;if(!_2)return false;var _3=_2.length;for(var i=0;i<_3;i++){var _5=_2[i];if(!this.isTextNode(_5))return true}
return false}
,isc.A.setAttributes=function(_1,_2){var _3;for(var _4 in _2){var _5=_2[_4];if(_5==null){_1.removeAttribute(_4);continue}
if(isc.Browser.isIE&&(_5===true||_5===false)){_5=isc.emptyString+_5}
_1.setAttribute(_4,_2[_4])}}
,isc.A.$37h=function(_1,_2){var _3=isc.SB.create(),_4=_1.documentElement,_2=_2||isc.emptyObject,_5;if(!_2["default"]){_5=this.$45x(_4);if(_5)_3.append('xmlns:default="',_5,'" ')}
var _6=_1.documentElement.attributes;for(var i=0;i<_6.length;i++){var _8=_6[i],_9=_8.prefix;if(_9=="xmlns"&&_9!=_8.name){if(_2[_8.baseName]!=null)continue;_3.append(_8.name,'="',_8.value,'" ')}}
return _3.toString()}
,isc.A.$45x=function(_1){var _2=this.logIsDebugEnabled("xmlSelect");if((_1.prefix==null||isc.isAn.emptyString(_1.prefix))&&_1.namespaceURI)
{if(_2){this.logWarn("using docElement ns, prefix: "+_1.prefix,"xmlSelect")}
return _1.namespaceURI}else if(_1.firstChild){var _3
for(var i=0;i<_1.childNodes.length;i++){var _5=_1.childNodes[i];if(_5.nodeType==3)continue;var _6=_5.namespaceURI;if(!_6)break;if(_5.prefix==null||isc.isAn.emptyString(_5.prefix)){_3=_5.namespaceURI;break}}
if(_3!=null){if(_2){this.logDebug("using default namespace detected on child: "+_3,"xmlSelect")}}
if(_3==null&&_1.namespaceURI){_3=_1.namespaceURI;if(_2){this.logDebug("using document element's namespace as default namespace: "+_3,"xmlSelect")}}
if(!_3)_3="http://openuri.org/defaultNamespace";return _3}}
,isc.A.selectObjects=function(_1,_2,_3){if(isc.contains("|")){var _4=_2.split(/|/),_5=[];for(var i=0;i<_4.length;i++){_5.addList(this.selectObjects(_4[i],_1))}
return _5}
var _7=isc.isAn.Array(_1)?_1:[_1];if(_2!=isc.slash){if(isc.startsWith(_2,isc.slash))_2=_2.substring(1);var _8=_2.split(/[\/@]/);_7=this.$37i(_8,_7,isc.slash)}
if(_3&&_7.length<=1)return _7[0];return _7}
,isc.A.$37i=function(_1,_2,_3){var _4=_1[0];_1=_1.length>1?_1.slice(1):null;if(_2==null)return null;var _5,_6=_4,_7=_4.indexOf(this.$ho);if(_7!=-1){_6=_4.substring(0,_7);_5=_4.substring(_7+1,_4.length-1)}
var _8=[];for(var i=0;i<_2.length;i++){var _10=_2[i];if(_6!=isc.star){_10=_10[_6]}else{var _11=isc.getValues(_10);_10=[];for(var i=0;i<_11.length;i++){if(!isc.isAn.Array(_11[i]))_10.add(_11[i]);else _10.addList(_11[i])}}
if(_10==null)continue;if(!isc.isAn.Array(_10)){_8.add(_10)}else{_8.addList(_10)}}
if(_5){var _12=this.$37j(_8,_5);_8=_12}
if(_1==null||_1.length==0)return _8;_3+=_4+isc.slash;return this.$37i(_1,_8,_3)}
,isc.A.$37j=function(_1,_2){var _3=parseInt(_2);if(!isNaN(_3)){return[_1[_3-1]]}
if(_2=="last()")return[_1.last()];var _4=_2.match(/^([a-zA-Z_0-9:\-\.\(\)]*)\s*(<|>|!=|=|<=|>=|)\s*(.*)$/),_5,_6,_7;if(_4==null){if(!_2.match(/^[a-zA-Z_0-9:\-\.]*$/)){this.logWarn("couldn't parse predicate expression: "+_2);return null}
_5=_2}else{_5=_4[1],_6=_4[2],_7=_4[3]}
if(_6=="=")_6="==";if(_7=="true()")_7=true;else if(_7=="false()")_7=false;if(_5=="position()")_5="position";var _8=new Function("item,position","return "+(_5!="position"?"item.":"")+_5+(_6?_6+_7:""));var _9=[];for(var i=0;i<_1.length;i++){if(_8(_1[i],i+1))_9.add(_1[i])}
return _9}
,isc.A.selectNodes=function(_1,_2,_3,_4){if(isc.isA.String(_1)){_1=this.parseXML(_1)}
if(isc.Browser.isSafari&&(isc.Browser.isApollo||(isc.Browser.safariVersion<522)))
{this.$37a("XPath");return this.safariSelectNodes(_1,_2,_3,_4)}
if(isc.isAn.XMLDoc(_1)){return _1.selectNodes(_2,_3,_4)}
var _5=isc.timestamp();var _6=this.$37k(_1,_2,_3,_4);var _7=isc.timestamp();if(this.logIsInfoEnabled("xmlSelect")){this.logInfo("selectNodes: expression: "+_2+" returned "+this.echoLeaf(_6)+": "+(_7-_5)+"ms","xmlSelect")}
return _6}
,isc.A.safariSelectNodes=function(_1,_2,_3,_4){var _5=[];if(!_2){return null}
var _6=_2.substring(_2.indexOf(":")+1);var _7;if(_6.endsWith("/*")){_7=true;_6=_6.substring(0,_6.indexOf("/*"))}
var _8=_1.getElementsByTagName(_6);if(_7&&_8.length>0){var _9=_8[0];_8=_9.childNodes}
for(var i=0;i<_8.length;i++){if(_8[i].nodeType==3)continue;_5.add(_8[i])}
if(_7&&_5.length==1)_5=_5[0];return _5}
,isc.A.$37l=function(_1,_2,_3){if(_1==null)return isc.emptyString;if(_2==null)_2=isc.getKeys(_1);var _4=isc.SB.create(),_3=(_3!=null?"\n"+_3:"");for(var i=0;i<_2.length;i++){var _6=_2[i];_4.append(_3," xmlns:",_6,'="',_1[_6],'"')}
return _4.toString()}
,isc.A.$53z=function(_1){var _2=_1.lookupNamespaceURI("");if(isc.Browser.isSafari&&(_2==null||_2=="")){_2=_1.getAttribute("xmlns")}
if(_2==null)_2=_1.namespaceURI;if(_2==null)_2="";return _2}
,isc.A.$37k=function(_1,_2,_3,_4){var _5=_1.ownerDocument;if(_5==null&&_1.documentElement){_5=_1;_1=_5.documentElement}
if(isc.Browser.isIE){if(isc.Browser.version>5.5){_5.setProperty("SelectionLanguage","XPath");var _6=this.$37h(_5,_3);if(_3)_6+=this.$37l(_3);if(this.logIsDebugEnabled("xmlSelect")){this.logDebug("selectNodes: expression: "+_2+", using namespaces: "+_6,"xmlSelect")}
_5.setProperty("SelectionNamespaces",_6)}
if(_4)return _1.selectSingleNode(_2);var _7=_1.selectNodes(_2);return this.$37m(_7)}
var _8=_5.createNSResolver(_5.documentElement),_9=this.$53z(_5.documentElement);if(this.logIsDebugEnabled("xmlSelect")){this.logDebug("Using namespaces: "+isc.echo(_3)+", defaultNamespace: '"+_9+"'","xmlSelect")}
var _10=function(_12){if(_3&&_3[_12])return _3[_12];if(_12=="default")return _9;return _8.lookupNamespaceURI(_12)};var _11=_5.evaluate(_2,_1,_10,0,null);if(_4)return _11.iterateNext();return this.$37m(_11)}
,isc.A.$37m=function(_1){var _2=[];if(isc.Browser.isIE||_1.iterateNext==null){for(var i=0;i<_1.length;i++){_2.add(_1.item(i))}}else{var _4;while(_4=_1.iterateNext()){_2.add(_4)}}
return _2}
,isc.A.getElementChildren=function(_1){var _2=[],_3=_1.childNodes;for(var i=0;i<_3.length;i++){var _5=_3[i];if(this.isTextNode(_5))continue;_2.add(_5)}
return _2}
,isc.A.selectString=function(_1,_2,_3){return this.selectScalar(_1,_2,_3)}
,isc.A.selectNumber=function(_1,_2,_3){return this.selectScalar(_1,_2,_3,true)}
,isc.A.selectScalar=function(_1,_2,_3,_4){if(isc.isA.String(_1))_1=this.parseXML(_1);if(isc.isAn.XMLDoc(_1))return _1.selectScalar(_2,_3,_4);var _5;if(isc.Browser.isSafari&&isc.Browser.isApollo||(isc.Browser.safariVersion<522)){var _6=_2.substring(_2.indexOf(":")+1);_5=_1.getElementsByTagName(_6)[0]}else{_5=this.selectNodes(_1,_2,_3,true)}
if(_5==null)return null;var _7=this.getElementText(_5);return _4?parseInt(_7):_7}
,isc.A.selectScalarList=function(_1,_2,_3){if(isc.isA.String(_1))_1=this.parseXML(_1);if(isc.isAn.XMLDoc(_1))return _1.selectScalarList(_2,_3);var _4=this.selectNodes(_1,_2,_3);for(var i=0;i<_4.length;i++){_4[i]=_4[i].nodeValue}
return _4}
,isc.A.transformNodes=function(_1,_2){if(isc.isAn.XMLDoc(_1))_1=_1.nativeDoc;if(isc.isAn.XMLDoc(_2))_2=_2.nativeDoc;if(isc.Browser.isIE){return _1.transformNode(_2)}
var _3=new XSLTProcessor();_3.importStylesheet(_2);if(isc.Browser.isMoz&&this.mozAnchorBug&&isc.Browser.geckoVersion<20051107){var _4=document.implementation.createDocument("","test",null);var _5=_3.transformToFragment(_1,_4);return new XMLSerializer().serializeToString(_5)}
var _6=_3.transformToDocument(_1);return new XMLSerializer().serializeToString(_6)}
,isc.A.serializeToString=function(_1){this.$37n=this.$37n||isc.xml.parseXML('<xsl:stylesheet version=\'1.0\' xmlns:xsl=\'http://www.w3.org/1999/XSL/Transform\'>\r'+'<xsl:output method="xml" indent="yes"/>\r'+'<xsl:strip-space elements="*"/>\r'+'<xsl:template match="/">\r'+'  <xsl:copy-of select="."/>\r'+'</xsl:template>\r'+'</xsl:stylesheet>');return this.transformNodes(_1,this.$37n)}
,isc.A.loadXMLSchema=function(_1,_2,_3){this.loadWSDL(_1,_2,true,_3)}
,isc.A.loadWSDL=function(_1,_2,_3,_4){if(!this.$37o){var _5=isc.Page.getIsomorphicClientDir()+"schema/schemaTranslator.xsl";_5=_5.replace(/https?:\/\/[^\/]*\//,"/");this.$37o="LOADING";isc.xml.loadXML(_5,function(_6,_7,_8){isc.xml.logDebug("schema translator loaded");if(isc.Browser.isMoz&&_8.xmlHttpRequest&&_8.xmlHttpRequest.responseXML)
{isc.xml.$37o=isc.XMLDoc.create(_8.xmlHttpRequest.responseXML)}else{isc.xml.$37o=_6}
isc.xml.loadWSDL(_1,_2,_3,_4)});return}
isc.xml.loadXML(_1,function(_6){isc.xml.$37p(_6,_3,_2)},_4)}
,isc.A.$37p=function(_1,_2,_3){if(!isc.isAn.XMLDoc(this.$37o)){this.logInfo("deferred schema translator, schema translator not loaded","xmlComm");isc.Timer.setTimeout({methodName:"$37p",target:this,args:[_1,_2,_3]});return}
this.logInfo("transforming schema: "+this.echoLeaf(_1)+" with translator "+this.echoLeaf(this.$37o),"xmlComm");var _4=this.transformNodes(_1,this.$37o);if(this.logIsDebugEnabled("xmlComm")){this.logWarn("XML service definition is: \n"+_4)}
if(this.useClientXML){var _1=isc.xml.parseXML(_4),_5=this.$37m(_1.documentElement.childNodes),_6=this.toJS(_5,null,null,true);this.$37q(_2,_3);return}
this.logInfo("about to call serverToJS with: "+this.echoLeaf(_4)+", callback: "+this.echo(_3),"xmlComm");this.serverToJS(_4,function(){isc.Log.logWarn("serverToJS returned");isc.xml.$37q(_2,_3)})}
,isc.A.$37q=function(_1,_2){var _3,_4;if(_1){_3=isc.SchemaSet.$37r;_4="schemaSet"}else{_3=isc.WebService.$37r;_4="service"}
this.fireCallback(_2,_4,[_3]);isc.WebService.$37r=isc.SchemaSet.$37r=null}
);isc.B._maxIndex=isc.C+48;isc.xml=isc.XML=isc.XMLTools;isc.defineClass("DataSource");isc.DS=isc.DataSource;isc.A=isc.DataSource;isc.A.dataSourceObjectSuffix="DS";isc.A._dataSources={};isc.A.$54v={};isc.A.$54w={};isc.A.$532="element";isc.A.$45t="type";isc.A.TABLE="table";isc.A.VIEW="view";isc.A.$37t="<soap:Envelope xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/' ";isc.A.$37w="</soap:Envelope>";isc.A.$37u="<soap:Header>";isc.A.$51y="</soap:Header>";isc.A.$37v="<soap:Body";isc.A.$51z="</soap:Body>";isc.A=isc.DataSource;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.isLoaded=function(_1){if(!_1)return false;if(isc.isA.DataSource(_1)||this._dataSources[_1])return true;return false}
,isc.A.getDataSource=function(_1,_2,_3,_4){if(!_1)return null;if(isc.isA.DataSource(_1))return _1;if(_4&&isc.WebService){if(_4==isc.DS.$532)return this.$54v[_1];if(_4==isc.DS.$45t)return this.$54w[_1];return null}
var _5=this._dataSources[_1];if(!_5){_5=this.$37x(_1,_2);if(_5)_5.ID=_1}
if(_5){if(_2){this.fireCallback(_2,"ds",[_5],_5)}
return _5}
if(_2){this.loadSchema(_1,_2,_3)}
return null}
,isc.A.loadSchema=function(_1,_2,_3){this.logWarn("Attempt to load schema for DataSource '"+_1+"'. This dataSource cannot be found. To load DataSources from the server without "+"explicit inclusion in your application requires optional SmartClient server "+"support - not present in this build.");return null}
,isc.A.get=function(_1,_2,_3,_4){return this.getDataSource(_1,_2,_3,_4)}
,isc.A.$37x=function(_1,_2){if(_2)return null;if(_1!=isc.auto&&this.logIsDebugEnabled()){this.logDebug("isc.DataSource '"+_1+"' not present")}
return null}
,isc.A.getRegisteredDataSources=function(){return isc.getKeys(this._dataSources)}
,isc.A.isRegistered=function(_1){if(this._dataSources[_1])return true;return false}
,isc.A.getForeignFieldName=function(_1){var _2=_1.foreignKey,_3=_2.indexOf(".");if(_3==-1)return _2;return _2.substring(_3+1)}
,isc.A.getForeignDSName=function(_1,_2){var _3=_1.foreignKey,_4=_3.indexOf(".");if(_4==-1)return isc.isA.String(_2)?_2:_2.ID;return _3.substring(0,_4)}
,isc.A.registerDataSource=function(_1){if(this.logIsInfoEnabled()){this.logInfo("Registered new isc.DataSource '"+_1.ID+"'")}
if(_1.ID){var _2=this._dataSources[_1.ID];if(!_2||!_1.schemaNamespace){this._dataSources[_1.ID]=_1}}
if(isc.Schema&&isc.isA.Schema(_1)){if(isc.isAn.XSElement(_1))this.$54v[_1.ID]=_1;else if(isc.isAn.XSComplexType(_1))this.$54w[_1.ID]=_1;return}
var _3=_1.getLocalFields(true);var _4=this.$37z=(this.$37z||{});for(var _5 in _3){var _6=_3[_5];if(_6.foreignKey==null)continue;var _7=this.getForeignDSName(_6,_1);if(isc.DS.isRegistered(_7)){isc.DS.get(_7).addChildDataSource(_1)}else{if(_4[_7]==null){_4[_7]=[]}
_4[_7].add(_1)}}
var _8=_4[_1.ID];if(_8!=null){_1.map("addChildDataSource",_8);_4[_1.ID]=null}
var _9=this.$370=this.$370||{};if(_1.childRelations){for(var i=0;i<_1.childRelations.length;i++){var _11=_1.childRelations[i],_12=_11.dsName,_13=isc.DS.get(_12);if(_13){this.$371(_1,_13,_11)}else{if(_9[_12]==null){_9[_12]=[]}
_11.parentDS=_1.ID;_9[_12].add(_11)}}}
var _14=_9[_1.ID];if(_14){for(var i=0;i<_14.length;i++){var _11=_14[i];this.$371(isc.DS.get(_11.parentDS),_1,_11)}}}
,isc.A.$371=function(_1,_2,_3){_1.addChildDataSource(_2);if(!_3.fieldName)return;var _4=_2.getField(_3.fieldName);if(!_4.foriegnKey){_4.foreignKey=_1.ID+"."+_1.getPrimaryKeyFieldNames()[0]}}
,isc.A.getInheritanceDistance=function(_1,_2){var _3=isc.ClassFactory.getClass(_1),_4=isc.ClassFactory.getClass(_2);if(_3==null||_4==null){this.logWarn("Invalid superclass and/or subclass argument provided");return-1}
if(!_4.isA(_1)){this.logWarn(_2+" is not a subclass of "+_1);return-1}
for(var _5=0;_4!=_3;_5++){_4=_4.getSuperClass()}
return _5}
,isc.A.isSimpleTypeValue=function(_1){if(_1!=null&&(!isc.isAn.Object(_1)||isc.isA.Date(_1)))return true;return false}
,isc.A.getNearestSchema=function(_1){if(_1==null)return null;var _2;if(isc.isA.String(_1))_2=_1;else{_2=isc.isAn.Instance(_1)?_1.getClassName():_1._constructor||_1.type||_1.$schemaId}
var _3=isc.DS.get(_2);var _4=isc.ClassFactory.getClass(_2);if(_4!=null){var _5=null;while(_3==null&&(_4=_4.getSuperClass())!=null&&_4!=_5)
{_3=isc.DS.get(_4.getClassName());_5=_4}}
return _3||isc.DS.get("Object")}
,isc.A.getNearestSchemaClass=function(_1){if(_1==null)return null;var _2;while(_2==null){var _1=isc.DS.get(_1);_2=isc.ClassFactory.getClass(_1._constructor||_1.Constructor||_1.type);if(_2!=null)return _2;_1=_1.inheritsFrom;if(!_1)return null}
return null}
,isc.A.$372=function(_1){switch(_1){case"fetch":case"select":case"filter":return"fetch";case"add":case"insert":return"add";case"update":return"update";case"remove":case"delete":return"remove";default:return _1}}
,isc.A.isClientOnly=function(_1){if(isc.isA.String(_1))_1=this.getDataSource(_1);if(!_1)return false;return _1.clientOnly}
,isc.A.makeDefaultOperation=function(_1,_2,_3){var _4=isc.rpc.app();if(isc.isA.DataSource(_1))_1=_1.ID;if(!_1)_1="auto";if(_4.operations==null)_4.operations={};_3=_3||_1+"_"+_2;var _5=_4.operations[_3];if(_5==null){_5={ID:_3,dataSource:_1,type:_2,filterType:"paged",loadDataOnDemand:true,source:"auto"};_4.operations[_3]=_5}
return _5}
,isc.A.handleUpdate=function(_1,_2){if(!this.isUpdateOperation(_2.operationType))return;var _3=this.get(_2.dataSource);_3.updateCaches(_1,_2)}
,isc.A.isUpdateOperation=function(_1){if(_1=="add"||_1=="update"||_1=="remove"||_1=="replace"||_1=="delete"||_1=="insert")return true}
,isc.A.getUpdatedData=function(_1,_2,_3){var _4=_2.data;if(_3&&_2.status==0&&(_4==null||(isc.isA.Array(_4)&&_4.length==0)||isc.isAn.emptyString(_4)))
{this.logInfo("dsResponse for successful operation of type "+_1.operationType+" did not return updated record[s]. Using submitted request data to update"+" ResultSet cache.","ResultSet");var _5=_1.data;if(_1.operationType=="update"){_4=isc.addProperties({},_1.oldValues);if(isc.isAn.Array(_5)){_4=isc.addProperties(_4,_5[0])}else{_4=isc.addProperties(_4,_5)}
_4=[_4]}else{if(!isc.isAn.Array(_5))_5=[_5];_4=[];for(var i=0;i<_5.length;i++){_4[i]=isc.addProperties({},_5[i])}}
if(this.logIsDebugEnabled("ResultSet")){this.logDebug("Submitted data to be integrated into the cache:"+this.echoAll(_4),"ResultSet")}}
return _4}
,isc.A.filterCriteriaForFormValues=function(_1){var _2={};for(var _3 in _1){var _4=_1[_3];if(_4==null||isc.is.emptyString(_4))continue;if(isc.isAn.Array(_4)){if(_4.length==0)continue;for(var i=0;i<_4.length;i++){var _6=_4[i];if(isc.isAn.emptyString(_6))continue}}
_2[_3]=_4}
return _2}
);isc.B._maxIndex=isc.C+22;isc.A=isc.DataSource.getPrototype();isc.A.addGlobalId=true;isc.A.dataFormat="iscServer";isc.A.callbackParam="callback";isc.A.transformResponseToJS=true;isc.A.supportsRequestQueuing=true;isc.A.copyLocalResults=true;isc.A.criteriaPolicy="dropOnShortening";isc.A.showPrompt=true;isc.A.autoDeriveTitles=true;isc.A=isc.DataSource.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$41v="Action";isc.A.resultBatchSize=150;isc.A.$2j=[];isc.A.textContentProperty="xmlTextContent";isc.A.$dq="Defaults";isc.A.$dr="Properties";isc.A.$375="name";isc.A.dropUnknownCriteria=true;isc.A.$45y="startsWith";isc.A.$19q="substring";isc.A.$50i="exact";isc.A.$50j="iscServer";isc.B.push(isc.A.init=function(){if(this.serverType=="sql")this.dataFormat="iscServer";if(this.dataFormat=="iscServer"&&(this.serviceNamespace!=null||this.recordXPath!=null))this.dataFormat="xml";this.canQueueRequests=(this.dataFormat=="iscServer"||this.clientOnly);if(this.ID==null&&this.id!=null)this.ID=this.id;if(this.name==null)this.name=this.ID;var _1=isc.DS.get(this.ID);if(_1&&_1.builtinSchema)return _1;var _2=window[this.ID];if(this.addGlobalId&&this.addGlobalId!=isc.$ae&&(!_2||(!isc.isA.ClassObject(_2)&&isc.isA.DataSource(_2))))
{isc.ClassFactory.addGlobalID(this)}
var _3=this.fields;if(isc.isAn.Array(_3)){var _4={};for(var i=0;i<_3.length;i++){var _6=_3[i];if(_4[_6.name]!=null){this.logWarn("field.name collision: first field: "+this.echo(_4[_6.name])+", discarded field: "+this.echo(_6));continue}
_4[_6.name]=_6}
this.fields=_4}
if(this.dataSourceType==isc.DataSource.VIEW)this.initViewSources();isc.DataSource.registerDataSource(this)}
,isc.A.destroy=function(){var _1=this.ID,_2=isc.DS;if(_1&&this==window[_1])window[_1]=null;if(_2._dataSources[_1]==this)_2._dataSources[_1]=null;if(_2.$54v[_1]==this)_2.$54v[_1]=null;if(_2.$54w[_1]==this)_2.$54w[_1]=null}
,isc.A.getResultSet=function(_1){var _2=isc.ClassFactory.getClass(this.resultSetClass||isc.ResultSet);if(!isc.isA.Class(_2)){this.logWarn("getResultSet(): Unrecognized 'resultSetClass' property:"+_2+", returning a standard isc.ResultSet.");_2=isc.ResultSet}
return _2.create(_1,{$31k:true})}
,isc.A.dataChanged=function(dsResponse,dsRequest){}
,isc.A.updateCaches=function(_1,_2){var _3=_1.data,_4=_1.invalidateCache;if(!_3&&!_4){this.logWarn("Empty results returned on '"+_2.operationType+"' on dataSource '"+_2.dataSource+"', unable to update resultSet(s) on DataSource "+this.ID+".  Return affected records to ensure cache consistency.");return}
this.dataChanged(_1,_2)}
,isc.A.getLegalChildTags=function(){var _1=this.getFieldNames(),_2=[];for(var i=0;i<_1.length;i++){if(this.fieldIsComplexType(_1[i]))_2.add(_1[i])}
return _2}
,isc.A.getOperationBinding=function(_1,_2){if(_1==null||this.operationBindings==null)return this;if(isc.isAn.Object(_1)){var _3=_1;_1=_3.operationType;_2=_3.operationId}
var _4;if(_2){var _5=this.operationBindings.find("operationId",_2);if(_5)return _5}
if(_1){var _5=this.operationBindings.find("operationType",_1);if(_5)return _5}
return this}
,isc.A.getDataFormat=function(_1,_2){return this.getOperationBinding(_1,_2).dataFormat||this.dataFormat}
,isc.A.transformRequest=function(_1){return _1.data}
,isc.A.serializeFields=function(_1,_2){if(!_1)_1=_2.data;if(!_1)return _1;if(isc.DS.isSimpleTypeValue(_1))return _1;if(isc.isAn.Array(_1)){var _3=[];for(var i=0;i<_1.length;i++){_3[i]=this.serializeFields(_1[i],_2)}
return _3}
_1=isc.addProperties({},_1);var _5=this.getFields();for(var _6 in _5){var _7=_5[_6];if(isc.isA.Date(_1[_6])&&isc.SimpleType.getBaseType(_7.type)=="date"&&!isc.SimpleType.inheritsFrom(_7.type,"datetime"))
{_1[_6].logicalDate=true}}
return _1}
,isc.A.getDataProtocol=function(_1){var _2=this.getOperationBinding(_1),_3=this.getWebService(_1);return(_2.dataProtocol!=null?_2.dataProtocol:isc.isA.WebService(_3)?"soap":this.dataProtocol||"getParams")}
,isc.A.getServiceInputs=function(_1){var _2=this.getOperationBinding(_1),_3=this.getWebService(_1),_4=this.getWSOperation(_1);var _5=_2.defaultCriteria||this.defaultCriteria;if(_5&&_1.operationType=="fetch"){_1.data=isc.addProperties({},_5,_1.data)}
_1.originalData=_1.data;var _6=this.getDataProtocol(_1),_7=_6=="clientCustom";if(_7){if(!this.$624)this.$624={};this.$624[_1.requestId]=_1}
_1.data=this.transformRequest(_1);if(_7){return{dataProtocol:"clientCustom"}}
if(isc.isA.WebService(_3)){if(_1.wsOperation==null&&isc.isAn.Object(_4)){_1.wsOperation=_4.name}
this.logInfo("web service: "+_3+", wsOperation: "+this.echoLeaf(_4),"xmlBinding")}
var _8=this.getDataURL(_1);_8=_1.actionURL||_1.dataURL||_8;var _9,_10=_2.defaultParams||this.defaultParams,_11=_1.params;if(_10||_11){_9=isc.addProperties({},_10,_11)}
var _12=_6=="getParams"||_6=="postParams";if(_12){_9=isc.addProperties(_9||{},_1.data)}
if(_12){if(_9)_9=this.serializeFields(_9,_1);return{actionURL:_8,httpMethod:_1.httpMethod||(_6=="getParams"?"GET":"POST"),params:_9}}
var _13={actionURL:_8,httpMethod:_1.httpMethod||"POST"};if(_9)_13.params=_9;if(_6=="postMessage"){_13.data=(_1.data||"").toString()}
if(_6=="postXML"||_6=="soap"){var _14=_13.data=this.getXMLRequestBody(_1);_13.contentType=_1.contentType||"text/xml";this.logDebug("XML post requestBody is: "+_14,"xmlBinding")}
if(_6=="soap"){var _15=this.$du(_2.soapAction,_4.soapAction);if(_15!=null){if(isc.isAn.emptyString(_15))_15='""';_13.httpHeaders=isc.addProperties({SOAPAction:_15},_1.httpHeaders)}}
this.logDebug("serviceInputs are: "+this.echo(_13),"xmlBinding");return _13}
,isc.A.processResponse=function(_1,_2){var _3=this.$624[_1];if(_3==null){this.logWarn("DataSource.provedResponse(): Unable to find request corresponding to ID "+_1+", taking no action.");return}
delete this.$624[_1];if(_2.status==null)_2.status=0;if(_2.status==0){var _4=_2.data;if(_4==null)_2.data=_4=[];if(_2.startRow==null)_2.startRow=_3.startRow||0;if(_2.endRow==null)_2.endRow=_2.startRow+_4.length;if(_2.totalRows==null){_2.totalRows=Math.max(_2.endRow,_4.length)}}
this.$38b(_4,_2,_3)}
,isc.A.$50e=function(_1,_2,_3){var _4=this.getClientOnlyResult(_3),_5=_3.$374;this.$38b(_2,_4,_5,_1,_3)}
,isc.A.$38a=function(_1,_2,_3){var _4={data:_2,startRow:0,endRow:0,totalRows:0,status:0};var _5=_3.$374;this.$38b(_2,_4,_5,_1,_3)}
,isc.A.$377=function(_1,_2,_3){var _4=_3.$374,_5=this.getOperationBinding(_4).recordXPath;if(_1.$38c&&this.logIsDebugEnabled("xmlBinding")){this.logDebug("Raw response data: "+isc.Comm.serialize(_2,true),"xmlBinding")}
var _6=_2;if(_2){if(this.recordXPath){_2=isc.xml.selectObjects(_2,this.recordXPath);this.logInfo("JSON recordXPath: '"+this.recordXPath+"', selected: "+this.echoLeaf(_2),"xmlBinding")}
_2=this.recordsFromObjects(_2);if(this.logIsDebugEnabled("xmlBinding")){this.logDebug("Validated dsResponse.data: "+isc.Comm.serialize(_2,true),"xmlBinding")}
var _7={data:_2,startRow:_4.startRow||0,status:0};_7.endRow=_7.startRow+Math.max(0,_2.length);_7.totalRows=Math.max(_7.endRow,_2.length)}else{var _7={status:-1}}
this.$38b(_6,_7,_4,_1,_3)}
,isc.A.$379=function(rpcResponse,jsonText,rpcRequest){if(rpcResponse.status>=0){var evalText=jsonText;if(rpcRequest.transport!="scriptInclude"){var re;if(this.jsonPrefix){re=new RegExp(/^\s*/);evalText=evalText.replace(re,"");if(evalText.startsWith(this.jsonPrefix)){evalText=evalText.substring(this.jsonPrefix.length)}else{this.logInfo("DataSource specifies jsonPrefix, but not present in "+"response returned from server. Processing response anyway.")}}
if(this.jsonSuffix){re=new RegExp(/\s*$/)
evalText=evalText.replace(re,"");if(evalText.endsWith(this.jsonSuffix)){evalText=evalText.substring(0,(evalText.length-this.jsonSuffix.length))}else{this.logInfo("DataSource specifies jsonSuffix, but not present in "+"response returned from server. Processing response anyway.")}}}
if(evalText.match(/^\s*\{/)){evalText="var evalText = "+evalText+";evalText;"}
try{var jsonObjects=isc.eval(evalText)}catch(e){this.logWarn("Error evaluating JSON: "+e.toString()+", JSON text:\r"+jsonText);return}
if(jsonObjects==null){this.logWarn("Evaluating JSON reply resulted in empty value. JSON text:\r"+this.echo(jsonText));return}
rpcResponse.$38c=true}
this.$377(rpcResponse,jsonObjects,rpcRequest)}
,isc.A.recordsFromObjects=function(_1){if(!isc.isAn.Array(_1))_1=[_1];for(var i=0;i<_1.length;i++){_1[i]=this.validateJSONRecord(_1[i])}
return _1}
,isc.A.validateJSONRecord=function(_1){var _2=this.getFieldNames(),_3={};for(var i=0;i<_2.length;i++){var _5=_2[i],_6=this.getField(_5),_7;if(_6.valueXPath){_7=isc.xml.selectObjects(_1,_6.valueXPath,true)}else{_7=_1[_5]}
if(_6.getFieldValue){if(!isc.isA.Function(_6.getFieldValue)){isc.Func.replaceWithMethod(_6,"getFieldValue","record,value,field,fieldName")}
_7=_6.getFieldValue(_1,_7,_6,_5)}
var _8;if(_7!=_8){_3[_5]=this.validateFieldValue(_6,_7)}}
if(this.dropExtraFields)return _3;for(var i=0;i<_2.length;i++){var _5=_2[i];_1[_5]=_3[_5]}
return _1}
,isc.A.getMessageSerializer=function(_1,_2){var _3=this.getOperationBinding(_1,_2);if(_3.wsOperation){var _4=this.getWebService(_1,_2);return _4.getMessageSerializer(_3.wsOperation)}
return this}
,isc.A.getXMLRequestBody=function(_1,_2){if(isc.$cv)arguments.$cw=this;var _3=isc.SB.create(),_4=this.getDataProtocol(_1);if(_4=="soap"){_3.append(this.getSoapStart(_1),"\r");_3.append(this.getSoapBody(_1,_2));_3.append("\r",this.getSoapEnd(_1))}else{if(this.messageStyle=="template"){_3.append(this.$38d(_1))}else{var _5=this.getMessageSerializer(_1);_3.append(this.getXMLRequestBodyPart(_1,_1.data,_5,_2))}}
if(this.logIsDebugEnabled("xmlComm")){this.logDebug("outbound XML message: "+_3,"xmlComm")}
return _3.toString()}
,isc.A.$38d=function(_1){var _2=isc.SB.create(),_3=this.soapBodyTemplate,_4;_4=_3.evalDynamicString(this,_1);return _4}
,isc.A.getSchemaSet=function(){return isc.SchemaSet.get(this.schemaNamespace)}
,isc.A.hasWSDLService=function(_1){return isc.isA.WebService(this.getWebService(_1))}
,isc.A.getWebService=function(_1){var _2=this.getOperationBinding(_1),_3=(_1?_1.serviceNamespace:null)||_2.serviceNamespace||this.serviceNamespace;var _4=isc.WebService.get(_3);if(_3!=null&&_4==null){this.logWarn("No WebService definition has been loaded for serviceNamespace: "+_3+this.getStackTrace())}
return _4||this}
,isc.A.getWSOperation=function(_1){var _2=this.getOperationBinding(_1),_3=(isc.isAn.Object(_1)?_1.wsOperation:null)||_2.wsOperation||this.wsOperation,_4=this.getWebService(_1);if(_3!=null&&isc.isA.WebService(_4)){var _5=_4.getOperation(_3);if(!_5){isc.logWarn("DataSource.getWSOperation() : could not retrieve the operation "+_3)}
return _5}
return this}
,isc.A.getDataURL=function(_1){var _2=this.getOperationBinding(_1);if(_2!=this&&_2.dataURL)return _2.dataURL;if(this.dataURL!=null)return this.dataURL;if(this.hasWSDLService(_1)){var _3=this.getWebService(_1);return _3.getDataURL(this.getWSOperation(_1).name)}
return this.dataURL}
,isc.A.getGlobalNamespaces=function(_1){var _2=this.getWebService(_1),_3=this.globalNamespaces;if(_2&&_2.globalNamespaces){_3=isc.addProperties({},_3,_2.globalNamespaces)}
return _3}
,isc.A.getSoapStart=function(_1){var _2=this.getWebService(_1);if(_2.getSoapStart)return _2.getSoapStart(_1);return isc.SB.concat(isc.DataSource.$37t,isc.xml.$37l(this.getGlobalNamespaces(_1),null,"         "),">",isc.DataSource.$37u,this.getSoapHeader(_1),isc.DataSource.$51y)}
,isc.A.getSoapHeader=function(_1){var _2=this.getWebService(_1);if(_2.getSoapHeader)return _2.getSoapHeader(_1);var _3=_1.headerData||_2.getHeaderData(_1);if(!_3)return;this.logDebug("headerData is: "+this.echo(_3),"xmlBinding");var _4=_2.getInputHeaderSchema(this.getWSOperation(_1))||isc.emptyObject;var _5="",_6=_1.useFlatHeaderFields;for(var _7 in _3){var _8=_4[_7];if(_8!=null){if(isc.isA.DataSource(_8)){_5+=_8.xmlSerialize(_3[_7],{useFlatFields:_6})}else{_5+="\r     "+this.$38g(_7,_8,_3[_7],_8.partNamespace)}}else{this.logWarn("headerData passed for SOAP header partName: "+_7+", no schema available, not outputting")}}
return _5}
,isc.A.getSoapBody=function(_1,_2){var _3=isc.SB.create(),_4=this.getWebService(_1),_5=_4.getSoapStyle(_1),_6=this.getWSOperation(_1),_7=this.xmlNamespaces?isc.makeReverseMap(this.xmlNamespaces):null,_2=isc.addProperties({nsPrefixes:isc.addProperties({},_7)},_2),_8=_2.generateResponse?_4.getResponseMessage(_6.name):_4.getRequestMessage(_6.name),_9=_4.getBodyPartNames(_6.name,_2.generateResponse);isc.Comm.omitXSI=_6.inputEncoding!="encoded";var _10=isc.Comm.xmlSchemaMode;isc.Comm.xmlSchemaMode=true;var _11="        ";if(_5=="rpc"){_3.append("\n",_11,isc.Comm.$36u(_6.name,null,_6.inputNamespace,"opNS",true),">");_11+="    "}
this.logInfo("soap:body parts in use: "+_9,"xmlSerialize");for(var i=0;i<_9.length;i++){var _13=_9[i],_14=_8.getField(_13);var _15=_9.length<2&&_5=="document"?_1.data:(_1.data?_1.data[_13]:null);var _16=this.getSchema(_14.type,_14.xsElementRef?"element":null);var _17;if(isc.isA.DataSource(_16)){this.logInfo("soap:body part '"+_13+"' is complex type with schema: "+_16,"xmlSerialize");_17=this.getXMLRequestBodyPart(_1,_15,_16,_2,_11)}else{this.logInfo("soap:body part '"+_13+" is of simple type '"+_14.type+"'","xmlSerialize");_3.append("\r",_11);_17=this.$38g(_13,_14,_15,_14.partNamespace,_2)}
_3.append(_17)}
if(_5=="rpc"){_3.append("\n","        ",isc.Comm.$36v(_6.name,_6.inputNamespace,"opNS"))}
isc.Comm.omitXSI=null;isc.Comm.xmlSchemaMode=_10;return isc.SB.concat("    ",isc.DS.$37v,this.outputNSPrefixes(_2.nsPrefixes,"        "),">",_3.toString(),"\r    ",isc.DS.$51z)}
,isc.A.getSoapEnd=function(_1){var _2=this.getWebService(_1);if(_2.getSoapEnd)return _2.getSoapEnd(_1);return isc.DataSource.$37w}
,isc.A.getSoapStyle=function(_1){if(!this.hasWSDLService(_1))return"document";return this.getWebService(_1).getSoapStyle(this.getWSOperation(_1).name)}
,isc.A.getXMLRequestBodyPart=function(_1,_2,_3,_4,_5){_4=isc.addProperties({soapStyle:this.getSoapStyle(_1)},_4);var _6=this.getOperationBinding(_1);_4.flatData=this.$du(_1.useFlatFields,_6.useFlatFields,this.useFlatFields);_4.recursiveFlatFields=this.$du(_1.recursiveFlatFields,_6.recursiveFlatFields,this.recursiveFlatFields);_4.textContentProperty=this.$du(_1.textContentProperty,_6.textContentProperty);_4.dsRequest=_1;_4.startRowTag=_6.startRowTag||this.startRowTag;_4.endRowTag=_6.endRowTag||this.endRowTag;return _3.xmlSerialize(_1.data,_4,_5)}
,isc.A.xmlSerialize=function(_1,_2,_3,_4){if(!_2)_2={};if(_2.useFlatFields)_2.flatData=true;var _5=this.getSchemaSet(),_6=(_2.qualifyAll==null);if(_5&&_5.qualifyAll){_2.qualifyAll=true}
var _7;if(_2.nsPrefixes==null){var _8=this.xmlNamespaces?isc.makeReverseMap(this.xmlNamespaces):null;_2.nsPrefixes=isc.addProperties({},_8);_7=true}
isc.Comm.xmlSchemaMode=true;var _9;if(isc.Comm.omitXSI==null){_9=isc.Comm.omitXSI=true}
var _10=this.$ew(_1,_2,_3,_4,_7);if(_6)_2.qualifyAll=null;var _11=isc.Comm.xmlSchemaMode;isc.Comm.xmlSchemaMode=_11;if(_9)isc.Comm.omitXSI=null;return _10}
,isc.A.$ew=function(_1,_2,_3,_4,_5){if(isc.$cv)arguments.$cw=this;if(this.logIsDebugEnabled("xmlSerialize")){this.logWarn("schema: "+this+" serializing: "+this.echo(_1)+" with flags: "+this.echo(_2))}
var _6=this.mustQualify||_2.qualifyAll;var _7;if(_1!=null&&(_1._constructor||isc.isAn.Instance(_1))){var _7=isc.isAn.Instance(_1)?_1.Class:_1._constructor}
if(isc.isAn.Instance(_1))_1=_1.getSerializeableFields();if(isc.DS.isSimpleTypeValue(_1)){this.logDebug("simple type value: "+this.echoLeaf(_1)+" passed to xmlSerialize on "+this,"xmlSerialize");return isc.Comm.$ew(_4||this.tagName||this.ID,_1)}
if(isc.isAn.Array(_1)&&!this.canBeArrayValued)return this.map("xmlSerialize",_1,_2,_3).join("\n");var _8=isc.SB.create(),_4=_4||this.tagName||this.ID,_3=_3||"";_8.append("\r",_3);var _9;if(_6){_9=(this.isA("XSComplexType")?_2.parentSchemaNamespace:null)||this.schemaNamespace}
_8.append(isc.Comm.$36u(_4,this.ID,_9,_2.nsPrefixes,true));_1=this.serializeAttributes(_1,_8,_2);if(_7&&_4!=_7){_8.append(" constructor=\"",_7,"\"")}
var _10;if(_1!=null){_10=this.xmlSerializeFields(_1,_2,_3+"    ")}
if(_5){_8.append(this.outputNSPrefixes(_2.nsPrefixes,_3+"     "))}
var _11=this.$45z;this.$45z=null;if(_10==null||isc.isAn.emptyString(_10)){_8.append("/>");return _8.toString()}
_8.append(">",_10,(_11?"":"\r"+_3));_8.append(isc.Comm.$36v(_4,_9,_2.nsPrefixes));return _8.toString()}
,isc.A.outputNSPrefixes=function(_1,_2){delete _1.$36y;_1=isc.makeReverseMap(_1);var _3=isc.xml.$37l(_1,null,_2+"        ");return _3}
,isc.A.serializeAttributes=function(_1,_2,_3){var _4=this.getFieldNames(),_5=true;for(var i=0;i<_4.length;i++){var _7=_4[i],_8=this.getField(_7);if(_8.xmlAttribute&&((_1&&_1[_7]!=null)||_8.xmlRequired)){if(_5){_1=isc.addProperties({},_1);_5=false}
var _9=_1[_7];if(_3&&_3.spoofData)_9=this.getSpoofedData(_8);_2.append(" ",_7,"=\"",this.$38f(_8,_9),"\"");delete _1[_7]}}
return _1}
,isc.A.xmlSerializeFields=function(_1,_2,_3){var _4=isc.SB.create(),_2=_2||isc.emptyObject,_5=_2.flatData,_6=_2.spoofData,_3=_3||"";var _1=isc.addProperties({},_1),_7=this.getFields();for(var _8 in _7){var _9=this.getField(_8),_10=_1[_8],_11=this.fieldIsComplexType(_8);var _12=_1[_8];if(_2.startRowTag==_9.name&&_12==null){_12=_2.dsRequest?_2.dsRequest.startRow:null}else if(_2.endRowTag==_9.name&&_12==null){_12=_2.dsRequest?_2.dsRequest.endRow:null}else if(_11&&_5&&_12==null){_12=_1}
var _13=(_9.xmlRequired&&!_9.xmlAttribute)||(_1[_8]!=null||(_6&&!_9.xmlAttribute));if(_5&&_11){var _14=this.getSchema(_9.type),_15=isc.clone(_2.nsPrefixes),_16=_14.xmlSerializeFields(_12,_2);if(_16!=null&&!isc.isAn.emptyString(_16)){_13=true}
_2.nsPrefixes=_15}
if(_13){if(_5&&_11&&_1[_8]!=null&&!isc.DS.isSimpleTypeValue(_1[_8])&&!_2.recursiveFlatFields)
{_2=isc.addProperties({},_2);_2.flatData=false}
_4.append(this.xmlSerializeField(_8,_12,_2,_3))}
if(!_5&&_1[_8]!=null)delete _1[_8]}
if(!_5){for(var _8 in _1){_4.append(this.xmlSerializeField(_8,_1[_8],_2,_3))}}
return _4.toString()}
,isc.A.xmlSerializeField=function(_1,_2,_3,_4){var _5=isc.SB.create(),_6=this.getField(_1);if(_6==null&&(_1.startsWith("_")||_1.startsWith("$")))return;var _7=(_6?_6.type:null),_8=_3&&_3.flatData,_9=_3&&_3.spoofData,_4=_4||"";if(_9)_2=this.getSpoofedData(_6);if(this.logIsDebugEnabled("xmlSerialize")){this.logDebug("serializing fieldName: "+_1+" with type: "+_7+" with value: "+this.echo(_2))}
var _10=((_6&&_6.mustQualify)||_3.qualifyAll?this.getSchemaSet().schemaNamespace:null);var _11=_3.textContentProperty||this.textContentProperty,_12=this.getTextContentField();if(_1==_11&&(_12!=null||!this.hasXMLElementFields(_11)))
{this.$45z=true;return this.$38f(_12,_2)}
if(_7==this.$41v&&_2!=null){if(_2.iscAction){_2=_2.iscAction}else if(isc.isA.StringMethod(_2)){_2=_2.value}}
var _13=isc.Comm.$36u(_1,_6?_6.type:null,_10,_3.nsPrefixes),_14=isc.Comm.$36v(_1,_10,_3.nsPrefixes);var _15=isc.isAn.Array(_2)?_2:[_2];if(this.fieldIsComplexType(_1)){var _16=_3.parentSchemaNamespace;_3.parentSchemaNamespace=this.schemaNamespace;var _17=this.getSchema(_7,_6&&_6.xsElementRef?"element":null);if(_6.multiple){_5.append("\r",_4,_13);for(var i=0;i<_15.length;i++){_5.append(_17.xmlSerialize(_15[i],_3,_4+"    ",_6.childTagName))}
_5.append("\r",_4,_14)}else if(_17.canBeArrayValued&&isc.isAn.Array(_2)){_5.append(_17.xmlSerialize(_2,_3,_4,_1))}else{for(var i=0;i<_15.length;i++){if(_15[i]==null){_5.append("\r",_4)
_5.append(_13,_14)}else if(isc.DS.isSimpleTypeValue(_15[i])){this.logWarn("simple type value "+this.echoLeaf(_15[i])+" passed to complex field '"+_6.name+"'","xmlSerialize");_5.append("\r",_4)
_5.append(isc.Comm.xmlSerialize(_1,_15[i]))}else{_5.append(_17.xmlSerialize(_15[i],_3,_4,_1))}}}
_3.parentSchemaNamespace=_16}else if(_6!=null){if(_6.multiple){_5.append("\r",_4,_13,"\r");for(var i=0;i<_15.length;i++){_5.append(this.$38g(null,_6,_15[i],_10,_3),"\r",_4)}
_5.append("\r",_4,_14,"\r")}else{for(var i=0;i<_15.length;i++){_5.append("\r",_4,this.$38g(_1,_6,_15[i],_10,_3))}}}else{for(var i=0;i<_15.length;i++){if(_15[i]==null||isc.isAn.emptyObject(_15[i])){_5.append("\r",_4,_13,_14)}else{_5.append("\r",_4,isc.Comm.$ew(_1,_15[i],_4,{isRoot:false}))}}}
return _5.toString()}
,isc.A.$38g=function(_1,_2,_3,_4,_5){var _6=_2.type,_5=_5||{};if(isc.isAn.Object(_3)&&!isc.isA.Function(_3.$ew)){return isc.Comm.xmlSerialize(_1||null,_3)}else{var _6=this.$38h(_6);if(_3==null&&_2.nillable){var _7=_1||"value";return isc.Comm.$36u(_7,null,_4,_5.nsPrefixes,true)+" xsi:nil=\"true\"/>"}
if(isc.isA.Date(_3)){_3=_3.toSchemaDate(_2.type=="date")}else if(_3!=null&&_3.$ew){return _3.$ew(_1,_6,_4)}else{_3=isc.makeXMLSafe(_3)}
return isc.Comm.$ex(_1||"value",_3,_6,_4,_5.nsPrefixes)}}
,isc.A.$38f=function(_1,_2){if(isc.isA.Date(_2)){return _2.toSchemaDate(_1&&_1.type=="date")}else{return isc.makeXMLSafe(_2)}}
,isc.A.$38h=function(_1){switch(_1){case"integer":return"int";case"number":return"long";default:return _1}}
,isc.A.xmlSerializeSample=function(){return this.xmlSerialize({},{spoofData:true})}
,isc.A.getSpoofedData=function(_1){if(!_1)return"textValue";if(this.getSchema(_1.type)!=null)return{};if(_1.multiple){_1={type:_1.type};return[this.getSpoofedData(_1),this.getSpoofedData(_1)]}
if(_1.valueMap){var _2=!isc.isAn.Array(_1.valueMap)?isc.getKeys(_1.valueMap):_1.valueMap;return _2[Math.round(Math.random()*(_2.length-1))]}
var _3=isc.SimpleType.getBaseType(_1.type);switch(_3){case"boolean":return(Math.random()>0.5);case"integer":case"int":case"number":var _4=0,_5=10;if(_1.validators){var _6=_1.validators.find("type","integerRange");if(_6){this.logWarn(_1.name+" has "+_6.type+" validator "+" with min "+_6.min+" and max "+_6.max);_4=_6.min||0;_5=_6.max||Math.min(_4,10);if(_4>_5)_4=_5}}
return Math.round(_4+(Math.random()*(_5-_4)));case"float":case"decimal":case"double":var _4=0,_5=10,_7=2;if(_1.validators){var _6=_1.validators.find("type","floatRange");if(_6){this.logWarn(_1.name+" has "+_6.type+" validator "+" with min "+_6.min+" and max "+_6.max);_4=_6.min||0;_5=_6.max||Math.min(_4,10);if(_4>_5)_4=_5}
var _8=_1.validators.find("type","floatPrecision");if(_8){_7=_8.precision||2}}
return(_4+(Math.random()*(_5-_4))).toFixed(_7);case"date":case"time":case"datetime":var _9=new Date();if(_1.validators){var _6=_1.validators.find("type","dateRange");if(_6){this.logWarn(_1.name+" has "+_6.type+" validator "+" with min "+_6.min+" and max "+_6.max);if(_6.min)_9=_6.min;else if(_6.max)_9=_6.max}}
return _9;default:return"textValue"}}
,isc.A.getSerializeableFields=function(_1,_2){var _3=this.Super("getSerializeableFields",arguments);var _4=_3.fields;_4=isc.getValues(_4);for(var i=0;i<_4.length;i++){var _6=_4[i]=isc.addProperties({},_4[i]);var _7=_6.validators;if(_7){_6.validators=_7.findAll("_generated",null);if(_6.validators==null)delete _6.validators}}
_3.fields=_4;return _3}
,isc.A.$378=function(_1,_2,_3,_4){var _5=_1,_6=_4.$374,_7=this.getOperationBinding(_6),_8;if(_3.status<0){this.$38b(_2,{status:-1},_6,_3,_4);return}
if(_5){if(_7.wsOperation){var _9=this.getWebService(_6),_8=_9.getOutputNamespaces(_7.wsOperation);_5.addNamespaces(_8)}
_5.addNamespaces(this.xmlNamespaces);_5.addNamespaces(_7.xmlNamespaces)}
var _10=isc.addProperties({},_8,this.xmlNamespaces,_7.xmlNamespaces);this.dsResponseFromXML(_5,_6,_10,{target:this,methodName:"$57b",xmlData:_5,dsRequest:_6,rpcRequest:_4,rpcResponse:_3})}
,isc.A.$57b=function(_1,_2){this.$38b(_2.xmlData,_1,_2.dsRequest,_2.rpcResponse,_2.rpcRequest)}
,isc.A.dsResponseFromXML=function(_1,_2,_3,_4){if(_1){this.selectRecords(_1,_2,{target:this,methodName:"$57c",dsRequest:_2,callback:_4,xmlData:_1,xmlNamespaces:_3})}else{this.$57c([],_2,_3,_4)}}
,isc.A.$57c=function(_1,_2,_3,_4){if(!_4&&_2.callback)_4=_2.callback;if(_2.xmlNamespaces)_3=_2.xmlNamespaces;if(_2.dsRequest)_2=_2.dsRequest;if(_3==null)_3=this.xmlNamespaces;var _5={data:_1,startRow:_2.startRow||0,status:0};_5.endRow=_5.startRow+Math.max(0,_1.length-1);_5.totalRows=Math.max(_5.endRow,_1.length);var _6=_4.xmlData;if(!_6)return _5;if(this.totalRowsXPath){_5.totalRows=isc.xml.selectNumber(_6,this.totalRowsXPath,_3,true)}
if(this.startRowXPath){_5.startRow=isc.xml.selectNumber(_6,this.startRowXPath,_3,true);_5.endRow=_5.startRow+Math.max(0,_1.length-1)}
if(this.endRowXPath){_5.endRow=isc.xml.selectNumber(_6,this.endRowXPath,_3,true);if(!this.startRowXPath){_5.startRow=_5.endRow-Math.max(0,_1.length-1)}}
if(this.statusXPath){_5.status=parseInt(isc.xml.selectScalar(_6,this.statusXPath,_3,true))}
if(this.errorSchema){_5.errors=this.errorSchema.selectRecords(_6,_2)}
if(_4)this.fireCallback(_4,"dsResponse",[_5,_4])
return _5}
,isc.A.selectRecords=function(_1,_2,_3){var _4=this.selectRecordElements(_1,_2);var _5=this.getOperationBinding(_2),_6=this.getSchema(_5.responseDataSchema)||this;return _6.recordsFromXML(_4,_3)}
,isc.A.recordsFromXML=function(_1,_2){if(!isc.isAn.Array(_1)){if(_1.length!=null)_1=isc.xml.$37m(_1);else _1=[_1]}
if(this.transformResponseToJS){if(_1.length>this.resultBatchSize){var _3={startingRow:0,callback:_2,elements:_1};return this.$57d(_3)}
var _4=this.dropExtraFields?this.getFieldNames():null;_1=isc.xml.toJS(_1,_4,this);if(this.logIsDebugEnabled("xmlBinding")){this.logDebug("transformed response: "+isc.Comm.serialize(_1,true)+"xmlBinding")}}
if(_2){this.fireCallback(_2,"records",[_1,_2])}
return _1}
,isc.A.$57d=function(_1){var _2=_1.elements,_3=_1.startingRow,_4=_1.callback,_5=Math.min(_2.length,_3+this.resultBatchSize),_6=this.dropExtraFields?this.getFieldNames():null;if(!_1.$57e){_1.$57e=isc.xml.toJS(_2.slice(_3,_5+1),_6,this)}else{var _7=isc.xml.toJS(_2.slice(_3,_5+1),_6,this);_1.$57e.addList(_7)}
if(_5<_2.length){_1.startingRow=_5+1;this.delayCall("$57d",[_1])}else if(_4){this.fireCallback(_4,"records",[_1.$57e,_4])}}
,isc.A.selectRecordElements=function(_1,_2){if(isc.isA.String(_1))_1=isc.xml.parseXML(_1);var _3=this.getOperationBinding(_2);var _4=_3==this?null:_3.recordXPath,_5=_3==this?null:_3.recordName,_6=this.recordXPath,_7=this.recordName;if(_4==null&&(_5!=null||(_6==null&&_7!=null))&&this.hasWSDLService(_2))
{var _8=this.getWebService(_2);return _8.selectByType(_1,_3.wsOperation||this.wsOperation,_5||_7)}
var _9=_4||_6,_10;if(_9){_10=isc.xml.selectNodes(_1,_9,this.xmlNamespaces);this.logDebug("applying XPath: "+_9+(this.xmlNamespaces?" with namespaces: "+this.echo(this.xmlNamespaces):"")+" got "+_10.length+" elements","xmlBinding")}else{_10=[];var _11=_5||_7||this.ID;var _12=_1.getElementsByTagName(_11);for(var i=0;i<_12.length;i++)_10.add(_12[i]);this.logDebug("getting elements of tag name: "+_11+" got "+_10.length+" elements","xmlBinding")}
return _10}
,isc.A.$38b=function(_1,_2,_3,_4,_5){if(_4!=null&&_5!=null){_2.httpResponseCode=_4.httpResponseCode;_2.transactionNum=_4.transactionNum;_2.clientContext=_5.clientContext}
if(this.logIsInfoEnabled("xmlBinding")){this.logInfo("dsResponse is: "+this.echo(_2),"xmlBinding")}
_2.context=_5;var _6=this.transformResponse(_2,_3,_1);_2=_6||_2;_2.startRow=this.$52v(_2.startRow);_2.endRow=this.$52v(_2.endRow);_2.totalRows=this.$52v(_2.totalRows);if(_2.status>=0){isc.DataSource.handleUpdate(_2,_3)}else if(!_3.willHandleError){isc.RPCManager.$a0(_2,_3)}
var _7=[_3.$376,_3.afterFlowCallback],_8=[];for(var i=0;i<_7.length;i++){var _10=_7[i];if(_8.contains(_10)){this.logWarn("Suppressed duplicate callback: "+_10);continue}
var _11=this.fireCallback(_10,"dsResponse,data,dsRequest",[_2,_2.data,_3]);if(_5&&_5.willHandleError&&_11===false){this.logDebug("performOperationReply: Further processing cancelled by callback");break}
if(_4){var _12=isc.RPCManager.getTransaction(_4.transactionNum);if(_12&&_12.suspended)return}}}
,isc.A.$52v=function(_1){if(_1==null||!isc.isA.String(_1))return _1;var _2=parseInt(_1);if(isNaN(_2))return _1;else return _2}
,isc.A.transformResponse=function(_1,_2,_3){return _1}
,isc.A.getFieldValue=function(_1,_2,_3){var _4=isc.xml.getFieldValue(_1,_2,_3,this,this.xmlNamespaces);if(!_3.getFieldValue)return _4;if(!isc.isA.Function(_3.getFieldValue)){isc.Func.replaceWithMethod(_3,"getFieldValue","record,value,field,fieldName")}
return _3.getFieldValue(_1,_4,_3,_2)}
,isc.A.validateFieldValue=function(_1,_2){var _3=_1.validators;if(!_3)return _2;if(!isc.isAn.Array(_3)){this.$2j[0]=_3;_3=this.$2j}
var _4=_2;for(var i=0;i<_3.length;i++){var _6=_3[i];var _7=isc.Validator.processValidator(_1,_6,_2);if(!_7){this.logWarn(this.ID+"."+_1.name+": value: "+this.echoLeaf(_2)+" failed on validator: "+this.echo(_6));return _2}
var _8;if(_6.resultingValue!==_8){_2=_6.resultingValue;_6.resultingValue=_8}
if(!_7&&_6.stopIfFalse)break}
this.$2j.length=0;return _2}
,isc.A.fetchData=function(_1,_2,_3){this.performDSOperation("fetch",_1,_2,_3)}
,isc.A.filterData=function(_1,_2,_3){if(!_3)_3={};if(_3.textMatchStyle==null)_3.textMatchStyle="substring";this.performDSOperation("fetch",_1,_2,_3)}
,isc.A.addData=function(_1,_2,_3){this.performDSOperation("add",_1,_2,_3)}
,isc.A.updateData=function(_1,_2,_3){this.performDSOperation("update",_1,_2,_3)}
,isc.A.removeData=function(_1,_2,_3){var _4=this.getPrimaryKeyFields(),_1=isc.applyMask(_1,_4);this.performDSOperation("remove",_1,_2,_3)}
,isc.A.$625=function(){if(!this.$626)this.$626=[this.getID(),"$627"];this.$626[2]=isc.DataSource.$625();return this.$626.join(isc.emptyString)}
,isc.A.performDSOperation=function(_1,_2,_3,_4){if(isc.$cv)arguments.$cw=this;var _5=isc.addProperties({operationType:_1,dataSource:this.ID,data:_2,callback:_3,requestId:this.$625()},_4);return this.sendDSRequest(_5)}
,isc.A.sendDSRequest=function(_1){isc.addDefaults(_1,this.getOperationBinding(_1.operationType).requestProperties);isc.addDefaults(_1,this.requestProperties);var _2=this.getDataFormat(_1);if(_2=="iscServer"&&!this.clientOnly&&!isc.hasOptionalModule("SCServer")){if(this.dataURL==null&&this.testFileName==null){this.logError("DataSource: "+this.ID+": attempt to use DataSource of type iscServer without SmartClient Server option."+" Please either set clientOnly: true for one-time fetch against"+" dataURL/testFileName or download the edition with SmartClient Server");return}
this.logInfo("Switching to clientOnly - no SmartClient Server installed.");this.clientOnly=true}
if(_1.showPrompt==null){_1.showPrompt=this.showPrompt}
if(this.fetchingClientOnlyData(_1))return;if(this.logIsDebugEnabled()){this.logDebug("Outbound DSRequest: "+this.echo(_1))}
_1.$376=_1.callback;if(_2=="iscServer"&&!this.clientOnly){return this.performSCServerOperation(_1)}
var _3=this.getServiceInputs(_1);if(_3.dataProtocol=="clientCustom")return;var _4=isc.addProperties({},_1,_3);_4.$374=_1;if(_3.data==null)_4.data=null;if(this.clientOnly){_4.callback={target:this,methodName:"$50e"};isc.RPC.sendRequest(_4);return}
var _5=this.getOperationBinding(_1);_4.transport=_5.dataTransport||this.dataTransport;if(_4.transport=="scriptInclude"){_4.callback={target:this,methodName:"$377"};if(!_4.callbackParam){_4.callbackParam=_5.callbackParam||this.callbackParam}
isc.RPC.sendRequest(_4);return}
var _2=this.getDataFormat(_1);if(_2=="xml"){_4.callback={target:this,method:this.$378};isc.xml.getXMLResponse(_4)}else if(_2=="json"){_4.callback={target:this,method:this.$379};isc.rpc.sendProxied(_4)}else{_4.serverOutputAsString=true;_4.callback={target:this,method:this.$38a};isc.rpc.sendProxied(_4)}}
,isc.A.performSCServerOperation=function(_1,_2){this.logWarn("Attempt to perform iscServer request requires options SmartClient server "+"support - not present in this build.\nRequest details:"+this.echo(_1));return}
,isc.A.getSchema=function(_1,_2){var _3=this.getSchemaSet();if(_3!=null){var _4=_3.getSchema(_1,_2);if(_4!=null)return _4}
var _5=this.getWebService();if(isc.isA.WebService(_5))return _5.getSchema(_1,_2);return isc.DS.get(_1,null,null,_2)}
,isc.A.getTitle=function(){return this.title||this.ID}
,isc.A.getPluralTitle=function(){return this.pluralTitle||(this.getTitle()+"s")}
,isc.A.getTitleField=function(){if(this.titleField==null){var _1=isc.getKeys(this.getFields());this.titleField=_1.contains("title")?"title":_1.contains("label")?"label":_1.contains("name")?"name":_1.contains("id")?"id":_1.first()}
return this.titleField}
,isc.A.getIconField=function(){var _1;if(this.iconField===_1){this.iconField=null;var _2=isc.getKeys(this.getFields());var _3=["picture","thumbnail","icon","image","img"];for(var i=0;i<_3.length;i++){var _5=_3[i],_6=this.getField(_5);if(_6&&isc.SimpleType.inheritsFrom(_6.type,"image")){this.iconField=_5}}}
return this.iconField}
,isc.A.initViewSources=function(){var _1=this.fields={};for(var _2 in this.sources){var _3=isc.DS.get(_2);if(!_3)continue;var _4=this.sources[_2].fields;for(var _5 in _4){var _6=_4[_5],_7=null;if(_6=="*"){_7=_3.fields[_5]}else if(isc.isA.String(_6)){_7=_3.fields[_6]}else if(isc.isAn.Object(_6)){_7=isc.addProperties({},_3.fields[_3.fields[_6.field]]);isc.addProperties(_7,_6)}
if(_7)_1[_5]=_7}}}
,isc.A.inheritsSchema=function(_1){if(_1==null)return false;if(isc.isA.String(_1))_1=this.getSchema(_1);if(_1==this||_1==isc.DS.get("Object"))return true;if(!this.hasSuperDS())return false;return this.superDS().inheritsSchema(_1)}
,isc.A.getInheritedProperty=function(_1){if(this[_1])return this[_1];var _2=this.superDS();return _2?_2.getInheritedProperty(_1):null}
,isc.A.hasSuperDS=function(){if(this.inheritsFrom)return true;return false}
,isc.A.superDS=function(){if(this.hasSuperDS())return this.getSchema(this.inheritsFrom);return null}
,isc.A.getField=function(_1){var _2=this.getFields();return _2?_2[_1]:null}
,isc.A.getFieldNames=function(){if(isc.$cv)arguments.$cw=this;return isc.getKeys(this.getFields())}
,isc.A.getLocalFields=function(_1){if(this.$38k)return this.fields;if(_1)return this.fields;this.$38l();this.$63p();this.$38k=true;return this.fields}
,isc.A.getFields=function(){if(isc.$cv)arguments.$cw=this;if(this.mergedFields)return this.mergedFields;if(!this.hasSuperDS()||this==this.superDS()){return this.mergedFields=this.getLocalFields()}
var _1=this.superDS();if(this.showLocalFieldsOnly||this.restrictToLocalFields){this.useParentFieldOrder=false}
var _2=isc.addProperties({},this.getLocalFields()),_3;if(!this.useParentFieldOrder){_3=_2}else{_3={}}
var _4=(this.restrictToLocalFields?isc.getKeys(this.getLocalFields()):_1.getFieldNames());for(var i=0;i<_4.length;i++){var _6=_4[i],_7=_2[_6];if(_7!=null){var _8=_1.getField(_6);if(_8.hidden&&_7.hidden==null&&!_7.inapplicable)
{_7.hidden=false}
if(_8.visibility!=null&&_7.visibility==null&&!_7.inapplicable&&!_7.hidden&&_8.visibility=="internal")
{_7.visibility="external"}
_3[_6]=_1.combineFieldData(_7)}else{if(this.showLocalFieldsOnly){_3[_6]=isc.addProperties({},_1.getField(_6));_3[_6].hidden="true"}else{_3[_6]=_1.getField(_6)}}
if(this.useParentFieldOrder)delete _2[_6]}
if(this.useParentFieldOrder)isc.addProperties(_3,_2);if(this.restrictToLocalFields&&isc.Schema&&isc.isA.Schema(this)){var _9=_1.getFieldNames();for(var i=0;i<_9.length;i++){var _6=_9[i],_10=_1.getField(_6);if(_10.xmlAttribute){_3[_6]=_3[_6]||_10}}}
return this.mergedFields=_3}
,isc.A.getFlattenedFields=function(_1){_1=_1||{};var _2=this.getFieldNames();for(var i=0;i<_2.length;i++){var _4=_2[i],_5=this.getField(_4);if(!this.fieldIsComplexType(_4)){if(_1[_4]==null){_5.sourceDS=this.ID;_1[_4]=_5}}else{var _6=this.getSchema(_5.type);_6.getFlattenedFields(_1)}}
return _1}
,isc.A.fieldIsComplexType=function(_1){var _2=this.getField(_1);return(_2!=null&&_2.type!=null&&!_2.xmlAttribute&&this.getSchema(_2.type)!=null)}
,isc.A.findTagOfType=function(_1,_2,_3){var _4=this.getFieldNames();for(var i=0;i<_4.length;i++){var _6=_4[i],_7=this.getField(_6);if(_7.type==_1)return[this,_6,_2,_3];if(this.fieldIsComplexType(_6)){var _8=this.getSchema(_7.type),_9=_8.findTagOfType(_1,this,_6);if(_9)return _9}}}
,isc.A.getTextContentField=function(){return this.getField(this.textContentProperty)}
,isc.A.hasXMLElementFields=function(_1){_1=_1||this.textContentProperty;var _2=this.getFieldNames();for(var i=0;i<_2.length;i++){if(_2[i]==_1)continue;if(this.getField(_2[i]).xmlAttribute)continue;return true}
return false}
,isc.A.getGroups=function(){var _1=this;while(_1.groups==null&&_1.hasSuperDS())_1=_1.superDS();return _1.groups}
,isc.A.getObjectField=function(_1,_2,_3){if(!_1)return null;var _4=this.getLocalFields(),_5=isc.getKeys(_4).reverse(),_6=isc.DataSource.getNearestSchemaClass(_1);if(_3==null)_3={};var _7=-1,_8=null;for(var i=0;i<_5.length;i++){var _10=_5[i],_11=_4[_10],_12;if(isc.endsWith(_10,this.$dr)||isc.endsWith(_10,this.$dq))continue;if(!_2&&(_3[_10]||_11.advanced||_11.inapplicable||_11.hidden||(_11.visibility!=null&&_11.visibility=="internal")))
{_3[_10]=_10;continue}
if(!_6&&_11.type==_1)return _10;if(_6&&_6.isA(_11.type)){_12=isc.DS.getInheritanceDistance(_11.type,_1);if(_8==null||_12<_7){_8=_10;_7=_12}}}
if(_8!=null){if(_7==0||!this.hasSuperDS()){return _8}else{var _13=this.superDS().getObjectField(_1,_2,_3);if(_13){var _14=this.getField(_13).type,_15=isc.DS.getInheritanceDistance(_14,_1)}
return(_13&&(_15<_7))?_13:_8}}else if(this.hasSuperDS()){return this.superDS().getObjectField(_1,_2,_3)}
return null}
);isc.evalBoundary;isc.B.push(isc.A.getLocalPrimaryKeyFields=function(){if(!this.primaryKeys){this.primaryKeys={};var _1=this.getFields();for(var _2 in _1){var _3=_1[_2];if(_3.primaryKey){this.primaryKeys[_2]=_3}}}
return this.primaryKeys}
,isc.A.filterPrimaryKeyFields=function(_1){var _2=this.getPrimaryKeyFields();return isc.applyMask(_1,isc.getKeys(_2))}
,isc.A.filterDSFields=function(_1){var _2=this.getFields();return isc.applyMask(_1,isc.getKeys(_2))}
,isc.A.recordHasAllKeys=function(_1){var _2=this.getPrimaryKeyFields();for(var _3 in _2){if(_1[_3]==null)return false}
return true}
,isc.A.getForeignKeysByRelation=function(_1,_2){var _3=this.getForeignKeyFields(_2);if(!_3)return{};var _4={};for(var _5 in _3){var _6=_3[_5];var _7=isc.DataSource.getForeignFieldName(_6);var _8=_1[_7];if(_8||_8===0)_4[_5]=_8}
return _4}
,isc.A.getPrimaryKeyFields=function(){if(!this.mergedPrimaryKeys){this.mergedPrimaryKeys={};if(this.hasSuperDS()){isc.addProperties(this.mergedPrimaryKeys,this.superDS().getPrimaryKeyFields())}
isc.addProperties(this.mergedPrimaryKeys,this.getLocalPrimaryKeyFields())}
return this.mergedPrimaryKeys}
,isc.A.getForeignKeyFields=function(_1){if(isc.isA.DataSource(_1))_1=_1.ID;var _2=this.getFields();if(!_2)return null;var _3={};for(var _4 in _2){var _5=_2[_4];if(_5.foreignKey){if(_1){var _6=isc.DataSource.getForeignDSName(_5,(_1||this));if(_6!=_1)continue}
_3[_5.name]=_5}}
return _3}
,isc.A.getLocalPrimaryKeyFieldNames=function(){var _1=this.getLocalPrimaryKeyFields();var _2=[];for(var _3 in _1){_2.add(_3)}
return _2}
,isc.A.getPrimaryKeyFieldNames=function(){return isc.getKeys(this.getPrimaryKeyFields())}
,isc.A.getPrimaryKeyField=function(){var _1=this.getPrimaryKeyFields();for(var _2 in _1){return _1[_2]}}
,isc.A.getPrimaryKeyFieldName=function(){return this.getPrimaryKeyFieldNames()[0]}
,isc.A.addChildDataSource=function(_1){var _2=this.$38m=(this.$38m||[]);_2.add(_1)}
,isc.A.getChildDataSources=function(){return this.$38m}
,isc.A.getChildDataSource=function(_1){var _2=this.getChildDataSources();if(_2==null)return null;var _3;for(var i=0;i<_2.length;i++){if(!_2[i]||(_1&&_2[i]==this))continue;if(!_3){_3=_2[i]}else if(_3!=_2[i]){this.logInfo("getChildDatasource(): This DataSource has multiple child "+"DataSources defined making getChildDataSource() ambiguous. Returning the "+"first child dataSource only - call getChildDataSources() to retrieve a "+"complete list.");break}}
return _3}
,isc.A.getTreeRelationship=function(_1,_2){if(isc.isA.String(_1))_1=this.getSchema(_1);var _3=this.getFields();if(_2==null){for(var _4 in _3){var _5=_3[_4];if(_5.foreignKey!=null){_2=_4;break}}}
var _6;if(_2==null&&_1){_2=_6=isc.getKeys(this.fields).intersect(isc.getKeys(_1.fields))[0];this.logWarn("matched tree relationship field by name: "+_2)}
var _7;if(_2)_7=_3[_2];if(_7==null){this.logDebug("getTreeRelationship(): Unable to find foreignKeyField."+"foreignKeyFieldName specified as:"+_2)}
if(!_1){if(!_7)_1=this;else{var _8=isc.DataSource.getForeignDSName(_7,this);_1=this.getSchema(_8)}}
if(!_6)_6=_7?isc.DataSource.getForeignFieldName(_7):null;if(_6==null){var _9=_1.getPrimaryKeyFieldNames();if(isc.isAn.Array(_9)){if(_9.length>1){this.logWarn("getTreeRelationship: dataSource '"+_1.ID+"' has multi-field primary key, which is not "+"supported for tree viewing.  Using field '"+_9[0]+"' as the only primary key field")}
_9=_9[0]}
_6=_9}
var _10;var _11;if(this.childrenField)_11=this.childrenField;for(_4 in _3){var _7=_3[_4];if(_7.isFolderProperty)_10=_4;if(_7.childrenProperty)_11=_4;if(_11==_4&&(_7.multiple==null)){_7.multiple=true}}
var _12={childDS:this,parentDS:_1,isFolderProperty:_10}
if(_2){_12.parentIdField=_2;_12.idField=_6}
if(_11)_12.childrenProperty=_11;if(_11==null&&_2==null){this.logInfo("getTreeRelationship(): No specified foreignKeyField or childrenProperty.")}
if(_1==this){var _13=_2?this.getField(_2).rootValue:null;if(_13==null)_12.rootValue=null;else _12.rootValue=_13}
return _12}
,isc.A.combineFieldOrders=function(_1,_2,_3){var _4=[];this.$38n(_2,0,_1,_4,_3);for(var _5 in _1){var _6=_1[_5],_7=_2.findIndex(this.$375,_5);if(_7!=-1){var _8=_2[_7],_9=this.combineFieldData(_8,true);if(_3==null||_3(_9,this))_4.add(_9);this.$38n(_2,_7+1,_1,_4,_3)}else{if(_3==null||_3(_6,this)){_4.add(isc.addProperties({},_6))}}}
return _4}
,isc.A.$38n=function(_1,_2,_3,_4,_5){for(var i=_2;i<_1.length;i++){var _7=_1[i];if(_7.name!=null&&_3[_7.name]!=null)return;if(_5==null||!_5(_7,this))continue;isc.SimpleType.addTypeDefaults(_7);_4.add(_7)}}
,isc.A.combineFieldData=function(_1){var _2=this.getField(_1.name);if(_2==null)return _1;for(var _3 in _2){if(_3=="validators"&&_1.validators!=null&&_2.validators!=_1.validators)
{for(var i=0;i<_2.validators.length;i++){var _5=_2.validators[i];if(!_1.validators.contains(_5)){if(_1.validators.$69){_1.validators=_1.validators.duplicate()}
_1.validators.add(_5)}}
continue}
if(_1[_3]!=null)continue;_1[_3]=_2[_3]}
return _1}
,isc.A.$38l=function(_1){if(_1==null)_1=this.fields;for(var _2 in _1){var _3=_1[_2];if(_3&&_3.required==null&&_3.xmlRequired!=null&&_3.xmlNonEmpty!=null)
{_3.required=_3.xmlRequired&&_3.xmlNonEmpty}
if(_3&&(_3.childrenProperty||_3.name==this.childrenField)){if(!_3.type)_3.type=this.ID}
isc.SimpleType.addTypeDefaults(_3,this)}}
,isc.A.$63p=function(){if(!this.autoDeriveTitles)return;for(var _1 in this.fields){var _2=this.fields[_1];if(_2.title&&_2.title!="")continue;_3=_1.replace(/_/g," ");var _3=_3.replace(/^\s+|\s+$/g,"");if(_3==_3.toUpperCase()||_3==_3.toLowerCase()){_3=_3.toLowerCase();var _4=true;var _5="";for(var i=0;i<_3.length;i++){var _7=_3.substr(i,1);if(_4){_7=_7.toUpperCase();_4=false}
if(_7==' ')_4=true;_5=_5+_7}}else{_5=_3.substr(0,1).toUpperCase();var _8=_3.substr(0,1)==_3.substr(0,1).toUpperCase();var _9=false;for(var i=1;i<_3.length;i++){var _7=_3.substr(i,1);if(_9&&_7==_7.toLowerCase()){_9=false;_5=_5.substr(0,_5.length-1)+" "+_5.substr(_5.length-1)}
if(_8&&_7==_7.toUpperCase()){_9=true}
if(!_8&&_7==_7.toUpperCase()){_5=_5+" "}
_8=_7==_7.toUpperCase();_5=_5+_7}}
_2.title=_5}}
,isc.A.getType=function(_1){var _2=isc.SimpleType.getType(_1);if(_2!=null)return _2;if(this.types&&this.types[_1])return this.types[_1];return null}
,isc.A.fetchingClientOnlyData=function(_1){if(this.clientOnly)_1.clientOnly=true;if(this.$498){this.$498.add(_1);return true}
if(this.clientOnly&&!this.testData&&(this.testFileName||this.dataURL)){this.$498=[_1];var _2=this.dataURL||this.testFileName;var _3=this.getDataFormat(_1);if(_3=="iscServer")_3=_2.match(/\.xml$/i)?"xml":"json";var _4=this.getOperationBinding(_1);var _5=isc.DataSource.create({ID:this.ID+"$499",inheritsFrom:this.ID,dataURL:_2,dataFormat:_3,recordXPath:this.recordXPath,transformRequest:this.transformRequest,transformResponse:this.transformResponse,recordName:_4.recordName||this.ID,showPrompt:this.showPrompt});this.logInfo("clientOnly datasource performing one-time "+_3+" fetch via: "+_2);this.addProperties({transformRequest:isc.DataSource.getInstanceProperty("transformRequest"),transformResponse:isc.DataSource.getInstanceProperty("transformResponse")});var _6=this;_5.sendDSRequest({operationType:"fetch",callback:function(_9,_10){if(_9.status!=isc.DSResponse.STATUS_SUCCESS){_6.logWarn("one-time fetch failed with status: "+_9.status+" and messsage: "+(_10?_10:"N/A")+".  Initializing an empty Array as testData.");_6.testData=[]}else{_6.logInfo("One-time fetch complete: "+(_10?_10.length:"null")+" records");_6.testData=_6.initializeSequenceFields(_10)}
var _7=_6.$498;delete _6.$498;for(var i=0;i<_7.length;i++){_6.sendDSRequest(_7[i])}
_5.destroy()},willHandleError:true});return true}}
,isc.A.getClientOnlyResult=function(_1){var _2=_1.$374;var _3=this.testData;if(!_3||isc.isA.String(_3)){if(isc.isA.String(_3)){this.logInfo(this.ID+" datasource: using testData property as data");this.testData=isc.eval(_3)}else if(window[this.ID+"TestData"]){this.logInfo(this.ID+" datasource: using "+this.ID+"TestData object as data");this.testData=window[this.ID+"TestData"]}else{this.logInfo(this.ID+" datasource: testData property and "+this.ID+"TestData object not found, using empty list as data");this.testData=[]}}
_3=this.testData;var _4=_2.operationType,_5={status:0};switch(_4){case"fetch":case"select":case"filter":var _6=_2.data;if(isc.isAn.Array(_6))_6=_6[0];var _7=this.applyFilter(_3,_6,_2),_8=_7;if(_2.startRow!=null){var _9=_2.startRow,_10=_2.endRow,_11=_7.length;var _12=_2.sortBy;if(_12){var _13=true;if(_12.startsWith("-")){_12=_12.substring(1);_13=false}
_7.sortByProperty(_12,_13)}
_10=Math.min(_10,_11-1);_8=_7.slice(_9,_10+1);_5.startRow=_9;_5.endRow=_10;_5.totalRows=_11}
if(this.copyLocalResults){for(var i=0;i<_8.length;i++){_8[i]=isc.addProperties({},_8[i])}}
_5.data=_8;break;case"remove":case"delete":var _15=this.findByKeys(_2.data,_3);if(_15==-1){this.logWarn("clientOnly remove operation: Unable to find record matching criteria:"+this.echo(_2.data))}else{_3.removeAt(_15);_5.data=isc.addProperties({},_2.data)}
break;case"add":case"insert":var _16=isc.addProperties({},_2.data);_16=this.applySequenceFields(_16);_3.add(_16);_5.data=isc.addProperties({},_16);break;case"replace":case"update":var _15=this.findByKeys(_2.data,_3);if(_15==-1){this.logWarn("clientOnly update operation: Unable to find record matching criteria:"+this.echo(_2.data))}else{var _16=_3[_15];isc.addProperties(_16,_2.data);_5.data=isc.addProperties({},_16)}
break;case"validate":default:break}
return _5}
,isc.A.getNextSequenceValue=function(_1){var _2=this.testData,_3=0;for(var i=0;i<_2.length;i++){var _5=_2[i][_1.name];if(_5!=null&&_5>_3)_3=_5}
return _3+1}
,isc.A.applySequenceFields=function(_1){if(!this.clientOnly){return}
var _2=this.getFields();for(var _3 in _2){var _4=_2[_3];if((_4.type=="sequence"||_4.primaryKey)&&_1[_3]==null){_1[_3]=this.getNextSequenceValue(_4)}}
return _1}
,isc.A.initializeSequenceFields=function(_1){if(!isc.isAn.Array(_1))return;var _2=this.getFields();var _3=[];for(var _4 in _2){if(_2[_4].type=="sequence"||_2[_4].primaryKey)_3.add(_4)}
for(var i=0;i<_1.length;i++){for(var j=0;j<_3.length;j++){var _4=_3[j];if(_1[i][_4]==null)_1[i][_4]=i}}
return _1}
,isc.A.findByKeys=function(_1,_2,_3,_4){return _2.findByKeys(_1,this,_3,_4)}
,isc.A.applyFilter=function(_1,_2,_3){var _4=[];if(!_1||_1.length==0)return _4;if(_2&&_2._constructor=="AdvancedCriteria"){return this.recordsMatchingAdvancedFilter(_1,_2,_3)}
return this.recordsMatchingFilter(_1,_2,_3)}
,isc.A.recordsMatchingFilter=function(_1,_2,_3){var _4=isc.getKeys(_2),_5=_4.length,_6=[],_7,_8,_9,_10,_11,j;for(var i=0,l=_1.length;i<l;i++){_7=_1[i];if(_7==null)continue;_8=true;for(j=0;j<_5;j++){_9=_4[j];if(_9==null)continue;if(this.dropUnknownCriteria&&!this.getField(_9))continue;_10=_7[_9];_11=_2[_9];if(!this.fieldMatchesFilter(_10,_11,_3)){_8=false;break}}
if(_8)_6.add(_7)}
return _6}
,isc.A.recordMatchesFilter=function(_1,_2,_3){return this.recordsMatchingFilter([_1],_2,_3).length>0}
,isc.A.fieldMatchesFilter=function(_1,_2,_3){if(isc.isAn.Array(_2)){if(_2.contains(_1))return true;return false}
if(isc.isA.Date(_1)&&isc.isA.Date(_2)){return(Date.compareDates(_1,_2)==0)}
if(!isc.isA.String(_1)&&!isc.isA.String(_2)){if(this.logIsDebugEnabled()){this.logDebug("Direct compare: "+_1+"=="+_2)}
return(_1==_2)}
if(_2==null)_2=isc.emptyString;if(_1==null)_1=isc.emptyString;if(!isc.isA.String(_1))_1=_1.toString();if(!isc.isA.String(_2))_2=_2.toString();if(!this.filterIsCaseSensitive){_1=_1.toLocaleLowerCase();_2=_2.toLocaleLowerCase()}
var _4;if(_3)_4=_3.textMatchStyle;if(!this.supportsTextMatchStyle(_4)){if(!this.$63c)this.$63c={};if(!this.$63c[_4]){this.logWarn("Text match style specified as '"+_4+"': This is not supported for"+" this dataSource - performing a substring match instead");this.$63c[_4]=true}
_4=this.getTextMatchStyle(_4)}
if(_4==this.$45y){return isc.startsWith(_1,_2)}else if(_4==this.$19q){return isc.contains(_1,_2)}else{return _1==_2}}
,isc.A.supportsTextMatchStyle=function(_1){if(!this.clientOnly&&(this.dataFormat!=this.$50j))return true;if(_1==this.$45y&&!this.clientOnly)return false;return(_1==null||_1==this.$19q||_1==this.$50i)}
,isc.A.getTextMatchStyle=function(_1){if(_1==null)_1=this.$50i;if(!this.supportsTextMatchStyle(_1)){_1=this.$19q}
return _1}
,isc.A.compareTextMatchStyle=function(_1,_2){_1=this.getTextMatchStyle(_1);_2=this.getTextMatchStyle(_2);if(_1==_2)return 0;if(_1==this.$50i)return 1;if(_2==this.$50i)return-1;if(_1==this.$45y)return 1;return-1}
,isc.A.compareCriteria=function(_1,_2,_3,_4){if(this.logIsInfoEnabled()){this.logInfo("Comparing criteria, oldCriteria:\n"+this.echo(_2)+"\nnewCriteria:\n"+this.echo(_1)+", policy: "+(_4||this.criteriaPolicy))}
if(_2==null)return-1;var _5=this.getTextMatchStyle(_3?_3.textMatchStyle:null);if(_1._constructor=="AdvancedCriteria"){if(_2&&_2._constructor=="AdvancedCriteria"){return this.compareAdvancedCriteria(_1,_2,_3,_4)}
if(_2==null)return 1;var j=0;for(var i in _2)j++;if(j==0)return 1;_2=this.convertCriteria(_2,_5);return this.compareAdvancedCriteria(_1,_2,_3,_4)}else{if(_2&&_2._constructor=="AdvancedCriteria"){_1=this.convertCriteria(_1,_5);return this.compareAdvancedCriteria(_1,_2,_3,_4)}}
_4=_4||this.criteriaPolicy;if(_4=="dropOnShortening"){if(_5==this.$50i){return this.dropOnFieldChange(_1,_2,_3)}else{return this.dropOnShortening(_1,_2,_3)}}else{return this.dropOnChange(_1,_2,_3)}}
,isc.A.dropOnChange=function(_1,_2,_3){if(isc.getKeys(_2).length!=isc.getKeys(_1).length)return-1;for(var _4 in _2){var _5=_2[_4],_6=_1[_4];if(isc.isAn.Array(_5)){if(!isc.isAn.Array(_6))return-1;if(_5.length!=_6.length)return-1;if(_5.intersect(_6).length!=_5.length)
{return-1}}else if(isc.isA.Date(_5)&&isc.isA.Date(_6))
{if(_5.getTime()!=_6.getTime())return-1}else if(_5!=_6){return-1}}
return 0}
,isc.A.dropOnFieldChange=function(_1,_2,_3){var _4=isc.getKeys(_1),_5=isc.getKeys(_2),_6=_4.length-_5.length;if(_6<0)return-1;for(var _7 in _2){var _8=_2[_7],_9=_1[_7];if(_9==null)return-1;if(isc.isAn.Array(_8)){if(!isc.isAn.Array(_9))return-1;if(_8.length!=_9.length)return-1;if(_8.intersect(_9).length!=_8.length)
{return-1}}else if(isc.isA.Date(_8)&&isc.isA.Date(_9))
{if(_8.getTime()!=_9.getTime())return-1}else if(_8!=_9){return-1}}
if(_6>0){_4.removeList(_5);for(var i=0;i<_4.length;i++){if(this.getField(_4[i])==null)return-1}
return 1}
return 0}
,isc.A.dropOnShortening=function(_1,_2,_3){var _4=isc.getKeys(_1),_5=isc.getKeys(_2),_6=_4.length-_5.length;if(_6<0)return-1;var _7=0;for(var _8 in _2){var _9=_2[_8],_10=_1[_8];if(_10==null)return-1;if(this.getField(_8)==null&&_9!=_10)
return-1;if(isc.isAn.Array(_9)){if(!isc.isAn.Array(_10))return-1;if(_9.length!=_10.length)return-1;if(_9.intersect(_10).length!=_9.length)
{return-1}}else if(isc.isA.String(_9)){if(!isc.isA.String(_10))return-1;if(_10.indexOf(_9)==-1)return-1;if(_9.length>_10.length)return-1;if(_9.length<_10.length)_7=1}else if(isc.isA.Date(_9)&&isc.isA.Date(_10))
{if(_9.getTime()!=_10.getTime())return-1}else if(_9!=_10){return-1}}
if(_6>0){_4.removeList(_5);for(var i=0;i<_4.length;i++){if(this.getField(_4[i])==null)return-1}
return 1}
return _7}
);isc.B._maxIndex=isc.C+127;isc.A=isc.DataSource;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$628=0;isc.B.push(isc.A.addSearchOperator=function(_1){if(!_1||!_1.ID){isc.logWarn("Attempted to add null search operator, or operator with no ID");return}
if(!isc.DataSource.$57z)isc.DataSource.$57z=[];var _2=isc.DataSource.$57z;if(_2.containsProperty("ID",_1.ID)){isc.logWarn("Attempted to add existing operator "+_1.ID+" - replacing");var _3=_2.findIndex("ID",_1.ID);if(_3>=0)_2.removeAt(_3)}
isc.DataSource.$57z.add(_1)}
,isc.A.setTypeOperators=function(_1,_2){if(!_2)return;if(!isc.isAn.Array(_2))_2=[_2];if(!isc.DataSource.$570)isc.DataSource.$570={};isc.DataSource.$570[_1||"_all_"]=_2}
,isc.A.$625=function(){return this.$628++}
);isc.B._maxIndex=isc.C+3;isc.A=isc.DataSource.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.addSearchOperator=function(_1,_2){if(!_1||!_1.ID){isc.logWarn("Attempted to add null search operator, or operator with no ID");return}
if(!isc.DataSource.$57z[_1.ID]){isc.DataSource.addSearchOperator(_1)}
if(!this.$570)this.$570={$58d:true};if(_2){for(var _3=0;_3<this.$570.length;_3++){this.$570[_3].remove(_1.ID)}
for(var _3=0;_3<_2.length;_3++){if(!this.$570[_2[_3]]){this.$570[_2[_3]]=[_1.ID]}
if(!this.$570[_2[_3]].contains(_1.ID)){this.$570[_2[_3]].add(_1.ID)}}}else{if(!this.$570["_all_"]){this.$570["_all_"]=[_1.ID]}
if(!this.$570["_all_"].contains(_1.ID)){this.$570["_all_"].add(_1.ID)}}}
,isc.A.getSearchOperator=function(_1){return isc.DataSource.$57z.find("ID",_1)}
,isc.A.getTypeOperators=function(_1){var _2=[];_1=_1||"text";var _3=isc.SimpleType.getType(_1);var _4=_3;if(this.$570){while(_4&&!this.$570[_4.name]){_4=isc.SimpleType.getType(_4.inheritsFrom,this)}
if(_4&&this.$570[_4.name]){_2=this.$570[_4.name]}
_2.addList(this.$570["_all_"]);if(!this.$570.$58d){return _2}}
_4=isc.SimpleType.getType(_1);while(_4&&!isc.DataSource.$570[_4.name]){_4=isc.SimpleType.getType(_4.inheritsFrom,this)}
if(_4&&isc.DataSource.$570[_4.name]){_2.addList(isc.DataSource.$570[_4.name])}
_2.addList(isc.DataSource.$570["_all_"]);return _2}
,isc.A.setTypeOperators=function(_1,_2){if(!_2)return;if(!isc.isAn.Array(_2))_2=[_2];if(!this.$570){this.$570={}}else{this.$570.$58d=false}
this.$570[_1||"_all_"]=_2;this.$570.$58d=false}
,isc.A.getFieldOperators=function(_1){if(isc.isA.String(_1))_1=this.getField(_1);if(_1&&_1.validOperators)return _1.validOperators;if(_1)return this.getTypeOperators(_1.type||"text");return[]}
,isc.A.getFieldOperatorMap=function(_1,_2,_3,_4){if(isc.isA.String(_1))_1=this.getField(_1);var _5={},_6=this.getFieldOperators(_1);for(var _7=0;_7<_6.length;_7++){var _8=this.getSearchOperator(_6[_7]);if(_8&&(!_8.hidden||_2)){if(!_3||(_8.valueType==_3)==!_4)
_5[_6[_7]]=_8.titleProperty==null?_8.title:isc.Operators[_8.titleProperty]}}
return _5}
,isc.A.getTypeOperatorMap=function(_1,_2,_3,_4){var _5={},_6=this.getTypeOperators(_1);for(var _7=0;_7<_6.length;_7++){var _8=this.getSearchOperator(_6[_7]);if(_8&&(!_8.hidden||_2)){if(!_3||(_8.valueType==_3)==!_4)
_5[_6[_7]]=_8.titleProperty==null?_8.title:isc.Operators[_8.titleProperty]}}
return _5}
);isc.B._maxIndex=isc.C+7;isc.A=isc.DataSource.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.evaluateCriterion=function(_1,_2){if(_2.requiresServer==true)return true;var _3=this.getSearchOperator(_2.operator);if(_3==null){isc.logWarn("Attempted to use unknown operator "+_2.operator);return false}
if(_2.fieldName){var _4=this.getFieldOperators(_2.fieldName);if(!_4.contains(_3.ID)){isc.logWarn("Operator "+_3.ID+" is not valid for field "+_2.fieldName+". Continuing anyway.")}}
return _3.condition(_2.value,_1,_2.fieldName,_2,_3,this)}
,isc.A.recordsMatchingAdvancedFilter=function(_1,_2,_3){var _4=[];this.$59u=false;this.$59v=_2.strictSQLFiltering;for(var _5=0;_5<_1.length;_5++){if(this.evaluateCriterion(_1[_5],_2)){_4.add(_1[_5])}}
return _4}
,isc.A.compareAdvancedCriteria=function(_1,_2,_3,_4){var _5=this.getSearchOperator(_2.operator);if(_5!=this.getSearchOperator(_1.operator)){return-1}
return _5.compareCriteria(_1,_2,_5,this)}
,isc.A.convertCriteria=function(_1,_2){var _3={_constructor:"AdvancedCriteria",operator:"and"}
var _4=[];for(var _5 in _1){if(_2=="equals")var _6="equals"
else _6="iContains";if(isc.isA.Array(_1[_5])){var _7={_constructor:"AdvancedCriteria",operator:"or",criteria:[]}
for(var i=0;i<_1[_5].length;i++){_7.criteria.add({fieldName:_5,operator:_6,value:_1[_5][i]})}
_4.add(_7)}else{_4.add({fieldName:_5,operator:_6,value:_1[_5]})}}
_3.criteria=_4;return _3}
);isc.B._maxIndex=isc.C+4;isc.$571=function(){var _1=function(_57,_58,_59,_60,_61,_62){var _2;if(!_60.criteria){_60.criteria=[]}
if(!isc.isAn.Array(_60.criteria)){isc.logWarn("AdvancedCriteria: found boolean operator where subcriteria was not "+"an array.  Subcriteria was: "+isc.Comm.serialize(_60.criteria));return false}
if(_61.isNot)_62.$59u=!_62.$59u;for(var _3=0;_3<_60.criteria.length;_3++){var _4=_62.evaluateCriterion(_58,_60.criteria[_3]);if(_61.isAnd&&!_4)_2=false;if(_61.isNot&&_4)_2=false;if(_61.isOr&&_4)_2=true;if(_2!=null)break}
if(_2==null){if(_61.isOr)_2=false;else _2=true}
if(_61.isNot)_62.$59u=!_62.$59u;return _2};var _5=function(_57,_58,_59,_60,_61,_62){if(_62.$59v){if(_58[_59]==null||_57==null)return _62.$59u}
var _6=(_57==_58[_59]);if(isc.isA.Date(_57)&&isc.isA.Date(_58[_59])){_6=(Date.compareDates(_57,_58[_59])==0)}
if(_61.negate)return!_6;else return _6};var _7=function(_57,_58,_59,_60,_61,_62){var _8=_57,_9=_57,_10=_58[_59];if(_60.start)_8=_60.start;if(_60.end)_9=_60.end;if(_62.$59v){if(_10==null||(_61.lowerBounds&&_8==null)||(_61.upperBounds&&_9==null)){return _62.$59u}}
var _11=true;var _12=true;var _13=isc.isA.Date(_58[_59]);var _14=isc.isA.Number(_58[_59]);if(_61.lowerBounds&&_8&&((_14&&isNaN(_8))||(_8&&_13&&(!isc.isA.Date(_8))))){return false}
if(_61.upperBounds&&_9&&((_14&&isNaN(_9))||(_8&&_13&&(!isc.isA.Date(_9))))){return false}
var _15;if(_8===null||_8===_15){_11=false}
if(_9===null||_9===_15){_12=false}
if(_13&&!isc.isA.Date(_8))_11=false;if(_13&&!isc.isA.Date(_9))_12=false;_13=isc.isA.Date(_8)||isc.isA.Date(_9);_14=isc.isA.Number(_8)||isc.isA.Number(_9);_10=_58[_59];if(_10===null||_10===_15){if(_13)_10=new Date(-8640000000000000);else if(_14)_10=Number.MIN_VALUE;else _10=""}else{if(_14&&isNaN(_10)){_8=""+_8;_9=""+_9}
if(_13&&!isc.isA.Date(_10)){return false}}
if(_61.lowerBounds&&_11){if(_61.inclusive){if(_10<_8)return false}else{if(_10<=_8)return false}}
if(_61.upperBounds&&_12){if(_61.inclusive){if(_10>_9)return false}else{if(_10>=_9)return false}}
return true};var _16=function(_57,_58,_59,_60,_61,_62){var _10=_58[_59],_17=_57;if(!isc.isA.String(_10)){return _61.negate}
if(_10==null)return _62.$59v?_62.$59u:_61.negate;if(_17==null)_17="";if(isc.isA.Number(_17))_17=""+_17;if(!isc.isA.String(_17)||!isc.isA.String(_10))return _61.negate;if(_61.caseInsensitive){_10=_10.toLowerCase();_17=_17.toLowerCase()}
if(_61.startsWith)var _18=isc.startsWith(_10,_17);else if(_61.endsWith)_18=isc.endsWith(_10,_17);else _18=isc.contains(_10,_17);if(_61.negate)return!_18;else return _18};var _19=function(_57,_58,_59,_60,_61){var _20=(_58[_59]==null);if(_61.negate)return!_20;else return _20};var _21=function(_57,_58,_59,_60,_61){var _22;var _15;if(_57===_15)return false;if(isc.isA.Date(_57)||isc.isA.Date(_58[_59]))return false;if(_61.caseInsensitive)_22=new RegExp(_57,"i");else _22=new RegExp(_57);return _22.test(_58[_59])};var _23=function(_57,_58,_59,_60,_61,_62){if(_57==null)_57=[]
else if(!isc.isAn.Array(_57))_57=[_57];if(!isc.isA.Date(_58[_59])){var _24=_57.contains(_58[_59])}else{_24=false;for(var i=0;i<_57.length;i++){if(isc.isA.Date(_57[i])&&Date.compareDates(_57[i],_58[_59])==0){_24=true;break}}}
if(_61.negate)return!_24;else return _24};var _26=function(_57,_58,_59,_60,_61,_62){if(_57==null)return true;var _27=(_58[_57]==_58[_59]);if(isc.isA.Date(_58[_57])&&isc.isA.Date(_58[_59])){_27=(Date.compareDates(_58[_57],_58[_59])==0)}
if(_61.negate)return!_27;else return _27};var _28=function(_57,_58,_59,_60){if(!_58.criteria)_58.criteria=[];if(!isc.isAn.Array(_58.criteria)){isc.logWarn("AdvancedCriteria: boolean compareCriteria found "+"where old subcriteria was not an array");return-1}
if(!_57.criteria)_57.criteria=[];if(!isc.isAn.Array(_57.criteria)){isc.logWarn("AdvancedCriteria: boolean compareCriteria found "+"where new subcriteria was not an array");return-1}
var _29,_30=0,_31=_58.criteria.length,_32=_57.criteria.length;if(_32>_31&&_59.isOr){return-1}
var _33=isc.clone(_58.criteria);var _34=isc.clone(_57.criteria);for(var i=0;i<_31;i++){var _35=_33[i];var _36=i>_32?null:_34[i];if(!_36||(_36&&_36.fieldName!=_35.fieldName||_36.operator!=_35.operator||_36.processed==true)){_36=null;for(var j=0;j<_32;j++){if(_34[j].processed)continue;if(_34[j].fieldName==_35.fieldName&&_34[j].operator==_35.operator){_36=_34[j];break}}}
if(_36&&_35){_36.processed=true;_29=_60.compareAdvancedCriteria(_36,_35)}else{if(_35&&!_36){if(_59.isOr)_29=1;if(_59.isAnd)_29=-1;if(_59.isNot)_29=-1}}
if(_59.isAnd&&_29==-1)return-1;if(_59.isOr&&_29==-1)return-1;if(_59.isNot&&_29==1)return-1;if(_29!=0)_30=1}
for(var i=0;i<_32;i++){if(!_34[i].processed){if(_59.isOr)return-1;if(_59.isAnd)return 1;if(_59.isNot)return-1}}
return _30};var _38=function(_57,_58,_59){if(_57.fieldName==_58.fieldName){var _6=(_57.value==_58.value);if(isc.isA.Date(_57.value)&&isc.isA.Date(_58.value)){_6=(Date.compareDates(_57.value,_58.value)==0)}
if(_6){return 0}else{return-1}}else{return-1}};var _39=function(_57,_58,_59){if(_57.fieldName==_58.fieldName){if(_59.upperBounds&&_59.lowerBounds){if((_57.start==_58.start)||(isc.isA.Date(_57.start)&&isc.isA.Date(_58.start)&&Date.compareDates(_57.start,_58.start)==0)){if((_57.end==_58.end)||(isc.isA.Date(_57.end)&&isc.isA.Date(_58.end)&&Date.compareDates(_57.end,_58.end)==0)){return 0}}}else{if((_57.value==_58.value)||(isc.isA.Date(_57.value)&&isc.isA.Date(_58.value)&&Date.compareDates(_57.value,_58.value)==0)){return 0}}
var _40=_57.start==null?_57.value:_57.start,_41=_58.start==null?_58.value:_58.start,_42=_57.start==null?_57.value:_57.end,_43=_58.start==null?_58.value:_58.end;var _13,_44;var _45=true,_46=true,_47=true,_48=true;if(_41==null)_45=false;if(_43==null)_46=false;if(_40==null)_47=false;if(_42==null)_48=false;if(_59.lowerBounds&&!_59.upperBounds&&!_47&&!_45){return 0}
if(_59.lowerBounds&&!_59.upperBounds&&(_40>_41||(_47&&!_45))){return 1}
if(_59.upperBounds&&!_59.lowerBounds&&!_48&&!_46){return 0}
if(_59.upperBounds&&!_59.lowerBounds&&(_42<_43||(_48&&!_46))){return 1}
if(_59.lowerBounds&&_59.upperBounds){if(_40>=_41&&_40<=_43&&_42<=_43&&_42>=_41){return 1}
if((_47&&!_45)||(_48&&!_46)){return 1}
if(!_47&&!_45&&!_48&&!_45){return 0}}}
return-1};var _49=function(_57,_58,_59){var _50=_58.value;var _51=_57.value;if(isc.isA.Number(_50))_50=""+_50;if(isc.isA.Number(_51))_51=""+_51;if(!isc.isA.String(_50)||!isc.isA.String(_51))return-1;if(_59.caseInsensitive){_50=_50.toLowerCase();_51=_51.toLowerCase()}
if(_57.fieldName==_58.fieldName&&_57.value==_58.value){return 0}
if(_59.startsWith&&!_59.negate&&_51.length>_50.length&&_51.startsWith(_50)){return 1}
if(_59.startsWith&&_59.negate&&_50.length>_51.length&&_50.startsWith(_51)){return 1}
if(_59.endsWith&&!_59.negate&&_51.length>_50.length&&_51.endsWith(_50)){return 1}
if(_59.endsWith&&_59.negate&&_50.length>_51.length&&_50.endsWith(_51)){return 1}
if(!_59.startsWith&&!_59.endsWith&&!_59.negate&&_51.length>_50.length&&_51.contains(_50)){return 1}
if(!_59.startsWith&&!_59.endsWith&&_59.negate&&_50.length>_51.length&&_50.contains(_51)){return 1}
return-1};var _52=function(_57,_58,_59){if(_57.fieldName==_58.fieldName)return 0;else return-1};var _53=function(_57,_58,_59){if(_57.value==_58.value&&_57.fieldName==_58.fieldName){return 0}else{return-1}};var _54=function(_57,_58,_59){if(_57.fieldName==_58.fieldName){if(!isc.isAn.Array(_58.value)||!isc.isAn.Array(_57.value)){return-1}
if(_57.value.equals(_58.value)){return 0}
if(!_59.negate&&_58.value.containsAll(_57.value)){return 1}
if(_59.negate&&_57.value.containsAll(_58.value)){return 1}}
return-1};var _55=function(_57,_58,_59){if(_57.value==_58.value&&_57.fieldName==_58.fieldName){return 0}else{return-1}};var _56=[{ID:"equals",titleProperty:"equalsTitle",negate:false,valueType:"fieldType",condition:_5,compareCriteria:_38},{ID:"notEqual",titleProperty:"notEqualTitle",negate:true,valueType:"fieldType",condition:_5,compareCriteria:_38},{ID:"greaterThan",titleProperty:"greaterThanTitle",lowerBounds:true,valueType:"fieldType",condition:_7,compareCriteria:_39},{ID:"lessThan",titleProperty:"lessThanTitle",upperBounds:true,valueType:"fieldType",condition:_7,compareCriteria:_39},{ID:"greaterOrEqual",titleProperty:"greaterOrEqualTitle",lowerBounds:true,inclusive:true,valueType:"fieldType",condition:_7,compareCriteria:_39},{ID:"lessOrEqual",titleProperty:"lessOrEqualTitle",upperBounds:true,inclusive:true,valueType:"fieldType",condition:_7,compareCriteria:_39},{ID:"between",titleProperty:"betweenTitle",lowerBounds:true,upperBounds:true,valueType:"valueRange",condition:_7,compareCriteria:_39},{ID:"betweenInclusive",titleProperty:"betweenInclusiveTitle",lowerBounds:true,upperBounds:true,hidden:true,valueType:"valueRange",inclusive:true,condition:_7,compareCriteria:_39},{ID:"iContains",titleProperty:"iContainsTitle",caseInsensitive:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"iStartsWith",titleProperty:"iStartsWithTitle",startsWith:true,caseInsensitive:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"iEndsWith",titleProperty:"iEndsWithTitle",endsWith:true,caseInsensitive:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"contains",titleProperty:"containsTitle",hidden:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"startsWith",titleProperty:"startsWithTitle",startsWith:true,hidden:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"endsWith",titleProperty:"endsWithTitle",endsWith:true,hidden:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"iNotContains",titleProperty:"iNotContainsTitle",caseInsensitive:true,negate:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"iNotStartsWith",titleProperty:"iNotStartsWithTitle",startsWith:true,caseInsensitive:true,negate:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"iNotEndsWith",titleProperty:"iNotEndsWithTitle",endsWith:true,caseInsensitive:true,negate:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"notContains",titleProperty:"notContainsTitle",negate:true,hidden:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"notStartsWith",titleProperty:"notStartsWithTitle",startsWith:true,negate:true,hidden:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"notEndsWith",titleProperty:"notEndsWithTitle",endsWith:true,negate:true,hidden:true,valueType:"fieldType",condition:_16,compareCriteria:_49},{ID:"isNull",titleProperty:"isNullTitle",valueType:"none",condition:_19,compareCriteria:_52},{ID:"notNull",titleProperty:"notNullTitle",negate:true,valueType:"none",condition:_19,compareCriteria:_52},{ID:"regexp",titleProperty:"regexpTitle",hidden:true,valueType:"custom",condition:_21,compareCriteria:_53},{ID:"iregexp",titleProperty:"iregexpTitle",hidden:true,caseInsensitive:true,valueType:"custom",condition:_21,compareCriteria:_53},{ID:"inSet",titleProperty:"inSetTitle",hidden:true,valueType:"valueSet",condition:_23,compareCriteria:_54},{ID:"notInSet",titleProperty:"notInSetTitle",negate:true,hidden:true,valueType:"valueSet",condition:_23,compareCriteria:_54},{ID:"equalsField",titleProperty:"equalsFieldTitle",valueType:"fieldName",condition:_26,compareCriteria:_55},{ID:"notEqualField",titleProperty:"notEqualFieldTitle",negate:true,valueType:"fieldName",condition:_26,compareCriteria:_55},{ID:"and",titleProperty:"andTitle",isAnd:true,valueType:"criteria",condition:_1,compareCriteria:_28},{ID:"not",titleProperty:"notTitle",isNot:true,valueType:"criteria",condition:_1,compareCriteria:_28},{ID:"or",titleProperty:"orTitle",isOr:true,valueType:"criteria",condition:_1,compareCriteria:_28}];for(var _3=0;_3<_56.length;_3++){isc.DataSource.addSearchOperator(_56[_3])}
isc.DataSource.setTypeOperators(null,["equals","notEqual","lessThan","greaterThan","lessOrEqual","greaterOrEqual","between","betweenInclusive","isNull","notNull","inSet","notInSet","equalsField","notEqualField","and","or","not"]);isc.DataSource.setTypeOperators("text",["regexp","iregexp","contains","startsWith","endsWith","iContains","iStartsWith","iEndsWith","notContains","notStartsWith","notEndsWith","iNotContains","iNotStartsWith","iNotEndsWith"])};isc.$571();isc.DataSource.create({ID:"Object",fields:{},addGlobalId:false});isc.DataSource.create({ID:"ValueMap",addGlobalId:false,builtinSchema:true,canBeArrayValued:true,fields:{},$cp:"ID",$450:"id",xmlToJS:function(_1,_2){if(_1==null||isc.xml.elementIsNil(_1))return null;var _3=isc.xml.getElementChildren(_1),_4=isc.xml.getAttributes(_1),_5=!isc.isAn.emptyObject(_4);for(var i=0;i<_3.length;i++){var _7=_3[i],_8=_1.getAttribute(this.$cp)||_1.getAttribute(this.$450),_9=isc.xml.getElementText(_7);if(_8!=null&&_9!=null){_5=true;_4[_8]=_9}else if(_8!=null){_4[_8]=_8}else if(_9!=null){_4[_9]=_9}else{_4[isc.emptyString]=isc.emptyString}}
if(_5)return _4;return isc.getValues(_4)},xmlSerializeFields:function(_1,_2,_3){if(_1==null||isc.DS.isSimpleTypeValue(_1)){return this.Super("xmlSerializeFields",arguments)}
var _4=isc.SB.create(),_3=(_3||"")+"    ";if(isc.isAn.Array(_1)){for(var i=0;i<_1.length;i++){var _6=_1[i];_4.append("\r",_3,"<value>",isc.makeXMLSafe(_6),"</value>")}}else{for(var _7 in _1){var _6=_1[_7];_4.append("\r",_3,"<value id=\"",isc.makeXMLSafe(_7),"\">",isc.makeXMLSafe(_6),"</value>")}}
return _4.toString()}});isc.ClassFactory.defineInterface("DataModel");isc.DataModel.addInterfaceMethods({getDataSource:function(){if(isc.isA.String(this.dataSource))this.dataSource=isc.DS.get(this.dataSource);return this.dataSource},getOperationId:function(_1){var _2=this.getOperation(_1);return _2==null?null:_2.ID},getOperation:function(_1){var _2=isc.rpc.getDefaultApplication(),_3,_4;var _5=_1+"Operation";if(this[_5]){_3=this[_5];if(isc.isAn.Object(_3))return _3;_4=_3}
if(_4==null){var _6=this.getDataSource();if(_6==null){this.logWarn("can't getOperation for type: "+_1+", no "+_5+" specified, and no dataSource to "+"create an auto-operation");return null}
this.logInfo("creating auto-operation for operationType: "+_1);_3=isc.DataSource.makeDefaultOperation(_6,_1);_4=_3.ID;this[_5]=_4}
return _3}});isc.defineClass("XJSONDataSource","DataSource");isc.A=isc.XJSONDataSource.getPrototype();isc.A.dataFormat="json";isc.A.dataTransport="scriptInclude";isc.defineClass("Schema","DataSource");isc.A=isc.Schema.getPrototype();isc.A.dataFormat="xml";isc.A.addGlobalId=false;isc.defineClass("WSDLMessage","Schema");isc.A=isc.WSDLMessage.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.getWSOperation=function(){var _1=this.getWebService();var _2=_1.operations.find("inputMessage",this.ID.substring(8));if(_2)return _2;return _1.operations.find("outputMessage",this.ID.substring(8))}
);isc.B._maxIndex=isc.C+1;isc.defineClass("XSElement","Schema");isc.defineClass("XSComplexType","Schema");isc.defineClass("SchemaSet").addMethods({init:function(){var _1=this.schemaNamespace,_2=isc.SchemaSet.schemaSets,_3=_2[_1];if(_3==null||((_3.schema==null&&_3.schema.length==0)&&(this.schema!=null&&this.schema.length!=0)))
{_2[_1]=this}
var _4=this.serviceNamespace;if(this.schema){this.$530={};this.$531={};for(var i=0;i<this.schema.length;i++){var _6=this.schema[i];_6.serviceNamespace=_4;_6.schemaNamespace=_1;if(_6.ID){if(isc.isAn.XSElement(_6)){this.$531[_6.ID]=_6}else{this.$530[_6.ID]=_6}}}}
isc.SchemaSet.$37r=this},getSchema:function(_1,_2){if(_2==isc.DS.$532)return this.$531[_1];if(_2==isc.DS.$45t)return this.$530[_1];return this.$530[_1]||this.$531[_1]}});isc.A=isc.SchemaSet;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.schemaSets={};isc.B.push(isc.A.get=function(_1){return this.schemaSets[_1]}
);isc.B._maxIndex=isc.C+1;isc.defineClass("WebService").addMethods({init:function(){var _1=this.serviceNamespace;if(this.messages){for(var i=0;i<this.messages.length;i++){this.messages[i].serviceNamespace=_1}}
this.logInfo("registered service with serviceNamespace: "+_1);isc.WebService.services[_1]=this;isc.WebService.$37r=this},getOperation:function(_1){if(isc.isAn.Object(_1))return _1;return this.operations.find("name",_1)},getOperationNames:function(){return this.operations.getProperty("name")},getSchema:function(_1,_2){var _3=this.$38q;if(!_3){_3=this.$38q=[];var _4=this.schemaImport;if(_4){if(!isc.isAn.Array(_4))_4=[_4];var _5=_4.getProperty("namespace");for(var i=0;i<_5.length;i++){var _7=_5[i],_8=isc.SchemaSet.get(_7);if(_8==null){this.logWarn("Could not find SchemaSet for schemaNamespace: '"+_7+"', schema imported via 'xs:import' must "+"be separately loaded via loadXMLSchema")}
_3.add(_8)}}}
for(var i=0;i<_3.length;i++){var _9=_3[i].getSchema(_1,_2);if(_9)return _9}
return isc.DS.get(_1,null,null,_2)},getRequestMessage:function(_1){var _2=this.getOperation(_1);return this.messages.find("ID","message:"+_2.inputMessage)},getResponseMessage:function(_1){var _2=this.getOperation(_1);return this.messages.find("ID","message:"+_2.outputMessage)},getBodyPartNames:function(_1,_2){var _3=this.getOperation(_1),_4=_2?_3.outputParts:_3.inputParts;if(_4==null||isc.isAn.emptyString(_4)){var _5=_2?this.getResponseMessage(_1):this.getRequestMessage(_1);return _5.getFieldNames()}else{return _4.split(" ")}},globalNamespaces:{xsi:"http://www.w3.org/2001/XMLSchema-instance",xsd:"http://www.w3.org/2001/XMLSchema"},callOperation:function(_1,_2,_3,_4,_5){var _6=this.getOperation(_1);if(_6==null){this.logWarn("No such operation: "+_1);return}
_5=_5||isc.emptyObject;var _7=isc.addProperties({actionURL:this.getDataURL(_1),httpMethod:"POST",contentType:"text/xml",data:_2,serviceNamespace:this.serviceNamespace,wsOperation:_1},_5);_7.headerData=_5.headerData||this.getHeaderData(_7);_7.httpHeaders=isc.addProperties({},_5.httpHeaders,{SOAPAction:_6.soapAction||'""'});_7.data=this.getSoapMessage(_7);_7.clientContext={$38r:_4,$38s:_1,$38u:_3,$38v:_5.xmlResult};if(this.spoofResponses){var _8=this.getSampleResponse(_1);if(this.logIsDebugEnabled("xmlBinding")){this.logDebug("spoofed response:\n"+_8,"xmlBinding")}
this.delayCall("$38w",[isc.xml.parseXML(_8),_8,{status:0,clientContext:_7.clientContext,httpResponseCode:200,httpResponseText:_8},_7]);return}
_7.callback={target:this,methodName:"$38w"};isc.xml.getXMLResponse(_7)},$38w:function(_1,_2,_3,_4){var _5=_4.clientContext,_6=_5.$38s,_7=_5.$38u;_1.addNamespaces(this.getOutputNamespaces(_6));var _8=_7!=null&&_7.contains("/"),_9=(_8?_7:null),_10;if(_8){_10=_1.selectNodes(_9)}else if(_7){_10=this.selectByType(_1,_6,_7)}else{_10=_1.selectNodes("//s:Body/*",{s:"http://schemas.xmlsoap.org/soap/envelope/"});if(_10.length==1)_10=_10[0]}
if(_5.$38v){this.fireCallback(_5.$38r,"data,xmlDoc,rpcResponse,wsRequest",[_10,_1,_3,_4]);return}
var _11;if(_8){_11=null}else if(_7){_11=this.getSchema(_5.$38u)}else{var _12=this.getSchema("message:"+this.getOperation(_6).outputMessage);if(this.getSoapStyle(_6)!="document"){_11=_12}else{var _13=_12.getFieldNames().first();_11=_12.getSchema(_12.getField(_13).type)}}
_10=isc.xml.toJS(_10,null,_11);this.fireCallback(_5.$38r,"data,xmlDoc,rpcResponse,wsRequest",[_10,_1,_3,_4])},getOutputNamespaces:function(_1,_2){var _3=this.getDefaultOutputDS(_1);return isc.addProperties({"default":_3.schemaNamespace||this.serviceNamespace,schema:_3.schemaNamespace,service:this.serviceNamespace},_2)},getDataURL:function(_1){var _2=this.getOperation(_1);if(_2&&_2.dataURL)return _2.dataURL;return this.dataURL},getMessageSerializer:function(_1,_2){var _3=_2?this.getResponseMessage(_1):this.getRequestMessage(_1);if(_3==null){this.logWarn("no "+(_2?"response":"request")+" message definition found for operation: '"+_1);return}
if(this.getSoapStyle(_1)!="document")return _3;var _4=_3.getFieldNames();if(_4.length==1&&_3.fieldIsComplexType(_4[0])){var _5=_3.getField(_4[0]);_3=_3.getSchema(_5.type,_5.xsElementRef?"element":null);if(_3==null){this.logWarn("can't find schema: "+_5.type+", part of "+(_2?"response":"request")+" message for operation '"+_1+"'")}}
return _3},getSoapMessage:function(_1,_2){_1.serviceNamespace=_1.serviceNamespace||this.serviceNamespace;var _3=_1.wsOperation;if(this.getOperation(_3)==null){this.logWarn("no such operation: '"+_3+"' in service: "+this.serviceNamespace);return""}
var _4=this.getMessageSerializer(_1.wsOperation,_2&&_2.generateResponse);if(_4==null)return"";return _4.getXMLRequestBody(_1,_2)},getSampleResponse:function(_1,_2,_3,_4){return this.getSoapMessage({wsOperation:_1,data:_2||{}},isc.addProperties({spoofData:true,generateResponse:!_4},_3))},getSampleRequest:function(_1,_2,_3){return this.getSampleResponse(_1,_2,_3,true)},getSoapStyle:function(_1){return this.getOperation(_1).soapStyle||this.soapStyle},getInputDS:function(_1){return this.getMessageSerializer(_1)},getHeaderSchema:function(_1,_2){var _3=this.getOperation(_1),_4=_2?_3.inputHeaders:_3.outputHeaders;if(!_4)return null;var _5={};for(var i=0;i<_4.length;i++){var _7=_4[i].part,_8=this.getSchema("message:"+_4[i].message);var _9=_8.getField(_7);if(_9==null){_9=isc.getValues(_8.getFields()).find("partName",_7)}
_5[_7]=this.getSchema(_9.type)||_9}
return _5},getInputHeaderSchema:function(_1){return this.getHeaderSchema(_1,true)},getOutputHeaderSchema:function(_1){return this.getHeaderSchema(_1,false)},getHeaderData:function(_1){},selectByType:function(_1,_2,_3){var _4=this.getOperation(_2),_5=this.getSchema("message:"+_4.outputMessage),_6=this.getSchema(_3);var _7=_5.findTagOfType(_6.ID),_8=_7[0],_9=_7[1],_10=_7[2],_11=_7[3],_12=_8.getField(_9);_9=_9||_6.ID;var _13=_6.mustQualify,_14=_6.schemaNamespace,_15="//"+(_13?"ns0:":"")+_9;if(_12&&_12.multiple)_15=_15+"/*";var _16=isc.xml.selectNodes(_1,_15,{ns0:_14});if(this.logIsDebugEnabled("xmlBinding")){this.logDebug("selecting type: '"+_6+"' within message '"+_4.outputMessage+" via XPath: "+_15+(_13?" using ns0: "+_6.schemaNamespace:"")+" got "+_16.length+" elements","xmlBinding")}
return _16},getDefaultOutputDS:function(_1){var _2=this.getResponseMessage(_1);var _3=_2.getFieldNames();if(_3.length==1&&_2.fieldIsComplexType(_3[0])){return _2.getSchema(_2.getField(_3[0]).type)}
return _2},getFetchDS:function(_1,_2,_3){if(_2==null)_2=this.getDefaultOutputDS(_1);_2=isc.isA.Object(_2)?_2.ID:_2;var _4=isc.DS.create({serviceNamespace:this.serviceNamespace,inheritsFrom:_2,operationBindings:[isc.addProperties({operationType:"fetch",wsOperation:_1,recordName:_2},_3)]});return _4},setLocation:function(_1,_2){if(_2)this.getOperation(_2).dataURL=_1;else this.dataURL=_1}});isc.A=isc.WebService;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.services={};isc.B.push(isc.A.get=function(_1){return this.services[_1]}
);isc.B._maxIndex=isc.C+1;isc.WebService.getPrototype().toString=function(){return"["+this.Class+" ns="+this.serviceNamespace+"]"};isc.ClassFactory.defineClass("RPCManager");isc.RPC=isc.rpc=isc.RPCManager;isc.Page.observe(isc,"goOffline","isc.rpc.goOffline()");isc.Page.observe(isc,"goOnline","isc.rpc.goOnline()");isc.ClassFactory.defineClass("RPCRequest");isc.A=isc.RPCRequest;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.create=function(_1,_2,_3,_4,_5,_6,_7,_8,_9,_10,_11,_12,_13){this.logWarn("An RPCRequest does not need to be created. Instead, pass properties to methods "+"such as RPCManager.send() and RPCManger.sendRequest.");return isc.addProperties({},_1,_2,_3,_4,_5,_6,_7,_8,_9,_10,_11,_12,_13)}
);isc.B._maxIndex=isc.C+1;isc.ClassFactory.defineClass("RPCResponse");isc.A=isc.RPCResponse;isc.A.errorCodes={STATUS_SUCCESS:0,STATUS_FAILURE:-1,STATUS_VALIDATION_ERROR:-4,STATUS_LOGIN_INCORRECT:-5,STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED:-6,STATUS_LOGIN_REQUIRED:-7,STATUS_LOGIN_SUCCESS:-8,STATUS_TRANSPORT_ERROR:-90,STATUS_SERVER_TIMEOUT:-100};isc.RPCResponse.addClassProperties(isc.RPCResponse.errorCodes)
isc.addGlobal("DSResponse",isc.RPCResponse);isc.A=isc.RPCManager;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.maxErrorMessageLength=1000;isc.A.maxLogMessageLength=25000;isc.A.defaultTimeout=240000;isc.A.defaultPrompt="Contacting server...";isc.A.timeoutErrorMessage="Operation timed out";isc.A.removeDataPrompt="Deleting record(s)...";isc.A.saveDataPrompt="Saving form...";isc.A.promptStyle="dialog";isc.A.useCursorTracker=isc.Browser.isSafari||(isc.Browser.isMoz&&isc.Browser.geckoVersion<20051111);isc.A.cursorTrackerConstructor="Img";isc.A.cursorTrackerDefaults={src:isc.Page.getSkinDir()+"/images/shared/progressCursorTracker.png",size:16,offsetX:12,offsetY:0,$38x:function(){this.setLeft(isc.EH.getX()+this.offsetX);this.setTop(isc.EH.getY()+this.offsetY)},initWidget:function(){this.Super("initWidget",arguments);this.$38x();this.$38y=isc.Page.setEvent("mouseMove",this.getID()+".$38x()");this.bringToFront()},destroy:function(){isc.Page.clearEvent("mouseMove",this.$38y);this.Super("destroy",arguments)}};isc.A.promptCursor=isc.Browser.isSafari||(isc.Browser.isMoz&&isc.Browser.geckoVersion<20051111)||(isc.Browser.isIE&&isc.Browser.minorVersion<=5.5)?"wait":"progress";isc.A.fetchDataPrompt="Finding records that match your criteria...";isc.A.getViewRecordsPrompt="Loading record...";isc.A.showPrompt=false;isc.A.neverShowPrompt=false;isc.A.actionURL="[ISOMORPHIC]/IDACall";isc.A.defaultTransport="xmlHttpRequest";isc.A.useHttpProxy=(!isc.Browser.isApollo);isc.A.dataEncoding="XML";isc.A.preserveTypes=true;isc.A.credentialsURL=isc.Page.getIsomorphicDir()+"login/loginSuccessMarker.html";isc.A.loginWindowSettings="WIDTH=550,HEIGHT=250";isc.A.maxLoginPageLength=1048576;isc.A.$38z=Array.create({addTrack:function(_1,_2){this.$451=_1;this.add(_1,_2);this.$451=null},setLastChanged:function(_1){this.$451=_1},clearLastChanged:function(){this.$451=null},getLastChanged:function(){return this.$451}});isc.A.$452=0;isc.A.$410=[];isc.B.push(isc.A.getTransactions=function(){return this.$38z}
);isc.B._maxIndex=isc.C+1;isc.A=isc.RPCManager;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$380=0;isc.A.onLine=!isc.isOffline();isc.A.loginStatusCodeMarker="<SCRIPT>//'\"]]>>isc_";isc.A.loginRequiredMarker="<SCRIPT>//'\"]]>>isc_loginRequired";isc.A.loginSuccessMarker="<SCRIPT>//'\"]]>>isc_loginSuccess";isc.A.maxLoginAttemptsExceededMarker="<SCRIPT>//'\"]]>>isc_maxLoginAttemptsExceeded";isc.B.push(isc.A.xmlHttpRequestAvailable=function(){if(isc.Browser.isIE)return(isc.Comm.createXMLHttpRequest()!=null);return true}
,isc.A.getActionURL=function(){return isc.Page.getURL(this.actionURL)}
,isc.A.send=function(_1,_2,_3){var _4=(_3||{});isc.addProperties(_4,{data:_1,callback:_2});return this.sendRequest(_4)}
,isc.A.$383=function(_1){if(this.xmlHttpRequestAvailable()||!this.logIsWarnEnabled())return false;var _2="Feature "+_1+" requires the xmlHttpRequest transport"+" which is not currently available because ActiveX is disabled."+" Please see the 'Features requiring ActiveX or Native support'"+" topic in the client-side reference under Client Reference/System"+" for more information.";this.logWarn(_2);return true}
,isc.A.sendProxied=function(_1,_2){_1.serverOutputAsString=true;_1.sendNoQueue=true;var _3=_1.actionURL||isc.RPCManager.actionURL;var _4=(_1.useHttpProxy!=null?_1.useHttpProxy:(isc.RPCManager.useHttpProxy&&_3.startsWith("http")&&!this.isLocalURL(_3)));if(!_4)
{if(!_2)_1.useSimpleHttp=true}else{_1=isc.addProperties({},_1,{actionURL:isc.XMLTools.httpProxyURL,isProxied:true,useSimpleHttp:true,proxiedURL:_3,params:{data:isc.Comm.xmlSerialize("data",{url:_3,httpMethod:_1.httpMethod,params:_1.params,contentType:_1.contentType,requestBody:_1.data,httpHeaders:_1.httpHeaders,uploadFileName:_1.uploadFileName})},transport:"xmlHttpRequest",httpMethod:null,data:null,contentType:null})}
return isc.rpc.sendRequest(_1)}
,isc.A.$59w=function(_1){var _2=isc.Page.getProtocol(_1),_3=_1.indexOf("/",_2.length),_4=_1.substring(_2.length,_3),_5;var _6=_4.indexOf(":");if(_6!=-1){_5=_4.substring(_6+1);_4=_4.substring(0,_6)}
return[_4,_5]}
,isc.A.isLocalURL=function(_1){var _2=this.$59w(_1),_3=_2[0],_4=_2[1];return(_3=="localhost"||_3==this.getWindow().location.hostname)&&_4==this.getWindow().location.port}
,isc.A.sendRequest=function(_1){if(_1.canDropOnDelay&&this.delayingTransactions)return;_1=isc.addProperties({},_1);if(_1.suppressAutoDraw!==false)_1.suppressAutoDraw=true;_1.actionURL=isc.Page.getURL(_1.actionURL||_1.url||_1.URL||this.getActionURL());var _2=_1.transport;if(!_2){if(_1.useXmlHttpRequest!=null||this.useXmlHttpRequest!=null){if(_1.useXmlHttpRequest==null){if(this.useXmlHttpRequest!=null){_1.transport=this.useXmlHttpRequest?"xmlHttpRequest":"hiddenFrame"}else{_1.transport=this.defaultTransport}}else{_1.transport=_2=_1.useXmlHttpRequest?"xmlHttpRequest":"hiddenFrame"}}else{_1.transport=this.defaultTransport}}
this.checkTransportAvailable(_1,(_2!=null));if(_1.useSimpleHttp==null)_1.useSimpleHttp=_1.paramsOnly;isc.addDefaults(_1,{showPrompt:this.showPrompt,promptStyle:this.promptStyle,promptCursor:this.promptCursor,useCursorTracker:this.useCursorTracker,cursorTrackerConstructor:this.cursorTrackerConstructor});_1.cursorTrackerProperties=isc.addProperties({},this.cursorTrackerDefaults,this.cursorTrackerProperties,_1.cursorTrackerProperties);if(_1.cursorTrackerProperties==null)
_1.cursorTrackerProperties=this.cursorTrackerProperties;if(!_1.operation){_1.operation={ID:"custom",type:"rpc"}}
if(this.canQueueRequest(_1,(_2!=null))){if(!this.currentTransaction)this.currentTransaction=this.$385();this.$386(_1,this.currentTransaction);if(!this.queuing)return this.sendQueue();return _1}else{return this.sendNoQueue(_1)}}
,isc.A.checkTransportAvailable=function(_1,_2){var _3=this.xmlHttpRequestAvailable();var _4=_1.transport||this.defaultTransport;if(!_3){if(_4=="xmlHttpRequest"){if(_2){this.logWarn("RPC/DS request specifically requesting the xmlHttpRequest"+" transport, but xmlHttpRequest not currently available -"+" switching transport to hiddenFrame.")}else{this.logWarn("RPCManager.defaultTransport specifies xmlHttpRequest, but"+" xmlHttpRequest not currently available - switching transport "+"to hiddenFrame.")}}
_1.transport="hiddenFrame"}}
,isc.A.canQueueRequest=function(_1,_2){if(_1.ignoreTimeout)_1.sendNoQueue=true;var _3=_1.transport;if(_1.containsCredentials){return false}
if(_1.sendNoQueue||_1.transport=="scriptInclude")return false;var _4=(this.currentTransaction&&this.currentTransaction.requestData.operations.length>0);if(_4&&(_1.actionURL!=this.currentTransaction.URL)){this.logWarn("RPCRequest specified (or defaulted to) URL: "+_1.actionURL+" which is different than the URL for which the RPCManager is currently queuing: "+this.currentTransaction.URL+" - sending this request to server and continuing to queue");return false}
if(_4&&(this.currentTransaction.transport!=_1.transport))
{this.logWarn("RPCRequest with conflicting transport while queuing, sending request to"+" server and continuing to queue.");return false}
return true}
,isc.A.sendNoQueue=function(_1){var _2=this.currentTransaction;this.currentTransaction=this.$385();this.$386(_1,this.currentTransaction);var _3=this.sendQueue();this.currentTransaction=_2;return _3}
,isc.A.$385=function(){var _1=this.$452++;var _2={timeout:this.defaultTimeout,transactionNum:_1,operations:[],responses:[],requestData:{transactionNum:_1,operations:[]},prompt:this.defaultPrompt,showPrompt:false,changed:function(){isc.RPCManager.$38z.setLastChanged(this);isc.RPCManager.$38z.dataChanged();isc.RPCManager.$38z.clearLastChanged()}}
this.$38z.addTrack(_2);this.$38z.clearLastChanged();return _2}
,isc.A.$386=function(_1,_2){_2.URL=_1.actionURL;if(_1.containsCredentials)_2.containsCredentials=true;if(_1.exportFilename)_2.URL+="/"+_1.exportFilename;if(!_2.download_filename)_2.download_filename=_1.download_filename;if(_1.downloadResult||_1.downloadToNewWindow){_2.download_filename=_1.download_filename;_2.URL+="/"+_1.download_filename;_2.ignoreError=true}
if(_1.prompt&&!_2.customPromptIsSet){this.logDebug("Grabbed prompt from first request that defined one: "+_1.prompt);_2.prompt=_1.prompt;_2.customPromptIsSet=true}
if(_1.showPrompt&&!_2.showPrompt&&!this.neverShowPrompt){_1.showedPrompt=true;isc.addProperties(_2,{showPrompt:true,promptStyle:_1.promptStyle,promptCursor:_1.promptCursor,useCursorTracker:_1.useCursorTracker,cursorTrackerConstructor:_1.cursorTrackerConstructor,cursorTrackerProperties:_1.cursorTrackerProperties})}
if(_1.isProxied){isc.addProperties(_2,{isProxied:true,proxiedURL:_1.proxiedURL})}
_2.transport=_1.transport;if(_1.ignoreReloginMarkers)_2.ignoreReloginMarkers=true;_2.operations.add(_1);var _3=_1.data;if(_3==null)_3="__ISC_NULL__";else if(_3==="")_3="__ISC_EMPTY_STRING__";if(!_1.clientOnly)_2.requestData.operations.add(_3);if(_2.omitNullMapValuesInResponse!==false&&_1.omitNullMapValuesInResponse!=null){_2.omitNullMapValuesInResponse=_2.requestData.omitNullMapValuesInResponse=_1.omitNullMapValuesInResponse}else{_2.omitNullMapValuesInResponse=false}
if(_1.ignoreTimeout)_2.$387=true;_1.transactionNum=_2.transactionNum;if(_1.timeout||_1.timeout===0)_2.timeout=_1.timeout;_2.changed()}
,isc.A.startQueue=function(_1){var _2=this.queuing;this.queuing=(_1==null?true:_1);return _2}
,isc.A.doShowPrompt=function(_1,_2){if(this.$380++!=0)return;if(_1.promptStyle=="dialog"&&_2!=null){isc.showPrompt(_2);this.$388=true}else{isc.EH.showClickMask(null,"hard",null,"blockingRPC");if(_1.useCursorTracker){this.$389=isc.ClassFactory.getClass(_1.cursorTrackerConstructor).create(_1.cursorTrackerProperties);this.$389.show()}else{isc.EH.$m8.setCursor(_1.promptCursor)}}}
,isc.A.doClearPrompt=function(_1){if(_1.clearedPrompt)return;_1.clearedPrompt=true;if(--this.$380!=0){if(this.$380<0)this.$380=0;return}
if(this.$388){isc.clearPrompt()}else{if(this.$389){this.$389.destroy();this.$389=null}else{isc.EH.$m8.setCursor(isc.Canvas.DEFAULT)}
isc.EH.hideClickMask("blockingRPC")}
this.$388=null}
,isc.A.cancelQueue=function(_1){if(_1==null){this.currentTransaction=null;return}
var _1=this.getTransaction(_1);if(_1==null)return;if(_1.showPrompt)this.doClearPrompt(_1);if(_1.transportRequest&&_1.transportRequest.abort){_1.transportRequest.abort()}
this.clearTransaction(_1)}
,isc.A.getTransaction=function(_1){if(_1==null)return null;if(_1.location&&_1.document){var _2=_1;var _3=isc.HiddenFrame.$h6;for(var i=0;i<_3.length;i++){if(_2==_3[i].getHandle()){_1=_3[i].transactionNum;break}}
if(_1==_2){this.logDebug("Can't find transactionNum in getTransaction from iframe");return null}}
if(isc.isA.Number(_1))return this.$38z.find({transactionNum:_1});return _1}
,isc.A.getCurrentTransaction=function(){return this.currentTransaction}
,isc.A.getLastSubmittedTransaction=function(){return this.$38z[this.$38z.length-1]}
,isc.A.clearTransaction=function(_1){_1=this.getTransaction(_1);this.clearTransactionTimeout(_1);if(!this.$453&&isc.Page.isLoaded()){var _2=isc.LogViewer.getGlobalLogCookie();this.setTrackRPC(_2?_2.trackRPC:false)}
_1.cleared=true;if(!this.$454)this.$38z.remove(_1);else _1.changed()}
,isc.A.setTrackRPC=function(_1){this.$454=_1;if(!_1)this.removeClearedRPC()}
,isc.A.removeClearedRPC=function(){var _1=this.$38z.findAll("cleared",true);if(_1)this.$38z.removeList(_1)}
,isc.A.delayAllPendingTransactions=function(){this.delayingTransactions=true;for(var i=0;i<this.$38z.length;i++){var _2=this.$38z[i];this.delayTransaction(_2)}}
,isc.A.suspendTransaction=function(_1){_1=this.getTransaction(_1);if(_1.suspended)return;_1.suspended=true;this.clearTransactionTimeout(_1);if(_1.showPrompt)this.doClearPrompt(_1);_1.changed()}
,isc.A.delayTransaction=function(_1){_1=this.getTransaction(_1);if(_1.delayed)return;_1.delayed=true;this.clearTransactionTimeout(_1);_1.changed()}
,isc.A.goOffline=function(){this.logInfo("Going offline...");this.onLine=false}
,isc.A.goOnline=function(){this.logInfo("Going online...");this.offlinePlayback=true;this.playbackNextOfflineTransaction()}
,isc.A.offlineTransactionPlaybackComplete=function(){}
,isc.A.playbackNextOfflineTransaction=function(){var _1=this.offlineTransactionLog?this.offlineTransactionLog.removeAt(0):null;if(_1==null){this.logInfo("Offline transaction playback complete");this.offlinePlayback=false;this.onLine=!isc.isOffline();this.offlineTransactionPlaybackComplete();return}
this.resubmitTransaction(_1)}
,isc.A.offlineTransaction=function(_1){if(_1.offline)return;_1=this.getTransaction(_1);_1.offline=true;this.clearTransactionTimeout(_1);if(!this.offlineTransactionLog){this.offlineTransactionLog=[];this.offlineTransactionLog.sortByProperty("timestamp",Array.ASCENDING)}
this.offlineTransactionLog.add(_1);_1.changed();var _2=_1.operations;for(var i=0;i<_2.length;i++){var _4=_2[i];var _5=this.createRPCResponse(_1,_4,{httpResponseCode:200,offlineResponse:true});this.delayCall("fireReplyCallbacks",[_4,_5],0)}}
,isc.A.resendTransaction=function(_1){this.resendTransactionsFlagged(_1,"suspended")}
,isc.A.resendDelayedTransactions=function(){this.delayingTransactions=false;this.resendTransactionsFlagged(null,"delayed")}
,isc.A.resendTransactionsFlagged=function(_1,_2){var _3=_1?[this.getTransaction(_1)]:this.$38z;for(var i=0;i<_3.length;i++){_1=_3[i];if(_1[_2]){delete _1[_2];this.resubmitTransaction(_1)}}}
,isc.A.getTransactionRequests=function(_1){return this.getTransaction(_1).operations}
,isc.A.$39a=function(_1){_1=this.getTransaction(_1);var _2=_1.timeout;if(!_2&&_2!==0)_2=this.defaultTimeout;if(_2==0)return;_1.timeoutTimer=isc.Timer.setTimeout("isc.RPCManager.$39b("+_1.transactionNum+")",_2)}
,isc.A.clearTransactionTimeout=function(_1){_1=this.getTransaction(_1)||this.getCurrentTransaction()||this.getLastSubmittedTransaction();if(!_1)return;isc.Timer.clear(_1.timeoutTimer)}
,isc.A.$39b=function(_1){_1=this.getTransaction(_1);if(_1.$387){this.clearTransaction(_1);return}
if(!this.onLine){this.offlineTransaction(_1);return}
_1.results=this.$39c(_1,{data:isc.RPCManager.timeoutErrorMessage,status:isc.RPCResponse.STATUS_SERVER_TIMEOUT});this.$39d(_1.transactionNum)}
,isc.A.$39c=function(_1,_2){var _3=[];for(var i=0;i<_1.operations.length;i++)
_3[i]=isc.clone(_2);return _3}
,isc.A.resubmitTransaction=function(_1){_1=this.getTransaction(_1)||this.getLastSubmittedTransaction();_1.status=null;var _2=this.currentTransaction;this.currentTransaction=_1;if(_1!=null){this.logInfo("Resubmitting transaction number: "+_1.transactionNum);delete _1.suspended;delete _1.clearedPrompt;this.sendQueue()}else{this.logWarn("No transaction to resubmit: transaction number "+_1+" does not exist")}
this.currentTransaction=_2}
,isc.A.retryOperation=function(_1){this.logDebug("Server-initiated operation retry for commFrameID: "+_1);var _2=window[_1];if(!_2){this.logError("comm operation retry failed - can't locate object: "+_1);return}
_2.sendData()}
,isc.A.transactionAsGetRequest=function(_1,_2,_3){_1=this.getTransaction(_1)||this.getCurrentTransaction();_2=(_2||_1.URL||this.getActionURL());if(!_3)_3={};_3._transaction=this.serializeTransaction(_1);return this.addParamsToURL(this.markURLAsRPC(_2),_3)}
,isc.A.encodeParameter=function(_1,_2){if(isc.isA.Date(_2)){isc.Comm.xmlSchemaMode=true;_2=_2.toSchemaDate();isc.Comm.xmlSchemaMode=null}else if(isc.isA.Array(_2)){var _3=isc.SB.create();for(var i=0;i<_2.length;i++){_3.append(this.encodeParameter(_1,_2[i]));if(i<_2.length-1)_3.append("&")}
return _3.toString()}if(!isc.isA.String(_2)){_2=isc.Comm.serialize(_2)}
return isc.SB.concat(encodeURIComponent(_1),"=",encodeURIComponent(_2))}
,isc.A.addParamsToURL=function(_1,_2){var _3=_1;if(!_2)return _1;for(var _4 in _2){var _5=_2[_4];_3+=_3.contains("?")?"&":"?";_3+=this.encodeParameter(_4,_5)}
return _3}
,isc.A.serializeTransaction=function(_1){var _2;if(this.dataEncoding=="JS"){isc.Comm.$ev=true;_2=isc.Comm.serialize(_1.requestData);isc.Comm.$ev=null}else{_2=isc.Comm.xmlSerialize("transaction",_1.requestData)}
return _2}
,isc.A.markURLAsRPC=function(_1){if(!_1.contains("isc_rpc="))_1+=(_1.contains("?")?"&":"?")+"isc_rpc=1&isc_v="+isc.versionNumber;return _1}
,isc.A.markURLAsXmlHttp=function(_1){if(!_1.contains("isc_xhr="))_1+=(_1.contains("?")?"&":"?")+"isc_xhr=1";return _1}
,isc.A.addDocumentDomain=function(_1){if(!_1.contains("isc_dd="))_1+=(_1.contains("?")?"&":"?")+"isc_dd="+document.domain;return _1}
,isc.A.sendQueue=function(_1,_2,_3){var _4=this.currentTransaction;this.currentTransaction=null;this.queuing=false;if(!_4){this.logWarn("sendQueue called with no current queue, ignoring");return false}
var _5=_4.operations[0];if(!isc.Page.isLoaded()){if(!this.delayingTransactions)isc.Page.setEvent("load",this,isc.Page.FIRE_ONCE,"resendDelayedTransactions");this.delayingTransactions=true}
if(this.delayingTransactions){this.delayTransaction(_4);return _5}
_4.timestamp=new Date().getTime();if(!this.onLine&&!this.offlinePlayback){this.offlineTransaction(_4);return _5}
var _6=true;for(var i=0;i<_4.operations.length;i++){if(!_4.operations[i].clientOnly){_6=false;break}}
if(_6){_4.allClientOnly=true;this.delayCall("$39d",[_4.transactionNum],0);return _5}
_3=_4.URL=isc.Page.getURL(_3||_4.URL||this.getActionURL());if(!_5.useSimpleHttp&&_4.transport!="scriptInclude"){_3=this.markURLAsRPC(_3);if(_4.transport=="xmlHttpRequest")_3=this.markURLAsXmlHttp(_3);if(document.domain!=location.hostname)_3=this.addDocumentDomain(_3);_3=this.addParamsToURL(_3,{isc_tnum:_4.transactionNum})}
_2=_4.prompt=((_4.showPrompt==null||_4.showPrompt)?(_2||_4.prompt||this.defaultPrompt):null);if(_2)this.doShowPrompt(_4,_2);var _8={};var _9=false;for(var i=0;i<_4.operations.length;i++){var _10=_4.operations[i];var _11=_10.params;var _12=_10.queryParams;var _13=_11;if(_12&&isc.isAn.Object(_12)){_3=_4.URL=this.addParamsToURL(_3,_12)}
if(_11&&_9)
this.logWarn("Multiple RPCRequests with params attribute in one transaction - merging");if(_11){if(isc.isA.String(_11)){if(window[_11])_11=window[_11];else if(isc.Canvas.getForm(_11))_11=isc.Canvas.getForm(_11);else{this.logWarn("RPCRequest: "+isc.Log.echo(_10)+" was passed a params value: "+_11+" which does not resolve to a component or a native"+" form - request to server will not include these params");_11=null}}
if(isc.isA.Class(_11)){if(_11.getValues)_11=_11.getValues();else{this.logWarn("RPCRequest: "+isc.Log.echo(_10)+" was passed an instance of class "+_11.getClassName()+" (or a global ID that resolved to this class)"+" - this class does not support the getValues() method - request to"+" server will not include these params")}}
if(_11&&!isc.isAn.Object(_11)){this.logWarn("params value: "+_13+" for RPCrequest: "+isc.Log.echo(_10)+" resolved to non-object: "+isc.Log.echo(_11)+" - request to server will not include these params");_11=null}
if(_11){isc.addProperties(_8,_11);_9=true}}}
if(this.logIsInfoEnabled()){this.logInfo("sendQueue["+_4.transactionNum+"]: "+_4.operations.length+" RPCRequest(s); transport: "+_4.transport+"; target: "+_3)}
_4.sendTime=isc.timeStamp();_4.changed();_4.callback="isc.RPCManager.performTransactionReply(transactionNum,results,wd)";if(_1)_4.$40c=_1;var _11=_8;var _14=_4.transport,_15="send"+(_14.substring(0,1).toUpperCase())+_14.substring(1);if(isc.Comm[_15]==null){this.logWarn("Attempt to send transaction with specified transport '"+_4.transport+"' failed - unsupported transaction type.");return}
this.$39a(_4);isc.RPCManager.$410.push(_4.transactionNum);_4.transactionRequest=isc.Comm[_15]({URL:_3,httpMethod:_5.httpMethod,contentType:_5.contentType,httpHeaders:_5.httpHeaders,bypassCache:_5.bypassCache,data:_5.useSimpleHttp?_5.data:null,fields:_11,target:_5.target,callbackParam:_5.callbackParam,transport:_4.transport,blocking:_5.blocking,useSimpleHttp:_5.useSimpleHttp,transactionNum:_4.transactionNum,transaction:_4});return _5}
,isc.A.performTransactionReply=function(_1,_2,_3){var _4=this.getTransaction(_1);if(!_4){this.logWarn("No such transaction "+_1);return false}
_4.receiveTime=isc.timeStamp();_4.changed();isc.RPCManager.$410.remove(_1);this.logInfo("transaction "+_1+" arrived after "+(_4.receiveTime-_4.sendTime)+"ms");if(_2==null){this.logFatal("No results for transaction "+_1);return false}
if(_4.transport=="xmlHttpRequest"){var _5=_2;_4.xmlHttpRequest=_5;_2=_5.responseText;var _6;try{_6=_5.status}catch(e){this.logWarn("Unable to access XHR.status - network cable unplugged?");_6=-1}
if(_6==1223)_6=204;if(_6==0&&(location.protocol=="file:"||location.protocol=="app-resource:"))
_6=200;_4.httpResponseCode=_6;_4.httpResponseText=_5.responseText;if(_6!=-1&&!_4.ignoreReloginMarkers&&this.processLoginStatusText(_5,_1))
{return}
if(_6!=-1&&this.responseRequiresLogin(_5,_1)){this.handleLoginRequired(_1);return}
if(_6!=-1&&this.responseIsRelogin(_5,_1)){this.handleLoginRequired(_1);return}
if(_6>299||_6<200){var _7=_4.URL;if(_4.isProxied){_7=_4.proxiedURL+" (via proxy: "+_7+")"}
_2=this.$39c(_4,{data:"Transport error - HTTP code: "+_6+" for URL: "+_7+(_6==302?" This error is likely the result"+" of a redirect to a server other than the origin"+" server or a redirect loop.":""),status:isc.RPCResponse.STATUS_TRANSPORT_ERROR});this.logDebug("RPC request to: "+_7+" returned with http response code: "+_6+". Response text:\n"+_5.responseText);_4.status=isc.RPCResponse.STATUS_TRANSPORT_ERROR}}
_4.results=_2;this.$39d(_1);return true}
,isc.A.responseIsRelogin=function(_1,_2){var _3=_1.status;if(document.domain!=location.hostname&&((_3==302&&this.treatRedirectAsRelogin)||(_3==0)||(_3==200&&_1.getAllResponseHeaders()==isc.emptyString&&_1.responseText==isc.emptyString)))
{this.logDebug("Detected document.domain 302 relogin condition - status: "+_3);return true}
return false}
,isc.A.processLoginStatusText=function(_1,_2){var _3=_1.responseText;if(_3&&_3.length<this.maxLoginPageLength){var _4=_3.indexOf(this.loginStatusCodeMarker);if(_4==-1)return false;if(_3.indexOf(this.loginRequiredMarker,_4)!=-1){this.handleLoginRequired(_2);return true}else if(_3.indexOf(this.loginSuccessMarker,_4)!=-1){this.handleLoginSuccess(_2);return true}else if(_3.indexOf(this.maxLoginAttemptsExceededMarker,_4)!=-1){this.handleMaxLoginAttemptsExceeded(_2);return true}}
return false}
,isc.A.processLoginStatusCode=function(_1,_2){if(_1.status==isc.RPCResponse.STATUS_LOGIN_REQUIRED){this.handleLoginRequired(_1.transactionNum);return true}else if(_1.status==isc.RPCResponse.STATUS_LOGIN_SUCCESS){this.handleLoginSuccess(_1.transactionNum);return true}else if(_1.status==isc.RPCResponse.STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED){this.handleMaxLoginAttemptsExceeded(_1.transactionNum);return true}
return false}
,isc.A.responseRequiresLogin=function(_1,_2){return false}
,isc.A.createRPCResponse=function(_1,_2,_3){return isc.addProperties({operationId:_2.operation.ID,clientContext:_2.clientContext,context:_2,transactionNum:_1.transactionNum,httpResponseCode:_1.httpResponseCode,httpResponseText:_1.httpResponseText,xmlHttpRequest:_1.xmlHttpRequest,transport:_1.transport,status:_1.status,clientOnly:_2.clientOnly},_3)}
,isc.A.$39d=function(_1){var _2=this.getTransaction(_1);this.clearTransactionTimeout(_1);if(!_2)return;if(this.logIsDebugEnabled()){this.logDebug("Result string for transaction "+_1+": "+isc.Log.echoAll(_2.results))}
if(_2.allClientOnly){_2.results={status:0}}else{}
var _3=_2.results;var _4=_2.operations,_5=[];for(var i=0,j=0;i<_4.length;i++){var _8=_4[i];var _9=isc.addProperties(this.createRPCResponse(_2,_8),{callbackArgs:_2.transport=="scriptInclude"?_3:null,results:_3});if(_9.status==null)_9.status=0;_5[i]=_9;_2.responses[i]=_9;_2.changed()}
var _10=0;while(_10<_4.length&&!_2.suspended){var _8=_4[_10],_9=_5[_10];this.performOperationReply(_8,_9);_10++}
if(_2.showPrompt)this.doClearPrompt(_2);if(!_2.suspended){this.clearTransaction(_1)}
if(_2.offline)this.playbackNextOfflineTransaction();if(_2.$40c){var _11=_8.application?_8.application:this.getDefaultApplication();if(isc.isA.String(_11))_11=window[_11];_11.fireCallback(_2.$40c,"responses",[_2.responses])}}
,isc.A.performOperationReply=function(_1,_2){var _3=_2.results,_4=_1.operation;if(this.logIsInfoEnabled()){this.logInfo("rpcResponse(unstructured) results -->"+isc.Log.echoAll(_3)+"<--")}
if(this.processLoginStatusCode(_2,_2.transactionNum))return;return this.fireReplyCallbacks(_1,_2)}
,isc.A.fireReplyCallback=function(_1,_2,_3,_4){var _5=_2.application?_2.application:this.getDefaultApplication();if(isc.isA.String(_5))_5=window[_5];var _6=_5.fireCallback(_1,"rpcResponse,data,rpcRequest",[_3,_4,_2]);return _6}
,isc.A.evalResult=function(_1,_2,_3){var _4=_1.evalVars;this.logDebug("evaling result"+(_4?" with evalVars: "+isc.Log.echo(_4):""));var _5=isc.Canvas.getInstanceProperty("autoDraw");if(_1.suppressAutoDraw)isc.Canvas.setInstanceProperty("autoDraw",false);var _6=isc.Class.evalWithVars(_3,_4);if(_1.suppressAutoDraw)isc.Canvas.setInstanceProperty("autoDraw",_5);return _6}
,isc.A.fireReplyCallbacks=function(_1,_2){var _3=_1.operation,_4=_2.results,_5=_1.evalResult&&_1.transport!="scriptInclude"?this.evalResult(_1,_2,_4):null;var _6;_6=(_1.evalResult?_5:_4);_2.data=_6;var _7=this.getTransaction(_2.transactionNum);var _8=_1.callback;if(_8!=null){this.fireReplyCallback(_8,_1,_2,_6)}}
,isc.A.$a0=function(_1,_2){if(_1.ignoreError)return;if(_2.dataSource){var _3=isc.DataSource.get(_2.dataSource);if(_3&&_3.handleError){var _4=_3.handleError(_1,_2);if(_4==false)return}}
this.handleError(_1,_2)}
,isc.A.handleError=function(_1,_2){var _3=(_1.context?_1.context:{}),_4;if(isc.isA.String(_1.data)){_4=_1.data;if(isc.isA.String(_4)){var _5=_4;if(_5.length>this.maxErrorMessageLength){var _6=_5.length-this.maxErrorMessageLength;_5=_5.substring(0,this.maxErrorMessageLength)+"<br><br>...("+_6+" bytes truncated - set"+" isc.RPCManager.maxErrorMessageLength > "+this.maxErrorMessageLength+" to see more or check the Developer Console for full error)..."}
isc.warn(_5.asHTML())}}else{var _7=isc.getKeyForValue(_1.status,isc.RPCResponse.errorCodes);if(isc.isA.String(_7)){if(_7.startsWith("STATUS_"))_7=_7.substring(7)}else{_7="number: "+(_1.status!=null?_1.status:"unknown")}
var _8=_1.operationId||_1.operationType;_4="Error performing "+(_8?"operation: '"+_8+"'":"rpcRequest")+": error: "+_7}
this.logWarn(_4+", response: "+this.echo(_1));return false}
,isc.A.handleLoginRequired=function(_1){if(this.$39j&&this.$39j==_1)return;var _2=this.getTransaction(_1);if(_2==null)return;_1=_2.transactionNum;this.clearTransactionTimeout(_2);var _3=_2.operations[0],_4=this.createRPCResponse(_2,_3);this.logInfo("loginRequired for transaction: "+_1+(_2.containsCredentials?", transaction containsCredentials":""));if(_2.containsCredentials){if(_3.callback){_4.status=isc.RPCResponse.STATUS_LOGIN_INCORRECT;this.fireReplyCallbacks(_3,_4);this.clearTransaction(_2);return}
this.clearTransaction(_2)}
this.suspendTransaction(_2);if(this.loginRequired){_4.status=isc.RPCResponse.STATUS_LOGIN_REQUIRED;this.loginRequired(_1,_3,_4);return}
var _5=this.addParamsToURL(this.credentialsURL,{ts:new Date().getTime()});this.$39j=window.open(_5,this.loginWindowSettings)}
,isc.A.handleLoginSuccess=function(_1){var _2=this.getTransaction(_1);if(_2&&_2.containsCredentials){this.clearTransactionTimeout(_2);var _3=_2.operations[0];if(_3.callback){var _4=this.createRPCResponse(_2,_3,{status:isc.RPCResponse.STATUS_SUCCESS});this.fireReplyCallbacks(_3,_4);this.clearTransaction(_2);return}
this.clearTransaction(_2)}
if(this.$39j)this.$39j.close();if(this.loginSuccess&&this.loginSuccess()===false)return;this.resendTransaction()}
,isc.A.handleMaxLoginAttemptsExceeded=function(_1){var _2=this.getTransaction(_1);if(_2&&_2.containsCredentials){this.clearTransactionTimeout(_2);var _3=_2.operations[0];if(_3.callback){var _4=this.createRPCResponse(_2,_3,{status:isc.RPCResponse.STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED});this.fireReplyCallbacks(_3,_4);this.clearTransaction(_2);return}
this.clearTransaction(_2)}
if(this.$39j)this.$39j.close();if(this.maxLoginAttemptsExceeded)this.maxLoginAttemptsExceeded();else{var _5="Max login attempts exceeded.";if(isc.warn)isc.warn(_5);else alert(_5)}}
);isc.B._maxIndex=isc.C+65;isc.RPCManager.rpc_logMessage=isc.RPCManager.logMessage;isc.RPCManager.logMessage=function(_1,_2,_3,_4){if(this.logIsEnabledFor(_1,_3)){if(isc.isA.String(_2)&&_2.length>this.maxLogMessageLength&&!this.logIsEnabledFor(_1,"RPCManagerResponse"))
{var _5=_2.length-this.maxLogMessageLength;_2=_2.substring(0,this.maxLogMessageLength)+"\n...("+_5+" bytes truncated).  Enable RPCManagerResponse log at same threshold to see full message."}}
this.rpc_logMessage(_1,_2,_3,_4)};isc.addGlobal("InstantDataApp",isc.RPCManager);isc.isA.InstantDataApp=isc.isA.RPCManager;isc.A=isc.InstantDataApp;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.addDefaultOperation=function(_1,_2,_3){if(!_1)_1={};_1.operation=isc.DataSource.makeDefaultOperation(_2,_3,_1.operation);return _1}
,isc.A.setDefaultApplication=function(_1){isc.InstantDataApp.defaultApplication=_1}
,isc.A.getDefaultApplication=function(){if(this.defaultApplication==null){this.create({ID:"builtinApplication",dataSources:[],operations:{},pointersToThis:[{object:this,property:"defaultApplication"}]})}
return this.defaultApplication}
,isc.A.app=function(){return this.getDefaultApplication()}
);isc.B._maxIndex=isc.C+4;isc.A=isc.InstantDataApp.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.init=function(){if(this.ID!="builtinApplication")isc.ClassFactory.addGlobalID(this);if(isc.rpc.defaultApplication==null||isc.rpc.defaultApplication.getID()=="builtinApplication")
{isc.rpc.setDefaultApplication(this)}}
);isc.B._maxIndex=isc.C+1;isc.defineClass("DMI").addClassProperties({actionURL:isc.RPCManager.actionURL,call:function(_1,_2,_3){var _4=[];for(var i=0;i<arguments.length;i++)_4[_4.length]=arguments[i];var _6={};if(isc.isAn.Object(_1)&&_4.length==1){var _7=isc.clone(_1);if(_7.requestParams){isc.addProperties(_6,_7.requestParams);delete _7.requestParams}
_6.callback=_7.callback;delete _7.callback;_6.data=_7}else{_6.data={appID:_1,className:_2,methodName:_3,arguments:_4.slice(3,_4.length-1)};_6.callback=_4[_4.length-1]}
_4=_6.data.arguments;if(!isc.isAn.Array(_4)){if(_4==null)_4=[];else _4=[_4]}
_6.data.arguments=_4;_6.data.is_ISC_RPC_DMI=true;if(this.addMetaDataToQueryString){if(!_6.queryParams)_6.queryParams={};isc.addProperties(_6.queryParams,{dmi_appID:_6.data.appID,dmi_class:_6.data.className,dmi_method:_6.data.methodName})}
return isc.RPCManager.sendRequest(_6)},callTemplate:"(function(){var x = function (firstArg) { "+"var isCall = ${isCall};"+"var obj = isc.addProperties({}, this.requestParams);"+"if(isc.isAn.Object(firstArg) && arguments.length == 1){"+"isc.addProperties(obj,{appID:'${appID}',className:'${className}',methodName:'${methodName}'},firstArg);"+"} else {"+"var args = [];for (var i = 0; i < arguments.length; i++) args[args.length] = arguments[i];"+"isc.addProperties(obj,{appID:'${appID}',className:'${className}',methodName:isCall?firstArg:'${methodName}',"+"arguments:args.slice(isCall ? 1 : 0,args.length-1),callback:args[args.length-1]});"+"}isc.DMI.call(obj);"+"};return x})()",bind:function(_1,_2,_3,_4){if(!isc.isAn.Array(_3))_3=[_3];var _5=isc.defineClass(_2).addProperties({requestParams:_4});var _6={appID:_1,className:_2,methodName:"firstArg",isCall:true};_5.call=isc.eval(this.callTemplate.evalDynamicString(this,_6));for(var i=0;i<_3.length;i++){var _8={appID:_1,className:_2,methodName:_3[i],isCall:false};_5[_3[i]]=isc.eval(this.callTemplate.evalDynamicString(this,_8))}
window[_2]=_5;return _5},makeDMIMethod:function(_1,_2,_3,_4){var _5={appID:_1,className:_2,isCall:_3,methodName:_3?"firstArg":_4};return isc.eval(this.callTemplate.evalDynamicString(this,_5))}});isc.DMI.callBuiltin=isc.DMI.makeDMIMethod("isc_builtin","builtin",true);isc.ClassFactory.defineClass("ResultSet",null,["List","DataModel"]);isc.A=isc.ResultSet;isc.A.UNKNOWN_LENGTH=1000;isc.A=isc.ResultSet.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.cachedRows=0;isc.A.fetchAhead=true;isc.A.resultSize=75;isc.A.fetchDelay=0;isc.A.useClientSorting=true;isc.A.useClientFiltering=true;isc.A.updateCacheFromRequest=true;isc.A.updatePartialCache=true;isc.B.push(isc.A.shouldUseClientSorting=function(){if(!isc.RPCManager.onLine)return true;return this.useClientSorting}
,isc.A.shouldUseClientFiltering=function(){if(!isc.RPCManager.onLine)return true;return this.useClientFiltering}
,isc.A.shouldNeverDropUpdatedRows=function(){if(!isc.RPCManager.onLine)return true;return this.neverDropUpdatedRows}
,isc.A.shouldUpdatePartialCache=function(){if(!isc.RPCManager.onLine)return true;return this.updatePartialCache}
);isc.B._maxIndex=isc.C+4;isc.A=isc.ResultSet.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$39r=0;isc.A.notifyOnUnchangedCache=false;isc.B.push(isc.A.init=function(){isc.ClassFactory.addGlobalID(this);if(this.operation!=null)this.fetchOperation=this.operation;var _1=this.getOperation("fetch");var _2=_1.dataSource;if(!isc.isAn.Array(_2))_2=[_2];for(var i=0;i<_2.length;i++){var _4=isc.DS.get(_2[i]);this.observe(_4,"dataChanged","observer.dataSourceDataChanged(dsRequest,dsResponse)");if(!this.$39s)this.$39s=[];this.$39s.add(_4);if(!this.dataSource)this.dataSource=_4}
var _5=this.context;this.resultSize=(_5&&_5.dataPageSize!=null?_5.dataPageSize:this.resultSize);if(this.dropCacheOnUpdate==null){this.dropCacheOnUpdate=this.$du(_1.dropCacheOnUpdate,this.getDataSource().dropCacheOnUpdate)}
this.context=this.context||{};this.criteria=this.criteria||this.filter||{};if(this.criteria){var _6=this.criteria;this.criteria=null;this.setCriteria(_6)}
if(this.fetchMode==null)this.fetchMode=(this.allRows?"local":"paged");if(this.allRows!=null&&(this.isLocal()||this.shouldUseClientFiltering())&&this.localData==null)
{this.filterLocalData()}
if(this.initialData){this.fillCacheData(this.initialData);this.setFullLength(this.initialLength||this.totalRows||this.initialData.length)}else if(this.isPaged()){this.localData=[]}
this.observe(isc,"goOffline",this.getID()+".goOffline()");this.observe(isc.RPCManager,"offlineTransactionPlaybackComplete",this.getID()+".offlinePlaybackComplete()")}
,isc.A.goOffline=function(){}
,isc.A.offlinePlaybackComplete=function(){if(this.haveOfflineRecords){this.invalidateCache();this.haveOfflineRecords=false}}
,isc.A.destroy=function(){if(window[this.ID]==this)window[this.ID]=null;this.ignore(isc,"goOffline");this.ignore(isc.RPCManager,"offlineTransactionPlaybackComplete");if(!this.$39s)return;for(var i=0;i<this.$39s.length;i++){var _2=this.$39s[i];if(_2){this.ignore(_2,"dataChanged")}}}
,isc.A.isPaged=function(){return this.fetchMode=="paged"}
,isc.A.isLocal=function(){return this.fetchMode=="local"}
,isc.A.allMatchingRowsCached=function(){return(this.localData!=null&&(!this.isPaged()||(this.allRows!=null||(this.cachedRows==this.totalRows))))}
,isc.A.allRowsCached=function(){return((this.allRows!=null&&(!this.allRowsCriteria||this.$505))||(this.allMatchingRowsCached()&&this.$39t))}
,isc.A.isEmpty=function(){if(this.isPaged()){if(this.allMatchingRowsCached()){return this.getLength()==0}else if(this.cachedRows>0)return false}
return!this.lengthIsKnown()||this.getLength()<=0}
,isc.A.canSortOnClient=function(){return this.shouldUseClientSorting()&&(this.allMatchingRowsCached()||isc.isOffline())}
,isc.A.canFilterOnClient=function(){return this.shouldUseClientFiltering()&&this.allRowsCached()}
,isc.A.getLength=function(){var _1=this.unknownLength||isc.ResultSet.UNKNOWN_LENGTH;if(!this.lengthIsKnown())return _1;return(this.isPaged()&&!this.allRows?this.totalRows:this.localData.length)}
,isc.A.indexOf=function(_1,_2,_3){if(this.localData==null)return-1;if(Array.isLoading(_1))return-1;var _4=this.localData.indexOf(_1,_2,_3);if(_4!=-1)return _4;return this.getDataSource().findByKeys(_1,this.localData,_2,_3)}
,isc.A.slideList=function(_1,_2){return}
,isc.A.get=function(_1){if(_1<0){this.logWarn("get: invalid index "+_1);return null}
if(this.localData!=null&&this.localData[_1]!=null)return this.localData[_1];if(this.fetchStartRow!=null&&_1>=this.fetchStartRow&&_1<=this.fetchEndRow){return Array.LOADING}
return this.getRange(_1,_1+1)[0]}
,isc.A.getRange=function(_1,_2,_3,_4){if(isc.$cv)arguments.$cw=this;if(_1==null){this.logWarn("getRange() called with no specified range - ignoring.");return}
if(_2==null)_2=_1+1;if(this.isPaged()){return this.$39u(_1,_2,_3,_4)}
if(this.localData==null){this.localData=[];var _5=this.getServerFilter();this.setRangeLoading(_1,_2);this.fetchRemoteData(_5)}
return this.localData.slice(_1,_2)}
,isc.A.getAllRows=function(){if(!this.lengthIsKnown())return[];return this.getRange(0,this.getLength())}
,isc.A.getAllLoadedRows=function(){if(!this.lengthIsKnown())return[];var _1=[];for(var i=0;i<this.getLength();i++){if(this.rowIsLoaded(i))_1.add(this.localData[i])}
return _1}
,isc.A.getFieldValue=function(_1,_2,_3){return this.getDataSource().getFieldValue(_1,_2,_3)}
,isc.A.lengthIsKnown=function(){return this.localData!=null&&(this.isPaged()?this.totalRows!=null:this.$39v==null)}
,isc.A.rowIsLoaded=function(_1){if(this.localData!=null){var _2=this.localData[_1];if(_2!=null&&!Array.isLoading(_2))return true}
return false}
,isc.A.rangeIsLoaded=function(_1,_2){if(this.localData==null)return false;for(var i=_1;i<_2;i++){var _4=this.localData[i];if(_4==null||Array.isLoading(_4))return false}
return true}
,isc.A.findLastCached=function(_1,_2){if(!this.rowIsLoaded(_1))return null;if(_2){for(var i=_1;i>=0;i--){var _4=this.localData[i];if(_4==null||Array.isLoading(_4))break}
return i+1}else{var _5=this.getLength();for(var i=_1;i<_5;i++){var _4=this.localData[i];if(_4==null||Array.isLoading(_4))break}
return i-1}}
,isc.A.getCachedRange=function(_1){if(_1==null)_1=this.lastRangeStart;if(_1==null)_1=0;if(!this.rowIsLoaded(_1))return null;var _2=this.getLength();if(this.allMatchingRowsCached())return[0,_2-1];var _3=this.findLastCached(_1,true),_4=this.findLastCached(_1);return[_3,_4]}
,isc.A.setRangeLoading=function(_1,_2){for(var i=_1;i<_2;i++){if(this.localData[i]==null)this.localData[i]=Array.LOADING}}
,isc.A.fillRangeLoading=function(_1,_2){for(var i=0;i<_2;i++){if(_1[i]==null)_1[i]=Array.LOADING}
return _1}
,isc.A.getServerFilter=function(){if(this.isLocal())return null;return this.criteria}
,isc.A.$39w=function(){var _1=this.fetchStartRow,_2=this.fetchEndRow;if(_1==null||_2==null)return;this.setRangeLoading(_1,_2);this.fetchStartRow=null;this.fetchEndRow=null;this.logInfo("fetching rows "+[_1,_2]+" from server");return this.fetchRemoteData(this.getServerFilter(),_1,_2)}
,isc.A.fetchRemoteData=function(_1,_2,_3){if(isc.isOffline()){this.haveOfflineRecords=true;return}
this.$39r+=1;var _4;if(this.context&&this.context.clientContext){this.context.clientContext.requestIndex=this.$39r}else{_4={requestIndex:this.$39r}}
var _5=isc.addProperties({operation:this.getOperationId("fetch"),startRow:_2,endRow:_3,sortBy:this.$39x,resultSet:this,clientContext:_4,willHandleError:true},this.context)
if(this.rowOrderInvalid()){this.logInfo("invalidating rows on fetch due to 'add'/'update' operation "+" with updatePartialCache");this.invalidateRows()}
if(this.logIsDebugEnabled("fetchTrace")){this.logWarn("ResultSet server fetch with server criteria: "+isc.Comm.serialize(_1,true)+this.getStackTrace())}
this.getDataSource().fetchData(_1,{caller:this,methodName:"fetchRemoteDataReply"},_5);if(!this.isPaged())this.$39v=this.$39r}
,isc.A.fetchRemoteDataReply=function(_1,_2,_3){var _4=_1.clientContext.requestIndex;if(!this.$39y)this.$39y=0;if(_4!=(this.$39y+1)){this.logInfo("server returned out-of-sequence response for fetch remote data request "+" - delaying processing: last processed:"+this.$39y+", returned:"+_4);if(!this.$39z)this.$39z=[];this.$39z.add({dsResponse:_1,data:_2,request:_3});return}
if(!this.isPaged()&&this.$39v==_4)delete this.$39v;var _5;if(_1.status<0||_1.offlineResponse){_5=[]}else{_5=_1.data}
var _6=_5.length;this.document=_1.document;this.logInfo("Received "+_6+" records from server");if(_1.startRow==null)_1.startRow=_3.startRow;if(_1.endRow==null)_1.endRow=_1.startRow+_6;if(_1.totalRows==null&&_1.endRow<_3.endRow)
_1.totalRows=_1.endRow;if(this.transformData){var _7=this.transformData(_5,_1);_5=_7!=null?_7:_5;if(_5.length!=_6){this.logInfo("Transform applied, "+_5.length+" records resulted, from "+_1.startRow+" to "+_1.endRow);_1.endRow=_1.startRow+_5.length}}
if(!isc.isA.List(_5)){this.logWarn("Bad data returned, ignoring: "+this.echo(_5));return}
if(_1.totalRows!=null&&_1.totalRows<_1.endRow){this.logWarn("fetchData callback: dsResponse.endRow set to:"+_1.endRow+". dsResponse.totalRows set to:"+_1.totalRows+". endRow cannot exceed total dataset size. "+"Clamping endRow to the end of the dataset ("+_1.totalRows+").");_1.endRow=_1.totalRows}
var _8=_1.startRow,_9=_1.endRow;this.$521();this.$390(_5,_1);this.$522(_8,_9);delete this.context.afterFlowCallback;this.$39y=_4;if(this.$39z&&this.$39z.length>0){for(var i=0;i<this.$39z.length;i++){var _11=this.$39z[i];if(_11==null)continue;var _12=_11.dsResponse.clientContext.requestIndex;if(_12==this.$39y+1){this.logInfo("Delayed out of sequence data response being processed now "+_12);this.$39z[i]=null;this.fetchRemoteDataReply(_11.dsResponse,_11.data,_11.request);break}}}
if(_1.status<0){isc.RPCManager.$a0(_1,_3)}}
,isc.A.$390=function(_1,_2){if(this.isLocal()){this.allRows=_1;this.filterLocalData();return}else if(!this.isPaged()){this.$ed();this.localData=_1;if(this.canSortOnClient()){this.$391()}
if(this.allRowsCached()){this.allRows=this.localData}
this.$ee();return}
var _3=_2.context;this.$ed()
if(this.dropCacheOnLengthChange&&this.lengthIsKnown()&&this.totalRows!=_2.totalRows)
{this.logInfo("totalRows changed from "+this.totalRows+" to "+_2.totalRows+", invalidating cache");this.$394()}
if(this.localData==null)this.localData=[];this.setFullLength(_2.totalRows);this.fillCacheData(_1,_2.startRow);var _4=this.localData;for(var i=_2.startRow+_1.length;i<this.totalRows;i++){if(Array.isLoading(_4[i]))_4[i]=null}
this.logInfo("cached "+_1.getLength()+" rows, from "+_2.startRow+" to "+_2.endRow+" ("+this.totalRows+" total rows, "+this.cachedRows+" cached)");if(this.allMatchingRowsCached()){if(this.allRowsCached()){this.logInfo("Cache for entire DataSource complete")}else{this.logInfo("Cache for current criteria complete")}
if(this.canSortOnClient())this.$391()}
this.$ee()}
,isc.A.setContext=function(_1){this.context=_1}
,isc.A.setCriteria=function(_1){var _2=this.allRowsCached();this.$39t=(isc.getKeys(_1).length==0);var _3=this.criteria||{},_4=this.$51w;if(_1!=null&&_1._constructor!="AdvancedCriteria"){_1=isc.clone(_1)}
this.criteria=_1;this.$51w=(this.context&&this.context.textMatchStyle)?this.context.textMatchStyle:null;var _5=this.compareTextMatchStyle(this.$51w,_4);if(_5>=0){if(_1._constructor=="AdvancedCriteria"&&_3._constructor!="AdvancedCriteria"){_3=this.getDataSource().convertCriteria(_3,this.$51w)}
if(_1._constructor!="AdvancedCriteria"&&_3._constructor=="AdvancedCriteria"){_1=this.getDataSource().convertCriteria(_1,this.$51w);this.criteria=_1}
var _6=this.compareCriteria(_1,this.allRowsCriteria?this.allRowsCriteria:_3,this.context);if(_6!=0)_5=_6}
if(_5==-1){if(this.isLocal()||(!this.allRowsCriteria&&this.allRows&&this.shouldUseClientFiltering()))
{if(this.allRows!=null)this.filterLocalData()}else{this.logInfo("setCriteria: filter criteria changed, invalidating cache");this.invalidateCache();this.allRowsCriteria=null;delete this.$505}
return true}else if(_5==1){if(this.allRowsCriteria){this.filterLocalData()}else if(this.shouldUseClientFiltering()&&this.allMatchingRowsCached()){this.allRows=this.localData;this.allRowsCriteria=_3;this.$505=(isc.getKeys(_3).length==0);this.filterLocalData()}else{this.logInfo("setCriteria: filter criteria changed, invalidating cache");this.invalidateCache()}
return true}else{if(this.allRowsCriteria&&this.compareCriteria(_1,_3)!=0){this.filterLocalData()}}
this.logInfo("setCriteria: filter criteria unchanged");return false}
,isc.A.setFilter=function(_1){return this.setCriteria(_1)}
,isc.A.getCriteria=function(){return this.criteria}
,isc.A.compareCriteria=function(_1,_2,_3,_4){return this.getDataSource().compareCriteria(_1,_2,_3?_3:this.context,_4?_4:this.criteriaPolicy)}
,isc.A.compareTextMatchStyle=function(_1,_2){return this.getDataSource().compareTextMatchStyle(_1,_2)}
,isc.A.willFetchData=function(_1,_2){var _3,_4;if(_2!==_3){_4=this.compareTextMatchStyle(_2,this.$51w);if(_4==-1)return true}
var _5=this.allRows?this.allRowsCriteria:this.criteria;_4=this.compareCriteria(_1,_5);if(_4==0)return false;if(!this.shouldUseClientFiltering())return true;if(!this.allMatchingRowsCached())return true;return(_4==-1)}
,isc.A.sortByProperty=function(_1,_2,_3,_4){if(_3==null){var _5=this.getDataSource().getField(_1);if(_5)_3=_5.type}
if(this.$395==_1&&this.$392==_2&&this.$393==_3)return;this.$395=_1;this.$392=_2;this.$393=_3;this.$45g=_4;if(this.isPaged()||!this.shouldUseClientSorting()){this.$39x=(this.$392?"":"-")+this.$395}
this.$391()}
,isc.A.unsort=function(){if(!this.allMatchingRowsCached())return false;this.$395=null;if(this.localData)this.localData.unsort();return true}
,isc.A.$391=function(){var _1=this.$395,_2=this.$392;if(this.localData==null||_1==null)return;if(this.canSortOnClient()){this.logInfo("sortByProperty("+_1+", "+_2+"): full cache allows local sort");if(_1!=null){this.localData.sortByProperty(_1,_2,this.$393,this.$45g);delete this.$572;delete this.$573;delete this.$574;delete this.$575;if(!this.$52z())this.dataChanged()}
return}
this.logInfo("sortByProperty("+_1+", "+_2+"): invalidating cache");this.invalidateCache()}
,isc.A.$521=function(){var _1;if(this.$523===_1)this.$523=0;this.$523++}
,isc.A.$522=function(_1,_2){if(--this.$523==0){if(this.dataArrived)this.dataArrived(_1,_2)}}
,isc.A.$524=function(){return(this.$523!=null&&this.$523>0)}
,isc.A.dataSourceDataChanged=function(_1,_2){if(this.disableCacheSync)return;if(this.logIsDebugEnabled())this.logDebug("dataSource data changed firing");var _3=isc.DataSource.getUpdatedData(_1,_2,this.updateCacheFromRequest);this.handleUpdate(_1.operationType,_3,_2.invalidateCache,_1)}
,isc.A.handleUpdate=function(_1,_2,_3,_4){if(isc.$cv)arguments.$cw=this;var _5=(this.allMatchingRowsCached()?", allMatchingRowsCached true":(", cached rows: "+this.cachedRows+", total rows: "+this.totalRows));if(this.dropCacheOnUpdate||_3||(_1!="remove"&&!this.allMatchingRowsCached()&&!this.shouldUpdatePartialCache()))
{this.invalidateCache();return}
this.logInfo("updating cache in place after operationType: "+_1+_5);this.$ed();if(!isc.isAn.Array(_2)||_2.length==1){this.$572=_1;this.$573=_2}
this.updateCache(_1,_2,_4);this.$ee()}
,isc.A.$ee=function(){var _1;if(!this.notifyOnUnchangedCache&&this.$573&&this.$575==null){_1=true}
var _2,_3,_4;if(!_1&&this.$573){_2=this.$572;_3=this.$574;_4=this.$575}
if(--this.$ef==0&&!_1){this.dataChanged(_2,_3,_4,this.$573);delete this.$572;delete this.$574;delete this.$575;delete this.$576;delete this.$573}}
,isc.A.updateCache=function(_1,_2,_3){if(_2==null)return;_1=isc.DS.$372(_1);if(!isc.isAn.Array(_2))_2=[_2];if(this.logIsInfoEnabled()){var _4=(_3.componentId?" submitted by '"+_3.componentId+"'":" (no compnentID) ");this.logInfo("Updating cache: operationType '"+_1+"'"+_4+","+_2.length+" rows update data"+(this.logIsDebugEnabled()?":\n"+this.echoAll(_2):""))}
switch(_1){case"remove":this.removeCacheData(_2,_3);break;case"add":this.addCacheData(_2,_3);break;case"replace":case"update":this.updateCacheData(_2,_3);break}
if(this.shouldUpdatePartialCache()&&_1!="remove"&&!this.allMatchingRowsCached())
{this.invalidateRowOrder()}
var _5=((_1=="remove")||(_1=="update"&&this.$576==null));if(this.allRows&&!this.shouldNeverDropUpdatedRows()){this.filterLocalData()}
var _6=this.$576||this.$574;if(!_5&&_6!=null){var _7=this.indexOf(_6);if(_7==-1){delete this.$575;delete this.$574}else{this.$575=_7}}}
,isc.A.updateCacheData=function(_1,_2){if(!isc.isAn.Array(_1))_1=[_1];var _3=this.allRows!=null,_4=_3?this.allRows:this.localData,_5=0,_6=0,_7=0;var _8=this.getDataSource().getPrimaryKeyFields();for(var i=0;i<_1.length;i++){var _10=_1[i],_11=isc.applyMask(_10,_8);var _12=this.getDataSource().findByKeys(_11,_4),_13;if(_12==-1){var _14=_2.data;if(isc.isAn.Array(_14))_14=_14[0];_14=isc.applyMask(_14,_8);var _15=this.getDataSource().findByKeys(_14,_4);if(_15!=-1){this.logWarn("Update operation - submitted record with primary key value[s]:"+this.echo(_14)+" returned with modified primary key:"+this.echo(_11)+". This may indicate bad server logic. Updating cache to reflect new primary key.");_6++;_4.removeAt(_15);delete this.$573}}else if(_1.length==1){_13=_4.get(_12);if(_3&&!this.getDataSource().recordMatchesFilter(_13,this.criteria,this.context))
{_13=null}
this.$574=_13;if(_13)this.$575=this.indexOf(_13)}
var _16=_3?this.allRowsCriteria:this.criteria,_17=this.getDataSource().recordMatchesFilter(_10,_16,this.context),_18=this.shouldNeverDropUpdatedRows();if(_12==-1&&_17){this.logInfo("updated row returned by server doesn't match any cached row, "+" adding as new row.  Primary key values: "+this.echo(_11)+", complete row: "+this.echo(_10));_7++;_4.add(_10);if(_1.length==1){this.$576=_10;this.$575=_4.length-1}}else if(_12!=-1){if(_17||_18){_5++;_4.set(_12,_10)}else{if(this.logIsDebugEnabled()){this.logDebug("row dropped:\n"+this.echo(_10)+"\ndidn't match filter: "+this.echo(_16))}
_6++;_4.removeAt(_12)}}else{}}
if(this.logIsDebugEnabled()){this.logDebug("updated cache: "+_7+" row(s) added, "+_5+" row(s) updated, "+_6+" row(s) removed.")}
if(!_3&&this.isPaged())
this.setFullLength(this.totalRows-_6+_7);if(!_3&&!this.shouldUpdatePartialCache())this.$391()}
,isc.A.removeCacheData=function(_1){if(!isc.isAn.Array(_1))_1=[_1];var _2=this.allRows!=null,_3=_2?this.allRows:this.localData,_4=this.getDataSource(),_5=0;for(var i=0;i<_1.length;i++){var _7=_4.findByKeys(_1[i],_3);if(_7!=-1){if(_1.length==1){var _8=_3[_7];if(!_2||_4.recordMatchesFilter(_8,this.criteria,this.context))
{this.$574=_8;this.$575=this.indexOf(this.$574)}}
_3.removeAt(_7);this.cachedRows-=1;_5++}else{if(this.allMatchingRowsCached())continue;if(_4.applyFilter([_1[i]],this.criteria,this.context).length>0){if(this.logIsDebugEnabled()){this.logDebug("removed record matches filter criteria: "+this.echo(_1[i]))}
if(this.$574==null)delete this.$573;_5++}else{if(this.logIsDebugEnabled()){this.logIsDebugEnabled("cache sync ignoring 'remove' operation, removed "+" row doesn't match filter criteria: "+this.echo(_1[i]))}}}}
if(!_2&&this.isPaged())
this.setFullLength(this.totalRows-_5)}
,isc.A.addCacheData=function(_1){if(!isc.isAn.Array(_1))_1=[_1];if(_1==null)return;var _2;if(this.allRows==null||!this.shouldUseClientFiltering()){_2=this.getDataSource().applyFilter(_1,this.criteria,this.context)}else{_2=_1;if(this.allRowsCriteria){_2=this.getDataSource().applyFilter(_2,this.allRowsCriteria,this.context)}}
var _3;if(_2.length!=_1.length){this.logInfo(_2.length+" of "+_1.length+" rows match filter criteria")}else if(_2.length==1){_3=true}
var _4=this.allRows||this.localData;if(!this.allMatchingRowsCached()&&this.shouldUpdatePartialCache()){var _5=this.getCachedRange();if(_5){if(_5[1]==this.getLength()-1||!this.rowIsLoaded(0)){var _6=_5[1]+1;_4.addListAt(_2,_6);if(_3)this.$575=_6}else{_4.addListAt(_2,0);if(_3)this.$575=0}}else{_4.addList(_2);if(_3)this.$575=_4.length-1}}else{_4.addList(_2);if(_3)this.$575=_4.length-1}
if(this.$575!=null)this.$576=_4[this.$575];this.cachedRows+=_2.length;if(this.canSortOnClient())this.$391();if(this.isPaged()&&!this.allRows)
this.setFullLength(this.totalRows+_2.length)}
,isc.A.insertCacheData=function(_1,_2){if(!isc.isAn.Array(_1))_1=[_1];if(this.allRows&&(this.allRows!=this.localData)){this.allRows.addListAt(_1,_2)}
var _3=this.localData;_3.addListAt(_1,_2);if(this.isPaged())this.setFullLength(this.totalRows+_1.length)}
,isc.A.findFirstCachedRow=function(_1){for(var i=_1;i>=0;i--){if(this.localData[i]==null)return i+1}
return 0}
,isc.A.findLastCachedRow=function(_1){for(var i=_1;i<this.totalRows;i++){if(this.localData[i]==null)return i-1}
return this.totalRows-1}
,isc.A.$39u=function(_1,_2,_3,_4){if(this.$397){var _5=(this.ignoreCache?[]:this.localData)||[];return this.fillRangeLoading(_5.slice(_1,_2),_2-_1)}
this.$397=true;var _6=this.getRangePaged(_1,_2,_3,_4);delete this.$397;return _6}
,isc.A.getRangePaged=function(_1,_2,_3,_4){if(_1<0||_2<0){this.logWarn("getRange("+_1+", "+_2+"): negative indices not supported, clamping start to 0");if(_1<0)_1=0}
if(_2<=_1){this.logDebug("getRange("+_1+", "+_2+"): returning empty list");return[]}
if(!_3&&this.lengthIsKnown()){var _5=this.getLength();if(_1>_5-1&&_1!=0){this.logWarn("getRange("+_1+", "+_2+"): start beyond end of rows, returning empty list");return[]}else if(_2>_5){_2=_5}}
if(this.localData==null)this.localData=[];if(_3){this.realCache=this.localData;this.localData=[]}
var _6=this.localData;this.lastRangeStart=_1;this.lastRangeEnd=_2;var _7,_8,_9;for(var i=_1;i<_2;i++){if(_6[i]==null){_9=true;if(_7==null)_7=i;if(_8==null||_8<i)_8=i}}
if(!_9){this.logDebug("getRange("+_1+", "+_2+") satisfied from cache");return _6.slice(_1,_2)}
var _11,_12;if(this.fetchAhead){var _13=this.$398(_1,_2,_7,_8,_3);_11=_13[0];_12=_13[1]}else{_11=_7;_12=_8+1}
this.fetchStartRow=_11;this.fetchEndRow=_12;var _14;if(_4||this.fetchDelay==0){this.$39w();_14=_6.slice(_1,_2)}else{this.fireOnPause("fetchRemoteData","$39w",this.fetchDelay);_14=this.fillRangeLoading(_6.slice(_1,_2),_2-_1)}
if(_3){this.localData=this.realCache;this.realCache=null}
return _14}
,isc.A.$398=function(_1,_2,_3,_4,_5){var _6=_5?[]:this.localData,_7=_5?Number.MAX_VALUE:this.getLength(),_8=_4-_3,_9=Math.floor((this.resultSize-_8)/2),_10=Math.max(0,_3-_9),_11=Math.min(_7,_4+_9);for(var i=_10;i<=_3;i++){var _13=_6[i];if(_13==null||Array.isLoading(_13))break}
_3=i;for(var i=_11;i>=_4;i--){var _13=_6[i];if(_13==null||Array.isLoading(_13))break}
_4=i;this.logDebug("getRange("+[_1,_2]+"), cache check: "+[_10,_11]+" firstMissingRow: "+_3+" lastMissingRow: "+_4);var _14,_15;if(_3==0||(_3>_10&&_4==_11))
{this.logDebug("getRange: guessing forward scrolling");_14=_3;_15=_14+this.resultSize;if(_15<_2)_15=_2}else if(_3==_10&&_4<_11){this.logDebug("getRange: guessing backward scrolling");_15=_4+1;_14=_15-this.resultSize;if(_14<0)_14=0;if(_14>_1)_14=_1}else{this.logDebug("getRange: no scrolling direction detected");_14=_10;_15=_11;if(_14>_1)_14=_1;if(_15<_2)_15=_2}
for(var i=_14;i<_10;i++){var _13=_6[i];if(_13==null||Array.isLoading(_13))break}
_14=i;for(var i=_15-1;i>_11;i--){var _13=_6[i];if(_13==null||Array.isLoading(_13))break}
_15=i+1;this.logInfo("getRange("+_1+", "+_2+") will fetch from "+_14+" to "+_15);return[_14,_15]}
,isc.A.filterLocalData=function(){this.$ed();this.localData=this.applyFilter(this.allRows,this.criteria,isc.addProperties({dataSource:this},this.context));this.logInfo("Local filter applied: "+this.localData.length+" of "+this.allRows.length+" records matched filter:"+isc.Comm.serialize(this.criteria));if(this.allRows!=null&&this.shouldUseClientSorting())this.$391();if(!this.$524()&&this.dataArrived)this.dataArrived(0,this.localData.length-1);this.$ee()}
,isc.A.applyFilter=function(_1,_2,_3){return this.getDataSource().applyFilter(_1,_2,_3)}
,isc.A.getValuesList=function(_1){this.logInfo("asked for valuesList for property '"+_1+"'");if(this.isLocal()){if(!this.allRows){this.logWarn("asked for valuesList before data has been loaded");return[]}
var _2=this.allRows.getProperty(_1);if(!_2)return[];return _2.getUniqueItems()}
var _3=this.getCachedRange(),_4=[];for(var i=_3[0];i<=_3[1];i++){var _6=this.get(i);if(!_4.contains(_6[_1]))_4[_4.length]=_6[_1]}
return _4}
,isc.A.fillCacheData=function(_1,_2){if(_2==null)_2=0;this.logDebug("integrating "+_1.length+" rows into cache at position "+_2);if(this.localData==null)this.localData=[];this.localData.length=this.getLength();for(var i=0;i<_1.length;i++){var _4=_2+i,_5=this.localData[_4];if(_5==null||Array.isLoading(_5)){this.cachedRows++}
this.localData[_4]=_1[i]}
if(this.allRowsCached()){this.allRows=this.localData}}
,isc.A.setFullLength=function(_1){if(!isc.isA.Number(_1))return;this.logDebug("full length set to: "+_1);if(this.isPaged())this.totalRows=_1;if(this.localData!=null)this.localData.length=_1;if(this.cachedRows>_1)this.cachedRows=_1}
,isc.A.invalidateCache=function(){delete this.$572;delete this.$576;delete this.$573;delete this.$574;delete this.$575;this.$394();if(!this.$52z())this.dataChanged()}
,isc.A.$394=function(){this.invalidateRows();this.totalRows=null;this.logInfo("Invalidating cache")}
,isc.A.invalidateRows=function(){this.localData=this.allRows=null;this.allRowsCriteria=null;this.cachedRows=0;this.$50k=null}
,isc.A.invalidateRowOrder=function(){this.$50k=true}
,isc.A.rowOrderInvalid=function(){return this.$50k}
,isc.A.getNewSelection=function(_1){var _2=this.getDataSource().selectionClass||"Selection";return isc.ClassFactory.getClass(_2).create(_1)}
);isc.B._maxIndex=isc.C+68;isc.ResultSet.registerStringMethods({transformData:"newData,dsResponse",dataArrived:"startRow,endRow",dataChanged:"operationType,originalRecord,rowNum,updateData"});isc.ResultSet.getPrototype().toString=isc.$63a;isc.ResultSet.getPrototype().logMessage=isc.$63b;isc.ClassFactory.defineClass("LocalResultSet",isc.ResultSet);isc.A=isc.LocalResultSet.getPrototype();isc.A.fetchMode="local";isc.ClassFactory.defineClass("WindowedResultSet",isc.ResultSet);isc.ResultSet.addMethods(isc.ClassFactory.makePassthroughMethods(["find","findIndex","findNextIndex","findAll","getProperty"],"localData"))
isc.ClassFactory.defineClass("ResultTree",isc.Tree);isc.A=isc.ResultTree.getPrototype();isc.A.nameProperty="$399";isc.A.nodeTypeProperty="nodeType";isc.A.childTypeProperty="childType";isc.A.modelType="parent";isc.A.loadDataOnDemand=true;isc.A.updateCacheFromRequest=true;isc.A=isc.ResultTree.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.init=function(_1,_2,_3,_4,_5,_6){if(this.initialData){if("parent"==this.modelType)this.data=this.initialData;else if("children"==this.modelType)this.root=this.initialData}
if(!this.criteria)this.criteria={};if(!this.operation)this.operation={operationType:"fetch"};if(!this.dataSource)this.dataSource=this.operation.dataSource;if(!this.operation.dataSource)this.operation.dataSource=this.dataSource;if(isc.isAn.Array(this.dataSource)){this.dataSource=this.dataSource[0];this.operation.dataSource=this.dataSource}
var _7=isc.DataSource.getDataSource(this.dataSource);this.observe(_7,"dataChanged","observer.dataSourceDataChanged(dsRequest,dsResponse);");if(!this.isMultiDSTree()){if(!this.root)this.root=this.makeRoot();var _8=this.getTreeRelationship(this.root);var _9;if(this.rootValue===_9)this.rootValue=_8.rootValue;if(this.idField==null)this.idField=_8.idField;if(this.parentIdField==null)this.parentIdField=_8.parentIdField;if(_8.childrenProperty)this.childrenProperty=_8.childrenProperty;this.root[this.idField]=this.rootValue}
this.dropCacheOnUpdate=this.operation.dropCacheOnUpdate;if(this.defaultIsFolder==null)this.defaultIsFolder=this.loadDataOnDemand;this.invokeSuper(isc.ResultTree,"init",_1,_2,_3,_4,_5,_6);this.defaultLoadState=this.loadDataOnDemand?isc.Tree.UNLOADED:isc.Tree.LOADED}
,isc.A.destroy=function(){this.Super("destroy",arguments);var _1=isc.DataSource.getDataSource(this.dataSource);if(_1)this.ignore(_1,"dataChanged")}
,isc.A.getTreeRelationship=function(_1){var _2=this.getChildDataSource(_1);var _3=_2.getTreeRelationship();return _3}
,isc.A.getChildDataSource=function(_1,_2){var _3=_1[this.childTypeProperty];if(_3!=null)return isc.DS.get(_3);var _2=_2||this.getNodeDataSource(_1);if(_2==null||!this.isMultiDSTree())return this.getRootDataSource();var _4=this.treeRelations,_5=_2.getChildDataSources();if(_4){_3=_4[_2.ID];if(_3!=null)return isc.DS.get(_3)}
if(_5!=null)return _5[0]}
,isc.A.getNodeDataSource=function(_1){var _2=_1[this.nodeTypeProperty];if(_2==null){var _3=this.getParent(_1);if(_3==null){return null}else if(_3==this.root){_2=this.getRootDataSource().ID}else{_2=_3.$40a;if(_2==null)_2=this.getRootDataSource().ID}}
return isc.DS.get(_2)||this.getRootDataSource()}
,isc.A.isMultiDSTree=function(){return this.multiDSTree||this.treeRelations!=null}
,isc.A.getRootDataSource=function(){return isc.DS.get(this.operation.dataSource||this.dataSource)}
,isc.A.getCriteria=function(_1,_2,_3){if(this.getRootDataSource()==_1)return this.criteria;return null}
,isc.A.getOperationId=function(_1,_2,_3){return this.operation?this.operation.ID:null}
,isc.A.loadChildren=function(_1,_2){var _3=(_1==null||_1==this.root),_4,_5,_6;if(_3&&this.isMultiDSTree()){_5=this.getRootDataSource();_4={childDS:_5}}else{_4=this.getTreeRelationship(_1);_5=_4.childDS;_6=_4.parentDS}
if(!this.isMultiDSTree()){_4.idField=this.idField;_4.parentIdField=this.parentIdField;_4.rootValue=_4.rootValue}
if(this.logIsDebugEnabled()){this.logDebug("parent id: "+(_3?"[root]":_1[_4.idField])+" (type: "+(_3?"[root]":_6.ID)+")"+" has childDS: "+_5.ID+", relationship: "+this.echo(_4))}
_1.$40a=_5.ID;var _7=isc.addProperties({},this.getCriteria(_5,_6,_1));if(_3&&this.isMultiDSTree()){}else if(this.loadDataOnDemand){_7[_4.parentIdField]=(_3?_4.rootValue:_1[_4.idField])}else{this.defaultLoadState=isc.Tree.LOADED}
var _8=isc.addProperties({parentNode:_1,relationship:_4,childrenReplyCallback:_2},this.context?this.context.clientContext:null);var _9=isc.addProperties({parentNode:_1,resultTree:this},this.context,{clientContext:_8});var _10=this.getOperationId(_5,_6,_1);if(_10)_9.operationId=_10;_9.willHandleError=true;if(_1!=null)this.setLoadState(_1,isc.Tree.LOADING);_5.fetchData(_7,{caller:this,methodName:'loadChildrenReply'},_9)}
,isc.A.loadChildrenReply=function(_1,_2,_3){var _4=_1.clientContext;var _5=_4.parentNode;var _6=_4.relationship,_7=_1.data;if(_1.status<0)_7=null;if(_7==null||_7.length==0){this.setLoadState(_5,isc.Tree.LOADED);if(_7==null){if(_1.status<0){isc.RPCManager.$a0(_1,_3)}else{this.logWarn("null children returned; return empty List instead")}
_7=[]}}
if(this.isMultiDSTree()){for(var i=0;i<_7.length;i++){var _9=_7[i];var _10=this.getChildDataSource(_9,_6.childDS);if(_10!=null)this.convertToFolder(_9);this.add(_9,_5)}}else{this.linkNodes(_7,_6.idField,_6.parentIdField,_6.rootValue,_6.isFolderProperty,_5)}
if(_4.childrenReplyCallback){this.fireCallback(_4.childrenReplyCallback,"node",[_5],this)}
if(this.dataArrived!=null){isc.Func.replaceWithMethod(this,"dataArrived","parentNode");this.dataArrived(_5)}}
,isc.A.getDataSource=function(){return isc.DataSource.getDataSource(this.dataSource)}
,isc.A.invalidateCache=function(){if(!this.isLoaded(this.root))return;this.setRoot(this.makeRoot())}
,isc.A.dataSourceDataChanged=function(_1,_2){if(this.disableCacheSync)return;var _3=isc.DataSource.getUpdatedData(_1,_2,this.updateCacheFromRequest);this.handleUpdate(_1.operationType,_3,_2.invalidateCache)}
,isc.A.handleUpdate=function(_1,_2,_3){if(isc.$cv)arguments.$cw=this;if(this.dropCacheOnUpdate||_3){this.invalidateCache();if(!this.getDataSource().canQueueRequests)this.dataChanged();return}
this.updateCache(_1,_2);this.dataChanged()}
,isc.A.updateCache=function(_1,_2){if(_2==null)return;_1=isc.DS.$372(_1);if(this.logIsInfoEnabled()){this.logInfo("Updating cache: operationType '"+_1+"', "+_2.length+" rows update data"+(this.logIsDebugEnabled()?":\n"+this.echoAll(_2):""))}
switch(_1){case"remove":this.removeCacheData(_2);break;case"add":this.addCacheData(_2);break;case"replace":case"update":this.updateCacheData(_2);break}}
,isc.A.addCacheData=function(_1){if(!isc.isAn.Array(_1))_1=[_1];var _2=this.getDataSource().applyFilter(_1,this.criteria,this.context);var _3=this.getDataSource().getPrimaryKeyFieldNames()[0];for(var i=0;i<_2.length;i++){var _5=this.find(_3,_2[i][this.parentIdField]);if(_5!=null&&(this.getLoadState(_5)==isc.Tree.LOADED))
this.add(isc.addProperties({},_2[i]),_5)}}
,isc.A.updateCacheData=function(_1){if(!isc.isAn.Array(_1))_1=[_1];var _2=0,_3=0;var _4=this.getDataSource().getPrimaryKeyFieldNames()[0];for(var i=0;i<_1.length;i++){var _6=_1[i];var _7=this.getDataSource().recordMatchesFilter(_6,this.criteria,this.context);if(this.logIsDebugEnabled()&&!_7){this.logDebug("updated node :\n"+this.echo(_6)+"\ndidn't match filter: "+this.echo(this.criteria))}
var _8=this.find(_4,_6[_4]);if(_8==null){if(_7){var _9=this.find(this.idField,_6[this.parentIdField]);if(_9&&(this.getLoadState(_9)==isc.Tree.LOADED)){this.logWarn("updated row returned by server doesn't match any cached row, "+" adding as new row.  Primary key value: "+this.echo(_6[_4])+", complete row: "+this.echo(_6));_6=isc.addProperties({},_6);this.add(_6,_9)}}
continue}
if(_7){if(_6[this.parentIdField]!=_8[this.parentIdField]){var _10=this.find(_4,_6[this.parentIdField]);if(_10==null||(this.getLoadState(_10)!=isc.Tree.LOADED)){this.remove(_8)
_2++;continue}
this.move(_8,_10)}
isc.addProperties(_8,_6)}else{this.remove(_8);_2++}}
if(this.logIsDebugEnabled()){this.logDebug("updated cache, "+(_1.length-_2)+" out of "+_1.length+" rows remain in cache, "+_3+" row(s) added.")}}
,isc.A.removeCacheData=function(_1){if(!isc.isAn.Array(_1))_1=[_1];var _2=[],_3=this.getDataSource().getPrimaryKeyFieldNames()[0];for(var i=0;i<_1.length;i++){var _5=this.find(_3,_1[i][_3]);if(_5==null){this.logWarn("Cache synch: couldn't find deleted node:"+this.echo(_1[i]));continue}
_2.add(_5)}
this.removeList(_2)}
,isc.A.getTitle=function(_1){var _2=this.getNodeDataSource(_1);if(!_2)return"root";var _3=_1[_2.getTitleField()];if(_3!=null)return _3;return this.Super("getTitle",arguments)}
,isc.A.indexOf=function(_1,_2,_3,_4,_5){var _6=this.getDataSource().getPrimaryKeyFieldNames();for(var i=0;i<_6.length;i++){var _8=_6[i];if(_1[_8]!=null)return this.findIndex(_8,_1[_8])}
return this.invokeSuper(isc.ResultTree,"indexOf",_1,_2,_3,_4,_5)}
);isc.B._maxIndex=isc.C+21;isc.ResultTree.getPrototype().toString=isc.$63a;isc.ResultTree.getPrototype().logMessage=isc.$63b;isc.ResultTree.registerStringMethods({dataArrived:"parentNode"});isc.A=isc.Canvas.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.buildRequest=function(_1,_2,_3){if(!_1)_1={};if(_3)_1.afterFlowCallback=_3;if(_2=="filter"){_2="fetch";if(_1.textMatchStyle==null)_1.textMatchStyle="substring"}
if(this.textMatchStyle!=null)_1.textMatchStyle=this.textMatchStyle;_2=isc.DS.$372(_2);if(this.dataPageSize)_1.dataPageSize=this.dataPageSize;var _4=_1.operationId||_1.operation;if(_4==null){switch(_2){case"fetch":_4=this.fetchOperation;break;case"add":_4=this.addOperation||this.saveOperation;break;case"update":_4=this.updateOperation||this.saveOperation;break;case"remove":_4=this.removeOperation||this.deleteOperation;break;case"validate":_4=this.validateOperation;break}
_1.operation=_4||this.operation}
_1.componentId=this.ID;return isc.rpc.addDefaultOperation(_1,this.dataSource,_2)}
,isc.A.createResultTree=function(_1,_2,_3,_4){this.$53w=_2;if(_4==null)_4="fetch";if(_3==null)_3={};_3.afterFlowCallback={target:this,methodName:"$53x"};var _5=isc.addProperties({initialData:this.initialData},this.dataProperties,_3.dataProperties,this.treeProperties,_3.treeProperties);_5.criteria=_1;_5.operation=_3.operation;_5.context=_3;_5.dataSource=this.dataSource;_5.componentId=this.ID;_5.$31k=true;if(this.loadDataOnDemand!=null)_5.loadDataOnDemand=this.loadDataOnDemand;if(this.treeDataRelations)_5.treeRelations=this.treeDataRelations;if(this.multiDSTree!=null)_5.multiDSTree=this.multiDSTree;var _6=this.getDataSource().resultTreeClass||"ResultTree";return isc.ClassFactory.getClass(_6).create(_5)}
,isc.A.$53x=function(_1,_2,_3){if(this.$53w){this.fireCallback(this.$53w,"dsResponse,data,dsRequest",arguments);delete this.$53w}}
);isc.B._maxIndex=isc.C+3;if(isc.ValuesManager){isc.A=isc.ValuesManager.getPrototype();isc.A.buildRequest=isc.Canvas.getInstanceProperty("buildRequest")}
isc.ClassFactory.defineInterface("EditorActionMethods");isc.EditorActionMethods.addInterfaceMethods({save:function(_1){return this.saveData(_1)},editSelected:function(_1,_2){return this.editSelectedData(_1,_2)},editNew:function(_1,_2){return this.editNewRecord(_1,_2)},editNewRecord:function(_1){this.setSaveOperationType("add");this.$39m(_1)},editRecord:function(_1){this.setSaveOperationType("update");this.$39m(_1)},$39m:function(_1){delete this.$50l;delete this.$39l;var _1=isc.addProperties({},_1);this.setData(_1)},editSelectedData:function(_1){if(isc.isA.String(_1))_1=window[_1];if(!_1)return;var _2=_1.selection.getSelection();if(_2&&_2.length>0)this.editList(_2)},editList:function(_1){this.setSaveOperationType("update");this.$50b(_1)},$50b:function(_1){this.$50l=0;this.$39l=_1;var _2=isc.addProperties({},_1[this.$50l]);this.setData(_2)},editNextRecord:function(){this.editOtherRecord(true)},editPrevRecord:function(){this.editOtherRecord(false)},editOtherRecord:function(_1){if(!this.$39l)return;if(this.isVisible()&&this.valuesHaveChanged()){this.$39n=_1;this.saveData({target:this,methodName:"editOtherReply"});return};if(_1&&this.$50l>=this.$39l.length-1){this.logWarn("Unable to edit next record - this is the last selected record");return false}
if(!_1&&this.$50l<=0){this.logWarn("Unable to edit previous record - this is the first selected record");return false}
this.$50l+=(_1?1:-1);var _2=isc.addProperties({},this.$39l[this.$50l]);this.setData(_2)},editOtherReply:function(_1,_2,_3){var _4=this.$39n;delete this.$39n;if(_1.status<0&&_1.errors){return this.setErrors(_1.errors,true)}
if(_1.status<0)return isc.RPCManager.$a0(_1,_3);this.rememberValues();this.$39l[this.$50l]=this.getValues();this.editOtherRecord(_4)
return true},validateData:function(_1,_2){if(!this.validate())return false;var _3=this.getValues();var _4=this.buildRequest(_2,"validate");_4.willHandleError=true;_4.editor=this;if(_4.valuesAsParams){if(!_4.params)_4.params={};isc.addProperties(_4.params,_3)}
var _5=this.getDataSource();return _5.performDSOperation(_4.operation.type,_3,_1?_1:{target:this,methodName:"saveEditorReply"},_4)},reset:function(){this.resetValues()},cancel:function(_1){var _2={actionURL:this.action,target:window,sendNoQueue:true,ignoreTimeout:true,useXmlHttpRequest:false,params:{},useSimpleHttp:true};_2.params[this.cancelParamName]=this.cancelParamValue;if(!_2.actionURL){this.logWarn("No actionURL defined for the cancel RPC - set 'action' on your form or"+"provide an actionURL in the requestProperties to cancel()");return}
isc.addProperties(_2,_1);isc.rpc.sendRequest(_2)},submit:function(_1,_2){if(this.submitValues!=null){return this.submitValues(this.getValues(),this)}
if(this.canSubmit)return this.submitForm();else return this.saveData(_1,_2)},saveOperationIsAdd:function(){if(this.saveOperationType)return this.saveOperationType=="add";if(this.dataSource){var _1=isc.DataSource.getDataSource(this.dataSource);return!_1.recordHasAllKeys(this.getValues())}
return false},saveData:function(_1,_2,_3){if(this.dataSource==null){this.logWarn("saveData() called on a non-databound DynamicForm. This is not supported. "+" for information on databinding of components look at the documentation"+" for the DataSource class.  "+"If this was intended to be a native HTML form submission, set the "+"canSubmit property to true on this form.");return}
if(_2==null&&isc.isAn.Object(_1)&&_1.methodName==null)
{_2=_1;_1=_2.afterFlowCallback}
if(this.validationURL&&!_3){var _4={};isc.addProperties(_4,_2);isc.addProperties(_4,{actionURL:this.validationURL,valuesAsParams:true,sendNoQueue:true});_4.$40b=_2;_4.$40c=_1;this.performingServerValidation=true;this.validateData(this.getID()+".$40d(rpcRequest,rpcResponse,data)",_4);return}
var _5=this.getFileItemForm();if(_5){var _6=this.getValues(),_7=_5.getItem(0).getFieldName();delete _6[_7];for(var _8 in _6){_5.setValue(_8,_6[_8])}
_5.action=this.action;_5.target=this.target;_5.dataSource=this.dataSource;if(!this.validate())return false;return _5.saveData(_1,_2,_3)}
var _9=this.getSaveOperationType(_2);this.$40c=_1;_1=this.getID()+".$49z(dsRequest, dsResponse, data)";_2=this.buildRequest(_2,_9,_1);_2.oldValues=this.$10s;var _10=false;if(this.submitParamsOnly)_2.useSimpleHttp=true;if(isc.DynamicForm&&isc.isA.DynamicForm(this)){if(this.action!=isc.DynamicForm.getInstanceProperty("action")){_2.actionURL=this.action;_2.target=this.target?this.target:window;_10=true}
if(this.method!=isc.DynamicForm.getInstanceProperty("method")){_2.httpMethod=this.method}}
if(!this.validate())return false
var _11=this.getValues();if((isc.DynamicForm&&isc.isA.DynamicForm(this)&&this.isMultipart())||this.canSubmit||_10)
{return this.submitEditorValues(_11,_2.operation,_2.callback,_2)}else{return this.saveEditorValues(_11,_2.operation,_2.callback,_2)}},setSaveOperationType:function(_1){this.saveOperationType=_1},getSaveOperationType:function(_1){var _2;if(!_1||!_1.operation){_2=(_1&&_1.operationType)?_1.operationType:this.saveOperationType;if(!_2&&this.dataSource!=null){var _3=isc.DataSource.getDataSource(this.dataSource).getPrimaryKeyFieldNames(),_4=this.getValues(),_5;for(var i=0;i<_3.length;i++){var _7=_3[i],_8=_4[_3];if(_8==null){_2="add";break}
if(this.$10s[_7]!==_5&&this.$10s[_7]!=_8){_2="add"}
var _9=this.getItem(_7);if(_9&&(_9.shouldSaveValue&&_9.isEditable())){_2="add"
break}}
if(_2==null){_2="update"}}}
return _2},$49z:function(_1,_2,_3){this.$490=0;if(!this.suppressServerDataSync&&_2&&_2.status>=0&&_3!=null){if(isc.isAn.Array(_3))_3=_3[0];var _4=(_1.originalData||_1.data),_5=this.getValues();for(var i in _3){var _7=this.getField(i);if(!this.fieldValuesAreEqual(_7,_4[i],_3[i])&&this.fieldValuesAreEqual(_7,_5[i],_4[i]))
{this.setValue(i,_3[i])}}}
this.$491={request:_1,response:_2,data:_3};this.formSavedComplete()},formSavedComplete:function(){var _1=this.getFields();for(var i=this.$490;i<_1.length;i++){this.$490++;var _3=_1[i];if(isc.isA.Function(_3.formSaved)&&_3.formSaved(this.$491.request,this.$491.response,this.$491.data)===false)return}
if(this.$40c){this.fireCallback(this.$40c,"dsResponse,data,dsRequest",[this.$491.response,this.$491.data,this.$491.request])}
delete this.$492;delete this.$40c},saveEditorValues:function(_1,_2,_3,_4){var _5;if(!_4)_4={};isc.addProperties(_4,{prompt:(_4.prompt||isc.RPCManager.saveDataPrompt),editor:this,willHandleError:true});if(_4.valuesAsParams){if(!_4.params)_4.params={};isc.addProperties(_4.params,_1)}
var _6=this.getDataSource();return _6.performDSOperation(_2.type,_1,_3?_3:{target:this,methodName:"saveEditorReply"},_4)},submitEditorValues:function(_1,_2,_3,_4){if(!_4)_4={};isc.addProperties(_4,{directSubmit:true,submitForm:this});return this.saveEditorValues(_1,_2,_3,_4)},saveEditorReply:function(_1,_2,_3){if(_1.status==isc.RPCResponse.STATUS_VALIDATION_ERROR&&_1.errors){this.setErrors(_1.errors,true);return false}
if(_1.status<0)return isc.RPCManager.$a0(_1,_3);return true},$40d:function(_1,_2,_3){if(_2.status==isc.RPCResponse.STATUS_SUCCESS){this.performingServerValidation=false;this.markForRedraw("serverValidationSuccess");this.saveData(_1.$40c,_1.$40b,true);_1.$40c=null;_1.$40b=null}else{this.setErrors(_2.errors,true)}}});if(isc.DynamicForm)isc.ClassFactory.mixInInterface("DynamicForm","EditorActionMethods");isc.$457={fetchData:function(_1,_2,_3){var _4=this.getDataSource();if(!_4){this.logWarn("Ignoring call to fetchData() on a DynamicForm with no valid dataSource");return}
if(this.$458==null)this.$458=[];this.$458.add(_2);_4.fetchData(_1,{target:this,methodName:"fetchDataReply"},_3)},fetchDataReply:function(_1,_2,_3){var _4=_2?_2.get(0):null;this.editRecord(_4);var _5=this.$458.pop();if(_5)this.fireCallback(_5,"dsResponse,data,dsRequest",[_1,_2,_3])},filterData:function(_1,_2,_3){var _4=this.getDataSource();if(!_4){this.logWarn("Ignoring call to filterData() on a DynamicForm with no valid dataSource");return}
if(this.$458==null)this.$458=[];this.$458.add(_2);_4.filterData(_1,{target:this,methodName:"fetchDataReply"},_3)}}
if(isc.DynamicForm)isc.DynamicForm.addMethods(isc.$457)
if(isc.ValuesManager)isc.ClassFactory.mixInInterface("ValuesManager","EditorActionMethods");if(isc.ValuesManager)isc.ValuesManager.addMethods(isc.$457)
if(isc.ValuesManager){isc.A=isc.ValuesManager.getPrototype();isc.A.fieldValuesAreEqual=isc.Canvas.getPrototype().fieldValuesAreEqual}
if(isc.TreeGrid){isc.A=isc.TreeGrid.getPrototype();isc.A.ignoreEmptyCriteria=true;isc.A=isc.TreeGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.useExistingDataModel=function(_1,_2,_3){return false}
,isc.A.createDataModel=function(_1,_2,_3){return this.createResultTree(_1,_3.afterFlowCallback,_3,null)}
);isc.B._maxIndex=isc.C+2}
if(isc.DetailViewer){isc.A=isc.DetailViewer.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.viewSelectedData=function(_1,_2,_3){if(isc.isA.String(_1))_1=window[_1];_3=_3||{};var _4=_1.selection.getSelection();if(_4&&_4.length>0){if(!_3.operation){this.setData(_4)}else{var _5=_3.operation,_6=this.getDataSource(),_7=_6.filterPrimaryKeyFields(_4);if(_3.prompt==null)
_3.prompt=isc.RPCManager.getViewRecordsPrompt;_3.viewer=this;return _6.performDSOperation(_5.type,_7,(_2?_2:{target:this,methodName:"viewSelectedDataReply"}),_3)}}
return false}
,isc.A.viewSelected=function(_1,_2){return this.viewSelectedData(_1,_2)}
,isc.A.viewSelectedDataReply=function(_1,_2,_3){this.setData(_2)}
);isc.B._maxIndex=isc.C+3}
isc.A=isc.Canvas;isc.A.resizeThumbConstructor=isc.Canvas;isc.A.resizeThumbDefaults={width:8,height:8,overflow:"hidden",styleName:"resizeThumb",canDrag:true,canDragResize:true,getEventEdge:function(){return this.edge},autoDraw:false};isc.A=isc.Canvas;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.$40f=function(){var _1=isc.Canvas.getInstanceProperty("edgeCursorMap"),_2={},_3=isc.ClassFactory.getClass(this.resizeThumbConstructor);for(var _4 in _1){_2[_4]=_3.create({ID:"isc_resizeThumb_"+_4,edge:_4},this.resizeThumbDefaults,this.resizeThumbProperties)}
isc.Canvas.$40g=_2}
,isc.A.showResizeThumbs=function(_1){if(!_1)return;if(!isc.Canvas.$40g)isc.Canvas.$40f();var _2=isc.Canvas.resizeThumbDefaults.width,_3=isc.Canvas.$40g;var _4=_1.getPageRect(),_5=_4[0],_6=_4[1],_7=_4[2],_8=_4[3],_9=Math.floor(_5+(_7/ 2)-(_2/ 2)),_10=Math.floor(_6+(_8/ 2)-(_2/ 2));_3.T.moveTo(_9,_6-_2);_3.B.moveTo(_9,_6+_8);_3.L.moveTo(_5-_2,_10);_3.R.moveTo(_5+_7,_10);_3.TL.moveTo(_5-_2,_6-_2);_3.TR.moveTo(_5+_7,_6-_2);_3.BL.moveTo(_5-_2,_6+_8);_3.BR.moveTo(_5+_7,_6+_8);for(var _11 in _3){var _12=_3[_11];_12.dragTarget=_1;_12.show()}
this.$rl=_1}
,isc.A.hideResizeThumbs=function(){var _1=this.$40g;for(var _2 in _1){_1[_2].hide()}
this.$rl=null}
);isc.B._maxIndex=isc.C+3;isc.A=isc.Canvas.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.editMaskDefaults={draw:function(){this.Super("draw",arguments);this.observe(this.masterElement,"setZIndex","observer.moveAbove(observed)");isc.Canvas.showResizeThumbs(this);this.observe(this.masterElement,"setPrompt","observer.setPrompt(observed.prompt)");return this},parentVisibilityChanged:function(){this.Super("parentVisibilityChanged",arguments);if(isc.Canvas.$rl==this)isc.Canvas.hideResizeThumbs()},click:function(){isc.Canvas.showResizeThumbs(this);return isc.EH.STOP_BUBBLING},bringToFront:function(){},mouseDown:function(){this.Super("mouseDown",arguments);return isc.EH.STOP_BUBBLING},mouseUp:function(){this.Super("mouseUp",arguments);return isc.EH.STOP_BUBBLING},doubleClick:function(){this.$jr.bringToFront();return this.click()},canDrag:true,canDragReposition:true,setDragTracker:function(){return isc.EH.STOP_BUBBLING},moved:function(){this.Super("moved",arguments);var _1=this.masterElement;if(_1){var _2=this.getOffsetLeft()-_1.getLeft();var _3=this.getOffsetTop()-_1.getTop();this.$ns=false;_1.moveTo(this.getOffsetLeft(),this.getOffsetTop());this.$ns=true}
if(isc.Canvas.$rl==this)isc.Canvas.showResizeThumbs(this)},resized:function(){this.Super("resized",arguments);if(this.$40h)return;this.$40h=true;var _1=this.masterElement;if(_1){this.$jo=false;_1.resizeTo(this.getWidth(),this.getHeight());this.$jo=true;_1.redrawIfDirty();this.resizeTo(_1.getVisibleWidth(),_1.getVisibleHeight())}
isc.Canvas.showResizeThumbs(this);this.$40h=false},showContextMenu:function(){var _1=this.masterElement,_2;if(this.editContext.selectedComponents.length>0){_2=(_1.editMultiMenuItems||[]).concat(this.multiSelectionMenuItems)}else{_2=(_1.editMenuItems||[]).concat(this.standardMenuItems)}
if(!this.contextMenu)this.contextMenu=isc.Menu.create({});this.contextMenu.setData(_2);this.contextMenu.showContextMenu(_1);return false},standardMenuItems:[{title:"Remove",click:"target.destroy()"},{title:"Bring to Front",click:"target.bringToFront()"},{title:"Send to Back",click:"target.sendToBack()"}],multiSelectionMenuItems:[{title:"Remove Selected Items",click:"target.editContext.removeSelection(target)"}]};isc.A.useEditMask=true;isc.B.push(isc.A.setEditMode=function(_1,_2){if(_1==null)_1=true;if(this.editingOn==_1)return;this.editingOn=_1;if(this.editingOn){this.editContext=_2;if(this.useEditMask)this.showEditMask()}else{this.hideEditMask()}}
,isc.A.showEditMask=function(){var _1=this.getID()+":<br>"+this.src;if(!this.$40i){var _2={};if(isc.SVG&&isc.isA.SVG(this)&&isc.Browser.isIE){isc.addProperties(_2,{backgroundColor:"gray",mouseOut:function(){this.$jr.Super("$mc")},contents:isc.Canvas.spacerHTML(10000,10000,_1)})}
var _3=isc.addProperties({},this.editMaskDefaults,this.editMaskProperties,{editContext:this.editContext||this.parentElement,keepInParentRect:this.keepInParentRect},_2);this.$40i=isc.EH.makeEventMask(this,_3)}
this.$40i.show();if(isc.SVG&&isc.isA.SVG(this)){if(isc.Browser.isIE)this.showNativeMask();else{this.setBackgroundColor("gray");this.setContents(_1)}}}
,isc.A.hideEditMask=function(){if(this.$40i)this.$40i.hide()}
);isc.B._maxIndex=isc.C+3;isc.A=isc.Class.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.getSchema=function(){return isc.DS.get(this.schemaName||this.Class)}
,isc.A.getSchemaField=function(_1){return this.getSchema().getField(_1)}
,isc.A.getObjectField=function(_1){var _2=this.$40j;if(isc.isA.Canvas(this)){var _3;if(_2&&_2[_1]!==_3){return _2[_1]}}
var _4=this.getSchema().getObjectField(_1);if(isc.isA.Canvas(this)){if(!_2)this.$40j=_2={};_2[_1]=_4}
return _4}
,isc.A.addChildObject=function(_1,_2,_3){return this.$40k("add",_1,_2,_3)}
,isc.A.removeChildObject=function(_1,_2){return this.$40k("remove",_1,_2)}
,isc.A.$40k=function(_1,_2,_3,_4){var _5=this.getObjectField(_2);var _6=this.getSchemaField(_5);if(!_6.multiple){var _7={};_7[_5]=_3;this.logInfo(_1+"ChildObject calling setProperties","editing");this.setProperties(_7);return true}
var _8=this.getFieldMethod(_2,_5,_1);if(_8!=null){this.logInfo("calling "+_8+"("+this.echoLeaf(_3)+(_4!=null?","+_4+")":")"),"editing");this[_8](_3,_4);return true}
return false}
,isc.A.getChildObject=function(_1,_2){var _3=this.getObjectField(_1),_4=this.getSchemaField(_3);if(!_4.multiple)return this.getProperty(_3);var _5=this.getFieldMethod(_1,_3,"get");if(_5&&this[_5]){this.logInfo("getChildObject calling: "+_5+"('"+_2+"')","editing");return this[_5](_2)}else{this.logInfo("getChildObject calling getArrayItem('"+_2+"',this."+_3+")","editing");return isc.Class.getArrayItem(_2,this[_3])}}
,isc.A.getFieldMethod=function(_1,_2,_3){var _4=_3+_1;if(isc.isA.Function(this[_4])&&isc.Func.getArgs(this[_4]).length>0)
{return _4}
if(_2.endsWith("s")){_4=_3+_2.slice(0,-1).toInitialCaps();if(isc.isA.Function(this[_4])&&isc.Func.getArgs(this[_4]).length>0)
{return _4}}}
);isc.B._maxIndex=isc.C+8;isc.A=isc.DataSource;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.getSchema=function(_1){if(isc.isA.Class(_1))return _1.getSchema();return isc.DS.get(_1.schemaName||_1._constructor||_1.Class)}
,isc.A.getObjectField=function(_1,_2){if(_1==null)return null;if(isc.isA.Class(_1))return _1.getObjectField(_2);var _3=isc.DS.getSchema(_1);if(_3)return _3.getObjectField(_2)}
,isc.A.getSchemaField=function(_1,_2){var _3=isc.DS.getSchema(_1);if(_3)return _3.getField(_2)}
,isc.A.addChildObject=function(_1,_2,_3,_4){return this.$40k(_1,"add",_2,_3,_4)}
,isc.A.removeChildObject=function(_1,_2,_3){return this.$40k(_1,"remove",_2,_3)}
,isc.A.$40k=function(_1,_2,_3,_4,_5){var _6=isc.DS.getObjectField(_1,_3);if(_6==null){this.logWarn("No field for child of type "+_3);return false}
this.logInfo(_2+" object "+this.echoLeaf(_4)+" in field: "+_6+" of parentObject: "+this.echoLeaf(_1),"editing");var _7=isc.DS.getSchemaField(_1,_6);if(isc.isA.Class(_1)){if(_1.$40k(_2,_3,_4,_5))return true}
if(!_7.multiple){if(_2=="add")_1[_6]=_4;else if(_2=="remove"){if(_1[_6]!=null)delete _1[_6]}else{this.logWarn("unrecognized verb: "+_2);return false}
return true}
this.logInfo("using direct Array manipulation for field '"+_6+"'","editing");var _8=_1[_6];if(_2=="add"){if(_8!=null&&!isc.isAn.Array(_8)){this.logWarn("unexpected field value: "+this.echoLeaf(_8)+" in field '"+_6+"' when trying to add child: "+this.echoLeaf(_4));return false}
if(_8==null)_1[_6]=_8=[];if(_5!=null)_8.addAt(_4,_5);else _8.add(_4)}else if(_2=="remove"){if(!isc.isAn.Array(_8))return false;if(_5!=null)_8.removeAt(_4,_5);else _8.remove(_4)}else{this.logWarn("unrecognized verb: "+_2);return false}
return true}
,isc.A.getChildObject=function(_1,_2,_3){if(isc.isA.Class(_1))return _1.getChildObject(_2,_3);var _4=isc.DS.getObjectField(_1,_2),_5=isc.DS.getSchemaField(_1,_4);var _6=_1[_4];if(!_5.multiple)return _6;if(!isc.isAn.Array(_6))return null;return isc.Class.getArrayItem(_3,_6)}
,isc.A.getAutoIdField=function(_1){var _2=this.getNearestSchema(_1);return _2?_2.getAutoIdField():"ID"}
,isc.A.getAutoId=function(_1){var _2=this.getAutoIdField(_1);return _2?_1[_2]:null}
);isc.B._maxIndex=isc.C+9;isc.A=isc.DataSource.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.getAutoIdField=function(){return this.getInheritedProperty("autoIdField")||"ID"}
,isc.A.shouldCreateStandalone=function(){if(this.createStandalone!=null)return this.createStandalone;if(!this.superDS())return true;return this.superDS().shouldCreateStandalone()}
);isc.B._maxIndex=isc.C+2;isc.ClassFactory.defineInterface("EditContext");isc.EditContext.addInterfaceMethods({requestLiveObject:function(_1,_2,_3){var _4=this;if(_1.loadData&&!_1.isLoaded){_1.loadData(_1,function(_6){_6=_6||_1
_6.isLoaded=true;_6.dropped=_1.dropped;_4.fireCallback(_2,"node",[_6])},_3);return}
if(_1.wizardConstructor){this.logWarn("creating wizard");var _5=isc.ClassFactory.newInstance(_1.wizardConstructor,_1.wizardDefaults);_5.getResults(_1,function(_6){_4.fireCallback(_2,"node",[_6])},_3);return}
_4.fireCallback(_2,"node",[_1])},getEditComponents:function(){return this.editComponents},getEditDataSource:function(_1){return isc.DataSource.getDataSource(_1.editDataSource||_1.Class||this.editDataSource)},$40l:function(_1){var _2=[];_2.addList(_1.baseEditFields);_2.addList(_1.editFields);for(var i=0;i<_2.length;i++){var _4=_2[i];if(_4.visible==null)_4.visible=true}
if(_2.length==0){_2=this.getEditDataSource(_1).getFields();_2=isc.getValues(_2)}
return _2},getEditFieldsList:function(_1){var _2=[],_3=this.$40l(_1);for(var i=0;i<_3.length;i++){var _5=_3[i];if(isc.isAn.Object(_5)){_2.add(_5.name)}else{_2.add(_5)}}
return _2},getEditFields:function(_1){var _2=this.$40l(_1);for(var i=0;i<_2.length;i++){var _4=_2[i];if(isc.isA.String(_4))_4={name:_4};if(_4.visible==null)_4.visible=true;_2[i]=_4}
return _2},serializeEditComponents:function(){var _1=this.getEditComponents(),_2=[];if(!_1)return[];for(var i=0;i<_1.length;i++){var _4=_1[i].liveObject,_5=_4.getUniqueProperties(),_6=this.getEditFieldsList(_4);_5._constructor=_4.Class;_5=isc.applyMask(_5,_6);_2.add(_5)}
return _2}});isc.ClassFactory.defineInterface("Palette");isc.Palette.addInterfaceMethods({makeEditNode:function(_1){return this.makeNewComponent(_1)},makeNewComponent:function(_1){if(!_1)_1=this.getDragData();if(isc.isAn.Array(_1))_1=_1[0];var _2=_1.className||_1.type;var _3={type:_2,_constructor:_2,title:_1.title,icon:_1.icon,iconSize:_1.iconSize,showDropIcon:_1.showDropIcon};if(_1.makeComponent){_3.liveObject=_1.makeComponent(_3);return _3}
var _4=_1.defaults;_3.ID=_1.ID||(_4?isc.DS.getAutoId(_4):null);if(_1.loadData){_3.loadData=_1.loadData}else if(_1.wizardConstructor){_3.wizardConstructor=_1.wizardConstructor;_3.wizardDefaults=_1.wizardDefaults}else if(_1.liveObject){var _5=_1.liveObject;if(isc.isA.String(_5))_5=window[_5];_3.liveObject=_5}else{_3=this.createLiveObject(_1,_3)}
return _3},generateNames:true,typeCount:{},getNextAutoId:function(_1){if(_1==null)_1="Object";var _2;this.typeCount[_1]=this.typeCount[_1]||0;while(window[(_2=_1+this.typeCount[_1]++)]!=null){}
return _2},createLiveObject:function(_1,_2){var _3=_1.className||_1.type,_4=isc.ClassFactory.getClass(_3),_5=isc.DS.getNearestSchema(_3),_6={},_7=(_5?_5.shouldCreateStandalone():true);if(_4&&_4.isA("Canvas"))_6.autoDraw=false;if(this.generateNames){var _8=_2.ID=_2.ID||this.getNextAutoId(_3);_6[_5.getAutoIdField()]=_8;if(_5&&_5.getField("title")&&!isc.isA.FormItem(_4))_6.title=_8}
_6=_2.initData=_2.defaults=isc.addProperties(_6,this.componentDefaults,_1.defaults);_6._constructor=_3;var _9;if(_4&&_7){_9=isc.ClassFactory.newInstance(_6)}else{_2.generatedType=true;_9=isc.clone(_6)}
_2.liveObject=_9;this.logInfo("palette created component, type: "+_3+", ID: "+_8+(this.logIsDebugEnabled("editing")?", initData: "+this.echo(_6):"")+", liveObject: "+this.echoLeaf(_9),"editing");return _2}});isc.defineClass("HiddenPalette","Class","Palette");if(isc.TreeGrid){isc.defineClass("TreePalette","TreeGrid","Palette");isc.A=isc.TreePalette.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.canDragRecordsOut=true;isc.B.push(isc.A.recordDoubleClick=function(){var _1=this.defaultEditContext;if(_1){if(isc.isA.String(_1))_1=isc.Canvas.getById(_1);if(isc.isAn.EditContext(_1)){_1.addNode(this.makeNewComponent(this.getDragData()))}}}
,isc.A.transferDragData=function(_1){return[this.makeNewComponent(this.getDragData())]}
);isc.B._maxIndex=isc.C+2}
if(isc.ListGrid){isc.defineClass("ListPalette","ListGrid","Palette");isc.A=isc.ListPalette.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.canDragRecordsOut=true;isc.B.push(isc.A.recordDoubleClick=function(){var _1=this.defaultEditContext;if(_1){if(isc.isA.String(_1))_1=isc.Canvas.getById(_1);if(isc.isAn.EditContext(_1)){_1.addNode(this.makeNewComponent(this.getDragData()))}}}
,isc.A.transferDragData=function(){return[this.makeNewComponent(this.getDragData())]}
);isc.B._maxIndex=isc.C+2}
if(isc.Menu){isc.defineClass("MenuPalette","Menu","Palette");isc.A=isc.MenuPalette.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.canDragRecordsOut=true;isc.A.selectionType="single";isc.B.push(isc.A.itemClick=function(_1){var _2=this.defaultEditContext;if(_2){if(isc.isA.String(_2))_2=isc.Canvas.getById(_2);if(isc.isAn.EditContext(_2)){_2.addNode(this.makeNewComponent(this.getDragData()))}}}
,isc.A.transferDragData=function(){return[this.makeNewComponent(this.getDragData())]}
);isc.B._maxIndex=isc.C+2}
isc.ClassFactory.defineClass("EditPane","Canvas","EditContext");isc.A=isc.EditPane.getPrototype();isc.A.canAcceptDrop=true;isc.A.contextMenu={autoDraw:false,data:[{title:"Clear",click:"target.removeAllChildren()"}]};isc.A.editingOn=true;isc.A.canDrag=true;isc.A.dragAppearance="none";isc.A.overflow="hidden";isc.A.selectedComponents=[];isc.A=isc.EditPane.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.outlineBorderStyle="2px dashed red";isc.B.push(isc.A.drop=function(){var _1=isc.EH.dragTarget;if(!_1.isA("Palette"))return this.Super("drop",arguments);var _2=_1.transferDragData(),_3=(isc.isAn.Array(_2)?_2[0]:_2);if(!_3)return false;var _4=this;this.requestLiveObject(_3,function(_3){if(_3)_4.addComponentAtCursor(_3)},_1)
return isc.EH.STOP_BUBBLING}
,isc.A.addNode=function(_1){return this.addComponent(_1)}
,isc.A.addComponent=function(_1){this.logInfo("EditPane adding component: "+this.echoLeaf(_1),"editing");if(this.editComponents==null)this.editComponents=[];this.editComponents.add(_1);var _2=_1.liveObject;this.addChild(_2);if(_2.setEditMode)_2.setEditMode(true,this)}
,isc.A.addComponentAtCursor=function(_1){this.addComponent(_1);var _2=_1.liveObject;_2.moveTo(this.getOffsetX(),this.getOffsetY())}
,isc.A.removeChild=function(_1,_2){this.Super("removeChild",arguments);if(this.editComponents==null)this.editComponents=[];this.editComponents.removeWhere("ID",_1.getID());this.selectedComponents.remove(_1)}
,isc.A.removeAllChildren=function(){if(!this.children)return;var _1=[];for(var i=0;i<this.children.length;i++){if(this.children[i]._eventMask)_1.add(this.children[i])}
for(var i=0;i<_1.length;i++){_1[i].destroy()}}
,isc.A.removeSelection=function(_1){if(this.selectedComponents.length>0){while(this.selectedComponents.length>0){this.selectedComponents[0].destroy()}}else{_1.destroy()}}
,isc.A.click=function(){isc.Canvas.hideResizeThumbs()}
,isc.A.setEditMode=function(_1){if(_1==null)_1=true;if(this.editingOn==_1)return;this.editingOn=_1;var _2=this.editComponents.getProperty("liveObject");_2.map("setEditMode",_1,this)}
,isc.A.childResized=function(_1){var _2=this.Super("childResized",arguments);this.saveCoordinates(_1);return _2}
,isc.A.childMoved=function(_1,_2,_3){var _4=this.Super("childMoved",arguments);this.saveCoordinates(_1);var _5=this.selectedComponents;if(_5.length>0&&_5.contains(_1)){for(var i=0;i<_5.length;i++){if(_5[i]!=_1){_5[i].moveBy(_2,_3)}}}
return _4}
,isc.A.saveCoordinates=function(_1){if(!this.editComponents)return;var _2=this.editComponents.find("liveObject",_1);if(!_2)return;_2.initData=isc.addProperties(_2.initData,{left:_1.getLeft(),top:_1.getTop(),width:_1.getWidth(),height:_1.getHeight()})}
,isc.A.getSaveData=function(){var _1=this.getEditComponents(),_2=[];for(var i=0;i<_1.length;i++){var _4=_1[i],_5=_4.liveObject;var _6={type:_4.type,defaults:_4.defaults};if(_5.getSaveData)_6=_5.getSaveData(_6);_2.add(_6)}
return _2}
,isc.A.mouseDown=function(){if(!this.editingOn)return;var _1=isc.EH.getTarget();if(this.selector==null){this.selector=isc.Canvas.create({autoDraw:false,keepInParentRect:true,left:isc.EH.getX(),top:isc.EH.getY(),redrawOnResize:false,overflow:"hidden",border:"1px solid blue"});this.addChild(this.selector)}
this.startX=this.getOffsetX();this.startY=this.getOffsetY();this.resizeSelector();this.selector.show();this.updateCurrentSelection()}
,isc.A.dragMove=function(){this.resizeSelector()}
,isc.A.mouseUp=function(){if(this.selector)this.selector.hide()}
,isc.A.dragStop=function(){this.selector.hide()}
,isc.A.setOutline=function(_1){if(!_1)return;if(!isc.isAn.Array(_1))_1=[_1];for(var i=0;i<_1.length;i++){_1[i]._eventMask.setBorder(this.outlineBorderStyle)}}
,isc.A.clearOutline=function(_1){if(!_1)return;if(!isc.isAn.Array(_1))_1=[_1];for(var i=0;i<_1.length;i++){_1[i]._eventMask.setBorder("none")}}
,isc.A.updateCurrentSelection=function(){if(!this.children)return;var _1=this.selectedComponents;this.selectedComponents=[];for(var i=0;i<this.children.length;i++){var _3=this.children[i];if(this.selector.intersects(_3)){_3=this.deriveSelectedComponent(_3);if(_3&&!this.selectedComponents.contains(_3)){this.selectedComponents.add(_3)}}}
this.setOutline(this.selectedComponents);_1.removeList(this.selectedComponents);this.clearOutline(_1);var _4=this.selectedComponents.getProperty("ID");window.status=_4.length?"Current Selection: "+_4:""}
,isc.A.deriveSelectedComponent=function(_1){if(_1.masterElement)return this.deriveSelectedComponent(_1.masterElement);if(!_1.parentElement||_1.parentElement==this){if(_1._eventMask)return _1;return null}
return this.deriveSelectedComponent(_1.parentElement)}
,isc.A.resizeSelector=function(){var x=this.getOffsetX(),y=this.getOffsetY();if(this.selector.keepInParentRect){if(x<0)x=0;var _3=this.selector.parentElement.getVisibleHeight();if(y>_3)y=_3}
this.selector.resizeTo(Math.abs(x-this.startX),Math.abs(y-this.startY));if(x<this.startX)this.selector.setLeft(x);else this.selector.setLeft(this.startX);if(y<this.startY)this.selector.setTop(y);else this.selector.setTop(this.startY);this.updateCurrentSelection()}
,isc.A.getSelectedComponents=function(){return this.selectedComponents.duplicate()}
);isc.B._maxIndex=isc.C+23;if(isc.TreeGrid){isc.ClassFactory.defineClass("EditTree","TreeGrid","EditContext");isc.A=isc.EditTree.getPrototype();isc.A.canDragRecordsOut=false;isc.A.canAcceptDroppedRecords=true;isc.A.canReorderRecords=true;isc.A.fields=[{name:"ID",title:"ID",width:"*"},{name:"type",title:"Type",width:"*"}];isc.A.selectionType=isc.Selection.SINGLE;isc.A.autoShowParents=true;isc.A=isc.EditTree.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments);var _1=this.rootComponent||{_constructor:"Object"},_2=isc.isA.Class(_1)?_1.Class:_1._constructor,_3=this.rootLiveObject||_1;var _4={type:_2,_constructor:_2,initData:_1,liveObject:_3};this.setData(isc.Tree.create({idField:"ID",root:_4,isFolder:function(){return true}}))}
,isc.A.canAddToParent=function(_1,_2){var _3=_1.liveObject;if(isc.isA.Class(_3)){return(_3.getObjectField(_2)!=null)}
return(isc.DS.getObjectField(_1,_2)!=null)}
,isc.A.willAcceptDrop=function(){if(!this.Super("willAcceptDrop",arguments))return false;var _1=this.getEventRow(),_2=this.getDropFolder(),_3=this.ns.EH.dragTarget.getDragData();if(_3==null)return false;if(_2==null)_2=this.data.getRoot();if(isc.isAn.Array(_3))_3=_3[0];var _4=_3.className||_3.type;this.logInfo("checking dragType: "+_4+" against dropLiveObject: "+_2.liveObject,"editing");return this.canAddToParent(_2,_4)}
,isc.A.folderDrop=function(_1,_2,_3,_4){if(_4!=this&&!_4.isA("Palette")){return this.Super("folderDrop",arguments)}
if(_4!=this){_1=_4.transferDragData()}
var _5=(isc.isAn.Array(_1)?_1[0]:_1);_5.dropped=true;this.logInfo("sourceWidget is a Palette, dropped node of type: "+_5.type," editing");var _6=this;this.requestLiveObject(_5,function(_7){if(_7==null)return;if(_4==_6)_6.removeComponent(_5,_2,_3);_6.addComponent(_7,_2,_3)},_4)}
,isc.A.addNode=function(_1,_2,_3){return this.addComponent(_1,_2,_3)}
,isc.A.addComponent=function(_1,_2,_3){if(_2==null)_2=this.getDefaultParent(_1);var _4=this.getLiveObject(_2);this.logInfo("addComponent will add newNode of type: "+_1.type+" to: "+this.echoLeaf(_4),"editing");var _5=isc.DS.getObjectField(_4,_1.type),_6=isc.DS.getSchemaField(_4,_5);if(!_6){this.logWarn("can't addComponent: can't find a field in parent: "+_4+" for a new child of type: "+_1.type+", newNode is: "+this.echo(_1));return}
if(!_6.multiple){var _7=isc.DS.getChildObject(_4,_1.type);if(_7){var _8=this.data.getChildren(_2).find("ID",isc.DS.getAutoId(_7));this.logWarn("destroying existing child: "+this.echoLeaf(_7)+" in singular field: "+_5);this.data.remove(_8);if(isc.isA.Class(_7)&&!isc.isA.DataSource(_7))_7.destroy()}}
var _9;if(_1.generatedType){_9=isc.addProperties({},_1.initData);this.addChildData(_9,this.data.getChildren(_1))}else{_9=_1.liveObject}
var _10=isc.DS.addChildObject(_4,_1.type,_9,_3);if(!_10){this.logWarn("addChildObject failed, returning");return}
_1.liveObject=isc.DS.getChildObject(_4,_1.type,isc.DS.getAutoId(_1.initData));this.logDebug("for new node: "+this.echoLeaf(_1)+" liveObject is now: "+this.echoLeaf(_1.liveObject),"editing");if(_1.liveObject==null){this.logWarn("wasn't able to retrieve live object after adding node of type: "+_1.type+" to liveParent: "+_4+", does liveParent have an appropriate getter() method?")}
this.data.add(_1,_2,_3);this.data.openFolder(_1);this.logInfo("added node "+this.echoLeaf(_1)+" to EditTree at path: "+this.getData().getPath(_1)+" with live object: "+this.echoLeaf(_1.liveObject),"editing");this.selection.selectSingle(_1);if(this.autoShowParents)this.showParents(_1);return _1}
,isc.A.getDefaultParent=function(_1){var _2=_1.className||_1.type,_3=this.getSelectedRecord();while(_3&&!this.canAddToParent(_3,_2))_3=this.data.getParent(_3);return _3||this.data.getRoot()}
,isc.A.getLiveObject=function(_1){var _2=this.data.getParent(_1);if(_2==null)return _1.liveObject;var _3=_2.liveObject;return _1.liveObject=isc.DS.getChildObject(_3,_1.type,isc.DS.getAutoId(_1))}
,isc.A.removeAll=function(){var _1=this.data.getChildren(this.data.getRoot()).duplicate()
for(var i=0;i<_1.length;i++){this.removeComponent(_1[i])}}
,isc.A.removeComponent=function(_1){this.data.remove(_1);var _2=this.data.getParent(_1),_3=this.getLiveObject(_2),_4=this.getLiveObject(_1);isc.DS.removeChildObject(_3,_1.type,_4)}
,isc.A.destroyComponent=function(_1){this.removeComponent(_1);var _2=this.getLiveObject(_1);if(_2.destroy)_2.destroy()}
,isc.A.showParents=function(_1){var _2=this.data.getParents(_1),_3=_2.findAll("type","Tab");if(_3){for(var i=0;i<_3.length;i++){var _5=_3[i],_6=this.data.getParent(_5),_7=this.getLiveObject(_5),_8=this.getLiveObject(_6);_8.selectTab(_7)}}}
,isc.A.serializeComponents=function(_1,_2){var _3=isc.SB.create();this.serverless=_1;var _4=_2?[this.data.root]:this.data.getChildren(this.data.root).duplicate();for(var i=0;i<_4.length;i++){var _6=_4[i]=isc.addProperties({},_4[i]),_7=isc.ClassFactory.getClass(_6.type),_8=_6.initData=isc.addProperties({},_6.initData);if(_7&&_7.isA("Canvas")&&_8&&_8.visibility!=isc.Canvas.HIDDEN)
{_8.autoDraw=true}}
this.saveNodes=[];this.map("getSerializeableTree",_4);isc.Comm.omitXSI=true;for(var i=0;i<this.saveNodes.length;i++){var _9=this.saveNodes[i],_10=isc.DS.getNearestSchema(_9);_3.append(_10.xmlSerialize(_9),"\n\n")}
isc.Comm.omitXSI=null;this.serverless=null;return _3.toString()}
,isc.A.getSerializeableTree=function(_1,_2){var _3=_1.type,_4=isc.addProperties({},_1.initData);var _5=isc.ClassFactory.getClass(_3);this.logWarn("node: "+this.echoLeaf(_1)+" with type: "+_3);if(_5&&_5.isA("DataSource")){if(this.saveNodes){var _6=this.saveNodes.find("ID",_4.ID)||this.saveNodes.find("loadID",_4.ID);if(_6&&_6.$schemaId=="DataSource")return}
if(!this.serverless){_4={_constructor:"DataSource",$schemaId:"DataSource",loadID:_4.ID}}else{var _7=_1.liveObject;_4=_7.getSerializeableFields();_4._constructor=_7.Class;_4.$schemaId="DataSource"}}
this.convertActions(_1,_4,_5);var _8=this.data.getChildren(_1);if(!_8){if(this.saveNodes)this.saveNodes.add(_4);return}
this.addChildData(_4,_8);if(_2)return _4;if(this.saveNodes)this.saveNodes.add(_4)}
,isc.A.addChildData=function(_1,_2){var _3=isc.DS.get(_1._constructor);for(var i=0;i<_2.length;i++){var _5=_2[i],_6=_5.initData._constructor,_7=isc.addProperties({},_5.initData),_8=_3.getObjectField(_6),_9=_3.getField(_8);this.logInfo("serializing: child of type: "+_6+" goes in parent field: "+_8,"editing");if((isc.isA.Canvas(_5.liveObject)&&!_5.liveObject._generated)||isc.isA.DataSource(_5.liveObject))
{_7=_7.ID;this.getSerializeableTree(_5)}else{_7=this.getSerializeableTree(_5,true)}
var _10=_1[_8];if(_9.multiple){if(!_10)_10=_1[_8]=[];_10.add(_7)}else{_1[_8]=_7}}}
,isc.A.convertActions=function(_1,_2,_3){for(var _4 in _2){var _5=_2[_4];if(!isc.isAn.Object(_5)||isc.isA.StringMethod(_5))continue;var _6;if(_3.getField)_6=_3.getField(_4).type;if(_6&&(_6!="StringMethod"))continue;var _7=_1.liveObject[_4],_8=_7?_7.iscAction:null,_9;if(_8)_9=true;if(_9)_2[_4]=isc.StringMethod.create({value:_5})}}
);isc.B._maxIndex=isc.C+16}
if(isc.DynamicForm){isc.defineClass("PropertySheet","DynamicForm");isc.A=isc.PropertySheet.getPrototype();isc.A.autoChildItems=true;isc.A.browserSpellCheck=false;isc.A.autoChildDefaults={cellStyle:"propSheetValue",titleStyle:"propSheetTitle",showHint:false};isc.A.GroupItemDefaults={cellStyle:null};isc.A.ExpressionItemDefaults={width:"*",height:18,showActionIcon:true};isc.A.ActionMenuItemDefaults={width:"*",height:18};isc.A.SelectItemDefaults={controlStyle:"propSheetSelectControl",pickListProperties:{cellHeight:16,border:"1px solid black"},height:20,width:"*",pickerIconHeight:15,pickerIconWidth:15,pickerIconSrc:"[SKIN]/DynamicForm/PropSheet_pickbutton.gif",showOver:false};isc.A.DateItemDefaults={width:"*"};isc.A.TextItemDefaults={width:"*",height:16,textBoxStyle:"propSheetField"};isc.A.ColorItemDefaults={width:"*",height:16,pickerIconHeight:16,pickerIconWidth:16,pickerIconSrc:"[SKIN]/DynamicForm/PropSheet_ColorPicker_icon.png",textBoxStyle:"propSheetField"};isc.A.HeaderItemDefaults={cellStyle:"propSheetHeading"};isc.A.TextAreaItemProperties={width:"*"};isc.A.CheckboxItemDefaults={showTitle:true,showLabel:false,getTitleHTML:function(){if(this[this.form.titleField]!=null)return this[this.form.titleField];return this[this.form.fieldIdProperty]}};isc.A.SectionItemDefaults={cellStyle:"propSheetSectionHeaderCell"};isc.A.titleAlign="left";isc.A.titleWidth=120;isc.A.cellSpacing=0;isc.A.cellPadding=0;isc.A.backgroundColor="white";isc.A.requiredTitlePrefix="<span style='color:green'>";isc.A.requiredTitleSuffix="</span>";isc.A.titleSuffix="";isc.A.clipItemTitles=true}
if(isc.ListGrid&&isc.DynamicForm){isc.defineClass("ListEditor",isc.Layout);isc.A=isc.ListEditor.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.vertical=false;isc.A.listDefaults={_constructor:isc.ListGrid,editEvent:"click",listEndEditAction:"next",autoParent:"listLayout",selectionType:isc.Selection.SINGLE,recordClick:"this.creator.recordClick(record)",editorEnter:"this.creator.moreButton.enable()",selectionChanged:"if (this.anySelected()) this.creator.moreButton.enable()",contextMenu:{data:[{title:"Remove",click:"target.creator.removeRecord()"}]}};isc.A.listButtonsDefaults={_constructor:isc.HLayout,autoParent:"listLayout",height:10,width:10,layoutMargin:6,membersMargin:10,overflow:isc.Canvas.VISIBLE};isc.A.newButtonTitle="New";isc.A.newButtonDefaults={_constructor:isc.AutoFitButton,autoParent:"listButtons",click:"this.creator.newRecord()"};isc.A.moreButtonTitle="More..";isc.A.moreButtonDefaults={_constructor:isc.AutoFitButton,autoParent:"listButtons",click:"this.creator.editMore()",disabled:true};isc.A.removeButtonTitle="Remove";isc.A.removeButtonDefaults={_constructor:isc.AutoFitButton,autoParent:"listButtons",click:"this.creator.removeRecord()"};isc.A.formDefaults={_constructor:isc.DynamicForm,autoParent:"formLayout",overflow:isc.Canvas.AUTO};isc.A.formButtonsDefaults={_constructor:isc.HLayout,autoParent:"formLayout",height:10,width:10,layoutMargin:6,membersMargin:10,overflow:isc.Canvas.VISIBLE};isc.A.saveButtonTitle="Save";isc.A.saveButtonDefaults={_constructor:isc.AutoFitButton,autoParent:"formButtons",click:"this.creator.saveRecord()"};isc.A.cancelButtonTitle="Cancel";isc.A.cancelButtonDefaults={_constructor:isc.AutoFitButton,autoParent:"formButtons",click:"this.creator.cancelChanges()"};isc.A.resetButtonTitle="Reset";isc.A.resetButtonDefaults={_constructor:isc.AutoFitButton,autoParent:"formButtons",click:"this.creator.form.resetValues()"};isc.A.listLayoutDefaults={_constructor:isc.VLayout};isc.A.listButtonsOrientation="left";isc.A.formLayoutDefaults={_constructor:isc.VLayout,autoFocus:true};isc.A.animateMembers=true;isc.A.membersMargin=10;isc.A.confirmLoseChangesMessage="Discard changes?";isc.A.formGroup=["formLayout","form","formButtons","saveButton","cancelButton","resetButton"];isc.A.listGroup=["listLayout","list","listButtons","newButton","moreButton"];isc.B.push(isc.A.draw=function(){if(isc.$cv)arguments.$cw=this;if(!this.readyToDraw())return this;if(!this.inlineEdit)this.showMoreButton=this.showMoreButton||false;this.addAutoChildren(this.listGroup);this.addAutoChildren(this.formGroup);return this.Super("draw",arguments)}
,isc.A.configureAutoChild=function(_1,_2){if(isc.isA.Button(_1))_1.title=this[_2+"Title"];if(_1==this.list){_1.dataSource=this.dataSource;_1.fields=this.fields;_1.saveLocally=this.saveLocally;_1.canEdit=this.inlineEdit}
if(this.listButtonsOrientation==isc.Canvas.RIGHT){if(_1==this.listLayout)_1.vertical=false;if(_1==this.formLayout)_1.vertical=false;if(_1==this.listButtons)_1.vertical=true;if(_1==this.formButtons)_1.vertical=true}
if(_1==this.form){_1.dataSource=this.dataSource;_1.fields=this.formFields}
if(this.inlineEdit){if(_1==this.formLayout)_1.visibility=isc.Canvas.HIDDEN}else{if(_1==this.listLayout)_1.showResizeBar=true}}
,isc.A.setDataSource=function(_1,_2){this.dataSource=_1||this.dataSource;if(this.list!=null){this.list.setDataSource(_1,_2);this.form.setDataSource(_1,_2)}}
,isc.A.setData=function(_1){if(_1!=null&&_1.dataSource)this.setDataSource(_1.dataSource);if(this.list!=null){this.list.setData(_1);this.form.clearValues()}else{isc.addProperties(this.listDefaults,{data:_1})}}
,isc.A.getData=function(){if(this.inlineEdit)this.list.endEditing();return this.list.getData()}
,isc.A.cancelChanges=function(){this.form.clearValues();this.showList()}
,isc.A.showList=function(){if(this.inlineEdit){this.formLayout.animateHide({effect:"wipe",startFrom:"R"});this.listLayout.animateShow({effect:"wipe",startFrom:"R"})}}
,isc.A.showForm=function(){if(this.inlineEdit){this.listLayout.animateHide({effect:"wipe",startFrom:"R"});this.formLayout.animateShow({effect:"wipe",startFrom:"R"})}}
,isc.A.recordClick=function(_1){if(this.inlineEdit)return;var _2=function(){if(!this.inlineEdit)this.editRecord(_1);this.form.setValues(isc.addProperties({},this.list.getSelectedRecord()))}
if(!this.form.valuesHaveChanged())_2();else this.confirmLoseChanges(_2)}
,isc.A.getEditRecord=function(){var _1=this.list.getEditRow();if(_1!=null){return this.list.getEditedRecord(_1)}else{return isc.addProperties({},this.list.getSelectedRecord())}}
,isc.A.editMore=function(){this.showForm();this.form.setValues(this.getEditRecord())}
,isc.A.newRecord=function(){if(this.inlineEdit)return this.list.startEditingNew()
var _1=function(){this.list.deselectAllRecords();this.showForm();this.form.editNewRecord()}
if(!this.form.valuesHaveChanges())_1();else this.confirmLoseChanges(_1)}
,isc.A.removeRecord=function(){this.form.clearValues();this.list.removeSelectedData()}
,isc.A.saveRecord=function(){if(!this.form.validate())return false;var _1=this.form.getValues();this.showList();if(this.form.saveOperationType=="add"){this.list.addData(_1)}else{if(this.inlineEdit&&this.list.getEditRow()!=null){var _2=this.list.getEditRow();if(this.list.data[_2]!=null)this.list.updateData(_1)
else this.list.setEditValues(_2,_1)}else{this.list.updateData(_1)}}
return true}
,isc.A.confirmLoseChanges=function(_1){isc.confirm(this.confirmLoseChangesMessages,_1)}
,isc.A.validate=function(){if(this.form.isVisible()&&this.form.valuesHaveChanged()){return this.form.validate()}
return true}
);isc.B._maxIndex=isc.C+16}
isc.ClassFactory.defineClass("ViewLoader",isc.Label);isc.A=isc.ViewLoader.getPrototype();isc.A.loadingMessage="Loading View...";isc.A.align=isc.Canvas.CENTER;isc.A.allowContentAndChildren=true;isc.A.httpMethod="GET";isc.A.useSimpleHttp=true;isc.A.transformXML=true;isc.A.overflow="hidden";isc.A=isc.ViewLoader.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.initWidget=function(){this.Super(this.$oc);if(this.placeholder)this.addChild(this.placeholder);else this.contents=this.loadingMessage}
,isc.A.draw=function(){if(!this.readyToDraw())return this;this.Super("draw",arguments);if(this.view){this.addChild(this.view);this.view.show()}else if(this.viewURL&&!this.loadingView()){this.setViewURL()}
return this}
,isc.A.layoutChildren=function(){this.Super("layoutChildren",arguments);var _1=this.children;if(!_1||_1.length==0)return;var _2=this.children[0],_3=this.getWidth(),_4=this.getHeight();if(_2.$pn!=null)_3=null;if(_2.$po!=null)_4=null;_2.setRect(0,0,_3,_4)}
,isc.A.destroy=function(){if(this.placeholder)this.placeholder.destroy();if(this.view)this.view.destroy();this.Super("destroy",arguments)}
,isc.A.setPlaceholder=function(_1){if(this.placeholder)this.placeholder.destroy();this.placeholder=_1;this.addChild(_1);this.placeholder.sendToBack()}
,isc.A.setViewURL=function(_1,_2,_3){if(_1!=null)this.viewURL=_1;_1=this.viewURL;if(this.placeholder){this.placeholder.show();this.placeholder.bringToFront()}
if(this.view!=null){this.view.hide();this.setContents(this.loadingMessage)}
var _4={},_5=this.useSimpleHttp,_6=this.httpMethod,_7=false;if(!isc.rpc.xmlHttpRequestAvailable()){this.logInfo("XMLHttpRequest not available, using frames comm and expecting RPCResponse");_4={};_5=false;_6="POST";_7=false}
var _8=isc.addProperties({showPrompt:false,actionURL:this.viewURL,httpMethod:_6,useSimpleHttp:_5,bypassCache:!this.allowCaching,params:isc.addProperties(_4,this.viewURLParams,_2)},this.viewRPCProperties,_3,{evalResult:_7,suppressAutoDraw:true,willHandleError:true,callback:this.getID()+".$40p(rpcRequest, rpcResponse, data)"});if(!_8.evalVars)_8.evalVars={};_8.evalVars.viewLoader=this;this.$40t=isc.rpc.sendProxied(_8,true).transactionNum}
,isc.A.loadingView=function(){return this.$40t!=null}
,isc.A.$40p=function(_1,_2,_3){if(_1.transactionNum!=this.$40t){return}
delete this.$40t;this.$40q=false;if(_2.status!=isc.RPCResponse.STATUS_SUCCESS){if(this.handleError(_1,_2)===false)return}
try{if(_1.actionURL.endsWith(".xml")&&this.transformXML){var _4=isc.Canvas._canvasList;var _5=_4.length;isc.xml.toComponents(_3);if(!this.$40q){for(var i=_4.length;i>=_5;i--){var _7=_4[i];if(_7!=null&&isc.isA.Canvas(_7)&&_7.parentElement==null&&_7.masterElement==null)
{this.setView(this.transformView(_7));break}}}
this.$40r()}else{var _8=this;isc.Class.globalEvalWithCapture(_3,function(_9,_10){isc.Log.logWarn("firing the callback from global eval with...");isc.Log.logWarn('viewLoader is:'+_8);if(_10){_8.handleError(_1,_2,_10)}else{_8.$40r(_9)}},_1.evalVars)}}catch(e){this.handleError(_1,_2,e)}}
,isc.A.$40r=function(_1){if(!this.$40q&&_1){for(var i=_1.length;i>=0;i--){var _3=_1[i];var _4=window[_3];if(_4&&isc.isA.Canvas(_4)&&_4.parentElement==null&&_4.masterElement==null)
{this.setView(this.transformView(_4));break}}}
if(!this.$40q){this.logWarn("setView() not explicitly called by loaded view and could"+" not be autodetected for view: "+this.getID())}
this.viewLoaded(this.view)}
,isc.A.transformView=function(_1){return _1}
,isc.A.handleError=function(_1,_2,_3){this.logWarn(_2.data);this.setView(isc.Label.create({contents:_3?_3.toString():_2.data}));return false}
,isc.A.setView=function(_1){if(_1!=null&&_1==this.view)return;this.$40q=true;this.setContents("&nbsp;");if(this.view)this.view.destroy();this.view=_1;if(_1==null)return;this.addChild(_1,null,false);this.layoutChildren();_1.draw();this.logInfo("showing view: "+_1);if(this.placeholder)this.placeholder.hide();this.contents="&nbsp;"}
,isc.A.getView=function(){return this.view}
,isc.A.viewLoaded=function(_1){}
);isc.B._maxIndex=isc.C+14;isc.ClassFactory.defineClass("HTMLFlow","Canvas");isc.A=isc.HTMLFlow;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$49v=0;isc.A.$49w=[];isc.B.push(isc.A.executeScript=function(_1,_2,_3){this.$49w[this.$49v]={callback:_2,displayErrors:_3};this.$49v++;this.getScript(_1,"isc.HTMLFlow.$49x("+this.$49v+",htmlFragments, scripts);")}
,isc.A.$49x=function(_1,_2,_3){var _4=this.$49w[_1];delete this.$49w[_1];var _5=true;for(var i=0;i<this.$49w.length;i++){if(this.$49w[i]!=null){_5=false;break}}
if(_5)this.$49v=0;isc.Class.globalEvalWithCapture(_3,_4.callback,null,_4.displayErrors)}
,isc.A.getScript=function(_1,_2,_3,_4){var _5=_1;var _6,_7,_8,_9;while((_6=_1.match(/<!--/i))!=null){_7=_1.match(/-->/i);if(_7==null||(_7.index<_6.index)){this.logWarn('HTMLFlow content contains an opening comment tag "<!--"'+' with no closing tag "-->", or vice versa. We recommend you review this '+'HTML (original HTML follows):\n'+_5);if(_7){_8=_7.index;_9=_8+3}else{_8=_6.index;_9=_8+4}}else{_8=_6.index;_9=_7.index+3}
_1=_1.slice(0,_8)+_1.slice(_9,_1.length)}
var _10=[];var _11=[];var _12=[];var _13=_1;_1=null;var _14;while((_14=_13.match(/(<script([^>]*)?>)/i))!=null){var _15=_14[1];_12.add(_13.slice(0,_14.index));_10.add(null);_11.add(null);_13=_13.slice(_14.index+_15.length,_13.length)
var _16=_13.match(/<\/script>/i),_17=_13.match(/(<script([^>]*)?>)/i);if(_16==null||(_17&&(_16.index>_17.index))){this.logWarn("HTMLFlow content contains an opening <script ...> tag "+"with no closing tag, or vice versa. Stripping out this tag:"+_15);continue}
var _18=_13.slice(0,_16.index);_13=_13.slice(_16.index+9,_13.length);var _19=(_15.match(/<script\s*(language|type)/i)==null)||(_15.match(/<script\s*(language|type)\s*=["']?[^'"]*(javascript|ecmascript|jscript)[^'"]*["']?/i)
!=null);var _20=_15.match(/ISC_([^.]*)\.js/i);if(_20&&isc["module_"+_20[1]])
continue;if(_19){var _21;if(_21=_15.match(/src=('|")?([^'"> ]*)/i)){_11.add(_21[2]);_10.add(null)}else{if(!isc.isA.String(_18)||isc.isAn.emptyString(_18))continue;_10.add(_18)}
_12.add(null)}else{this.logWarn("html to be evaluated contains non-JS script tags - these will be"+" ignored.  Tag: "+_15)}}
if(_12.length==0)
_12=[_13];if(_11.length>0&&!_4){if(isc.RPCManager){var _22=false;for(var i=0;i<_11.length;i++){if(_11[i]==null){continue}
isc.RPCManager.sendRequest({actionURL:_11[i],serverOutputAsString:true,httpMethod:"GET",clientContext:{scriptIndex:i,scripts:_10,scriptIncludes:_11,callback:_2,htmlFragments:(_3?_12:[_5])},callback:"isc.HTMLFlow.loadedRemoteScriptBlock(data, rpcResponse.clientContext)"});_22=true}
if(_22)return}else{this.logWarn("html contains <script src=> blocks with the "+"following target URLs: "+_11+" If you want "+"these to be dynamically loaded, please include the "+"DataBinding module or include the contents of "+"these files in inline <script> blocks.")}}
var _24=_10.join("\n");this.fireCallback(_2,"htmlFragments,scripts",[_3?_12:[_5],_10])}
,isc.A.loadedRemoteScriptBlock=function(_1,_2){var _3=_2.scriptIndex,_4=_2.scripts,_5=_2.scriptIncludes;_4[_3]=_1;delete _5[_3];for(var i=0;i<_5.length;i++){if(_5[i]!=null)return}
this.fireCallback(_2.callback,"htmlFragments,scripts",[_2.htmlFragments,_4])}
);isc.B._maxIndex=isc.C+4;isc.A=isc.HTMLFlow.getPrototype();isc.A.defaultWidth=200;isc.A.defaultHeight=1;isc.A.allowContentAndChildren=true;isc.A.cursor="auto";isc.A.httpMethod="GET";isc.A.useSimpleHttp=true;isc.A.evalScriptBlocks=true;isc.A.captureSCComponents=true;isc.A=isc.HTMLFlow.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$525=0;isc.B.push(isc.A.initWidget=function(){if(this.contentsType=="page"&&this.overflow=="visible")this.setOverflow("auto")}
,isc.A.draw=function(){if(!this.readyToDraw())return this;this.Super("draw",arguments);var _1;if(this.containsIFrame())return this;else if(this.canSelectText===_1)this.canSelectText=true;if(this.contentsURL&&!(this.$533==this.contentsURL||this.loadingContent()))
{this.setContentsURL()}
return this}
,isc.A.setContentsURL=function(_1,_2,_3){if(this.contentsType=="page"){return this.invokeSuper(isc.HTMLFlow,"setContentsURL",_1)}
if(_1!=null)this.contentsURL=_1;if(this.loadingMessage)this.setContents(this.loadingMessage);var _4=isc.addProperties({},this.contentsURLParams,_2),_5=this.useSimpleHttp,_6=this.httpMethod,_7=true;var _8=isc.addProperties({showPrompt:false,actionURL:this.contentsURL,httpMethod:_6,useSimpleHttp:_5,bypassCache:!this.allowCaching,params:_4},this.contentRPCProperties,_3,{willHandleError:true,serverOutputAsString:_7,callback:this.getID()+".$40s(rpcRequest, rpcResponse)"});this.$40t=isc.rpc.sendProxied(_8,true).transactionNum}
,isc.A.loadingContent=function(){return this.$40t!=null}
,isc.A.$40s=function(_1,_2){var _3=_2.data;if(_2.status!=isc.RPCResponse.STATUS_SUCCESS){if(this.handleError(_1,_2)===false)return}
if(_1.transactionNum!=this.$40t){return}
isc.HTMLFlow.getScript(_3,{target:this,methodName:"$49y"},true,!this.evalScriptBlocks)}
,isc.A.$526=function(_1){if(!_1.parentElement)this.addChild(_1);var _2="HTMLFlow"+this.$525++;_1.htmlElement=_2;var _3='<DIV id="'+_2+'"></DIV>';return _3}
,isc.A.$527=function(_1){if(!_1.parentElement)this.addChild(_1);return null}
,isc.A.$49y=function(_1,_2){this.setContents(this.transformHTML(_1.join("")));if(_1.length>1){if(this.evalScriptBlocks){if(this.isDirty())this.redraw();if(this.captureSCComponents){this.$528=isc.Canvas.autoDraw;isc.setAutoDraw(false)}
for(var i=0;i<_1.length;i++){var _4=null;var _5=this;if(this.captureSCComponents)_4=function(_8,_9){if(!_8.length)return;_1[i]=_8.map(function(_10){var _6=window[_10];if(!_6||!isc.isA.Canvas(_6))return null;if(_6.position==isc.Canvas.RELATIVE)
return _5.$526(_6);else return _5.$527(_6)}).join("")};if(_2[i])isc.Class.globalEvalWithCapture(_2[i],_4)}
if(this.captureSCComponents){this.setContents(this.transformHTML(_1.join("")));if(this.$528){isc.setAutoDraw(true);for(var _7 in window)
if(isc.isA.Canvas(_7)&&_7.autoDraw)
_7.markForRedraw()}}}
else{this.logWarn("html returned by server appears to contain <script> blocks.  "+"If you want these to be evaluated, you must set evalScriptBlocks:true.")}}
this.$40u()}
,isc.A.handleError=function(_1,_2){this.logWarn(_2.data)}
,isc.A.$40u=function(){this.$533=this.contentsURL;this.$40t=null;this.contentLoaded()}
,isc.A.transformHTML=function(_1){return _1}
,isc.A.contentLoaded=function(){}
);isc.B._maxIndex=isc.C+12;isc.HTMLFlow.registerStringMethods({contentLoaded:""})
isc.defineClass("HTMLPane",isc.HTMLFlow);isc.A=isc.HTMLPane.getPrototype();isc.A.overflow=isc.Canvas.AUTO;isc.A.defaultHeight=200;isc.defineClass("WSDataSource","DataSource");isc.A=isc.WSDataSource.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.serviceNamespace="urn:operations.smartclient.com";isc.A.operationBindings=[{operationType:"fetch",wsOperation:"fetch",recordXPath:"//data/*"},{operationType:"add",wsOperation:"add",recordXPath:"//data/*"},{operationType:"remove",wsOperation:"remove",recordXPath:"//data/*"},{operationType:"update",wsOperation:"update",recordXPath:"//data/*"}];isc.B.push(isc.A.transformRequest=function(_1){var _2={dataSource:_1.dataSource,operationType:_1.operationType,data:_1.data};if(_1.startRow!=null){_2.startRow=_1.startRow;_2.endRow=_1.endRow}
if(_1.textMatchStyle!=null)_2.textMatchStyle=_1.textMatchStyle;if(_1.operationId!=null)_2.operationId=_1.operationId;if(_1.sortBy!=null)_2.sortBy=_1.sortBy;return _2}
,isc.A.transformResponse=function(_1,_2,_3){if(!_3||!_3.selectString)return;_1.status=_3.selectString("//status");if(isc.isA.String(_1.status)){var _4=isc.DSResponse[_1.status];if(_1.status==null){this.logWarn("Unable to map response code: "+_4+" to a DSResponse code, setting status to DSResponse.STATUS_FAILURE.");_4=isc.DSResponse.STATUS_FAILURE;_1.data=_3.selectString("//data")}else{_1.status=_4}}
if(_1.status==isc.DSResponse.STATUS_VALIDATION_ERROR){var _5=_3.selectNodes("//errors/*");_1.errors=isc.xml.toJS(_5,null,this)}
_1.totalRows=_3.selectNumber("//totalRows");_1.startRow=_3.selectNumber("//startRow");_1.endRow=_3.selectNumber("//endRow")}
);isc.B._maxIndex=isc.C+2;isc.defineClass("RestDataSource","DataSource");isc.A=isc.RestDataSource.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.serverType="generic";isc.A.dataFormat="xml";isc.A.xmlRecordXPath="/response/data/*";isc.A.jsonRecordXPath="/response/data";isc.A.operationBindings=[{operationType:"fetch",dataProtocol:"getParams"},{operationType:"add",dataProtocol:"postParams"},{operationType:"remove",dataProtocol:"postParams"},{operationType:"update",dataProtocol:"postParams"}];isc.A.sendMetaData=true;isc.A.metaDataPrefix="_";isc.B.push(isc.A.init=function(){this.recordXPath=(this.dataFormat=="xml"?this.xmlRecordXPath:this.jsonRecordXPath);return this.Super("init",arguments)}
,isc.A.getDataURL=function(_1){var _2=_1.operationType;if(_2=="fetch"&&this.fetchDataURL!=null)
return this.fetchDataURL;if(_2=="update"&&this.updateDataURL!=null)
return this.updateDataURL;if(_2=="add"&&this.addDataURL!=null)
return this.addDataURL;if(_2=="remove"&&this.removeDataURL!=null)
return this.removeDataURL;return this.Super("getDataURL",arguments)}
,isc.A.getDataProtocol=function(_1){var _2=this.Super("getDataProtocol",arguments);if(_2=="postXML")_2="postMessage";return _2}
,isc.A.transformRequest=function(_1){var _2=this.getDataProtocol(_1);if(_2=="postMessage"){if(this.dataFormat=="json"){this.logWarn('DataSource dataProtocol specified for operation as "postMessage". '+'Data will be sent to the server as a serialized xml message'+' even though dataFormat is set to "json"')}
var _3={dataSource:this.getID(),operationType:_1.operationType,operationId:_1.operationId,startRow:_1.startRow,endRow:_1.endRow,sortBy:_1.sortBy,textMatchStyle:_1.textMatchStyle};if(this.sendClientContext)_3.clientContext=_1.clientContext;if(_1.componentId)_3.componentId=_1.componentId;var _4=isc.DataSource.create({fields:[{name:"data",multiple:true,type:this.getID()},{name:"oldValues",type:this.getID()}]});_3.data=_1.data;_3.oldValues=_1.oldValues;return _4.xmlSerialize(_3,null,null,"request")}else{if(_2!="getParams"&&_2!="postParams"){this.logWarn("RestDataSource operation:"+_1.operationID+", of type "+_1.operationType+" has dataProtocol specified as '"+_2+"'. Supported protocols are 'postParams', 'getParams' "+"and 'postMessage' only. Defaulting to 'getParams'.");_1.dataProtocol='getParams'}
var _3=isc.addProperties({},_1.data,_1.params);if(this.sendMetaData){if(!this.parameterNameMap){var _5={};_5[this.metaDataPrefix+"operationType"]="operationType";_5[this.metaDataPrefix+"operationId"]="operationId";_5[this.metaDataPrefix+"startRow"]="startRow";_5[this.metaDataPrefix+"endRow"]="endRow";_5[this.metaDataPrefix+"sortBy"]="sortBy";_5[this.metaDataPrefix+"textMatchStyle"]="textMatchStyle";_5[this.metaDataPrefix+"oldValues"]="oldValues";_5[this.metaDataPrefix+"componentId"]="componentId";this.parameterNameMap=_5}
for(var _6 in this.parameterNameMap){var _7=_1[this.parameterNameMap[_6]];if(_7!=null)_3[_6]=_7}
_3[this.metaDataPrefix+"dataSource"]=this.getID()}
return _3}}
,isc.A.getValidStatus=function(_1){if(isc.isA.String(_1)){if(parseInt(_1)==_1)_1=parseInt(_1);else{_1=isc.DSResponse[_1];if(_1==null){this.logWarn("Unable to map response code: "+_1+" to a DSResponse code, setting status to DSResponse.STATUS_FAILURE.");_1=isc.DSResponse.STATUS_FAILURE}}}
if(_1==null)_1=isc.DSResponse.STATUS_SUCCESS;return _1}
,isc.A.transformResponse=function(_1,_2,_3){if(_1.status<0)return _1;if(this.dataFormat=="json"){var _4=_3.response||{};_1.status=this.getValidStatus(_4.status);if(_1.status==isc.DSResponse.STATUS_VALIDATION_ERROR){var _5=_4.errors;if(isc.isAn.Array(_5)){if(_5.length>1){this.logWarn("server returned an array of errors - ignoring all but the first one")}
_5=_5[0]}
_1.errors=_5}else if(_1.status<0){_1.data=_4.data}
if(_4.totalRows!=null)_1.totalRows=_4.totalRows;if(_4.startRow!=null)_1.startRow=_4.startRow;if(_4.endRow!=null)_1.endRow=_4.endRow}else{_1.status=this.getValidStatus(_3.selectString("//status"));if(_1.status==isc.DSResponse.STATUS_VALIDATION_ERROR){var _5=_3.selectNodes("//errors");_5=isc.xml.toJS(_5);if(_5.length>1){this.logWarn("server returned an array of errors - ignoring all but the first one")}
_5=_5[0];_1.errors=_5}else if(_1.status<0){_1.data=_3.selectString("//data")}
var _6=_3.selectNumber("//totalRows");if(_6!=null)_1.totalRows=_6;var _7=_3.selectNumber("//startRow");if(_7!=null)_1.startRow=_7;var _8=_3.selectNumber("//endRow");if(_8!=null)_1.endRow=_8}
return _1}
);isc.B._maxIndex=isc.C+6;isc.DataSource.create({
Constructor:"DataSource",
ID:"DataSource",
addGlobalId:"false",
fields:{
ID:{required:"true",type:"string",xmlAttribute:"true"},
inheritsFrom:{title:"Superclass",type:"string"},
useParentFieldOrder:{type:"boolean"},
useLocalFieldsOnly:{type:"boolean"},
restrictToParentFields:{type:"boolean"},
dataFormat:{
title:"DataFormat",
type:"string",
xmlAttribute:"true",
valueMap:{custom:"Custom Binding",iscServer:"ISC Java Server",json:"JSON Web Service",
xml:"XML / WSDL Web Service"}
},
noAutoFetch:{type:"boolean",xmlAttribute:"true"},
serverType:{
title:"Server Type",
type:"string",
xmlAttribute:"true",
valueMap:{custom:"Custom Server Binding",sql:"ISC Server SQL Connectors"}
},
callbackParam:{title:"Callback Parameter",type:"string",xmlAttribute:"true"},
requestProperties:{type:"Object"},
fields:{childTagName:"field",multiple:"true",propertiesOnly:"true",type:"DataSourceField",
uniqueProperty:"name"},
addGlobalId:{title:"Add Global ID",type:"boolean"},
showPrompt:{type:"boolean"},
dbName:{title:"Database Name",type:"string",xmlAttribute:"true"},
tableName:{title:"Table Name",type:"string",xmlAttribute:"true"},
serverObject:{type:"ServerObject"},
operationBindings:{multiple:"true",type:"OperationBinding"},
serviceNamespace:{type:"string",xmlAttribute:"true"},
dataURL:{type:"string",xmlAttribute:"true"},
dataProtocol:{type:"string",xmlAttribute:"true"},
dataTransport:{type:"string",xmlAttribute:"true"},
defaultParams:{type:"Object"},
soapAction:{type:"string"},
jsonPrefix:{type:"string"},
jsonSuffix:{type:"string"},
messageTemplate:{type:"string"},
defaultCriteria:{propertiesOnly:"true",type:"Object",visibility:"internal"},
tagName:{type:"string",visibility:"xmlBinding"},
recordXPath:{type:"XPath"},
recordName:{type:"string"},
xmlNamespaces:{type:"Object"},
dropExtraFields:{type:"boolean"},
schemaNamespace:{type:"string",visibility:"internal",xmlAttribute:"true"},
mustQualify:{type:"boolean",visibility:"internal"},
xsdSimpleContent:{type:"boolean",visibility:"internal"},
xsdAnyElement:{type:"boolean",visibility:"internal"},
xsdAbstract:{type:"boolean",visibility:"internal"},
title:{title:"Title",type:"string"},
titleField:{title:"Title Field",type:"string"},
pluralTitle:{title:"Plural Title",type:"string"},
clientOnly:{title:"Client Only",type:"boolean",xmlAttribute:"true"},
testFileName:{title:"Test File Name",type:"URL",xmlAttribute:"true"},
testData:{multiple:"true",type:"Object"},
types:{multiple:"true",propertiesOnly:"true",type:"DataSourceField",uniqueProperty:"ID",
visibility:"internal"},
groups:{multiple:"true",type:"string",visibility:"internal"},
methods:{multiple:"true",type:"MethodDeclaration",visibility:"internal"},
showSuperClassActions:{type:"boolean"},
createStandalone:{type:"boolean"},
useFlatFields:{type:"boolean"},
showLocalFieldsOnly:{type:"boolean",xmlAttribute:"true"},
globalNamespaces:{type:"Object"}
}
})
isc.DataSource.create({
ID:"DataSourceField",
addGlobalId:"false",
fields:{
name:{primaryKey:"true",required:"true",title:"Name",type:"string",xmlAttribute:"true"},
type:{title:"Type",type:"string",xmlAttribute:"true"},
required:{title:"Required",type:"boolean",xmlAttribute:"true"},
valueMap:{type:"ValueMap"},
validators:{multiple:"true",propertiesOnly:"true",type:"Validator"},
length:{title:"Length",type:"positiveInteger",xmlAttribute:"true"},
xmlRequired:{type:"boolean",visibility:"internal"},
xmlNonEmpty:{type:"boolean",visibility:"internal"},
xsElementRef:{type:"boolean",visibility:"internal"},
canHide:{title:"User can hide",type:"boolean"},
xmlAttribute:{type:"boolean",visibility:"internal"},
mustQualify:{type:"boolean",visibility:"internal"},
valueXPath:{title:"Value XPath",type:"XPath",xmlAttribute:"true"},
childrenProperty:{type:"boolean"},
title:{title:"Title",type:"string",xmlAttribute:"true"},
detail:{title:"Detail",type:"boolean",xmlAttribute:"true"},
canEdit:{title:"Can Edit",type:"boolean",xmlAttribute:"true"},
inapplicable:{inapplicable:"true",title:"Inapplicable",type:"boolean"},
advanced:{inapplicable:"true",title:"Advanced",type:"boolean"},
visibility:{inapplicable:"true",title:"Visibility",type:"string"},
hidden:{inapplicable:"true",title:"Hidden",type:"boolean",xmlAttribute:"true"},
primaryKey:{title:"Is Primary Key",type:"boolean",xmlAttribute:"true"},
foreignKey:{title:"Foreign Key",type:"string",xmlAttribute:"true"},
rootValue:{title:"Tree Root Value",type:"string",xmlAttribute:"true"},
nativeName:{hidden:"true",title:"Native Name",type:"string"},
fieldName:{hidden:"true",title:"Field Name",type:"string"},
fields:{hidden:"true",multiple:"true",propertiesOnly:"true",type:"DataSourceField",
uniqueProperty:"name"},
multiple:{type:"boolean"},
pickListFields:{multiple:"true",type:"Object"}
}
})
isc.DataSource.create({
ID:"Validator",
addGlobalId:"false",
fields:{
type:{type:"string"},
stopIfFalse:{type:"boolean"},
clientOnly:{type:"boolean"},
errorMessage:{type:"string"},
max:{type:"number"},
min:{type:"number"},
mask:{type:"regexp"},
transformTo:{type:"regexp"},
precision:{type:"integer"},
expression:{type:"string"},
otherField:{type:"string"},
list:{multiple:"true",type:"text"},
valueMap:{type:"ValueMap"},
substring:{type:"text"},
operator:{type:"text"},
count:{type:"integer"}
}
})
isc.DataSource.create({
Constructor:"SimpleType",
inheritsFrom:"DataSourceField",
ID:"SimpleType",
fields:{
inheritsFrom:{type:"string",name:"inheritsFrom"},
editorType:{type:"string",name:"editorType"}
},
addGlobalId:false
})
isc.DataSource.create({Constructor:"XSComplexType",inheritsFrom:"DataSource",ID:"XSComplexType",addGlobalId:false})
isc.DataSource.create({Constructor:"XSElement",inheritsFrom:"DataSource",ID:"XSElement",addGlobalId:false})
isc.DataSource.create({
Constructor:"SchemaSet",
ID:"SchemaSet",
fields:{
schemaNamespace:{type:"url",name:"schemaNamespace"},
qualifyAll:{type:"boolean",name:"qualifyAll"},
schema:{type:"DataSource",name:"schema",multiple:true}
},
addGlobalId:false
})
isc.DataSource.create({Constructor:"WSDLMessage",inheritsFrom:"DataSource",ID:"WSDLMessage",addGlobalId:false})
isc.DataSource.create({
Constructor:"WebService",
ID:"WebService",
fields:{
location:{type:"url",name:"location"},
targetNamespace:{type:"url",name:"targetNamespace"},
operations:{type:"WebServiceOperation",name:"operations",multiple:true},
messages:{type:"WSDLMessage",name:"messages",multiple:true},
globalNamespaces:{type:"Object",name:"globalNamespaces"}
},
addGlobalId:false
})
isc.DataSource.create({
ID:"WebServiceOperation",
fields:{
name:{title:"Operation Name",name:"name",required:true},
soapAction:{title:"SOAPAction Header",name:"soapAction"},
inputMessage:{title:"Input Message",name:"inputMessage"},
outputMessage:{title:"Input Message",name:"outputMessage"},
inputHeaders:{type:"WSOperationHeader",name:"inputHeaders",multiple:true},
outputHeaders:{type:"WSOperationHeader",name:"outputHeaders",multiple:true}
},
addGlobalId:false
})
isc.DataSource.create({
ID:"WSOperationHeader",
fields:{
encoding:{name:"encoding"},
message:{name:"message"},
part:{name:"part"}
},
addGlobalId:false
})
isc.defineClass("Operators","Class");isc.A=isc.Operators;isc.A.equalsTitle="equals";isc.A.notEqualTitle="not equal";isc.A.greaterThanTitle="greater than";isc.A.lessThanTitle="less than";isc.A.greaterOrEqualTitle="greater than or equal to";isc.A.lessOrEqualTitle="less than or equal to";isc.A.betweenTitle="between";isc.A.betweenInclusiveTitle="between (inclusive)";isc.A.iContainsTitle="contains";isc.A.iStartsWithTitle="starts with";isc.A.iEndsWithTitle="ends with";isc.A.containsTitle="contains (match case)";isc.A.startsWithTitle="starts with (match case)";isc.A.endsWithTitle="ends with (match case)";isc.A.iNotContainsTitle="does not contain";isc.A.iNotStartsWithTitle="does not start with";isc.A.iNotEndsWithTitle="does not end with";isc.A.notContainsTitle="does not contain (match case)";isc.A.notStartsWithTitle="does not start with (match case)";isc.A.notEndsWithTitle="does not end with (match case)";isc.A.isNullTitle="is null";isc.A.notNullTitle="not null";isc.A.regexpTitle="matches expression (exact case)";isc.A.iregexpTitle="matches expression";isc.A.inSetTitle="is one of";isc.A.notInSetTitle="is not one of";isc.A.equalsFieldTitle="matches other field";isc.A.notEqualFieldTitle="differs from field";isc.A.andTitle="Match All";isc.A.notTitle="Match None";isc.A.orTitle="Match Any";if(isc.DynamicForm){isc.defineClass("FilterBuilder","Layout");isc.A=isc.FilterBuilder.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.vertical=false;isc.A.vPolicy="none";isc.A.height=1;isc.A.defaultWidth=400;isc.A.showFieldTitles=true;isc.A.showRemoveButton=true;isc.A.removeButtonDefaults={_constructor:isc.ImgButton,width:18,height:18,layoutAlign:"center",src:"[SKIN]/actions/remove.png",showRollOver:false,showDown:false,showDisabled:false,prompt:"Remove",click:function(){this.creator.removeButtonClick(this.clause)}};isc.A.showAddButton=true;isc.A.addButtonDefaults={_constructor:isc.ImgButton,autoParent:"buttonBar",width:18,height:18,src:"[SKIN]/actions/add.png",showRollOver:false,showDown:false,prompt:"Add",click:function(){this.creator.addButtonClick(this.clause)}};isc.A.buttonBarDefaults={_constructor:isc.HStack,autoParent:"clauseStack",membersMargin:4,defaultLayoutAlign:"center",height:1};isc.A.topOperator="and";isc.A.radioOptions=["and","or","not"];isc.A.topOperatorAppearance="bracket";isc.A.radioOperatorFormDefaults={_constructor:isc.DynamicForm,autoParent:"clauseStack",height:1,items:[{name:"operator",type:"radioGroup",showTitle:false,vertical:false,width:250,changed:function(_1,_2,_3){_1.creator.topOperatorChanged(_3)}}]};isc.A.topOperatorFormDefaults={height:1,width:80,numCols:1,colWidths:["*"],layoutAlign:"center",_constructor:isc.DynamicForm,items:[{name:"operator",type:"select",showTitle:false,width:"*",changed:function(_1,_2,_3){_1.creator.topOperatorChanged(_3)}}]};isc.A.defaultSubClauseOperator="or";isc.A.filterRow=[{type:"select",name:"fieldName",showTitle:false,width:150,changed:function(){this.form.creator.fieldNameChanged(this.form)}},{name:"operator",type:"select",showTitle:false,width:150,addUnknownValues:false,defaultToFirstOption:true,changed:function(){this.form.creator.operatorChanged(this.form)}}];isc.A.clauseConstructor=isc.DynamicForm;isc.A.clauseDefaults={$10j:"Enter",handleKeyPress:function(_1,_2){var _3=this.getFocusItem();if(isc.isA.TextItem(_3))_2.firedOnTextItem=true;if(_1.keyName!=this.$10j){return this.Super("handleKeyPress",[_1,_2])}},itemChanged:function(_1,_2,_3){if(this.creator.itemChanged)this.creator.itemChanged()}};isc.A.clauseStackDefaults={_constructor:isc.VStack,height:1,membersMargin:1,animateMembers:true,animateMemberTime:300};isc.A.clauseLayoutDefaults={_constructor:isc.HStack,height:1};isc.A.rangeSeparator=">>";isc.A.subClauseButtonDefaults={_constructor:"IButton",autoParent:"buttonBar",title:"+()",autoFit:true,prompt:"Add Subclause",click:function(){this.creator.addSubClause(this.clause)}};isc.A.bracketDefaults={styleName:"bracketBorders",width:10};isc.A.$10j="Enter";isc.B.push(isc.A.addButtonClick=function(){this.addNewClause()}
,isc.A.removeButtonClick=function(_1){this.removeClause(_1)}
,isc.A.removeClause=function(_1){this.clauses.remove(_1);var _2=_1.clauseLayout;this.clauseStack.hideMember(_2,function(){_2.destroy()})
if(this.firstRemoveButton)this.updateFirstRemoveButton()}
,isc.A.updateFirstRemoveButton=function(){var _1=this.clauses[0];if(this.clauses.length==1&&!this.allowEmpty){_1.removeButton.disable();_1.removeButton.setOpacity(50)}else if(this.clauses.length>1){_1.removeButton.enable();_1.removeButton.setOpacity(100)}}
,isc.A.setTopOperator=function(_1){this.topOperator=_1;var _2=this.topOperatorAppearance;if(_2=="bracket"){this.topOperatorForm.setValue("operator",_1)}else if(_2=="radio"){this.radioOperatorForm.setValue("operator",_1)}}
,isc.A.topOperatorChanged=function(_1){this.topOperator=_1}
,isc.A.initWidget=function(){this.Super("initWidget",arguments);var _1;if(this.showSubClauseButton==_1){this.showSubClauseButton=(this.topOperatorAppearance!="radio")}
this.clauses=[];var _2=this.topOperatorAppearance;var _3=this.getDataSource().getTypeOperatorMap("text",true,"criteria"),_4=[];for(var _5 in _3){_4.add(_5)}
if(_2=="bracket"){if(this.showTopRemoveButton){var _6=this.createAutoChild("removeButton",{click:function(){this.creator.parentClause.removeButtonClick(this.creator)}});this.clauseLayout=this;this.addMember(_6)}
this.addAutoChild("topOperatorForm");this.topOperatorForm.items[0].valueMap=_4;this.topOperatorForm.items[0].defaultValue=this.topOperator;this.addAutoChild("bracket")}
this.addAutoChild("clauseStack");if(_2=="radio"){this.addAutoChild("radioOperatorForm");var _7={};for(var i=0;i<this.radioOptions.length;i++){_7[this.radioOptions[i]]=_3[this.radioOptions[i]]}
this.radioOperatorForm.items[0].valueMap=_7;this.radioOperatorForm.items[0].defaultValue=this.topOperator}
this.addAutoChildren(["buttonBar","addButton","subClauseButton"]);if(this.criteria){this.setCriteria(this.criteria)}else if(!this.allowEmpty&&!this.dontCreateEmptyChild){this.addNewClause()}
this.setTopOperator(this.topOperator)}
,isc.A.addNewClause=function(_1){var _2=isc.clone(this.filterRow);var _3=this.getDataSource().getFieldNames(),_4=[];for(var i=0;i<_3.length;i++){var _6=_3[i];if(this.getDataSource().getField(_6).hidden)continue;_4.add(_3[i])}
var _7={};for(i=0;i<_4.length;i++){_6=_4[i];if(this.showFieldTitles){var _8=this.getDataSource().getField(_6).title;_8=_8?_8:_6;_7[_6]=_8}else{_7[_6]=_6}}
_2[0].valueMap=_7;if(_1&&_1.fieldName){if(_4.contains(_1.fieldName)){_2[0].defaultValue=_1.fieldName}else{isc.logWarn("Criterion specified field "+_1.fieldName+", which is not"+" in the record. Using the first record field ("+_4[0]+") instead");_2[0].defaultValue=_4[0]}}else{_2[0].defaultValue=_4[0]}
var _9=this.getDataSource().getFieldOperatorMap(_4[0],false,"criteria",true);_2[1].valueMap=_9;if(_1&&_1.operator){_2[1].defaultValue=_1.operator}else{_2[1].defaultValue=isc.firstKey(_9)}
var _10=this.getDataSource().getSearchOperator(_2[1].defaultValue),_11=this.getDataSource().getField(_2[0].defaultValue);if(!_10){isc.logWarn("Criterion specified unknown operator "+_1.operator+". Using the first valid operator ("+isc.firstKey(_9)+") instead");_2[1].defaultValue=isc.firstKey(_9);_10=this.getDataSource().getSearchOperator(_2[1].defaultValue)}
var _12=this.buildValueItemList(_11,_10);if(_1){if(_1.value!=null&&_12.containsProperty("name","value")){_12.find("name","value").defaultValue=_1.value}
if(_1.start!=null&&_12.containsProperty("name","start")){_12.find("name","start").defaultValue=_1.start}
if(_1.end!=null&&_12.containsProperty("name","end")){_12.find("name","end").defaultValue=_1.end}}
_2.addList(_12);var _13=this.createAutoChild("clause",{flattenItems:true,items:_2});this.clauses.add(_13);this.updateFields(_13);var _14=this.createAutoChild("removeButton");var _15=[_14];_15.add(_13);var _16=this.createAutoChild("clauseLayout",{visibility:"hidden",members:_15});_13.removeButton=_14;_13.clauseLayout=_16;_14.clause=_13;var _17=this.clauseStack;var _18=Math.max(0,_17.getMemberNumber(this.buttonBar));_17.addMember(_16,_18);_17.showMember(_16,function(){_13.focusInItem("fieldName")});this.updateFirstRemoveButton()}
,isc.A.buildValueItemList=function(_1,_2){var _3=_1.name,_4=_2.valueType,_5=isc.SimpleType.getType(_1.type)||isc.SimpleType.getType("text"),_6=[];while(_5.inheritsFrom){_5=isc.SimpleType.getType(_5.inheritsFrom)}
_5=_5.name;if(_4=="valueSet"){return}else if(_4=="fieldType"||_4=="custom"){var _7=null;if(_4=="custom"&&_2.editorType){_7=_2.editorType}
var _8=isc.addProperties({type:_5,name:"value",showTitle:false,width:150,editorType:_7,changed:function(){this.form.creator.valueChanged(this,this.form)}},this.getValueFieldProperties(_1.type,_3));if(_1.type=="enum"){_8-isc.addProperties(_8,{valueMap:_1.valueMap})}
_6.add(_8)}else if(_4=="fieldName"){var _9=this.getDataSource().getFieldNames();_9.remove(_3);_6.add(isc.addProperties({type:"select",name:"value",showTitle:false,width:150,valueMap:_9,changed:function(){this.form.creator.valueChanged(this,this.form)}},this.getValueFieldProperties(_1.type,_3)))}else if(_4=="valueRange"){_6.addList([isc.addProperties({type:_5,name:"start",showTitle:false,width:150,changed:function(){this.form.creator.valueChanged(this,this.form)}},this.getValueFieldProperties(_1.type,_3)),isc.addProperties({type:"staticText",name:"rangeSeparator",showTitle:false,width:1,defaultValue:this.rangeSeparator,shouldSaveValue:false,changed:function(){this.form.creator.valueChanged(this,this.form)}},this.getValueFieldProperties(_1.type,_3)),isc.addProperties({type:_5,name:"end",showTitle:false,width:150,changed:function(){this.form.creator.valueChanged(this,this.form)}},this.getValueFieldProperties(_1.type,_3))])}
return _6}
,isc.A.valueChanged=function(_1,_2){}
,isc.A.fieldNameChanged=function(_1){this.updateFields(_1)}
,isc.A.removeValueFields=function(_1){if(_1.getItem("value"))_1.removeItem("value");if(_1.getItem("rangeSeparator"))_1.removeItem("rangeSeparator");if(_1.getItem("start"))_1.removeItem("start");if(_1.getItem("end"))_1.removeItem("end")}
,isc.A.operatorChanged=function(_1){var _2=_1.getValue("fieldName");if(_2==null)return;var _3=this.getDataSource().getField(_2);var _4=this.getDataSource().getSearchOperator(_1.getValue("operator"));this.removeValueFields(_1);var _5=this.buildValueItemList(_3,_4)
_1.addItems(_5)}
,isc.A.updateFields=function(_1){var _2=_1.getValue("fieldName");if(_2==null)return;var _3=this.getDataSource().getField(_2);var _4=this.getDataSource().getSearchOperator(_1.getValue("operator"));_1.getItem("operator").setValueMap(this.getDataSource().getFieldOperatorMap(_3,false,"criteria",true));if(_1.getItem("value")&&(_3.type||"text")==_1.getItem("value").type)return;this.removeValueFields(_1);_1.setValue("value",null);if(_1.getItem("start"))_1.setValue("start",null);if(_1.getItem("end"))_1.setValue("end",null);_1.addItems(this.buildValueItemList(_3,_4))}
,isc.A.getFieldOperators=function(_1){var _2=this.getDataSource().getField(_1)
return this.getDataSource().getFieldOperators(_2)}
,isc.A.getValueFieldProperties=function(_1,_2){}
,isc.A.childResized=function(){this.Super("childResized",arguments);if(this.clauseStack&&this.bracket)this.bracket.setHeight(this.clauseStack.getVisibleHeight())}
,isc.A.draw=function(){this.Super("draw",arguments);if(this.clauseStack&&this.bracket)this.bracket.setHeight(this.clauseStack.getVisibleHeight())}
,isc.A.addSubClause=function(_1){var _2;if(_1){_2=_1.operator}
var _3=this.createAutoChild("subClause",{dataSource:this.dataSource,parentClause:this,showTopRemoveButton:true,topOperatorAppearance:"bracket",topOperator:_2||this.defaultSubClauseOperator,visibility:"hidden",saveOnEnter:this.saveOnEnter,dontCreateEmptyChild:_1!=null},this.Class);this.clauses.add(_3);this.clauseStack.addMember(_3,this.clauses.length-1);this.clauseStack.showMember(_3,function(){_3.topOperatorForm.focusInItem("operator")
_3.bracket.setHeight(_3.getVisibleHeight())});return _3}
,isc.A.getCriteria=function(){var _1={_constructor:"AdvancedCriteria",operator:this.topOperator,criteria:[]};for(var i=0;i<this.clauses.length;i++){var _3=this.clauses[i],_4,_5=false;if(isc.isA.FilterBuilder(_3)){_4=_3.getCriteria()}else{_4=_3.getValues();if(isc.isA.Date(_4.value))_4.value.logicalDate=true;var _6=_4.operator;if(isc.isA.String(_6))_6=this.getDataSource().getSearchOperator(_6);if(_6.valueType!="none"&&_6.valueType!="valueRange"&&(_4.value==null||_4.value==""))
{_5=true}}
if(!_5)_1.criteria.add(_4)}
return isc.clone(_1)}
,isc.A.setCriteria=function(_1){this.clearCriteria(true);if(!_1){return}
if(_1._constructor!="AdvancedCriteria"){_1=this.getDataSource().convertCriteria(_1,"substring")}
this.setTopOperator(_1.operator);if(!_1.criteria||_1.criteria.length==0){this.logWarn("Found top-level AdvancedCriteria with no sub-criteria. Converting "+"to a top-level 'and' with a single sub-criterion");this.setTopOperator("and");this.addNewClause(_1)}else{for(var i=0;i<_1.criteria.length;i++){this.addCriterion(_1.criteria[i])}}}
,isc.A.clearCriteria=function(_1){while(this.clauses.length>0){this.removeClause(this.clauses[0])}
if(!_1&&!this.allowEmpty)this.addNewClause()}
,isc.A.addCriterion=function(_1){if(_1.criteria){var _2=this.addSubClause(_1);for(var _3=0;_3<_1.criteria.length;_3++){_2.addCriterion(_1.criteria[_3])}}else{this.addNewClause(_1)}}
,isc.A.handleKeyPress=function(_1,_2){if(_1.keyName==this.$10j){if(this.saveOnEnter){if(_2.firedOnTextItem){if(!this.creator&&this.search){this.search(this.getCriteria());return isc.EH.STOP_BUBBLING}}}}}
,isc.A.itemChanged=function(){if(this.creator&&isc.isA.Function(this.creator.itemChanged)){this.creator.itemChanged()}else{if(!this.creator&&isc.isA.Function(this.filterChanged)){this.filterChanged()}}}
);isc.B._maxIndex=isc.C+25;isc.FilterBuilder.registerStringMethods({search:"criteria",filterChanged:""})}
isc.defineClass("BatchUploader","VStack");isc.A=isc.BatchUploader.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.defaultWidth="80%";isc.A.uploadFormDefaults={_constructor:"DynamicForm",updateOperation:"upload"};isc.A.uploadFileLabel="Upload File";isc.A.uploadButtonDefaults={_constructor:"IButton",title:"Upload",click:"this.creator.upload()"};isc.A.gridDefaults={_constructor:"ListGrid",defaultHeight:500,canEdit:true,editByCell:true,validateByCell:true,autoSaveEdits:false};isc.A.cancelCommitButtonLayoutDefaults={_constructor:"HLayout"};isc.A.commitButtonDefaults={_constructor:"IButton",title:"Commit",click:"this.creator.commitClicked()",autoParent:"cancelCommitButtonLayout"};isc.A.cancelButtonDefaults={_constructor:"IButton",title:"Cancel",click:"this.creator.cancelClicked()",autoParent:"cancelCommitButtonLayout"};isc.A.partialCommit="prompt";isc.A.partialCommitPrompt="There are errors in your data so it cannot all be saved.  "+"If you proceed, you will lose the records with errors.  Click 'OK' "+"to proceed anyway, or 'Cancel' to return to your data";isc.A.partialCommitError="There are errors in your data.  Please correct all errors before "+"clicking Commit";isc.A.warnOnCancel=true;isc.A.cancelConfirmMessage="You will lose any work you have done on this data. Proceed anyway?";isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments);if(!this.uploadFormFields)this.uploadFormFields=[];this.uploadFormFields.add({name:"file",type:"file",title:this.uploadFileLabel});this.uploadFormFields.add({name:"dsName",type:"hidden",defaultValue:isc.DataSource.getDataSource(this.uploadDataSource).ID});this.addAutoChild("uploadForm",{fields:this.uploadFormFields});this.addAutoChild("uploadButton");var _1=this.uploadForm.getFileItemForm();if(_1)_1.updateOperation=this.uploadForm.updateOperation;var _2=this;isc.XMLTools.loadXML(isc.Page.getURL("[APP]shared/ds/batchUpload.ds.xml"),function(_3,_4){_2.createUploadDataSource(_3,_4)})}
,isc.A.createUploadDataSource=function(_1,_2){var _3=isc.XMLTools.toJS(_1);if(!isc.isAn.Array(_3.operationBindings)){_3.operationBindings=[_3.operationBindings.operationBinding]}
isc.DataSource.create(_3)}
,isc.A.upload=function(){this.uploadForm.dataSource=null;if(!this.uploadForm.validate(false,false))return;this.uploadForm.dataSource="batchUpload";isc.rpc.startQueue();var _1=this.uploadForm.fields;for(var i=0;i<_1.length;i++){_1[i].value=this.uploadForm.getValue(_1[i].name)}
var _3=this;isc.DMI.call("isc_builtin","com.isomorphic.tools.BuiltinRPC","setAttributes","session",_1,this.uploadFieldPrefix,null);this.uploadForm.saveData(function(_4,_5,_6){_3.uploadReply(_5)});isc.rpc.sendQueue()}
,isc.A.uploadReply=function(_1){var _2=this.grid;if(!_2){if(isc.ListGrid){_2=this.addAutoChild("grid");this.addAutoChildren(["cancelCommitButtonLayout","commitButton","cancelButton"])}}
_2.setDataSource(this.uploadDataSource);_2.setData(_1.gridRows);if(_1.errors){for(var i=0;i<_1.errors.length;i++){var _4=_1.errors[i];isc.logWarn("rowNum: "+_4.rowNum+", error: "+isc.echoAll(_4.errors));_2.setRowErrors(_4.rowNum,_4.errors)}
var _5=_1.errors[0].rowNum;_2.delayCall("scrollRecordIntoView",[_5])}
_2.show()}
,isc.A.commitClicked=function(){var _1=this.grid,_2=_1.data,_3=false;for(var i=0;i<_2.length;i++){if(_1.getRowErrors(i)){_3=true;break}}
if(_3){if(this.partialCommit=="prevent"){isc.say(this.partialCommitError);return}
if(this.partialCommit=="prompt"){var _5=this;isc.warn(this.partialCommitPrompt,function(_6){if(_6)_5.commit()},{buttons:[isc.Dialog.OK,isc.Dialog.CANCEL]});return}}
this.commit()}
,isc.A.commit=function(){var _1=this.grid.data,_2=this;for(var i=0;i<_1.length;i++)
isc.rpc.startQueue();var _4=isc.DataSource.getDataSource(this.grid.dataSource);for(var i=0;i<_1.length;i++){_4.addData(this.grid.getEditedRecord(i),function(){isc.say("Records added",function(){_2.cleanup()})})}
isc.rpc.sendQueue()}
,isc.A.cancelClicked=function(){if(this.warnOnCancel){var _1=this;isc.warn(this.cancelConfirmMessage,function(_2){if(_2)_1.cleanup()},{buttons:[isc.Dialog.OK,isc.Dialog.CANCEL]});return}
this.cleanup()}
,isc.A.cleanup=function(){this.grid.destroy();this.grid=null;this.cancelCommitButtonLayout.destroy();this.cancelCommitButtonLayout=null;this.commitButton.destroy();this.commitButton=null;this.cancelButton.destroy();this.cancelButton=null}
);isc.B._maxIndex=isc.C+8;isc.screenReader=false;isc.A=isc.Canvas.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.addPrimaryRole=function(){if(!isc.Browser.isMoz||isc.Browser.geckoVersion<20051111)return;if(!this.waiRole)return;var _1=this.getClipHandle();isc.Canvas.setWAIRole(_1,this.waiRole);var _2=this.waiStateProps;if(_2)return;for(var _3 in _2){var _4=_2[_3],_5=this[_4];if(_5==null)continue;isc.Canvas.setWAIState(_1,_3,_5)}}
,isc.A.addContentRoles=function(){}
);isc.B._maxIndex=isc.C+2;isc.A=isc.Canvas;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.waiStateNS="http://www.w3.org/2005/07/aaa";isc.A.xhtml2NS="http://www.w3.org/TR/xhtml2";isc.B.push(isc.A.setWAIRole=function(_1,_2){_1.setAttributeNS(this.xhtml2NS,"role","wairole:"+_2)}
,isc.A.setWAIState=function(_1,_2,_3){_1.setAttributeNS(this.waiStateNS,_2,_3)}
,isc.A.setWAIStates=function(_1,_2){for(var _3 in _2){this.setWAIState(_1,_3,_2[_3])}}
);isc.B._maxIndex=isc.C+3;if(isc.DynamicForm){isc.A=isc.FormItem.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.addContentRoles=function(){if(!isc.Browser.isMoz||isc.Browser.geckoVersion<20051111)return;if(!this.$kk())return;var _1=this.getFocusElement();if(_1!=null)isc.Canvas.setWAIRole(_1,this.waiRole)}
);isc.B._maxIndex=isc.C+1}
if(isc.GridRenderer){isc.A=isc.GridRenderer.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.addContentRoles=function(){if(!isc.Browser.isMoz||isc.Browser.geckoVersion<20051111)return;var _1=this.parentElement;if(!_1||(!_1.rowRole&&!_1.getRowRole))return;for(var i=this.$252;i<=this.$253;i++){var _3=i,_4=this.getTableElement(_3),_5=_1.getRowRole?_1.getRowRole(_3):_1.rowRole;if(_5&&_4){isc.Canvas.setWAIRole(_4,_5);if(_1.getRowWAIState){var _6=_1.getRowWAIState(_3);if(_6)isc.Canvas.setWAIStates(_4,_6)}}
this.addCellRoles(_3)}}
,isc.A.addCellRoles=function(_1){var _2=this.parentElement;if(!_2||(!_2.cellRole&&!_2.getCellRole))return;for(var i=this.$254;i<=this.$255;i++){var _4=this.getTableElement(_1,i),_5=_2.getCellRole?_2.getCellRole(_1,i):_2.cellRole;if(_5){isc.Canvas.setWAIRole(_4,_5);if(_2.getCellWAIState){var _6=_2.getCellWAIState(_1,i);if(_6)isc.Canvas.setWAIStates(_4,_6)}}}}
);isc.B._maxIndex=isc.C+2;isc.A=isc.ListGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.waiRole="list";isc.A.rowRole="listitem";isc.B.push(isc.A.getRowRole=function(_1){var _2=this.getCellRecord(_1);if(_2&&_2.isSeparator)return"separator";return this.rowRole}
,isc.A.getRowWAIState=function(_1){var _2=this.getRecord(_1);if(this.selection&&this.selection.isSelected(_1)){return{selected:true}}}
);isc.B._maxIndex=isc.C+2;isc.A=isc.TreeGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.waiRole="tree";isc.A.rowRole="treeitem";isc.B.push(isc.A.getRowRole=function(_1){if(!isc.isA.Tree(this.data)){return this.rowRole}
var _2=this.getRecord(_1);if(this.data.isFolder(_2))return"group";else return this.rowRole}
,isc.A.getRowWAIState=function(_1){var _2=this.getRecord(_1),_3=this.data,_4=!!(this.selection&&this.selection.isSelected(_2));if(!_4&&!_3.isFolder(_2))return;var _5={selected:_4};if(_3.isFolder(_2))_5.expanded=!!_3.isOpen(_2);return _5}
);isc.B._maxIndex=isc.C+2;isc.A=isc.Menu.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.waiRole="menu";isc.B.push(isc.A.getRowRole=function(_1){var _2=this.getItem(_1);if(!_2||_2.isSeparator)return"separator";if(_2.checked||_2.checkIf||_2.checkable)return"menuitemcheckable";if(_2.radio)return"menuitemradio";return"menuitem"}
,isc.A.getRowState=function(_1){if(this.hasSubmenu(this.getItem(_1)))return{haspopup:true}}
);isc.B._maxIndex=isc.C+2;isc.A=isc.MenuButton.getPrototype();isc.A.waiRole="menu";isc.A=isc.MenuBar.getPrototype();isc.A.waiRole="menubar"}
(function(){var _1={Button:"button",StretchImgButton:"button",ImgButton:"button",Label:"label",CheckboxItem:"checkbox",Slider:"slider",ComboBoxItem:"combobox",SelectItem:"list",Window:"dialog",Toolbar:"toolbar",TabBar:"tablist",PaneContainer:"tabpanel",ImgTab:"tab",EdgedCanvas:"presentation",BackMask:"presentation"}
for(var _2 in _1){var _3=isc.ClassFactory.getClass(_2);if(_3)_3.addProperties({waiRole:_1[_2]})}})();isc._moduleEnd=isc._DataBinding_end=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc.Log&&isc.Log.logIsInfoEnabled('loadTime'))isc.Log.logInfo('DataBinding module init time: ' + (isc._moduleEnd-isc._moduleStart) + 'ms','loadTime');}else{if(window.isc && isc.Log && isc.Log.logWarn)isc.Log.logWarn("Duplicate load of module 'DataBinding'.");}
/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

