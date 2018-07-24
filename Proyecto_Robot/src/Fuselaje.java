public class Fuselaje extends Parte_robot{
    //Atributos de Fuselaje, que refleja la presencia de este en el robot y las 2 armas de este.
    private Arma arma_canon;
    private Arma arma_laser;
    Fuselaje(String nombre_arma_1, String nombre_arma_2, int indicador_resistencia){
        super(false, indicador_resistencia);
        this.arma_canon = new Arma(nombre_arma_1);
        this.arma_laser = new Arma(nombre_arma_2);
    }
    //Getters y setter de los atributos y las armas
    public Arma getArma_canon() {
        return arma_canon;
    }
    public Arma getArma_laser() {
        return arma_laser;
    }
}