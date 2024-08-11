package com.kubilaycicek.customer_service.api.controller;

import com.kubilaycicek.customer_service.api.data.request.SaveCustomerRequest;
import com.kubilaycicek.customer_service.api.data.response.GetCustomerListResponse;
import com.kubilaycicek.customer_service.api.data.response.SaveCustomerResponse;
import com.kubilaycicek.customer_service.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("api/v1/customer"))
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public ResponseEntity<GetCustomerListResponse> getCustomerList() {
        return ResponseEntity.ok(new GetCustomerListResponse(customerService.getList()));
    }

    @PostMapping("")
    public ResponseEntity<SaveCustomerResponse> getCustomerList(@RequestBody SaveCustomerRequest saveCustomerRequest) {
        return ResponseEntity.ok(new SaveCustomerResponse(customerService.saveCustomer(saveCustomerRequest.customerDTO())));
    }
}
