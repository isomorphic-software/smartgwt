
package com.smartgwt.client.docs;

/**
 * <h3>String Methods Overview</h3>
 * A method flagged as a String Method can be specified as a String containing a valid&#010 JavaScript expression.  This
 * expression will automatically be converted to a function with a&#010 return value matching the value of the last
 * statement.  Providing a String is not required -&#010 you may use a real function instead.&#010 <p>&#010 For example -
 * suppose you wanted to override the <code>leafClick()</code> method on&#010 the TreeGrid.  Normally you would do so as
 * follows:<br>&#010&#010 <pre>&#010 TreeGrid.create({&#010     ...&#010     leafClick : function(viewer, leaf, recordNum)
 * { &#010         if(leaf.name == 'zoo') { &#010             alert(1); &#010         } else {&#010            
 * alert(2);&#010         }&#010     }&#010 });&#010 </pre>&#010&#010 Since leafClick is a stringMethod, however, you can
 * shorten this to:<br>&#010 <pre>&#010 TreeGrid.create({&#010     ...&#010     leafClick : "if(leaf.name == 'zoo') {
 * alert(1); } else { alert(2); }";&#010 });&#010 </pre>
 */
public interface StringMethods {
}
