package ru.geekbrains;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        executeVariant1();
        executeVariant2();
    }

    public static void executeVariant1(){
        float[] arr = getDefaultArray();
        System.out.println("Start calculating variant 1.");
        long timeBegin = System.currentTimeMillis();
        ArrayCalculation ac = new ArrayCalculation(arr);
        ac.calculate();
        long timeEnd = System.currentTimeMillis();
        System.out.println("Calculated " + size + " elements of array in " + (timeEnd - timeBegin) + " ms.");
    }

    public static void executeVariant2(){
        float arr[] = getDefaultArray();
        System.out.println("Start calculating variant 2.");

        long timeBegin = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        ArrayCalculationThread act1 = new ArrayCalculationThread(a1);
        ArrayCalculationThread act2 = new ArrayCalculationThread(a2);

        try {
            act1.join();
            act2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long timeEnd = System.currentTimeMillis();

        System.out.println("Calculated " + size + " elements of array in " + (timeEnd - timeBegin) + " ms.");
    }

    public static float[] getDefaultArray(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        return arr;
    }
}
