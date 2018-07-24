public class Alas {
    private boolean presente;
    private Arma arma_laser;
    Alas() {
        arma_laser = new Arma();
    }
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public Arma getArma_laser() {
        return arma_laser;
    }
}
