/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.controller.customer;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.nuance.him.controller.exception.CustomErrorType;
import com.nuance.him.model.customermodel.Customer;
import com.nuance.him.service.customer.CustomerService;
import com.nuance.him.service.serviceexception.CustomerServiceException;
import java.util.List;
import java.util.Set;

/**
 * CustomerController.
 */
@RestController
@RequestMapping("${baseURL}")
@Validated
public class CustomerController {

    private static final String ADD_CUSTOMER = "/addCustomer";
    private static final String DISPLAY_CUSTOMERS = "/displayCustomer";
    private final CustomerService customerService;

    /**
     * constructor for assign bean of {@link CustomerService}.
     *
     * @param customerService instance of {@link CustomerService}
     */
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Request Method to add New Customer.
     *
     * @param name name of customer
     * @param address address
     * @param city city
     * @param phone mobile
     * @return new generated CustomerId
     */
    @RequestMapping(value = CustomerController.ADD_CUSTOMER, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Customer> addNewCustomer(
        @RequestParam("name") @Pattern(regexp = "[a-z A-z]+", message = "Name should contain Alphabets only") String name,
        @RequestParam("address") String address,
        @RequestParam("city") @Pattern(regexp = "[a-z A-z]+", message = "City should contain Alphabets only") String city,
        @RequestParam("phone") @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone should 10 digits only") String phone) {
        try {
            int customerId = customerService.addCustomer(new Customer(name, Long.parseLong(phone), address, city));
            return new ResponseEntity("Customer is registered successfully\n" + " customerID: " + customerId, HttpStatus.CREATED);
        }
        catch (NumberFormatException nfe) {
            return new ResponseEntity(new CustomErrorType(nfe.getCause().getMessage()), HttpStatus.BAD_REQUEST);
        }
        catch (CustomerServiceException e) {
            return new ResponseEntity(new CustomErrorType("Error in  Add customer"), HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Displays all customers.
     *
     * @return all customer details
     */
    @RequestMapping(value = CustomerController.DISPLAY_CUSTOMERS, method = RequestMethod.GET)
    public ResponseEntity<Customer> displayCustomers() {
        List<Customer> customerList;
        try {
            customerList = customerService.getAllCustomers();
        }
        catch (CustomerServiceException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(customerList, HttpStatus.OK);
    }

    /**
     * exception validation handler.
     *
     * @param exception exception
     * @return message
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(ConstraintViolationException exception) {
        String message = "";
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            message += violation.getMessage().concat(";");
        }
        return message;
    }
}
