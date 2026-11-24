
import Clases.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Envio> enTransito = new HashMap<>();
        ArrayList<Envio> entregados = new ArrayList<>();
        int contador = 1001;
        int opcion;

        do {
            System.out.println("\n=== SERVIENTREGA - SISTEMA DE ENVIOS ===");
            System.out.println("1. Registrar envío");
            System.out.println("2. Consultar envío");
            System.out.println("3. Entregar envío");
            System.out.println("4. Listar entregados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: {
                    System.out.print("Tipo de servicio (1: Nacional, 2: Express, 3: Internacional): ");
                    int tipo = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre del destinatario: ");
                    String destinatario = sc.nextLine();

                    System.out.print("Ciudad de destino: ");
                    String ciudad = sc.nextLine();

                    System.out.print("Peso en kilos: ");
                    double peso = Double.parseDouble(sc.nextLine());

                    if (peso <= 0) {
                        System.out.println("El peso debe ser mayor que cero. No se registró el envío.");
                        break;
                    }

                    if (tipo == 1) {
                        System.out.print("¿Entrega a domicilio? (S/N): ");
                        String domStr = sc.nextLine();
                        boolean aDomicilio = domStr.equalsIgnoreCase("S");

                        String guia = "NAC" + String.valueOf(contador);
                        EnvioNacional envio = new EnvioNacional(guia, destinatario, ciudad, peso, aDomicilio);

                        enTransito.put(guia, envio);
                        contador++;
                        System.out.println("Registrado con guía " + guia + " | Costo: $" + envio.calcularCosto());

                    } else if (tipo == 2) {
                        System.out.print("¿Entrega a domicilio? (S/N): ");
                        String domStr = sc.nextLine();
                        boolean aDomicilio = domStr.equalsIgnoreCase("S");

                        System.out.print("¿Entrega en 24 horas? (S/N): ");
                        String h24Str = sc.nextLine();

                        String guia = "EXP" + String.valueOf(contador);
                        EnvioExpress envio;
                        if (h24Str.equalsIgnoreCase("S")) {
                            envio = new EnvioExpress(guia, destinatario, ciudad, peso, aDomicilio, 24);
                        } else {
                            envio = new EnvioExpress(guia, destinatario, ciudad, peso, aDomicilio);
                        }

                        enTransito.put(guia, envio);
                        contador++;
                        System.out.println("Registrado con guía " + guia + " | Costo: $" + envio.calcularCosto());

                    } else if (tipo == 3) {
                        System.out.print("Valor de la compra en USD: ");
                        double valorFob = Double.parseDouble(sc.nextLine());

                        String guiaTemp = "INT" + String.valueOf(contador);
                        EnvioInternacional envio = new EnvioInternacional(guiaTemp, destinatario, ciudad, peso, valorFob);

                        if (!envio.cumple4x4()) {
                            System.out.println("Envío rechazado por no cumplir la regla 4x4 (máx. 4 kg y $400).");
                            break;
                        }

                        enTransito.put(guiaTemp, envio);
                        contador++;
                        System.out.println("Registrado con guía " + guiaTemp + " | Costo: $" + envio.calcularCosto());

                    } else {
                        System.out.println("Tipo de servicio inválido.");
                    }
                    break;
                }

                case 2: {
                    System.out.print("Ingrese el número de guía: ");
                    String guia = sc.nextLine();

                    if (!enTransito.containsKey(guia)) {
                        System.out.println("No existe un envío en tránsito con la guía " + guia);
                    } else {
                        Envio envio = enTransito.get(guia);
                        System.out.println(envio.describir() + " | Costo: $" + envio.calcularCosto());
                    }
                    break;
                }

                case 3: {
                    System.out.print("Ingrese el número de guía a entregar: ");
                    String guia = sc.nextLine();

                    if (!enTransito.containsKey(guia)) {
                        System.out.println("No existe un envío en tránsito con la guía " + guia);
                    } else {
                        Envio envio = enTransito.remove(guia);
                        entregados.add(envio);
                        System.out.println("Envío " + guia + " marcado como entregado.");
                    }
                    break;
                }

                case 4: {
                    if (entregados.isEmpty()) {
                        System.out.println("Todavía no hay envíos entregados.");
                    } else {
                        double totalRecaudado = 0.0;
                        System.out.println("=== ENVÍOS ENTREGADOS ===");
                        for (Envio e : entregados) {
                            double costo = e.calcularCosto();
                            totalRecaudado += costo;
                            System.out.println(e.describir() + " | Costo: $" + costo);
                        }
                        System.out.println("Total recaudado: $" + totalRecaudado);
                    }
                    break;
                }

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }
}

