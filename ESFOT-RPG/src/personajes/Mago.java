package personajes;

public class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int nivel, int vida,
                     int vidaMaxima, int ataque, int defensa, int mana){
        super(nombre,nivel, vida,vidaMaxima, ataque, defensa);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana >= 0) {
            this.mana = mana;
        }
    }


    public void lanzarHechizo(Personaje enemigo){
        if (enemigo != null && enemigo.estaVivo() && mana >=10){
            mana = mana - 10;
            enemigo.recibirDanio(20);
        }

    }


    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Maná: "+mana);
    }




}
