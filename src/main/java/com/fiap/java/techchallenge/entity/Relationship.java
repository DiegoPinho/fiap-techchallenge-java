package com.fiap.java.techchallenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Table
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id" }, callSuper = true)
@Entity(name = "relationships")
public class Relationship {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person person;

  @ManyToOne
  @JoinColumn(name = "relative_id")
  private Person relative;

  private String relation;

  public Relationship() {
  }

  public Relationship(Person person, Person relative, String relation) {
    this.person = person;
    this.relative = relative;
    this.relation = relation;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person pessoa) {
    this.person = pessoa;
  }

  public Person getRelative() {
    return relative;
  }

  public void setRelative(Person relative) {
    this.relative = relative;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

}
