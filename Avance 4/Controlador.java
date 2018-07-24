import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Controlador {
    Random aleatorio;
    Scanner lector = new Scanner(System.in);
    private Robot valkirie;
    private Escenario escenario;
    private Fighter modo_fighter;
    private Gerwalk modo_gerwalk;
    private Battloid modo_battloid;
    private ArrayList<Robot_Enemigo> robots_zentraedi;
    private int estado;
    Controlador() {
        aleatorio = new Random(System.currentTimeMillis());
        escenario = new Escenario();
        valkirie = new Robot();
        modo_fighter = new Fighter();
        modo_gerwalk = new Gerwalk();
        modo_battloid = new Battloid();
        robots_zentraedi = new ArrayList<Robot_Enemigo>();
        estado = 1;
    }
    //Getters & Setters de los atributos
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public Robot getValkirie() {
        return valkirie;
    }
    public Fighter getModo_fighter() {
        return modo_fighter;
    }
    public Battloid getModo_battloid() {
        return modo_battloid;
    }
    public Gerwalk getModo_gerwalk() {
        return modo_gerwalk;
    }
    public Escenario getEscenario() {
        return escenario;
    }
    public ArrayList<Robot_Enemigo> getRobots_zentraedi() {
        return robots_zentraedi;
    }
    //Función encargada de crear un determinado numero de enemigos y posicionarlos aleatoriamente en el mapa, además de agregarlos a un arraylist de tipo Robot_Enemigo
    public void crear_enemigos_en_posiciones_random(){
        Random random = new Random();
        for(int i=0; i<5; i++) {
            getRobots_zentraedi().add(new Robot_Enemigo(String.valueOf(i)));
            getRobots_zentraedi().get(i).setPosicion_eje_x((Math.abs(aleatorio.nextInt() % 60) + 1) * 50);
            getRobots_zentraedi().get(i).setPosicion_eje_y((Math.abs(aleatorio.nextInt() % 60) + 1) * 50);
            getRobots_zentraedi().get(i).setPosicion_eje_z((Math.abs(aleatorio.nextInt() % 20) + 1) * 50);
        }
    }
    //Funcion encargada de imprimir la información aleatoria de los enemigos
    public void mostrar_posicion_enemigos() {
        for (int i = 0; i < getRobots_zentraedi().size(); i++) {
            System.out.println("Zentraedi " + getRobots_zentraedi().get(i).getNombre());
            System.out.println("(" + getRobots_zentraedi().get(i).getPosicion_eje_x() + ", " + getRobots_zentraedi().get(i).getPosicion_eje_y() + " ," + getRobots_zentraedi().get(i).getPosicion_eje_z() + ")");
        }
    }
    public void mover_robot_zentraedi_aleatorio(){
        int numero_random = Math.abs(aleatorio.nextInt() % getRobots_zentraedi().size());
        if(getRobots_zentraedi().get(numero_random).movimientos_aleatorios()) {
            System.out.println("Robot enemigo " + getRobots_zentraedi().get(numero_random).getNombre() + " se ha desplazado a la posición");
            System.out.println("(" + getRobots_zentraedi().get(numero_random).getPosicion_eje_x() + ", " + getRobots_zentraedi().get(numero_random).getPosicion_eje_y() + ", " + getRobots_zentraedi().get(numero_random).getPosicion_eje_z() + ")");
        }
    }
    //Funcion encargada de armar las armas del robot
    public void escojer_armas_robot() {
        int seleccionar_armas = 0;
        System.out.println("Ingrese la cantidad de armas deseada (1 - 2 - 4)");
        seleccionar_armas = lector.nextInt();
        while (seleccionar_armas != 1 && seleccionar_armas != 2 && seleccionar_armas != 4) {
            System.out.println("Intente nuevamente");
            seleccionar_armas = lector.nextInt();
        }
        if (seleccionar_armas == 1) {
            getValkirie().getFuselaje_robot().getArma_canon().setPresente(true);
        }
        if (seleccionar_armas == 2) {
            getValkirie().getFuselaje_robot().getArma_canon().setPresente(true);
            getValkirie().getFuselaje_robot().getArma_laser().setPresente(true);
        }
        if (seleccionar_armas == 4) {
            getValkirie().getFuselaje_robot().getArma_canon().setPresente(true);
            getValkirie().getFuselaje_robot().getArma_laser().setPresente(true);
            getValkirie().getAla_derecha().getArma_laser().setPresente(true);
            getValkirie().getAla_izquierda().getArma_laser().setPresente(true);
        }
        System.out.println("Presione 1 para obtener Arma de brazo derecho \nPresione 2 para obtener Arma de brazo izquierdo\nPresione 0 para no obtener Arma");
        seleccionar_armas = lector.nextInt();
        while (seleccionar_armas != 0 && seleccionar_armas != 1 && seleccionar_armas != 2) {
            System.out.println("Intente nuevamente");
            seleccionar_armas = lector.nextInt();
        }
        if (seleccionar_armas == 1) {
            getValkirie().getBrazo_derecho().getArma_canon().setPresente(true);
        } else if (seleccionar_armas == 2) {
            getValkirie().getBrazo_izquierdo().getArma_canon().setPresente(true);
        }
    }
    //Función encargada de mover el robot y derivar a las diferentes funciones
    public void control_valkirie() {
        if (getEstado() == 1) {
            getValkirie().getAla_derecha().setPresente(true);
            getValkirie().getAla_izquierda().setPresente(true);
            getValkirie().getCabeza_robot().setPresente(false);
            getValkirie().getBrazo_derecho().setPresente(false);
            getValkirie().getBrazo_izquierdo().setPresente(false);
            getValkirie().getPierna_derecha().setPresente(false);
            getValkirie().getPierna_izquierda().setPresente(false);
            getValkirie().getFuselaje_robot().setPresente(true);
            System.out.println("MODO FIGHTER");
            setEstado(getModo_fighter().movimiento(getEstado(), getValkirie(), getEscenario()));
            if(getEstado() == 5) {
                mostrar_posicion_enemigos();
                setEstado(1);
            }
        }
        if (getEstado() == 2) {
            getValkirie().getAla_derecha().setPresente(true);
            getValkirie().getAla_izquierda().setPresente(true);
            getValkirie().getCabeza_robot().setPresente(false);
            getValkirie().getBrazo_derecho().setPresente(true);
            getValkirie().getBrazo_izquierdo().setPresente(true);
            getValkirie().getPierna_derecha().setPresente(true);
            getValkirie().getPierna_izquierda().setPresente(true);
            getValkirie().getFuselaje_robot().setPresente(true);
            System.out.println("MODO GERWALK");
            setEstado(getModo_gerwalk().movimiento(getEstado(), getValkirie(), escenario));
            if(getEstado() == 5) {
                mostrar_posicion_enemigos();
                setEstado(2);
            }
        }
        if (getEstado() == 3) {
            getValkirie().getAla_derecha().setPresente(false);
            getValkirie().getAla_izquierda().setPresente(false);
            getValkirie().getCabeza_robot().setPresente(true);
            getValkirie().getBrazo_derecho().setPresente(true);
            getValkirie().getBrazo_izquierdo().setPresente(true);
            getValkirie().getPierna_derecha().setPresente(true);
            getValkirie().getPierna_izquierda().setPresente(true);
            getValkirie().getFuselaje_robot().setPresente(false);
            System.out.println("MODO BATTLOID");
            setEstado(getModo_battloid().movimiento(getEstado(), getValkirie(), escenario));
            if(getEstado() == 5) {
                mostrar_posicion_enemigos();
                setEstado(3);
            }
        }
    }
    //Función encargada de verificar si se encuentra un enemigo a 4 cuadrantes de valkirie, y cual/cuales zentraedi es/son
    public void encontrar_enemigo(){
        for (int i = 0 ; i < getRobots_zentraedi().size() ; i++){
            if (Math.abs(getRobots_zentraedi().get(i).getPosicion_eje_x() - getValkirie().getPosicion_eje_x()) <= 400 &&
                Math.abs(getRobots_zentraedi().get(i).getPosicion_eje_y() - getValkirie().getPosicion_eje_y()) <= 400 &&
                Math.abs(getRobots_zentraedi().get(i).getPosicion_eje_z() - getValkirie().getPosicion_eje_z()) <= 400){
                System.out.println("ROBOT ENEMIGO DETECTADO : Zentraedi " + getRobots_zentraedi().get(i).getNombre());
                getRobots_zentraedi().get(i).disparo_enemigo();
            }
        }
    }
}