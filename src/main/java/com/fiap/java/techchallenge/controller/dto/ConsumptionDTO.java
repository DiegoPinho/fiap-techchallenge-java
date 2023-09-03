package com.fiap.java.techchallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class ConsumptionDTO {

  @JsonProperty
  @NotBlank(message = "dailyUse is required and cannot be blank")
  private Integer dailyUse;

  @JsonProperty
  @NotBlank(message = "homeApplianceId is required and cannot be blank")
  private Long homeApplianceId;

  @JsonProperty
  @NotBlank(message = "personId is required and cannot be blank")
  private Long personId;

  public Integer getDailyUse() {
    return dailyUse;
  }

  public void setDailyUse(Integer dailyUse) {
    this.dailyUse = dailyUse;
  }

  public Long getHomeApplianceId() {
    return homeApplianceId;
  }

  public void setHomeApplianceId(Long homeApplianceId) {
    this.homeApplianceId = homeApplianceId;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

}
