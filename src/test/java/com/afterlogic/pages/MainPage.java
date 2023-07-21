package com.afterlogic.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    String successOpenPageText = "Afterlogic Corp. is an award-winning technological company";
    List<String> tabsTitles = List.of("Products", "Purchase", "Support", "Our Clients", "Services", "About");
    List<String> productNames = List.of("Afterlogic Aurora Corporate", "Afterlogic WebMail Pro PHP",
            "Afterlogic WebMail Pro ASP.NET", "Afterlogic ActiveServer", "Afterlogic MailSuite Pro for Linux",
            "MailBee.NET Objects", "MailBee Objects");
    String productsListName = "All Products";
    String contactFormName = "Contact";
    String successSendMessageText = "Thank you for your inquiry.\n" +
            "Your message will be processed as soon as possible.";
    String privacyPolicyTitleName = "Privacy policy";

    SelenideElement
            homeText = $(".home-hero"),
            purchaseTab = $(".item102"),
            productsListLink = $("[href='/purchase/order-online']"),
            aboutTab = $(".item112"),
            contactUsLink = $("[href='/contact']"),
            companyName = $("#jform_company"),
            yourName = $("#jform_name"),
            phoneNumber = $("#jform_phone"),
            email = $("#jform_email"),
            message = $("#jform_message"),
            sendBtn = $(".button"),
            sendMessageText = $(".alert-message"),
            privacyPolicyLink = $("[href='/privacy-policy']"),
            privacyPolicyTitle = $("h1");

    ElementsCollection tabsBar = $$("#main-menu a.l1");
    ElementsCollection productsList = $$(".products-list h3");

    public MainPage openPage() {
        open(baseUrl);
        return this;
    }

    public MainPage checkHomePageText() {
        homeText.shouldHave(text(successOpenPageText));
        return this;
    }

    public MainPage checkTabsTitles() {
        tabsBar.shouldHave(texts(tabsTitles));
        return this;
    }

    public MainPage openAllProductsList() {
        purchaseTab.hover().$(byText(productsListName)).hover();
        productsListLink.click();
        return this;
    }

    public MainPage checkProductTitles() {
        productsList.shouldHave(texts(productNames));
        return this;
    }

    public MainPage openContactForm() {
        aboutTab.hover().$(byText(contactFormName)).hover();
        contactUsLink.click();
        return this;
    }

//    public MainPage setCompanyName(String value) {
//        companyName.setValue(value);
//        return this;
//    }

    public MainPage setCompanyName() {
        companyName.setValue("Test company");
        return this;
    }

    public MainPage setYourName() {
        yourName.setValue("Test name");
        return this;
    }

    public MainPage setPhoneNumber() {
        phoneNumber.setValue("+19001001001");
        return this;
    }

    public MainPage setEmail() {
        email.setValue("test@email.com");
        return this;
    }

    public MainPage setMessage() {
        message.setValue("Hello!");
        return this;
    }

    public MainPage clickSendBtn() {
        sendBtn.click();
        return this;
    }

    public MainPage checkSuccessSendMessageText() {
        sendMessageText.shouldHave(text(successSendMessageText));
        return this;
    }

    public MainPage openPrivacyPolicyTerms() {
        privacyPolicyLink.click();
        return this;
    }

    public MainPage checkOpenPrivacyPolicyTerms() {
        privacyPolicyTitle.shouldHave(text(privacyPolicyTitleName));
        return this;
    }
}
