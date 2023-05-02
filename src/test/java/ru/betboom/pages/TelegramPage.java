package ru.betboom.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class TelegramPage {
    SelenideElement
            languageIcon = $(".dev_top_lang_icon"),
            sloganText = $(".tl_main_logo_lead");
    ElementsCollection header = $$(".nav.navbar-nav > li > a");
    public SelenideElement languageLink(String language) {
        return $(byTagAndText("a", language));
    }

    public TelegramPage openTelegramPage() {
            open("https://telegram.org/");
        return this;
    }
    public TelegramPage expandLanguages() {
        languageIcon.click();
        return this;
    }
    public TelegramPage checkSloganText(String expectedValues) {
        sloganText.shouldHave(text(expectedValues));
        return this;
    }
    public TelegramPage verifyHeader(List<String> expectedValues) {
        header.shouldHave(texts(expectedValues));
        return this;
    }
    public TelegramPage chooseLanguage(String language) {
        languageLink(language).click();
        return this;
    }
}
