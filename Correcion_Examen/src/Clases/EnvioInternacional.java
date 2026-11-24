package Clases;

public class EnvioInternacional extends Envio {

    private double valorFobUsd;

    public EnvioInternacional(String guia, String destinatario, String ciudadDestino,
                              double pesoKg, double valorFobUsd) {
        super(guia, destinatario, ciudadDestino, pesoKg);
        this.valorFobUsd = valorFobUsd;
    }

    public double getValorFobUsd() {
        return valorFobUsd;
    }

    public void setValorFobUsd(double valorFobUsd) {
        this.valorFobUsd = valorFobUsd;
    }

    public boolean cumple4x4() {
        return getPesoKg() <= 4.0 && valorFobUsd <= 400.0;
    }

    @Override
    public double calcularCosto() {
        return (6.0 * kilosFacturables()) + 20.0;
    }

    @Override
    public String describir() {
        return super.describir() + " | Valor compra: $" + valorFobUsd;
    }
}
