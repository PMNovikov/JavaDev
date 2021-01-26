package ru.geekbrains.lesson08;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignButtonListener implements ActionListener{
    private final JTextField textField;

    public SignButtonListener(JTextField textField) {
        this.textField = textField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String[] values = textField.getText().split("\\ ");
        if (!textField.getText().equals("") && values.length % 2 == 1) {
            StringBuilder sb = new StringBuilder(textField.getText());
            sb.append(' ');
            sb.append(button.getText());
            sb.append(' ');

            textField.setText(sb.toString());
        }
    }
}
