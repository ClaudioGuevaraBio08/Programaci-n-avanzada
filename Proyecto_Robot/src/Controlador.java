import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Controlador {
    Random aleatorio = new Random(System.currentTimeMillis());
    Scanner lector = new Scanner(System.in);
    private Robot valkirie;
    private Escenario escenario;
    private Fighter modo_fighter;
    private Gerwalk modo_gerwalk;
    private Battloid modo_battloid;
    private ArrayList<Robot_Enemigo> robots_zentraedi;
    private int estado;
    private boolean se_encuentra_sobre_pista;
    private boolean puede_despegar;
    private boolean[] enemigos_detectados;//Arreglo que pretende identificar qué robots enemigos se encuentran a < 200 m
    private boolean destruccion_gerwalk;
    Controlador(int estado, int cantidad_enemigos) {
        this.escenario = new Escenario(2000,2000);
        this.valkirie = new Robot(0, 0, 0, 0);
        this.modo_fighter = new Fighter();
        this.modo_gerwalk = new Gerwalk();
        this.modo_battloid = new Battloid();
        this.robots_zentraedi = new ArrayList<>(cantidad_enemigos);
        this.estado = estado;
        this.enemigos_detectados = new boolean[cantidad_enemigos];
        this.se_encuentra_sobre_pista = false;
        this.puede_despegar = false;
        this.destruccion_gerwalk = false;
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
    public boolean isSe_encuentra_sobre_pista() {
        return se_encuentra_sobre_pista;
    }
    public void setSe_encuentra_sobre_pista(boolean se_encuentra_sobre_pista) {
        this.se_encuentra_sobre_pista = se_encuentra_sobre_pista;
    }
    public boolean[] getEnemigos_detectados() {
        return enemigos_detectados;
    }
    public boolean isPuede_despegar() {
        return puede_despegar;
    }
    public void setPuede_despegar(boolean puede_despegar) {
        this.puede_despegar = puede_despegar;
    }
    public boolean isDestruccion_gerwalk() {
        return destruccion_gerwalk;
    }
    public void setDestruccion_gerwalk(boolean destruccion_gerwalk) {
        this.destruccion_gerwalk = destruccion_gerwalk;
    }
    //Función encargada de crear un determinado numero de enemigos y posicionarlos aleatoriamente en el mapa, además de agregarlos a un arraylist de tipo Robot_Enemigo
    public void crear_enemigos_en_posiciones_random(int cantidad_enemigos){
        for(int i=0; i<cantidad_enemigos; i++) {
            getRobots_zentraedi().add(new Robot_Enemigo());
            getRobots_zentraedi().get(i).setPosicion_eje_x((Math.abs(aleatorio.nextInt() % 20) + 1) * 50);
            getRobots_zentraedi().get(i).setPosicion_eje_y((Math.abs(aleatorio.nextInt() % 20) + 1) * 50);
            getRobots_zentraedi().get(i).setPosicion_eje_z((Math.abs(aleatorio.nextInt() % 10) + 1) * 50);
        }
    }
    //Funcion encargada de armar las armas del robot
    public void escojer_armas_robot() {
        int seleccionar_armas;
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
        }
        if (seleccionar_armas == 2) {
            getValkirie().getBrazo_izquierdo().getArma_canon().setPresente(true);
        }
    }
    //Función encargada de mover el robot y derivar a las diferentes funciones
    public void control_valkirie() {
        if (getEstado() == 1){
            getValkirie().getAla_izquierda().setPresente(true);
            getValkirie().getAla_derecha().setPresente(true);
            getValkirie().getBrazo_izquierdo().setPresente(false);
            getValkirie().getBrazo_derecho().setPresente(false);
            getValkirie().getFuselaje_robot().setPresente(true);
            getValkirie().getPierna_izquierda().setPresente(false);
            getValkirie().getPierna_derecha().setPresente(false);
            getValkirie().getCabeza_robot().setPresente(false);
            System.out.println("MODO FIGHTER");
            encontrar_pista();
            if (isSe_encuentra_sobre_pista()) {
                recuperar_resistencia();
            }
            encontrar_enemigo();
            if (getValkirie().getAla_izquierda().getIndicador_resistencia() * getValkirie().getAla_derecha().getIndicador_resistencia() == 0)
            {
                System.out.println("CAMBIO FORZADO DE MODO - ¡¡¡CAMBIANDO A MODO GERWALK!!!");
                setEstado(2);
            }
            if(getEstado() == 1) {
                setEstado(getModo_fighter().movimiento(getEstado(), getValkirie(), getEscenario(), isSe_encuentra_sobre_pista(), isPuede_despegar()));
            }
            if (getEstado() == 5) {
                mostrar_posicion_enemigos();
                setEstado(1);
            }
            if (getEstado() == 6){
                setEstado(1);
                combatir();
            }
            if (getEstado() == 7){
                escapar();
                setEstado(1);
            }
            if (getEstado() == 8){
                mostrar_resistencias_del_robot();
                setEstado(1);
            }
            if (getEstado() == 9){
                recuperar_resistencia();
                setEstado(1);
            }
        }
        if (getEstado() == 2) {
            getValkirie().getAla_izquierda().setPresente(true);
            getValkirie().getAla_derecha().setPresente(true);
            getValkirie().getBrazo_izquierdo().setPresente(true);
            getValkirie().getBrazo_derecho().setPresente(true);
            getValkirie().getFuselaje_robot().setPresente(true);
            getValkirie().getPierna_izquierda().setPresente(true);
            getValkirie().getPierna_derecha().setPresente(true);
            getValkirie().getCabeza_robot().setPresente(false);
            System.out.println("MODO GERWALK");
            encontrar_enemigo();
            encontrar_pista();
            if (isSe_encuentra_sobre_pista()) {
                recuperar_resistencia();
            }
            if (getValkirie().getAla_izquierda().getIndicador_resistencia() * getValkirie().getAla_derecha().getIndicador_resistencia() == 0) {
                if(getValkirie().getPosicion_eje_z() <= 200) {
                    System.out.println("CAMBIO FORZADO DE MODO - ¡¡¡CAMBIANDO A MODO BATTLOID!!!");
                    setEstado(3);
                }
                else{
                    setDestruccion_gerwalk(true);
                }
            }
            if (getValkirie().getBrazo_izquierdo().getIndicador_resistencia() * getValkirie().getBrazo_derecho().getIndicador_resistencia() * getValkirie().getPierna_izquierda().getIndicador_resistencia() * getValkirie().getPierna_derecha().getIndicador_resistencia() == 0){
                System.out.println("CAMBIO FORZADO DE MODO - ¡¡¡CAMBIANDO A MODO FIGHTER!!!");
                setEstado(1);
            }
            if (getEstado() == 2){
                setEstado(getModo_gerwalk().movimiento(getEstado(), getValkirie(), getEscenario(), getModo_battloid()));
            }
            if (getEstado() == 5) {
                mostrar_posicion_enemigos();
                setEstado(2);
            }
            if (getEstado() == 6){
                setEstado(2);
                combatir();
            }
            if (getEstado() == 7){
                escapar();
                setEstado(2);
            }
            if (getEstado() == 8){
                mostrar_resistencias_del_robot();
                setEstado(2);
            }
            if (getEstado() == 9){
                recuperar_resistencia();
                setEstado(2);
            }
        }
        if (getEstado() == 3) {
            getValkirie().getAla_izquierda().setPresente(false);
            getValkirie().getAla_derecha().setPresente(false);
            getValkirie().getBrazo_izquierdo().setPresente(true);
            getValkirie().getBrazo_derecho().setPresente(true);
            getValkirie().getFuselaje_robot().setPresente(true);
            getValkirie().getPierna_izquierda().setPresente(true);
            getValkirie().getPierna_derecha().setPresente(true);
            getValkirie().getCabeza_robot().setPresente(true);
            System.out.println("MODO BATTLOID");
            encontrar_enemigo();
            encontrar_pista();
            if (isSe_encuentra_sobre_pista()) {
                recuperar_resistencia();
            }
            if(getValkirie().getCabeza_robot().getIndicador_resistencia() == 0){
                System.out.println("CAMBIO FORZADO DE MODO (Modo fighter (0 - Modo gerwalk (1))");
                int emergencia_seleccion = lector.nextInt();
                if(emergencia_seleccion == 0){
                    System.out.println("¡¡¡CAMBIANDO A MODO FIGHTER!!!");
                    setEstado(1);
                }
                if(emergencia_seleccion == 1) {
                    System.out.println("¡¡¡CAMBIANDO A MODO GERWALK!!!");
                    setEstado(2);
                }
            }
            if (getValkirie().getBrazo_izquierdo().getIndicador_resistencia() * getValkirie().getBrazo_derecho().getIndicador_resistencia() * getValkirie().getPierna_izquierda().getIndicador_resistencia() * getValkirie().getPierna_derecha().getIndicador_resistencia() == 0){
                System.out.println("CAMBIO FORZADO DE MODO - ¡¡¡CAMBIANDO A MODO FIGHTER!!!");
                setEstado(1);
            }
            if (getEstado() == 3) {
                setEstado(getModo_battloid().movimiento(getEstado(), getValkirie(), getEscenario(), getRobots_zentraedi()));
            }
            if (getEstado() == 5) {
                mostrar_posicion_enemigos();
                setEstado(3);
            }
            if (getEstado() == 6){
                setEstado(3);
                combatir();
            }
            if (getEstado() == 7){
                escapar();
                setEstado(3);
            }
            if (getEstado() == 8){
                mostrar_resistencias_del_robot();
                setEstado(3);
            }
            if (getEstado() == 9){
                recuperar_resistencia();
                setEstado(3);
            }
        }
    }
    //Funcion encargada de imprimir la información aleatoria de los enemigos
    public void mostrar_posicion_enemigos() {
        for (int i = 0; i < getRobots_zentraedi().size(); i++) {
            System.out.print("Zentraedi " + i);
            System.out.print(" (" + getRobots_zentraedi().get(i).getPosicion_eje_x() + ", " + getRobots_zentraedi().get(i).getPosicion_eje_y() + " ," + getRobots_zentraedi().get(i).getPosicion_eje_z() + ")");
            System.out.println(" Resistencia: " + getRobots_zentraedi().get(i).getIndicador_resistencia());
        }
    }
    //Función encargada de imprimir la vida de cada parte de Valkirie
    public void mostrar_resistencias_del_robot(){
        System.out.println("Ala izquierda " + getValkirie().getAla_izquierda().getIndicador_resistencia());
        System.out.println("Ala derecha " + getValkirie().getAla_derecha().getIndicador_resistencia());
        System.out.println("Brazo izquierdo " + getValkirie().getBrazo_izquierdo().getIndicador_resistencia());
        System.out.println("Brazo derecho " + getValkirie().getBrazo_derecho().getIndicador_resistencia());
        System.out.println("Fuselaje " + getValkirie().getFuselaje_robot().getIndicador_resistencia());
        System.out.println("Pierna izquierda " + getValkirie().getPierna_izquierda().getIndicador_resistencia());
        System.out.println("Pierna derecha " + getValkirie().getPierna_derecha().getIndicador_resistencia());
        System.out.println("Cabeza " + getValkirie().getCabeza_robot().getIndicador_resistencia());
    }
    //Funcion encargada de verificar si se está sobre una pista y si esa pista es suficientemente larga para despegar (>100m)
    public void encontrar_pista(){
        setSe_encuentra_sobre_pista(false);
        setPuede_despegar(false);
        if (getValkirie().getPosicion_eje_z() == 0) {
            for (int k = 0; k < getEscenario().getPistas().size(); k = k + 1) {
                if ((getEscenario().getPistas().get(k).getOrientacion() == 1 &&
                        getValkirie().getPosicion_eje_x() >= getEscenario().getPistas().get(k).getPosicion_x() &&
                        getValkirie().getPosicion_eje_x() <= getEscenario().getPistas().get(k).getPosicion_x() + getEscenario().getPistas().get(k).getLargo_pista() &&
                        getValkirie().getPosicion_eje_y() == getEscenario().getPistas().get(k).getPosicion_y()) ||
                        (getEscenario().getPistas().get(k).getOrientacion() == 2 &&
                                getValkirie().getPosicion_eje_y() >= getEscenario().getPistas().get(k).getPosicion_y() &&
                                getValkirie().getPosicion_eje_y() <= getEscenario().getPistas().get(k).getPosicion_y() + getEscenario().getPistas().get(k).getLargo_pista()) &&
                                getValkirie().getPosicion_eje_x() == getEscenario().getPistas().get(k).getPosicion_x()) {
                    setSe_encuentra_sobre_pista(true);
                    if (getEscenario().getPistas().get(k).getLargo_pista() > 100) {
                        setPuede_despegar(true);
                    }
                }
            }
        }
    }
    //Funciones encargadas de luchar Valkirie vs Zentraedi
    public void encontrar_enemigo(){
        for(int i=0; i<getRobots_zentraedi().size(); i++){
            getEnemigos_detectados()[i] = false;
        }
        getValkirie().setDetectando_enemigo_zentraedi(false);
        for (int i = 0 ; i < getRobots_zentraedi().size() ; i++){
            if (Math.sqrt(Math.pow(getRobots_zentraedi().get(i).getPosicion_eje_x() - getValkirie().getPosicion_eje_x(), 2) +
                    Math.pow(getRobots_zentraedi().get(i).getPosicion_eje_y() - getValkirie().getPosicion_eje_y(), 2) +
                    Math.pow(getRobots_zentraedi().get(i).getPosicion_eje_z() - getValkirie().getPosicion_eje_z(), 2)) <= 200) {
                getEnemigos_detectados()[i] = true;
                getValkirie().setDetectando_enemigo_zentraedi(true);
                System.out.print("ROBOT ENEMIGO DETECTADO : Zentraedi " + i);
                System.out.print(" (" + getRobots_zentraedi().get(i).getPosicion_eje_x() + ", " + getRobots_zentraedi().get(i).getPosicion_eje_y() + ", " + getRobots_zentraedi().get(i).getPosicion_eje_z() + ")");
                System.out.println(" Resistencia: " + getRobots_zentraedi().get(i).getIndicador_resistencia());
            }
        }
    }
    public int calculo_distancia_hacia_enemigo(int enemigo_seleccionado){
        int distancia;
        distancia = (int) Math.sqrt(Math.pow(getRobots_zentraedi().get(enemigo_seleccionado).getPosicion_eje_x() - getValkirie().getPosicion_eje_x(), 2) + Math.pow(getRobots_zentraedi().get(enemigo_seleccionado).getPosicion_eje_y() - getValkirie().getPosicion_eje_y(), 2) + Math.pow(getRobots_zentraedi().get(enemigo_seleccionado).getPosicion_eje_z() - getValkirie().getPosicion_eje_z(), 2));
        return distancia;
    }
    public int calculo_de_porcentaje(int intervalo, int piso){
        int porcentaje_de_acierto;
        porcentaje_de_acierto = (Math.abs(aleatorio.nextInt() % intervalo) + piso);
        return porcentaje_de_acierto;
    }
    public void combatir(){
        int eleccion_disparo = Math.abs(aleatorio.nextInt() % 4) + 1;
        for (int i = 0; i < getRobots_zentraedi().size(); i++) {
            if (getEnemigos_detectados()[i]) {
                if(eleccion_disparo == 1 || eleccion_disparo == 2) {
                    System.out.println("Valkirie dispara");
                    disparar(i);
                }
                if(eleccion_disparo == 3){
                    System.out.println("Zentraedi dispara");
                    disparo_enemigo(i);
                }
                if(eleccion_disparo == 4){
                    System.out.println("Ambos disparan");
                    disparar(i);
                    disparo_enemigo(i);
                }
            }
        }
    }
    public void disparar(int enemigo_seleccionado){
        int arma_seleccionada;
        int porcentaje = 0;
        float dano;
        float dano_final;
        System.out.println("Armas disponibles");
        if(getEstado() == 1){
            if(getValkirie().getArray_armas_fighter().get(0).isPresente()){
                System.out.println("Arma cañón fuselaje (Presione botón 0)");
            }
            if(getValkirie().getArray_armas_fighter().get(1).isPresente()){
                System.out.println("Arma laser fuselaje (Presione botón 1)");
            }
            if(getValkirie().getArray_armas_fighter().get(2).isPresente()){
                System.out.println("Arma laser ala izquierda (Presione botón 2)");
            }
            if(getValkirie().getArray_armas_fighter().get(3).isPresente()){
                System.out.println("Arma laser ala derecha (Presione botón 3)");
            }
        }
        if(getEstado() == 2){
            if(getValkirie().getArray_armas_fighter().get(0).isPresente()){
                System.out.println("Arma cañón fuselaje (Presione botón 0)");
            }
            if(getValkirie().getArray_armas_fighter().get(4).isPresente()){
                System.out.println("Arma laser brazo izquierdo (Presione botón 4)");
            }
            if(getValkirie().getArray_armas_fighter().get(5).isPresente()){
                System.out.println("Arma laser brazo derecho (Presione botón 5)");
            }
        }
        if(getEstado() == 3){
            if(getValkirie().getArray_armas_fighter().get(4).isPresente()){
                System.out.println("Arma cañón brazo izquierdo (Presione botón 4)");
            }
            if(getValkirie().getArray_armas_fighter().get(5).isPresente()){
                System.out.println("Arma cañón brazo derecho (Presione botón 5)");
            }
        }
        arma_seleccionada = lector.nextInt();
        if (getEstado() == 1) {
            while((!getValkirie().getArray_armas_fighter().get(arma_seleccionada).isPresente() || arma_seleccionada > 3)){
                System.out.println("Intenta nuevamente");
                arma_seleccionada = lector.nextInt();
            }
        }
        if (getEstado() == 2){
            while ((!getValkirie().getArray_armas_fighter().get(arma_seleccionada).isPresente()) || (arma_seleccionada != 0 && arma_seleccionada != 4 && arma_seleccionada != 5)){
                System.out.println("Intente nuevamente");
                arma_seleccionada = lector.nextInt();
            }
        }
        if (getEstado() == 3){
            while ((!getValkirie().getArray_armas_fighter().get(arma_seleccionada).isPresente()) || (arma_seleccionada != 4 && arma_seleccionada != 5)){
                System.out.println("Intente nuevamente");
                arma_seleccionada = lector.nextInt();
            }
        }
        dano = Math.abs(aleatorio.nextInt() % 10) + 1;
        getValkirie().getArray_armas_fighter().get(arma_seleccionada).setDano_disparo(dano);
        System.out.print("Dispara " + getValkirie().getArray_armas_fighter().get(arma_seleccionada).getNombre() + " Daño efectuado : " + dano);
        if(calculo_distancia_hacia_enemigo(enemigo_seleccionado) <= 200 && calculo_distancia_hacia_enemigo(enemigo_seleccionado) > 150){
            porcentaje = -calculo_de_porcentaje(21, 10);
            System.out.print(" - " + Math.abs(porcentaje) + "%");
        }
        if(calculo_distancia_hacia_enemigo(enemigo_seleccionado) <= 150 && calculo_distancia_hacia_enemigo(enemigo_seleccionado) > 100){
            porcentaje = -calculo_de_porcentaje(21, 0);
            System.out.print(" - " + Math.abs(porcentaje) + "%");
        }
        if(calculo_distancia_hacia_enemigo(enemigo_seleccionado) <= 100 && calculo_distancia_hacia_enemigo(enemigo_seleccionado) > 50){
            porcentaje = calculo_de_porcentaje(11, 0);
            System.out.print( " + " + Math.abs(porcentaje) + "%");
        }
        if(calculo_distancia_hacia_enemigo(enemigo_seleccionado) <= 50 && calculo_distancia_hacia_enemigo(enemigo_seleccionado) >= 0){
            porcentaje = calculo_de_porcentaje(21, 10);
            System.out.print(" + " + Math.abs(porcentaje) + "%");
        }
        dano_final = dano * (porcentaje+100) / 100;
        getValkirie().getArray_armas_fighter().get(enemigo_seleccionado).setDano_disparo(dano_final);
        getRobots_zentraedi().get(enemigo_seleccionado).setIndicador_resistencia(getRobots_zentraedi().get(enemigo_seleccionado).getIndicador_resistencia() - dano_final);
        System.out.println(" : " + dano_final);
        if(getRobots_zentraedi().get(enemigo_seleccionado).getIndicador_resistencia() > 0) {
            System.out.println("Zentraedi " + enemigo_seleccionado + " Resistencia: " +  getRobots_zentraedi().get(enemigo_seleccionado).getIndicador_resistencia());
        }
        if(getRobots_zentraedi().get(enemigo_seleccionado).getIndicador_resistencia() <= 0){
            getRobots_zentraedi().remove(enemigo_seleccionado);
            System.out.println("Zentraedi " + enemigo_seleccionado + " Ha sido destruido");
        }
    }
    public void disparo_enemigo(int enemigo_seleccionado) {
        int arma_enemiga_aleatoria;
        boolean acerto;
        arma_enemiga_aleatoria = Math.abs(aleatorio.nextInt() % 2) + 1;
        acerto = false;
        if (arma_enemiga_aleatoria == 1) {
            System.out.println(getRobots_zentraedi().get(enemigo_seleccionado).getCanon_1().getNombre() + " " + enemigo_seleccionado + " Ha disparado");
            getRobots_zentraedi().get(enemigo_seleccionado).getCanon_1().setDano_disparo(Math.abs(aleatorio.nextInt() % 10) + 1);
            System.out.println("Daño disparo : " + getRobots_zentraedi().get(enemigo_seleccionado).getCanon_1().getDano_disparo());
        }
        if (arma_enemiga_aleatoria == 2) {
            System.out.println(getRobots_zentraedi().get(enemigo_seleccionado).getCanon_2().getNombre() + " " + enemigo_seleccionado + " Ha disparado");
            getRobots_zentraedi().get(enemigo_seleccionado).getCanon_2().setDano_disparo(Math.abs(aleatorio.nextInt() % 10) + 1);
            System.out.println("Daño disparo : " + getRobots_zentraedi().get(enemigo_seleccionado).getCanon_2().getDano_disparo());
        }
        while (!acerto) {
            if (arma_enemiga_aleatoria == 1) {
                acerto = encontrar_parte_valkirie(acerto, getRobots_zentraedi().get(enemigo_seleccionado).getCanon_1().getDano_disparo());
            }
            if (arma_enemiga_aleatoria == 2) {
                acerto = encontrar_parte_valkirie(acerto, getRobots_zentraedi().get(enemigo_seleccionado).getCanon_2().getDano_disparo());
            }
        }
    }
    public boolean encontrar_parte_valkirie(boolean acerto, float dano_disparo){
        int parte_valkirie_aleatoria;
        parte_valkirie_aleatoria = Math.abs(aleatorio.nextInt() % 8);
        if (parte_valkirie_aleatoria == 0 && getValkirie().getAla_izquierda().isPresente() && getValkirie().getAla_izquierda().getIndicador_resistencia() > 0) {
            getValkirie().getAla_izquierda().setIndicador_resistencia(getValkirie().getAla_izquierda().getIndicador_resistencia() - dano_disparo);
            if(getValkirie().getAla_derecha().getIndicador_resistencia() > 0){
                System.out.println("Indicador resistencia de Ala izquierda : " + getValkirie().getAla_izquierda().getIndicador_resistencia());
            }
            if(getValkirie().getAla_izquierda().getIndicador_resistencia() < 0){
                getValkirie().getAla_izquierda().setIndicador_resistencia(0);
                System.out.println("Ala izquierda ha sido destruida");
                getValkirie().getArray_armas_fighter().get(2).setPresente(false);
            }
            acerto = true;
        }
        if (parte_valkirie_aleatoria == 1 && getValkirie().getAla_derecha().isPresente() && getValkirie().getAla_derecha().getIndicador_resistencia() > 0) {
            getValkirie().getAla_derecha().setIndicador_resistencia(getValkirie().getAla_derecha().getIndicador_resistencia() - dano_disparo);
            if(getValkirie().getAla_derecha().getIndicador_resistencia() > 0){
                System.out.println("Indicador resistencia de Ala derecha : " + getValkirie().getAla_derecha().getIndicador_resistencia());
            }
            if(getValkirie().getAla_derecha().getIndicador_resistencia() < 0){
                getValkirie().getAla_derecha().setIndicador_resistencia(0);
                System.out.println("Ala derecha ha sido destruida");
                getValkirie().getArray_armas_fighter().get(3).setPresente(false);
            }
            acerto = true;
        }
        if (parte_valkirie_aleatoria == 2 && getValkirie().getBrazo_izquierdo().isPresente() && getValkirie().getBrazo_izquierdo().getIndicador_resistencia() > 0) {
            getValkirie().getBrazo_izquierdo().setIndicador_resistencia(getValkirie().getBrazo_izquierdo().getIndicador_resistencia() - dano_disparo);
            if(getValkirie().getBrazo_izquierdo().getIndicador_resistencia() > 0){
                System.out.println("Indicador resistencia de Brazo izquierdo: " + getValkirie().getBrazo_izquierdo().getIndicador_resistencia());
            }
            if(getValkirie().getBrazo_izquierdo().getIndicador_resistencia() < 0){
                getValkirie().getBrazo_izquierdo().setIndicador_resistencia(0);
                System.out.println("Brazo izquierdo ha sido destruido");
                getValkirie().getArray_armas_fighter().get(4).setPresente(false);
            }
            acerto = true;
        }
        if (parte_valkirie_aleatoria == 3 && getValkirie().getBrazo_derecho().isPresente() && getValkirie().getBrazo_derecho().getIndicador_resistencia() > 0) {
            getValkirie().getBrazo_derecho().setIndicador_resistencia(getValkirie().getBrazo_derecho().getIndicador_resistencia() - dano_disparo);
            if(getValkirie().getBrazo_derecho().getIndicador_resistencia() > 0) {
                System.out.println("Indicador resistencia de Brazo Derecho : " + getValkirie().getBrazo_derecho().getIndicador_resistencia());
            }
            if(getValkirie().getBrazo_derecho().getIndicador_resistencia() < 0){
                getValkirie().getBrazo_derecho().setIndicador_resistencia(0);
                System.out.println("Brazo derecho ha sido destruido");
                getValkirie().getArray_armas_fighter().get(5).setPresente(false);
            }
            acerto = true;
        }
        if (parte_valkirie_aleatoria == 4 && getValkirie().getFuselaje_robot().isPresente() && getValkirie().getFuselaje_robot().getIndicador_resistencia() > 0) {
            getValkirie().getFuselaje_robot().setIndicador_resistencia(getValkirie().getFuselaje_robot().getIndicador_resistencia() - dano_disparo);
            if(getValkirie().getFuselaje_robot().getIndicador_resistencia() > 0){
                System.out.println("Indicador resistencia de Fuselaje : " + getValkirie().getFuselaje_robot().getIndicador_resistencia());
            }
            if(getValkirie().getFuselaje_robot().getIndicador_resistencia() < 0){
                getValkirie().getFuselaje_robot().setIndicador_resistencia(0);
                System.out.println("Fuselaje ha sido destruido");
                getValkirie().getArray_armas_fighter().get(0).setPresente(false);
                getValkirie().getArray_armas_fighter().get(1).setPresente(false);
            }
            acerto = true;
        }
        if (parte_valkirie_aleatoria == 5 && getValkirie().getPierna_izquierda().isPresente() && getValkirie().getPierna_izquierda().getIndicador_resistencia() > 0) {
            getValkirie().getPierna_izquierda().setIndicador_resistencia(getValkirie().getPierna_izquierda().getIndicador_resistencia() - dano_disparo);
            if(getValkirie().getPierna_izquierda().getIndicador_resistencia() > 0){
                System.out.println("Indicador resistencia de Pierna izquierda : " + getValkirie().getPierna_izquierda().getIndicador_resistencia());
            }
            if(getValkirie().getPierna_izquierda().getIndicador_resistencia() < 0){
                getValkirie().getPierna_izquierda().setIndicador_resistencia(0);
                System.out.println("Pierna izquierda ha sido destruida");
            }
            acerto = true;
        }
        if (parte_valkirie_aleatoria == 6 && getValkirie().getPierna_derecha().isPresente() && getValkirie().getPierna_derecha().getIndicador_resistencia() > 0) {
            getValkirie().getPierna_derecha().setIndicador_resistencia(getValkirie().getPierna_derecha().getIndicador_resistencia() - dano_disparo);
            if(getValkirie().getPierna_derecha().getIndicador_resistencia() > 0){
                System.out.println("Indicador resistencia de Pierna Derecha : " + getValkirie().getPierna_derecha().getIndicador_resistencia());
            }
            if(getValkirie().getPierna_derecha().getIndicador_resistencia() < 0){
                getValkirie().getPierna_derecha().setIndicador_resistencia(0);
                System.out.println("Pierna derecha ha sido destruida");
            }
            acerto = true;
        }
        if (parte_valkirie_aleatoria == 7 && getValkirie().getCabeza_robot().isPresente() && getValkirie().getCabeza_robot().getIndicador_resistencia() > 0) {
            getValkirie().getCabeza_robot().setIndicador_resistencia(getValkirie().getCabeza_robot().getIndicador_resistencia() - dano_disparo);
            if(getValkirie().getCabeza_robot().getIndicador_resistencia() > 0){
                System.out.println("Indicador resistencia de Cabeza: " + getValkirie().getCabeza_robot().getIndicador_resistencia());
            }
            if(getValkirie().getCabeza_robot().getIndicador_resistencia() < 0){
                getValkirie().getCabeza_robot().setIndicador_resistencia(0);
                System.out.println("Cabeza ha sido destruida");
            }
            acerto = true;
        }
        return acerto;
    }
    //Función encargada de retroceder sobre el eje x hasta que no haya enemigos
    public void escapar(){
        for (int i = 0 ; i < getRobots_zentraedi().size() ; i++) {
            while (Math.sqrt(Math.pow(getRobots_zentraedi().get(i).getPosicion_eje_x() - getValkirie().getPosicion_eje_x(), 2) +
                    Math.pow(getRobots_zentraedi().get(i).getPosicion_eje_y() - getValkirie().getPosicion_eje_y(), 2) +
                    Math.pow(getRobots_zentraedi().get(i).getPosicion_eje_z() - getValkirie().getPosicion_eje_z(), 2)) <= 200) {
                getValkirie().setPosicion_eje_x(getValkirie().getPosicion_eje_x() - 50);
            }
            getEnemigos_detectados()[i] = false;
        }
    }
    //Funciones que retornan información importante para conocer el valor ponderado del disparo con los porcentajes requeridos
    public void recuperar_resistencia(){
        System.out.println("RESISTENCIA RECUPERADA");
        getValkirie().getAla_izquierda().setIndicador_resistencia(10);
        getValkirie().getAla_derecha().setIndicador_resistencia(10);
        getValkirie().getFuselaje_robot().setIndicador_resistencia(10);
        getValkirie().getPierna_izquierda().setIndicador_resistencia(10);
        getValkirie().getPierna_derecha().setIndicador_resistencia(10);
        getValkirie().getBrazo_izquierdo().setIndicador_resistencia(10);
        getValkirie().getBrazo_derecho().setIndicador_resistencia(10);
        getValkirie().getCabeza_robot().setIndicador_resistencia(10);
    }
}
