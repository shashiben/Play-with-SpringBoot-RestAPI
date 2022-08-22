package com.example.restapi.respositories;

import com.example.restapi.models.Employee;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
  extends PagingAndSortingRepository<Employee, Long> {
  List<Employee> findByName(String name);
  List<Employee> findByDepartment(String department);
  List<Employee> findByNameAndAddress(String name, String address);
  List<Employee> findByNameContaining(String keyword, Sort sort);
  List<Employee> findByNameContainingAndAddress(
    String keyword,
    String address,
    Sort sort
  );

  List<Employee> findByNameLike(String keyword);
}
