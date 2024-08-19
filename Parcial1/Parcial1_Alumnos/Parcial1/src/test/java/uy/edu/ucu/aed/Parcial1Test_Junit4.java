package uy.edu.ucu.aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

// import org.junit.After;
// import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for implemented methods.
 */
public class Parcial1Test_Junit4 
{
    @Test
    public void testSeparar() {
        TArbolBB<String> arbol = new TArbolBB<>();
        arbol.insertar("2", "B");
        arbol.insertar("1", "A");
        arbol.insertar("3", "C");

        LinkedList<String> hojas = new LinkedList<>();
        LinkedList<String> internos = new LinkedList<>();
        arbol.separar(internos, hojas);

        assertEquals(2, hojas.size());
        assertTrue(hojas.contains("A"));
        assertTrue(hojas.contains("C"));

        assertEquals(1, internos.size());
        assertTrue(internos.contains("B"));
    }
}
