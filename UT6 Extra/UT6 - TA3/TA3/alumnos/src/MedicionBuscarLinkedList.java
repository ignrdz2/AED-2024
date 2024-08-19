import java.util.LinkedList;
import java.util.List;

public class MedicionBuscarLinkedList extends Medible{

    private LinkedList linkedList;

    public MedicionBuscarLinkedList(LinkedList linkedList) {
        this.linkedList = linkedList;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                linkedList.contains(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.linkedList;
    }

    public List<String> predecirPalabra(String prefijo) {
        List<String> palabrasCoincidentes = new LinkedList<>();
        for(Object obj : linkedList){
            String palabra = (String) obj;
            if(palabra.startsWith(prefijo)){
                palabrasCoincidentes.add(palabra);
            }
        }
        return palabrasCoincidentes;
    }


}
