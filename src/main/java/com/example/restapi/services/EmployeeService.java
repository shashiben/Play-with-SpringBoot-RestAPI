package com.example.restapi.services;

import com.example.restapi.models.Employee;
import java.util.List;

public interface EmployeeService {
  public List<Employee> getEmployees();

  public String createEmployee(Employee employee);

  public Employee updateEmployee(Long id, Employee employee);

  public String getEmployeeById(Long id);

  public String deleteEmployee(Long id);
}
