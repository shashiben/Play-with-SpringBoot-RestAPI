package com.example.restapi.controllers;

import com.example.restapi.models.Employee;
import com.example.restapi.services.EmployeeService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Value("${app.name}")
  private String appName;

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public ResponseEntity<List<Employee>> getEmployees(
    @RequestParam Integer pageNumber,
    @RequestParam Integer pageSize
  ) {
    return new ResponseEntity<List<Employee>>(
      employeeService.getEmployees(pageNumber, pageSize),
      HttpStatus.OK
    );
  }

  @PostMapping("/")
  public ResponseEntity<Employee> createEmployee(
    @Valid @RequestBody Employee employee
  ) {
    return new ResponseEntity<>(
      employeeService.createEmployee(employee),
      HttpStatus.CREATED
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(
    @PathVariable Long id,
    @Valid @RequestBody Employee employee
  ) {
    employee.setId(id);
    return new ResponseEntity<>(
      employeeService.updateEmployee(employee),
      HttpStatus.OK
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(
      employeeService.getEmployeeById(id),
      HttpStatus.OK
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteEmployee(
    @PathVariable("id") Long id
  ) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/filter")
  public ResponseEntity<List<Employee>> getEmployeesByName(
    @RequestParam String name,
    @RequestParam Optional<String> address
  ) {
    Sort sort = Sort.by(Sort.Direction.DESC, "id");
    if (address.isPresent()) {
      return new ResponseEntity<>(
        employeeService.getEmployeesByNameAndAddress(name, address.get(), sort),
        HttpStatus.OK
      );
    }
    return new ResponseEntity<List<Employee>>(
      employeeService.getEmployeesByName(name, sort),
      HttpStatus.OK
    );
  }

  @GetMapping("/getByNameOrLocation")
  public ResponseEntity<List<Employee>> getEmployeeByNameOrLocation(
    @RequestParam String name,
    @RequestParam String address
  ) {
    return new ResponseEntity<>(
      employeeService.getEmployeeByNameOrAddress(name, address),
      HttpStatus.OK
    );
  }

  @DeleteMapping("/deleteByName")
  public ResponseEntity<Integer> deleteEmployeeByName(
    @RequestParam String name
  ) {
    return new ResponseEntity<>(
      employeeService.deleteEmployeeByName(name),
      HttpStatus.OK
    );
  }
}
