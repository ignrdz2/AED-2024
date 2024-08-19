package com.example;

import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ListaEnlazada listaEnlazada = new ListaEnlazada();
        listaEnlazada.insertar(new Cancion("A Don Jose", "/aDonJose.mp3", 123));
        listaEnlazada.insertar(new Cancion("Me Llama", "/mellama.mp3", 999));
        listaEnlazada.insertar(new Cancion("Innuendo", "/innuendo.mp3", 241));

        listaEnlazada.mostrarElementos();

        LinkedList<Cancion> listaJava = new LinkedList<>();
        listaJava.add(new Cancion("A Don Jose", "/aDonJose.mp3", 123));
        listaJava.add(new Cancion("Me Llama", "/mellama.mp3", 999));
        listaJava.add(new Cancion("Innuendo", "/innuendo.mp3", 241));

        System.out.println("----------------------------------------------------------------");

        for(int i = 0; i < listaJava.size(); i++){
            Cancion c = listaJava.get(i);
            System.out.println(c.getNombre() + " | " + c.getDuracion() + " | " + c.getRuta());
        }
    }
}
