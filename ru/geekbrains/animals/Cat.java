package ru.geekbrains.animals;

public class Cat extends Animal {
    private static int catCounter;

    public Cat(String name) {
        super(name, 200, 0);
        catCounter++;
    }

    public static void showCounter() {
        System.out.println(String.format("Cats counter: %d", catCounter));
    }

    @Override
    public void swim(int distance) {
        if (maxSwimDistance == 0){
            System.out.println(String.format("Cat %s can't swim.", name));
        } else if (maxSwimDistance >= distance) {
            System.out.println(String.format("Cat %s swim %d m.", name, distance));
        } else {
            System.out.println(String.format("Cat %s can't swim %d m. Maximum swim distance: %d m.", name, distance, maxSwimDistance));
        }

    }

    @Override
    public void run(int distance) {
        if (maxRunDistance == 0){
            System.out.println(String.format("Cat %s can't run.", name));
        } else if (maxRunDistance >= distance) {
            System.out.println(String.format("Cat %s run %d m.", name, distance));
        } else {
            System.out.println(String.format("Cat %s can't run %d m. Maximum run distance: %d m.", name, distance, maxSwimDistance));
        }
    }
}
