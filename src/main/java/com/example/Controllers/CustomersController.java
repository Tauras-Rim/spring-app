package com.example.Controllers;

import com.example.Interfaces.*;
import com.example.Models.Customer;
import com.example.Models.NewCustomerRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomersController {

    private final ICustomerService customerService;

    public CustomersController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        try {
            return ok(customerService.getCustomers());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer list not found");
        }
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer id){
        try{
            customerService.deleteCustomer(id);
            return ok().body("Customer with id " + id + " deleted successfully");
        }
        catch (EntityNotFoundException e){
            return status(HttpStatus.NOT_FOUND).body("Customer with id " + id + " not found");
        }
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@Valid @RequestBody NewCustomerRequest request) {
        if (request.getAge() == null || request.getName() == null || request.getEmail() == null){
            return badRequest().body("All fields are required");
        }
        customerService.addCustomer(request);
        return ResponseEntity.ok().body("Customer created");
    }

    @PutMapping("{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer id, @Valid @RequestBody Customer customerFromRequest){
        try{
            if (customerFromRequest.getName() == null || customerFromRequest.getEmail() == null || customerFromRequest.getAge() == null){
                return badRequest().body("All fields are required");
            }
            customerService.updateCustomer(id, customerFromRequest);
            return ok().body("Customer with id " + id + " updated");
        } catch (EntityNotFoundException e){
            return status(HttpStatus.NOT_FOUND).body("Customer with id " + id + " not found");
        }
    }
}
