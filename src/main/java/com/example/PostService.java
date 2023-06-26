package com.example;

import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

    private final CustomerRepository customerRepository;

    public PostService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());
        customerRepository.save(customer);
    }
}
