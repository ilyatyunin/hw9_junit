package ru.betboom.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApplePage {

    public SelenideElement headerWithProducts(String productName) {
        String productNameToLowerCase = productName.toLowerCase();
        return $(".globalnav-menu-list .globalnav-item-" + productNameToLowerCase);
    }
    public ApplePage checkProductInHeader(String productName) {
        headerWithProducts(productName).shouldBe(visible);
        return this;
    }

    public ApplePage openApplePage() {
        open("https://www.apple.com/");
        return this;
    }

}
