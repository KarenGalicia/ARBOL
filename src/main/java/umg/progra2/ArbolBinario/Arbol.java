package umg.progra2.ArbolBinario;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Arbol {
    //nodo root
    private Nodo raiz;
    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        }else {
            this.insertar(this.raiz, dato);
        }
    }

    public void insertar(Nodo padre, int dato) {
        if (dato < padre.valorNodo()){
            if (padre.getSubarbolIzdo() == null){
                padre.setRamaIzdo(new Nodo(dato));
            }else {
                insertar(padre.getSubarbolIzdo(), dato);
            }
        }else if (dato > padre.valorNodo()){
            if (padre.getSubarbolDcho() == null){
                padre.setRamaDcho(new Nodo(dato));
            }else{
                insertar(padre.getSubarbolDcho(), dato);
            }
        }
    }
    //RECORRIDOS DEL ARBOL, POSTORDEN, PREORDEN, INORDEN

    //metodo para recorrido en postorden
    public void postorden(){
        postorden(this.raiz);
    }

    private void postorden (Nodo nodo){
        if (nodo != null){
            postorden(nodo.getSubarbolIzdo());
            postorden(nodo.getSubarbolDcho());
            System.out.println(nodo.valorNodo() + "");
            // Visualizar el nodo actual en el recorrido
            JFrame frame = new JFrame("Visualización Postorden - Nodo: " + nodo.valorNodo());
            VisualizadorArbol visualizador = new VisualizadorArbol(this);
            visualizador.setNodoActual(nodo);
            frame.add(visualizador);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            try { Thread.sleep(1000); } catch (InterruptedException e) { }
        }
    }

    //metodo para recorrido en preorden
    public void preorden (){
        preorden(this.raiz);
    }

    private void preorden (Nodo nodo){
        if (nodo != null){
            System.out.println(nodo.valorNodo() + "");
            // Visualizar el nodo actual en el recorrido
            JFrame frame = new JFrame("Visualización Preorden - Nodo: " + nodo.valorNodo());
            VisualizadorArbol visualizador = new VisualizadorArbol(this);
            visualizador.setNodoActual(nodo);
            frame.add(visualizador);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            try { Thread.sleep(1000); } catch (InterruptedException e) { }
            
            preorden(nodo.getSubarbolIzdo());
            preorden(nodo.getSubarbolDcho());
        }
    }

    //metodo para recorrido en orden
    public void inorden(){
        inorden(this.raiz);
    }

    private void inorden (Nodo nodo){
        if (nodo != null){
            inorden(nodo.getSubarbolIzdo());
            System.out.println(nodo.valorNodo() + "");
            // Visualizar el nodo actual en el recorrido
            JFrame frame = new JFrame("Visualización Inorden - Nodo: " + nodo.valorNodo());
            VisualizadorArbol visualizador = new VisualizadorArbol(this);
            visualizador.setNodoActual(nodo);
            frame.add(visualizador);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            try { Thread.sleep(1000); } catch (InterruptedException e) { }
            
            inorden(nodo.getSubarbolDcho());
        }
    }

    // Método público para mostrar el árbol
    public void mostrarArbol() {
        if (this.raiz == null) {
            System.out.println("El árbol está vacío");
            return;
        }

        // Obtener la altura del árbol para calcular el ancho de la visualización
        int altura = obtenerAltura(this.raiz);

        // Matriz para almacenar la representación del árbol
        String[][] matriz = new String[altura * 2][calculaAncho(altura)];

        // Inicializar la matriz con espacios
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = " ";
            }
        }

        // Llenar la matriz con la representación del árbol
        llenarMatriz(matriz, this.raiz, 0, 0, matriz[0].length - 1);

        // Imprimir la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }

    // Método para obtener la altura del árbol
    private int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzquierda = obtenerAltura(nodo.getSubarbolIzdo());
        int alturaDerecha = obtenerAltura(nodo.getSubarbolDcho());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // Método para calcular el ancho necesario para la visualización
    private int calculaAncho(int altura) {
        return (int) Math.pow(2, altura) * 4;
    }

    // Método recursivo para llenar la matriz con la representación del árbol
    private void llenarMatriz(String[][] matriz, Nodo nodo, int nivel, int min, int max) {
        if (nodo == null) {
            return;
        }

        int medio = (min + max) / 2;

        // Dibujar el nodo actual (simular un círculo)
        matriz[nivel * 2][medio - 1] = "(";
        matriz[nivel * 2][medio] = String.valueOf(nodo.valorNodo());
        matriz[nivel * 2][medio + 1] = ")";

        // Si hay hijo izquierdo, dibujar la conexión y procesar el subárbol izquierdo
        if (nodo.getSubarbolIzdo() != null) {
            int medioIzquierdo = (min + medio) / 2;

            // Dibujar la línea de conexión al hijo izquierdo
            matriz[nivel * 2 + 1][medioIzquierdo] = "╱";

            // Procesar el subárbol izquierdo
            llenarMatriz(matriz, nodo.getSubarbolIzdo(), nivel + 1, min, medio - 1);
        }

        // Si hay hijo derecho, dibujar la conexión y procesar el subárbol derecho
        if (nodo.getSubarbolDcho() != null) {
            int medioDerecho = (medio + max) / 2;

            // Dibujar la línea de conexión al hijo derecho
            matriz[nivel * 2 + 1][medioDerecho] = "╲";

            // Procesar el subárbol derecho
            llenarMatriz(matriz, nodo.getSubarbolDcho(), nivel + 1, medio + 1, max);
        }
    }

    // Método mejorado que muestra un árbol con una representación más atractiva
    public void mostrarArbolMejorado() {
        mostrarArbolMejorado(this.raiz, "", true);
    }

    private void mostrarArbolMejorado(Nodo nodo, String prefijo, boolean esUltimo) {
        if (nodo == null) {
            return;
        }

        // Imprime el nodo actual
        System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + "(" + nodo.valorNodo() + ")");

        // Calcula el prefijo para los hijos
        String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");

        // Procesa los hijos
        boolean tieneHijoDerecho = nodo.getSubarbolDcho() != null;

        // Primero procesamos el hijo izquierdo
        if (nodo.getSubarbolIzdo() != null) {
            mostrarArbolMejorado(nodo.getSubarbolIzdo(), nuevoPrefijo, !tieneHijoDerecho);
        }

        // Luego procesamos el hijo derecho
        if (tieneHijoDerecho) {
            mostrarArbolMejorado(nodo.getSubarbolDcho(), nuevoPrefijo, true);
        }
    }

    public void mostrarArbolGrafico() {
        JFrame frame = new JFrame("Visualizador de Árbol Binario");
        VisualizadorArbol visualizador = new VisualizadorArbol(this);
        frame.add(visualizador);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Método para obtener la referencia al nodo raíz (necesario para el visualizador)
     */
    public Nodo getRaiz() {
        return this.raiz;
    }

    /**
     * Clase interna para visualizar el árbol gráficamente
     */
    private class VisualizadorArbol extends JPanel {
        private Arbol arbol;
        private final int DIAMETRO_NODO = 50;
        private final int RADIO = DIAMETRO_NODO / 2;
        private final int ESPACIO_VERTICAL = 80;

        public VisualizadorArbol(Arbol arbol) {
            this.arbol = arbol;
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (arbol.getRaiz() != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int altura = obtenerAltura(arbol.getRaiz());
                int anchuraPanel = getWidth();

                dibujarNodo(g2d, arbol.getRaiz(), anchuraPanel / 2, 30, anchuraPanel / 4, 1, altura);
            }
        }

        /**
         * Dibuja recursivamente los nodos del árbol
         */
        private void dibujarNodo(Graphics2D g2d, Nodo nodo, int x, int y, int espacioHorizontal, int nivel, int alturaTotal) {
            if (nodo == null) return;

            // Dibujar las líneas de conexión a los hijos
            int espacioSiguienteNivel = espacioHorizontal / 2;

            if (nodo.getSubarbolIzdo() != null) {
                int hijoX = x - espacioHorizontal;
                int hijoY = y + ESPACIO_VERTICAL;
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(2.0f));
                g2d.draw(new Line2D.Double(x, y + RADIO, hijoX, hijoY));

                dibujarNodo(g2d, nodo.getSubarbolIzdo(), hijoX, hijoY, espacioSiguienteNivel, nivel + 1, alturaTotal);
            }

            if (nodo.getSubarbolDcho() != null) {
                int hijoX = x + espacioHorizontal;
                int hijoY = y + ESPACIO_VERTICAL;
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(2.0f));
                g2d.draw(new Line2D.Double(x, y + RADIO, hijoX, hijoY));

                dibujarNodo(g2d, nodo.getSubarbolDcho(), hijoX, hijoY, espacioSiguienteNivel, nivel + 1, alturaTotal);
            }

            // Dibujar el nodo
            g2d.setColor(new Color(100, 200, 50)); // Verde similar a la imagen
            g2d.fill(new Ellipse2D.Double(x - RADIO, y, DIAMETRO_NODO, DIAMETRO_NODO));

            // Borde del nodo
            g2d.setColor(new Color(0, 100, 0));
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.draw(new Ellipse2D.Double(x - RADIO, y, DIAMETRO_NODO, DIAMETRO_NODO));

            // Dibujar el valor dentro del nodo
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            String valorStr = String.valueOf(nodo.valorNodo());
            FontMetrics fm = g2d.getFontMetrics();
            int textoX = x - fm.stringWidth(valorStr) / 2;
            int textoY = y + DIAMETRO_NODO / 2 + fm.getAscent() / 2 - 2;
            g2d.drawString(valorStr, textoX, textoY);
        }

        public void setNodoActual(Nodo nodo) {
        }
    }
}