package com.example.employeemenu.controller;

import com.example.employeemenu.model.Employee;
import com.example.employeemenu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("employee", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add_employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String editPage(@PathVariable (value = "id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdatedEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(employee.getId(), employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable (value = "id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
