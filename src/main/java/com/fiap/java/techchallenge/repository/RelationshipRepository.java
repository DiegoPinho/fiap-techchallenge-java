package com.fiap.java.techchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.java.techchallenge.entity.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {

}
