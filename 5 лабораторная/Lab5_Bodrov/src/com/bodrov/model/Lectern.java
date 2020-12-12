package com.bodrov.model;

import com.bodrov.model.enums.Gender;
import com.bodrov.model.persons.Person;

import java.util.ArrayList;
import java.util.List;

public class Lectern {
    private final List<Person> people;

    //Создает новую коллекцию
    public Lectern() {
        people = new ArrayList<>();
    }

    //Добавляет новую персону
    public void add(Person person) {
        people.add(person);
    }
    public int size() {
        return people.size();
    }

    //Возвращаем колекцию людей
    public List<Person> getPeople() {
        return people;
    }

    //Удаление по номеру
    public void remove(int number){
        if (number > 0 && number <= people.size())
            people.remove(number - 1);
    }

    //Поиск по номеру
    public Person get(int number){
        if (number > 0 && number <= people.size())
           return people.get(number - 1);
        return null;
    }

    //Поиск по имени
    public List<Person> search(String name) {
        List<Person> list = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name))
                list.add(person);
        }return list;
    }
    public List<Person> search(int age) {
        List<Person> list = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() == age)
                list.add(person);
        }return list;
    }

    public List<Person> search(Gender gender) {
        List<Person> list = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender() == gender)
                list.add(person);
        }return list;
    }
}
