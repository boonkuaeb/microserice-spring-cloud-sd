package com.bk.secureapi.repository;

import com.bk.secureapi.model.Forbidden;

import java.util.Map;


public interface ForbiddenRepo {

    // Save a new forbidden.
    void save(Forbidden forbidden);

    // Find employee by id.
    Forbidden findById(String id);

    // Final all employees.
    Map<String, Forbidden> findAll();

    // Delete a employee.
    void delete(String id);
}
