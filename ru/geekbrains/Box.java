package ru.geekbrains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits;

    public <T> Box() {
        this.fruits = new ArrayList<>();
    }

    public Box(T... fruits){
        this();
        Collections.addAll(this.fruits, fruits);
    }

    public void add(T fruit){
        if (fruits.isEmpty() || fruits.get(0).getClass() == fruit.getClass()) {
            fruits.add(fruit);
        } else {
            throw new RuntimeException("Can't move different fruit in boxes.");
        }
    }

    public float getWeight(){
        float result = 0.0f;
        for (T fruit : fruits ) {
            result += fruit.getWight();
        }
        return result;
    }

    public boolean compare(Box<? extends Fruit> anotherBox){
        return (this.getWeight() == anotherBox.getWeight());
    }

    public void moveTo(Box<T> anotherBox){
        try {
            for (T fruit: fruits) {
               anotherBox.add(fruit);
            }
            fruits.clear();
        } catch (RuntimeException e){
            System.out.println(e);
        }
    }

    public String toString(){
        if (fruits.isEmpty()){
            return "Box is empty.";
        }
        return "Box [" + fruits.get(0) + "] = " + this.getWeight();
    }
}
