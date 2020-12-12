package com.bodrov.view;

import javax.swing.*;
import java.awt.*;

public class AddPersonForm extends JDialog {

    private JPanel pnlContent;
    private JLabel lbName;
    private JLabel lbAge;
    private JLabel lbGender;
    private JLabel lbGroup;
    private JLabel lbDegree;
    private JLabel lbOffice;

    private JTextField txtName;
    private JTextField txtAge;
    private JComboBox<String> cmBGender;
    private JTextField txtGroup;
    private JComboBox<String> cmBDegree;
    private JTextField txtOffice;

    private JButton buttonOK;

    public AddPersonForm(String title) {
        initialize();

        setTitle(title);
        setBounds(400, 300, 270, 380);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(getSize());//Текущий размер будет минимальным
        setContentPane(pnlContent);
        setModal(true);
    }

    private void initialize() {
        pnlContent = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
        lbName = new JLabel("Имя:");
        lbAge = new JLabel("Возраст:");
        lbGender = new JLabel("Пол:");
        lbGroup = new JLabel("Группа:");
        lbDegree = new JLabel("Степень:");
        lbOffice = new JLabel("Аудитория:");
        txtName = new JTextField();
        txtAge = new JTextField();
        cmBGender = new JComboBox<>(new String[]{ "Мужской", "Женский" });
        txtGroup = new JTextField();
        cmBDegree = new JComboBox<>(new String[]{ "Аспирант","Кандидат наук","Доктор наук" });
        txtOffice = new JTextField();
        buttonOK = new JButton("ОК");

        //Размер текстовых полей
        Dimension size = new Dimension(220, 20);
        txtName.setPreferredSize(size);
        txtAge.setPreferredSize(size);
        txtGroup.setPreferredSize(size);
        txtOffice.setPreferredSize(size);

        //Размер ComboBox(Выпадающие списки)
        cmBGender.setPreferredSize(size);
        cmBDegree.setPreferredSize(size);

        //Добавление всех компанентов на панельку
        pnlContent.add(lbName);
        pnlContent.add(txtName);
        pnlContent.add(lbAge);
        pnlContent.add(txtAge);
        pnlContent.add(lbGender);
        pnlContent.add(cmBGender);
        pnlContent.add(lbGroup);
        pnlContent.add(txtGroup);
        pnlContent.add(lbDegree);
        pnlContent.add(cmBDegree);
        pnlContent.add(lbOffice);
        pnlContent.add(txtOffice);
        pnlContent.add(buttonOK);
    }




    public JPanel getPnlContent() { return pnlContent; }
    public JLabel getLbName() { return lbName; }
    public JLabel getLbAge() { return lbAge; }
    public JLabel getLbGender() { return lbGender; }
    public JLabel getLbGroup() { return lbGroup; }
    public JLabel getLbDegree() { return lbDegree; }
    public JLabel getLbOffice() { return lbOffice; }

    public JTextField getTxtName() { return txtName; }
    public JTextField getTxtAge() { return txtAge; }
    public JComboBox<String> getCmBGender() { return cmBGender; }
    public JTextField getTxtGroup() { return txtGroup; }
    public JComboBox<String> getCmBDegree() { return cmBDegree; }
    public JTextField getTxtOffice() { return txtOffice; }

    public JButton getButtonOK() { return buttonOK; }
}
