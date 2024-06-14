package com.beast.managementapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.beast.managementapi.model.Employee;
import com.beast.managementapi.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployee() {

        List<Employee> allEmployees = employeeRepository.findAll();

        return allEmployees;
    }

    public Employee getEmployee(Long id) {

        Employee employee = employeeRepository.findById(id).get();

        return employee;
    }

    public ResponseEntity<Employee> updateEmployee(Long id, @RequestBody Employee employee) {
        Employee newEmployee = employeeRepository.findById(id).get();

        newEmployee.setName(employee.getName());
        newEmployee.setPassword(employee.getPassword());
        newEmployee.setEmail(employee.getEmail());

        employeeRepository.save(newEmployee);

        return ResponseEntity.ok(newEmployee);
    }

    public void createEmployee(@RequestBody Employee employee) {

        employeeRepository.save(employee);

    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);

    }
}
