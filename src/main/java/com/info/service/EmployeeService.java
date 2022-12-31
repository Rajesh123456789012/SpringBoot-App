package com.info.service;

import com.info.dto.Employee;

import java.util.List;

public interface EmployeeService {

    public String saveEmployeeDetails(Employee employee);

    List<Employee> getAllEmps();
}
