public class Brazos {
    //Atributos de los brazos, que reflejan si está presente en el robot en el modo y el arma que posee.
    private boolean presente;
    private Arma arma_canon;
    Brazos(){
        arma_canon = new Arma();
    }
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public Arma getArma_canon() {
        return arma_canon;
    }
}
