package com.kubilaycicek.customer_service.api.payload.response;

import com.kubilaycicek.customer_service.api.payload.dto.CustomerDTO;

import java.util.List;

public record GetCustomerListResponse(List<CustomerDTO> customerDTOList) { }