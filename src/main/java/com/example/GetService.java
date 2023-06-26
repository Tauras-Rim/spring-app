package com.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetService implements IGetService{

    private final CustomerRepository customerRepository;

    public GetService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
