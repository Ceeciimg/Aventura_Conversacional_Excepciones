package AventuraConversacional;

public class NPC {
    private String nombre;
    private String mensaje;

    public NPC(String nombre, String mensaje) {
        this.nombre = nombre;
        this.mensaje = mensaje;
    }

    public void hablar() {
        System.out.println(nombre + " dice: " + mensaje);
    }
}
