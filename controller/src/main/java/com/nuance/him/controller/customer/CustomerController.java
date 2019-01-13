/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.controller.customer;

import com.nuance.him.controller.exception.CustomErrorType;
import com.nuance.him.model.customermodel.Customer;
import com.nuance.him.service.customer.CustomerService;
import com.nuance.him.service.serviceexception.CustomerServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@PropertySource(value = {"classpath:application.properties"})
@RequestMapping(value = "${baseURL}")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private static final String ADD_CUSTOMER = "/addCustomer";
    private static final String DISPLAY_CUSTOMERS="/displayCustomer";
    private final CustomerService customerService;

    /**
     * constructor for assign bean of {@link CustomerService}
     * @param customerService instance of {@link CustomerService}
     */
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * method to add customer
     * @param name name of customer
     * @param address address
     * @param city city
     * @param phone mobile
     * @return  CustomerId
     */

    @RequestMapping(value = CustomerController.ADD_CUSTOMER, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Customer>addNewCustomer(@Valid @RequestParam("name") @Min(5)  String name,
        @RequestParam("address") @Valid @Min(5) String address,@Valid @RequestParam("city") @Min(5)  String city,
        @RequestParam("phone")  @Valid  String phone) {

        try {

            int customerId = customerService.addCustomer(new Customer(name,Long.parseLong(phone), address, city));
            return new ResponseEntity("Customer is registered successfully\n" +
                    " customerID: " + customerId, HttpStatus.CREATED);

        }catch (NumberFormatException nfe){
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
    @RequestMapping(value = CustomerController.DISPLAY_CUSTOMERS,method = RequestMethod.GET)
    public ResponseEntity displayCustomers() {
        List<Customer> customerList;
        try {
            customerList=customerService.getAllCustomers();
        } catch (CustomerServiceException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(customerList,HttpStatus.OK);
    }



    /**
     * @param ex instance of exception class
     * @return exception message
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
    }

}
