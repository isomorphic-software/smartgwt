<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<HTML>
<HEAD>
<%-- page title is driven by main page via the 'title' parameter to this page --%>
<TITLE><%=request.getParameter("title")%></TITLE>
</HEAD>
<%-- body overflow: hidden - suppress page level scrollbars --%>
<!-- onafterprint - supported in IE only -->
<BODY overflow="hidden" onload="pageLoaded()" onafterprint="printed()">

<script>
// document.write out our skin styles file
if (window.parent && window.parent.isc) {
    document.write('<LINK REL="STYLESHEET" TYPE="text/css" HREF=' + 
                   window.parent.isc.Page.getURL("[SKIN]/skin_styles.css")+
                   ">");
}
</script>

<SCRIPT>
function pageLoaded() {
    window.controllerCanvas = '<%=request.getParameter("id")%>';
    parent[controllerCanvas].iframeLoad();
}

function printed() {
    parent[window.controllerCanvas].printComplete();
}

function assignHTML(HTML) {
    getPrintElement().innerHTML = HTML;
}

function getPrintElement() {
    return document.getElementById('printElement');
}

function doPrint(callback) {
    // focus() required for IE - otherwise it prints the top-level window
    focus();
    print();
    
}

</SCRIPT>

<span id='printElement'></span>

</SCRIPT>
</BODY>
</HTML>
