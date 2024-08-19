package test.grafonodirigido;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import grafos.*;

public class MenosSaltosTest {

    @Test
    public void test_menos_saltos() {
        List<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice<>("A"));
        vertices.add(new TVertice<>("B"));
        vertices.add(new TVertice<>("C"));
        vertices.add(new TVertice<>("D"));
        vertices.add(new TVertice<>("E"));

        List<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 0));
        aristas.add(new TArista("B", "C", 0));
        aristas.add(new TArista("B", "D", 0));

        aristas.add(new TArista("A", "D", 0));
        aristas.add(new TArista("D", "E", 0));
        aristas.add(new TArista("E", "C", 0));

        TGrafoNoDirigido gnd = new TGrafoNoDirigido(vertices, aristas);
        List<TVertice> AC = gnd.menosSaltos("A", "C");

        assertEquals(3, AC.size());
        assertEquals("A", AC.get(0).getEtiqueta());
        assertEquals("B", AC.get(1).getEtiqueta());
        assertEquals("C", AC.get(2).getEtiqueta());
        
        List<TVertice> AE = gnd.menosSaltos("A", "E");

        assertEquals(3, AE.size());
        assertEquals("A", AE.get(0).getEtiqueta());
        assertEquals("D", AE.get(1).getEtiqueta());
        assertEquals("E", AE.get(2).getEtiqueta());

    }
}
