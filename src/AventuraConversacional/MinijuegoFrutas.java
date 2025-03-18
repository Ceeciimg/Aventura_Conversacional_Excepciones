package AventuraConversacional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MinijuegoFrutas {
    private Scanner scanner;

    public MinijuegoFrutas() {
        this.scanner = new Scanner(System.in);
    }

    public void jugar(Jugador jugador) {

        int frutasReales = (int) (Math.random() * 10) + 1;  // Número aleatorio entre 1 y 10
        System.out.println("Introduce un número: ");
        int intento = 0;


        try {
        intento = scanner.nextInt();

            if (intento < 1 || intento > 10) {
                System.out.println("Error: El número debe estar entre 1 y 10.");
                return;
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.next(); // Limpiarvel buffer del scanner
            return;
        }

        if (intento == frutasReales) {
            System.out.println("¡Increíble! Has adivinado el número exacto de frutas. Obtienes 5 puntos de salud.");
            jugador.aumentarSalud(5);
        } else {
            System.out.println("No era la cantidad exacta, pero aún así recoges algunas frutas. Obtienes 2 puntos de salud.");
            jugador.aumentarSalud(2);
        }

        System.out.println("Salud actual: " + jugador.getSalud());
    }

    
}

