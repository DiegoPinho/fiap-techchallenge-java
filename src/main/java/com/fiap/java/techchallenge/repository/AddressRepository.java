package com.fiap.java.techchallenge.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fiap.java.techchallenge.domain.Address;

@Repository
public class AddressRepository {

  private List<Address> addresses;

  public AddressRepository() {
    this.addresses = new ArrayList<Address>();
  }

  public List<Address> getAll() {
    return this.addresses;
  }

  public Address getById(Integer id) {
    for (Address address : this.addresses) {
      if (address.getId().equals(id)) {
        return address;
      }
    }

    return null;
  }

  public Address save(Address address) {
    this.addresses.add(address);
    return address;
  }

  public void update(Integer id, Address updatedAddress) {
    for (Address address : this.addresses) {
      if (address.getId().equals(id)) {
        address.setCity(updatedAddress.getCity());
        address.setDistrict(updatedAddress.getDistrict());
        address.setNumber(updatedAddress.getNumber());
        address.setState(updatedAddress.getState());
        address.setStreet(updatedAddress.getStreet());
        break;
      }
    }
  }

  public void delete(Integer id) {
    Address addressToRemove = null;

    for (Address address : this.addresses) {
      if (address.getId().equals(id)) {
        addressToRemove = address;
        break;
      }
    }

    if (addressToRemove != null) {
      this.addresses.remove(addressToRemove);
    }
  }

}
