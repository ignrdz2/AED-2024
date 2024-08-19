package com.ut9;

public class Main {
    public static void main(String[] args) {
      int [] vector = {44 , 55 , 12 , 42 , 94 , 18 , 6 , 67};
      TClasificador clasificador = new TClasificador();
      int [] resultado= clasificador.quickSort(vector);
      //¿cuántas llamadas se realizan en total al método “Quicksort” (contando la inicial)
      //se hacen 4 llamadas al metodo
      //¿cuál es el máximo nivel de profundidad recursiva alcanzado?
      System.out.println(clasificador.maxDepth);
      //el maximo nivel de profundidad es 4
}
}