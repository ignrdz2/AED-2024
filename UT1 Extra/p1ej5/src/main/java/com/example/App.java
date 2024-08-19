package com.example;

public class App 
{
    /* 
    public static void main( String[] args )
    {
        contador cont = new contador();
        //cont.mostrarContador();
        //cont.mostrarContadorDW();
        cont.mostrarContadorFor();
    } 
    */

    public static void main(String[] args) {
        // Rectangle myRect = new Rectangle();
        // myRect.width = 40;
        // myRect.height = 50;
        // System.out.println("myRect's area is " + myRect.area(myRect.width, myRect.height));

        NumberHolder numberHolder = new NumberHolder();

        numberHolder.anInt = 32;
        numberHolder.aFloat = 4.20f;

        System.out.println("anInt: " + numberHolder.anInt);
        System.out.println("aFloat: " + numberHolder.aFloat);
    }
        
}
