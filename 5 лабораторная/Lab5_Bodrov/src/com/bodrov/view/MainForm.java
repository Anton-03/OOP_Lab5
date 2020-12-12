package com.bodrov.view;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JPanel pnlContent;
    private JMenuBar mainMenu;
    private JMenuItem menuStudent;
    private JMenuItem menuProfessor;
    private JMenuItem menuHeadOfLectern;
    private JMenuItem menuRemoveOfNumber;
    private JMenuItem menuFindOfNumber;
    private JMenuItem menuFindOfName;
    private JMenuItem menuFindOfAge;
    private JMenuItem menuFindOfGender;
    private JMenuItem menuAllFind;


    public MainForm(String title) {
        initialize();// Инициализируем компоненты

        setTitle(title);//Задаем заголовок окна
        setBounds(400, 300, 600, 400);// Задаем размеры и координамы
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// Ничего не делать при закрытии
        setContentPane(pnlContent);//Установить панель в качестве главной
        setVisible(true);//Сделать окно видимым
    }

    private void initialize() {
        pnlContent = new JPanel(new BorderLayout());// Пограничное расположение(Слева направо)

        //
        mainMenu = new JMenuBar();


        //Добавление персоны
        JMenu menuAdd = new JMenu("Добавить персону");
        menuStudent = new JMenuItem("Студент");
        menuProfessor = new JMenuItem("Преподаватель");
        menuHeadOfLectern = new JMenuItem("Завкафедрой");

        //Добавление кнопок в меню (Добавление)
        menuAdd.add(menuStudent);
        menuAdd.add(menuProfessor);
        menuAdd.add(menuHeadOfLectern);



        //Удалить персону
        JMenu menuRemove = new JMenu("Удалить персону");
        menuRemoveOfNumber = new JMenuItem("Удалить по номеру");

        //Дабавление кнопки в меню (Удаление)
        menuRemove.add(menuRemoveOfNumber);


        //Поиск персоны
        JMenu menuFind = new JMenu("Поиск персоны");
        menuFindOfNumber = new JMenuItem("Поиск по номеру ");
        menuFindOfName = new JMenuItem("Поиск по имени ");
        menuFindOfAge = new JMenuItem("Поиск по возрасту ");
        menuFindOfGender = new JMenuItem("Поиск по полу ");

        //Добавление кнопки в меню (Поиск персоны)
        menuFind.add(menuFindOfNumber);
        menuFind.add(menuFindOfName);
        menuFind.add(menuFindOfAge);
        menuFind.add(menuFindOfGender);


        //Вывести список всех персон
        JMenu menuAllPerson = new JMenu("Список всех персон");
        menuAllFind = new JMenuItem("Весь список");

        //Добавление кнопки в меню (Поиск всех персон)
        menuAllPerson.add(menuAllFind);



        //Добавление меню в основной Bar
        mainMenu.add(menuAdd);
        mainMenu.add(menuRemove);
        mainMenu.add(menuFind);
        mainMenu.add(menuAllPerson);


        pnlContent.add(mainMenu, BorderLayout.NORTH);
    }

    public JPanel getPnlContent() { return pnlContent; }
    public JMenuItem getMenuRemoveOfNumber() { return menuRemoveOfNumber; }
    public JMenuItem getMenuHeadOfLectern() { return menuHeadOfLectern; }
    public JMenuItem getMenuProfessor() { return menuProfessor; }
    public JMenuItem getMenuStudent() { return menuStudent; }
    public JMenuBar getMainMenu() { return mainMenu; }
    public JMenuItem getMenuFindOfAge() { return menuFindOfAge; }
    public JMenuItem getMenuFindOfNumber() { return menuFindOfNumber; }
    public JMenuItem getMenuFindOfGender() { return menuFindOfGender; }
    public JMenuItem getMenuFindOfName() { return menuFindOfName; }
    public JMenuItem getMenuAllFind() { return menuAllFind; }
}

