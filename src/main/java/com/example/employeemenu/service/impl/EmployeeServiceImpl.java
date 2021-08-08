package com.example.employeemenu.service.impl;

import com.example.employeemenu.dao.EmployeeDao;
import com.example.employeemenu.model.Employee;
import com.example.employeemenu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee emp) {
        employeeDao.addEmployeeToDB(emp);
    }

    public Object getAllEmployee() {
        List<Employee> employeeList = employeeDao.getAllEmployeeFromDB();
        for (Employee emp:employeeList) {
            System.out.println(emp.toString());
        }

        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee emp = employeeDao.getEmployeeByIdFromDB(id);
        return emp;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        employeeDao.updateEmployeeById(id, employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployeeById(id);
    }
}
