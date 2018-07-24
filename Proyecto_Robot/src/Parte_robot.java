public class Parte_robot {
    private boolean presente;
    private float indicador_resistencia;
    Parte_robot(boolean presente, float indicador_resistencia){
        this.presente = presente;
        this.indicador_resistencia = indicador_resistencia;
    }
    //Getters y Setters de atributos.
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public float getIndicador_resistencia() {
        return indicador_resistencia;
    }
    public void setIndicador_resistencia(float indicador_resistencia) {
        this.indicador_resistencia = indicador_resistencia;
    }
}