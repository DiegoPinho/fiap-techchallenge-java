package com.fiap.java.techchallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.java.techchallenge.entity.HomeAppliance;

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

  @JsonProperty
  @NotBlank(message = "Model is required and cannot be blank")
  private String manufacturer;

  @JsonProperty
  @NotNull(message = "Power is required and cannot be blank")
  @Positive(message = "Power is required and cannot be blank")
  private Integer voltage;

  @JsonProperty
  @NotNull(message = "AddressId is required and cannot be blank")
  private Long addressId;

  public HomeAppliance toHomeAppliance() {
    return new HomeAppliance(this.name, this.model, this.power, this.manufacturer, this.voltage);
  }

  public String getName() {
    return name;
  }

  public String getModel() {
    return model;
  }

  public Integer getPower() {
    return power;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public Integer getVoltage() {
    return voltage;
  }

  public Long getAddressId() {
    return addressId;
  }

}