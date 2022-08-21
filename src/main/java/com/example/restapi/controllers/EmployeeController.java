package com.example.restapi.controllers;

import com.example.restapi.models.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
  @Value("${app.name}")
  private String appName;

  @GetMapping("/employees")
  public String getEmployees() {
    return "List of Employees";
  }

  @PostMapping("/employees")
  public String createEmployee(@RequestBody Employee employee) {
    return employee.toString();
  }

  @PutMapping("/employees/{id}")
  public Employee updateEmployee(
    @PathVariable Long id,
    @RequestBody Employee employee
  ) {
    return employee;
  }

  @GetMapping("/employees/{id}")
  public String getEmployeeById(@PathVariable("id") Long id) {
    return "Employee with id " + id;
  }

  @DeleteMapping("/employees/{id}")
  public String deleteEmployee(@PathVariable("id") Long id) {
    return "Deleting Employee with id " + id;
  }
}
