package com.vcakitchen.controller;

import com.vcakitchen.request.CustomerRequest;
import com.vcakitchen.response.CustomerResponse;
import com.vcakitchen.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Controller Class is the entry point of the application
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerServices costumerServices;

    @Autowired
    public CustomerController(CustomerServices costumerServices) {
        this.costumerServices = costumerServices;
    }

    //This is the PostMapping annotation used for adding a new costumer.
    @PostMapping("/add")
    public ResponseEntity<?> createCostumer(@RequestBody CustomerRequest costumerRequest) {
        CustomerResponse costumerResponse = new CustomerResponse(costumerServices.createCostumer(costumerRequest));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(costumerResponse);
    }

    //GetMapping is used from getting  the customers from DataBase
    @GetMapping("/get")
    public ResponseEntity<?> getAllCostumers(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(costumerServices.getAllCostumers());
    }
}
