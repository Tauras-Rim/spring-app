package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateController {

    private final ICustomerRepository customerRepository;

    public UpdateController(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PutMapping("/api/v1/customers/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody Customer customerFromRequest){
        Customer customer = customerRepository.getReferenceById(id);
        customer.setName(customerFromRequest.getName());
        customer.setAge(customerFromRequest.getAge());
        customer.setEmail(customerFromRequest.getEmail());
        customerRepository.save(customer);
    }
}
