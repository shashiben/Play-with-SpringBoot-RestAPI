package com.example.restapi.services;

import com.example.restapi.models.Employee;
import java.util.List;

public interface EmployeeService {
  public List<Employee> getEmployees();

  public Employee createEmployee(Employee employee);

  public Employee updateEmployee(Employee employee);

  public Employee getEmployeeById(Long id);

  public String deleteEmployee(Long id);
}
