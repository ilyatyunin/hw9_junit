package ru.betboom.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.betboom.pages.TelegramPage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class TelegramChangeLanguageInHeaderTest {
TelegramPage telegramPage = new TelegramPage();

    @Tags({
            @Tag("WEB"),
            @Tag("MAIN"),
            @Tag("BLOCKER")
    })
    @BeforeEach
    void setup() {
        telegramPage.openTelegramPage();
    }
    @MethodSource("ru.betboom.pages.TelegramPage#changeLanguageAndVerifyHeader")
    @ParameterizedTest(name = "Check translate Header on {0}")
    void changeLanguageAndVerifyHeader(String language, List<String> expectedValues) {
        telegramPage
                .expandLanguages()
                .chooseLanguage(language)
                .verifyHeader(expectedValues);
    }
}