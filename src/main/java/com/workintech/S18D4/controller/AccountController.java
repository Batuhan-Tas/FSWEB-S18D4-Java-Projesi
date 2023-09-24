package com.workintech.S18D4.controller;

import com.workintech.S18D4.entity.Account;
import com.workintech.S18D4.entity.Address;
import com.workintech.S18D4.entity.Customer;
import com.workintech.S18D4.service.AccountService;
import com.workintech.S18D4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    private CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable int id){
        return accountService.find(id);
    }

    @PostMapping("/{customerId}")
    public Account save(@RequestBody Account account, @PathVariable int customerId){
        Customer customer = customerService.find(customerId);
        customer.add(account);
        account.setCustomer(customer);
        return accountService.save(account);
    }

    @PutMapping("/{customerId}")
    public Account update(@RequestBody Account account, @PathVariable int customerId){
        Customer foundCustomer = customerService.find(customerId);
        Account foundAccount = foundCustomer.getAccountList().stream().filter(account1 -> account1.getId() == account.getId()).collect(Collectors.toList()).get(0);
        int index = foundCustomer.getAccountList().indexOf(foundAccount);
        foundCustomer.getAccountList().set(index,foundAccount);
        account.setCustomer(foundCustomer);
        return accountService.save(account);
    }

    @DeleteMapping("/{customerId}")
    public void save(@PathVariable int id){
        Account foundAccount = accountService.find(id);
        accountService.delete(foundAccount);
    }
}
