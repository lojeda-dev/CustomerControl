package com.lo.service;

import com.lo.entities.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    void update(Long id);

    void save(Customer customer);

    void deleteById(Long id);
}
