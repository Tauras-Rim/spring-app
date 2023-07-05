package com.example.services;

import com.example.CustomerRepository;
import com.example.interfaces.ICustomerService;
import com.example.models.Customer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void deleteCustomer(Integer id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            customerRepository.save(customer);
        } else {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }

    }
}
