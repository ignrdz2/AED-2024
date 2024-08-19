package com.example;

public class Sucursales {
    String[] sucursal;

    public Sucursales(){
        
    }

    public void agregarSucursal(String file, String[] local){
        ManejadorArchivosGenerico.escribirArchivo(file, local);
        System.out.println("Agregado correctamente");
    }
    public boolean buscarSucursal(String file, String local){
        if(ManejadorArchivosGenerico.buscar(file, local)) return true;
        return false;
    }
    public boolean borrarSucursal(String file, String local){
        return true;
    }
}
