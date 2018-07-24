public class Alas extends Parte_robot{
    private Arma arma_laser;
    Alas(String nombre_arma, int indicador_resistencia) {
        super(false, indicador_resistencia);
        this.arma_laser = new Arma(nombre_arma);
    }
    //Getters & Setters de los atributos
    public Arma getArma_laser() {
        return arma_laser;
    }
}
