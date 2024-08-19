import org.junit.Before;
import org.junit.Test;

import com.example.Vertice;

import static org.junit.Assert.*;

public class VerticeTest {
    private Vertice<String> verticeA;
    private Vertice<String> verticeB;
    private Vertice<String> verticeKevinBacon;

    @Before
    public void setUp() {
        verticeA = new Vertice<>("Actor_A");
        verticeB = new Vertice<>("Actor_B");
        verticeKevinBacon = new Vertice<>("Kevin_Bacon");
    }

    @Test
    public void testInsertarAdyacencia() {
        verticeA.insertarAdyacencia(1.0, verticeB);
        assertNotNull(verticeA.buscarAdyacencia(verticeB));
    }

    @Test
    public void testObtenerCostoAdyacencia() {
        verticeA.insertarAdyacencia(1.0, verticeB);
        Double costo = verticeA.obtenerCostoAdyacencia(verticeB);
        assertEquals(Double.valueOf(1.0), costo);
    }

    @Test
    public void testNumBacon() {
        verticeA.insertarAdyacencia(1.0, verticeB);
        verticeB.insertarAdyacencia(1.0, verticeKevinBacon);
        assertEquals(2, verticeA.numBacon());
    }
}
