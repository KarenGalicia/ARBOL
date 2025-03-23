package umg.progra2.ArbolContacto;


import umg.progra2.Datos.Personas;

public class NodoContacto {
    protected Personas persona;
    protected NodoContacto izdo;
    protected NodoContacto dcho;

    //primer constructor
    public NodoContacto(Personas persona) {
        this.persona = persona;
        izdo = dcho = null;
    }

    //segundo constructor
    public NodoContacto (NodoContacto ramaIzdo, Personas persona, NodoContacto ramaDcho){
        this.persona = persona;
        izdo = ramaIzdo;
        dcho = ramaDcho;
    }
    //accesos:
    public Personas valorNodo(){
        return persona;
    }

    public NodoContacto getSubarbolIzdo(){
        return izdo;
    }

    public NodoContacto getSubarbolDcho(){
        return dcho;
    }

    public void setRamaIzdo (NodoContacto n){
        izdo = n;
    }
    public void setRamaDcho (NodoContacto n){
        dcho = n;
    }

    public void imprimirDato (){
        System.out.println("Nombre: " + persona.getNombre() + " - Teléfono: " + persona.getNumeroTelefono());
    }

}
