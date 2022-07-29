package com.bk.secureapi.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

// Employee model class has basic employee-related attributes.
@Component
public class Forbidden implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String description;

    private String param;

    private String staffRole;

    private String customerRole;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    public String getCustomerRole() {
        return customerRole;
    }

    public void setCustomerRole(String customerRole) {
        this.customerRole = customerRole;
    }
}