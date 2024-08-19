package com.example;

public class App 
{
    public static void main( String[] args )
    {
        Sabores sabor1 = new Sabores(FlavourEnum.CHOCOLATE);
        sabor1.opinarSabor();
        Sabores sabor2 = new Sabores(FlavourEnum.FRUTILLA);
        sabor2.opinarSabor();
        Sabores sabor3 = new Sabores(FlavourEnum.MENTA);
        sabor3.opinarSabor();
        Sabores sabor4 = new Sabores(FlavourEnum.DULCEDELECHE);
        sabor4.opinarSabor();
        Sabores sabor5 = new Sabores(FlavourEnum.NARANJA);
        sabor5.opinarSabor();


    }
}
