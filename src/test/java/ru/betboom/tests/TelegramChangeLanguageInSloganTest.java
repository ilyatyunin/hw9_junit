package ru.betboom.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.betboom.pages.TelegramPage;

import static io.qameta.allure.Allure.step;

public class TelegramChangeLanguageInSloganTest extends TestBase {
TelegramPage telegramPage = new TelegramPage();
    @Tags({
            @Tag("WEB"),
            @Tag("MAIN"),
            @Tag("BLOCKER")
    })

    @CsvSource({
            "Русский, новая эра в общении",
            "English, a new era of messaging",
            "Deutsch, ein neues Messaging-Zeitalter"
    })

    @ParameterizedTest(name = "Проверка перевода слогана на {0}")
    void getSloganForLanguage(String language, String expectedValues) {
        step("Открытие страницы Telegram", () -> {
            telegramPage.openTelegramPage();
        });
        step("Выбор языка", () -> {
            telegramPage
                    .expandLanguages()
                    .chooseLanguage(language);
        });
        step("Проверка перевода слогана", () -> {
            telegramPage.checkSloganText(expectedValues);
        });
    }
}