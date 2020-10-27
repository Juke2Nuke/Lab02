package com.example.lab02;

public class Counting{
    String inputProcess(String input)
    {
        input = input.replaceAll("[^a-zA-Z0-9]", " ");

        return input;
    }
    public int symbolCounting(String input){
        int spaceCount;
        spaceCount = 0;
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        int symbolCount;
        symbolCount = 0;
        for (char c : inputProcess(input).toCharArray()) {
            if (c == ' ') {
                symbolCount++;
            }
        }
        symbolCount = symbolCount-spaceCount;
        return symbolCount;
    }
    public int wordCounting(String input){
        String[] words = inputProcess(input).split("\\s+");
        return words.length;
    }

}
