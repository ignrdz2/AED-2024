package com.example;

public class Marcapasos {
    short presionSanguinea; // 2 bytes
    short frecuenciaCardiaca; // 2 bytes
    short nivelAzucarSangre; // 2 bytes
    int maximaFuerza; // 4 bytes
    float minTiempoLatidos; // 4 bytes
    float bateriaRestante; // 4 bytes
    char[] codigoFabricante = new char[8]; // 16 bytes
}
