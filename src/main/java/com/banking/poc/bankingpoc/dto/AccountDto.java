package com.banking.poc.bankingpoc.dto;

import com.banking.poc.bankingpoc.entity.Transaction;
import com.banking.poc.bankingpoc.validator.Conditional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Conditional(selected = "transaction", values = {"BRANCH"}, required = {"accountHolderName","accountMobileNumber"})
@Conditional(selected = "transaction",values="ATM",required = {"accountMobileNumber"})
@Conditional(selected = "transaction",values ="NETBANKING",required ={"accountEmail","accountMobileNumber"})

public class AccountDto {

    @NotNull
    private Long customerId;
    @NotNull
    private String accountNumber;
    private String accountHolderName;
    @NotNull
    private Transaction transaction;
    private String accountEmail;
    @Pattern(regexp = "^\\d{10}$" , message = "Invalid Mobile Number Entered")
    private String accountMobileNumber;
    private double accountBalance;
}
