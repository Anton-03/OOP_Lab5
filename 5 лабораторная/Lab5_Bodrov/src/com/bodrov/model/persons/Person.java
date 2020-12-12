package com.bodrov.model.persons;

import com.bodrov.model.enums.Gender;

public abstract class Person {
   protected String name;
   protected int age;
   protected Gender gender;

   //Конструктор передачи параметров
    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public abstract void goToUniversity();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
