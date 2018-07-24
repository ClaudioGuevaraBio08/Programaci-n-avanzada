import java.util.Random;
public class Robot_Enemigo {
    private String nombre;
    private Arma canon_1;
    private Arma canon_2;
    private int posicion_eje_x;
    private int posicion_eje_y;
    private int posicion_eje_z;
    private boolean[] posibilidades_de_movimientos;
    Random aleatorio;
    Robot_Enemigo(String nombre_ingresado){
        aleatorio = new Random(System.currentTimeMillis());
        nombre = nombre_ingresado;
        canon_1 = new Arma("Cañón 1 Zentraedi");
        canon_2 = new Arma("Cañón 2 Zentraedi");
        posibilidades_de_movimientos = new boolean[6];
    }
    //Getters y Setters de los atributos
    public String getNombre() {
        return nombre;
    }
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
    public boolean[] getPosibilidades_de_movimientos() {
        return posibilidades_de_movimientos;
    }
    //Funcion qu recoje todas las acciones posibles del robot y las almacena en un arreglo para luego escojer una de ellas aleatoriamente
    public boolean movimientos_aleatorios(){
        boolean existe_movimiento = false;
        int eleccion_aleatoria;
        if(getPosicion_eje_x() > 0){
            getPosibilidades_de_movimientos()[0] = true;
        }
        if(getPosicion_eje_x() <= 0){
            getPosibilidades_de_movimientos()[0] = false;
        }
        if(getPosicion_eje_x() < 3000){
            getPosibilidades_de_movimientos()[1] = true;
        }
        if(getPosicion_eje_x() >= 3000){
            getPosibilidades_de_movimientos()[1] = false;
        }
        if(getPosicion_eje_y() > 0){
            getPosibilidades_de_movimientos()[2] = true;
        }
        if(getPosicion_eje_y() <= 0){
            getPosibilidades_de_movimientos()[2] = false;
        }
        if(getPosicion_eje_y() < 3000){
            getPosibilidades_de_movimientos()[3] = true;
        }
        if(getPosicion_eje_y() >= 3000){
            getPosibilidades_de_movimientos()[3] = false;
        }
        if(getPosicion_eje_z() > 0){
            getPosibilidades_de_movimientos()[4] = true;
        }
        if(getPosicion_eje_z() <= 0){
            getPosibilidades_de_movimientos()[4] = false;
        }
        getPosibilidades_de_movimientos()[5] = true;
        eleccion_aleatoria = Math.abs(aleatorio.nextInt() % getPosibilidades_de_movimientos().length);
        if(eleccion_aleatoria == 0 && getPosibilidades_de_movimientos()[0]){
            setPosicion_eje_x(getPosicion_eje_x() - 50);
            existe_movimiento = true;
        }
        if(eleccion_aleatoria == 1 && getPosibilidades_de_movimientos()[1]){
            setPosicion_eje_x(getPosicion_eje_x() + 50);
            existe_movimiento = true;
        }
        if(eleccion_aleatoria == 2 && getPosibilidades_de_movimientos()[2]){
            setPosicion_eje_y(getPosicion_eje_y() - 50);
            existe_movimiento = true;
        }
        if(eleccion_aleatoria == 3 && getPosibilidades_de_movimientos()[3]){
            setPosicion_eje_y(getPosicion_eje_y() + 50);
            existe_movimiento = true;
        }
        if(eleccion_aleatoria == 4 && getPosibilidades_de_movimientos()[4]){
            setPosicion_eje_z(getPosicion_eje_z() - 50);
            existe_movimiento = true;
        }
        if(eleccion_aleatoria == 5 && getPosibilidades_de_movimientos()[5]){
            setPosicion_eje_z(getPosicion_eje_z() + 50);
            existe_movimiento = true;
        }
        return existe_movimiento;
    }
    public void disparo_enemigo(){
        int arma_aleatoria = Math.abs(aleatorio.nextInt() % 2) + 1;
        int numero_aleatorio;
        if (arma_aleatoria == 1){
            getCanon_1().disparo();
        }
        if (arma_aleatoria == 2){
            getCanon_2().disparo();
        }
    }
}