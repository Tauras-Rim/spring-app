package com.example.Services;

import com.example.CustomerRepository;
import com.example.Interfaces.IDeleteService;
import org.springframework.stereotype.Service;

@Service
public class DeleteService implements IDeleteService {

    private final CustomerRepository customerRepository;

    public DeleteService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
