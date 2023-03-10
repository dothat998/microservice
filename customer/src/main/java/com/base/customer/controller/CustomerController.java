package com.base.customer.controller;

import com.base.customer.request.CustomerRequest;
import com.base.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest) throws IllegalAccessException {
        log.info("New customer registration{}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
    @GetMapping("/all")
    public String abc(){
        return "this is Customer";
    }
}
