package com.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    private final ICustomerRepository customerRepository;

    public DeleteController(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @DeleteMapping("/api/v1/customers/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }
}
