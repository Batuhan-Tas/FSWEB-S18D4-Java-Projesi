package com.workintech.S18D4.service;

import com.workintech.S18D4.entity.Address;
import com.workintech.S18D4.repository.AddressRepository;

import java.util.List;

public interface AddressService {


    List<Address> findAll();
    Address find(int id);

    Address save(Address address);

    void delete(Address address);
}
