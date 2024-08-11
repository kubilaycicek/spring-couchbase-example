package com.kubilaycicek.customer_service.service;

import com.kubilaycicek.customer_service.dto.CustomerDTO;

import java.util.List;


public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getList();
}
