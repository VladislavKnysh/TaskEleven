package com.company;

import java.util.ArrayList;
import java.util.HashMap;


public class StringParser {
    private final HashMap<String, Integer> hashMap;
    private final ArrayList<String> keyList;

    public StringParser() {
        this.hashMap = new HashMap<>();
        this.keyList = new ArrayList<>();
    }

    public void displayHashMap(){
        for (String key:keyList) {
            System.out.println(key+": "+ hashMap.get(key));
        }
    }


    public void parseString(String string) {
        StringChopper stringChopper = new StringChopper(string, "[а-яА-я]+|[a-zA-Z]+");
        String[] words = stringChopper.generateArray();
        updateKeyList(words);
        if(!keyList.isEmpty()){
            updateHashMap(words);
        }else {
            System.out.println("Your string has no words");
        }
    }

    private void updateKeyList(String[] words) {
        for (String word : words) {
            if (!keyList.contains(word)) {
                keyList.add(word);
            }

        }
    }

    private void updateHashMap(String[] words){
        for (String key:keyList) {
            int input = 0;
            for (String word:words) {
                if (key.equalsIgnoreCase(word)){
                    input++;
                }
            }
            hashMap.put(key, input);
        }
    }





}
