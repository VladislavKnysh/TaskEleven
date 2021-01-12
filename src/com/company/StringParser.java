package com.company;

import java.util.HashMap;
import java.util.Set;


public class StringParser {
    private final HashMap<String, Integer> hashMap;


    public StringParser() {
        this.hashMap = new HashMap<>();

    }

    public void displayHashMap() {
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + hashMap.get(key));
        }
    }


    public void parseString(String string) {
        StringChopper stringChopper = new StringChopper(string, "[а-яА-я]+|[a-zA-Z]+");
        String[] words = stringChopper.generateArray();
        if (words.length != 0) {
            updateHashMap(words);
        } else {
            System.out.println("Your string has no words");
        }
    }

    private void updateHashMap(String[] words) {
        for (String word : words) {
            if (hashMap.containsKey(word)) {
                hashMap.put(word, hashMap.get(word) + 1);
            } else {
                hashMap.put(word, 1);
            }
        }

    }
}





