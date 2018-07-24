public class Arma {
    private boolean presente;
    Arma(){
        presente = false;
    }
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    public void disparo(){
        System.out.println("Dispara");
    }
}

