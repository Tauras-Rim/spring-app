package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetController {

    private final ICustomerRepository customerRepository;

    public GetController(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
