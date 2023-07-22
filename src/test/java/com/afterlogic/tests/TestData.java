package com.afterlogic.tests;

import com.github.javafaker.Faker;

import static com.afterlogic.utils.RandomUtils.getRandomMessage;

public class TestData {
    static Faker faker = new Faker();

    static String companyName = faker.name().firstName();
    static String userName = faker.name().lastName();
    static String userEmail = faker.internet().emailAddress();
    static String userNumber = faker.phoneNumber().subscriberNumber(10);
    static String message = getRandomMessage();
}
