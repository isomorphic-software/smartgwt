package com.mycompany.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.mycompany.client.util.Console;
import com.smartgwt.client.cordova.contacts.Contact;
import com.smartgwt.client.cordova.contacts.ContactAddress;
import com.smartgwt.client.cordova.contacts.ContactError;
import com.smartgwt.client.cordova.contacts.ContactErrorFunction;
import com.smartgwt.client.cordova.contacts.ContactField;
import com.smartgwt.client.cordova.contacts.ContactFindOptions;
import com.smartgwt.client.cordova.contacts.ContactName;
import com.smartgwt.client.cordova.contacts.ContactSuccessFunction;
import com.smartgwt.client.cordova.contacts.Contacts;
import com.smartgwt.client.cordova.contacts.FindContactsSuccessFunction;
import com.smartgwt.client.cordova.contacts.SaveContactSuccessFunction;
import com.smartgwt.client.cordova.types.ContactFilterProperty;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.ChangeEvent;
import com.smartgwt.client.widgets.grid.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.NavigationBar;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.events.NavigationClickEvent;
import com.smartgwt.client.widgets.layout.events.NavigationClickHandler;

public class MyContacts extends CordovaEntryPoint {

    //private static final int DIALOG_WIDTH = Math.min(360, (int)Math.round(0.65 * Window.getClientWidth()));

    public static final DataSourceField CUSTOMER_NAME_FIELD = new DataSourceField("name", FieldType.TEXT);
    static {
        CUSTOMER_NAME_FIELD.setCanEdit(false);
        CUSTOMER_NAME_FIELD.setTitle("Name");
    }
    private static final DataSourceField[] CUSTOMERS_DS_FIELDS = new DataSourceField[] {
        CUSTOMER_NAME_FIELD
    };

    public static final DataSourceField CUSTOMER_CONTACT_CONTACT_ID_FIELD = new DataSourceField("contactID", FieldType.TEXT),
            CUSTOMER_CONTACT_FULL_NAME_FIELD = new DataSourceField("fullName", FieldType.TEXT),
            CUSTOMER_CONTACT_GIVEN_NAME_FIELD = new DataSourceField("givenName", FieldType.TEXT),
            CUSTOMER_CONTACT_FAMILY_NAME_FIELD = new DataSourceField("familyName", FieldType.TEXT),
            CUSTOMER_CONTACT_PHONE_FIELD = new DataSourceField("phone", FieldType.TEXT),
            CUSTOMER_CONTACT_STREET_ADDRESS_FIELD = new DataSourceField("streetAddress", FieldType.TEXT),
            CUSTOMER_CONTACT_LOCALITY_FIELD = new DataSourceField("locality", FieldType.TEXT),
            CUSTOMER_CONTACT_REGION_FIELD = new DataSourceField("region", FieldType.TEXT),
            CUSTOMER_CONTACT_POSTAL_CODE_FIELD = new DataSourceField("postalCode", FieldType.TEXT),
            CUSTOMER_CONTACT_COUNTRY_FIELD = new DataSourceField("country", FieldType.TEXT),
            CUSTOMER_CONTACT_CONTACT_FIELD = new DataSourceField("contact", FieldType.BOOLEAN);
    static {
        CUSTOMER_CONTACT_FULL_NAME_FIELD.setPrimaryKey(true);
        CUSTOMER_CONTACT_CONTACT_FIELD.setHidden(true);
    }
    private static final DataSourceField[] CUSTOMER_CONTACTS_DS_FIELDS = new DataSourceField[] {
        CUSTOMER_CONTACT_CONTACT_ID_FIELD,
        CUSTOMER_CONTACT_FULL_NAME_FIELD,
        CUSTOMER_CONTACT_GIVEN_NAME_FIELD,
        CUSTOMER_CONTACT_FAMILY_NAME_FIELD,
        CUSTOMER_CONTACT_PHONE_FIELD,
        CUSTOMER_CONTACT_STREET_ADDRESS_FIELD,
        CUSTOMER_CONTACT_LOCALITY_FIELD,
        CUSTOMER_CONTACT_REGION_FIELD,
        CUSTOMER_CONTACT_POSTAL_CODE_FIELD,
        CUSTOMER_CONTACT_COUNTRY_FIELD,
        CUSTOMER_CONTACT_CONTACT_FIELD
    };

    private static Record createCustomerRecord(String name) {
        final Record record = new Record();
        record.setAttribute(CUSTOMER_NAME_FIELD.getName(), name);
        return record;
    }

    private MyContactsImpl impl = GWT.create(MyContactsImpl.class);

    private DataSource customersDS;
    private DataSource customerContactsDS;

    private Map<String, String> names;

    private Layout customersContainer;
    private Layout contactsApp;
    private Layout customerContactsContainer;

    public MyContacts() {
        final Record[] customerData = new Record[] {
            createCustomerRecord("Acme Inc"),
            createCustomerRecord("ABC Co")
        };

        customersDS = new DataSource();
        customersDS.setClientOnly(true);
        customersDS.setCacheData(customerData);
        customersDS.setFields(CUSTOMERS_DS_FIELDS);

        customerContactsDS = new DataSource();
        customerContactsDS.setClientOnly(true);
        customerContactsDS.setFields(CUSTOMER_CONTACTS_DS_FIELDS);

        names = new HashMap<String, String>();
    }

    @Override
    protected void onDeviceReady() {
        final ContactFindOptions options = ContactFindOptions.create();
        options.setFilter("");
        options.setMultiple(true);
        final ContactFilterProperty[] fields = new ContactFilterProperty[] { ContactFilterProperty.DISPLAY_NAME };
        Contacts.find(fields, new FindContactsSuccessFunction() {

            @Override
            public void execute(JsArray<Contact> contacts) {
                Console.log("contacts.length = " + contacts.length());
                for (int i = 0; i < contacts.length(); ++i) {
                    final Contact contact = contacts.get(i);
                    Console.log("'" + contact.getDisplayName() + "' => " + contact.getID());
                    names.put(contact.getDisplayName(), contact.getID());
                }
                showCustomers();
            }
        }, new ContactErrorFunction() {

            @Override
            public void execute(ContactError error) {
                SC.say("Failed to access your contacts.");
            }
        }, options);
    }

    private void showCustomers() {
        final NavigationBar customersNavBar = new NavigationBar();
        customersNavBar.setTitle("Customers");
        customersNavBar.setLeftButtonTitle("Back");

        customersNavBar.setShowLeftButton(false);
        customersNavBar.setShowRightButton(false);

        final ListGrid customers = new ListGrid();
        customers.setHeight("*");
        customers.setAutoFetchData(true);
        customers.setDataSource(customersDS);
        customers.setAlternateRecordStyles(false);
        customers.setSelectionType(SelectionStyle.SINGLE);
        customers.setShowAllRecords(true);
        customers.setLeaveScrollbarGap(false);
        customers.setFields(new ListGridField(CUSTOMER_NAME_FIELD.getName(), "Name"));

        customersContainer = new VLayout();
        customersContainer.setWidth100();
        customersContainer.setHeight100();
        customersContainer.setMembers(customersNavBar, customers);

        contactsApp = new VLayout();
        contactsApp.setWidth100();
        contactsApp.setHeight100();
        contactsApp.setBackgroundColor("white");
        contactsApp.setMembers(customersContainer);

        customers.addCellClickHandler(new CellClickHandler() {

            @Override
            public void onCellClick(CellClickEvent event) {
                final ListGridRecord record = event.getRecord();

                final RecordList contacts = new RecordList();
                if ("Acme Inc".equals(record.getAttribute(CUSTOMER_NAME_FIELD.getName()))) {
                    final Record contact = new Record();
                    contact.setAttribute(CUSTOMER_CONTACT_CONTACT_FIELD.getName(), Boolean.FALSE);
                    contact.setAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName(), "Bill Adams");
                    contact.setAttribute(CUSTOMER_CONTACT_GIVEN_NAME_FIELD.getName(), "Bill");
                    contact.setAttribute(CUSTOMER_CONTACT_FAMILY_NAME_FIELD.getName(), "Adams");
                    contact.setAttribute(CUSTOMER_CONTACT_PHONE_FIELD.getName(), "408-344-5609");
                    contact.setAttribute(CUSTOMER_CONTACT_STREET_ADDRESS_FIELD.getName(), "1192 Hedding St.");
                    contact.setAttribute(CUSTOMER_CONTACT_LOCALITY_FIELD.getName(), "San Jose");
                    contact.setAttribute(CUSTOMER_CONTACT_REGION_FIELD.getName(), "CA");
                    contact.setAttribute(CUSTOMER_CONTACT_POSTAL_CODE_FIELD.getName(), "95112");
                    contact.setAttribute(CUSTOMER_CONTACT_COUNTRY_FIELD.getName(), "U.S.A.");
                    final String contactID = names.get(contact.getAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()));
                    if (contactID != null) {
                        contact.setAttribute(CUSTOMER_CONTACT_CONTACT_ID_FIELD.getName(), contactID);
                        contact.setAttribute(CUSTOMER_CONTACT_CONTACT_FIELD.getName(), Boolean.TRUE);
                    }
                    contacts.add(contact);
                } else if ("ABC Co".equals(record.getAttribute(CUSTOMER_NAME_FIELD.getName()))) {
                    final Record contact = new Record();
                    contact.setAttribute(CUSTOMER_CONTACT_CONTACT_FIELD.getName(), Boolean.FALSE);
                    contact.setAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName(), "Abe Larson");
                    contact.setAttribute(CUSTOMER_CONTACT_GIVEN_NAME_FIELD.getName(), "Abe");
                    contact.setAttribute(CUSTOMER_CONTACT_FAMILY_NAME_FIELD.getName(), "Larson");
                    contact.setAttribute(CUSTOMER_CONTACT_PHONE_FIELD.getName(), "408-901-8887");
                    contact.setAttribute(CUSTOMER_CONTACT_STREET_ADDRESS_FIELD.getName(), "201 San Antonio St.");
                    contact.setAttribute(CUSTOMER_CONTACT_LOCALITY_FIELD.getName(), "San Jose");
                    contact.setAttribute(CUSTOMER_CONTACT_REGION_FIELD.getName(), "CA");
                    contact.setAttribute(CUSTOMER_CONTACT_POSTAL_CODE_FIELD.getName(), "95112");
                    contact.setAttribute(CUSTOMER_CONTACT_COUNTRY_FIELD.getName(), "U.S.A.");
                    final String contactID = names.get(contact.getAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()));
                    if (contactID != null) {
                        contact.setAttribute(CUSTOMER_CONTACT_CONTACT_ID_FIELD.getName(), contactID);
                        contact.setAttribute(CUSTOMER_CONTACT_CONTACT_FIELD.getName(), Boolean.TRUE);
                    }
                    contacts.add(contact);
                }

                slideTransition(customersContainer, showCustomerContacts(contacts), contactsApp, false);
            }
        });

        RootLayoutPanel.get().add(contactsApp);
    }

    private Layout showCustomerContacts(RecordList contacts) {
        customerContactsDS.setCacheData(contacts.toArray());

        final NavigationBar customerContactsNavBar = new NavigationBar();
        customerContactsNavBar.setAutoDraw(false);
        customerContactsNavBar.setTitle("Customer Contacts");
        customerContactsNavBar.setLeftButtonTitle("Back");

        customerContactsNavBar.setShowLeftButton(true);
        customerContactsNavBar.setShowRightButton(false);

        final ListGrid customerContacts = new ListGrid();
        customerContacts.setHeight("*");
        customerContacts.setAutoFetchData(true);
        customerContacts.setDataSource(customerContactsDS);
        customerContacts.setAlternateRecordStyles(false);
        customerContacts.setSelectionType(SelectionStyle.SINGLE);
        customerContacts.setCanEdit(true);
        customerContacts.setEditEvent(ListGridEditEvent.CLICK);
        customerContacts.setModalEditing(true);
        customerContacts.setLeaveScrollbarGap(false);
        final ListGridField fullNameField = new ListGridField(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName(), "Name");
        fullNameField.setCanEdit(false);
        fullNameField.setWidth("25%");
        final ListGridField phoneField = new ListGridField(CUSTOMER_CONTACT_PHONE_FIELD.getName(), "Phone&nbsp;#");
        phoneField.setCanEdit(false);
        phoneField.setWidth("25%");
        final ListGridField formattedAddressField = new ListGridField("formattedAddress", "Address");
        formattedAddressField.setCanEdit(false);
        formattedAddressField.setWidth("40%");
        formattedAddressField.setCellFormatter(new CellFormatter() {

            @Override
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                return record.getAttribute(CUSTOMER_CONTACT_STREET_ADDRESS_FIELD.getName()) + "<br>" +
                        record.getAttribute(CUSTOMER_CONTACT_LOCALITY_FIELD.getName()) + ", " + record.getAttribute(CUSTOMER_CONTACT_REGION_FIELD.getName()) + " " + record.getAttribute(CUSTOMER_CONTACT_POSTAL_CODE_FIELD.getName()) + "<br>" +
                        record.getAttribute(CUSTOMER_CONTACT_COUNTRY_FIELD.getName());
            }
        });
        final ListGridField contactField = new ListGridField(CUSTOMER_CONTACT_CONTACT_FIELD.getName(), "Contact");
        contactField.setCanToggle(true);
        customerContacts.setFields(fullNameField, phoneField, formattedAddressField, contactField);

        customerContactsContainer = new VLayout();
        customerContactsContainer.setWidth100();
        customerContactsContainer.setHeight100();
        customerContactsContainer.setBackgroundColor("white");
        customerContactsContainer.setMembers(customerContactsNavBar, customerContacts);

        customerContactsNavBar.setNavigationClickHandler(new NavigationClickHandler() {

            @Override
            public void onNavigationClick(NavigationClickEvent event) {
                if ("back".equals(event.getDirection())) {
                    slideTransition(customerContactsContainer, customersContainer, contactsApp, true);
                }
            }
        });

        contactField.addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                final boolean value = ((Boolean)event.getValue()).booleanValue();

                final ListGridRecord contactRecord = customerContacts.getSelectedRecord();
                if (value) {
                    slideTransition(customerContactsContainer, createContact(contactRecord), contactsApp, false);
                } else {
                    // If for some reason the record does not have a 'contactID' value, then
                    // allow the change to proceed.
                    final String contactID = contactRecord.getAttribute(CUSTOMER_CONTACT_CONTACT_ID_FIELD.getName());
                    if (contactID == null || contactID.isEmpty()) return;

                    SC.ask("Remove Contact?", "Are you sure you want to remove " + contactRecord.getAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()) + " from your contacts?", new BooleanCallback() {

                        @Override
                        public void execute(Boolean value) {
                            if (value != null && value.booleanValue()) {
                                final Contact contact = Contact.create(contactID);
                                contact.remove(new ContactSuccessFunction() {

                                    @Override
                                    public void execute() {
                                        names.remove(contactRecord.getAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()));
                                        contactRecord.setAttribute(CUSTOMER_CONTACT_CONTACT_ID_FIELD.getName(), (String)null);
                                        contactRecord.setAttribute(CUSTOMER_CONTACT_CONTACT_FIELD.getName(), Boolean.FALSE);
                                        customerContactsDS.updateData(contactRecord);
                                    }
                                }, new ContactErrorFunction() {

                                    @Override
                                    public void execute(ContactError error) {
                                        // The iOS implementation reports error code 0 (UNKNOWN_ERROR) if the contact has
                                        // already been deleted (for example, the user deletes the contact using the standard
                                        // Contacts app and then switches back to MyContacts).
                                        //
                                        // See: https://issues.apache.org/jira/browse/CB-1143
                                        Console.error("Contact.remove() failed with error code " + error.getCode());
                                        SC.say("Remove Failed", contactRecord.getAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()) + " could not be removed.");
                                    }
                                });
                            }
                        }
                    });
                }
                event.cancel();
            }
        });

        return customerContactsContainer;
    }

    private Layout createContact(final Record contact) {
        final NavigationBar contactCreateNavBar = new NavigationBar();
        contactCreateNavBar.setAutoDraw(false);
        contactCreateNavBar.setTitle("New Contact");
        contactCreateNavBar.setLeftButtonTitle("Back");

        contactCreateNavBar.setShowLeftButton(true);
        contactCreateNavBar.setShowRightButton(false);

        final DynamicForm createContactForm = new DynamicForm();
        createContactForm.setAutoDraw(false);
        createContactForm.setPadding(5);
        createContactForm.setHeight("*");
        final TextItem givenNameField = new TextItem(CUSTOMER_CONTACT_GIVEN_NAME_FIELD.getName(), "First&nbsp;Name");
        givenNameField.setRequired(true);
        givenNameField.setDefaultValue(contact.getAttribute(CUSTOMER_CONTACT_GIVEN_NAME_FIELD.getName()));
        final TextItem familyNameField = new TextItem(CUSTOMER_CONTACT_FAMILY_NAME_FIELD.getName(), "Last&nbsp;Name");
        familyNameField.setRequired(true);
        familyNameField.setDefaultValue(contact.getAttribute(CUSTOMER_CONTACT_FAMILY_NAME_FIELD.getName()));
        final TextItem fullNameField = new TextItem(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName(), "Full&nbsp;Name");
        fullNameField.setRequired(true);
        fullNameField.setDefaultValue(contact.getAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()));
        final TextItem phoneField = new TextItem(CUSTOMER_CONTACT_PHONE_FIELD.getName(), "Phone&nbsp;#");
        phoneField.setRequired(true);
        phoneField.setDefaultValue(contact.getAttribute(CUSTOMER_CONTACT_PHONE_FIELD.getName()));
        final TextItem streetAddressField = new TextItem(CUSTOMER_CONTACT_STREET_ADDRESS_FIELD.getName(), "Street&nbsp;Address");
        streetAddressField.setRequired(true);
        streetAddressField.setDefaultValue(contact.getAttribute(CUSTOMER_CONTACT_STREET_ADDRESS_FIELD.getName()));
        final TextItem localityField = new TextItem(CUSTOMER_CONTACT_LOCALITY_FIELD.getName(), "City");
        localityField.setRequired(true);
        localityField.setDefaultValue(contact.getAttribute(CUSTOMER_CONTACT_LOCALITY_FIELD.getName()));
        final TextItem regionField = new TextItem(CUSTOMER_CONTACT_REGION_FIELD.getName(), "State");
        regionField.setRequired(true);
        regionField.setDefaultValue(contact.getAttribute(CUSTOMER_CONTACT_REGION_FIELD.getName()));
        final TextItem postalCodeField = new TextItem(CUSTOMER_CONTACT_POSTAL_CODE_FIELD.getName(), "Postal&nbsp;Code");
        postalCodeField.setRequired(true);
        postalCodeField.setDefaultValue(contact.getAttribute(CUSTOMER_CONTACT_POSTAL_CODE_FIELD.getName()));
        final TextItem countryField = new TextItem(CUSTOMER_CONTACT_COUNTRY_FIELD.getName(), "Country");
        countryField.setRequired(true);
        countryField.setDefaultValue(contact.getAttribute(CUSTOMER_CONTACT_COUNTRY_FIELD.getName()));
        createContactForm.setFields(givenNameField, familyNameField, fullNameField, phoneField,
                streetAddressField, localityField, regionField, postalCodeField, countryField);

        final IButton createContactButton = new IButton("Add to Contacts");
        createContactButton.setAutoDraw(false);
        createContactButton.setWidth("40%");
        createContactButton.setHeight(50);

        final HStack contactHContainer = new HStack();
        contactHContainer.setAutoDraw(false);
        contactHContainer.setHeight("*");
        contactHContainer.setPadding(5);
        contactHContainer.setAlign(Alignment.CENTER);
        contactHContainer.setMembers(createContactButton);

        final VLayout createContactContainer = new VLayout();
        createContactContainer.setWidth100();
        createContactContainer.setHeight100();
        createContactContainer.setBackgroundColor("white");
        createContactContainer.setMembers(contactCreateNavBar, createContactForm, new LayoutSpacer(),
                contactHContainer);

        contactCreateNavBar.setNavigationClickHandler(new NavigationClickHandler() {

            @Override
            public void onNavigationClick(NavigationClickEvent event) {
                if ("back".equals(event.getDirection())) {
                    slideTransition(createContactContainer, customerContactsContainer, contactsApp, true);
                }
            }
        });

        createContactButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                final DynamicForm form = createContactForm;

                final ContactAddress contactAddress = ContactAddress.create();
                contactAddress.setStreetAddress(form.getValueAsString(CUSTOMER_CONTACT_STREET_ADDRESS_FIELD.getName()));
                contactAddress.setLocality(form.getValueAsString(CUSTOMER_CONTACT_LOCALITY_FIELD.getName()));
                contactAddress.setRegion(form.getValueAsString(CUSTOMER_CONTACT_REGION_FIELD.getName()));
                contactAddress.setPostalCode(form.getValueAsString(CUSTOMER_CONTACT_POSTAL_CODE_FIELD.getName()));
                contactAddress.setCountry(form.getValueAsString(CUSTOMER_CONTACT_COUNTRY_FIELD.getName()));
                contactAddress.setFormatted(contactAddress.getStreetAddress() + "\n" +
                        contactAddress.getLocality() + ", " + contactAddress.getRegion() + " " + contactAddress.getPostalCode() + "\n" +
                        contactAddress.getCountry());

                final ContactName contactName = ContactName.create();
                contactName.setFormatted(form.getValueAsString(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()));
                contactName.setGivenName(form.getValueAsString(CUSTOMER_CONTACT_GIVEN_NAME_FIELD.getName()));
                contactName.setFamilyName(form.getValueAsString(CUSTOMER_CONTACT_FAMILY_NAME_FIELD.getName()));

                final ContactField phoneNumber = ContactField.create();
                phoneNumber.setValue(form.getValueAsString(CUSTOMER_CONTACT_PHONE_FIELD.getName()));

                final Contact newContact = Contact.create();
                newContact.setDisplayName(form.getValueAsString(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()));
                newContact.setName(contactName);
                newContact.setPhoneNumbers(phoneNumber);
                newContact.setAddresses(contactAddress);
                newContact.save(new SaveContactSuccessFunction() {

                    @Override
                    public void execute(Contact newContact) {
                        names.put(contact.getAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()), newContact.getID());
                        contact.setAttribute(CUSTOMER_CONTACT_CONTACT_ID_FIELD.getName(), newContact.getID());
                        contact.setAttribute(CUSTOMER_CONTACT_CONTACT_FIELD.getName(), Boolean.TRUE);
                        customerContactsDS.updateData(contact);

                        SC.say(contact.getAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()) + " was added successfully.", new BooleanCallback() {

                            @Override
                            public void execute(Boolean value) {
                                slideTransition(createContactContainer, customerContactsContainer, contactsApp, true);
                            }
                        });
                    }
                }, new ContactErrorFunction() {

                    @Override
                    public void execute(ContactError error) {
                        SC.say("Save Failed", contact.getAttribute(CUSTOMER_CONTACT_FULL_NAME_FIELD.getName()) + " could not be added to your contacts.", new BooleanCallback() {

                            @Override
                            public void execute(Boolean value) {
                                slideTransition(createContactContainer, customerContactsContainer, contactsApp, true);
                            }
                        });
                    }
                });
            }
        });

        return createContactContainer;
    }

    private void slideTransition(Layout oldPane, Layout newPane, Layout container, boolean right) {
        impl.slideTransition(this, oldPane, newPane, container, right);
    }
}
