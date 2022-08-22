package com.example.restapi.services;

import com.example.restapi.models.Employee;
import com.example.restapi.respositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee updateEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee getEmployeeById(Long id) {
    Optional<Employee> employee = employeeRepository.findById(id);
    if (employee.isPresent()) {
      return employee.get();
    }
    throw new RuntimeException("Employee Not Found for the id " + id);
  }

  @Override
  public String deleteEmployee(Long id) {
    try {
      employeeRepository.deleteById(id);
      return "Deleted employee with id " + id;
    } catch (Exception e) {
      return "Employee not found for the id " + id;
    }
  }
}
