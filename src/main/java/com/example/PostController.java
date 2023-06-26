package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("api/v1/customers")
    public ResponseEntity<String> addCustomer(@RequestBody NewCustomerRequest request) {
        postService.addCustomer(request);
        return ResponseEntity.ok().body("Customer created");
    }
}
