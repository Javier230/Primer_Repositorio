package personajes;

public class Personaje {
    private String nombre;
    private int nivel;
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int defensa;

    public Personaje(){
    }

    public Personaje(String nombre, int nivel,int vida,
                     int vidaMaxima,int ataque, int defensa){
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public int getNivel() {

        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel > 0){
            this.nivel = nivel;
        }
    }

    public int getVida() {

        return vida;
    }

    public void setVida(int vida) {
        if (vida >=0 && vida <= vidaMaxima) {
            this.vida = vida;
        }
    }

    public int getVidaMaxima() {

        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        if (vidaMaxima > 0 && vida <= vidaMaxima) {
            this.vidaMaxima = vidaMaxima;
        }
    }

    public int getAtaque() {

        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque >= 0) {
            this.ataque = ataque;
        }
    }

    public int getDefensa() {

        return defensa;
    }

    public void setDefensa(int defensa) {
        if (defensa >= 0) {
            this.defensa = defensa;
        }
    }

    public boolean estaVivo(){
        if (vida > 0){
            return true;
        }else {
            return false;
        }
    }

    public void recibirDanio(int cantidad){
        int danioReal = Math.max(1, cantidad - defensa);
        vida = Math.max(0, vida - danioReal);
    }

    public void atacar(Personaje enemigo){
        if (enemigo != null && enemigo.estaVivo()){
            enemigo.recibirDanio(ataque);
        }
    }

    public void atacar(Personaje enemigo, int bonificacion){
        if (enemigo != null && enemigo.estaVivo() && bonificacion >=0){
            enemigo.recibirDanio(ataque + bonificacion);
        }
    }

    public void mostrarInformacion(){
        System.out.println("Nombre: "+ nombre);
        System.out.println("Nivel: "+ nivel);
        System.out.println("Vida: "+ vida);
        System.out.println("Vida Máxima: "+ vidaMaxima);
        System.out.println("Ataque: "+ ataque);
        System.out.println("Defensa: "+ defensa);
    }




}
