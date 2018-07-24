import java.util.Scanner;
public class Pista {
    Scanner lector = new Scanner(System.in);
    //Atributos de la pista
    private int posicion_x;
    private int posicion_y;
    private int largo_pista;
    private int orientacion;
    //Getters y Settters de atributos.
    public int getLargo_pista() {
        return largo_pista;
    }
    public void setLargo_pista(int largo_pista) {
        this.largo_pista = largo_pista;
    }
    public int getPosicion_y() {
        return posicion_y;
    }
    public void setPosicion_y(int posicion_y) {
        this.posicion_y = posicion_y;
    }
    public int getPosicion_x() {
        return posicion_x;
    }
    public void setPosicion_x(int posicion_x) {
        this.posicion_x = posicion_x;
    }
    public int getOrientacion() {
        return orientacion;
    }
    public void setOrientacion(int orientacion) {
        this.orientacion = orientacion;
    }
}

