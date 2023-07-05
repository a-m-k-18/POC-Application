package com.banking.poc.bankingpoc.service;

import com.banking.poc.bankingpoc.dto.AccountDto;
import com.banking.poc.bankingpoc.entity.Account;
import com.banking.poc.bankingpoc.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTest {

    private static final Long USER_ID=1L;
    private static final String ACCOUNT_HOLDERNAME="XYZ";
    private static final String ACCOUNT_NUMBER="1234";
    private static final String EMAIL="xyz@gmail.com";
    private static final String PHONE="91XXXXXXXX";

    @Mock
    private AccountRepository accountRepository;

    @MockBean
    private Account account;

    @MockBean
    private AccountDto accountDto;

    @BeforeEach
    void setup()
    {
        account=new Account();
        accountDto=new AccountDto();
        account.setId(USER_ID);
        accountDto.setCustomerId(USER_ID);
        account.setAccountHolderName(ACCOUNT_HOLDERNAME);
        accountDto.setAccountHolderName(ACCOUNT_HOLDERNAME);
        account.setAccountMobileNumber(PHONE);
        accountDto.setAccountMobileNumber(PHONE);
        account.setAccountEmail(EMAIL);
        accountDto.setAccountEmail(EMAIL);
        account.setAccountBalance(11000);
        accountDto.setAccountBalance(11000);
        account.setAccountNumber(ACCOUNT_NUMBER);
        accountDto.setAccountNumber(ACCOUNT_NUMBER);

    }
    @Test
    void getAccountByIdTesT()
    {
        when(accountRepository.getReferenceById(USER_ID)).thenReturn(account);

    }
    @Test
    void createAccountTest()
    {
        when(accountRepository.save(account)).thenReturn(account);
    }
    @Test
    void deleteAccountTest()
    {
        Assertions.assertTrue(accountRepository.findById(USER_ID)!=null);
    }
}
