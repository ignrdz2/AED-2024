
import org.junit.Before;
import org.junit.Test;

import com.example.Arista;
import com.example.GrafoDirigido;
import com.example.GrafoNoDirigido;
import com.example.Vertice;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class GrafoNoDirigidoTest {

    private GrafoNoDirigido grafo;

    @Before
    public void setUp() {
        Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);

        Arista a1 = new Arista(1, 2, 1.0);
        Arista a2 = new Arista(2, 3, 1.0);
        Arista a3 = new Arista(3, 4, 1.0);
        Arista a4 = new Arista(4, 1, 1.0); // Crear un ciclo
        Arista a5 = new Arista(1, 3, 2.0); // Arista adicional para pruebas adicionales

        grafo = new GrafoNoDirigido(Arrays.asList(v1, v2, v3, v4), Arrays.asList(a1, a2, a3, a4, a5));
    }

    @Test
    public void testInsertarVertice() {
        grafo.insertarVertice(5);
        assertNotNull(grafo.buscarVertice(5));
    }

    @Test
    public void testExisteVertice() {
        assertTrue(grafo.existeVertice(1));
        assertFalse(grafo.existeVertice(5));
    }

    @Test
    public void testBuscarVertice() {
        assertNotNull(grafo.buscarVertice(1));
        assertNull(grafo.buscarVertice(5));
    }

    @Test
    public void testInsertarArista() {
        Vertice<Integer> v5 = new Vertice<>(5);
        grafo.insertarVertice(v5.getEtiqueta());
        grafo.insertarArista(new Arista(1, 5, 3.0));
        assertTrue(grafo.existeArista(1, 5));
    }

    @Test
    public void testEliminarArista() {
        Arista arista = new Arista(1, 3, 2.0);
        grafo.eliminarArista(arista);
        assertFalse(grafo.existeArista(1, 3));
    }

    @Test
    public void testExisteArista() {
        assertTrue(grafo.existeArista(1, 2));
        assertFalse(grafo.existeArista(1, 5));
    }

    @Test
    public void testGetEtiquetasOrdenadas() {
        Object[] etiquetasOrdenadas = grafo.getEtiquetasOrdenadas();
        assertArrayEquals(new Object[]{1, 2, 3, 4}, etiquetasOrdenadas);
    }

    @Test
    public void testCentroDelGrafo() {
        assertEquals((Integer) 1, grafo.centroDelGrafo());
    }

    @Test
    public void testFloyd() {
        Double[][] distancias = grafo.floyd();
        assertEquals(0.0, distancias[0][0], 0.01); // Distancia a sí mismo
        assertEquals(1.0, distancias[0][1], 0.01); // Distancia a un vecino
        assertEquals(2.0, distancias[0][2], 0.01); // Distancia a través de un vecino
    }

    @Test
    public void testObtenerExcentricidad() {
        assertEquals(2.0, grafo.obtenerExcentricidad(1), 0.01);
    }

    @Test
    public void testEncontrarMinimaDistancia() {
        assertEquals(1.0, grafo.encontrarMinimaDistancia(1, 2), 0.01);
        assertEquals(2.0, grafo.encontrarMinimaDistancia(1, 3), 0.01);
    }

    // @Test
    // public void testEncontrarRutaMinima() {
    //     grafo.floyd(); // Asegurarse de que Floyd-Warshall se ha ejecutado para inicializar predecesores
    //     List<Comparable> ruta = grafo.encontrarRutaMinima(1, 3);
    //     assertEquals(Arrays.asList(1, 2, 3), ruta);
    // }

    @Test
    public void testDFS() {
        grafo.dfs();
        // Aquí deberías verificar la salida manualmente o redirigir la salida del sistema y verificarla.
    }

    @Test
    public void testBEA() {
        Collection<Vertice> vertices = grafo.bea(1);
        assertEquals(4, vertices.size());
    }

    // @Test
    // public void testPrim() {
    //     try {
    //         GrafoNoDirigido mst = grafo.prim();
    //         assertNotNull(mst);
    //         assertEquals(4, mst.getVertices().size());
    //     } catch (ClassCastException e) {
    //         fail("ClassCastException: " + e.getMessage());
    //     }
    // }

    // @Test
    // public void testKruskal() {
    //     try {
    //         GrafoNoDirigido mst = grafo.kruskal();
    //         assertNotNull(mst);
    //         assertEquals(4, mst.getVertices().size());
    //     } catch (ClassCastException e) {
    //         fail("ClassCastException: " + e.getMessage());
    //     }
    // }

    // @Test
    // public void testFindArticulationPoints() {
    //     Set<Comparable> puntosArticulacion = grafo.findArticulationPoints();
    //     // Ajusta las expectativas según la topología del grafo
    //     assertTrue(puntosArticulacion.contains(2));
    //     assertTrue(puntosArticulacion.contains(3));
    // }
}
