import java.util.Scanner;
public class Fighter {
    Scanner lector = new Scanner(System.in);
    //Movimiento y llamado a acciones
    public int movimiento(int estado, Robot valkirie, Escenario escenario) {
        String accion_seleccionada;
        boolean se_encuentra_sobre_pista = false;
        boolean pista_larga = false;
        System.out.println("Presione 'x' para consultar la posicion de las pistas - Presione 'm' para mostrar mapa - Presione 'z' para consultar la posición del enemigo");
        System.out.println("Posición (" + valkirie.getPosicion_eje_x() + " ," + valkirie.getPosicion_eje_y() + " ," + valkirie.getPosicion_eje_z() + ")");
        System.out.println("Velocidad : " + valkirie.getVelocidad());
        System.out.println("Utiliza 'i - k - j - l' para moverte)");
        if (valkirie.getPosicion_eje_z() == 0) {
            for (int k = 0; k < escenario.getPistas().size(); k = k + 1) {
                if ((escenario.getPistas().get(k).getOrientacion() == 1 &&
                        valkirie.getPosicion_eje_x() >= escenario.getPistas().get(k).getPosicion_x() &&
                        valkirie.getPosicion_eje_x() <= escenario.getPistas().get(k).getPosicion_x() + escenario.getPistas().get(k).getLargo_pista() &&
                        valkirie.getPosicion_eje_y() == escenario.getPistas().get(k).getPosicion_y()) ||
                        (escenario.getPistas().get(k).getOrientacion() == 2 &&
                                valkirie.getPosicion_eje_y() >= escenario.getPistas().get(k).getPosicion_y() &&
                                valkirie.getPosicion_eje_y() <= escenario.getPistas().get(k).getPosicion_y() + escenario.getPistas().get(k).getLargo_pista()) &&
                                valkirie.getPosicion_eje_x() == escenario.getPistas().get(k).getPosicion_x()) {
                    se_encuentra_sobre_pista = true;
                    if (escenario.getPistas().get(k).getLargo_pista() > 100) {
                        pista_larga = true;
                    }
                }
            }
            if (se_encuentra_sobre_pista) {
                System.out.println("Te encuentras sobre la pista " + escenario.getMatriz_escenario()[valkirie.getPosicion_eje_y()/50][valkirie.getPosicion_eje_x()/50]);
                if (pista_larga) {
                    if(valkirie.getVelocidad()<350) {
                        System.out.println("Puedes despegar siempre que tu velocidad sobrepase los 350 km/h");
                    }
                    else{
                        System.out.println("Puedes despegar");
                    }
                }
                if (!pista_larga) {
                    System.out.println("La pista no tiene largo suficiente, no puedes despegar");
                }
            }
            if (pista_larga && valkirie.getVelocidad() >= 350) {
                System.out.println("Presione w para despegar");
            }
        }
        if(valkirie.getPosicion_eje_z() > 0){
            System.out.println("Presione w para ascender\nPresione s para descender ");
        }
        if (valkirie.getVelocidad() > 0) {
            System.out.println("Presione d para desacelerar");
        }
        if (valkirie.getVelocidad() < 750) {
            System.out.println("Presione a para acelerar");
        }
        System.out.println("Presione g para cambiar a modo Gerwalk");
        if(valkirie.getPosicion_eje_z() <= 200 && valkirie.getPosicion_eje_z() > 0){
            System.out.println("Presione b para cambiar a modo Battloid");
        }
        System.out.println("Presione p para disparar");
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
        if(valkirie.getPosicion_eje_z() == 0){
            if (valkirie.getVelocidad() < 750) {
                if (pista_larga && valkirie.getVelocidad() >= 350 && accion_seleccionada.equalsIgnoreCase("w")) {
                    valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() + 50);
                    if (escenario.getPistas().get(Integer.parseInt(escenario.getMatriz_escenario()[valkirie.getPosicion_eje_y() / 50][valkirie.getPosicion_eje_x() / 50])).getOrientacion() == 1) {
                        valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() +
                                escenario.getPistas().get(Integer.parseInt(escenario.getMatriz_escenario()[valkirie.getPosicion_eje_y() / 50][valkirie.getPosicion_eje_x() / 50])).getLargo_pista());
                    }
                    if (escenario.getPistas().get(Integer.parseInt(escenario.getMatriz_escenario()[valkirie.getPosicion_eje_y() / 50][valkirie.getPosicion_eje_x() / 50])).getOrientacion() == 2) {
                        valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() +
                                escenario.getPistas().get(Integer.parseInt(escenario.getMatriz_escenario()[valkirie.getPosicion_eje_y() / 50][valkirie.getPosicion_eje_x() / 50])).getLargo_pista());
                    }
                }
            }
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
        if (valkirie.getPosicion_eje_x() > 3000){
            valkirie.setPosicion_eje_x(3000);
        }
        if(valkirie.getPosicion_eje_y() < 0){
            valkirie.setPosicion_eje_y(0);
        }
        if(valkirie.getPosicion_eje_y() > 3000){
            valkirie.setPosicion_eje_y(3000);
        }
        if (accion_seleccionada.equalsIgnoreCase("g")) {
            estado = 2;
        }
        if (accion_seleccionada.equalsIgnoreCase("p")) {
            disparar(valkirie);
        }
        if (valkirie.getPosicion_eje_z() <= 200 && valkirie.getPosicion_eje_z() > 0 && accion_seleccionada.equalsIgnoreCase("b")) {
            estado = 3;
        }
        if(accion_seleccionada.equalsIgnoreCase("x")){
            escenario.consultar_pistas();
        }
        if(accion_seleccionada.equalsIgnoreCase("m")){
            escenario.mostrar_escenario();
        }
        if(accion_seleccionada.equalsIgnoreCase("z")){
            estado = 5;
        }
        return estado;
    }
    //Función que dispara dependiendo de qué arma escoja de entre las disponibles.
    public void disparar(Robot valkirie){
        int arma_seleccionada;
        System.out.println("Armas disponibles");
        if(valkirie.array_armas_fighter.get(0).isPresente()){
            System.out.println("Arma cañón fuselaje (Presione botón 1)");
        }
        if(valkirie.array_armas_fighter.get(1).isPresente()){
            System.out.println("Arma laser fuselaje (Presione botón 2)");
        }
        if(valkirie.array_armas_fighter.get(2).isPresente()){
            System.out.println("Arma laser ala izquierda (Presione botón 3)");
        }
        if(valkirie.array_armas_fighter.get(3).isPresente()){
            System.out.println("Arma laser ala derecha (Presione botón 4)");
        }
        arma_seleccionada = lector.nextInt();
        while((!valkirie.array_armas_fighter.get(arma_seleccionada-1).isPresente() || (arma_seleccionada<1 || arma_seleccionada>4))){
            System.out.println("Intenta nuevamente");
            arma_seleccionada = lector.nextInt();
        }
        valkirie.getArray_armas_fighter().get(arma_seleccionada).disparo();
    }
}