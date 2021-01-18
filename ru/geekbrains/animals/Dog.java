package ru.geekbrains.animals;

public class Dog extends Animal {
    private static int dogCounter;
    public Dog(String name) {
        super(name, 500, 10);
        dogCounter++;
    }

    public static void showCounter() {
        System.out.println(String.format("Dogs counter: %d", dogCounter));
    }

    @Override
    public void swim(int distance) {
        if (maxSwimDistance == 0){
            System.out.println(String.format("Dog %s can't swim.", name));
        } else if (maxSwimDistance >= distance) {
            System.out.println(String.format("Dog %s swim %d m.", name, distance));
        } else {
            System.out.println(String.format("Dog %s can't swim %d m. Maximum swim distance: %d m.", name, distance, maxSwimDistance));
        }
    }

    @Override
    public void run(int distance){
        if (maxRunDistance == 0){
            System.out.println(String.format("Dog %s can't run.", name));
        } else if (maxRunDistance >= distance) {
            System.out.println(String.format("Dog %s run %d m.", name, distance));
        } else {
            System.out.println(String.format("Dog %s can't run %d m. Maximum run distance: %d m.", name, distance, maxSwimDistance));
        }
    }
}
