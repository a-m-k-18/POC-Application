package com.banking.poc.bankingpoc.service;

import com.banking.poc.bankingpoc.dto.AccountDto;
import com.banking.poc.bankingpoc.dto.TransactionRequestDto;
import com.banking.poc.bankingpoc.entity.Account;
import com.banking.poc.bankingpoc.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account createAccount(AccountDto accountDto) {
        Account account = Account.build(0L, accountDto.getAccountNumber(), accountDto.getAccountHolderName(), accountDto.getAccountEmail(), accountDto.getAccountMobileNumber(), accountDto.getAccountBalance());
        return accountRepository.save(account);
    }


    public boolean deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            accountRepository.delete(account);
            return true;
        }
        return false;
    }

    public Account creditAccount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            account.credit(amount);
            return accountRepository.save(account);
        }
        return null;
    }

    public Account debitAccount(Long id, double amount) throws Exception {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            account.debit(amount);
            return accountRepository.save(account);
        }
        return null;
    }

    public Account debitTransaction(TransactionRequestDto transactionRequestDto) throws Exception {
        Account account=accountRepository.findById(transactionRequestDto.getAccountDto()
                .getCustomerId()).orElse(null);
        if(account!=null){
            account.debit(transactionRequestDto.getAmount());
            return accountRepository.save(account);
        }
        return null;

    }
}
