package uy.edu.ucu.aed;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {

        Nodo<T> nuevoNodo = new Nodo<T>(clave, dato);

        if (esVacia()) {
            primero = nuevoNodo;
        } else {
            Nodo<T> aux = new Nodo(3, 3);
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevoNodo);
        }
    }

    @Override
    public T buscar(Comparable clave) {
        // TODO Auto-generated method stub
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux.getDato();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia())
            return false;

        // En caso de que el valor a eliminar sea el primero
        if (primero.getEtiqueta() == clave) {
            primero = primero.getSiguiente();
            return true;
        }

        // Buscar el nodo a eliminar
        Nodo<T> aux = primero;
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente() == clave) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                return true;
            }
        }
        return false;
    }

    @Override
    public String imprimir() {
        if (esVacia())
            return "Lista vacia";
        Nodo<T> aux = primero;
        String resultado = "";

        while (aux != null) {
            resultado += aux.getDato().toString() + "\n";
            aux = aux.getSiguiente();
        }
        return resultado;
    }

    @Override
    public String imprimir(String separador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }

    @Override
    public int cantElementos() {
        if (esVacia())
            return 0;

        Nodo<T> aux = primero;
        int count = 0;

        while (aux != null) {
            count++;
            aux = aux.getSiguiente();
        }
        return count;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        }
        unNodo.setSiguiente(primero);
        primero = unNodo;
        return;
    }

    // implementar los metodos indicados en la interfaz
}
