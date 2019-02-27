package com.nuance.him.service.account;

import com.nuance.him.model.accountmodel.InterestCalculator;
import com.nuance.him.service.serviceexception.InterestServiceException;

/**
 * InterestCalService Interface.
 */
public interface InterestCalculatorService {

    /**
     * Calculates the total interest and adds the monthly interest to the balance.
     * @param interestCalculator instance of class {@link InterestCalculator}
     *
     * @return monthly interest calculated
     * @throws InterestServiceException
     */
    double calculateMonthlyInterest(InterestCalculator interestCalculator)throws InterestServiceException;


}
