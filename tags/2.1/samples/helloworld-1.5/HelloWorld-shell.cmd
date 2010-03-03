if not "%GWT_HOME%" == "" goto shell
echo Set the environment variable GWT_HOME to point to you GWT root directory.
goto end

:shell

@java -Xmx500M -cp "%~dp0\src;%~dp0\bin;%GWT_HOME%/gwt-user.jar;%GWT_HOME%/gwt-dev-windows.jar;../smartgwt.jar" com.google.gwt.dev.GWTShell -out "%~dp0\www" %* com.mycompany.HelloWorld/HelloWorld.html

:end