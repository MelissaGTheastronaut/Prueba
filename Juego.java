package Taller6;

import java.util.Random;



public class Juego {
    public static void main(String[] args) {
        int filas = 10, columnas = 10;
        char[][] matriz = new char[filas][columnas];
        Random random = new Random();

        // Generar y mostrar la matriz inicial
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextBoolean() ? '*' : ' ';
            }
        }
        System.out.println("Matriz inicial:");
        imprimirMatriz(matriz);

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
