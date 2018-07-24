public class Fuselaje {
    //Atributos de Fuselaje, que refleja la presencia de este en el robot y las 2 armas de este.
    private boolean presente;
    private Arma arma_canon;
    private Arma arma_laser;
    private int indicador_resistencia;
    Fuselaje(String nombre_ingresado_1, String nombre_ingresado_2){
        presente = true;
        arma_canon = new Arma(nombre_ingresado_1);
        arma_laser = new Arma(nombre_ingresado_2);
        indicador_resistencia = 50;
    }
    //Getters y setter de los atributos y las armas
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public Arma getArma_canon() {
        return arma_canon;
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
