package AventuraConversacional;

public class Jugador {
    
    private String nombre;
    private int salud;

    public Jugador(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void reducirSalud(int cantidad) {
        salud -= cantidad;
        if (salud <= 0) {
            System.out.println("Has perdido toda tu salud.");
        }
    }

    public void aumentarSalud(int cantidad) {
        salud += cantidad;
    }
}
