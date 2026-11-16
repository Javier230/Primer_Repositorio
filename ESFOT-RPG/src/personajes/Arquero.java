package personajes;

public class Arquero extends Personaje{

    private int flechas;

    public Arquero(String nombre, int nivel, int vida,
                    int vidaMaxima, int ataque, int defensa, int flechas) {
        super(nombre, nivel, vida, vidaMaxima, ataque, defensa);
        this.flechas = flechas;
    }

    public int getFlechas() {

        return flechas;
    }

    public void setFlechas(int flechas) {
        if (flechas >= 0) {
            this.flechas = flechas;
        }
    }

    public void dispararFlecha(Personaje enemigo){
        if (enemigo != null && enemigo.estaVivo() && flechas > 0){
            flechas--;
            enemigo.recibirDanio(getAtaque() + 5);

        }
    }

    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Flechas: "+ flechas);
    }
}
