package com.example;

public class App 
{
    public static void main( String[] args )
    {
        String[] file = ManejadorArchivosGenerico.leerArchivo("src/sucursales.txt");

        Sucursales suc = new Sucursales();
        String[] sucursales = {"asd", "hola", "ds"};
        suc.agregarSucursal("src/sucursales.txt", sucursales);
        suc.buscarSucursal("src/sucursales.txt", "asd");
    }

}
