package ru.betboom.pages.components.enums;

public enum LanguageEnum {
    RU("Русский"),
    EN("English"),
    DE("Deutsch");

    private String languages;

    LanguageEnum(String languages) {
        this.languages = languages;
    }

    public String getLanguages() {
        return languages;
    }
}
