package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.dto.CustomerDetailsDto;
import com.eazybytes.accounts.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for CustomerDetails in Eazybank",
        description = "CRUD REST APIs in Eazybank to CREATE, UPDATE, FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @GetMapping("/fetch_customer_details")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
            @RequestParam String mobileNumber) {
        logger.debug("fetchCustomerDetails method start");
        CustomerDetailsDto customerDetailsDto = customerService.fetchCustomerDetails(mobileNumber);
        logger.debug("fetchCustomerDetails method end");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDetailsDto);
    }

}
