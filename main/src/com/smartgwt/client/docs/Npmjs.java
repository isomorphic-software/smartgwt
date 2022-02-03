
package com.smartgwt.client.docs;

/**
 * <h3>NPMJS Support</h3>
 * Smart GWT client-side resources - the JavaScript runtime, skins, and schema - can be
 * installed and updated via <a href='https://www.npmjs.com' target='_blank'>npmjs</a>.  Select
 * the 
 *  appropriate package based on your licensing:<ul>
 * <li> <a href='https://www.npmjs.com/package/smartclient-lgpl'
 * target='_blank'>smartclient-lgpl</a>
 * <li> <a href='https://www.npmjs.com/package/smartclient-eval'
 * target='_blank'>smartclient-eval</a>
 * <li> <a href='https://www.npmjs.com/package/smartclient-pro'
 * target='_blank'>smartclient-pro</a>
 * <li> <a href='https://www.npmjs.com/package/smartclient-power'
 * target='_blank'>smartclient-power</a>
 * <li> <a href='https://www.npmjs.com/package/smartclient-enterprise'
 * target='_blank'>smartclient-enterprise</a>
 *  </ul>
 *  <b>Note:</b> the Smart GWT npm module requires an environment, such as
 * <a href='https://en.wikipedia.org/wiki/React_(JavaScript_library)' target='_blank'>React</a> or
 * <a href='https://en.wikipedia.org/wiki/Angular_(web_framework)' target='_blank'>Angular</a>,
 * that defines
 *  "window" as a global with real browser document and navigator objects.
 *  <h2>Installation</h2>
 *  <b style="color:red">When installing a module in npm v7, console output is suppressed, and
 *  interactive output is not allowed. So by default, we now install without prompting wherever
 *  a default response is available. Please be patient as it may take a minute or more,
 *  depending on your connection and hardware, to finish, with no console updates to indicate
 *  progress.</b><p>
 *  To install one of these packages, use:
 *  <pre>
 *    npm install &lt;package name&gt; [flags]</pre>
 *  where the flags are as follows:<p>
 *  <table border=1 class="normal">
 *  <tr bgcolor="#D0D0D0"><td>Option Name</td><td>Argument Value</td><td>Description</td></tr>
 *  <tr>
 *  <td><code>location</code></td><td>path</td>
 *  <td>A path (absolute or relative to the dependent module) specifying where to install
 *  the Smart GWT runtime(s).  Default is to place the runtime root directory
 *  (<code>isomorphic</code>) in the dependent module directory.</td>
 *  </tr><tr>
 *  <td><code>branch</code></td><td>number</td>
 *  <td>Desired branch (e.g. 11.1).  Default is the latest release.</td>
 *  </tr><tr>
 *  <td><code>date</code></td><td>date in format YYYY-MM-DD | <code>latest</code>
 *  </td><td>Desired date.  Default is to use the latest build available.</td>
 *  </tr><tr>
 *  <td><code>runtime</code></td><td><code>release</code> | <code>debug</code> |
 *  <code>both</code></td><td>Desired runtime(s) to install.  Default is to install them both.
 *  </td></tr><tr>
 *  <td><code>reference</code></td><td><code>true</code> | <code>false</code></td>
 *  <td>Whether to keep the framework reference directory.  Default is to not install it to save
 *  disk space.</td>
 *  </tr><tr>
 *  <td><code>skins</code></td><td><code>Tahoe</code> | <code>all</code> | <code>none</code></td>
 *  <td>Which skins (if any) to install.  Default is to only install Tahoe.</td>
 *  </tr><tr>
 *  <td><code>username</code></td><td>string</td>
 * <td>The username for your <a href='https://www.smartclient.com' target='_blank'>Smart GWT
 * account</a>.
 * Required for the <a href='https://www.npmjs.com/package/smartclient-pro'
 * target='_blank'>Pro</a>,
 *  <a href='https://www.npmjs.com/package/smartclient-power' target='_blank'>Power</a>, and
 * <a href='https://www.npmjs.com/package/smartclient-enterprise' target='_blank'>Enterprise</a>
 * packages,
 *  and available subject to your licensing.</td>
 *  </tr><tr>
 *  <td><code>password</code></td><td>string</td>
 * <td>The password for your <a href='https://www.smartclient.com' target='_blank'>Smart GWT
 * account</a>.
 * Required for the <a href='https://www.npmjs.com/package/smartclient-pro'
 * target='_blank'>Pro</a>,
 *  <a href='https://www.npmjs.com/package/smartclient-power' target='_blank'>Power</a>, and
 * <a href='https://www.npmjs.com/package/smartclient-enterprise' target='_blank'>Enterprise</a>
 * packages,
 *  and available subject to your licensing.</td>
 *  </tr><tr>
 *  <td><code>analytics</code></td><td><code>true</code> | <code>false</code></td>
 * <td>Whether to install the optional {@link com.smartgwt.client.docs.LoadingOptionalModules
 * Analytics Module}.
 * Only available for the <a href='https://www.npmjs.com/package/smartclient-power'
 * target='_blank'>Power</a>,
 * and <a href='https://www.npmjs.com/package/smartclient-enterprise'
 * target='_blank'>Enterprise</a> packages,
 *  subject to your licensing.</td>
 *  </tr><tr>
 *  <td><code>rtm</code></td><td><code>true</code> | <code>false</code></td>
 *  <td>Whether to install the optional 
 * {@link com.smartgwt.client.docs.LoadingOptionalModules RealtimeMessaging Module}.  Only
 * available for the
 * for the <a href='https://www.npmjs.com/package/smartclient-power' target='_blank'>Power</a>,
 * and
 * <a href='https://www.npmjs.com/package/smartclient-enterprise' target='_blank'>Enterprise</a>
 * packages,
 *  subject to your licensing.</td>
 *  </tr><tr>
 *  <td><code>prompt</code></td><td><code>true</code> | <code>false</code></td> <td>Wait for
 *  input instead of assuming the default response to all queries during install; default is to
 *  not prompt to support newer npm releases.</td>
 *  </tr></table><p>
 *  After installation, command-line configuration is persisted, so command-line arguments only
 *  need to be supplied when updating if the desired configuration has changed. If a username and
 *  password aren't supplied via the above options, you will be prompted to enter them by the
 *  update script. A password typed in response to the script won't be persisted to your
 *  configuration, so you may choose to always enter it interactively for security.
 *  <h2>Updating</h2>
 *  Since 'npm update' no longer runs a package's update script if the version hasn't changed,
 *  and smartclient npm packages are versioned separately from nightly SDK builds, you must go
 *  to the smartclient npm module directory, and run using the syntax
 *  <pre>
 *    npm run update [flags]</pre>
 *  to update your installation to the latest runtimes.  The supported flags are the same as
 *  during installation.
 *  <P>
 *  <h2>Using npm v7</h2>
 *  <P>
 *  The install script for a module is no longer allowed to write output in npm v7, which means
 *  that we can no longer interactively query for decisions or show zip download progress. So,
 *  to still have a complete install process, the module now proceeds automatically, without
 *  waiting, wherever a default response is available for what was formerly an interactive
 *  query. Please be patient as the zip download and installation of framework, skins, and other
 *  assets may take more than a minute, during which no additional output indicating progress
 *  will be printed.
 *  <P>
 *  You have a few alternatives to this default behavior:<ul>
 *  <li>You can pass "--prompt" to "npm install ...". Due to npm v7 rules, installing the module
 *  this way will skip the download and installation of the Smart GWT framework and skins, and
 *  the isc-config.json configuration file won't be created. So afterwards, to install the
 *  missing assets you should navigate down to the module directory (under node_modules) and
 *  manually execute "npm run update [flags]", passing your install flags.
 *  <li>In addition to "--prompt", you can also pass "--foreground-scripts" as a flag to the
 *  install command to allow output as in npm v6, but in npm v7 this seems to trigger other
 *  timing logs that obfuscate what we print. Hopefully, support for the "--foreground-scripts"
 *  flag will improve in future npm releases.</ul>
 *  Note that since there are no default responses for the "username" and "password" flags, if
 *  they are required, installation of assets will be skipped (as in the first bullet above)
 *  unless you provide bindings on the command line initially for "npm install ...".
 *  <P>
 *  "Uninstall" is no longer a lifecycle event in npm v7, so a module's uninstall script
 *  declared in package.json no longer gets called during uninstallation. The recommended
 *  workaround is to run "npm run uninstall" from the module directory (under node_modules)
 *  before uninstalling.
 *  <P>
 *  <h2>Examples</h2>
 *  New install of Smart GWT Evaluation, selecting a specific branch and date:
 *  <pre>
 *    npm install smartclient-eval --branch=11.1 --date=2018-12-30</pre>
 *  Update to latest nighlty build (run from package directory):
 *  <pre>
 *    npm run update --date=latest</pre>
 *  Update to Smart GWT 12.1 branch, installing all skins:
 *  <pre>
 *    npm run update --branch=12.1 --skins=all</pre>
 *  <h2>Importing</h2>
 *  If you are building a new Angular, React or similar application, and plan to use Smart GWT
 *  pervasively throughout, you can just add an import declaration to your <code>main.ts</code>
 *  or <code>App.tsx</code> to make the framework available.  However, if you are adding
 *  Smart GWT to an existing application, and you only plan to use Smart GWT for specific
 * components like grids, or for {@link com.smartgwt.client.docs.ReifyForDevelopers Reify
 * screens}, consider using
 * {@link com.smartgwt.client.docs.BackgroundDownload background download} instead of importing
 * Smart GWT
 *  directly (importing causes Smart GWT to load immediately on all pages).
 *  <p>
 *  To directly import the release or debug framework, respectively, in your application, you can
 *  write:
 *  <pre>
 *    import 'smartclient-eval/debug';</pre>
 *  or
 *  <pre>
 *    import 'smartclient-eval/release';</pre>
 *  To import a skin as well, such as "Tahoe", you can add:
 *  <pre>
 *    import 'smartclient-eval/skins/Tahoe';</pre>
 *  To import one of the optional modules, you'd write something like:
 *  <pre>
 *    import 'smartclient-eval/debug/rtm';</pre>
 *  or
 *  <pre>
 *    import 'smartclient-eval/release/analytics';</pre>
 *  respectively, to import the debug version of the Realtime Messaging module or the release
 *  version of the Analytics module.
 *  <p>
 *  <b>Caution:</b> you can't mix debug and release imports in a single app.
 *  <h3>Importing skins in Angular</h3>
 *  In Angular,  if you directly import the skin, you may need to manually add the path to the
 *  <code>skin_styles.css</code> file for your skin to the <code>src/styles.css</code> file (or
 *  equivalent) for your app, in addition to importing the
 *  skin as described above.
 *  <p>
 *  For example, if you've installed the Smart GWT runtime in the default location, and are
 *  importing Tahoe, you'd add the following to <code>src/style.css</code> in your app:
 *  <pre>
 *    &commat;import '../isomorphic/skins/Tahoe/skin_styles.css';</pre>
 *  <b>Note:</b> if you are using the FileLoader to load a skin, it must be installed
 *  under <code>src/assets</code> (for example copied from <code>isomorphic/skins</code>) to
 *  work properly.
 *  <h3>Using Smart GWT APIs</h3>
 *  If you want to refer to Smart GWT APIs through your own constant, you can always issue a
 *  declaration such as:
 *  <pre>
 *    const ISC: typeof isc = window['isc'];</pre>
 *  after importing this package.
 *  <h2>TypeScript</h2>
 *  To provide typescript support, the installation process should automatically augment your
 *  <code>tsconfig.json</code> file with an include directive targeting Smart GWT's typescript
 *  file.
 *  <P>
 *  Alternatively, you can copy the typescript declaration file, <code>smartclient.d.ts</code>,
 *  from the installed resources under the <code>isomorphic</code> directory to your app's
 *  source directory, and then import it from your app like:
 * 
 *  <pre>
 *    import 'smartclient.d.ts';</pre>
 *  Smart GWT's TypeScript support is intended for IDE auto-completion and inline
 *  documentation, not for transpilation.  So, if you run into compile errors, you can always
 *  remove any reference to our TypeScript file from your own TS file and application, remove
 *  <code>smartclient.d.ts</code> from under <code>src/assets</code> (if present), and instead
 *  make TypeScript active for your IDE only.  For further details, see the TypeScript support
 *  documentation for {@link typeScriptSupport our framework} or your IDE.
     * @see com.smartgwt.client.docs.IscInstall
 */
public interface Npmjs {
}
