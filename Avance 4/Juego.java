public class Juego {
    private Controlador controlador;
    Juego(){
        controlador = new Controlador();
    }
    public Controlador getControlador() {
        return controlador;
    }
    public void jugar(){
        getControlador().crear_enemigos_en_posiciones_random();
        getControlador().getEscenario().crear_pistas_random_y_matriz_de_escenario();
        getControlador().escojer_armas_robot();
        while(true) {
            getControlador().control_valkirie();
            getControlador().mover_robot_zentraedi_aleatorio();
            getControlador().encontrar_enemigo();
        }
    }
}
