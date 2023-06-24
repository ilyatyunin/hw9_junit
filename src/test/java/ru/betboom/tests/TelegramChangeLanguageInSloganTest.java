package ru.betboom.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.betboom.pages.TelegramPage;

public class TelegramChangeLanguageInSloganTest {
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
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @CsvSource({
            "Русский, новая эра в общении",
            "English, a new era of messaging",
            "Deutsch, ein neues Messaging-Zeitalter"
    })

    @ParameterizedTest(name = "Check translate Telegram Slogan on {0}")
    void getSloganForLanguage(String language, String expectedValues) {
        telegramPage
                .expandLanguages()
                .chooseLanguage(language)
                .checkSloganText(expectedValues);
    }
}