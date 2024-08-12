package com.kubilaycicek.customer_service.api.controller;

import com.kubilaycicek.customer_service.api.payload.request.*;
import com.kubilaycicek.customer_service.api.payload.response.*;
import com.kubilaycicek.customer_service.service.CustomerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("api/v1/customer"))
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<SaveCustomerResponse> saveCustomer(@RequestBody SaveCustomerRequest saveCustomerRequest) {
        return ResponseEntity.ok(new SaveCustomerResponse(customerService.saveCustomerDTO(saveCustomerRequest.customerDTO())));
    }

    @PutMapping
    public ResponseEntity<SaveCustomerResponse> updateCustomer(@RequestBody SaveCustomerRequest saveCustomerRequest) {
        return ResponseEntity.ok(new SaveCustomerResponse(customerService.saveCustomerDTO(saveCustomerRequest.customerDTO())));
    }

    @DeleteMapping("{id}")
    public void deleteCustomerById(@PathVariable(name = "id") String id) {
        customerService.deleteCustomerById(id);
    }

    @Cacheable(cacheNames = "CustomerList", key = "#CustomerList+#id")
    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerResponse> getCustomer(@PathVariable String id) {
        return ResponseEntity.ok(new GetCustomerResponse(customerService.getCustomerById(id)));
    }

    @Cacheable(cacheNames = "CustomerList", key = "#CustomerList")
    @GetMapping("/list")
    public ResponseEntity<GetCustomerListResponse> getCustomerList() {
        return ResponseEntity.ok(new GetCustomerListResponse(customerService.getCustomerDTOList()));
    }
}
