package AventuraConversacional;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego {
    private boolean juegoActivo;
    private Scanner scanner;
    private Jugador jugador;
    private NPC guia;
    private Playa playa;
    private Jungla jungla;
    private Escenario cabaña;

    public Juego() {
        this.juegoActivo = true;
        this.scanner = new Scanner(System.in);
        this.jugador = new Jugador("Explorador", 100);
        this.guia = new NPC("Guía", "Si deseas encontrar comida, debes buscar cerca del río. Hay árboles frutales por allí.");
        this.playa = new Playa();  
        this.jungla = new Jungla();
        this.cabaña = new Escenario("Cabaña", "Has entrado a una cabaña abandonada.");
    }

    public void iniciarJuego() {
        System.out.println("Bienvenido a 'La Isla Misteriosa'");
        System.out.println("Te despiertas en la arena de la playa...");
        System.out.println(playa.getDescripcion());
       
        // se inicia el juego

        while (juegoActivo) {

            try {

            // Mostrar el menú de opciones
            System.out.println("\n¿Qué quieres hacer?");
            System.out.println("1. Explorar la jungla");
            System.out.println("2. Entrar en la cabaña");
            System.out.println("3. Jugar al Tres en Raya");
            System.out.println("4. Hablar con el Guía");
            System.out.println("5. Salir del juego");
           
            // opción del jugador
            int eleccion = scanner.nextInt();
            scanner.nextLine();  

            // Procesar la opción seleccionada
            switch (eleccion) {
                case 1:
                    explorarJungla();
                    break;
                case 2:
                    entrarCabaña();
                    break;
                case 3:
                    jugarTresEnRaya();
                    break;
                case 4:
                    hablarConGuia();
                    break;
                case 5:
                    salirJuego();
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println("Se ha producido un error inesperado: " + e.getMessage());
            }

        }
    }

    // Método para explorar la jungla
    public void explorarJungla() {
        System.out.println(jungla.getDescripcion());
        System.out.println("\nTe adentras en la jungla. La vegetación es espesa y el sonido de los animales es constante.");
        System.out.println("Puedes escuchar el sonido de un río en la distancia.");
        jugador.reducirSalud(10);
        System.out.println("Pierdes 10 puntos de salud. Salud actual: " + jugador.getSalud());
    }

    // Método para entrar a la cabaña

    public void entrarCabaña() {


        System.out.println(cabaña.getDescripcion());
        System.out.println("\nTe acercas a la cabaña hecha de madera. Dentro huele a tierra y humo.");
        System.out.println("Un fuego arde en el centro, y en las esquinas hay estantes con algunas herramientas.");
        System.out.println("En el suelo ves tres cajas misteriosas... ¿Cuál abrirás?");

        try {
        MinijuegoCajas minijuego = new MinijuegoCajas();
        minijuego.jugar(this.jugador);

        } catch (Exception e) {
            System.out.println("Error al ejecutar el minijuego: " + e.getMessage());
        }
    }


    // Método para jugar al Tres en Raya
    public void jugarTresEnRaya() {
        System.out.println("\nInicias una partida de Tres en Raya.");

        try {
            TresEnRaya juego = new TresEnRaya();
            juego.jugar();

        } catch (Exception e) {
            System.out.println("Error al jugar Tres en Raya: " + e.getMessage());


        }

    }

    // Método para hablar con el Guía
    public void hablarConGuia() {
        System.out.println("\nTe acercas a un hombre sabio sentado junto a un fuego.");
        System.out.println("Él te mira y sonríe.");
        guia.hablar();
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Ir al río en busca de frutas.");
        System.out.println("2. Ignorar el consejo y seguir explorando.");

        try {
        
        int eleccionGuia = scanner.nextInt();
        scanner.nextLine(); 

        switch (eleccionGuia) {
            case 1:
                System.out.println("Decides seguir el consejo del guía y te diriges al río en busca de frutas.");
                System.out.println("Encuentras un árbol frondoso con muchas frutas. ¿Cuántas crees que hay en él? (Entre 1 y 10)");
                MinijuegoFrutas frutas = new MinijuegoFrutas();
                frutas.jugar(this.jugador);
                break;
            case 2:
                System.out.println("Decides ignorar el consejo del guía y sigues explorando por tu cuenta.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.nextLine();
        }


    }

    // Método para salir del juego
    private void salirJuego() {
        System.out.println("¡Gracias por jugar!");
        juegoActivo = false;
    }

    // Método para mostrar el escenario de la playa
    private void mostrarEscenarioPlaya() {
        System.out.println("\nEstás en una playa desierta. La arena es suave y el sonido de las olas te relaja.");
        System.out.println("Ves una jungla espesa a lo lejos y una cabaña de madera cerca de las rocas.");
    }

    
}
