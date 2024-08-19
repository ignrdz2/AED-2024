package uy.edu.ucu.aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import javax.swing.text.TabSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uy.edu.ucu.aed.parcial2.TGrafoDeLaRed;
import uy.edu.ucu.aed.parcial2.TVerticeDeLaRed;

/**
 * Unit test for implemented methods.
 */
public class Parcial2Test_Junit4 
{
    String instanceVariable;
    private TGrafoDirigido grafoD;
    private TGrafoDeLaRed grafo;

    @Before
    public void setUp() {
        // Creación de vértices
        TVerticeDeLaRed v1 = new TVerticeDeLaRed("Vertice_1", "1");
        TVerticeDeLaRed v2 = new TVerticeDeLaRed("Vertice_2", "2");
        TVerticeDeLaRed v3 = new TVerticeDeLaRed("Vertice_3", "1");
        TVerticeDeLaRed v4 = new TVerticeDeLaRed("Vertice_4", "1");
        TVerticeDeLaRed v5 = new TVerticeDeLaRed("Vertice_5", "2");
        TVerticeDeLaRed v6 = new TVerticeDeLaRed("Vertice_6", "1");
        TVerticeDeLaRed v7 = new TVerticeDeLaRed("Vertice_7", "2");
        TVerticeDeLaRed v8 = new TVerticeDeLaRed("Vertice_8", "1");

        // Creación de aristas
        TArista a1 = new TArista("Vertice_1", "Vertice_2", 1.0);
        TArista a2 = new TArista("Vertice_2", "Vertice_3", 1.0);
        TArista a3 = new TArista("Vertice_3", "Vertice_4", 1.0);
        TArista a4 = new TArista("Vertice_4", "Vertice_1", 1.0); // Esto crea un ciclo
        TArista a5 = new TArista("Vertice_5", "Vertice_6", 1.0);

        // Inicialización del grafo con los vértices y aristas creados
        grafo = new TGrafoDeLaRed(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8), Arrays.asList(a1, a2, a3, a4, a5));
    }

    @After
    public void tearDown() {
        // Release any resources or clean up after the tests
        instanceVariable = null;
    }

    /**
     * Sample test in JUnit 4
     */
    // @Test
    // public void shouldAnswerWithTrueInJUnit4Test()
    // {
    //     assertTrue(instanceVariable != null);
    // }

    @Test
    public void testCaminosDesdeHasta() {
        TCaminos caminos = grafo.caminosDesdeHasta("Vertice_1", "Vertice_3");
        assertFalse(caminos.getCaminos().isEmpty());
    }

    @Test
public void testCaminoDirecto() {
    TCaminos caminos = grafo.caminosDesdeHasta("Vertice_1", "Vertice_2");
    assertFalse(caminos.getCaminos().isEmpty());
}

@Test
public void testMultiplesCaminos() {
    TCaminos caminos = grafo.caminosDesdeHasta("Vertice_1", "Vertice_4");
    assertTrue(caminos.getCaminos().size() > 1);
}

@Test
public void testVerticesNoConectados() {
    TCaminos caminos = grafo.caminosDesdeHasta("Vertice_1", "Vertice_8");
    assertTrue(caminos.getCaminos().isEmpty());
}

@Test
public void testVerticesFormanCiclo() {
    TCaminos caminos = grafo.caminosDesdeHasta("Vertice_1", "Vertice_1");
    assertTrue(caminos.getCaminos().isEmpty());
}

}
