package com.smartgwt.client.types;


/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
/**
 * The AutoTest subsystem relies on generating and parsing identifier strings to identify components on the page. A very
 * common pattern is identifying a specific component within a list of possible candidates. There are many many cases where
 * this pattern is used, for example - members in a layout, tabs in a tabset, sections in a section stack. <P> In order to
 * make these identifiers as robust as possible across minor changes to an application, (such as skin changes, minor layout
 * changes, etc) the system will store multiple pieces of information about a component when generating an identification
 * string to retrieve it from a list of candidates. The system has a default strategy for choosing the order in which to
 * look at these pieces of information but in some cases this can be overridden by setting a <code>LocatorStrategy</code>.
 * <p> By default we use the following strategies in order to identify a component from a list of candidates:
 * <UL><li><code>name</code>: Does not apply in all cases but in cases where a specified <code>name</code> attribute has
 * meaning we will use it - for example for {@link com.smartgwt.client.widgets.layout.SectionStackSection#getName sections
 * in a section stack} or {@link com.smartgwt.client.widgets.Img#getName images}. </li> <li><code>title</code>: If a title
 * is specified for the component this may be used   as a legitimate identifier if it is unique within the component - for
 * example   differently titled tabs within a tabset.</li> <li><code>index</code>: Locating by index is typically less
 * robust than by name or   title as it is likely to be affected by layout changes on the page.</li> </UL><P> If an
 * explicit strategy is specified, that will be used to locate the component if possible. If no matching component is found
 * using that strategy, we will continue to try the remaining strategies in order as described above. In other words
 * setting a locatorStrategy to "title" will skip attempting to find a component by name, and instead attempt to find by
 * title - or failing that by index. <P> In cases where the name is considered definitive, such as for {@link
 * com.smartgwt.client.widgets.tab.Tab#getName Tabs} or {@link com.smartgwt.client.widgets.form.fields.FormItem#getName
 * FormItems}, no fallback check will occur if a name is provided in the locator but doesn't match a live object - the
 * locator will fail to match anything. Furthermore, in the case of {@link com.smartgwt.client.widgets.tab.Tab Tabs},
 * {@link com.smartgwt.client.widgets.form.fields.FormItem FormItems}, or collections other than {@link
 * com.smartgwt.client.widgets.Canvas#getChildren children of a widget}, if a title is present in the locator and you
 * haven't specified specified "index" as the strategy, there may be no fallback check using the index if the locator title
 * fails to match. <P> To avoid the Framework trying to match by name or title where they are assumed definitive and we
 * skip fallback to the remaining locator attributes, you'll need to remove the name or title from the locator in question
 * (or set the locatorStrategy to "index" in the case of the title). <P> Note that we also support matching by type (see
 * {@link com.smartgwt.client.types.LocatorTypeStrategy}). Matching by type is used if we were unable to match by name or
 * title or to disambiguate between multiple components with a matching title.
 */
public enum LocatorStrategy implements ValueEnum {
    /**
     * Match by name if possible.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "name".
     */
    NAME("name"),
    /**
     * Match by title if possible.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "title".
     */
    TITLE("title"),
    /**
     * Match by index
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "index".
     */
    INDEX("index");
    private String value;

    LocatorStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
