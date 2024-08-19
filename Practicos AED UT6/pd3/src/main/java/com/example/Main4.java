package com.example;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Main4 {
    public static void main(String[] args) throws IOException {
        // Ejercicio  4
        if (args.length < 2) {
            System.out.println("Por favor, proporciona el nombre del archivo y el número de líneas a imprimir.");
            return;
        }

        Path path = Paths.get(args[0]);
        int linesToPrint = Integer.parseInt(args[1]);        
        int estimatedLineCount = (int)(Files.size(path) / 50); 

        List<String> lines = new ArrayList<>(estimatedLineCount);
        lines.addAll(Files.readAllLines(path));

        Random random = new Random();
        for (int i = 0; i < linesToPrint; i++) {
            System.out.println(lines.get(random.nextInt(lines.size())));
        }
    }
}
