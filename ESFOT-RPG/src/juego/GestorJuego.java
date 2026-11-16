package juego;


import personajes.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorJuego {

    private List<Personaje> personajes = new ArrayList<>();
    private Map<String, Personaje> registro = new HashMap<>();

    public boolean agregarPersonaje(Personaje personaje) {

        if (personaje == null) {
            return false;
        }

        String nombre = personaje.getNombre();

        if (nombre == null || nombre.trim().isEmpty()
                || registro.containsKey(nombre)) {
            return false;
        }

        personajes.add(personaje);
        registro.put(nombre, personaje);

        return true;
    }

    public Personaje buscarPersonaje(String nombre) {
        return registro.get(nombre);

    }

    public void mostrarPersonajes() {
        for (Personaje personaje : personajes) {
            personaje.mostrarInformacion();
            System.out.println("-------------------");
        }
    }

    public void mostrarPersonajesVivos() {
        for (Personaje personaje : personajes) {
            if (personaje.estaVivo()) {
                personaje.mostrarInformacion();
                System.out.println("-------------------");
            }
        }
    }

    public void atacarPersonaje(String nombreAtacante, String nombreObjetivo) {

        Personaje atacante = buscarPersonaje(nombreAtacante);
        Personaje objetivo = buscarPersonaje(nombreObjetivo);

        if (atacante == null || objetivo == null) {
            System.out.println("Personaje no encontrado");
            return;
        }

        if (!atacante.estaVivo() || !objetivo.estaVivo()) {
            System.out.println("No se puede atacar");
            return;
        }

        atacante.atacar(objetivo);

        System.out.println("Ataque realizado");
        System.out.println("Vida restante de " + objetivo.getNombre()
                + ": " + objetivo.getVida());
    }

    public void utilizarHabilidad(String nombrePersonaje,
                                  String nombreObjetivo, int opcion) {

        Personaje personaje = buscarPersonaje(nombrePersonaje);
        Personaje objetivo = buscarPersonaje(nombreObjetivo);

        if (personaje == null) {
            System.out.println("Personaje no encontrado");
            return;
        }

        if (!personaje.estaVivo()) {
            System.out.println("El personaje está derrotado");
            return;
        }

        if (personaje instanceof Mago) {

            Mago mago = (Mago) personaje;

            if (objetivo != null && objetivo.estaVivo()
                    && mago.getMana() >= 10) {

                mago.lanzarHechizo(objetivo);
                System.out.println("Hechizo lanzado");

            } else {
                System.out.println("No se puede lanzar el hechizo");
            }

        } else if (personaje instanceof Arquero) {

            Arquero arquero = (Arquero) personaje;

            if (objetivo != null && objetivo.estaVivo()
                    && arquero.getFlechas() > 0) {

                arquero.dispararFlecha(objetivo);
                System.out.println("Flecha disparada");

            } else {
                System.out.println("No hay flechas disponibles o el objetivo no es válido");
            }

        } else if (personaje instanceof Paladin) {

            Paladin paladin = (Paladin) personaje;

            if (opcion == 1) {

                if (objetivo != null && objetivo.estaVivo()
                        && paladin.getEnergiaSagrada() >= 10) {

                    paladin.curar(objetivo);
                    System.out.println("Curación realizada");

                } else {
                    System.out.println("No se puede realizar la curación");
                }

            } else if (opcion == 2) {

                paladin.activarEscudo();
                System.out.println("Escudo activado");

            } else {
                System.out.println("Opción no válida");
            }

        } else {
            System.out.println("Este personaje no tiene habilidades especiales");
        }

    }

    public void simularCombate(String nombre1, String nombre2) {

        Personaje personaje1 = buscarPersonaje(nombre1);
        Personaje personaje2 = buscarPersonaje(nombre2);

        if (personaje1 == null || personaje2 == null) {
            System.out.println("Personaje no encontrado");
            return;
        }

        if (personaje1 == personaje2) {
            System.out.println("No pueden combatir contra sí mismos");
            return;
        }

        if (!personaje1.estaVivo() || !personaje2.estaVivo()) {
            System.out.println("No pueden combatir personajes derrotados");
            return;
        }

        Personaje atacante = personaje1;
        Personaje objetivo = personaje2;

        int turno = 1;

        while (personaje1.estaVivo() && personaje2.estaVivo()) {

            System.out.println("Turno " + turno);
            System.out.println(atacante.getNombre() + " ataca a "
                    + objetivo.getNombre());

            int vidaAnterior = objetivo.getVida();

            atacante.atacar(objetivo);

            int danio = vidaAnterior - objetivo.getVida();

            System.out.println("Daño efectivo: " + danio);
            System.out.println("Vida restante de " + objetivo.getNombre()
                    + ": " + objetivo.getVida());

            if (!objetivo.estaVivo()) {
                break;
            }

            Personaje temporal = atacante;
            atacante = objetivo;
            objetivo = temporal;

            turno++;
        }

        System.out.println("GANADOR: " + atacante.getNombre());
    }

}
