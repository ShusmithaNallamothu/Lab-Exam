package com.klef.jfsd.exam.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.models.Customer;
import com.klef.jfsd.exam.repository.CustomerRepository;
import com.klef.jfsd.exam.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer updateCustomer(Long id, String name, String address) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.setName(name);
            customer.setAddress(address);
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }
}
