package com.banking.poc.bankingpoc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="accounts")
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String accountHolderName;
    private String accountEmail;
    private String accountMobileNumber;
    private double accountBalance;

    public void credit(double amount) {
        this.accountBalance += amount;
    }

    public void debit(double amount) throws Exception {
        if (this.accountBalance >= amount) {
            this.accountBalance -= amount;
        } else {
            throw new Exception("Insufficient funds in the account.");
        }
    }

}
