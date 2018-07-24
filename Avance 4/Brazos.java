public class Brazos {
    private boolean presente;
    private Arma arma_canon;
    private int indicador_resistencia;
    Brazos(String nombre_ingresado){
        arma_canon = new Arma(nombre_ingresado);
        indicador_resistencia = 30;
    }
    //Getters & Setters de los atributos
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public Arma getArma_canon() {
        return arma_canon;
    }
    public int getIndicador_resistencia() {
        return indicador_resistencia;
    }
    public void setIndicador_resistencia(int indicador_resistencia) {
        this.indicador_resistencia = indicador_resistencia;
    }
}
