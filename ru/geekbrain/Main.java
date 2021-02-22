package ru.geekbrain;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    doTask1();
	    doTask2();
    }

    public static void doTask1(){
        String[] array = {
                "Task1","Task2","Task1","Task3","Task4",
                "Task1","Task2","Task3","Task3","Task4",
                "Task1","Task2","Task1","Task3","Task4",
                "Task1","Task5","Task1","Task3","Task4"
        };

        //Вариант подсчета количества уникальных слов с коллецией Set
        Set<String> uniqueString1 = new HashSet<String>(Arrays.asList(array));
        System.out.println("[1] Find " + uniqueString1.size() + " unique word: " + uniqueString1);

        Map<String, Integer> wordCounter = new HashMap<String, Integer>();
        for (String word : array) {
            if (wordCounter.containsKey(word)){
                wordCounter.put(word, wordCounter.get(word) + 1);
            } else {
                wordCounter.put(word, 1);
            }
        }
        //Вариант подсчета количества уникальных слов с коллекцией Map
        Set<String> uniqueString2 = wordCounter.keySet();
        System.out.println("[2] Find " + uniqueString2.size() + " unique word: " + uniqueString2);

        System.out.println("Word counter: " + wordCounter);
    }

    public static void doTask2(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nick", "112");
        phoneBook.add("Jack", "113");
        phoneBook.add("Jack", "114");
        phoneBook.add("Mike", "115");

        Set<String> phoneNames = phoneBook.getNames();
        System.out.println("Phone Book contains " + phoneNames.size() + " record.");
        for (String name: phoneNames){
            System.out.println("Record: " + name + " - " + phoneBook.get(name));
        }
    }
}
