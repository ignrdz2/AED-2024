package com.ut9;

public class Main {
    public static void main(String[] args) {
        //insercion
        int[] vector= {9,2,1,4,5};
        TClasificador clasificador = new TClasificador();
        int[] resClasificador = clasificador.clasificar(vector);
        System.out.println("Clasificador");
        for (int i = 0; i < resClasificador.length; i++) {
            System.out.println(resClasificador[i]);
        }
        System.out.println(clasificador.estaOrdenado(resClasificador));
        System.out.println("Insercion");
    int[] resInsercion= clasificador.OrdenarPorInsercion(vector);
    for (int i = 0; i < resInsercion.length; i++) {
        System.out.println(resInsercion[i]);
    }
    System.out.println(clasificador.estaOrdenado(resInsercion));
    System.out.println("pruebas");
    int[] vectorAscendente= {1,2,3,4,5};
    int[] vectorDescendente= {5,4,3,2,1};
    int[] vectorAleatorio=new int[5];
    for (int i = 0; i < 5; i++) {
        vectorAleatorio[i]= (int) (Math.random()*1000);
    }
    //Test 1
    System.out.println("Test 1");
    System.out.println(clasificador.estaOrdenado(vectorAscendente));
    System.out.println(clasificador.estaOrdenado(vectorDescendente));
    System.out.println(clasificador.estaOrdenado(vectorAleatorio));
    //Test 2
    System.out.println("Test 2");
    int[] resClasificadorAscendente = clasificador.clasificar(vectorAscendente);
    for (int i = 0; i < resClasificadorAscendente.length; i++) {
        System.out.println(resClasificadorAscendente[i]);
    }
    System.out.println(clasificador.estaOrdenado(resClasificadorAscendente));
    int[] resClasificadorDescendente = clasificador.clasificar(vectorDescendente);
    for (int i = 0; i < resClasificadorDescendente.length; i++) {
        System.out.println(resClasificadorDescendente[i]);
    }
    System.out.println(clasificador.estaOrdenado(resClasificadorDescendente));
    int[] resClasificadorAleatorio = clasificador.clasificar(vectorAleatorio);
    for (int i = 0; i < resClasificadorAleatorio.length; i++) {
        System.out.println(resClasificadorAleatorio[i]);
    }
    System.out.println(clasificador.estaOrdenado(resClasificadorAleatorio));
    //Test 3
    System.out.println("Test 3");
    int[] resInsercionAscendente= clasificador.OrdenarPorInsercion(vectorAscendente);
    for (int i = 0; i < resInsercionAscendente.length; i++) {
        System.out.println(resInsercionAscendente[i]);
    }
    System.out.println(clasificador.estaOrdenado(resInsercionAscendente));
    int[] resInsercionDescendente= clasificador.OrdenarPorInsercion(vectorDescendente);
    for (int i = 0; i < resInsercionDescendente.length; i++) {
        System.out.println(resInsercionDescendente[i]);
    }
    System.out.println(clasificador.estaOrdenado(resInsercionDescendente));
    int[] resInsercionAleatorio= clasificador.OrdenarPorInsercion(vectorAleatorio);
    for (int i = 0; i < resInsercionAleatorio.length; i++) {
        System.out.println(resInsercionAleatorio[i]);
    }
    System.out.println(clasificador.estaOrdenado(resInsercionAleatorio));
    //Tiempos.
    /*
    -Peor Caso (O(n²)): Ocurre cuando el vector está ordenado en orden descendente.
     Cada elemento necesita compararse con todos los elementos anteriores, resultando en 𝑂(𝑛^2) comparaciones y movimientos.

    -Mejor Caso (O(n)): Ocurre cuando el vector ya está ordenado en orden ascendente. Solo se realizan 𝑂(𝑛)
     comparaciones y no se realizan movimientos.

     -Caso Promedio (O(n²)): En promedio, el algoritmo también tiene un comportamiento de 
     𝑂(𝑛^2) porque aproximadamente la mitad de los elementos necesitan moverse.
    */    

    //shellSort
    int[] vectorShell= {9,2,1,4,5};
    TClasificador clasificadorShell = new TClasificador();
    int[] resClasificadorShell = clasificadorShell.clasificar(vectorShell);
    System.out.println("Clasificador");
    for (int i = 0; i < resClasificadorShell.length; i++) {
        System.out.println(resClasificadorShell[i]);
    }
    System.out.println(clasificadorShell.estaOrdenado(resClasificadorShell));
    System.out.println("Shell");
    int[] resShell= clasificadorShell.shellSort(vectorShell);
    for (int i = 0; i < resShell.length; i++) {
        System.out.println(resShell[i]);
    }
    System.out.println(clasificadorShell.estaOrdenado(resShell));
    System.out.println("pruebas");
    int[] vectorAscendenteShell= {1,2,3,4,5};
    int[] vectorDescendenteShell= {5,4,3,2,1};
    int[] vectorAleatorioShell=new int[5];
    for (int i = 0; i < 5; i++) {
        vectorAleatorioShell[i]= (int) (Math.random()*1000);
    }
    //Test 1
    System.out.println("Test 1");
    System.out.println(clasificadorShell.estaOrdenado(vectorAscendenteShell));
    System.out.println(clasificadorShell.estaOrdenado(vectorDescendenteShell));
    System.out.println(clasificadorShell.estaOrdenado(vectorAleatorioShell));
    //Test 2
    System.out.println("Test 2");
    int[] resClasificadorAscendenteShell = clasificadorShell.clasificar(vectorAscendenteShell);
    for (int i = 0; i < resClasificadorAscendenteShell.length; i++) {
        System.out.println(resClasificadorAscendenteShell[i]);
    }
    System.out.println(clasificadorShell.estaOrdenado(resClasificadorAscendenteShell));
    int[] resClasificadorDescendenteShell = clasificadorShell.clasificar(vectorDescendenteShell);
    for (int i = 0; i < resClasificadorDescendenteShell.length; i++) {
        System.out.println(resClasificadorDescendenteShell[i]);
    }
    System.out.println(clasificadorShell.estaOrdenado(resClasificadorDescendenteShell));
    int[] resClasificadorAleatorioShell = clasificadorShell.clasificar(vectorAleatorioShell);
    for (int i = 0; i < resClasificadorAleatorioShell.length; i++) {
        System.out.println(resClasificadorAleatorioShell[i]);
    }
    System.out.println(clasificadorShell.estaOrdenado(resClasificadorAleatorioShell));
    //Test 3
    System.out.println("Test 3");
    int[] resShellAscendente= clasificadorShell.shellSort(vectorAscendenteShell);
    for (int i = 0; i < resShellAscendente.length; i++) {
        System.out.println(resShellAscendente[i]);
    }
    System.out.println(clasificadorShell.estaOrdenado(resShellAscendente));
    int[] resShellDescendente= clasificadorShell.shellSort(vectorDescendenteShell);
    for (int i = 0; i < resShellDescendente.length; i++) {
        System.out.println(resShellDescendente[i]);
    }
    System.out.println(clasificadorShell.estaOrdenado(resShellDescendente));
    int[] resShellAleatorio= clasificadorShell.shellSort(vectorAleatorioShell);
    for (int i = 0; i < resShellAleatorio.length; i++) {
        System.out.println(resShellAleatorio[i]);
    }
    System.out.println(clasificadorShell.estaOrdenado(resShellAleatorio));
    //Tiempos.
    /*
    -Mejor Caso (O(n)): Ocurre cuando el vector está ya ordenado en orden ascendente. Solo se realizan 
    O(n) comparaciones y no se realizan movimientos.
    -Peor Caso (O(n²)): Ocurre cuando el vector está ordenado en orden descendente. Cada elemento necesita compararse con todos los elementos anteriores, resultando en 
    O(n^2) comparaciones y movimientos.
    -Caso Promedio (O(n²)): En promedio, el algoritmo tiene un comportamiento de 
    O(n^2) porque aproximadamente la mitad de los elementos necesitan moverse.
    */

    //burbuja
    int[] vectorBurbuja= {9,2,1,4,5};
    TClasificador clasificadorBurbuja = new TClasificador();
    int[] resClasificadorBurbuja = clasificadorBurbuja.clasificar(vectorBurbuja);
    System.out.println("Clasificador");
    for (int i = 0; i < resClasificadorBurbuja.length; i++) {
        System.out.println(resClasificadorBurbuja[i]);
    }
    System.out.println(clasificadorBurbuja.estaOrdenado(resClasificadorBurbuja));
    System.out.println("Burbuja");
    int[] resBurbuja= clasificadorBurbuja.burbuja(vectorBurbuja);
    for (int i = 0; i < resBurbuja.length; i++) {
        System.out.println(resBurbuja[i]);
    }
    System.out.println(clasificadorBurbuja.estaOrdenado(resBurbuja));
    System.out.println("pruebas");
    int[] vectorAscendenteBurbuja= {1,2,3,4,5};
    int[] vectorDescendenteBurbuja= {5,4,3,2,1};
    int[] vectorAleatorioBurbuja=new int[5];
    for (int i = 0; i < 5; i++) {
        vectorAleatorioBurbuja[i]= (int) (Math.random()*1000);
    }
    //Test 1
    System.out.println("Test 1");
    System.out.println(clasificadorBurbuja.estaOrdenado(vectorAscendenteBurbuja));
    System.out.println(clasificadorBurbuja.estaOrdenado(vectorDescendenteBurbuja));
    System.out.println(clasificadorBurbuja.estaOrdenado(vectorAleatorioBurbuja));
    //Test 2
    System.out.println("Test 2");
    int[] resClasificadorAscendenteBurbuja = clasificadorBurbuja.clasificar(vectorAscendenteBurbuja);
    for (int i = 0; i < resClasificadorAscendenteBurbuja.length; i++) {
        System.out.println(resClasificadorAscendenteBurbuja[i]);
    }
    System.out.println(clasificadorBurbuja.estaOrdenado(resClasificadorAscendenteBurbuja));
    int[] resClasificadorDescendenteBurbuja = clasificadorBurbuja.clasificar(vectorDescendenteBurbuja);
    for (int i = 0; i < resClasificadorDescendenteBurbuja.length; i++) {
        System.out.println(resClasificadorDescendenteBurbuja[i]);
    }
    System.out.println(clasificadorBurbuja.estaOrdenado(resClasificadorDescendenteBurbuja));
    int[] resClasificadorAleatorioBurbuja = clasificadorBurbuja.clasificar(vectorAleatorioBurbuja);
    for (int i = 0; i < resClasificadorAleatorioBurbuja.length; i++) {
        System.out.println(resClasificadorAleatorioBurbuja[i]);
    }
    System.out.println(clasificadorBurbuja.estaOrdenado(resClasificadorAleatorioBurbuja));
    //Test 3
    System.out.println("Test 3");
    int[] resBurbujaAscendente= clasificadorBurbuja.burbuja(vectorAscendenteBurbuja);
    for (int i = 0; i < resBurbujaAscendente.length; i++) {
        System.out.println(resBurbujaAscendente[i]);
    }
    System.out.println(clasificadorBurbuja.estaOrdenado(resBurbujaAscendente));
    int[] resBurbujaDescendente= clasificadorBurbuja.burbuja(vectorDescendenteBurbuja);
    for (int i = 0; i < resBurbujaDescendente.length; i++) {
        System.out.println(resBurbujaDescendente[i]);
    }
    System.out.println(clasificadorBurbuja.estaOrdenado(resBurbujaDescendente));
    int[] resBurbujaAleatorio= clasificadorBurbuja.burbuja(vectorAleatorioBurbuja);
    for (int i = 0; i < resBurbujaAleatorio.length; i++) {
        System.out.println(resBurbujaAleatorio[i]);
    }
    System.out.println(clasificadorBurbuja.estaOrdenado(resBurbujaAleatorio));
    //Tiempos.
    /*
    -Mejor Caso (O(n))
    El mejor caso ocurre cuando el vector ya está ordenado en orden ascendente. En este caso, solo se realizan 
    O(n) comparaciones y no se realizan movimientos, ya que el algoritmo puede detectar que no hay necesidad de más intercambios en la primera pasada.
    -Peor Caso (O(n²))
    El peor caso ocurre cuando el vector está ordenado en orden descendente. En este caso, cada elemento necesita compararse con todos los elementos anteriores y realizar intercambios, resultando en 
    O(n^2) comparaciones y movimientos.
    -Caso Promedio (O(n²))
    En promedio, el algoritmo tiene un comportamiento de 
    O(n^2) porque aproximadamente la mitad de los elementos necesitan moverse.
    */
}
}