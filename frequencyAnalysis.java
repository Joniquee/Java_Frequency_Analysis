package Homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class frequencyAnalysis {
    private static HashMap<Character, Integer> freq = new HashMap<>();
    public static boolean inAlphabet(int i){
        return (i >= 65 && i <= 90) || (i >= 97 && i <= 122);
    }
    public static void addSymbol(char s){
        if (!freq.containsKey(s)) freq.put(s, 1);
        else {
            int v = freq.get(s);
            freq.put(s, ++v);
        }
    }
    public static String[] getTable(){
        String[] finalArr = new String[freq.size()];
        int i = 0;
        for(Map.Entry<Character, Integer> symbol : freq.entrySet()){
            finalArr[i] = symbol.getKey() + " = " + symbol.getValue();
            i++;
        }
        return finalArr;
    }
}



