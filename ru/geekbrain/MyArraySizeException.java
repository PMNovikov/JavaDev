package ru.geekbrain;

public class MyArraySizeException extends RuntimeException{
    private static String message = "Array should be size 4x4.";

    public MyArraySizeException() {
        super(message);
    }

    public MyArraySizeException(Throwable cause) {
        super(message, cause);
    }

}
