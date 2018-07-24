import java.util.Random;
public class Arma {
    private boolean presente;
    private String nombre;
    private float dano_disparo;
    Arma(String nombre){
        this.presente = false;
        this.nombre = nombre;
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
    public float getDano_disparo() {
        return dano_disparo;
    }
    public void setDano_disparo(float dano_disparo) {
        this.dano_disparo = dano_disparo;
    }
}