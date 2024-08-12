package com.kubilaycicek.customer_service.service;

import com.kubilaycicek.customer_service.api.payload.dto.CustomerDTO;

import java.util.List;


public interface CustomerService {
    CustomerDTO saveCustomerDTO(CustomerDTO customerDTO);

    CustomerDTO updateCustomerDTO(CustomerDTO customerDTO);

    List<CustomerDTO> getCustomerDTOList();

    CustomerDTO getCustomerById(String id);

    void deleteCustomerById(String id);
}
