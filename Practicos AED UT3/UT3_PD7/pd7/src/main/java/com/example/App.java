package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
        cursoPF.agregar(alumno3);  // Carlos está en ambos cursos
        cursoPF.agregar(alumno4);
        cursoPF.agregar(alumno5);


        IConjunto<TAlumno> alumnosEnCursos = cursoAED1.union(cursoPF);
        System.out.println("Alumnos en cualquiera de los dos cursos:");
        alumnosEnCursos.listar();

        IConjunto<TAlumno> alumnosEnAmbosCursos = cursoAED1.interseccion(cursoPF);
        System.out.println("\nAlumnos en ambos cursos:");
        alumnosEnAmbosCursos.listar();



    }
}
