package com.banking.poc.bankingpoc.entity;

public enum Transaction {
    BRANCH("BRANCH"),
    ATM("ATM"),
    NetBanking("NETBANKING");

    private final String transactionMethod;

    Transaction(String transactionMethod)
    {
        this.transactionMethod=transactionMethod;
    }
}
