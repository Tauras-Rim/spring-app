package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class UpdateController {

    private final IUpdateService updateService;

    public UpdateController(IUpdateService updateService) {
        this.updateService = updateService;
    }

    @PutMapping("/api/v1/customers/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer id, @RequestBody Customer customerFromRequest){
        updateService.updateCustomer(id, customerFromRequest);
        return ok().body("Customer with id " + id + " updated");
    }
}
