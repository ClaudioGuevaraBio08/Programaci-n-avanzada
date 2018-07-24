import java.util.Scanner;
public class Fighter {
    Scanner lector = new Scanner(System.in);
    //Movimiento y llamado a acciones
    public int movimiento(int estado, Robot valkirie, Escenario escenario, boolean se_encuentra_sobre_pista, boolean puede_despegar) {
        String accion_seleccionada;
        System.out.println("Presione 'x' para consultar la posicion de las pistas - Presione 'm' para mostrar mapa - Presione 'z' para consultar la posición del enemigo - Presione 'v' para consultar los indicadores de vida");
        System.out.println("Posición (" + valkirie.getPosicion_eje_x() + " ," + valkirie.getPosicion_eje_y() + " ," + valkirie.getPosicion_eje_z() + ")");
        System.out.println("Velocidad : " + valkirie.getVelocidad());
        if (valkirie.getPosicion_eje_z() == 0) {
            if (se_encuentra_sobre_pista) {
                System.out.println("Se encuentra sobre la pista " + escenario.getMatriz_escenario()[valkirie.getPosicion_eje_y()/50][valkirie.getPosicion_eje_x()/50]);
                if (puede_despegar) {
                    estado = 9;
                    if (valkirie.getVelocidad()<350) {
                        System.out.println("Puede despegar siempre que su velocidad sobrepase los 350 km/h");
                    }
                    else{
                        System.out.println("Puede despegar");
                    }
                }
                if (!puede_despegar) {
                    System.out.println("La pista no tiene largo suficiente, no puede despegar");
                }
            }
            if (puede_despegar && valkirie.getVelocidad() >= 350) {
                System.out.println("/Presione 'w' para despegar");
            }
        }
        System.out.println("/Presione 'i - k - j - l' para moverse)");
        if (valkirie.getPosicion_eje_z() > 0){
            System.out.println("/Presione 'w' para ascender\n/Presione 's' para descender ");
        }
        if (valkirie.getVelocidad() > 0) {
            System.out.println("/Presione 'd' para desacelerar");
        }
        if (valkirie.getVelocidad() < 750) {
            System.out.println("/Presione 'a' para acelerar");
        }
        System.out.println("/Presione 'g' para cambiar a modo Gerwalk");
        if (valkirie.getPosicion_eje_z() <= 200 && valkirie.getPosicion_eje_z() > 0){
            System.out.println("/Presione 'b' para cambiar a modo Battloid");
        }
        if (valkirie.isDetectando_enemigo_zentraedi()){
            System.out.println("/Presione 'p' para combatir");
            System.out.println("/Presione 't' para escapar");
        }
        accion_seleccionada = lector.nextLine();
        if (valkirie.getVelocidad() < 750 && accion_seleccionada.equalsIgnoreCase("a")) {
            valkirie.setVelocidad(valkirie.getVelocidad() + 50);
        }
        if (valkirie.getVelocidad() > 0 && accion_seleccionada.equalsIgnoreCase("d")) {
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
        if (valkirie.getPosicion_eje_z() == 0 && puede_despegar && valkirie.getVelocidad() >= 350 && valkirie.getVelocidad() < 750 && accion_seleccionada.equalsIgnoreCase("w")) {
            valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() + 50);
        }
        if (accion_seleccionada.equalsIgnoreCase("w") && valkirie.getPosicion_eje_z() > 0) {
            valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() + 50);
        }
        if (accion_seleccionada.equalsIgnoreCase("s") && valkirie.getPosicion_eje_z() > 0) {
            valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() - 50);
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
        if (accion_seleccionada.equalsIgnoreCase("g")) {
            estado = 2;
        }
        if (accion_seleccionada.equalsIgnoreCase("p") && valkirie.isDetectando_enemigo_zentraedi()) {
            estado = 6;
        }
        if (accion_seleccionada.equalsIgnoreCase("t") && valkirie.isDetectando_enemigo_zentraedi()){
            estado = 7;
        }
        if (valkirie.getPosicion_eje_z() <= 200 && valkirie.getPosicion_eje_z() > 0 && accion_seleccionada.equalsIgnoreCase("b")) {
            estado = 3;
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