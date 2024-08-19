package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Arbol arbol = new Arbol();
        arbol.insertar(43);
        arbol.insertar(10);
        arbol.insertar(8);
        arbol.insertar(54);
        arbol.insertar(15);
        arbol.insertar(50);
        arbol.insertar(53);

        System.out.println("InOrden: ");
        arbol.dispararInorden();

        System.out.println("\n========================");

        System.out.println("PostOrden: ");
        arbol.dispararPostOrden();

        System.out.println("\n========================");
        
        System.out.println("PreOrden: ");
        arbol.dispararPreorden();
    }
}
