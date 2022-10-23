package com.mrzachmorgan;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email
) { }
