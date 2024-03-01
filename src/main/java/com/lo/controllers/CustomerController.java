package com.lo.controllers;

import com.lo.entities.Customer;
import com.lo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(customers)
public class CustomerController {

    @Autowired
    ICustomerService service;

    @GetMapping
    public List<Customer> findAll(){
       return service.findAll();
    }
}
