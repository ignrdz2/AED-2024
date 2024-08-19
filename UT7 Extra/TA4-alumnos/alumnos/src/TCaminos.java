import java.util.ArrayList;
import java.util.Collection;

public class TCaminos {
    private Collection<TCamino> caminos;

    public TCaminos() {
        this.caminos = new ArrayList<>();
    }

    public void imprimir() {
        for (TCamino camino : caminos) {
            System.out.println(camino.imprimirEtiquetas());
        }
    }

    // You might want to add methods to add/remove TCamino instances to/from the collection
    public void addCamino(TCamino camino) {
        this.caminos.add(camino);
    }

    public void removeCamino(TCamino camino) {
        this.caminos.remove(camino);
    }
}
