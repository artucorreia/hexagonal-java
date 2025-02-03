package com.example.hexagonal.adapters.in.controller.response;

public class AddressResponse {

  private String city;
  private String state;
  private String street;

  public AddressResponse() {}

  public AddressResponse(String city, String state, String street) {
    this.city = city;
    this.state = state;
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }
}
