package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetController {

    private final IGetService getService;

    public GetController(IGetService getService) {
        this.getService = getService;
    }

    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers() {
        return getService.getCustomers();
    }
}
