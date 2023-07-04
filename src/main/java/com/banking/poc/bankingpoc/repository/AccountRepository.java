package com.banking.poc.bankingpoc.repository;

import com.banking.poc.bankingpoc.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account , Long> {
}
