import java.util.ArrayList;
import java.util.Collection;

public class TCamino {
    public TVertice origen;
    public Collection<Comparable> otrosVertices;
    private Double costoTotal;

    // private void ImprimirEtiquetas() { }; // IMPLEMENTAR
    private String ImprimirEtiquetas() { return ""; } // IMPLEMENTAR

    public String imprimirEtiquetas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Origen: ").append(origen.getEtiqueta()).append("\n");
        sb.append("Otros vertices: ");
        for (Comparable etiqueta : otrosVertices) {
            sb.append(etiqueta.toString()).append(", ");
        }
        // Remove the trailing comma and space
        if (!otrosVertices.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }


    public TCamino(TVertice v) {
        this.origen = v;
        this.otrosVertices = new ArrayList<Comparable>();
        this.costoTotal = 0.0;
    }

    public boolean agregarAdyacencia(TAdyacencia adyacenciaActual) {
        if (adyacenciaActual.getDestino() != null) {
            costoTotal = costoTotal + ((Number)adyacenciaActual.getCosto()).doubleValue();
            return otrosVertices.add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual) {
        if (otrosVertices.contains(adyacenciaActual.getDestino().getEtiqueta())) {
            costoTotal = costoTotal - ((Number)adyacenciaActual.getCosto()).doubleValue();
            return otrosVertices.remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    public TCamino copiar() {
        TVertice origen = new TVertice(this.getOrigen().getEtiqueta());
        TCamino copia = new TCamino(origen);
        origen.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        return copia;
    }

    public TVertice getOrigen(){
        return this.origen;
    }

    public Collection<Comparable> getOtrosVertices() {
        return this.otrosVertices;
    }
}