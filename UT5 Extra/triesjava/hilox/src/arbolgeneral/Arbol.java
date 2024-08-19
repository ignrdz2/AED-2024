
package arbolgeneral;
public class Arbol {
    Nodo raiz;

    public Arbol() {
        this.raiz=null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo Raiz) {
        this.raiz = Raiz;
    }
    
    public Nodo buscarPadre(int busqueda){
        if(this.raiz.getDato()==busqueda){
            return this.raiz.getPadre();
        }
        else{
            return buscarPadreRecursivo(this.raiz,busqueda);
        }
    }
    public Nodo buscarPadreRecursivo(Nodo actual,int busqueda){
        //nodo para retornar el padre del buscado
        Nodo PadreEncontrado=null;
        //si el valor del hijo del nodo actual es igual al buscado retorna al nodo
        if(actual.getDato()==busqueda){
            PadreEncontrado=actual.getPadre();
            return PadreEncontrado;
        }
        else{
            if(actual.getPrimerHijo()!=null){
                Nodo a=buscarPadreRecursivo(actual.getPrimerHijo(),busqueda);
                if(a!=null){
                    PadreEncontrado=a;
                }
            }
            if(actual.getHermanoDerecho()!=null){
                Nodo a=buscarPadreRecursivo(actual.getHermanoDerecho(),busqueda);
                if(a!=null){
                    PadreEncontrado=a;
                }
            }
            
        }
        return PadreEncontrado;
    }
    
    public void insertarHijo(int destino,Nodo nuevoNodo){
        //entero destino indica donde se ingresa el nodo hijo
        //nuevo nodo indica el nodo a agregar
        if(this.raiz==null){
            this.raiz=nuevoNodo;
            this.raiz.setPadre(this.raiz);
        }
        else{
            insertarRecursivo(this.raiz,destino,nuevoNodo);
        }
    }
    public void insertarRecursivo(Nodo actual,int destino,Nodo nuevoNodo){
        if(actual.getDato()==destino){
            //si encontramos el nodo de destino le agregamos un hijo
            actual.setPrimerHijo(nuevoNodo);
            actual.getPrimerHijo().setPadre(actual);
        }
        else{
            if(actual.getPrimerHijo()!=null){
                insertarRecursivo(actual.getPrimerHijo(),destino,nuevoNodo);
            }
            if(actual.getHermanoDerecho()!=null){
                insertarRecursivo(actual.getHermanoDerecho(),destino,nuevoNodo);
            }
        }
    }
    public void insertarHermano(int destino,Nodo nuevoNodo){
        if(this.raiz==null){
            this.raiz=nuevoNodo;
            this.raiz.setPadre(this.raiz);
        }
        else{
            insertarRecursivoHermano(this.raiz,destino,nuevoNodo);
        }
    }
    public void insertarRecursivoHermano(Nodo actual,int destino,Nodo nuevoNodo){
        if(actual.getDato()==destino){
            //si encontramos el nodo de destino le agregamos un hijo
            actual.setHermanoDerecho(nuevoNodo);
            if(actual.getPadre()!=null){
                actual.getHermanoDerecho().setPadre(actual.getPadre());
            }
        }
        else{
            if(actual.getPrimerHijo()!=null){
                insertarRecursivoHermano(actual.getPrimerHijo(),destino,nuevoNodo);
            }
            if(actual.getHermanoDerecho()!=null){
                insertarRecursivoHermano(actual.getHermanoDerecho(),destino,nuevoNodo);
            }
        }
    }
    public void preOrden(){
        preOrdenRecursivo(raiz);
    }
    public void preOrdenRecursivo(Nodo valor){
        if(valor!=null){
            System.out.println(valor.getPadre().getDato());
            preOrdenRecursivo(valor.getPrimerHijo());//izquierdo
            preOrdenRecursivo(valor.getHermanoDerecho());//derecho
        }
    }
    public void postOrden(){
        postOrdenRecursivo(raiz);
    }
    public void postOrdenRecursivo(Nodo valor){
        if(valor!=null){
            postOrdenRecursivo(valor.getPrimerHijo());//izquierdo
            postOrdenRecursivo(valor.getHermanoDerecho());//derecho
            System.out.println(valor.getDato());
        }
    }
    public void inOrden(){
        inOrdenRecursivo(raiz);
    }
    public void inOrdenRecursivo(Nodo valor){
        if(valor!=null){
            inOrdenRecursivo(valor.getPrimerHijo());//izquierdo
            System.out.println(valor.getDato());
            inOrdenRecursivo(valor.getHermanoDerecho());//derecho
        }
    }
    
}
