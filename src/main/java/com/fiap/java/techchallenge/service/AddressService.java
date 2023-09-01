package com.fiap.java.techchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.java.techchallenge.controller.criterias.AddressCriteria;
import com.fiap.java.techchallenge.controller.dto.AddressDTO;
import com.fiap.java.techchallenge.entity.Address;
import com.fiap.java.techchallenge.entity.User;
import com.fiap.java.techchallenge.repository.AddressRepository;
import com.fiap.java.techchallenge.repository.UserRepository;

@Service
public class AddressService {

  @Autowired
  AddressRepository repository;

  @Autowired
  private UserRepository userRepository;

  public List<Address> getAll(AddressCriteria criteria) {
    Specification<Address> specification = criteria.toSpecification();
    return this.repository.findAll(specification);
  }

  public Address getById(Long id) {
    return this.repository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Address Not Found!"));
  }

  public Address create(Long userId, AddressDTO addressDTO) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("User Not Found!"));

    Address address = addressDTO.toAddress();
    address.setUser(user);
    return this.repository.save(address);
  }

  public void update(Long id, AddressDTO addressDTO) {
    this.getById(id); // checks if exists

    Address address = addressDTO.toAddress();
    address.setId(id);
    this.repository.save(address);
  }

  public void delete(Long id) {
    this.getById(id); // checks if exists
    this.repository.deleteById(id);
  }

}
