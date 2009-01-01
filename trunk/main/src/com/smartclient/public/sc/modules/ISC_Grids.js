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

if(window.isc&&window.isc.module_Core&&!window.isc.module_Grids){isc.module_Grids=1;isc._moduleStart=isc._Grids_start=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc._moduleEnd&&(!isc.Log||(isc.Log && isc.Log.logIsDebugEnabled('loadTime')))){isc._pTM={ message:'Grids load/parse time: ' + (isc._moduleStart-isc._moduleEnd) + 'ms', category:'loadTime'};
if(isc.Log && isc.Log.logDebug)isc.Log.logDebug(isc._pTM.message,'loadTime')
else if(isc._preLog)isc._preLog[isc._preLog.length]=isc._pTM
else isc._preLog=[isc._pTM]}isc.ClassFactory.defineInterface("List");isc.List.addInterfaceMethods({init:function(){if(!this.data)this.data=[]},first:function(){return this.get(0)},last:function(){return this.get(this.getLength()-1)},indexOf:function(_1,_2,_3){if(_2==null)_2=0;if(_3==null)_3=this.getLength()-1;for(var i=_2;i<=_3;i++){if(this.get(i)==_1)return i}
return-1},lastIndexOf:function(_1,_2,_3){if(_2==null)_2=this.getLength()-1;if(_3==null)_3=0;for(var i=_2;i>=_3;i--)
if(this.get(i)==_1)return i;return-1},findNextIndex:function(_1,_2,_3,_4){var _5=this.getLength();if(_1==null)_1=0;else if(_1>=_5)return-1;if(_4==null)_4=_5-1;if(_2==null)return-1;if(isc.isA.String(_2)){for(var i=_1;i<=_4;i++){var _7=this.get(i);if(_7&&_7[_2]==_3)return i}
return-1}else{return this.findNextMatch(_2,_1,_4)}},findAll:function(_1,_2){if(_1==null)return null;if(isc.isA.String(_1)){var _3=null,l=this.getLength();for(var i=0;i<l;i++){var _6=this.get(i);if(_6&&_6[_1]==_2){if(_3==null)_3=[];_3.add(_6)}}
return _3}else{return this.findAllMatches(_1)}},getRange:function(_1,_2){if(_2==null)_2=this.getLength()-1;var _3=[];for(var i=_1;i<_2;i++){_3[_3.length]=this.get(i)}
return _3},duplicate:function(){return this.newInstance().addList(this)},add:function(_1,_2){var _3;if(_2!==_3){return this.addAt(_1,_2)}
this.addAt(_1,this.getLength());return _1},setLength:function(_1){this.$ed();if(_1>this.getLength()){var _2;while(_1>this.getLength())this.add(_2)}else{while(_1<this.getLength())this.removeAt(this.getLength()-1)}
this.$ee()},addListAt:function(_1,_2){this.$ed();var _3=_1.getLength();for(var i=0;i<_3;i++){this.addAt(_1.get(i),_2+i)}
this.$ee();return _1},remove:function(_1){var _2=this.indexOf(_1);if(_2==-1)return false;this.$ed();var _3=this.getLength();for(var i=_2;i<_3;i++)this.set(i,this.get(i+1));this.setLength(_3-1);this.$ee();return true},removeList:function(_1){if(_1==null)return null;this.$ed();var _2=false;for(var i=0;i<this.getLength();i++){var _4=this.get(i);if(_1.contains(_4)){_2=true;this.removeAt(i);i--}}
this.$ee();return _1},sort:function(_1){var _2=this.getRange(0,this.getLength());_2.sort(_1);for(var i=0;i<_2.length;i++)this.set(i,_2[i]);return this},sortByProperty:function(_1,_2,_3,_4){var _5=this.getRange(0,this.getLength());_5.sortByProperty(_1,_2,_3,_4);for(var i=0;i<_5.length;i++)this.set(i,_5[i]);return this},dataChanged:function(){}});isc.$27b=function(){var _1=["isEmpty","contains","containsAll","intersect","equals","getItems","addList","getValueMap","removeEvery","$ed","$ee","$52z","getItem","setItem","removeItem","clearAll","find","findIndex","findNextMatch","findAllMatches","findByKeys","size","subList","addAll","removeAll","clear"];var _2={};for(var i=0;i<_1.length;i++){var _4=_1[i];_2[_4]=Array.prototype[_4]}
isc.List.addInterfaceMethods(_2)}
isc.$27b();isc.A=isc.isA;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$27c="List";isc.B.push(isc.A.List=function(_1){if(_1==null)return false;if(isc.isA.Array(_1))return true;return _1.isA&&_1.isA(this.$27c)}
);isc.B._maxIndex=isc.C+1;isc.ClassFactory.defineClass("Tree",null,"List");isc.A=isc.Tree;isc.A.FOLDERS_AND_LEAVES=null;isc.A.FOLDERS_ONLY="folders";isc.A.LEAVES_ONLY="leaves";isc.A.UNLOADED=null;isc.A.LOADING="loading";isc.A.FOLDERS_LOADED="folders";isc.A.LOADED="loaded";isc.A.PARENT="parent";isc.A.CHILDREN="children";isc.A.autoID=0;isc.A=isc.Tree.getPrototype();isc.A.modelType="children";isc.A.isFolderProperty="isFolder";isc.A.reportCollisions=true;isc.A.autoSetupParentLinks=true;isc.A.pathDelim="/";isc.A.treeProperty="$42c";isc.A.nameProperty="name";isc.A.titleProperty="title";isc.A.childrenProperty="children";isc.A.cacheOpenList=true;isc.A.discaredParentlessNodes=false;isc.A.sortDirection=Array.ASCENDING;isc.A.showRoot=false;isc.A.autoOpenRoot=true;isc.A.separateFolders=false;isc.A.defaultNodeTitle="Untitled";isc.A.defaultLoadState=isc.Tree.UNLOADED;isc.A=isc.Tree.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$27d=0;isc.A.loadBatchSize=50;isc.B.push(isc.A.init=function(){isc.ClassFactory.addGlobalID(this);if(!this.parentProperty)this.parentProperty="_parent_"+this.ID;if(!this.isFolderProperty)this.isFolderProperty="_isFolder_"+this.ID;if(this.idField==null)this.idField="id";if(this.parentIdField==null)this.parentIdField="parentId";if(!this.openProperty)this.openProperty="_isOpen_"+this.ID;this.setRoot(this.root||this.makeRoot());if(this.loadOnInit&&this.loadBatchSize>=0)this.loadSubtree(null,null,true)}
,isc.A.destroy=function(){if(window[this.ID]==this)window[this.ID]=null}
,isc.A.makeRoot=function(){var _1={};var _2;if(this.idField!==_2)_1[this.idField]=this.rootValue;return _1}
,isc.A.convertToFolder=function(_1){_1[this.isFolderProperty]=true}
,isc.A.makeNode=function(_1,_2){var _3=this.find(_1);if(_3){if(_2)this.convertToFolder(_3);return _3}
var _4=_1.split(this.pathDelim);var _5=this.getRoot()[this.nameProperty];if(_5.endsWith(this.pathDelim))
_5=_5.substring(0,_5.length-this.pathDelim.length);if(_4[0]!=_5)_4.addAt(_5,0);var _6=_4[_4.length-1],_7=(_6!=isc.emptyString);if(!_7){_4.length=_4.length-1;_6=_4[_4.length-1]}
var _8=_4.slice(0,(_4.length-1)).join(this.pathDelim)+this.pathDelim;var _9=this.find(_8);if(_9==null){_9=this.find(_8.substring(0,_8.length-this.pathDelim.length))}
if(!_9){_9=this.makeNode(_8,_2)}else if(!this.isFolder(_9)){this.convertToFolder(_9)}
var _3={};_3[this.nameProperty]=_6;if(!_7)this.convertToFolder(_3);return this.add(_3,_9)}
,isc.A.isRoot=function(_1){return this.root==_1}
,isc.A.setupParentLinks=function(_1){if(!_1)_1=this.root;this.nodeIndex[_1[this.idField]]=_1;var _2=_1[this.childrenProperty];if(_2){this.setLoadState(_1,isc.Tree.LOADED);if(!isc.isAn.Array(_2)){_2=_1[this.childrenProperty]=[_2]}}
if(!_2||_2.length==0)return;for(var i=0,_4=_2.length,_5;i<_4;i++){_5=_2[i];if(!_5)continue;if(_5[this.parentIdField]==null&&_1[this.idField]!=null)
_5[this.parentIdField]=_1[this.idField];_5[this.parentProperty]=_1;if(this.isFolder(_5))this.setupParentLinks(_5);else this.nodeIndex[_5[this.idField]]=_5}}
,isc.A.connectByParentID=function(_1,_2,_3,_4,_5){this.linkNodes(_1,_2,_3,_4,_5)}
,isc.A.connectByParentId=function(_1,_2,_3,_4,_5){this.linkNodes(_1,_2,_3,_4,_5)}
,isc.A.linkNodes=function(_1,_2,_3,_4,_5,_6){if(this.modelType=="fields"){this.connectByFields(_1);return}
_1=_1||this.data;_2=_2||this.idField;_3=_3||this.parentIdField;_4=_4||this.rootValue;var _7=_1;var _8=this.logIsDebugEnabled("treeLinking");while(_7.length>0){var _9=_7,_10=false;_7=[];for(var i=0;i<_9.length;i++){var _12=_9[i],_13=_12[_3],_14=this.nodeIndex[_13];if(_14!=null){if(_8){this.logDebug("found parent "+_14[_2]+" for child "+_12[_2],"treeLinking")}
this.$27e(_12,_14);_10=true}else if(_13==null&&_6){if(_8){this.logDebug("child:"+_12[_2]+" has no explicit parent - linking to default node "+_6[_2],"treeLinking")}
this.$27e(_12,_6);_10=true}else if(this.discardParentlessNodes&&_13!=_4&&_13!=null&&_13!=-1&&_13!=isc.emptyString)
{if(_8){this.logDebug("couldn't place child: "+_12[_2],"treeLinking")}
_7.add(_12)}else{if(_8){this.logDebug("root node: "+_12[_2],"treeLinking")}
this.$27e(_12,this.root);_10=true}}
if(_8){this.logDebug("end of linking pass: "+_7.length+" unplaced children"+", found new parents: "+_10,"treeLinking")}
if(!_10&&_7.length>0){this.logWarn("Couldn't find parents: "+_7.getProperty(_3)+", unplaced children: "+_7.getProperty(_2),"treeLinking");break}}
this.$27f();this.dataChanged()}
,isc.A.connectByFields=function(_1){if(!_1)_1=this.data;for(var i=0;i<_1.length;i++){this.addNodeByFields(_1[i])}}
,isc.A.addNodeByFields=function(_1){var _2=this.root;for(var i=0;i<this.fieldOrder.length;i++){var _4=this.fieldOrder[i],_5=_1[_4];var _6=_5,_7=this.findChildNum(_2,_6),_8;if(_7!=-1){_8=this.getChildren(_2).get(_7)}else{_8={};_8[this.nameProperty]=_6;this.add(_8,_2);this.convertToFolder(_8)}
_2=_8}
this.add(_1,_2)}
,isc.A.getRoot=function(){return this.root}
,isc.A.setRoot=function(_1,_2){this.root=_1;if(_1&&this.parentProperty.endsWith(this.ID))_1[this.parentProperty]=null;if(this.rootValue==null)this.rootValue=this.root[this.idField];var _3=this.root[this.nameProperty];if(_3==null||_3==isc.emptyString)this.root[this.nameProperty]=this.pathDelim;if(!this.isFolder(this.root))this.convertToFolder(this.root);this.nodeIndex={};if("parent"==this.modelType){if(this.data)this.linkNodes()}else if("fields"==this.modelType){if(this.data)this.connectByFields()}else if("children"==this.modelType){if(this.autoSetupParentLinks)this.setupParentLinks();if(this.data){var _4=this.data;this.data=null;this.addList(_4,this.root)}}else{this.logWarn("Unsupported modelType: "+this.modelType)}
if(_2!==false&&(this.autoOpenRoot||_2)){this.openFolder(_1)}
this.setupParentLinks();this.$27f();this.dataChanged()}
,isc.A.getCleanNodeData=function(_1,_2){if(_1==null)return null;var _3=[],_4=false;if(!isc.isAn.Array(_1)){_1=[_1];_4=true}
for(var i=0;i<_1.length;i++){var _6=_1[i],_7={};for(var _8 in _6){if(_8==this.parentProperty||_8=="$27g"||_8=="$42c"||_8.startsWith("_isOpen_")||_8.startsWith("_isFolder_")||_8.startsWith("$399")||_8=="$40a"||_8.startsWith("_selection_")||(_2==false&&_8==this.childrenProperty))continue;_7[_8]=_6[_8];if(_8==this.childrenProperty&&isc.isAn.Array(_7[_8])){_7[_8]=this.getCleanNodeData(_7[_8])}}
_3.add(_7)}
if(_4)return _3[0];return _3}
,isc.A.getName=function(_1){var _2=isc.$ad;if(!_1)return _2;var _3=_1[this.nameProperty];if(_3==null)_3=_1[this.idField];if(_3==null){if(!this.isDescendantOf(_1,this.root)&&_1!=this.root)return null;if(!this.$27h)this.$27h=isc.Tree.autoID+++"_";_3=this.$27h+this.$27d++}
if(!isc.isA.String(_3))_3=_2+_3;_1[this.nameProperty]=_3;return _3}
,isc.A.getTitle=function(_1){if(!_1)return null;if(_1[this.titleProperty]!=null)return _1[this.titleProperty];var _2=_1[this.nameProperty];if(_2==null)_2=this.defaultNodeTitle;return(isc.endsWith(_2,this.pathDelim)?_2.substring(0,_2.length-this.pathDelim.length):_2)}
,isc.A.getPath=function(_1){var _2=this.getParent(_1);if(_2==null)return this.getName(_1);var _3=this.getName(_2);return this.getPath(_2)+(_3==this.pathDelim?isc.emptyString:this.pathDelim)+this.getName(_1)}
,isc.A.getParentPath=function(_1){var _2=this.getName(_1),_3=this.getPath(_1);return _3.substring(0,_3.length-_2.length-this.pathDelim.length)}
,isc.A.getParent=function(_1){if(_1==null)return null;return _1[this.parentProperty]}
,isc.A.getParents=function(_1){var _2=[],_3=this.getParent(_1);while(_3){_2.add(_3);if(_3==this.root)break;_3=this.getParent(_3)}
return _2}
,isc.A.getLevel=function(_1){return this.getParents(_1).length}
,isc.A.$59a=function(_1){var _2=[],_3=this.getParents(_1),_4=_3.length;for(var i=0;i<_4;i++){var _6=this.getChildren(_3[i]);if(_6.indexOf(_1)!=_6.length-1)_2.add(_4-i);_1=_3[i]}
return _2}
,isc.A.isFolder=function(_1){if(_1==null)return false;var _2=_1[this.isFolderProperty];if(_2!=null)return _2;if(_1[this.childrenProperty])return true;var _3=this.getName(_1);if(_3==null)return false;return isc.endsWith(_3,this.pathDelim)}
,isc.A.isLeaf=function(_1){return!this.isFolder(_1)}
,isc.A.isLast=function(_1){var _2=this.getParent(_1);if(!_2)return true;var _3=this.getChildren(_2,this.opendisplayNodeType,this.$27i,this.sortDirection,null,this.$45g);return _3[_3.length-1]==_1}
,isc.A.findById=function(_1){return this.find(this.idField,_1)}
,isc.A.find=function(_1,_2){var _3;if(_2===_3&&isc.isA.String(_1))return this.$27j(_1);if(_2!==_3){if(_1==this.idField)return this.nodeIndex[_2];if(this.root[_1]==_2)return this.root;return this.getDescendants().find(_1,_2)}else{var _4=this.getDescendants();_4.add(this.root);return _4.find(_1)}}
,isc.A.findAll=function(_1,_2){return this.getDescendants().findAll(_1,_2)}
,isc.A.$27j=function(_1){if(_1==this.pathDelim)return this.root;var _2=this.getPath(this.root);if(_1==_2)return this.root;var _3=this.root,_4=0,_5=this.pathDelim.length;if(isc.startsWith(_1,_2)){_4=_2.length}else if(isc.startsWith(_1,this.pathDelim)){_4+=_5}
while(true){var _6=_1.indexOf(this.pathDelim,_4);if(_6==_4){_4++;continue}
var _7=(_6!=-1),_8=_1.substring(_4,_7?_6:_1.length),_9=this.findChildNum(_3,_8);if(_9==-1)return null;_3=_3[this.childrenProperty][_9];if(!_7)return _3;_4=_6+_5;if(_4==_1.length)return _3}}
,isc.A.findChildNum=function(_1,_2){var _3=this.getChildren(_1);if(_3==null)return-1;if(_2==null)return-1;var _4=_3.getLength(),_5=isc.endsWith(_2,this.pathDelim),_6=this.pathDelim.length;for(var i=0;i<_4;i++){var _8=this.getName(_3.get(i)),_9=_8.length-_2.length;if(_9==0&&_8==_2)return i;if(_9==_6){if(isc.startsWith(_8,_2)&&isc.endsWith(_8,this.pathDelim)&&!_5)
{return i}}else if(_5&&_9==-_6){if(isc.startsWith(_2,_8))return i}}
return-1}
,isc.A.getChildren=function(_1,_2,_3,_4,_5,_6){if(_1==null)_1=this.root;if(this.isLeaf(_1))return null;if(_1[this.childrenProperty]==null){var _7=[];_1[this.childrenProperty]=_7;return _7}
var _8=_1[this.childrenProperty],_9;if(_5){_9=[];for(var i=0,_11=_8.length;i<_11;i++){var _12=_8[i];if(this.fireCallback(_5,"node,parent,tree",[_12,_1,this]))
_9[_9.length]=_12}
_8=_9}
if(_2==isc.Tree.FOLDERS_ONLY){_9=[];for(var i=0,_11=_8.length;i<_11;i++){if(this.isFolder(_8[i]))_9[_9.length]=_8[i]}}else if(_2==isc.Tree.LEAVES_ONLY){_9=[];for(var i=0,_11=_8.length;i<_11;i++){if(this.isLeaf(_8[i]))_9[_9.length]=_8[i]}}else{_9=_8}
if(_3){_9.sortByProperty(this.sortProp,_4,_3,_6)}
return _9}
,isc.A.getFolders=function(_1,_2,_3,_4,_5){return this.getChildren(_1,isc.Tree.FOLDERS_ONLY,_2,_3,_4,_5)}
,isc.A.getLeaves=function(_1,_2,_3,_4,_5){return this.getChildren(_1,isc.Tree.LEAVES_ONLY,_2,_3,_4,_5)}
,isc.A.hasChildren=function(_1,_2){var _3=this.getChildren(_1,_2);return _3&&_3.length>0}
,isc.A.hasFolders=function(_1){return this.hasChildren(_1,isc.Tree.FOLDERS_ONLY)}
,isc.A.hasLeaves=function(_1){return this.hasChildren(_1,isc.Tree.LEAVES_ONLY)}
,isc.A.isDescendantOf=function(_1,_2){if(_1==_2)return false;var _3=_1;while(_3!=null){if(_3==_2)return true;_3=_3[this.parentProperty]}
return false}
,isc.A.getDescendants=function(_1,_2,_3){if(!_1)_1=this.root;var _4=[];if(!_3)_3=function(){return true};if(this.isLeaf(_1))return _4;var _5=this.getChildren(_1);if(!_5)return _4;for(var i=0,_7=_5.length,_8;i<_7;i++){_8=_5[i];if(this.isFolder(_8)){if(_2!=isc.Tree.LEAVES_ONLY&&_3(_8))
_4[_4.length]=_8;_4=_4.concat(this.getDescendants(_8,_2,_3))}else{if(_2!=isc.Tree.FOLDERS_ONLY&&_3(_8)){_4[_4.length]=_8}}}
return _4}
,isc.A.getDescendantFolders=function(_1,_2){return this.getDescendants(_1,isc.Tree.FOLDERS_ONLY,_2)}
,isc.A.getDescendantLeaves=function(_1,_2){return this.getDescendants(_1,isc.Tree.LEAVES_ONLY,_2)}
,isc.A.dataChanged=function(){}
,isc.A.add=function(_1,_2,_3){if(isc.isA.String(_2))_2=this.find(_2);else if(!this.getParent(_2)&&_2!==this.getRoot()){isc.logWarn('Tree.add(): parent is not in the tree, returning');return}
if(!_2){var _4=this.getParentPath(_1);if(_4)_2=this.find(_4);if(!_2)return false}
this.$27e(_1,_2,_3);this.$27f();this.dataChanged();return _1}
,isc.A.$580=function(_1){if(this.reportCollisions){this.logWarn("Adding node to tree with id property set to:"+_1+". A node with this ID is already present in this Tree - that node will be "+"replaced. Note that this warning may be disabled by setting the "+"reportCollisions attribute to false.")}}
,isc.A.$27e=function(_1,_2,_3){var _4=_1[this.idField];if(_4!=null&&this.modelType==isc.Tree.PARENT){var _5=this.findById(_4);if(_5){this.$580(_4);this.remove(_5)}}
this.getName(_1);this.convertToFolder(_2);var _6=_2[this.childrenProperty];if(!_6)_6=_2[this.childrenProperty]=[];if(_6!=null&&!isc.isAn.Array(_6))
_2[this.childrenProperty]=_6=[_6];if(_3==null||_3>_6.length){_6.add(_1)}else{_6.addAt(_1,_3)}
var _7=this.idField
_1[this.parentIdField]=_2[_7];_1[this.parentProperty]=_2;_1[this.treeProperty]=this.ID;if(_1[_7])this.nodeIndex[_1[_7]]=_1;this.setLoadState(_2,isc.Tree.LOADED);var _8=_1[this.childrenProperty];if(_8!=null){_1[this.childrenProperty]=[];if(!isc.isAn.Array(_8))this.$27e(_8,_1);else if(_8.length>0)this.$27k(_8,_1);this.setLoadState(_1,isc.Tree.LOADED)}else{var _9=_1[this.isFolderProperty];if(_9!=null&&!isc.isA.Boolean(_9))
_9=isc.booleanValue(_9,true);if(_9==null&&this.defaultIsFolder)_9=true;_1[this.isFolderProperty]=_9}}
,isc.A.addList=function(_1,_2,_3){if(isc.isA.String(_2))_2=this.find(_2);if(!_2)return false;this.$27k(_1,_2,_3);this.$27f();this.dataChanged();return _1}
,isc.A.$27k=function(_1,_2,_3){for(var i=0,_5=_1.length;i<_5;i++){this.$27e(_1[i],_2,_3!=null?_3++:null)}}
,isc.A.move=function(_1,_2,_3){this.moveList([_1],_2,_3)}
,isc.A.moveList=function(_1,_2,_3){var _4=_1[0],_5=this.getParent(_4),_6=this.getChildren(_5).indexOf(_4);this.removeList(_1);if(_2==_5&&_1.length==1){if(_3>_6)_3--}else{var _7=this.getChildren(_2);if(_7&&_3>_7.length)_3=_7.length}
this.addList(_1,_2,_3);this.dataChanged()}
,isc.A.remove=function(_1,_2){var _3=this.getParent(_1);if(!_3)return false;var _4=this.getChildren(_3);if(!_4)return false;if(_4.remove(_1)){delete this.nodeIndex[_1[this.idField]];if(!_2){this.$27f();this.dataChanged()}
return true}
return false}
,isc.A.removeList=function(_1){var _2=false;for(var _3=_1.length-1,i=_3;i>=0;i--){if(this.remove(_1[i],true))_2=true}
if(_2){this.$27f();this.dataChanged()}
return _2}
,isc.A.getLoadState=function(_1){if(!_1)return null;if(!_1.$27g)return this.defaultLoadState;return _1.$27g}
,isc.A.isLoaded=function(_1){var _2=this.getLoadState(_1);return(_2==isc.Tree.LOADED||_2==isc.Tree.LOADING)}
,isc.A.setLoadState=function(_1,_2){_1.$27g=_2}
,isc.A.loadRootChildren=function(_1){this.loadChildren(this.root,_1)}
,isc.A.loadChildren=function(_1,_2){if(!_1)_1=this.root;this.setLoadState(_1,isc.Tree.LOADED);if(_2){this.fireCallback(_2,"node",[_1],this)}}
,isc.A.unloadChildren=function(_1,_2){if(this.isLeaf(_1))return;var _3;if(_2==isc.Tree.LEAVES_ONLY){_3=this.getLeaves(_1);_1[this.childrenProperty]=this.getFolders(_1);this.setLoadState(_1,isc.Tree.FOLDERS_LOADED)}else{_3=_1[this.childrenProperty];_1[this.childrenProperty]=[];this.setLoadState(_1,isc.Tree.UNLOADED)}
if(_3){for(var i=0;i<_3.length;i++){var _1=_3[i];delete this.nodeIndex[_1[this.idField]]}}
this.$27f();this.dataChanged()}
,isc.A.reloadChildren=function(_1,_2){this.unloadChildren(_1,_2);this.loadChildren(_1,_2)}
,isc.A.$27f=function(){this.$q7=true}
,isc.A.isOpen=function(_1){return _1!=null&&_1[this.openProperty]}
,isc.A.getOpenFolders=function(_1){if(_1==null)_1=this.root;var _2=this.getDescendantFolders(_1,new Function("node","return node."+this.openProperty));if(this.isOpen(_1))_2.add(_1);return _2}
,isc.A.getOpenFolderPaths=function(_1){var _2=this.getOpenFolders(_1);for(var i=0;i<_2.length;i++){_2[i]=this.getPath(_2[i])}
return _2}
,isc.A.changeDataVisibility=function(_1,_2){if(this.isLeaf(_1))return false;_1[this.openProperty]=_2;this.$27f();if(_2&&!this.isLoaded(_1)){this.loadChildren(_1)}}
,isc.A.toggleFolder=function(_1){this.changeDataVisibility(_1,!this.isOpen(_1))}
,isc.A.openFolder=function(_1){if(_1==null)_1=this.root;if(!this.isOpen(_1)){this.changeDataVisibility(_1,true)}}
,isc.A.openFolders=function(_1){for(var i=0;i<_1.length;i++){var _3=_1[i];if(_3==null)continue;if(isc.isA.String(_3))_3=this.find(_3);if(_3!=null){this.openFolder(_3)}}}
,isc.A.closeFolder=function(_1){if(this.isOpen(_1)){this.changeDataVisibility(_1,false)}}
,isc.A.closeFolders=function(_1){for(var i=0;i<_1.length;i++){var _3=_1[i];if(_3==null)continue;if(isc.isA.String(_3))_3=this.find(_3);if(_3!=null){this.closeFolder(_3)}}}
,isc.A.openAll=function(_1){if(!_1)_1=this.root;var _2=this.getDescendants(_1,isc.Tree.FOLDERS_ONLY);for(var i=0,_4=_2.length;i<_4;i++){if(!this.isOpen(_2[i])){this.changeDataVisibility(_2[i],true)}}
this.changeDataVisibility(_1,true)}
,isc.A.closeAll=function(_1){if(!_1)_1=this.root;var _2=this.getDescendants(_1,isc.Tree.FOLDERS_ONLY);for(var i=0,_4=_2.length;i<_4;i++){if(this.isOpen(_2[i])){this.changeDataVisibility(_2[i],false)}}
if(!(_1==this.root&&this.showRoot==false))this.changeDataVisibility(_1,false)}
,isc.A.getOpenList=function(_1,_2,_3,_4,_5,_6){if(!_1)_1=this.root;if(_3==null)_3=this.$27i;if(_4==null)_4=this.sortDirection;if(_6==null)_6=this.$45g;if(this.isLeaf(_1)){if(_1==this.root)return[];return null}
var _7=[];if(_2!=isc.Tree.LEAVES_ONLY)_7[_7.length]=_1;if(!this.isOpen(_1))return _7;var _8=this.getChildren(_1,_2,_3,_4,_5,_6);for(var i=0,_10=_8.length,_11;i<_10;i++){_11=_8[i];if(!_11){continue}
var _12=_11[this.childrenProperty];if(_12&&_12.length){_7=_7.concat(this.getOpenList(_11,_2,_3,_4,_5))}else{if(_2!=isc.Tree.FOLDERS_ONLY){_7[_7.length]=_11}}}
if(!this.showRoot&&_7[0]==this.root){_7=_7.slice(1,_7.length)}
return _7}
,isc.A.$27l=function(){if(!this.$27m||this.$q7||!this.cacheOpenList){this.$27m=this.getOpenList(this.root,this.openDisplayNodeType,this.$27i,this.sortDirection,this.openListCriteria);this.$q7=false}
return this.$27m}
,isc.A.getLength=function(){return this.$27l().length}
,isc.A.get=function(_1){return this.$27l()[_1]}
,isc.A.getRange=function(_1,_2){return this.$27l().slice(_1,_2)}
,isc.A.indexOf=function(_1,_2,_3){return this.$27l().indexOf(_1,_2,_3)}
,isc.A.lastIndexOf=function(_1,_2,_3){return this.$27l().lastIndexOf(_1,_2,_3)}
,isc.A.getAllItems=function(){return this.$27l()}
,isc.A.sortByProperty=function(_1,_2,_3,_4){if(_1!=null)this.sortProp=_1;if(_2!=null)this.sortDirection=_2;if(_3&&isc.isA.Function(_3)){this.$27i=_3}else{this.$27n()}
this.$45g=_4;this.$27f();this.dataChanged()}
,isc.A.$27n=function(){var _1=this.sortProp,_2=this.sortDirection,_3=this.separateFolders!=false;var _4=isc.SB.create();_4.append("var __tree__ = ",this.getID(),";\rvar value = '';");if(_3)_4.append("value+=(__tree__.isFolder(obj) ? '0:' : '1:');");if(_1&&_1!="title"){_4.append("var prop = obj.",_1,";","if (isc.isA.Number(prop)) prop = prop.stringify(12);","if (isc.isA.Date(prop)) prop = prop.getTime();","if (prop != null) value += prop + ':';")}
_4.append("var title = __tree__.getTitle(obj);","if (isc.isA.Number(title)) title = title.stringify(12);","if (isc.isA.Date(title)) title = title.getTime();","if (title != null) {title = title + ''; value += title.toLowerCase()}","return value;");this.addMethods({$27i:new Function("obj,property",_4.toString())})}
,isc.A.loadSubtree=function(_1,_2,_3){if(!_1)_1=this.getRoot();if(_2==null)_2=this.loadBatchSize;this.$27o=_3?2:1;var _4=0,_5=1;while(_4<_2){var _6=this.$27p(_2,_1,_4,_5++);if(_6==0)break;_4+=_6}
this.$27o=null;if(_4>0)this.$27f()}
,isc.A.loadingBatch=function(_1){if(_1)return this.$27o==2;else return this.$27o}
,isc.A.$27p=function(_1,_2,_3,_4){var _5=0;if(!this.isOpen(_2)){if(!this.isLoaded(_2))this.loadChildren(_2);if(this.isLoaded(_2)){if(this.openFolder(_2)===false)return _5}
if(_2.children){_5+=_2.children.length;_3+=_2.children.length}}
var _6=_2.children;if(_3>=_1||_4==0||_6==null)return _5;for(var i=0;i<_6.length;i++){var _8=_6[i];var _9=this.$27p(_1,_8,_3,_4-1);_5+=_9;_3+=_9;if(_3>=_1)return _5}
return _5}
);isc.B._maxIndex=isc.C+83;isc.ClassFactory.defineClass("Selection");isc.A=isc.Selection.getPrototype();isc.A.$q7=true;isc.A=isc.Selection;isc.A.NONE="none";isc.A.SINGLE="single";isc.A.MULTIPLE="multiple";isc.A.SIMPLE="simple";isc.A.$24e=0;isc.A=isc.Selection.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.init=function(){if(!this.selectionProperty)this.selectionProperty="_selection_"+isc.Selection.$24e++;this.setData((this.data?this.data:[]))}
,isc.A.destroy=function(){if(this.data)this.ignoreData(this.data);delete this.data}
,isc.A.setData=function(_1){if(this.data!=null)this.ignoreData(this.data);this.data=_1;if(this.data!=null)this.observeData(this.data)}
,isc.A.observeData=function(_1){this.observe(_1,"dataChanged","observer.dataChanged()");if(_1.dataArrived)this.observe(_1,"dataArrived","observer.dataChanged()")}
,isc.A.ignoreData=function(_1){if(!_1)return;if(this.isObserving(_1,"dataChanged"))this.ignore(_1,"dataChanged");if(this.isObserving(_1,"dataArrived"))this.ignore(_1,"dataArrived")}
,isc.A.dataChanged=function(){this.markForRedraw()}
,isc.A.markForRedraw=function(){this.$q7=true}
,isc.A.isSelected=function(_1){if(_1==null)return false;if(isc.isAn.XMLNode(_1))return"true"==_1.getAttribute(this.selectionProperty);return _1[this.selectionProperty]}
,isc.A.anySelected=function(){return this.getSelection().length>0}
,isc.A.multipleSelected=function(){return this.getSelection().length>1}
,isc.A.getSelection=function(){if(this.$q7)this.cacheSelection();return this.$27q}
,isc.A.getSelectedRecord=function(){var _1=this.getSelection();if(_1&&_1.length>0)return _1[0]}
,isc.A.cacheSelection=function(){this.$27q=[];var _1=this.data,_2=isc.isA.ResultSet!=null&&isc.isA.ResultSet(_1),_3=_1.getLength();if(_2&&!_1.lengthIsKnown()){this.$q7=false;return}
for(var i=0;i<_3;i++){if(_2&&!_1.rowIsLoaded(i))continue;var _5=_1.get(i);if(_5!=null&&this.isSelected(_5)){this.$27q[this.$27q.length]=_5}}
this.$q7=false}
,isc.A.setSelected=function(_1,_2){if(_1==null)return false;if(_1.enabled==false)return false;var _3=this.selectionProperty,_4=isc.isAn.XMLNode(_1);if(_2==null)_2=true;var _5=_4?_1.getAttribute(_3):_1[_3];if(_5==null)_5=false;if(_4){_1.setAttribute(_3,(_2==true)+"")}else{_1[_3]=_2}
this.lastSelectionItem=_1;this.lastSelectionState=_2;if(_2==_5)return false;this.markForRedraw();if(this.target&&this.target.selectionChange)this.target.selectionChange(_1,_2);return true}
,isc.A.select=function(_1){return this.setSelected(_1,true)}
,isc.A.deselect=function(_1){return this.setSelected(_1,false)}
,isc.A.selectSingle=function(_1){this.deselectAll();return this.select(_1)}
,isc.A.selectList=function(_1,_2){if(_2==null)_2=true;if(!_1)return false;var _3=false,_4=_1.getLength();for(var i=0;i<_4;i++){var _6=_1.get(i);if(this.isSelected(_6)==_2)continue;_3=this.setSelected(_6,_2)||_3}
return _3}
,isc.A.deselectList=function(_1){this.selectList(_1,false)}
,isc.A.selectAll=function(){return this.selectRange(0,this.data.getLength())}
,isc.A.deselectAll=function(){return this.deselectList(this.getSelection())}
,isc.A.selectItem=function(_1){return this.selectRange(_1,_1+1)}
,isc.A.deselectItem=function(_1){return this.deselectRange(_1,_1+1)}
,isc.A.selectRange=function(_1,_2,_3){if(_3==null)_3=true;if(isc.isA.ResultSet!=null&&isc.isA.ResultSet(this.data)&&!this.data.rangeIsLoaded(_1,_2))
{isc.warn("Can't select that many records at once.<br><br>"+"Please try working in smaller batches.");return false}
return this.selectList(this.data.getRange(_1,_2),_3)}
,isc.A.deselectRange=function(_1,_2){return this.selectRange(_1,_2,false)}
,isc.A.selectOnMouseDown=function(_1,_2){var _3=_1.selectionType||isc.Selection.MULTIPLE;if(_3==isc.Selection.NONE)return false;this.startRow=this.lastRow=_2;this.logDebug("selectOnMouseDown: recordNum: "+_2);var _4=this.data.get(_2),_5=this.isSelected(_4),_6=this.getSelection();if(Array.isLoading(_4))return false;this.deselectRecordOnMouseUp=false;this.deselectOthersOnMouseUp=false;var _7=(isc.Browser.isMac?isc.EventHandler.metaKeyDown():isc.EventHandler.ctrlKeyDown()),_8=isc.EH.shiftKeyDown();if(_3==isc.Selection.SINGLE){if(_7&&_5)this.deselect(_4);else if(!_5)this.selectSingle(_4);return true}else if(_8){if(_6.length==0){this.select(_4);return true}else{var _9=this.data.indexOf(_6[0]),_10=this.data.indexOf(_6.last());if(_2>=_10){this.selectRange(_9,_2+1)}else if(_2<=_9){this.selectRange(_2,_10+1)}else{this.selectRange(_9,_2+1);this.deselectRange(_2+1,_10+1)}
return true}}else if(_3==isc.Selection.SIMPLE){if(!_5){this.select(_4);return true}else{this.deselectRecordOnMouseUp=true;return false}}else if(_7){this.setSelected(_4,!_5);return true}else{if(!_5){this.selectSingle(_4);return true}else if(isc.EventHandler.rightButtonDown()){this.deselectOnDragMove=true;return false}else{if(this.dragSelection){if(this.simpleDeselect){this.deselectAll();this.selectOriginOnDragMove=true;return true}
this.selectSingle(_4);return true}else{if(this.simpleDeselect){this.deselectAllOnMouseUp=true}else{this.deselectOthersOnMouseUp=(_6.length>1)}
return false}}}}
,isc.A.selectOnDragMove=function(_1,_2){var _3=this.startRow,_4=this.lastRow;if(_2<0){this.logWarn("selectOnDragMove: got negative coordinate: "+_2);return}
if(_2==_4)return;if(this.selectOriginOnDragMove){this.select(this.data.getItem(_3));this.selectOriginOnDragMove=false}else if(this.deselectOnDragMove||this.deselectAllOnMouseUp||this.deselectOthersOnMouseUp){this.selectSingle(this.data.getItem(_3));this.deselectAllOnMouseUp=this.deselectOthersOnMouseUp=this.deselectOnDragMove=false}
if((_2>_3&&_3>_4)||(_4>_3&&_3>_2))
{this.deselectAll();if(_3>_2){this.selectRange(_2,_3+1)}else{this.selectRange(_3,_2+1)}}else if(_3>=_4&&_4>_2){this.selectRange(_2,_4)}else if(_3>=_2&&_2>_4){this.deselectRange(_4,_2)}else if(_3<=_2&&_2<_4){this.deselectRange(_2+1,_4+1)}else if(_3<=_4&&_4<_2){this.selectRange(_4,_2+1)}else{this.logWarn("dragMove case not handled: lastRow: "+_4+", currRow: "+_2+", startRow "+_3)}
this.lastRow=_2}
,isc.A.selectOnMouseUp=function(_1,_2){if(_1.selectionType==isc.Selection.NONE)return false;this.logDebug("selectOnMouseUp: recordNum: "+_2);if(this.deselectOthersOnMouseUp){this.selectSingle(this.data.getItem(_2));this.deselectOthersOnMouseUp=false;return true}else if(this.deselectRecordOnMouseUp){this.deselect(this.data.getItem(_2));this.deselectRecordOnMouseUp=false;return true}else if(this.deselectAllOnMouseUp){this.deselectAll();this.deselectAllOnMouseUp=false;return true}else
return false}
);isc.B._maxIndex=isc.C+28;isc.ClassFactory.defineClass("DetailViewer","Canvas");isc.A=isc.DetailViewer.getPrototype();isc.A.fieldIdProperty="name";isc.A.recordsPerBlock=1;isc.A.blockSeparator="<BR><BR>";isc.A.showEmptyField=true;isc.A.emptyCellValue="&nbsp;";isc.A.labelPrefix="";isc.A.labelSuffix=":";isc.A.valueAlign="left";isc.A.wrapValues=true;isc.A.useInnerWidth=true;isc.A.clipValues=false;isc.A.styleName="detailViewer";isc.A.blockStyle="detailBlock";isc.A.labelStyle="detailLabel";isc.A.cellStyle="detail";isc.A.headerStyle="detailHeader";isc.A.separatorStyle="detail";isc.A.cellPadding=3;isc.A.showEmptyMessage=true;isc.A.emptyMessage="No items to display.";isc.A.emptyMessageStyle="normal";isc.A.loadingMessage="&nbsp;";isc.A.loadingMessageStyle="normal";isc.A.defaultHeight=35;isc.A.showLabel=true;isc.A=isc.DetailViewer.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$g4="date";isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments);this.fields=this.bindToDataSource(this.fields)}
,isc.A.setData=function(_1){if(this.data)this.ignore(this.data,"dataChanged");this.data=_1;if(this.data&&this.data.dataChanged){this.observe(this.data,"dataChanged","observer.dataChanged()")}
this.markForRedraw("new data")}
,isc.A.dataChanged=function(){this.applyHilites();this.markForRedraw()}
,isc.A.getData=function(){return this.data}
,isc.A.getFields=function(){return this.fields}
,isc.A.getInnerHTML=function(){var _1=this.getData();if(isc.ResultSet!=null&&isc.isA.ResultSet(_1)&&!_1.lengthIsKnown()){_1.getRange(0,10000);return this.loadingMessageHTML()}
if((_1==null||(isc.isAn.Array(_1)&&_1.getLength()==0))&&this.showEmptyMessage){return this.emptyMessageHTML()}
if(this.fields==null||this.fields.length==0){return"Note: you must define detailViewer.fields to specify what to display!"}
if(!isc.isA.List(_1))_1=[_1];if(_1.getLength()==1||this.recordsPerBlock=="*"){return this.getBlockHTML(_1)}else{var _2=isc.StringBuffer.newInstance();for(var _3=0;_3<_1.getLength();_3+=this.recordsPerBlock){_2.append(this.getBlockHTML(_1.getRange(_3,_3+this.recordsPerBlock)),this.blockSeparator)}
return _2.toString()}}
,isc.A.getBlockHTML=function(_1){var _2=_1.getLength();var _3="<TABLE BORDER=0 CELLSPACING=0 CLASS="+this.blockStyle+" WIDTH="+(this.useInnerWidth&&!this.isPrinting?this.getInnerWidth():"'100%'")+" CELLPADDING="+this.cellPadding+(this.clipValues?" STYLE='table-layout:fixed'":"");_3+=">";var _4=this.fields;for(var _5=0,_6=_4.length;_5<_6;_5++){var _7=_4[_5];if(!_7)continue;if(_7.showIf){if(!isc.isA.Function(_7.showIf)){isc.Func.replaceWithMethod(_7,"showIf","viewer,valueList")}
if(_7.showIf(this,_1)==false)continue}
var _8=_7.type?_7.type:"";if(_8!="separator"&&_8!="header"&&!this.showEmptyField){var _9=true;for(var i=0;i<_1.getLength();i++){var _11=_1.get(i)[_7[this.fieldIdProperty]]
if(!(_11==null||_11=="")){_9=false;break}}
if(_9)continue}
if(_7.output){if(!isc.isA.Function(_7.output)){isc.Func.replaceWithMethod(_7,"output","fieldNum,field,valueList")}
_3+=_7.output(_5,_7,_1)}else{_3+=this.outputItem(_5,_7,_1)}}
_3+="</TABLE>"
return _3}
,isc.A.outputItem=function(_1,_2,_3){var _4=(_2.type?_2.type:"value"),_5="output_"+_4,_6="";if(!this[_5])_5="output_value";_6+="<TR"+(this.rowClass!=null?" CLASS='"+this.rowClass+"'":"")+">";_6+=this[_5](_1,_2,_3);_6+="</TR>\r";return _6}
,isc.A.output_blob=function(_1,_2,_3){return this.output_binary(_1,_2,_3)}
,isc.A.output_upload=function(_1,_2,_3){return this.output_binary(_1,_2,_3)}
,isc.A.output_binary=function(_1,_2,_3){var _4="<TD WIDTH=10% CLASS='"+(this.isPrinting?this.printLabelStyle||this.labelStyle:this.labelStyle)+"' ALIGN=RIGHT"+(this.wrapLabel?">":" NOWRAP><NOBR>")+this.labelPrefix+(_2.title?_2.title:_2[this.fieldIdProperty])+this.labelSuffix+"<\/NOBR><\/TD>";for(var i=0;i<_3.getLength();i++){var _6=_3.get(i);var _7=this.getData().indexOf(_6);var _8=_6[_2.name+"_filename"];var _9=isc.Canvas.imgHTML("[SKIN]actions/view.png",16,16,null,"style='cursor:"+isc.Canvas.HAND+"' onclick='"+this.getID()+".viewRow("+_7+")'");var _10=isc.Canvas.imgHTML("[SKIN]actions/download.png",16,16,null,"style='cursor:"+isc.Canvas.HAND+"' onclick='"+this.getID()+".downloadRow("+_7+")'");var _11=_9+"&nbsp;"+_10+"&nbsp;"+_8;_4+="<TD CLASS='"+this.getCellStyle(_11,_2,_6,this)+"'>"+_11+"<\/TD>"}
return _4}
,isc.A.viewRow=function(_1){isc.DS.get(this.dataSource).viewFile(this.getData().get(_1))}
,isc.A.downloadRow=function(_1){isc.DS.get(this.dataSource).downloadFile(this.getData().get(_1))}
,isc.A.output_value=function(_1,_2,_3){var _4;if(this.showLabel){_4="<TD WIDTH=10% CLASS='"+(this.isPrinting?this.printLabelStyle||this.labelStyle:this.labelStyle)+"' ALIGN=RIGHT"+(this.wrapLabel?">":" NOWRAP><NOBR>")+this.labelPrefix+(_2.title?_2.title:_2[this.fieldIdProperty])+this.labelSuffix+"<\/NOBR><\/TD>"}else{_4=""}
if(_2.valueMap&&isc.isA.String(_2.valueMap))
_2.valueMap=this.getGlobalReference(_2.valueMap);for(var i=0;i<_3.getLength();i++){var _6=_3.get(i),_7;if(_2.type=="image"){var _8,_9,_10,_11,_12;if(isc.isA.String(_2.imageWidth)){_10=_2.imageWidth}else{_8=_2.imageWidth}
if(isc.isA.String(_2.imageHeight)){_11=_2.imageHeight}else{_9=_2.imageHeight}
if(isc.isA.String(_2.imageSize)){_12=_2.imageSize}else{_8=_8||_2.imageSize;_9=_9||_2.imageSize}
if(_6!=null){_8=_8||_6[_10]||_6[_12];_9=_9||_6[_11]||_6[_12]}
var _13=this.getCellValue(_6,_2),_14=_2.imageURLPrefix||_2.baseURL||_2.imgDir;_7=this.imgHTML(_13,_8,_9,null,_2.extraStuff,_14,_2.activeAreaHTML)}else{_7=this.getCellValue(_6,_2)}
var _15=_6[_2.name];var _16;if(_2.getCellStyle)_16=_2.getCellStyle(_15,_2,_6,this);else _16=(this.getCellStyle(_15,_2,_6,this)||this.cellStyle);var _17=" style='";if(this.clipValues)_17+="overflow:hidden;";_17+="text-align:"+this.valueAlign;if(this.getCellCSSText){var _18=this.getCellCSSText(_15,_2,_6,this);if(_18!=null)_17+=";"+_18}
_17+="'";_4+="<TD CLASS='"+_16+"'"+_17+(this.wrapValues?">":" NOWRAP><NOBR>")+_7+(this.wrapValues?"<\/NOBR>":"")+"<\/TD>"}
return _4}
,isc.A.getCellCSSText=function(_1,_2,_3,_4){var _5;if(this.hilites&&_3[this.hiliteProperty]!=null){_5=this.addObjectHilites(_3,_5,_2)}else if(this.hilites&&_3[this.hiliteMarker]!=null){_5=this.addHiliteCSSText(_3,this.getFieldNum(_2))}
return _5}
,isc.A.getCellStyle=function(_1,_2,_3,_4){if(_2&&_2.getCellStyle){return _2.getCellStyle(_1,_2,_3,_4)}
return(this.isPrinting&&this.printCellStyle!=null)?this.printCellStyle:this.cellStyle}
,isc.A.getCellValue=function(_1,_2){var _3=_1[_2[this.fieldIdProperty]];if(isc.isA.String(_2.formatCellValue)){_2.formatCellValue=isc.Func.expressionToFunction("value,record,field,viewer",_2.formatCellValue)}
if(_2.getCellValue!=null){if(isc.isA.String(_2.getCellValue)){_2.getCellValue=isc.Func.expressionToFunction("value,record,field,viewer",_2.getCellValue)}
_3=_2.getCellValue(_3,_1,_2,this);if(_2.formatCellValue)_3=_2.formatCellValue(_3,_1,_2,this)}else{if(_2.valueMap!=null)_3=isc.getValueForKey(_3,_2.valueMap);if(_2.formatCellValue)_3=_2.formatCellValue(_3,_1,_2,this);if(_3==null||isc.is.emptyString(_3))_3=this.emptyCellValue}
if(_2.formatCellValue==null&&this.formatCellValue){_3=this.formatCellValue(_3,_1,_2)}else{_3=this.$17c(_1,_2,_3);if(_2.asHTML)_3=_3.asHTML()}
return _3}
,isc.A.$17c=function(_1,_2,_3){var _4=_2.type,_5=(_4!=null?isc.SimpleType.getBaseType(_4):null),_6;if(_5==this.$g4)
_6=(_2.dateFormatter||_2.formatter||this.dateFormatter);if(_6!=null){if(isc.isA.Date(_3))_3=_3.toNormalDate(_6)}else{if(_2.$64!=null){_3=_2.$62.normalDisplayFormatter(_3,_2,this,_1)}
else if(_2.type==null&&isc.isA.Date(_3))_3=_3.toNormalDate()}
return isc.iscToLocaleString(_3)}
,isc.A.output_header=function(_1,_2,_3){return"<TD COLSPAN="+(_3.getLength()+1)+" CLASS='"+(this.isPrinting&&this.printHeaderStyle?this.printHeaderStyle:this.headerStyle)+"'>"+_2.value+"</TD>"}
,isc.A.output_separator=function(_1,_2,_3){var _4=(_2.width==null?_2.defaultSeparatorWidth:_2.width),_5=(_2.height==null?_2.defaultSeparatorHeight:_2.height);return"<TD COLSPAN="+(_3.getLength()+1)+" CLASS='"+this.separatorStyle+"'>"+isc.Canvas.spacerHTML(_4,_5)+"</TD>"}
,isc.A.getEmptyMessage=function(){return this.emptyMessage}
,isc.A.getLoadingMessage=function(){return this.loadingMessage}
,isc.A.emptyMessageHTML=function(){return"<TABLE WIDTH=100%>"+"<TR><TD CLASS='"+this.emptyMessageStyle+"' ALIGN=CENTER><BR><BR>"+this.getEmptyMessage()+"<\/TD><\/TR><\/TABLE>"}
,isc.A.loadingMessageHTML=function(){return"<TABLE WIDTH=100%>"+"<TR><TD CLASS='"+this.loadingMessageStyle+"' ALIGN=CENTER><BR><BR>"+this.getLoadingMessage()+"<\/TD><\/TR><\/TABLE>"}
);isc.B._maxIndex=isc.C+24;isc.DetailViewer.registerStringMethods({getCellValue:"record,field",getCellStyle:"value,field,record,viewer",getCellCSSText:"value,field,record,viewer",formatCellValue:"value,record,field,viewer"});isc.ClassFactory.defineClass("GridRenderer","Canvas");isc.A=isc.GridRenderer;isc.A.SELECTED="Selected";isc.A.DISABLED="Disabled";isc.A.OVER="Over";isc.A.standardStyleSuffixes=["","Over","Selected","SelectedOver","Disabled","DisabledOver","DisabledSelected","DisabledSelectedOver","Dark","OverDark","SelectedDark","SelectedOverDark","DisabledDark"];isc.A=isc.GridRenderer.getPrototype();isc.A.totalRows=0;isc.A.virtualScrolling=true;isc.A.drawAllMaxCells=250;isc.A.recordCanSelectProperty="canSelect";isc.A.isSeparatorProperty="isSeparator";isc.A.singleCellValueProperty="singleCellValue";isc.A.scrollRedrawDelay=75;isc.A.drawAheadRatio=1.3;isc.A.quickDrawAheadRatio=1.3;isc.A.cellHeight=20;isc.A.fixedRowHeights=true;isc.A.fixedColumnWidths=true;isc.A.cellSpacing=0;isc.A.cellPadding=2;isc.A.canSelectOnRightMouse=true;isc.A.hoverByCell=true;isc.A.backgroundColor="white";isc.A.tableStyle="listTable";isc.A.baseStyle="cell";isc.A.alternateRowFrequency=1;isc.A.emptyCellValue="&nbsp;";isc.A.overflow="auto";isc.A.$r9=true;isc.A.canFocus=true;isc.A.animateRowsMaxTime=1000;isc.A.snapToCells=false;isc.A.snapInsideBorder=false;isc.A.snapHDirection=isc.Canvas.BEFORE;isc.A.snapVDirection=isc.Canvas.BEFORE;isc.A=isc.GridRenderer.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$57k=["<DIV style='position:relative;z-index:",,";'>",,"</DIV>"];isc.A.$623="<table style='position:absolute;top:0px;font-size:1px;height:100%;width:100%;z-index:1;overflow:hidden;visibility:hidden;'><tr><td>&nbsp;</td></tr></table>";isc.A.$27r="none";isc.A.$27s="<DIV cellClipDiv=true style='overflow:hidden;";isc.A.$57l="within";isc.A.$57m="expand";isc.A.$14k="cell";isc.A.recordCustomStyleProperty="customStyle";isc.A.$27t="NOBR";isc.A.$27u="cellClipDiv";isc.A.$o5="height";isc.A.$27v="minHeight";isc.A.$39=";";isc.A.avgRowHeight=60;isc.B.push(isc.A.initWidget=function(){if(!this.$26a)this.setColumnWidths([]);if(this.selection)this.setSelection(this.selection);if(this.overflow==isc.Canvas.VISIBLE){this.showAllRows=true;this.showAllColumns=true}
if(!this.fixedRowHeights&&!this.showAllRows){this.$r9=true;if(this.showCustomScrollbars==false){this.logWarn("Variable height records cannot be used with native scrollbars;"+" set showCustomScrollbars:true globally or on this GridRenderer")}
this.showAllColumns=true}
if(this.fastCellUpdates&&!isc.Browser.isIE)this.fastCellUpdates=false}
,isc.A.isEmpty=function(){return false}
,isc.A.$27w=function(_1,_2){return this.getEmptyMessageHTML(_1,_2)}
,isc.A.getEmptyMessageHTML=function(_1,_2){if(!this.showEmptyMessage)return"&nbsp;";if(this.isPrinting){if(_1==null)_1=0;if(_2==null)_2=this.fields?this.fields.getLength()-1:0;return"<TABLE cellspacing=0 style='width:100%' class='"+this.emptyMessageTableStyle+"'>"+this.grid.getPrintHeaders(_1,_2)+"<TR><TD  ALIGN=CENTER VALIGN=TOP class='"+this.emptyMessageStyle+"' colspan='"+((_2-_1)+1)+"'>"+this.getEmptyMessage()+"</TD></TR></TABLE>"}
var _3=this.getInnerWidth(),_4=0;if(this.expandEmptyMessageToMatchFields&&this.$26a){_4=this.$26a.sum()-_3;if(_4<0)_4=0}
var _5=_4&&this.overflow!=isc.Canvas.VISIBLE;var _6=isc.StringBuffer.create();_6.append("<TABLE BORDER=0 MARGIN=0 CELLSPACING=0 CLASS='",this.emptyMessageTableStyle,"' style='width:",(_3+_4),"px;",(isc.Browser.isSafari?"height"+this.getInnerHeight()+":px;'":"' HEIGHT=100%"),"><TR><TD ALIGN=CENTER VALIGN=TOP CLASS='",this.emptyMessageStyle,"' style='padding-left:0px;padding-right:0px;'>",this.getEmptyMessage(),(_4&&_5?"<br>"+isc.Canvas.spacerHTML(_3,1):null),"</TD>");if(_4&&_5){_6.append("<TD style='padding-left:0px;padding-right:0px;'>",isc.Canvas.spacerHTML(_4,1),"</TD>")}
_6.append("</TR></TABLE>");return _6.release()}
,isc.A.getEmptyMessage=function(){return this.emptyMessage}
,isc.A.getInnerHTML=function(){var _1=this.getTableHTML(),_2=this.$57k;_2[1]=this.getTableZIndex();_2[3]=_1;if(isc.Browser.isMoz)_2[5]=this.$623;return _2.join(isc.emptyString)}
,isc.A.shouldUseQuickDrawAheadRatio=function(){return this.useQuickDrawAheadRatio||this.isDragScrolling()||this.isRepeatTrackScrolling()}
,isc.A.doneFastScrolling=function(){var _1=this.$50z;if(_1){this.$50v=true;this.markForRedraw("Done Fast scrolling.")}}
,isc.A.addDrawAhead=function(_1,_2,_3,_4,_5){var _6=this.shouldUseQuickDrawAheadRatio(),_7=_6&&this.quickDrawAheadRatio!=null?this.quickDrawAheadRatio:this.drawAheadRatio,_8=Math.ceil((_2-_1)*_7);if(this.$50v)_4=null;if(_4!=null){if(_4)_2=_1+_8;else _1=_2-_8}else{if(_1==0)_2=_8;else{var _9=Math.ceil((_8-(_2-_1))/2);_1-=_9;_2+=_9}}
if(_1<0){_2-=_1;_1=0}
if(_2>=_3){var _10=_2-(_3-1);_1=Math.max(0,(_1-_10));_2=Math.max(0,_3-1)}
if(_6)this.$50z=true;else delete this.$50z;return[_1,_2]}
,isc.A.getExtraRowHeight=function(_1,_2){var _3=0;for(var _4=_1;_4<_2;_4++){var _5=this.getRowHeight(this.getCellRecord(_4,0),_4),_6=(_5-this.cellHeight);if(_6>0){_3+=_6}}
return _3}
,isc.A.getDrawArea=function(_1){var _2=this.getTotalRows(),_3,_4,_5;var _6=_2*this.fields.length,_7=_6<=this.drawAllMaxCells&&!isc.EH.dragging&&!this.isAnimating()&&!(this.parentElement&&this.parentElement.isAnimating());if(this.showAllRows||_7){_3=0;_4=_2-1}else{var _8=this.$27x();_5=(this.lastScrollTop==null?null:this.lastScrollTop<this.getScrollTop());var _9=this.addDrawAhead(_8[0],_8[1],_2,_5,true);_3=_9[0];_4=_9[1]}
var _10,_11,_12=this.fields.length,_13;if(_1!=null){_10=_1;_11=_1+1}else if(this.showAllColumns||_7){_10=0;_11=_12-1}else{var _14=this.getVisibleColumns();_13=(this.lastScrollLeft==null?null:this.lastScrollLeft<this.getScrollLeft());var _9=this.addDrawAhead(_14[0],_14[1],_12,_13);_10=_9[0];_11=_9[1]}
if(this.cacheDOM&&!this.$508){this.$508=_4-_3;this.$509=_11-_10}
return[_3,_4,_10,_11]}
,isc.A.getRowCoordinate=function(_1){var _2=this.getEventRow(_1),_3=this.getRowTop(_2),_4=_1-_3,_5=this.getRowSize(_2),_6=_4/ _5;return _2+_6}
,isc.A.scrollToRatio=function(_1,_2,_3,_4){if(!_1||!this.$60s){return this.invokeSuper(isc.GridRenderer,"scrollToRatio",_1,_2,_3,_4)}
var _5=this.getTotalRows()-1,_6=_2*_5,_7=Math.floor(_6),_8=Math.round((_6-_7)*this.getRowSize(_7));this.$27y=_7;this.$27z=_8;this.$270();if(this.isDirty()){this.$271=_2;this.$27y=_7;this.$27z=_8}}
,isc.A.getScrollRatio=function(_1,_2,_3,_4){if(!_1||!this.$60s){return this.invokeSuper(isc.GridRenderer,"getScrollRatio",_1,_2,_3,_4)}
if(this.isDirty()&&this.$271!=null)return this.$271;var _5=this.getTotalRows()-1;if(_5<=0)return 0;var _6=this.getScrollTop(),_7=this.getRowCoordinate(_6),_8=_7/ _5;return Math.min(1,_8)}
,isc.A.getViewportRatio=function(_1,_2,_3,_4){if(!_1||!this.$60s){return this.invokeSuper(isc.GridRenderer,"getViewportRatio",_1,_2,_3,_4)}
var _5=this.$272||this.getAvgRowHeight();return Math.min(1,(this.getViewportHeight()/_5)/this.getTotalRows())}
,isc.A.$273=function(_1,_2){if(this.$274)return;if(this.isEmpty())return;var _3
if(_2>0){_3=_1+this.getViewportHeight()}else{_3=_1}
var _4=this.getEventRow(_3),_5=this.getTotalRows()-1,_6=_1;if(_4<0||_4>_5){this.$27y=_5;this.$27z=0;_6=this.getRowTop(_5)}else{this.$27y=_4;this.$27z=_1-this.getRowTop(this.$27y)+_2;if(Math.abs(this.$27z)>this.getViewportHeight()){this.logInfo("storeTargetRow: targetRow: "+_4+" with offset: "+this.$27z+", clearing","virtualScrolling");this.$27z=this.$27y=null}}
return _6}
,isc.A.$270=function(){var _1=this.$27y,_2=this.$27z;var _3=this.getRowTop(_1)+_2;this.$274=true;this.$sz=null;this.scrollTo(null,_3);this.$274=false;this.$271=null}
,isc.A.scrollTo=function(_1,_2,_3,_4){if(isc.$cv)arguments.$cw=this;if(this.$60s&&_2!=null&&!_3){var _5=this.getScrollTop(),_6=_2-_5;this.$273(_5,_6);_2=Math.min(_2,this.getRowTop(this.getTotalRows()-1))}
this.invokeSuper(isc.GridRenderer,"scrollTo",_1,_2,_3,_4);if(this.isDirty()||this.$275)return;var _7=(this.$276()||this.$277());if(_7){if(this.scrollRedrawDelay==0){this.markForRedraw("scrolled")}else{this.fireOnPause("scrollRedraw","markForRedraw",this.scrollRedrawDelay)}
this.$250=true}}
,isc.A.$276=function(){if(this.showAllRows)return false;var _1=this.getVisibleRows(),_2=_1[0],_3=_1[1];var _4=this.getTotalRows();if(_3>_4-1)_3=_4-1;var _5=(_2<this.$252||_3>this.$253);return _5}
,isc.A.$277=function(){if(this.showAllColumns)return false;var _1=this.getVisibleColumns(),_2=_1[0],_3=_1[1],_4=(_2<this.$254||_3>this.$255);return _4}
,isc.A.setOverflow=function(_1){if(_1==isc.Canvas.VISIBLE){this.showAllRows=true;this.showAllColumns=true}
return this.Super("setOverflow",arguments)}
,isc.A.getRowChunkNum=function(_1){return Math.round(_1/ this.$508)}
,isc.A.getColChunkNum=function(_1){return Math.round(_1/ this.$509)}
,isc.A.getTableChunk=function(_1,_2){var _3=this.$51a;if(!_3)return;_1=_1||0;_2=_2||0;var _4=_3[_1];return _4?_4[_2]:null}
,isc.A.getTableChunkAt=function(_1,_2){var _3=this.getRowChunkNum(_1),_4=this.getColChunkNum(_2),_5=this.getTableChunk(_3,_4);if(_5!=null){this.$51b=_3*this.$508;this.$254=_4*this.$509;return _5}}
,isc.A.$rd=function(_1,_2,_3,_4){if(this.cacheDOM){this.drawVisibleChunks()}else{this.invokeSuper(isc.GridRenderer,"$rd",_1,_2,_3,_4)}}
,isc.A.drawVisibleChunks=function(){var _1=this.getVisibleRows(),_2=this.getVisibleColumns(),_3=this.getRowChunkNum(_1[0]),_4=this.getColChunkNum(_2[0]),_5=this.getRowChunkNum(_1[1]),_6=this.getColChunkNum(_2[1]);for(var _7=_3;_7<_5;_7++){for(var _8=_4;_8<_6;_8++){if(this.getTableChunk(_7,_8)==null){this.logWarn("drawing chunk: "+[_7,_8]);this.renderTableChunk(_7,_8)}}}
var _9=this.getTableHTML()}
,isc.A.renderTableChunk=function(_1,_2){var _3=_1*this.$508,_4=_3+this.$508,_5=_2*this.$509,_6=_5+this.$509;var _7=this.getTableHTML([_5,_6],_3,_4),_8=isc.Element.insertAdjacentHTML(this.getHandle(),"beforeEnd",_7,true);var _9=this.$51a=this.$51a||[],_10=_9[_1]=_9[_1]||[];_10[_2]=_8}
,isc.A.getDrawnRows=function(){return this.getVisibleRows()}
,isc.A.startRowAnimation=function(_1,_2,_3,_4,_5,_6,_7,_8,_9,_10){this.finishRowAnimation();if(!this.isDrawn()||!this.isVisible()){if(_4!=null){var _11=_9?this.parentElement:this;_11.fireCallback(_4)}
return}
if(_1==null)_1=true;if(_2==null)_2=0;if(_3==null)_3=this.getTotalRows()-1;if(_2==_3){this.logWarn("startRowAnimation passed empty row range, aborting: "+[_2,_3]);return}
var _12=this.readyToRedraw("animating show / hide of rows",false);if(!_12){this.$278=[_1,_2,_3,_4,_5,_6,_7,_8,_9];this.$279=isc.Timer.setTimeout({target:this,methodName:"$28a"},0);return}
var _13=this.$28b(_1,_2,_3,_4,_9);this.animateRowHeight(this.$28c,(_1?_13:0),{target:this,methodName:"$28d"},_5,_6,_7,_8)}
,isc.A.$28a=function(){if(this.$278==null){this.logWarn("Unable to perform delayed row animation - bailing");return}
var _1=this.$278,_2=_1[0],_3=_1[1],_4=_1[2],_5=_1[3],_6=_1[4],_7=_1[5],_8=_1[6],_9=_1[7],_10=_1[8];this.$278=null;this.$279=null;this.startRowAnimation(_2,_3,_4,_5,_6,_7,_8,_9,_10,true)}
,isc.A.$28b=function(_1,_2,_3,_4,_5){var _6=0;if(this.$28c==_2&&this.$28e==_3){var _7=this.getTableElement(this.$28c,0),_8=this.$28g(_7);if(!_8){_6=(_3-_2)*this.cellHeight}else _6=_8.scrollHeight}else{this.$28c=_2;this.$28e=_3;if(!_1){var _9=this.$26b();for(var i=_2;i<_3;i++){_6+=_9[i]}
this.$28f=_6;this.redraw("initializing animated hide row")}else{this.$28f=1;this.redraw("initializing animated show row");var _7=this.getTableElement(this.$28c,0),_8=this.$28g(_7);if(!_8){_6=(_3-_2)*this.cellHeight}else _6=_8.scrollHeight}
if(this.isDirty())this.redraw("Initializing row animation requires second redraw")}
this.$28h={callback:_4,target:(_5?this.parentElement:this)};return _6}
,isc.A.finishRowAnimation=function(){if(this.$28c!=null){this.finishAnimateRowHeight()}else{if(this.$279!=null){isc.Timer.clearTimeout(this.$279);var _1=this.$278,_2=_1[0],_3=_1[1],_4=_1[2],_5=_1[3],_6=_1[4],_7=_1[5];delete this.$278;delete this.$279;if(!this.readyToRedraw()){this.logWarn("Finish row animation called while Grid is not ready to redraw. "+"GridRenderer HTML will not be updated when callback fires.","animation");var _8=_7?this.parentElement:this;if(_5)_8.fireCallback(_5)}else{var _9=this.$28b(_2,_3,_4,_5,_7);this.setRowHeight(_3,(_2?_9:1));this.$28d()}}}}
,isc.A.$28d=function(){var _1=this.$28h;delete this.$28h;delete this.$28c;delete this.$28e;delete this.$28f;if(_1&&_1.callback)_1.target.fireCallback(_1.callback)}
,isc.A.animateRowHeight=function(_1,_2,_3,_4,_5,_6,_7,_8){if(!this.isDrawn()){if(_3){var _9=(_8?this.parentElement:this);_9.fireCallback(_3)}
return}
if(this.$28i!=null){this.logInfo("early finish of row animation, because new animation started","animation")
this.finishAnimateRowHeight()}
var _10=this.getRowSize(_1);if(_4!=null){var _11=(_2-_10);if(_11<0)_11=0-_11;_5=Math.round((_11/ _4)*1000);if(_5>this.animateRowsMaxTime)_5=this.animateRowsMaxTime}
this.$28j={$24t:_1,$28k:_10,$28l:_2,$03:_3,$1n:_7,$28m:_8}
_6=(_6||this.$27r);if(this.logIsInfoEnabled("animation")){this.logInfo("starting row animation, duration: "+_5+", effect: "+_6,"animation")}
this.$28i=this.registerAnimation({target:this,method:this.$28n},_5,_6);if(this.overflow==isc.Canvas.AUTO||this.overflow==isc.Canvas.SCROLL)
this.$417=true}
,isc.A.$28n=function(_1){var _2=this.$28j,_3=_2.$24t,_4=this.$04(_2.$28k,_2.$28l,_1);if(isc.Browser.isSafari&&_2.$28k>_2.$28l)
this.$28o=true;this.setRowHeight(_3,_4,null,isc.emptyString,true,true,true);if(isc.Browser.isSafari)delete this.$28o;if(_2.$1n){var _5=this.$28g(this.getTableElement(_3,0));if(_5){var _6=_5.scrollHeight,_7=_5.offsetHeight;if(_6>_7)_5.scrollTop=_6-_7;else _5.scrollTop=0}}
if(_1==1){isc.Timer.setTimeout({target:this,methodName:"$28p"},0)}}
,isc.A.$28p=function(){delete this.$417;this.adjustOverflow("row animation complete");var _1=this.$28j;delete this.$28i;delete this.$28j;if(_1&&_1.$03){var _2=_1.$28m?this.parentElement:this;_2.fireCallback(_1.$03)}}
,isc.A.finishAnimateRowHeight=function(){if(!this.$28i)return;this.cancelAnimation(this.$28i);this.$28n(1)}
,isc.A.getTableHTML=function(_1,_2,_3){var _4=isc.timeStamp();if(this.isEmpty()){this.$252=this.$253=this.$254=this.$255=null;if(this.isPrinting){return this.grid.getPrintHeaders(_13,_14)+this.$27w()}
return this.$27w()}
var _5=(_2!=null&&_3!=null),_6=_2!=null?_2:0,_7=_3!=null?_3:this.getTotalRows();var _8=this.getDrawArea();if(!_5){this.$252=_8[0];this.$253=_8[1];if(this.$28c!=null){this.$253+=(this.$28e-this.$28c);var _9=this.getTotalRows();if(this.$253>=_9)this.$253=_9-1}
_2=this.$252;_3=this.$253+1;var _10=(_2==0&&_3==this.getTotalRows());if(this.virtualScrolling){this.$60s=!_10&&!this.fixedRowHeights}
if(!this.$60s){delete this.$27y;delete this.$60t;delete this.$271;delete this.$60u}}else{var _11=_8[0],_12=_8[1]+1;if(this.$28q){if(_11>_3||_12<_2){_2=_3}}}
this.$254=_8[2];this.$255=_8[3];var _13,_14;if(_1!=null){if(isc.isAn.Array(_1)){_13=_1[0];_14=_1[1]+1}else{_13=_1;_14=_1+1}}else{_13=this.$254;_14=this.$255+1}
var _15=_14-_13;var _16=(this.showAllColumns||_1!=null);var _17=isc.StringBuffer.create(),_18=this.fields,_19=this.$26a;this.$28r=_13!=0?null:this.$26a[0];var _20,_21,_22,_23;if(!_16){_20=this.$26a.slice(0,_13).sum(),_21=this.$26a.slice(_14,this.$26a.length).sum(),_22=this.$26a.sum()
_23=(this.cacheDOM||isc.Browser.isIE||isc.Browser.isSafari?"margin":"padding")}
var _24=this.$26a.slice(_13,_14).sum(),_25=this.autoFit;var _26="";if(_1!=null){if(!_25&&this.fixedColumnWidths){_26=" WIDTH=100%"}}else if(this.isPrinting&&this.autoFit){_26=" WIDTH=100%"}else if((isc.Browser.isMoz||isc.Browser.isSafari)&&!_25){_26=" WIDTH="+_24}
var _27=this.startSpace||0;if(_2!=_6){var _28=((_2-_6)*this.getAvgRowHeight());this.$514=_28;_27+=_28}else{this.$514=0}
if(!this.cacheDOM&&!this.isPrinting){_17.append("<DIV style='height:",_27,"px;overflow:hidden;",(_27==0?"display:none;":null),"' ",(_5?">":" ID="+this.getID()+"$28s>"),isc.Canvas.spacerHTML(1,_27),"</DIV>")}
if(!this.$568||_2==0){_17.append("<TABLE BORDER=0",_26,(!_5?" ID="+this.getTableElementId():null),(this.tableStyle&&isc.Browser.isDOM?" CLASS='"+this.tableStyle+this.$ob:isc.$ad)," CELLSPACING=",this.cellSpacing," CELLPADDING=",this.cellPadding," STYLE='",(isc.Browser.isDOM&&!_25&&this.fixedColumnWidths?"table-layout:fixed;overflow:hidden;wrap:false;":""),(!_16?_23+(this.isRTL()?"-right: ":"-left:")+_20+"px;"+_23+(this.isRTL()?"-left:":"-right:")+_21+"px;":""),(this.cacheDOM&&this.$514>0?"margin-top:"+this.$514+"px;":""),(this.$27y!=null&&!(isc.Browser.isIE&&this.$r9)?"visibility:hidden;":""),"'>",(isc.Browser.isMoz?"<TBODY>":""));var _29=0,_30=0,_31=this.$54p();if((isc.Browser.isSafari||isc.Browser.isIE)&&isc.Browser.isStrict){_30=this.$54q();_29=(this.fixedRowHeights?0:this.cellPadding*2);_29+=(this.fixedRowHeights?isc.Element.$ym(_31):isc.Element.$yo(_31))}
this.$28t=_29;this.$28u=_30;if(!_25&&isc.Browser.isDOM){for(var _1=_13;_1<_14;_1++){_17.append("<COL WIDTH=",(_19[_1]-_30),">")}}
_17.append("<TBODY>")}
var _32=this.cellHeight,_33=(this.wrapCells?"":"<NOBR>"),_34=(this.wrapCells?"":"</NOBR>");var _35=0;if(isc.Browser.isDOM){var _36=this.$28v(_32);var _37=[];_37[0]="<TD";_37[3]=" ALIGN=";_37[17]=this.fastCellUpdates?"' ":"' CLASS=";if(!_5&&this.getCellElementId)_37[19]=" ID=";_37[23]=">"+_33;_37[30]=_34+(_36?"</DIV></TD>":"</TD>");var _38=1,_39=2,_40=4,_41=5,_42=6,_43=7,_44=10,_45=11,_46=18,_47=20,_48=21,_49=24;var _50="<TR>",_51="</TR>",_52=" HEIGHT=",_53=" VALIGN=";if(isc.screenReader)_50="<TR tabIndex=-1>";var _54=[],_55=0,_56=[];var _57=" COLSPAN="+_15+" STYLE='"+(this.fixedRowHeights?"padding-top:0px;padding-bottom:0px;":"");this.$50d(_13,_14,_25,_30,_36);if(this.isPrinting&&(!this.$568||_2==0)){_17.append(this.grid.getPrintHeaders(_13,_14))}
for(var _58=_2;_58<_3;_58++){var _59=(!_5&&this.$28c==_58);var _60=this.getCellRecord(_58);var _61=_59||this.$282(_58,_60);if(!_5&&this.getRowElementId){_17.append("<TR",(isc.screenReader?" tabIndex=-1":null)," ID=",this.getRowElementId(_58,_58-_2),">")}else{_17.append(_50)}
if(this.fixedRowHeights||_36){var _62=_59?this.$28f:(this.getRowHeight!=null?this.getRowHeight(_60,_58):_32),_63=_59||(this.shouldFixRowHeight==null||this.shouldFixRowHeight(_60,_58)!=false);if(_63){_37[_38]=_52;_37[_39]=_62-_29;_37[_44]=null}else{_37[_38]=null;_37[_39]=null;_37[_44]=this.$281(_60,_58)}
if(_36){_37[_48]=">"+this.$27s+this.$283(_62,_60,_58,_59)}}
for(_1=_13;_1<_14;_1++){var _64=_18[_1],_65=_60;if(_65==null)_65=this.getCellRecord(_58,_1);if(_54[_1]>0){_64.$28w[_58]=_56[_1];_54[_1]--;if(_54[_1]==0){_55--;_56[_1]=null}
continue}
_37[_40]=this.getCellAlign(_60,_64,_58,_1);var _66=this.getCellVAlign(_60,_64,_58,_1);if(_66!=null){_37[_41]=_53
_37[_42]=_66}
if(_61){_35++;_37[_43]=_57;if(_36){_37[_48+1]=this.$ob}}else{_37[_43]=_64.$28x;if(this.getRowSpan){var _67=this.getRowSpan(_60,_58,_1);if(_67>1){var _68=" ROWSPAN="+_67;if(_37[_40]!=null)
_37[_40]+=_68;else
_37[_40]=_68;_54[_1]=_67-1;_55++;_56[_1]=_58;if(_64.$28w==null)_64.$28w={};_64.$28w[_58]=_58}}
if(_36){_37[_48+1]=_64.$28y}else{_37[_48+1]=null}}
var _69=this.getCellStyle(_60,_58,_1),_70=(this.getCellCSSText?this.getCellCSSText(_60,_58,_1):null);if(_59){var _71="padding:0px;border:0px;";if(_70)_70+=";"+_71
else _70=_71}
if(!this.fastCellUpdates){_37[_45]=_70
_37[_46]=_69}else{_37[_45]=isc.Element.getStyleText(_69,true);_37[_45+1]=_70}
if(_59){this.$28q=true;var _72=this.getTableHTML(null,this.$28c,this.$28e);delete this.$28q;if(!_36){_37[_49]=isc.SB.concat(this.$27s,this.$283(_62,_60,_58,_59),this.$ob,this.$oa,_72,"</DIV>")}else{_37[_49]=_72}}else
_37[_49]=this.$22k(_60,_58,_1);if(!_5&&this.getCellElementId){_37[_47]=this.getCellElementId(_58,_58-_2,_1,_1-_13)}
_17.append(_37);if(!_5&&_65!=null&&_65.$29a!=null){if(_65.$29a[0]&&_65.$29a[0].rowNum==null)
{this.updateEmbeddedComponentCoords(_65.$29a,_65,_58,_1)}}
if(_61)break}
_17.append(_51);if(_59){_58=this.$28e-1}}}
if(!this.$568||_3==this.getTotalRows())_17.append("</TABLE>");var _73=_7-_3,_74=(!_5&&this.$60s);var _75=this.cacheDOM?0:(this.endSpace||0);this.$515=0;if(!this.showAllRows&&(_73!=0||(_74&&_73==0&&(this.overflow=="auto"||this.overflow=="scroll"))))
{var _76=_73*this.getAvgRowHeight();if(_74&&_73==0){var _77=this.getViewportHeight();if(_76<_77){_76=_77}}
this.$515=_76;_75+=this.$515}
if(!this.cacheDOM&&!this.isPrinting){_17.append("<DIV STYLE='overflow:hidden;width:1px;height:",_75,"px;",(_75==0?"display:none;":null),(_5?"'>":"' ID="+this.getID()+"$284>"),isc.Canvas.spacerHTML(1,_75),"</DIV>")}
if(this.logIsDebugEnabled("gridHTML")){var _78=(isc.timeStamp()-_4),_79=((_14-_13)*(_3-_2)),_80=(_78/ _79),_81=(1000/_80);if(_80.toFixed!=null)_80=_80.toFixed(2);if(_81.toFixed!=null)_81=_81.toFixed(2);this.logDebug("getTableHTML: columns "+_13+"->"+(_14-1)+", rows "+_2+"->"+(_3-1)+", time: "+_78+"ms ("+_79+" cells at "+_80+"ms per cell, "+_81+" cells per second), "+"spacerHeights: ["+[_27,_75]+"], "+_35+" single cell rows","gridHTML")}
return _17.release()}
,isc.A.getCellVAlign=function(_1,_2,_3,_4){return null}
,isc.A.getCellAlign=function(_1,_2,_3,_4){return _2.cellAlign||_2.align}
,isc.A.$54p=function(){return(this.getBaseStyle!=null?this.getBaseStyle(this.getCellRecord(0,0),0,0):this.baseStyle)}
,isc.A.$50d=function(_1,_2,_3,_4,_5){var _6=this.fields,_7=this.$26a;for(var _8=_1;_8<_2;_8++){var _9=_6[_8];_9.$28w=null;if(_3){_9.$28x=(isc.Browser.isIE&&!isc.Browser.isIEStrict)?" STYLE='":" STYLE='OVERFLOW:hidden;";_9.$28y=this.$ob}else{var _10=isc.Browser.isIE8Strict?" STYLE='overflow:hidden;":" STYLE='";_9.$28x=(isc.Browser.isIE?" WIDTH="+(_7[_8]-_4)+_10:" STYLE='"+this.$28z(_8));if(_5){_9.$28y=this.$280(_8)+this.$ob}}
if(!this.fixedRowHeights){_9.$28x+=this.$281()}
if(this.fixedRowHeights)_9.$28x+="padding-top:0px;padding-bottom:0px;"}}
,isc.A.$28v=function(_1){return(isc.Browser.isSafari||(isc.Browser.isOpera&&!this.autoFit&&(this.fixedColumnWidths||this.fixedRowHeights))||(isc.Browser.isMoz&&isc.Browser.geckoVersion>=20040113&&this.fixedColumnWidths&&!this.autoFit)||(this.fixedRowHeights&&(this.wrapCells||this.enforceVClipping)&&(isc.Browser.isMoz||(isc.Browser.isStrict&&isc.Browser.isIE))))}
,isc.A.$282=function(_1,_2){return(_2&&(_2[this.singleCellValueProperty]!=null||_2[this.isSeparatorProperty]||(Array.isLoading(_2)&&!(isc.Browser.isSafari&&(_1==0||_1==this.$252)))))}
,isc.A.$283=function(_1,_2,_3,_4){var _5=_4||(this.fixedRowHeights&&(this.enforceVClipping||this.wrapCells)&&(this.shouldFixRowHeight==null||this.shouldFixRowHeight(_2,_3)!=false));if(_5){var _6=_1-2*this.cellSpacing-
(_4?0:2);if(_3==this.$285){for(var i=0;i<this.$286.getItems().length;i++){_6=Math.max(this.$286.getItems()[i].getHeight(),this.$286.getItems()[i].iconHeight)}}
if(_6<1)_6=1;return(isc.Browser.isMoz||isc.Browser.isSafari?"MAX-HEIGHT:":"HEIGHT:")+_6+"px;"}
return isc.$ad}
,isc.A.$280=function(_1){if(!this.fixedColumnWidths||this.autoFit)return isc.emptyString;return"WIDTH:"+this.getInnerColumnWidth(_1)+"px;"}
,isc.A.$281=function(_1,_2){var _3=(_2!=null?this.getRowHeight(_1,_2):this.cellHeight),_4=isc.Browser.isIE,_5=isc.Browser.isStrict;if(_5&&(_4||isc.Browser.isSafari))_3-=this.$28t;if(_4&&!_5&&!(this.autoFit||!this.fixedColumnWidths)){return"MIN-HEIGHT:"+_3+"px;"}
return"HEIGHT:"+_3+"px;"}
,isc.A.$28z=function(_1){if(isc.Browser.isIE||this.autoFit)return isc.$ad;if(this.$287==null){this.$287=[];for(var i=0;i<this.$26a.length;i++){var _3=this.$26a[i];this.$287[i]="WIDTH:"+_3+(this.fixedColumnWidths?"px;OVERFLOW:hidden;":"px;")}}
return this.$287[_1]}
,isc.A.getCellRecord=function(_1,_2){return null}
,isc.A.findRowNum=function(_1){return-1}
,isc.A.findColNum=function(_1){return-1}
,isc.A.$22k=function(_1,_2,_3){var _4=this.getCellValue(_1,_2,_3,this);if(_1&&_1.$29a){var _5=0;for(var i=0;i<_1.$29a.length;i++){var _7=_1.$29a[i];if(_7.embeddedPosition==this.$57m)_5+=_7.getVisibleHeight()}
if(_5){_4+="<BR>"+isc.Canvas.spacerHTML(1,_5)}}
return _4}
,isc.A.getCellValue=function(_1,_2,_3){return this.emptyCellValue}
,isc.A.getTotalRows=function(){return this.totalRows}
,isc.A.setColumnWidth=function(_1,_2){this.fields[_1].width=this.$26a[_1]=_2;this.$287=null;this.markForRedraw("setColumnWidth")}
,isc.A.setColumnWidths=function(_1){var _2=this.$26a;this.$26a=_1.duplicate();this.$287=null;if(_2!=null&&_1!=null&&_2.length==_1.length){if(_2==_1)return;var _3=false;for(var i=0;i<_2.length;i++){if(_2[i]!=_1[i])_3=true}
if(!_3)return;if(!this.fixedColumnWidths&&!this.wrapCells&&this.isDrawn()&&_1.length==1){var _5=this.$28r||_2[0],_6=_1[0],_7=this.getColumnSize(0);if((_5==_6)||(_7>_5&&_7>=_6)){return}}}
this.markForRedraw("setColumnWidths")}
,isc.A.shouldRedrawOnResize=function(_1,_2,_3){if(this.redrawOnResize!=null)return this.redrawOnResize;if(isc.isA.ListGrid(this.parentElement)&&isc.isA.Layout(this.parentElement.parentElement))
{var _4=this.parentElement.parentElement.getMembers();if(_4&&_4.map("isAnimating").or())return false}
if(this.$276()||this.$277())return true;if(this.isEmpty())return true;return false}
,isc.A.getRowHeight=function(_1,_2){var _3=this.updateHeightForEmbeddedComponents(_1,_2,this.cellHeight);return _3}
,isc.A.updateHeightForEmbeddedComponents=function(_1,_2,_3){if(_1&&_1.$29a){var _4=_1.$29a;for(var i=0;i<_4.length;i++){var _6=_1.$29a[i];if(!isc.isA.Canvas(_6))continue;_6.$289=_2;if(_6.embeddedPosition==this.$57l)continue;_3+=_6.getVisibleHeight()}}
return _3}
,isc.A.getCellStartRow=function(_1,_2){var _3=this.fields[_2].$28w;if(_3==null||_3[_1]==null)return _1;return _3[_1]}
,isc.A.getCellRowSpan=function(_1,_2){var _3=this.fields[_2].$28w;var _4=this.getCellStartRow(_1,_2);if(_4==_1)return 1;var _5=_1+1,_6=_1-_4+1;while(_5<=this.$253&&_3[_5]==_4)
{_5++;_6++}
return _6}
,isc.A.addEmbeddedComponent=function(_1,_2,_3,_4,_5){if(_5==null)_5=this.$57m;if(!isc.isA.Canvas(_1)){_1.autoDraw=false;var _6=isc.ClassFactory.getClass(_1._constructor);if(_6==null)_6=isc.Canvas;_1=_6.create(_1)}
var _7;if(this.$29a&&this.$29a.contains(_1)){if(_2.$29a&&_2.$29a.contains(_1)&&_1.embeddedPosition==_5&&_1.$289==_3&&_1.$57n==_4)
{return}
if(_5==_1.embeddedPosition&&_5==this.$57l){_7=!this.isDirty()}
this.removeEmbeddedComponent(_1.embeddedRecord,_1,true)}else if(_5==this.$57l){_7=!this.isDirty()}
if(!_2.$29a)_2.$29a=[];_2.$29a.add(_1);if(this.$29a==null)this.$29a=[];this.$29a.add(_1);_1.embeddedPosition=_5;_1.embeddedRecord=_2;_1.$289=_3;_1.$57n=_4;_1.percentBox="custom";if(_1.parentElement!=this){_1.hide();this.addChild(_1)}
if(_5==this.$57m){this.observe(_1,"resized","if(deltaY!=null&&deltaY!=0)observer.markForRedraw('embedded component resized')")}
_1.$29b=_1.$nu;_1.$nu=false;if(_7&&(_3==-1||_4==-1)){_7=false}
if(_7){this.placeEmbeddedComponent(_1)}else{this.markForRedraw("added embedded component")}}
,isc.A.updateEmbeddedComponentCoords=function(_1,_2,_3,_4){_1.setProperty("$289",_3)}
,isc.A.placeEmbeddedComponent=function(_1){var _2=_1.$289;if(_2==null||_2<this.$252||_2>this.$253){if(_1.isDrawn())_1.clear()}else{var _3=_1.embeddedRecord,_4=_1.embeddedPosition;if(_4==this.$57l){var _5=_1.snapTo||"TL",_6=_1.snapEdge||_5,_7=_1.$57n;var _8=this.getRowSize(_2),_9=_7!=null?this.getColumnWidth(_7):this.$26a.sum(),_10=_1._percent_width,_11=_1._percent_height,_12,_13;if(isc.isA.String(_10)&&_10.endsWith("%")){_12=Math.round((parseInt(_10)*_9)/100)}
if(isc.isA.String(_11)&&_11.endsWith("%")){_13=Math.round((parseInt(_11)*_8)/100)}
var _14=this.getRowTop(_2),_15=_7!=null?this.getColumnLeft(_7):0,_16=_13!=null?_13:_1.getHeight(),_17=_12!=null?_12:_1.getWidth();var _18=this.$52c(_5,[_14,_15],[_9,_8],false),_19=this.$52c(_6,_18,[_17,_16],true);if(_13||_12){_1.setRect(_19[1],_19[0],_12,_13);_1._percent_width=_10,_1._percent_height=_11}else{_1.moveTo(_19[1],_19[0])}}else{_1.setTop(this.getRowTop(_2)+this.cellHeight)}
if(!_1.isDrawn())_1.draw();if(!_1.isVisible()){if(this.shouldAnimateEmbeddedComponent(_1)){_1.animateShow()}else{_1.show()}}
this.updateEmbeddedComponentZIndex(_1)}}
,isc.A.shouldAnimateEmbeddedComponent=function(_1){return false}
,isc.A.updateEmbeddedComponentZIndex=function(_1){}
,isc.A.removeEmbeddedComponent=function(_1,_2,_3){if(isc.isA.Number(_1))_1=this.getCellRecord(_1,0);var _4=_1.$29a;if(_4==null||!_4.contains(_2))return;if(this.isObserving(_2,"resized")){this.ignore(_2,"resized")}
_1.$29a.remove(_2);if(_1.$29a.length==0)_1.$29a=null;this.$29a.remove(_2);_2.$nu=_2.$29b;_2.$29b=null;var _5=_2.embeddedPosition==this.$57m;_2.embeddedPosition=null;_2.$289=null;_2.$57n=null;if(_3){_2.hide();return}
if(_2.destroyOnUnEmbed)_2.destroy();else{this.removeChild(_2)}
if(_5){this.markForRedraw("removed embedded component")}}
,isc.A.$29c=function(){var _1=this.$29a;if(_1==null)return;_1.setProperty("$289",null)}
,isc.A.$29d=function(){var _1=this.$29a;if(_1==null)return;for(var i=0;i<_1.length;i++){this.placeEmbeddedComponent(_1[i])}}
,isc.A.getTableZIndex=function(){return 1000}
,isc.A.getCellStyle=function(_1,_2,_3){if(_1&&_1[this.recordCustomStyleProperty]!=null){return _1[this.recordCustomStyleProperty]}
var _4=this.getCellStyleIndex(_1,_2,_3);return this.getCellStyleName(_4,_1,_2,_3)}
,isc.A.getCellStyleName=function(_1,_2,_3,_4){var _5=isc.GridRenderer.standardStyleSuffixes;if(this.getBaseStyle){var _6=this.getBaseStyle(_2,_3,_4);if(_6!==this.baseStyle){if(_1==0)return _6;return _6+_5[_1]}}
if(!this.$29e){this.$29e=[];for(var i=0;i<_5.length;i++){this.$29e[i]=this.baseStyle+_5[i]}}
return this.$29e[_1]}
,isc.A.getCellStyleIndex=function(_1,_2,_3){var _4=0;if(this.alternateRowStyles){var _5=(Math.floor(_2/ this.alternateRowFrequency)%2==1);if(_5)_4+=8}
if(!this.cellIsEnabled(_2,_3)){_4+=4}else{if(this.shouldShowRollOver(_2,_3)&&!this.isPrinting&&_2==this.lastOverRow&&(!this.useCellRollOvers||_3==this.lastOverCol))
{_4+=1}
if(this.selectionEnabled()){var _6=(this.canSelectCells?this.selection.cellIsSelected(_2,_3):this.selection.isSelected(_1));if(_6)_4+=2}}
return _4}
,isc.A.cellIsEnabled=function(_1,_2){return true}
,isc.A.getTableElementId=function(){return this.getCanvasName()+"table"}
,isc.A.getDOMTable=function(_1,_2){if(this.cacheDOM)return this.getTableChunkAt(_1,_2);if((_1!=null&&(_1-this.$252<0||_1>this.$253))||(_2!=null&&(_2-this.$254<0||_2>this.$255)))
return null;var _3=this.$29f;if(_3==null){var _4=this.getTableElementId();var _3=isc.Element.get(_4);if(_3==null)return null}
return this.$29f=_3}
,isc.A.getTableElement=function(_1,_2){var _3=this.getDOMTable(_1,_2);if(_1==null)return _3;if(!_3)return null;var _4=_1-(this.$252>0?this.$252:0);if(_4<0){return null}
var _5;if(this.$29g!=null)_5=this.$29g[_4];if(_5==null)_5=_3.rows[_4];if(_5==null)return null;if(this.$29g==null)this.$29g=[];this.$29g[_4]=_5;if(_2==null)return _5;var _6=_2-this.$254;if(_6<0){return null}
if(this.getRowSpan){var _7=this.getCellStartRow(_1,_6);if(_7!=_4){_4=_7;_5=this.getTableElement(_7)}
if(_5.cells.length<(this.$255-this.$254+1)){var _8=0;for(var i=0;i<_6;i++){if(this.fields[i].$28w!=null&&this.fields[i].$28w[_4]!=null&&this.fields[i].$28w[_4]!=_4)_8++}
_6-=_8}}
return _5.cells[_6]}
,isc.A.$29h=function(_1,_2,_3,_4,_5){if(_4==null)_4=this.getTableElement(_2,_3);if(_4==null)return;if(_1==null)_1=this.getCellRecord(_2,_3);if(_5==null)_5=this.getCellStyle(_1,_2,_3);if(this.fastCellUpdates){_4.style.cssText=this.$29i(_1,_2,_3,_5)}else{if(_4.className!=_5)_4.className=_5;if(this.getCellCSSText){_4.style.cssText=this.$29i(_1,_2,_3,_5)}}
if(this.shouldRefreshCellHTML(_1,_2,_3)){this.refreshCellValue(_2,_3)}
if(!this.isDrawn())return;var _6=this.fixedRowHeights&&(this.shouldFixRowHeight==null||this.shouldFixRowHeight(_1,_2)!=false),_7=(this.getRowHeight!=null?this.getRowHeight(_1,_2):this.cellHeight);this.setRowHeight(_2,_7,_1,_5,_6)}
,isc.A.$28g=function(_1){if(_1==null)return null;var _2=_1.childNodes[0];if(!_2)return null;if(_2.tagName==this.$27t)_2=_2.childNodes[0];if(_2&&(_2.cellClipDiv||(_2.getAttribute&&_2.getAttribute(this.$27u))))
{return _2}
return null}
,isc.A.setRowHeight=function(_1,_2,_3,_4,_5,_6){var _7=this.$254,_8=this.$255;if(_5==null){if(_3==null)_3=this.getCellRecord(_1,_7);_5=this.fixedRowHeights&&(this.shouldFixRowHeight==null||this.shouldFixRowHeight(_3,_1)!=false)}
var _9=this.getTableElement(_1,_7),_10=_9?parseInt(_9.height):null,_11;if(!isc.isA.Number(_10))_10=null;if((isc.Browser.isSafari||isc.Browser.isIE)&&isc.Browser.isStrict){if(_3==null)_3=this.getCellRecord(_1,_7);var _12=_4;if(_12==null)_12=this.getCellStyle(_3,_1,_7)
_2-=this.fixedRowHeights?isc.Element.$ym(_12):isc.Element.$yo(_12);if(!this.fixedRowHeights)_2-=(this.cellPadding*2)}
if((!_5&&_10!=null)||(_10!=_2&&!(_10==null&&_2==isc.emptyString)))
{_11=true}
if(!_11)return;var _13=isc.isA.Number(_2);if(_13&&_2<=0)_2=_5?0:1;var _14=this.getTableElement(_1);if(_2==0&&_5){_14.style.display="none"}else{_14.style.display=isc.emptyString;for(var i=_7;i<=_8;i++){var _16=this.getTableElement(_1,i);if(_16){var _17=(!isc.Browser.isIE||isc.Browser.isStrict)?this.$o5:this.$27v;if(_5){_16.height=_2;_16.style[_17]=isc.emptyString}else{_16.height=isc.emptyString;_16.style[_17]=_2}
var _18=this.$28g(_16),_19=(_5?(_13?_2+isc.px:_2):isc.emptyString);if(_18){if(isc.Browser.isMoz||isc.Browser.isSafari)
_18.style.maxHeight=_19;else
_18.style.height=_19}}}}
if(isc.Browser.isSafari&&this.$28o){var _20=this.getTableElement(_1);if(_20!=null){_20.innerHTML=_20.innerHTML}}
this.$29j();if(_6){this.adjustOverflow("cell height changd")}else{this.$t6("cell height changed")}}
,isc.A.$29i=function(_1,_2,_3,_4){var _5=null;if(this.fixedRowHeights)_5="padding-top:0px;padding-bottom:0px;";else{_5=this.$281(_1,_2)}
if(isc.Browser.isIE8Strict){if(_5==null)_5="overflow:hidden;";else _5+="overflow:hidden;"}
if(isc.Browser.isMoz){if(_5==null)_5=this.$28z(_3);else _5+=this.$28z(_3)}
if(this.fastCellUpdates){if(_4==null)_4=this.getCellStyle(_1,_2,_3);var _6=isc.Element.getStyleText(_4,true);if(_6==null&&isc.Page.$29k){this.fastCellUpdates=false;this.redraw()}
if(_5!=null)_5+=_6;else _5=_6}
if(this.getCellCSSText){var _7=this.getCellCSSText(_1,_2,_3)
if(_7!=null){if(!_7.endsWith(this.$39)){_7+=this.$39}
if(_5!=null)_5+=_7
else _5=_7}}
return _5}
,isc.A.shouldRefreshCellHTML=function(_1,_2,_3){return this.showHiliteInCells}
,isc.A.$29l=function(_1,_2){if((isc.EH.$ku||isc.EH.$km)&&isc.EH.lastEvent.target==this){var _3=this.getEventRow();if(_3!=_1)return true;if(_2!=null){var _4=this.getEventColumn();if(_2!=_4)return true}
return false}
return true}
,isc.A.refreshCellValue=function(_1,_2){var _3=this.getTableElement(_1,_2);if(!_3)return;if(!this.$29l(_1,_2)){this.delayCall("refreshCellValue",[_1,_2]);return}
var _4=this.getCellRecord(_1,_2),_5=this.fields[_2];if(!_5){this.logDebug("refreshCell called for invalid field "+_2);return}
var _6="";var _7=this.getCellStyle(_4,_1,_2),_8=this.$28v(_9);if(_8){_6+=this.$27s;var _9=(this.getRowHeight!=null?this.getRowHeight(_4,_1):this.cellHeight);_6+=this.$283(_9,_4,_1);var _10=this.$282(_1,_4);if(!_10){_6+=this.$280(_2)}
_6+="'>"}
if(!this.wrapCells)_6+="<NOBR>";_6+=this.$22k(_4,_1,_2);if(!this.wrapCells)_6+="</NOBR>";if(_8)_6+="</DIV>";_3.innerHTML=_6}
);isc.evalBoundary;isc.B.push(isc.A.setCellStyle=function(_1,_2,_3){return this.setRowStyle(_1,_3,_2)}
,isc.A.setRowStyle=function(_1,_2,_3){if(isc.$cv)arguments.$cw=this;if(_1==null||_1<0){this.logWarn("setRowStyle: bad rowNum: "+_1);return false}
var _4=this.getTableElement(_1,_3);if(_4==null){return false}
var _5=this.getCellRecord(_1,_3);if(_5&&_5.$29m)return;if(_3!=null){this.$29h(_5,_1,_3,_4,_2)}else{var _6=this.getTableElement(_1);if(_6!=null){var _7="TD",_8=(!this.showAllColumns?this.$254:0),_9=(!this.showAllColumns?this.$255:this.fields.length-1),_10=0;for(var _11=_8;_11<=_9;_11++,_10++){var _4;if(this.showColumnsSeparately||this.cacheDOM){_4=this.getTableElement(_1,_11)}else{_4=_6.cells[_10]}
if(_4==null)continue;this.$29h(_5,_1,_11,_4,_2)}}}
return true}
,isc.A.refreshCellStyle=function(_1,_2,_3){return this.setCellStyle(_1,_2,_3)}
,isc.A.refreshCell=function(_1,_2){this.refreshCellStyle(_1,_2);if(!this.shouldRefreshCellHTML())this.refreshCellValue(_1,_2)}
,isc.A.refreshRow=function(_1){if(!this.$29l(_1)){this.delayCall("refreshRow",[_1])}
for(var i=0;i<this.fields.length;i++){this.refreshCell(_1,i)}}
,isc.A.refreshCellStyles=function(_1,_2){this.logDebug("refreshing cell styles: "+_1.length+" cells");for(var i=0;i<_1.length;i++){var _4=_1[i][0],_5=_1[i][1];var _6=this.getTableElement(_4,_5);if(_6==null){continue}else{this.$29h(null,_4,_5,_6,_2)}}
return true}
,isc.A.getCellPageRect=function(_1,_2){return[this.getColumnPageLeft(_2),this.getRowPageTop(_1),this.getColumnSize(_2),this.getRowSize(_1)]}
,isc.A.getColumnLeft=function(_1){if(this.isRTL()){return this.getScrollWidth()-this.$26a.sum(0,_1+1)-
(this.vscrollOn?this.getScrollbarSize():0)}else{return this.$26a.sum(0,_1)}}
,isc.A.getColumnPageLeft=function(_1){return this.getPageLeft()-this.getScrollLeft()+this.getColumnLeft(_1)+(this.isRTL()&&this.vscrollOn?this.getScrollbarSize():0)}
,isc.A.getColumnWidth=function(_1){return this.$26a[_1]}
,isc.A.getInnerColumnWidth=function(_1){var _2=this.getColumnWidth(_1);if(_2==null)return null;return(_2-(2*this.cellSpacing+this.$54q()))}
,isc.A.$54q=function(_1){if(!_1&&this.$54r!=null)return this.$54r;var _2=this.$54p(),_3=isc.Element.$tr(_2,true),_4=isc.Element.$ts(_2,true),_5=isc.Element.$yn(_2);if(_3==null)_3=this.cellPadding;if(_4==null)_4=this.cellPadding;this.$54r=(_3+_4+_5);return this.$54r}
,isc.A.getRowTop=function(_1){if(_1<this.$252)return this.getAvgRowHeight()*_1;var _2=this.$29n(),_3=this.$26b();if(_1>this.$253){return _2+_3.sum()+(((_1-1)-this.$253)*this.getAvgRowHeight())}
return _2+_3.sum(0,_1-this.$252)}
,isc.A.getRowPageTop=function(_1){return this.getPageTop()+this.getTopBorderSize()+(this.getRowTop(_1)-this.getScrollTop())}
,isc.A.getRowSize=function(_1){if(_1<this.$252||_1>this.$253){return this.getAvgRowHeight()}
var _2=_1-this.$252,_3=this.$26b();return _3[_2]}
,isc.A.getColumnSize=function(_1){if((this.fixedFieldWidths&&!this.autoSize)||(_1<this.$254||_1>this.$255))
{return this.getColumnWidth(_1)}
var _2=_1-this.$254,_3=this.getColumnSizes();return _3[_2]}
,isc.A.$29n=function(){return this.$252*this.getAvgRowHeight()}
,isc.A.$26b=function(){if(this.$8s!=null)return this.$8s;var _1=this.$8s=[];var _2=this.getTableElement();if(!_2||!_2.rows){delete this.$8s;return _1}
var _3=this.getDrawnRows(),_4=_3[1]-_3[0]+1,_5=false;for(var _6=0;_6<=_4;_6++){var _7=this.cacheDOM?this.getTableElement(_6+this.$252):_2.rows[_6];if(_7){var _8=(isc.Browser.isSafari&&(this.fixedRowHeights==false||(this.shouldFixRowHeight!=null&&this.shouldFixRowHeight(this.getCellRecord(_6),_6)==false))),_9,_10=[];if(!isc.Browser.isSafari||(!_8&&isc.Browser.safariVersion>=125)){_9=_7.cells[_7.cells.length-1]}else{if(isc.Browser.safariVersion>=125){for(var k=0;k<_7.cells.length;k++){_10[k]=_7.cells[k]}}}
if(_8){_1[_6]=0;for(var _12=0;_12<_10.length;_12++){var _13=_10[_12],_14=_13.offsetHeight;var _15=parseInt(_13.style?_13.style.height:null);if(isc.Browser.isStrict){if(this.cellPadding)_15+=this.cellPadding;_15+=isc.Element.$yo(_13.className)}
if(isc.isA.Number(_15)&&_15>_14)
_14=_15;if(_14>_1[_6])_1[_6]=_14}
_1[_6]+=this.cellSpacing}else if(_9){if(!isc.Browser.isSafari){_1[_6]=_9.offsetHeight}else{var _16=parseInt(_9.height);if(_16!=null&&isc.isA.Number(_16)){if(isc.Browser.isStrict){_16+=isc.Element.$ym(_9.className)}}else{_16=_9.offsetHeight||0}
_1[_6]=_16}
_1[_6]+=this.cellSpacing}}
var _14=_1[_6];if(_14!=0&&_14!=null)_5=true}
_1[0]+=this.cellSpacing;if(!_5){this.logWarn("row heights not yet available; returning all zeroes");this.$8s=null}
if(isc.Browser.isSafari&&!isc.Page.isLoaded())this.$8s=null;return _1}
,isc.A.getColumnSizes=function(){if(this.$29o!=null)return this.$29o;if(this.fixedColumnWidths&&isc.Browser.version>=5){return(this.$29o=this.$26a.duplicate())}else{var _1=this.$29o=[];var _2=this.getTableElement(this.$252);if(_2==null){this.$29o=_1.concat(this.$26a);return this.$29o}
var _3=(isc.Browser.isMac?this.cellSpacing:0);for(var _4=0;_4<this.fields.length;_4++){var _5;if(this.showColumnsSeparately){_5=this.getTableElement(this.$252,_4)}else if(!(isc.Browser.isSafari&&isc.Browser.safariVersion<125)){_5=_2.cells[_4]}
if(_5){_1[_4]=_5.offsetWidth+_3}else{_1[_4]=this.$26a[_4]}}
this.innerWidth=this.getTableElement().offsetWidth;return _1}}
,isc.A.getEventRow=function(_1){if(this.isEmpty())return-2;if(_1==null)_1=this.getOffsetY();if(this.startSpace)_1-=this.startSpace;var _2=this.$29n();if(_1<=_2)return Math.floor(_1/ this.getAvgRowHeight());var _3=_1-_2,_4=this.$26b();var _5=this.inWhichPosition(_4,_3),_6;if(_5>=0){_6=this.$252+_5}else{var _7=_3-_4.sum();_6=this.$253+1+Math.floor(_7/ this.getAvgRowHeight());if(_6>=this.getTotalRows())_6=-2}
return _6}
,isc.A.getEventColumn=function(_1){var _2=this.getColumnSizes();if(_1==null)_1=this.getOffsetX();return this.inWhichPosition(_2,_1,this.getTextDirection())}
,isc.A.getNearestRowToEvent=function(){var _1=this.getEventRow();if(_1<0){var _2=this.getVisibleRows();if(_1==-1)return _2[0];if(_1==-2)return _2[1]}
return _1}
,isc.A.getNearestColToEvent=function(){var _1=this.getEventColumn();if(_1<0){var _2=this.getVisibleColumns();if(_1==-1)return _2[0];if(_1==-2)return _2[1]}
return _1}
,isc.A.$27x=function(){var _1=Math.floor(this.getScrollTop()/this.getAvgRowHeight()),_2=_1+Math.ceil(this.getViewportHeight()/this.cellHeight);if(this.startSpace){var _3=Math.floor(this.startSpace/ this.getAvgRowHeight());_1=Math.max(0,_1-_3);_2=Math.max(0,_2-_3)}
var _4=this.virtualScrolling&&!this.fixedRowHeights&&this.$27y!=null;if(_4){if(_1==0&&_2>=(this.getTotalRows()-1))_4=false}
if(!_4)return[_1,_2];var _5=this.$27y;if(this.$27z<0)_5+=Math.floor(this.$27z/ this.cellHeight);if(_5<0)_5=0;var _6=_5+Math.ceil(this.getViewportHeight()/this.cellHeight);return[_5,_6]}
,isc.A.getAvgRowHeight=function(){return this.fixedRowHeights?this.cellHeight:this.avgRowHeight}
,isc.A.getVisibleRows=function(){var _1=this.getScrollTop();var _2=[this.getEventRow(_1),this.getEventRow(_1+this.getInnerHeight())];if(_2[1]==-2){var _3=this.getTotalRows();if(_3==0){_2[0]=-1;_2[1]=-1}else{_2[1]=this.getTotalRows()-1}}
return _2}
,isc.A.getVisibleColumns=function(){var _1=this.$26a;if(this.overflow==isc.Canvas.VISIBLE)return[0,_1.length-1];var _2=this.getScrollLeft();if(this.isRTL()){var _3=this.getScrollWidth()-this.getInnerWidth(),_2=_3-_2}
var _4=this.inWhichPosition(_1,_2),_5=this.inWhichPosition(_1,_2+this.getInnerWidth());if(_5==-2)_5=this.$26a.length-1;return[_4,_5]}
,isc.A.getDrawnRows=function(){if(this.cacheDOM)return this.getVisibleRows();return[this.$252,this.$253]}
,isc.A.shouldShowRollOver=function(_1,_2){return(this.showRollOver&&!this.$28j)}
,isc.A.updateRollOver=function(_1,_2){this.setRowStyle(_1,null,(this.useCellRollOvers?_2:null))}
,isc.A.startHover=function(){}
,isc.A.mouseMove=function(_1,_2){if(this.$29p())return;var _3=this.getEventRow(),_4=this.getEventColumn();if(_3==this.lastOverRow&&_4==this.lastOverCol)return false;var _5,_6=(_3!=this.lastOverRow||_4<0);var _7=(_3>=0&&_4>=0&&this.cellIsEnabled(_3,_4));if(this.lastOverRow!=null&&this.lastOverCol!=null){var _8=this.lastOverRow,_9=this.lastOverCol,_10=this.getCellRecord(_8,_9);this.lastOverRow=null;this.lastOverCol=null;if((this.hoverByCell||_6)&&this.shouldShowRollOver(_8,_9))
{this.updateRollOver(_8,_9,_7);if(this.getCanHover()&&!this.keepHoverActive)this.stopHover()}
if(this.cellOut){this.cellOut(_10,_8,_9)}
if(_6&&this.rowOut){this.rowOut(_10,_8,_9)}}
if(_7){this.lastOverRow=_3;this.lastOverCol=_4;if(this.hoverByCell||_6){if(this.shouldShowRollOver(_3,_4)){this.updateRollOver(_3,_4)}
if(this.getCanHover()){isc.Hover.setAction(this,this.$29q,[_3,_4],this.hoverDelay)}}
if(this.cellOver){this.cellOver(this.getCellRecord(_3,_4),_3,_4)}
if(_6&&this.rowOver){this.rowOver(this.getCellRecord(_3,_4),_3,_4)}}
return isc.EventHandler.STOP_BUBBLING}
,isc.A.$29p=function(){if(this.$28j!=null)return true;return false}
,isc.A.mouseOut=function(){var _1=isc.EH.getTarget();if(this.$29a){var _2=this.$29a;for(var i=0;i<_2.length;i++){if(_2[i].contains(_1,true))return}}
if(_1==this)return;if(this.getCanHover())this.stopHover();if(this.lastOverRow!=null&&this.lastOverCol!=null){var _4=this.lastOverRow,_5=this.lastOverCol,_6=this.getCellRecord(_4,_5);this.lastOverRow=null;this.lastOverCol=null;if(this.shouldShowRollOver(_4,_5)){this.updateRollOver(_4,_5)}
if(this.cellOut){this.cellOut(_6,_4,_5)}
if(this.rowOut){this.rowOut(_6,_4,_5)}}}
,isc.A.$29q=function(_1,_2){var _3=this.getCellRecord(_1,_2);var _4;if(this.cellHover&&this.cellHover(_3,_1,_2)==false)_4=false;if(this.rowHover&&this.rowHover(_3,_1,_2)==false)_4=false;if(_4==false)return;if(this.showHover)this.$29r(_3,_1,_2)}
,isc.A.$29r=function(_1,_2,_3){var _4=this.$wc();isc.Hover.show(this.cellHoverHTML(_1,_2,_3),_4,this.cellHoverBoundary(_2,_3),this.getHoverTarget())}
,isc.A.getHoverTarget=function(){return this}
,isc.A.cellHoverHTML=function(_1,_2,_3){return null}
,isc.A.cellHoverBoundary=function(_1,_2){return null}
,isc.A.showContextMenu=function(){if(this.$29p())return false;var _1=this.getEventRow(),_2=this.getEventColumn();if(_1>=0&&_2>=0&&this.cellIsEnabled(_1,_2)){var _3=this.getCellRecord(_1,_2),_4;if(this.cellContextClick)
if(this.cellContextClick(_3,_1,_2)==false)_4=false;if(this.rowContextClick)
if(this.rowContextClick(_3,_1,_2)==false)_4=false;if(this.recordContextClick)
if(this.recordContextClick(_3,_1,_2)==false)_4=false;if(_4==false)return false}
return this.Super("showContextMenu")}
,isc.A.setSelection=function(_1){this.selection=_1;if(this.selection.isA("CellSelection")){this.observe(this.selection,"selectionChanged","observer.$29s(observed.changedCells)")}else{this.observe(this.selection,"setSelected","observer.$29t(observed.lastSelectionItem,observed.lastSelectionState)")}}
,isc.A.clearSelection=function(){if(this.selection){if(this.isObserving(this.selection,"selectionChanged"))
this.ignore(this.selection,"selectionChanged");if(this.isObserving(this.selection,"setSelected"))
this.ignore(this.selection,"setSelected");delete this.selection}}
,isc.A.$29s=function(_1){if(this.cellSelectionChanged){if(this.cellSelectionChanged(_1)==false)return false}
this.refreshCellStyles(_1)}
,isc.A.$29t=function(_1,_2){if(this.selectionChanged&&(this.selectionChanged(_1,_2)==false))return false;var _3=this.selection,_4=_3.lastSelectionItem,_5=_3.data.indexOf(_4,this.$252,this.$253);if(_5==-1)_5=_3.data.indexOf(_4);if(_5==-1)return;this.updateRowSelection(_5)}
,isc.A.updateRowSelection=function(_1){this.setRowStyle(_1)}
,isc.A.selectionEnabled=function(){return this.selection!=null}
,isc.A.mouseDown=function(){if(this.$29p())return;var _1=this.getEventRow(),_2=this.getEventColumn();if(!(_1>=0&&_2>=0))return;if(!this.cellIsEnabled(_1,_2))return false;this.$29u=_1;this.$29v=_2;var _3=this.getCellRecord(_1,_2);if(!isc.EH.rightButtonDown()){return this.$29w(_3,_1,_2)}else{return this.$29x(_3,_1,_2)}}
,isc.A.rightMouseDown=function(){return this.mouseDown()}
,isc.A.$29w=function(_1,_2,_3){var _4;if(this.cellMouseDown&&(this.cellMouseDown(_1,_2,_3)==false))_4=false;if(this.rowMouseDown&&(this.rowMouseDown(_1,_2,_3)==false))_4=false;if(this.recordMouseDown&&this.recordMouseDown(_2,_3)==false)_4=false;if(_4==false)return false;this.selectOnMouseDown(_1,_2,_3);return isc.EH.STOP_BUBBLING}
,isc.A.selectOnMouseDown=function(_1,_2,_3){if(!this.selectionEnabled())return true;if(_2>=0&&_3>=0&&_1!=null&&_1[this.recordCanSelectProperty]!==false){this.selection.selectOnMouseDown(this,_2,_3)}}
,isc.A.$29x=function(_1,_2,_3){if(this.canSelectOnRightMouse)this.selectOnRightMouseDown(_1,_2,_3)}
,isc.A.selectOnRightMouseDown=function(_1,_2,_3){this.selectOnMouseDown(_1,_2,_3)}
,isc.A.mouseUp=function(){if(this.$29p())return;var _1=this.getEventRow(),_2=this.getEventColumn();if(!(_1>=0&&_2>=0))return;if(!this.cellIsEnabled(_1,_2))return;var _3=this.getCellRecord(_1,_2);var _4;if(this.cellMouseUp&&(this.cellMouseUp(_3,_1,_2)==false))_4=false;if(this.rowMouseUp&&(this.rowMouseUp(_3,_1,_2)==false))_4=false;if(this.recordMouseUp&&this.recordMouseUp(_1,_2)==false)_4=false;if(_4==false)return _4;this.selectOnMouseUp(_3,_1,_2);return isc.EventHandler.STOP_BUBBLING}
,isc.A.selectOnMouseUp=function(_1,_2,_3){if(!this.selectionEnabled())return true;if(_2>=0&&_3>=0)this.selection.selectOnMouseUp(this,_2,_3)}
,isc.A.click=function(){if(this.$29p())return;var _1=this.getEventRow(),_2=this.getEventColumn();return this.$29y(_1,_2)}
,isc.A.$29y=function(_1,_2){this.$29z=this.$290=null;if(!(_1>=0&&_2>=0))return;if(!this.cellIsEnabled(_1,_2))return false;var _3=this.$29u;if(_1!=_3)return false;this.$29z=_1;var _4=this.getCellRecord(_1,_2),_5;if(!this.$22n(_4,_1,_2))_5=false;if(this.rowClick&&(this.rowClick(_4,_1,_2)==false))
_5=false;this.$29u=null;return _5}
,isc.A.$22n=function(_1,_2,_3){if(this.$29v!=_3){this.$290=null;return}
this.$290=_3;this.$291=null;return!(this.cellClick&&(this.cellClick(_1,_2,_3)==false))}
,isc.A.doubleClick=function(){if(this.$29p())return;var _1=this.getEventRow(),_2=this.getEventColumn();if(!(_1>=0&&_2>=0))return;if(!this.cellIsEnabled(_1,_2))return false;if(_1!=this.$29z){return this.$29y(_1,_2)}
var _3=this.getCellRecord(_1,_2),_4;if(_2!=this.$290){_4=this.$22n(_3,_1,_2)}else if(this.cellDoubleClick&&(this.cellDoubleClick(_3,_1,_2)==false))
{_4=false}
if(this.rowDoubleClick&&(this.rowDoubleClick(_3,_1,_2)==false))
_4=false;this.$29u=this.$29v=null;this.$29z=this.$290=null;if(_4==false)return false}
,isc.A.dragMove=function(){if(this.$29p()||!this.selectionEnabled()||!this.canDragSelect)
return true;var _1=this.getNearestRowToEvent(),_2=this.getNearestColToEvent();this.selection.selectOnDragMove(this,_1,_2);return isc.EH.STOP_BUBBLING}
,isc.A.noSnapDragOffset=function(_1){return this.snapToCells}
,isc.A.getHSnapPosition=function(_1,_2){if(!this.snapToCells){return this.Super("getHSnapPosition",arguments)}
var _3=this.ns.EH,_4=_2||this.snapHDirection,_5=this.getEventColumn(_1),_6=this.getColumnLeft(_5),_7=this.getColumnLeft(_5)+this.getColumnSize(_5),_8=this.getEventColumn(_7+1),_9;if(_8>=0){_9=this.getColumnLeft(_8)}else{_9=_6}
var _10=_6+this.getColumnSize(_5)/2;if(this.snapInsideBorder){var _11=isc.Element.$tl(this.baseStyle)
var _12=isc.Element.$tm(this.baseStyle)
_6+=_11;_7-=_12;_9+=_11}
if(_3.dragOperation==_3.DRAG_RESIZE){var _13=isc.EH.resizeEdge.contains("L");return _13?_6:_7}else{if(_4==isc.Canvas.BEFORE){return _6}else if(_4==isc.Canvas.AFTER){return _9}else{if(_1<=_10){return _6}else{return _9}}}}
,isc.A.getVSnapPosition=function(_1,_2){if(!this.snapToCells){return this.Super("getVSnapPosition",arguments)}
var _3=this.ns.EH,_4=_2||this.snapVDirection,_5=this.snapVGap?Math.floor(_1/ this.snapVGap):this.getEventRow(_1),_6=this.snapVGap?(_5*this.snapVGap):this.getRowTop(_5),_7=this.snapVGap?_6+this.snapVGap:this.getRowTop(_5)+this.getRowSize(_5),_8=this.snapVGap?_5+1:this.getEventRow(_7+1),_9;if(_8>=0){_9=this.snapVGap?_8*this.vSnapGap:this.getRowTop(_8)}else{_9=_6}
var _10=_6+(this.snapVGap?this.snapVGap:this.getRowSize(_5))/2;if(this.snapInsideBorder){var _11=isc.Element.$tn(this.baseStyle)
var _12=isc.Element.$to(this.baseStyle)
_6+=_11;_7-=_12;_9+=_11}
if(_3.dragOperation==_3.DRAG_RESIZE){var _13=isc.EH.resizeEdge.contains("T");return _13?_6:_7}else{if(_4==isc.Canvas.BEFORE){return _6}else if(_4==isc.Canvas.AFTER){return _9}else{if(_1<=_10)return _6;else return _9}}}
,isc.A.getColumnAutoSize=function(_1){var _2=this.$292=this.$292||isc.Canvas.create({top:-1000,width:1,height:1,autoDraw:false});var _3=this.autoFit,_4=this.wrapCells;this.autoFit=true;this.wrapCells=false;_2.contents=this.getTableHTML(_1);this.autoFit=_3;this.wrapCells=_4;_2.draw();var _5=_2.getScrollWidth();_2.clear();return _5}
,isc.A.redraw=function(_1,_2,_3,_4){this.$29c();if(!this.cacheDOM)this.$29j();this.invokeSuper(isc.GridRenderer,"redraw",_1,_2,_3,_4);delete this.$50v}
,isc.A.modifyContent=function(){if(this.$27y!=null){this.$275=true;this.$270();this.$275=null;var _1=this.getTableElement();if(_1)_1.style.visibility="inherit"}
if(this.$60s){var _2=this.$26b().sum();if(_2<this.getViewportHeight()){this.$515=0;var _3=isc.Element.get(this.getID()+"$284"),_4=this.$515+(this.endSpace||0);if(_3){if(_4==0)_3.style.display="none"
else _3.style.display="";_3.style.height=_4+"px"}}
var _5=this.getVisibleRows(),_6=Math.max(1,_5[1]-_5[0]),_7=_6/ this.getTotalRows(),_8=this.getViewportRatio(true);if(isc.isA.Number(_7)&&((_8==1&&_7<1)||_8/ _7>1.25))
{this.$272=Math.max(this.cellHeight,Math.round(this.getViewportHeight()/_6))}}
this.$29d()}
,isc.A.setStartSpace=function(_1){if(!isc.isA.Number(_1)||_1==this.startSpace)return;var _2=this.startSpace&&this.startSpace>_1;this.startSpace=_1;if(!this.isDrawn())return;var _3=_1+this.$514,_4=isc.Element.get(this.getID()+"$28s");if(_4){if(_3==0)_4.style.display="none";else _4.style.display="";_4.style.height=_3+"px";if(!_2)_4.innerHTML=isc.Canvas.spacerHTML(1,_3);this.$t6()}}
,isc.A.setEndSpace=function(_1){if(!isc.isA.Number(_1)||_1==this.endSpace)return;var _2=this.endSpace&&this.endSpace>_1;this.endSpace=_1;if(!this.isDrawn())return;var _3=_1+this.$515,_4=isc.Element.get(this.getID()+"$284");if(_4){if(_3==0)_4.style.display="none";else _4.style.display="";_4.style.height=_3+"px";if(!_2)_4.innerHTML=isc.Canvas.spacerHTML(1,_3);this.$t6()}}
,isc.A.clear=function(){this.Super("clear",arguments);this.$29j();delete this.$50v}
,isc.A.$29j=function(){this.$29g=null;this.$29f=null;delete this.$29o;delete this.$293;delete this.$8s;this.$250=false}
);isc.B._maxIndex=isc.C+154;isc.GridRenderer.$294={getCellRecord:"rowNum,colNum",getCellValue:"record,rowNum,colNum,gridBody",findRowNum:"record",findColNum:"record",getBaseStyle:"record,rowNum,colNum",getCellStyle:"record,rowNum,colNum",getCellCSSText:"record,rowNum,colNum",cellIsEnabled:"rowNum,colNum",getRowHeight:"record,rowNum",getRowSpan:"record,rowNum,colNum",cellOut:"record,rowNum,colNum",cellOver:"record,rowNum,colNum",rowOut:"record,rowNum,colNum",rowOver:"record,rowNum,colNum",cellContextClick:"record,rowNum,colNum",rowContextClick:"record,rowNum,colNum",recordContextClick:"record,recordNum,fieldNum",cellMouseDown:"record,rowNum,colNum",rowMouseDown:"record,rowNum,colNum",recordMouseDown:"recordNum,fieldNum",cellMouseUp:"record,rowNum,colNum",rowMouseUp:"record,rowNum,colNum",recordMouseUp:"recordNum,fieldNum",selectOnMouseDown:"record,rowNum,colNum",selectOnRightMouseDown:"record,rowNum,colNum",selectOnMouseUp:"record,rowNum,colNum",cellClick:"record,rowNum,colNum",cellDoubleClick:"record,rowNum,colNum",rowClick:"record,rowNum,colNum",rowDoubleClick:"record,rowNum,colNum",cellHover:"record,rowNum,colNum",rowHover:"record,rowNum,colNum",cellHoverHTML:"record,rowNum,colNum",selectionChanged:"record,state",cellSelectionChanged:"cellList",getRowElementId:"rowNum,physicalRowNum",getCellElementId:"rowNum,physicalRowNum,colNum,physicalColNum",shouldFixRowHeight:"record,rowNum",updateEmbeddedComponentZIndex:"component",updateEmbeddedComponentCoords:"component,record,rowNum,colNum"};isc.GridRenderer.registerStringMethods(isc.GridRenderer.$294);isc.ClassFactory.defineClass("ListGrid","Canvas");isc.addGlobal("ListViewer",isc.ListGrid);isc.defineClass("GridBody",isc.GridRenderer);isc.A=isc.GridBody.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.adjustOverflowWhileDirty=false;isc.A.expandEmptyMessageToMatchFields=true;isc.B.push(isc.A.adjustOverflow=function(_1,_2,_3,_4,_5){var _6=this.grid;if(_6&&_6.data&&_6.data.getLength()>0&&Array.isLoading(_6.data.get(0)))
{return this.invokeSuper(isc.GridBody,"adjustOverflow",_1,_2,_3,_4,_5)}
var _7=(this.autoFitData=="both"),_8=_7;if(!_7)_7=(this.autoFitData=="vertical");if(!_8)_8=(this.autoFitData=="horizontal");if(_8||_7){if(!this.$1g)this.$1g=this.getHeight();if(!this.$1i)this.$1i=this.getWidth();var _9,_10,_11,_12,_13,_14;if(_7){_9=this.$1g;var _15=this.getTotalRows(),_16=_15;if(this.autoFitMaxRecords)_16=Math.min(_16,this.autoFitMaxRecords);if(_16>0){var _17=0,_18=this.$26b();var _19=this.$252,_20=this.$253;if(this.$252==null){_19=_16;_20=_16}
if(_19>0){_19=Math.min(_19,_16);for(var i=0;i<_19;i++){_17+=this.getRowHeight?this.getRowHeight(i):this.celHeight}}
if(_20<_16-1){for(var i=_20+1;i<_16;i++){_17+=this.getRowHeight?this.getRowHeight(i):this.celHeight}}
_20=Math.min(_20,_16-1);for(var i=_19;i<=_20;i++){_17+=_18[i]}
_12=_15>_16;var _22=this.getAutoFitMaxHeight();if(_22&&_17>_22){_17=_22
_12=true}
if(_17>_9)_9=_17;else{var _23=this.getScrollHeight();_12=(_23>=_9)}}}else{_12=this.getScrollHeight()>(this.$1g||this.getHeight())}
if(_8){var _24=this.getColumnSizes();var _25=_24.sum();if(this.autoFitMaxColumns&&this.autoFitMaxColumns<_24.length){_24=_24.slice(0,this.autoFitMaxColumns)}
var _26=_24.sum();if(this.autoFitMaxWidth)_26=Math.min(this.autoFitMaxWidth,_26);_10=Math.max(this.$1i,_26);_11=_25>_10}else{_11=this.getScrollWidth()>(this.$1i||this.getWidth())}
if(_9!=null&&_9!=this.$1g){_9+=this.getVBorderPad()+this.getVMarginSize();if(_11){_9+=this.getScrollbarSize();var _22=this.getAutoFitMaxHeight()
if(_22&&_9>_22){_9=_22}}}
if(_10!=null&&_10!=this.$1i){_10+=this.getHBorderPad()+this.getHMarginSize();if(_12||this.alwaysShowVScrollbar){_10+=this.getScrollbarSize();if(this.autoFitMaxWidth&&_10>this.autoFitMaxWidth){_10=this.autoFitMaxWidth}}}
_14=this.getDelta(this.$o5,_9,this.getHeight());_13=this.getDelta(this.$o6,_10,this.getWidth());if(_14!=null||_13!=null)this.resizeBy(_13,_14,null,null,true);if(_10!=null){var _27=this.parentElement,_28=_27.header;if(_28&&_28.isDrawn()){_28.setWidth(_10-(_12?_27.getScrollbarSize():0))}
if(_27.sorter&&_27.$313()&&!_27.isRTL()){_27.sorter.setLeft(_10-_27.getScrollbarSize());if(!_27.sorter.isVisible())_27.sorter.show()}else if(_27.sorter){_27.sorter.setLeft(0-_27.sorter.getWidth())}}}
if((!_7&&this.$1g&&(this.getHeight()!=this.$1g))||(!_8&&this.$1i&&(this.getWidth()!=this.$1i)))
{this.resizeTo(this.$58n,this.$1i);this.parentElement.$45m("autoFitData mode changed")}
return this.invokeSuper(isc.GridBody,"adjustOverflow",_1,_2,_3,_4,_5)}
,isc.A.getAutoFitMaxHeight=function(){return this.parentElement?this.parentElement.getAutoFitMaxBodyHeight():null}
,isc.A.resizeBy=function(_1,_2,_3,_4,_5){if(!_5){this.$1g=this.getHeight()+(_2!=null?_2:0);this.$1i=this.getWidth()+(_1!=null?_1:0)}
return this.invokeSuper(isc.GridBody,"resizeBy",_1,_2,_3,_4,_5)}
,isc.A.cellContextClick=function(_1,_2,_3){return this.grid.$298(_1,_2,_3)}
,isc.A.getInnerHTML=function(){if(this==this.grid.body)this.grid.bodyDrawing(this);return this.Super("getInnerHTML",arguments)}
,isc.A.getCellVAlign=function(_1,_2,_3,_4){if(this.grid&&this.grid.getCellVAlign){var _5=this.grid.getFieldNumFromLocal(_4,this);return this.grid.getCellVAlign(_1,_3,_5)}}
,isc.A.getCellAlign=function(_1,_2,_3,_4){if(this.grid&&this.grid.getCellAlign!=null){var _5=this.grid.getFieldNumFromLocal(_4,this);return this.grid.getCellAlign(_1,_3,_5)}else return _2.cellAlign||_2.align}
,isc.A.$282=function(_1,_2,_3){var _4=this.grid;if(_4.showNewRecordRow&&_4.$299(_1))return true;return isc.GridRenderer.$b4.$282.call(this,_1,_2,_3)}
,isc.A.scrollTo=function(_1,_2,_3,_4){if(isc.$cv)arguments.$cw=this;if(_1!=null){var _5=this.getScrollWidth()-this.getViewportWidth();_1=Math.max(0,Math.min(_5,_1))}
if(_2!=null){var _6=this.getScrollHeight()-this.getViewportHeight();_2=Math.max(0,Math.min(_6,_2))}
var _7=this.grid;if(!_4)_7.bodyScrolled(_1,_2,this);this.invokeSuper(null,"scrollTo",_1,_2,_3,_4);if(!this.isDirty()&&_7.$30a){_7.$286.itemsMoved()}}
,isc.A.redraw=function(_1,_2,_3,_4){this.$58p=true;var _5=this.grid,_6=_5.$286,_7=_5.$30a,_8,_9,_10,_11,_12;if(!_5.leaveScrollbarGap&&_5.predictScrollbarGap&&(this.overflow==isc.Canvas.AUTO)){var _13=this.vscrollOn,_14=!_5.isEmpty()&&(_5.getTotalRows()*_5.cellHeight)>this.getInnerHeight();if(_13!=_14){_5.$45m("body redrawing with changed vertical scroll-state")}}
if(_7){this.logInfo("redraw with editors showing, editForm.hasFocus: "+_6.hasFocus,"gridEdit");_8=_5.getEditCol();this.$516();_12=this.$517()}
this.invokeSuper(null,"redraw",_1,_2,_3,_4);delete this.$58p;if(_7){if(_12!=null&&_12.length>0){_6.removeItems(_12)}
_5.$30b(null,true,this);_5.updateEditRow(_5.getEditRow());if(_6.hasFocus||(this.$519&&isc.EH.getFocusCanvas()==null))
{this.$518(_8)}else{delete this.$519}}else if(_6!=null){_5.$30b(null,null,this)}}
,isc.A.$517=function(){var _1=this.grid,_2=_1.getEditForm(),_3=[],_4=_2.getItems();if(!_1.editByCell){var _5=_1.getEditRow(),_6=_1.getRecord(_5),_7=_1.getEditFormItemFieldWidths(_6);var _4=_2.getItems(),_8=_4.getProperty(this.fieldIdProperty),_9=_1.getDrawnFields(),_10=_9.getProperty(this.fieldIdProperty);var _11=_4.length==_9.length,_12=false;for(var i=0;i<_4.length;i++){var _14=_10.indexOf(_8[i]);if(_14==-1){_12=true;_3.add(_4[i])}else{_4[i].width=_7[_4[i].colNum];_4[i].redrawing()}}
if(!_11||_12){var _15=_1.getEditedRecord(_5,0);for(var i=0;i<_9.length;i++){if(!_8.contains(_10[i])){var _16=_1.fields.indexOf(_9[i]);var _17=_1.getEditItem(_9[i],_6,_15,_5,_16,_7[_16]);_2.addItem(_17)}}}}
return _3}
,isc.A.$516=function(){var _1=this.grid,_2=_1.getEditForm(),_3=_1.getEditCol();if(_2.hasFocus){var _4=_2.getFocusItem();if(_4){_4.updateValue();while(_4.parentItem!=null){_4=_4.parentItem}
if(!_1.canEditCell(_4.rowNum,_4.colNum)||_3!=_4.colNum){_2.blur()}else{_4.rememberSelection();this.$519=[_4.$17r,_4.$17s];_2.$106()}}}
_2.$10u=true}
,isc.A.$518=function(_1){var _2=this.grid,_3=_2.getEditForm(),_4=_3.getItem(_2.getEditorName(_2.getEditRow(),_1));if(_4!=null&&_4.isDrawn()){var _5=_2.body.getScrollLeft(),_6=_2.body.getScrollTop(),_7=_2.body.getViewportWidth(),_8=_2.body.getViewportHeight(),_9=_4.getRect(),_10=_9[0]<_5||_9[1]<_6||_9[0]+_9[2]>(_5+_7)||_9[1]+_9[3]>(_6+_8);if(!_10){_3.$11b(_4);if(this.$519[0]!=null){_4.setSelectionRange(this.$519[0],this.$519[1])}
delete this.$519}}}
,isc.A.isDirty=function(_1,_2,_3){return this.invokeSuper(null,"isDirty",_1,_2,_3)||this.grid.isDirty()}
,isc.A.shouldShowRollOver=function(_1,_2,_3,_4){if(!this.grid.showRollOver||this.$28j)return false;var _5=this.grid;if(_5.$30a&&!_5.editByCell&&_1==_5.$285)return false;if(this.$29a&&this.$29a.length>0){var _6=this.getCellRecord(_1,_2),_7=_6?_6.$29a:null;if(_7){for(var i=0;i<_7.length;i++){if(_7[i].embeddedPosition!="within")return false}}}
return true}
,isc.A.updateRollOver=function(_1,_2,_3){var _4=this.grid;if(_4.showRollOverCanvas){if(!_3){var _5=!(this.lastOverRow==_1&&this.lastOverCol==_2);_4.updateRollOverCanvas(_1,_2,_5)}}
this.setRowStyle(_1,null,(this.useCellRollOvers?_2:null));var _6=(this==_4.body?_4.frozenBody:_4.body);if(_6){_6.lastOverRow=this.lastOverRow;_6.lastOverCol=this.lastOverCol;_6.setRowStyle(_1,null,(this.useCellRollOvers?_2:null))}}
,isc.A.selectOnMouseDown=function(_1,_2,_3){var _4=this.isRTL()?this.grid.fields.length-1:0,_5=this.grid.selectionAppearance;if(_5!="checkbox"||(_5=="checkbox"&&_4==_3)){this.invokeSuper(isc.GridBody,"selectOnMouseDown",_1,_2,_3)}}
,isc.A.selectOnMouseUp=function(_1,_2,_3){var _4=this.isRTL()?this.grid.fields.length-1:0,_5=this.grid.selectionAppearance;if(_5!="checkbox"||(_5=="checkbox"&&_4==_3)){this.invokeSuper(isc.GridBody,"selectOnMouseUp",_1,_2,_3)}}
,isc.A.$29h=function(_1,_2,_3,_4,_5,_6,_7,_8){this.invokeSuper(isc.GridBody,"$29h",_1,_2,_3,_5,_6,_7,_8);var _9=this.grid;if(_9&&_9.getEditRow()==_2){var _10=_9.getFieldName(_9.getFieldNumFromLocal(_3,this)),_11=_9.getEditForm(),_12=_11?_11.getItem(_10):null;if(_12&&_12.gridCellStyleChanged){if(_5==null)_5=this.getCellStyle(_1,_2,_3);_12.gridCellStyleChanged(_1,_2,_3,_5)}}}
,isc.A.getHoverTarget=function(){return this.grid}
,isc.A.keyPress=function(_1,_2){return this.grid.bodyKeyPress(_1,_2)}
,isc.A.$lf=function(_1){var _2=this.Super("$lf",arguments);if(_1&&this.grid.isEditable()){var _3=this.grid,_4=isc.EH.lastEvent;if(_3.editOnFocus&&_3.isEditable()&&_3.getEditRow()==null&&!(_4.target==this&&(_4.eventType==isc.EH.MOUSE_DOWN||_4.eventType==isc.EH.MOUSE_UP||_4.eventType==isc.EH.CLICK||_4.eventType==isc.EH.DOUBLE_CLICK)))
{if(_3.$30c){delete _3.$30c}else{var _5=_3.findNextEditCell(0,0,true,true);if(_5!=null)
_3.handleEditCellEvent(_5[0],_5[1],isc.ListGrid.FOCUS)}}}
return _2}
,isc.A.updateRowSelection=function(_1){var _2=this.parentElement;if(_2&&!isc.isA.ListGrid(_2))_2=_2.parentElement;if(_2&&_2.showSelectionCanvas)_2.updateSelectionCanvas();this.invokeSuper(isc.GridBody,"updateRowSelection",_1);if(_2&&_2.selectionAppearance=="checkbox"){var _3=this.isRTL()?this.fields.length-1:0;this.refreshCell(_1,_3);var _4=(isc.isAn.Array(_2.data)||(isc.isA.ResultSet(_2.data)&&_2.data.allMatchingRowsCached()));if(_4&&_2.getSelection.length==_2.data.getLength()){_2.$63m(true)}else if(_4){_2.$63m(false)}}}
,isc.A.$29s=function(_1,_2,_3,_4){var _5=this.parentElement;if(_5&&_5.showSelectionCanvas)_5.updateSelectionCanvas();return this.invokeSuper(isc.GridBody,"$29s",_1,_2,_3,_4)}
,isc.A.shouldAnimateEmbeddedComponent=function(_1){var _2=this.grid;if(_1==_2.selectionCanvas)return _2.animateSelection;if(_1==_2.selectionUnderCanvas)return _2.animateSelectionUnder;if(_1==_2.rollOverCanvas)return _2.animateRollOver;if(_1==_2.rollUnderCanvas)return _2.animateRollUnder;return false}
,isc.A.draw=function(_1,_2,_3,_4){var _5=this.grid;if(_5.getEditRow()!=null){var _6=_5.getEditRow(),_7=_5.getRecord(_6),_8=_5.getEditCol(),_9=_5.$286,_10=_5.getEditRowItems(_7,_6,_8,_5.editByCell);_9.setItems(_10);_9.$10u=true}
this.invokeSuper(null,"draw",_1,_2,_3,_4);if(_5.$286)_5.$30b(null,null,this);_5.updateEditRow(_5.getEditRow());if(_5.$30d!=null){_5.scrollCellIntoView(_5.$30d);delete _5.$30d}}
,isc.A.layoutChildren=function(_1,_2,_3,_4){this.invokeSuper(null,"layoutChildren",_1,_2,_3,_4);if(!this.isDrawn()||(this.grid.frozenFields&&!this.grid.bodyLayout.isDrawn())){return}
if(_1=="scrolling state changed"){if(this.$28i==null){this.grid.layoutChildren("body scroll changed");delete this.$30e}else{this.$30e=true}}}
,isc.A.$28p=function(){this.Super("$28p",arguments);if(this.$30e){this.grid.layoutChildren("body scroll changed during animation");delete this.$30e}}
,isc.A.moved=function(_1,_2,_3,_4){this.invokeSuper(null,"moved",_1,_2,_3,_4);var _5=this.grid;if(_5.$30a){_5.$286.itemsMoved()}}
,isc.A.parentMoved=function(_1,_2,_3,_4){this.invokeSuper(null,"parentMoved",_1,_2,_3,_4);var _5=this.grid;if(_5.$30a){_5.$286.itemsMoved()}}
,isc.A.setVisibility=function(_1,_2,_3,_4){this.invokeSuper(null,"setVisibility",_1,_2,_3,_4);var _5=this.grid;if(_5.$30a)_5.$286.itemsVisibilityChanged()}
,isc.A.parentVisibilityChanged=function(_1,_2,_3,_4){this.invokeSuper(null,"parentVisibilityChanged",_1,_2,_3,_4);var _5=this.grid;if(_5.$30a)_5.$286.itemsVisibilityChanged()}
,isc.A.clear=function(){this.Super("clear",arguments);var _1=this.grid;if(_1.$30a){_1.$30b(null,null,this);_1.$286.itemsVisibilityChanged()}}
,isc.A.$vy=function(_1){return this.grid.$vy(_1)}
,isc.A.$vv=function(){}
,isc.A.zIndexChanged=function(){this.Super("zIndexChanged",arguments);var _1=this.grid;if(_1&&_1.$30a)_1.$286.itemsZIndexChanged()}
,isc.A.parentZIndexChanged=function(_1,_2,_3,_4){this.invokeSuper(null,"zIndexChanged",_1,_2,_3,_4);var _5=this.grid;if(_5.$30a)_5.$286.itemsZIndexChanged()}
,isc.A.redrawFormItem=function(_1,_2){var _3=this.grid;if(_3&&(_1.form==_3.$286)){var _4=_3.getEditRow(),_5=_3.getColNum(_1.getFieldName());_3.refreshCell(_4,_5,false,true)}else
return this.markForRedraw("Form Item Redraw "+(_2?_2:isc.emptyString))}
,isc.A.startRowAnimation=function(_1,_2,_3,_4,_5,_6,_7,_8,_9){var _10=(_9&&(this.$34y!=null)),_11=this.grid;if(_10){_11.$34v=true;_11.data.openFolder(this.$34y);_11.$34v=null}
this.Super("startRowAnimation",arguments);if(_10){_11.$34v=true;_11.data.closeFolder(this.$34y);_11.$34v=null}
delete this.$34y}
);isc.B._maxIndex=isc.C+39;isc.A=isc.ListGrid;isc.A.CORNER="corner";isc.A.FIELD="field";isc.A.COPY="copy";isc.A.MOVE="move";isc.A.CLONE="clone";isc.A.AFTER="after";isc.A.BEFORE="before";isc.A.OVER="over";isc.A.CLICK_OUTSIDE="click_outside";isc.A.CLICK="click";isc.A.DOUBLE_CLICK="doubleClick";isc.A.ENTER_KEYPRESS="enter";isc.A.ESCAPE_KEYPRESS="escape";isc.A.UP_ARROW_KEYPRESS="arrow_up";isc.A.DOWN_ARROW_KEYPRESS="arrow_down";isc.A.LEFT_ARROW_KEYPRESS="arrow_left";isc.A.RIGHT_ARROW_KEYPRESS="arrow_right";isc.A.TAB_KEYPRESS="tab";isc.A.SHIFT_TAB_KEYPRESS="shift_tab";isc.A.EDIT_FIELD_CHANGE="field_change";isc.A.EDIT_ROW_CHANGE="row_change";isc.A.PROGRAMMATIC="programmatic";isc.A.FOCUS="focus";isc.A.$295=["selection","selectionType","canSelectCells","canDragSelect","canSelectOnRightMouse","canDrag","canAcceptDrop","canDrop","autoFit","wrapCells","cellSpacing","cellPadding","cellHeight","enforceVClipping","autoFitData","autoFitMaxRecords","autoFitMaxWidth","autoFitMaxColumns","autoFitMaxHeight","showAllColumns","drawAllMaxCells","drawAheadRatio","quickDrawAheadRatio","scrollRedrawDelay","animateRowsMaxTime","fastCellUpdates","showRollOver","useCellRollOvers","canHover","showHover","hoverDelay","hoverWidth","hoverHeight","hoverAlign","hoverVAlign","hoverStyle","hoverOpacity","hoverMoveWithMouse","hoverByCell","keepHoverActive","cellHoverOutset","showEmptyMessage","emptyMessageStyle","emptyMessageTableStyle","singleCellValueProperty","isSeparatorProperty","accessKey","canFocus","_useNativeTabIndex","tableStyle","baseStyle","recordCustomStyleProperty","showFocusOutline"];isc.A.$296=["getCellStyleName","getCellStyleIndex","getRowTop","getRowPageTop","getRowSize","getCellPageRect","getVisibleRows","getDrawnRows","addEmbeddedComponent","removeEmbeddedComponent"];isc.A.$297=["getTotalRows","isEmpty","cellIsEnabled","willAcceptDrop","scrolled","getTableElementId","getRowElementId","getCellElementId","shouldFixRowHeight","getEmptyMessage","getCanHover","stopHover","updateEmbeddedComponentZIndex"];isc.A=isc.ListGrid;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.makeBodyMethods=function(_1){var _2=this.$cf;if(_2==null){_2=this.$cf=[,"return this.grid.",,"(",,")"]}
var _3={};for(var i=0;i<_1.length;i++){var _5=_1[i],_6=isc.GridRenderer.getArgString(_5);if(isc.contains(_6,"colNum")){_2[0]="if (this.fields[colNum]) colNum = this.fields[colNum].masterIndex;"}else if(isc.isAn.emptyString(_6)){_6="body";_2[0]="body = this;"}else{_2[0]=null}
_2[2]=_5;_2[4]=_6;var _7=_2.join(isc.emptyString);_3[_5]=new Function(_6,_7)}
return _3}
,isc.A.classInit=function(){this.addMethods(isc.ClassFactory.makePassthroughMethods(this.$296,"body"));var _1={};var _2=isc.getKeys(isc.GridRenderer.$294),_1=isc.ListGrid.makeBodyMethods(_2);isc.addProperties(_1,isc.ListGrid.makeBodyMethods(this.$297));this.$30f=_1;var _3={},_4=["if(this.body.__orig_",,")return this.body.__orig_",,"(",,")"],_5="__orig_",_6=isc.GridRenderer.getPrototype();for(var i=0;i<_2.length;i++){var _8=_2[i],_9=isc.GridRenderer.getArgString(_8);if(isc.ListGrid.getInstanceProperty(_8)==null){_4[1]=_4[3]=_8;_4[5]=_9
_3[_8]=new Function(_9,_4.join(isc.emptyString))}
_6[_5+_8]=_6[_8]}
this.$30g=_3;this.addMethods(_3)}
);isc.B._maxIndex=isc.C+2;isc.A=isc.ListGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.styleName="listGrid";isc.A.useCellRecords=false;isc.A.animateFolders=true;isc.A.animateFolderTime=100;isc.A.animateFolderSpeed=1000;isc.A.animateRowsMaxTime=1000;isc.A.autoFetchDisplayMap=true;isc.A.showDetailFields=true;isc.A.groupStartOpen="first";isc.A.groupNodeStyle="groupNode";isc.A.groupIcon="[SKINIMG]/TreeGrid/opener.gif";isc.A.groupIconSize=16;isc.A.groupIndentSize=20;isc.A.groupLeadingIndent=10;isc.A.canGroupBy=true;isc.A.groupByMaxRecords=1000;isc.A.nullGroupTitle="-none-";isc.A.valueIconSize=16;isc.A.valueIconLeftPadding=2;isc.A.valueIconRightPadding=2;isc.A.imageSize=16;isc.A.headerSpanVAlign="center";isc.A.showTreeColumnPicker=true;isc.A.fetchDelay=300;isc.A.uniqueMatch=true;isc.A.overflow=isc.Canvas.HIDDEN;isc.A.backgroundColor="white";isc.A.minHeight=50;isc.A.defaultWidth=200;isc.A.drawAllMaxCells=250;isc.A.drawAheadRatio=1.3;isc.A.quickDrawAheadRatio=1.0;isc.A.scrollRedrawDelay=75;isc.A.dataFetchDelay=300;isc.A.bodyConstructor="GridBody";isc.A.bodyOverflow=isc.Canvas.AUTO;isc.A.bodyBackgroundColor="white";isc.A.allowMismatchedHeaderBodyBorder=true;isc.A.emptyCellValue="&nbsp;";isc.A.cellHeight=20;isc.A.fixedRecordHeights=true;isc.A.fixedFieldWidths=true;isc.A.autoFitMaxRecords=50;isc.A.autoFitMaxColumns=50;isc.A.leaveScrollbarGap=true;isc.A.resizeFieldsForScrollbar=true;isc.A.cellSpacing=0;isc.A.cellPadding=2;isc.A.timeFormatter="toShortPaddedTime";isc.A.$30h=["<a href='",,"' target='",,"' onclick='if(window.",,") return ",,".$30i(event,",,",",,");'>",,"</a>"];isc.A.$30j="\\'";isc.A.$30k="_blank";isc.A.linkTextProperty="linkText";isc.A.baseStyle="cell";isc.A.editFailedBaseStyle=null;isc.A.editFailedCSSText="color:red;border:1px solid red;";isc.A.editPendingBaseStyle=null;isc.A.editPendingCSSText="color:#0066CC;";isc.A.recordCustomStyleProperty="customStyle";isc.A.recordBaseStyleProperty="_baseStyle";isc.A.shrinkForFreeze=false;isc.A.alternateRecordFrequency=1;isc.A.recordCSSTextProperty="cssText";isc.A.generateClickOnSpace=true;isc.A.generateDoubleClickOnEnter=true;isc.A.arrowKeyAction="select";isc.A.showRollOver=true;isc.A.showHover=true;isc.A.cellHoverOutset=5;isc.A.hoverStyle="gridHover";isc.A.selectionAppearance="rowStyle";isc.A.showEmptyMessage=true;isc.A.emptyMessage="No items to show.";isc.A.emptyMessageStyle="emptyMessage";isc.A.loadingDataMessage="Loading data...";isc.A.offlineDataMessage="Data is offline...";isc.A.loadingDataMessageStyle="loadingDataMessage";isc.A.loadingMessage="&nbsp;";isc.A.offlineMessage="Record offline...";isc.A.singleCellValueProperty="singleCellValue";isc.A.isSeparatorProperty="isSeparator";isc.A.filterEditorDefaults={shouldPrint:false};isc.A.filterEditorHeight=22;isc.A.recordEditProperty="_canEdit";isc.A.editValuesTestedProperty="$30l";isc.A.autoValidate=true;isc.A.removeIcon="[SKIN]/actions/remove.png";isc.A.animateRemoveRecord=true;isc.A.animateRemoveTime=100;isc.A.animateRemoveSpeed=200;isc.A.removeSummaryTitle="[Remove Record]";isc.A.removeFieldDefaults={type:"icon",width:20,showHeaderContextMenuButton:false,canEdit:false,canSort:false,canGroupBy:false,canFilter:false,recordClick:function(_1,_2,_3){_1.$609(_3,_2);return false}};isc.A.autoSaveEdits=true;isc.A.showErrorIcons=true;isc.A.errorIconHeight=16;isc.A.errorIconWidth=16;isc.A.errorIconSrc="[SKIN]/validation_error_icon.png";isc.A.cancelEditingConfirmationMessage="Cancelling this edit will clear unsaved edit values for this record. Continue?";isc.A.confirmDiscardEdits=true;isc.A.confirmDiscardEditsMessage="This action will discard all unsaved edited values for this list.";isc.A.discardEditsSaveButtonTitle="Save";isc.A.rowEndEditAction="next";isc.A.listEndEditAction="stop";isc.A.newRecordRowMessage="-- Add New Row --";isc.A.enterKeyEditAction="done";isc.A.escapeKeyEditAction="cancel";isc.A.editEvent=isc.EH.DOUBLE_CLICK;isc.A.selectOnEdit=true;isc.A.enumCriteriaAsInitialValues=true;isc.A.autoSelectEditors=true;isc.A.editFormDefaults={canSelectText:true,autoDraw:false,errorOrientation:"left",showErrorText:false,showErrorStyle:false,itemKeyPress:function(_1,_2,_3){return this.grid.editorKeyPress(_1,_2,_3)}};isc.A.longTextEditorThreshold=255;isc.A.longTextEditorType="PopUpTextAreaItem";isc.A.headerHeight=22;isc.A.showHeader=true;isc.A.headerBackgroundColor="#CCCCCC";isc.A.headerDefaults={instantRelayout:true,enforcePolicy:false,itemClick:function(_1,_2){this.Super("itemClick",arguments);this.grid.headerClick(_2,this)},showContextMenu:function(){return this.grid.headerBarContextClick(this)},backgroundRepeat:isc.Canvas.NO_REPEAT,shouldPrint:false};isc.A.headerButtonDefaults={dragScrollType:"parentsOnly",minWidth:20};isc.A.sorterConstructor=isc.Button;isc.A.sorterDefaults={$nu:false,getTitle:function(){return this.parentElement.getSortArrowImage()},click:function(){return this.parentElement.sorterClick()},showContextMenu:function(){return this.parentElement.sorterContextClick()},canFocus:false};isc.A.canSort=true;isc.A.sortDirection=Array.ASCENDING;isc.A.canPickFields=true;isc.A.openRecordEditorContextMenuItemTitle="Edit";isc.A.dismissEmbeddedComponentContextMenuItemTitle="Dismiss";isc.A.deleteRecordContextMenuItemTitle="Delete";isc.A.canOpenRecordDetailGrid=true;isc.A.canOpenRecordEditor=true;isc.A.recordEditorSaveButtonTitle="Save";isc.A.recordEditorCancelButtonTitle="Cancel";isc.A.headerMenuButtonIcon="[SKIN]/ListGrid/headerMenuButton_icon.gif";isc.A.headerMenuButtonIconWidth=7;isc.A.headerMenuButtonIconHeight=7;isc.A.headerMenuButtonWidth=16;isc.A.headerMenuButtonHeight="100%";isc.A.canDragRecordsOut=false;isc.A.canReorderFields=true;isc.A.canResizeFields=true;isc.A.dragAppearance=isc.EH.TRACKER;isc.A.dragTrackerMode="title";isc.A.resizeFieldsInRealTime=(isc.Browser.isIE&&isc.Browser.isWin)||(isc.Browser.isFirefox&&isc.Browser.geckoVersion>=20080529);isc.A.dragDataAction=isc.ListGrid.MOVE;isc.A.embeddedComponentIndent=25;isc.A.nestedGridDefaults={height:150};isc.A.skinImgDir="images/ListGrid/";isc.A.sortAscendingImage={src:"[SKIN]sort_ascending.gif",width:7,height:7};isc.A.sortDescendingImage={src:"[SKIN]sort_descending.gif",width:7,height:7};isc.A.trackerImage={src:"[SKIN]tracker.gif",width:16,height:16};isc.A.booleanTrueImage=null;isc.A.booleanFalseImage=null;isc.A.booleanImageWidth=16;isc.A.booleanImageHeight=16;isc.A.mozBodyOutlineColor="white";isc.A.mozBodyNoHeaderOutlineColor="red";isc.B.push(isc.A.$30m=function(_1,_2,_3,_4,_5,_6){if(isc.isA.Date(_1)){var _7=_3.$45i(_2);if(_7!=null){if(isc.isA.Function(_1[_7]))return _1[_7]();if(isc.isA.Function(_7))return _7.apply(_1);_3.logWarn("Specified dateFormatter '"+_7+"' is not a valid date formatter name.  "+"Displaying date in shortDate format.")}
return _1.toShortDate()}
return _1}
,isc.A.$45i=function(_1){var _2;if(_1)_2=(_1.displayFormat||_1.dateFormatter||_1.formatter);if(!_2)_2=this.dateFormatter;return _2}
,isc.A.$45j=function(_1){var _2;if(_1)_2=_1.inputFormat
if(!_2)_2=this.dateInputFormat;return _2}
,isc.A.$30n=function(_1,_2,_3,_4,_5,_6){if(isc.isA.Number(_1)){var _7=(_2.numberFormatter||_2.formatter||_3.numberFormatter);return _1.toFormattedString(_7)}
return _1}
,isc.A.$30o=function(_1){var _2;if(_1)_2=(_1.displayFormat||_1.timeFormatter||_1.formatter);if(!_2)_2=this.timeFormatter;return _2}
,isc.A.$30p=function(_1,_2,_3,_4,_5,_6){var _7=_1;if(isc.isA.String(_7)){_7=isc.Time.parseInput(_7)}
if(_7!=null){var _8=_3.$30o(_2);return isc.Time.toTime(_7,_8)}
return _1}
,isc.A.$30q=function(_1,_2,_3,_4,_5,_6){if(isc.isA.String(_1))return _1;var _7=_4[_2.name+"_filename"];var _8=isc.Canvas.imgHTML("[SKIN]actions/view.png",16,16,null,"style='cursor:"+isc.Canvas.HAND+"' onclick='"+_3.getID()+".viewRow("+_5+")'");var _9=isc.Canvas.imgHTML("[SKIN]actions/download.png",16,16,null,"style='cursor:"+isc.Canvas.HAND+"' onclick='"+_3.getID()+".downloadRow("+_5+")'");return _8+"&nbsp;"+_9+"&nbsp;"+_7}
,isc.A.$30r=function(_1,_2,_3,_4,_5,_6){if(_1==null||isc.is.emptyString(_1))return _1;var _7=_2.target?_2.target.replaceAll(_3.$ob,_3.$30j):_3.$30k;var _8=(_4&&_4[this.linkTextProperty])?_4[this.linkTextProperty]:_2[this.linkTextProperty]||_1;var _9=_1;if(_2.linkURLPrefix)_9=_2.linkURLPrefix+_9;if(_2.linkURLSuffix)_9=_9+_2.linkURLSuffix;_9=_9.replaceAll(_3.$ob,_3.$30j);var _10=_3.$30h;_10[1]=_9;_10[3]=_7;var _11=_3.getID();_10[5]=_11;_10[7]=_11;_10[9]=_5;_10[11]=_6;_10[13]=_8;return _10.join(isc.emptyString)}
,isc.A.$30i=function(_1,_2,_3){var _4=(this.destroyed||!this.isDrawn()||!this.isVisible()||isc.EH.targetIsMasked(this.body)||!this.recordIsEnabled(_2,_3));if(_4){if(!isc.Browser.isIE){_1.preventDefault()}
return false}}
,isc.A.$30s=function(_1,_2,_3,_4,_5,_6){if(_1==null||_1==isc.emptyString)return isc.emptyString;var _7,_8;var _9,_10,_11;if(isc.isA.String(_2.imageWidth)){_9=_2.imageWidth}else{_7=_2.imageWidth}
if(isc.isA.String(_2.imageHeight)){_10=_2.imageHeight}else{_8=_2.imageHeight}
if(isc.isA.String(_2.imageSize)){_11=_2.imageSize}else{_7=_7||_2.imageSize;_8=_8||_2.imageSize}
if(_4!=null){_7=_7||_4[_9]||_4[_11];_8=_8||_4[_10]||_4[_11]}
_7=_7||_3.imageSize;_8=_8||_3.imageSize;var _12=_1,_13=_2.imageURLPrefix||_2.baseURL||_2.imgDir;if(_2.imageURLSuffix!=null)_12+=_2.imageURLSuffix;return isc.Canvas.imgHTML(_12,_7,_8,null,_2.extraStuff,_13,_2.activeAreaHTML)}
,isc.A.$59e=function(_1,_2,_3,_4,_5,_6){if(_2.$59f)return _2.$59f;_2.$59f=isc.Canvas.imgHTML(_2.cellIcon||_2.icon,_2.iconWidth||_2.iconSize,_2.iconHeight||_2.iconSize);return _2.$59f}
,isc.A.editorKeyDown=function(_1,_2){if(isc.Browser.isSafari&&isc.Browser.safariVersion>=525.13&&_2=="Tab"){return false}}
,isc.A.editorKeyPress=function(_1,_2,_3){var _4=isc.EH,_5,_6;if(_2=="Tab"){var _7=_4.shiftKeyDown();if(this.ns.isA.ContainerItem(_1)||(_1.icons!=null&&_1.icons.length>0&&!this.ns.isA.PopUpTextAreaItem(_1)))
{if(!this.$11s(_1,_7)){return false}}
_6=_7?isc.ListGrid.SHIFT_TAB_KEYPRESS:isc.ListGrid.TAB_KEYPRESS;_5=false}else if(_2=="Enter"){if(_1.getFocusIconIndex()!=null)return;if((isc.isA.PopUpTextAreaItem(_1)||isc.isA.TextAreaItem(_1))&&isc.EH.altKeyDown()==false)
{return _5}
_6=isc.ListGrid.ENTER_KEYPRESS;_5=false}else if(_2=="Escape"){_6=isc.ListGrid.ESCAPE_KEYPRESS;_5=false}else if(_2=="Arrow_Up"){var _8=isc.isA.PopUpTextAreaItem(_1)||isc.isA.TextAreaItem(_1);if(_8&&!isc.EH.altKeyDown())return _5;if(isc.isA.SelectItem(_1)&&!isc.EH.ctrlKeyDown())return _5;if(isc.EH.ctrlKeyDown()&&isc.EH.shiftKeyDown())return _5;_6=isc.ListGrid.UP_ARROW_KEYPRESS;_5=false}else if(_2=="Arrow_Down"){var _8=isc.isA.PopUpTextAreaItem(_1)||isc.isA.TextAreaItem(_1);if(_8&&!isc.EH.altKeyDown())return _5;if(isc.isA.SelectItem(_1)&&!isc.EH.ctrlKeyDown())return _5;if(isc.EH.ctrlKeyDown&&isc.EH.shiftKeyDown())return _5;_6=isc.ListGrid.DOWN_ARROW_KEYPRESS;_5=false}else if(this.moveEditorOnArrow&&this.$51k){if(_2=="Arrow_Left"){_6=isc.ListGrid.LEFT_ARROW_KEYPRESS;_5=false}else if(_2=="Arrow_Right"){_6=isc.ListGrid.RIGHT_ARROW_KEYPRESS;_5=false}}
if(_6!=null){if(isc.EH.clickMaskUp()){isc.EH.setMaskedFocusCanvas(null,isc.EH.clickMaskRegistry.last())}
this.cellEditEnd(_6)}
return _5}
,isc.A.$11s=function(_1,_2){if(!_1)return true;return(!_1.$11s(!_2))}
,isc.A.$30t=function(_1){var _2=this.form,_3=_2.grid;var _4,_5,_6,_7;if(_3.$30a&&!_1){_4=_3.$285;if(!_3.editByCell){_4=_3.$285;_6=this.getFieldName(),_5=_3.fields.findIndex(_3.fieldIdProperty,_6);_7=(_3.$30u!=_5);if(_7){_3.setNewEditCell(_4,_5);_3.cellEditEnd(isc.ListGrid.EDIT_FIELD_CHANGE)}}else{_5=_3.$30u}}
this.Super("elementFocus",arguments);if(_3.$30a){var _8=this.$30v,_9=this.$30w;delete this.$30v;delete this.$30w;if(_9)_3.$30x(this,_4,_5,_3.$30y(_4,_5));if(_8)_3.$30z(this,_4,_3.$300(_4,_5))}else{_3.logWarn("suppressing editorEnter handlers on focus as listGrid.$30a is null")}}
);isc.B._maxIndex=isc.C+15;isc.A=isc.ListGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$g2="boolean";isc.A.$604="set fields";isc.A.checkboxFieldDefaults={name:"$63n",canEdit:false,canGroupBy:false,canSort:false,$63f:true,type:"boolean",showHeaderContextMenuButton:false};isc.A.$63g=15;isc.A.$301="false;";isc.A.$18r="false";isc.A.$302="<HR>";isc.A.$303=["style='margin-left:",,"px;margin-right:",,"px;'"];isc.A.$g2="boolean";isc.A.$gx="text";isc.A.$54y={" ":true,"\n":true,"\r":true,"\r\n":true};isc.A.$54t="&nbsp;";isc.A.$18r="false";isc.A.$18q="true";isc.A.printAutoFit=true;isc.A.printWrapCells=true;isc.A.printHeaderStyle="printHeader";isc.A.printMaxRows=200;isc.A.$20s="Arrow_Up";isc.A.$20t="Arrow_Down";isc.A.$304="Space";isc.A.$10j="Enter";isc.A.$51g="f2";isc.A.$20w="Escape";isc.A.$51h="Backspace";isc.A.$51i="Delete";isc.A.$51l="keyPress";isc.A.$27r="none";isc.A.$305="focus";isc.A.$12b="select";isc.A.$306="activate";isc.A.$kn=false;isc.A.$18q="true";isc.A.$307={time:true,TimeItem:true};isc.A.$g5="time";isc.A.$308={date:true,dateTime:true,DateItem:true};isc.A.$g4="date";isc.A.$309={popUpTextArea:true,PopUpTextAreaItem:true};isc.A.$31a={checkbox:true,CheckboxItem:true};isc.A.$g2="boolean";isc.A.$12c="checkbox";isc.A.$12i="CycleItem";isc.A.$31b={select:true,SelectItem:true};isc.A.$45k=["change","changed","defaultDynamicValue"];isc.A.$31c=["change","changed","defaultDynamicValue","keyPress","click","showIf","enableIf"];isc.A.$31d={};isc.A.$31e=0;isc.A.$31f="rowNum,colNum,editCompletionEvent,success";isc.A.dragTrackerStyle="gridDragTracker";isc.A.$60m="toggle frozen fields";isc.A.selectionCanvasDefaults={opacity:20};isc.A.selectionUnderCanvasDefaults={};isc.A.rollOverCanvasDefaults={snapTo:"TL",width:"100%",height:"100%"};isc.A.rollUnderCanvasDefaults={snapTo:"TL",width:"100%",height:"100%"};isc.A.$616="header height changed";isc.A.$617="header visibility changed";isc.A.headerMenuButtonDefaults={snapTo:"R",canFocus:false,resizeFrom:"R",title:null,iconSpacing:0,click:function(){this.parentElement.grid.headerMenuButtonClick()},mouseOut:function(){var _1=isc.EH.getTarget();if(!_1||!this.parentElement.contains(_1))this.hide();this.Super("mouseOut",arguments)}};isc.A.predictScrollbarGap=true;isc.A.sortFieldAscendingText="Sort Ascending";isc.A.sortFieldDescendingText="Sort Descending";isc.A.fieldVisibilitySubmenuTitle="Columns";isc.A.freezeFieldText="Freeze ${viewer.getSummaryTitle(field)}";isc.A.unfreezeFieldText="Unfreeze ${viewer.getSummaryTitle(field)}";isc.A.groupByText="Group by ${viewer.getSummaryTitle(field)}";isc.A.ungroupText="Ungroup";isc.A.$31g="sort";isc.A.chartConstructor="FusionChart";isc.A.groupIconPadding=5;isc.A.$31h={canDragSelect:true,canDragRecordsOut:true,canReorderRecords:true,canAcceptDroppedRecords:true};isc.A.$45l={bodyBackgroundColor:"backgroundColor",bodyStyleName:"styleName",fixedRecordHeights:"fixedRowHeights",fixedFieldWidths:"fixedColumnWidths",alternateRecordStyles:"alternateRowStyles",alternateRecordFrequency:"alternateRowFrequency",showAllRecords:"showAllRows"};isc.B.push(isc.A.initWidget=function(){if(this.loadingMessage==null||this.loadingMessage==isc.emptyString)
this.loadingMessage="&nbsp";if(this.autoFitData!=null){this.$58o=this.overflow;this.setOverflow("visible")}
this.setData(this.data?null:this.getDefaultData());if(this.groupByField){var _1;if(isc.isA.Array(this.groupByField))_1=this.groupByField;else _1=[this.groupByField];this.groupByField=null;this.groupBy(_1)}
this.setSelectionAppearance(this.selectionAppearance);this.$31i()}
,isc.A.getDefaultData=function(){return[]}
,isc.A.$31i=function(){this.canDrag=(this.canDrag||this.canDragRecordsOut||this.canReorderRecords||this.canDragSelect);this.canDrop=(this.canDrop||this.canDragRecordsOut||this.canReorderRecords);this.canAcceptDrop=(this.canAcceptDrop||this.canAcceptDroppedRecords||this.canReorderRecords)}
,isc.A.getEmptyMessage=function(){if(isc.ResultSet&&isc.isA.ResultSet(this.data)&&!this.data.lengthIsKnown()){if(isc.isOffline()){return this.offlineDataMessage}else{return this.loadingDataMessage}}
return this.emptyMessage}
,isc.A.isEmpty=function(){if(!this.data)return true;if(!this.fields||this.fields.length==0)return true;if(isc.ResultSet&&isc.isA.ResultSet(this.data)){if(this.data.isPaged()){if(!this.data.isEmpty())return false;var _1=this.getAllEditRows();if(_1&&_1.length>0){for(var i=0;i<_1.length;i++){if(_1[i]>=0)return false}}
return true}else{if(this.data.lengthIsKnown())return this.getTotalRows()<=0;else return true}}else{return(this.getTotalRows()<=0)}}
,isc.A.setData=function(_1){if(this.data==_1)return;if(!this.preserveEditsOnSetData)this.discardAllEdits();this.clearLastHilite();if(this.data){this.$31j(this.data);if(this.data.$31k&&isc.isA.Function(this.data.destroy))
this.data.destroy()}
if(_1)this.data=_1;if(!this.data)return;this.$31m(this.data);this.regroup(true);if(!this.selection||(this.data!=this.selection.data)){this.createSelectionModel()}
if(this.preserveEditsOnSetData)this.$31n();if(this.canSort&&this.$60z()!=null){this.sortData()}
if(isc.ResultSet&&isc.isA.ResultSet(this.data)&&this.body&&this.body.overflow=="visible")
{this.body.showAllRows=false}
this.$25a("setData")}
,isc.A.createSelectionModel=function(){this.invokeSuper(isc.ListGrid,"createSelectionModel",arguments);if(isc.isA.Canvas(this.body)){this.body.setSelection(this.selection);if(this.frozenBody)this.frozenBody.setSelection(this.selection)}}
,isc.A.destroySelectionModel=function(){if(this.body)this.body.clearSelection();if(this.frozenBody)this.frozenBody.clearSelection();return this.Super("destroySelectionModel",arguments)}
,isc.A.setSelectionType=function(_1){this.selectionType=_1;if(this.body)this.body.selectionType=_1}
,isc.A.setSelectionAppearance=function(_1){this.selectionAppearance=_1;var _2=_1=="checkbox"?isc.Selection.SIMPLE:isc.Selection.MULTIPLE;this.setSelectionType(_2)}
,isc.A.setBodyOverflow=function(_1){this.bodyOverflow=_1;if(this.body)this.body.setOverflow(this.bodyOverflow)}
,isc.A.setBodyStyleName=function(_1){this.bodyStyleName=_1;if(this.body&&(!this.alternateBodyStyleName||!this.alternateRecordStyles)){this.body.setStyleName(_1)}}
,isc.A.setAlternateBodyStyleName=function(_1){this.alternateBodyStyleName=_1;if(this.body&&this.alternateRecordStyles){this.body.setStyleName(_1||this.bodyStyleName)}}
,isc.A.setAlternateRecordStyles=function(_1){if(this.alternateRecordStyles==_1)return;this.alternateRecordStyles=_1;if(this.body&&(this.alternateBodyStyleName!=null)){if(_1)this.body.setStyleName(this.alternateBodyStyleName);else this.body.setStyleName(this.bodyStyleName)}}
,isc.A.hasInherentHeight=function(_1,_2,_3,_4){if(this.inherentHeight!=null)return this.inherentHeight;if(this.autoFitData==isc.Canvas.VERTICAL||this.autoFitData==isc.Canvas.BOTH){return true}
return this.invokeSuper(isc.ListGrid,"hasInherentHeight",_1,_2,_3,_4)}
,isc.A.hasInherentWidth=function(_1,_2,_3,_4){if(this.inherentWidth!=null)return this.inherentWidth;if(this.autoFitData==isc.Canvas.HORIZONTAL||this.autoFitData==isc.Canvas.BOTH){return true}
return this.invokeSuper(isc.ListGrid,"hasInherentWidth",_1,_2,_3,_4)}
,isc.A.setAutoFitData=function(_1){this.autoFitData=_1;if(this.$60v&&(_1=="both"||_1=="horizontal"||_1=="vertical")){delete this.$60v;delete this.canFreezeFields}
if(_1==null&&this.$58o){this.setOverflow(this.$58o)}else if(this.overflow!="visible"){this.$58o=this.overflow;this.setOverflow("visible")}
if(this.body){this.body.autoFitData=this.autoFitData;this.body.adjustOverflow()}}
,isc.A.setAutoFitMaxRecords=function(_1){this.autoFitMaxRecords=_1;if(this.body){this.body.autoFitMaxRecords=_1;this.body.adjustOverflow()}}
,isc.A.setAutoFitMaxHeight=function(_1){this.autoFitMaxHeight=_1;if(this.body){this.body.adjustOverflow()}}
,isc.A.getAutoFitMaxBodyHeight=function(){if(this.autoFitMaxHeight==null)return null;var _1=this.getVBorderPad();if(this.showHeader)_1+=this.headerHeight;if(this.showFilterEditor)_1+=this.filterEditorHeight;return this.autoFitMaxHeight-_1}
,isc.A.setAutoFitMaxColumns=function(_1){this.autoFitMaxColumns=_1;if(this.body){this.body.autoFitMaxColumns=_1;this.body.adjustOverflow()}}
,isc.A.setAutoFitMaxWidth=function(_1){this.autoFitMaxWidth=_1;if(this.body){this.body.autoFitMaxWidth=_1;this.body.adjustOverflow()}}
,isc.A.$25a=function(_1){if(this.bodies){this.bodies.map("markForRedraw",_1)}else{this.markForRedraw(_1)}}
,isc.A.redraw=function(_1,_2,_3,_4){if(this.body){if(this.body.$30e){this.$45m("scrollbar change during animation");delete this.body.$30e}}
this.invokeSuper(isc.ListGrid,"redraw",_1,_2,_3,_4)}
,isc.A.$31m=function(_1){this.observe(_1,"dataChanged","observer.dataChanged("+(isc.ResultSet&&isc.isA.ResultSet(_1)?"operationType,originalRecord,rowNum,updateData)":")"));if(isc.isA.Tree(_1)){this.observe(_1,"changeDataVisibility","observer.$34u()")}}
,isc.A.groupTreeChanged=function(){}
,isc.A.$606=function(_1){this.observe(_1,"dataChanged","observer.groupTreeChanged()");this.observe(_1,"changeDataVisibility","observer.$34u()")}
,isc.A.$34u=function(){if(this.$34v){this.$31n();return}
if(this.body)this.body.finishRowAnimation();this.$31n();this.$25a('folderToggled');this.selection.markForRedraw()}
,isc.A.toggleFolder=function(_1){if(this.data.isOpen(_1)){this.closeFolder(_1)}else{this.openFolder(_1);if(this.frozenBody)this.frozenBody.markForRedraw()}}
,isc.A.openFolder=function(_1){if(this.folderOpened!=null){this.convertToMethod("folderOpened");if(this.folderOpened(_1)==false)return false}
if(this.animateFolders){this.animateOpen(_1)}else{this.data.openFolder(_1)}}
,isc.A.animateOpen=function(_1){var _2=this.data;if(_2.isOpen(_1))return;this.$34v=true;_2.openFolder(_1);delete this.$34v;var _3=_2.getParent(_1);if(_3&&!_2.isOpen(_3))return;if(_2.getLoadState(_1)!=isc.Tree.LOADED){this.$34z=_1;return}
this.$340(_1)}
,isc.A.closeFolder=function(_1){if(this.folderClosed!=null){this.convertToMethod("folderClosed");if(this.folderClosed(_1)==false)return false}
var _2=this.selection.getSelection();if(_2){for(var i=0;i<_2.length;i++){if(this.data.isDescendantOf(_2[i],_1))
this.selection.deselect(_2[i])}}
if(this.getEditRow()!=null){var _4=this.getRecord(this.getEditRow());if(this.data.isDescendantOf(_4,_1))this.endEditing()}
if(this.animateFolders)
this.animateClose(_1);else
this.data.closeFolder(_1)}
,isc.A.animateClose=function(_1){if(!this.data.isOpen(_1))return;var _2=this.data.getParent(_1);if(_2&&!this.data.isOpen(_2)){return this.closeFolder(_1)}
var _3=this.data,_4=_3.indexOf(_1),_5=_3.getOpenList(_1).getLength()-1;this.startRowAnimation(false,_4+1,_4+_5+1,{target:this,methodName:"redraw"},this.animateFolderSpeed,this.animateFolderTime,this.animateFolderEffect,true);this.$34v=true;this.data.closeFolder(_1);delete this.$34v
if(this.body&&this.body.$279!=null){this.body.$34y=_1}}
,isc.A.$340=function(_1){var _2=this.data,_3=_2.indexOf(_1),_4=_2.getOpenList(_1).getLength()-1;if(_3<0||_4<=0)return;this.startRowAnimation(true,_3+1,(_3+_4+1),{target:(this.bodyLayout||this.body),methodName:"redraw"},this.animateFolderSpeed,this.animateFolderTime,this.animateFolderEffect,true)}
,isc.A.dataChanged=function(_1,_2,_3,_4){var _5=this.groupByField;if(_5!=null&&!this.$52y){if(_1=="add"||_1=="remove"||(_1=="update"&&(_2==null||_3==null)))
this.$52y=true;else if(_1=="update"){var _6=this.data;if(this.data.isGroupedOutput&&this.originalData)_6=this.originalData;var _7=_6.get(_3);if(_7==null)this.$52y=true;else for(var i=0;i<_5.length;i++){var _9,_10=_5[i];if(_2[_10]!==_9&&!this.fieldValuesAreEqual(_10,_2[_10],_7[_10])){this.$52y=true;break}}}}
if(this.$52y){this.$52y=false;this.regroup()}
if(this.body)this.body.finishRowAnimation();if(!this.$31o)this.$31n();var _11=this.getTotalRows()-1;if(this.body){if(this.body.lastOverRow>_11)delete this.body.lastOverRow;if(this.body.$31p>_11)delete this.body.$31p}
if(this.$31q>_11)delete this.$31q;if(this.hilites)this.applyHilites();if(!this.$50w)this.$25a("dataChanged")}
,isc.A.$31j=function(_1){if(this.body)this.body.finishRowAnimation();if(isc.isA.Tree(this.data))
this.ignore(_1,"changeDataVisibility");else
this.ignore(_1,"dataChanged");if(this.selection)this.selection.deselectAll()}
,isc.A.applyFieldDefaults=function(_1){if(_1==null)return;for(var i=0;i<_1.length;i++){var _3=_1[i];if(_3==null)continue;var _4=this.isRTL()?isc.Canvas.RIGHT:isc.Canvas.LEFT;var _5=_3.type,_6=(_5!=null?isc.SimpleType.getBaseType(_5):null);if(isc.SimpleType.inheritsFrom(_3.type,"image")){_3.$31r=this.$30s}else if(_6==this.$gx){if(_3.width==null&&_3.length!=null){if(_3.length<15&&!_3.valueMap){_3.width=_3.length*7}}}else if(_6=="integer"||_6=="float"){_4=isc.Canvas.RIGHT
_3.$31r=this.$30n}else if(_6=="date"){var _7=(this.canEdit==true&&_3.canEdit!=false)||(this.canEdit!=false&&_3.canEdit==true);_3.width=_3.width||(_7?100:80);_4=isc.Canvas.RIGHT;_3.$31r=this.$30m}else if(_6=="time"){_3.width=_3.width||80;_3.$31r=this.$30p;_4=isc.Canvas.RIGHT}else if(_5=="binary"||_5=="blob"||_5=="upload"||_5=="imageFile"){_3.$31r=this.$30q}else if(_5=="link"){_3.$31r=this.$30r}else if(_5=="icon"){_3.width=_3.width||((_3.iconWidth||_3.iconSize)+(2*this.cellPadding)+4);_3.align=_3.align||"center";_3.$31r=this.$59e;_3.title=_3.title||"&nbsp;"}
if(_3.formatCellValue!=null&&!isc.isA.Function(_3.formatCellValue))
isc.Func.replaceWithMethod(_3,"formatCellValue","value,record,rowNum,colNum,grid");if(this.showValueIconOnly(_3)){_4=isc.Canvas.CENTER;if(_3.width==null&&_3.showValueIconOnly){_3.width=this.getValueIconWidth(_3)+(2*this.cellPadding)+this.getValueIconRightPadding(_3)+this.getValueIconLeftPadding(_3)}}
if(!_3.align)_3.align=_4}}
,isc.A.$31s=function(_1){if(this.booleanTrueImage==null&&this.booleanFalseImage==null)return false;var _2=_1.type,_3=(_2!=null?isc.SimpleType.getBaseType(_2):null);if(_3!=this.$g2)return false;return(!_1.suppressValueIcons&&_1.showValueIconOnly==null&&_1.valueIcons==null&&_1.valueMap==null&&_1.formatCellValue==null)}
,isc.A.setFieldProperties=function(_1,_2){_1=this.getFieldNum(_1);var _3=this.getField(_1);isc.addProperties(_3,_2);if(this.header!=null&&this.header.isDrawn()){var _4=this.getFieldHeader(_1),_5=_4.getMember(this.getLocalFieldNum(_1));if(_5)_5.setProperties(_2)}}
,isc.A.setFieldTitle=function(_1,_2){this.setFieldProperties(_1,{title:_2})}
,isc.A.setAutoComplete=function(_1){this.autoComplete=_1}
,isc.A.setFieldAutoComplete=function(_1,_2){_1=this.getField(_1);if(_1)_1.autoComplete=_2}
,isc.A.showField=function(_1,_2){arguments.$cw=this;var _3=_1;_3=this.getSpecifiedField(_3);if(_3==null){this.logWarn("showField(): unable to find field object for field: "+_1+". Taking no action. Call setFields() to add new fields.")
return}
if(_3.showIf!=null)_3.showIf=null;var _4=this.completeFields!=null
if(!_4||this.frozenFields||_3.frozen||this.$54d){this.setFields(this.completeFields||this.fields);this.fieldStateChanged();return}else{if(this.fields.contains(_3))return;this.deriveVisibleFields()}
var _5=this.fields.indexOf(_3),_6=this.$60z();if(_6!=null&&_6>=_5){this.$600(_6+=1)}
var _7=this.header;if(_7!=null){if(!_2)this.header.hPolicy="fill";this.header.addButtons([_3],_5)}
if(this.body){if(this.getEditCol()!=null&&this.getEditCol()>=_5){this.$30u+=1}
if(this.$30a&&!this.editByCell||this.getEditCol()==_5){var _8=this.getEditRow(),_9=this.getRecord(_8),_10=this.getEditedRecord(_8),_11=this.getEditFormItemFieldWidths(_9)[_5],_12=this.getEditItem(_3,_9,_10,_8,_5,_11);if(_12!=null){var _13;if(this.editByCell)_13=0;else{var _14=this.$286.getItems();for(var i=0;i<_14.length;i++){var _16=_14[i].colNum;if(_16>=_5){if(_13==null)_13=i;_14[i].colNum+=1}}}
var _17=this.body.getDrawArea();if(this.editByCell||_5>=_17[2]&&_5<=_17[3])
this.$286.addItems([_12],_13)}}
this.body.fields=this.normalFields||this.fields;this.setBodyFieldWidths(this.getFieldWidths());if(this.body.isDrawn())this.body.redraw("show field")}
if(this.filterEditor!=null)this.filterEditor.showField(_1,_2);this.fieldStateChanged()}
,isc.A.hideField=function(_1,_2){arguments.$cw=this;var _3=_1;_3=this.getSpecifiedField(_3);if(_3==null){this.logWarn("hideField(): unable to find field object for field: "+_1+". Taking no action. To add this field use the setFields() method.")
return}
_3.showIf=this.$18r;if(!this.fields.contains(_3)){return}
var _4=this.fields.indexOf(_3),_5=this.getFieldName(_4);var _6=this.$60z();if(_6==_4)_6=null;else if(_6!=null&&_6>_4){this.$600(_6-1)}
if(this.completeFields==null||this.frozenFields){this.setFields(this.completeFields||this.fields);this.fieldStateChanged();return}
var _7=this.$30a;if(_7){var _8=this.getEditRow(),_9=this.getEditCol();if(this.editByCell){if(_9==_4)this.cancelEditing(isc.ListGrid.PROGRAMMATIC);_7=false}else{var _10=this.getEditFormItem(_4);if(_10)_10.blurItem();this.clearEditValue(_8,_9,true);if(_9==_4){var _11=this.findNextEditCell(_8,_9,-1,true,false,false,true);if(_11==null||_11[0]!=_8){_11=this.findNextEditCell(_8,_9,1,true,false,false,true)}
if(_11==null||_11[0]!=_8){this.cancelEditing(isc.ListGrid.PROGRAMMATIC);_7=false}else{this.$31u(_11[0],_11[1])}}else if(this.getEditCol()>_4){this.$30u-=1}}}
this.deriveVisibleFields();var _12=this.header;if(_12!=null){if(!_2)this.header.hPolicy="fill";var _13=this.header.getButton(_4);this.header.removeButtons([_13]);if(this.headerMenuButton&&this.headerMenuButton.masterElement==_13){this.headerMenuButton.depeer()}
_13.destroy()}
if(_7){var _14=this.$286,_15=_14.getItems();for(var i=_15.length-1;i>=0;i--){if(_15[i].colNum<=_4)break;_15[i].colNum-=1}}
if(this.body){this.body.fields=this.normalFields||this.fields;this.setBodyFieldWidths(this.getFieldWidths());if(this.body.isDrawn())this.body.redraw("hide field")}
if(_7){if(!this.editByCell){var _17=this.$286.getItem(_5);if(_17!=null){this.$286.removeItems([_17])}}}
if(this.filterEditor!=null)this.filterEditor.hideField(_1,_2);this.fieldStateChanged()}
,isc.A.fieldIsVisible=function(_1){var _2=_1;if(!isc.isAn.Object(_2))_2=this.getSpecifiedField(_1);return this.fields.contains(_2)}
,isc.A.getTitleField=function(){if(this.titleField!=null)return this.titleField;if(this.dataSource!=null){var _1=this.getDataSource().getTitleField();if(!this.getField(_1))_1=this.getFields()[0][this.fieldIdProperty];this.titleField=_1}else{var _2=this.getFields().getProperty(this.fieldIdProperty);this.titleField=_2.contains("title")?"title":_2.contains("name")?"name":_2.contains("id")?"id":_2.first()}
return this.titleField}
,isc.A.setFields=function(_1){if(isc.$cv)arguments.$cw=this;if(!_1&&this.getDataSource()&&!this.getDataSource().fields){isc.logWarn('ListGrid.setFields() : neither this ListGrid nor its dataSource have fields')}
if(!this.booleanFalseImage&&!this.booleanTrueImage){this.booleanTrueImage=isc.CheckboxItem?isc.CheckboxItem.getInstanceProperty("checkedImage"):null;this.booleanFalseImage=isc.CheckboxItem?isc.CheckboxItem.getInstanceProperty("uncheckedImage"):null;this.booleanImageWidth=isc.CheckboxItem?isc.CheckboxItem.getInstanceProperty("valueIconWidth"):null;this.booleanImageHeight=isc.CheckboxItem?isc.CheckboxItem.getInstanceProperty("valueIconHeight"):null}
var _2=this.$60z(),_3=(_2!=null&&this.fields?this.fields[_2]:null);var _4=this.$30a,_5=this.getEditRow(),_6=this.getEditCol(),_7=this.$286,_8=this.fields?this.getEditFieldName():null;if(this.completeFields==null)this.fields=[];this.completeFields=this.bindToDataSource(_1);if(this.completeFields==null)this.completeFields=[];if(this.selectionAppearance=="checkbox"&&this.selectionType!="none"){var _9=this.getCheckboxField(),_10=this.getCheckboxFieldPosition();if(this.completeFields.find("frozen",true))_9.frozen=true;this.completeFields.addAt(_9,_10)}
if(this.canRemoveRecords){var _11=this.completeFields.findIndex("isRemoveField",true),_12=(_11>=0)?this.completeFields[_11]:{isRemoveField:true};if(!_12.$61a){isc.addProperties(_12,this.removeFieldDefaults,this.removeFieldProperties);if(_12.name==null)_12.name="$61b";if(_12.cellIcon==null)_12.cellIcon=this.removeIcon;if(_12.summaryTitle==null){_12.summaryTitle=this.getRemoveSummaryTitle()}
if(_11==-1){this.completeFields.add(_12)}
_12.$61a=true}}
if(isc.DataSource)this.$45n();if(this.fieldState!=null)this.setFieldState();this.applyFieldDefaults(this.completeFields);this.deriveVisibleFields();if(this.fields.length==0){var _13=this.completeFields.length>0;if(!_13){this.logWarn("This component has no specified fields. In order to display data "+"fields must be set up either via an explicit call to setFields() or "+"by binding to a dataSource.")}else{this.logWarn("All specified fields for this component are hidden. Note that fields "+"may be hidden via 'showIf' or 'detail' attribute values. "+"In order to display data this grid must have some visible fields.")}}
this.$26a=null;var _14,_15,_16;if(_4){this.storeUpdatedEditorValue();_14=this.fields.findIndex(this.fieldIdProperty,_8);if(_14!=-1&&!this.canEditCell(_5,_14))
_14=-1;if(_14==-1){var _17;if(!this.editByCell)_17=this.findNextEditCell(_5,0,1,true,true,false,true);if(_17!=null&&_17[0]==_5){_14=_17[1]}
if(_14==-1){this.cancelEditing(isc.ListGrid.PROGRAMMATIC);_4=false}}else{var _18=_7.getItem(_8);if(_18){_16=_18.hasFocus;if(_16)_7.$106()}
_15=true}
if(_4)this.hideInlineEditor(false,true)}
var _19=(this.canFreezeFields==null||this.$60v)&&this.fixedRecordHeights!=false&&this.fixedFieldWidths!=false&&this.autoFitData!="horizontal"&&this.autoFitData!="both"&&this.bodyOverflow!="visible";if(_19){if(this.completeFields.getProperty("overflow").contains("visible"))_19=false}
if(_19){this.$60v=true;this.canFreezeFields=true}else if(this.$60v){delete this.$60v;this.canFreezeFields=null}
if(this.canSelectCells)this.selection.numCols=this.fields.length;if(_3){var _20=this.fields.indexOf(_3);if(_20==-1)_20=null;this.$600(_20)}
if(this.showHeader&&this.headerHeight>0&&this.header!=null){this.updateHeader();if(this.body!=null){this.syncHeaderScrolling(this.body.getScrollLeft())}}
this.updateBody();this.layoutChildren(this.$604);if(this.$52b!=null){var _21={};for(var i in this.$52b){if(this.$52b[i]==null)continue;var _23=this.$52b[i].$31x,_24=(this.dataSource!=null?this.getDataSource().getPrimaryKeyFieldNames():[]);for(var _25 in _23){if(!this.fields.containsProperty(this.fieldIdProperty,_25)&&!_24.contains(_25)){_21[_25]=true;this.clearEditValue(_23,_25,true)}}}
_21=isc.getKeys(_21);if(_21.length>0){this.logInfo("'setFields()' removed the following fields which had pending edit "+"values for some row[s]: '"+_21.join("', '")+"'.\n"+"Edit values for these fields have been dropped.","gridEdit")}}
if(_4){if(_15){this.showInlineEditor(_5,_14,false,false,true);if(_16)_7.$11b(_26)}else{this.$31u(_5,_14,!_16)}
if(_16){var _26=this.getEditFieldName();if(_26==_8){_7.$11b(_26)}else{_7.focusInItem(_26)}}}
if(this.$60z()!=null&&this.canSort)this.resort();if(this.filterEditor!=null)this.filterEditor.setFields(this.completeFields.duplicate())}
,isc.A.getRemoveSummaryTitle=function(){var _1=this.completeFields.find("isRemoveField",true)||{};return isc.Canvas.imgHTML(this.removeIcon,_1.iconWidth||_1.iconSize,_1.iconHeight||_1.iconSize)+"&nbsp;"+this.removeSummaryTitle}
,isc.A.focusInFilterEditor=function(_1){if(this.filterEditor==null)return;var _2=_1!=null?this.getColNum(_1):null;this.filterEditor.startEditing(0,_2)}
,isc.A.filterByEditor=function(){if(this.filterEditor!=null)this.filterEditor.performAction()}
,isc.A.bindToDataSource=function(_1,_2,_3,_4,_5,_6){var _7=this.invokeSuper(isc.ListGrid,"bindToDataSource",_1,_2,_3,_4,_5,_6);if(this.showDetailFields&&_7!=null){for(var i=0;i<_7.length;i++){if(_7[i].showIf==null&&_7[i].detail==true){_7[i].showIf=this.$18r}}}
return _7}
,isc.A.getFieldState=function(){var _1=[];if(this.completeFields){var _2=this.header.members;for(var i=0;i<this.completeFields.length;i++){var _4=this.completeFields[i],_5=_4[this.fieldIdProperty],_6={name:_5};if(!this.fieldIsVisible(_4))_6.visible=false;if(_2){var _7=_2.find(this.fieldIdProperty,_5);if(_7&&_7.$pn&&isc.isA.Number(_7.$pn)){_6.width=_7.$pn}}
_1.add(_6)}}
return isc.Comm.serialize(_1)}
,isc.A.evalViewState=function(_1,_2,_3){if(isc.isA.String(_1)){var _4=_1;try{_1=isc.eval(_1)}catch(e){if(!_3)
this.logWarn("Unable to parse "+_2+" object passed in: "+_4+" Ignoring.");return}}
return _1}
,isc.A.setFieldState=function(_1){if(this.completeFields==null)return;if(_1==null&&this.fieldState!=null){if(isc.isA.String(this.fieldState)){_1=this.evalViewState(this.fieldState,"fieldState")}
this.$31y(this.fieldState);this.fieldState=null;return}
_1=this.evalViewState(_1,"fieldState")
if(_1){this.$31y(_1);this.refreshFields()}}
,isc.A.$31y=function(_1){if(_1==null)return;var _2=this.completeFields.getProperty(this.fieldIdProperty),_3=[];for(var i=0;i<_1.length;i++){var _5=_1[i],_6=this.completeFields.find(this.fieldIdProperty,_5.name);if(_6==null)continue;_2.remove(_5.name);if(_5.visible==false)_6.showIf=this.$18r;else _6.showIf=null;if(_5.width!=null&&!isNaN(_5.width))_6.width=_5.width;_3.add(_6)}
for(var i=0;i<_2.length;i++){var _7=_2[i],_8=this.completeFields.findIndex(this.fieldIdProperty,_7),_6=this.completeFields[_8],_9=this.completeFields[_8-1];if(_9!=null){var _10=_3.indexOf(_9);if(_10!=-1){_3.addAt(_6,_10+1);continue}}
if(this.fieldShouldBeVisible(_6,_8)){_3.addAt(_6,this.$31z(_3)+1)}else{_3.add(_6)}}
this.completeFields=_3}
,isc.A.$31z=function(_1){if(_1==null)_1=this.completeFields;var _2=this.getVisibleFields(_1);if(_2.length==0)return-1;return _1.lastIndexOf(_2.last())}
,isc.A.fieldStateChanged=function(){}
,isc.A.getCheckboxField=function(){var _1={};isc.addProperties(_1,this.checkboxFieldDefaults,this.checkboxFieldProperties);_1.valueIconWidth=isc.CheckboxItem.getInstanceProperty("valueIconWidth");_1.valueIconHeight=isc.CheckboxItem.getInstanceProperty("valueIconHeight");_1.width=_1.valueIconWidth+this.$63g;var _2=isc.CheckboxItem.getInstanceProperty("checkedImage"),_3=isc.CheckboxItem.getInstanceProperty("uncheckedImage");_1.title=this.getValueIconHTML(_3,_1);if(!_1.valueIcons){_1.valueIcons={"true":_2,"false":_3}}
return _1}
,isc.A.isCheckboxField=function(_1){if(!_1||!_1.$63f)return false;else return true}
,isc.A.getCheckboxFieldPosition=function(){if(!this.selectionAppearance=="checkbox")return-1;return this.isRTL()?this.completeFields.length-1:0}
,isc.A.getSelectedState=function(){if(!this.selection)return null;if(!this.dataSource||isc.isAn.emptyObject(this.getDataSource().getPrimaryKeyFields()))
{this.logWarn("can't getSelectedState without a DataSource "+"with a primary key field set");return null}
var _1=this.selection.getSelection()||[],_2=[];for(var i=0;i<_1.length;i++){_2[i]=this.getPrimaryKeys(_1[i])}
return isc.Comm.serialize(_2)}
,isc.A.setSelectedState=function(_1){_1=this.evalViewState(_1,"selectedState")
if(!_1)return;var _2=this.selection,_3=this.data;if(_3&&_2){_2.deselectAll();var _4=[];for(var i=0;i<_1.length;i++){var _6=_3.findByKeys(_1[i],this.getDataSource());if(_6!=-1)_4.add(_3.get(_6))}
this.selection.selectList(_4)}}
,isc.A.getSortState=function(){var _1=this.$60z(),_2=(_1!=null?this.getField(_1):null),_3=_2!=null?this.getFieldName(_2):null,_4=_2&&_2.sortDirection!=null?_2.sortDirection:this.sortDirection;return"("+isc.Comm.serialize({fieldName:_3,sortDir:_4})+")"}
,isc.A.setSortState=function(_1){_1=this.evalViewState(_1,"sortState")
if(!_1)return;if(_1.fieldName==null)this.unsort();else{var _2=this.getFieldNum(_1.fieldName)
if(_2!=-1)this.sort(_2,_1.sortDir)}}
,isc.A.getViewState=function(_1){var _2={selected:this.getSelectedState(),field:this.getFieldState(),sort:this.getSortState()};if(_1)return _2;return"("+isc.Comm.serialize(_2)+")"}
,isc.A.setViewState=function(_1){_1=this.evalViewState(_1,"viewState")
if(!_1)return;if(_1.field)this.setFieldState(_1.field);if(_1.sort)this.setSortState(_1.sort);if(_1.selected)this.setSelectedState(_1.selected)}
,isc.A.setDataSource=function(_1,_2){this.Super("setDataSource",arguments);this.clearFilterValues();this.discardAllEdits()}
,isc.A.fieldShouldBeVisible=function(_1,_2){if(_1.showIf!=null){if(_1.showIf==this.$18r||_1.showIf==this.$301)return false;isc.Func.replaceWithMethod(_1,"showIf","list,field,fieldNum");if(!_1.showIf(this,_1,_2))return false}
return true}
,isc.A.getVisibleFields=function(_1){var _2=[];for(var i=0;i<_1.length;i++){var _4=_1[i];if(_4==null)continue;if(this.fieldShouldBeVisible(_4,i))_2.add(_4)}
return _2}
,isc.A.deriveVisibleFields=function(){this.fields.setArray(this.getVisibleFields(this.completeFields));this.deriveFrozenFields();this.refreshMasterIndex()}
,isc.A.refreshFields=function(){this.setFields(this.completeFields)}
,isc.A.getFieldWidths=function(_1){var _2=this.header;if(isc.isA.Layout(_2)&&_2.isDrawn()){var _3=_2.getMemberSizes();if(this.allowMismatchedHeaderBodyBorder&&_3.length>0){var _4=_2.getLeftBorderSize()+_2.getLeftMargin(),_5=_2.getRightBorderSize()+_2.getRightMargin();if(_4!=0){_3[0]+=_4}
var _6=_3.sum(),_7=_6-_2.getInnerWidth();if(_7>0){_3[_3.length-1]+=Math.min(_7,_5)}}
if(this.frozenFields){var _8=this.frozenHeader.getMemberSizes();_3.addListAt(_8,this.freezeLeft()?0:_3.length)}
return _3}else{return this.getStretchResizeWidths()}}
,isc.A.getStretchResizeWidths=function(){if(this.fields==null)return[];return isc.Canvas.applyStretchResizePolicy(this.fields.getProperty("width"),(this.innerWidth!=null?this.innerWidth:this.getAvailableFieldWidth()))}
,isc.A.getAvailableFieldWidth=function(){var _1=((this.autoFitData=="both"||this.autoFitData=="horizontal")?this.getVisibleWidth():this.getWidth())-this.getHMarginBorder();var _2=this.$54u();if(_2){_1-=this.getScrollbarSize()}
return _1}
,isc.A.getFieldWidth=function(_1){_1=this.getFieldNum(_1);if(_1==-1||!this.fields||_1>=this.fields.length)return null;if(this.body!=null)return this.getColumnWidth(_1);return this.getFieldWidths()[_1]}
,isc.A.$310=function(_1,_2){if(_2==null)_2=false;if(_1==null||_1.length==0)return _1;if(!this.body){return _1}
_1[_1.length-1]=this.$311(_1[_1.length-1],_1.sum(),_2);_1[0]=this.$312(_1[0],_2);return _1}
,isc.A.$312=function(_1,_2){if(!this.body)return _1;var _3=(_2?this.body.getTopBorderSize()+this.body.getTopMargin():this.body.getLeftBorderSize()+this.body.getLeftMargin());if(_3!=0)_1-=_3;return Math.max(0,_1)}
,isc.A.$311=function(_1,_2,_3){if(!this.body)return _1;var _4=(_3?this.body.getBottomBorderSize()+this.body.getBottomMargin():this.body.getRightBorderSize()+this.body.getRightMargin());if(_4!=0){var _5=_2-
(_3?this.body.getInnerHeight():this.body.getInnerWidth());if(_5>0){_1-=Math.min(_5,_4)}}
return Math.max(_1,1)}
,isc.A.setBodyFieldWidths=function(_1){this.$26a=_1;var _2=_1;if(this.allowMismatchedHeaderBodyBorder){if(isc.isAn.Array(_1)){_1=this.$310(_1.duplicate())}}
var _3=this.frozenFields;if(_3){var _4=this.getFrozenSlots(_1);_1=this.getUnfrozenSlots(_1);this.frozenBody.setColumnWidths(_4);var _5=_4.sum();this.frozenBody.setWidth(_5);this.frozenBody.$pn=_5;if(this.frozenHeader)this.frozenHeader.setWidth(_5)}
if(this.body!=null)this.body.setColumnWidths(_1);if(this.$30a){var _6=this.$286.getItems(),_7=this.getRecord(this.getEditRow()),_8=this.getEditFormItemFieldWidths(_7);for(var i=0;i<_6.length;i++){var _10=_6[i].colNum;if(_6[i].width!=_8[_10])
_6[i].setWidth(_8[_10])}}}
,isc.A.createChildren=function(){if(this.showHeader&&this.headerHeight>0&&!this.header)this.makeHeader();if(this.showFilterEditor&&!this.filterEditor)this.makeFilterEditor();this.createBodies();if(this.header)this.body.moveAbove(this.header);if(isc.Browser.isMoz&&isc.Browser.geckoVersion>=20051111){if(this.header){this.body.mozOutlineOffset="0px";if(this.body.mozOutlineColor==null)
this.body.mozOutlineColor=this.mozBodyOutlineColor}else{if(this.body.mozOutlineColor==null)
this.body.mozOutlineColor=this.mozBodyNoHeaderOutlineColor;this.body.mozOutlineOffset="-1px"}}
this._useNativeTabIndex=false}
,isc.A.layoutChildren=function(_1,_2,_3){isc.Canvas.$b4.layoutChildren.call(this,_1,_2,_3);if(this.body!=null){this.$45m(_1,_2,_3);if(this.frozenBody){var _4=this.shrinkForFreeze&&this.body.hscrollOn;var _5=this.bodyLayout.getInnerHeight();if(_4)_5-=this.body.getScrollbarSize();this.frozenBody.setHeight(_5);this.frozenBody.$po=_5}}}
,isc.A.$45m=function(_1,_2,_3){if(this.body==null)return;this.$26a=null;var _4=this.getAvailableFieldWidth(),_5=(_4!=this.innerWidth);this.innerWidth=_4;var _6=this.header,_7=(this.showHeader?this.headerHeight:0);if(_6!=null){var _8=(this.isRTL()&&this.$54u()?this.getScrollbarSize():0);_6.hPolicy="fill";if(this.frozenHeader)this.frozenHeader.hPolicy="fill";var _9=this.innerWidth;if(!this.leaveScrollbarGap&&_6.isDrawn()&&_9!=_6.getWidth()&&_1=="body scroll changed"){if(this.$54e||!this.resizeFieldsForScrollbar){_6.hPolicy="none"}}
var _10=this.headerLayout||_6;_10.setRect(_8,0,_9,_7);if(!_6.isDrawn()&&(_1=="initial draw"||this.isDrawn())){if(!this.frozenFields){_6.draw()}else{var _11=this.getFieldWidths(),_12=this.getFrozenSlots(_11);this.frozenHeader.setWidth(_12.sum());this.headerLayout.draw()}}
_6.hPolicy="none";if(this.frozenHeader)this.frozenHeader.hPolicy="none";if(this.sorter){this.sorter.setLeft(this.getSorterLeft());var _13=this.$313();this.sorter.setVisibility(this.$313()?isc.Canvas.INHERIT:isc.Canvas.HIDDEN)}}
if((!this.$26a||_5)&&((_6&&_6.isDrawn())||_7==0))
{var _11=this.getFieldWidths(_1);this.setBodyFieldWidths(_11);if(this.filterEditor){this.filterEditor.setBodyFieldWidths(_11.duplicate())}
if(this.logIsDebugEnabled("layout")){this.logDebug("new field widths: "+this.$26a,"layout")}}
if(!this.$618){this.$618={}
this.$618[this.$pc]=true;this.$618[this.$60m]=true;this.$618[this.$604]=true;this.$618[this.$616]=true;this.$618[this.$617]=true}
var _14=this.autoFitData==null||!this.body.isDrawn()||this.$618[_1];if(_14){this.bodyHeight=Math.max(1,(this.getInnerHeight()-_7));this.bodyWidth=Math.max(1,this.getInnerWidth());var _15=this.bodyLayout||this.body;_15.setRect(0,_7,this.bodyWidth,this.bodyHeight);if(this.body.isDirty()&&!this.body.$58p&&!_15.$58p){_15.redraw()}}}
,isc.A.resizePeersBy=function(_1,_2,_3,_4){this.invokeSuper(isc.ListGrid,"resizePeersBy",_1,_2,_3,_4);if(this.filterEditor!=null){this.filterEditor.resizeBy(_1,0)}}
,isc.A.draw=function(_1,_2,_3,_4){if(isc.$cv)arguments.$cw=this;if(!this.readyToDraw())return this;this.prepareForDraw();this.invokeSuper(isc.ListGrid,"draw",_1,_2,_3,_4);this.body.getColumnSizes();var _5=this.$60z();if(this.header&&_5!=null)this.header.selectButton(_5);this.bodyScrolled()}
,isc.A.prepareForDraw=function(){if(this.completeFields==null)this.setFields(this.fields);this.createChildren()}
,isc.A.destroy=function(_1){if(this._dragLine){this._dragLine.destroy();this._dragLine=null}
if(this.$314)this.$314.destroy();if(this.$58q)this.$58q.destroy();if(this.cellContextMenu)this.cellContextMenu.destroy();if(this.$286){this.$286.destroy();delete this.$286;delete this.$30a}
if(this.data){if(this.data.$31k&&isc.isA.Function(this.data.destroy)){this.data.destroy()}else{this.$31j(this.data);delete this.data}}
if(this.selection){this.destroySelectionModel()}
if(this.selectionCanvas)this.selectionCanvas.destroy();if(this.selectionUnderCanvas)this.selectionUnderCanvas.destroy();if(this.rollOverCanvas)this.rollOverCanvas.destroy();if(this.rollUnderCanvas)this.rollUnderCanvas.destroy();this.Super("destroy",arguments)}
);isc.evalBoundary;isc.B.push(isc.A.redrawHeader=function(){if(this.header)this.header.markForRedraw()}
,isc.A.getBaseStyle=function(_1,_2,_3){if(this.canEdit==true&&!this.isPrinting){if(this.editFailedBaseStyle&&this.cellHasErrors(_2,_3))
return this.editFailedBaseStyle;if(this.editPendingBaseStyle&&this.cellHasChanges(_2,_3,false))
return this.editPendingBaseStyle}
if(_1&&this.recordBaseStyleProperty&&_1[this.recordBaseStyleProperty])
return _1[this.recordBaseStyleProperty];var _4=this.getField(_3);if(_4&&_4.baseStyle)return _4.baseStyle;if(_4&&_4.frozen&&this.frozenBaseStyle)return this.frozenBaseStyle;return this.isPrinting?this.printBaseStyle||this.baseStyle:this.baseStyle}
,isc.A.getCellCSSText=function(_1,_2,_3){if(_1){var _4=_1[this.recordCSSTextProperty];if(_4!=null)return _4}
var _4;if(this.isEditable()){if(this.editFailedBaseStyle==null&&this.editFailedCSSText&&this.cellHasErrors(_2,_3))
{_4=this.editFailedCSSText}else if(this.editPendingBaseStyle==null&&this.editPendingCSSText&&this.cellHasChanges(_2,_3,false))
{_4=this.editPendingCSSText}}
if(this.hilites&&_1[this.hiliteProperty]!=null){_4=this.addObjectHilites(_1,_4,this.getField(_3))}else if(this.hilites&&_1[this.hiliteMarker]!=null){_4=this.addHiliteCSSText(_1,_3,_4)}
return _4}
,isc.A.getRawCellValue=function(_1,_2,_3,_4){var _5,_6;if(_4){_6=_3
_5=this.completeFields?isc.Class.getArrayItem(_6,this.completeFields,this.fieldIdProperty):this.getField(_6)}else{_5=this.fields[_3];_6=_5[this.fieldIdProperty]}
if(_6==null)return this.emptyCellValue;var _7,_8,_9;if(this.rowEditNotComplete(_2)){_7=this.$30y(_2,_3)}
if(_7!==_9){return _7}else{if(_1==null)return this.emptyCellValue;if(this.data.getFieldValue&&_5){_8=this.data.getFieldValue(_1,_6,_5)}else if(_1.ownerDocument&&_5){_8=isc.xml.getFieldValue(_1,_6,_5)}else{_8=_1[_6]}}
if(_5&&_5.getRawCellValue){isc.Func.replaceWithMethod(_5,"getRawCellValue","viewer,record,recordNum,field,fieldNum,value");_8=_5.getRawCellValue(this,_1,_2,_5,_3,_8)}
return _8}
,isc.A.getCellValue=function(_1,_2,_3,_4){if(_1==null){if(this.showNewRecordRow&&this.$299(_2)){return this.getNewRecordRowCellValue()}
_1=this.$300(_2,_3)}
var _5=this.fields[_3],_6=null;if(_5==null)return"";if(this.isCheckboxField(_5)&&!_1.$52e){var _7=this.selection.isSelected(_1)?true:false;var _8=this.getValueIcon(_5,_7);var _9=this.getValueIconHTML(_8,_5);return _9}
var _8,_10=this.showValueIconOnly(_5),_11;if(_1!=null){if(_1[this.isSeparatorProperty])
return this.$302;if(_1[this.singleCellValueProperty]!=null){if(_1.$52e){return this.getGroupNodeHTML(_1,_4)}else{return _1[this.singleCellValueProperty]}}
if(Array.isLoading(_1)){if(!isc.Browser.isSafari||_3==0){if(isc.isOffline()){return this.offlineMessage}else{return this.loadingMessage}}
return"&nbsp;"}
_11=(this.$30a&&this.$285==_2&&(!this.editByCell||this.$30u==_3)&&this.canEditCell(_2,_3));if(_11){_6=this.getEditItemCellValue(_1,_2,_3)}else{var _5=this.fields[_3],_12,_13;if(_5.displayField!=null){_13=!_5.valueMap&&!_5.getCellValue&&this.$425(_5);if(_13){var _14=_5.displayField;_12=this.getRawCellValue(_1,_2,_14,true)}}
_6=this.getRawCellValue(_1,_2,_3);if(_5.getCellValue){isc.Func.replaceWithMethod(_5,"getCellValue","viewer,record,recordNum,field,fieldNum,value");_6=_5.getCellValue(this,_1,_2,_5,_3,_6)}
_8=this.getValueIcon(_5,_6,_1);if(!_10){var _15=_5.valueMap;if(_15){if(isc.isA.String(_15))_15=this.getGlobalReference(_15);if(!isc.isAn.Array(_15))_6=isc.getValueForKey(_6,_15)}}
if(_13)_6=_12}}
if(!_11){var _16=null;if(_8!=null){_16=this.getValueIconHTML(_8,_5)}
if(_10){if(!_16||isc.isAn.emptyString(_16))_16=this.emptyCellValue;return _16}
_6=this.$315(_6,_1,_5,_2,_3);if(_16){if(_5.valueIconOrientation!=isc.Canvas.RIGHT)
_6=_16+_6;else
_6=_6+_16}
if(this.isEditable()&&this.showErrorIcons&&this.cellHasErrors(_2,_3)){_6=this.getErrorIconHTML(_2,_3)+_6}}
return _6}
,isc.A.getValueIconHTML=function(_1,_2){var _3=_2.imageURLPrefix||_2.baseURL||_2.imgDir,_4=_2.imageURLSuffix,_5=this.getValueIconWidth(_2),_6=this.getValueIconHeight(_2),_7=this.getValueIconLeftPadding(_2),_8=this.getValueIconRightPadding(_2);if(_4!=null)_1+=_4;var _9=isc.Canvas.$xq(_1,_3,_5,_6,_7,_8,null,this);return _9}
,isc.A.getCellAlign=function(_1,_2,_3){if(_1&&(_1[this.singleCellValueProperty]!=null)){return isc.Canvas.LEFT}
var _4=_3;if(this.isPrinting){for(var i=0;i<_3;i++){if(this.fields[i].shouldPrint==false){_4+=1}}}
var _6=this.fields[_4];return(_6.cellAlign||_6.align)}
,isc.A.$425=function(_1){return _1&&_1.displayField&&(!_1.optionDataSource||isc.DS.get(_1.optionDataSource)==this.getDataSource())}
,isc.A.getValueIcon=function(_1,_2,_3){if(!_1.valueIcons||_1.suppressValueIcon){if(this.$31s(_1)){var _4=(_2?this.booleanTrueImage:this.booleanFalseImage);if(_4==null)_4=isc.Canvas.getImgURL(isc.Canvas.$wz);return _4}
return null}
var _5=_1.valueIcons[_2];return _5}
,isc.A.getValueIconLeftPadding=function(_1){return(_1&&_1.valueIconLeftPadding!=null?_1.valueIconLeftPadding:this.valueIconLeftPadding||0)}
,isc.A.getValueIconRightPadding=function(_1){return(_1&&_1.valueIconRightPadding!=null?_1.valueIconRightPadding:this.valueIconRightPadding||0)}
,isc.A.showValueIconOnly=function(_1){if(_1.showValueIconOnly!=null)return _1.showValueIconOnly;if(_1.valueIcons!=null&&_1.valueMap!=null)return true;return this.$31s(_1)}
,isc.A.getValueIconWidth=function(_1){if(this.$31s(_1))return this.booleanImageWidth;return(_1.valueIconWidth!=null?_1.valueIconWidth:(_1.valueIconSize!=null?_1.valueIconSize:(this.valueIconWidth!=null?this.valueIconWidth:this.valueIconSize)))}
,isc.A.getValueIconHeight=function(_1){if(this.$31s(_1))return this.booleanImageHeight;return(_1.valueIconHeight!=null?_1.valueIconHeight:(_1.valueIconSize!=null?_1.valueIconSize:(this.valueIconHeight!=null?this.valueIconHeight:this.valueIconSize)))}
,isc.A.$299=function(_1){return this.showNewRecordRow&&(_1==this.getTotalRows()-1)}
,isc.A.getNewRecordRowCellValue=function(){return'<div align="center">'+this.newRecordRowMessage+'</div>'}
,isc.A.getErrorIconHTML=function(_1,_2){var _3=this.getCellErrors(_1,_2);if(_3==null)return isc.$ad;var _4="title='",_5=isc.FormItem.getErrorPromptString(_3,true);_4+=_5+"'";var _6=this.imgHTML(this.errorIconSrc,this.errorIconWidth,this.errorIconHeight,null,_4);if(isc.Browser.isIE&&this.$30a&&this.getEditRow()==_1&&(!this.editByCell||this.getEditCol()==_2)){_6+=" "}else{_6+=isc.Canvas.spacerHTML(this.cellPadding,"auto")}
return _6}
,isc.A.$315=function(_1,_2,_3,_4,_5){if(_3&&_3.formatCellValue!=null){_1=_3.formatCellValue(_1,_2,_4,_5,this)}else if(_3&&_3.cellValueTemplate){_1=_3.cellValueTemplate.evalDynamicString(this,{value:_1,record:_2,field:_3})}else if(this.formatCellValue!=null){_1=this.formatCellValue(_1,_2,_4,_5)}else if(_3&&_3.$63!=null){_1=_3.$62.shortDisplayFormatter(_1,_3,this,_2,_4,_5)}else if(_3&&_3.$31r!=null){_1=_3.$31r(_1,_3,this,_2,_4,_5)}
if(_1==null||isc.is.emptyString(_1)){if(_3.emptyCellValue!=null){_1=_3.emptyCellValue}else{_1=this.emptyCellValue}}else if(this.$54y[_1]){_1=this.$54t}else if(!isc.isA.String(_1)){_1=isc.iscToLocaleString(_1)}
return _1}
,isc.A.getEditItemCellValue=function(_1,_2,_3){var _4=this.getEditorName(_2,_3);var _5=this.getCellErrors(_2,_3);if(_5){this.$286.setFieldErrors(_4,_5)}
var _6=this.$286.getItem(_4),_7=_6.getStandaloneItemHTML(false,true);if(_5){this.$286.setFieldErrors(_4,null)}
var _8=_6.containerWidget;if(!_8.$316)_8.$316=[];if(!_8.$316.contains(_6)){_8.$316.add(_6)}
return _7}
,isc.A.$30b=function(_1,_2,_3){var _4;if(_1)_4=[_1];else{_4=[];var _5=this.$286.getItems();for(var i=0;i<_5.length;i++){if(_5[i].containerWidget==_3)_4.add(_5[i])}}
var _7=_3.$316;for(var i=0;i<_4.length;i++){var _8=_4[i],_9=_8.isDrawn(),_10=_7?_7.contains(_8):false,_11=isc.CanvasItem&&isc.isA.CanvasItem(_8);if(_9){if(_10){_8.redrawn();if(_2)_8.moved()}
else{_8.cleared()}}else if(_10){if(_11)_8.placeCanvas();_8.drawn()}}
delete _3.$316}
,isc.A.setRawCellValue=function(_1,_2,_3,_4){var _5=this.fields[_3];if(!_1||!_5)return;if(_5.setRawCellValue){isc.Func.replaceWithMethod(_5,"setRawCellValue","viewer,record,recordNum,field,fieldNum,value");_5.setRawCellValue(this,_1,_2,_5,_3,_4)}else{_1[_5[this.fieldIdProperty]]=_4}
this.data.dataChanged()}
,isc.A.getCellBooleanProperty=function(_1,_2,_3,_4){var _5=false,_6=this[_1];if(_6==false||_6==this.$18r)return false;var _7=this.fields[_3][_1];if(_7==false||_7==this.$18r)return false;if(_4!=null){var _8=this.getRecord(_2,_3),_9=(_8!=null?_8[_4]:false);if(_9==false||_9==this.$18r)return false;if(_9==true||_9==this.$18q)return true}
return(_6==true)||(_7==true)||(_6==this.$18q)||(_7==this.$18q)}
,isc.A.getDrawArea=function(){if(this.body)return this.body.getDrawArea();return null}
,isc.A.bodyDrawing=function(_1){if(isc.$cv)arguments.$cw=this;if(this.$31v){var _2=!isc.RPCManager.startQueue();for(var _3 in this.$45o){var _4=this.$45o[_3].fields,_5=this.$45o[_3].outputs,_6=isc.DataSource.getDataSource(_3);_6.fetchData({},{target:this,methodName:"$317"},{clientContext:{fields:_4},parameters:{outputs:_5.getUniqueItems()}})}}
this.requestVisibleRows();if(this.$31v){if(_2)isc.RPCManager.sendQueue();this.$31v=null}}
,isc.A.$45n=function(){this.$31v=null;this.$45o={};var _1=this.getDataSource();for(var i=0;i<this.completeFields.length;i++){var _3=this.completeFields[i];if(_3.optionDataSource==null||_3.autoFetchDisplayMap==false||(this.autoFetchDisplayMap==false&&_3.autoFetchDisplayMap==null))
{continue}
var _4=isc.DS.get(_3.optionDataSource);if(_4==null){this.logWarn(_3.optionDataSource+" dataSource not found, check value of "+"optionDataSource property on the "+_3[this.fieldIdProperty]+" field");continue}else if(_4==_1)continue;var _5=_4.ID;this.$31v=true;if(this.$45o[_5]!=null){var _6=this.$45o[_5];_6.fields.add(_3);_6.outputs.add(_3.displayField);_6.outputs.add(_3.valueField)}else{var _6=this.$45o[_5]={};_6.fields=[_3];_6.outputs=[_3.displayField,_3.valueField]}}}
,isc.A.$317=function(_1,_2,_3){var _4=_3.clientContext.fields;for(var i=0;i<_4.length;i++){var _6=_4[i];this.setValueMap(_6[this.fieldIdProperty],_2.getValueMap(_6.valueField,_6.displayField))}
return true}
,isc.A.requestVisibleRows=function(){if(isc.ResultSet&&isc.isA.ResultSet(this.data)){if(this.body==null)return this.data.getRange(0);if(this.data.lengthIsKnown()&&this.data.getLength()==0)return;if(!this.data.lengthIsKnown()){this.body.showAllRows=false}else{this.body.showAllRows=(this.body.overflow==isc.Canvas.VISIBLE?true:this.showAllRecords)}
var _1=this.body.getDrawArea();if(this.isGrouped){return this.data.getRange(0,this.groupByMaxRecords)}else{return this.data.getRange(_1[0],_1[1])}}
return null}
,isc.A.getPrintHeaders=function(_1,_2){var _3=isc.SB.create();_3.append("<TR>");var _4=(this.isRTL()?isc.Canvas.LEFT:isc.Canvas.RIGHT);for(var _5=_1;_5<_2;_5++){var _6=this.body.fields[_5];var _7=_6.align||_4;_3.append("<TD CLASS=",(this.printHeaderStyle||this.headerBaseStyle)," ALIGN=",_7,">",this.getHeaderButtonTitle(_6.masterIndex),"</TD>")}
_3.append("</TR>");return _3.toString()}
,isc.A.getPrintHTML=function(_1,_2){var _3=this.body;if(_3==null){this.createChildren();_3=this.body}
if(this.isDirty()||_3.isDirty()){this.redraw("updating HTML for printing")}
var _4=isc.addProperties({},_1,this.printProperties);var _5,_6;if(isc.isA.ResultSet(this.data)&&!this.data.allMatchingRowsCached()){var _7=this.body.getVisibleRows(),_8=_7?_7[0]:null,_9=this.data.getCachedRange(_8);if(_9!=null){_5=_9[0];_6=_9[1]}}
var _10=isc.Canvas.applyStretchResizePolicy(this.fields.getProperty("width"),_4.width||isc.Page.getWidth());var _11=_6!=null?(_6-_5):this.getTotalRows(),_12=this.printMaxRows;if(_12<_11){if(_5==null)_5=0;if(_6==null)_6=this.getTotalRows();this.getPrintHTMLChunk({startRow:_5,endRow:_6,maxRows:_12,callback:_2,printWidths:_10,printProps:_4});return null}
var _13=this.$569(_10,_4);var _14=_3.getTableHTML(null,_5,_6);this.$57a(_13);return _14}
,isc.A.$569=function(_1,_2){this.isPrinting=this.body.isPrinting=true;this.currentPrintProperties=_2;var _3=this.body,_4=this.$30a;var _5=isc.getProperties(_3,["autoFit","wrapCells","showAllRows","showAllColumns","fixedRowHeights","$26a","fields"]);_3.showAllRows=true;_3.showAllColumns=true;this.$30a=false;_3.autoFit=this.printAutoFit;_3.wrapCells=this.printWrapCells;_3.fixedRowHeights=!this.printWrapCells;var _6=this.fields.duplicate();_6.removeAll(_6.findAll("shouldPrint",false));_3.fields=_6;_3.$26a=_1;return{oldEditorShowing:_4,origProps:_5}}
,isc.A.$57a=function(_1){var _2=this.body,_3=_1.origProps,_4=_1.oldEditorShowing;isc.addProperties(_2,_3);if(_3.showAllRows==null)_2.showAllRows=null;this.$30a=_4;delete this.currentPrintProperties;this.isPrinting=this.body.isPrinting=false}
,isc.A.getPrintHTMLChunk=function(_1){var _2=this.$569(_1.printWidths);this.body.$568=true;var _3=_1.startRow,_4=_1.endRow,_5=_1.maxRows,_6=_1.callback;this.currentPrintProperties=_1.printProps;if(!_1.html)_1.html=[];var _7=Math.min(_4,(_3+_5)),_8=this.body.getTableHTML(null,_3,_7);_1.html.add(_8);this.$57a(_2);this.body.$568=false;if(_7<_4){_1.startRow=_7;return this.delayCall("getPrintHTMLChunk",[_1],0)}
if(_6){var _9=_1.html.join(isc.emptyString);this.fireCallback(_6,"HTML,callback",[_9,_6])}}
,isc.A.rowClick=function(_1,_2,_3,_4){this.$31q=_2;var _1=this.getCellRecord(_2,_3),_5=this.fields[_3];if(Array.isLoading(_1))return;var _6=this.getCellValue(_1,_2,_3);var _7=this.getRawCellValue(_1,_2,_3);if(_1!=null&&_1.$52e){var _8=this,_9=_1;if(this.getEditRow()!=null)this.saveAllEdits(null,function(){_8.toggleFolder(_9)});else this.toggleFolder(_1);return}
if(_5.recordClick){isc.Func.replaceWithMethod(_5,"recordClick","viewer,record,recordNum,field,fieldNum,value,rawValue");var _10=_5.recordClick(this,_1,_2,_5,_3,_6,_7);if(_10==false)return false}
if(this.recordClick){var _10=this.recordClick(this,_1,_2,_5,_3,_6,_7);if(_10==false)return false}
var _11=this.isEditable()&&(this.editEvent==isc.EH.CLICK||this.editOnFocus);if(_5.canToggle&&this.canEditCell(_2,_3)&&this.shouldToggle(_5)){var _12=this.getEditorValueMap(_5,this.getEditedRecord(_2,_3));if(_12==null&&isc.SimpleType.getBaseType(_5.type)==this.$g2){_12=[true,false]}
if(_12!=null){if(!isc.isAn.Array(_12))_12=isc.getKeys(_12);if(_12.length>1){var _13=this.getFieldName(_3),_14=this.getEditedCell(_2,_3),_15=_12.indexOf(_14);_15+=1;if(_15>=_12.length)_15=0;_14=_12[_15];if(!_11&&this.autoSaveEdits){this.setEditValue(_2,_3,_14,true,false);this.saveEdits(null,null,_2,_3)}else{this.setEditValue(_2,_3,_14)}}}}
if(_11){if(this.handleEditCellEvent(_2,_3,isc.ListGrid.CLICK)==true){return true}
if(_4){for(var i=0;i<this.fields.length;i++){if(i==_3)continue;if(this.handleEditCellEvent(_2,i,isc.ListGrid.CLICK)==true){return true}}}}}
,isc.A.shouldToggle=function(_1){if(!this.$31s(_1))return true;var _2=this.getEventPart();return(_2&&_2.part=="valueicon")}
,isc.A.rowDoubleClick=function(_1,_2,_3,_4){var _5=this.fields[_3],_6=this.getCellValue(_1,_2,_3),_7=this.getRawCellValue(_1,_2,_3);if(_1!=null&&_1.$52e)return;if(_5.recordDoubleClick){isc.Func.replaceWithMethod(_5,"recordDoubleClick","viewer,record,recordNum,field,fieldNum,value,rawValue");var _8=_5.recordDoubleClick(this,_1,_2,_5,_3,_6,_7);if(_8==false)return _8}
if(this.recordDoubleClick!=null){var _8=this.recordDoubleClick(this,_1,_2,_5,_3,_6,_7);if(_8==false)return _8}
if(this.isEditable()&&this.editEvent==isc.EH.DOUBLE_CLICK){if(this.handleEditCellEvent(_2,_3,isc.ListGrid.DOUBLE_CLICK)==true)return true;if(_4){for(var i=0;i<this.fields.length;i++){if(i==_3)continue;if(this.handleEditCellEvent(_2,i,isc.ListGrid.DOUBLE_CLICK)==true)return true}}}}
,isc.A.click=function(){return isc.EH.STOP_BUBBLING}
,isc.A.doubleClick=function(){return isc.EH.STOP_BUBBLING}
,isc.A.$298=function(_1,_2,_3){this.cellContextItems=null;if(this.cellContextClick){var _1=this.getCellRecord(_2,_3);if(this.cellContextClick(_1,_2,_3)==false)return false}
if(this.showCellContextMenus){if(!this.cellContextMenu)this.cellContextMenu=isc.Menu.create(this.contextMenuProperties);if(!this.cellContextItems){this.cellContextItems=this.makeCellContextItems(this.getCellRecord(_2,_3),_2,_3)}
if(isc.isAn.Array(this.cellContextItems)&&this.cellContextItems.length>0){this.cellContextMenu.setData(this.cellContextItems);this.cellContextMenu.showContextMenu(this)}
return false}else{return true}}
,isc.A.getShowChildDataSourceContextMenuItemTitle=function(_1){return"Show "+_1.getPluralTitle()}
,isc.A.makeCellContextItems=function(_1,_2,_3){if(this.dataSource!=null){var _4=[];if(this.canOpenRecordDetailGrid){var _5=isc.DS.get(this.getRecordDataSource(_1)),_6=_5.getChildDataSources();if(_6!=null){for(var i=0;i<_6.length;i++){var _8=_6[i];_4.add({title:this.getShowChildDataSourceContextMenuItemTitle(_8),record:_1,dataSource:_8,click:"target.openRecordDetailGrid(item.record, item.dataSource)"})}}}
if(this.canOpenRecordEditor){_4.add({title:this.openRecordEditorContextMenuItemTitle,record:_1,click:"target.endEditing();target.openRecordEditor(item.record)"})}
if(_1!=null&&this.$32o==_1){_4.add({title:this.dismissEmbeddedComponentContextMenuItemTitle,click:"target.closeRecord()"})}
_4.add({title:this.deleteRecordContextMenuItemTitle,click:"target.removeSelectedData()"});return(_4.length>0?_4:null)}
return null}
,isc.A.getCanHover=function(){if(this.canHover!=null)return this.canHover;var _1=this.getFields();if(_1!=null){for(var i=0;i<_1.length;i++){if(_1[i].showHover)return true}}
return this.canHover}
,isc.A.cellHoverHTML=function(_1,_2,_3){if(this.$30a&&this.getEditRow()==_2&&(!this.editByCell||this.getEditCol()==_3))return null;var _4=this.getField(_3);if(_4.showHover==false)return null;if(_4.showHover==null&&!this.canHover)return null;var _5=this.getCellValue(_1,_2,_3);if(_4.hoverHTML){isc.Func.replaceWithMethod(_4,"hoverHTML","record,value,rowNum,colNum,grid");return _4.hoverHTML(_1,_5,_2,_3,this)}
if(_5!=null&&!isc.isAn.emptyString(_5)&&_5!=this.emptyCellValue){return _5}}
,isc.A.bodyKeyPress=function(_1,_2){if(this.data.getLength()>0){var _3=isc.EventHandler,_4=_1.keyName;var _5=this.editOnKeyPress&&this.isEditable();if(_5&&this.$51j(_1,_2))return false;if(_4==this.$20s){return this.$318(-1)}else if(_4==this.$20t){return this.$318(1)}else if(_4==this.$304){if(this.generateClickOnSpace)
if(this.$240()==false)return false;if(this.generateDoubleClickOnSpace)
return this.$241()}else if(_4==this.$10j){if(this.generateClickOnEnter)
if(this.$240()==false)return false;if(this.generateDoubleClickOnEnter)
return this.$241()}}
return true}
,isc.A.$51j=function(_1,_2){var _3=_2.keyName,_4=isc.EH.getKeyEventCharacter(_1);if(_3!=this.$51g&&_3!=this.$51i&&_3!=this.$51h&&(_3==this.$20w||isc.EH.$i8[_3]||_4==null||_4==isc.emptyString))
{return false}
var _5=this.getFocusCell(),_6=_5[0]||0,_7=_5[1]||0;if(this.$30a)return false;var _8;if(_3==this.$10j||_3==this.$51g)_4=null;var _9;if(_4!=null){if(_3==this.$51i||_3==this.$51h){_9=null}else if(this.autoSelectEditors){_9=_4}else{_9=this.getEditedCell(_6,_7)+_4}
this.$51m=true}
return this.handleEditCellEvent(_5[0],_5[1],this.$51l,_9)}
,isc.A.getArrowKeyAction=function(){var _1=this.arrowKeyAction;if(_1==this.$27r)return this.$27r;if(isc.EH.ctrlKeyDown())return this.$305;return _1}
,isc.A.$318=function(_1){var _2=this.getArrowKeyAction();if(_2==this.$27r)return true;if(_1==null)_1=1;var _3;_3=this.getFocusRow(_1>0);if(_3==null)_3=this.$31q;if(isc.isA.Number(_3))_3+=_1;else _3=0;var _4=_3,_5=this.getTotalRows()-1;if(_3<0||_3>_5){if(_5<0)return true;_3=_4}
while(!this.recordIsEnabled(_3,0)){_3+=_1;if(_3<0||_3>_5){_3=_4;break}}
if(isc.screenReader){var _6=this.body.getTableElement(_3);_6.focus()}
if(_2==this.$305)this.$88(_3);else if(_2==this.$12b)this.$319(_3);else if(_2==this.$306)this.$32a(_3);this.scrollRecordIntoView(_3)
return false}
,isc.A.$32b=function(){var _1=this.keyboardClickField;if(_1==null)return 0;if(isc.isA.Number(_1)&&_1>0&&_1<this.fields.length)return _1;var _2=this.fields.find(this.fieldIdProperty,_1),_3=(_2?this.fields.indexOf(_2):0);return _3}
,isc.A.$319=function(_1){this.clearLastHilite();if(isc.isAn.Object(_1))_1=this.getRecordIndex(_1);if(!isc.isA.Number(_1)||_1<0)_1=0;if(_1>=this.data.getLength())_1=this.data.getLength()-1;this.body.$31p=_1;var _2=this.$32b();var _3=(this.body.selectionEnabled()&&this.recordIsEnabled(_1,_2));if(_3)this.selection.selectOnMouseDown(this,_1,_2);this.rowClick(this.getCellRecord(_1,_2),_1,_2,true);if(_3)this.selection.selectOnMouseUp(this,_1,_2);return false}
,isc.A.getFocusRow=function(_1){if(this.body.$31p!=null&&((this.body.$31p==this.body.lastOverRow)||(this.body.$31p==this.$31q)))
{return this.body.$31p}
delete this.body.$31p;var _2=this.getSelection();if(_2.length==0)return null;_2=_2[(_1?_2.length-1:0)]
return this.getRecordIndex(_2)}
,isc.A.getFocusCell=function(){return[this.getFocusRow(),this.$32b()]}
,isc.A.$240=function(){var _1=this.getFocusRow();if(_1!=null){this.$319(_1);return false}
return true}
,isc.A.$32a=function(_1){var _2=this.$32b();this.rowDoubleClick(this.getCellRecord(_1,_2),_1,_2,true)}
,isc.A.$241=function(){var _1=this.$32b(),_2=this.getFocusRow();if(_2!=null){this.$32a(_2);return false}
return true}
,isc.A.scrollRecordToTop=function(_1){return this.scrollRecordIntoView(_1,false)}
,isc.A.scrollRecordIntoView=function(_1,_2){return this.scrollCellIntoView(_1,null,_2)}
,isc.A.scrollColumnIntoView=function(_1,_2){return this.scrollCellIntoView(null,_1,_2)}
,isc.A.scrollCellIntoView=function(_1,_2,_3){if(!this.body||!this.body.isDrawn()){this.logInfo("scrollCellIntoView() called before the body has been drawn.  Cell "+_1+","+_2+" will scrolled into view on draw().");this.$30d=[_1,_2];return}
if(_3==null)_3=true;var x,y,_6,_7,_8=this.body;if(_1!=null){if(!_8.$60s){y=_8.getRowTop(_1);_7=_8.getRowSize(_1)}else{var _9=_8.$252==null||_1<_8.$252||_1>_8.$253,_10=!_9;if(_10){var _11=_8.getRowTop(_1),_12=_8.getRowHeight?_8.getRowHeight(this.getCellRecord(_1),_1):_8.cellHeight,_13=_8.getScrollTop();if(_13>_11||((_8.getViewportHeight()+_13)<(_11+_12)))
{_10=false}}
if(!_10){_8.$27y=_1;if(_3){_8.$27z=-1*((_8.getViewportHeight()/2)-_8.cellHeight)}else{_8.$27z=0}
_8.$270()}
return}}
if(_2!=null){x=this.getColumnLeft(_2);_6=this.getColumnWidth(_2)}
if(this.isDirty()||this.body.isDirty()){var _14;if(_1!=null){var _15=_8.getScrollHeight();if(y+_7>_15)_14=true}
if(!_14&&_2!=null){var _16=_8.getScrollWidth();if(x+_6>_16)_14=true}
if(_14)this.redraw("scrollIntoView")}
_8.scrollIntoView(x,y,_6,_7,(_3?"center":"left"),(_3?"center":"top"))}
,isc.A.bodyScrolled=function(_1,_2,_3){for(var i=0;i<this.bodies.length;i++){if(this.bodies[i]!=_3)this.bodies[i].scrollTo(null,_2,null,true)}
this.syncHeaderScrolling(_1,_2);this.syncFilterEditorScrolling(_1,_2);if(this.$30a&&this.$519){var _5=this.getEditForm(),_6=this.getEditRow(),_7=this.getEditCol(),_8=_5.getItem(this.getEditorName(_6,_7));if(_8){if(!_8.hasFocus&&(_5.hasFocus||isc.EH.getFocusCanvas()==null))
{this.$518(_7)}else{delete this.$519}}}}
,isc.A.syncHeaderScrolling=function(_1,_2){if(_1!=null&&this.header){if(!this.isRTL()){if(_1!=this.header.getScrollLeft())this.header.scrollTo(_1)}else{var _3=this.header,_4=this.body,_5=_3.getScrollWidth()-_3.getViewportWidth(),_6=_5-_3.getScrollLeft(),_7=_4.getScrollWidth()-_4.getViewportWidth(),_8=_7-_1;if(_8!=_6){_3.scrollTo(_5-_8)}}}}
,isc.A.headerScrolled=function(){if(!this.$32c){this.$32c=this.delayCall("syncBodyScrolling")}}
,isc.A.syncBodyScrolling=function(){delete this.$32c;var _1=this.header.getScrollLeft();if(this.body){if(!this.isRTL()){if(_1!=this.body.getScrollLeft())this.body.scrollTo(_1)}else{var _2=this.header,_3=this.body,_4=_2.getScrollWidth()-_2.getViewportWidth(),_5=_4-_2.getScrollLeft(),_6=_3.getScrollWidth()-_3.getViewportWidth(),_7=_6-_1;if(_7!=_5){_3.scrollTo(_6-_5)}}}}
,isc.A.syncFilterEditorScrolling=function(_1,_2){if(this.filterEditor!=null&&this.filterEditor.body!=null&&this.filterEditor.body.getScrollLeft()!=_1)
{this.filterEditor.body.scrollTo(_1)}}
,isc.A.$88=function(_1){if(!isc.isA.Number(_1)){_1=this.getRecordIndex(_1)}
if(!isc.isA.Number(_1)||_1<0)_1=0;if(_1>=this.data.getLength())_1=this.data.getLength()-1;this.clearLastHilite();this.body.$31p=_1;this.body.lastOverRow=_1;this.body.lastOverCol=0;this.bodies.map("setRowStyle",_1)}
,isc.A.clearLastHilite=function(){if(!this.body)return;this.body.$31p=null;var _1=this.body.lastOverRow;if(isc.isA.Number(_1)){delete this.body.lastOverRow;if(this.showRollOver)this.body.updateRollOver(_1)}}
,isc.A.$vk=function(_1,_2,_3,_4){this.invokeSuper(isc.ListGrid,"$vk",_1,_2,_3,_4);if(this.header!=null&&this.canTabToHeader)this.header.$vk(_1,false);if(this.body!=null)this.body.$vk(_1,false)}
,isc.A.setAccessKey=function(_1){this.Super("setAccessKey",arguments)
if(this.body!=null)this.body.setAccessKey(_1)}
,isc.A.setFocus=function(_1){if(this.body!=null)this.body.setFocus(_1)}
,isc.A.$kk=function(){if(this.body)return this.body.$kk();return false}
,isc.A.recordClick=function(){}
,isc.A.recordDoubleClick=function(){}
,isc.A.setShowFilterEditor=function(_1){if(this.showFilterEditor==_1)return;this.showFilterEditor=_1;if(_1){if(this.isDrawn())this.makeFilterEditor()}else if(this.filterEditor){this.filterEditor.destroy();this.filterEditor=null}
if(this.isDrawn()){this.clear();this.draw()}}
,isc.A.makeFilterEditor=function(){this.filterEditor=isc.RecordEditor.create({autoDraw:false,top:this.getTop()+this.getTopMargin(),left:this.getLeft()+this.getLeftMargin(),height:this.filterEditorHeight,sourceWidget:this,ID:this.getID()+"filterEditor",actionType:"filter",destroy:function(){this.sourceWidget.$wj(this,isc.Canvas.TOP);this.Super("destroy",arguments)},fetchDelay:this.fetchDelay},this.filterEditorDefaults,this.filterEditorProperties);this.addPeer(this.filterEditor);this.filterEditor.moveAbove(this);this.$wi(this.filterEditor,isc.Canvas.TOP)}
,isc.A.getFilterEditorValueMap=function(_1){return _1.filterEditorValueMap||_1.valueMap}
,isc.A.getFilterEditorType=function(_1){if(_1.filterEditorType!=null)return _1.filterEditorType;return this.getEditorType(isc.addProperties({},_1,this.getFilterEditorProperties(_1)))}
,isc.A.getFilterEditorProperties=function(_1){return _1.filterEditorProperties}
,isc.A.getFilterEditor=function(){return this.filterEditor}
,isc.A.setFilterValues=function(_1){this.$32d=_1||{};this.updateFilterEditorValues()}
,isc.A.updateFilterEditorValues=function(){var _1=this.filterEditor;if(!_1)return;var _2=this.$32e();this.filterEditor.setEditValues(0,_2)}
,isc.A.$32e=function(){var _1=this.$32d,_2={};if(_1==null){_2={};for(var i=0;i<this.completeFields.length;i++){_2[this.completeFields[i].name]=this.completeFields[i].defaultFilterValue}}else{for(var i=0;i<this.completeFields.length;i++){var _4=this.completeFields[i].name;_2[_4]=_1[_4]}}
return _2}
,isc.A.clearFilterValues=function(){this.$32d=null;this.updateFilterEditorValues()}
,isc.A.canEditCell=function(_1,_2){if(_2<0||_2>=this.fields.length)return false;var _3=this.getCellRecord(_1,_2);if(_3!=null){if(!this.recordIsEnabled(_1,_2))return false;if(this.$32o==_3)return false}
if(this.getField(_2).disabled)return false;if(!this.isEditable()||this.getCellBooleanProperty("canEdit",_1,_2,(_3!=null?this.recordEditProperty:null))==false){return false}
return true}
,isc.A.isEditable=function(){if(this.canEdit==false)return false;if(this.canEdit==true||this.canEdit==this.$18q){var _1=this.getFields();for(var i=0;i<_1.length;i++){if(_1[i].canEdit!=false)return true}
return false}else{var _1=this.getFields();for(var i=0;i<_1.length;i++){if(_1[i].canEdit==true)return true}
return false}}
,isc.A.setCanEdit=function(_1){if(_1==false){if(this.getEditRow()!=null)this.cancelEditing(isc.ListGrid.PROGRAMMATIC);this.canEdit=false}else{this.canEdit=_1}}
,isc.A.setFieldCanEdit=function(_1,_2){if(isc.isA.String(_1))_1=this.getField(_1);if(_1==null||!this.completeFields.contains(_1)||_1.canEdit==_2)return;_1.canEdit=_2;if(this.$30a){var _3=this.getEditRow(),_4=_1[this.fieldIdProperty],_5=this.getColNum(_1);if(this.editByCell){if(!_2&&_5==this.getEditCol()){this.cancelEditing(isc.ListGrid.PROGRAMMATIC)}}else if(_5>=0){if(!_2&&_5==this.getEditCol()){var _6=this.$286.getItem(_4),_7=_6.hasFocus;var _8=this.findNextEditCell(_3,_5,-1,true,false,false,true);if(_8==null||_8[0]!=_3)
_8=this.findNextEditCell(_3,_5,1,true,false,false,true);if(_8==null||_8[0]!=_3){this.cancelEditing(isc.ListGrid.PROGRAMMATIC);return}
this.startEditing(_8[0],_8[1],!_7)}
this.refreshCell(this.getEditRow(),_5)}}}
,isc.A.handleEditCellEvent=function(_1,_2,_3,_4){if(_3==this.$51l)this.$51k=true;else delete this.$51k
if(_1<0||_2<0)return false;if(this.editByCell){if(!this.canEditCell(_1,_2))return false}else{var _5=this.findNextEditCell(_1,_2,-1,true,true,false,true);if(_5==null||_5[0]!=_1)
_5=this.findNextEditCell(_1,_2,1,true,false,false,true);if(_5==null||_5[0]!=_1)return false;_2=_5[1]}
var _6;if(_4!==_6){this.setEditValue(_1,_2,_4)}
return this.startEditing(_1,_2,null,_3)}
,isc.A.startEditing=function(_1,_2,_3,_4){if(!this.canEdit&&!(this.completeFields||this.fields).getProperty("canEdit").or()){this.canEdit=true}
if(this.completeFields==null)this.setFields(this.fields);var _5=(_1==null),_6=(_2==null);if(_5||_6){var _7=(_5?0:_1),_8=(_6?0:_2);var _9=this.findNextEditCell(_7,_8,1,_6,true);if(_9==null){this.logInfo("startEditing() passed bad cell coordinates:"+[_1,_2])}else{this.logInfo("startEditing() using derived coordinates:"+_9);_1=_9[0];_2=_9[1]}}
if(_1==null||_1<0||_1>this.getTotalRows()){this.logWarn("startEditing() passed bad cell coordinates:"+[_1,_2]+", can't edit","gridEdit");return false}
if(!this.canEditCell(_1,_2)){this.logInfo("startEditing(): cell "+[_1,_2]+" is non editable. Returning.","gridEdit");return false}
if(this.$30a){this.$32f((_4||isc.ListGrid.PROGRAMMATIC),this.getEditRow(),this.getEditCol(),_1,_2)}else{this.$31u(_1,_2,_3)}
return true}
,isc.A.$32f=function(_1,_2,_3,_4,_5){var _6=this.getEditValue(_2,_3);var _7=this.getFieldName(_3),_8=this.$286,_9=_8?_8.getItem(_7):null,_10=_9?!_9.$30w:true;if(_9){delete _9.$30w;delete _9.$30v;if(this.$32g(_9,_2,_4,_5)){this.$32h(_9,_3)}}
var _11=(_4!=_2),_12=this.$300(_2,_3);if(_10){var _13=!this.$32i(_1,_2,_3,_6);if(_11&&!_13){_13=!this.$32j(_1,_2,_12)}
if(_13){if(_1==isc.ListGrid.EDIT_FIELD_CHANGE){var _14=this.getFieldName(_5);if(_9&&_8.getItem(_14).hasFocus){_9.focusInItem()}}
return false}}
var _15=(this.autoSaveEdits&&((_11&&this.shouldSaveOnRowExit(_2,_3,_1))||this.shouldSaveOnCellExit(_2,_3,_1)));if(!_15&&this.$32k()){var _16,_17=_11&&this.shouldValidateByRow(_2,_3,_1);if(_17&&!this.usingCellRecords){_16=!this.validateRow(_2)}else{if(_17||this.shouldValidateByCell(_2,_3,_1))
{_16=!this.validateCell(_2,_3)}}
if(this.stopOnErrors&&_16)return false}
if(_15){return this.$32l(_4,_5,_1)}else{this.$31u(_4,_5)}}
,isc.A.$32g=function(_1,_2,_3,_4){if(!isc.Browser.isIE)return false;var _5=(isc.isA.PopUpTextAreaItem(_1)&&_1.$32m&&_1.$21t.hasFocus)||(_1.hasFocus&&isc.FormItem.$12r(_1));if(!this.editByCell&&_3==_2)return false;var _6=this.getEditorType(this.getField(_4),this.getCellRecord(_3,_4));return!(_6==null||isc.FormItem.$12r(_6,true))}
,isc.A.$31u=function(_1,_2,_3){if(_1=="delayed"){var _4=this.$32n;if(_4==null)return;_1=_4[0];_2=_4[1]}else if(this.isDrawn()&&(!this.body.readyToRedraw()||(this.frozenBody&&!this.frozenBody.readyToRedraw())))
{if(!this.$32n){this.delayCall("$31u",['delayed'],0)}
this.$32n=[_1,_2];return}
delete this.$32n;var _5=this.getEditRow()!=_1;if(!_5&&(this.getEditCol()==_2)){this.getEditForm().focusInItem(this.getEditorName(_1,_2));return}
this.logInfo("Starting editing at row "+_1+", colNum "+_2,"gridEdit");if(this.$32o!=null)this.closeRecord();if(this.$30a){if(this.editByCell||_5){this.hideInlineEditor(false,true)}}
var _6=(this.$32p==null)||_5||this.saveByCell;if(_6){this.$32p=this.$32q()}
var _7=this.$30a&&(this.getEditRow()==_1)
this.initializeEditValues(_1,_2,_7);var _8=this.getCellRecord(_1,_2);if(this.selectOnEdit&&_8!=null)this.selectRecordForEdit(_8);if(_8==null&&this.addNewBeforeEditing){this.$285=_1;this.$30u=_2;var _9=this.shouldWaitForSave();var _10="this.$32r("+_9+","+_3+")";this.saveEdits(isc.ListGrid.PROGRAMMATIC,_10);if(_9)return;else{_1=this.$285;_2=this.$30u}}
this.showInlineEditor(_1,_2,true,_5,_3);return true}
,isc.A.selectRecordForEdit=function(_1){if(!this.editByCell)_1.$29m=true;if(this.canSelectCells){var _2=this.getRecordCellIndex(_1);this.selection.selectSingleCell(_2[0],_2[1])}else{this.selection.selectSingle(_1)}
delete _1.$29m}
,isc.A.$51n=function(_1){if(!isc.isA.TextItem(_1)&&!isc.isA.TextAreaItem(_1)&&!(isc.isA.DateItem(_1)&&_1.useTextField))return;var _2=isc.isA.DateItem(_1)?_1.dateTextField.getDataElement():_1.getDataElement();if(!_2)return;if(this.$51m||!this.autoSelectEditors){var _3=_1.getDataElement().value||"";_1.setSelectionRange(_3.length,_3.length);delete this.$51m}else{_2.select()}}
,isc.A.$32r=function(_1,_2){var _3=this.$285,_4=this.$30u,_5=this.getCellRecord(_3,_4);if(_5!=null&&_5!="loading"){var _6=this.getEditValues(_3,_4);for(var i in _5){if(_5[i]!=null&&_6[i]==null){_6[i]=_5[i]}}}
if(_1)this.showInlineEditor(_3,_4,true,true,_2);else this.updateEditRow(_3)}
,isc.A.editField=function(_1,_2){if(this.completeFields==null)this.setFields(this.fields);var _3;if(isc.isA.Number(_1))_3=_1;else _3=this.fields.findIndex(this.fieldIdProperty,_1);if(_2==null){_2=this.getEditRow();if(_2==null){this.logWarn("editField(): unable to determine which row to edit - returning.","gridEdit");return}}
return this.startEditing(_2,_3)}
,isc.A.showInlineEditor=function(_1,_2,_3,_4,_5){if(this.$30a){if(_1!=this.getEditRow()||(this.editByCell&&_2!=this.getEditCol())){this.logWarn("Unexpected call to 'showInlineEditor' during another edit "+"- cancelling previous edit","gridEdit");this.cancelEditing();this.startEditing(_1,_2);return}}
this.logDebug("showing inline editor at: "+[_1,_2]+", will focus: "+!_5,"gridEdit");var _6=this.body&&(!this.body.showAllColumns||!this.body.showAllRows);if(_6){var _7=this.body.scrollRedrawDelay;this.body.scrollRedrawDelay=0;this.scrollCellIntoView(_1,_2,false);this.body.scrollRedrawDelay=_7}
if(this.rollOverCanvas&&this.rollOverCanvas.$289==_1){this.updateRollOverCanvas(this.rollOverCanvas.$289,this.rollOverCanvas.$57n,true)}
if(!this.$30a){this.makeEditForm(_1,_2)}
this.$285=_1;this.$30u=_2;this.$32s(_1,_2);if(this.body){var _8;if(!_6)_8=true;else{var _9=this.body,_10=_9.getRowTop(_1),_11=_9.getRowSize(_1),_12=_9.getScrollTop(),_13=_9.getViewportHeight();_8=(_10<_12)||(_10+_11>_12+_13)}
if(_8)this.scrollCellIntoView(_1,_2,false)}
if(!this.isDrawn())return;this.$32t();var _14=this.getEditorName(_1,_2),_15=this.$286.getItem(_14);if(_15==null){this.logWarn("ListGrid showing inline editor. Unable to get a pointer to the edit "+"form item for field:"+_14);return}
if(_3)_15.$30w=true;if(_4)_15.$30v=true;if(!_5){if(isc.Browser.isMoz){var _16=this.body.getClipHandle(),_17=_16.scrollTop}
var _18=isc.EH.lastEvent;var _19=(isc.Browser.isIE&&_18.eventType==isc.EH.MOUSE_DOWN&&_18.target!=this.$286);if(isc.Browser.isIE){var _20=isc.ListGrid.$32u;if(_20&&(_20.hasFocus||_20.itemHasFocus()))_19=true}
if(_19){this.$32v=isc.Timer.setTimeout(this.$286.getID()+".focusInItem('"+_14+"');",0)}else{if(isc.Browser.isMoz&&this.body.overflow==isc.Canvas.VISIBLE){this.adjustOverflow()}
this.$286.focusInItem(_14)}}}
);isc.evalBoundary;isc.B.push(isc.A.$32s=function(_1,_2){var _3=this.$30a;this.$30a=true;if(!this.isDrawn()||!this.body)return;var _4=this.isEmpty()||(!_3&&(_1>=this.data.getLength())&&(this.showNewRecordRow||(this.body.getTableElement(_1,_2)==null)));if(_4||this.body.isDirty()||(this.frozenBody&&this.frozenBody.isDirty())){var _5=this.bodyLayout?this.bodyLayout:this.body;_5.redraw("Showing editor");return}
if(this.editByCell){this.refreshCell(_1,_2)}else{var _6=this.getDrawnFields();for(var i=0;i<_6.length;i++){if(this.isCheckboxField(_6[i]))continue;var _8=_6[i][this.fieldIdProperty],_9=this.$286.getItem(_8),_2=_9.colNum,_10=!!(_3&&_9.isDrawn()),_11=this.canEditCell(_1,i);if(_10!=_11)this.refreshCell(_1,_2);else if(this.selectOnEdit||this.lastOverRow){this.body.$29h(this.getCellRecord(_1,_2),_1,_2)}}}}
,isc.A.$32t=function(){if(!this.modalEditing){if(this.canHover)this.stopHover();return}
if(!this.$286.clickMaskUp()){if(!this.$32w)
this.$32w=new Function(this.getID()+".$32x()");this.$286.showClickMask(this.$32w,(this.stopOnErrors?isc.EH.SOFT_CANCEL:isc.EH.SOFT),this.$286)}}
,isc.A.shouldWaitForSave=function(){if(this.stopOnErrors&&!this.waitForSave){var _1="Note: ListGrid initialized with 'waitForSave' false, and 'stopOnErrors' true."+" In this case user input will be be blocked during save, to allow server side "+" errors to be determined before the editor is hidden. Setting 'waitForSave' to true.";if(this.waitForSave==false)this.logWarn(_1,"gridEdit");else this.logInfo(_1,"gridEdit");this.waitForSave=true}
return!!(this.waitForSave||this.stopOnErrors)}
,isc.A.hideInlineEditor=function(_1,_2){_1=_1&&(this.hasFocus||this.body.hasFocus||(this.getEditForm()&&this.getEditForm().hasFocus)||(isc.ListGrid.$32u&&isc.ListGrid.$32u.hasFocus));if(!this.$30a)return false;this.$30a=null;this.$519=null;var _3=this.$285,_4=this.$30u;this.$285=this.$30u=null;if(!_2)this.$286.hideClickMask();if(this.getEditValues(_3,_4)!=null&&(!this.$31o||!this.$31o[this.getEditValuesID(_3,_4)])&&!this.recordHasChanges(_3,_4,false))
{this.logInfo("hideInlineEditor for row with no edits - dropping edit values","gridEdit");this.$321(_3,_4)}
if(!this.body)return true;var _5=this.$286;if(_5.hasFocus){_5.blur()}
if(isc.Browser.isIE){var _6=_5.getFocusItem(),_7=isc.EH.$ld;if(_5.hasFocus||(_7&&((_7==_5)||(isc.EH.$ld.form==_5))))
{_6.elementBlur();this.$32h(_6,_4)}}
if(!this.body.isDirty()&&(!this.bodyLayout||!this.bodyLayout.isDirty())&&!this.isDirty())
{if(_3>=this.getTotalRows()){var _8=this.bodyLayout||this.body;_8.markForRedraw("Editor Hidden")}else{if(this.editByCell)this.refreshCell(_3,_4)
else this.refreshRow(_3)}}
if(_1){this.$30c=true;this.body.focus()}
return true}
,isc.A.$32h=function(_1,_2){if(isc.isA.TextItem(_1)||isc.isA.TextAreaItem(_1)||isc.isA.PopUpTextAreaItem(_1))
{var _3=isc.ListGrid.$32u;if(!_3){_3=isc.ListGrid.$32u=isc.DynamicForm.create({pointersToThis:[{object:isc.ListGrid,property:"$32u"}],getFocusParkItem:function(){return this.getItem(0)},autoDraw:false,$nu:false,ID:"$322",_generated:true,selectOnFocus:true,tabIndex:-1,items:[{name:"textItem",type:"text",handleKeyPress:function(){return false}}],width:1,height:1,overflow:isc.Canvas.HIDDEN,itemHasFocus:function(){var _4=this.getFocusParkItem();if(_4.hasFocus)return true;if(isc.Browser.isIE&&this.isDrawn()&&this.isVisible()&&(this.getActiveElement()==this.getFocusParkItem().getFocusElement()))
return true;return false},redraw:function(){var _5=false;if(this.itemHasFocus())_5=true;this.Super("redraw",arguments);if(_5)this.focusInItem(this.getFocusParkItem())}})}
if(_3.parentElement!=this){if(_3.isVisible())_3.hide();this.addChild(_3)}
_3.moveTo(this.getColumnLeft(_2)-this.body.getScrollLeft(),Math.min(((this.showHeader?this.headerHeight:0)+this.getRowTop(this.getEditRow())
-this.body.getScrollTop()),this.getScrollHeight()-1));_3.moveBelow(this.body);_3.show();if(this.$286.clickMaskUp())_3.unmask(this.$286.getID());_3.getFocusParkItem().focusInItem();_1.form.hasFocus=false}}
,isc.A.makeEditForm=function(_1,_2){var _3=this.getCellRecord(_1,_2),_4=this.getEditRowItems(_3,_1,_2,this.editByCell),_5=this.getEditDisplayValues(_1,_2);if(this.$286!=null){this.$286.setItems(_4);this.$286.setValues(_5)}else{this.$286=isc.DynamicForm.create(this.editFormDefaults,{grid:this,locatorParent:this,showErrorIcons:this.showErrorIcons,tabIndex:this.getTabIndex(),dataSource:this.dataSource,autoComplete:this.autoComplete,uniqueMatch:this.uniqueMatch,autoFocus:false,items:_4,values:_5})}
if(this.logIsDebugEnabled()){this.logDebug("editRowForm created with values: "+this.echo(this.$286.getValues()),"gridEdit")}}
,isc.A.getEditForm=function(){return this.$286}
,isc.A.getEditFormItem=function(_1){var _2=this.getEditForm();if(!_2)return null;var _3=this.getEditorName(this.getEditRow(),_1),_4=_2.getItem(_3);if(_4&&_4.colNum==_1)return _4}
,isc.A.getEditFormValue=function(_1){var _2=this.getEditFormItem(_1);return(_2?_2.getValue():null)}
,isc.A.$33g=function(){if(!this.$286)return;var _1=this.getEditRow(),_2=this.getEditCol(),_3=this.getEditDisplayValues(_1,_2);this.$286.setValues(_3)}
,isc.A.getEditDisplayValues=function(_1,_2){var _3=this.getEditValues(_1,_2),_4=this.getCellRecord(_1,_2),_5={};for(var _6 in _4){_5[_6]=_4[_6]}
for(var _6 in _3){_5[_6]=_3[_6]}
return _5}
,isc.A.getEditFormItemFieldWidths=function(_1){var _2=[];for(var i=0;i<this.fields.length;i++){var _4=this.getLocalFieldNum(i),_5=this.fields[i],_6=_5.frozen?this.frozenBody:this.body;_2[i]=_6.getInnerColumnWidth(_4)}
return _2}
,isc.A.getEditorValueMap=function(_1,_2){return _1.editorValueMap||_1.valueMap}
,isc.A.getEditorValueIcons=function(_1,_2){return _1.editorValueIcons||_1.valueIcons}
,isc.A.getEditorValueIconWidth=function(_1){if(_1.editorValueIconWidth!=null)return _1.editorValueIconWidth;return(_1.valueIconWidth!=null?_1.valueIconWidth:_1.valueIconSize)}
,isc.A.getEditorValueIconHeight=function(_1){if(_1.editorValueIconHeight!=null)return _1.editorValueIconHeight;return _1.valueIconHeight!=null?_1.valueIconHeight:_1.valueIconSize}
,isc.A.setEditorValueMap=function(_1,_2){var _3=this.getColNum(_1),_4=this.getField(_1),_5=_4[this.fieldIdProperty];_4.editorValueMap=_2;if(this.$30a){var _6=this.getEditRow(),_7=this.getEditedRecord(_6,_3);this.$286.setValueMap(_5,this.getEditorValueMap(_4,_7))}}
,isc.A.getEditorType=function(_1,_2){var _3=isc.addProperties({},_1,_1.editorProperties);return isc.DynamicForm.getEditorType(_3,this)}
,isc.A.getEditorProperties=function(_1){return isc.addProperties({},this.editorProperties,_1.editorProperties)}
,isc.A.getEditRowItems=function(_1,_2,_3,_4){var _5=this.body;if(_5==null)return[];var _6,_7,_8=[],_9=[];var _10=this.getEditedRecord(_2,_3);var _11;if(_4)_11=[this.getField(_3)]
else _11=this.getDrawnFields();_8=this.getDrawnFieldWidths(_1,_11);for(var i=0;i<_11.length;i++){var _13=this.getColNum(_11[i]);var _14=this.getEditItem(_11[i],_1,_10,_2,_13,_8[i])
if(_14==null)continue;_9[_9.length]=_14}
return _9}
,isc.A.getDrawnFields=function(){if(!this.body)return null;var _1=[],_2=this.body;var _3=this.frozenFields,_4=this.freezeLeft();if(_3&&_4){_1.addList(_3)}
var _5,_6;if((_2.$254==null)||_2.isDirty()||_2.$58p){var _7=_2.getDrawArea();_5=_7[2];_6=_7[3]}else{_5=_2.$254;_6=_2.$255}
if(_3&&_4){_5+=_3.length;_6+=_3.length}
for(var i=_5;i<=_6;i++){_1.add(this.fields[i])}
if(_3&&!_4){_1.addList(_3)}
return _1}
,isc.A.getDrawnFieldWidths=function(_1,_2){if(!_2)_2=this.getDrawnFields();if(!_2)return null;var _3=this.getEditFormItemFieldWidths(_1),_4=[];for(var i=0;i<_2.length;i++){_4[i]=_3[_2[i].masterIndex]}
return _4}
,isc.A.$323=function(_1,_2,_3){return this.grid.editorKeyPress(this,_2,_3)}
,isc.A.$54z=function(_1,_2,_3){return this.grid.editorKeyDown(this,_2,_3)}
,isc.A.$62k=function(){var _1=this.form,_2=this.grid,_3,_4,_5,_6;if(_2.$30a){_3=_2.$285;if(!_2.editByCell){_3=_2.$285;_5=this.getFieldName(),_4=_2.fields.findIndex(_2.fieldIdProperty,_5);_6=(_2.$30u!=_4);if(_6){_2.setNewEditCell(_3,_4);_2.cellEditEnd(isc.ListGrid.EDIT_FIELD_CHANGE)}}}}
,isc.A.$324=function(){var _1=this.grid,_2=this.getFieldName(),_3=_1.getEditRow(),_4=_1.getCellStyle(_1.getRecord(_3),_3,_1.getColNum(_2)),_5=_1.getRowPageTop(_3)+isc.Element.$tn(_4)+isc.Element.$tt(_4);return _5}
,isc.A.$581=function(_1,_2,_3,_4){if(!this.hasFocus){var _5=this.grid;_5.setNewEditCell(this.rowNum,this.colNum);_5.cellEditEnd(isc.ListGrid.EDIT_FIELD_CHANGE);this.$30w=true}
return this.invokeSuper("CheckboxItem","handleClick",_1,_2,_3,_4)}
,isc.A.handleEditorChanged=function(_1){var _2=_1.getFieldName(),_3=this.getField(_2),_4;if(_3&&_3.validateOnChange!=null)_4=_3.validateOnChange;else _4=this.validateOnChange;if(_4){var _5=this.getEditRow();this.validateCell(_5,_2)}}
,isc.A.$325=function(_1,_2,_3,_4){this.invokeSuper(this.getClassName(),"handleChanged",_1,_2,_3,_4);if(!this.destroyed)this.grid.handleEditorChanged(this)}
,isc.A.$45p=function(){var _1=this.grid;if(!_1)return null;var _2=_1.getField(this.getFieldName());if(_2.autoComplete!=null)return _2.autoComplete;if(_1.autoComplete!=null)return _1.autoComplete;return this.Super("$17h",arguments)}
,isc.A.getEditItem=function(_1,_2,_3,_4,_5,_6){var _7={};var _8=this.getEditorName(_4,_1);_7[this.fieldIdProperty]=_8;_7.$17h=this.$45p;_7.autoCompleteCandidates=_1.autoCompleteCandidates;_7.uniqueMatch=_1.uniqueMatch;_7.containerWidget=_1.frozen?this.frozenBody:this.body;_7.width=_6;_7.textAlign=(_1.cellAlign||_1.align);_7.record=_2;_7.rowNum=_4;_7.colNum=_5;_7.grid=this;_7.handleChanged=this.$325;_7.valueMap=this.getEditorValueMap(_1,_3);if(_1.valueField!=null)_7.valueField=_1.valueField
if(_1.displayField!=null)_7.displayField=_1.displayField
if(_1.optionDataSource)_7.optionDataSource=_1.optionDataSource
_7.valueIcons=this.getEditorValueIcons(_1,_3);var _9=this.getEditorValueIconWidth(_1),_10=this.getEditorValueIconHeight(_1);if(_9)_7.valueIconWidth=_9;if(_10)_7.valueIconHeight=_10;_7.imageURLPrefix=(_1.editorImageURLPrefix||_1.imageURLPrefix);_7.imageURLSuffix=(_1.editorimageURLSuffix||_1.imageURLSuffix);_7.baseURL=_1.baseURL;_7.imgDir=_1.imgDir;var _11;if(_1.icons!==_11)_7.icons=_1.icons;if(_1.showPickerIcon!==_11)_7.showPickerIcon=_1.showPickerIcon;if(_1.pickerIconSrc!==_11)_7.pickerIconSrc=_1.pickerIconSrc;if(_1.pickerIconWidth!==_11)_7.pickerIconWidth=_1.pickerIconWidth;if(_1.pickerIconHeight!==_11)_7.pickerIconHeight=_1.pickerIconHeight;if(_1.defaultIconSrc!==_11)_7.defaultIconSrc=_1.defaultIconSrc;var _12=(_1.editorIconHeight||_1.iconHeight);if(_12!==_11)_7.iconHeight=_12
var _13=(_1.editorIconWidth||_1.iconWidth);if(_13!==_11)_7.iconWidth=_13;if(_1.iconPrompt!==_11)_7.iconPrompt=_1.iconPrompt;if(_1.iconHSpace!==_11)_7.iconHSpace=_1.iconHSpace;if(_1.iconVAlign!==_11)_7.iconVAlign=_1.iconVAlign;if(this.showValueIconOnly(_1)){if(_1.editorProperties==null)_1.editorProperties={};_1.editorProperties.showValueIconOnly=true}
if(_1.pickListWidth!=null)_7.pickListWidth=_1.pickListWidth;if(_1.pickListFields!=null)_7.pickListFields=_1.pickListFields;_7.keyDown=function(_7,_24,_25){return this.form.grid.editorKeyDown(_7,_25)}
if(_1.editorProperties!=null){for(var i=0;i<this.$31c.length;i++){var _15=this.$31c[i],_16=_1.editorProperties[_15];if(_16!=null&&!isc.isA.Function(_16)){var _17=isc.FormItem._stringMethodRegistry;_1.editorProperties[_15]=_16=isc.Func.expressionToFunction(_17[_15],_16)}
if(_16!=null)_1.editorProperties[_15]=_16}}
for(var i=0;i<this.$45k.length;i++){var _15=this.$45k[i];if(_1.editorProperties&&_1.editorProperties[_15]!=null){continue}
var _16=_1[_15];if(_16!=null){if(_1.editorProperties==null)_1.editorProperties={};if(!isc.isA.Function(_16)){var _17=isc.FormItem._stringMethodRegistry;_16=isc.Func.expressionToFunction(_17[_15],_16)}
_1.editorProperties[_15]=_16}}
_7.valueIconLeftPadding=this.getValueIconLeftPadding(_1);_7.valueIconRightPadding=this.getValueIconRightPadding(_1);_7.editorType=this.getEditorType(_1,_2);var _18=_7.editorType;if(this.$308[_18]||(_1.type==this.$g4&&_18==null)){_7.editorType=this.$g4;_7.useTextField=true;_7.cellPadding=0;_7.itemCellStyle=null;_7.pickerIconHSpace=0;var _19=this.$45i(_1);if(_19)_7.displayFormat=_19;var _20=this.$45j(_1);if(_20)_7.inputFormat=_20}
if(this.$307[_18]||(_1.type==this.$g5&&_18==null)){var _19=this.$30o(_1);if(_19)_7.displayFormat=_19}
if(this.$309[_18]){_7.getTextBoxStyle=function(){var _21=this.grid,_2=_21.getCellRecord(this.rowNum,this.colNum);this.textBoxStyle=_21.getCellStyle(_2,this.rowNum,this.colNum);return this.Super("getTextBoxStyle",arguments)}
_7.gridCellStyleChanged=function(_2,_4,_5,_24){var _22=this.$15h();if(_22){_22.className=this.textBoxStyle=_24}}
_7.textBoxCellCSS=isc.Canvas.$42a
_7.textAreaKeyDown=this.$54z;_7.textAreaKeyPress=this.$323;_7.getTextAreaTop=this.$324;if(_7.popUpOnEnter==null)_7.popUpOnEnter=true;_7.textAreaFocus=this.$62k}
if(this.$31a[_18]||(_1.type==this.$g2&&_18==null)){if(_7.showLabel==null)_7.showLabel=false;if(_7.handleClick==null){_7.handleClick=this.$581}}
_7.elementFocus=this.$30t;_7.canTabToIcons=false;_7.focusInItem=this.$51o;var _23=this.getEditorProperties(_1,_2);isc.addProperties(_7,_23);return _7}
,isc.A.$51o=function(){this.Super("focusInItem",arguments);this.grid.$51n(this)}
,isc.A.getEditorName=function(_1,_2){if(isc.isA.Number(_2))_2=this.getField(_2);return _2?_2[this.fieldIdProperty]:null}
,isc.A.refreshCell=function(_1,_2,_3,_4){if(_1==null){isc.logWarn('ListGrid.refreshCell(): first parameter rowNum not present, returning');return}
if(!this.isDrawn()||!this.body)return;var _5=this.getFieldBody(_2);if(_5.isDirty()){this.logDebug("refresh cell redrawing body","gridEdit");_5.redraw("refresh cell");return false}
var _6=this.getLocalFieldNum(_2);_5.refreshCellStyle(_1,_6);if(!_5.shouldRefreshCellHTML()){this.refreshCellValue(_1,_2,_3,_4)}}
,isc.A.refreshCellValue=function(_1,_2,_3,_4){if(!this.isDrawn()||!this.body)return;var _5=this.getFieldBody(_2),_6=this.getLocalFieldNum(_2);if(!_5.$29l(_1,_6)){this.delayCall("refreshCellValue",[_1,_2,_3,_4]);return}
var _7=this.getEditorName(_1,_2),_8=this.getFieldName(_2),_9=this.$286,_10,_11=false,_12,_13;if(_9){var _10=_9.getItem(_7),_14=(this.$30a&&_1==this.getEditRow());if(_10&&_10.colNum!=_2)_10=null;if(_14){_12=(_10&&_10.isDrawn());_13=this.canEditCell(_1,_2);if(_10!=null&&_9.hasFocus){var _15=_9.getFocusItem();_11=(_15==_10||(_10.items&&_10.items.contains(_15)))}}else if(_10&&_10.rowNum==_1){_13=false;_12=_10.isDrawn()}}
if(!_4&&(_11&&_12&&_13))
{return}
if(_12){this.getUpdatedEditorValue();if(_10!=null){if(_11){if(_13){_9.$106()}
else _10.blurItem()}
if(_13)_10.redrawing()}}
_5.refreshCellValue(_1,_6);if(_10&&(_12||_13)){this.$30b(_10,null,_5);if(_13){_10.setValue(this.getEditDisplayValue(_1,_2));if(_11){_9.$11b(_10)}}}}
,isc.A.refreshRow=function(_1){if(!this.body||!this.isDrawn())return;var _2=this.frozenFields&&this.frozenFields.length>0;if(_2&&!this.frozenBody)_2=false;var _3=false;if(this.body.isDirty())_3=true;if(_2&&!_3){if(this.frozenBody.isDirty()||this.bodyLayout.isDirty())_3=true}
if(_3){var _4=_2?this.bodyLayout:this.body;return _4.redraw("refresh row")}
if(this.$30a&&this.$286!=null){this.logInfo("refresh row: "+_1,"gridEdit")}
if(_2){for(var i=0;i<this.frozenFields.length;i++){this.refreshCell(_1,this.getFieldNum(this.frozenFields[i]),true)}}
var _6=this.body.$254,_7=this.body.$255;for(var i=_6;i<=_7;i++){var _8=this.getFieldNumFromLocal(i,this.body);this.refreshCell(_1,_8,true)}}
,isc.A.startEditingNew=function(_1,_2){if(!this.canEdit&&!(this.completeFields||this.fields).getProperty("canEdit").or()){this.canEdit=true}
if(isc.isAn.Array(this.data)&&this.data.length==0&&this.dataSource&&!this.saveLocally)
{this.fetchData(null,null,{$326:true});this.data.setFullLength(0)}
var _3=this.body?this.body.getTotalRows():this.getTotalRows();if(this.showNewRecordRow)_3-=1;var _4=this.findNextEditCell(_3,0,1,true,true,true);if(_4==null){this.logInfo("startEditingNew() failed to find any editable fields in this grid.","gridEdit");return}
if(_1!=null)this.setEditValues(_4,isc.addProperties({},_1),true);this.startEditing(_4[0],_4[1],_2)}
,isc.A.updateEditRow=function(_1){if(this.$285!=_1||!this.$286){return}
this.$286.setItemValues();delete this.$286.$10u;this.$286.$327=false}
,isc.A.shouldFixRowHeight=function(_1,_2){if(this.canEdit!=false&&this.$30a&&_2==this.$285){return false}
return this.fixedRecordHeights}
,isc.A.$32q=function(){if(this.$328==null)this.$328=isc.timeStamp();return this.$328++}
,isc.A.$32x=function(){var _1=this.getEditRow();this.cellEditEnd(isc.ListGrid.CLICK_OUTSIDE)}
,isc.A.getEditDisplayValue=function(_1,_2,_3){var _4;if(_3===_4)_3=this.getCellRecord(_1,_2);var _5=this.$30y(_1,_2);if(_5===_4&&_3!=null){_5=this.getRawCellValue(_3,_1,_2)}
_5=this.$329(_5,_3,_1,_2);return _5}
,isc.A.$329=function(_1,_2,_3,_4){if(_2==null)_2=this.$300(_3,_4);var _5=this.fields[_4];if(_5&&_5.$65!=null){_1=_5.$62.editFormatter(_1,_5,this,_2)}else if(_5&&_5.formatEditorValue!=null){isc.Func.replaceWithMethod(_5,"formatEditorValue","value,record,rowNum,colNum,grid");_1=_5.formatEditorValue(_1,_2,_3,_4,this)}else if(this.formatEditorValue!=null){_1=this.formatEditorValue(_1,_2,_3,_4)}
return _1}
,isc.A.getEditValuesID=function(_1){if(_1==null||this.$52b==null)return null;if(isc.isA.String(_1)&&this.$52b[_1]!=null)return _1;if(isc.isA.Number(_1))return this.$33a[_1];for(var i in this.$52b){var _3=this.$52b[i];if(_3==_1)return i;if(this.comparePrimaryKeys(this.$52b[i].$33b,_1)){return i}}
return null}
,isc.A.getEditSession=function(_1,_2){if(this.$52b==null)return null;if(!isc.isA.String(_1))_1=this.getEditValuesID(_1,_2);return this.$52b[_1]}
,isc.A.getEditSessionRowNum=function(_1){_1=this.getEditSession(_1);return(_1!=null?_1.$24t:null)}
,isc.A.getEditSessionColNum=function(_1){_1=this.getEditSession(_1);return(_1!=null?_1.$24u:null)}
,isc.A.getAllEditRows=function(_1){return this.getAllEditCells(_1,true)}
,isc.A.getAllEditCells=function(_1,_2){var _3=this.$52b,_4=[];if(!_3)return _4;if(_1)return isc.getKeys(this.$52b);for(var i in _3){var _6=_3[i].$24t;_6=parseInt(_6);if(_6==null||_6<0||isNaN(_6))continue;if(_2)_4[_4.length]=_6
else{var _7=_3[i].$24u;if(_7==null){_7=this.$30a&&(_6==this.getEditRow())?this.getEditCol():this.getRowEditColNum(_6)}
if(_7!=null&&!isc.isA.Number(_7))_7=parseInt(_7);_4[_4.length]=[_6,_7]}}
return _4}
,isc.A.getEditValues=function(_1,_2){if(_1==null)return this.logWarn("getEditValues() called with no valuesID");if(_2==null&&isc.isA.Array(_1)){_2=_1[1];_1=_1[0]}
var _3=(isc.isA.Number(_1)?_1:this.getEditSessionRowNum(_1));if(this.$30a&&(this.getEditRow()==_3)){this.storeUpdatedEditorValue()}
return this.$300(_1,_2)}
,isc.A.$300=function(_1,_2){var _3=this.getEditSession(_1,_2);return _3!=null?_3.$31x:null}
,isc.A.getEditedRecord=function(_1,_2,_3){if(_1==null)return this.logWarn("getEditedRecord() called with no valuesID");if(!isc.isA.Number(_1)){_1=this.getEditSessionRowNum(_1);_2=this.getEditSessionColNum(_1)}
var _4=this.getCellRecord(_1,_2),_5=_3?this.$300(_1,_2):this.getEditValues(_1,_2);return isc.addProperties({},_4,_5)}
,isc.A.getEditedCell=function(_1,_2){if(_1==null||_2==null)
return this.logWarn("getEditedCell() called with no record / field parameter");var _3=this.getEditValues(_1,_2),_4=isc.isA.Number(_1)?_1:this.getEditSessionRowNum(_1),_5=isc.isA.Number(_2)?_2:this.getFieldNum(_2),_1=this.getCellRecord(_4,_5);var _6=this.getEditorName(_4,this.getField(_5))
var _7;if(_3&&_3[_6]!==_7)return _3[_6];return _1?_1[_6]:null}
,isc.A.rememberSubmittedEditValues=function(_1,_2){var _3=this.getEditSession(_1);if(_3!=null){_3.$33e=isc.addProperties({},_3.$31x)}}
,isc.A.getSubmittedEditValues=function(_1,_2){var _3=this.getEditSession(_1,_2);return _3!=null?_3.$33e:null}
,isc.A.clearSubmittedEditValues=function(_1,_2){var _3=this.getEditSession(_1);if(_3==null)return;var _4=_3.$33e;if(!_4)return;for(var _5 in _2){if(_4[_5]==_2[_5])delete _4[_5]}
if(isc.isA.emptyObject(_4))_3.$33e=null}
,isc.A.createEditValues=function(_1){var _2=this.body.getTotalRows();this.setEditValues(_2,_1);return this.getEditValuesID(_2)}
,isc.A.initializeEditValues=function(_1,_2,_3){if(this.$300(_1,_2)==null){this.setEditValues([_1,_2],{},_3)}}
,isc.A.setEditValues=function(_1,_2,_3){var _4;if(isc.isAn.Array(_1)){_4=_1[1];_1=_1[0]}
if(!isc.isA.Number(_1)){this.logWarn("setEditValues() called with bad rowNum: "+this.echo(_1));return}
if(_2==null)_2={};var _5,_6,_7=true;if(!_3){var _8=this.getCellRecord(_1,_4);if(_8==null)_8={};else _7=false;_5=this.getEditValues(_1,_4);if(_5!=null)_7=false;_6=isc.addProperties({},_5);for(var i in _6){_6[i]=_8[i]}
isc.addProperties(_6,_2)}
if(this.logIsInfoEnabled("gridEdit")){_5=_5||this.getEditValues(_1,_4);if(!_5){this.logInfo("establishing new edit session at row: "+_1+(_4!=null?", col:"+_4:"")+(this.logIsDebugEnabled("gridEdit")?" with values: "+this.echo(_2):""),"gridEdit")}}
this.$33f(_1,_4,_2);if(_3||!this.isDrawn()||!this.body)return;var _10=(_7||this.body.isDirty());if(_10){var _11=this.isEditingRecord(_1,_4)&&this.$286!=null
if(_11)this.$33g();this.body.markForRedraw()}else{this.$50r(_1,_4,_6)}}
,isc.A.$50r=function(_1,_2,_3,_4){if(!_3){return}
var _5=this.isEditingRecord(_1,_2)&&this.$286!=null
for(var _6 in _3){var _7;if(_5){this.$286.setValue(_6,_3[_6]);var _8=this.$286.getItem(_6),_2=this.getFieldNum(_6);_7=(_2>=0&&_8&&this.canEditCell(_1,_2))}
var _9=_2;if(_2==null)_9=this.getColNum(_6);if(!_7){if(_9>=0)this.refreshCell(_1,_9)}else if(_4&&_4[_6]){this.showCellErrors(_1,_9)}}}
,isc.A.$33f=function(_1,_2,_3,_4){var _5=this.getCellRecord(_1,_2);var _6=this.getEditSession(_1,_2)||this.createEditSession(_1,_2,_5,_4);if(this.dataSource!=null){if(_5=="loading"){_6.$33i=true}else if(_5!=null){var _7=this.getDataSource(),_8=_7.getPrimaryKeyFieldNames();for(var i=0;i<_8.length;i++){_3[_8[i]]=_5[_8[i]]}}}
if(_5==null){_6.$33i=true;var _10=this.completeFields||this.fields||[],_11;for(var i=0;i<_10.length;i++){var _12=_10[i],_13=_12[this.fieldIdProperty];if(_3[_13]===_11){if(_12.defaultValue!=null){_3[_13]=_12.defaultValue}else if(this.enumCriteriaAsInitialValues&&_12.type=="enum"&&this.$32d!=null&&this.$32d[_13]!=null)
{_3[_13]=this.$32d[_13]}}}}
for(var i in _6.$31x){delete _6.$31x[i]}
for(var i in _3){_6.$31x[i]=_3[i]}
if(this.$33j==null||_1>=this.$33j){this.$33j=_1}}
,isc.A.createEditSession=function(_1,_2,_3,_4){var _5={};if(_3!=null&&_3!="loading")
_5.$33b=this.getPrimaryKeys(_3);_5.$24t=_1;if(this.useCellRecords){_5.$24u=_2;if(this.getCellFacetValues)_5.$507=this.getCellFacetValues(_1,_2)}
_5.$31x={};if(this.$52b==null)this.$52b={};if(_4==null){if(this.$33k==null)this.$33k=0;_4="_"+this.$33k++}
this.$52b[_4]=_5;if(this.$33a==null)this.$33a={};this.$33a[_1]=_4;return _5}
,isc.A.setEditValue=function(_1,_2,_3,_4,_5){var _6=isc.isA.String(_2)?_2:this.getEditorName(_1,_2);if(isc.isA.String(_2))_2=this.getFieldNum(_2);var _7=this.$33l(_1,_2,_6,_3,_5);if(!_7)return;var _8=this.getField(_6);if(_8&&this.$425(_8)){var _9;var _10=this.getEditForm();if(_10&&this.getEditRow()==_1&&this.fieldValuesAreEqual(_8,_10.getValue(_6),_3))
{_9=_10.getValue(_8.displayField)}
if(_9==null){var _11=this.data;if(isc.ResultSet&&isc.isA.ResultSet(_11))_11=_11.localData;if(_11){var _12=_11.find(_6,_3);_9=(_12?_12[_8.displayField]:_3)}else{_9=_3}}
this.setEditValue(_1,_8.displayField,_9,_4,true)}
if(_4)return;this.setRowEditFieldName(_1,_6);if(!isc.isA.Number(_1)){_2=this.getEditSessionColNum(_1);_1=this.getEditSessionRowNum(_1)}else if(!isc.isA.Number(_2)){_2=this.getFieldNum(_2)}
var _13={};_13[_6]=_3;this.$50r(_1,_2,_13)}
,isc.A.$33l=function(_1,_2,_3,_4,_5){var _6=true,_7=false,_8,_9,_10,_11;_8=this.getEditSession(_1,_2)
if(_8!=null){_9=_8.$31x;_10=_9[_3]}else{this.logInfo("creating new edit values for row: "+_1,"gridEdit");this.initializeEditValues(_1,_2,true);_8=this.getEditSession(_1,_2);_9=_8.$31x}
if(_10===_11){var _12=this.getCellRecord(_1,_2);_10=_12?_12[_3]:null}else _7=true;var _13=this.getField(_3);if(this.fieldValuesAreEqual(_13,_10,_4))_6=false;if(_4===_11)delete _9[_3];else if(_7||_6)_9[_3]=_4;if(_6&&!_5){this.$33m(_1,_2,_4,_10)}
return _6}
,isc.A.setRowEditFieldName=function(_1,_2){var _3=this.getEditSession(_1);if(!_3){var _4=this.getColNum(_2);this.setEditValues([_1,_4],null,true);_3=this.getEditSession(_1)}
if(isc.isA.Number(_2))_2=this.getFieldName(_2);_3.$33n=_2}
,isc.A.getRowEditFieldName=function(_1){var _2=this.getEditSession(_1);return(_2?_2.$33n:null)}
,isc.A.getRowEditColNum=function(_1){var _2=this.getRowEditFieldName(_1);return _2?this.getColNum(_2):null}
,isc.A.getEditValue=function(_1,_2){var _3=_2
if(isc.isA.String(_2))_2=this.getColNum(_2);if(this.$30a&&(this.getEditRow()==_1)&&(this.getEditCol()==_2))
{this.storeUpdatedEditorValue()}
return this.$30y(_1,_3)}
,isc.A.$30y=function(_1,_2){var _3=this.$300(_1,_2);if(_3==null)return;if(!isc.isA.String(_2))_2=this.getEditorName(_1,_2);return _3[_2]}
,isc.A.clearEditValue=function(_1,_2,_3,_4){var _5=(isc.isA.Number(_1)?_1:this.getEditSessionRowNum(_1));var _6=_2;if(isc.isA.Number(_6))_6==this.getEditorName(_5,_6);if(this.$30a){if(this.getEditRow()==_5&&this.getEditFieldName()==_6){this.storeUpdatedEditorValue(true)}}
var _7=this.getEditSession(_1,_2);if(_7==null)return;var _8=_7.$31x,_9=false,_10=_7.$33e,_11=_7.$33o,_12=_11&&_11[_6],_5=_7.$24t;if(_8!=null){var _13=this.getRecord(_5);_9=isc.propertyDefined(_8,_6)&&((_5==null||_13==null)||!this.fieldValuesAreEqual(this.getField(_6),_8[_6],_13[_6]));delete _8[_6];if(_10)delete _10[_6];if(_11!=null)delete _11[_6];if(!_4&&isc.isAn.emptyObject(_8)){this.logDebug("no edit values left for row, discarding editSession","gridEdit");return this.$321(_1,_2,_3)}}
var _14=this.getField(_6);if(_14&&this.$425(_14)&&(_14.displayField!=_6)){this.clearEditValue(_1,_14.displayField,_3,_4)}
if(_3||_5==null)return;var _2=this.getColNum(_6);if(_9){var _15;if(this.$30a&&this.getEditRow()==_5){var _16=_13?_13[_6]:null;this.$286.setValue(_6,_16);_15=_2>=0&&this.canEditCell(_5,_2)&&this.$286.getItem(_6)}
if(_2>=0&&!_15)this.refreshCell(_5,_2)}else if(_12&&_2>=0){if(_12)this.showCellErrors(_5,_2)}}
,isc.A.$321=function(_1,_2,_3){if(_1==null){return}
if(!isc.isA.String(_1))_1=this.getEditValuesID(_1,_2);var _4=this.getEditSession(_1);if(_4==null)return;var _5=_4.$24t;if(_5!=null)delete this.$33a[_5];if(_2==null)_2=_4.$24u;var _6=this.$52b[_1];delete this.$52b[_1];var _7=this.$34e();delete this.$33j;if(_5!=null&&_4.$33i){var _8=this.getEditRow();for(var i=_5+1;i<=_7;i++){var _10=this.getEditSession(i);var _11=_10.$24t;_10.$24t=i-1;this.$33a[i-1]=this.$33a[i];delete this.$33a[i]}
if(_8!=null&&_8>_5)this.$285-=1;if(!_3){if(this.$30a){if(_5==_8)this.hideInlineEditor();else{if(_5<_8)this.$50s(_8-1,null,"Earlier temp edit row removed")}}
this.body.markForRedraw("clear edit values, remove row")}}else if(_5!=null&&!_3){this.$50r(_5,_2,_6.$31x,_6.$33o)}}
,isc.A.newRecordForEditValues=function(_1,_2){var _3=this.getEditSession(_1),_4=_3.$31x;_3.$33b=this.getPrimaryKeys(_2);var _5=this.getDataSource().getPrimaryKeyFieldNames();for(var i=0;i<_5.length;i++){var _7=_5[i];_4[_7]=_2[_7]}
delete _3.$33i}
,isc.A.$31n=function(_1){delete this.$33j;delete this.$33q;if(this.$52b==null)return;var _2=this.getEditRow(),_3=this.getEditCol(),_4=false;var _5=this.data.getLength(),_6={};var _7=isc.getKeys(this.$52b);for(var i=0;i<_7.length;i++){var _9=_7[i],_10=this.$52b[_9];var _11=this.$52p(_10,_5);if(_10.$33b==null)_5++;if(_11==null)continue;var _12=_11[0],_13=_11[1];if(_12!=null&&_12>=0){if(_2!=null&&_2==_10.$24t&&(!this.useCellRecords||(_3==_10.$24u)))
{_4=true;if(!_1)this.$50s(_12,_13,"remapEditRows")}
_6[_12]=_9;_10.$24t=_12;if(this.useCellRecords)_10.$24u=_13}else{if(!this.dataSource||this.saveLocally||(isc.ResultSet&&isc.isA.ResultSet(this.data)&&this.data.allRowsCached()))
{this.logWarn("Record:"+this.echo(_10.$33b)+", is no longer present in this List.<br>Clearing edit values for this record.");delete this.$52b[this.getEditValuesID(_9)]}else{this.logWarn("Record:"+this.echo(_10.$33b)+", lost from local cache in paged result set. "+"Pending edits for this record will be maintained.");delete _10.$24t;delete _10.$24u;this.$33q=true}}}
this.$33a=_6;if(_2!=null&&!_4&&!_1){this.hideInlineEditor(true)}}
,isc.A.$52p=function(_1,_2){var _3,_4,_5=_1.$33b;if(_5==null){_3=_2}else{var _6=_1.$31x,_7=false,_8;if(_1.$33o!=null&&!isc.isA.emptyObject(_1._validationErrors_))
{_7=true}else{for(var _9 in _6){if(_6[_9]!=_5[_9]||_5[_9]===_8){_7=true;break}}}
if(!_7&&_1.$24t!=null&&!this.isEditingRecord(_1.$24t,_1.$24u))
{this.logInfo("dropping empty editSession","gridEdit");delete this.$52b[this.getEditValuesID(_1)];return null}
_3=this.findRowNum(_5,_1);_4=this.findColNum(_5,_1)}
return[_3,_4]}
,isc.A.$wo=function(_1,_2,_3,_4,_5){if(!_5&&this.confirmDiscardEdits&&this.dataSource!=null){if(this.hasChanges()&&!(isc.ResultSet&&isc.isA.ResultSet(this.data)&&this.data.compareCriteria(_2,this.data.getCriteria())==0))
{this.showLostEditsConfirmation({target:this,methodName:"$33r"},{target:this,methodName:"$33s"});this.$33t={type:_1,criteria:_2,callback:_3,requestProperties:_4}
return}}
this.setFilterValues(_2);return this.Super("$wo",[_1,_2,_3,_4],arguments)}
,isc.A.$33r=function(){var _1=this.$33t,_2=_1.type,_3=_1.criteria,_4=_1.callback,_5=_1.requestProperties;delete this.$33t;this.$wo(_2,_3,_4,_5,true)}
,isc.A.$33s=function(){delete this.$33t}
,isc.A.showLostEditsConfirmation=function(_1,_2){this.$33u=_1;this.$33v=_2;isc.confirm(this.confirmDiscardEditsMessage,"if(window[this.targetGridID])window[this.targetGridID].lostEditsCallback(value, this);",{targetGridID:this.getID(),buttons:[isc.Dialog.OK,{title:this.discardEditsSaveButtonTitle,width:75,click:"this.hide();this.topElement.returnValue('save');"},isc.Dialog.CANCEL]})}
,isc.A.lostEditsCallback=function(_1,_2){var _3=this.$33u,_4=this.$33v;delete this.$33u;delete this.$33v;if(_1==null){this.fireCallback(_4)}else if(_1==true){this.discardAllEdits();this.fireCallback(_3)}else if(_1=="save"){this.saveAllEdits(null,_3)}
_2.targetGrid=null}
,isc.A.findRowNum=function(_1){return this.data.indexOf(_1)}
,isc.A.findColNum=function(_1){return-1}
,isc.A.$50s=function(_1,_2,_3){if(!this.$30a||_1==this.$285)return;var _4=this.$285;this.logInfo(_3+": editSession: "+this.getEditValuesID(_1)+" with values: "+this.echo(this.$300(_1,_2))+" was being edited at row: "+_4+", will now edit at row: "+_1,"gridEdit");this.$285=_1;var _5=this.$286,_6=_5?_5.getItems():null;if(_6){for(var i=0;i<_6.length;i++){_6[i].rowNum=_1}}}
,isc.A.rowEditNotComplete=function(_1){return(this.$33a!=null&&this.$33a[_1]!=null)}
,isc.A.$33m=function(_1,_2,_3,_4){var _5=this.getCellRecord(_1,_2);if(this.editorChange!=null)this.editorChange(_5,_3,_4,_1,_2);var _6=this.getFieldName(_2);if(this.editValueChanged!=null)
this.editValueChanged(_1,_6,_3,_4);if(this.$30a&&this.isEditingRecord(_1,_2)&&this.fields!=null){_5=isc.addProperties({},this.$300(_1,_2),_5);var _7=!this.editByCell?this.fields:[this.getEditField()];for(var i=0;i<_7.length;i++){var _9=_7[i],_10=this.$286.getItem(_9[this.fieldIdProperty]);if(_10==null)continue;var _11=this.getEditorValueMap(_9,this.getEditedRecord(_1,_2,true));if(_10.valueMap!=_11)_10.setValueMap(_11)}}}
,isc.A.getEditRow=function(){return this.$285}
,isc.A.getEditCol=function(){return this.$30u}
,isc.A.getEditField=function(){return this.getField(this.getEditCol())}
,isc.A.getEditFieldName=function(){return this.getFieldName(this.getEditCol())}
,isc.A.getEditRecord=function(){return this.getCellRecord(this.getEditRow(),this.getEditCol())}
,isc.A.cancelEditing=function(_1){if(!this.$30a)return;if(_1==null)_1=isc.ListGrid.PROGRAMMATIC;this.$33w(this.$32p,_1)}
,isc.A.cellEditEnd=function(_1,_2){if(this.$51k&&_1!=isc.ListGrid.TAB_KEYPRESS&&_1!=isc.ListGrid.SHIFT_TAB_KEYPRESS&&_1!=isc.ListGrid.UP_ARROW_KEYPRESS&&_1!=isc.ListGrid.DOWN_ARROW_KEYPRESS&&_1!=isc.ListGrid.LEFT_ARROW_KEYPRESS&&_1!=isc.ListGrid.RIGHT_ARROW_KEYPRESS)delete this.$51k
var _3=this.getEditRow(),_4=this.getEditCol();if(arguments.length>=2){this.setEditValue(_3,_4,_2)}
var _5=this.getFieldName(_4),_6=this.shouldCancelEdit(_3,_4,_1);if(_6)return this.cancelEditing(_1);var _7=this.getNextEditCell(_3,_4,_1);this.clearNewEditCell();if(_7==null){this.logInfo("cellEditEnd: ending editing, completion event: "+_1,"gridEdit");this.$33x(_1);return}
if(Array.isLoading(this.getCellRecord(_7[0],_7[1]))){return false}
this.$32f(_1,_3,_4,_7[0],_7[1])}
,isc.A.getUpdatedEditorValue=function(){if(!this.$30a)return;var _1=this.$286.getItem(this.getEditFieldName()),_2=this.getEditField(),_3;if(_1){if(_1.$10v())_1.updateValue();_3=_1.getValue();return this.$33y(_3,_2,this.getEditRow(),this.getEditCol())}else{return this.getEditDisplayValue(this.getEditRow(),this.getEditCol())}}
,isc.A.storeUpdatedEditorValue=function(_1){if(!this.isDrawn()||!this.$30a)return;var _2=this.getEditRow(),_3=this.getEditCol(),_4=this.getField(_3),_5=this.$286,_6=this.getEditFormItem(_3),_7;if(_6){if(_6.$10v())_6.updateValue();_7=this.$33y(_6.getValue(),_4,_2,_3);this.setEditValue(_2,_3,_7,true,_1)}}
,isc.A.$32i=function(_1,_2,_3,_4){var _5=this.getCellRecord(_2,_3),_6=this.getField(_3),_7=this.getEditorName(_2,_6),_8=true;var _9=this.$286.getItem(_7);if(isc.isA.PopUpTextAreaItem(_9))_9.hidePopUp();if(_6&&_6.editorExit!=null){isc.Func.replaceWithMethod(_6,"editorExit","editCompletionEvent,record,newValue,rowNum,colNum,grid");_8=(_6.editorExit(_1,_5,_4,_2,_3,this)
!=false)}
if(_8&&this.editorExit!=null)
_8=this.editorExit(_1,_5,_4,_2,_3)!=false;return _8}
,isc.A.$32j=function(_1,_2,_3){var _4=this.getRecord(_2);if(this.rowEditorExit!=null)
return(this.rowEditorExit(_1,_4,_3,_2)!=false);return true}
,isc.A.$30x=function(_1,_2,_3,_4){var _5=this.getCellRecord(_2,_3),_6=this.getFieldName(_3),_7=this.getField(_3),_8=true;if(isc.isA.PopUpTextAreaItem(_1)&&_1.popUpOnEnter){_1.showPopUp(true)}
if(_7&&_7.editorEnter!=null){isc.Func.replaceWithMethod(_7,"editorEnter","record,value,rowNum,colNum,grid");_8=_7.editorEnter(_5,_4,_2,_3,this)!=false}
if(_8&&this.editorEnter!=null)
_8=this.editorEnter(_5,_4,_2,_3)!=false;return _8}
,isc.A.$30z=function(_1,_2,_3){var _4=this.getRecord(_2);if(this.rowEditorEnter!=null)
return this.rowEditorEnter(_4,_3,_2)!=false;return true}
);isc.evalBoundary;isc.B.push(isc.A.$32k=function(){if(!isc.DS)return false;var _1=isc.DS.get(this.dataSource);return!this.neverValidate&&!(_1&&_1.useLocalValidators!=null&&_1.useLocalValidators==false)}
,isc.A.shouldSaveOnCellExit=function(_1,_2){if(this.getCellRecord(_1,_2)==null)return false;return(this.saveByCell!=null?this.saveByCell:this.editByCell)}
,isc.A.shouldSaveOnRowExit=function(_1,_2,_3){return true}
,isc.A.shouldValidateByCell=function(_1,_2,_3){var _4=this.getField(_2);if(_4&&_4.validateByCell!=null)return _4.validateByCell;return(this.validateByCell!=null?this.validateByCell:this.editByCell)}
,isc.A.shouldValidateByRow=function(_1,_2,_3){return this.autoValidate}
,isc.A.shouldCancelEdit=function(_1,_2,_3){if(_3==isc.ListGrid.ESCAPE_KEYPRESS){var _4=this.getField(_2),_5=_4.escapeKeyEditAction||this.escapeKeyEditAction;if(_5=="cancel")return true}
return false}
,isc.A.$33w=function(_1,_2,_3){if(this.$32p!=_1)return;if(this.confirmCancelEditing){if(_3==null){var _4=this.getID()+".$33w('"+_1+"','"+_2+"',value);";isc.ask(this.cancelEditingConfirmationMessage,_4);var _5=isc.Dialog.Warn.toolbar.getButton(0);if(_5.isDrawn())_5.focus()
else isc.Timer.setTimeout({target:_5,methodName:"focus"},0);return}else if(_3==false)return}
var _6=this.getEditRow(),_7=this.getEditCol(),_8=this.getUpdatedEditorValue(),_9=this.getEditValues(_6,_7);if(!this.$32i(_2,_6,_7,_8)||!this.$32j(_2,_6,_9))
{return}
var _10,_11=[],_12=this.$285,_13=this.getEditValues(_12,_7),_14=this.body?this.body.getDrawArea():[null,null,1,0],_15=_14[2],_16=_14[3],_17;if(_13!=null){if(this.isNewEditRecord(_12,_7)){_10=true}else{for(var i=_15;i<=_16;i++){if(_13[this.getFieldName(i)]!==_17&&((this.editByCell&&this.$30u!=i)||!this.canEditCell(_12,i)))
{_11.add(i)}}}
this.$321(this.$285,_7,true)}
if(this.body){this.hideInlineEditor(true);if(this.isDrawn()){if(_10)this.body.markForRedraw("clearing extra edit row");else{for(var i=0;i<_11.length;i++){this.refreshCell(_12,_11[i])}}}}}
,isc.A.isNewEditRecord=function(_1){var _2=this.getEditSession(_1);return _2&&_2.$33i}
,isc.A.endEditing=function(){if(this.getEditRow()!=null)this.$33x(isc.ListGrid.PROGRAMMATIC)}
,isc.A.$33x=function(_1){var _2=this.getEditRow(),_3=this.getEditCol(),_4=this.getEditValue(_2,_3),_5=this.getEditValues(_2,_3);if(!this.$32i(_1,_2,_3,_4)||!this.$32j(_1,_2,_5))return;var _6=(this.autoSaveEdits&&this.shouldWaitForSave()),_7=(this.autoSaveEdits&&this.stopOnErrors),_8;if(_6)_8="if((success||!this.stopOnErrors)&&"+"(this.$32p=="+this.$32p+"))"+"this.hideInlineEditor(true);";var _9=_1==isc.ListGrid.ESCAPE_KEYPRESS;if(!_9&&this.autoSaveEdits){this.saveEdits(_1,_8)}else{var _10=this.getFieldName(_3);this.setEditValue(_2,_3,_4);var _11=!_9&&this.$32k()&&(this.shouldValidateByCell(_2,_3,_1)||this.shouldValidateByRow(_2,_3,_1));if(_11){var _12;if(this.useCellRecords){_12=!this.validateCell(_2,_3)}else{_12=!this.validateRow(_2)}
if(this.stopOnErrors&&_12)return false}
if(!this.rowHasChanges(_2,false)){this.logInfo("editor hiding at "+[_2,_3]+", no actual changes, dropping editSession","gridEdit");this.$321(_2,_3)}}
if(!_6)this.hideInlineEditor(true)}
,isc.A.saveAndEditNewCell=function(_1,_2,_3){if(_3==null)_3=isc.ListGrid.PROGRAMMATIC;this.$32l(_1,_2,_3)}
,isc.A.$32l=function(_1,_2,_3){var _4=this.shouldWaitForSave(),_5;if(_4){_5="if((success||!this.stopOnErrors)&&"+"(this.$32p=="+this.$32p+"))"+"this.$31u("+_1+","+_2+");"}
this.saveEdits(_3,_5);if(!_4){this.$31u(_1,_2)}}
,isc.A.$33z=function(_1,_2){var _3=this.getEditRow(),_4=this.getEditCol(),_5=isc.ListGrid.PROGRAMMATIC,_6=this.findNextEditCell(_3,_4,_1,_2,false);this.$32l(_6[0],_6[1],_5)}
,isc.A.saveAndEditNextCell=function(){this.$33z(1,true)}
,isc.A.saveAndEditPreviousCell=function(){this.$33z(-1,true)}
,isc.A.saveAndEditNextRow=function(){this.$33z(1,false)}
,isc.A.saveAndEditPreviousRow=function(){this.$33z(-1,false)}
,isc.A.getNextEditCell=function(_1,_2,_3){switch(_3){case isc.ListGrid.CLICK_OUTSIDE:case isc.ListGrid.ESCAPE_KEYPRESS:return null;case isc.ListGrid.ENTER_KEYPRESS:var _4=this.getField(_2),_5=_4.enterKeyEditAction||this.enterKeyEditAction;if(_5=="done")return null;else if(_5=="nextCell")
return this.findNextEditCell(_1,_2,1,true,false);else if(_5=="nextRow")
return this.findNextEditCell(_1,_2,1,false,false);else if(_5=="nextRowStart"){var _6=this.listEndEditAction;if(_1+1<this.getTotalRows()||_6=="next"){return this.findNextEditCell(_1+1,0,1,true,true)}else{if(_6=="stop")return[_1,_2];return null}}
case isc.ListGrid.EDIT_FIELD_CHANGE:case isc.ListGrid.PROGRAMMATIC:return this.getNewEditCell();case isc.ListGrid.UP_ARROW_KEYPRESS:return this.findNextEditCell(_1,_2,-1,false,false);case isc.ListGrid.DOWN_ARROW_KEYPRESS:return this.findNextEditCell(_1,_2,1,false,false);case isc.ListGrid.TAB_KEYPRESS:case isc.ListGrid.RIGHT_ARROW_KEYPRESS:var _4=this.getField(_2);if(_4.nextTabColNum!=null){return this.findNextEditCell(_1+1,_4.nextTabColNum,1,true,true)}else
return this.findNextEditCell(_1,_2,1,true,false);case isc.ListGrid.SHIFT_TAB_KEYPRESS:case isc.ListGrid.LEFT_ARROW_KEYPRESS:var _4=this.getField(_2)
if(_4.previousTabColNum!=null){return this.findNextEditCell(_1-1,_4.previousTabColNum,-1,true,true)}else
return this.findNextEditCell(_1,_2,-1,true,false)}
this.logWarn("getNextEditCell(): Passed unrecognized editCompletionEvent type:"+_3+", returning null");return null}
,isc.A.findNextEditCell=function(_1,_2,_3,_4,_5,_6,_7){var _8=_1,_9=_2,_10,_11=this.getFields().length;_10=(_7?_8:(this.listEndEditAction=="next"||_6)?this.getTotalRows():this.getTotalRows()-1);if(_8>this.getTotalRows())_10=_8;if((_5!=false||_3==0)&&_8<=_10&&_8>=0&&_9<_11&&_9>=0&&this.canEditCell(_8,_9)&&this.$60w(_8,_9))
{return[_8,_9]}
if(_3==0)return null;var _12=this.canEditCell(_8,_9)&&this.$60w(_8,_9),_13=_7?_8:0;if(_4){var _14=this.rowEndEditAction;while(_8<(_10+1)&&_8>=_13){_9+=_3;if(_14=="same"&&_2==_9){return _12?[_1,_2]:null}
if(_9<0||_9>=_11){if(_14=="done")return null;if(_14=="stop")return(_12?[_1,_2]:null)
else{_9=(_3>0?-1:_11);if(_14=="next")_8+=_3}}else if(this.canEditCell(_8,_9)&&this.$60w(_8,_9))
{return[_8,_9]}}
if(this.listEndEditAction=="stop"||(this.listEndEditAction=="next"&&_8<_13))
{if(_12)return[_1,_2];else return null}else{return null}}else{_8+=_3
while(_8>=_13&&_8<=_10){if(this.canEditCell(_8,_9)&&this.$60w(_8,_9)){return[_8,_9]}
_8+=_3}
if(this.listEndEditAction=="stop"||(this.listEndEditAction=="next"&&_8<_13))
{return _12?[_1,_2]:null}
return null}}
,isc.A.$60w=function(_1,_2){var _3=this.getFieldName(_2),_4=this.$286,_5=_4?_4.getItem(_3):null;if(_5)return _5.$kk();var _6=this.getField(_3);if(_6.canFocus!=null)return _6.canFocus;var _7=this.getEditorType(_6,this.getEditedRecord(_1));_7=isc.FormItemFactory.getItemClassName(_6,_7,null,true);var _8=_7=isc.FormItemFactory.getItemClass(_7);return _8?_8.getPrototype().$kk():false}
,isc.A.setNewEditCell=function(_1,_2){this.$330=[_1,_2]}
,isc.A.getNewEditCell=function(){if(this.canEditCell(this.$330[0],this.$330[1]))return this.$330;return null}
,isc.A.clearNewEditCell=function(){this.$330=null}
,isc.A.discardAllEdits=function(_1,_2){if(_1==null)_1=this.getAllEditRows(true);else{for(var i=0;i<_1.length;i++){if(isc.isA.Array(_1[i]))_1[i]=this.getEditValuesID(_1[i][0],_1[i][1]);if(isc.isA.Number(_1[i]))_1[i]=this.getEditValuesID(_1[i])}}
if(_1==null)return;for(var i=0;i<_1.length;i++)this.discardEdits(_1[i],null,_2)}
,isc.A.discardEdits=function(_1,_2,_3){if(_1==null)return;var _4;if(isc.isA.Number(_1)){_4=this.getEditValuesID(_1,_2)}else{_4=_1;_1=this.getEditSessionRowNum(_4,_2)}
if(!_3&&this.$30a&&this.getEditRow()==_1){this.cancelEditing()}else{if(this.$30a){if(this.getEditRow()==_1){this.storeUpdatedEditorValue(true)}}}
this.$321(_4,_2)}
,isc.A.saveEdits=function(_1,_2,_3,_4,_5){if(_1==null)_1=isc.ListGrid.PROGRAMMATIC;if(_3==null){_3=this.getEditRow()
_4=this.getEditCol()}else if(_4==null){var _4=(_3==this.getEditRow()?this.getEditCol():this.getRowEditColNum(_3))}
if(_3==null)return false;var _6=this.getEditValues(_3,_4),_7=this.getCellRecord(_3,_4),_8=this.getEditValuesID(_3,_4);var _9;if(_7!=null&&!Array.isLoading(_7)){if(isc.isA.Tree(this.data)){_9=this.data.getCleanNodeData(_7,false)}else{_9=isc.addProperties({},_7)}
if(_9&&this.selection)delete _9[this.selection.selectionProperty]}
var _10={rowNum:_3,colNum:_4,oldValues:_9,editValuesID:_8,values:_6,editCompletionEvent:_1,newRecord:(_3>this.data.getLength())};if(this.logIsDebugEnabled("gridEdit")){this.logDebug("change detection: newValues: "+this.echo(_6)+", oldValues: "+this.echo(_9),"gridEdit")}
if(this.$32k()){var _11;if(this.useCellRecords){_11=!this.validateCell(_3,_4)}else{_11=!this.validateRow(_3)}
if(_11){if(!_5)this.$331(_10,_2);return false}}
if(_5)return true;if(!this.recordHasChanges(_3,_4,false)){this.logInfo("saveEdits: no actual change, not saving","gridEdit");this.$321(_8,_4);this.$332(_2,_3,_4,_1,true);return}
_6=this.$300(_3,_4);this.logInfo("Saving newValues '"+isc.echoAll(_6)+"'","gridEdit");this.rememberSubmittedEditValues(_3,_4);_6=isc.addProperties({},_6);this.saveEditedValues(_3,_4,_6,_9,_8,_1,_2);return true}
,isc.A.rowHasChanges=function(_1,_2){return this.recordHasChanges(_1,null,_2)}
,isc.A.recordHasChanges=function(_1,_2,_3){if(_3==null)_3=true;var _4=false,_5=(_3?this.getEditValues(_1,_2):this.$300(_1,_2)),_6=this.getCellRecord(_1,_2);if(!_6)return true;var _7=isc.addProperties({},_6,this.getSubmittedEditValues(_1,_2));for(var _8 in _5){var _9=_7[_8],_10=_5[_8];if(!this.fieldValuesAreEqual(this.getField(_8),_9,_10)){_4=true;break}}
return _4}
,isc.A.hasChanges=function(_1){var _2=this.getAllEditRows();if(_2!=null){for(var i=0;i<_2.length;i++){if(this.rowHasChanges(_2[i],_1))return true}}
return false}
,isc.A.cellHasChanges=function(_1,_2,_3){if(_1==null||_2==null)return false;var _4=isc.isA.String(_2)?_2:this.getEditorName(_1,_2);var _5=(_3?this.getEditValues(_1,_2):this.$300(_1,_2));if(!_5)return false;var _6=this.getCellRecord(_1,_2);if(!_6)return true;var _7;if(_5[_4]===_7)return false;var _8=this.getSubmittedEditValues(_1,_2),_9=_8!=null?this.$du(_8[_4],_6[_4]):_6[_4];var _10=this.getField(_4);return!this.fieldValuesAreEqual(_10,_9,_5[_4])}
,isc.A.saveAllEdits=function(_1,_2){this.$333=this.$333||{};this.$334=this.$334||{};if(_1==null)_1=this.getAllEditCells();if(_1==null)return;if(!isc.isAn.Array(_1))_1=[_1];if(this.$32k()){for(var i=0;i<_1.length;i++){var _4=isc.isAn.Array(_1[i])?_1[i][0]:_1[i],_5=isc.isAn.Array(_1[i])?_1[i][1]:null;var _6=this.saveEdits(null,null,_4,_5,true);if(!_6){if(this.stopOnErrors)return false;else{_1[i]=null;_2=null}}}}
var _7=(this.dataSource!=null&&!this.saveLocally),_8=false;if(_7)_8=!isc.RPCManager.startQueue();var _9=this.$31e++,_10=this.$333[_9]=[];this.$334[_9]=_2;for(var i=0;i<_1.length;i++){if(_1[i]==null)continue;var _4=_1[i],_5;if(isc.isAn.Array(_4)){_5=_4[1];_4=_4[0]}
if(!this.recordHasChanges(_4,_5))continue;_10[_10.length]=_1[i];var _11="this.$335(rowNum,"+_9+",colNum,editCompletionEvent,success)";this.saveEdits(null,_11,_4,_5)}
if(_8)isc.RPCManager.sendQueue();return true}
,isc.A.$335=function(_1,_2,_3,_4,_5){if(!_5){delete this.$334[_2];delete this.$333[_2];return}
var _6=this.$333[_2];if(_6==null)return;var _7,_8;for(_7=0;_7<_6.length;_7++){var _9=_6[_7];if(isc.isA.Number(_9)){if(_9==_1){_8=true;break}}else if(_9[0]==_1&&_9[1]==_3){_8=true;break}}
_6.removeAt(_7);if(_6.length==0){this.$332(this.$334[_2],_1,_3,_4);delete this.$334[_2];delete this.$333[_2]}}
,isc.A.$33y=function(_1,_2,_3,_4,_5){var _6;if(_5===_6)_5=this.getCellRecord(_3,_4);if(_2&&_2.$66!=null){_1=_2.$62.parseInput(_1,_2,this,_5)}else if(_2&&_2.parseEditorValue!=null){isc.Func.replaceWithMethod(_2,"parseEditorValue","value,record,rowNum,colNum,grid");_1=_2.parseEditorValue(_1,_5,_3,_4,this)}else if(this.parseEditorValue!=null){_1=this.parseEditorValue(_1,_5,_3,_4)}
return _1}
,isc.A.shouldSaveLocally=function(){return(!this.dataSource||this.saveLocally)}
,isc.A.saveEditedValues=function(_1,_2,_3,_4,_5,_6,_7){var _8={editValuesID:_5,rowNum:_1,colNum:_2,values:_3,oldValues:_4,editCompletionEvent:_6};if(this.shouldSaveLocally())return this.$336(_8,_7);var _9=this.getID()+".$337(dsResponse, dsRequest)",_10={operation:(_4==null?this.addOperation:this.updateOperation)||this.saveOperation,application:this.application,willHandleError:true,showPrompt:this.shouldWaitForSave(),oldValues:_4,$52s:this.getRecord(_1,_2),clientContext:{saveCallback:_7,newValues:_3,editInfo:_8},componentId:this.ID};this.$338(_3,_4);if(this.$31o==null)this.$31o={};this.$31o[_8.editValuesID]=true;var _11=isc.DS.get(this.dataSource);if(_4==null){var _12=isc.addProperties({},_4,_3);_11.addData(_12,_9,_10)}else{var _13=isc.DS.get(this.dataSource).filterPrimaryKeyFields(_4),_14=isc.addProperties({},_13,_3);_11.updateData(_14,_9,_10)}}
,isc.A.$336=function(_1,_2){var _3=_1.rowNum,_4=_1.colNum,_5=_1.oldValues,_6=_1.values;var _7=this.getCellRecord(_3,_4),_8=(_7==null);if(_8){var _9=this.getData();var _10=this.getEditSession(_3);_10.$33b=this.getPrimaryKeys(_6);delete _10.$33i;_9.add(_6);_9.dataChanged()}else{var _11,_12;for(var i=0;i<this.fields.length;i++){_11=_6[this.fields[i][this.fieldIdProperty]];if(_11!==_12)this.setRawCellValue(_7,_3,i,_11)}}
this.$338(_6,_5);this.$339(_1,_2)}
,isc.A.$338=function(_1,_2){var _3=this.$60z();if(_3==null)return;var _4=this.fields[_3];if(_4==null)return;var _5=_4[this.fieldIdProperty];var _6;if(_5!=null&&_1[_5]!==_6&&(_2==null||_1[_5]!=_2[_5]))
{this.unsort()}}
,isc.A.$337=function(_1,_2){var _3=_1.data,_4=_1.clientContext,_5=_4.editInfo,_6=_5.colNum,_7=this.fields[_6];if(this.$31o&&this.$31o[_5.editValuesID]){delete this.$31o[_5.editValuesID];if(isc.isAn.emptyObject(this.$31o))delete this.$31o}
var _8=this.getEditSession(_5.editValuesID);if(_8!=null){_5.rowNum=_8.$24t}else{if(_3&&_3[0]){_5.rowNum=this.findRowNum(_3[0]);if(this.useCellRecords)_5.colNum=this.findColNum(_3[0])}
else _5.rowNum=-1}
var _9=_5.rowNum,_6=_5.colNum;if(_1.status<0){var _10=this.parseServerErrors(_1.errors);this.logInfo("error on save, status: "+_1.status+", errors: "+this.echo(_1.errors),"gridEdit");if(isc.isAn.Array(_10)){if(_10.length!=1)
this.logWarn("Server reports validation errors for multiple records - only "+"displaying errors for the first record.","gridEdit");_10=_10[0]}
if(this.useCellRecords)this.setCellErrors(_9,_6,_10[this.getEditorName(_9,_6)]);else this.setRowErrors(_9,_10);this.$331(_5,_4.saveCallback,_1,_2);return false}
this.$339(_5,_4.saveCallback,_1,_2)}
,isc.A.parseServerErrors=function(_1){if(isc.isAn.Array(_1)){if(_1.length>1){this.logWarn("server returned errors for multiple records - dropping all but the "+"first record returned")}
_1=_1[0]}
if(_1&&_1.recordPath)delete _1.recordPath;for(var _2 in _1){var _3=_1[_2];if(isc.isAn.Array(_3)){for(var i=0;i<_3.length;i++){_3[i]=_3[i].errorMessage}}else{_1[_2]=[_3.errorMessage]}}
return _1}
,isc.A.$339=function(_1,_2,_3,_4){if(this.$30a&&this.getEditForm().hasFocus)this.storeUpdatedEditorValue(true);var _5=_1.rowNum,_6=_1.colNum,_7=_1.editValuesID,_8=this.getEditSession(_7);var _9;if(_3!=null){var _10=isc.DataSource.getUpdatedData(_4,_3,true),_9=isc.isAn.Array(_10)?_10[0]:_10;if(_9==null){return}
if(_8&&_8.$33b==null){this.newRecordForEditValues(_7,_9)}}else{_9=this.getCellRecord(_5,_6)}
var _11=_1.values,_12=this.$300(_7),_13=this.isEditingRecord(_5,_6),_14=this.dataSource?isc.DS.get(this.dataSource).getPrimaryKeyFieldNames():null;var _15=false;for(var _16 in _12){var _17=_14&&_14.contains(_16);if(this.fieldValuesAreEqual(this.getField(_16),_12[_16],_11[_16]))
{if(!(_13&&_17))this.clearEditValue(_7,_16,true,true)}else{if(!_17)_15=true}}
if(!_13&&!_15){this.$321(_7,_6)}
if(_3!=null||_1.newRecord){this.displayUpdatedDSRecord(_5,_6,_9)}
var _18=_1.values,_19=_1.oldValues,_20=_1.editCompletionEvent;if(_5==-1)_5=_1.rowNum;if(this.convertToMethod("editComplete")){this.editComplete(_5,_6,_18,_19,_20,_3)}
this.$50u(_9,_5,_6,_18,_19,_4);if(_2)this.$332(_2,_5,_6,_20,true)}
,isc.A.displayUpdatedDSRecord=function(_1,_2,_3){this.dataChanged()}
,isc.A.isEditingRecord=function(_1,_2){return this.getEditRow()==_1}
,isc.A.$332=function(_1,_2,_3,_4,_5){if(_1!=null){this.fireCallback(_1,this.$31f,[_2,_3,_4,_5])}}
,isc.A.$50u=function(_1,_2,_3,_4,_5,_6){var _7;for(var i in _4){var _9=(_5==null?null:_5[i]);if(_4[i]==_9)continue;var _10=this.fields.find(this.fieldIdProperty,i);if(!_10)continue;if(this.isGrouped&&_10&&this.groupByField.contains(_10.name)){_7=true}
this.$34a(_1,_10,_4[i],_9,_2,this.fields.indexOf(_10))}
if(_7){if(this.shouldSaveLocally())
this.$607(_1,_1,_2,_4);this.$34v=false;this.$34u()}}
,isc.A.$34a=function(_1,_2,_3,_4,_5,_6){if(_2&&_2.cellChanged){if(!isc.isA.Function(_2.cellChanged)){isc.Func.replaceWithMethod(_2,"cellChanged","record,newValue,oldValue,rowNum,colNum,grid,recordNum,fieldNum")}
_2.cellChanged.call(this,_1,_3,_4,_5,_6,this,_5,_6)}else if(this.cellChanged){this.cellChanged(_1,_3,_4,_5,_6,this,_5,_6)}}
,isc.A.$331=function(_1,_2,_3,_4){var _5=_1.rowNum,_6=_1.colNum,_7=_1.values,_8=_1.oldValues,_9=_1.editCompletionEvent;if(this.convertToMethod("editFailed")){this.editFailed(_5,_6,_7,_8,_9,_3,_4)}
if(_2!=null)this.$332(_2,_5,_6,_9,false);this.clearSubmittedEditValues(_1.editValuesID,_7)}
,isc.A.editFailed=function(_1,_2,_3,_4,_5,_6,_7){if(_6!=null&&_6.errors==null){isc.RPCManager.$a0(_6,_7)}}
,isc.A.validateRow=function(_1,_2){return this.validateRecord(_1,_2)}
,isc.A.validateRecord=function(_1,_2){var _3,_4;if(isc.isAn.Array(_1)){_3=_1[0];_4=_1[1]}else{_3=_1}
var _5=this.getEditValues(_3,_4);if(_5==null)return true;var _6=this.getCellRecord(_3,_4),_7;if(_6==null)_7=this.getFields().getProperty(this.fieldIdProperty);else _7=isc.getKeys(_5);var _8=this.validateRowValues(_5,_6,_3,_7);this.setRowErrors(_3,_8,_2);return(_8==null)}
,isc.A.validateRowValues=function(_1,_2,_3,_4){var _5=true,_6={};if(!isc.isAn.Array(_4))_4=[_4];var _7=false;if(_2==null){_7=true;_2={}}
for(var i=0;i<_4.length;i++){var _9,_10;if(isc.isA.Number(_4[i])){_10=_4[i];_9=_4[i]=this.getFieldName(_10)}else{_9=_4[i];_10=this.getFields().findIndex(this.fieldIdProperty,_9)}
if(_10<0)continue;var _11=((_7&&this.canEditCell(_3,_10))||isc.propertyDefined(_1,_9));if(!_11)continue;var _12=_1[_9],_13=_2[_9],_14=this.validateCellValue(_3,_10,_12,_13);if(_14!=null){_5=false;_6[_9]=_14}}
if(!_5)return _6;return null}
,isc.A.validateCell=function(_1,_2,_3){var _4;if(isc.isA.String(_2))_4=this.getColNum(_2);else{_4=_2;_2=this.getEditorName(_1,_4)}
var _5=this.getEditValues(_1,_4),_6=this.cellHasErrors(_1,_2),_7=_5?_5[_2]:null,_8=this.getCellRecord(_1,_4),_9=_8?_8[_2]:null;if(_8!=null&&(!_5||!isc.propertyDefined(_5,_2))){return true}
var _10=this.validateCellValue(_1,_4,_7,_9);if(_10!=null){if(this.useCellRecords)this.setCellErrors(_1,_4,_10);else this.setFieldError(_1,_2,_10);return false}
if(_6){if(this.useCellRecords)this.setCellErrors(_1,_4,null);else this.setFieldError(_1,_2,null)}
return true}
,isc.A.validateCellValue=function(_1,_2,_3,_4){var _5=this.getCellRecord(_1,_2);var _6=this.getField(_2);return this.validateFieldValue(_3,_4,_5,_6,_1,_2)}
,isc.A.getRequiredFieldMessage=function(_1,_2){return"Field is required"}
,isc.A.validateFieldValue=function(_1,_2,_3,_4,_5,_6){var _7=[],_8=true;var _9=this.cellIsRequired(_5,_6);if(_9&&(_1==null||isc.isAn.emptyString(_1))){var _10=this.getRequiredFieldMessage(_4,_3);_7.add(_10);_8=false}
var _11=this.getCellValidators(_5,_6);if(_11){if(!isc.isAn.Array(_11)){_11=[_11]}
if(this.logIsDebugEnabled("gridEdit")){this.logDebug((this.useCellRecords?"At col:"+_6:"At field: "+_4.name)+" applying validators: "+this.echoAll(_11)+" to value:"+_1,"gridEdit")}
for(var i=0;i<_11.length;i++){var _13=_11[i];if(!_13||_13.serverOnly)continue;var _14=isc.Validator.processValidator(_4,_13,_1);if(_14!=true){_8=false;_7.add(isc.Validator.getErrorMessage(_13))}else{if(_13.resultingValue!=null){this.setEditValue(_5,_6,_13.resultingValue);_1=_13.resultingValue}}
if(!_14&&_13.stopIfFalse)break}
if(this.logIsInfoEnabled("gridEdit")){this.logInfo("validateFieldValue, newValue: "+this.echo(_1)+", passed validation: "+_14+", resultingValue: "+this.echo(_13.resultingValue),"gridEdit")}}
if(_8)return null
else return _7}
,isc.A.cellIsRequired=function(_1,_2){var _3=this.getField(_2);return _3&&_3.required}
,isc.A.getCellValidators=function(_1,_2){var _3=this.getField(_2);return _3?_3.validators:null}
,isc.A.hasErrors=function(){var _1=this.getAllEditRows(true);for(var i=0;i<_1.length;i++){if(this.rowHasErrors(_1[i]))return true}
return false}
,isc.A.rowHasErrors=function(_1,_2){var _3=this.getEditSession(_1,_2);return(_3&&_3.$33o&&!isc.isA.emptyObject(_3.$33o))}
,isc.A.cellHasErrors=function(_1,_2){var _3=(isc.isA.String(_2)?_2:this.getEditorName(_1,_2)),_4=this.getEditSession(_1,_2),_5=_4?_4.$33o:null;return(_5!=null&&_5[_3]!=null)}
,isc.A.getRowValidationErrors=function(_1){return this.getRowErrors(_1)}
,isc.A.getRowErrors=function(_1,_2){var _3=this.getEditSession(_1,_2);return(_3!=null?_3.$33o:null)}
,isc.A.getCellErrors=function(_1,_2){var _3=this.getEditSession(_1,_2);if(_3==null)return null;if(isc.isA.Number(_2))_2=this.getEditorName(_1,_2);var _4=_3.$33o;return(_4==null?null:_4[_2])}
,isc.A.setCellErrors=function(_1,_2,_3,_4){return this.setFieldError(_1,_2,_3,_4)}
,isc.A.setFieldError=function(_1,_2,_3,_4){var _5=_2;if(isc.isA.Number(_5))_5=this.getEditorName(_1,_5);if(_3==null||(isc.isAn.Array(_3)&&_3.length==0)){if(!this.cellHasErrors(_1,_2))return;var _6=this.getEditSession(_1,_2);delete _6.$33o[_5];if(isc.isAn.emptyObject(_6.$33o))delete _6.$33o}else{if(_5==null){this.logWarn("setFieldError() passed field identifier '"+_2+"'. "+"Unable to find corresponding field in this grid - not setting error.");return}
var _7=this.getFields().getProperty(this.fieldIdProperty);if(!_7.contains(_5))
{this.logWarn("setFieldError() passed field identifier '"+_2+"'. This "+"is not a visible field in the grid - error may not be visible to user.")}
var _8;if(isc.isAn.Array(_3))_8=_3
else _8=[_3];var _6=this.getEditSession(_1,_2);if(_6==null){var _9=this.getColNum(_2),_10=this.getCellRecord(_1,_9);_6=this.createEditSession(_1,_9,_10)}
if(_6.$33o==null)_6.$33o={};_6.$33o[_5]=_8}
if(!_4){if(this.useCellRecords)this.showCellErrors(_1,_2)
else this.showErrors(_1,[_5])}}
,isc.A.setRowErrors=function(_1,_2,_3){if(_1==null||_1==-1)return;var _4=this.getRowErrors(_1);if(!_2&&!_4)return;var _5=this.getEditSession(_1);if(_5==null)_5=this.createEditSession(_1,null,this.getRecord(_1));if(_2){var _6=this.getFields().getProperty(this.fieldIdProperty);for(var _7 in _2){if(!_3&&!_6.contains(_7)){this.logWarn("setRowErrors() passed error for non-visible field: '"+_7+"'")}
if(!isc.isAn.Array(_2[_7]))_2[_7]=[_2[_7]]}}
_5.$33o=_2;if(!_3){var _8=_2?isc.getKeys(_2):[];for(var _7 in _4){var _9=this.getColNum(_7);if(!_8.contains(_7))_8.add(_7)}
this.showErrors(_1,_8)}}
,isc.A.clearFieldError=function(_1,_2,_3){return this.setFieldError(_1,_2,null,_3)}
,isc.A.clearRowErrors=function(_1,_2){this.setRowErrors(_1,null,_2)}
,isc.A.showErrors=function(_1,_2){if(_2==null)_2=this.getFields().getProperty(this.fieldIdProperty);var _3=this.getRowErrors(_1);if(_3==null)_3={};var _4;for(var i=0;i<_2.length;i++){var _6=_2[i];this.showCellErrors(_1,_6);if(_4==null&&_3[_6])_4=_6}
var _7=this.assembleErrorMessage(_3,_2);if(_7){this.displayRowErrorMessages(_7)}
if(this.stopOnErrors&&_4!=null){var _8=this.getFields().findIndex(this.fieldIdProperty,_4);this.showInlineEditor(_1,_8)}}
,isc.A.showCellErrors=function(_1,_2){var _3;if(isc.isA.Number(_2)){this.getEditorName(_1,_2)}else{_3=_2;_2=this.getColNum(_3)}
if(_2==-1)return;if(this.showErrorIcons){this.refreshCell(_1,_2,null,true)}else{this.body.$29h(null,_1,_2)}}
,isc.A.assembleErrorMessage=function(_1,_2){var _3=false,_4="Validation Errors occurred:\r\n";for(var _5 in _1){if(_2&&!_2.contains(_1))continue;var _6=this.$34b(_5,_1[_5]);if(_6!=null){_3=true;_4+=_6}}
return(_3?_4:null)}
,isc.A.$34b=function(_1,_2){var _3,_4,_5=this.getField(_1),_6=_5&&_5.title?_5.title:_1;for(var i=0;i<_2.length;i++){var _8=_2[i];if(_8!=null){if(_4==null){_4="<br>Field '"+_6+"':"}
_4+="<br>* "+_8}}
return _4}
,isc.A.displayRowErrorMessages=function(_1){if(this.stopOnErrors)isc.warn(_1,"var LG="+this.getID()+";if(LG.$286)LG.$286.focus()")}
,isc.A.$609=function(_1,_2){if(_2==null)return;this.delayCall("removeRecord",[_1,_2])}
,isc.A.removeRecord=function(_1,_2){if(_2==null)_2=this.data.get(_1);else _1=(this.data?this.data.indexOf(_2):null)
if(_2==null||_1==null||_1==-1||!this.data)return;var _3=this.animateRemoveRecord&&this.isDrawn()&&this.isVisible()&&this.body&&_1>=this.body.$252&&_1<=this.body.$253;if(_3){this.$50w=true;var _4=1;if(isc.isA.Tree(this.data)&&this.data.isFolder(_2)&&this.data.isOpen(_2)){var _5=this.data.getChildren(_2);if(_5)_4+=_5.getLength()}
this.$63o=_4;this.body.$28b(false,_1,_1+_4)}
var _6=this.getDataSource();if(_6){if(!_6.getPrimaryKeyField){this.logWarn("DataSource:"+_6+" has no primary key field - unable to remove records");return}
var _7;if(_3){_7=this.getID()+".removeDataComplete("+_1+", data,dsResponse);"}
this.removeData(_2,_7,{showPrompt:false})}else{this.data.remove(_2);if(_3)this.removeDataComplete(_1,_2)}}
,isc.A.removeDataComplete=function(_1,_2,_3){if(_3&&_3.status<0){this.logWarn("Removal of record failed");_2=null}
if(!_2){delete this.$50w;if(this.body){delete this.body.$28c;delete this.body.$28e;delete this.body.$28f;delete this.body.$28h}
this.markForRedraw()}else{this.startRowAnimation(false,_1,_1+this.$63o,{target:this,methodName:"$63d"},this.animateRemoveSpeed,this.animateRemoveTime);delete this.$63o}}
,isc.A.$63d=function(){delete this.$50w;this.redraw()}
,isc.A.startRowAnimation=function(_1,_2,_3,_4,_5,_6,_7,_8,_9){if(!this.body)return;if(this.frozenBody){this.frozenBody.startRowAnimation(_1,_2,_3,null,_5,_6,_7,_8,true,_9)}
this.body.startRowAnimation(_1,_2,_3,_4,_5,_6,_7,_8,true,_9)}
,isc.A.animateRowHeight=function(_1,_2,_3,_4,_5,_6,_7){if(!this.body)return;return this.body.animateRowHeight(_1,_2,_3,_4,_5,_6,_7,true)}
,isc.A.setCellHeight=function(_1){var _2=this.cellHeight;this.cellHeight=_1;if(this.body)this.body.cellHeight=_1;if(_2!=_1&&this.isDrawn())this.body.markForRedraw("Cell height changed")}
,isc.A.setRowHeight=function(_1,_2){if(!this.body)return;return this.body.setRowHeight(_1,_2)}
,isc.A.setDragTracker=function(){var _1=isc.EH,_2=this.dragTrackerMode;if(_2=="none"){_1.setDragTracker("");return false}else if(_2=="icon"){var _3=this.getSelection(),_4=this.getDragTrackerIcon(_3);_1.setDragTracker(this.imgHTML(_4),null,null,null,null,this.getDragTrackerProperties());return false}else{var _5=this.getSelectedRecord(),_6=_5&&this.data?this.data.indexOf(_5):-1;if(_2=="title"){var _7=this.getDragTrackerTitle(_5,_6);_1.setDragTracker(_7,null,null,null,null,this.getDragTrackerProperties());return false}else if(_2=="record"){var _8=this.body.getTableHTML([0,this.fields.length-1],_6,_6+1);_1.setDragTracker(_8,null,null,null,null,this.getDragTrackerProperties());return false}}}
,isc.A.getDragTrackerProperties=function(){var _1=isc.addProperties({},this.dragTrackerProperties);_1.styleName=this.dragTrackerStyle;if(this.dragTrackerMode=="record")_1.opacity=50;return _1}
,isc.A.getDragTrackerIcon=function(_1){var _2=_1?_1[0]:null,_3;if(_2){var _4=this.getTitleField();_3=this.getValueIcon(this.getField(_4),_2[_4],_2)}
if(_3==null)_3=this.trackerImage;return _3}
,isc.A.getDragTrackerTitle=function(_1,_2){var _3=this.getTitleField(),_4=this.getColNum(_3),_5=this.getCellValue(_1,_2,_4);return"<nobr>"+_5+"</nobr>"}
,isc.A.dragStart=function(){if(this.canDragSelect)return true;var _1=this.selection.getSelection();if(!_1||_1.length==0)return false;for(var i=0;i<_1.length;i++){if(_1[i].canDrag==false)return false}
return true}
,isc.A.dragMove=function(){var _1=isc.EH.dropTarget;if(!this.canDragRecordsOut&&_1!=null&&_1!=this&&!this.contains(_1))
{return false}}
,isc.A.dropMove=function(){if(!this.canReorderRecords)return true;if(!this.canAcceptDroppedRecords&&isc.EH.dragTarget!=this)return true;if(!this.willAcceptDrop()){this.body.setNoDropIndicator()}else{this.body.clearNoDropIndicator()}
this.showDragLineForRecord()}
,isc.A.dropOut=function(){this.body.clearNoDropIndicator();this.hideDragLine()}
,isc.A.dragStop=function(){this.body.clearNoDropIndicator();this.hideDragLine()}
,isc.A.willAcceptDrop=function(){var _1=this.ns.EH;if(!this.Super("willAcceptDrop",arguments)&&_1.dragTarget!=this.body)return false;if(_1.dragTarget==this){if(!this.$34c())return false}else{if(!this.canAcceptDroppedRecords)return false}
if(!isc.isAn.Object(_1.dragTarget.getDragData()))return false;isc.$54j=true;var _2=this.getEventRecordNum(),_3=this.getEventFieldNum();var _4=this.getReorderPosition(_2);if(_2!=-2&&_4==isc.ListGrid.AFTER)_2+=1;isc.$54j=false;if(_2<-1)return true;if(_2==-1)return false;var _5=this.getRecord(_2,_3);if(!this.recordIsEnabled(_2,_3)||(_5!=null&&_5.canAcceptDrop==false))return false;return true}
,isc.A.$34c=function(){return this.canReorderRecords}
,isc.A.isValidTransferSource=function(_1){if(!_1||!_1.transferDragData){this.logWarn("transferSelectedData(): "+(_1?"Invalid ":"No ")+"source widget passed in - "+(_1||"")+" taking no action.");return false}
if(_1==this){this.logWarn("transferSelectedData(): target parameter contains a pointer back to this grid - ignoring");return false}
return true}
,isc.A.transferSelectedData=function(_1,_2){if(!this.isValidTransferSource(_1))return;if(_2==null)_2=this.data.getLength()
else _2=Math.min(_2,this.data.getLength());var _3=this.getDataSource(),_4=_1.getDataSource();if(_3&&_3==_4){var _5=_1.getDragData()}else{_5=_1.transferDragData()}
var _6=this.data.get(_2);this.transferRecords(_5,_6,_2,_1)}
,isc.A.drop=function(){if(this.willAcceptDrop()==false)return false;var _1=this.ns.EH.dragTarget;var _2=this.getEventRecordNum();if(this.data.getLength()==0){_2=0}else if(this.canReorderRecords){if(_2==-2)_2=this.data.getLength()-1;var _3=this.getReorderPosition(_2);if(_3==isc.ListGrid.AFTER)_2+=1}
var _4=this.getDataSource(),_5=_1.getDataSource();if(_4&&_4==_5){var _6=_1.getDragData()}else{_6=(this.canReorderRecords&&_1==this?this.selection.getSelection():_1.transferDragData?_1.transferDragData():null)}
var _7=this.data.get(_2);return this.recordDrop(_6,_7,_2,_1)}
,isc.A.recordDrop=function(_1,_2,_3,_4){this.transferRecords(_1,_2,(this.canReorderRecords?_3:null),_4);if(this.recordsDropped)this.recordsDropped(_1,_3,this,_4);return false}
,isc.A.getDragData=function(){var _1=this.selection.getSelection();return _1}
,isc.A.transferDragData=function(){var _1=this.getDragData();var _2=this.dragDataAction==isc.ListGrid.COPY||this.dragDataAction==isc.ListGrid.CLONE;if(_2){for(var i=0;i<_1.length;i++){var _4=_1[i];if(_4.$29a!=null){for(var _5=0;_5<_4.$29a.length;_5++){this.removeEmbeddedComponent(_4,_4.$29a[_5])}}
delete _4.$29a}
_1=isc.clone(_1)}else if(this.dragDataAction==isc.ListGrid.MOVE){this.selection.deselectList(_1);if(this.dataSource){var _6=isc.rpc.startQueue();for(var i=0;i<_1.length;i++){this.getDataSource().removeData(_1[i])}
if(!_6)isc.rpc.sendQueue()}else{this.data.removeList(_1)}}
return _1}
,isc.A.viewRow=function(_1){this.getDataSource().viewFile(this.getRecord(_1))}
,isc.A.downloadRow=function(_1){this.getDataSource().downloadFile(this.getRecord(_1))}
,isc.A.autoSizeColumn=function(_1){var _2=this.body.getColumnAutoSize(_1);this.resizeField(_1,_2)}
,isc.A.getRecord=function(_1,_2){return this.getCellRecord(_1,_2)}
,isc.A.getCellRecord=function(_1,_2){if(!isc.isA.Number(_1)){this.logWarn("getCellRecord called with bad rowNum: "+this.echo(_1));return}
if(!this.data||_1>=this.data.getLength())return null;var _3=this.data.get(_1);if(this.$33q)this.$34d(_3,_1);return _3}
,isc.A.$34d=function(_1,_2){if(_1==null||_1[this.editValuesTestedProperty])return;if(this.$33a==null)this.$33a={};var _3=true;for(var i in this.$52b){var _5=this.$52b[i];if(_5!=null&&_5.$24t==null){if(this.comparePrimaryKeys(_1,_5.$33b)){_5.$24t=_2;this.$33a[_2]=i}else{_3=false}}}
if(_3)delete this.$33q;_1[this.editValuesTestedProperty]=true}
,isc.A.comparePrimaryKeys=function(_1,_2){var _3=this.getPrimaryKeys(_1);if(!this.dataSource||this.saveLocally)return(_3==_2);for(var _4 in _3){if(_3[_4]!=_2[_4])return false}
return true}
,isc.A.getPrimaryKeys=function(_1){if(this.dataSource==null||this.saveLocally)return _1;var _2=this.getDataSource(),_3=_2.getPrimaryKeyFieldNames(),_4={};if(!isc.isAn.Array(_3))_3=[_3];for(var i=0;i<_3.length;i++){_4[_3[i]]=_1[_3[i]]}
return _4}
,isc.A.getTotalRows=function(){if(this.data==null)return 0;var _1=this.data.getLength(),_2=this.$34e();if(_2!=null&&_2+1>_1)_1=_2+1;if(this.showNewRecordRow)_1+=1;return _1}
,isc.A.$34e=function(){if(this.$33j==null){var _1=-1,_2=(this.$33a?isc.getKeys(this.$33a):[]);for(var i=0;i<_2.length;i++){var _4=parseInt(_2[i]);if(_4>_1)_1=_4}
this.$33j=_1}
return this.$33j}
,isc.A.recordIsEnabled=function(_1,_2){var _3=this.getCellRecord(_1,_2);if(_3==null)return true;return(_3.enabled!=false&&_3[this.isSeparatorProperty]!=true)}
,isc.A.cellIsEnabled=function(_1,_2){return this.recordIsEnabled(_1,_2)}
,isc.A.getCellField=function(_1,_2){return this.getField(_2)}
,isc.A.getFields=function(){return this.fields}
,isc.A.getAllFields=function(){return this.completeFields||this.fields}
,isc.A.getSpecifiedField=function(_1){var _2=this.completeFields;if(_2==null)_2=this.fields;if(isc.isAn.Object(_1)){if(_2.contains(_1))return _1;return null}else if(isc.isA.String(_1))return _2.find(this.fieldIdProperty,_1);else return(_2[_1])}
,isc.A.getFieldName=function(_1){var _2=this.getField(_1);return _2?_2[this.fieldIdProperty]:null}
,isc.A.getColNum=function(_1){return this.getFieldNum(_1)}
,isc.A.getFieldTitle=function(_1){var _2;if(isc.isAn.Object(_1))_2=_1;else _2=this.fields[_1];if(!_2)return"Unknown field";if(_2.getFieldTitle){isc.Func.replaceWithMethod(_2,"getFieldTitle","viewer,fieldNum");return _2.getFieldTitle(this,_1)}
return _2.title||_2.name}
,isc.A.getSummaryTitle=function(_1){var _2;if(_1.getSummaryTitle!=null){isc.Func.replaceWithMethod(_1,"getSummaryTitle","viewer,field");_2=_1.getSummaryTitle(this,_1)}else if(_1.summaryTitle!=null){_2=_1.summaryTitle}else{_2=this.getFieldTitle(_1)}
return _2}
,isc.A.setValueMap=function(_1,_2){this.Super('setValueMap',arguments);if(this.$30a){var _3,_4;var _5=this.getColNum(_1);if(_5!=-1&&_5<this.fields.length){var _4=this.getField(_1),_3=_4[this.fieldIdProperty];this.$286.setValueMap(_3,this.getEditorValueMap(_4,this.getEditedRecord(this.getEditRow(),_5)))}}
if(this.isDrawn()&&this.isVisible()){this.$25a("setValueMap")}}
,isc.A.getData=function(){return this.data}
,isc.A.getRecordIndex=function(_1){var _2=-1;if(this.body&&this.body.isDrawn()){_2=this.data.indexOf(_1,this.body.$252,this.body.$253)}
if(_2==-1)_2=this.data.indexOf(_1);return _2}
,isc.A.getRecordCellIndex=function(_1){return[this.getRecordIndex(),0]}
,isc.A.getEventRow=function(_1){if(this.header&&this.header.containsPoint(this.ns.EH.getX(),this.ns.EH.getY())){return-1}
return this.body.getEventRow(_1)}
,isc.A.getEventColumn=function(_1){return this.body.getEventColumn(_1)}
);isc.evalBoundary;isc.B.push(isc.A.getEventRecordNum=function(_1){return this.getEventRow(_1)}
,isc.A.getEventFieldNum=function(_1){return this.getEventColumn(_1)}
,isc.A.getReorderPosition=function(_1,_2){if(_2==null)_2=this.body.getOffsetY();if(_1==null)_1=this.getEventRow(_2);if(_1==-2)return isc.ListGrid.AFTER;if(_1>=this.getTotalRows())return isc.ListGrid.BEFORE;var _3=this.body.getRowTop(_1),_4=this.body.getRowSize(_1);if(_2>Math.round(_3+_4/ 2)){return isc.ListGrid.AFTER}else{return isc.ListGrid.BEFORE}}
,isc.A.getDropRecordNum=function(_1,_2){if(_1==null)_1=this.getEventRow();if(_2==null)_2=this.getReorderPosition(_1);return _1+(_2==isc.ListGrid.AFTER?1:-1)}
,isc.A.getSerializeableFields=function(_1,_2){_1.addList(["header","selection"]);return this.Super("getSerializeableFields",arguments)}
,isc.A.deriveFrozenFields=function(){var _1=this.frozenFields=this.fields.findAll("frozen",true);var _2=this.completeFields.findAll("frozen",true);if(_1&&_1.length==this.fields.length){_1=this.frozenFields=null;this.$54d=true}else this.$54d=false;if(_1){this.fields.slideList(_1,this.freezeLeft()?0:this.fields.length);this.completeFields.slideList(_2,this.freezeLeft()?0:this.completeFields.length);this.resizeFieldsInRealTime=false}
for(var i=0;i<this.fields.length;i++){var _4=this.fields[i];_4.masterIndex=i}
if(_1){var _5=this.normalFields=[];for(var i=0;i<this.fields.length;i++){var _4=this.fields[i];if(!_4.frozen)_5.add(_4)}}else this.normalFields=null}
,isc.A.rebuildForFreeze=function(_1){if(!this.body)return;if(this.filterEditor){this.filterEditor.deriveVisibleFields();this.filterEditor.updateBody(_1);this.filterEditor.remapEditFieldsForFreeze();this.filterEditor.layoutChildren(this.$60m)}
this.endEditing();this.deriveVisibleFields();this.updateHeader();this.updateBody(_1);this.layoutChildren(this.$60m)}
,isc.A.setCanFreezeFields=function(_1){this.canFreezeFields=_1;delete this.$60v}
,isc.A.refreshMasterIndex=function(){if(!this.body)return;if(this.header)this.$51c(this.header.getMembers());if(this.body)this.$51c(this.body.fields);if(!this.frozenFields)return;if(this.frozenHeader)this.$51c(this.frozenHeader.getMembers());if(this.frozenBody)this.$51c(this.frozenBody.fields)}
,isc.A.$51c=function(_1){for(var i=0;i<_1.length;i++){_1[i].masterIndex=this.fields.findIndex("name",_1[i].name)}}
,isc.A.getFreezeOn=function(){return(this.freezeOn!=null?this.freezeOn:this.isRTL()?"right":"left")}
,isc.A.freezeLeft=function(){return this.getFreezeOn()=="left"}
,isc.A.getLeftBody=function(){return this.frozenFields&&this.freezeLeft()?this.frozenBody:this.body}
,isc.A.getRightBody=function(){return this.frozenFields&&!this.freezeLeft()?this.frozenBody:this.body}
,isc.A.setFreezeOn=function(_1){var _2=this.get
this.freezeOn=_1;if(_1!=_2)this.rebuildForFreeze(true)}
,isc.A.getFrozenSlots=function(_1){var _2=this.frozenFields;if(!_2)return _1;return this.freezeLeft()?_1.slice(0,_2.length):_1.slice(_1.length-_2.length)}
,isc.A.getUnfrozenSlots=function(_1){var _2=this.frozenFields;if(!_2)return _1;return this.freezeLeft()?_1.slice(_2.length):_1.slice(0,_1.length-_2.length)}
,isc.A.fieldIsFrozen=function(_1){if(!this.frozenFields)return false;var _2=this.getField(_1);return _2&&_2.frozen}
,isc.A.getFieldBody=function(_1){if(!this.frozenFields)return this.body;return this.fieldIsFrozen(_1)?this.frozenBody:this.body}
,isc.A.getFieldHeader=function(_1){if(!this.frozenFields)return this.header;return this.fieldIsFrozen(_1)?this.frozenHeader:this.header}
,isc.A.getLocalFieldNum=function(_1){if(!this.frozenFields)return _1;var _2=this.freezeLeft()?this.frozenFields.length:0;if(!this.fieldIsFrozen(_1))return _1-_2;return this.freezeLeft()?_1:_1-(this.fields.length-this.frozenFields.length)}
,isc.A.getFieldNumFromLocal=function(_1,_2){if(!this.frozenFields)return _1;if(_2==this.frozenBody){if(this.freezeLeft())return _1;else{var _3=this.fields.length-this.frozenFields.length;return _1+_3}}else{var _4=this.freezeLeft()?this.frozenFields.length:0;return _1+_4}}
,isc.A.getColumnLeft=function(_1){var _2=this.getFieldBody(_1);return _2.getColumnLeft(this.getLocalFieldNum(_1))}
,isc.A.getColumnPageLeft=function(_1){var _2=this.getFieldBody(_1);return _2.getColumnPageLeft(this.getLocalFieldNum(_1))}
,isc.A.getColumnWidth=function(_1){var _2=this.getFieldBody(_1);return _2.getColumnWidth(this.getLocalFieldNum(_1))}
,isc.A.refreshCellStyle=function(_1,_2,_3){var _4=this.getFieldBody(_2);return _4.refreshCellStyle(_1,this.getLocalFieldNum(_2),_3)}
,isc.A.freezeField=function(_1){return this.toggleFrozen(_1,true)}
,isc.A.unfreezeField=function(_1){return this.toggleFrozen(_1,false)}
,isc.A.toggleFrozen=function(_1,_2){var _1=this.getField(_1);if(!_1||!this.fieldIsVisible(_1)||this.isCheckboxField(_1))return;if(_1.frozen==_2)return false;_1.frozen=_2;this.rebuildForFreeze();return true}
,isc.A.updateBody=function(_1){if(_1||(this.frozenFields&&!this.frozenBody)||(this.frozenBody&&!this.frozenFields))
{if(this.frozenFields){this.$62b=this.showRollOverCanvas;this.$62c=this.showSelectionCanvas;this.showRollOverCanvas=false;this.showSelectionCanvas=false;if(this.$62b)this.updateRollOverCanvas();if(this.$62c)this.updateSelectionCanvas()}else{if(this.$62b)this.showRollOverCanvas=true;if(this.$62c)this.showSelectionCanvas=true;delete this.$62b;delete this.$62c}
if(this.bodyLayout)this.bodyLayout.destroy();if(this.body)this.body.destroy();this.body=this.bodyLayout=this.frozenBody=null;this.createBodies()}
if(this.body){this.body.fields=this.normalFields||this.fields;this.body.markForRedraw("fields change")}
if(this.frozenBody){this.frozenBody.fields=this.frozenFields;this.frozenBody.markForRedraw("fields change")}}
,isc.A.createBodies=function(){if(this.body!=null)return;this.body=this.createBody(this.ID+"_body",this.normalFields||this.fields);this.bodies=[this.body];var _1=this.frozenFields;if(!_1){this.addChild(this.body);return}
this.frozenBody=this.createBody(this.ID+"$51d",_1,true);if(this.body.hscrollOn&&!this.shrinkForFreeze){this.frozenBody.setEndSpace(this.body.getScrollbarSize())}
this.observe(this.body,"adjustOverflow","observer.bodyOverflowed()");if(this.freezeLeft()){this.bodies.unshift(this.frozenBody)}else{this.bodies.add(this.frozenBody)}
this.addAutoChild("bodyLayout",{autoDraw:false,members:this.bodies},isc.HLayout)}
,isc.A.bodyOverflowed=function(){if(!this.frozenBody)return;this.frozenBody.setEndSpace(this.body.hscrollOn&&!this.shrinkForFreeze?this.body.getScrollbarSize():0)}
,isc.A.createBody=function(_1,_2,_3){var _4=isc.ClassFactory.getClass(this.bodyConstructor).createRaw();_4.ID=_1;_4.autoDraw=false;_4.grid=this;_4.fields=_2;_4.overflow=_3?"hidden":this.bodyOverflow;if(_3){_4.mouseWheel=function(){var _5=this.ns.EH.lastEvent.wheelDelta;var _6=this.scrollTop+Math.round(_5*this.scrollWheelDelta);this.scrollTo(this.getScrollLeft(),_6);return false}}
_4.backgroundColor=this.bodyBackgroundColor;var _7=this.bodyStyleName;if(this.alternateBodyStyleName!=null&&this.alternateRecordStyles){_7=this.alternateBodyStyleName}
_4.styleName=_7;_4.allowContentAndChildren=true;_4.fixedRowHeights=this.fixedRecordHeights;_4.fixedColumnWidths=this.fixedFieldWidths;_4.alternateRowStyles=this.alternateRecordStyles;_4.alternateRowFrequency=this.alternateRecordFrequency;_4.showAllRows=this.showAllRecords;if(this.virtualScrolling!=null)_4.virtualScrolling=this.virtualScrolling;_4.tabIndex=this.getTabIndex();_4.dragTarget=this.canDragSelect?null:this;_4.dragAppearance=isc.EventHandler.NONE;_4.locatorParent=this;var _8=isc.ListGrid.$295;for(var i=0;i<_8.length;i++){var _10=_8[i],_11=this[_10];if(_11!=null)_4[_10]=_11}
isc.addProperties(_4,this.bodyDefaults,this.bodyProperties);this.$51e(_4);_4.completeCreation();return _4}
,isc.A.getRowHeight=function(_1,_2){var _3=this.cellHeight;if(this.frozenFields&&this.getEditRow()==_2){var _4=this.getEditForm(),_5=_4?_4.getItems():[];for(var i=0;i<_5.length;i++){var _7=(_5[i].getHeight()+2*this.cellPadding);if(_7>_3)_3=_7}}
return this.body.updateHeightForEmbeddedComponents(_1,_2,_3)}
,isc.A.makeSelectionCanvas=function(_1){this.selectionCanvas=this.createAutoChild("selectionCanvas",{eventProxy:this.body,snapTo:"TL",width:"100%",height:"100%",destroyOnUnEmbed:false,percentSource:this,percentBox:"custom",grid:this,autoDraw:false});this.selectionUnderCanvas=this.createAutoChild("selectionUnderCanvas",{eventProxy:this.body,snapTo:"TL",width:"100%",height:"100%",destroyOnUnEmbed:false,percentSource:this,percentBox:"custom",grid:this,autoDraw:false})}
,isc.A.getSelectionCanvas=function(){if(!this.selectionCanvas)this.makeSelectionCanvas();return this.selectionCanvas}
,isc.A.getSelectionUnderCanvas=function(){if(!this.selectionUnderCanvas)this.makeSelectionCanvas();return this.selectionUnderCanvas}
,isc.A.updateSelectionCanvas=function(){var _1=this.selection,_2,_3,_4;if(isc.isA.CellSelection(_1)){var _5=_1.getSelectedCells()[0];_2=_5?_5[0]:-1,_3=_5?_5[1]:-1;_4=_5?this.getCellRecord(_2,_3):null}else{var _4=this.getSelectedRecord();_2=this.data?this.data.indexOf(_4):-1}
var _6=this.selectionCanvas,_7=_6?_6.embeddedRecord:null,_8=_6?_6.$289:-1,_9=_6?_6.$57n:-1;if(this.selectionCanvas==null){if(_4==null||!this.showSelectionCanvas)return}else if(this.showSelectionCanvas&&_7==_4&&_8==_2&&_9==_3)
{return}
if(this.showSelectionCanvas&&this.selectionType!=isc.Selection.SINGLE&&this.selectionType!=isc.Selection.NONE)
{this.logWarn("showSelectionCanvas is set to true, but not supported for selectionType "+this.selectionType);this.showSelectionCanvas=false}
if(!_4||_2==-1||!this.showSelectionCanvas){if(_7){this.removeEmbeddedComponent(_7,_6);var _10=this.selectionUnderCanvas;this.removeEmbeddedComponent(_7,_10)}
return}
var _6=this.getSelectionCanvas(),_10=this.getSelectionUnderCanvas();_6.record=_4;_10.record=_4;this.addEmbeddedComponent(_6,_4,_2,_3,"within");this.addEmbeddedComponent(_10,_4,_2,_3,"within")}
,isc.A.makeRollOverCanvas=function(){this.rollOverCanvas=this.createAutoChild("rollOverCanvas",{eventProxy:this.body,percentSource:this,percentBox:"custom",destroyOnUnEmbed:false,grid:this,autoDraw:false});this.rollUnderCanvas=this.createAutoChild("rollUnderCanvas",{eventProxy:this.body,percentSource:this,percentBox:"custom",destroyOnUnEmbed:false,grid:this,autoDraw:false})}
,isc.A.getRollOverCanvas=function(){if(!this.rollOverCanvas)this.makeRollOverCanvas();return this.rollOverCanvas}
,isc.A.getRollUnderCanvas=function(){if(!this.rollUnderCanvas)this.makeRollOverCanvas();return this.rollUnderCanvas}
,isc.A.updateRollOverCanvas=function(_1,_2,_3){if(_3||!this.showRollOverCanvas||_1==-1){if(this.rollOverCanvas){this.removeEmbeddedComponent(this.rollOverCanvas.embeddedRecord,this.rollOverCanvas);this.removeEmbeddedComponent(this.rollUnderCanvas.embeddedRecord,this.rollUnderCanvas)}
return}
var _4=this.getCellRecord(_1,_2);if(!this.useCellRollOvers)_2=null;var _5=this.getRollOverCanvas(),_6=this.getRollUnderCanvas();_5.record=_4;_6.record=_4;if(!this.useCellRollOvers)_2=null;this.addEmbeddedComponent(_5,_4,_1,_2,"within");this.addEmbeddedComponent(_6,_4,_1,_2,"within")}
,isc.A.updateEmbeddedComponentZIndex=function(_1){if(!_1)return;if(this.selectionCanvas==_1){var _2=this.body.getTableZIndex();this.selectionCanvas.setZIndex(_2+50)}
if(this.selectionUnderCanvas==_1){var _2=this.body.getTableZIndex();this.selectionUnderCanvas.setZIndex(_2-100)}
if(this.rollOverCanvas==_1){var _2=this.body.getTableZIndex();_1.setZIndex(_2+100)}
if(this.rollUnderCanvas==_1){var _2=this.body.getTableZIndex();_1.setZIndex(_2-50)}}
,isc.A.getButtonProperties=function(){var _1={align:null};if(this.headerTitleStyle!=null)_1.titleStyle=this.headerTitleStyle;if(this.headerBaseStyle!=null)_1.baseStyle=this.headerBaseStyle;if(this.headerButtonSrc!=null)_1.src=this.headerButtonSrc;if(this.frozenHeaderBaseStyle!=null)
_1.frozenBaseStyle=this.frozenHeaderBaseStyle;if(this.frozenHeaderTitleStyle!=null)
_1.frozenTitleStyle=this.frozenHeaderTitleStyle;if(this.frozenHeaderButtonSrc!=null)
_1.frozenSrc=this.frozenHeaderButtonSrc;var _2=isc.addProperties({},this.headerButtonDefaults,_1,this.headerButtonProperties);return _2}
,isc.A.getHeaderButtonProperties=function(_1){var _2=this.getButtonProperties();if(this.buttonTitleFunction==null){this.buttonTitleFunction=new Function("return this.parentElement.grid.getHeaderButtonTitle(this)")}
isc.addProperties(_2,{defaultRadioGroup:this.getID()+"$34f",getActionType:function(_9,_10,_11,_12){var _3=this.parentElement,_4;if(_3)_4=_3.grid;if(_4&&isc.isA.ListGrid(_4)){var _5=_4.fields[_3.getButtonNumber(this)];var _6=(_4.canSort!=false);if(_6&&_5!=null)_6=(_5.canSort!=false);if(_6)return isc.Button.RADIO}
return this.invokeSuper(null,"getActionType",_9,_10,_11,_12)},getTitle:this.buttonTitleFunction,mouseOver:function(){var _4=this.parentElement.grid;if(_4.shouldShowHeaderMenuButton(this)){var _7=_4.getHeaderMenuButton();this.addPeer(_7);_7.addProperties({dragTarget:this});if(this.zIndex>_7.zIndex)_7.bringToFront();if(!_7.isVisible()){_7.show()}}
return this.Super("mouseOver",arguments)},mouseOut:function(){var _4=this.parentElement.grid,_8=_4.headerMenuButton;if(_8&&_8.isVisible()&&_8.masterElement==this&&isc.EH.getTarget()!=_8)
{_4.headerMenuButton.hide()}
return this.Super("mouseOut",arguments)}},_1);return _2}
,isc.A.makeHeader=function(_1){if(this.header!=null)return;if(this.headerSpans){this.spanMap={};for(var i=0;i<this.headerSpans.length;i++){var _3=this.headerSpans[i];for(var j=0;j<_3.fields.length;j++){this.spanMap[_3.fields[j]]=_3}}}
var _5=this.header=this.makeHeaderForFields(this.normalFields||this.fields);if(this.sorter==null)this.makeCornerSortButton();this.headers=[_5];if(!this.frozenFields){this.addChild(_5,null,!_1);return}
var _6=this.frozenHeader=this.makeHeaderForFields(this.frozenFields,"visible",this.getID()+"$51f");if(this.freezeLeft()){this.headers.unshift(this.frozenHeader)}else{this.headers.add(this.frozenHeader)}
this.headerLayout=this.createAutoChild("headerLayout",{autoDraw:false,overflow:"hidden",height:this.headerHeight,members:this.headers},isc.HLayout)
this.addChild(this.headerLayout,null,!_1)}
,isc.A.makeHeaderForFields=function(_1,_2,_3){var _4=this.createHeader({ID:_3,grid:this,buttons:_1.duplicate(),reorderOnDrop:false,height:null,tabWithinToolbar:false,overflow:_2||"hidden",$nu:!this.fixedFieldWidths})
this.observe(_4,"scrollTo","observer.headerScrolled()");return _4}
,isc.A.createHeader=function(_1){var _2=this;var _3=isc.addProperties({makeButton:function(_4){if(_4.headerTitleStyle)_4.titleStyle=_4.headerTitleStyle;else if(_4.frozen&&this.buttonProperties.frozenTitleStyle)
_4.titleStyle=_4.frozenTitleStyle;if(_4.frozen&&this.buttonProperties.frozenSrc)
_4.src=this.buttonProperties.frozenSrc;_4.showIf=null;var _4=this.Super("makeButton",arguments);if(_4.$63f)_4.canReorder=false;var _5;if(_4.headerBaseStyle){_4.baseStyle=_4.headerBaseStyle;_5=true}else if(!_5){if(_4.frozen&&this.buttonProperties.frozenBaseStyle)
_4.setBaseStyle(this.buttonProperties.frozenBaseStyle);else if(this.buttonProperties.baseStyle!=null)
_4.setBaseStyle(this.buttonProperties.baseStyle)}
return _4},buttonProperties:this.getHeaderButtonProperties(),border:this.headerBorder,styleName:this.headerBarStyle,backgroundColor:this.headerBackgroundColor,backgroundImage:this.headerBackgroundImage,tabIndex:(this.canTabToHeader?this.getTabIndex():-1),canResizeItems:this.canResizeFields,canReorderItems:this.canReorderFields,dontObserve:false,childVisibilityChanged:function(){this.Super("childVisibilityChanged",arguments);this.$55g()},$3j:function(){this.Super("$3j",arguments);this.$55g()},spannedFields:Array.create({sortUnique:true}),addSpan:function(_13,_18){if(!this.$55h)this.$55h=[];this.$55h.add(_13);this.spannedFields.addList(_18);if(this.isDrawn()){this.$55i(_13);this.addChild(_13)}},$55g:function(){if(!this.$55h||!this.isDrawn())return;var _6=this.instantRelayout;this.instantRelayout=false;for(var i=0;i<this.$55h.length;i++)this.$55i(this.$55h[i]);this.instantRelayout=_6},$55i:function(_13){if(!this.isDrawn()){return}
if(_13.$55j){_13.setHeight(Math.floor(this.getVisibleHeight()/2))}
var _8=this.members.findAll("name",_13.$55k);if(!_8){_13.hide();return}
var _9,_10=0;for(var i=0;i<_8.length;i++){var _11=_8[i];_11.canReorder=false;_11.layoutAlign="bottom";if(_11.visibility!=isc.Canvas.HIDDEN){_10+=_11.getVisibleWidth();if(!_9||this.isRTL())_9=_11}}
if(_9){_13.show();_13.setLeft(_9.getLeft());_13.setWidth(_10)}},$58r:function(){if(!this.$55h)return;this.$55g();var _12=this.getVisibleHeight();for(var i=0;i<this.$55h.length;i++){var _13=this.$55h[i];this.addChild(_13);var _8=this.members.findAll("name",_13.$55k);if(!_8)continue;for(var j=0;j<_8.length;j++){var _15=_8[j],_16=_15.getVisibleHeight(),_17=_13.getVisibleHeight();if(_17+_16>_12)_15.setHeight(_16-_17)}
_13.bringToFront()}},addButtons:function(_18,_19){this.Super("addButtons",arguments);if(_2.headerSpans)_2.$60x(_18,this);this.$58r()},draw:function(){if(this.$55h&&_2.unspannedHeaderVAlign){for(var i=0;i<this.buttons.length;i++){var _4=this.buttons[i];if(!this.spannedFields.contains(_4.name))_4.valign=_2.unspannedHeaderVAlign}}
this.Super("draw",arguments);this.$58r()}},_1);if(this.headerButtonConstructor!=null)
_3.buttonConstructor=this.headerButtonConstructor;var _15=this.createAutoChild("header",_3,isc.Toolbar);if(_15.canReorderItems&&!_15.dontObserve){this.observe(_15,"itemDragReordered","observer.headerDragReordered(itemNum,newPosition,this)")}
if(_15.canResizeItems&&!_15.dontObserve)this.$62l(_15);if(this.headerSpans)this.$60x(_1.buttons,_15);return _15}
,isc.A.$60x=function(_1,_2){var _3=[],_4=_1.getProperty(this.fieldIdProperty);for(var i=0;i<this.headerSpans.length;i++){var _6=this.headerSpans[i];if(_4.intersect(_6.fields).length)_3.add(_6)}
for(var i=0;i<_3.length;i++){var _6=_3[i];var _7=this;var _8=isc.addProperties(this.getButtonProperties(),{_constructor:_2.buttonConstructor,height:this.headerSpanHeight,align:"center",valign:this.headerSpanVAlign,showRollOver:false,showContextMenu:function(){return _7.headerSpanContextClick(this)}},_6);var _9=_6.liveObject=this.createAutoChild("headerSpan",_8);_9.$55j=this.headerSpanHeight==null;if(_9.$55j){[this.headerSpanDefaults,this.headerSpanProperties,_6].map(function(_10){if(_10&&_10.height!=null)_9.$55j=false})}
_9.$55k=_6.fields;_2.addSpan(_9,_9.fields)}}
,isc.A.dirtyHeader=function(){if(this.header)this.header.markForRedraw()}
,isc.A.updateHeader=function(){if(this.frozenHeader)this.headerLayout.destroy();else if(this.header)this.header.destroy();this.header=this.frozenHeader=this.headerLayout=null;if(this.headerMenuButton&&this.headerMenuButton.destroyed){this.headerMenuButton=null}
if(this.showHeader){this.makeHeader(true)}else if(this.sorter){this.sorter.hide()}}
,isc.A.setHeaderHeight=function(_1){var _2=this.headerHeight;if(_2==_1)return;this.headerHeight=_1;if(this.showHeader==false)return;if(!this.header&&_1>0){if(this.isDrawn())this.makeHeader()}else{if(_2==0)this.updateHeader();this.layoutChildren(this.$616)}}
,isc.A.setShowHeader=function(_1){if(_1==this.showHeader)return;this.showHeader=_1;this.updateHeader();this.layoutChildren(this.$617)}
,isc.A.shouldShowHeaderMenuButton=function(_1){var _2;if(_1.showHeaderContextMenuButton!=null){_2=_1.showHeaderContextMenuButton}else{_2=this.showHeaderMenuButton}
if(this.showHeaderContextMenu&&_2){var _3=this.getHeaderContextMenuItems(_1.masterIndex);return(_3.length>0)}
return false}
,isc.A.getHeaderMenuButton=function(){if(!this.headerMenuButton){var _1={};if(this.headerMenuButtonHeight)_1.height=this.headerMenuButtonHeight;if(this.headerMenuButtonWidth)_1.width=this.headerMenuButtonWidth;if(this.headerMenuButtonIcon)_1.icon=this.headerMenuButtonIcon;if(this.headerMenuButtonIconHeight){_1.iconHeight=this.headerMenuButtonIconHeight}
if(this.headerMenuButtonIconWidth){_1.iconWidth=this.headerMenuButtonIconWidth}
if(this.headerMenuButtonBaseStyle){_1.baseStyle=this.headerMenuButtonBaseStyle}
if(this.headerMenuButtonTitleStyle){_1.titleStyle=this.headerMenuButtonTitleStyle}
if(this.headerMenuButtonSrc)_1.src=this.headerMenuButtonSrc;this.createAutoChild("headerMenuButton",_1,"Button",true)}
this.headerMenuButton.canDragResize=this.canResizeFields;return this.headerMenuButton}
,isc.A.headerMenuButtonClick=function(){var _1=this.header,_2=_1.getMouseOverButtonIndex();if(_2==-1&&this.frozenHeader){_1=this.frozenHeader;_2=_1.getMouseOverButtonIndex()}
if(_2==-1)return;var _3=_1.getMember(_2);var _4=_3.getPageBottom(),_5=this.$314?this.$314.getVisibleWidth():isc.Menu.getPrototype().defaultWidth,_6=Math.max(_3.getPageLeft(),(_3.getPageRight()-_5));return this.displayHeaderContextMenu(_3,[_6,_4])}
,isc.A.getHeaderButtonTitle=function(_1){var _2=_1;if(isc.isA.Object(_1))_2=_1.masterIndex;var _3=this.fields[_2];if(!_3)return"";var _4=(_2==this.$60z())&&(!this.showSortArrow||this.showSortArrow==isc.ListGrid.FIELD||this.showSortArrow==isc.ListGrid.BOTH),_5=this.getFieldTitle(_2);return _5+(_4?"&nbsp;"+this.getSortArrowImage():"")}
,isc.A.$63m=function(_1){var _2=this.isRTL()?this.fields.length:0,_3=this.fields[_2];var _4=this.getValueIconHTML(this.getValueIcon(_3,_1),_3);this.setFieldTitle(_2,_4);_3.$63h=_1}
,isc.A.headerClick=function(_1,_2){var _3=_2.getMember(_1).masterIndex,_4=this.fields[_3];if(this.isCheckboxField(_4)){if(_4.$63h){this.deselectAllRecords();this.$63m(false)}else{this.selectAllRecords();this.$63m(true)}
return false}
if(this.canSort==false||!_4||_4.canSort==false)return false;if(_3==this.$60z()){var _5=_4.sortDirection==null?this.sortDirection:_4.sortDirection;this.sort(_3,!Array.shouldSortAscending(_5))}else{this.sort(_3)}
return false}
,isc.A.fieldDragResizeStart=function(){this.makeDragLine();this._dragLine.resizeTo(2,this.getVisibleHeight()-(this.body.hscrollOn?this.getScrollbarSize():0));this.ns.EH.dragTarget.setOverflow("hidden")}
,isc.A.fieldDragResizeMove=function(_1){var _2=this.ns.EH,_3=_2.dragTarget;var _4=this.header.$6j;this.showDragLineForField(_4);if(this.resizeFieldsInRealTime){var _5=_2.dragResizeWidth;this.$26a[_4]=_5;this.$54e=true;this.setBodyFieldWidths(this.$26a);this.body.useQuickDrawAheadRatio=true;this.body.redraw("fieldDragResize");delete this.body.useQuickDrawAheadRatio;delete this.body.$54e;var _6=this.body.getScrollLeft();if(_6>0)this.header.scrollTo(_6)}}
,isc.A.fieldDragResizeStop=function(){this.hideDragLine()}
,isc.A.headerDragReordered=function(_1,_2,_3){var _4=_3.getMember(_1).masterIndex,_5=_3.getMember(_2).masterIndex;this.reorderField(_4,_5)}
,isc.A.reorderField=function(_1,_2){this.reorderFields(_1,_1+1,_2-_1)}
,isc.A.reorderFields=function(_1,_2,_3){var _4=this.fields[_1],_5=this.fields[_2-1],_6=_1+_3,_7=this.fields[_6];var _8=this.$60z(),_9=this.fields[_8];this.$26a.slideRange(_1,_2,_1+_3);if(this.completeFields.contains(_7)){var _10=this.completeFields.indexOf(_4),_11=this.completeFields.indexOf(_5)+1,_12=this.completeFields.indexOf(_7);this.completeFields.slideRange(_10,_11,_12)}
this.deriveVisibleFields()
if(_8!=null){_8=this.fields.indexOf(_9);if(_8==-1)_8=null;this.$600(_8)}
var _13;if(!this.frozenFields){_13=this.getFieldHeader(_1);if(_13){_13.reorderItems(this.getLocalFieldNum(_1),this.getLocalFieldNum(_2),this.getLocalFieldNum(_1+_3))}}else{this.rebuildForFreeze();_13=this.getFieldHeader(_1)}
if(_8!=null&&_13)
_13.selectButton(this.getLocalFieldNum(_8));var _14=this.$30a;if(_14){var _15=this.$286,_16=this.getEditRow(),_17=this.getEditField(),_18=[]
for(var i=0;i<_15.items.length;i++){var _20=_15.items[i];_20.colNum=this.fields.findIndex(this.fieldIdProperty,_20.getFieldName());for(var j=0;j<=_18.length;j++){if(_18[j]==null||_18[j].colNum>_20.colNum){_18.addAt(_20,j);break}}}
_15.items.setArray(_18);this.$30u=this.fields.indexOf(_17)}
if(this.body){this.body.fields=this.normalFields||this.fields;this.setBodyFieldWidths(this.$26a);if(!this.body.isDirty())this.$25a("reorderFields")}
if(this.showFilterEditor){this.filterEditor.reorderFields(_1,_2,_3)}
this.fieldStateChanged()}
,isc.A.remapEditFieldsForFreeze=function(){if(this.$30a){var _1=this.getEditForm(),_2=_1.getItems();for(var i=0;i<_2.length;i++){var _4=_2[i];_4.colNum=this.fields.findIndex(this.fieldIdProperty,_4.getFieldName());var _5=this.fields[_4.colNum];if(_5.frozen)_4.containerWidget=this.frozenBody;else _4.containerWidget=this.body}}}
,isc.A.headerDragResized=function(_1,_2,_3){var _4=_3.getMember(_1).masterIndex;this.resizeField(_4,_2)}
,isc.A.setCanResizeFields=function(_1){if(this.canResizeFields==_1)return;this.canResizeFields=_1;if(this.header)this.header.setCanResizeItems(_1);if(this.frozenHeader)this.frozenHeader.setCanResizeItems(_1);if(this.headerMenuButton)this.headerMenuButton.canDragResize=_1;if(_1){if(this.header&&!this.header.dontObserve)this.$62l(this.header);if(this.frozenHeader&&!this.frozenHeader.dontObserve)
this.$62l(this.frozenHeader)}else{if(this.header)this.$62m(this.header);if(this.frozenHeader)this.$62m(this.frozenHeader)}}
,isc.A.$62l=function(_1){this.observe(_1,"itemDragResized","observer.headerDragResized(itemNum,newSize,this)");this.observe(_1,"dragResizeMemberStart","observer.fieldDragResizeStart()");this.observe(_1,"dragResizeMemberMove","observer.fieldDragResizeMove()");this.observe(_1,"dragResizeMemberStop","observer.fieldDragResizeStop()")}
,isc.A.$62m=function(_1){if(this.isObserving(_1,"itemDragResized"))
this.ignore(_1,"itemDragResized");if(this.isObserving(_1,"dragResizeMemberStart"))
this.ignore(_1,"dragResizeMemberStart");if(this.isObserving(_1,"dragResizeMemberMove"))
this.ignore(_1,"dragResizeMemberMove");if(this.isObserving(_1,"dragResizeMemberStop"))
this.ignore(_1,"dragResizeMemberStop")}
,isc.A.resizeField=function(_1,_2){if(this.header&&this.header.isDrawn()){var _3=this.getFieldHeader(_1),_4=this.getLocalFieldNum(_1);_3.getMember(_4).setWidth(_2)}
this.fields[_1].width=_2;if(!this.isDrawn())return;this.$26a[_1]=_2;this.$54e=true;this.setBodyFieldWidths(this.$26a);if(this.body.isDirty())this.body.redraw("setting body field widths");delete this.$54e;if(this.showFilterEditor&&this.filterEditor){this.filterEditor.resizeField(_1,_2)}
this.fieldStateChanged()}
,isc.A.$313=function(){var _1=this.showSortArrow;if(_1!=null){return(_1==isc.ListGrid.CORNER||_1==isc.ListGrid.BOTH)}
return this.$54u()}
,isc.A.$54u=function(){if(this.leaveScrollbarGap)return true;if(!this.body||this.isEmpty())return false;if(this.body.vscrollOn)return true;var _1=this.body,_2=this.headerHeight,_3=this.getInnerHeight()-this.body.getVMarginBorder()-
(this.showHeader?_2:0);if(this.autoFitData==isc.Canvas.VERTICAL||this.autoFitData==isc.Canvas.BOTH){_3=(this.getTotalRows()*this.cellHeight);var _4=this.getAutoFitMaxBodyHeight();if(_4&&_4<_3){_3=_4}
if(this.autoFitMaxRows&&(this.autoFitMaxRows*this.cellHeight)>_3){_3=(this.autoFitMaxRows*this.cellHeight)}}
if(_3<=0)return false;return this.predictScrollbarGap&&this.bodyOverflow==isc.Canvas.AUTO&&(this.getTotalRows()*this.cellHeight>_3)}
,isc.A.getSorterLeft=function(){if(this.isRTL()){return this.getLeftMargin()+this.getLeftBorderSize()}else{return this.getWidth()-this.getScrollbarSize()-this.getHMarginBorder()}}
,isc.A.makeCornerSortButton=function(){this.addAutoChild("sorter",isc.addProperties(this.getButtonProperties(),this.sorterDefaults,{ID:this.getID()+"_sorter",left:this.getSorterLeft(),top:0,width:this.getScrollbarSize(),height:this.headerHeight,backgroundColor:this.headerBackgroundColor,imgDir:this.widgetImgDir,visibility:(this.$313()?isc.Canvas.INHERIT:isc.Canvas.HIDDEN)}))}
,isc.A.sorterContextClick=function(){var _1=this.showHeaderContextMenu;if(this.showCornerContextMenu!=null)_1=this.showCornerContextMenu;if(_1)return this.displayHeaderContextMenu(this.sorter)}
,isc.A.headerBarContextClick=function(_1){var _2=this.showHeaderContextMenu;if(this.showCornerContextMenu!=null)_2=this.showCornerContextMenu;if(_2){return this.displayHeaderContextMenu(_1.getMember(_1.getMouseOverButtonIndex()))}}
,isc.A.headerSpanContextClick=function(_1){var _2=this.getHeaderSpanContextMenuItems(_1);if(!_2||_2.length==0)return false;if(!this.$58q){this.$58q=isc.Menu.create({items:_2})}else{this.$58q.setItems(_2)}
this.$58q.showContextMenu();return false}
,isc.A.displayHeaderContextMenu=function(_1,_2){if(!_1)return;var _3=this.fields[_1.masterIndex];if(this.isCheckboxField(_3))return false;var _4=this.getHeaderContextMenuItems(_1.masterIndex);if(_4.length==0)return;if(!this.$314)this.$314=this.getHeaderContextMenu(_1);this.$314.setData(_4);if(_2!=null&&_2.length>0){this.$314.moveTo(_2[0],_2[1]);this.$314.show();return false}else{return this.$314.showContextMenu(_1)}}
,isc.A.getToggleFreezeText=function(_1){var _2={field:_1,viewer:this}
return _1.frozen?this.unfreezeFieldText.evalDynamicString(this,_2):this.freezeFieldText.evalDynamicString(this,_2)}
,isc.A.getGroupByText=function(_1){var _2={field:_1,viewer:this}
return this.groupByText.evalDynamicString(this,_2)}
,isc.A.$58f=function(_1){var _1=this.getField(_1);return!!(_1&&this.$58g(_1)&&this.data.getLength()<=this.groupByMaxRecords)}
,isc.A.$58g=function(_1){var _1=this.getField(_1);return!!(_1&&((this.canGroupBy==true&&_1.canGroupBy!=false)||(this.canGroupBy!=false&&_1.canGroupBy==true)))}
,isc.A.getHeaderSpanContextMenuItems=function(_1){if(!this.showTreeColumnPicker&&!this.showHeaderSpanContextMenu)return false;var _2=[{title:this.fieldVisibilitySubmenuTitle,submenu:this.getColumnPickerItems(),icon:"[SKINIMG]actions/column_preferences.png"}];var _3=this,_4;for(var i=0;i<_1.fields.length;i++){var _6=_1.fields[i],_7=this.getField(_6);if(_7&&_7.frozen){_4=true;break}}
if(this.canFreezeFields&&this.fields.length>1&&(_4||this.frozenFields==null||this.normalFields.length>_1.fields.length))
{_2.add({isSeparator:true});_2.add({title:(_4?"Unfreeze ":"Freeze ")+_1.title,grid:this,spanFields:_1.fields,frozen:_4,icon:(_4?"[SKINIMG]actions/unfreeze.png":"[SKINIMG]actions/freezeLeft.png"),click:function(){for(var i=0;i<this.spanFields.length;i++){_3.completeFields.find(_3.fieldIdProperty,this.spanFields[i]).frozen=!this.frozen}
_3.rebuildForFreeze()}})}
return _2}
,isc.A.shouldShowColumnPicker=function(_1){if(_1.treeField||this.isCheckboxField(_1))return false;var _2=this.getSummaryTitle(_1);if(_2==null||isc.isAn.emptyString(_2))return false;if(_1.canHide===false)return false;return true}
,isc.A.getColumnPickerItems=function(){var _1=[],_2=this;for(var i=0;i<this.completeFields.length;i++){var _4=this.completeFields[i];if(!this.shouldShowColumnPicker(_4))continue;var _5=this.getSummaryTitle(_4);var _6=this.spanMap?this.spanMap[_4.name]:null;if(this.showTreeColumnPicker&&_6){if(!_1.find("spanConfig",_6)){_1.add({title:_6.title,autoDismiss:false,spanConfig:_6,click:function(_16,_9,_17){var _7=this.spanConfig.fields;var _8=this.anySpannedFieldsVisible();_7.map(function(_18){_8?_2.hideField(_18):_2.showField(_18)});_17.body.delayCall("markForRedraw")},anySpannedFieldsVisible:function(){var _7=this.spanConfig.fields;for(var i=0;i<_7.length;i++){if(_2.fieldIsVisible(_7[i]))return true}
return false},enableIf:function(_16,_17,_9){var _6=this.spanConfig;for(var i=0;i<_17.data.length;i++){var _9=_17.data[i];if(_2.fieldIsVisible(_9.fieldName)&&!_6.fields.contains(_9.fieldName))return true}
return false},checkIf:function(_16,_17,_9){return this.anySpannedFieldsVisible()}})}
_5="&nbsp;&nbsp;&nbsp;&nbsp;"+_5}
_1.add({title:_5,fieldName:_4.name,prompt:_4.prompt,autoDismiss:false,checkIf:function(_16,_17,_9){return _2.fieldIsVisible(this.fieldName)},enableIf:function(_16,_17,_9){return!(_2.fields.length==1&&_2.fieldIsVisible(this.fieldName))},click:function(_16,_9,_17){var _10=_17.$35q,_11=_10?_10.data.findIndex("groupItem",true):null,_12=_10?_10.data[_11]:null,_13=(_12&&_12.fieldName==_9.fieldName);if(_2.fieldIsVisible(this.fieldName)){var _14=_2.fields.length;if(_2.selectionAppearance=="checkbox")_14-=1;if(_14>1){_2.hideField(_9.fieldName)}
if(_14==1){var _15=_17.data.find("fieldName",_2.fields[0].name);_17.setItemEnabled(_15,false);this.$58s=_15}}else{_2.showField(_9.fieldName);if(this.$58s){_17.setItemEnabled(this.$58s,true);this.$58s=null}}
if(_13){_10.setItemEnabled(_11,_2.$58f(_12.fieldName))}
_17.body.delayCall("markForRedraw")}})}
return _1}
,isc.A.getColumnPickerMenu=function(_1){var _2={canHover:true,showIcons:true,showHover:true,cellHoverHTML:function(_3){return _3.prompt},items:_1};return{title:this.fieldVisibilitySubmenuTitle,submenu:_2,icon:"[SKINIMG]actions/column_preferences.png"}}
,isc.A.getHeaderContextMenuItems=function(_1){var _2=this.getField(_1);var _3=[],_4=false;var _5=this.canSort&&((_2&&_2.canSort!=false)||(!_2&&this.$60z()!=null));if(_5){var _6=_1!=null?_1:this.$60z();_3[0]={title:this.sortFieldAscendingText,icon:"[SKINIMG]actions/sort_ascending.png",click:"menu.doSort("+_6+", 'ascending')"};_3[1]={title:this.sortFieldDescendingText,icon:"[SKINIMG]actions/sort_descending.png",click:"menu.doSort("+_6+", 'descending')"};_4=true}
if(this.canPickFields&&this.completeFields.length>1){var _7=this.getColumnPickerItems();if(_7.length>1){if(_4)_3.add({isSeparator:true});_3.add(this.getColumnPickerMenu(_7));_4=true}}
var _8=this.$58g(_2),_9=(this.canGroupBy!=false)&&this.isGrouped;if(_4&&(_9||_8)){_3.add({isSeparator:true})}
if(_8){var _10=(!_2.getGroupValue?_2.groupingModes?_2.groupingModes:(_2.$62?_2.$62.groupingModes:false):false);var _11=null;if(_10){_11=[];for(var _12 in _10){_11.add({title:_10[_12],groupType:_12,targetField:_2,fieldName:_2.name,prompt:_2.prompt,checked:(_2.groupingMode==_12),click:function(_13,_14,_15){this.targetField.groupingMode=this.groupType;_15.$35q.groupField(_14)}})}}
_3.add({groupItem:true,title:this.getGroupByText(_2),fieldName:_2.name,targetField:_2,prompt:_2.prompt,icon:"[SKINIMG]actions/groupby.png",click:function(_13,_14,_15){this.targetField.groupingMode=this.targetField.defaultGroupingMode||null;_15.groupField(_14)},enabled:this.$58f(_2),canSelectParent:true,submenu:_11});_4=true}
if(_9){_3.add({title:this.ungroupText,click:"menu.ungroup()",icon:"[SKINIMG]actions/ungroup.png"});_4=true}
if(!_2)return _3;if(this.canFreezeFields&&this.fields.length>1&&(_2.frozen||(this.frozenFields==null||this.normalFields.length>1))&&!(this.spanMap&&this.spanMap[_2.name]))
{if(_4)_3.add({isSeparator:true});_3.add({title:this.getToggleFreezeText(_2),grid:this,field:_2,icon:(_2.frozen?"[SKINIMG]actions/unfreeze.png":"[SKINIMG]actions/freezeLeft.png"),click:"item.grid.toggleFrozen(this.field,!this.field.frozen)"})}
return _3}
,isc.A.getHeaderContextMenu=function(){return this.ns.Menu.create({ID:this.getID()+"$314",grid:this,hide:function(){this.Super("hide",arguments);if(this.grid&&this.grid.headerMenuButton&&this.grid.headerMenuButton.isVisible()){this.grid.headerMenuButton.hide()}},doSort:function(_2,_3){this.grid.sort(_2,_3)},canHover:true,showHover:true,cellHoverHTML:function(_2,_3,_4){return _2.prompt},groupField:function(_2){var _1=this.grid;if((_2.targetField&&_2.targetField.groupingMode)||((!_1.groupByField)||!_1.groupByField.contains(_2.fieldName))){_1.groupBy(_2.fieldName)}},ungroup:function(){this.grid.ungroup()}})}
,isc.A.getSortArrowImage=function(){var _1=this.$60z();if(this.canSort&&_1!=null){return this.imgHTML((Array.shouldSortAscending(this.getField(_1).sortDirection)?this.sortAscendingImage:this.sortDescendingImage),null,null,null,null,this.widgetImgDir)}else{return isc.Canvas.spacerHTML(1,1)}}
,isc.A.sorterClick=function(){if(!this.canSort)return false;var _1=this.$60z();this.sort(_1,(_1!=null?!Array.shouldSortAscending(this.getField(_1).sortDirection):null))}
,isc.A.makeDragLine=function(){if(this._dragLine)return false;var _1={ID:this.getID()+"_dragLine",width:2,height:2,overflow:isc.Canvas.HIDDEN,visibility:isc.Canvas.HIDDEN,isMouseTransparent:true,dropTarget:this.body,redrawOnResize:false,styleName:"dragLine"};if(this.ns.Element.getStyleEdges(_1.styleName)==null){_1.backgroundColor="black"}
this._dragLine=this.ns.Canvas.create(_1);return true}
,isc.A.showDragLineForRecord=function(_1,_2){var _3=this.body;if(_1==null)_1=this.getEventRecordNum();var _4=_3.getVisibleRows()[1];if(_1==-2)_1=_4;if(!this.recordIsEnabled(_1)&&_1!=_4)return this._dragLine.hide();if(_2==null)_2=this.getReorderPosition(_1);var _5=this.getLeftBody();var _6=_5.getPageLeft()+(this.isRTL()&&_5.vscrollOn?this.getScrollbarSize():0);if(_2==isc.ListGrid.BEFORE){this.showHDragLine(_6,_3.getRowPageTop(_1));this._dragLine.afterRow=_1-1}else if(_2==isc.ListGrid.AFTER){this.showHDragLine(_6,(_3.getRowPageTop(_1)+_3.getRowSize(_1)));this._dragLine.afterRow=_1}else{return this._dragLine.hide()}
if(this.recordDropMove){this.fireCallback("recordDropMove","viewer,recordNum,record,position",[this,_1,this.getRecord(_1),_2])}}
);isc.evalBoundary;isc.B.push(isc.A.showHDragLine=function(_1,_2){this.makeDragLine();this._dragLine.resizeTo(this.getViewportWidth()-(this.body.vscrollOn?this.getScrollbarSize():0),2);var _3=this.body.getPageTop(),_4=_3+this.body.getVisibleHeight();if(_2<_3)_2=_3;else if(_2>_4)_2=_4;this._dragLine.setPageRect(_1,_2);this._dragLine.show();this._dragLine.bringToFront()}
,isc.A.showDragLineForField=function(_1,_2){this.makeDragLine();if(_2==true){this._dragLine.resizeTo(2,this.headerHeight)}else{this._dragLine.resizeTo(2,this.getOuterViewportHeight())}
if(_1==null)_1=this.getEventFieldNum();if(_1<0){this._dragLine.hide();return}
var _3=this.ns.EH.dragTarget,_4=(!this.isRTL()?_3.getPageLeft()+this.ns.EH.dragResizeWidth:_3.getPageRight()-this.ns.EH.dragResizeWidth)-1;this._dragLine.setPageRect(_4,this.getPageTop()+(this.showFilterEditor?this.filterEditorHeight:0));this._dragLine.bringToFront();this._dragLine.show()}
,isc.A.hideDragLine=function(){if(this._dragLine)this._dragLine.hide()}
,isc.A.unsort=function(){if(this.data.unsort&&this.data.unsort()){var _1=this.$60z();this.$600(null);if(_1!=null&&this.header&&isc.isA.Toolbar(this.header)){this.header.deselectButton(_1);var _2=this.header.getButton(_1);if(_2)_2.setTitle(this.getHeaderButtonTitle(_2))}
if(this.sorter)this.sorter.setTitle(this.sorter.getTitle())}}
,isc.A.resort=function(){var _1=this.$60z();this.$600(null);return this.sort(_1)}
,isc.A.sort=function(_1,_2){if(this.canSort==false)return false;if(isc.isA.String(_1))_1=this.getFieldNum(_1);if(this.confirmDiscardEdits&&this.dataSource!=null){if(this.hasChanges()&&isc.ResultSet&&isc.isA.ResultSet(this.data)&&!this.data.allMatchingRowsCached())
{this.showLostEditsConfirmation({target:this,methodName:"$34g"},{target:this,methodName:"$34h"});this.$34i={sortFieldNum:_1,sortDirection:_2}
return}}
var _3=this.$60z(),_4=(_3!=null?Array.shouldSortAscending(this.getField(_3).sortDirection):null);if(_1==null){if(_3!=null){_1=_3}else{for(var i=0;i<this.fields.length;i++){if(this.fields[i].canSort!=false){_1=i;break}}}}
if(_1==null)return false;var _6=this.getField(_1);if(_6==null||_6.canSort==false)return;if(_2==null){_2=(_6.sortDirection!=null?_6.sortDirection:this.sortDirection)}
this.sortDirection=_2=Array.shouldSortAscending(_2);if(_3==_1&&_2==_6.sortDirection)return;this.$600(_1);_6.sortDirection=_2;this.sortData();if(this.header&&isc.isA.Toolbar(this.header)){var _7=this.getFieldHeader(_1);_7.selectButton(this.getLocalFieldNum(_1));if(_3!=null&&_3!=_1){var _8=this.getFieldHeader(_3),_9=_8.getButton(this.getLocalFieldNum(_3));if(_9!=null){_9.setTitle(_9.getTitle())}}
if(_1!=_3||_6.sortDirection!=_4){var _10=_7.getButton(this.getLocalFieldNum(_1));if(_10!=null){_10.setTitle(_10.getTitle())}}}
if(this.sorter&&_4!=_6.sortDirection){this.sorter.setTitle(this.sorter.getTitle())}
this.$25a(this.$31g);return true}
,isc.A.$60z=function(){if(this.sortFieldNum!=null)return this.sortFieldNum;if(this.sortField!=null){var _1=this.getFieldNum(this.sortField);if(_1==-1)_1=null;this.sortFieldNum=_1;var _2=this.getFieldName(this.sortField);this.sortField=_2;return _1}
return null}
,isc.A.$600=function(_1){this.sortFieldNum=_1;var _2=this.getFieldName(_1);this.sortField=_2}
,isc.A.$34g=function(){var _1=this.$34i,_2=_1.sortFieldNum,_3=_1.sortDirection;delete this.$34i;this.sort(_2,_3)}
,isc.A.$34h=function(){var _1=this.$34i.sortFieldNum;delete this.$34i;if(this.sortFieldNum!=_1)this.header.deselectButton(_1)}
,isc.A.sortData=function(){if(!this.data||!this.fields)return;var _1=this.fields[this.$60z()],_2=null;if(_1==null){this.$600(0);_1=this.fields[0]}
if(_1.sortNormalizer){_2=_1.sortNormalizer}else if(_1.valueMap){_2=_1.valueMap;if(isc.isA.String(_1.valueMap))_2=this.getGlobalReference(_1.valueMap)}else if(_1.type!=null){_2=_1.type}
this.data.sortByProperty(_1[this.fieldIdProperty],_1.sortDirection,_2,this)}
,isc.A.getRecordDataSource=function(_1){return this.dataSource}
,isc.A.openRecordEditor=function(_1){if(this.$32o!=null)this.closeRecord();var _2=isc.addProperties({},_1);var _3=this.ns.DynamicForm.create(this.recordEditorProperties,{autoDraw:false,dataSource:this.getRecordDataSource(_1),numCols:4,values:_2,$34j:_1});var _4=this.ns.VStack.create({autoDraw:false,width:this.getAvailableFieldWidth()-this.embeddedComponentIndent,left:this.embeddedComponentIndent,destroyOnUnEmbed:true,members:[_3,this.ns.Toolbar.create({autoDraw:false,width:200,buttons:[{title:this.recordEditorSaveButtonTitle,click:this.getID()+".embeddedSaveRecord("+_3.getID()+")",extraSpace:10},{title:this.recordEditorCancelButtonTitle,record:_1,grid:this,click:function(){var _5=this.parentElement.parentElement;this.grid.closeRecord(this.record,_5)}}]})]});this.addEmbeddedComponent(_4,_1,this.data.indexOf(_1));this.$32o=_1;this.$57o=_4}
,isc.A.embeddedSaveRecord=function(_1){_1.saveData({target:this,methodName:"embeddedEditComplete"},{$34j:_1.$34j,$57p:_1})}
,isc.A.embeddedEditComplete=function(_1,_2,_3){if(_1.status==0){this.removeEmbeddedComponent(_3.$34j,_3.$57p)}}
,isc.A.closeRecord=function(_1,_2){if(!_1)_1=this.$32o;if(!_2)_2=this.$57o;this.removeEmbeddedComponent(_1,_2);this.$32o=null;this.$57o=null}
,isc.A.openRecordDetailGrid=function(_1,_2){if(this.$32o!=null)this.closeRecord();var _3=this.getRecordDetailGrid(_1,_2);var _4=isc.VLayout.create({autoDraw:false,destroyOnUnEmbed:true,height:this.cellHeight,left:this.embeddedComponentIndent,width:this.getAvailableFieldWidth()-this.embeddedComponentIndent,resizeBarSize:4,members:[_3]});this.addEmbeddedComponent(_4,_1,this.data.indexOf(_1));var _2=isc.DataSource.getDataSource(_3.dataSource);_3.fetchRelatedData(_1,this.getRecordDataSource(_1));this.$32o=_1;this.$57o=_4}
,isc.A.getRecordDetailGrid=function(_1,_2){_2=isc.DataSource.getDataSource(_2);var _3=isc.ListGrid.create(this.recordDetailGridProperties,{autoDraw:false,dataSource:_2,showResizeBar:true,showCellContextMenus:this.showCellContextMenus},this.nestedGridDefaults);return _3}
,isc.A.chartData=function(_1,_2,_3,_4,_5){if(_1)_1=this.getField(_1);if(_2)_2=this.map("getField",_2);else{_2=this.fields.duplicate();_2.remove(_1)}
if(!_3){if(!isc.ResultSet||!isc.isA.ResultSet(this.data)){_3=this.data}else if(this.data.allMatchingRowsCached()){_3=this.data.getAllRows()}else{var _6=this.getVisibleRows();_3=this.data.getRange(_6[0],_6[1])}}
var _7,_8;if(_2.length>1){_8={title:this.valueTitle,values:_2,inlinedValues:true}}
if(_3.length>1&&_1){_7={id:_1.name}}
var _9=[_8,_7];_9.remove(null);if(_5)_9.reverse();var _10=isc.addProperties({data:_3,facets:_9,title:this.chartTitle},_4);if(_7&&!_8)_10.valueProperty=_2[0].name;return this.createAutoChild("chart",_10,this.chartConstructor)}
,isc.A.chartRow=function(_1,_2,_3){return this.chartData(null,_2,[this.getRecord(_1)],_3)}
,isc.A.chartColumn=function(_1,_2,_3){return this.chartData(_2,[_1],null,_3)}
,isc.A.regroup=function(_1){if(!this.isGrouped||(this.canGroupBy==false)||!this.groupByField||!this.groupByField.length||this.inhibitRegroup||!(this.originalData||this.data)||!(this.originalData||this.data).getLength())
{return}
var _2;if(this.data.isGroupedOutput&&this.originalData)_2=this.originalData;else this.originalData=_2=this.data;var _3=_2.getLength();if(isc.ResultSet&&isc.isA.ResultSet(_2)&&(!_2.lengthIsKnown()||!_2.rangeIsLoaded(0,_3-1)))
{_2.getRange(0,_3-1);this.$52y=true;this.logInfo("postponing grouping until data is loaded","grouping");return}
if(_3>=this.groupByMaxRecords){this.logInfo("Results too numerous - disabling grouping.","grouping");this.isGrouped=false;if(this.originalData)this.data=this.originalData;return}
if(this.groupTree){this.ignore(this.groupTree,"changeDataVisibility");this.groupTree.destroy()}
this.groupTree=this.createAutoChild("groupTree",{dataSource:this.dataSource,defaultLoadState:isc.Tree.LOADED,loadDataOnDemand:false,parentIdField:"groupParentId",titleProperty:"groupValue",childrenProperty:"groupMembers",parentProperty:"_groupTree_"+this.ID,showRoot:false,isGroupedOutput:true},(this.dataSource?isc.ResultTree:isc.Tree));this.logInfo("Adding "+_2.getLength()+" records to groups","grouping");for(var i=0;i<_2.getLength();i++){this.$52u(_2.get(i),false)}
var _5=this.groupTree.getRoot(),_6=0,_7=0,_8=this.groupTree;while(_5!=null&&_7<this.groupByField.length){var _9=_8.getChildren(_5);for(var i=0;i<_9.length;i++){var _10=(this.completeFields||this.fields).find(this.fieldIdProperty,this.groupByField[_7]);var _11=_10.getGroupTitle?"false":!_10.getGroupValue?(_10.$62&&_10.$62.getGroupTitle)?"true":null:null;if(_11=="false"){var _12=_9[i];_12.singleCellValue=_10.getGroupTitle(_12.groupValue,_12,_10,_10.name,this)}
else if(_11=="true"){var _12=_9[i];_12.singleCellValue=_10.$62.getGroupTitle(_12.groupValue,_12,_10,_10.name,this)}}
if(_8.getParent(_5)&&_8.getChildren(_8.getParent(_5))[_6+1]){_6++;_5=_8.getChildren(_8.getParent(_5))[_6]}else{_5=_8.getChildren(_5).first();_6=0;_7++}}
this.openInitialGroups();this.data=_8;if(!_1){this.$606(this.data)}else{this.observe(_8,"changeDataVisibility","observer.$34u()")}
this.createSelectionModel()}
,isc.A.$607=function(_1,_2,_3,_4){this.$34v=true;var _5=this.data.getParents(_2);var _6=this.data.remove(_2);for(var i=0,j=this.groupByField.length-1;i<_5.length-1;i++){var _9=_5[i];if(_9.groupMembers.getLength()==0){this.data.remove(_9)}else{var _10=(this.completeFields||this.fields).find(this.fieldIdProperty,this.groupByField[j]);var _11=_10.getGroupTitle?"false":!_10.getGroupValue?(_10.$62&&_10.$62.getGroupTitle)?"true":null:null;if(_11=="false"){_9.singleCellValue=_10.getGroupTitle(_9.groupValue,_9,_10,_10.name,this)}
else if(_11=="true"){_9.singleCellValue=_10.$62.getGroupTitle(_9.groupValue,_9,_10,_10.name,this)}}
j--}
if(!(_2&&!_6)&&(_1||_4))
this.$52u(_1||_4,true)}
,isc.A.openInitialGroups=function(){var _1=this.groupTree;if(this.groupStartOpen=="all"){_1.openAll()}else if(this.groupStartOpen=="first"){_1.openAll(_1.getChildren(_1.getRoot()).first())}else if(isc.isAn.Array(this.groupStartOpen)){var _2=_1.getChildren(_1.getRoot());for(var i=0;i<this.groupStartOpen.length;i++){var _4=this.groupStartOpen[i];var _5=_2.find("groupValue",_4);if(_5)_1.openFolder(_5)}}}
,isc.A.groupBy=function(_1){var _2=[];if(isc.isAn.Array(_1)){_2=_1}else{_2=arguments}
if(_2.length==0||_2[0]==null){this.logInfo("ungrouping","grouping");this.isGrouped=false;if(this.originalData){this.setData(this.originalData);delete this.originalData;delete this.groupTree;if(this.groupByField)this.groupByField.setLength(0)}
return}
if(this.groupByField)this.groupByField.setLength(0);else this.groupByField=[];for(var i=0;i<_2.length;i++){if(this.isCheckboxField(_2[i]))continue;this.groupByField.add(_2[i])}
this.logInfo("groupBy: "+this.groupByField,"grouping");this.isGrouped=true;this.$52y=true;this.dataChanged()}
,isc.A.getGroupNodeHTML=function(_1,_2){var _3=this.frozenBody===_2;if(this.frozenBody&&!_3)return this.emptyCellValue;var _4=this.data.isOpen(_1)?"opened":"closed",_5=isc.Img.urlForState(this.groupIcon,null,null,_4),_6=isc.Canvas.spacerHTML(this.groupIconPadding,1),_7=isc.Canvas.spacerHTML((this.data.getLevel(_1)-1)*this.groupIndentSize+this.groupLeadingIndent,1);var _8=this.imgHTML(_5,this.groupNodeSize,this.groupNodeSize);return _7+_8+_6+_1[this.singleCellValueProperty]}
,isc.A.$52u=function(_1,_2){var _3,_4=this.groupTree.getRoot();for(var i=0;i<this.groupByField.length;i++){var _6=this.groupByField[i],_7=(this.completeFields||this.fields).findIndex(this.fieldIdProperty,_6),_8=(this.completeFields||this.fields).get(_7);var _9=this.getRawCellValue(_1,i,_6,true);if(_8.getGroupValue){_9=_8.getGroupValue(_9,_1,_8,_6,this)}
else if(_8.$62&&_8.$62.getGroupValue){_9=_8.$62.getGroupValue(_9,_1,_8,_6,this)}
if(_8.valueMap&&_8.valueMap[_9]){_9=_8.valueMap[_9]}
if(_9==null||isc.isAn.emptyString(_9)){_9=this.nullGroupTitle}
if(this.groupTree.getChildren(_4)==null)_3=null;else _3=this.groupTree.getChildren(_4).find('groupValue',_9);if(!_3){_3={singleCellValue:_9,groupValue:_9,$52e:true,canDrag:false};_3[_6]=_9;_3[this.recordCustomStyleProperty]=this.groupNodeStyle
_3[this.recordEditProperty]=false
this.groupTree.add(_3,_4)}
_4=_3}
this.groupTree.add(_1,_4);if(_2){var _10=this.groupTree.getParents(_1);for(var i=_10.length-2,j=0;i>=0;i--,j++){var _12=(this.completeFields||this.fields).find(this.fieldIdProperty,this.groupByField[j]);var _13=_12.getGroupTitle?"false":!_12.getGroupValue?(_12.$62&&_12.$62.getGroupTitle)?"true":null:null;if(_13=="false"){var _14=_10[i];_14.singleCellValue=_12.getGroupTitle(_14.groupValue,_14,_12,_12.name,this)}
else if(_13=="true"){var _14=_10[i];_14.singleCellValue=_12.$62.getGroupTitle(_14.groupValue,_14,_12,_12.name,this)}}}}
,isc.A.ungroup=function(){this.groupBy(null)}
,isc.A.setHeaderSpans=function(_1){this.headerSpans=_1;this.updateHeader();this.layoutChildren("headerSpans changed")}
,isc.A.setHeaderSpanTitle=function(_1,_2){var _3=this.headerSpans.find("name",_1);if(!_3){this.logWarn("setHeaderSpanTitle() - unable to locate span named: "+_1+this.getStackTrace());return}
_3.title=_2;if(_3.liveObject)_3.liveObject.setTitle(_2)}
,isc.A.addBodyPassthroughMethods=function(_1){if(!this.body)return;this.bodies.map("$51e")}
,isc.A.$51e=function(_1){var _2={},_3=isc.getKeys(isc.ListGrid.$30f);for(var i=0;i<_3.length;i++){var _5=_3[i],_6=this[_5];if(_5=="cellContextClick")continue;if(_6==null){_2[_5]=_1.getClass().getPrototype()[_5]}else if(_6!=isc.ListGrid.$30g[_5]){_2[_5]=isc.ListGrid.$30f[_5]}}
_1.addMethods(_2)}
,isc.A.addProperties=function(_1){this.Super("addProperties",arguments);this.addBodyPassthroughMethods()}
,isc.A.addMethods=function(_1){this.Super("addMethods",arguments);this.addBodyPassthroughMethods()}
,isc.A.propertyChanged=function(_1,_2){this.invokeSuper(isc.ListGrid,"propertyChanged",_1,_2);if(this.$31h[_1])this.$34k=true;if(this.body==null)return;if(isc.ListGrid.$295.contains(_1)){this.body[_1]=_2}
if(this.$45l[_1]!=null){this.body.setProperty(this.$45l[_1],_2);this.markForRedraw()}}
,isc.A.doneSettingProperties=function(){if(this.$34k)this.$31i()}
);isc.B._maxIndex=isc.C+529;isc.ListGrid.registerStringMethods(isc.GridRenderer.$294);isc.ListGrid.registerStringMethods({recordClick:"viewer,record,recordNum,field,fieldNum,value,rawValue",recordDoubleClick:"viewer,record,recordNum,field,fieldNum,value,rawValue",recordsDropped:"records,rowNum,viewer,sourceWidget",recordDropMove:"viewer,recordNum,record,position",editValueChanged:"rowNum,fieldName,newValue,oldValue",editorChange:"record,newValue,oldValue,rowNum,colNum",cellChanged:"record,newValue,oldValue,rowNum,colNum,grid,recordNum,fieldNum",editComplete:"rowNum,colNum,newValues,oldValues,editCompletionEvent,dsResponse",editFailed:"rowNum,colNum,newValues,oldValues,editCompletionEvent,dsResponse,dsRequest",editorEnter:"record,value,rowNum,colNum",rowEditorEnter:"record,editValues,rowNum",editorExit:"editCompletionEvent,record,newValue,rowNum,colNum",rowEditorExit:"editCompletionEvent,record,newValues,rowNum",validateCellValue:"rowNum,colNum,newValue,oldValue",validateFieldValue:"newValue,oldValue,record,field,rowNum,colNum",formatCellValue:"value,record,rowNum,colNum",formatEditorValue:"value,record,rowNum,colNum",parseEditorValue:"value,record,rowNum,colNum",fieldStateChanged:""});isc.ListGrid.$24j=isc.addProperties({},isc.ListGrid.getInstanceProperty("headerDefaults"));isc.ListGrid.$24k=isc.addProperties({},isc.ListGrid.getInstanceProperty("headerButtonDefaults"));isc.ListGrid.classInit();isc.defineClass("HiliteEditor","SectionStack");isc.A=isc.HiliteEditor.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.hilitesDSDefaults={_constructor:"DataSource",clientOnly:true,fields:[{name:"id",primaryKey:true,type:"sequence"}]};isc.A.hiliteListDefaults={_constructor:isc.ListGrid,selectionType:"single",leaveScrollbarGap:false,recordCSSTextProperty:"$62t",fields:[{name:"fieldName",title:"Target Field",recordClick:function(_1){_1.creator.hiliteClicked()}},{name:"sample",title:"Sample",formatCellValue:function(_1,_2){return"<span style='"+_2.cssText+"'>Sample Text</span>"},recordClick:function(_1){_1.creator.hiliteClicked()}},{name:"Delete",type:"icon",iconSize:16,icon:"[SKINIMG]/actions/remove.png",recordClick:function(_1){_1.removeSelectedData()}}]};isc.A.hiliteEditorDefaults={_constructor:isc.VStack};isc.A.filterBuilderDefaults={_constructor:"FilterBuilder",autoParent:"hiliteEditor",isGroup:true,groupTitle:"Filter",padding:8};isc.A.hiliteFormDefaults={_constructor:"DynamicForm",autoParent:"hiliteEditor",isGroup:true,groupTitle:"Appearance",extraSpace:4,padding:8,numCols:4,items:[{title:"Target Field(s)",name:"fieldName",multiple:true,type:"select",rowSpan:2,defaultDynamicValue:"isc.firstKey(item.valueMap)"},{title:"Text",name:"textColor",type:"color"},{title:"Background",name:"backgroundColor",type:"color"}]};isc.A.hiliteButtonsDefaults={_constructor:isc.HLayout,membersMargin:8,height:1,autoParent:"hiliteEditor"};isc.A.addButtonDefaults={_constructor:"IButton",autoParent:"hiliteButtons",title:"Save",click:function(){this.creator.saveHilite()}};isc.A.newButtonDefaults={_constructor:"IButton",autoParent:"hiliteButtons",title:"New",click:function(){this.creator.newHilite()},extraSpace:50};isc.A.doneButtonDefaults={_constructor:"IButton",autoParent:"hiliteButtons",title:"Done",click:function(){this.creator.doneEditing()}};isc.A.defaultWidth=800;isc.A.defaultHeight=600;isc.A.visibilityMode="multiple";isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments);this.hilitesDS=this.createAutoChild("hilitesDS");this.setHilites();this.hiliteList=this.createAutoChild("hiliteList",{dataSource:this.hilitesDS});this.hiliteList.fetchData();this.addSection({title:"Current Highlights",expanded:true,items:["autoChild:hiliteList"]});this.addSection({title:"Define New Highlight",expanded:true,items:["autoChild:hiliteEditor"]});var _1=this.getDataSource();this.addAutoChild("filterBuilder",{dataSource:_1});this.addAutoChild("hiliteForm",{dataSource:this.hilitesDS});var _2=this.fieldNames||_1.getFieldNames(),_3=this.fieldMap={};for(var i=0;i<_2.length;i++){var _5=_2[i],_6=_1.getField(_5),_7=_6.title;if(_6.hidden)continue;_7=_7?_7:_5;_3[_5]=_7}
this.hiliteForm.setValueMap("fieldName",_3);this.hiliteList.setValueMap("fieldName",_3);this.addAutoChildren(["hiliteButtons","addButton","newButton","doneButton"])}
,isc.A.setHilites=function(_1){_1=_1||this.hilites;this.hilitesDS.testData=_1;if(this.hiliteList)this.hiliteList.data.invalidateCache();if(this.hiliteForm)this.hiliteForm.clearValues()}
,isc.A.hiliteClicked=function(){var _1=this.hiliteList.getSelectedRecord();this.filterBuilder.setCriteria(_1.criteria);this.hiliteForm.setValues(_1)}
,isc.A.newHilite=function(){this.hiliteList.selection.deselectAll();this.filterBuilder.clearCriteria()
this.hiliteForm.editNewRecord()}
,isc.A.saveHilite=function(_1){this.hiliteForm.setValue("criteria",this.filterBuilder.getCriteria());var _2=this.hiliteForm.getValues();_2.cssText=""+(_2.textColor?"color:"+_2.textColor+";":"")+(_2.backgroundColor?"background-color:"+_2.backgroundColor+";":"");this.hiliteForm.setValue("cssText",_2.cssText);var _3=this;this.hiliteForm.saveData(function(_5,_6){var _4=isc.isAn.Array(_6)?_6[0]:_6;_3.hiliteList.selectRecord(_4);_3.hiliteForm.setValues(_4);if(_1)_3.fireCallback(_1)})}
,isc.A.doneEditing=function(){if(!this.hiliteForm.valuesHaveChanged()){this.completeEditing();return}
var _1=this;isc.confirm("Save changes to selected highlight?",function(_2){if(_2){_1.saveHilite(function(){_1.completeEditing()})}else{_1.completeEditing()}})}
,isc.A.completeEditing=function(){var _1=this.hilitesDS.testData;this.fireCallback(this.callback,"hilites",[_1])}
);isc.B._maxIndex=isc.C+7;isc.ClassFactory.defineClass("TreeGrid","ListGrid");isc.addGlobal("TreeViewer",isc.TreeGrid);isc.defineClass("TreeGridBody",isc.GridBody);isc.A=isc.TreeGridBody.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$34w="TABLE";isc.A.$34x="padding:0px;border:0px;";isc.B.push(isc.A.$29h=function(_1,_2,_3,_4,_5){if(_4==null)_4=this.getTableElement(_2,_3);if(_4==null)return;if(!this.showHiliteInCells&&_3==this.grid.getLocalFieldNum(this.grid.getTreeFieldNum()))
{if(_1==null)_1=this.getCellRecord(_2,_3);if(_5==null)_5=this.getCellStyle(_1,_2,_3);var _6=_4.childNodes[0];while(_6&&_6.tagName!=this.$34w)_6=_6.childNodes[0];if(_6){_6.className=_5;if(this.getCellCSSText){_4.style.cssText=isc.StringBuffer.concat(this.$29i(_1,_2,_3,_5),this.$34x)}}}
return isc.GridRenderer.getPrototype().$29h.apply(this,[_1,_2,_3,_4,_5])}
,isc.A.click=function(_1,_2){if(!this.$29p()){var _3=this.grid,_4=_3.getEventRecordNum(),_5=_3.getRecord(_4);if(_3.data.isFolder(_5)&&_3.clickInOpenArea(_5)){_3.toggleFolder(_5);_3.clearLastHilite();_3.$31q=null;return isc.EH.STOP_BUBBLING}}
return this.Super("click",arguments)}
,isc.A.mouseDown=function(){var _1=this.getEventRow(),_2=this.grid.data.get(_1);if(_2!=null&&this.grid.clickInOpenArea(_2)){return isc.EH.STOP_BUBBLING}else{return this.Super("mouseDown",arguments)}}
,isc.A.mouseUp=function(){var _1=this.getEventRow(),_2=this.grid.data.get(_1);if(_2!=null&&this.grid.clickInOpenArea(_2)){return isc.EH.STOP_BUBBLING}else{return this.Super("mouseUp",arguments)}}
);isc.B._maxIndex=isc.C+4;isc.A=isc.TreeGrid;isc.A.TREE_FIELD={name:"nodeTitle",width:"*",treeField:true,getCellValue:function(_1,_2,_3,_4){return _1.getNodeTitle(_2,_3,this)},getFieldTitle:function(_1,_2){var _3=_1.getField(_2);if(_3.name=="nodeTitle")return _1.treeFieldTitle;return _3.title||_3.name}};isc.A=isc.TreeGrid.getPrototype();isc.A.treeFieldTitle="Name";isc.A.autoAssignTreeField=true;isc.A.showRoot=false;isc.A.separateFolders=false;isc.A.displayNodeType=isc.Tree.FOLDERS_AND_LEAVES;isc.A.canDragRecordsOut=false;isc.A.dragDataAction=isc.ListGrid.MOVE;isc.A.openDropFolderDelay=600;isc.A.parentAlreadyContainsChildMessage="This item already contains a child item with that name.";isc.A.cantDragIntoSelfMessage="You can't drag an item into itself.";isc.A.cantDragIntoChildMessage="You can't drag an item into one of it's children.";isc.A.fixedFieldWidths=true;isc.A.wrapCells=false;isc.A.showHiliteInCells=false;isc.A.indentSize=20;isc.A.iconSize=16;isc.A.skinImgDir="images/TreeGrid/";isc.A.folderIcon="[SKIN]/folder.gif";isc.A.dropIconSuffix="drop";isc.A.openIconSuffix="open";isc.A.closedIconSuffix="closed";isc.A.nodeIcon="[SKIN]/file.gif";isc.A.showOpenIcons=true;isc.A.showDropIcons=true;isc.A.customIconProperty="icon";isc.A.showCustomIconOpen=false;isc.A.showCustomIconDrop=false;isc.A.customIconOpenProperty="showOpenIcon";isc.A.customIconDropProperty="showDropIcon";isc.A.manyItemsImage="[SKIN]folder_file.gif";isc.A.showConnectors=false;isc.A.showFullConnectors=true;isc.A.openerImage="[SKIN]opener.gif";isc.A.connectorImage="[SKIN]connector.gif";isc.A.canGroupBy=false;isc.A.ignoreEmptyCriteria=false;isc.A.$34l="open_icon_";isc.A.$34m="extra_icon_";isc.A.$34n="icon_";isc.A.$34o="nodeTitle";isc.A=isc.TreeGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.bodyConstructor="TreeGridBody";isc.A.iconPadding=3;isc.A.$34p=["<table cellpadding=0 cellspacing=0 class='",,"' style='",,isc.Canvas.$42a+"'><tr><td>",,"</td>","<td>"+(isc.Browser.isSafari||isc.Browser.isIE?"<nobr>":""),,,,(isc.Browser.isSafari?"</nobr>":"")+"</td><td style='padding-left:",,"px;'>",,,"</td>","</tr></table>"];isc.A.$39=";";isc.A.$34q=["<td>"+(isc.Browser.isSafari||isc.Browser.isIE?"<nobr>":""),,,,(isc.Browser.isSafari?"</nobr>":"")+"</td><td style='padding-left:",,"px;'>",,,"</td>"];isc.A.$34r="absmiddle";isc.A.$4s={};isc.B.push(isc.A.initWidget=function(){this.invokeSuper(isc.TreeGrid,this.$oc);if(!this.dataSource&&this.data!=null&&this.data.dataSource){this.dataSource=this.data.dataSource}
if(!this.fields||this.fields.length==0){this.fields=[isc.TreeGrid.TREE_FIELD]}}
,isc.A.setDataSource=function(_1,_2){if(_2==null||_2.length==0){_2=[isc.TreeGrid.TREE_FIELD]}
return this.Super("setDataSource",[_1,_2])}
,isc.A.$34s=function(){if(!this.fields||this.fields.length==0){this.fields=[isc.TreeGrid.TREE_FIELD]}else{var _1=this.completeFields,_2=this.fields,_3;for(var i=0;i<_1.length;i++){if(_1[i].treeField){_3=_2.indexOf(_1[i]);break}}
if(_3==null){if(!this.autoAssignTreeField)return;var _5=this.data.titleProperty,_6=_2.findIndex(this.fieldIdProperty,_5);if(_6!=-1)_3=_6}
if(_3==null)_3=0;this.$34t=_3;var _7=_2[_3],_8=isc.TreeGrid.TREE_FIELD;for(var _9 in _8){if(_7[_9]==null){_7[_9]=_8[_9]}}}}
,isc.A.deriveVisibleFields=function(_1,_2,_3,_4){this.invokeSuper(isc.TreeGrid,"deriveVisibleFields",_1,_2,_3,_4);this.$34s()}
,isc.A.getEmptyMessage=function(){if(isc.isA.Tree(this.data)&&this.data.getLoadState(this.data.getRoot())==isc.Tree.LOADING)
return this.loadingDataMessage;return this.emptyMessage}
,isc.A.isEmpty=function(){if(!isc.isA.Tree(this.data))return true;var _1=this.data.getRoot();if(_1==null)return true;var _2=this.data.hasChildren(_1);if(_2||this.showRoot||this.data.showRoot)return false;return true}
,isc.A.getOpenState=function(){var _1=this.data;if(_1==null){this.logWarn("getOpenState() called for a treeGrid with no data");return[]}
var _2=_1.getRoot(),_3=[];this.$45q(_1,_2,_3);return isc.Comm.serialize(_3)}
,isc.A.$45q=function(_1,_2,_3){if(!_1.isOpen(_2)||!_1.isLoaded(_2))return false;var _4=_1.getFolders(_2),_5=false;if(_4!=null){for(var i=0;i<_4.length;i++){_5=this.$45q(_1,_4[i],_3)||_5}}
_3[_3.length]=_1.getPath(_2);return true}
,isc.A.setOpenState=function(_1){_1=this.evalViewState(_1,"openState")
if(!_1)return;if(!this.data){this.logWarn("unable to set open state for this treeGrid as this.data is unset");return}
this.data.closeAll();this.data.openFolders(_1)}
,isc.A.getSelectedPaths=function(){if(!this.selection)return null;var _1=this.selection.getSelection()||[],_2=[];for(var i=0;i<_1.length;i++){_2[i]=this.data.getPath(_1[i])}
return isc.Comm.serialize(_2)}
,isc.A.setSelectedPaths=function(_1){_1=this.evalViewState(_1,"selectedPaths")
if(!_1)return;var _2=this.selection,_3=this.data;if(_3&&_2){_2.deselectAll();var _4=[];for(var i=0;i<_1.length;i++){var _6=_3.find(_1[i]);if(_6)_4.add(_6)}
this.selection.selectList(_4)}}
,isc.A.getViewState=function(){var _1=this.Super("getViewState",[true]);_1.open=this.getOpenState();return"("+isc.Comm.serialize(_1)+")"}
,isc.A.setViewState=function(_1){this.Super("setViewState",arguments);_1=this.evalViewState(_1,"viewState",true)
if(!_1)return;if(_1.open)this.setOpenState(_1.open)}
,isc.A.getDefaultData=function(){return isc.Tree.create()}
,isc.A.setData=function(_1,_2,_3,_4){this.invokeSuper(isc.TreeGrid,"setData",_1,_2,_3,_4);if(!this.data)return;this.data.separateFolders=this.separateFolders;if(this.showRoot&&isc.ResultTree&&isc.isA.ResultTree(this.data)){this.logWarn("showRoot may not be set with a databound treeGrid, unexpected "+"results may occur")}
this.data.showRoot=this.showRoot;this.data.openDisplayNodeType=this.displayNodeType}
,isc.A.draw=function(_1,_2,_3,_4){if(this.initialData&&(!isc.ResultSet||!isc.isA.ResultSet(this.data))){this.setData(this.createResultTree())}
this.invokeSuper(isc.TreeGrid,"draw",_1,_2,_3,_4)}
,isc.A.bodyKeyPress=function(_1){var _2=this.selection;if(this.selectionType!=isc.Selection.NONE&&this.data.getLength()>0&&_2.anySelected()&&!_2.multipleSelected())
{var _3=this.selection.getSelectedRecord();if(_1.keyName=="Arrow_Left"){if(this.data.isFolder(_3)&&this.data.isOpen(_3)){this.closeFolder(_3)}else{this.$319(this.data.getParent(_3),true)}
return false}else if(_1.keyName=="Arrow_Right"){if(this.data.isFolder(_3)){if(!this.data.isOpen(_3)){this.openFolder(_3);return false}else{var _4=this.getRecord(this.data.indexOf(_3)+1);if(_4!=null&&this.data.getParent(_4)==_3){this.$319(_4,true);return false}}}}}
return this.Super("bodyKeyPress",arguments)}
,isc.A.$298=function(_1,_2,_3){if(_2<0||_3<0)return true;var _4=this.data.isFolder(_1);if(this.nodeContextClick&&this.nodeContextClick(this,_1,_2)==false){return false}
if(_4){if(this.folderContextClick&&this.folderContextClick(this,_1,_2)==false){return false}}else{if(this.leafContextClick&&this.leafContextClick(this,_1,_2)==false){return false}}
return this.Super("$298",arguments)}
,isc.A.handleEditCellEvent=function(_1,_2){var _3=this.getRecord(_1);if(this.clickInOpenArea(_3))return false;return this.Super("handleEditCellEvent",arguments)}
,isc.A.canEditCell=function(_1,_2){if(this.Super("canEditCell",arguments)==false)return false;if(this.getField(_2)[this.fieldIdProperty]==this.data.nameProperty)return false;if(this.getField(_2)[this.fieldIdProperty]==this.$34o)return false;return true}
,isc.A.getEditFormItemFieldWidths=function(_1){var _2=this.data.getLevel(_1);if(!this.showRoot)_2--;var _3=_2*this.indentSize;_3+=this.iconSize+this.getOpenerIconSize(_1);if(this.getExtraIcon(_1))_3+=this.iconSize;var _4=this.Super("getEditFormItemFieldWidths",arguments),_5=this.getTreeFieldNum();_4[_5]-=_3;return _4}
,isc.A.getRecordDataSource=function(_1){return this.data.getNodeDataSource(_1)}
,isc.A.rowClick=function(_1,_2,_3){var _4=_1;if(this.clickInOpenArea(_4))return false;this.$31q=_2;if(_2<0||_3<0)return false;var _4=this.getRecord(_2),_5=this.data.isFolder(_4);if(this.nodeClick)this.nodeClick(this,_4,_2);if(_5){if(this.folderClick)this.folderClick(this,_4,_2)}else{if(this.leafClick)this.leafClick(this,_4,_2)}
return this.Super("rowClick",arguments)}
,isc.A.recordDoubleClick=function(_1,_2,_3,_4,_5,_6,_7){if(this.clickInOpenArea(_2))return false;if(this.data.isFolder(_2)){return this.toggleFolder(_2)}else
return this.openLeaf(_2)}
,isc.A.dataChanged=function(){this.Super("dataChanged",arguments);var _1=this.$34z;if(_1&&this.data.isOpen(_1)&&this.data.getLoadState(_1)==isc.Tree.LOADED)
{this.$340(_1);this.$34z=null}}
,isc.A.openLeaf=function(_1){}
,isc.A.transferDragData=function(){var _1=this.getDragData();if(this.dragDataAction==isc.TreeGrid.COPY||this.dragDataAction==isc.TreeGrid.CLONE)
{_1=this.data.getCleanNodeData(_1)}else{_1=this.Super("transferDragData")}
return _1}
,isc.A.getDragTrackerIcon=function(_1){var _2;if(_1&&_1.length>1&&this.manyItemsImage!=null)
_2=this.manyItemsImage;else if(_1&&_1[0])_2=this.getIcon(_1[0],true);return _2}
,isc.A.getDragTrackerTitle=function(_1,_2,_3,_4,_5,_6){var _7=this.getFieldNum(this.getTitleField());if(_7!=this.getTreeFieldNum())
return this.invokeSuper(isc.TreeGrid,"getDragTrackerTitle",_1,_2,_3,_4,_5,_6);var _8=this.invokeSuper(isc.TreeGrid,"getCellValue",_1,_2,_7);var _9=this.$342(_8,_1,null,false).join(isc.emptyString);var _10=this.getCellStyle(_1,_2,_7);if(this.selection.isSelected(_1)){var _11=this.body.getCellStyleIndex(_1,_2,_7),_12=this.body.getCellStyleName(_11,_1,_2,_7);if(_12==_10){_11-=2;_10=this.body.getCellStyleName(_11,_1,_2,_7)}}
return["<table class='",_10,"' style='",this.getCellCSSText(_1,_2,_7),"'><tr>",_9,"</tr></table>"].join(isc.emptyString)}
,isc.A.willAcceptDrop=function(){if(!this.Super("willAcceptDrop",arguments))return false;isc.$54j=true;var _1=this.getEventRecordNum(),_2=this.data.get(_1);isc.$54j=false;if(_2==null)_2=this.data.getRoot();if(!_2||_2.canAcceptDrop==false)return false;var _3=this.data.isFolder(_2);if(!_3&&!(this.canReorderRecords||this.canDropOnLeaves))return false;var _4=isc.EH.dragTarget.getDragData();if(!isc.isAn.Object(_4)||this.getDropError(_4,_2)!=null){return false}
if(!_3){_2=this.data.getParent(_2);if(_2.canAcceptDrop==false)return false}
if(isc.EH.dragTarget!=this)return true;var _5=this.canReparentNodes;if(_5==null&&this.canAcceptDroppedRecords)_5=true;if(!_5){if(!isc.isAn.Array(_4))_4=[_4];var _6;_6=this.data.getParent(_4[0]);if(_6!=_2)return false;for(var i=1;i<_4.length;i++){if(_6!=this.data.getParent(_4[i]))return false}}
return true}
,isc.A.$31i=function(){this.canDrag=(this.canDrag||this.canDragRecordsOut||this.$34c()||this.canDragSelect);this.canDrop=(this.canDrop||this.canDragRecordsOut||this.$34c());this.canAcceptDrop=(this.canAcceptDrop||this.canAcceptDroppedRecords||this.$34c())}
,isc.A.$34c=function(){var _1=this.canReparentNodes;if(_1==null&&this.canAcceptDroppedRecords){if(!this.$343){this.logInfo("'canReparentNodes' is unset. Allowing node reparenting as "+"'canAcceptDroppedRecords' is set to true. For explicit control, "+"use 'canReparentNodes' instead.","dragDrop");this.$343=true}
_1=this.canAcceptDroppedRecords}
return this.canReorderRecords||_1}
,isc.A.getDropError=function(_1,_2){for(var i=0,_4=_1.length;i<_4;i++){if(this.data.isDescendantOf(_2,_1[i])){return this.cantDragIntoChildMessage}}
var _5=this.data.isFolder(_2);if(_5){for(i=0;i<_4;i++){if(_1[i]==_2){return this.cantDragIntoSelfMessage}}}
return null}
,isc.A.dropMove=function(){var _1=this.getEventRow();if(_1==-1)return;var _2=(_1==-2?this.data.getRoot():this.data.get(_1)),_3=this.getDropFolder(),_4=(this.canReorderRecords?this.getReorderPosition(_1):null);if(_3!=this.lastDropFolder||_2!=this.$344||_4!=this.$345){if(!this.$346){this.$346=this.getID()+".openDropFolder()"}
if(this.openDropFolderTimer)isc.Timer.clear(this.openDropFolderTimer);if(!this.data.isOpen(_3)){this.openDropFolderTimer=isc.Timer.setTimeout(this.$346,this.openDropFolderDelay)}
this.updateDropFolder(_3)}
if(!this.willAcceptDrop()){this.body.setNoDropIndicator()}else{this.body.clearNoDropIndicator()}
if(this.canReorderRecords){if(this.data.isOpen(_3))this.showDragLineForRecord(_1,_4);else this.hideDragLine()}
this.$344=_2;this.$345=_4}
,isc.A.getDropFolder=function(){var _1=this.getEventRow(),_2=this.data,_3=(_3<0?_2.getRoot():_2.get(_1));if(_2.isRoot(_3))return _2.getRoot();var _4=_2.isFolder(_3);if(!this.canReorderRecords)return(_4?_3:_2.getParent(_3));var _5=this.getReorderPosition(_3);if(!_4||_5==isc.ListGrid.BEFORE||(_5==isc.ListGrid.AFTER&&(!_2.isOpen(_3)||!_2.hasChildren(_3))))
{return _2.getParent(_3)}else{return _3}}
,isc.A.openDropFolder=function(){var _1=this.lastDropFolder;if(!_1||!this.data.isFolder(_1)||this.data.isOpen(_1))return false;this.data.openFolder(_1);if(this.canReorderRecords)
this.showDragLineForRecord(this.data.indexOf(_1),isc.ListGrid.OVER)}
,isc.A.getReorderPosition=function(_1,_2,_3,_4,_5){if(_2==null)_2=this.body.getOffsetY();if(_1==null)_1=this.getEventRow(_2);var _6=this.data;if(!isc.isA.Number(_1))_1=_6.indexOf(_1);var _7=_6.get(_1);if(_7&&_6.isFolder(_7)){var _8=_2-this.body.getRowTop(_1),_9=this.body.getRowSize(_1);if(_8<(_9/ 4)){return isc.ListGrid.BEFORE}else if(_8>(3*_9/ 4)){return isc.ListGrid.AFTER}else{return isc.ListGrid.OVER}}
return this.invokeSuper(isc.TreeGrid,"getReorderPosition",_1,_2,_3,_4,_5)}
,isc.A.showDragLineForRecord=function(_1,_2,_3,_4,_5){if(_1==null)_1=this.getEventRecordNum();if(_2==null)_2=this.getReorderPosition(_1);if(_2==isc.ListGrid.OVER){var _6=this.getRecord(_1),_7=this.data;if(_7.isFolder(_6)&&_7.isOpen(_6))_2=isc.ListGrid.AFTER}
return this.invokeSuper(isc.TreeGrid,"showDragLineForRecord",_1,_2,_3,_4,_5)}
,isc.A.dropOut=function(){this.hideDragLine();this.body.clearNoDropIndicator();this.$344=null;this.updateDropFolder();if(this.openDropFolderTimer)isc.Timer.clear(this.openDropFolderTimer)}
,isc.A.updateDropFolder=function(_1){var _2=this.lastDropFolder;this.lastDropFolder=_1;if(_1){_1.$347=this.body.willAcceptDrop(_1)
this.setRowIcon(_1,this.getIcon(_1))}
if(_2&&_2!=_1){delete _2.$347;this.setRowIcon(_2,this.getIcon(_2))}}
,isc.A.transferSelectedData=function(_1,_2,_3){if(!this.isValidTransferSource(_1))return;if(_3==null)_3=0;if(_2==null)_2=this.data.getRoot();var _4=_1.getDragData();this.transferNodes(_4,_2,_3,_1)}
,isc.A.drop=function(){if(!this.willAcceptDrop())return false;var _1=isc.EH.dragTarget.getDragData(),_2=this.getEventRecordNum(),_3=this.getReorderPosition(_2),_4=this.data.get(_2)||this.data.getRoot(),_5=this.getDropFolder();var _6=isc.EH.dragTarget.getData(),_7=(isc.isA.Tree(_6)&&isc.isA.Tree(this.data)&&_6.getRoot()==this.data.getRoot());for(var i=0;i<_1.length;i++){var _9=_1[i];var _10=(this.data.findChildNum(_5,this.data.getName(_9))!=-1);var _11=_7&&this.canReorderRecords&&_5==this.data.getParent(_9);if(_10&&!_11){this.logInfo("already a child named: "+this.data.getName(_9)+" under parent: "+this.data.getPath(_5));isc.warn(this.parentAlreadyContainsChildMessage);return false}}
var _12=null;if(this.canReorderRecords){if(_2<0){_5=_4;_12=this.data.getChildren(_5).getLength()}else if(_4==_5){_12=0}else{_12=(_3==isc.ListGrid.AFTER?1:0)+this.data.getChildren(_5).indexOf(_4)}}
this.folderDrop(_1,_5,_12,isc.EH.dragTarget);this.data.openFolder(_5);return false}
,isc.A.folderDrop=function(_1,_2,_3,_4){this.transferNodes(_1,_2,_3,_4)}
,isc.A.transferNodes=function(_1,_2,_3,_4){_2=_2||this.data.root;var _5=_4.getData(),_6=(isc.isA.Tree(_5)&&isc.isA.Tree(this.data)&&_5.getRoot()==this.data.getRoot());var _7=this.getDataSource(),_8=_4.getDataSource();if(_6&&(this.dragDataAction!=isc.TreeGrid.COPY&&this.dragDataAction!=isc.TreeGrid.CLONE))
{if(_7!=null&&this.data!=null&&isc.ResultTree&&isc.isA.ResultTree(this.data))
{var _9=isc.rpc.startQueue();for(var i=0;i<_1.length;i++){var _11=isc.addProperties({},this.data.getCleanNodeData(_1[i])),_12=isc.addProperties({},_11);_11[this.data.parentIdField]=_2[this.data.idField];this.$61f(_11,_7,{oldValues:_12,parentNode:this.data.getParent(_1[i])})}
if(!_9)isc.rpc.sendQueue();return}else{_5.moveList(_1,_2,_3)}}else if(_7!=null){var _13;if(this.dragRecategorize&&_8!=null&&this.data!=null&&isc.ResultTree&&isc.isA.ResultTree(this.data))
{var _14=_8.getTreeRelationship(_7);if(_14!=null&&_14.parentIdField){var _15=false,_16=_8.getPrimaryKeyFields();for(var _17 in _16){if(_17==_14.parentIdField){this.logWarn("dragRecategorize: data source has dataSource:"+_8.getID()+". foreignKey relationship with "+"target dataSource "+_7.getID()+" is based on primary key which cannot be modified.");_15=true}}
if(!_15)_13=true;this.logInfo("Recategorizing dropped nodes in dataSource:"+_8.getID())}
var _9=isc.rpc.startQueue();for(var i=0;i<_1.length;i++){var _11=isc.addProperties({},_1[i]);if(_13){_11[_14.parentIdField]=_2[_14.idField]}
isc.addProperties(_11,this.getDropValues(_11,_8,_2,_3,_4));this.$61f(_11,_8)}
if(!_9)isc.rpc.sendQueue();return}
_1=_4.transferDragData();var _9=isc.rpc.startQueue();for(var i=0;i<_1.length;i++){var _18=_1[i],_19=this.data;if(_19){_18[_19.parentIdField]=_2[_19.idField]}
isc.addProperties(_11,this.getDropValues(_18,_8,_2,_3,_4));this.$61d(_18,_8,null,_3,_2)}
if(!_9)isc.rpc.sendQueue()}else{_1=_4.transferDragData();for(var i=0;i<_1.length;i++){this.$61d(_1[i],_8,null,_3,_2)}}}
,isc.A.getTreeCellValue=function(_1,_2,_3,_4){if(_2==null){return _1}
var _5=this.data.getLevel(_2);var _6=this.$34p;_6[1]=this.getCellStyle(_2,_3,_4);_6[3]=this.getCellCSSText(_2,_3,_4);if(_6[3]!=null&&!_6[3].endsWith(this.$39))_6[3]+=this.$39;_6[5]=this.getIndentHTML(_5,_2);var _7=this.$342(_1,_2,_3,true);for(var i=0;i<10;i++){_6[6+i]=_7[i]}
return _6.join(isc.emptyString)}
,isc.A.$342=function(_1,_2,_3,_4){var _5=this.$34q;if(_4){var _6=this.getOpenIcon(_2),_7=this.openerIconSize||(this.showConnectors?this.cellHeight:null),_8=(_3!=null?this.$34l+_3:null);if(_6){_5[1]=this.getIconHTML(_6,_8,_7)}else{_5[1]=this.$348(_7||this.iconSize)}}else _5[1]=null;var _9=this.getExtraIcon(_2),_10=(_3!=null?this.$349+_3:null),_11=this.getIcon(_2),_12=(_3!=null?this.$34n+_3:null);_5[2]=(_9?this.getIconHTML(_9,_10):null);_5[3]=this.getIconHTML(_11,_12,_2.iconSize);_5[5]=this.iconPadding;_5[7]=this.wrapCells?null:"<NOBR>"
_5[8]=_1;return _5}
,isc.A.getCellValue=function(_1,_2,_3,_4,_5,_6,_7){var _8=this.invokeSuper(isc.TreeGrid,"getCellValue",_1,_2,_3,_4,_5,_6,_7);if(_3==this.getTreeFieldNum()){_8=this.getTreeCellValue(_8,_1,_2,_3)}
return _8}
,isc.A.bodyDrawing=function(_1,_2,_3,_4,_5){this.$35a={};return this.invokeSuper(isc.TreeGrid,"bodyDrawing",_2,_3,_4,_5);delete this.$35a}
,isc.A.getNodeTitle=function(_1,_2,_3){if(_3.name&&_3.name!=this.$34o){return this.getEditedRecord(_2)[_3.name]}
return this.data.getTitle(_1)}
,isc.A.getTitleField=function(){if(this.titleField!=null)return this.titleField;return this.getFieldName(this.getTreeFieldNum())}
,isc.A.getTreeFieldNum=function(){return this.$34t}
,isc.A.getOpenAreaWidth=function(_1){return((this.data.getLevel(_1)-(this.showRoot?0:1))*this.indentSize)+this.getOpenerIconSize(_1)}
,isc.A.getOpenerIconSize=function(_1){return(this.openerIconSize||(this.showConnectors?this.cellHeight:this.iconSize))}
,isc.A.clickInOpenArea=function(_1){if(!this.data.isFolder(_1))return false;var _2=this.getTreeFieldNum(),_3=this.getFieldBody(_2),_4=this.getLocalFieldNum(_2),_5=_3.getColumnLeft(_4),_6=_3.getColumnWidth(_4),_7=this.getOpenAreaWidth(_1),x=_3.getOffsetX();if(this.isRTL()){var _9=_5+_6;return x>=(_9-_7)&&x<=_9}else{return x>=_5&&x<_5+_7}}
,isc.A.getIndentHTML=function(_1,_2){var _3=_1
if(!this.showRoot)_3--;if(this.showConnectors&&this.showFullConnectors){var _4=this.data.$59a(_2);_4.remove(_1);if(!this.showRoot)_4.remove(0);if(_4.length!=0){if(!this.$59b){var _5=isc.Img.urlForState(this.connectorImage,null,null,"ancestor"),_6=this.getIconHTML(_5,null,this.cellHeight);this.$59c=_6}
var _7=this.$348(this.indentSize),_8=isc.StringBuffer.create(isc.emptyString);_8.append("<NOBR>");for(var i=(this.showRoot?0:1);i<_1;i++){if(_4.contains(i))_8.append(this.$59c);else _8.append(_7)}
_8=_8.release();return _8}}
return this.$348(_3*this.indentSize)}
,isc.A.$348=function(_1){if(_1==0)return isc.emptyString;var _2=isc.TreeGrid.$35c;if(_2==null)_2=isc.TreeGrid.$35c={};if(_2[_1]==null)_2[_1]=isc.Canvas.spacerHTML(_1,1);return _2[_1]}
,isc.A.getOpenIcon=function(_1){if(!this.data)return null;if(isc.isA.Number(_1))_1=this.data.get(_1);if(_1==null)return null;if(_1.openIcon){return _1.openIcon}else{var _2=this.data.isFolder(_1),_3=_2,_4=_2,_5,_6;if(_2){var _7=this.data.getLoadState(_1);if(_7==isc.Tree.UNLOADED||(_7==isc.Tree.FOLDERS_LOADED&&this.displayNodeType!=isc.Tree.FOLDERS_ONLY))
{_3=true;_4=false}else{_3=this.data.hasChildren(_1,this.displayNodeType);_4=_3&&this.data.isOpen(_1)}}
if(_4&&!this.showFullConnectors)_6=true
else{_6=!this.$35d(_1)}
_5=!this.$35e(_1);return this.getOpenerImageURL(_3,_4,_5,_6)}
return null}
,isc.A.$35e=function(_1){var _2=this.data.indexOf(_1);if(_2==0)return false;if(this.showFullConnectors)return true;var _3=this.getRecord(_2-1),_4=this.data.getParent(_1);if(_3==null)return false;return(_4==_3||_4==this.data.getParent(_3))}
,isc.A.$35d=function(_1){if(this.showFullConnectors){var _2=this.data,_3=_2.getParent(_1),_4=_2.getChildren(_3);return _4.indexOf(_1)!=_4.length-1}
var _5=this.data.indexOf(_1),_6=this.getRecord(_5+1);if(_6==null)return false;return(this.data.getParent(_1)==this.data.getParent(_6))}
,isc.A.getOpenerImageURL=function(_1,_2,_3,_4){if(!this.$35f){var _5=this.openerImage;this.$35f={opened:isc.Img.urlForState(_5,null,null,"opened"),closed:isc.Img.urlForState(_5,null,null,(this.isRTL()?"closed_rtl":"closed")),opening:isc.Img.urlForState(_5,null,null,"opening")}}
if(this.showConnectors&&!this.$35g){var _5=this.connectorImage,_6=["single","start","end","middle","opened_single","opened_start","opened_middle","opened_end","closed_single","closed_start","closed_middle","closed_end"],_7={},_8=this.isRTL(),_9="$35h";for(var i=0;i<_6.length;i++){var _11=_6[i],_12=_11;if(_8)_12+=_9;_7[_11]=isc.Img.urlForState(_5,null,null,_12)}
this.$35g=_7}
if(this.showConnectors){var _13=this.$35g;if(_1){if(_2){if(!this.showFullConnectors){if(_3)return _13.opened_single;return _13.opened_end}
if(_3&&_4)return _13.opened_single;else if(_3)return _13.opened_start;else if(_4)return _13.opened_end;else return _13.opened_middle}else{if(_3&&_4)return _13.closed_single;if(_3)return _13.closed_start;if(_4)return _13.closed_end;return _13.closed_middle}}else{if(_3&&_4)return _13.single;if(_3)return _13.start;if(_4)return _13.end;return _13.middle}}else{var _13=this.$35f;if(!_1)return null;if(_2)return _13.opened;return _13.closed}}
,isc.A.getExtraIcon=function(_1){return null}
,isc.A.getIcon=function(_1,_2){if(isc.isA.Number(_1))_1=this.data.get(_1);if(!_1)return null;var _3=_1[this.customIconProperty],_4=(_3!=null),_5=this.data.isFolder(_1);if(!_4){if(_5)_3=this.folderIcon;else _3=this.nodeIcon}
var _6;if(_5){var _7=_2?false:(this.lastDropFolder==_1&&_1.$347),_8=_2?false:!!this.data.isOpen(_1);if(_7){if(_1.dropIcon!=null)_3=_1.dropIcon;else if(!_4&&this.folderDropImage!=null)_3=this.folderDropImage;else{var _9;if(_4){_9=_1[this.customIconDropProperty];if(_9==null)_9=this.showCustomIconDrop}else{_9=this.showDropIcons}
if(_9)_6=this.dropIconSuffix}}else if(_8){if(_1.openedIcon!=null)_3=_1.openedIcon;else if(!_4&&this.folderOpenImage!=null)_3=this.folderOpenImage;else{var _10;if(_4){_10=_1[this.customIconOpenProperty];if(_10==null)_10=this.showCustomIconOpen}else{_10=this.showOpenIcons}
if(_10)_6=this.openIconSuffix;else if(!_4)_6=this.closedIconSuffix}}else{if(!_4){if(this.folderClosedImage)_3=this.folderClosedImage;else _6=this.closedIconSuffix}}}else{if(!_4&&this.fileImage)_3=this.fileImage}
return isc.Img.urlForState(_3,false,false,_6)}
,isc.A.getIconHTML=function(_1,_2,_3){if(_1==null)return isc.emptyString;if(_3==null)_3=this.iconSize;var _4=this.$35a.iconHTML;if(_4==null)_4=this.$35a.iconHTML={};if(_4[_1]==null){var _5=this.$4s;_5.src=_1;_5.width=_5.height=_3;_5.name=_2;_5.align=this.$34r;_4[_1]=this.$wf(_5)}
var _6=_4[_1];_6[14]=_2;return _6.join(isc.$ad)}
,isc.A.setRowIcon=function(_1,_2){if(!isc.isA.Number(_1))_1=this.data.indexOf(_1);if(_1!=-1&&this.getIcon(_1)!=null){this.setImage(this.$34n+_1,_2)}}
,isc.A.setNodeIcon=function(_1,_2){_1[this.customIconProperty]=_2;this.setImage(this.$34n+this.getRecordIndex(_1),_2)}
,isc.A.getPrintHTML=function(_1,_2){var _3=this.printExpandTree;if(_3==null)_3=_1?_1.expandTrees:null;if(_3&&this.data){if(isc.ResultTree&&isc.isA.ResultTree(this.data)&&this.data.loadDataOnDemand){this.logWarn("Printing TreeGrid with option to expand folders on print not supported "+"for load on demand trees.")}else{this.data.openAll()}}
return this.Super("getPrintHTML",arguments)}
);isc.B._maxIndex=isc.C+66;isc.TreeGrid.registerStringMethods({folderOpened:"node",folderClosed:"node",folderClick:"viewer,folder,recordNum",leafClick:"viewer,leaf,recordNum",nodeClick:"viewer,node,recordNum",folderContextClick:"viewer,folder,recordNum",leafContextClick:"viewer,leaf,recordNum",nodeContextClick:"viewer,node,recordNum"});isc.ClassFactory.defineClass("RecordEditor","ListGrid");isc.A=isc.RecordEditor.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.autoDraw=false;isc.A.cellSpacing=0;isc.A.cellPadding=0;isc.A.selectionType="none";isc.A.showRollOver=false;isc.A.baseStyle="recordEditorCell";isc.A.showHeader=false;isc.A.showEmptyMessage=false;isc.A.bodyOverflow="hidden";isc.A.fixedRecordHeights=true;isc.A.skinImgDir="images/RecordEditor/";isc.A.saveImg={src:"[SKIN]add.png",width:16,height:16,showOver:true};isc.A.filterImg={src:"[SKIN]filter.png",width:16,height:16,showOver:true};isc.A.actionButtonStyle="normal";isc.A.listEndEditAction="next";isc.A.canEdit=true;isc.A.editByCell=false;isc.A.canFocus=false;isc.A.$jo=false;isc.A.bodyStyleName="normal";isc.B.push(isc.A.$32t=function(){}
);isc.B._maxIndex=isc.C+1;isc.A=isc.RecordEditor.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.initWidget=function(){if(this.sourceWidget!=null){var _1=this.sourceWidget;this.setWidth(_1.getWidth()-(_1.getLeftMargin()+_1.getRightMargin()));this.leaveScrollbarGap=this.sourceWidget.leaveScrollbarGap;if(this.actionType=="filter"){this.actOnCellChange=this.sourceWidget.filterByCell;this.actOnKeypress=this.sourceWidget.filterOnKeypress}else{this.actOnCellChange=this.sourceWidget.saveByCell}
isc.addProperties(this.editFormDefaults,{autoFocus:false});this.fieldIDProperty=this.sourceWidget.fieldIDProperty;this.fields=this.sourceWidget.completeFields.duplicate()}else{this.logWarn("RecordEditor initialized without a sourceWidget property. "+"This widget is not supported as a standalone component.")}
return this.Super(this.$oc)}
,isc.A.$315=function(_1,_2,_3,_4,_5){if(_3.isRemoveField)return"&nbsp;"
return this.Super("$315",arguments)}
,isc.A.draw=function(){var _1=this.findNextEditCell(0,0,1,true,true);if(_1==null){this.logWarn("No editable fields in this record editor."+(this.actionType=="filter"?" Check the 'canFilter' property for each field in ":" Check the 'canEdit' property for each field in ")+this.sourceWidget.getID())}else{var _2=this.actionType=="filter",_3;if(_2){_3=this.sourceWidget.$32e()}else{var _4;_3={};for(var i=0;i<this.fields.length;i++){var _6=this.fields[i];if(_6.defaultValue!==_4){_3[_6[this.fieldIdProperty]]=_6.defaultValue}}}
this.setEditValues(0,_3);var _7=_1[1];this.$31u(0,_7)}
this.Super("draw",arguments);this.$35i.bringToFront()}
,isc.A.setFields=function(){this.Super("setFields",arguments);var _1=this.findNextEditCell(0,0,1,true,true);if(this.isDrawn()&&!this.$30a)this.$31u(0,_1[1])}
,isc.A.createChildren=function(){this.Super("createChildren",arguments);if(!this.$35i)this.makeActionButton()}
,isc.A.makeActionButton=function(){var _1;if(this.actionType=="filter"){_1=this.filterImg}else{_1=this.saveImg}
this.$35i=isc.Button.create({recordEditor:this,left:this.getInnerWidth()-this.getScrollbarSize(),width:this.getScrollbarSize(),autoDraw:false,baseStyle:this.actionButtonStyle,skinImgDir:this.skinImgDir,icon:_1.src,showRollOverIcon:_1.showOver,showFocusedIcon:_1.showFocused,showFocusedAsOver:false,click:function(){this.recordEditor.performAction()}},this.actionButtonDefaults,this.actionButtonProperties);this.addChild(this.$35i);this.$35i.$sq(this)}
,isc.A.performAction=function(_1){if(this.actionType=="filter")this.performFilter(_1);else this.performSave(_1)}
,isc.A.performFilter=function(_1){var _2=this.getValues(),_3=this.sourceWidget.data.criteria;for(var _4 in _3){var _5;if(_2[_4]===_5)_2[_4]=_3[_4]}
_2=isc.DataSource.filterCriteriaForFormValues(_2);var _6={};if(_1)_6.showPrompt=false;var _7=this.sourceWidget.data;if(isc.isA.ResultSet(_7)&&_7.willFetchData(_2)){this.fireOnPause("performFilter",{target:this.sourceWidget,methodName:"filterData",args:[_2,null,_6]},this.fetchDelay)}else{this.sourceWidget.filterData(_2,null,_6)}}
,isc.A.performSave=function(_1){var _2=this.getEditRow(),_3=this.getEditCol(),_4=this.getFieldName(_3),_5=this.$286.getValue(_4);this.setEditValue(_2,_3,_5);var _6=this.getEditValues(0),_7=this.getFields().getProperty(this.fieldIdProperty);if(!this.validateRowValues(_6,{},0,_7))return;this.$321(0);this.$31u(0,0);for(var _4 in _6){this.refreshCell(0,_3)}}
,isc.A.getValues=function(){var _1=this.getEditCol(),_2=this.getEditFieldName();this.setEditValue(0,_1,this.$286.getValue(_2));return isc.addProperties({},this.getEditValues(0))}
,isc.A.canEditCell=function(_1,_2){if(this.actionType=="filter"){var _3=this.getField(_2);if(_3==null)return false;return(_3.canFilter!=false)}else{return this.sourceWidget.canEditCell(_1,_2)}}
,isc.A.getEditorValueMap=function(_1,_2){if(this.actionType=="filter"){return this.sourceWidget.getFilterEditorValueMap(_1)}else{return this.sourceWidget.getEditorValueMap(_1,_2)}}
,isc.A.getEditorType=function(_1,_2){if(this.actionType=="filter"){return this.sourceWidget.getFilterEditorType(_1)}else{return this.sourceWidget.getEditorType(_1,_2)}}
,isc.A.$45r=function(){this.form.grid.editorChanged(this)}
,isc.A.editorChanged=function(_1){var _2=_1.actOnKeypress!=null?_1.actOnKeypress:this.actOnKeypress;if(_2){this.performAction(true)}}
,isc.A.getEditorProperties=function(_1){var _2={height:this.cellHeight};if(_1.displayField&&!_1.optionDataSource)
_2.optionDataSource=this.sourceWidget.dataSource;if(this.actionType=="filter"){_2.allowEmptyValue=true;_2.changed=this.$45r;_2.actOnKeypress=_1.filterOnKeypress;return isc.addProperties(_2,this.sourceWidget.getFilterEditorProperties(_1))}else{return isc.addProperties(_2,this.sourceWidget.getEditorProperties(_1))}}
,isc.A.getEditItem=function(_1,_2,_3,_4,_5,_6){var _7=this.Super("getEditItem",arguments),_8=this.sourceWidget.getFilterEditorProperties(_1),_9;if(!_8)_8={};if(_1.defaultValue!=null&&_8.defaultValue===_9){delete _7.defaultValue}
if(_1.change!=null&&_8.change===_9){delete _7.change}
if(_1.defaultDynamicValue!=null&&_8.defaultDynamicValue!=null)
{delete _7.defaultDynamicValue}
if(_1.icons!=null&&_8.icons===_9){delete _7.icons}
if(_1.showPickerIcon!=null&&_8.showPickerIcon===_9){delete _7.showPickerIcon}
return _7}
,isc.A.cellEditEnd=function(_1,_2){if(_1!=isc.ListGrid.ENTER_KEYPRESS&&_1!=isc.ListGrid.TAB_KEYPRESS&&_1!=isc.ListGrid.SHIFT_TAB_KEYPRESS&&_1!=isc.ListGrid.EDIT_FIELD_CHANGE)return true;var _3;if(_2===_3)_2=this.getUpdatedEditorValue();var _4=this.getEditRow(),_5=this.getEditCol();this.setEditValue(_4,_5,_2);if(_1==isc.ListGrid.ENTER_KEYPRESS||this.actOnCellChange){this.performAction();if(_1==isc.ListGrid.ENTER_KEYPRESS)return}
var _6=this.getNextEditCell(_4,_5,_1);if(_6==null||_6[0]!=_4){if(_1==isc.ListGrid.TAB_KEYPRESS){this.$35i.focus()}else{if(this.$vw!=null)this.$vw.focus()}
return}
return this.Super("cellEditEnd",arguments)}
,isc.A.clearEditValue=function(_1,_2){return this.Super("clearEditValue",[_1,_2,null,true])}
,isc.A.layoutChildren=function(){this.Super("layoutChildren",arguments);if(this.$35i)
this.$35i.setLeft(this.getInnerWidth()-this.getScrollbarSize())
if(this.body){var _1=this.body;if(this.bodyLayout)_1=this.bodyLayout;_1.setWidth(this.getInnerWidth()-this.getScrollbarSize())}}
,isc.A.adjustOverflow=function(){this.Super("adjustOverflow",arguments);if(this.$35i){this.$35i.setHeight(this.body.getVisibleHeight())}}
,isc.A.bodyScrolled=function(_1,_2){this.Super("bodyScrolled",arguments);if(this.$35j!=null){isc.Timer.clear(this.$35j)}
this.$35j=this.delayCall("syncSourceScrolling",[],0)}
,isc.A.syncSourceScrolling=function(){var _1=this.body.getScrollLeft();if(this.sourceWidget&&this.sourceWidget.body&&this.sourceWidget.body.getScrollLeft()!=_1){this.sourceWidget.body.scrollTo(_1)}}
,isc.A.getFieldWidths=function(){var _1=this.sourceWidget.getFieldWidths();if(isc.isA.Array(_1))_1=_1.duplicate();return _1}
,isc.A.$57q=function(){return(this.sourceWidget&&this.sourceWidget.body&&!this.sourceWidget.body.vscrollOn)}
,isc.A.getEditFormItemFieldWidths=function(_1){var _2=this.Super("getEditFormItemFieldWidths",arguments);if(this.$57q()){var _3=_2.sum(),_4=this.getInnerWidth()-this.getScrollbarSize();if(_3>_4){_2[_2.length-1]-=Math.min(this.getScrollbarSize(),(_3-_4))}}
return _2}
,isc.A.getEditItemCellValue=function(_1,_2,_3){var _4=this.Super("getEditItemCellValue",arguments);if(_3==this.fields.length-1&&this.$57q()){var _5=this.getEditForm().getItem(this.getEditorName(_2,_3)),_6=this.getFieldWidth(_3)-_5.getWidth();if(_6>0){_4+=isc.Canvas.spacerHTML(_6,1)}}
return _4}
,isc.A.rebuildForFreeze=function(){}
,isc.A.rowClick=function(){}
,isc.A.rowDoubleClick=function(){}
);isc.B._maxIndex=isc.C+30;isc.ClassFactory.defineClass("Menu","ListGrid");isc.A=isc.Menu;isc.A.standardFields={icon:"ICON_FIELD",title:"TITLE_FIELD",key:"KEY_FIELD",subMenu:"SUBMENU_FIELD"};isc.A.ICON_FIELD={name:"icon",width:25,getCellValue:function(_1,_2){return _1.getIcon(_2)}};isc.A.TITLE_FIELD={name:"title",width:"*",getCellValue:function(_1,_2){return _1.getItemTitle(_2)}};isc.A.KEY_FIELD={name:"keys",width:35,getCellValue:function(_1,_2){return _1.getKeyTitle(_2)}};isc.A.SUBMENU_FIELD={name:"submenu",width:18,getCellValue:function(_1,_2){return _1.getSubmenuImage(_2)}};isc.A.$kc=[];isc.A.SHIFT=(isc.Browser.isWin?"Shift+":"shift-");isc.A.CTRL=(isc.Browser.isWin?"Ctrl+":"ctrl-");isc.A.ALT=(isc.Browser.isWin?"Alt+":"option-");isc.A.META=(isc.Browser.isWin?"Windows+":"command-");isc.A=isc.Menu.getPrototype();isc.A.styleName="normal";isc.A.bodyStyleName="normal";isc.A.submenuDelay=200;isc.A.submenuOffset=-4;isc.A.defaultWidth=150;isc.A.defaultHeight=20;isc.A.enforceMaxHeight=true;isc.A.maxHeight=null;isc.A.backgroundColor=null;isc.A.overflow=isc.Canvas.VISIBLE;isc.A.bodyOverflow=isc.Canvas.VISIBLE;isc.A.arrowKeyAction="focus";isc.A.selectionType=isc.Selection.NONE;isc.A.autoDraw=false;isc.A.tableStyle="menuTable";isc.A.showRollOver=true;isc.A.showFocusOutline=false;isc.A.showAllRecords=true;isc.A.fixedFieldWidths=false;isc.A.fixedRecordHeights=false;isc.A.leaveScrollbarGap=false;isc.A.baseStyle="menu";isc.A.showHeader=false;isc.A.showSortArrow=isc.ListGrid.NONE;isc.A.canDrag=false;isc.A.canAcceptDrop=false;isc.A.canReorderRecords=false;isc.A.useKeys=true;isc.A.showKeys=true;isc.A.showIcons=true;isc.A.showSubmenus=true;isc.A.submenuDirection="right";isc.A.showFieldsSeparately=false;isc.A.emptyMessage="[Empty menu]";isc.A.cellSpacing=0;isc.A.cellPadding=2;isc.A.iconWidth=16;isc.A.iconHeight=16;isc.A.autoSetDynamicItems=true;isc.A.skinImgDir="images/Menu/";isc.A.submenuImage={src:"[SKIN]submenu.gif",width:7,height:7};isc.A.submenuDisabledImage={src:"[SKIN]submenu_disabled.gif",width:7,height:7};isc.A.checkmarkImage={src:"[SKIN]check.gif",width:9,height:9};isc.A.checkmarkDisabledImage={src:"[SKIN]check_disabled.gif",width:9,height:9};isc.A.useBackMask=true;isc.A.submenuInheritanceMask=["submenuConstructor","$35k","className","submenuDelay","submenuOffset","defaultWidth","backgroundColor","tableStyle","showRollOver","baseStyle","emptyMessage","canDrag","canAcceptDrop","canReorderRecords","useKeys","showKeys","showIcons","showSubmenus","submenuDirection","cellPadding","iconWidth","iconHeight","autoSetDynamicItems","skinImgDir","submenuImage","submenuDisabledImage","checkmarkImage","checkmarkDisabledImage","bodyDefaults","itemClick","canSelectParentItems","childrenProperty","inheritedProperties"];isc.A.mergeSingleParent=true;isc.A.autoDismiss=true;isc.A=isc.Menu.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$oz="left";isc.A.$o1="right";isc.B.push(isc.A.initWidget=function(){this.$35l();this.position=isc.Canvas.ABSOLUTE;if(this.dataSource!=null&&isc.ResultTree){var _1=this.createResultTree(null,null,{showPrompt:false,dataProperties:{autoOpenRoot:false}});if(this.loadDataOnDemand==false){_1.loadChildren(_1.getRoot(),{caller:this,methodName:"treeDataLoaded"})}
this.data=_1}
if(this.data==null&&this.items!=null)this.data=this.items;if(isc.Tree&&isc.isA.Tree(this.data)){this.$35k=this.data;this.childrenProperty=this.data.childrenProperty;var _2=this.data.getChildren(),_3=this.mergeSingleParent&&!isc.isA.ResultTree(this.$35k)&&_2.length==1&&this.data.hasChildren(_2[0]);if(_3){var _4=_2[0];this.data=this.data.getChildren(_4).duplicate();this.data.add({isSeparator:true});var _5={};isc.addProperties(_5,_4);_5[this.childrenProperty]=null;this.data.add(_5)}else{this.data=null}}
this.Super(this.$oc);if(!this.fields){this.$51r=true;this.fields=[];var _6=(this.submenuDirection==this.$oz);if(_6&&this.showSubmenus)this.fields.add(isc.Menu.SUBMENU_FIELD);if(this.showIcons)this.fields.add(isc.Menu.ICON_FIELD);this.fields.add(isc.Menu.TITLE_FIELD);if(this.showKeys)this.fields.add(isc.Menu.KEY_FIELD);if(!_6&&this.showSubmenus)this.fields.add(isc.Menu.SUBMENU_FIELD)}else{this.$51r=false;for(var i=0;i<this.fields.length;i++){var _8=this.fields[i];if(isc.isA.String(_8)){if(isc.Menu.standardFields[_8]!=null){this.fields[i]=isc.Menu[isc.Menu.standardFields[_8]]}else{this.logWarn("Menu field specified as :"+_8+". This is not a recognized standard field name");this.fields.removeAt(i);i-=1}}}}
if(isc.Browser.isSafari){isc.addProperties(this.submenuImage,{align:"BOTTOM"});isc.addProperties(this.submenuDisabledImage,{align:"BOTTOM"})}
if(this.useKeys)this.setUpKeyListening();if(this.$35k){if(!this.treeParentNode)this.treeParentNode=this.$35k.getRoot();this.setTreeNode(this.treeParentNode)}}
,isc.A.setFields=function(_1,_2,_3,_4,_5){if(_1&&(_1!=this.fields)){this.$51r=false}
return this.invokeSuper(isc.Menu,"setFields",_1,_2,_3,_4,_5)}
,isc.A.treeDataLoaded=function(){this.treeDataArrived(this.$35m)}
,isc.A.setTreeNode=function(_1){var _2=this.$35k.getLoadState(_1);this.$35m=_1;if(_2==isc.Tree.LOADED){this.treeDataArrived(_1)}else if(_2!=isc.Tree.LOADING){this.$35k.loadChildren(_1,this.getID()+".treeDataArrived(node)");this.$35n=true;this.setData(null)}}
,isc.A.treeDataArrived=function(_1){delete this.$35n;if(_1==this.$35m){this.setData(this.$35k.getChildren(_1));if(this.masterMenu&&this.masterMenu.isVisible())
this.masterMenu.placeSubmenu(_1,this)}}
,isc.A.getEmptyMessage=function(){if(this.$35n)return this.loadingDataMessage;return this.Super("getEmptyMessage",arguments)}
,isc.A.isEmpty=function(){if(this.$35n)return true;return this.Super("isEmpty",arguments)}
,isc.A.$35l=function(){isc.addProperties(this,{emptyMessageTableStyle:this.tableStyle,emptyMessageStyle:this.baseStyle+isc.GridRenderer.standardStyleSuffixes[4]})}
,isc.A.$31m=function(_1,_2,_3,_4,_5){var _6;if(this.$35k){_6=this.isObserving(this.$35k,"dataChanged");_1=this.$35k}
if(!_6)this.invokeSuper(isc.Menu,"$31m",_1,_2,_3,_4,_5);if(this.autoSetDynamicItems){this.$35o()}}
,isc.A.$31j=function(_1){this.Super("$31j",arguments);if(this.autoSetDynamicItems){delete this.setDynamicItems}}
,isc.A.rowClick=function(_1,_2,_3){this.Super("rowClick",arguments);this.selectMenuItem(_2,_3)}
,isc.A.selectMenuItem=function(_1,_2){if(_1==null)_1=this.getEventRecordNum();_1=this.getItem(_1);var _3=true;if(_1==null||!this.itemIsEnabled(_1)){isc.Menu.hideAllMenus();return false}
if(this.hasSubmenu(_1)&&!this.canSelectParentItems&&!_1.canSelectParent){if(this.submenuTimer)this.submenuTimer=isc.Timer.clear(this.submenuTimer);if(this.$35p!=_1)this.hideSubmenu();this.showSubmenu(_1);return false}
var _4=this;while(_4.$35q){_4=_4.$35q}
if(_4.autoDismiss&&(_1.autoDismiss||_1.autoDismiss==null)){isc.Menu.hideAllMenus()}
if(_1.action){if(!isc.isA.Function(_1.action)){isc.Func.replaceWithMethod(_1,"action","")}
if(_1.action()==false)return false}
if(_1.click){if(!isc.isA.Function(_1.click)){isc.Func.replaceWithMethod(_1,"click","target,item,menu,colNum")}
var _5=(this.target?this.target:this);_3=_1.click(_5,_1,this,_2)}
if(_3!=false){_3=this.itemClick(_1,_2)}
if(!(_4.autoDismiss&&(_1.autoDismiss||_1.autoDismiss==null))){this.refreshRow(this.getRecordIndex(_1))}
return _3}
,isc.A.mouseOver=function(){var _1=this.$35q;if(_1&&_1.body.lastOverRow!=this.$35r){if(_1.submenuTimer)_1.submenuTimer=isc.Timer.clear(_1.submenuTimer);_1.$88(this.$35r)}}
,isc.A.rowOver=function(_1,_2){if(this.submenuTimer)this.submenuTimer=isc.Timer.clear(this.submenuTimer);this.submenuTimer=isc.Timer.setTimeout({target:this,method:this.changeSubmenu},this.submenuDelay)}
,isc.A.itemClick=function(_1,_2){}
,isc.A.getShowSubmenuKey=function(){return this.submenuDirection=="right"?"Arrow_Right":"Arrow_Left"}
,isc.A.getHideSubmenuKey=function(){return this.submenuDirection=="right"?"Arrow_Left":"Arrow_Right"}
,isc.A.bodyKeyPress=function(_1,_2){var _3=isc.EventHandler.lastEvent.keyName;if(_3==this.getHideSubmenuKey()){if(this.$35q!=null){this.$35q.hideSubmenu();this.$35q.focus();return false}}else if(_3==this.getShowSubmenuKey()){var _4=this.getItem(this.getFocusRow());if(this.hasSubmenu(_4)){this.changeSubmenu();this.$35s.$318(1);return false}}else if(_3=="Escape"){if(this.$35q!=null){this.$35q.hideSubmenu();this.$35q.focus()}else{isc.Menu.hideAllMenus()}
return false}else if(_3=="Enter"){return this.$240()}
return this.Super("bodyKeyPress",arguments)}
,isc.A.$318=function(_1){var _2=this.getFocusRow();if(_2==null)_2=0;if(_1==-1){do{_2+=_1;if(_2<0){this.hide();return false}}while(!this.itemIsEnabled(_2))}
return this.Super("$318",arguments)}
,isc.A.show=function(_1){if(this.$35t){this.moveTo(this.$35u[0],this.$35u[1]);this.$35t=null}
if(_1==null)_1=this.showAnimationEffect;var _2=!this.$35v&&(_1!=null)&&(_1!="none");if(_2){this.$35v=true;this.animateShow(_1,"this.$35w()")
return}
if(this.setDynamicItems)this.setDynamicItems()
if(!this.isDrawn()){this.draw(true)}
this.body.focusOnHide=isc.EH.getFocusCanvas();if(isc.Menu.$kc.length==0){isc.Menu.$35x=isc.EH.showClickMask("isc.Menu.hideAllMenus()",true)}
this.bringToFront();isc.Menu.$kc.add(this);this.Super("show",arguments);if(!this.$35v)this.$35w()}
,isc.A.$35w=function(){if(this.$35v)delete this.$35v;if(isc.Browser.isMoz){this.getClipHandle().offsetLeft}
this.body.focus()}
,isc.A.hide=function(){if(this.visibility==isc.Canvas.HIDDEN)return;this.Super("hide",arguments);this.$20();this.clearLastHilite();this.$31q=null;if(this.$35p)delete this.$35p;if(this.submenuTimer)isc.Timer.clearTimeout(this.submenuTimer)}
,isc.A.showContextMenu=function(_1){if(_1&&(_1.target==this||(this.body&&_1.target==this.body))){if(this.body){if(isc.Browser.isSafari){this.body.$29u=this.getEventRow();this.body.$29v=this.getEventColumn()}
this.body.click()}
return false}
var _2;if(isc.isA.Canvas(_1))_2=_1;if(_1!=null&&_1.target!=null)_2=_1.target;if(_2!=null)this.target=_2;this.positionContextMenu();this.show();return false}
,isc.A.getMaxHeight=function(){if(this.maxHeight!=null)return this.maxHeight;return isc.Page.getHeight()-this.getScrollbarSize()}
,isc.A.$8h=function(){if(!this.isDrawn()){this.setVisibility(isc.Canvas.HIDDEN);this.draw()}
this.setVisibility(isc.Canvas.VISIBLE);this.$20();if(this.isDirty()||this.body.isDirty())this.redraw();if(this.$rm)this.adjustOverflow();if(!this.$35y&&this.enforceMaxHeight){if(this.overflow!=isc.Canvas.VISIBLE){this.leaveScrollbarGap=false;this.setOverflow(isc.Canvas.VISIBLE);this.setHeight(this.defaultHeight);this.setWidth(this.$35z||this.defaultWidth);this.adjustOverflow()}
var _1=this.getVisibleHeight(),_2=this.getVisibleWidth(),_3=this.getMaxHeight();if(this.overflow==isc.Canvas.VISIBLE&&_1>_3){this.leaveScrollbarGap=true;this.setHeight(_3);this.$35z=this.getWidth();this.setWidth(this.getVisibleWidth()+this.getScrollbarSize())
this.setOverflow(isc.Canvas.AUTO);this.adjustOverflow()}
this.$35y=true}
this.setVisibility(isc.Canvas.HIDDEN)}
,isc.A.dataChanged=function(_1,_2,_3,_4){if(this.$35k&&this.$35m!=null){if(!this.$501(this.$35m)){this.destroy();return}}
var _5=this.invokeSuper(isc.Menu,"dataChanged",_1,_2,_3,_4);delete this.$35y;return _5}
,isc.A.$501=function(_1){while(_1){if(this.$35k.isRoot(_1))return true;_1=this.$35k.getParent(_1)}
return false}
,isc.A.setData=function(_1,_2,_3,_4){var _5=this.invokeSuper(isc.Menu,"setData",_1,_2,_3,_4);delete this.$35y;return _5}
,isc.A.setItems=function(_1,_2,_3,_4){return this.setData(_1,_2,_3,_4)}
,isc.A.getMenuItem=function(_1){return isc.Class.getArrayItem(_1,this.data,"name")}
,isc.A.$20=function(){if(this.parentElement!=null)return;if(this.$35t)return;this.$35u=[this.getLeft(),this.getTop()];this.moveTo(null,-9999);this.$35t=true}
,isc.A.moveBy=function(){var _1=this.Super("moveBy",arguments);if(this.$35t)this.$35t=false;return _1}
,isc.A.resizeBy=function(_1,_2,_3,_4,_5,_6){if((_1!=null&&_1!=0)||(_2!=null&&_2!=0))delete this.$35y;return this.invokeSuper(isc.Menu,"resizeBy",_1,_2,_3,_4,_5,_6)}
,isc.A.hideContextMenu=function(){this.hide()}
,isc.A.positionContextMenu=function(){this.$8h();var _1=isc.EH.getLastEvent();this.placeNear(_1.x,_1.y)}
,isc.A.getItem=function(_1){return isc.Class.getArrayItem(_1,this.data,"name")}
,isc.A.getItemNum=function(_1){return isc.Class.getArrayItemIndex(_1,this.data,"name")}
,isc.A.getItems=function(){return this.getData()}
,isc.A.addItem=function(_1,_2){if(_2==null)_2=this.data.getLength();this.data.addAt(_1,_2);this.markForRedraw()}
,isc.A.removeItem=function(_1){this.data.remove(_1);this.markForRedraw()}
,isc.A.changeSubmenu=function(){var _1=this.getItem(this.body.lastOverRow);if(_1&&this.$35p==_1)return;this.hideSubmenu();if(_1!=null)this.showSubmenu(_1)}
,isc.A.hasSubmenu=function(_1){if(!_1)return false;if(_1.submenu)return true;if(isc.isA.Tree(this.$35k)){return(this.$35k.isFolder(_1)&&((isc.ResultTree&&isc.isA.ResultTree(this.$35k))||this.$35k.hasChildren(_1)))}
return false}
,isc.A.showSubmenu=function(_1){var _2=this.getSubmenu(_1);if(!_2)return;this.placeSubmenu(_1,_2)}
,isc.A.getSubmenu=function(_1){_1=this.getItem(_1);if(!this.hasSubmenu(_1))return;var _2=isc.applyMask(this,this.submenuInheritanceMask);if(!this.$51r){var _3=[];for(var i=0;i<this.fields.length;i++){_3[i]=isc.addProperties({},this.fields[i])}
_2.fields=_3}
var _5=_1.submenu;if(!_5){var _6=(this.$350||this),_7=(_6==this?0:this.$351);if(!_6.$352)_6.$352=[];this.logDebug("RootMenu:"+_6.getID()+", submenus:"+_6.$352+", Level:"+_7);_5=_6.$352[_7];if(!_5){isc.addProperties(_2,{ID:(_6.getID()+"_childrenSubMenu_"+_7),$350:_6,$351:_7+1,autoDraw:false,treeParentNode:this.$35k?_1:null,masterMenu:this});var _8=this.submenuConstructor||isc.Menu;_5=_8.create(_2);_6.$352[_7]=_5;_6.observe(_5,"destroy","observer.submenuDestroyed("+_7+");")}}else if(!isc.isA.Menu(_5)){if(!this.$352)this.$352=[];if(isc.isA.String(_5)){_5=window[_5]}else if(isc.isAn.Array(_5)){_5=isc.Menu.create({autoDraw:false,data:_5},_2);this.$352.add(_5)}else if(isc.isAn.Object(_5)){_5=isc.Menu.create(isc.addProperties({autoDraw:false},_2,_5));this.$352.add(_5)}
_1.submenu=_5}
if(this.$35k)_5.setTreeNode(_1);return _5}
,isc.A.submenuDestroyed=function(_1){delete this.$352[_1]}
,isc.A.placeSubmenu=function(_1,_2){this.$35p=_1;this.$35s=_2;_2.$8h();var _3=this.getItemNum(_1),_4=_2.getPeerRect(),_5=isc.Canvas.$t7(_4[2],_4[3],{left:this.getPageLeft()-this.submenuOffset,width:this.getVisibleWidth()+this.submenuOffset,top:this.body.getRowPageTop(_3)},this.submenuDirection==this.$oz?this.$oz:this.$o1,false)
_2.setPageRect(_5[0],_5[1]);if(this.target!=this&&_2.target!=_2){_2.target=this.target}
_2.show();_2.$35q=this;_2.$35r=_3;if(isc.Menu.$353)delete isc.Menu.$353[this.getID()]}
,isc.A.hideMenuTree=function(){this.hideSubmenu();this.hide()}
,isc.A.hideSubmenu=function(){if(this.$35s){this.$35s.hideSubmenu();this.$35s.hide();delete this.$35s;delete this.$35p}}
,isc.A.getSubmenuImage=function(_1){if(!this.hasSubmenu(_1))return"&nbsp;";if(!this.$354){var _2=(this.submenuDirection==this.$oz),_3=isc.addProperties({},this.submenuImage),_4=isc.addProperties({},this.submenuDisabledImage);_3.src=isc.Img.urlForState(_3.src,null,null,(_2?this.$oz:null));_4.src=isc.Img.urlForState(_4.src,null,null,(_2?this.$oz:null));this.$354=this.imgHTML(_3);this.$355=this.imgHTML(_4)}
return(this.itemIsEnabled(_1)?this.$354:this.$355)}
,isc.A.itemIsEnabled=function(_1){_1=this.getItem(_1);return(_1&&_1.enabled!=false&&_1.isSeparator!=true)}
,isc.A.$35o=function(){var _1=isc.SB.create();if(this.enableIf)_1.append(this.enableIf,";");_1.append("var menu=this\r");for(var i=0;i<this.data.length;i++){var _3=this.getItem(i);if(!_3)continue;_1.append("var item=this.data["+i+"];\r");if(_3.enableIf){if(isc.isA.String(_3.enableIf)){_1.append("changed|=this.$59g(",i,",",_3.enableIf,");\r")}else if(isc.isA.Function(_3.enableIf)){_1.append("changed|=this.$59g(",i,",this.data[",i,"].enableIf(target,menu,item));\r")}}
if(_3.checkIf){if(isc.isA.String(_3.checkIf)){_1.append("changed|=this.$59h(",i,",",_3.checkIf,");\r")}else if(isc.isA.Function(_3.checkIf)){_1.append("changed|=this.$59h(",i,",this.data[",i,"].checkIf(target,menu,item));\r")}}
if(_3.dynamicTitle){if(isc.isA.String(_3.dynamicTitle)){_1.append("changed|=this.setItemTitle(",i,",",_3.dynamicTitle,");\r")}else if(isc.isA.Function(_3.dynamicTitle)){_1.append("changed|=this.setItemTitle(",i,",this.data[",i,"].dynamicTitle(target,menu,item));\r")}}
if(_3.dynamicIcon){if(isc.isA.String(_3.dynamicIcon)){_1.append("changed|=this.setItemIcon(",i,",",_3.dynamicIcon,");\r")}else if(isc.isA.Function(_3.dynamicIcon)){_1.append("changed|=this.setItemIcon(",i,",this.data[",i,"].dynamicIcon(target,menu,item));\r")}}}
var _4=_1.toString();if(_4=="")return;_1=isc.SB.create();_1.append("var target=this.target,changed=false;\r",_4,"if(changed&&this.isDrawn()){\r","this.redraw('dynamic item change');\r",(isc.Browser.isIE?"this.body.setRowStyle(0);\r":""),"}");this.addMethods({setDynamicItems:new Function(_1.toString())})}
,isc.A.refreshRow=function(){if(this.setDynamicItems)this.setDynamicItems();return this.Super("refreshRow",arguments)}
,isc.A.$59g=function(_1,_2){return this.setItemEnabled(_1,!!_2)}
,isc.A.$59h=function(_1,_2){return this.setItemChecked(_1,!!_2)}
,isc.A.setItemEnabled=function(_1,_2){if(_2==null)_2=true;_1=this.getItem(_1);if(!_1)return;if(_1.enabled!=_2){_1.enabled=_2;this.markForRedraw("itemEnabled");return true}
return false}
,isc.A.setItemChecked=function(_1,_2){if(_2==null)_2=true;_1=this.getItem(_1);if(!_1)return;if(_1.checked!=_2){_1.checked=_2;this.markForRedraw("itemChecked");return true}
return false}
,isc.A.setItemTitle=function(_1,_2){_1=this.getItem(_1);if(!_1)return;if(_1.title!=_2){_1.title=_2;this.markForRedraw("item title change");return true}
return false}
,isc.A.setItemIcon=function(_1,_2,_3){_1=this.getItem(_1);if(!_1)return;if(_1.icon!=_2){_1.icon=_2;if(_3)_1.disabledIcon=_3;this.markForRedraw("item icon change");return true}
return false}
,isc.A.getIcon=function(_1){if(_1.icon){var _2=(this.itemIsEnabled(_1)||!_1.disabledIcon?_1.icon:_1.disabledIcon);return this.imgHTML(_2,(_1.iconWidth?_1.iconWidth:this.iconWidth),(_1.iconHeight?_1.iconHeight:this.iconHeight))}
if(_1.checked){return this.getCheckmarkImage(_1)}
return"&nbsp;"}
,isc.A.getItemTitle=function(_1){var _2;if(this.$35k){_2=this.$35k.getTitle(_1)}else{_2=_1.title||_1.name||_1.id}
_2=_2||"&nbsp;";return _2}
,isc.A.getKeyTitle=function(_1){if(_1.keyTitle)return _1.keyTitle;return"&nbsp;"}
,isc.A.getCheckmarkImage=function(_1){if(!this.$356){this.$356=this.imgHTML(this.checkmarkImage);this.$357=this.imgHTML(this.checkmarkDisabledImage)}
return(this.itemIsEnabled(_1)?this.$356:this.$357)}
,isc.A.setUpKeyListening=function(){var _1="";var _2,_3,_4=this.data.length;for(var i=0;i<_4;i++){_2=this.getItem(i);if(!_2)continue;_3=_2.keys;if(!_3)continue;if(!isc.isAn.Array(_3))_3=[_3];for(var _6,k=0,_8=_3.length;k<_8;k++){_6=_3[k];if(_6==null)continue;isc.Page.registerKey(_6,"target.menuKey("+i+");",this);if(!this.registeredKeys)this.registeredKeys=[];this.registeredKeys.add(_6)}
if(!_2.keyTitle)this.setItemKeyTitle(_2,_3[0])}}
,isc.A.destroy=function(){if(this.registeredKeys){for(var i=0;i<this.registeredKeys.length;i++){isc.Page.unregisterKey(this.registeredKeys[i],this)}}
if(this.$352)this.$352.map("destroy");this.Super("destroy",arguments)}
,isc.A.menuKey=function(_1){if(this.setDynamicItems)this.setDynamicItems();return this.selectMenuItem(_1)}
,isc.A.setItemKeyTitle=function(_1,_2){var _3;if(isc.isA.String(_2))_3=_2
else if(isc.isAn.Object(_2)){if(_2.title)_3=_2.title
else _3=_2.keyName}
_1.keyTitle=_3}
);isc.B._maxIndex=isc.C+66;isc.A=isc.Menu;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.hideAllMenus=function(){if(isc.Menu.$kc.length>0){var _1=isc.Menu.$kc,_2=false,_3,_4=isc.EH.getFocusCanvas();for(var i=_1.length-1;i>=0;i--){var _6=_1[i];if(!_6.isVisible()){continue}
if(_6.$sr(_4)){if(_3==null)_3=_6;_2=true}
_6.hide()}
if(_2&&isc.isA.Canvas(_3.body.focusOnHide)){_3.body.focusOnHide.focus()}
isc.Menu.$kc=[]}
isc.Menu.$353={};if(isc.Menu.$35x)isc.EH.hideClickMask(isc.Menu.$35x);isc.Menu.$35x=null;if(isc.Menu.$358!=null){var _7=isc.Menu.$358;delete isc.Menu.$358;if(isc.EH.lastEvent.eventType==isc.EH.MOUSE_DOWN){_7.$359=true;isc.Page.setEvent(isc.EH.CLICK,_7,isc.Page.FIRE_ONCE,"$36a")}}}
,isc.A.menuForValueMap=function(_1,_2){var _3=[];if(isc.isA.String(_1))_1=this.getPrototype().getGlobalReference(_1);if(isc.isAn.Array(_1)){for(var i=0;i<_1.length;i++){_3[i]={value:_1[i],title:_1[i]}}}else{for(var _5 in _1){_3.add({value:_5,title:_1[_5]})}}
var _6=isc.Menu.$36b;if(_2==false||isc.Menu.$36b==null){_6=isc.Menu.newInstance({autoDraw:false,itemClick:function(_7){if(this.target.valueMapMenuSelected){this.target.valueMapMenuSelected(_7.value)}}})}
if(_2!=false&&isc.Menu.$36b==null)isc.Menu.$36b=_6;_6.setData(_3);return _6}
);isc.B._maxIndex=isc.C+2;isc.Menu.registerStringMethods({itemClick:"item"})
isc.A=isc.ListGrid.getPrototype();isc.A.showHeaderContextMenu=true;isc.A=isc.ListGrid.getPrototype();isc.A.showHeaderMenuButton=false;isc.ClassFactory.defineClass("MenuButton","Button");isc.A=isc.MenuButton.getPrototype();isc.A.title="Show Menu";isc.A.baseStyle="menuButton";isc.A.height=22;isc.A.showMenuButtonImage=true;isc.A.skinImgDir="images/Menu/";isc.A.menuButtonImage="[SKIN]menu_button.gif";isc.A.menuButtonImageUp="[SKIN]menu_button_up.gif";isc.A.hiliteAccessKey=true;isc.A.iconWidth=7;isc.A.iconHeight=7;isc.A.iconOrientation="right";isc.A.iconAlign="right";isc.A.align="left";isc.A.showMenuBelow=true;isc.A.alignMenuLeft=true;isc.A.menu=null;isc.A=isc.MenuButton.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.initWidget=function(_1,_2,_3,_4){if(this.showMenuButtonImage)this.$36c();return this.invokeSuper(isc.MenuButton,"initWidget",_1,_2,_3,_4)}
,isc.A.setShowMenuButtonImage=function(_1){if(_1==this.showMenuButtonImage)return;this.showMenuButtonImage=_1;if(_1)this.$36c();else this.icon=null;if(this.isDrawn())this.markForRedraw()}
,isc.A.setShowMenuBelow=function(_1){if(_1!=this.showMenuBelow){this.showMenuBelow=_1;if(this.showMenuButtonImage){this.$36c();if(this.isDrawn())this.markForRedraw()}}}
,isc.A.$36c=function(){var _1=this.showMenuBelow?this.menuButtonImage:this.menuButtonImageUp;if(isc.isAn.Object(_1)){if(_1.width)this.iconWidth=_1.width;if(_1.height)this.iconHeight=_1.height;this.icon=_1.src}else{this.icon=_1}}
,isc.A.click=function(){if(this.$359)return;this.showMenu()}
,isc.A.$36a=function(){if(this.$359){var _1=this;isc.Page.setEvent(isc.EH.IDLE,function(){_1.$359=null},isc.Page.FIRE_ONCE)}}
,isc.A.keyPress=function(){if(isc.EventHandler.lastEvent.keyName=="Arrow_Down"){this.showMenu();return false}
return this.Super("keyPress",arguments)}
,isc.A.$ur=function(){this.Super("$ur",arguments);this.markForRedraw()}
,isc.A.showContextMenu=function(){this.click();return false}
,isc.A.showMenu=function(){if(isc.isA.String(this.menu))this.menu=window[this.menu];if(!isc.isA.Menu(this.menu))this.$36d(this.menu);if(!isc.isA.Menu(this.menu))return;isc.Menu.$358=this;var _1=this.menu;_1.$8h();var _2=this.getPageLeft();if(!this.alignMenuLeft){_2=_2-(_1.getVisibleWidth()-this.getVisibleWidth())}
var _3=this.showMenuBelow?this.getPageTop()+this.getVisibleHeight()+1:this.getPageTop()-_1.getVisibleHeight()+2;_1.placeNear(_2,_3);_1.show(this.menuAnimationEffect)}
,isc.A.$36d=function(_1){_1.autoDraw=false;var _2=this.menuConstructor||isc.Menu;this.menu=_2.create(_1)}
);isc.B._maxIndex=isc.C+11;isc.ClassFactory.defineClass("SelectionTreeMenu","Menu")
isc.A=isc.SelectionTreeMenu.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.itemClick=function(_1){this.inheritedProperties.button.$21j(_1)}
,isc.A.getBaseStyle=function(_1,_2,_3){var _4=this.inheritedProperties.button;if(_4.$36e(_1))return _4.selectedBaseStyle;return this.Super("getBaseStyle",arguments)}
,isc.A.show=function(){if(this.body){for(var i=0;i<this.getTotalRows();i++){this.body.setRowStyle(i)}}
return this.Super("show",arguments)}
,isc.A.getItemTitle=function(_1,_2,_3,_4,_5){var _6=this.inheritedProperties.button;if(_6.displayField)return _1[_6.displayField];return this.invokeSuper(isc.SelectionTreeMenu,"getItemTitle",_1,_2,_3,_4,_5)}
);isc.B._maxIndex=isc.C+4;isc.ClassFactory.defineClass("TreeMenuButton","MenuButton");isc.A=isc.TreeMenuButton.getPrototype();isc.A.title=null;isc.A.unselectedTitle="Choose a value";isc.A.showPath=false;isc.A.pathSeparatorString="&nbsp;&gt;&nbsp;";isc.A.selectedBaseStyle="treeMenuSelected";isc.A.overflow=isc.Canvas.VISIBLE;isc.A.menuConstructor=isc.SelectionTreeMenu;isc.A=isc.TreeMenuButton.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.getTitle=function(){if(this.title)return this.title;var _1=this.getSelectedItem();if(_1){var _2=this.getTree();if(!this.showPath){return _2.getTitle(_1)}else{var _3=_2.getParents(_1),_4=[];for(var i=_3.length-1;i>=0;i--){if(!_2.showRoot&&i==_3.length-1)continue;_4.add(_2.getTitle(_3[i]))}
_4.add(_2.getTitle(_1));return _4.join(this.pathSeparatorString)}
return _2.getTitle(_1)}else{return this.unselectedTitle}}
,isc.A.$36d=function(_1){_1=isc.addProperties(this.menuDefaults||{},_1,{inheritedProperties:{button:this},canSelectParentItems:this.canSelectParentItems,submenuConstructor:isc.SelectionTreeMenu,dataSource:this.dataSource,data:this.data});if(this.emptyMenuMessage)_1.emptyMessage=this.emptyMenuMessage;if(this.loadDataOnDemand!=null)_1.loadDataOnDemand=this.loadDataOnDemand;var _2=this.Super("$36d",[_1]);this.observe(this.menu,"treeDataLoaded","observer.$21l()");return _2}
,isc.A.$21l=function(){if(this.treeDataLoaded)this.treeDataLoaded()}
,isc.A.getTree=function(){if(!isc.isA.Menu(this.menu))this.$36d(this.menu);return this.menu.$35k}
,isc.A.$21j=function(_1){if(this.itemSelected&&this.itemSelected(_1,this.$36f)==false)
return;this.setSelectedItem(_1)}
,isc.A.setSelectedItem=function(_1){this.$36f=_1;this.markForRedraw()}
,isc.A.getSelectedItem=function(){return this.$36f}
,isc.A.$36e=function(_1){var _2=this.getSelectedItem(),_3=this.getTree();while(_2){if(_1==_2)return true;_2=_3.getParent(_2)}
return false}
);isc.B._maxIndex=isc.C+8;isc.TreeMenuButton.registerStringMethods({itemSelected:"item, oldItem"})
isc.ClassFactory.defineClass("TileLayout","Canvas");isc.A=isc.TileLayout.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.layoutPolicy="fit";isc.A.tileSize=50;isc.A.tileMargin=10;isc.A.layoutMargin=5;isc.A.paddingAsLayoutMargin=true;isc.A.orientation="horizontal";isc.A.overflow="auto";isc.A.expandMargins=true;isc.A.autoWrapLines=true;isc.A.dropIndicatorDefaults={overflow:"hidden",styleName:"layoutDropLine"};isc.B.push(isc.A.initWidget=function(){this.invokeSuper(isc.TileLayout,"initWidget");if(!this.tiles)this.tiles=[];this.data=this.tiles}
,isc.A.draw=function(_1,_2,_3,_4){this.invokeSuper(isc.TileLayout,"draw",_1,_2,_3,_4);this.layoutTiles();if(!this.dropIndicatorDefaults.height)
this.dropIndicatorDefaults.height=this.orientation=="horizontal"?(this.tileHeight||this.tileSize||100):2;if(!this.dropIndicatorDefaults.width)
this.dropIndicatorDefaults.width=this.orientation=="horizontal"?2:(this.tileWidth||this.tileSize||100)}
,isc.A.willScroll=function(){var _1=this.orientation=="horizontal";var _2=this.$td;var _3=this.$te;var _4=this.$tb;var _5=this.$tc;if(this.layoutPolicy=="flow"){if(this.overflow!="auto"&&this.overflow!="scroll")return false;var _6=_1?this.getInnerWidth()-_5:this.getInnerHeight()-_3;var _7=_1?this.getInnerHeight()-_3:this.getInnerWidth()-_4;var _8=_1?_4:_2;var _9=_1?_2:_4;var _10=0;var _11=0;var _12=_1?this.getTileHMargin():this.getTileVMargin();var _13=_1?this.getTileVMargin():this.getTileHMargin();for(var i=0;i<this.getLength();i++){var _15=this.getTile(i);if(!this.autoWrapLines&&_15.startLine)_8=0;var _16=_1?_15.getVisibleWidth():_15.getVisibleHeight();if((this.autoWrapLines&&_8+_16>_6)||(!this.autoWrapLines&&_15.endLine)){_8=_1?_4:_2;;_9+=_10+_13;_10=0;_11++}
var _17=_1?_15.getVisibleHeight():_15.getVisibleWidth();if(_9+_17>_7)return true;if(_10<_17){_10=_17}
_8+=_16+_12}
return false}else{var _7=_1?this.getVisibleHeight()-(_2+_3):this.getVisibleWidth()-(_5+_4);var _17=_1?this.getTileHeight():this.getTileWidth();var _13=_1?this.getTileVMargin():this.getTileHMargin();var _18=this.getTilesPerLine();var _19=Math.floor(_7/(_17+_13));var _20=_18*_19;return(this.getLength()>_20)}}
,isc.A.layoutTiles=function(_1){if(!this.isDrawn()||this.getLength()==0)return;this.$585=[];this.$608=0;this.$619=[this.getScrollLeft(),this.getScrollTop(),this.getInnerWidth(),this.getInnerHeight()];var _2,_3,_4,_5;if(this.paddingAsLayoutMargin){var _6=this.$tq();_4=_6.left;_5=_6.right;_2=_6.top;_3=_6.bottom}
var _7=this.$td=this.$du(this.layoutMargin,_2,0);var _8=this.$te=this.$du(this.layoutMargin,_3,0);var _9=this.$tb=this.$du(this.layoutMargin,_4,0);var _10=this.$tc=this.$du(this.layoutMargin,_5,0);if(this.layoutPolicy=="flow"){this.logDebug("starting flow layout","TileLayout");var _11=this.orientation=="horizontal";var _12=_11?this.getInnerWidth()-_10:this.getInnerHeight()-_8;if(this.willScroll())_12-=this.getScrollbarSize();var _13=_11?_9:_7;var _14=_11?_7:_9;var _15=0;var _16=0;var _17=_11?this.getTileHMargin():this.getTileVMargin();var _18=_11?this.getTileVMargin():this.getTileHMargin();for(var i=0;i<this.getLength();i++){var _20=this.getTile(i);if(!this.autoWrapLines&&_20.startLine)_13=0;var _21=_11?_20.getVisibleWidth():_20.getVisibleHeight();if((this.autoWrapLines&&_13+_21>_12)||(!this.autoWrapLines&&_20.endLine)){_13=_11?_9:_7;;_14+=_15+(i==0?0:_18);_15=0;_16++}
var _22=_11?_14:_13;var _23=_11?_13:_14;this.processTile(i,_22,_23);var _24=_11?_20.getVisibleHeight():_20.getVisibleWidth();if(_15<_24){_15=_24}
_13+=_21+_17}}else{this.logDebug("starting fit layout","TileLayout");var _25=this.getTilesPerLine();var _26=this.getTileHeight();var _27=this.getTileWidth();var _11=this.orientation=="horizontal";var _28,_29,_30;var _31,_32,_33,_34,_35,_36;if(this.shouldUseIncrRendering()){var _37=this.getVisibleTiles();this.$57r=_37;_32=_37[0];_31=this.getLength();var _38=this.getVisibleLines();_35=_38[0];_36=_38[0]+_38[1]}else{_31=this.getLength();_32=0;_35=0;_36=Math.ceil(_31/ _25);_28=this.getTileHMargin();_29=this.getTileVMargin()}
var _39=Math.ceil(this.getLength()/_25);var _29=this.getTileVMargin();var _28=this.getTileHMargin();var _24=_11?_26:_27;var _40=_11?_29:_28;var _41=((_24+_40)*_39)-_40+(_11?_7+_8:_9+_10);_34=this.$58t();_11?_34.setHeight(_41):_34.setWidth(_41);_34.sendToBack();_30=this.getExtraMarginPixels(_25,_26,_27,_28,_29);for(var i=_35;i<_36;i++){var _42=_30;for(var j=0;j<_25;j++){var _44=_11?i:j;var _45=_11?j:i;var _22=(_44*_26)+(_44*_29)+_7;if(!_11&&j+1<=_30)_22+=j+1;var _23=(_45*_27)+(_45*_28)+_9;if(_11&&j+1<=_30)_23+=j+1;var _20=this.processTile(_32,_22,_23,this.getTileHeight(),this.getTileWidth());_32++;if(_32>=_31)break}
if(_32>=_31)break}}}
,isc.A.processTile=function(_1,_2,_3,_4,_5){if(this.$35v){var _6=this.getRecordTile(_1)
if(!_6)return;if(this.$584.findIndex("ID",_6.ID)==-1)return;if(!_6)return;if(_4)_6.setHeight(_4);if(_5)_6.setWidth(_5);if(_6.getTop()!=_2||_6.getLeft()!=_3){_6.$589=_2;_6.$588=_3;this.$586.add(_6)}
var _7=[_3,_2,_6.getVisibleWidth(),_6.getVisibleHeight()];if(isc.Canvas.rectsIntersect(this.$619,_7)){this.$585.add(_6)}}else{var _6=this.getTile(_1);if(_4)_6.setHeight(_4);if(_5)_6.setWidth(_5);_6.setTop(_2);_6.setLeft(_3);this.addChild(_6);_6.show();var _7=[_6.getLeft(),_6.getTop(),_6.getVisibleWidth(),_6.getVisibleHeight()];if(isc.Canvas.rectsIntersect(this.$619,_7)){this.$585.add(_6)}
this.$608+=1;return _6}}
,isc.A.$58t=function(){if(!this.$58u){this.$58u=isc.Canvas.create({autoDraw:false});this.addChild(this.$58u)}
return this.$58u}
,isc.A.getDrawnStartIndex=function(){if(this.$57r)return this.$57r[0];else return null}
,isc.A.getDrawnEndIndex=function(){if(this.$57r)return this.$57r[1];else return null}
,isc.A.shouldUseIncrRendering=function(){if(this.$35v){return true}else if(!this.showAllRecords&&this.layoutPolicy=="fit"&&(this.overflow=="auto"||this.overflow=="hidden")){return true}else{return false}}
,isc.A.getLength=function(){if(!this.tiles)return 0;else return this.tiles.getLength()}
,isc.A.getTilesPerLine=function(){if(this.tilesPerLine)return this.tilesPerLine;else{var _1=this.orientation=="horizontal"?this.getTileWidth():this.getTileHeight();var _2=this.orientation=="horizontal"?(this.tileHMargin||this.tileMargin):(this.tileVMargin||this.tileMargin);var _3=this.orientation=="horizontal"?this.getInnerWidth():this.getInnerHeight();var _4=Math.floor(_3/ _1);var _5=this.orientation=="horizontal"?this.$tb+this.$tc:this.$td+this.$te;var _6=_2*(_4-1)+(_4*_1)+_5;if(_6>_3){var _7=Math.ceil((_6-_3)/_1);_4-=_7}
if(_4<1)_4=1;return _4}}
,isc.A.getVisibleLines=function(){var _1=(this.orientation=="horizontal");var _2=_1?this.getScrollTop():this.getScrollLeft();var _3=_1?this.getTileHeight()+this.getTileVMargin():this.getTileWidth()+this.getTileHMargin();var _4=_1?this.getInnerHeight():this.getInnerWidth();var _5=Math.floor(_2/ _3);if(_5>0)_5--;var _6=Math.ceil(_4/ _3)+2;return[_5,_6]}
,isc.A.getVisibleTiles=function(){var _1=this.getVisibleLines();var _2=this.getTilesPerLine();var _3=_1[0]*_2;var _4=(_1[0]+_1[1])*_2;return[_3,_4]}
,isc.A.scrolled=function(){if(this.shouldUseIncrRendering()){if(this.$57s)isc.Timer.clear(this.$57s);this.$57s=isc.Timer.setTimeout(this.ID+".layoutAfterScroll()")}}
,isc.A.layoutAfterScroll=function(){this.logDebug('layoutAfterScroll',"TileLayout");if(this.shouldLayoutTiles())this.layoutTiles()}
,isc.A.shouldLayoutTiles=function(){var _1=this.getVisibleTiles();if(_1[0]==this.getDrawnStartIndex()&&_1[1]==this.getDrawnEndIndex()){return false}else{return true}}
,isc.A.getTileWidth=function(){if(this.tileWidth)return this.tileWidth;else return this.tileSize}
,isc.A.getTileHeight=function(){if(this.tileHeight)return this.tileHeight;else return this.tileSize}
,isc.A.getInnerBreadth=function(){var _1=this.orientation=="horizontal"?this.getVisibleWidth()-this.getHBorderPad():this.getVisibleHeight()-this.getVBorderPad();if(this.willScroll())_1-=this.getScrollbarSize();return _1}
,isc.A.getTileHMargin=function(){var _1;if(this.tileHMargin){_1=this.tileHMargin}else{_1=this.tileMargin}
if(this.layoutPolicy=="fit"&&this.expandMargins&&this.orientation=="horizontal"){var _2=this.getTilesPerLine();var _3=this.$tb+this.$tc;var _4=Math.floor((this.getInnerBreadth()-(_2*this.getTileWidth())-_3)/(_2-1));if(_4<_1)return _1;else return _4}else{return _1}}
,isc.A.getTileVMargin=function(){var _1;if(this.tileHMargin){_1=this.tileVMargin}else{_1=this.tileMargin}
if(this.layoutPolicy=="fit"&&this.expandMargins&&this.orientation=="vertical"){var _2=this.getTilesPerLine();var _3=this.$td+this.$te;var _4=Math.floor((this.getInnerBreadth()-(_2*this.getTileHeight())-_3)/(_2-1));if(_4<_1)return _1;else return _4}else{return _1}}
,isc.A.getExtraMarginPixels=function(_1,_2,_3,_4,_5){if(this.expandMargins&&this.orientation=="horizontal"){var _6=(_1*_3)+((_1-1)*_4)+(this.$tb+this.$tc);return this.getInnerBreadth()-_6}else if(this.expandMargins&&this.orientation=="vertical"){var _6=(_1*_2)+((_1-1)*_5)+(this.$td+this.$te);return this.getInnerBreadth()-_6}else{return 0}}
,isc.A.getTile=function(_1){if(!this.tiles)return null;else return this.tiles[_1]}
,isc.A.addTile=function(_1,_2){if(!this.tiles)return;if(!_2)_2=this.tiles.getLength();this.tiles.addAt(_1,_2);this.layoutTiles()}
,isc.A.removeTile=function(_1){if(!this.tiles)return;var _2;if(isc.isA.Canvas(_1)){_2=this.tiles.findIndex("ID",_1.ID)}else{_2=this.tiles.findIndex("ID",_1);if(_2==-1)_2=_1}
this.tiles.removeAt(_2);this.layoutTiles()}
,isc.A.getRecordTile=function(_1){return this.tiles.get(_1)}
,isc.A.dropOver=function(){var _1=isc.addProperties(this.dropIndicatorDefaults,this.dropIndicatorProperties);isc.Event.setDragTracker("",_1.width,_1.height,null,null,_1)}
,isc.A.dropMove=function(){if(isc.isAn.Array(this.data)){var x=this.getOffsetX(),y=this.getOffsetY(),_3=this.getPageLeft(),_4=this.getPageTop();var _5=this.findIndexForCoord(x,y);if(_5==null)return;this.$610=_5;var _6=this.getRecordTile(_5);var _7=this.ns.EH.dragTracker;_7.moveTo(_3+(_6.getLeft()-this.getScrollLeft()),_4+(_6.getTop()-this.getScrollTop()));if(this.orientation=="horizontal")_7.setHeight(_6.getVisibleHeight());else _7.setWidth(_6.getVisibleWidth())}}
,isc.A.findIndexForCoord=function(_1,_2){var _3=this.getDrawnStartIndex(),_4=this.getDrawnEndIndex();if(_3==null||_4==null){_3=0;_4=this.data.getLength()}
for(var i=_3;i<_4;i++){var _6=this.getRecordTile(i);if(!_6)continue;if(_6.getLeft()+_6.getVisibleWidth()>_1&&_6.getTop()+_6.getVisibleHeight()>_2)return i}
return null}
,isc.A.drop=function(){var _1=this.$610||0;var _2=this.ns.EH.dragTarget;if(_1==null)_1=this.data.getLength()
else _1=Math.min(_1,this.data.getLength());var _3=_2;var _4=this.data.get(_1);this.transferRecords(_3,_4,_1,_2);isc.Timer.setTimeout(this.ID+".$583()",200)}
,isc.A.$583=function(){this.logDebug("starting $583()","TileLayout");this.$35v=true;this.$0j=[];var _1=this.$584=this.$585;this.$586=[];this.layoutTiles();for(var i=0;i<_1.length;i++){if(!this.$585.contains(_1[i])){_1[i].hide()}}
var _3=this.$586.length;if(_3==0){this.$587();return}
for(var i=0;i<_3;i++){var _4=this.$586[i];_4.show();var _5;if(i==_3-1){_5=_4.animateMove(_4.$588,_4.$589,this.getID()+".$587()")}else{_5=_4.animateMove(_4.$588,_4.$589)}
this.$0j.add({ID:_5,tile:_4})}}
,isc.A.$587=function(){this.$35v=false;this.$584=null;delete this.$584;this.$586=null;delete this.$586;this.layoutTiles()}
,isc.A.setTileSize=function(_1){this.tileSize=_1;this.layoutTiles()}
,isc.A.setTileWidth=function(_1){this.tileWidth=_1;this.layoutTiles()}
,isc.A.setTileHeight=function(_1){this.tileHeight=_1;this.layoutTiles()}
,isc.A.setTileMargin=function(_1){this.tileMargin=_1;this.layoutTiles()}
,isc.A.setTileHMargin=function(_1){this.tileHMargin=_1;this.layoutTiles()}
,isc.A.setTileVMargin=function(_1){this.tileVMargin=_1;this.layoutTiles()}
);isc.B._maxIndex=isc.C+38;isc.ClassFactory.defineClass("TileGrid","TileLayout");isc.A=isc.TileGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.tileValueStyle="tileValue";isc.A.valuesShowRollOver=false;isc.A.valuesShowSelected=true;isc.A.valuesShowDown=false;isc.A.tileValueAlign="center";isc.A.showLabels=false;isc.A.tileLabelStyle="tileLabel";isc.A.wrapValues=false;isc.A.tileConstructor="SimpleTile";isc.A.detailViewerConstructor="DetailViewer";isc.A.recycleTiles=true;isc.A.animateTileChange=true;isc.A.styleName="tileGrid";isc.A.$20s="Arrow_Up";isc.A.$20t="Arrow_Down";isc.A.$60n="Arrow_Left";isc.A.$60o="Arrow_Right";isc.B.push(isc.A.initWidget=function(){this.invokeSuper(isc.TileLayout,"initWidget");if(this.showAllRecords)this.recycleTiles=false;if(this.getDataSource()){this.$601={};if(this.getDataSource().getPrimaryKeyFieldNames().length==0){this.animateTileChange=false}}
this.detailViewer=this.createAutoChild("detailViewer",{tileGrid:this,showLabel:this.showLabels,showBorder:false,cellStyle:this.tileValueStyle,labelStyle:this.tileLabelStyle,blockStyle:"normal",wrapValues:this.wrapValues,cellPadding:0,valueAlign:this.tileValueAlign,useInnerWidth:false,clipValues:true,width:10,height:10,getCellStyle:function(_2,_3,_4,_5){var _1=(_3.cellStyle||this.cellStyle);if(this.tileGrid.valuesShowRollOver&&this.currentTile.state==isc.StatefulCanvas.STATE_OVER){_1+=this.currentTile.getStateSuffix()}else if(this.tileGrid.valuesShowDown&&this.currentTile.state==isc.StatefulCanvas.STATE_DOWN){_1+=this.currentTile.getStateSuffix()}else if(this.tileGrid.valuesShowSelected&&this.currentTile.isSelected()){_1+=this.currentTile.getStateSuffix()}
return _1}});this.setFields(this.fields,true);this.membersMargin=this.tileMargin;this.setData(this.data)}
,isc.A.setDataSource=function(_1,_2){this.Super("setDataSource",arguments);if(this.getDataSource()){this.$601={};if(this.getDataSource().getPrimaryKeyFieldNames().length==0){this.animateTileChange=false}}}
,isc.A.setFields=function(_1,_2){if(!_1&&this.getDataSource()){var _3=this.getDataSource().getIconField();if(_3){_1=[];_1.add({name:_3,type:"image"});_1.add({name:this.getDataSource().getTitleField()})}}
this.invokeSuper(isc.TileGrid,"setFields",_1);this.detailViewer.fields=isc.clone(this.fields);if(!_2)this.layoutTiles()}
,isc.A.computeTileDimensions=function(_1){if(((this.tileHeight&&this.tileWidth)||(this.tileSize))&&!_1)return;if(!((isc.ResultSet&&isc.isA.ResultSet(this.data)&&this.data.resultSize>=this.data.getLength())||isc.isAn.Array(this.data))){return}
if(this.layoutPolicy!="fit")return;var _2=0,_3=0;this.detailViewer.clipValues=false;for(var i=0;i<this.data.getLength();i++){var t=this.getTile(i);var _6=t.overflow;t.setOverflow("visible");t.redraw();t.show();var _7=t.getVisibleHeight();var _8=t.getVisibleWidth();if(_7>_2)_2=_7;if(_8>_3)_3=_8;t.setOverflow(_6);t.hide()}
this.detailViewer.clipValues=true;if(!this.tileHeight&&_2>0)this.tileHeight=_2;if(!this.tileWidth&&_3>0)this.tileWidth=_3}
,isc.A.getTileID=function(_1){if(!_1)return null;var _2=this.getDataSource();if(_2&&_2.getPrimaryKeyFieldNames().length>0){var _3=_2.getPrimaryKeyFields();var _4="";for(var _5 in _3){_4+=_1[_5]}
return this.$601[_4]}else{return _1.$57v}}
,isc.A.setTileID=function(_1,_2){var _3=this.getDataSource();if(_3&&_3.getPrimaryKeyFieldNames().length>0){var _4=_3.getPrimaryKeyFields();var _5="";for(var _6 in _4){_5+=_1[_6]}
this.$601[_5]=_2}else{_1.$57v=_2}}
,isc.A.getTileRecord=function(_1){var _2=this;var _3=_2.data;var _4,_5;if(this.showAllRecords||!_2.getDrawnStartIndex()||!_2.getDrawnEndIndex()){_4=0;_5=_3.getLength()}else{_4=_2.getDrawnStartIndex();_5=_2.getDrawnEndIndex()+1;if(_5>_3.getLength())_5=_3.getLength()}
for(var i=_4;i<_5;i++){var _7=_3.get(i);if(_2.getTileID(_7)==_1.ID)return _7}
return null}
,isc.A.setTileRecord=function(_1,_2){return null}
,isc.A.setData=function(_1){if(this.$35v){return false}
if(!_1)return;if(this.data){this.ignore(this.data,"dataChanged");this.ignore(this.data,"dataArrived")}
if(_1)this.data=_1;if(!this.data)return;if(this.data){if(isc.ResultSet&&isc.isA.ResultSet(this.data)){this.observe(this.data,"dataArrived","observer.dataArrived()");this.observe(this.data,"dataChanged","observer.dataChanged(operationType, originalRecord, rowNum, updateData)")}else{this.observe(this.data,"dataChanged","observer.dataChanged()")}}
if(!this.selection||(this.data!=this.selection.data)){this.createSelectionModel()}
this.dataChanged()}
,isc.A.getData=function(){return this.data}
,isc.A.resized=function(){this.Super("resized",arguments);this.layoutTiles()}
,isc.A.dataArrived=function(){}
,isc.A.dataChanged=function(_1,_2,_3,_4){if(!this.data||(isc.ResultSet&&isc.isA.ResultSet(this.data)&&!this.data.lengthIsKnown()))
{this.logDebug("dataChanged: returning due to no data yet","TileGrid");return}
this.computeTileDimensions();if(!this.$257)this.$257=0;if(_1=="add"){this.logDebug("add","TileGrid");this.layoutTiles()}else if(_1=="remove"){this.logDebug("remove","TileGrid");if((this.recycleTiles&&this.data.getLength()<this.getDrawnEndIndex()-this.getDrawnStartIndex()+1)||!this.recycleTiles){var _5=this.tiles.removeAt(this.tiles.getLength()-1);_5.destroy()}
this.layoutTiles()}else if(_1=="update"){this.logDebug("update","TileGrid");this.layoutTiles()}else if(this.data.getLength()>=this.$257){this.logDebug("filter or sort, new data same or longer","TileGrid");if(this.$257>0)this.$582();else this.layoutTiles()}else{this.logDebug("filter or sort, new data shorter","TileGrid");this.selection.deselectAll();var _6=this.getDrawnEndIndex()+1;var _7=_6>this.data.getLength()?this.data.getLength():_6;var _8=this.getTilesPerLine();if(Math.floor(_6/ _8)>Math.floor(_7/ _8)&&this.getScrollTop()!=0&&this.recycleTiles){this.scrollToTop();this.layoutTiles()}else{this.$582()}}
this.$257=this.data.getLength()}
,isc.A.$582=function(){if(this.animateTileChange){if(this.$35v){var _1=this.$0j;for(var i=0;i<_1.length;i++){this.finishAnimation(_1[i].ID);_1[i].tile.hide()}
return}
this.fireOnPause("tileGridAnimate",this.$583)}else{this.layoutTiles()}}
,isc.A.cleanupExtraTiles=function(_1){var _2=this.tiles;for(var i=_1;i<_2.length;i++){var _4=_2[i];_4.hide();_4.moveTo(0,0)}}
,isc.A.destroy=function(){if(this.data){this.ignore(this.data,"dataChanged");this.ignore(this.data,"dataArrived");if(this.data.$31k&&isc.isA.Function(this.data.destroy))
this.data.destroy()}
this.Super("destroy",arguments)}
,isc.A.$57t=function(_1){return this.ID+"_tile_"+_1}
,isc.A.getLength=function(){if(!this.data||(isc.ResultSet&&isc.isA.ResultSet(this.data)&&!this.data.lengthIsKnown()))return 0;else return this.data.getLength()}
,isc.A.makeTile=function(_1,_2){var _3={ID:this.$57t(_2),tileNum:_2,canHover:true,handleHover:function(){if(this.creator.itemHover)this.creator.fireCallback("itemHover","item",[this])},click:function(){this.creator.$57u(this);this.creator.focus()}};if(_1.tileProperties)isc.addProperties(_3,_1.tileProperties);var _4=_1.tileConstructor?_1.tileConstructor:this.tileConstructor;var _5=this.createAutoChild("tile",_3,_4);this.detailViewer.setWidth(_5.getInnerWidth());this.detailViewer.setHeight(_5.getInnerHeight());return _5}
,isc.A.getTileHTML=function(_1){return this.detailViewer.getBlockHTML([_1])}
,isc.A.getTile=function(_1){var _2,_3,_4;if(isc.isAn.Object(_1)){_3=_1;_4=this.data.indexOf(_1);_2=this.getTileID(_1)}else{_3=this.data.get(_1);if(!_3)return null;_2=this.$57t(_1);_4=_1}
if(!_2)_2=this.$57t(_4);if(this.canReclaimTile(_4)&&!_3.tileConstructor){var _5=this.$57w(_4);_5.redraw();if(this.selection.isSelected(_3)){_5.setSelected(true)}else{_5.setSelected(false)}
return _5}else if(_2&&window[_2]){var _5=this.$57w(_4,window[_2]);_5.redraw();if(this.selection.isSelected(_3)){_5.setSelected(true)}else{_5.setSelected(false)}
return _5}else{var _6=this.$57t(_4),_7;this.setTileID(_3,_6);_7=this.makeTile(_3,_4);if(!this.tiles)this.tiles=[];this.tiles.add(_7);return _7}}
,isc.A.layoutTiles=function(){this.computeTileDimensions();this.invokeSuper(isc.TileGrid,"layoutTiles");var _1=this.tiles?this.tiles.length:0;var _2=this.$608;if(!this.$35v&&_2<_1)this.cleanupExtraTiles(_2)}
,isc.A.$57w=function(_1,_2){var _3=this.data.get(_1),_4;if(!_2){var _5=_1-this.getDrawnStartIndex();_4=this.tiles[_5]}else{_4=_2}
var _6=this.getTileRecord(_4);if(_6)this.setTileID(_6,null);this.setTileID(_3,_4.ID);_4.tileNum=_1;return _4}
,isc.A.canReclaimTile=function(_1){if(this.recycleTiles&&this.tiles&&this.tiles.length>_1-this.getDrawnStartIndex())return true;else return false}
,isc.A.$57u=function(_1){if(this.recordClick(this,_1,this.getTileRecord(_1))!=false){this.selection.selectOnMouseDown(this,_1.tileNum);this.selection.selectOnMouseUp(this,_1.tileNum)}
var _2,_3;if(_1.getTop()<this.getScrollTop()){_3="top"}else if(_1.getTop()+_1.getVisibleHeight()>this.getScrollTop()+this.getInnerHeight()){_3="bottom"}
if(_1.getLeft()<this.getScrollLeft()){_2="left"}else if(_1.getLeft()+_1.getVisibleWidth()>this.getScrollLeft()+this.getInnerWidth()){_2="right"}
if(_2||_3){this.scrollIntoView(_1.getLeft(),_1.getTop(),_1.getVisibleWidth(),_1.getVisibleHeight(),_2,_3,true)}}
,isc.A.recordClick=function(){return true}
,isc.A.selectionChange=function(_1,_2){if(this.selectionChanged&&(this.selectionChanged(_1,_2)==false))return false;var _3=this.selection,_4=_3.lastSelectionItem;var _5=window[this.getTileID(_4)];if(_5&&_5.setSelected){_5.setSelected(_2)}}
,isc.A.keyPress=function(_1,_2){if(this.isAnimating("scroll"))return false;var _3=this.selection.lastSelectionItem;if(!_3)return;var _4=_1.keyName,_5=this.selection.data.indexOf(_3),_6=this.orientation=="horizontal",_7;if(_4==this.$20s){_7=_6?this.$60p(_5,"above"):_5-1}else if(_4==this.$20t){_7=_6?this.$60p(_5,"below"):_5+1}else if(_4==this.$60n){_7=_6?_5-1:this.$60p(_5,"above")}else if(_4==this.$60o){_7=_6?_5+1:this.$60p(_5,"below")}else{return}
if(_7==-1||_7>this.data.getLength()-1)return;if(_7==null)return false;var _8=this.selection.data.get(_7),_9=window[this.getTileID(_8)];if(_9){this.$57u(_9)}
return false}
,isc.A.$60p=function(_1,_2){var _3=this.selection.data,_4=_1,_5=window[this.getTileID(_3.get(_4))],_6=this.orientation=="horizontal",_7=_6?_5.getTop():_5.getLeft(),_8=_6?_5.getLeft():_5.getTop(),_9=_6?_5.getVisibleWidth():_5.getVisibleHeight(),_10=_5;while(_7==(_6?_10.getTop():_10.getLeft())){_4=_2=="above"?_4-1:_4+1;if(_4<0||_4>_3.getLength()-1){return-1}
_10=window[this.getTileID(_3.get(_4))];if(!_10)return-1}
var _11=_6?_10.getTop():_10.getLeft();var _12=-1,_13=0;while((_6?_10.getTop():_10.getLeft())==_11){var _14=_6?_10.getLeft():_10.getTop(),_15=_6?_10.getVisibleWidth():_10.getVisibleHeight(),_16=this.$60q([_8,_8+_9],[_14,_14+_15]);if(_16>_13){_12=_4;_13=_16}
_4=_2=="above"?_4-1:_4+1;if(_4<0||_4>_3.getLength()-1)break;_10=window[this.getTileID(_3.get(_4))];if(!_10)break}
return _12}
,isc.A.$60q=function(_1,_2){if((_2[0]>=_1[0]&&_2[0]<=_1[1])||(_2[1]>=_1[0]&&_2[1]<=_1[1])||(_2[0]<=_1[0]&&_2[1]>=_1[1]))
{var _3=_2[0]>_1[0]?_2[0]:_1[0];var _4=_2[1]>_1[1]?_1[1]:_2[1];return _4-_3}
return 0}
,isc.A.addTile=function(){return false}
,isc.A.removeTile=function(){return false}
,isc.A.getRecordTile=function(_1){var _2=this.getTileID(this.data.get(_1))
if(!_2)return null;else return window[_2]}
,isc.A.drop=function(){var _1=this.$610||0;var _2=this.ns.EH.dragTarget;if(_1==null)_1=this.data.getLength()
else _1=Math.min(_1,this.data.getLength());var _3=this.getDataSource(),_4=_2.getDataSource(),_5;if(_3&&_3==_4){_5=_2.getDragData()}else{_5=_2.transferDragData()}
var _6=this.data.get(_1);this.transferRecords(_5,_6,_1,_2)}
);isc.B._maxIndex=isc.C+34;isc.ClassFactory.defineClass("SimpleTile","StatefulCanvas");isc.A=isc.SimpleTile.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.baseStyle="simpleTile";isc.A.overflow="hidden";isc.A.showRollOver=true;isc.A.redrawOnStateChange=true;isc.B.push(isc.A.initWidget=function(){this.invokeSuper(isc.SimpleTile,"initWidget",arguments);this.showDown=this.creator.valuesShowDown}
,isc.A.getInnerHTML=function(){this.creator.detailViewer.currentTile=this;var _1=this.creator.getTileRecord(this);if(!_1)return null;return this.creator.getTileHTML(_1)}
,isc.A.getRecord=function(){return this.creator.getTileRecord(this)}
);isc.B._maxIndex=isc.C+3;isc.TileGrid.registerStringMethods({itemHover:"item",itemClick:"item",recordClick:"viewer,tile,record"});isc.ClassFactory.defineClass("ColumnTree","Layout");isc.A=isc.ColumnTree;isc.A.TREE_FIELD={width:"*",getCellValue:function(_1,_2,_3,_4){return _1.creator.getCellValue(_1,_2,_3,_4)}};isc.A=isc.ColumnTree.getPrototype();isc.A.orientation="horizontal";isc.A.folderIcon="[SKIN]/folder.gif";isc.A.customIconProperty="icon";isc.A.nodeIcon="[SKIN]file.gif";isc.A.openIconSuffix="open";isc.A.closedIconSuffix="closed";isc.A.showOpenIcons=true;isc.A.showCustomIconOpen=false;isc.A.customIconOpenProperty="showOpenIcon";isc.A.showColumn=true;isc.A.columnConstructor="ListGrid";isc.A.columnDefaults={canSort:false,canGroupBy:false,showHeaderMenuButton:false,selectionChanged:function(_1,_2){if(_2){this.creator.nodeSelected(this,_1)}},bodyProperties:{$29h:function(_1,_2,_3,_4,_5){var _6="padding:0px;border:0px;";if(_4==null)_4=this.getTableElement(_2,_3);if(_4==null)return;if(!this.showHiliteInCells)
{if(_1==null)_1=this.getCellRecord(_2,_3);if(_5==null)_5=this.getCellStyle(_1,_2,_3);var _7=_4.childNodes[0];while(_7&&_7.tagName!="TABLE")_7=_7.childNodes[0];if(_7){_7.className=_5;if(this.getCellCSSText){_4.style.cssText=isc.StringBuffer.concat(this.$29i(_1,_2,_3,_5),this.zeroBorderPadding)}}}
return isc.GridRenderer.getPrototype().$29h.apply(this,[_1,_2,_3,_4,_5])}}};isc.A.showHeaders=false;isc.A.firstColumnTitle=" ";isc.A.showNodeCount=false;isc.A.wrapCells=false;isc.A.iconPadding=3;isc.A.ignoreEmptyCriteria=false;isc.A=isc.ColumnTree.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$34p=["<table cellpadding=0 cellspacing=0 class='",,"' style='",,"border:0px;padding:0px;'><tr><td>",,"</td>","<td>"+(isc.Browser.isSafari||isc.Browser.isIE?"<nobr>":""),,,,(isc.Browser.isSafari?"</nobr>":"")+"</td><td style='padding-left:",,"px;'>",,,"</td>","</tr></table>"];isc.A.$34q=["<td>"+(isc.Browser.isSafari||isc.Browser.isIE?"<nobr>":""),,,,(isc.Browser.isSafari?"</nobr>":"")+"</td><td style='padding-left:",,"px;'>",,,"</td>"];isc.A.$34r="absmiddle";isc.A.$4s={};isc.B.push(isc.A.getDynamicDefaults=function(_1){if(_1=="column"){return{autoDraw:false,showHiliteInCells:true,leaveScrollbarGap:false,selectionType:"single",showHeader:false,fields:isc.clone(this.fields)}}}
,isc.A.initWidget=function(){this.Super("initWidget",arguments);this.columns=[];if(!this.dataSource&&this.data!=null&&this.data.dataSource){this.dataSource=this.data.dataSource}
if(!this.fields||this.fields.length==0){this.fields=[isc.ColumnTree.TREE_FIELD]}
this.columns[0]=this.createAutoChild("column",this.getColumnProperties(this.data?this.data.getRoot():null,0),null,false);this.addMember(this.columns[0]);if(this.data)this.populateFirstColumn()}
,isc.A.populateFirstColumn=function(){if(this.data.showRoot){this.columns[0].setData([this.data.getRoot()])}else{this.columns[0].setData(this.data.getChildren(this.data.getRoot()))}
if(this.shouldShowHeader(null,0)){this.columns[0].setShowHeader(true);this.columns[0].setFieldProperties(0,{title:this.getColumnTitle(null,0)})}}
,isc.A.treeIsTied=function(_1,_2){return false}
,isc.A.nodeSelected=function(_1,_2){var _3=this.getColumnIndex(_2),_4=this.data.isFolder(_2);var _5=_3+1;if(!_4)_5-=1;if(!this.treeIsTied(_1,_2)){this.hideColumnsToRight(_5);if(!_4)return;this.data.openFolder(_2);if(isc.isA.ListGrid(this.columns[_5])){this.columns[_5].setData(this.data.getChildren(_2))}else{this.columns[_5]=this.createAutoChild("column",this.getColumnProperties(_2,_3+1),null,false);this.columns[_5].setData(this.data.getChildren(_2));this.addMember(this.columns[_5])}
if(this.shouldShowHeader(_2,_5)){this.columns[_5].setShowHeader(true);var _6=this.getColumnTitle(_2,_5);this.columns[_5].setFieldProperties(0,{title:_6})}
if(this.columns[_5].data.getLength()>0){this.updateHeadingNodeCount(_2)}
this.columns[_5].show()}}
,isc.A.updateHeadingNodeCount=function(_1){var _2=this.getColumnIndex(_1);if(!this.shouldShowHeader(_1,_2)||!this.showNodeCount)return;if(_2<0)return;if(this.columns[_2+1].data.getLength()==0)return;var _3=this.data.getTitle(_1);if(this.showNodeCount){_3=_3+" ("+this.columns[_2+1].data.getLength()+")"}
this.columns[_2+1].setFieldProperties(0,{title:_3})}
,isc.A.getColumnIndex=function(_1){if(this.data.showRoot){return this.data.getLevel(_1)}else{return this.data.getLevel(_1)-1}}
,isc.A.hideColumnsToRight=function(_1){for(var i=_1+1;i<this.columns.length;i++){this.columns[i].hide();this.columns[i].deselectAllRecords()}}
,isc.A.shouldShowHeader=function(_1,_2){return this.showHeaders}
,isc.A.getColumnTitle=function(_1,_2){if(_2==0){return this.firstColumnTitle}else{return this.data.getTitle(_1)}}
,isc.A.getRecord=function(_1,_2){if(_1==null||_1<0)return null;if(_2!=null){if(_2<0||_2>this.columns.length){return null}
if(_1>this.columns[_2].data.length||!this.columns[_2].isVisible()){return null}
return this.columns[_2].data[_1]}
var _3=0;for(var _4=0;_4<this.columns.length;_4++){if(!this.columns[_4].isVisible())continue;if(_3+this.columns[_4].data.length>_1){return this.columns[_4].data[_1-_3]}
_3+=this.columns[_4].data.length}
return null}
,isc.A.getTreeCellValue=function(_1,_2,_3,_4,_5){if(_3==null){return _1}
var _6=this.$34p;_6[1]=_2.getCellStyle(_3,_4,_5);_6[3]=_2.getCellCSSText(_3,_4,_5);var _7=this.$342(_1,_3,_4,true);for(var i=0;i<10;i++){_6[6+i]=_7[i]}
return _6.join(isc.emptyString)}
,isc.A.$342=function(_1,_2,_3,_4){var _5=this.$34q;_5[1]=null;var _6=this.getIcon(_2),_7=(_3!=null?this.$34n+_3:null);_5[2]=null;_5[3]=this.getIconHTML(_6,_7,_2.iconSize);_5[5]=this.iconPadding;_5[7]=this.wrapCells?null:"<NOBR>"
_5[8]=_1;return _5}
,isc.A.getCellValue=function(_1,_2,_3,_4,_5,_6,_7,_8){var _9=this.getNodeTitle(_2,_3);_9=this.getTreeCellValue(_9,_1,_2,_3,_4);return _9}
,isc.A.getIcon=function(_1,_2){if(isc.isA.Number(_1))_1=this.data.get(_1);if(!_1)return null;var _3=_1[this.customIconProperty],_4=(_3!=null),_5=this.data.isFolder(_1);if(!_4){if(_5)_3=this.folderIcon;else _3=this.nodeIcon}
var _6;if(_5){var _7=_2?false:(this.lastDropFolder==_1&&_1.$347),_8=_2?false:!!this.data.isOpen(_1);if(_7){if(_1.dropIcon!=null)_3=_1.dropIcon;else if(!_4&&this.folderDropImage!=null)_3=this.folderDropImage;else{var _9;if(_4){_9=_1[this.customIconDropProperty];if(_9==null)_9=this.showCustomIconDrop}else{_9=this.showDropIcons}
if(_9)_6=this.dropIconSuffix}}else if(_8){if(_1.openedIcon!=null)_3=_1.openedIcon;else if(!_4&&this.folderOpenImage!=null)_3=this.folderOpenImage;else{var _10;if(_4){_10=_1[this.customIconOpenProperty];if(_10==null)_10=this.showCustomIconOpen}else{_10=this.showOpenIcons}
if(_10)_6=this.openIconSuffix;else if(!_4)_6=this.closedIconSuffix}}else{if(!_4){if(this.folderClosedImage)_3=this.folderClosedImage;else _6=this.closedIconSuffix}}}else{if(!_4&&this.fileImage)_3=this.fileImage}
return isc.Img.urlForState(_3,false,false,_6)}
,isc.A.getIconHTML=function(_1,_2,_3){if(_1==null)return isc.emptyString;if(_3==null)_3=this.iconSize;var _4=this.$4s;_4.src=_1;_4.width=_4.height=_3;_4.name=_2;_4.align=this.$34r;var _5=this.$wf(_4);_5[14]=_2;return _5.join(isc.$ad)}
,isc.A.getNodeTitle=function(_1,_2,_3){return this.data.getTitle(_1)}
,isc.A.getData=function(){return this.data}
,isc.A.setData=function(_1,_2,_3,_4){if(!isc.isA.Tree(_1))return;this.data=_1;this.data.columnTree=this;this.data.dataArrived="this.columnTree.updateHeadingNodeCount(parentNode);";this.data.separateFolders=this.separateFolders;if(this.showRoot&&isc.isA.ResultTree(this.data)){this.logWarn("showRoot may not be set with a databound columnTree, unexpected "+"results may occur")}
this.data.showRoot=this.showRoot;this.data.openDisplayNodeType=this.displayNodeType;this.data.openFolder(this.data.root);this.populateFirstColumn()}
,isc.A.useExistingDataModel=function(_1,_2,_3){return false}
,isc.A.createDataModel=function(_1,_2,_3){return this.createResultTree(_1,_3.callback,_3,null)}
,isc.A.updateDataModel=function(_1,_2,_3){}
,isc.A.getColumn=function(_1){if(isc.isA.TreeNode(_1)){var _2=this.getColumnIndex(_1)+1;if(this.columns[_2]&&this.columns[_2].isVisible())return this.columns[_2]}else{if(this.columns[_1]&&this.columns[_1].isVisible())return this.columns[_1]}
return null}
,isc.A.getColumnProperties=function(_1,_2){}
,isc.A.selectAllRecords=function(_1){if(_1==null)_1=0;if(!this.columns[_1])return;this.columns[_1].selectAllRecords()}
,isc.A.deselectAllRecords=function(_1){if(_1==null)_1=0;if(!this.columns[_1])return;this.columns[_1].deselectAllRecords()}
,isc.A.anySelected=function(_1){if(_1==null)_1=0;if(!this.columns[_1])return false;return this.columns[_1].anySelected()}
,isc.A.getSelection=function(_1){if(_1==null)_1=0;if(!this.columns[_1])return[];return this.columns[_1].getSelection()}
,isc.A.getSelectionObject=function(_1){if(_1==null)_1=0;if(!this.columns[_1])return null;return this.columns[_1].selection}
);isc.B._maxIndex=isc.C+29;isc.ClassFactory.defineClass("DOMTree","Tree");isc.A=isc.DOMTree.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.loadOnInit=true;isc.A.hideTextNodes=true;isc.B.push(isc.A.makeRoot=function(){var _1=this.Super("makeRoot",arguments);_1.$9b=this.rootElement;return _1}
,isc.A.getElement=function(_1){return _1.$9b}
,isc.A.getTitle=function(_1){var _2=this.getElement(_1),_3=_2.getAttribute(this.titleProperty);if(!this.valueIsEmpty(_3))return _3;_3=_2.getAttribute(this.nameProperty);if(!this.valueIsEmpty(_3))return _3;return _2.tagName||_2.nodeName}
,isc.A.valueIsEmpty=function(_1){return _1==null||isc.isAn.emptyString(_1)}
,isc.A.isFolder=function(_1){if(_1==this.root||_1.children!=null)return true;var _2=_1.$9b;if(!_2||!_2.childNodes||_2.childNodes.length==0)return false;if(!this.hideTextNodes)return true;return isc.xml.hasElementChildren(_2)}
,isc.A.moveList=function(_1,_2,_3){var _4=_1[0],_5=this.getElement(_4);this.logWarn("moveList: "+this.echoAll(_1)+", newParent: "+this.echo(_2)+", index: "+_3);this.$36g(_5,_2,_3);this.Super("moveList",arguments)}
,isc.A.remove=function(_1){var _2=this.getElement(_1);_2.parentNode.removeChild(_2);return this.Super("remove",arguments)}
,isc.A.addElement=function(_1,_2,_3){this.$36g(_1,_2,_3);if(this.isLoaded(_2)){var _4={$9b:_1};this.add(_4,_2,_3)}else{this.dataChanged()}}
,isc.A.$36g=function(_1,_2,_3){var _4=this.getElement(_2);if(_3==null){this.logWarn("appending: "+this.echoLeaf(_1)+" to: "+this.echoLeaf(_4));_4.appendChild(_1)}else{var _5=this.getChildren(_2)[_3],_6=this.getElement(_5);this.logWarn("inserting into: "+this.echoLeaf(_4)+", before: "+this.echoLeaf(_6));_4.insertBefore(_1,_6)}}
,isc.A.loadChildren=function(_1){if(this.isLoaded(_1))return;try{var _2=_1.$9b;if(_2==null)return;var _3=_2.childNodes;if(isc.Browser.isMoz&&_2.contentDocument){_3=[_2.contentDocument.documentElement]}else{if(this.loadingBatch()&&!isc.xml.hasElementChildren(_2))return}
_1[this.openProperty]=true;if(_3!=null){for(var i=0;i<_3.length;i++){var _5=_3[i];if(this.hideTextNodes&&_5.nodeName.startsWith("#"))continue;var _6={$9b:_5};this.add(_6,_1)}}
this.setLoadState(_1,isc.Tree.LOADED)}catch(e){this.logWarn("parent node: "+this.echo(_1)+", at path: "+this.getPath(_1)+", error: "+this.echo(e)+this.getStackTrace())}}
);isc.B._maxIndex=isc.C+10;isc.defineClass("DOMGrid","TreeGrid");isc.A=isc.DOMGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.canDragRecordsOut=true;isc.A.canAcceptDroppedRecords=true;isc.A.canReorderRecords=true;isc.A.showRoot=true;isc.A.$36h="&lt;";isc.A.$36i="&gt;";isc.A.$36j=[" ",,'="',,'"'];isc.A.colorMap={table:"#009900",tr:"#333399",td:"#663366",form:"#CC6600",input:"#3333FF",textarea:"#3333FF",div:"#663300",span:"#663300"};isc.A.colorPrefix="color:";isc.A.$36k={};isc.B.push(isc.A.initWidget=function(){this.Super(this.$oc);if(this.url){isc.xml.loadXML(this.url,this.getID()+".setRootElement(xmlDoc.documentElement)")}}
,isc.A.getDefaultData=function(){return null}
,isc.A.getElement=function(_1){return this.data.getElement(_1)}
,isc.A.setRootElement=function(_1){this.rootElement=_1;var _2=isc.DOMTree.create({rootElement:_1});this.setData(_2)}
,isc.A.getIcon=function(){}
,isc.A.getNodeTitle=function(_1,_2,_3){if(_1==null)return null;if(_1.$9g)return _1.$9g;var _4=this.htmlMode?this.$36l(_1):this.$36m(_1);return(_1.$9g=_4)}
,isc.A.dataChanged=function(){this.Super("dataChanged",arguments);this.data.getOpenList().setProperty("$9g",null)}
,isc.A.$36m=function(_1){if(_1.$9b==null){this.logWarn("no element for node: "+this.echo(_1))}
var _2=_1.$9b,_3=isc.emptyString,_4=this.$36n;if(_4==null)_4=this.$36n=isc.SB.create();else _4.clear();_4.append(this.$36h,(_2.tagName||_2.nodeName));var _5=_2.attributes;if(_5!=null){var _6=this.$36j;for(var i=0;i<_5.length;i++){var _8=_5[i];_6[1]=_8.name;_6[3]=_8.value;_4.append(_6)}}
if(!isc.xml.hasElementChildren(_2)){_4.append(this.$36i,isc.xml.getElementText(_2),"&lt;/",(_2.tagName||_2.nodeName),this.$36i)}else if(_2.childNodes.length>0){_4.append(this.$36i)}else{_4.append("/&gt;")}
return _4.toString()}
,isc.A.$36l=function(_1){var _2=_1.$9b,_3=isc.emptyString,_4,_5;if(isc.Browser.isIE&&_2.scopeName=="VML"){_4=(_2.style?_2.style.width:null);_5=(_2.style?_2.style.height:null)}else{_4=_2.width||(_2.style?_2.style.width:null);_5=_2.height||(_2.style?_2.style.height:null)}
var _6=(_2.tagName&&_2.tagName.toLowerCase()=="td");return isc.SB.concat(this.$36h,(_2.tagName||_2.nodeName),(_2.id?" ID="+_2.id:_3),(!this.valueIsEmpty(_4)?" WIDTH="+_4:_3),(!this.valueIsEmpty(_5)?" HEIGHT="+_5:_3),(_6&&_2.rowSpan>1?" ROWSPAN="+_2.rowSpan:_3),(_6&&_2.colSpan>1?" COLSPAN="+_2.colSpan:_3),this.$36i)}
,isc.A.valueIsEmpty=function(_1){return _1==null||isc.isAn.emptyString(_1)}
,isc.A.getCellCSSText=function(_1,_2,_3){var _4=this.data.getElement(_1);if(_4==null)return null;var _5=_4.tagName;if(_5==null)return null;if(this.$36k[_5]){_5=this.$36k[_5]}else{this.$36k=_5=_5.toLowerCase()}
if(this.colorMap[_5]!=null){return isc.SB.concat(this.colorPrefix,this.colorMap[_5],isc.semi)}}
);isc.B._maxIndex=isc.C+11;isc.ClassFactory.defineClass("MenuBar","Toolbar");isc.addGlobal("Menubar",isc.MenuBar);isc.A=isc.MenuBar.getPrototype();isc.A.overflow=isc.Canvas.VISIBLE;isc.A.defaultHeight=22;isc.A.menuConstructor="Menu";isc.A.buttonConstructor="MenuBarButton";isc.A.tabIndex=-1;isc.A.tabWithinToolbar=false;isc.A.buttonDefaults={showDown:false,showRollOver:true,showFocused:true,showFocusedAsOver:true};isc.A=isc.MenuBar.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.initWidget=function(){this.Super("initWidget",arguments)}
,isc.A.setButtons=function(_1){_1=[];for(var i=0;i<this.menus.length;i++){var _3=this.menus[i];_1[i]=this.$36o(_3,i)}
return this.Super("setButtons",[_1])}
,isc.A.$36o=function(_1,_2){return{title:_1.title,width:(_1.menuButtonWidth?_1.menuButtonWidth:_1.width),menuNum:_2,focusChanged:function(_3){if(isc.Browser.isMoz&&_3)this.bringToFront()}}}
,isc.A.setMenus=function(_1){if(!isc.isAn.Array(_1))_1=[_1];for(var i=0;i<this.members.length;i++){var _3=this.members[i],_4=this.menus[_3.menuNum];if(_3.isObserving(_4,"hide")){_3.ignore(_4,"hide")}}
this.menus=_1;this.setButtons(_1)}
,isc.A.$36p=function(_1,_2){if(!_1)return;if(_2==-1){var _3=_1.menuNum,_4=this.menus[_1.menuNum];if(_1.isObserving(_4,"hide")){_1.ignore(_4,"hide")}}
_1.menuNum=_2}
,isc.A.addMenus=function(_1,_2){if(!_1)return;if(!isc.isAn.Array(_1))_1=[_1];if(!this.menus)this.menus=[];if(_2==null)_2=this.menus.length;if(!this.$6c){this.menus.addListAt(_1,_2)}else{for(var i=_2;i<this.members.length;i++){this.$36p(this.members[i],(i+_1.length))}
this.menus.addListAt(_1,_2);var _4=[];for(var i=0;i<_1.length;i++){var _5=this.menus.indexOf(_1[i]);_4[i]=this.$36o(_1[i],_5)}
this.addButtons(_4,_2)}}
,isc.A.removeMenus=function(_1){if(_1==null)return;if(!isc.isAn.Array(_1))_1=[_1];var _2=[],_3=this.menus.duplicate();for(var i=0;i<_1.length;i++){var _5=_1[i];if(isc.isA.Number(_5))_5=this.menus[_5];else if(!this.menus.contains(_5))continue;_3.remove(_5);var _6=this.menus.indexOf(_5);if(this.$6c)_2.add(this.members[_6])}
if(!this.$6c){this.menus=_3;return}
for(var i=0;i<this.menus.length;i++){if(this.menus[i]==_3[i])continue;this.$36p(this.members[i],_3.indexOf(this.menus[i]))}
this.menus=_3;this.removeButtons(_2)}
,isc.A.showMenu=function(_1){var _2;if(isc.isA.Number(_1))_2=this.menus[_1];else{_2=_1;_1=this.menus.indexOf(_2)}
if(!_2){this.logWarn("showMenu() called with invalid menu number: "+_1+".  No effect.");return}
var _3;for(var i=0;i<this.members.length;i++){if(this.members[i].menuNum==_1){_3=this.members[i]}}
if(!isc.isA.Canvas(_2)){if(_2.ID==null)_2.ID=this.getID()+"_menu"+_1;_2.autoDraw=false;_2=this.menus[_1]=isc.ClassFactory.newInstance(this.menuConstructor,_2,this.menuDefaults)}
if(this.activeMenu!=null){this.menus[this.activeMenu].hideMenuTree()}
_2.eventParent=this;_2.moveTo(_3.getPageLeft(),_3.getPageBottom());_2.show();_3.$36q=_3.showRollOver;_3.showRollOver=false;_3.setState(isc.StatefulCanvas.STATE_DOWN);this.activeMenu=_1;if(!_3.isObserving(_2,"hide")){_3.observe(_2,"hide","observer.menuHidden(observed)")}
var _5=isc.EH;if(_5.targetIsMasked(this))this.bringToFront();var _6=_5.clickMaskRegistry.last(),_7=_5.getMaskedFocusCanvas(_6);if(this.members.contains(_7))_5.setMaskedFocusCanvas(null,_6);_2.body.focusOnHide=_3}
,isc.A.$6d=function(_1){if(!this.activeMenu==null)return this.Super("$6d",arguments);if(_1==null)_1=true;var _2=this.activeMenu,_3=_1?1:-1,_4=_2+_3,_5=this.getMembers();while(_2!=_4){if(_4<0)_4=_5.length-1;else if(_4>=this.members.length)_4=0;var _6=_5[_4];if(!_6.isDisabled()){_6.showMenu();break}
_4+=_3}}
,isc.A.getFocusButtonIndex=function(){if(this.activeMenu!=null)return this.activeMenu;return this.Super("getFocusButtonIndex",arguments)}
,isc.A.mouseDown=function(){return false}
,isc.A.mouseUp=function(){return false}
,isc.A.click=function(){return false}
);isc.B._maxIndex=isc.C+13;isc.ClassFactory.defineClass("MenuBarButton","MenuButton");isc.A=isc.MenuBarButton.getPrototype();isc.A.showMenuButtonImage=false;isc.A.showDown=false;isc.A.autoDraw=false;isc.A.align="center";isc.A=isc.MenuBarButton.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.mouseOver=function(){this.Super("mouseOver",arguments);var _1=this.parentElement.activeMenu;if(_1!=null&&_1!=this.menuNum){this.showMenu()}}
,isc.A.mouseDown=function(){if(this.parentElement.activeMenu==this.menuNum){isc.Menu.hideAllMenus()}else{this.showMenu()}}
,isc.A.mouseUp=function(){}
,isc.A.click=function(){}
,isc.A.mouseOut=function(){if(this.parentElement.activeMenu!=this.menuNum){this.Super("mouseOut",arguments)}}
,isc.A.handleKeyPress=function(_1,_2){if(_1.keyName=="Space"||_1.keyName=="Enter")return this.showMenu();if(this.keyPress){this.convertToMethod("keyPress");return this.keyPress(_1,_2)}}
,isc.A.showMenu=function(){this.parentElement.showMenu(this.menuNum)}
,isc.A.menuHidden=function(_1){if(isc.$cv)arguments.$cw=this;if(this.state==isc.StatefulCanvas.STATE_DOWN){if(this.hasFocus&&this.showFocused)this.setState(isc.StatefulCanvas.STATE_OVER);else this.setState(isc.StatefulCanvas.STATE_UP)}
this.showRollOver=this.$36q;delete this.$36q;this.menuIsDown=false;if(this.parentElement.activeMenu==this.menuNum){this.parentElement.activeMenu=null}}
);isc.B._maxIndex=isc.C+8;isc.ClassFactory.defineClass("CellSelection");isc.A=isc.CellSelection;isc.A.$24e=0;isc.A.COL_SELECTION_FLAGS=null;isc.A=isc.CellSelection;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.generateFlagTable=function(){isc.CellSelection.COL_SELECTION_FLAGS=[];for(var i=0;i<32;i++)
isc.CellSelection.COL_SELECTION_FLAGS[i]=Math.pow(2,i)}
);isc.B._maxIndex=isc.C+1;isc.A=isc.CellSelection.getPrototype();isc.A.data=null;isc.A.numCols=0;isc.A.selectionProperty=null;isc.A.$q7=true;isc.A.$24f=[];isc.A.lastSelectedCell=[];isc.A.changedCells=[];isc.A=isc.CellSelection.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.init=function(){if(!isc.CellSelection.COL_SELECTION_FLAGS)isc.CellSelection.generateFlagTable();if(!this.selectionProperty)this.selectionProperty="_cellSelection_"+isc.CellSelection.$24e++;this.setData((this.data?this.data:[]))}
,isc.A.setData=function(_1){if(this.data!=null)this.ignoreData(this.data);this.data=_1;if(this.data!=null)this.observeData(this.data)}
,isc.A.observeData=function(_1){this.observe(_1,"dataChanged","observer.$q7 = true")}
,isc.A.ignoreData=function(_1){this.ignore(_1,"dataChanged")}
,isc.A.cellIsSelected=function(_1,_2){var _3=this.data[_1],_4=(_3?_3[this.selectionProperty]:null),_5=(_4?_4[Math.floor(_2/ 32)]:null),_6=isc.CellSelection.COL_SELECTION_FLAGS[_2%32];return(_5!=null&&((_5&_6)!=0))}
,isc.A.rowHasSelection=function(_1){var _2=this.data[_1],_3=(_2?_2[this.selectionProperty]:null),_4=Math.ceil(this.numCols/ 32);if(!_2||!_2[this.selectionProperty])return false;for(var i=0;i<_4;i++){if(_3[i])return true}
return false}
,isc.A.colHasSelection=function(_1){if(_1>this.numCols-1)return false;var _2=isc.CellSelection.COL_SELECTION_FLAGS[_1%32],_3=Math.floor(_1/ 32);var _4=this.data,_5=_4.length;for(var i=0;i<_5;i++){var _7=_4[i][this.selectionProperty];if(_7&&_7[_3]&&((_7[_3]&_2)!=0))
return true}
return false}
,isc.A.anySelected=function(){var _1=Math.ceil(this.numCols/ 32);var _2=this.data,_3=_2.length;for(var i=0;i<_3;i++){var _5=_2[i][this.selectionProperty];if(!_5)continue;for(var j=0;j<_1;j++){if(_5[j])return true}}
return false}
,isc.A.getSelectedCells=function(){if(!this.$q7)return this.$24f;var _1=[],_2=isc.CellSelection.COL_SELECTION_FLAGS,_3=Math.ceil(this.numCols/ 32),_4=this.data,_5=_4.length,_6;for(var i=0;i<_5;i++){_6=_4[i][this.selectionProperty];if(!_6)continue;for(var j=0,_9,_10;j<_3;j++){_9=_6[j];if(!_9)continue;_10=(j==_3-1&&this.numCols%32!=0)?this.numCols%32:32;for(var k=0;k<_10;k++){if((_9&_2[k])!=0){_1[_1.length]=[i,j*32+k]}}}}
this.$24f=_1;this.$q7=false;return _1}
,isc.A.getSelectionRowNums=function(){var _1=[],_2=Math.ceil(this.numCols/ 32),_3=this.data,_4=_3.length,_5;for(var i=0;i<_4;i++){_5=_3[i][this.selectionProperty];if(!_5)continue;for(var j=0,_8;j<_2;j++){if(_5[j]){_1[_1.length]=i;break}}}
return _1}
,isc.A.getSelectionColNums=function(){var _1=[],_2=[],_3=isc.CellSelection.COL_SELECTION_FLAGS,_4=Math.ceil(this.numCols/ 32),_5=this.data,_6=_5.length,_7;for(var i=0;i<_6;i++){_7=_5[i][this.selectionProperty];if(!_7)continue;for(var j=0,_10;j<_4;j++){if(_7[j]){_2[j]=_2[j]|_7[j]}}}
if(_2.length==0)return _1;for(var i=0,_11=this.numCols;i<_11;i++){if((_2[Math.floor(i/ 32)]&_3[i%32])!=0)
_1[_1.length]=i}
return _1}
,isc.A.getSelectionBounds=function(){var _1=this.getSelectionRowNums(),_2=this.getSelectionColNums();return[_1.first(),_2.first(),_1.last(),_2.last()]}
,isc.A.$24g=function(_1,_2,_3){var _4=this.data[_1],_5=(_4?_4[this.selectionProperty]:null),_6=Math.floor(_2/ 32),_7=(_5?_5[Math.floor(_2/ 32)]:0),_8=isc.CellSelection.COL_SELECTION_FLAGS[_2%32];if(!_4||_2>this.numCols-1)return false;if(_4.enabled==false)return false;if(_5==null){_5=_4[this.selectionProperty]=[];for(var i=0,_10=Math.ceil(this.numCols/ 32);i<_10;i++)_5[i]=0}
else if(_7==null){_5[_6]=0}
if(((_7&_8)!=0)==_3)return false;_5[_6]=_7^_8;if(_3)this.lastSelectedCell=[_1,_2];this.$q7=true;return true}
,isc.A.setCellRangeSelection=function(_1,_2,_3,_4,_5){this.changedCells=this.$24h(_1,_2,_3,_4,_5);return this.$24i()}
,isc.A.$24h=function(_1,_2,_3,_4,_5){var _6=[],_7,_8,_9,_10;if(_1<=_3){_7=_1;_8=_3}else{_7=_3;_8=_1}
if(_2<=_4){_9=_2;_10=_4}else{_9=_4;_10=_2}
if(this.logIsDebugEnabled()){this.logDebug((_5?"selecting ":"deselecting ")+[_7,_9]+" through "+[_8,_10])}
for(var _11=_7;_11<=_8;_11++){for(var _12=_9;_12<=_10;_12++){if(this.$24g(_11,_12,_5)){_6[_6.length]=[_11,_12]}}}
return _6}
,isc.A.setCellListSelection=function(_1,_2){if(!_1)return false;var _3=[];for(var i=0,_5=_1.length,_6,_7;i<_5;i++){_6=_1[i][0];_7=_1[i][1];if(this.$24g(_6,_7,_2))
_3[_3.length]=[_6,_7]}
this.changedCells=_3;return this.$24i()}
,isc.A.$24i=function(){if(this.changedCells.length>0){this.selectionChanged();return true}else
return false}
,isc.A.selectionChanged=function(){}
,isc.A.setCellSelection=function(_1,_2,_3){if(this.$24g(_1,_2,_3)){this.changedCells=[[_1,_2]];this.selectionChanged();return true}else
return false}
,isc.A.selectCell=function(_1,_2){return this.setCellSelection(_1,_2,true)}
,isc.A.deselectCell=function(_1,_2){return this.setCellSelection(_1,_2,false)}
,isc.A.selectCellRange=function(_1,_2,_3,_4){this.changedCells=this.$24h(_1,_2,_3,_4,true);return this.$24i()}
,isc.A.deselectCellRange=function(_1,_2,_3,_4){this.changedCells=this.$24h(_1,_2,_3,_4,false);return this.$24i()}
,isc.A.selectRow=function(_1){return this.selectCellRange(_1,0,_1,this.numCols-1)}
,isc.A.deselectRow=function(_1){return this.deselectCellRange(_1,0,_1,this.numCols-1)}
,isc.A.selectCol=function(_1){return this.selectCellRange(0,_1,this.data.length-1,_1)}
,isc.A.deselectCol=function(_1){return this.deselectCellRange(0,_1,this.data.length-1,_1)}
,isc.A.selectAll=function(){return this.selectCellRange(0,0,this.data.length-1,this.numCols-1)}
,isc.A.deselectAll=function(){return this.deselectCellRange(0,0,this.data.length-1,this.numCols-1)}
,isc.A.selectCellList=function(_1){return this.setCellListSelection(_1,true)}
,isc.A.deselectCellList=function(_1){return this.setCellListSelection(_1,false)}
,isc.A.selectSingleCell=function(_1,_2){var _3=this.cellIsSelected(_1,_2);this.changedCells=this.$24h(0,0,this.data.length-1,this.numCols-1,false);this.$24g(_1,_2,true);if(!_3)
this.changedCells[this.changedCells.length]=[_1,_2];return this.$24i()}
,isc.A.selectSingleRow=function(_1){var _2=[];if(_1>0)
_2=this.$24h(0,0,_1-1,this.numCols-1,false);_2=_2.concat(this.$24h(_1,0,_1,this.numCols-1,true));if(_1<this.data.length-1)
_2=_2.concat(this.$24h(_1+1,0,this.data.length-1,this.numCols-1,false));this.changedCells=_2;return this.$24i()}
,isc.A.selectSingleCol=function(_1){var _2=[];if(_1>0)
_2=this.$24h(0,0,this.data.length-1,_1-1,false);_2=_2.concat(this.$24h(0,_1,this.data.length-1,_1,true));if(_1<this.numCols-1)
_2=_2.concat(this.$24h(0,_1+1,this.data.length-1,this.numCols-1,false));this.changedCells=_2;return this.$24i()}
,isc.A.selectOnMouseDown=function(_1,_2,_3){if(_1.selectionType==isc.Selection.NONE)return false;this.startRow=this.lastRow=_2;this.startCol=this.lastCol=_3;var _4=this.cellIsSelected(_2,_3),_5=this.getSelectedCells(),_6=this.getSelectionBounds();this.deselectCellOnMouseUp=false;this.deselectOthersOnMouseUp=false;if(_1.selectionType==isc.Selection.SINGLE){this.selectSingleCell(_2,_3);return true}else if(isc.EventHandler.shiftKeyDown()){if(_5.length==0){this.selectCell(_2,_3);return true}else{var _7=_6[0],_8=_6[1],_9=_6[2],_10=_6[3];if(_2<_7)
_7=_2;else if(_2>=_9)
_9=_2;else{this.deselectCellRange(_2+1,_8,_9,_10);_9=_2}
if(_3<_8)
_8=_3;else if(_3>=_10)
_10=_3;else{this.deselectCellRange(_7,_3+1,_9,_10);_10=_3}
this.selectCellRange(_7,_8,_9,_10);return true}}else if(_1.selectionType==isc.Selection.SIMPLE){if(!_4){this.selectCell(_2,_3);return true}else{this.deselectCellOnMouseUp=true;return false}}else if(isc.Browser.isMac?isc.EventHandler.metaKeyDown():isc.EventHandler.ctrlKeyDown()){this.setCellSelection(_2,_3,!_4);return true}else{if(!_4){this.selectSingleCell(_2,_3);return true}else if(isc.EventHandler.rightButtonDown()){this.deselectOnDragMove=true;return false}else{if(this.dragSelection){if(this.simpleDeselect){this.deselectAll();this.selectOriginOnDragMove=true;return true}
this.selectSingleCell(_2,_3);return true}else{if(this.simpleDeselect){this.deselectAllOnMouseUp=true}else{this.deselectOthersOnMouseUp=(_5.length>1)}
return false}}}}
,isc.A.selectOnDragMove=function(_1,_2,_3){var _4=this.startRow,_5=this.startCol,_6=this.lastRow,_7=this.lastCol;if(_2<0||_3<0){this.logWarn("selectOnDragMove: aborting due to negative coordinate: "+[_2,_3]);return}
if(_2==_6&&_3==_7)return;if(_1.selectionType==isc.Selection.SINGLE){this.selectSingleCell(_2,_3);return}
var _8=[];if(this.selectOriginOnDragMove){this.$24g(_4,_5);_8.add([_4,_5]);this.selectOriginOnDragMove=false}else if(this.deselectOnDragMove||this.deselectAllOnMouseUp||this.deselectOthersOnMouseUp)
{this.selectSingleCell(_4,_5);this.deselectAllOnMouseUp=this.deselectOthersOnMouseUp=this.deselectOnDragMove=false}
if((_2!=_6&&((_6>=_4&&_4>=_2)||(_2>=_4&&_4>=_6)))||(_3!=_7&&((_7>=_5&&_5>=_3)||(_3>=_5&&_5>=_7))))
{this.$24g(_4,_5,false);_8.addList(this.$24h(_4,_5,_6,_7,false));this.$24g(_4,_5,true);_8.addList(this.$24h(_4,_5,_2,_3,true));this.changedCells=_8;this.$24i();this.lastRow=_2;this.lastCol=_3;return}
if(_2>=0&&_2!=_6){if(_4>=_6&&_6>_2){_8.addList(this.$24h(_2,_5,_6-1,_7,true))}else if(_4>=_2&&_2>_6){_8.addList(this.$24h(_6,_5,_2-1,_7,false))}else if(_4<=_2&&_2<_6){_8.addList(this.$24h(_2+1,_5,_6,_7,false))}else if(_4<=_6&&_6<_2){_8.addList(this.$24h(_6+1,_5,_2,_7,true))}
_6=this.lastRow=_2}
if(_3>=0&&_3!=_7){if(_5>=_7&&_7>_3){_8.addList(this.$24h(_4,_3,_6,_7-1,true))}else if(_5>=_3&&_3>_7){_8.addList(this.$24h(_4,_7,_6,_3-1,false))}else if(_5<=_3&&_3<_7){_8.addList(this.$24h(_4,_3+1,_6,_7,false))}else if(_5<=_7&&_7<_3){_8.addList(this.$24h(_4,_7+1,_6,_3,true))}
this.lastCol=_3}
this.changedCells=_8;this.$24i()}
,isc.A.selectOnMouseUp=function(_1,_2,_3){if(_1.selectionType==isc.Selection.NONE)return false;if(this.deselectOthersOnMouseUp){this.selectSingleCell(_2,_3);this.deselectOthersOnMouseUp=false;return true}else if(this.deselectRecordOnMouseUp){this.deselectCell(_2,_3);this.deselectRecordOnMouseUp=false;return true}else if(this.deselectAllOnMouseUp){this.deselectAll();this.deselectAllOnMouseUp=false}else
return false}
);isc.B._maxIndex=isc.C+37;isc._moduleEnd=isc._Grids_end=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc.Log&&isc.Log.logIsInfoEnabled('loadTime'))isc.Log.logInfo('Grids module init time: ' + (isc._moduleEnd-isc._moduleStart) + 'ms','loadTime');}else{if(window.isc && isc.Log && isc.Log.logWarn)isc.Log.logWarn("Duplicate load of module 'Grids'.");}
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

