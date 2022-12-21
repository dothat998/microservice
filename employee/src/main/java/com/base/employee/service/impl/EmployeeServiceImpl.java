package com.base.employee.service.impl;

import com.base.employee.entity.Employee;
import com.base.employee.repository.EmployeeRepository;
import com.base.employee.response.EmployeeResponse;
import com.base.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse isEmployeeOfCustomer(Integer CustomerId) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setIsCustomer(false);
        employeeRepository.save(
                Employee.builder()
                        .customerId(CustomerId)
                        .employeeId("Employee 1")
                        .employeeName("Nguyen Do That")
                        .email("dothat998@gmail.com")
                        .build()
        );
        return employeeResponse;
    }
}
