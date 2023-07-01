package com.example.Services;

import com.example.CustomerRepository;
import com.example.Interfaces.IUpdateService;
import com.example.Models.Customer;
import org.springframework.stereotype.Service;

@Service
public class UpdateService implements IUpdateService {

    private final CustomerRepository customerRepository;

    public UpdateService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void updateCustomer(Integer id, Customer customerFromRequest) {
        Customer customer = customerRepository.getReferenceById(id);
        customer.setName(customerFromRequest.getName());
        customer.setAge(customerFromRequest.getAge());
        customer.setEmail(customerFromRequest.getEmail());
        customerRepository.save(customer);
    }
}
