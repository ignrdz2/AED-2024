public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }


    @Override
    public boolean insertar(Comparable etiqueta, T dato) {

        TElementoAB elementoAB = new TElementoAB<T>(etiqueta, dato);

        if (raiz == null) {
            raiz = elementoAB;
            return true;
        }
        boolean resultado = raiz.insertar(elementoAB);
        return resultado;
    }

    public boolean insertarBalanceado(TElementoAB<T> unElemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertarBalanceado'");
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        }
        return raiz.buscar(unaEtiqueta);
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "Arbol Vacio";
        }
        return raiz.preOrden();
    }

    @Override
    public String inOrden() {
        if (raiz == null) {
            return "Arbol Vacio";
        }
        return raiz.inOrden();
    }

    @Override
    public String postOrden() {
        if (raiz == null) {
            return "Arbol Vacio";
        }
        return raiz.postOrden();
    }


    public int alturaArbol() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alturaArbol'");
    }

    public int hojasArbol() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hojasArbol'");
    }

    public void printTree() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printTree'");
    }

    private static void printTreeHelper(TElementoAB node, String indent, boolean isRight) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printTreeHelper'");
    }


    @Override
    public T eliminar(Comparable unaEtiqueta) {
        if (raiz == null) {
            System.out.println("Arbol vacio");
            return;
        }
        raiz.eliminar(unaEtiqueta);
    }
}