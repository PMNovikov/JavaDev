package ru.geekbrains.lesson07;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n){
        if (n > food){
            return false;
        }
        food -= n;
        return true;
    }

    public void addFood(int quantity){
        food += quantity;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
