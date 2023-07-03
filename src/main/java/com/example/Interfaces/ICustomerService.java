package com.example.Interfaces;

import com.example.Models.Customer;
import com.example.Models.NewCustomerRequest;

import java.util.List;

public interface ICustomerService {

    void deleteCustomer(Integer id);

    List<Customer> getCustomers();

    void addCustomer( NewCustomerRequest request);

    void updateCustomer(Integer id, Customer customerFromRequest);
}
