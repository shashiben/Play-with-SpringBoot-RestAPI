package com.example.restapi.models;

import com.example.restapi.request.EmployeeRequest;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Setter
@Getter
@ToString
@Entity
@Table(name = "employee")
public class Employee {
  @NotBlank(message = "Employee name is required")
  private String name;

  @Email(message = "Please provide a valid email")
  @Column(name = "email", unique = true)
  private String email;

  private Long age = 0L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private Date updatedAt;

  @JoinColumn(name = "department_id")
  @OneToOne
  private Department department;

  public Employee() {}

  public Employee(EmployeeRequest request) {
    this.name = request.getName();
    this.email = request.getEmail();
    this.age = request.getAge();
    this.createdAt = request.getCreatedAt();
    this.updatedAt = request.getUpdatedAt();
  }
}
