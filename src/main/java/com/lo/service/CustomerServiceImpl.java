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
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer c = customerRepository.findById(id).orElse(null);

        if (c != null) {
            c.setName(customer.getName());
            c.setSurname(customer.getSurname());
            c.setEmail(customer.getEmail());
            c.setPhone(customer.getPhone());
            c.setBalance(customer.getBalance());
            customerRepository.save(c);
        }
        return c;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
