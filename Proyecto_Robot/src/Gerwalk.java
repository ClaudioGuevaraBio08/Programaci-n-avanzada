import java.util.ArrayList;
import java.util.Scanner;
public class Gerwalk {
    Scanner lector = new Scanner(System.in);
    //Funciónes que mueven el modo Robot y deriva a disparar.
    public int movimiento(int estado, Robot valkirie, Escenario escenario, Battloid modo_battloid) {
        String accion_seleccionada;
        if (valkirie.getPosicion_eje_z() == 0){
            valkirie.setVelocidad(0);
        }
        System.out.println("Presione 'x' para consultar la posicion de las pistas - Presione 'm' para mostrar mapa - Presione 'z' para consultar la posición del enemigo - Presione 'v' para consultar los indicadores de vida");
        System.out.println("Posición (" + valkirie.getPosicion_eje_x() + " ," + valkirie.getPosicion_eje_y() +  " ," + valkirie.getPosicion_eje_z() + ")");
        System.out.println("Velocidad : " + valkirie.getVelocidad());
        System.out.println("/Presione 'i - k - j - l' para moverse \n/Presione 'w' para subir");
        if (valkirie.getPosicion_eje_z() > 0 ) {
            System.out.println("/Presione 's' para bajar");
            if (valkirie.getVelocidad() < 750) {
                System.out.println("/Presione 'a' para acelerar");
            }
            if (valkirie.getVelocidad() > 0) {
                System.out.println("/Presione 'd' para desacelerar");
            }
            System.out.println("/Presione 'f' para cambiar a modo Fighter");
        }
        if (valkirie.getPosicion_eje_z() <= 200){
            System.out.println("/Presione 'b' para cambiar a modo Battloid");
        }
        if (valkirie.isDetectando_enemigo_zentraedi()) {
            System.out.println("/Presione 'p' para combatir\n/Presione 't' para escapar");
        }
        accion_seleccionada = lector.nextLine();
        if (valkirie.getPosicion_eje_z() == 0){
            valkirie.setVelocidad(0);
            if (accion_seleccionada.equalsIgnoreCase("i")) {
                valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() + modo_battloid.caminar(valkirie));
            }
            if (accion_seleccionada.equalsIgnoreCase("k")) {
                valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() - modo_battloid.caminar(valkirie));
            }
            if (accion_seleccionada.equalsIgnoreCase("j")) {
                valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() - modo_battloid.caminar(valkirie));
            }
            if (accion_seleccionada.equalsIgnoreCase("l")) {
                valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() + modo_battloid.caminar(valkirie));
            }
        }
        if (valkirie.getPosicion_eje_z() > 0) {
            if (accion_seleccionada.equalsIgnoreCase("a") && valkirie.getVelocidad() < 750){
                valkirie.setVelocidad(valkirie.getVelocidad() + 50);
            }
            if (accion_seleccionada.equalsIgnoreCase("d") && valkirie.getVelocidad() > 0) {
                valkirie.setVelocidad(valkirie.getVelocidad() - 50);
            }
            if (accion_seleccionada.equalsIgnoreCase("j")) {
                valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() - valkirie.getVelocidad());
            }
            if (accion_seleccionada.equalsIgnoreCase("l")) {
                valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() + valkirie.getVelocidad());
            }
            if (accion_seleccionada.equalsIgnoreCase("i")) {
                valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() + valkirie.getVelocidad());
            }
            if (accion_seleccionada.equalsIgnoreCase("k")) {
                valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() - valkirie.getVelocidad());
            }
            if (accion_seleccionada.equalsIgnoreCase("s")){
                valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() - 50);
            }
            if (accion_seleccionada.equalsIgnoreCase("f")) {
                estado = 1;
            }
        }
        if (valkirie.getPosicion_eje_x() < 0) {
            valkirie.setPosicion_eje_x(0);
        }
        if (valkirie.getPosicion_eje_x() > escenario.getEje_x()){
            valkirie.setPosicion_eje_x(escenario.getEje_x());
        }
        if (valkirie.getPosicion_eje_y() < 0){
            valkirie.setPosicion_eje_y(0);
        }
        if (valkirie.getPosicion_eje_y() > escenario.getEje_y()){
            valkirie.setPosicion_eje_y(escenario.getEje_y());
        }
        if (valkirie.getPosicion_eje_z() <= 200 && accion_seleccionada.equalsIgnoreCase("b")){
            estado = 3;
        }
        if (accion_seleccionada.equalsIgnoreCase("w")){
            valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() + 50);
        }
        if (accion_seleccionada.equalsIgnoreCase("p") && valkirie.isDetectando_enemigo_zentraedi()){
            estado = 6;
        }
        if (accion_seleccionada.equalsIgnoreCase("t") && valkirie.isDetectando_enemigo_zentraedi()){
            estado = 7;
        }
        if (accion_seleccionada.equalsIgnoreCase("x")){
            escenario.consultar_pistas();
        }
        if (accion_seleccionada.equalsIgnoreCase("m")){
            escenario.mostrar_escenario();
        }
        if (accion_seleccionada.equalsIgnoreCase("z")){
            estado = 5;
        }
        if (accion_seleccionada.equalsIgnoreCase("v")){
            estado = 8;
        }
        return estado;
    }
}