package com.example.employeemenu.service;

import com.example.employeemenu.model.Employee;

public interface EmployeeService {

    void addEmployee(Employee emp);

    Object getAllEmployee();

    Employee getEmployeeById(int id);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
