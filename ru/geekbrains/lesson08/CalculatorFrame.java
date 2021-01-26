package ru.geekbrains.lesson08;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(50, 50, 300, 400);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JTextField inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(6, 3));

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.CENTER);

        DigitButtonListener digitButtonListener = new DigitButtonListener(inputField);

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(digitButtonListener);
            bottom.add(button);
        }

        SignButtonListener signButtonListener = new SignButtonListener(inputField);
        ClearButtonListener clearButtonListener = new ClearButtonListener(inputField);
        SubmitButtonListener submitButtonListener = new SubmitButtonListener(inputField);

        JButton add = new JButton("+");
        add.addActionListener(signButtonListener);
        bottom.add(add);

        JButton minus = new JButton("-");
        minus.addActionListener(signButtonListener);
        bottom.add(minus);

        JButton multiplication = new JButton("*");
        multiplication.addActionListener(signButtonListener);
        bottom.add(multiplication);

        JButton division = new JButton("/");
        division.addActionListener(signButtonListener);
        bottom.add(division);

        JButton calc = new JButton("=");
        calc.addActionListener(submitButtonListener);
        bottom.add(calc);

        JButton clear = new JButton("C");
        clear.addActionListener(clearButtonListener);
        bottom.add(clear);

        setVisible(true);

    }
}
