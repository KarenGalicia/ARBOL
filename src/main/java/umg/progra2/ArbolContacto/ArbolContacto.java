package umg.progra2.ArbolContacto;

import umg.progra2.Datos.Personas;

public class ArbolContacto {
    private NodoContacto raiz;

    public ArbolContacto() {
        raiz = null;
    }

    public void insertar(Personas persona) {
        if (this.raiz == null) {
            this.raiz = new NodoContacto(persona);
        }else {
            this.insertar(this.raiz, persona);
        }
    }

    //El arbol tomara el nombre como criterio para ordenar los nodos, por eso se usa getNombre, asi se obtiene la cadena del nombre
    public void insertar(NodoContacto padre, Personas persona) {
        if (persona.getNombre().compareTo(padre.valorNodo().getNombre()) < 0 ){ //persona.getNombre es el string que se va a comparar
            if (padre.getSubarbolIzdo() == null){
                padre.setRamaIzdo(new NodoContacto(persona));
            } else {
                insertar(padre.getSubarbolIzdo(), persona);
            }
        } else if (persona.getNombre().compareTo(padre.valorNodo().getNombre()) > 0){
            if (padre.getSubarbolDcho() == null){
                padre.setRamaDcho(new NodoContacto(persona));
            }else {
                insertar(padre.getSubarbolDcho(), persona);
            }
        }

    }

    // Metdo para imprimir el arbol en INORDEN
    public void inOrden() {
        inOrden(this.raiz);
    }

    private void inOrden(NodoContacto nodo) {
        if (nodo != null) {
            inOrden(nodo.getSubarbolIzdo());
            nodo.imprimirDato();
            inOrden(nodo.getSubarbolDcho());
        }
    }

}
