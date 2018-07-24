public class Piernas {
    private boolean presente;
    private boolean avanzada;
    private int indicador_resistencia;
    Piernas() {
        presente = false;
        avanzada = false;
        indicador_resistencia = 30;
    }
    //Getters y Setters de los atributos
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public boolean isAvanzada() {
        return avanzada;
    }
    public void setAvanzada(boolean avanzada) {
        this.avanzada = avanzada;
    }
    public int getIndicador_resistencia() {
        return indicador_resistencia;
    }
    public void setIndicador_resistencia(int indicador_resistencia) {
        this.indicador_resistencia = indicador_resistencia;
    }
}