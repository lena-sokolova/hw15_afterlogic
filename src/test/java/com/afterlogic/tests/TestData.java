package com.afterlogic.tests;

import com.github.javafaker.Faker;

import static com.afterlogic.utils.RandomUtils.getRandomMessage;

public class TestData {

    Faker faker = new Faker();

    String companyName = faker.company().name();
    String userName = faker.name().firstName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String message = getRandomMessage();
}