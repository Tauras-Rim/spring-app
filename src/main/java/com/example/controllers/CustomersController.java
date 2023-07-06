package com.example.controllers;

import com.example.interfaces.*;
import com.example.models.Customer;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<List<Customer>> getCustomers() {
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

    @PutMapping("/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody @Valid Customer customerFromRequest) {
        if (customerFromRequest.getName() == null || customerFromRequest.getEmail() == null || customerFromRequest.getAge() == null) {
            return badRequest().body("All fields are required");
        }
        customerService.updateCustomer(customerId, customerFromRequest);
        return ok("Customer with id " + customerId + " updated");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleException(EntityNotFoundException entityNotFoundException) {
        return notFound().build();
    }
}
