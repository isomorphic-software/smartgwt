package com.smartgwt.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.form.fields.FormItem;

/**
 * Handles the upload, validation, review and saving of a dataset expressed in CSV or other upload formats.
 * 
 * <p><em><b>Requires Smart GWT Enterprise, Power or Eval.</b></em>
 * 
 * <p>By default, a <code>BatchUploader</code> consists of a single {@link com.smartgwt.client.widgets.form.fields.FileItem}
 * form field. This form field will upload a file using the special "batchUpload" built-in DataSource.
 * The uploaded file data will be parsed and validated using the {@link #getUploadDataSource() uploadDataSource},
 * then streamed back to the browser, along with any errors, for display in a {@link com.smartgwt.client.widgets.grid.ListGrid}.
 * 
 * <p>The user can then correct any errors and submit the final dataset, which will be added to
 * the DataSource via a series of "add" {@link com.smartgwt.client.data.DSRequest}s, all submitted
 * as a single HTTP request via request queuing.
 * 
 * <p>Additional form fields can be added to the form that uploads the data file via {@link #setUploadFormItems(FormItem...) uploadFormItems}.
 * Values entered into these fields are not included in the "add" DSRequests used to store the
 * uploaded records. Instead, they are stored as HttpSession attributes with the names corresponding
 * to the names of the specified uploadFormItems (optionally with a prefix applied, in case this
 * is necessary to avoid name collisions in the session). This allows any custom logic for the
 * "add" operation to access these additional fields via httpSession.getAttribute().
 * 
 * <p>Because all records are saved in a single HTTP request, a similar strategy of storing data
 * as servletRequest or session attributes allows reuse of objects required to perform the "add"
 * operations (such as field values common to all added records, or a SQL connection or transaction manager).
 * 
 * <p>If uploadFieldName is set on any of the uploadDataSource's fields, the <code>BatchUploader</code>
 * will use that name to map the uploaded file's content.
 * 
 * <p>A couple of server-side techniques are interesting in conjunction with the <code>BatchUploader</code>.
 * One is to set the DataSource.serverConstructor property to point at your own class that inherits
 * from <code>com.isomorphic.datasource.DataSource</code>. The most interesting reason for doing
 * this is to override the validate method and provide complete custom validation - for example,
 * checking relations to other tables.
 * 
 * <p>Another technique is to handle the initial SmartClient call in your own servlet, by setting
 * the {@link #getDataURL() dataURL} property. You then handle the add requests with a combination
 * of your own code and SmartClient server API calls. This is a good way to add special pre- and
 * post-processing to the normal server-side flow.
 * 
 * <p>The BatchUploader sample, provided as one of the databinding examples, demonstrates both
 * of these techniques. We use a special subclass of DataSource and override the validate method
 * as described above; we also set dataURL to point at a JSP that wraps the queue of SmartClient
 * requests inside a single database transaction (a servlet would be more usual, but we use a
 * JSP for ease of modification)
 * 
 * <p><b>Note:</b> The special "batchUpload" DataSource, which should reside in the <code>shared/ds</code>
 * folder of your application's webroot (see Deploying SmartClient), is not part of your application's
 * data flow, and it has nothing to do with the uploadDataSource you use to actually persist
 * the validated and error-corrected data; it is simply the means for uploading the raw data
 * in the first place. Normally, you should simply ignore its presence and treat it as an internal
 * detail of the SmartClient framework.
 * 
 * <p>However, there are circumstances in which you may wish to change it to achieve specific aims.
 * For example, you may wish to override the Java class it invokes, in order to insert your own
 * security or other validation logic into the initial upload flow. This is entirely in keeping
 * with the design, but we regard it as an out-of-the-ordinary use-case; normal usage is simply
 * to ignore the presence of the batchUpload DataSource.
 */
public class BatchUploader extends Canvas {

    public static BatchUploader getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if (obj != null) {
            return (BatchUploader) obj;
        } else {
            // Instantiate `BatchUploader' in the com.smartgwtee package to prevent possible
            // `ClassCastException's until officially removed.
            return new com.smartgwtee.client.widgets.BatchUploader(jsObj);
        }
    }


    public BatchUploader() {
        setDsURL("/ds/batchUpload.ds.xml");
    }

    public BatchUploader(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public native JavaScriptObject create() /*-{
        if (!$wnd.isc.BatchUploader) {
            var errorMessage = "Attempt to create BatchUploader. This class requires Smart GWT Enterprise or Eval.";
            @com.smartgwt.client.util.SC::logWarn(Ljava/lang/String;)(errorMessage);
            throw @java.lang.UnsupportedOperationException::new(Ljava/lang/String;)(errorMessage);
        }
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.BatchUploader.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Ljava/lang/String;)(widget.getID());
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    public void setUploadFormItems(FormItem... items) {
        setAttribute("uploadFormFields", items, false);
    }

    public void setUploadDataSource(DataSource dataSource) {
        setAttribute("uploadDataSource", dataSource.getOrCreateJsObj(), true);
    }

    public DataSource getUploadDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("uploadDataSource"));
    }

    /**
     * Setting dataURL causes every "add" operation issued by the BatchUploader to use that dataURL.
     *
     * @param dataURL the data URL
     */
    public void setDataURL(String dataURL) {
        setAttribute("dataURL", dataURL, true);
    }

    public String getDataURL() {
        return getAttributeAsString("dataURL");
    }

    /**
     * The location of  batchUpload.ds.xml. Defaults to /ds/batchUpload.ds.xml
     *
     * @param dsURL the batchUploader datasource URL
     */
    public void setDsURL(String dsURL) {
        setAttribute("dsURL", dsURL, true);
    }
}
