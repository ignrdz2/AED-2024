package tries;
public class nodo {
    //la variable hijos te permite almacenar los caracteres de la cadena que vas recorriendo;
    nodo[] hijos = new nodo[26]; // para letras minúsculas
    //hola
    //h -[o] -[l] -[a]
    //hoy
    //h -[o] -[y, l]
    //la variable finalDePalabra te permite identificar cuando has ingresado toda la cadena en el trie
    boolean finalDePalabra;

    nodo() {
        //define el final de palabra como false
        finalDePalabra = false;
        //colocar todos los elementos del arreglo en nulo
        //[a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z]
        for (int i = 0; i < 26; i++) {
            hijos[i] = null;
        }
    }
}
