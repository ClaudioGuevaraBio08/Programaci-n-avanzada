public class Fuselaje {
    //Atributos de Fuselaje, que refleja la presencia de este en el robot y las 2 armas de este.
    private boolean presente;
    private Arma arma_canon;
    private Arma arma_laser;
    Fuselaje(){
        presente = true;
        arma_canon = new Arma();
        arma_laser = new Arma();
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
}
