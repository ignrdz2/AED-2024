package com.example;

public class NodoArbol {
    private int valor;
    private NodoArbol nodoIzq;
    private NodoArbol nodoDer;

    public NodoArbol(int valor){
        this.valor = valor;
        this.nodoIzq = null;
        this.nodoDer = null;
    }

    public int getValor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public NodoArbol getNodoIzq(){
        return nodoIzq;
    }
    public NodoArbol getNodoDer(){
        return nodoDer;
    }
    public void insertar(int value){
        if(value < this.valor){
            //Insertar en lado izquierdo.
            if(this.nodoIzq == null){
                this.nodoIzq = new NodoArbol(value);
            } else{
                this.nodoIzq.insertar(value);
            }
        } else{
            //Insertar en lado derecho.
            if(this.nodoDer == null){
                this.nodoDer = new NodoArbol(value);
            } else{
                this.nodoDer.insertar(value);
            }
        }
    }
}
