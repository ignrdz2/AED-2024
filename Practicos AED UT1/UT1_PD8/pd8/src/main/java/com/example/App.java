package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Marcapasos marcapasos = new Marcapasos();

        marcapasos.presionSanguinea = 120;
        marcapasos.frecuenciaCardiaca = 80;
        marcapasos.nivelAzucarSangre = 100;
        marcapasos.maximaFuerza = 2000000000;
        marcapasos.minTiempoLatidos = 0.8f;
        marcapasos.bateriaRestante = 50.5f;
        marcapasos.codigoFabricante = new char[]{'A', 'B', 'C', '1', '2', '3', 'X', 'Y'};

        System.out.println( "Presión Sanguínea: " + marcapasos.presionSanguinea );
        System.out.println( "Frecuencia Cardíaca: " + marcapasos.frecuenciaCardiaca );
        System.out.println( "Nivel de Azúcar en Sangre: " + marcapasos.nivelAzucarSangre );
        System.out.println( "Máxima Fuerza: " + marcapasos.maximaFuerza );
        System.out.println( "Mínimo Tiempo entre Latidos: " + marcapasos.minTiempoLatidos );
        System.out.println( "Batería Restante: " + marcapasos.bateriaRestante );
        System.out.println( "Código del Fabricante: " + new String(marcapasos.codigoFabricante) );

        int totalMemory = 2 + 2 + 2 + 4 + 4 + 4 + 16; // Suma de acuerdo a los sizes de cada objeto indicado en la calse Marcapasos
        System.out.println( "Memoria total consumida por el objeto marcapasos: " + totalMemory + " bytes" );
    }
}
