package ru.geekbrains.lesson07;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public Cat(String name) {
        new Cat(name, 10);
    }

    public void eat(Plate p){
        satiety = p.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}
