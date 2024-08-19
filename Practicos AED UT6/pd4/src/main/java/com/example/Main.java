package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ignrd\\OneDrive\\Escritorio\\Practicos AED UT6\\pd4\\src\\libro.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> sortedByCount = wordCount.entrySet()
            .stream()
            .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(10)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sortedByCount);
    }
}