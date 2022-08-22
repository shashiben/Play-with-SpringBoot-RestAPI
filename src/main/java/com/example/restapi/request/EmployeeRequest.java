package com.example.restapi.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
  private String name;
  private String email;
  private Long age;
  private String department;
  private Date createdAt;
    private Date updatedAt;
}
