package uy.edu.ucu.aed;

public class Main {
    public static void main(String[] args) {
        // Ruta del archivo a manejar
        String nombreArchivo = "archivo.txt";

        // Escribir en el archivo
        String[] lineasParaEscribir = {"Linea 1", "Linea 2", "Linea 3"};
        ManejadorArchivosGenerico.escribirArchivo(nombreArchivo, lineasParaEscribir);

        // Leer del archivo
        String[] lineasLeidas = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        for (String linea : lineasLeidas) {
            System.out.println(linea);
        }
    }
}
