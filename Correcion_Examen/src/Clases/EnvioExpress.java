package Clases;

public class EnvioExpress extends EnvioNacional {

    private int horasEntrega;

    public EnvioExpress(String guia, String destinatario, String ciudadDestino,
                        double pesoKg, boolean entregaDomicilio, int horasEntrega) {
        super(guia, destinatario, ciudadDestino, pesoKg, entregaDomicilio);
        this.horasEntrega = horasEntrega;
    }

    public EnvioExpress(String guia, String destinatario, String ciudadDestino,
                        double pesoKg, boolean entregaDomicilio) {
        this(guia, destinatario, ciudadDestino, pesoKg, entregaDomicilio, 48);
    }

    public int getHorasEntrega() {
        return horasEntrega;
    }

    public void setHorasEntrega(int horasEntrega) {
        this.horasEntrega = horasEntrega;
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() * 1.40;
    }

    @Override
    public String describir() {
        return super.describir() + " | Plazo: " + horasEntrega + " horas";
    }
}
