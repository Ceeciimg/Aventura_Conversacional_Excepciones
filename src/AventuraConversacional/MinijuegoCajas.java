package AventuraConversacional;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MinijuegoCajas {
    public void jugar(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        int cajaCorrecta = (int) (Math.random() * 3) + 1;
        int eleccion = 0;

        System.out.println("\nHay tres cajas frente a ti. Solo una tiene algo útil.");

        try {


        System.out.println("Elige una caja (1, 2 o 3): ");
        eleccion = scanner.nextInt();

            if (eleccion < 1 || eleccion > 3) {
                System.out.println("Error: Debes elegir un número entre 1 y 3.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número válido.");
            return;

        }

        if (eleccion == cajaCorrecta) {
            System.out.println("¡Felicidades! Has encntrado un botiquín de primeros auxilios. Ganas 10 puntos de salud.");
            jugador.aumentarSalud(10);
        } else {
            System.out.println("Oh no... la caja está vacía. Pierdes 5 puntos de salud.");
            jugador.reducirSalud(5);
        }

        System.out.println("Salud actual: " + jugador.getSalud());
    }
}
