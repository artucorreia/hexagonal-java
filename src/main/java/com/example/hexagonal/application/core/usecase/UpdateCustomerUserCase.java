package com.example.hexagonal.application.core.usecase;

import com.example.hexagonal.application.core.domain.Address;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.example.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.example.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUserCase implements UpdateCustomerInputPort {

  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
  private final UpdateCustomerOutputPort updateCustomerOutputPort;

  public UpdateCustomerUserCase(
      FindCustomerByIdInputPort findCustomerByIdInputPort,
      FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
      UpdateCustomerOutputPort updateCustomerOutputPort) {
    this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    this.updateCustomerOutputPort = updateCustomerOutputPort;
  }

  @Override
  public void update(Customer customer, String zipCode) {
    findCustomerByIdInputPort.find(customer.getId());
    Address address = findAddressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    updateCustomerOutputPort.update(customer);
  }
}
