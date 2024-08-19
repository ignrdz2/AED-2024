package com.example;

public class TArbolBB<T> implements IArbolBB<T> {

    private String inorden = "";
    private String postorden = "";
    private String preorden = "";

    TElementoAB<T> raiz;
    public TArbolBB(){
        raiz = null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(@SuppressWarnings("rawtypes") Comparable etiqueta, T dato) {

        TElementoAB<T> n = new TElementoAB(etiqueta, dato);
        n.setDato(dato);

        if(raiz == null){
            raiz = n;
            return true;
        } else{
            TElementoAB<T> aux = raiz;
            while(aux != null){
                n.padre = aux;//
                if(n.getEtiqueta().compareTo(aux.getEtiqueta()) > 0){
                    aux = aux.getHijoDer();
                } else{
                    aux = aux.getHijoIzq();
                }
            }
        }

        if(n.getEtiqueta().compareTo(n.padre.getEtiqueta()) < 0){
            n.padre.setHijoIzq(n);
            return true;
        } else{
            n.padre.setHijoDer(n);
            return true;
        }

    }

    @Override
    public TElementoAB<T> buscar(Comparable id) {
        TElementoAB<T> aux = raiz;
        while(aux.getEtiqueta() != id){
            if(id.compareTo(aux.getEtiqueta()) < 0){
                aux = aux.getHijoIzq();
            } else{
                aux = aux.getHijoDer();
            }
            if(aux == null){
                return null;
            }
        }
        
        return new TElementoAB<T>(aux.getEtiqueta(), aux.getDato());   
    }

    @Override
    public String preOrden(){
        return preOrdenRecursivo(raiz, new StringBuilder()).toString();
    }

    private StringBuilder preOrdenRecursivo(TElementoAB<T> n, StringBuilder resultado){
        if(n != null){
            resultado.append(n.getEtiqueta()).append(" ");
            preOrdenRecursivo(n.getHijoIzq(), resultado);
            preOrdenRecursivo(n.getHijoDer(), resultado);
        }
        return resultado;
    }

    @Override
    public String inOrden() {
        return inOrdenRecursivo(raiz, new StringBuilder()).toString();
    }

    private StringBuilder inOrdenRecursivo(TElementoAB<T> n, StringBuilder resultado) {
        if (n != null) {
            inOrdenRecursivo(n.getHijoIzq(), resultado);
            resultado.append(n.getEtiqueta()).append(" ");
            inOrdenRecursivo(n.getHijoDer(), resultado);
        }
        return resultado;
    }

    @Override
    public String postOrden() {
        return postOrdenRecursivo(raiz, new StringBuilder()).toString();
    }
    
    private StringBuilder postOrdenRecursivo(TElementoAB<T> n, StringBuilder resultado){
        if(n != null){
            postOrdenRecursivo(n.getHijoIzq(), resultado);
            postOrdenRecursivo(n.getHijoDer(), resultado);
            resultado.append(n.getEtiqueta()).append(" ");
        }
        return resultado;
    }

    @Override
    public T eliminar(Comparable id) {
        TElementoAB<T> aux = raiz;
        TElementoAB<T> padre = raiz;
        boolean esIzq = true;
        T datoEliminado = null;

        while(aux.getEtiqueta() != id){
            padre = aux;
            if(id.compareTo(aux.getEtiqueta()) < 0){
                esIzq = true;
                aux = aux.getHijoIzq();
            } else{
                esIzq = false;
                aux = aux.getHijoDer();
            }
            // Llegó al final y no lo encontró
            if(aux == null){
                return null;
            }
        }

        datoEliminado = aux.getDato();
        //Caso que sea una hoja
        if(aux.getHijoIzq() == null && aux.getHijoDer() == null){
            if(aux == raiz){
                raiz = null;
            } else if(esIzq){
                padre.setHijoIzq(null);
            } else{
                padre.setHijoDer(null);;
            }
            //
        } else if(aux.getHijoDer() == null){
            if(aux == raiz){
                raiz = aux.getHijoIzq();
            } else if(esIzq){
                padre.setHijoIzq(aux.getHijoIzq());
            } else{
                padre.setHijoDer(aux.getHijoIzq());
            }
            //
        } else if(aux.getHijoIzq() == null){
            if(aux == raiz){
                raiz = aux.getHijoDer();
            } else if(esIzq){
                padre.setHijoDer(aux.getHijoDer());
            } else{
                padre.setHijoIzq(aux.getHijoDer());
            }
            //
        } else{
            TElementoAB<T> reemplazo = obtenerNodoReemplazo(aux);
            if(aux == raiz){
                raiz = reemplazo;
            } else if(esIzq){
                padre.setHijoIzq(reemplazo);
            } else{
                padre.setHijoDer(reemplazo);
            }
            reemplazo.setHijoIzq(aux.getHijoIzq());
        }

        
        return datoEliminado;
    }

    private TElementoAB<T> obtenerNodoReemplazo(TElementoAB<T> nodoReemp){
        TElementoAB<T> reemplazarPadre = nodoReemp;
        TElementoAB<T> reemplazo = nodoReemp;
        TElementoAB<T> aux = nodoReemp.getHijoDer();

        while(aux != null){
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.getHijoIzq();
        }
        if(reemplazo != nodoReemp.getHijoDer()){
            reemplazarPadre.setHijoIzq(reemplazo.getHijoDer());
            reemplazo.setHijoDer(nodoReemp.getHijoDer());
        }
        System.out.println("El nodo reemplazo es: " + reemplazo.getEtiqueta());
        return reemplazo;
    }

    public int altura(){
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(TElementoAB<T> nodo){
        if(nodo == null){
            return 0;
        } else{
            int alturaIzquierda = alturaRecursiva(nodo.getHijoIzq());
            int alturaDerecha = alturaRecursiva(nodo.getHijoDer());
            return Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
    }

    public int size(){
        return Tamano(raiz);
    }

    private int Tamano(TElementoAB<T> nodo){
        if(nodo == null) return 0;
        else{
            int tamanoIzquierdo = Tamano(nodo.getHijoIzq());
            int tamanoDerecho = Tamano(nodo.getHijoDer());
            return tamanoIzquierdo + tamanoDerecho + 1;
        }
    }

    public int contarHojas(){
        return contadorHojas(raiz);
    }

    private int contadorHojas(TElementoAB<T> nodo){
        if(nodo == null) return 0;
        if(nodo.getHijoIzq() == null && nodo.getHijoDer() == null) return 1;
        return contadorHojas(nodo.getHijoIzq()) + contadorHojas(nodo.getHijoDer());
    }

    public int buscarNivel(int clave){
        return buscarNivel(raiz, clave, 1);
    }

    private int buscarNivel(TElementoAB<T> nodo, Comparable clave, int nivel) {
        if (nodo == null) return -1;
        if (nodo.getEtiqueta().compareTo(clave) == 0) return nivel;
        int nivelIzquierdo = buscarNivel(nodo.getHijoIzq(), clave, nivel + 1);
        if (nivelIzquierdo != -1) return nivelIzquierdo;
        return buscarNivel(nodo.getHijoDer(), clave, nivel + 1);
    }

}
