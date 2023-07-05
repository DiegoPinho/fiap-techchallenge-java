package com.fiap.java.techchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.java.techchallenge.controller.dto.AddressDTO;
import com.fiap.java.techchallenge.domain.Address;
import com.fiap.java.techchallenge.repository.AddressRepository;

@Service
public class AddressService {

  @Autowired
  AddressRepository repository;

  public List<Address> getAll() {
    return this.repository.getAll();
  }

  public Address getById(Integer id) {
    Address address = this.repository.getById(id);
    if (address == null) {
      throw new IllegalArgumentException("Address Not Found!");
    }

    return address;
  }

  public Address create(AddressDTO addressDTO) {
    return this.repository.save(addressDTO.toAddress());
  }

  public void update(Integer id, AddressDTO addressDTO) {
    this.getById(id); // checks if exists
    this.repository.update(id, addressDTO.toAddress());
  }

  public void delete(Integer id) {
    this.getById(id);
    this.repository.delete(id);
  }

}
