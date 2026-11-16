
import personajes.*;
import juego.GestorJuego;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestorJuego gestor = new GestorJuego();

        int opcion;

        do {

            System.out.println("\n===== ESFOT RPG - JAVA POO =====");
            System.out.println("1. Crear Guerrero");
            System.out.println("2. Crear Mago");
            System.out.println("3. Crear Arquero");
            System.out.println("4. Crear Paladin");
            System.out.println("5. Mostrar personajes");
            System.out.println("6. Buscar personaje por nombre");
            System.out.println("7. Atacar a otro personaje");
            System.out.println("8. Utilizar habilidad especial");
            System.out.println("9. Simular combate por turnos");
            System.out.println("10. Mostrar personajes vivos");
            System.out.println("11. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    crearPersonaje(scanner, gestor, 1);
                    break;

                case 2:
                    crearPersonaje(scanner, gestor, 2);
                    break;

                case 3:
                    crearPersonaje(scanner, gestor, 3);
                    break;

                case 4:
                    crearPersonaje(scanner, gestor, 4);
                    break;

                case 5:
                    gestor.mostrarPersonajes();
                    break;

                case 6:
                    System.out.print("Ingrese el nombre: ");
                    String nombreBuscar = scanner.nextLine();

                    Personaje encontrado = gestor.buscarPersonaje(nombreBuscar);

                    if (encontrado != null) {
                        encontrado.mostrarInformacion();
                    } else {
                        System.out.println("Personaje no encontrado");
                    }
                    break;

                case 7:
                    System.out.print("Nombre del atacante: ");
                    String atacante = scanner.nextLine();

                    System.out.print("Nombre del objetivo: ");
                    String objetivo = scanner.nextLine();

                    gestor.atacarPersonaje(atacante, objetivo);
                    break;

                case 8:
                    System.out.print("Nombre del personaje: ");
                    String nombrePersonaje = scanner.nextLine();

                    Personaje personaje = gestor.buscarPersonaje(nombrePersonaje);

                    if (personaje == null) {
                        System.out.println("Personaje no encontrado");
                        break;
                    }

                    System.out.print("Nombre del objetivo: ");
                    String nombreObjetivo = scanner.nextLine();

                    int habilidad = 0;

                    if (personaje instanceof Paladin) {

                        System.out.println("1. Curar");
                        System.out.println("2. Activar escudo");
                        System.out.print("Seleccione habilidad: ");

                        habilidad = scanner.nextInt();
                        scanner.nextLine();

                    }

                    gestor.utilizarHabilidad(nombrePersonaje,
                            nombreObjetivo, habilidad);
                    break;

                case 9:
                    System.out.print("Nombre del primer personaje: ");
                    String nombre1 = scanner.nextLine();

                    System.out.print("Nombre del segundo personaje: ");
                    String nombre2 = scanner.nextLine();

                    gestor.simularCombate(nombre1, nombre2);
                    break;

                case 10:
                    gestor.mostrarPersonajesVivos();
                    break;

                case 11:
                    System.out.println("Saliendo del juego...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 11);

        scanner.close();


    }
        public static void crearPersonaje(Scanner scanner,
                GestorJuego gestor, int tipo) {

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Nivel: ");
            int nivel = scanner.nextInt();

            System.out.print("Vida: ");
            int vida = scanner.nextInt();

            System.out.print("Vida maxima: ");
            int vidaMaxima = scanner.nextInt();

            System.out.print("Ataque: ");
            int ataque = scanner.nextInt();

            System.out.print("Defensa: ");
            int defensa = scanner.nextInt();

            Personaje nuevo = null;

            switch (tipo) {

                case 1:
                    System.out.print("Fuerza: ");
                    int fuerza = scanner.nextInt();

                    nuevo = new Guerrero(nombre, nivel, vida,
                            vidaMaxima, ataque, defensa, fuerza);
                    break;

                case 2:
                    System.out.print("Mana: ");
                    int mana = scanner.nextInt();

                    nuevo = new Mago(nombre, nivel, vida,
                            vidaMaxima, ataque, defensa, mana);
                    break;

                case 3:
                    System.out.print("Flechas: ");
                    int flechas = scanner.nextInt();

                    nuevo = new Arquero(nombre, nivel, vida,
                            vidaMaxima, ataque, defensa, flechas);
                    break;

                case 4:
                    System.out.print("Fuerza: ");
                    int fuerzaP = scanner.nextInt();

                    System.out.print("Energia sagrada: ");
                    int energia = scanner.nextInt();

                    nuevo = new Paladin(nombre, nivel, vida,
                            vidaMaxima, ataque, defensa, fuerzaP, energia);
                    break;
            }

            scanner.nextLine();

            if (gestor.agregarPersonaje(nuevo)) {
                System.out.println("Personaje creado correctamente");
            } else {
                System.out.println("No se pudo registrar el personaje");
            }
        }
}


