package uy.edu.ucu.aed.parcial2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uy.edu.ucu.aed.*;

/**
 * Algoritmo y Estrucutras de Datos
 * Parcial 2 - Parte 3
 *
 */
public class MainParcial2 {
    public static void main(String[] args) {
        // Cargar grafo a partir de archivos de entrada
        TGrafoDeLaRed grafo = UtilGrafos.cargarGrafo("C:\\Users\\ignrd\\OneDrive\\Escritorio\\parcial2_alumnos_2\\Parcial2\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial2\\vertices.txt",
                "C:\\Users\\ignrd\\OneDrive\\Escritorio\\parcial2_alumnos_2\\Parcial2\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial2\\aristas.txt", false, TGrafoDeLaRed.class,
                TVerticeDeLaRed.class);

        // Calculo de todos los caminos entre dos vertices
        TCaminos<TEstacionDeLaRed> caminos = grafo.caminosDesdeHasta("Vertice_3", "Vertice_4");

        // Escribir archivo de salida con el resultado de la llamada anterior, con los
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ignrd\\OneDrive\\Escritorio\\parcial2_alumnos_2\\Parcial2\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial2\\salida.txt"))) {
            for (TCamino<TEstacionDeLaRed> camino : caminos) {
                writer.write(camino.toString());
                writer.newLine(); // Esto asegura que cada camino esté en una línea separada
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // caminos ordenados de menor a mayor costo, uno por línea.
        String archivoEntrada = "C:\\Users\\ignrd\\OneDrive\\Escritorio\\parcial2_alumnos_2\\Parcial2\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial2\\salida.txt";
        String archivoSalida = "C:\\Users\\ignrd\\OneDrive\\Escritorio\\parcial2_alumnos_2\\Parcial2\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial2\\caminos_ordenados.txt";
        ArrayList<CaminoCosto> caminoss = leerCaminos(archivoEntrada);
        heapSort(caminoss);
        escribirCaminosOrdenados(caminoss, archivoSalida);

    }

    private static ArrayList<CaminoCosto> leerCaminos(String archivo) {
        ArrayList<CaminoCosto> caminos = new ArrayList<>();
        Pattern pattern = Pattern.compile("Costo Total: (\\d+\\.?\\d*)$");
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    double costo = Double.parseDouble(matcher.group(1));
                    caminos.add(new CaminoCosto(line, costo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return caminos;
    }

    private static void heapSort(ArrayList<CaminoCosto> arr) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            CaminoCosto temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(ArrayList<CaminoCosto> arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr.get(left).costo > arr.get(largest).costo)
            largest = left;
        if (right < n && arr.get(right).costo > arr.get(largest).costo)
            largest = right;
        if (largest != i) {
            CaminoCosto swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
            heapify(arr, n, largest);
        }
    }

    private static void escribirCaminosOrdenados(ArrayList<CaminoCosto> caminos, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (CaminoCosto camino : caminos) {
                writer.write(camino.camino);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class CaminoCosto {
        String camino;
        double costo;

        public CaminoCosto(String camino, double costo) {
            this.camino = camino;
            this.costo = costo;
        }
    }
}
