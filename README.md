# Proyecto Prueba
Este repositorio contiene un archivo .java con el código fuente del proyecto.
Taller#6
Juego de la Vida en Java

Resumen del Proyecto

Este proyecto implementa el "Juego de la Vida" de John Conway en Java. El programa genera una matriz inicial de celdas vivas ('*') y muertas (' ') y aplica las reglas del juego para actualizar su estado en iteraciones.


Instrucciones


Estructuras de Datos:

Se usará una matriz bidimensional de tamaño 10x10 para representar el tablero del juego.
Cada celda de la matriz puede contener:
'*' (célula viva).
' ' (célula muerta).
Juego de la Vida:

Reglas del modelo celular:
Una célula viva ('*') con menos de 2 o más de 3 vecinos vivos muere.
Una célula viva ('*') con exactamente 2 o 3 vecinos vivos sobrevive.
Una célula muerta (' ') con exactamente 3 vecinos vivos revive ('*').
Prueba de Escritorio:

Simulación manual del comportamiento en un punto específico:
Evaluar el estado inicial del punto (0,0) y sus vecinos.
Aplicar las reglas del modelo celular.
Registrar el estado final de la celda (0,0) después de una iteración.


Realizar una prueba de escritorio detallada para la celda (0,0).

-Prueba de Escritorio


Celda (0,0)

Estado inicial: '*' (viva).


*         *     *   
*   * * *         * 
*   *     *   *   * 
...

Vecinos:

(0,1): ' ' (muerta).

(1,0): '*' (viva).

(1,1): ' ' (muerta).

Vecinos vivos: 1.

Estado final: ' ' (muerta por soledad).



  *   * *           
*   * * * * *     * 
*   *           *   
...

Código



        
       //import java.util.Random;
       
    public class JuegoDeLaVida {

    public static void main(String[] args) {
        int filas = 10, columnas = 10;
        char[][] matriz = new char[filas][columnas];
        Random random = new Random();

        // Inicializar la matriz con celdas vivas ('*') y muertas (' ')
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextBoolean() ? '*' : ' ';
            }
        }

        // Mostrar estado inicial
        System.out.println("Estado inicial:");
        imprimirMatriz(matriz);

        // Actualizar la matriz usando las reglas del Juego de la Vida
        char[][] nuevaMatriz = actualizarMatriz(matriz);

        // Mostrar estado posterior
        System.out.println("\nEstado posterior:");
        imprimirMatriz(nuevaMatriz);
    }

    // Actualiza la matriz según las reglas del Juego de la Vida
    public static char[][] actualizarMatriz(char[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        char[][] nuevaMatriz = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int vecinosVivos = contarVecinosVivos(matriz, i, j);

                if (matriz[i][j] == '*') { // Célula viva
                    if (vecinosVivos < 2 || vecinosVivos > 3) {
                        nuevaMatriz[i][j] = ' '; // Muere
                    } else {
                        nuevaMatriz[i][j] = '*'; // Sobrevive
                    }
                } else { // Célula muerta
                    if (vecinosVivos == 3) {
                        nuevaMatriz[i][j] = '*'; // Revive
                    } else {
                        nuevaMatriz[i][j] = ' '; // Sigue muerta
                    }
                }
            }
        }
        return nuevaMatriz;
    }

    // Cuenta los vecinos vivos de una celda
    public static int contarVecinosVivos(char[][] matriz, int fila, int columna) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int vivos = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Ignorar la celda actual
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;

                // Validar que los índices estén dentro del rango
                if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas) {
                    if (matriz[nuevaFila][nuevaColumna] == '*') {
                        vivos++;
                    }
                }
            }
        }
        return vivos;
    }

    // Imprimir la matriz
    public static void imprimirMatriz(char[][] matriz) {
        for (char[] fila : matriz) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }


    }
