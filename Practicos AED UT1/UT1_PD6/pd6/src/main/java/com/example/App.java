package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // imprimirTablero(7, 7);
        // leerEntradaArchivo("src/entrada.txt");
        // leerEntradaStdin();
        //transformarTextoT9("src/entrada.txt");
        transformarT9Texto("src/entrada.txt");

        // int[] vector1 = {1, 2, 3};
        // int[] vector2 = {4, 5, 6};
        // Integer resultado = multiplicarVectores(vector1, vector2);
        // if (resultado != null) {
        //     System.out.println("El resultado de la multiplicación de los vectores es: " + resultado);
        // }
    }

    public static Integer multiplicarVectores(int[] vector1, int[] vector2) {
        if (vector1.length != vector2.length) {
            System.out.println("Los vectores deben tener la misma longitud para poder multiplicarse.");
            return null;
        }
    
        int resultado = 0;
        for (int i = 0; i < vector1.length; i++) {
            resultado += vector1[i] * vector2[i];
        }
    
        return resultado;
    }

    public static void transformarT9Texto(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
             PrintWriter writer = new PrintWriter(new FileWriter("salida.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder sb = new StringBuilder(line);
                sb.reverse(); // invertir la línea
                for (char c : sb.toString().toUpperCase().toCharArray()) {
                    writer.print(T9_MAP.get(c));
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final Map<Character, String> T9_MAP = new HashMap<Character, String>() {{
        put('A', "2"); put('B', "2"); put('C', "2");
        put('D', "3"); put('E', "3"); put('F', "3");
        put('G', "4"); put('H', "4"); put('I', "4");
        put('J', "5"); put('K', "5"); put('L', "5");
        put('M', "6"); put('N', "6"); put('O', "6");
        put('P', "7"); put('Q', "7"); put('R', "7"); put('S', "7");
        put('T', "8"); put('U', "8"); put('V', "8");
        put('W', "9"); put('X', "9"); put('Y', "9"); put('Z', "9");
        put(' ', "0"); put('.', "1");
    }};

     public static void transformarTextoT9(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
             PrintWriter writer = new PrintWriter(new FileWriter("salida.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toUpperCase().toCharArray()) {
                    writer.print(T9_MAP.get(c));
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerEntradaStdin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el radio de la circunferencia: ");
        double radio = sc.nextDouble();

        double area = Math.PI * (radio * radio);
        double perimetro = (radio * 2) * Math.PI;

        System.out.printf("Área de la circunferencia: %.2f\n", area);
        System.out.printf("Perímetro de la circunferencia: %.2f\n", perimetro);

        sc.close();
    }

    public static void imprimirTablero(int largo, int ancho){
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void leerEntradaArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            int entero = Integer.parseInt(br.readLine());
            double flotante = Double.parseDouble(br.readLine());
            String cadena = br.readLine();

            System.out.println("El entero leído es: " + entero);
            System.out.println("El número de punto flotante es: " + flotante);
            System.out.println("La cadena leída es \"" + cadena + "\"");
            System.out.println("¡Hola " + cadena + "! La suma de " + entero + " y " + flotante + " es " + (entero + flotante) + ".");
            System.out.println("La división entera de " + flotante + " y " + entero + " es " + ((int) (flotante / entero)) + " y su resto es " + (flotante % entero) + ".");
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
