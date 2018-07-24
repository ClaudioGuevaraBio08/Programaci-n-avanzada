public class Piernas extends Parte_robot{
    private boolean avanzada;
    Piernas(int indicador_resistencia) {
        super(false, indicador_resistencia);
        this.avanzada = false;
    }
    //Getters y Setters de los atributos
    public boolean isAvanzada() {
        return avanzada;
    }
    public void setAvanzada(boolean avanzada) {
        this.avanzada = avanzada;
    }
}