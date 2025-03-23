package umg.progra2.ArbolCadena;

public class ArbolCadena {
        private NodoCadena raiz;
        public ArbolCadena() {
            this.raiz = null;
        }

        public void insertar(String dato) {
            if (this.raiz == null) {
                this.raiz = new NodoCadena(dato);
            }else {
                this.insertar(this.raiz, dato);
            }
        }

        public void insertar(NodoCadena padre, String dato) {
            if (dato.compareTo(padre.valorNodo()) < 0){
                if (padre.getSubarbolIzdo() == null){
                    padre.setRamaIzdo(new NodoCadena(dato));
                }else {
                    insertar(padre.getSubarbolIzdo(), dato);
                }
            }else if (dato.compareTo(padre.valorNodo()) > 0){
                if (padre.getSubarbolDcho() == null){
                    padre.setRamaDcho(new NodoCadena(dato));
                }else{
                    insertar(padre.getSubarbolDcho(), dato);
                }
            }
        }
    }
