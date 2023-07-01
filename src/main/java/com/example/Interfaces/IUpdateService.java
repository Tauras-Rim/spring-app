package com.example.Interfaces;

import com.example.Models.Customer;

public interface IUpdateService {

    void updateCustomer(Integer id, Customer customerFromRequest);
}
