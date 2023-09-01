package com.fiap.java.techchallenge.controller.criterias;

import org.springframework.data.jpa.domain.Specification;

import com.fiap.java.techchallenge.entity.Gender;
import com.fiap.java.techchallenge.entity.Person;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Objects;

public class PersonCriteria {

  private String name;
  private Gender gender;
  private String relationship;

  public Specification<Person> toSpecification() {
    return (Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
      Predicate predicate = criteriaBuilder.conjunction();

      if (Objects.nonNull(name)) {
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), name));
      }

      if (Objects.nonNull(gender)) {
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("gender"), gender));
      }

      if (Objects.nonNull(relationship)) {
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("relationship"), relationship));
      }

      // Você pode adicionar mais condições baseadas em outros campos, similar ao ISBN
      // acima.
      return predicate;
    };
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

}
