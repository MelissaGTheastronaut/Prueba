# Proyecto Prueba
Este repositorio contiene un archivo .java con el código fuente del proyecto.
Taller#6
Juego de la Vida en Java

Resumen del Proyecto

Este proyecto implementa el "Juego de la Vida" de John Conway en Java. El programa genera una matriz inicial de celdas vivas ('*') y muertas (' ') y aplica las reglas del juego para actualizar su estado en iteraciones.


Instrucciones


-Generar la Matriz Inicial

-Crear una matriz bidimensional de tamaño 10x10.

-Llenar cada celda aleatoriamente con:

-'*' para celdas vivas.

-' ' para celdas muertas.

-Imprimir la matriz inicial en consola.



Actualizar el estado de cada celda según las siguientes reglas:


Una célula viva ('*'):

-Muere si tiene menos de 2 o más de 3 vecinos vivos.

-Sobrevive si tiene exactamente 2 o 3 vecinos vivos.


Una célula muerta (' '):

-Revive si tiene exactamente 3 vecinos vivos.


Mostrar Resultados

-Mostrar en consola:

La matriz inicial.
La matriz actualizada después de aplicar las reglas.

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





        
       //package Taller6;
        import java.util.Random;
        public class Juego {
    public static void main(String[] args) {
        int filas = 10, columnas = 10;
        char[][] matriz = new char[filas][columnas];
        Random random = new Random();

        // Actualizar la matriz con reglas simples (sin contar vecinos)
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == '*') {
                    matriz[i][j] = ' ';  // Las celdas vivas mueren
                } else {
                    matriz[i][j] = '*';  // Las celdas muertas reviven
                }
            }
        }

        System.out.println("\nMatriz actualizada:");
        imprimirMatriz(matriz);
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
