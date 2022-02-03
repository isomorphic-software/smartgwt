
package com.smartgwt.client.docs;

/**
 * <h3>Test Data</h3>
 * You can create a test file that contains a sample dataset which can be imported into your
 *  database table with the Admin Console.
 *  <p>
 *  Test data can come in a variety of flavours based on your personal preference.
 *  <p>
 *  <ul>
 *  <li>CSV - Comma Separated Values</li>
 *  <li>JSON - An array of JSON objects</li>
 *  <li>XML - Extensible Markup Language</li>
 *  </ul>
 *  <p>
 *  <h3>CSV</h3>
 *  <p>
 *  The test file to use with your DataSource is specified in the <code>testFileName</code>
 *  DataSource configuration property and will have the <code>.data.csv</code> extension.
 *  <p>
 * The CSV file can contain an optional header line as the example below will show you. The
 * headline
 *  names can be either DataSource title or field name and are not case sensitive. If the
 * header line is missing it will be assumed that the data/columns are the same order as the field
 *  declaration in the DataSource file. This sample represents some moon landing data and you can
 *  also use double quotes around more complex values.
 *  <p>
 *  <pre>
 *  mission, duration, launchDate, commander, rover
 *  "Apollo 11", "195.31", 1969-07-16, "Neil Armstrong", false
 *  "Apollo 12", "244.61", 1969-11-14, "Charles Conard", false
 *  "Apollo 13", 142.91, "1970-04-11", "Jim Lovell", false
 *  "Apollo 14", 216.03, "1971-01-31", "Alan Shepard", false
 *  "Apollo 15", 295.20, "1971-07-26", "David Scott", true
 *  "Apollo 16", 265.85, "1972-04-16", "John W. Young", true
 *  "Apollo 17", "301.87", 1972-12-07, "Eugene Cernan", true
 *  </pre>
 *  <p>
 *  <h3>JSON</h3>
 *  <p>
 *  The test file to use with your DataSource is specified in the <code>testFileName</code>
 *  DataSource configuration property and will have the <code>.data.js</code> extension.
 *  <p>
 *  The JSON file needs to contain an array of objects. Each object represents a new record and
 *  will contain the properties in a JSON fashion. The names can be either DataSource title or
 *  field name and are not case senstive.
 *  <p>
 *  <pre>
 *  [
 *    {
 *      category: "Adding Machine/calculator Roll",
 *      itemName: "Adding Machine Roll 57x57mm Lint Free",
 *      sku: "226500",
 *      unitCost: 0.52,
 *      units: "Roll"
 *    },
 *    {
 *      category: "Pastes and Gum",
 *      itemName: "Glue UHU Clear Gum 250ml",
 *      sku: "724800",
 *      unitCost: 2.26,
 *      description: "Ideal for paper and card. Dries clear. Easy to use. Washable &amp; Non-Toxic."
 *    },
 *    ...
 *  ]
 *  </pre>
 *  <p>
 *  <h3>XML</h3>
 *  <p>
 *  The test file to use with your DataSource is specified in the <code>testFileName</code>
 *  DataSource configuration property and will have the <code>.data.xml</code> extension.
 *  <p>
 *  The test data file should consist of a top-level element containing a series of XML
 *  elements, each of which creates one DataSource record. Values for each field are given
 *  within tags named after the field name or in the parent tag as an attribute.
 *  <p>
 *  For example, the following XML represents a list of supply items.
 *  <p>
 *  <pre>
 *  &lt;records&gt;
 *   &lt;record&gt;
 *       &lt;description&gt;A revolutionary cushion-grip ballpoint pen that reduces
 *           required gripping power, relieving stress and alleviating writing
 *           fatigue. Excellent for people who suffer from arthritis or carpal
 *           tunnel syndrome. Medium point, black ink. Refillable.&lt;/description&gt;
 *       &lt;category&gt;1&lt;/category&gt;
 *       &lt;itemRef&gt;ODC 204-502-153&lt;/itemRef&gt;
 *       &lt;maxQuantity&gt;5&lt;/maxQuantity&gt;
 *       &lt;requiresJustification&gt;0&lt;/requiresJustification&gt;
 *       &lt;itemName&gt;Dr. Grip Pens -- Blue Barrel&lt;/itemName&gt;
 *       &lt;itemID&gt;1&lt;/itemID&gt;
 *       &lt;unitCost&gt;4.99&lt;/unitCost&gt;
 *   &lt;/record&gt;
 *   &lt;record&gt;
 *       &lt;description&gt;A revolutionary cushion-grip ballpoint pen that reduces
 *           required gripping power, relieving stress and alleviating writing
 *           fatigue. Excellent for people who suffer from arthritis or carpal
 *           tunnel syndrome. Medium point, black ink. Refillable.&lt;/description&gt;
 *       &lt;category&gt;1&lt;/category&gt;
 *       &lt;itemRef&gt;ODC 204-708-834&lt;/itemRef&gt;
 *       &lt;maxQuantity&gt;5&lt;/maxQuantity&gt;
 *       &lt;requiresJustification&gt;0&lt;/requiresJustification&gt;
 *       &lt;itemName&gt;Dr. Grip Pens -- Black Barrel&lt;/itemName&gt;
 *       &lt;itemID&gt;2&lt;/itemID&gt;
 *       &lt;unitCost&gt;4.99&lt;/unitCost&gt;
 *   &lt;/record&gt;
 *   &lt;record&gt;
 *       &lt;description&gt;Personalized business cards for all your networking
 *           needs.&lt;/description&gt;
 *       &lt;category&gt;2&lt;/category&gt;
 *       &lt;itemRef&gt;&lt;/itemRef&gt;
 *       &lt;maxQuantity&gt;500&lt;/maxQuantity&gt;
 *       &lt;requiresJustification&gt;1&lt;/requiresJustification&gt;
 *       &lt;itemName&gt;Personalized business cards -- 500 count&lt;/itemName&gt;
 *       &lt;itemID&gt;3&lt;/itemID&gt;
 *       &lt;unitCost&gt;25.00&lt;/unitCost&gt;
 *   &lt;/record&gt;
 *   ...
 *  &lt;records/&gt;
 *  </pre>
 * 
 *  Data for a tree-like DataSource can be specified with the same format.
 *  The following code example is for supply categories. This will make use of attribute values
 *  instead of separate tags for each property on the supply category. The attribues are not
 *  case sensitive and can be named after either the DataSource title or field name.
 * 
 *  <pre>
 *  &lt;categories&gt;
 *      &lt;category itemName="Office Paper Products" parentID="root" /&gt;
 *      &lt;category itemName="Calculator Rolls" parentID="Office Paper Products" /&gt;
 *      &lt;category itemName="Adding Machine/calculator Roll" parentID="Calculator Rolls" /&gt;
 *      ...
 *  &lt;/categories&gt;
 *  </pre>
 * 
 *  Note that all records must define values for the itemName primary key field and for the
 *  parentID field that establishes the tree relationship.
 *  <p>
 *  <h3>Date, Time and DateTime considerations</h3>
 *  <p>
 * When you have date, time or datetime fields these need to be formatted the same way they are
 * expected
 *  to be formatted in REST responses. If data for a field does not match the expected format it
 *  will be parsed using JDK built-in DataFormat parsers, in lenient mode, in the server's default
 *  locale.
 * 
 *  Examples of date, time and datetime formats.
 *  <pre>
 *     // date - YYYY-MM-DD
 *     2014-12-06
 * 
 *     // time - hh:mm:ss
 *     22:01:45
 * 
 *     // datetime - YYYY-MM-DDThh:mm:ssZ
 *     2014-12-06T22:01:45-04:00
 *  </pre>
     * @see com.smartgwt.client.docs.DateFormatAndStorage
 */
public interface TestData {
}
