package com.example.hexagonal.adapters.out;

import com.example.hexagonal.adapters.out.repository.CustomerRepository;
import com.example.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.stereotype.Controller;

@Controller
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

  private final CustomerRepository customerRepository;

  public DeleteCustomerByIdAdapter(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void delete(String id) {
    customerRepository.deleteById(id);
  }
}
