package com.bodrov.controll;

import com.bodrov.model.Lectern;
import com.bodrov.model.persons.HeadOfLectern;
import com.bodrov.model.persons.Person;
import com.bodrov.model.persons.Professor;
import com.bodrov.model.persons.Student;
import com.bodrov.view.PrintAllPersonForm;

import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class PrintAllPersonController {
    private PrintAllPersonForm form;
    private Lectern lectern;

    public void execute(PrintAllPersonForm form, Lectern lectern) {
        this.form = form;
        this.lectern = lectern;


        form.getTableAllPerson().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String[][] data = new String[lectern.size()][];

                for (int i=0; i< lectern.size();i++) {
                    Person person = lectern.get(i+1);
                    String nameClass = "";
                    String addInfo = "";

                    //Приведение к определенному классу и получения доп. информации
                    if (person instanceof Student) {
                        nameClass = "Студент";
                        addInfo = "Группа: " + ((Student) person).getGroup();
                    }else if (person instanceof Professor) {
                        nameClass = "Преподаватель";
                        addInfo = "Степень: " + ((Professor) person).getDegree().getName();
                     }else  if (person instanceof HeadOfLectern){
                        nameClass = "Завкафедрой";
                        addInfo = "Аудитория: №" + ((HeadOfLectern) person).getPersonalOffice();
                    }

                    //
                    data[i] = new String[] {
                        // Сбор данных из объекта класса Person и добавление их в модель DefaultTableModel
                        nameClass,
                        person.getName(),
                        String.valueOf(person.getAge()),
                        person.getGender().getName(),
                        addInfo
                    };
                }
                //У таблицы обновляем ее модель с помощью DefaultTableModel
                form.getTableAllPerson().setModel(new DefaultTableModel(data,  form.getHeader()));
            }
        });

        form.setVisible(true);//Сделать окно видимым
    }
}