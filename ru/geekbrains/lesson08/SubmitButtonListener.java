package ru.geekbrains.lesson08;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitButtonListener implements ActionListener {
    private final JTextField textField;

    public SubmitButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //calculate();
        calculateScriptEngine();
    }

    private void calculateScriptEngine(){
        int result = 0;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        try {
            result = (int) engine.eval(textField.getText());
            textField.setText(String.valueOf(result));
        } catch (ScriptException e) {
            textField.setText("ERROR IN SCRIPT ENGINE. PRESS C.");
        }
    }

    private void calculate(){
        int result = 0;
        String[] values = textField.getText().split("\\ ");
        if (values.length % 2 == 1) {
            result = Integer.parseInt(values[0]);
            for (int i = 1; i < values.length; i++) {
                if (values[i].equals("+")) {
                    result += Integer.parseInt(values[++i]);
                } else if (values[i].equals("-")){
                    result -= Integer.parseInt(values[++i]);
                }
            }
            textField.setText(String.valueOf(result));
        }

    }

}
