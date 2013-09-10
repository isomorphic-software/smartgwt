package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class EmployeeRecord extends ListGridRecord {

    public EmployeeRecord() {
    }

    public EmployeeRecord(String employee, String division, String department) {
        setEmployee(employee);
        setDivision(division);
        setDepartment(department);
    }

    public String getEmployee() {
        return getAttribute("employee");
    }

    public void setEmployee(String employee) {
        setAttribute("employee", employee);
    }

    public String getDivision() {
        return getAttribute("division");
    }

    public void setDivision(String division) {
        setAttribute("division", division);
    }

    public String getDepartment() {
        return getAttribute("department");
    }

    public void setDepartment(String department) {
        setAttribute("department", department);
    }
}
