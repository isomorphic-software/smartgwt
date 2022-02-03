
package com.smartgwt.client.docs;

/**
 * <ul> <li>Explicitly defined validators on the dataSource field are run in the order in which
 * they are  defined on the client and on the server. Obviously any server-only validators are
 * skipped  on the client, and any client-only validators are skipped on the server.</li>
 * <li>Implicit type validators (an "isInteger" validator being applied automatically to all
 * fields  of type "Integer", for example) are run before any validators applied explicitly at the
 * field level. </li> <li>If a component has explicitly applied validators in addition to those
 * picked up from the  DataSourceField definition, the component-level validators will execute
 * first.  (This of course does not apply to server side validation).</li> </ul>
 */
public interface ValidatorExecution {
}
