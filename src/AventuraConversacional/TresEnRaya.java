package AventuraConversacional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TresEnRaya {
    private char[][] tablero;
    private char jugadorActual;
    private boolean juegoActivo;
    private Scanner scanner;

    public TresEnRaya() {
        tablero = new char[3][3]; // tablero de 3x3
        jugadorActual = 'X'; // El primer jugador es X
        juegoActivo = true;
        scanner = new Scanner(System.in);
        inicializarTablero(); // el tablero está vacío
    }


    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Mostrar el tablero
    private void mostrarTablero() {
        System.out.println("-----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-----------");
        }
    }

    // Verificar si hay un ganador
    private boolean verificarGanador() {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != ' ') ||
                (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != ' ')) {
                return true;
            }
        }
        // Verificar diagonales
        if ((tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != ' ') ||
            (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != ' ')) {
            return true;
        }
        return false;
    }

    // Verificar si el tablero está lleno 
    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Iniciar el juego
    public void jugar() {
        while (juegoActivo) {
            mostrarTablero();
            System.out.println("Es el turno del jugador " + jugadorActual);

            try {
            System.out.print("Ingresa la fila (0, 1, 2): ");
            int fila = scanner.nextInt();
            System.out.print("Ingresa la columna (0, 1, 2): ");
            int columna = scanner.nextInt();

                if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
                    throw new ArrayIndexOutOfBoundsException("Índice fuera de los límites del tablero.");

                }

            // Verificar si la celda está vacía
            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                tablero[fila][columna] = jugadorActual;

                // Verificar si el jugador ha ganado
                if (verificarGanador()) {
                    mostrarTablero();
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                    juegoActivo = false;
                } else if (verificarEmpate()) {
                    mostrarTablero();
                    System.out.println("¡Es un empate!");
                    juegoActivo = false;
                } else {
                    // Cambiar al siguiente jugador
                    jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Celda inválida, intenta de nuevo.");
            }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                scanner.next();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }


        }


