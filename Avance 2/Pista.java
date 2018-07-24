import java.util.Scanner;
public class Pista {
    Scanner lector = new Scanner(System.in);
    //Atributos de la pista
    private int posición_x;
    private int posicion_y;
    private int largo_pista;
    private int orientación;
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
    public int getPosición_x() {
        return posición_x;
    }
    public void setPosición_x(int posición_x) {
        this.posición_x = posición_x;
    }
    public int getOrientación() {
        return orientación;
    }
    public void setOrientación(int orientación) {
        this.orientación = orientación;
    }
}

