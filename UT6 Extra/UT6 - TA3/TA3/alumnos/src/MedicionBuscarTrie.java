public class MedicionBuscarTrie extends Medible {
    public MedicionBuscarTrie(TArbolTrie trie) {
        this.tArbolTrie=trie;
    }
    private TArbolTrie tArbolTrie;

    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                tArbolTrie.buscar(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.tArbolTrie;
    }
}
