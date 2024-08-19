package com.example;

public class Arbol {

    Nodo raiz;
    public Arbol(){
        raiz = null;
    }

    public void insertar(int i, String dato){
        Nodo n = new Nodo(i);
        n.contenido = dato;

        if(raiz == null){
            raiz = n;
        } else{
            Nodo aux = raiz;
            while(aux != null){
                n.padre = aux;
                if(n.llave >= aux.llave){
                    aux = aux.derecha;
                } else{
                    aux = aux.izquierda;
                }
            }

            if(n.llave < n.padre.llave){
                n.padre.izquierda = n;
            } else {
                n.padre.derecha = n;
            }
        }
    }

    public void preOrden(Nodo n){
        if(n == null) return;
        else {
            System.out.println(n.llave + " -> " + n.contenido);
            preOrden(n.izquierda);
            preOrden(n.derecha);
        }
        return;
    }

    public void inOrden(Nodo n){
        if(n == null) return;
        else {
            inOrden(n.izquierda);
            System.out.println(n.llave + " -> " + n.contenido);
            inOrden(n.derecha);
        }
        return;
    }

    public void postOrden(Nodo n){
        if(n == null) return;
        else {
            postOrden(n.izquierda);
            postOrden(n.derecha);
            System.out.println(n.llave + " -> " + n.contenido);
        }
        return;
    }

    public Nodo buscar(int id){
        Nodo aux = raiz;
        while(aux.llave != id){
            if(id < aux.llave){
                aux = aux.izquierda;
            } else{
                aux = aux.derecha;
            }
            if(aux == null){
                return null;
            }
        }
        return aux;
    }

    public boolean eliminar(int id){
        Nodo aux = raiz;
        Nodo padre = raiz;
        boolean esIzq = true;

        while(aux.llave != id){
            padre = aux;
            if(id < aux.llave){
                esIzq = true;
                aux = aux.izquierda;
            } else{
                esIzq = false;
                aux = aux.derecha;
            }
            // Llegó hasta el final y no lo encontró 
            if(aux == null){
                return false;
            }
        } //Fin del while

        //Caso que sea una hoja
        if(aux.izquierda == null && aux.derecha == null){
            if(aux == raiz){
                raiz = null;
            } else if(esIzq){
                padre.izquierda = null;
            } else{
                padre.derecha = null;
            }
        //
        } else if(aux.derecha == null){
            if(aux == raiz){
                raiz = aux.izquierda;
            } else if(esIzq){
                padre.izquierda = aux.izquierda;
            } else{
                padre.derecha = aux.izquierda;
            }
        //
        } else if(aux.izquierda == null){
            if(aux == raiz){
                raiz = aux.derecha;
            } else if(esIzq){
                padre.derecha = aux.derecha;
            } else{
                padre.izquierda = aux.derecha;
            }
        //
        } else{
            Nodo reemplazo = obtenerNodoReemplazo(aux);
            if(aux == raiz){
                raiz = reemplazo;
            } else if(esIzq){
                padre.izquierda = reemplazo;
            } else{
                padre.derecha = reemplazo;
            }
            reemplazo.izquierda = aux.izquierda;
        }
        return true;
    }

    public Nodo obtenerNodoReemplazo(Nodo nodoReemp){
        Nodo reemplazarPadre = nodoReemp;
        Nodo reemplazo = nodoReemp;
        Nodo aux = nodoReemp.derecha;

        while(aux != null){
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.izquierda;
        }
        if(reemplazo != nodoReemp.derecha){
            reemplazarPadre.izquierda = reemplazo.derecha;
            reemplazo.derecha = nodoReemp.derecha;
        }
        System.out.println("El nodo reemplazo es: " + reemplazo);
        return reemplazo;
    }

    
    private class Nodo{
        public Nodo padre;
        public Nodo derecha;
        public Nodo izquierda;
        public int llave;
        public String contenido;

        public Nodo(int indice){
            llave = indice;
            derecha = null;
            izquierda = null;
            padre = null;
            contenido = null;
        }
    }

}
