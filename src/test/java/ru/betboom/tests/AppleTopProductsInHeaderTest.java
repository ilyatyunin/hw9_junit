package ru.betboom.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.betboom.pages.ApplePage;

public class AppleTopProductsInHeaderTest {
ApplePage applePage = new ApplePage();
    @Tags({
            @Tag("WEB"),
            @Tag("MAIN"),
            @Tag("CRITICAL")
    })

    @BeforeEach
    void setup() {applePage.openApplePage();}

    @ValueSource(strings = {"Mac", "iPad", "iPhone", "Watch", "AirPods"})

    @ParameterizedTest(name = "Check product {0} by Apple in Header")
    void checkAppleTopProductInHeader(String productName) {
        applePage.checkProductInHeader(productName);
    }
}