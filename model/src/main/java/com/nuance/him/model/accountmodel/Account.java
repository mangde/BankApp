/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.model.accountmodel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Account POJO class.
 */
public class Account {

    @Id
    @GeneratedValue
    private int accountNo;
    private final String type;
    private final double balance;
    private final int customerId;

    /**
     * Constructor of  Account.
     *
     * @param type Account type
     * @param balance balance
     * @param customerId customerID
     */
    public Account(String type, double balance, int customerId) {
        this.type = type;
        this.balance = balance;
        this.customerId = customerId;
    }

    /**
     * getAccountType.
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * GetBalance.
     *
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * getCustomerId.
     *
     * @return customerID
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * setAccountNumber.
     *
     * @param accountNo accountNumber
     */
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * getAccountNumber.
     *
     * @return accountNumber
     */
    public int getAccountNo() {
        return accountNo;
    }

    @Override
    public String toString() {
        return "Account{" +
            "accountNo=" + accountNo +
            ", type='" + type + '\'' +
            ", balance=" + balance +
            ", customerId=" + customerId +
            '}';
    }
}
