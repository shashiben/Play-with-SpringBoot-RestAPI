package com.example.restapi.services;

import com.example.restapi.models.Employee;
import com.example.restapi.respositories.EmployeeRepository;
import java.util.List;
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
  public String createEmployee(Employee employee) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Employee updateEmployee(Long id, Employee employee) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getEmployeeById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String deleteEmployee(Long id) {
    // TODO Auto-generated method stub
    return null;
  }
}
