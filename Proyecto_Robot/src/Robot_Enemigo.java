import java.util.Random;
public class Robot_Enemigo {
    private Arma canon_1;
    private Arma canon_2;
    private int posicion_eje_x;
    private int posicion_eje_y;
    private int posicion_eje_z;
    private float indicador_resistencia;
    Random aleatorio;
    Robot_Enemigo(){
        aleatorio = new Random(System.currentTimeMillis());
        this.canon_1 = new Arma("Cañón 1 Zentraedi");
        this.canon_2 = new Arma("Cañón 2 Zentraedi");
        this.indicador_resistencia = 20;
    }
    //Getters y Setters de los atributos
    public Arma getCanon_1() {
        return canon_1;
    }
    public Arma getCanon_2() {
        return canon_2;
    }
    public int getPosicion_eje_x() {
        return posicion_eje_x;
    }
    public void setPosicion_eje_x(int posicion_eje_x) {
        this.posicion_eje_x = posicion_eje_x;
    }
    public int getPosicion_eje_y() {
        return posicion_eje_y;
    }
    public void setPosicion_eje_y(int posicion_eje_y) {
        this.posicion_eje_y = posicion_eje_y;
    }
    public int getPosicion_eje_z() {
        return posicion_eje_z;
    }
    public void setPosicion_eje_z(int posicion_eje_z) {
        this.posicion_eje_z = posicion_eje_z;
    }
    public float getIndicador_resistencia() {
        return indicador_resistencia;
    }
    public void setIndicador_resistencia(float indicador_resistencia) {
        this.indicador_resistencia = indicador_resistencia;
    }
}