import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Escenario {
    Scanner lector = new Scanner(System.in);
    Random aleatorio = new Random(System.currentTimeMillis());
    private int eje_x;
    private int eje_y;
    private ArrayList<Pista> pistas;
    private String[][] matriz_escenario;
    Escenario(int eje_x, int eje_y){
        this.pistas = new ArrayList<>();
        this.eje_x = eje_x;
        this.eje_y = eje_y;
        this.matriz_escenario = new String[(eje_x+50)/50][(eje_y+50)/50];
    }
    public int getEje_x() {
        return eje_x;
    }
    public int getEje_y() {
        return eje_y;
    }
    public ArrayList<Pista> getPistas() {
        return pistas;
    }
    public String[][] getMatriz_escenario() {
        return matriz_escenario;
    }
    //Funcion encargada de crear pistas con posiciones y orientaciones aleatorias, además de introducir dicha información en una matriz.
    public void crear_pistas_random_y_matriz_de_escenario(){
        int cantidad_pistas;
        boolean pista_encontrada = false;
        Random random = new Random();
        System.out.print("Ingrese la cantidad de pistas deseadas (No debe superar las 10 unidades)\n");
        cantidad_pistas = lector.nextInt();
        while(cantidad_pistas > 10){
            System.out.print("Intente nuevamente\n");
            cantidad_pistas = lector.nextInt();
        }
        for(int i = 0; i < cantidad_pistas; i++){
            getPistas().add(new Pista(String.valueOf(i), Math.abs(aleatorio.nextInt() % 40) * 50,
                    Math.abs(aleatorio.nextInt() % 40) * 50,
                    (Math.abs(aleatorio.nextInt() % 6) + 1) * 50,
                    Math.abs(aleatorio.nextInt() % 2) + 1));
            while (getPistas().get(i).getOrientacion() == 1 && getPistas().get(i).getLargo_pista() + getPistas().get(i).getPosicion_x() > getEje_x()){
                getPistas().get(i).setLargo_pista((Math.abs(aleatorio.nextInt() % (getEje_x()-getPistas().get(i).getPosicion_x())/50) + 1) * 50);
            }
            while (getPistas().get(i).getOrientacion() == 2 && getPistas().get(i).getLargo_pista() + getPistas().get(i).getPosicion_y() > getEje_y()){
                getPistas().get(i).setLargo_pista((Math.abs(aleatorio.nextInt() % (getEje_y()-getPistas().get(i).getPosicion_y())/50) + 1) * 50);
            }
        }
        for(int i = 0; i <= getEje_y(); i = i+50){
            for(int j = 0; j <= getEje_x(); j = j+50) {
                for (int k = 0; k < getPistas().size(); k++) {
                    if (getPistas().get(k).getOrientacion() == 1) {
                        if (j >= getPistas().get(k).getPosicion_x() &&
                                j < getPistas().get(k).getPosicion_x() +
                                        getPistas().get(k).getLargo_pista() &&
                                getPistas().get(k).getPosicion_y() == i) {
                            pista_encontrada = true;
                            getMatriz_escenario()[i/50][j/50] = getPistas().get(k).getNumero_pista();
                        }
                    }
                    if (getPistas().get(k).getOrientacion() == 2) {
                        if (i >= getPistas().get(k).getPosicion_y() &&
                                i < getPistas().get(k).getPosicion_y() +
                                        getPistas().get(k).getLargo_pista() &&
                                getPistas().get(k).getPosicion_x() == j) {
                            pista_encontrada = true;
                            getMatriz_escenario()[i/50][j/50] = getPistas().get(k).getNumero_pista();
                        }
                    }
                }
                if (!pista_encontrada) {
                    getMatriz_escenario()[i/50][j/50] = "-";
                }
                if (pista_encontrada) {
                    pista_encontrada = false;
                }
            }
        }
    }
    //Función encargada de imprimir las posiciones y espacios ocupados por las pistas
    public void consultar_pistas(){
        for(int j=0; j < getPistas().size(); j++){
            System.out.print("Pista " + getPistas().get(j).getNumero_pista());
            if(getPistas().get(j).getOrientacion() == 1){
                System.out.println(" (" + getPistas().get(j).getPosicion_x() +" - " + (getPistas().get(j).getPosicion_x() + getPistas().get(j).getLargo_pista()) + " ," + getPistas().get(j).getPosicion_y()+ ")");
            }
            if(getPistas().get(j).getOrientacion() == 2){
                System.out.println(" (" + getPistas().get(j).getPosicion_x() + " ," + getPistas().get(j).getPosicion_y() +" - " + (getPistas().get(j).getPosicion_y() + getPistas().get(j).getLargo_pista()) + ")");
            }
        }
    }
    //Función encargada de imprimir la matriz gráfica del escenario
    public void mostrar_escenario(){
        for(int i = 0; i <= 40; i++){
            for(int j = 0; j <= 40; j++){
                System.out.print(getMatriz_escenario()[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}