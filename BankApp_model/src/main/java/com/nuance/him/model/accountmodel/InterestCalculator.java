package com.nuance.him.model.accountmodel;

/**
 * model class for interestCalculator.
 */
public class InterestCalculator {

    private int accNumber;
    private double balance;
    private double annualInterestRate;
    private double annualInterest;
    private double totalInterest;
    private double monthlyInterest;

    /**
     * default constructor require for @requestBody.
     */
    public InterestCalculator() {
    }

    /**
     * Constructor.
     *
     * @param accNumber account number calculate interest.
     * @param startBalance The account's balance.
     * @param annualInterestRate The annual interest rate.
     */
    public InterestCalculator(final int accNumber,final double startBalance,final double annualInterestRate) {
        this.accNumber = accNumber;
        balance = startBalance;
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * @return The account's balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return The annual interest rate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * @return The monthly interest rate.
     */
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    /**
     * @return The total interest
     */
    public double getTotalnterest() {
        return totalInterest;
    }

    /**
     * setBalance.
     *
     * @param balance balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * setToatal interest earned.
     *
     * @param totalInterest amount
     */
    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    /**
     * Sets the annual interest rate.
     *
     * @param annualInterestRate The annual interest rate.
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * getMonthlyInterest.
     * @return monthlyInterest
     */
    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    /**
     * set monthly interest.
     * @param monthlyInterest interest amount
     */
    public void setMonthlyInterest(final double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    /**
     * getAnnual interest.
     * @return annual Interest.
     */
    public double getAnnualInterest() {
        return annualInterest;
    }

    /**
     * set annualInterest.
     * @param annualInterest annualInterest
     */
    public void setAnnualInterest(final double annualInterest) {
        this.annualInterest = annualInterest;
    }

    /**
     * get Account number.
     * @return account number
     */

    public int getAccNumber() {
        return accNumber;
    }

    @Override
    public String toString() {
        return "InterestCalculator{" +
            "accNumber=" + accNumber +
            ", balance=" + balance +
            ", annualInterestRate=" + annualInterestRate +
            ", annualInterest=" + annualInterest +
            ", totalInterest=" + totalInterest +
            ", monthlyInterest=" + monthlyInterest +
            '}';
    }
}