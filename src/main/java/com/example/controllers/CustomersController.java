package com.example.controllers;

import com.example.interfaces.*;
import com.example.models.Customer;
import com.example.models.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomersController {

    private final ICustomerService customerService;

    public CustomersController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        return ok(customerService.getCustomers());
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody @Valid Customer request) {
        customerService.addCustomer(request);
        return ok("Customer created");
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        return ok("Customer with id " + customerId + " deleted successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody @Valid Customer customer) {
        customerService.updateCustomer(customer);
        return ok("Customer with id " + customer.getId() + " updated");
    }
}
