
package com.smartgwt.client.docs;

/**
 * <h3>NPMJS Support</h3>
 * Smart GWT client-side resources - the JavaScript runtime, skins, and schema - can be
 * installed and updated via <a href='https://www.npmjs.com' target='_blank'>npmjs</a>.  Select
 * the appropriate
 *  package based on your licensing:<ul>
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
 *  To install one these packages, use:
 *  <pre>
 *    npm install &lt;package name&gt; [flags]</pre>
 *  where the flags are as follows:<p>
 *  <table border=1 class="normal">
 *  <tr>
 *  <td><b>location</b></td><td>string</td>
 *  <td>A path specifying where to install the Smart GWT runtime(s).  Default is to place the
 *  runtime root directory (isomorphic) in the parent of the <code>node_modules</code> directory
 *  containing the package.</td>
 *  </tr><tr>
 *  <td><b>branch</b></td><td>number</td>
 *  <td>Desired branch (e.g. 11.1).  Default is the latest release.</td>
 *  </tr><tr>
 *  <td><b>date</b></td><td>string in the format YYYY-MM-DD | 'latest'</td>
 *  <td>Desired date.  Default is 'latest'.</td>
 *  </tr><tr>
 *  <td><b>runtime</b></td><td>'release' | 'debug' | 'both'</td>
 *  <td>Desired runtime(s) to install.  Default is 'both'.</td>
 *  </tr><tr>
 *  <td><b>skins</b></td><td>boolean</td>
 *  <td>Whether to install all skins or not.  Default is to only install Tahoe.</td>
 *  </tr><tr>
 *  <td><b>username</b></td><td>string</td>
 * <td>The username for your <a href='https://www.smartclient.com' target='_blank'>Smart GWT
 * account</a>.
 * Required for the <a href='https://www.npmjs.com/package/smartclient-pro'
 * target='_blank'>Pro</a>,
 *  <a href='https://www.npmjs.com/package/smartclient-power' target='_blank'>Power</a>, and
 * <a href='https://www.npmjs.com/package/smartclient-enterprise' target='_blank'>Enterprise</a>
 * packages,
 *  and available subject to your licensing.</td>
 *  </tr><tr>
 *  <td><b>password</b></td><td>string</td>
 * <td>The password for your <a href='https://www.smartclient.com' target='_blank'>Smart GWT
 * account</a>.
 * Required for the <a href='https://www.npmjs.com/package/smartclient-pro'
 * target='_blank'>Pro</a>,
 *  <a href='https://www.npmjs.com/package/smartclient-power' target='_blank'>Power</a>, and
 * <a href='https://www.npmjs.com/package/smartclient-enterprise' target='_blank'>Enterprise</a>
 * packages,
 *  and available subject to your licensing.</td>
 *  </tr><tr>
 *  <td><b>analytics</b></td><td>boolean</td>
 * <td>Whether to install the optional {@link com.smartgwt.client.docs.LoadingOptionalModules
 * Analytics Module}.
 * Only available for the <a href='https://www.npmjs.com/package/smartclient-power'
 * target='_blank'>Power</a>,
 * and <a href='https://www.npmjs.com/package/smartclient-enterprise'
 * target='_blank'>Enterprise</a> packages,
 *  subject to your licensing.</td>
 *  </tr><tr>
 *  <td><b>rtm</b></td><td>boolean</td>
 *  <td>Whether to install the optional 
 * {@link com.smartgwt.client.docs.LoadingOptionalModules RealtimeMessaging Module}.  Only
 * available for the
 * for the <a href='https://www.npmjs.com/package/smartclient-power' target='_blank'>Power</a>,
 * and
 * <a href='https://www.npmjs.com/package/smartclient-enterprise' target='_blank'>Enterprise</a>
 * packages,
 *  subject to your licensing.</td>
 *  </tr></table><p>
 *  After installation, command-line configuration is persisted, so command-line arguments only
 *  need to be supplied when updating if the desired configuration has changed. If a username and
 *  password aren't supplied via the above options, you will be prompted to enter them by the
 *  update script. A password typed in response to the script won't be persisted to your
 *  configuration, so you may choose to always enter it interactively for security.
 *  <h2>Updating</h2>
 *  Since 'npm update' no longer runs a package's update script, which we need to download and
 *  install the runtime(s) from our website, you must instead run the following from the
 *  directory of your installed Smart GWT package (e.g. smartclient-eval):
 *  <pre>
 *       npm run update [flags]</pre>
 *  The supported flags are the same as during installation.
 *  <P>
 *  <h2>Examples</h2>
 *  New install, selecting a specific branch and date:
 *  <pre>
 *    npm install smartclient-eval --branch=11.1 --date=2018-12-30</pre>
 *  Update to latest nighlty build (run from package directory):
 *  <pre>
 *    npm run update --date=latest</pre>
 *  Update to Smart GWT 12.0 branch, installing all skins:
 *  <pre>
 *    npm run update --branch=12.0 --skins</pre>
     * @see com.smartgwt.client.docs.IscInstall
 */
public interface Npmjs {
}
