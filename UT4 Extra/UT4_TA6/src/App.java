public class App {
    public static void main(String[] args) throws Exception {

        String[] claves = ManejadorArchivosGenerico.leerArchivo("src/claves1.txt");

        TArbolBB arbolBB = new TArbolBB<>();

        for (String clave : claves) {
            //TElementoAB<String> elementoAB = new TElementoAB<String>(clave, clave);
            int claveInt = Integer.parseInt(clave);

            arbolBB.insertar(claveInt, null);
            
        }

        System.out.println("preOrden: ");
        System.out.println(arbolBB.preOrden());
        System.out.println("inOrden: ");
        System.out.println(arbolBB.inOrden());
        System.out.println("postOrden: ");
        System.out.println(arbolBB.postOrden());

        

    }
}