package com.mrzachmorgan.customer;

import com.mrzachmorgan.clients.fraud.FraudCheckResponse;
import com.mrzachmorgan.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;

    public void registerCustomer(final CustomerRegistrationRequest customerRegistrationRequest) {
        final Customer customer = Customer.builder()
            .firstName(customerRegistrationRequest.firstName())
            .lastName(customerRegistrationRequest.lastName())
            .email(customerRegistrationRequest.email())
            .build();

        customerRepository.saveAndFlush(customer);

        final FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
