
import org.junit.Before;
import org.junit.Test;

import com.example.Arista;
import com.example.Caminos;
import com.example.GrafoDirigido;
import com.example.Vertice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class GrafoDirigidoTest {

    private GrafoDirigido grafo;

    @Before
    public void setUp() {
        Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);

        Arista a1 = new Arista(1, 2, 1.0);
        Arista a2 = new Arista(2, 3, 1.0);
        Arista a3 = new Arista(3, 4, 1.0);
        Arista a4 = new Arista(4, 1, 1.0); // Esto crea un ciclo

        grafo = new GrafoDirigido(Arrays.asList(v1, v2, v3, v4), Arrays.asList(a1, a2, a3, a4));
    }

    @Test
    public void testInsertarVertice() {
        assertTrue(grafo.insertarVertice(new Vertice<>(5)));
        assertFalse(grafo.insertarVertice(new Vertice<>(1)));
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
        assertTrue(grafo.insertarArista(new Arista(1, 3, 2.0)));
        assertFalse(grafo.insertarArista(new Arista(1, 5, 2.0)));
    }

    @Test
    public void testExisteArista() {
        assertTrue(grafo.existeArista(1, 2));
        assertFalse(grafo.existeArista(1, 3));
    }

    @Test
    public void testCentroDelGrafo() {
        assertEquals((Integer) 1, grafo.centroDelGrafo());
    }

    @Test
    public void testObtenerExcentricidad() {
        assertEquals(3.0, grafo.obtenerExcentricidad(1), 0.01);
    }

    @Test
    public void testEncontrarMinimaDistancia() {
        // Asegúrate de que ambos vértices existen en el grafo
        assertTrue(grafo.existeVertice(1));
        assertTrue(grafo.existeVertice(2));

        // Luego, prueba encontrar la distancia mínima
        assertEquals(1.0, grafo.encontrarMinimaDistancia(1, 2), 0.01);

        // Este caso debería lanzar la excepción, pero es opcional según cómo quieras manejarlo
        try {
            grafo.encontrarMinimaDistancia(1, 5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Test passed
        }
    }

    @Test
    public void testEncontrarRutaMinima() {
        assertEquals(Arrays.asList(1, 2, 3), grafo.encontrarRutaMinima(1, 3));
    }

    @Test
    public void testDFS() {
        grafo.dfs();
        // Aquí deberías verificar la salida manualmente o redirigir la salida del sistema y verificarla.
    }

    @Test
    public void testBFS() {
        grafo.bfs(1);
        // Aquí deberías verificar la salida manualmente o redirigir la salida del sistema y verificarla.
    }

    @Test
    public void testBEA() {
        Collection<Vertice> vertices = grafo.bea(1);
        assertEquals(4, vertices.size());
    }

    @Test
    public void testTodosLosCaminos() {
        Caminos caminos = grafo.todosLosCaminos(1, 3);
        assertFalse(caminos.caminos.isEmpty());
    }

    // @Test
    // public void testTieneCiclos() {
    //     assertTrue(grafo.tieneCiclos());
    // }

    @Test
    public void testOrdenTopologico() {
        grafo.ordenTopologico();
        // Aquí deberías verificar la salida manualmente o redirigir la salida del sistema y verificarla.
    }

    @Test
    public void testGetTranspuesto() {
        GrafoDirigido transpuesto = grafo.getTranspuesto();
        assertNotNull(transpuesto);
    }

    @Test
    public void testEsFuertementeConexo() {
        assertTrue(grafo.esFuertementeConexo());
    }

    @Test
    public void testOrdenParcial() {
        LinkedList<Vertice> orden = grafo.ordenParcial();
        assertEquals(4, orden.size());
    }

    @Test
    public void testListarTareas() {
        LinkedList<Vertice> orden = grafo.ordenParcial();
        grafo.listarTareas(orden);
        // Aquí deberías verificar la salida manualmente o redirigir la salida del sistema y verificarla.
    }

    @Test
    public void testFloyd() {
        Double[][] distancias = grafo.floyd();
        assertNotNull(distancias);
        assertEquals(4, distancias.length);
    }

    @Test
    public void testClasificarArcos() {
        List<Arista> arcosArbol = new ArrayList<>();
        List<Arista> arcosRetroceso = new ArrayList<>();
        List<Arista> arcosAvance = new ArrayList<>();
        List<Arista> arcosCruzados = new ArrayList<>();
        grafo.ClasificarArcos(grafo.buscarVertice(1), arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
        assertFalse(arcosArbol.isEmpty());
    }
}
