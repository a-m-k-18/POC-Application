package com.banking.poc.bankingpoc.dto;

import com.banking.poc.bankingpoc.entity.Transaction;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TransactionRequestDto {
    private Transaction transactionMethod;
    private double amount;
    private AccountDto accountDto;
}
