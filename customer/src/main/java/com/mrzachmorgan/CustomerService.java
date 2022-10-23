package com.mrzachmorgan;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(
    CustomerRepository customerRepository
) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        final Customer customer = Customer.builder()
            .firstName(customerRegistrationRequest.firstName())
            .lastName(customerRegistrationRequest.lastName())
            .email(customerRegistrationRequest.email())
            .build();

        customerRepository.save(customer);
    }
}
