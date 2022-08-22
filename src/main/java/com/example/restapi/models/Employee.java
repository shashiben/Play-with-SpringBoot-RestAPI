package com.example.restapi.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  @NotBlank(message = "Please provide department name")
  private String department;

  @NotBlank(message = "Please provide a valid address")
  private String address;

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
}
