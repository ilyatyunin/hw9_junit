package ru.betboom.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.betboom.pages.TelegramPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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