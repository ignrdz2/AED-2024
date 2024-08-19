package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class ConjuntoTest {

    @Test
    public void testUnion() {
        Conjunto<TAlumno> cursoAED1 = new Conjunto<>();
        Conjunto<TAlumno> cursoPF = new Conjunto<>();

        TAlumno alumno1 = new TAlumno(1234, "Juan", "Pérez");
        TAlumno alumno2 = new TAlumno(5678, "María", "González");
        TAlumno alumno3 = new TAlumno(9012, "Carlos", "López");
        TAlumno alumno4 = new TAlumno(3456, "Ana", "Martínez");
        TAlumno alumno5 = new TAlumno(7890, "Luis", "Rodríguez");

        cursoAED1.agregar(alumno1);
        cursoAED1.agregar(alumno2);
        cursoAED1.agregar(alumno3);

        cursoPF.agregar(alumno3);
        cursoPF.agregar(alumno4);
        cursoPF.agregar(alumno5);

        Conjunto<TAlumno> resultado = (Conjunto<TAlumno>) cursoAED1.union(cursoPF);
        assertTrue(resultado.contiene(alumno1));
        assertTrue(resultado.contiene(alumno2));
        assertTrue(resultado.contiene(alumno3));
        assertTrue(resultado.contiene(alumno4));
        assertTrue(resultado.contiene(alumno5));
    }

    @Test
    public void testInterseccion() {
        Conjunto<TAlumno> cursoAED1 = new Conjunto<>();
        Conjunto<TAlumno> cursoPF = new Conjunto<>();

        TAlumno alumno1 = new TAlumno(1234, "Juan", "Pérez");
        TAlumno alumno2 = new TAlumno(5678, "María", "González");
        TAlumno alumno3 = new TAlumno(9012, "Carlos", "López");
        TAlumno alumno4 = new TAlumno(3456, "Ana", "Martínez");
        TAlumno alumno5 = new TAlumno(7890, "Luis", "Rodríguez");

        cursoAED1.agregar(alumno1);
        cursoAED1.agregar(alumno2);
        cursoAED1.agregar(alumno3);

        cursoPF.agregar(alumno3);
        cursoPF.agregar(alumno4);
        cursoPF.agregar(alumno5);

        Conjunto<TAlumno> resultado = (Conjunto<TAlumno>) cursoAED1.interseccion(cursoPF);
        assertTrue(resultado.contiene(alumno3));
    }
}



