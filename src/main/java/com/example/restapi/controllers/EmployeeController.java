package com.example.restapi.controllers;

import com.example.restapi.models.Employee;
import com.example.restapi.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Value("${app.name}")
  private String appName;

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public List<Employee> getEmployees() {
    return employeeService.getEmployees();
  }

  @PostMapping("/")
  public String createEmployee(@RequestBody Employee employee) {
    return employee.toString();
  }

  @PutMapping("/{id}")
  public Employee updateEmployee(
    @PathVariable Long id,
    @RequestBody Employee employee
  ) {
    return employee;
  }

  @GetMapping("/{id}")
  public String getEmployeeById(@PathVariable("id") Long id) {
    return "Employee with id " + id;
  }

  @DeleteMapping("/{id}")
  public String deleteEmployee(@PathVariable("id") Long id) {
    return "Deleting Employee with id " + id;
  }
}
