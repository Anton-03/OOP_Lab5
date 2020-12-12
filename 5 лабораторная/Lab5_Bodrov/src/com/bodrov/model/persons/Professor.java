package com.bodrov.model.persons;

import com.bodrov.model.enums.Degree;
import com.bodrov.model.enums.Gender;

public class Professor extends Person {
    private Degree degree;

    public Professor(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    public Professor(String name, int age, Gender gender, Degree degree) {
        super(name, age, gender);
        this.degree = degree;
    }

    @Override
    public void goToUniversity() {
        System.out.println("Преподаватель ведет лекции и учит студентов");
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        //Проверка( Не равна null)
        if (degree != null)
            this.degree = degree;
    }

    @Override public String toString() {
        return "Преподаватель: \n\tИмя = '" + name + "," +
            "\n\tВозраст = " + age + " лет," +
            "\n\tПол = " + gender.getName() + ", " +
            "\n\tНаучная степень = " + degree.getName() + "\n\n";
    }
}
