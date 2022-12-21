package com.base.customer.service.impl;

import com.base.customer.repository.CustomerRepository;
import com.base.customer.entity.Customer;
import com.base.customer.request.CustomerRequest;
import com.base.customer.response.EmployeeResponse;
import com.base.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

    public CustomerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void registerCustomer(CustomerRequest customerRequest) throws IllegalAccessException {
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);
        //check call api bên Employee
        EmployeeResponse rest = restTemplate.getForObject(
                "http://localhost:8081/api/v1/employee/{cusId}",
                EmployeeResponse.class,
                customer.getId()
        );

        if (rest.getIsCustomer() == false ){
            throw new IllegalAccessException("Employee");
        }
    }
}
