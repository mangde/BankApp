package com.nuance.him.dao.account;

import com.nuance.him.dao.daoexception.InterestDaoException;
import com.nuance.him.model.accountmodel.InterestCalculator;

/**
 * interface class.
 */
public interface SpringInterestCalcDao {

    /**
     * Calculates the total interest and adds the monthly interest to the balance.
     * @param interestCalculator instance of class {@link InterestCalculator}
     * @return monthly interest calculated
     */
    double calculateMonthlyInterest(InterestCalculator interestCalculator)throws InterestDaoException;


}