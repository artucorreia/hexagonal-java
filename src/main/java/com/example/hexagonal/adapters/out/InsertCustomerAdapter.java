package com.example.hexagonal.adapters.out;

import com.example.hexagonal.adapters.out.repository.CustomerRepository;
import com.example.hexagonal.adapters.out.repository.mapper.CustomerMapper;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  @Autowired
  public InsertCustomerAdapter(
      CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public void insert(Customer customer) {
    customerRepository.save(customerMapper.toCustomerEntity(customer));
  }
}
