package com.bodrov.model.persons;

import com.bodrov.model.enums.Gender;

public class HeadOfLectern extends Person {
    private int personalOffice;

    public HeadOfLectern(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    public HeadOfLectern(String name, int age, Gender gender, int personalOffice) {
        super(name, age, gender);
        this.personalOffice = personalOffice;
    }

    @Override
    public void goToUniversity() {
        System.out.println("Завкафедрой следит за учебным процессом");
    }

    public int getPersonalOffice() {
        return personalOffice;
    }

    public void setPersonalOffice(int personalOffice) {
        this.personalOffice = personalOffice;
    }

    @Override public String toString() {
        return "Зав. кафедрой: \n\tИмя = '" + name + "," +
            "\n\tВозраст = " + age + " лет," +
            "\n\tПол = " + gender.getName() + ", " +
            "\n\tАудитория = №" + personalOffice + "\n\n";
    }
}
