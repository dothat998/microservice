package com.base.employee.controller;

import com.base.employee.response.EmployeeResponse;
import com.base.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping(path = "{cusId}")
    public ResponseEntity<EmployeeResponse> isCheck (@PathVariable("cusId") Integer cusId){
        EmployeeResponse employeeOfCustomer = employeeService.isEmployeeOfCustomer(cusId);
        return ResponseEntity.ok(employeeOfCustomer);
    }
}
