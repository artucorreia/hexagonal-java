package com.example.hexagonal.config;

import com.example.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.example.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.example.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.example.hexagonal.application.core.usecase.UpdateCustomerUserCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

  @Bean
  public UpdateCustomerUserCase updateCustomerUserCase(
      FindCustomerByIdUseCase findCustomerByIdUseCase, 
      FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, 
      UpdateCustomerAdapter updateCustomerAdapter) {
    return new UpdateCustomerUserCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
  }
}
