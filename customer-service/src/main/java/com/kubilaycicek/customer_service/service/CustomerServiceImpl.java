package com.kubilaycicek.customer_service.service;

import com.kubilaycicek.customer_service.dto.CustomerDTO;
import com.kubilaycicek.customer_service.model.Customer;
import com.kubilaycicek.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(new Customer(customerDTO.id(), customerDTO.name(), customerDTO.surname(), customerDTO.email()));
        return new CustomerDTO(customer.getId(), customerDTO.name(), customerDTO.surname(), customerDTO.email());
    }

    @Override
    public List<CustomerDTO> getList() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        customerRepository.findAll().forEach(item -> {
            customerDTOList.add(new CustomerDTO(item.getId(), item.getName(), item.getSurname(), item.getEmail()));
        });

        return customerDTOList;
    }

}
