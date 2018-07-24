public class Juego {
    private Controlador controlador;
    private int cantidad_enemigos;
    Juego(){
        this.cantidad_enemigos = 5;
        this.controlador = new Controlador(1, cantidad_enemigos);
    }
    public int getCantidad_enemigos() {
        return cantidad_enemigos;
    }
    public Controlador getControlador() {
        return controlador;
    }
    public void jugar(){
        getControlador().crear_enemigos_en_posiciones_random(getCantidad_enemigos());
        getControlador().getEscenario().crear_pistas_random_y_matriz_de_escenario();
        getControlador().escojer_armas_robot();
        while((getControlador().getRobots_zentraedi().size() > 0 && getControlador().getValkirie().getFuselaje_robot().getIndicador_resistencia() > 0) &&
                ((getControlador().getValkirie().getAla_izquierda().getIndicador_resistencia() * getControlador().getValkirie().getAla_derecha().getIndicador_resistencia() > 0) ||
                        (getControlador().getValkirie().getBrazo_izquierdo().getIndicador_resistencia() * getControlador().getValkirie().getBrazo_derecho().getIndicador_resistencia() *
                                getControlador().getValkirie().getPierna_izquierda().getIndicador_resistencia() * getControlador().getValkirie().getPierna_derecha().getIndicador_resistencia() *
                                getControlador().getValkirie().getCabeza_robot().getIndicador_resistencia() > 0)) && !getControlador().isDestruccion_gerwalk()) {
            getControlador().control_valkirie();
        }
        System.out.println("FIN DEL JUEGO");
        if (getControlador().getRobots_zentraedi().size() == 0){
            System.out.println("HAS GANADO");
        }
        if (getControlador().getValkirie().getFuselaje_robot().getIndicador_resistencia() == 0 ||
                ((getControlador().getValkirie().getAla_izquierda().getIndicador_resistencia() * getControlador().getValkirie().getAla_derecha().getIndicador_resistencia()== 0) &&
                        (getControlador().getValkirie().getBrazo_izquierdo().getIndicador_resistencia() * getControlador().getValkirie().getBrazo_derecho().getIndicador_resistencia() *
                                getControlador().getValkirie().getPierna_izquierda().getIndicador_resistencia() * getControlador().getValkirie().getPierna_derecha().getIndicador_resistencia() *
                                getControlador().getValkirie().getCabeza_robot().getIndicador_resistencia() == 0)) || getControlador().isDestruccion_gerwalk()){
            System.out.println("HAS PERDIDO");
        }
    }
}