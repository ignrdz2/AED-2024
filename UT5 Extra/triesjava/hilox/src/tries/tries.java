package tries;
public class tries {
    //nodo raiz siempre tiene un valor nulo ya que marca el inicio de las palabras
    nodo root;

    public tries() {
        root = new nodo();
    }
    //insertar elementos dentro del trie
    //argumento: word que va a ser la palabra a ingresar dentro del trie
    public void insert(String word) {
        nodo curr = root;
        //gas 4
        //recorremos la cadena letra por letra
        for (int i = 0; i < word.length(); i++) {
            // i=0
            //word.charAt(0) == h
            // 104-97=7
            //el index te permite obtener la posición que tomara la letra en el arreglo.
            int index = word.charAt(i) - 'a'; // índice de la letra en el arreglo
            //verifica si la posición del elemento a ingresar esta vacia para asi crearlo
            if (curr.hijos[index] == null) {
                curr.hijos[index] = new nodo();
            }
            
            curr = curr.hijos[index];
        }
        curr.finalDePalabra = true;
    }

    public boolean search(String word) {
        nodo curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.hijos[index] == null) {
                return false;
            }
            curr = curr.hijos[index];
        }
        return curr != null && curr.finalDePalabra;
    }

    public boolean startsWith(String prefix) {
        nodo curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.hijos[index] == null) {
                return false;
            }
            curr = curr.hijos[index];
        }
        return true;
    }
}
