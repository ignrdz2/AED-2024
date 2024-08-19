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

        arbol.insertar(4, "Cuatro");
        arbol.insertar(8, "Ocho");
        arbol.insertar(1, "Uno");
        arbol.insertar(9, "Nueve");
        arbol.insertar(7, "Siete");

        // arbol.preOrden(arbol.raiz);
        arbol.inOrden(arbol.raiz);
        // arbol.postOrden(arbol.raiz);

        
        if(arbol.buscar(9) == null){
            System.out.println("No se ha encontrado ese nodo en el arbol!");
        } else{
            System.out.println("Nodo encontrado!");
        }

        System.out.println("------------------------------");
        arbol.eliminar(9);
        arbol.inOrden(arbol.raiz);
    }
}
