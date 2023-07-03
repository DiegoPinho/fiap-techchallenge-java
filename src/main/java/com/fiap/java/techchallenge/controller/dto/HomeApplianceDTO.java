package com.fiap.java.techchallenge.controller.dto;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.java.techchallenge.domain.HomeAppliance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class HomeApplianceDTO {

  @JsonProperty
  @NotBlank(message = "Name is required and cannot be blank")
  private String name;

  @JsonProperty
  @NotBlank(message = "Model is required and cannot be blank")
  private String model;

  @JsonProperty
  @NotNull(message = "Power is required and cannot be blank")
  @Positive(message = "Power is required and cannot be blank")
  private Integer power;

  public HomeAppliance toHomeAppliance() {
    return new HomeAppliance(this.name, this.model, this.power);
  }
}