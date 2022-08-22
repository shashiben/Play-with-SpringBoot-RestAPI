package com.example.restapi.services;

import com.example.restapi.models.Employee;
import java.util.List;
import org.springframework.data.domain.Sort;

public interface EmployeeService {
  public List<Employee> getEmployees(int pageNumber, int pageSize);

  public Employee createEmployee(Employee employee);

  public Employee updateEmployee(Employee employee);

  public Employee getEmployeeById(Long id);

  public void deleteEmployee(Long id);

  public List<Employee> getEmployeesByName(String name, Sort sort);

  // public List<Employee> getEmployeesByNameAndAddress(
  //   String name,
  //   String address,
  //   Sort sort
  // );

  // public List<Employee> getEmployeeByNameOrAddress(
  //   String name,
  //   String address
  // );
  public Integer deleteEmployeeByName(String name);
}
