package ru.betboom.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.provider.Arguments;
import ru.betboom.pages.components.enums.LanguageEnum;

import java.util.List;
import java.util.stream.Stream;

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

    private static Stream<Object> changeLanguageAndVerifyHeader() {
        return Stream.of(
                Arguments.of(LanguageEnum.RU.getLanguages(), List.of("RU", "Twitter", "Главная", "FAQ", "Приложения", "API", "Протокол")),
                Arguments.of(LanguageEnum.EN.getLanguages(), List.of("EN", "Twitter", "Home", "FAQ", "Apps", "API", "Protocol")),
                Arguments.of(LanguageEnum.DE.getLanguages(), List.of("DE", "Twitter", "Start", "FAQ", "Apps", "API", "Protokoll"))
        );
    }
}
