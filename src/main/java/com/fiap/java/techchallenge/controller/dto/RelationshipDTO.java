package com.fiap.java.techchallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class RelationshipDTO {
  @JsonProperty
  @NotBlank(message = "personId is required and cannot be blank")
  private Long personId;

  @JsonProperty
  @NotBlank(message = "relativeId is required and cannot be blank")
  private Long relativeId;

  @JsonProperty
  @NotBlank(message = "relation is required and cannot be blank")
  private String relation;

  public RelationshipDTO(Long personId, Long relativeId, String relation) {
    this.personId = personId;
    this.relativeId = relativeId;
    this.relation = relation;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public Long getRelativeId() {
    return relativeId;
  }

  public void setRelativeId(Long relativeId) {
    this.relativeId = relativeId;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

}
