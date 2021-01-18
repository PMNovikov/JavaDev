package ru.geekbrains.animals;

public abstract class Animal {
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    private static int animalCounter;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.animalCounter++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static void showCounter()
    {
        System.out.println(String.format("Animals counter: %d", animalCounter));
    }

}
