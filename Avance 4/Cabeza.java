public class Cabeza {
    private boolean presente;
    private int indicador_resistencia;
    Cabeza(){
        indicador_resistencia = 30;
    }
    //Getters y Setters de atributos de la cabeza.
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public int getIndicador_resistencia() {
        return indicador_resistencia;
    }
    public void setIndicador_resistencia(int indicador_resistencia) {
        this.indicador_resistencia = indicador_resistencia;
    }
}
