package com.lo.service;

import com.lo.entities.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    Customer update(Long id, Customer customer);

    Customer save(Customer customer);

    void deleteById(Long id);
}
