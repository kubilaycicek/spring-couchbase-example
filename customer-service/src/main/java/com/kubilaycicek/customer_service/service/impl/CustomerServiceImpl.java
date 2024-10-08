package com.kubilaycicek.customer_service.service.impl;

import com.kubilaycicek.customer_service.api.payload.dto.CustomerDTO;
import com.kubilaycicek.customer_service.exception.CustomerNotFoundException;
import com.kubilaycicek.customer_service.api.payload.model.Customer;
import com.kubilaycicek.customer_service.repository.CustomerRepository;
import com.kubilaycicek.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDTO saveCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(new Customer(customerDTO.name(), customerDTO.surname(), customerDTO.email(), customerDTO.phone(), customerDTO.address()));

        return new CustomerDTO(customer.getId(), customerDTO.name(), customerDTO.surname(), customerDTO.email(), customer.getPhone(), customer.getAddress());
    }

    @Override
    public CustomerDTO updateCustomerDTO(CustomerDTO customerDTO) {
        Customer customerDb = getCustomerDb(customerDTO.id());
        Customer customer = customerDb;
        customer.setName(customer.getName());
        customer.setEmail(customer.getEmail());
        customer.setSurname(customer.getSurname());
        customerRepository.save(customer);

        return new CustomerDTO(customer.getId(), customerDTO.name(), customerDTO.surname(), customerDTO.email(), customer.getPhone(), customer.getAddress());

    }

    @Override
    public List<CustomerDTO> getCustomerDTOList() {
        return customerRepository.findAll().stream().map(item -> new CustomerDTO(item.getId(), item.getName(), item.getSurname(), item.getEmail(), item.getPhone(), item.getAddress())).toList();

    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        Customer customer = getCustomerDb(id);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getSurname(), customer.getEmail(), customer.getPhone(), customer.getAddress());
    }


    @Override
    public void deleteCustomerById(String id) {
        Customer customerDb = getCustomerDb(id);
        customerRepository.delete(customerDb);
    }

    private Customer getCustomerDb(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer " + id + " not found !"));
    }
}