package com.example.hexagonal.adapters.out;

import com.example.hexagonal.adapters.out.repository.CustomerRepository;
import com.example.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.example.hexagonal.adapters.out.repository.mapper.CustomerMapper;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  @Autowired
  public FindCustomerByIdAdapter(
      CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public Optional<Customer> find(String id) {
    Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
    return customerEntity.map(entity -> customerMapper.toCustomer(entity));
  }
}
