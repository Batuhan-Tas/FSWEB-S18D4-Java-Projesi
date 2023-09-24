package com.workintech.S18D4.repository;

import com.workintech.S18D4.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    
}
