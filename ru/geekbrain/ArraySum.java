package ru.geekbrain;

public class ArraySum {

    public int calculate(String[][] array){
        int result = 0;

        checkSizeCondition(array);

        for (int i = 0; i < array.length; i++) {
            checkSizeCondition(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    String strError = String.format("Array[%s][%s] contains non-parsable value: '%s'", i+1, j+1, array[i][j]);
                    throw new MyDataArrayException(strError, e);
                }
            }
        }
        return result;
    }

    private void checkSizeCondition(String[][] array){
        if (array.length != 4){
            throw new MyArraySizeException();
        }
    }

    private void checkSizeCondition(String[] array){
        if (array.length != 4){
            throw new MyArraySizeException();
        }
    }
}
