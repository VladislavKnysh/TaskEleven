package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringChopper {

    private final String stringToChop;
    private final String patternString;

    public StringChopper(String stringToChop, String patternString) {
        this.stringToChop = stringToChop;
        this.patternString = patternString;
    }

    public String[] generateArray() {
        Pattern pattern = Pattern.compile(this.patternString);
        Matcher matcher = pattern.matcher(stringToChop);
        int i = getNumberOfWords(matcher);
        String[] words = new String[i];
        int j = 0;
        matcher.reset();
        while (matcher.find()) {


            words[j++] = stringToChop.substring(matcher.start(), matcher.end());

        }
        return words;
    }

    private int getNumberOfWords(Matcher matcher) {
        int i = 0;
        while (matcher.find()) {
            i++;
        }
        return i;
    }
}
