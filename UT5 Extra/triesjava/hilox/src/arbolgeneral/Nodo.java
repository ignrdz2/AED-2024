package arbolgeneral;
public class Nodo {
    private Nodo hermanoDerecho;
    private Nodo primerHijo;
    private Nodo padre;
    private int dato;

    public Nodo(int dato) {
        this.dato = dato;
        this.hermanoDerecho=null;
        this.primerHijo=null;
        this.padre=null;
    }

    public Nodo getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setHermanoDerecho(Nodo hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    public Nodo getPrimerHijo() {
        return primerHijo;
    }

    public void setPrimerHijo(Nodo primerHijo) {
        this.primerHijo = primerHijo;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    
    
}
