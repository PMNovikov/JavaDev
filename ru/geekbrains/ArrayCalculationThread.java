package ru.geekbrains;

public class ArrayCalculationThread extends AbstractArrayCalculation implements Runnable {
    private Thread thread;

    public ArrayCalculationThread(float[] arr) {
        super(arr);
        thread = new Thread(this);
        thread.start();
    }

    public void join() throws InterruptedException {
        thread.join();
    }

    @Override
    public void run() {
        calculate();
    }
}
