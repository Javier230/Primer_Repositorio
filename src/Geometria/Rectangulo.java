package Geometria;

public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(String color, double base, double altura){
        super(color);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {

        return base;
    }

    public void setBase(double base) {

        this.base = base;
    }

    public double getAltura() {

        return altura;
    }

    public void setAltura(double altura) {

        this.altura = altura;
    }

    @Override
    public double calcularArea(){

        return base * altura;
    }

    @Override
    public double calcularPerimetro(){

        return 2 * (base + altura);
    }
    @Override
    public void imprimirDatos(){
        System.out.println("== Figura Rectangulo  ==");
        System.out.println("Color: " + getColor());
        System.out.printf("Area: %.2f%n",calcularArea());
        System.out.printf("Perimetro: %.2f%n",calcularPerimetro());
    }
}


