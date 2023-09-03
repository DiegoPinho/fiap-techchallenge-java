package com.fiap.java.techchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.java.techchallenge.entity.Consumption;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {

}
