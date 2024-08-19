

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    public static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        TNodoTrie actual = raiz;
        for(int i = 0; i < palabra.length(); i++){
            char ch = palabra.charAt(i);
            if(!actual.contiene(ch)){
                actual.put(ch, new TNodoTrie());
            }
            actual = actual.get(ch);
        }
        actual.setFin(true);
    }

    @Override
    public void imprimir() {
        LinkedList<String> palabras = new LinkedList<>();
        if (raiz != null) {
            imprimir(raiz, new StringBuilder(), palabras);
        }
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }

    private void imprimir(TNodoTrie nodo, StringBuilder prefijo, LinkedList<String> palabras) {
        if (nodo.esFin()) {
            palabras.add(prefijo.toString());
        }
        if (nodo.esHoja()) {
            return;
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (nodo.contiene(ch)) {
                prefijo.append(ch);
                imprimir(nodo.get(ch), prefijo, palabras);
                prefijo.deleteCharAt(prefijo.length() - 1);
            }
        }
    }

    @Override
    public int buscar(String palabra) {
        int count = 0;
        TNodoTrie nodo = raiz;
        for (int i = 0; i < palabra.length(); i++) {
            char ch = palabra.charAt(i);
            if (!nodo.contiene(ch)) {
                return 0; // La cadena no está en el Trie.
            }
            nodo = nodo.get(ch);
            count++;
        }
        // La cadena está en el Trie y puede ser una palabra completa o un prefijo.
        return count;
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        TNodoTrie nodo = raiz;
        for(int i = 0; i < prefijo.length(); i++){
            char ch = prefijo.charAt(i);
            if(!nodo.contiene(ch)){
                return palabras;
            }
            nodo = nodo.get(ch);
        }
        predecir(nodo, new StringBuilder(prefijo), palabras);
        return palabras;
    }

    private void predecir(TNodoTrie nodo, StringBuilder prefijo, LinkedList<String> palabras) {
        if(nodo.esFin()){
            palabras.add(prefijo.toString());
        }
        if(nodo.esHoja()){
            return;
        }
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(nodo.contiene(ch)){
                prefijo.append(ch);
                predecir(nodo.get(ch), prefijo, palabras);
                prefijo.deleteCharAt(prefijo.length() - 1);
            }
        }
    }
    
}
