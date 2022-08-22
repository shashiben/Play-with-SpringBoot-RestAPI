package com.example.restapi.respositories;

import com.example.restapi.models.Employee;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository
  extends PagingAndSortingRepository<Employee, Long> {
  List<Employee> findByName(String name);
  // List<Employee> findByDepartment(String department);
  // List<Employee> findByNameAndAddress(String name, String address);
  List<Employee> findByNameContaining(String keyword, Sort sort);
  // List<Employee> findByNameContainingAndAddress(
  //   String keyword,
  //   String address,
  //   Sort sort
  // );

  List<Employee> findByNameLike(String keyword);

  // @Query("FROM Employee e WHERE e.name=:name OR address=:address")
  // List<Employee> getEmployeeByNameAndAddress(String name, String address);

  @Transactional
  @Modifying
  @Query("DELETE FROM Employee e WHERE e.name=:name")
  Integer deleteEmployeeByName(String name);

  @Query("FROM Employee  WHERE department.name=:name")
  List<Employee> getEmployeesByDeptName(String name);
}
