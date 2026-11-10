package Geometria;

public class Triangulo extends FiguraGeometrica {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(String color, double lado1, double lado2, double lado3) {
        super(color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1() {

        return lado1;
    }

    public void setLado1(double lado1) {
        if (lado1 >= 0){
            System.out.println("Valor incorrecto.");
        }else{
            this.lado1 = lado1;
        }
    }

    public double getLado2() {

        return lado2;
    }

    public void setLado2(double lado2) {
        if (lado2 >=0){
            System.out.println("Valor incorrecto.");
        }else{
            this.lado2 = lado2;
        }

    }

    public double getLado3() {

        return lado3;
    }

    public void setLado3(double lado3) {
        if (lado3 >=0){
            System.out.println("Valor incorrecto.");
        }else{
            this.lado3 = lado3;
        }
    }


    @Override
    public double calcularArea(){
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }

    @Override
    public double calcularPerimetro(){
        return lado1 + lado2 + lado3;
    }

    @Override
    public void imprimirDatos(){
        System.out.println("== Figura Triangulo ==");
        System.out.println("Color: " + getColor());
        System.out.printf("Area: %.2f%n",calcularArea());
        System.out.printf("Perimetro: %.2f%n",calcularPerimetro());
    }
}

