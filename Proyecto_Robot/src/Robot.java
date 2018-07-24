import java.util.ArrayList;
public class Robot {
    //Partes físicas del robot y armas
    private Alas ala_izquierda;
    private Alas ala_derecha;
    private Piernas pierna_derecha;
    private Piernas pierna_izquierda;
    private Brazos brazo_derecho;
    private Brazos brazo_izquierdo;
    private Cabeza cabeza_robot;
    private Fuselaje fuselaje_robot;
    private ArrayList<Arma> array_armas_fighter;
    //Atributos de tipo int que reflejan variables del robot
    private int posicion_eje_x;
    private int posicion_eje_y;
    private int posicion_eje_z;
    private int velocidad;
    //variable que indica si el robot se encuentra detectando un enemigo a < 200 m
    private boolean detectando_enemigo_zentraedi;
    Robot(int posicion_eje_x, int posicion_eje_y, int posicion_eje_z, int velocidad) {
        this.ala_izquierda = new Alas("Arma laser ala izquierda", 10);
        this.ala_derecha = new Alas("Arma laser ala derecha", 10);
        this.brazo_derecho = new Brazos("Arma cañón brazo derecho", 10);
        this.brazo_izquierdo = new Brazos("Arma cañón brazo izquierdo", 10);
        this.fuselaje_robot= new Fuselaje("Arma cañón fuselaje", "Arma laser fuselaje", 10);
        this.cabeza_robot = new Cabeza(10);
        this.pierna_derecha = new Piernas(10);
        this.pierna_izquierda = new Piernas(10);
        this.array_armas_fighter = new ArrayList<>(6);
        this.array_armas_fighter.add(0, getFuselaje_robot().getArma_canon());
        this.array_armas_fighter.add(1, getFuselaje_robot().getArma_laser());
        this.array_armas_fighter.add(2, getAla_izquierda().getArma_laser());
        this.array_armas_fighter.add(3, getAla_derecha().getArma_laser());
        this.array_armas_fighter.add(4, getBrazo_izquierdo().getArma_canon());
        this.array_armas_fighter.add(5, getBrazo_derecho().getArma_canon());
        this.posicion_eje_x = posicion_eje_x;
        this.posicion_eje_y = posicion_eje_y;
        this.posicion_eje_z = posicion_eje_z;
        this.velocidad = velocidad;
        this.detectando_enemigo_zentraedi = false;
    }
    //Geters & Seters de las partes del robot y armas
    public Alas getAla_izquierda()
    {
        return ala_izquierda;
    }
    public Alas getAla_derecha() {
        return ala_derecha;
    }
    public Cabeza getCabeza_robot()
    {
        return cabeza_robot;
    }
    public Piernas getPierna_derecha()
    {
        return pierna_derecha;
    }
    public Piernas getPierna_izquierda()
    {
        return pierna_izquierda;
    }
    public Brazos getBrazo_derecho()
    {
        return brazo_derecho;
    }
    public Brazos getBrazo_izquierdo()
    {
        return brazo_izquierdo;
    }
    public Fuselaje getFuselaje_robot() {
        return fuselaje_robot;
    }
    public ArrayList<Arma> getArray_armas_fighter() {
        return array_armas_fighter;
    }
    public int getPosicion_eje_z() {
        return posicion_eje_z;
    }
    public void setPosicion_eje_z(int posicion_eje_z) {
        this.posicion_eje_z = posicion_eje_z;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
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
    public boolean isDetectando_enemigo_zentraedi() {
        return detectando_enemigo_zentraedi;
    }
    public void setDetectando_enemigo_zentraedi(boolean detectando_enemigo_zentraedi) {
        this.detectando_enemigo_zentraedi = detectando_enemigo_zentraedi;
    }
}