	    
package com.smartgwt.client.docs;

/**
 * <h3>Integration with Titanium</h3>
 * Titanium provides an extensive Javascript API to access a native device's UI, phone, camera,
 * geolocation, etc. Documentation, getting started, programming guides are <a
 * href='http://developer.appcelerator.com/documentation'
 * onclick="window.open('http://developer.appcelerator.com/documentation');return
 * false;">here</a>. Titanium provides a consistent API across devices including the ability to
 * mix webviews with native controls. <P> The Titanium sample application provides an example of
 * accessing a device's Contacts db using Smart GWT.  The application presents 2 tabs 'Customers'
 * and 'Contacts' and allows the user to import Customer contacts into  his/her contacts db
 * resident on the device. Selecting a Customer's Contact address will show a map of the contact.
 * Selecting a Customer's phone number will call the customer or prompt to import the contact into
 * the user's  contacts. The latter option is default behavior on the iPad. Calling the customer
 * contact is default behavior for  devices such as the iPhone or Android.  <P> The Titanium
 * Contact object holds the following properties: <ul> <li>URL</li> <li>address</li>
 * <li>birthday</li> <li>created</li> <li>date</li> <li>department</li> <li>email</li>
 * <li>firstName</li> <li>firstPhonetic</li> <li>fullName</li> <li>image</li>
 * <li>instantMessage</li> <li>jobTitle</li> <li>kind</li> <li>lastName</li> <li>lastPhonetic</li>
 * <li>middleName</li> <li>middlePhonetic</li> <li>modified</li> <li>nickname</li> <li>note</li>
 * <li>organization</li> <li>phone</li> <li>prefix</li> <li>relatedNames</li> <li>suffix</li>
 * </ul> <P> The following Titanium API's are used: <ul> <li>Titanium.App.addEventListener</li>
 * <li>Titanium.App.fireEvent</li> <li>Titanium.Contacts.getAllPeople</li>
 * <li>Titanium.Geolocation.forwardGeocoder</li> <li>Titanium.Map.STANDARD_TYPE,</li>
 * <li>Titanium.Map.createView</li> <li>Titanium.UI.createTab</li>
 * <li>Titanium.UI.createTabGroup</li> <li>Titanium.UI.createWebView</li>
 * <li>Titanium.UI.createWindow</li> <li>Titanium.UI.setBackgroundColor</li> </ul> <P> The
 * following Smart GWT Components are used <ul> <li>isc.DataSource</li> <li>isc.ListGrid</li> 
 * </ul> <P> The following Smart GWT Resources are bundled in the Titanium application <ul>
 * <li>ISC_Containers.js</li> <li>ISC_Core.js</li> <li>ISC_DataBinding.js</li>
 * <li>ISC_Foundation.js</li> <li>ISC_Grids.js</li> <li>load_skin.js</li>
 * <li>skins/Mobile/images/black.gif</li> <li>skins/Mobile/images/blank.gif</li>
 * <li>skins/Mobile/images/checked.png</li> <li>skins/Mobile/images/formula_menuItem.png</li>
 * <li>skins/Mobile/images/grid.gif</li> <li>skins/Mobile/images/group_closed.gif</li>
 * <li>skins/Mobile/images/group_opened.gif</li>
 * <li>skins/Mobile/images/headerMenuButton_icon.gif</li> <li>skins/Mobile/images/loading.gif</li>
 * <li>skins/Mobile/images/loadingSmall.gif</li> <li>skins/Mobile/images/opacity.png</li>
 * <li>skins/Mobile/images/pinstripes.png</li> <li>skins/Mobile/images/row_collapsed.gif</li>
 * <li>skins/Mobile/images/row_expanded.gif</li> <li>skins/Mobile/images/sort_ascending.gif</li>
 * <li>skins/Mobile/images/sort_descending.gif</li> <li>skins/Mobile/skin_styles.css</li> </ul>
 */
public interface TitaniumIntegration {
}
