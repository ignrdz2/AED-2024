package com.example;

/**
 * Hello world!
 *
 */
public class Parcial1 {
    public static void main(String[] args) {
        // Ejemplo para la ListaOrdenada
        IListaOrdenada<Integer> unaListaOrdenada = new ListaOrdenada<>();
        IListaOrdenada<Integer> otraListaOrdenada = new ListaOrdenada<>();

        unaListaOrdenada.insertarOrdenado(1);
        unaListaOrdenada.insertarOrdenado(2);
        unaListaOrdenada.insertarOrdenado(4);
        unaListaOrdenada.insertarOrdenado(5);
        unaListaOrdenada.insertarOrdenado(8);
        unaListaOrdenada.insertarOrdenado(9);

        otraListaOrdenada.insertarOrdenado(2);
        otraListaOrdenada.insertarOrdenado(3);
        otraListaOrdenada.insertarOrdenado(6);
        otraListaOrdenada.insertarOrdenado(7);

        System.out.print("unaListaOrdenada: ");
        unaListaOrdenada.imprimir(",");

        System.out.print("otraListaOrdenada: ");
        otraListaOrdenada.imprimir(",");

        IListaOrdenada<Integer> resultadoListaOrdenada = unaListaOrdenada.mezclar(otraListaOrdenada);

        System.out.print("resultadoListaOrdenada: ");
        resultadoListaOrdenada.imprimir(",");

        // Ejemplo para Lista
        ILista<Integer> unaLista = new Lista<>();
        unaLista.insertar(1);
        unaLista.insertar(2);
        unaLista.insertar(3);
        unaLista.insertar(3);
        unaLista.insertar(3);
        unaLista.insertar(4);
        unaLista.insertar(5);
        unaLista.insertar(6);
        unaLista.insertar(7);
        unaLista.insertar(7);
        unaLista.insertar(8);

        System.out.print("unaLista: ");
        unaLista.imprimir(",");

        unaLista.retirarDuplicados();

        System.out.print("unaLista después de retirar duplicados: ");
        unaLista.imprimir(",");
    }
}


