public class Juego {
    private Controlador controlador;
    Juego(){
        controlador = new Controlador();
    }
    public Controlador getControlador() {
        return controlador;
    }
    public void jugar(){
        getControlador().getEscenario().crear_escenario();
        getControlador().getEscenario().crear_pistas();
        getControlador().escojer_armas_robot();
        getControlador().control_valkirie();
    }
}
