package ru.geekbrains;

public abstract class AbstractArrayCalculation {
    float[] arr;

    public AbstractArrayCalculation(float[] arr) {
        this.arr = arr;
    }


    protected void calculate(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
