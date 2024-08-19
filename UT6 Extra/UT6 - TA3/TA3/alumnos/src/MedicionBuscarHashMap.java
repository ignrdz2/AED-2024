import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MedicionBuscarHashMap extends Medible {
    public MedicionBuscarHashMap(HashMap hashMap) {
        this.hashMap=hashMap;
    }
    private HashMap hashMap;

    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                hashMap.containsValue(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.hashMap;
    }

    public List<String> predecirPalabra(String prefijo) {
        List<String> palabrasCoincidentes = new ArrayList<>();
        for(Object obj : hashMap.keySet()){
            String palabra = (String) obj;
            if(palabra.startsWith(prefijo)){
                palabrasCoincidentes.add(palabra);
            }
        }
        return palabrasCoincidentes;
    }
}
