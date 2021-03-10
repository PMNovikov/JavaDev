package ru.geekbrains;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
    }

    public static void doTask1(){
        //1. Написать метод, который меняет два элемента массива местами.
        // (массив может быть любого ссылочного типа);
        System.out.println("Task 1");
        String[] array = {"String", "One", "Two", "Three"};
        System.out.println("Array before: " + Arrays.toString(array));
        swapElements(array, 1,3);
        System.out.println("Array after: " + Arrays.toString(array));
    }

    public static <T> void swapElements(T[] array, int first, int second){
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void doTask2(){
        //2. Написать метод, который преобразует массив в ArrayList;
        System.out.println("Task 2");
        String[] array = {"String", "One", "Two", "Three"};
        List<String> result = getArrayList(array);
        System.out.println("Result: " + result.getClass().getName() + " " + result.toString());
    }

    public static <T> List<T> getArrayList(T[] array){
        ////вариант 1
        //return Arrays.asList(array);

        //Вариант 2
        List<T> result = new ArrayList<>();
        Collections.addAll(result, array);
        return result;
    }

    public static void doTask3(){
        Box box1 = new Box<Apple>(new Apple(), new Apple(), new Apple());
        Box box2 = new Box<Orange>(new Orange(), new Orange(), new Orange(), new Orange());
        Box box3 = new Box<Apple>(new Apple(), new Apple(), new Apple());
        System.out.println("Box1: " + box1);
        System.out.println("Box2: " + box2);
        System.out.println("Box3: " + box3);
        System.out.println("Compare (Box2 == Box3) = " + box2.compare(box3));
        box1.moveTo(box2);
        box1.moveTo(box3);
        System.out.println("Box1: " + box1);
        System.out.println("Box2: " + box2);
        System.out.println("Box3: " + box3);
        System.out.println("Compare (Box2 == Box3) = " + box2.compare(box3));
    }
}
