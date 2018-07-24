public class Arma {
    private boolean presente;
    private String nombre;
    Arma(){
        presente = false;
    }
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
    public void disparo(){
        System.out.println("Dispara " + getNombre());
    }
}