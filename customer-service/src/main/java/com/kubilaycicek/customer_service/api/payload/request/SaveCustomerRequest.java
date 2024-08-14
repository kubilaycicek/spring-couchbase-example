package com.kubilaycicek.customer_service.api.payload.request;

import com.kubilaycicek.customer_service.api.payload.dto.CustomerDTO;

public record SaveCustomerRequest(CustomerDTO customerDTO) { }
