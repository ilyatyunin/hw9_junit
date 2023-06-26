package ru.betboom.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.betboom.pages.TelegramPage;
import ru.betboom.pages.components.enums.LanguageEnum;

import java.util.List;
import java.util.stream.Stream;

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



    @ParameterizedTest(name = "Check translate Header on {0}")
    @MethodSource("changeLanguageAndVerifyHeader")
    void changeLanguageAndVerifyHeader(String language, List<String> expectedValues) {
        telegramPage
                .expandLanguages()
                .chooseLanguage(language)
                .verifyHeader(expectedValues);
    }

    public static Stream<Object> changeLanguageAndVerifyHeader() {
        return Stream.of(
                Arguments.of(LanguageEnum.RU.getLanguages(), List.of("RU", "Twitter", "Главная", "FAQ", "Приложения", "API", "Протокол")),
                Arguments.of(LanguageEnum.EN.getLanguages(), List.of("EN", "Twitter", "Home", "FAQ", "Apps", "API", "Protocol")),
                Arguments.of(LanguageEnum.DE.getLanguages(), List.of("DE", "Twitter", "Start", "FAQ", "Apps", "API", "Protokoll"))
        );
    }
}