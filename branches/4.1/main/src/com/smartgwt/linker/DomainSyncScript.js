var dot = document.domain.indexOf(".");
if (dot != -1) {
    document.domain = document.domain.substring(dot + 1);
}