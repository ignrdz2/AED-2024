package com.example;

/**
 * Hello world!
 *
 */
public class App{
    public static void main (String[] args) {
        Alumno alumno = new Alumno();
        // Test getNombreAdmiracion()
        System.out.println(alumno.getNombreAdmiracion());
        // Test recorrer()
        System.out.println(recorrer(alumno.getNombre()));
        // Test getValor()
        System.out.println(getValor());
        // Test getPrimerCaracter()
        System.out.println(getPrimerCaracter(alumno.getNombre()));
        // Test paraAString()
        System.out.println(1 + paraAString(recorrer(alumno.getNombre()))); 
        // ^ El numero es para demostrar que se pasa a string, ya que de lo contrario se mostraria la suma de los dos valores.
    }

    public static int recorrer (String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
                }
        }
        return res;
    }

    public static int getValor() {
        int vector[] = { 6, 16, 26,36,46,56,66,76 };
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
        //String string[] = new String[5];
        return (palabra.charAt(0));
    }

    public static String paraAString(int a) {
        return Integer.toString(a);
    }
}
    