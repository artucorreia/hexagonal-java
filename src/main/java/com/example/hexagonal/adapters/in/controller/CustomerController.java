package com.example.hexagonal.adapters.in.controller;

import com.example.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.example.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  private final InsertCustomerInputPort insertCustomerInputPort;
  private final CustomerMapper customerMapper;

  @Autowired
  public CustomerController(
      InsertCustomerInputPort insertCustomerInputPort, CustomerMapper customerMapper) {
    this.insertCustomerInputPort = insertCustomerInputPort;
    this.customerMapper = customerMapper;
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
    Customer customer = customerMapper.toCustomer(customerRequest);
    insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
    return ResponseEntity.ok().build();
  }
}
