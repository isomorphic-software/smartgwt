SmartGWT Showcase
-----------------
The SmartGWT Showcase contains many easy-to-follow illustrations of SmartGWT's
capabilities.


Prerequisites
-------------
- Google Web Toolkit, 2.6.1 or later
  http://code.google.com/webtoolkit/download.html

  Ensure GWT_HOME to the location of your Google Web Toolkit SDK directory.

  
- Apache Ant, 1.6.5 or later (1.7.1 or later recommended)
  http://ant.apache.org/
  
  Ensure ANT_HOME to the location of your Apache Ant directory, and the
  'ant' command is in your PATH.

  
Build and Deployment Instructions
---------------------------------
- 'ant'
  Compile Showcase for deployment.

  
- 'ant war'
  Compile Showcase for deployment and bundle into showcase.war file.

  If you have a web container operating on localhost:8080, you can deploy
  showcase.war into the web container and access the Showcase at:
  http://localhost:8080/showcase/index.html


- 'ant hosted' (Deprecated)
  Run Showcase in GWT Hosted Mode.  

  Consider using the currently supported Super Development Mode instead:
  https://www.smartclient.com/smartgwt/javadoc/com/smartgwt/client/docs/SuperDevModeTroubleshooting.html
