package com.example.services;

import com.example.repositories.CustomerRepository;
import com.example.interfaces.CustomerMapper;
import com.example.interfaces.ICustomerService;
import com.example.models.Customer;
import com.example.models.CustomerDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public void deleteCustomer(Integer id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }
    }

    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toDTO)
                .toList();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            customer.setId(customer.getId());
            customerRepository.save(customer);
        } else {
            throw new EntityNotFoundException("Customer with id " + customer.getId() + " not found");
        }
    }
}
