package com.bodrov.controll;

import com.bodrov.model.Lectern;
import com.bodrov.model.enums.Gender;
import com.bodrov.model.persons.Person;
import com.bodrov.view.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class MainController {
    private MainForm form;
    private Lectern lectern;

    //Вызов обработчиков событий
    public void execute(MainForm form, Lectern lectern) {
        this.form = form;
        this.lectern = lectern;


        //УДАЛЕНИЕ
        this.form.getMenuRemoveOfNumber().addActionListener(e -> {
            //Вызов дилогового окна ввода
            //Перевод сткроки в число и сохраняем

            try {
                int number = Integer.parseInt(JOptionPane.showInputDialog(form,
                    "Введите номер удаляемой персоны",
                    "Удаление персоны", JOptionPane.PLAIN_MESSAGE));

                if (lectern.size() > 0) {

                    if (number > 0 && number <= lectern.size()) {
                        lectern.remove(number);
                        JOptionPane.showMessageDialog(form,
                            "Персона успешно удалена!");
                    } else JOptionPane.showMessageDialog(form,
                            "Персона с таким номером отсутствует!",
                            "Ошибка удаления", JOptionPane.ERROR_MESSAGE);

                } else JOptionPane.showMessageDialog(form,
                        "Список пуст!");

            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(form,
                    "Вводите только числа!!!",
                    "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            }
        });



        //CПИСОК ПЕРСОН
        this.form.getMenuAllFind().addActionListener(e -> {
            PrintAllPersonController controller = new PrintAllPersonController();
            PrintAllPersonForm dialog = new PrintAllPersonForm("Список персон");
            controller.execute(dialog, lectern);
        });




        //ВЫХОД ИЗ ПРОГРАММЫ
        this.form.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Будет хранить нажатую кнопку пользователя
                int option = JOptionPane.showConfirmDialog(form,
                    "Вы действительно хотите выйти из программы?",
                    "Выход из программы",JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION)
                    form.dispose();


            }
        });




        //ДОБАВЛЕНИЕ
        //Студент
        this.form.getMenuStudent().addActionListener(e -> {
            //Создали контролер, который обрабатывает события
            AddPersonController controller = new AddPersonController();
            AddPersonForm addPersonForm = new AddPersonForm("Создание Студента");

            addPersonForm.getLbOffice().setVisible(false);
            addPersonForm.getLbDegree().setVisible(false);
            addPersonForm.getTxtOffice().setVisible(false);
            addPersonForm.getCmBDegree().setVisible(false);

            //Вызов контроллера
            controller.execute(addPersonForm);
            //Добаление персоны в кафедру
            lectern.add(controller.getPerson());

        });


        //Профессор
        this.form.getMenuProfessor().addActionListener(e -> {

            AddPersonController controller = new AddPersonController();
            AddPersonForm addPersonForm = new AddPersonForm("Создание Профессора");

            addPersonForm.getLbGroup().setVisible(false);
            addPersonForm.getLbOffice().setVisible(false);
            addPersonForm.getTxtGroup().setVisible(false);
            addPersonForm.getTxtOffice().setVisible(false);

            controller.execute(addPersonForm);
            lectern.add(controller.getPerson());


        });

        //Завкафедрой
        this.form.getMenuHeadOfLectern().addActionListener(e -> {

            AddPersonController controller = new AddPersonController();
            AddPersonForm addPersonForm = new AddPersonForm("Создание Завкафедрой");

            addPersonForm.getLbGroup().setVisible(false);
            addPersonForm.getLbDegree().setVisible(false);
            addPersonForm.getTxtGroup().setVisible(false);
            addPersonForm.getCmBDegree().setVisible(false);

            controller.execute(addPersonForm);
            lectern.add(controller.getPerson());


        });




        //ПОИСК ПО ПАРАМЕТРАМ
        //Номеру
        this.form.getMenuFindOfNumber().addActionListener(e -> {

            if (lectern.size() > 0) {
                try {
                    int number = Integer.parseInt(JOptionPane.showInputDialog(form,
                            "Введите номер", "Поиск по номеру", JOptionPane.PLAIN_MESSAGE));
                    Person person = lectern.get(number);

                    if (person != null) {
                        JOptionPane.showMessageDialog(form, person,
                                "Результаты поиска", JOptionPane.PLAIN_MESSAGE);
                    } else  JOptionPane.showMessageDialog(form,
                            "Ничего не найдено!","Ошибка!" ,
                            JOptionPane.WARNING_MESSAGE);

                } catch (NumberFormatException ignored) { }

            } else JOptionPane.showMessageDialog(form,
                    "Список пуст!");
        });

        //Имя
        this.form.getMenuFindOfName().addActionListener(e -> {

            if (lectern.size() > 0) {
                String name = JOptionPane.showInputDialog(form,
                        "Введите имя", "Поиск по имени", JOptionPane.PLAIN_MESSAGE);
                List<Person> people = lectern.search(name);
                String [] strings = new String[people.size()];

                for (int i = 0; i < people.size(); i++) {
                    strings[i] = (i+1) + ". " + people.get(i).toString();
                }

                if (people.size() != 0) {
                    JOptionPane.showMessageDialog(form, strings,
                        "Результаты поиска", JOptionPane.PLAIN_MESSAGE);
                } else JOptionPane.showMessageDialog(form, "Ничего не найдено!","Ошибка!" , JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(form,
                    "Список пуст!");
      });

        //Возраст
        this.form.getMenuFindOfAge().addActionListener(e -> {

            if (lectern.size() > 0) {
                try {
                    int age = Integer.parseInt(JOptionPane.showInputDialog(form,
                            "Введите возраст", "Поиск по возрасту", JOptionPane.PLAIN_MESSAGE));
                    List<Person> people = lectern.search(age);
                    String[] strings = new String[people.size()];

                    for (int i = 0; i < people.size(); i++) {
                        strings[i] = (i + 1) + ". " + people.get(i).toString();
                    }

                    if (people.size() != 0) {
                        JOptionPane.showMessageDialog(form, strings,
                                "Результаты поиска", JOptionPane.PLAIN_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(form,
                            "Ничего не найдено!", "Ошибка!",
                            JOptionPane.WARNING_MESSAGE);

                } catch  (NumberFormatException ignored) { }

            } else JOptionPane.showMessageDialog(form,
                    "Список пуст!");
        });

        //Полу
        this.form.getMenuFindOfGender().addActionListener(e -> {

            if (lectern.size() > 0) {

                //Вспомогательный массив для определния пола
                String [] genders = new String [] { "Мужской", "Женский" };

                //Приведение к строке выбранного значения из выпадающего списка
                String result = (String) JOptionPane.showInputDialog(form,
                        "Выберите пол", "Поиск по полу", JOptionPane.PLAIN_MESSAGE,
                        null, genders, genders[0]);

                //Приведение строки к классу Gender
                if (result != null) {
                    Gender gender = result.equals(genders[0]) ? Gender.MAN : Gender.WOMAN;

                    List<Person> people = lectern.search(gender);
                    String[] strings = new String[people.size()];

                    for (int i = 0; i < people.size(); i++) {
                        strings[i] = (i + 1) + ". " + people.get(i).toString();
                    }

                    if (people.size() != 0) {
                        JOptionPane.showMessageDialog(form, strings,
                                "Результаты поиска", JOptionPane.PLAIN_MESSAGE);

                    } else JOptionPane.showMessageDialog(form,
                            "Ничего не найдено!", "Ошибка!",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else JOptionPane.showMessageDialog(form, "Список пуст!");
        });
    }
}
