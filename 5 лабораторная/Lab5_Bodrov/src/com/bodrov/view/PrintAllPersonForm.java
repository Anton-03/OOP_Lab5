package com.bodrov.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PrintAllPersonForm extends JDialog {
    private JPanel pnlContent;
    private JTable tableAllPerson;
    private String [] header;

    public PrintAllPersonForm(String title) {
        initialize();// Инициализируем компоненты

        setTitle(title);//Задаем заголовок окна
        setBounds(400, 300, 600, 400);// Задаем размеры и координамы
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);// Закрытие по умолчанию
        setContentPane(pnlContent);//Установить панель в качестве главной
        setModal(true);
    }

    private void initialize() {
        pnlContent = new JPanel(new BorderLayout());

        header = new String[] {
            "Персона", "Имя", "Возраст", "Пол", "Доп. информация",
        };
        //Пустой массив данных для таблцы
        String [][] data = new String[0][];

        tableAllPerson = new JTable(data, header);
        JScrollPane scrollPane = new JScrollPane(tableAllPerson);
        pnlContent.add(scrollPane, BorderLayout.CENTER);

    }

    public JTable getTableAllPerson() {return tableAllPerson; }
    public String[] getHeader() { return header; }
}