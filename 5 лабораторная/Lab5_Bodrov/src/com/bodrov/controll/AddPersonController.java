package com.bodrov.controll;

import com.bodrov.model.enums.*;
import com.bodrov.model.persons.*;
import com.bodrov.view.AddPersonForm;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddPersonController  {
    private AddPersonForm form;
    private Person person;

    public void execute (AddPersonForm form){
        this.form = form;

        this.form.getButtonOK().addActionListener(e -> {
            //Получение данных с компонентов формы
            String name = form.getTxtName().getText();
            Gender gender = Gender.convert(form.getCmBGender().getSelectedIndex());
            int age = Integer.parseInt(form.getTxtAge().getText());


            //по видимости компонента определяем нажатую кнопку
            if (form.getTxtGroup().isVisible()) {
                String group = form.getTxtGroup().getText();
                person = new Student(name, age, gender, group);


            } else if (form.getTxtOffice().isVisible()) {
                int office = Integer.parseInt(form.getTxtOffice().getText());
                person = new HeadOfLectern(name,age,gender, office);


            } else if (form.getCmBDegree().isVisible()) {
                Degree degree = Degree.convert(form.getCmBDegree().getSelectedIndex());
                person = new Professor(name, age, gender, degree);
            }
            form.dispose();
        });

        //Обработчик ввода символов (Возраст)
        this.form.getTxtAge().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //Берем у события источник, который является текстовым полем и берем у него введенный текст
                String text = ((JTextField) e.getSource()).getText();

                //Если введеный символ не является цифрой
                if (!Character.isDigit(e.getKeyChar())
                    || text.length() >= 2
                    || text.length() == 0 && e.getKeyChar() == '0')
                    e.consume();//Остановить событие
            }
        });

        //Обработчик ввода символов (Имя)
        this.form.getTxtName().addKeyListener((new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String text = ((JTextField) e.getSource()).getText();

                if (e.getKeyChar() < 'А' || e.getKeyChar() > 'я'
                || text.length() == 0 && Character.isLowerCase(e.getKeyChar())
                || text.length() != 0 && Character.isUpperCase(e.getKeyChar()))

                    e.consume();//Остановить событие

            }
        }));


        form.setVisible(true);
    }

    public Person getPerson() { return person; }
}
