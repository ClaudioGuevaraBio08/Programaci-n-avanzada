import java.util.ArrayList;
import java.util.Scanner;
public class Escenario {
    Scanner lector = new Scanner(System.in);
    private int eje_x;
    private int eje_y;
    private int eje_z;
    private ArrayList<Pista> pistas;
    Escenario(){
        pistas = new ArrayList<Pista>();
    }
    public int getEje_x() {
        return eje_x;
    }
    public void setEje_x(int eje_x) {
        this.eje_x = eje_x;
    }
    public int getEje_y() {
        return eje_y;
    }
    public void setEje_y(int eje_y) {
        this.eje_y = eje_y;
    }
    public int getEje_z() {
        return eje_z;
    }
    public void setEje_z(int eje_z) {
        this.eje_z = eje_z;
    }
    public ArrayList<Pista> getPistas() {
        return pistas;
    }

    public void crear_escenario(){
        int medidas;
        System.out.println("Ingrese el eje x de su escenario (múltiplos de 50, debe ser mayor a 800)");
        medidas = lector.nextInt();
        while(medidas%50 != 0 || (medidas <800)){
            System.out.println("Intente nuevamente");
            medidas = lector.nextInt();
        }
        setEje_x(medidas);
        System.out.println("Ingrese el eje y de su escenario (múltiplos de 50, debe ser mayor a 800)");
        medidas = lector.nextInt();
        while(medidas%50 != 0 || (medidas < 800)){
            System.out.println("Intente nuevamente");
            medidas = lector.nextInt();
        }
        setEje_y(medidas);
        System.out.println("Ingrese el eje z de su escenario (múltiplos de 50, debe ser mayor a 800)");
        medidas = lector.nextInt();
        while(medidas%50 != 0 || (medidas < 800)){
            System.out.println("Intente nuevamente");
            medidas = lector.nextInt();
        }
        setEje_z(medidas);
        System.out.println(getEje_x() + ", " + getEje_y() + ", " + getEje_z());
    }
    public void crear_pistas(){
        int cantidad_pistas;
        int x;
        int y;
        int largo_pista;
        int respuesta;
        System.out.println("Ingrese la cantidad de pistas deseadas");
        cantidad_pistas = lector.nextInt();
        for(int i=0; i<cantidad_pistas; i++){
            getPistas().add(new Pista());
        }
        for(int i=0; i<cantidad_pistas; i++){
            System.out.println("Pista "+ (i+1));
            //Ingresar posición x.
            System.out.println("Ingrese Posición x (múltiplos de 50)");
            x = lector.nextInt();
            while(x > getEje_x()-50 || x%50 != 0){
                System.out.println("Intente nuevamente");
                x = lector.nextInt();
            }
            getPistas().get(i).setPosicion_x(x);
            //Ingresar posición y.
            System.out.println("Ingrese Posición y (múltiplos de 50)");
            y = lector.nextInt();
            while(y > getEje_y()-50 || y%50 !=0){
                System.out.println("Intente nuevamente");
                y = lector.nextInt();
            }
            getPistas().get(i).setPosicion_y(y);
            //Horizontal / Vertical.
            System.out.println("Para posición horizontal ingrese 1. Para posición vertical ingrese 2");
            respuesta = lector.nextInt();
            while(respuesta != 1 && respuesta != 2){
                System.out.println("Intente nuevamente");
                respuesta = lector.nextInt();
            }
            getPistas().get(i).setOrientacion(respuesta);
            //Ingresar largo de la pista, este no debe sobrepasar los límites del escenario.
            System.out.println("Ingrese largo de la pista (múltiplos de 50, no debe sobrepasar los límites del escenario)");
            largo_pista = lector.nextInt();
            while(getPistas().get(i).getOrientacion() == 1 && (largo_pista + getPistas().get(i).getPosicion_x() > getEje_x() || largo_pista%50 != 0)){
                System.out.println("Intente nuevamente");
                largo_pista = lector.nextInt();
            }
            while(getPistas().get(i).getOrientacion() == 2 && (largo_pista + getPistas().get(i).getPosicion_y() > getEje_y() || largo_pista%50 != 0)){
                System.out.println("Intente nuevamente");
                largo_pista = lector.nextInt();
            }
            getPistas().get(i).setLargo_pista(largo_pista);
            System.out.print("Mapa de pistas\n");
            mostrar_mapa();
        }
    }
    public void mostrar_mapa(){
        boolean pista_encontrada = false;
        System.out.print("\n");
        for(int i = 0; i < getEje_y(); i = i+50){
            for(int j = 0; j < getEje_x(); j = j+50){
                for(int k = 0; k < getPistas().size(); k++){
                    if(getPistas().get(k).getOrientacion() == 1){
                        if(j >= getPistas().get(k).getPosicion_x() && j < getPistas().get(k).getPosicion_x()+getPistas().get(k).getLargo_pista() && getPistas().get(k).getPosicion_y() == i ){
                            pista_encontrada = true;
                        }
                    }
                    if(getPistas().get(k).getOrientacion() == 2){
                        if(i >= getPistas().get(k).getPosicion_y() && i < getPistas().get(k).getPosicion_y() + getPistas().get(k).getLargo_pista() && getPistas().get(k).getPosicion_x() == j){
                            pista_encontrada = true;
                        }
                    }
                }
                if(!pista_encontrada){
                    System.out.print("- ");
                }
                if(pista_encontrada){
                    System.out.print("P ");
                    pista_encontrada = false;
                }
            }
            System.out.print(" \n");
        }
    }
}
