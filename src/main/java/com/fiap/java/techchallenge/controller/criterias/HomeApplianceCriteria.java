package com.fiap.java.techchallenge.controller.criterias;

import org.springframework.data.jpa.domain.Specification;

import com.fiap.java.techchallenge.entity.HomeAppliance;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Objects;

public class HomeApplianceCriteria {

  private String name;
  private String model;
  private Integer power;

  public Specification<HomeAppliance> toSpecification() {
    return (Root<HomeAppliance> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
      Predicate predicate = criteriaBuilder.conjunction();

      if (Objects.nonNull(name)) {
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), name));
      }

      if (Objects.nonNull(model)) {
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("model"), model));
      }

      if (Objects.nonNull(power)) {
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("power"), power));
      }

      return predicate;
    };
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getPower() {
    return power;
  }

  public void setPower(Integer power) {
    this.power = power;
  }

}
