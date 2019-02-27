package com.nuance.him.service;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.dao.account.SpringInterestCalcDao;
import com.nuance.him.dao.daoexception.InterestDaoException;
import com.nuance.him.model.accountmodel.InterestCalculator;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.account.InterestCalculatorService;
import com.nuance.him.service.account.InterestCalculatorServiceImpl;
import com.nuance.him.service.serviceexception.InterestServiceException;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * test class of Interest Service class.
 */
public class InterestServiceimplTest {

    private static final double BALANCE = 500.00;
    private static final int INTEREST_RATE = 4;
    private static final int ACCOUNT_NUMBER = 3;
    @Mock
    private SpringInterestCalcDao springInterestCalcDao;
    @Mock
    private AccountService accountService;
    private InterestCalculatorService interestCalculatorService;
    private InterestCalculator interestCalculator;

    /**
     * initial setup.
     */
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        interestCalculatorService = new InterestCalculatorServiceImpl(springInterestCalcDao, accountService);
        interestCalculator = new InterestCalculator(ACCOUNT_NUMBER, BALANCE, INTEREST_RATE);
    }

    /**
     * test InterestCalculator Method.
     * @throws Exception exception if fail.
     */

    @Test
    public void testInterestRateCalculator() throws Exception {
        when(springInterestCalcDao.calculateMonthlyInterest(any(InterestCalculator.class))).thenReturn(BALANCE);
        when(accountService.depositeAmount(anyInt(), anyDouble())).thenReturn(BALANCE);
        double intrest = interestCalculatorService.calculateMonthlyInterest(interestCalculator);
        assertNotNull(intrest, "interest should not be null");
        verify(springInterestCalcDao, atMost(2)).calculateMonthlyInterest(interestCalculator);
    }

    /**
     * test exception thrown by method interest calculator.
     *
     * @throws Exception is {@link InterestServiceException}
     */
    @Test(expectedExceptions = InterestServiceException.class)
    public void testGetBalanceException() throws Exception {
        doThrow(InterestDaoException.class).when(springInterestCalcDao).calculateMonthlyInterest(anyObject());
        try {
            double intrest = interestCalculatorService.calculateMonthlyInterest(interestCalculator);
        }
        catch (final InterestServiceException interestServiceException) {
            assertEquals(interestServiceException.getCause().getClass(), InterestDaoException.class);
            verify(springInterestCalcDao).calculateMonthlyInterest(interestCalculator);
            throw interestServiceException;
        }
    }
}
