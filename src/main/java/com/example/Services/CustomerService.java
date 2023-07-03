package com.example.Services;

import com.example.CustomerRepository;
import com.example.Interfaces.ICustomerService;
import com.example.Models.Customer;
import com.example.Models.NewCustomerRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void deleteCustomer(Integer id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }
    }

    public List<Customer> getCustomers() {
        var customerList = customerRepository.findAll();

        if (!customerList.isEmpty()){
            return customerList;
        }
        throw new EntityNotFoundException("Customer list not found");
    }

    public void addCustomer(NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customerFromRequest) {
        if(customerRepository.existsById(id)) {
            Customer customer = customerRepository.getReferenceById(id);
            customer.setName(customerFromRequest.getName());
            customer.setAge(customerFromRequest.getAge());
            customer.setEmail(customerFromRequest.getEmail());
            customerRepository.save(customer);
        } else {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }

    }
}
