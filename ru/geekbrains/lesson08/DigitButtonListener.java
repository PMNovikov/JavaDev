package ru.geekbrains.lesson08;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonListener implements ActionListener {
    private final JTextField textField;

    public DigitButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        StringBuilder sb = new StringBuilder(textField.getText());
        sb.append(button.getText());

        textField.setText(sb.toString());
    }
}

