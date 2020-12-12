package com.bodrov;

import com.bodrov.controll.MainController;
import com.bodrov.model.Lectern;
import com.bodrov.view.MainForm;

import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        //Запуск контролера в новом потоке и передача ему интерфейса
        SwingUtilities.invokeLater(() -> {
            MainController controller = new MainController();
            MainForm form = new MainForm("Добро пожаловать в программу!");
            Lectern lectern = new Lectern();

            controller.execute(form, lectern);
        });
    }
}