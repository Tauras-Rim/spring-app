package com.example.interfaces;

import com.example.models.Customer;

import java.util.List;

public interface ICustomerService {

    void deleteCustomer(Integer id);

    List<Customer> getCustomers();

    void addCustomer(Customer request);

    void updateCustomer(Integer id, Customer customerFromRequest);
}
