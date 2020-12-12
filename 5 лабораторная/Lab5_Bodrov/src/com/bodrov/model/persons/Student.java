package com.bodrov.model.persons;

import com.bodrov.model.enums.Gender;

public class Student extends Person {
    private String group;
    //Вызов конструктора в родительском классе
    public Student(String name, int age, Gender gender) {
        super(name, age, gender);

    }
       //Создание нового студента
    public Student(String name, int age, Gender gender, String group) {
        super(name, age, gender);
        this.group = group;
    }

    @Override//Метод переопределяется(Другая реализация)
    public void goToUniversity() {
        System.out.println("Студент учится и получает знания");
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        //Проверка( Не равна null и не пустая)
        if (group != null && !group.isEmpty())
         this.group = group;
    }

    @Override public String toString() {
        return "Студент: \n\tИмя = '" + name + "," +
            "\n\tВозраст = " + age + " лет," +
            "\n\tПол = " + gender.getName() + ", " +
            "\n\tГруппа = " + group + "\n\n";
    }
}
