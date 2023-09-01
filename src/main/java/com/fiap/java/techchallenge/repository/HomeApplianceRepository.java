package com.fiap.java.techchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.fiap.java.techchallenge.entity.HomeAppliance;

public interface HomeApplianceRepository
    extends JpaRepository<HomeAppliance, Long>, JpaSpecificationExecutor<HomeAppliance> {

}
