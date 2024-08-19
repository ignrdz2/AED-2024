package com.example;

import java.util.Objects;
import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        
        Map<String, String> map = new HashMap<>();

        // Ejercicio 1
        map.values().removeIf(Objects::isNull);
        // Fin ejercio 1

        //Ejercicio 3
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Introduce las cadenas de caracteres (escribe 'fin' para terminar):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("fin")) {
                break;
            }
            strings.add(input);
        }

        Collections.sort(strings, Comparator.comparingInt(String::length).thenComparing(String::compareTo));

        System.out.println("Las cadenas ordenadas son:");
        for (String s : strings) {
            System.out.println(s);
        }
        //Fin ejercicio 3
    }

    // Ejercicio 2
    public static Map<String, String> invertMap(Map<String, String> map) throws IllegalArgumentException {
        Map<String, String> invertedMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (invertedMap.containsKey(entry.getValue())) {
                throw new IllegalArgumentException("El mapa contiene valores duplicados");
            }
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        return invertedMap;
    }
    // Fin ejercicio 2
}