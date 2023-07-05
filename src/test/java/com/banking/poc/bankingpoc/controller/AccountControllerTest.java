package com.banking.poc.bankingpoc.controller;
import com.banking.poc.bankingpoc.dto.AccountDto;
import com.banking.poc.bankingpoc.dto.TransactionRequestDto;
import com.banking.poc.bankingpoc.entity.Account;
import com.banking.poc.bankingpoc.entity.Transaction;
import com.banking.poc.bankingpoc.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class AccountControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();
    private static final String USER_ID="1";
    private static final String BASIC_ENDPOINT="/";
    private static final String CREDIT_ENDPOINT=BASIC_ENDPOINT+USER_ID+"/credit";
    private static final String DEBIT_ENDPOINT=BASIC_ENDPOINT+USER_ID+"/debit";
    private static final String TRANSACTION_ENDPOINT="/transaction";

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private MockMvc mockMvc;

    private Account dummyAccount;

    @BeforeEach
    void setup()
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        dummyAccount=new Account();
        dummyAccount.setId(Long.parseLong(USER_ID));
        dummyAccount.setAccountHolderName("XYZ");
        dummyAccount.setAccountNumber("1234");
        dummyAccount.setAccountEmail("xyz@gmail.com");
        dummyAccount.setAccountMobileNumber("91XXXXXXXX");
        dummyAccount.setAccountBalance(199990);

    }
    @Test
    void getAccountByIdTest() throws Exception {
        when(accountService.getAccountById(Long.parseLong(USER_ID))).thenReturn(dummyAccount);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/1").param("id","1").
                contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(objectWriter
                        .writeValueAsString(USER_ID))).andExpect(status().isOk());
    }

    @Test
    void createAccountTest()
    {
        AccountDto accountDto=new AccountDto();
        accountDto.setCustomerId(Long.parseLong("1"));
        accountDto.setAccountHolderName("XYZ");
        accountDto.setAccountNumber("1234");
        accountDto.setAccountEmail("xyz@gmail.com");
        accountDto.setAccountMobileNumber("91XXXXXXXX");
        accountDto.setAccountBalance(199990);
        when(accountService.createAccount(accountDto)).thenReturn(dummyAccount);

    }

    @Test
    void deleteAccountTest() throws Exception {
        Long negativeCaseUserId=3L;
        when(accountService.deleteAccount(Long.parseLong(USER_ID))).thenReturn(true);
        when (accountService.deleteAccount(negativeCaseUserId)).thenReturn(false);

    }
    @Test
    void creditAccountTest() throws Exception {
        Long ammount=100L;
        when(accountService.creditAccount(Long.parseLong(USER_ID),ammount)).thenReturn(dummyAccount);

    }

    @Test
    void debitAccountTest() throws Exception {
        Long ammount=100L;
        when(accountService.debitAccount(Long.parseLong(USER_ID),ammount)).thenReturn(dummyAccount);
    }
    @Test
    void debitTransactionTest() throws Exception {
        AccountDto accountDto=new AccountDto();
        accountDto.setCustomerId(Long.parseLong("1"));
        accountDto.setAccountHolderName("XYZ");
        accountDto.setAccountNumber("1234");
        accountDto.setAccountEmail("xyz@gmail.com");
        accountDto.setAccountMobileNumber("91XXXXXXXX");
        accountDto.setAccountBalance(199990);
        TransactionRequestDto transactionRequestDto=new TransactionRequestDto();
        transactionRequestDto.setAccountDto(accountDto);
        transactionRequestDto.setAmount(100L);
        transactionRequestDto.setTransactionMethod(Transaction.ATM);
        when(accountService.debitTransaction(transactionRequestDto)).thenReturn(dummyAccount);
    }

}
