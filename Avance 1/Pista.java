import java.util.Scanner;
public class Pista {
    Scanner lector = new Scanner(System.in);
    //Atributos de la pista
    private int largo_pista;
    public int largo() {
        System.out.println("Ingrese el largo de la pista para despegar");
        largo_pista = lector.nextInt();
        while (largo_pista <100) {
            System.out.println("El largo de la pista tiene que ser minimo de 100 metros. Vuelva a ingresar");
            largo_pista = lector.nextInt();
        }
        return largo_pista;
    }
    //Getters y Settters de atributos.
    public int getLargo_pista() {
        return largo_pista;
    }
    public void setLargo_pista(int largo_pista) {
        this.largo_pista = largo_pista;
    }
}
