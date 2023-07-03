package com.fiap.java.techchallenge.controller.dto;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PersonDTO {

  private String name;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

  private String gender; // TODO: transform into ENUM

  private String relationship;
}
