package com.example;

public class Arbol {
    NodoArbol inicial;

    public Arbol(){
        this.inicial = null;
    }

    public void insertar(int valor){
        if(this.inicial == null){
            this.inicial = new NodoArbol(valor);
        } else{
            //Aca se da inicio a la recursividad.
            this.inicial.insertar(valor);
        }
    }

    //Pre Orden
    public void dispararPreorden(){
        this.preOrden(this.inicial);
    }
    public void preOrden(NodoArbol nodo){
        if(nodo == null){
            return; //Detener recursividad (Cado Base).
        } else{
            System.out.print(nodo.getValor() + " ");
            preOrden(nodo.getNodoIzq());
            preOrden(nodo.getNodoDer());
        }
    }

    //In Orden
    public void dispararInorden(){
        this.inOrden(this.inicial);
    }
    public void inOrden(NodoArbol nodo){
        if(nodo == null){
            return; //Detener recursividad (Cado Base).
        } else{
            inOrden(nodo.getNodoIzq());
            System.out.print(nodo.getValor() + " ");
            inOrden(nodo.getNodoDer());
        }
    }

    //Post Orden
    public void dispararPostOrden(){
        this.postOrden(this.inicial);
    }
    public void postOrden(NodoArbol nodo){
        if(nodo == null){
            return; //Detener recursividad (Cado Base).
        } else{
            postOrden(nodo.getNodoIzq());
            postOrden(nodo.getNodoDer());
            System.out.print(nodo.getValor() + " ");
        }
    }
}
