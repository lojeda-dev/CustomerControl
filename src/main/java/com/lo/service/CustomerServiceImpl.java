package com.lo.service;

import com.lo.entities.Customer;
import com.lo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
