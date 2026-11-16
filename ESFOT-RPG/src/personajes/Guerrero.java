package personajes;

public class Guerrero extends Personaje{

    private int fuerza;

    public Guerrero(String nombre, int nivel, int vida,
                    int vidaMaxima, int ataque, int defensa, int fuerza) {
        super(nombre, nivel, vida, vidaMaxima, ataque, defensa);
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        if (fuerza >= 0) {
            this.fuerza = fuerza;
        }
    }

    @Override
    public void atacar(Personaje enemigo){
        if (enemigo != null && enemigo.estaVivo()){
            enemigo.recibirDanio(getAtaque() + fuerza);
        }
    }

    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Fuerza: "+fuerza);
    }







}
