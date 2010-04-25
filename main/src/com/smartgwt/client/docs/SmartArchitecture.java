
package com.smartgwt.client.docs;

/**
 * <h3>Smart GWT Architecture</h3>
 * Smart GWT can add interactivity and performance benefits to any web application with a&#010 variety of integration
 * approaches.  This topic discusses the optimal architecture for a&#010 Smart GWT application, which can be adopted in
 * whole or in part.&#010 <p>&#010 In a typical HTML-based web application, every time a new view is shown to a user, a
 * round&#010 trip to the server is required to retrieve new presentation information, such as a search&#010 screen. 
 * However in an ISC-based application, showing a new view can be accomplished by&#010 simply hiding some components and
 * showing others.&#010 <p>&#010 Because ISC components are expressed in a concise declarative form, and because ISC&#010
 * components have essentially no runtime performance impact until used, dozens of application&#010 views can be downloaded
 * to the browser using the same bandwidth that would have been&#010 required to render just the initial view in plain
 * HTML.  &#010 <p> &#010 This architectural pattern of "preloading views" has tremendous benefits.  View transitions&#010
 * which do not require new data from the server can be performed near-instantaneously and&#010 without server involvement,
 * boosting both interactivity and scalability.&#010 <p>&#010 Showing a dialog containing a "wizard" is a straightforward
 * example of showing a "preloaded&#010 view".  For example:&#010 <pre>&#010    function showNewUserWizard() {&#010       
 * Window.create({&#010            items:[&#010                DynamicForm.create({ ... })&#010            ]&#010       
 * });&#010    }&#010    Button.create({&#010        title:"New User..",&#010        click:"showNewUserWizard()"&#010   
 * });&#010 </pre>&#010 In this example, none of the components involved in a potentially multi-pane wizard are &#010
 * created until they are needed.  Showing the wizard has near-instantaneous response and&#010 causes no server load.&#010
 * <p>&#010 However, let's say that the first pane of the wizard is going to incorporate some dynamic&#010 user-specific
 * data, such as the current user's name.  To load the username, we'll use an RPC&#010 operation targetting a .jsp called
 * "getUserName.jsp" and show the wizard when it completes&#010 (see {@link com.smartgwt.client.rpc.RPCManager} for
 * information on RPCs and how to construct a .jsp that can&#010 send an RPC response).&#010 <pre>&#010    function
 * showNewUserWizard() {&#010        RPCManager.sendRequest({&#010            actionURL:"getUserName.jsp",&#010           
 * callback:"doShow(rpcResponse)"&#010        });&#010    }&#010    function doShow(rpcResponse) {&#010       
 * Window.create({&#010            items:[&#010                Canvas.create({contents:"Hello, " +
 * rpcResponse.userName}),&#010                DynamicForm.create({ ... })&#010            ]&#010        });&#010    }&#010
 * Button.create({&#010        title:"New User..",&#010        click:"showNewUserWizard()"&#010    });&#010 </pre>&#010 In
 * this example, we've simply incorporated a user name into the first pane of a wizard.&#010 However, this pattern allows
 * us to arbitrarily change user interactions based on data from&#010 the server.  For example, the RPCResponse might have
 * contained a flag indicating that the&#010 wizard should skip the first two steps, or an arbitrary warning message for
 * the user, or&#010 even JavaScript code to be evaluated on the client.&#010 <P>&#010 This architecture has several key
 * advantages:&#010 <dl>&#010&#010 <dt><b>Performance: Cacheable UI</b></dt>&#010 <dd>&#010 A dynamic, data-driven UI can
 * be expressed completely in <i>cacheable</i> JavaScript.&#010 This is in contrast to any architecture based on
 * server-side HTML generation, where static&#010 parts of the presentation are mixed in with dynamic data, preventing
 * cacheability so that&#010 bandwidth and server time are wasted repeatedly delivering the same static presentation&#010
 * data.&#010 <br>&#010 Even generated JavaScript is cacheable.  For example, a Smart GWT View expressed in XML&#010 and
 * contained within a JSP is still a separately cacheable resource when loaded via a&#010 &lt;SCRIPT SRC&gt; tag and
 * advertised as a cacheable resource via HTTP headers, because it&#010 is ultimately delivered to the browser as simple
 * JavaScript.  Hence standard &#010 {@link com.smartgwt.client.docs.I18n 'internationalization'} techniques such as using
 * JSTL tags in a JSP remain&#010 applicable.&#010 <br>&#010 The Smart GWT Architecture even allows you to capture all the
 * gradations of cacheability&#010 from completely static (changes once per application rollout) to completely dynamic&#010
 * (timestamp).  In the example above, the user name wouldn't actually change for the lifetime&#010 of the page, so could
 * be loaded once only.&#010 <br>&nbsp;</dd>&#010&#010 <dt><b>Performance: Minimal Server State</b></dt>&#010 <dd>&#010 Any
 * architecture that relies on component descriptions being generated by the server&#010 must track a great deal of state,
 * which, in the Smart GWT Architecture, is either&#010 completely eliminated or greatly reduced.&#010
 * <br>&nbsp;</dd>&#010&#010 <dt><b>True Presentation / Business Logic separation</b></dt>&#010 <dd>&#010 The RPCResponse
 * object represents the client's exact, minimal needs for server data.&#010 This is much easier to understand and to audit
 * than a slew of .jsp files which access and&#010 update miscellaneous state.  It is also far easier to spot reusable
 * patterns of data access,&#010 which in server-side HTML generation systems often end up as duplicated code.&#010
 * <br>&nbsp;</dd>&#010&#010 <dt><b>Parallel Development and Testability</b></dt>&#010 <dd>&#010 Using the Smart GWT
 * architecture allows you to build a complete, working application&#010 that can run without a server, based on sample
 * data.  In the example above, it would be &#010 straightforward to create a testing mode that returned a faked RPC
 * response consisting of&#010 simply <code>{ userName : "Bob" }</code>.&#010 <br>&#010 This allows better parallel
 * development by enabling the client side of the system to be&#010 tested in isolation, and creates clearer communication
 * between client and server-side&#010 developers since creation of test data tends to develop into data requirements&#010
 * specifications.&#010 <br>&#010 For more info on creating applications that support client-only testing, see&#010 {@link
 * com.smartgwt.client.docs.ClientOnlyDataSources 'Client Only DataSources'}.&#010 <br>&nbsp;</dd>&#010 </dl>&#010
 * <br>&#010 <h3>Refinements</h3>&#010 <br>&#010 <b>Creating vs Showing a View</b>&#010 <br>&#010 Many views will be shown
 * to the user repeatedly, for example, the user may repeatedly switch&#010 back and forth between two panes of a TabSet. 
 * In that usage it makes sense to make a&#010 distinction between <i>creating</i> a view and <i>showing</i> an existing
 * view.  When&#010 showing an existing view, the same components and/or data may be able to be reused.&#010 <br>&#010 In
 * the following variant on the original example, we only create the Window object and&#010 do the RPC to retrieve the user
 * name the first time <code>showNewUserWizard()</code> is&#010 called.  Subsequently we reuse the existing window, and we
 * assume the user name has not&#010 changed, so we need not do the RPC again. (<i>Note: "New User" button omitted for
 * brevity&#010 from here on</i>)&#010 <pre>&#010    function showNewUserWizard() {&#010        if (!window.myWindow)
 * {&#010            Window.create({&#010                ID:"myWindow",&#010                autoDraw:false,&#010           
 * items:[&#010                    Canvas.create({ ID: "welcomeCanvas" }),&#010                    DynamicForm.create({ ...
 * })&#010                ]&#010            });&#010            RPCManager.sendRequest({&#010               
 * actionURL:"getUserName.jsp",&#010                callback:"doShow(rpcResponse)"&#010            });&#010        } else
 * {&#010            myWindow.show();&#010        }&#010    }&#010    function doShow(rpcResponse) {&#010       
 * welcomeCanvas.setContents("Hello, " + rpcResponse.userName);&#010        myWindow.show();&#010    }&#010 </pre>&#010
 * &#010 <b>Batching Operations</b>&#010 <br>&#010 A view may incorporate multiple components, each of which requires data.
 * In the following&#010 example, a DataBound ListGrid has been incorporated into the wizard, and we'd like to fetch&#010
 * the user's name and the beginning dataset for the grid in the same batch.  We use &#010 {@link
 * com.smartgwt.client.rpc.RPCManager#startQueue RPCManager.startQueue} to do so.&#010 <pre>&#010    function
 * showNewUserWizard() {&#010        if (!window.myWindow) {&#010            Window.create({&#010               
 * ID:"myWindow",&#010                autoDraw:false,&#010                items:[&#010                    Canvas.create({
 * ID: "welcomeCanvas" }),&#010                    <b>ListGrid.create({ &#010                        ID: "myGrid",&#010    
 * dataSource:"myDataSource"&#010                    }),</b>&#010                    DynamicForm.create({ ... })&#010      
 * ]&#010            });&#010            <b>RPCManager.startQueue();&#010            myGrid.fetchData();</b>&#010          
 * RPCManager.sendRequest({&#010                actionURL:"getUserName.jsp",&#010               
 * callback:"doShow(rpcResponse)"&#010            });&#010            <b>RPCManager.sendQueue();</b>&#010        } else
 * {&#010            myWindow.show();&#010        }&#010    }&#010    function doShow(rpcResponse) {&#010       
 * welcomeCanvas.setContents("Hello, " + rpcResponse.userName);&#010        myWindow.show();&#010    }&#010
 * </pre>&#010&#010 <b>Segmenting very large Applications</b>&#010 <P>&#010 If an application has many hundreds of views,
 * but only a handful of views are used by a&#010 given user in a typical session, for the fastest loading performance you
 * should consider&#010 loading only the most commonly used views initially then loading further views on demand.&#010
 * <P>&#010 You can use {@link com.smartgwt.client..FileLoader#loadJSFiles FileLoader.loadJSFiles} to load a set of
 * JavaScript files&#010 compromising an application module that defines a set of related views.  The loaded&#010
 * JavaScript files may define new component classes and new DataSources in addition to&#010 defining new views and their
 * associated logic.
 */
public interface SmartArchitecture {
}
