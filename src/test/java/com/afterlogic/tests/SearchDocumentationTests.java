package com.afterlogic.tests;

import com.afterlogic.pages.MainPage;
import com.afterlogic.pages.SearchDocumentationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchDocumentationTests extends TestBase {

    SearchDocumentationPage searchDocumentationPage = new SearchDocumentationPage();

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
