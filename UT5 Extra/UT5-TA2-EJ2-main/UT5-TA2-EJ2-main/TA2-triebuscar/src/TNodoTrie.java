

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        
        imprimir("", this);
    }


    private TNodoTrie buscarNodoTrie(String palabra) {
        TNodoTrie nodo = this;
        for (int i = 0; i < palabra.length(); i++) {
            char ch = palabra.charAt(i);
            if (!nodo.contiene(ch)) {
                return null;
            }
            nodo = nodo.get(ch);
        }
        return nodo;
    }
    
    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos[c]);
                }
            }
        }
    }
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = buscarNodoTrie(prefijo);
        predecir("", prefijo, palabras, nodo);
    }

    @Override
    public int buscar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean contiene(char ch){
        return hijos[ch - 'a'] != null;
    }
  
    public TNodoTrie get(char ch){
        return hijos[ch - 'a'];
    }

    public void put(char ch, TNodoTrie nodo){
        hijos[ch - 'a'] = nodo;
    }

    public void setFin(boolean esFin){
        this.esPalabra = esFin;
    }
    
    public boolean esFin(){
        return esPalabra;
    }

    public boolean esHoja(){
        for(TNodoTrie hijo : hijos){
            if(hijo != null){
                return false;
            }
        }
        return true;
    }
}
