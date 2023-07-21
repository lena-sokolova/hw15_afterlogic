package com.afterlogic;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchDocumentationTests {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://afterlogic.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка поиска в документации продукта")
    void checkProductsTest() {
        open(baseUrl);
        $(".item106").hover().$(byText("Online documentation")).hover();
        $("[href='/docs']").click();
        $("a[href='/docs/aurora/']").click();
        $("#search_input").click();
        $("#search_input").setValue("Two-factor").pressEnter();

        $("#j1_42_anchor").shouldHave(text("Two-factor authentication"));
    }
}
