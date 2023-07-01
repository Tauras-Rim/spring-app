package com.example.Controllers;

import com.example.*;
import com.example.Interfaces.IDeleteService;
import com.example.Interfaces.IGetService;
import com.example.Interfaces.IPostService;
import com.example.Interfaces.IUpdateService;
import com.example.Models.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/customers")
public class CustomersController {

    private final IGetService getService;
    private final IDeleteService deleteService;
    private final IPostService postService;
    private final IUpdateService updateService;

    public CustomersController(IGetService getService, IDeleteService deleteService, IPostService postService, IUpdateService updateService) {
        this.getService = getService;
        this.deleteService = deleteService;
        this.postService = postService;
        this.updateService = updateService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return getService.getCustomers();
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer id){
        deleteService.deleteCustomer(id);
        return ok().body("Customer with id " + id + " deleted successfully");
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody NewCustomerRequest request) {
        postService.addCustomer(request);
        return ResponseEntity.ok().body("Customer created");
    }

    @PutMapping("{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer id, @RequestBody Customer customerFromRequest){
        updateService.updateCustomer(id, customerFromRequest);
        return ok().body("Customer with id " + id + " updated");
    }
}
