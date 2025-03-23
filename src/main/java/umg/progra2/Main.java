package umg.progra2;

import umg.progra2.ArbolBinario.Arbol;


public class Main {
    public static void main(String[] args) {

        Arbol arbol = new Arbol();
        arbol.insertar(71);
        arbol.insertar(81);
        arbol.insertar(96);
        arbol.insertar(55);
        arbol.insertar(77);
        arbol.insertar(69);
        arbol.insertar(89);

        System.out.println("Preorden");
        arbol.preorden();
        System.out.println("Inorden");
        arbol.inorden();
        System.out.println("Postorden");
        arbol.postorden();

        // En tu método main
        System.out.println("\nEstructura del árbol:");
        arbol.mostrarArbol();

        System.out.println("\nEstructura del árbol (formato mejorado):");
        arbol.mostrarArbolMejorado();

        arbol.mostrarArbolGrafico();
    }
}



//    ArbolCadena cadena = new ArbolCadena();
//        cadena.insertar("Karen");
//  Arbol arbol = new Arbol();      cadena.insertar("Pablo");
//        cadena.insertar("Carlos");
//        cadena.insertar("Rafael");
//        cadena.insertar("Héctor");
//        System.out.println("FIN!");

//creear los contactos
//Personas p1 = new Personas();
//p1.setNombre("Carlos");
//p1.setNumeroTelefono(5551234);
// p1.setDireccion("Zona 15");

//  Personas p2 = new Personas();
//  p2.setNombre("Karen");
//              p2.setNumeroTelefono(5555678);
//              p2.setDireccion("Zona 2");

//              Personas p3 = new Personas();
//             p3.setNombre("Rafael");
//               p3.setNumeroTelefono(5558765);
//              p3.setDireccion("Zona 3");

//insetar cointactos al arbol
// arbol.insertar(p1);
//              arbol.insertar(p2);
//              arbol.insertar(p3);


//  System.out.println("Recorrido en preorden:");
//              Arbol.preorden(); // Usamos la instancia 'arbol'
//
//              System.out.println("Recorrido en postorden:");
//              Arbol.postorden(); // Usamos la instancia 'arbol'
//
//        System.out.println("Recorrido en inorden:");
//    Arbol.inorden(); // Usamos la instancia 'arbol'
//      }


