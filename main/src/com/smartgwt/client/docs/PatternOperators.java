
package com.smartgwt.client.docs;

/**
 * The {@link com.smartgwt.client.types.OperatorId search operators}   use patterns like "foo*txt"
 * to match text values.  The patterns are similar to the patterns you use to match names of files
 * in a command-line interface, or to the pattern allowed for the SQL "LIKE" operator. The
 * supported search operators are:  <ul>      <li>"matchesPattern" Basic GLOB matching using
 * wildcards.</li>      <li>"iMatchesPattern" Basic GLOB matching using wildcards (case
 * insensitive).</li>      <li>"containsPattern" GLOB matching using wildcards. Value is
 * considered to meet the        criterion if it contains the pattern. </li>     
 * <li>"startsWithPattern" GLOB mathcing using wildcards. Value is considered to meet the       
 * criterion if it starts with the pattern.</li>      <li>"endsWithPattern" GLOB mathcing using
 * wildcards. Value is considered to meet the        criterion if it starts with the pattern.</li>
 * <li>"iContainsPattern" GLOB matching using wildcards. Value is considered to meet the       
 * criterion if it contains the pattern. Matching is case insensitive. </li>     
 * <li>"iStartsWithPattern" GLOB matching using wildcards. Value is considered to meet the       
 * criterion if it starts with the pattern.  Matching is case insensitive.</li>     
 * <li>"iEndsWithPattern" GLOB matching using wildcards.Value is considered to meet the       
 * criterion if it ends with the pattern. Matching is case insensitive.</li>  </ul> See {@link
 * com.smartgwt.client.data.DataSource#getTranslatePatternOperators
 * DataSource.translatePatternOperators} for more information on available patterns)
 */
public interface PatternOperators {
}
