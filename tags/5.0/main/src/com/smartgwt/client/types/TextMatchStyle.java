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
 * For "fetch" operations, how simple search criteria should be interpreted for text fields  (and to some extent numeric
 * fields, see the notes below).  For greater flexibility, use  {@link com.smartgwt.client.data.AdvancedCriteria}.
 */
public enum TextMatchStyle implements ValueEnum {
    /**
     * case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
     */
    EXACT("exact"),
    /**
     * case-sensitive exact match ("foo" matches only "foo")
     */
    EXACT_CASE("exactCase"),
    /**
     * case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
     */
    SUBSTRING("substring"),
    /**
     * case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo") <p> textMatchStyle behavior is consistent across
     * the client and all three of the built-in server DataSource implementations - SQL, Hibernate and JPA - to the maximum
     * extent that is practical. Known inconsistencies, some of which can be tweaked with configuration settings, are described
     * below<ul> <li>textMatchStyle can be disabled for any individual field with the  {@link
     * com.smartgwt.client.data.DataSourceField#getIgnoreTextMatchStyle ignoreTextMatchStyle} declaration. This behavior is
     * consistent across client and server implementations, with the proviso that case-sensitive behavior  is inherently
     * inconsistent in the server-side implementations (see below for a more  detailed discussion of this)</li>
     * <li>textMatchStyle does not apply to boolean or temporal (date, datetime, time) {@link
     * com.smartgwt.client.data.DataSourceField#getType field types}. Such fields are always checked for equality. If  you have
     * a need for more complex matching, such as date-range checking, use AdvancedCriteria</li> <li>Critiera values for
     * temporal fields <b>must</b> be real dates (Javascript <code>Date</code> objects on the client, instances of
     * <code>java.util.Date</code> on the server). Attempting to match against a string or any other type of value will result
     * in an "always fails"  clause being generated. This behavior is how the client code has always worked, but is a  change
     * for the server-side DataSources, in the interests of consistency. The previous behavior was:<ul> <li>SQLDataSource used
     * to attempt to match the date column to the criteria value provided; if that value was an appropriately-formatted string,
     * that attempt <i>might</i> have  worked, but it would be database-specific. If you have an application that depends on 
     * this old behavior, you can switch it back on by adding the following to your <code>server.properties</code> file: 
     * <code>sql.temporal.fields.require.date.criteria: false</code></li> <li>HibernateDataSource and JPADataSource used to
     * skip such clauses altogether, which  results in the opposite behavior (there is an implied "always succeeds" clause,
     * because  the clause is not present in the query at all). If you have an application that depends on  this old behavior,
     * you can switch it back on by adding the following to your <code>server.properties</code> file: 
     * <code>jpa.temporal.fields.require.date.criteria: false</code> or  <code>hibernate.temporal.fields.require.date.criteria:
     * false</code>, as appropriate</li> </ul></li> <li>textMatchStyle does not apply to fields used in the joins generated to
     * satisfy  {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom includeFrom} declarations or entity
     * relations in Hibernate or JPA. Again, such comparisons are always for equality</li> <li>textMatchStyle is applied to
     * numeric fields <b>only</b> if the supplied criteria value is a string. So for a numeric field "myNumber", we will match
     * 10, 100, 110 and 1000 if a  criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a 
     * criteria value of 10 (the actual number) is supplied<ul> <li>This is a change in behavior for the server-side DataSource
     * implementations, in the  interests of consistency with the client behavior. Previously, all three of the built-in
     * DataSource implementations applied textMatchStyle to numeric fields regardless of the  criteria value's type. If you
     * have an application that depends on this old behavior,  you can switch it back on by adding the following to your
     * <code>server.properties</code> file: <code>sql.substring.numeric.criteria: true</code> or 
     * <code>hibernate.substring.numeric.criteria: true</code> or  <code>jpa.substring.numeric.criteria: true</code>, as
     * appropriate</li> </ul></li> <li>"exactCase" matching cannot be made consistent across all database providers because 
     * each database has its own idea of whether case-sensitive matching should be the default,  and how to switch it on and
     * off (if that is even possible)<ul> <li>Microsoft SQL Server must have case-sensitive matching enabled by setting a 
     * case-sensitive collation when the database is created (there are more fine-grained  options, but we do not recommend
     * them because of the scope for further inconsistency,  where "exactCase" works correctly on table A but not on table B).
     * See  <a href=http://msdn.microsoft.com/en-us/library/ms175835.aspx>MSDN</a> for details</li> <li>HSQLDB has case
     * sensitivity set with the <code>SET IGNORECASE</code> directive - <a
     * href=http://www.hsqldb.org/doc/guide/ch09.html#set_ignorecase-section>see here</a></li> <li>MySQL is case-insensitive,
     * but since it provides an easy way to do per-query, case-sensitive matching in SQL, we work around it for that database,
     * but <b>only</b> in SQL DataSources</li> </ul></li> <li>If you are using Hibernate or JPA, whether "exactCase" works as
     * expected depends  entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained control of
     * the SQL that the database executes, we are constrained by what the ORM will  allow. This prevents us from compensating
     * for database quirks, like we do with MySQL's case-insensitivity in the SQL DataSource</li> </ul>
     */
    STARTS_WITH("startsWith");
    private String value;

    TextMatchStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
