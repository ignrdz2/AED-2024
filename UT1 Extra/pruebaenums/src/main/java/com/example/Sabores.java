package com.example;

public class Sabores {
    FlavourEnum sabor;

    public Sabores(FlavourEnum sabor){
        this.sabor = sabor;
    }

    public void opinarSabor(){
        switch (sabor) {
            case CHOCOLATE:
                System.out.println("Buen sabor");
                break;
            
            case FRUTILLA:
                System.out.println("Aceptable");
                break;
            case MENTA: 
                System.out.println("Sobrevalorado");
                break;
            case DULCEDELECHE:
                System.out.println("Top 1");
                break;
            case NARANJA:
                System.out.println("???");
                break;
            default:
                System.out.println("Ese sabor no existe!!");
                break;
        }
    }
}
