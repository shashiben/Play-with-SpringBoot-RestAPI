package com.example.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "employee")
public class Employee {
  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "age")
  private Long age;

  @Column(name = "department")
  private String department;

  @Column(name = "address")
  private String address;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;
}
