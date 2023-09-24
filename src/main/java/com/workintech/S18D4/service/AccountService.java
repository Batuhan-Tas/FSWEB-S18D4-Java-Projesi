package com.workintech.S18D4.service;

import com.workintech.S18D4.entity.Account;
import com.workintech.S18D4.entity.Customer;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account find(int id);

    Account save(Account account);

    void delete(Account account);
}
