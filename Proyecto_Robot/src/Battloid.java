import java.util.ArrayList;
import java.util.Scanner;
public class Battloid {
    Scanner lector = new Scanner(System.in);
    //Funciónes que mueven el modo Robot y deriva a disparar.
    public int caminar(Robot valkirie){
        String pierna_seleccionada = " ";
        int distancia = 0;
        while(!pierna_seleccionada.equalsIgnoreCase("s")) {
            System.out.println("Presione a para avanzar con la pierna izquierda\nPresione d para avanzar con la pierna derecha\nPresione s para detenerse\n Distancia: " + distancia);
            pierna_seleccionada = lector.nextLine();
            if (pierna_seleccionada.equalsIgnoreCase("a") && !valkirie.getPierna_izquierda().isAvanzada()) {
                System.out.println("Izquierda");
                valkirie.getPierna_izquierda().setAvanzada(true);
                valkirie.getPierna_derecha().setAvanzada(false);
                distancia = distancia + 5;
            }
            if (pierna_seleccionada.equalsIgnoreCase("d") && !valkirie.getPierna_derecha().isAvanzada()) {
                System.out.println("Derecha");
                valkirie.getPierna_izquierda().setAvanzada(false);
                valkirie.getPierna_derecha().setAvanzada(true);
                distancia = distancia + 5;
            }
        }
        return distancia;
    }
    public int movimiento(int estado, Robot valkirie, Escenario escenario, ArrayList<Robot_Enemigo> Robots_zentraedi){
        String accion_seleccionada;
        valkirie.setPosicion_eje_z(0);
        System.out.println("Presione 'x' para consultar la posicion de las pistas - Presione 'm' para mostrar mapa - Presione 'z' para consultar la posición del enemigo - Presione 'v' para consultar los indicadores de vida");
        System.out.println("Posición (" + valkirie.getPosicion_eje_x() + " ," + valkirie.getPosicion_eje_y() +  " ," + valkirie.getPosicion_eje_z() + ")");
        System.out.println("/Presione 'i - k - j - l' para moverse)");
        System.out.println("/Presione 'g' para cambiar a modo Gerwalk");
        if (valkirie.isDetectando_enemigo_zentraedi()) {
            System.out.println("/Presione 'p' para combatir");
            System.out.println("/Presione 't' para escapar");
        }
        accion_seleccionada = lector.nextLine();
        if (accion_seleccionada.equalsIgnoreCase("i")) {
            valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() + caminar(valkirie));
        }
        if (accion_seleccionada.equalsIgnoreCase("k")) {
            valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() - caminar(valkirie));
        }
        if (accion_seleccionada.equalsIgnoreCase("j")) {
            valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() - caminar(valkirie));
        }
        if (accion_seleccionada.equalsIgnoreCase("l")) {
            valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() + caminar(valkirie));
        }
        if (accion_seleccionada.equalsIgnoreCase("g")){
            estado = 2;
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