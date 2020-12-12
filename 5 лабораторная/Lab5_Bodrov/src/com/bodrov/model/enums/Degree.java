package com.bodrov.model.enums;

public enum Degree {
    POSTGRADUATE("Аспирант"),
    CANDIDATE("Кандидат наук"),
    DOCTOR("Доктор наук");

    private final String name;
    Degree(String name) { this.name = name; }
    public String getName() { return name; }

    public static Degree convert(int index) {
        for (Degree degree : values()) {
            if (degree.ordinal() == index)
                return degree;
        } return null;
    }
}
