import java.util.Random;
public class Arma {
    private boolean presente;
    private String nombre;
    private int dano_disparo;
    Random aleatorio;
    Arma(String nombre_ingresado){
        presente = false;
        nombre = nombre_ingresado;
        aleatorio = new Random(System.currentTimeMillis());
        dano_disparo = 0;
    }
    //Getters & Setters de los atributos
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDano_disparo() {
        return dano_disparo;
    }
    public void setDano_disparo(int dano_disparo) {
        this.dano_disparo = dano_disparo;
    }
    //Funcion que dispara e imprime qué arma es la que lo efectua
    public void disparo(){
        System.out.println("Dispara " + getNombre());
        setDano_disparo(Math.abs(aleatorio.nextInt() % 10) + 1);
        System.out.println("Daño efectuado : " + getDano_disparo());
    }
}