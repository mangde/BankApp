package com.nuance.him.service.account;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.nuance.him.dao.account.SpringInterestCalcDao;
import com.nuance.him.dao.daoexception.InterestDaoException;
import com.nuance.him.model.accountmodel.InterestCalculator;
import com.nuance.him.service.serviceexception.AccountServiceException;
import com.nuance.him.service.serviceexception.InterestServiceException;

/**
 * implement InterestCalculator interface.
 */
public class InterestCalculatorServiceImpl implements InterestCalculatorService {

    private SpringInterestCalcDao springInterestCalcDao;
    private AccountService accountService;

    /**
     * constructor for setting bean values.
     * @param springInterestCalcDao instance of dao class {@link SpringInterestCalcDao}
     * @param accountService instance of {@link com.nuance.him.model.accountmodel.Account} class
     */
    public InterestCalculatorServiceImpl(final SpringInterestCalcDao springInterestCalcDao, final AccountService accountService) {
        this.accountService = accountService;
        this.springInterestCalcDao = springInterestCalcDao;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
    public double calculateMonthlyInterest(InterestCalculator interestCalculator) throws InterestServiceException {
        try {
            double monthlyInterest = interestCalculator.getBalance() * interestCalculator.getMonthlyInterestRate();
            interestCalculator.setMonthlyInterest(monthlyInterest);
            accountService.depositeAmount(interestCalculator.getAccNumber(), monthlyInterest);
            return springInterestCalcDao.calculateMonthlyInterest(interestCalculator);
        }
        catch (InterestDaoException interestDaoException) {
            throw new InterestServiceException("exception in Interest  service", interestDaoException);
        }
        catch (AccountServiceException accountException) {
            throw new InterestServiceException("exception in Account service", accountException);
        }
    }
}