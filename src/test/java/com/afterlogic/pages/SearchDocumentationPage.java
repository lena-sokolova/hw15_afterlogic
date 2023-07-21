package com.afterlogic.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchDocumentationPage {

    String documentationList = "Online documentation";
    String searchKey = "Two-factor";
    String searchResultText = "Two-factor authentication";

    SelenideElement
            supportTab = $(".item106"),
            documentationListLink = $("[href='/docs']"),
            auroraDocumentationLink = $("a[href='/docs/aurora/']"),
            searchInput = $("#search_input"),
            searchResult = $("#j1_42_anchor");

    public SearchDocumentationPage openPage() {
        open(baseUrl);
        return this;
    }

    public SearchDocumentationPage openDocumentationList() {
        supportTab.hover().$(byText(documentationList)).hover();
        documentationListLink.click();
        return this;
    }

    public SearchDocumentationPage openAuroraDocumentation() {
        auroraDocumentationLink.click();
        return this;
    }

    public SearchDocumentationPage searchDocumentation() {
        searchInput.click();
        searchInput.setValue(searchKey).pressEnter();
        return this;
    }

    public SearchDocumentationPage checkSearchResult() {
        searchResult.shouldHave(text(searchResultText));
        return this;
    }
}
