package com.example.hexagonal.adapters.out;

import com.example.hexagonal.adapters.out.repository.CustomerRepository;
import com.example.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.example.hexagonal.adapters.out.repository.mapper.CustomerMapper;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public UpdateCustomerAdapter(
      CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public void update(Customer customer) {
    CustomerEntity customerEntity = customerMapper.toCustomerEntity(customer);
    customerRepository.save(customerEntity);
  }
}
