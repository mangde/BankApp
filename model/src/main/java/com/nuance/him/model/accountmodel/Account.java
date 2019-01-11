/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.model.accountmodel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Account {



    @Id
    @GeneratedValue
    private int accountNo;
    private String type;
    private double balance;
    private int customerId;

    public Account(String type, double balance, int customerId) {
        this.type = type;
        this.balance = balance;
        this.customerId = customerId;
    }

    public String getType() {
        return this.type;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getCustomerId() {
        return this.customerId;
    }
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
}
