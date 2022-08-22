package com.example.restapi.services;

import com.example.restapi.models.Employee;
import com.example.restapi.respositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getEmployees(int pageNumber, int pageSize) {
    Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC, "id");
    return employeeRepository.findAll(pages).getContent();
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
  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public List<Employee> getEmployeesByName(String name, Sort sort) {
    return employeeRepository.findByNameContaining(name, sort);
  }

  @Override
  public List<Employee> getEmployeesByNameAndAddress(
    String name,
    String address,
    Sort sort
  ) {
    return employeeRepository.findByNameContainingAndAddress(
      name,
      address,
      sort
    );
  }

  @Override
  public List<Employee> getEmployeeByNameOrAddress(
    String name,
    String address
  ) {
    return employeeRepository.getEmployeeByNameAndAddress(name, address);
  }

  @Override
  public Integer deleteEmployeeByName(String name) {
    return employeeRepository.deleteEmployeeByName(name);
  }
}
