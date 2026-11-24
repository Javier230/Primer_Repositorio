package Clases;

public class Envio {

    private String guia;
    private String destinatario;
    private String ciudadDestino;
    private double pesoKg;

    public Envio(String guia, String destinatario, String ciudadDestino, double pesoKg) {
        this.guia = guia;
        this.destinatario = destinatario;
        this.ciudadDestino = ciudadDestino;
        this.pesoKg = pesoKg;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        }
    }

    public int kilosFacturables() {
        int parteEntera = (int) pesoKg;
        if (pesoKg > parteEntera) {
            return parteEntera + 1;
        }
        return parteEntera;
    }

    public double calcularCosto() {
        return 2.0 * kilosFacturables();
    }

    public String describir() {
        return "Guía: " + guia
                + " | Destinatario: " + destinatario
                + " | Ciudad: " + ciudadDestino
                + " | Peso: " + pesoKg + " kg (" + kilosFacturables() + " kg facturables)";
    }
}