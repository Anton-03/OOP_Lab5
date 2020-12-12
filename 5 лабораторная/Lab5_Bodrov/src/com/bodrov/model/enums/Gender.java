package com.bodrov.model.enums;

public enum Gender {
    MAN("Мужчина"),
    WOMAN("Женщина");

    private final String name;
    Gender(String name) { this.name = name; }
    public String getName() { return name; }

    public static Gender convert(int index) {
        for (Gender gender : values()) {
            if (gender.ordinal() == index)
                return gender;
        } return null;
    }
}