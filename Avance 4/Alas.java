public class Alas {
    private boolean presente;
    private Arma arma_laser;
    private int indicador_resistencia;
    Alas(String nombre_ingresado) {
        arma_laser = new Arma(nombre_ingresado);
        indicador_resistencia = 30;
    }
    //Getters & Setters de los atributos
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public Arma getArma_laser() {
        return arma_laser;
    }
    public int getIndicador_resistencia() {
        return indicador_resistencia;
    }
    public void setIndicador_resistencia(int indicador_resistencia) {
        this.indicador_resistencia = indicador_resistencia;
    }
}