
package com.smartgwt.client.docs;

/**
 * <h3>String Methods Overview</h3>
 * A method flagged as a String Method can be specified as a String containing a valid
 *  JavaScript expression.  This expression will automatically be converted to a function with a
 *  return value matching the value of the last statement.  Providing a String is not required -
 *  you may use a real function instead.
 *  <p>
 *  For example - suppose you wanted to override the <code>leafClick()</code> method on
 *  the TreeGrid.  Normally you would do so as follows:<br>
 * 
 *  <pre>
 *  TreeGrid.create({
 *      ...
 *      leafClick : function(viewer, leaf, recordNum) { 
 *          if(leaf.name == 'zoo') { 
 *              alert(1); 
 *          } else {
 *              alert(2);
 *          }
 *      }
 *  });
 *  </pre>
 * 
 *  Since leafClick is a stringMethod, however, you can shorten this to:<br>
 *  <pre>
 *  TreeGrid.create({
 *      ...
 *      leafClick : "if(leaf.name == 'zoo') { alert(1); } else { alert(2); }";
 *  });
 *  </pre>
 */
public interface StringMethods {
}
