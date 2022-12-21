package com.base.customer.service;

import com.base.customer.request.CustomerRequest;

public interface CustomerService {
    void registerCustomer(CustomerRequest customerRequest) throws IllegalAccessException;
}
