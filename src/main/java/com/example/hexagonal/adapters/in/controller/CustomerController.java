package com.example.hexagonal.adapters.in.controller;

import com.example.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.example.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.example.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.example.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.example.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final InsertCustomerInputPort insertCustomerInputPort;
  private final UpdateCustomerInputPort updateCustomerInputPort;

  private final CustomerMapper customerMapper;

  @Autowired
  public CustomerController(
      FindCustomerByIdInputPort findCustomerByIdInputPort,
      InsertCustomerInputPort insertCustomerInputPort,
      UpdateCustomerInputPort updateCustomerInputPort,
      CustomerMapper customerMapper) {
    this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    this.insertCustomerInputPort = insertCustomerInputPort;
    this.updateCustomerInputPort = updateCustomerInputPort;
    this.customerMapper = customerMapper;
  }

  @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
    Customer customer = findCustomerByIdInputPort.find(id);
    CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);
    return ResponseEntity.ok(customerResponse);
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
    Customer customer = customerMapper.toCustomer(customerRequest);
    insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
    return ResponseEntity.ok().build();
  }

  @PutMapping(
      value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> update(
      @PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest) {
    Customer customer = customerMapper.toCustomer(customerRequest);
    customer.setId(id);
    updateCustomerInputPort.update(customer, customerRequest.getZipCode());
    return ResponseEntity.ok().build();
  }
}
