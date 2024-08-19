package com.example;

public class Par<S, F> {
    private S suero;
    private F farmaco;

    public Par(S suero, F farmaco) {
        this.suero = suero;
        this.farmaco = farmaco;
    }

    public S getSuero() {
        return suero;
    }

    public void setSuero(S suero) {
        this.suero = suero;
    }

    public F getFarmaco() {
        return farmaco;
    }

    public void setFarmaco(F farmaco) {
        this.farmaco = farmaco;
    }
}

