package com.workintech.S18D4.service;

import com.workintech.S18D4.entity.Address;
import com.workintech.S18D4.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer find(int id);

    Customer save(Customer customer);

    void delete(Customer customer);
}
