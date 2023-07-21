package com.afterlogic;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTests {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://afterlogic.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    @Tag("smoke")
    @DisplayName("Успешное открытие главной страницы")
    void successfulOpenMainPageTest() {
        open(baseUrl);
        $(".home-hero").shouldHave(text("Afterlogic Corp. is an award-winning technological company"));
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка наличия всех табов на странице")
    void checkTabsTitlesTest() {
        List<String> titles = List.of("Products", "Purchase", "Support", "Our Clients", "Services",
                "About");
        open(baseUrl);
        sleep(2000);
        $$("#main-menu a.l1").should(texts(titles));
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка наличия всех продуктов в каталоге")
    void checkProductsTest() {
        List<String> titles = List.of("Afterlogic Aurora Corporate", "Afterlogic WebMail Pro PHP",
                "Afterlogic WebMail Pro ASP.NET", "Afterlogic ActiveServer", "Afterlogic MailSuite Pro for Linux",
                "MailBee.NET Objects", "MailBee Objects");
        open(baseUrl);
        sleep(2000);
        $(".item102").hover().$(byText("All Products")).hover();
        $("[href='/purchase/order-online']").click();
        $$(".products-list h3").should(texts(titles));
    }

    @Disabled
    @Test
    @DisplayName("Проверка заполнения формы обратной связи")
    void checkContactUsFormTest() {
        open(baseUrl);
        sleep(2000);
        $(".item112").hover().$(byText("Contact")).hover();
        $("[href='/contact']").click();
        $("#jform_company").setValue("Test company");
        $("#jform_name").setValue("Test name");
        $("#jform_phone").setValue("+19001001001");
        $("#jform_email").setValue("test@email.com");
        $("#jform_message").setValue("Hello");
        $(".button").click();

        $(".alert-message").shouldHave(text("Thank you for your inquiry.\n" +
                "Your message will be processed as soon as possible."));
    }

    @Test
    @DisplayName("Проверка перехода в раздел политики конфиденциальности")
    void checkPrivacyPolicySectionTest(){
        open(baseUrl);
        sleep(2000);
        $("[href='/privacy-policy']").click();
        $("h1").shouldHave(text("Privacy policy"));
    }
}

