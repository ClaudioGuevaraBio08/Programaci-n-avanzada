import java.util.Scanner;
public class Controlador {
    //Atributos de Controlador, posee al robot, la pista y a los 3 modos principales, además de un estado que interactuará entre unos y otros.
    private Robot valkirie;
    private Escenario escenario;
    private Fighter modo_fighter;
    private Gerwalk modo_gerwalk;
    private Battloid modo_battloid;
    private int estado;
    Scanner lector = new Scanner(System.in);
    Controlador() {
        escenario = new Escenario();
        valkirie = new Robot();
        modo_fighter = new Fighter();
        modo_gerwalk = new Gerwalk();
        modo_battloid = new Battloid();
        estado = 1;
    }
    //Getters y setters de los modos de los atributos.
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
    public void escojer_armas_robot(){
        int seleccionar_armas = 0;
        System.out.println("Ingrese la cantidad de armas deseada (1 - 2 - 4)");
        seleccionar_armas = lector.nextInt();
        while(seleccionar_armas != 1 && seleccionar_armas != 2 && seleccionar_armas != 4) {
            System.out.println("Intente nuevamente");
            seleccionar_armas = lector.nextInt();
        }
        if (seleccionar_armas == 1) {
            getValkirie().getFuselaje_robot().getArma_cañón().setPresente(true);
        }
        else if (seleccionar_armas == 2) {
            getValkirie().getFuselaje_robot().getArma_cañón().setPresente(true);
            getValkirie().getFuselaje_robot().getArma_laser().setPresente(true);
        }
        else if (seleccionar_armas == 4) {
            getValkirie().getFuselaje_robot().getArma_cañón().setPresente(true);
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
            getValkirie().getBrazo_derecho().getArma_cañón().setPresente(true);
        }
        else if (seleccionar_armas == 2) {
            getValkirie().getBrazo_izquierdo().getArma_cañón().setPresente(true);
        }
    }
    public void control_valkirie() {
        for(int i=0; i<1000; i=i+1){
            if (getEstado() == 1) {
                getValkirie().getAla_derecha().setPresente(true);
                getValkirie().getAla_izquierda().setPresente(true);
                getValkirie().getCabeza_robot().setPresente(false);
                getValkirie().getBrazo_derecho().setPresente(false);
                getValkirie().getBrazo_izquierdo().setPresente(false);
                getValkirie().getPierna_derecha().setPresente(false);
                getValkirie().getPierna_izquierda().setPresente(false);
                getValkirie().getFuselaje_robot().setPresente(true);
                getModo_fighter().título();
                setEstado(getModo_fighter().movimiento(getEstado(), getValkirie(), getEscenario()));
                }
                if(getEstado() == 4){
                    getModo_fighter().disparar(getValkirie());
                    setEstado(1);
                }
            }
            if (getEstado() == 2) {
                getValkirie().getAla_izquierda().setPresente(true);
                getValkirie().getAla_izquierda().setPresente(true);
                getValkirie().getCabeza_robot().setPresente(false);
                getValkirie().getBrazo_derecho().setPresente(true);
                getValkirie().getBrazo_izquierdo().setPresente(true);
                getValkirie().getPierna_derecha().setPresente(true);
                getValkirie().getPierna_izquierda().setPresente(true);
                getValkirie().getFuselaje_robot().setPresente(true);
                getModo_gerwalk().título();
                setEstado(getModo_gerwalk().movimiento(getEstado(), getValkirie()));
                if(getEstado() == 4){
                    getModo_gerwalk().disparar(getValkirie());
                    setEstado(2);
                }
            }
            if (getEstado() == 3) {
                getValkirie().getAla_izquierda().setPresente(false);
                getValkirie().getAla_izquierda().setPresente(false);
                getValkirie().getCabeza_robot().setPresente(true);
                getValkirie().getBrazo_derecho().setPresente(true);
                getValkirie().getBrazo_izquierdo().setPresente(true);
                getValkirie().getPierna_derecha().setPresente(true);
                getValkirie().getPierna_izquierda().setPresente(true);
                getValkirie().getFuselaje_robot().setPresente(false);
                getModo_battloid().titulo();
                setEstado(getModo_battloid().movimiento(getEstado(), getValkirie()));
                if(getEstado() == 4){
                    getModo_battloid().disparar(getValkirie());
                    setEstado(3);
                }
            }
        }
    }