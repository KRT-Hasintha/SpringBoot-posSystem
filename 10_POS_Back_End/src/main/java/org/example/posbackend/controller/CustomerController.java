package org.example.posbackend.controller;

import jakarta.validation.Valid;
import org.example.posbackend.dto.CustomerDto;
import org.example.posbackend.service.impl.CustomerServiceImpl;
import org.example.posbackend.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }


    @PostMapping(consumes = "application/json")
    public ResponseEntity<APIResponse<String>> saveCustomer(@RequestBody @Valid CustomerDto customerDto) {


        customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(new APIResponse<>(201,"Customer Saved", null), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<APIResponse<String>> updateCustomer(@RequestBody @Valid CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);
        return new ResponseEntity<>(new APIResponse<>(200,"Customer Updated", null), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<String>> deleteCustomer(@PathVariable @Valid String id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(new APIResponse<>(200,"Customer Deleted", null));
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
