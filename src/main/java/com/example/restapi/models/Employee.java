package com.example.restapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Employee {
  private String name;

  private String email;
  private Long age;

  private String department;
  private String address;
}
