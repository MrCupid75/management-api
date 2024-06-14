package com.beast.managementapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beast.managementapi.model.Employee;
import com.beast.managementapi.repository.EmployeeRepository;
import com.beast.managementapi.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String greetEmployee() {
        return "Hello good poeple";
    }

    @PostMapping("/register")
    public List<Employee> register(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);

        List<Employee> employees = employeeRepository.findAll();

        return employees;
    }

    @GetMapping("/")
    public List<Employee> showALL() {
        return employeeService.getAllEmployee();
    }

    @PutMapping("/{id}")
    public List<Employee> updateEmploy(@PathVariable long id, @RequestBody Employee employee) {
       employeeService.updateEmployee(id, employee);

       return employeeService.getAllEmployee();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
    }

}
