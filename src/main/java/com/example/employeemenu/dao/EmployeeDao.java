package com.example.employeemenu.dao;

import com.example.employeemenu.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void addEmployeeToDB(Employee emp);

    List getAllEmployeeFromDB();

    Employee getEmployeeByIdFromDB(int id);

    void updateEmployeeById(int id, Employee employee);

    int deleteEmployeeById(int id);
}
