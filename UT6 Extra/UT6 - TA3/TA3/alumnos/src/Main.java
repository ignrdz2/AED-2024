import java.util.*;

public class Main {

    private static final int REPETICIONES = 100;

    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();      
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
         String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\ignrd\\OneDrive\\Escritorio\\AED\\UT6\\UT6 - TA3\\TA3\\alumnos\\src\\listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\ignrd\\OneDrive\\Escritorio\\AED\\UT6\\UT6 - TA3\\TA3\\alumnos\\src\\listado-general_palabrasBuscar.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
                linkedList.add(p);
                arrayList.add(p);
                hashMap.put(p,p);
                treeMap.put(p, p);
        }
        
        Medible[] medibles = new Medible[5];
        int i = 0;
        medibles[i++] = new MedicionBuscarLinkedList(linkedList);
        medibles[i++] = new MedicionBuscarArrayList(arrayList);
        medibles[i++] = new MedicionBuscarTrie(trie);
        medibles[i++] = new MedicionBuscarHashMap(hashMap);
        medibles[i++] = new MedicionBuscarTreeMap(treeMap);
        Medicion mi;
	    i = 0;
        Object[] params = {REPETICIONES, palabrasBuscar};
        String[] lineas = new String[6];
		lineas[i++] = "algoritmo,tiempo,memoria";
		for (Medible m: medibles){
            mi= m.medir(params);
			mi.print();
			lineas[i++] = mi.getTexto()+","+mi.getTiempoEjecucion().toString()+","+mi.getMemoria().toString();
			
        }

        MedicionBuscarLinkedList medList = new MedicionBuscarLinkedList(linkedList);
        MedicionBuscarHashMap medMap = new MedicionBuscarHashMap(hashMap);

        String prefijo = "cas";
        int numMediciones = 20;
        long[][] tiempos = new long[5][numMediciones];

        List<String> resultados = new ArrayList<>();

        for (int j = 0; j < numMediciones; j++) {
            long inicio = System.nanoTime();
            List<String> resultadoTrie = trie.predecir(prefijo);
            long fin = System.nanoTime();
            tiempos[0][j] = fin - inicio;
            resultados.addAll(resultadoTrie);

            inicio = System.nanoTime();
            List<String> resultadoList = medList.predecirPalabra(prefijo);
            fin = System.nanoTime();
            tiempos[1][j] = fin - inicio;
            resultados.addAll(resultadoList);

            inicio = System.nanoTime();
            List<String> resultadoMap = medMap.predecirPalabra(prefijo);
            fin = System.nanoTime();
            tiempos[2][j] = fin - inicio;
            resultados.addAll(resultadoMap);
        }

        ManejadorArchivosGenerico.escribirArchivo("resultados2.txt", resultados.toArray(new String[0]));

        // 3
		ManejadorArchivosGenerico.escribirArchivo("resultados3.txt",lineas);
    }
}