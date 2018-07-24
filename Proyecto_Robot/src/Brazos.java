public class Brazos extends Parte_robot{
    private Arma arma_canon;
    Brazos(String nombre_arma, int indicador_resistencia){
        super(false, indicador_resistencia);
        this.arma_canon = new Arma(nombre_arma);
    }
    //Getters & Setters de los atributos
    public Arma getArma_canon() {
        return arma_canon;
    }
}