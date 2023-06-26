package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class DeleteController {

    private final IDeleteService deleteService;

    public DeleteController(IDeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @DeleteMapping("/api/v1/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer id){
        deleteService.deleteCustomer(id);
        return ok().body("Custtomer with id " + id + " deleted successfully");
    }
}
