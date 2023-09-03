package com.fiap.java.techchallenge.entity;

import jakarta.persistence.Column;
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
@Entity(name = "consumptions")
public class Consumption {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "dailyuse")
  private Integer dailyUse;

  @ManyToOne
  @JoinColumn(name = "homeappliance_id")
  private HomeAppliance homeAppliance;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person person;

  public Consumption() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getDailyUse() {
    return dailyUse;
  }

  public void setDailyUse(Integer dailyUse) {
    this.dailyUse = dailyUse;
  }

  public HomeAppliance getHomeAppliance() {
    return homeAppliance;
  }

  public void setHomeAppliance(HomeAppliance homeAppliance) {
    this.homeAppliance = homeAppliance;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

}
