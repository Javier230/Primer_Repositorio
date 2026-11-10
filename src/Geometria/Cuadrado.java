package Geometria;

public class Cuadrado extends FiguraGeometrica {
    private double lado;

    public Cuadrado(String color, double lado) {
        super(color);
        this.lado = lado;
    }

    public double getLado() {

        return lado;
    }

    public void setLado(double lado) {

        this.lado = lado;
    }

    @Override
    public double calcularArea(){

        return Math.pow(lado, 2);
    }

    @Override
    public double calcularPerimetro(){

        return 4 * lado;
    }
    @Override
    public void imprimirDatos(){
        System.out.println("== Figura Cuadrado ==");
        System.out.println("Color: " + color);
        System.out.printf("Area: %.2f%n",calcularArea());
        System.out.printf("Perimetro: %.2f%n",calcularPerimetro());
    }
}


