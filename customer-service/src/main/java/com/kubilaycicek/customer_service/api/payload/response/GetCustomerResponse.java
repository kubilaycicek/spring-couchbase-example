package com.kubilaycicek.customer_service.api.payload.response;

import com.kubilaycicek.customer_service.api.payload.dto.CustomerDTO;

public record GetCustomerResponse(CustomerDTO customerDTO) { }