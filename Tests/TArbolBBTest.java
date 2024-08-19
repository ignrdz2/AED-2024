import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TArbolBBTest {

    TArbolBB arbol;

    @BeforeEach
    void setUp() {
        arbol = new TArbolBB<>();
    }

    void insertarEnArbol() {
        arbol.insertar(new TElementoAB(12, 12));
        arbol.insertar(new TElementoAB(25, 25));
        arbol.insertar(new TElementoAB(14, 14));
        arbol.insertar(new TElementoAB(1, 1));
        arbol.insertar(new TElementoAB(33, 33));
        arbol.insertar(new TElementoAB(88, 88));
        arbol.insertar(new TElementoAB(45, 45));
        arbol.insertar(new TElementoAB(2, 2));
        arbol.insertar(new TElementoAB(7, 7));
        arbol.insertar(new TElementoAB(66, 66));
        arbol.insertar(new TElementoAB(5, 5));
        arbol.insertar(new TElementoAB(99, 99));
    }

    @Test
    void testInsertarDuplicados() {
        assertEquals(true, arbol.insertar(new TElementoAB<>(2, null)));
        assertEquals(true, arbol.insertar(new TElementoAB<>(1, null)));
        assertEquals(true, arbol.insertar(new TElementoAB<>(3, null)));

        assertEquals(3, arbol.obtenerTamanio());

        assertEquals(false, arbol.insertar(new TElementoAB<>(1, null)));
        assertEquals(false, arbol.insertar(new TElementoAB<>(2, null)));
        assertEquals(false, arbol.insertar(new TElementoAB<>(3, null)));

        assertEquals(3, arbol.obtenerTamanio());
    }

    @Test
    void testEliminar() {
        insertarEnArbol();
        arbol.eliminar(99);
        arbol.eliminar(15); // No esta en el arbol
        arbol.eliminar(2);
        arbol.eliminar(12);
        arbol.eliminar(77); // No esta en el arbol
        arbol.eliminar(33);

        assertEquals("1-5-7-14-25-45-66-88", arbol.inOrden());
        assertEquals("7-1-5-25-14-88-45-66", arbol.preOrden());
        assertEquals("5-1-14-66-45-88-25-7", arbol.postOrden());

    }

    @Test
    void testEliminarDeArbolVacio() {
        assertEquals(true, arbol.esVacio());
        arbol.eliminar(10);
        assertEquals(true, arbol.esVacio());
    }

    @Test
    void testEliminarRaiz() {
        insertarEnArbol();
        assertEquals(12, arbol.getRaiz().getEtiqueta());
        arbol.eliminar(12);
        assertEquals(7, arbol.getRaiz().getEtiqueta());
    }

    @Test
    void testEliminar25() {
        insertarEnArbol();
        assertEquals(25, arbol.getRaiz().getHijoDer().getEtiqueta());

        arbol.eliminar(25);

        assertEquals(14, arbol.getRaiz().getHijoDer().getEtiqueta());
    }

    @Test
    void testInOrden() {
        insertarEnArbol();
        assertEquals("1-2-5-7-12-14-25-33-45-66-88-99", arbol.inOrden());
    }

    @Test
    void testPreOrden() {
        insertarEnArbol();
        assertEquals("12-1-2-7-5-25-14-33-88-45-66-99", arbol.preOrden());
    }

    @Test
    void testPostOrden() {
        insertarEnArbol();
        assertEquals("5-7-2-1-14-66-45-99-88-33-25-12", arbol.postOrden());
    }

    @Test
    void testRecorridosArbolVacio() {
        assertEquals("", arbol.inOrden());
        assertEquals("", arbol.preOrden());
        assertEquals("", arbol.postOrden());
    }

    @Test
    void testInOrdenLista() {
        insertarEnArbol();
        Lista lista = arbol.inorden();
        assertEquals("1-2-5-7-12-14-25-33-45-66-88-99", lista.imprimir("-"));
    }

    @Test
    void testObtenerAltura() {
        insertarEnArbol();
        assertEquals(5, arbol.obtenerAltura());
    }

    @Test
    void testObtenerAlturaUnSoloElemento() {
        arbol.insertar(new TElementoAB<>(1, null));
        assertEquals(0, arbol.obtenerAltura());
    }

    @Test
    void testObtenerAlturaArbolVacio() {
        assertEquals(-1, arbol.obtenerAltura());
    }

    @Test
    void testObtenerTamanio() {
        insertarEnArbol();
        assertEquals(12, arbol.obtenerTamanio());
    }

    @Test
    void testObtenerTamanioArbolVacio() {
        assertEquals(0, arbol.obtenerTamanio());
    }

    @Test
    void testObtenerNivel() {
        insertarEnArbol();
        assertEquals(0, arbol.obtenerNivel(12));

        assertEquals(1, arbol.obtenerNivel(1));
        assertEquals(1, arbol.obtenerNivel(25));

        assertEquals(2, arbol.obtenerNivel(2));
        assertEquals(2, arbol.obtenerNivel(14));
        assertEquals(2, arbol.obtenerNivel(33));

        assertEquals(3, arbol.obtenerNivel(7));
        assertEquals(3, arbol.obtenerNivel(88));

        assertEquals(4, arbol.obtenerNivel(5));
        assertEquals(4, arbol.obtenerNivel(45));
        assertEquals(4, arbol.obtenerNivel(99));

        assertEquals(5, arbol.obtenerNivel(66));

        assertEquals(-1, arbol.obtenerNivel(10));
    }

    @Test
    void testCantidadHojas() {
        insertarEnArbol();
        assertEquals(4, arbol.obtenerCantidadHojas());
    }

    @Test
    void testObtenerInmediataAnterior() {
        insertarEnArbol();
        assertEquals(null, arbol.obtenerInmediataAnterior(0));
        assertEquals(null, arbol.obtenerInmediataAnterior(1));
        assertEquals(1, arbol.obtenerInmediataAnterior(2));
        assertEquals(2, arbol.obtenerInmediataAnterior(5));
        assertEquals(5, arbol.obtenerInmediataAnterior(7));
        assertEquals(7, arbol.obtenerInmediataAnterior(12));
        assertEquals(12, arbol.obtenerInmediataAnterior(14));
        assertEquals(14, arbol.obtenerInmediataAnterior(25));
        assertEquals(25, arbol.obtenerInmediataAnterior(33));
        assertEquals(33, arbol.obtenerInmediataAnterior(45));
        assertEquals(45, arbol.obtenerInmediataAnterior(66));
        assertEquals(66, arbol.obtenerInmediataAnterior(88));
        assertEquals(88, arbol.obtenerInmediataAnterior(99));
        assertEquals(99, arbol.obtenerInmediataAnterior(100));
        assertEquals(99, arbol.obtenerInmediataAnterior(101));
    }

    @Test
    void testSumaDeClaves() {
        insertarEnArbol();
        assertEquals(12, arbol.sumaDeClaves(0));
        assertEquals(26, arbol.sumaDeClaves(1));
        assertThrows(IndexOutOfBoundsException.class, () -> arbol.sumaDeClaves(10));
        assertThrows(IllegalArgumentException.class, () -> arbol.sumaDeClaves(-1));

        TElementoAB elem1 = new TElementoAB<>(1, null);
        TElementoAB elem2 = new TElementoAB<>(2, null);
        TElementoAB elem3 = new TElementoAB<>(3, null);
        TElementoAB elem4 = new TElementoAB<>(4, null);
        TElementoAB elem5 = new TElementoAB<>(5, null);

        elem1.setHijoIzq(elem2);
        
        elem2.setHijoDer(elem3);
        elem2.setHijoIzq(elem4);

        elem3.setHijoIzq(elem5);

        arbol.vaciar();
        arbol.insertar(elem1);
        assertEquals(5, arbol.sumaDeClaves(3));

        arbol.vaciar();
        assertThrows(IndexOutOfBoundsException.class, () -> arbol.sumaDeClaves(1));
    }

}
