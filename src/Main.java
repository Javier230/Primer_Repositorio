
import java.util.Scanner;

import Geometria.Circulo;
import Geometria.Cuadrado;
import Geometria.Triangulo;
import Geometria.Rectangulo;
import Geometria.FiguraGeometrica;

public class Main {
    public static void main(String[] args) {
        Scanner le = new Scanner (System.in);

        String color;
        int opcion;

        do{
            System.out.println("==============================");
            System.out.println("CALCULADORA GEOMÉTRICA - ESFOT");
            System.out.println("==============================");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Rectángulo");
            System.out.println("4. Triángulo");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.print("Seleccione una opción:");
            opcion = le.nextInt();
            switch(opcion){
                case 1:
                    System.out.print("Ingrese el color:");
                    color = le.nextLine();
                    le.next();
                    System.out.print("Ingrese el radio: ");
                    double radio = le.nextDouble();
                    Circulo c = new Circulo(color, radio);
                    c.imprimirDatos();
                    break;
                case 2:
                    System.out.print("Ingrese el color:");
                    color = le.nextLine();
                    le.next();
                    System.out.print("Ingrese el lado: ");
                    double lado = le.nextDouble();
                    Cuadrado ca = new Cuadrado(color,lado);
                    ca.imprimirDatos();
                    break;

                case 3:
                    System.out.print("Ingrese el color:");
                    color = le.nextLine();
                    le.next();
                    System.out.print("Ingrese la base: ");
                    double bas = le.nextDouble();
                    System.out.print("Ingrese la altura: ");
                    double alt = le.nextDouble();
                    Rectangulo rec = new Rectangulo(color,bas,alt);
                    rec.imprimirDatos();

                    break;
                case 4:
                    System.out.print("Ingrese el color:");
                    color = le.nextLine();
                    le.next();
                    System.out.print("Ingrese el lado1: ");
                    double lado1 = le.nextDouble();
                    System.out.print("Ingrese el lado2: ");
                    double lado2 = le.nextDouble();
                    System.out.print("Ingrese el lado3: ");
                    double lado3 = le.nextDouble();

                    Triangulo tria = new Triangulo(color,lado1, lado2, lado3);
                    tria.imprimirDatos();

                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }

        }while(opcion!=5);

        le.close();






    }
}