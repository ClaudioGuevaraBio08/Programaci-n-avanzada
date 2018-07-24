import java.util.ArrayList;

public class Robot {
    //Atributos de el robot
    //Partes físicas del robot y armas
    private Alas ala_izquierda;
    private Alas ala_derecha;
    private Piernas pierna_derecha;
    private Piernas pierna_izquierda;
    private Brazos brazo_derecho;
    private Brazos brazo_izquierdo;
    private Cabeza cabeza_robot;
    private Fuselaje fuselaje_robot;
    ArrayList<Arma> array_armas_fighter;
    //Atributos de tipo int que reflejan la posición del robot
    private int altura;
    private int velocidad;
    private int distancia;
    Robot() {
        ala_izquierda = new Alas();
        ala_derecha = new Alas();
        pierna_derecha = new Piernas();
        pierna_izquierda = new Piernas();
        brazo_derecho = new Brazos();
        brazo_izquierdo = new Brazos();
        cabeza_robot = new Cabeza();
        fuselaje_robot= new Fuselaje();
        array_armas_fighter = new ArrayList<>();
        array_armas_fighter.add(0,getFuselaje_robot().getArma_cañón());
        array_armas_fighter.add(1,getFuselaje_robot().getArma_laser());
        array_armas_fighter.add(2,getAla_izquierda().getArma_laser());
        array_armas_fighter.add(3,getAla_derecha().getArma_laser());
        array_armas_fighter.add(4,getBrazo_izquierdo().getArma_cañón());
        array_armas_fighter.add(5, getBrazo_derecho().getArma_cañón());
        altura = 0;
        velocidad = 0;
        distancia = 0;
    }
    //Getters de las partes del robot y armas
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
    //Getters y Setters de los atributos int de robot
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public int getDistancia() {
        return distancia;
    }
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}
