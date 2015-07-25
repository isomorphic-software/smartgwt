## Introduction ##
If all you need are nightly build, then please have a look at the [NightlyBuilds\_and\_MavenRepository](NightlyBuilds_and_MavenRepository.md) wiki for details.

## Compiling from Source ##

### Checking Out the Source from Subversion ###

Checking out the SmartGWT source is most useful if you plan to compile SmartGWT yourself. The pre-built SmartGWT distribution already contains all the Java source, so you don't actually need to check it out from the repository just to debug through it. Just tweak your IDE to read source from the SmartGWT jars.

SmartGWT is hosted on [Google Code](http://code.google.com/hosting/) project hosting, so you check out the source for SmartGWT using a Subversion client as you would for any other project hosted on Google Code.  However, daily commits to the trunk and branches subdirectories are only made for certain files, so you generally cannot build from them.  Instead, the suggested approach is to sync from the desired branch's release tag directory, such as:

` svn checkout http://smartgwt.googlecode.com/svn/tags/5.0 releases/5.0 `

The [project source code access page](http://code.google.com/p/smartgwt/source) has additional instructions for browsing the [source online](http://smartgwt.googlecode.com/svn/) or [getting a Subversion client](http://subversion.tigris.org/links.html#clients) if you don't already have one.

Here's a good writeup if you're using Eclipse : http://forums.smartclient.com/showthread.php?t=3206.

### Compiling from Source ###

Everything is Java source that can be built with the included SmartGWT [Ant](http://ant.apache.org/) build files. (Note that SGWT 4.0 and earlier won't compile with JDK 7 or later.)

  * Install [Ant 1.6.5  http://ant.apache.org/bindownload.cgi](Apache.md) or later. We'll assume that the ant command is in your path.

  * Set the GWT\_HOME environment variable to point to your GWT home directory. (supported versions are GWT  1.5.3 and later).

  * Check out the SmartGWT prerequisite tools and third-party libraries, and set the SMARTGWT\_TOOLS environment variable to it:
> > ` ~/smartgwt$ svn checkout http://smartgwt.googlecode.com/svn/tools/ tools `

  * Check out the SmartGWT source for the desired release:
> > ` ~/smartgwt$ svn checkout http://smartgwt.googlecode.com/svn/tags/5.0 releases/5.0 `

  * Switch to the directory into which you checked out the SmartGWT source. Let's assume you checked it out into ~/smartgwt/releases/5.0. Make sure you're in that directory.
> > ` ~/smartgwt$ cd releases/5.0 `
> > then just invoke Ant
> > > ` ant  `

  * To clean invoke

> > ` ant  clean`

  * The SmartGWT build creates a binary distribution in the build/dist subdirectory of the source root directory. In this example, the distributions would be in ~/smartgwt/releases/5.0/build.


### Ant JUnit Issues ###
There is a problem, detailed at ant.apache.org, where ant cannot find the JUnit classes. The simple workaround is to either:
  * Delete ant-junit.jar from the ant lib directory (for example, /usr/share/ant/lib/)
  * Copy junit.jar into your ant lib directory

### Ant XSLT issues ###
If you get an error like the one below, please remove the file {ANT\_HOME}\lib\xercesImpl.jar from your Ant installation as the copy of Xerces distrbuted with certain versions on Ant causes conflicts.

```
[java] FATAL ERROR:  'Could not compile stylesheet'

BUILD FAILED
C:\java\ smartgwt-svn\trunk\build.xml:35: The following error occurred while executing this line:
C:\java\ smartgwt-svn\trunk\build.xml:15: The following error occurred while executing this line:
C:\java\ smartgwt-svn\trunk\doc\build.xml:63: java.lang.RuntimeException: Unable to complete the xslt tranform

```