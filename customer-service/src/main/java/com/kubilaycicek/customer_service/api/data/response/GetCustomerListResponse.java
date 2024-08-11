package com.kubilaycicek.customer_service.api.data.response;

import com.kubilaycicek.customer_service.dto.CustomerDTO;

import java.util.List;

public record GetCustomerListResponse(List<CustomerDTO> customerDTOList) { }