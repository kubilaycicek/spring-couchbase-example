package com.kubilaycicek.customer_service.api.data.request;

import com.kubilaycicek.customer_service.dto.CustomerDTO;

public record SaveCustomerRequest(CustomerDTO customerDTO) {
}
