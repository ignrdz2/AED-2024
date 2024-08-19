package uy.edu.ucu.aed;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"rawtypes"})
/**
 * Clase que representa un nodo de un árbol binario de búsqueda (ABB). Cada nodo almacena una etiqueta
 * que lo identifica de manera única, los datos asociados a esa etiqueta, y las referencias a sus hijos
 * izquierdo y derecho.
 *
 * @param <T> Tipo de dato que se almacena en el nodo.
 */
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;
    public int miAltura = 0;

    /**
     * Constructor para el nodo del árbol binario de búsqueda.
     *
     * @param unaEtiqueta Etiqueta del nodo.
     * @param unosDatos   Datos asociados a la etiqueta.
     */
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    /**
     * Retorna el hijo izquierdo del nodo actual.
     *
     * @return Hijo izquierdo del nodo.
     */
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    /**
     * Retorna el hijo derecho del nodo actual.
     *
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * Inserta un elemento en el subárbol cuya raíz es el nodo actual, respetando las
     * propiedades del árbol binario de búsqueda.
     *
     * @param unElemento Elemento a insertar.
     * @return Verdadero si el elemento fue insertado, falso si ya existía un elemento con la misma etiqueta.
     */
    @SuppressWarnings("unchecked")
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // Ya existe un elemento con la misma etiqueta.
            return false;
        }
    }

    /**
     * Busca un elemento en el subárbol cuya raíz es el nodo actual, utilizando la etiqueta como clave de búsqueda.
     *
     * @param unaEtiqueta Etiqueta del elemento a buscar.
     * @return El nodo encontrado. Si no se encuentra, retorna nulo.
     */
    @SuppressWarnings({"unchecked"})
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * Realiza un recorrido inorden del subárbol cuya raíz es el nodo actual y devuelve la representación
     * de todos los elementos en el subárbol como una cadena de texto.
     *
     * @return Cadena de texto con la representación inorden de los elementos.
     */
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }
        return tempStr.toString();
    }

    /**
     * Realiza un recorrido inorden del subárbol cuya raíz es el nodo actual y agrega los datos de los
     * elementos a una lista pasada como parámetro.
     *
     * @param unaLista Lista donde se agregarán los datos de los elementos en inorden.
     */
    public void inOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.getDatos());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    /**
     * Retorna la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * Retorna una representación en cadena de texto de la etiqueta del nodo.
     *
     * @return Representación en texto de la etiqueta del nodo.
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    /**
     * Retorna los datos asociados a la etiqueta del nodo.
     *
     * @return Datos del nodo.
     */
    @Override
    public T getDatos() {
        return datos;
    }

    /**
     * Asigna un nodo como hijo izquierdo del nodo actual.
     *
     * @param elemento Nodo que será el hijo izquierdo.
     */
    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    /**
     * Asigna un nodo como hijo derecho del nodo actual.
     *
     * @param elemento Nodo que será el hijo derecho.
     */
    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    /**
     * Elimina un elemento del subárbol cuya raíz es el nodo actual, utilizando la etiqueta como clave de búsqueda.
     *
     * @param unaEtiqueta Etiqueta del elemento a eliminar.
     * @return El nodo que reemplaza al nodo eliminado en la posición que ocupaba dentro del árbol.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();
    }

    /**
     * Auxiliar para el método eliminar. Realiza las operaciones necesarias para quitar un nodo y mantener las
     * propiedades del árbol binario de búsqueda.
     *
     * @return El nodo que reemplaza al nodo eliminado.
     */
    private TElementoAB<T> quitaElNodo() {
        if (hijoIzq == null) {    // solo tiene un hijo o es hoja
            return hijoDer;
        }
        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }
        // El nodo tiene dos hijos, se busca el nodo lexicográficamente anterior
        TElementoAB<T> elHijo = hijoIzq;
        TElementoAB<T> elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }
        elHijo.setHijoDer(hijoDer);
        
        // Se desconectan los hijos del nodo actual para facilitar el trabajo del recolector de basura
        setHijoIzq(null);
        setHijoDer(null);
        
        return elHijo;
    }

    /**
     * Retorna la cantidad total de nodos en el subárbol cuya raíz es el nodo actual.
     *
     * @return Tamaño del subárbol.
     */
    @Override
    public int obtenerTamaño() {
        int tam = 1;
        if (this.getHijoIzq() != null) {
            tam += this.getHijoIzq().obtenerTamaño();
        }
        if (this.getHijoDer() != null) {
            tam += this.getHijoDer().obtenerTamaño();
        }
        return tam;
    }

    /**
     * Realiza un recorrido preorden del subárbol cuya raíz es el nodo actual y agrega los datos de los
     * elementos a una lista pasada como parámetro.
     *
     * @param unaLista Lista donde se agregarán los datos de los elementos en preorden.
     */
    @Override
    public void preOrden(LinkedList<T> unaLista) {
        unaLista.add(this.getDatos());
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }
    }

    /**
     * Realiza un recorrido postorden del subárbol cuya raíz es el nodo actual y agrega los datos de los
     * elementos a una lista pasada como parámetro.
     *
     * @param unaLista Lista donde se agregarán los datos de los elementos en postorden.
     */
    @Override
    public void postOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.add(this.getDatos());
    }

    public void obtenerHojas(List<T> hojas) {
        if (this.hijoIzq == null && this.hijoDer == null) {
            hojas.add(this.getDatos());
        } else {
            if (this.hijoIzq != null) {
                this.hijoIzq.obtenerHojas(hojas);
            }
            if (this.hijoDer != null) {
                this.hijoDer.obtenerHojas(hojas);
            }
        }
    }

    public void separar(List<T> nodosInternos, List<T> nodosExternos) {
        if (this.hijoIzq == null && this.hijoDer == null) {
            nodosExternos.add(this.getDatos());  
        } else{
            nodosInternos.add(this.getDatos());
        }
        if (this.hijoIzq != null) {
            this.hijoIzq.separar(nodosInternos, nodosExternos);
        }
        if (this.hijoDer != null) {
            this.hijoDer.separar(nodosInternos, nodosExternos);
        }
    }

    public int altura() {
        return this.miAltura;
    }

    // ROTACIONES

    /*
     * t  		 n
     *   \ 		/ \
     *    n    t   A
     *   / \    \
     *  A   B    B
     */

     public TElementoAB<T> leftRotation() {
        TElementoAB<T> newRoot = getHijoDer();
        setHijoDer(newRoot.getHijoIzq());
        newRoot.setHijoIzq(this);

        int alturaIzq = -1;
        int alturaDer = -1;

        if (getHijoIzq() != null) {
            alturaIzq = getHijoIzq().altura();
        }
        if (getHijoDer() != null) {
            alturaDer = getHijoDer().altura();
        }

        miAltura = Math.max(alturaDer, alturaIzq) + 1;
        return newRoot;
    }

    /*
     *     t  	  n
     *    / 	 / \
     *   n      A   t
     *  / \        /
     * A   B      B
     */

    public TElementoAB<T> rightRotation() {
        TElementoAB<T> newRoot = getHijoIzq();
        setHijoIzq(newRoot.getHijoDer());
        newRoot.setHijoDer(this);

        int alturaIzq = -1;
        int alturaDer = -1;

        if (getHijoIzq() != null) {
            alturaIzq = getHijoIzq().altura();
        }
        if (getHijoDer() != null) {
            alturaDer = getHijoDer().altura();
        }

        miAltura = Math.max(alturaDer, alturaIzq) + 1;
        return newRoot;
    }

    public TElementoAB<T> rotacionLL() {
        setHijoIzq(getHijoIzq().leftRotation());
        return rightRotation();
    }

    public TElementoAB<T> rotacionRL() {
        setHijoDer(getHijoDer().rightRotation());
        return leftRotation();
    }

    public TElementoAB<T> balancear() {
        int alturaIzq = -1;
        int alturaDer = -1;

        if (getHijoIzq() != null) {
            setHijoIzq(hijoIzq.balancear());
            alturaIzq = getHijoIzq().altura();
        }
        if (getHijoDer() != null) {
            setHijoDer(hijoDer.balancear());
            alturaDer = getHijoDer().altura();
        }
        if (alturaIzq == alturaDer) {
            return this;
        }
        int AlturaIzqChild = -1;
        int AlturaDerChild = -1;
        
        if (alturaDer - alturaIzq > 1) {
            if(hijoDer.hijoDer != null) AlturaDerChild = hijoDer.hijoDer.altura();
            if(hijoDer.hijoIzq != null) AlturaIzqChild = hijoDer.hijoIzq.altura();

            if (AlturaDerChild > AlturaIzqChild) return leftRotation();
            else return rotacionRL();
        }

        if (alturaIzq - alturaDer > 1) {
            if(hijoIzq.hijoDer != null) AlturaDerChild = hijoIzq.hijoDer.altura();
            if(hijoIzq.hijoIzq != null) AlturaIzqChild = hijoIzq.hijoIzq.altura();

            if (AlturaIzqChild > AlturaDerChild) return rightRotation();
            else return rotacionLL();
        }

        if (getHijoIzq() != null) {
            alturaIzq = getHijoIzq().altura();
        }
        if (getHijoDer() != null) {
            alturaDer = getHijoDer().altura();
        }

        miAltura = Math.max(alturaDer, alturaIzq) + 1;

        return this;
    }
}