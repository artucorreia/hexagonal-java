package com.example.hexagonal.adapters.out.repository.entity;

public class AddressEntity {

  private String city;
  private String street;
  private String state;

  public AddressEntity() {}

  public AddressEntity(String city, String street, String state) {
    this.city = city;
    this.street = street;
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
