package com.example;

public class contador {
    int MAX_CONT = 50;
    int incremento = 1;
    int contador = 1;

    public void mostrarContador(){
        int i = 1;
        while(i <= MAX_CONT){
            System.out.println(contador);
            contador += incremento;
            i++;
        }
    }

    public void mostrarContadorDW(){
        int i = 1;
        do{
            System.out.println(contador);
            contador += incremento;
            i++;
        } while(i <= MAX_CONT);
    }

    public void mostrarContadorFor(){
        for(int i = 1; i <= MAX_CONT; i++){
            System.out.println(contador);
            contador += incremento;
        }
    }
}
