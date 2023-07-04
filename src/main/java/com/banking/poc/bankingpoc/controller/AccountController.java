package com.banking.poc.bankingpoc.controller;

import com.banking.poc.bankingpoc.dto.AccountDto;
import com.banking.poc.bankingpoc.entity.Account;
import com.banking.poc.bankingpoc.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Valid AccountDto accountDto) {
        Account createdAccount = accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        boolean deleted = accountService.deleteAccount(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/credit")
    public ResponseEntity<Account> creditAccount(@PathVariable Long id, @RequestBody double amount) {
        Account creditedAccount = accountService.creditAccount(id, amount);
        if (creditedAccount != null) {
            return ResponseEntity.ok(creditedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/debit")
    public ResponseEntity<Account> debitAccount(@PathVariable Long id, @RequestBody double amount) {
        try {
            Account debitedAccount = accountService.debitAccount(id, amount);
            return ResponseEntity.ok(debitedAccount);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
