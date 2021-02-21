package ru.geekbrain;

public class Main {

    public static void main(String[] args) {
        try {
            String[][] values = {
                    {"1", "2", "5", "-1"},
                    {"1", "2", "5", "-1"},
                    {"1", "2", "A", "-1"},
                    {"1", "2", "5", "-1"}
            };
            new ArraySum().calculate(values);
        } catch (MyArraySizeException | MyDataArrayException e) {
            throw new RuntimeException("Something went wrong during calculation", e);
        }
    }
}
