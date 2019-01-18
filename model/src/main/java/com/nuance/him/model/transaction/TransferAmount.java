/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.model.transaction;

import javax.persistence.Id;
import java.sql.Date;

/**
 * {@link TransferAmount} model class.
 */
public class TransferAmount {

    @Id
    private int transactionId;
    private final int accIdFrom;
    private final int accIdTo;
    private final double amount;
    private final String description;
    private Date date;

    /**
     * constructor of class {@link TransferAmount}.
     *
     * @param accIdFrom Debit Account number
     * @param accIdTo credit Account Number
     * @param amount Amount
     * @param description Description
     */
    public TransferAmount(final int accIdFrom, final int accIdTo, final double amount, final String description) {
        this.accIdFrom = accIdFrom;
        this.accIdTo = accIdTo;
        this.amount = amount;
        this.description = description;
    }

    /**
     * get TransferAmount Id.
     *
     * @return TransactionId
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * setTransactionId.
     *
     * @param transactionId TransactionId
     */
    public void setTransactionId(final int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * get Debit account Number.
     *
     * @return Debit AccountNumber
     */
    public int getAccIdFrom() {
        return accIdFrom;
    }

    /**
     * get credit account Number.
     *
     * @return credit AccountNumber
     */
    public int getAccIdTo() {
        return accIdTo;
    }

    /**
     * get Date of transaction.
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * set date of transaction.
     *
     * @param date date
     */
    public void setDate(final Date date) {
        this.date = date;
    }

    /**
     * get amount.
     *
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * get description.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "TransferAmount{" +
            "transactionId=" + transactionId +
            ", accIdFrom=" + accIdFrom +
            ", accIdTo=" + accIdTo +
            ", date=" + date +
            ", amount=" + amount +
            ", description='" + description + '\'' +
            '}';
    }
}
