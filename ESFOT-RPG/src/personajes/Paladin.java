package personajes;

public class Paladin extends Guerrero{

    private int energiaSagrada;
    private boolean escudoActivo;

    public Paladin(String nombre, int nivel, int vida,
                int vidaMaxima, int ataque, int defensa,int fuerza, int energiaSagrada){
        super(nombre,nivel, vida,vidaMaxima, ataque, defensa, fuerza);
        this.energiaSagrada = energiaSagrada;
        this.escudoActivo = false;
    }

    public int getEnergiaSagrada() {
        return energiaSagrada;
    }

    public void setEnergiaSagrada(int energiaSagrada) {
        if (energiaSagrada >= 0) {
            this.energiaSagrada = energiaSagrada;
        }
    }

    public void curar(Personaje objetivo) {
        if (objetivo != null && objetivo.estaVivo()
                && energiaSagrada >= 10
                && objetivo.getVida() < objetivo.getVidaMaxima()) {

            int curacion = Math.min(20,
                    objetivo.getVidaMaxima() - objetivo.getVida());

            objetivo.setVida(objetivo.getVida() + curacion);
            energiaSagrada -= 10;
        }
    }

    public void activarEscudo() {
        escudoActivo = true;
    }

    @Override
    public void recibirDanio(int cantidad) {
        if (escudoActivo) {
            cantidad = Math.max(0, cantidad - 5);
            escudoActivo = false;
        }

        super.recibirDanio(cantidad);
    }

    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Energía Sagrada: " + energiaSagrada);
    }

}
