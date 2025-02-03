package com.example.hexagonal.adapters.in.controller.response;

public class CustomerResponse {
  private String name;
  private AddressResponse address;
  private String cpf;
  private Boolean isValidCpf;

  public CustomerResponse() {
    isValidCpf = false;
  }

  public CustomerResponse(String name, AddressResponse address, String cpf, Boolean isValidCpf) {
    this.name = name;
    this.address = address;
    this.cpf = cpf;
    this.isValidCpf = isValidCpf;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AddressResponse getAddress() {
    return address;
  }

  public void setAddressResponse(AddressResponse address) {
    this.address = address;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Boolean getIsValidCpf() {
    return isValidCpf;
  }

  public void setIsValidCpf(Boolean isValidCpf) {
    this.isValidCpf = isValidCpf;
  }
}
