package ru.geekbrains.lesson07;

public class Main {

    public static void main(String[] args) {
        Cat[] cat = {new Cat("Barsik", 10),
                        new Cat("Simon", 15),
                        new Cat("Vas'ka", 30)};
        Plate plate = new Plate(30);
        System.out.println(plate);
        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
            System.out.println(cat[i]);
        }
        System.out.println(plate);
    }
}
