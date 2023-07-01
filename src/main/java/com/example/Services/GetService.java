package com.example.Services;

import com.example.CustomerRepository;
import com.example.Interfaces.IGetService;
import com.example.Models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetService implements IGetService {

    private final CustomerRepository customerRepository;

    public GetService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
