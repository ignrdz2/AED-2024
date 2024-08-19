package uy.edu.ucu.aed;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TArbolBBTest_JUnit4 {

    private TArbolBB<Integer> arbol;

    @Before
    public void init() {
        arbol = new TArbolBB<>();
    }

    @Test
    public void dadoArbolVacio_cuandoInsertarEntoncesArbolNoVacio() {
        assertTrue(arbol.esVacio());

        boolean resultado = arbol.insertar(10, 10);

        assertTrue(resultado);
        assertFalse(arbol.esVacio());
    }

    @Test
    public void dadoArbolConElementos_cuandoInsertarElementoExistenteEntoncesFalso() {
        arbol.insertar(10, 10);
        assertFalse(arbol.esVacio());

        boolean resultado = arbol.insertar(10, 10);

        assertFalse(resultado);
    }

    @Test
    public void dadoArbolVacio_cuandoBuscarEntoncesNull() {
        assertTrue(arbol.esVacio());

        Integer resultado = arbol.buscar(10);

        assertNull(resultado);
    }

    @Test
    public void dadoArbolConElementos_cuandoBuscarElementoExistenteEntoncesElemento() {
        arbol.insertar(10, 10);

        Integer resultado = arbol.buscar(10);

        assertNotNull(resultado);
        assertEquals(Integer.valueOf(10), resultado);
    }

    @Test
    public void dadoArbolConElementos_cuandoBuscarElementoNoExistenteEntoncesNull() {
        arbol.insertar(10, 10);

        Integer resultado = arbol.buscar(20);

        assertNull(resultado);
    }

    @Test
    public void dadoArbolVacio_cuandoVaciarEntoncesFalso() {
        assertTrue(arbol.esVacio());

        boolean resultado = arbol.vaciar();

        assertFalse(resultado);
    }

    @Test
    public void dadoArbolConElementos_cuandoVaciarEntoncesVerdadero() {
        arbol.insertar(10, 10);
        assertFalse(arbol.esVacio());

        boolean resultado = arbol.vaciar();

        assertTrue(resultado);
        assertTrue(arbol.esVacio());
    }

    @Test
    public void dadoArbolVacio_cuandoInOrdenEntoncesListaVacia() {
        assertTrue(arbol.esVacio());

        List<Integer> resultado = arbol.inOrden();

        assertNull(resultado);
    }

    @Test
    public void dadoArbolConElementos_cuandoInOrdenEntoncesListaOrdenada() {
        arbol.insertar(20, 20);
        arbol.insertar(10, 10);
        arbol.insertar(30, 30);

        List<Integer> resultado = arbol.inOrden();

        assertNotNull(resultado);
        assertArrayEquals(new Integer[]{10, 20, 30}, resultado.toArray(new Integer[0]));
    }

    @Test
    public void dadoArbolConElementos_cuandoPreOrdenEntoncesListaPreOrden() {
        arbol.insertar(20, 20);
        arbol.insertar(10, 10);
        arbol.insertar(30, 30);

        List<Integer> resultado = arbol.preOrden();

        assertNotNull(resultado);
        assertArrayEquals(new Integer[]{20, 10, 30}, resultado.toArray(new Integer[0]));
    }

    @Test
    public void dadoArbolConElementos_cuandoPostOrdenEntoncesListaPostOrden() {
        arbol.insertar(20, 20);
        arbol.insertar(10, 10);
        arbol.insertar(30, 30);

        List<Integer> resultado = arbol.postOrden();

        assertNotNull(resultado);
        assertArrayEquals(new Integer[]{10, 30, 20}, resultado.toArray(new Integer[0]));
    }

    @Test
    public void dadoArbolVacio_cuandoEliminarEntoncesNoCambios() {
        assertTrue(arbol.esVacio());

        arbol.eliminar(10);

        assertTrue(arbol.esVacio());
    }

    @Test
    public void dadoArbolConElementos_cuandoEliminarElementoNoExistenteEntoncesArbolInalterado() {
        arbol.insertar(10, 10);
        assertFalse(arbol.esVacio());

        arbol.eliminar(20);

        assertFalse(arbol.esVacio());
        assertNotNull(arbol.buscar(10));
    }

    @Test
    public void dadoArbolConElementos_cuandoEliminarElementoExistenteEntoncesElementoEliminado() {
        arbol.insertar(10, 10);
        arbol.insertar(20, 20);
        arbol.insertar(30, 30);
        assertFalse(arbol.esVacio());

        arbol.eliminar(20);

        assertNull(arbol.buscar(20));
        assertNotNull(arbol.buscar(10));
        assertNotNull(arbol.buscar(30));
    }
}
