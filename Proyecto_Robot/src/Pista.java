import java.util.Scanner;
public class Pista {
    Scanner lector = new Scanner(System.in);
    //Atributos de la pista
    private String numero_pista;
    private int posicion_x;
    private int posicion_y;
    private int largo_pista;
    private int orientacion;
    Pista(String numero_pista, int posicion_x, int posicion_y, int largo_pista, int orientacion){
        this.numero_pista = numero_pista;
        this.posicion_x = posicion_x;
        this.posicion_y = posicion_y;
        this.largo_pista = largo_pista;
        this.orientacion = orientacion;
    }
    //Getters y Settters de atributos.
    public String getNumero_pista() {
        return numero_pista;
    }
    public int getLargo_pista() {
        return largo_pista;
    }
    public void setLargo_pista(int largo_pista) {
        this.largo_pista = largo_pista;
    }
    public int getPosicion_y() {
        return posicion_y;
    }
    public int getPosicion_x() {
        return posicion_x;
    }
    public int getOrientacion() {
        return orientacion;
    }
}