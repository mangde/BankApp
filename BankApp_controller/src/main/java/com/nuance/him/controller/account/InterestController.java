package com.nuance.him.controller.account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.nuance.him.controller.exception.CustomErrorType;
import com.nuance.him.dao.daoexception.AccountDaoException;
import com.nuance.him.model.accountmodel.InterestCalculator;
import com.nuance.him.service.account.InterestCalculatorService;
import com.nuance.him.service.serviceexception.InterestServiceException;

/**
 * controller class of interest calculator.
 */
@RestController
@RequestMapping("${baseURL}")
public class InterestController {

    private static final String CAL_MONTHLY_INTEREST = "/calMonthlyInterest";
    private final InterestCalculatorService interestCalculatorService;

    /**
     * constructor of class {@link InterestController}.
     * @param interestCalculatorService interestCalculatorService
     */
    public InterestController(InterestCalculatorService interestCalculatorService) {
        this.interestCalculatorService = interestCalculatorService;
    }

    /**
     * @param interestCalculator instance of class {@link InterestCalculator}.
     * @return monthly interest calculated
     */
    @RequestMapping(value = CAL_MONTHLY_INTEREST, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> addMonthlyInterest(@RequestBody final InterestCalculator interestCalculator) {
        try {
            System.out.println(interestCalculator.toString());
            final double monthlyInterest = interestCalculatorService.calculateMonthlyInterest(interestCalculator);
            return new ResponseEntity("Customer Account  add monthly interest successfully\n interest : " + monthlyInterest, HttpStatus.CREATED);
        }
        catch (final InterestServiceException interestServiceException) {
            if (interestServiceException.getCause().getCause().getClass().equals(AccountDaoException.class)) {
                return new ResponseEntity<>(new CustomErrorType("failed to deposite interest  check account details" + interestCalculator.getAccNumber()), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(new CustomErrorType("Error in  Add Monthly interest in customer Account " + interestServiceException.getCause().getCause()), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
