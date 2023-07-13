package com.example.interfaces;

import com.example.models.Customer;
import com.example.models.CustomerDTO;

import java.util.List;

public interface ICustomerService {

    void deleteCustomer(Integer id);

    List<CustomerDTO> getCustomers();

    void addCustomer(Customer request);

    void updateCustomer(Customer customerFromRequest);
}
