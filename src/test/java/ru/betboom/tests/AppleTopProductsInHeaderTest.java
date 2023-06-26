package ru.betboom.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.betboom.pages.ApplePage;

import static io.qameta.allure.Allure.step;

public class AppleTopProductsInHeaderTest extends TestBase {
ApplePage applePage = new ApplePage();
    @Tags({
            @Tag("WEB"),
            @Tag("MAIN"),
            @Tag("CRITICAL")
    })

    @ValueSource(strings = {"Mac", "iPad", "iPhone", "Watch", "AirPods"})

    @ParameterizedTest(name = "Проверка наличия {0} в хедере сайта Apple")
    void checkAppleTopProductInHeader(String productName) {
        step("Открытие страницы Apple", () -> {
            applePage.openApplePage();
        });
        step("Проверка наличия продукта в Хедере сайта", () -> {
            applePage.checkProductInHeader(productName);
        });
    }
}