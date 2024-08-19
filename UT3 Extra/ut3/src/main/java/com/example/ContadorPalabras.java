package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContadorPalabras {
    String palabra;
    String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] vocals = {"a", "e", "i", "o", "u"};

    public ContadorPalabras(){

    }
    public void procesarArchivo(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lineas.size() < 2) {
            System.out.println("El archivo debe contener al menos dos líneas.");
            return;
        }

        // Seleccionar dos líneas al azar
        Random rand = new Random();
        String linea1 = lineas.get(rand.nextInt(lineas.size()));
        String linea2 = lineas.get(rand.nextInt(lineas.size()));

        // Dividir las líneas en palabras
        String[] palabras1 = linea1.split("\\s+");
        String[] palabras2 = linea2.split("\\s+");

        // Encontrar la intersección y imprimir el resultado
        String[] interseccion = interStrings(palabras1, palabras2);
        System.out.println(Arrays.toString(interseccion));
    }

    public String[] interStrings(String[] arr1, String[] arr2){
        List<String> intersection = new ArrayList<>();

        for (String s : arr1) {
            for (String value : arr2) {
                if (s.equals(value)) {
                    intersection.add(s);
                    break;
                }
            }
        }

        return intersection.toArray(new String[intersection.size()]);
    }

    public String[] obtenerLineas (String archivo) {
        ArrayList<String> listaLineasArchivo = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                listaLineasArchivo.add(linea);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + archivo);
            e.printStackTrace();
        }
        return listaLineasArchivo.toArray(new String[0]);
    }

    public int cantPalabras (String[] lineasArchivo) {
        int count = 0;
        for (String linea : lineasArchivo) {
            count += contarPalabras(linea);
        }
        return count;
    }

    public int GetConsonants(String frase){
        int count = 0;

        for(char letra : frase.toCharArray()){
            if(Character.isLetter(letra) && !Arrays.asList(vocals).contains(String.valueOf(letra))) {
                count++;
            }
        }

        return count;
    }

    public int GetVocals(String frase) {
        int count = 0;
        for (char letra : frase.toCharArray()) {
            if (Arrays.asList(vocals).contains(String.valueOf(letra))) {
                count++;
            }
        }
        return count;
    }

    public int contarPalabras(String frase){
        int count = 0;
        boolean isWord = false;
        boolean containsAlphabetic = false;
    
        for (char letra : frase.toCharArray()) {
            if (letra == ' ') {
                if (isWord && containsAlphabetic) {
                    count++;
                }
                isWord = false;
                containsAlphabetic = false;
            } else {
                isWord = true;
                if (Character.isLetter(letra)) {
                    containsAlphabetic = true;
                }
            }
        }
    
        // If the last word doesn't end with a space, count it
        if (isWord && containsAlphabetic) {
            count++;
        }
    
        return count;
    }

    public int palabraMayoresX(String frase, int x) {
        int count = 0;
        boolean isWord = false;
        int longitudPalabra = 0;

        for (int i =0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (Character.isLetter(c)) {
                isWord = true;
                longitudPalabra++;
            } else if (isWord){
                if (longitudPalabra > x) {
                    count++;
                }
                longitudPalabra = 0;
                isWord = false;
            }
        }
        if (isWord && longitudPalabra > x) {
            count++;
        }
        return count;
    }

    public boolean isNumber(char letra){
        if(!Arrays.asList(numbers).contains(String.valueOf(letra)) ){
            return false;
        }
        return true;
    }




}
