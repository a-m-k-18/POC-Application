package com.banking.poc.bankingpoc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDto {

    private String accountNumber;
    @NotNull(message = "Username should not be null")
    private String accountHolderName;
    @Email(message = "Invalid Email Address")
    private String accountEmail;
    @NotNull
    @Pattern(regexp = "^\\d{10}$" , message = "Invalid Mobile Number Entered")
    private String accountMobileNumber;
    private double accountBalance;
}
