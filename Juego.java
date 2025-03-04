package Taller6;

import java.util.Random;



import java.util.Random;

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
