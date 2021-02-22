package ru.geekbrain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private final Map<String, Set<String>> records = new HashMap<>();

    public void add(String name, String phone){
        if (records.containsKey(name)){
            records.get(name).add(phone);
        } else {
            Set<String> phones = new HashSet<>();
            phones.add(phone);
            records.put(name, phones);
        }
    }

    public Set<String> get(String name){
        if (records.containsKey(name)){
            return records.get(name);
        }
        return new HashSet<String>();
    }

    public Set<String> getNames(){
        if (records.isEmpty()){
            return new HashSet<String>();
        }
        return records.keySet();
    }
}
