package com.workintech.S18D4.controller;

import com.workintech.S18D4.entity.Address;
import com.workintech.S18D4.entity.Customer;
import com.workintech.S18D4.service.AddressService;
import com.workintech.S18D4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable int id){
        return customerService.find(id);
    }

    @PostMapping("/")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable int id){
        Customer customerAdress = findById(id);
        if(customerAdress!=null){
            customer.setId(id);
            return customerService.save(customer);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void save(@PathVariable int id){
        Customer foundCustomer = customerService.find(id);
        customerService.delete(foundCustomer);
    }
}
