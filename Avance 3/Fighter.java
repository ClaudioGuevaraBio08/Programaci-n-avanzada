import java.util.Scanner;

public class Fighter {
    Scanner lector = new Scanner(System.in);

    public void título() {
        System.out.println("MODO FIGHTER");
    }

    public int movimiento_superficial(int estado, Robot valkirie, Escenario escenario) {
        String comando;
        boolean se_encuentra_sobre_pista = false;
        boolean pista_larga = false;
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
                    ;
                    pista_larga = true;
                }
            }
        }
        //MENUS
        System.out.println("Posición (" + valkirie.getPosicion_eje_x() + " ," + valkirie.getPosicion_eje_y() + ")");
        if (se_encuentra_sobre_pista) {
            System.out.println("Te encuentras sobre una pista");
            if (pista_larga) {
                System.out.println("Puedes despegar");
                System.out.println("Velocidad : " + valkirie.getVelocidad());
            }
            if (!pista_larga) {
                System.out.println("La pista no tiene largo suficiente, no puedes despegar");
            }
        }
        System.out.println("Utiliza 'i - k - j - l' para moverte)");
        if (pista_larga && valkirie.getVelocidad() > 0) {
            System.out.println("Presione d para desacelerar");
        }
        if (pista_larga && valkirie.getVelocidad() < 750) {
            System.out.println("Presione a para acelerar");
            if (valkirie.getVelocidad() >= 350) {
                System.out.println("Presione w para subir");
            }
        }
        System.out.print("Presione g para cambiar a modo Gerwalk\nPresione p para disparar\n");
        //SELECCIONES
        comando = lector.nextLine();
        if (comando.equalsIgnoreCase("j")) {
            valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() - 10);
        }
        if (comando.equalsIgnoreCase("l")) {
            valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() + 10);
        }
        if (comando.equalsIgnoreCase("i")) {
            valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() + 10);
        }
        if (comando.equalsIgnoreCase("k")) {
            valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() - 10);
        }
        if (comando.equalsIgnoreCase("d") && pista_larga && valkirie.getVelocidad() > 0) {
            valkirie.setVelocidad(valkirie.getVelocidad() - 50);
        }
        if (pista_larga && valkirie.getVelocidad() < 750) {
            if (comando.equalsIgnoreCase("a")) {
                valkirie.setVelocidad(valkirie.getVelocidad() + 50);
            }
            if (valkirie.getVelocidad() >= 350 && comando.equalsIgnoreCase("w")) {
                valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() + 50);
            }
        }
        if (comando.equalsIgnoreCase("g")) {
            estado = 2;
        }
        if (comando.equalsIgnoreCase("p")) {
            estado = 4;
        }
        return estado;
    }

    public int movimiento(int estado, Robot valkirie, Escenario escenario) {
        String comando;
        if (valkirie.getPosicion_eje_z() == 0) {
            estado = movimiento_superficial(estado, valkirie, escenario);
        }
        //MENUS
        if (valkirie.getPosicion_eje_z() > 0) {
            System.out.println("Utiliza 'i - k - j - l' para moverte)");
            System.out.println("Presione w para subir\nPresione s para bajar");
            if (valkirie.getVelocidad() >= 0 && valkirie.getVelocidad() < 750) {
                System.out.println("Presione a para acelerar");
            }
            if (valkirie.getVelocidad() < 0 && valkirie.getVelocidad() <= 750) {
                System.out.println("Presione d para desacelerar");
            }
            if (valkirie.getPosicion_eje_z() <= 200) {
                System.out.println("Presione b para cambiar a modo Battloid");
            }
            System.out.println("Presione g para cambiar a modo Gerwalk");
            System.out.println("Presione p para disparar");
            //SELECCION
            comando = lector.nextLine();
            if (comando.equalsIgnoreCase("j")) {
                valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() - 10);
            }
            if (comando.equalsIgnoreCase("l")) {
                valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() + 10);
            }
            if (comando.equalsIgnoreCase("i")) {
                valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() + 10);
            }
            if (comando.equalsIgnoreCase("k")) {
                valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() - 10);
            }
            if (comando.equalsIgnoreCase("w")) {
                valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() + 50);
            }
            if (comando.equalsIgnoreCase("s")) {
                valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() - 50);
            }
            if (valkirie.getVelocidad() >= 0 && valkirie.getVelocidad() < 750 && comando.equalsIgnoreCase("a")) {
                valkirie.setVelocidad(valkirie.getVelocidad() + 50);
            }
            if (valkirie.getVelocidad() < 0 && valkirie.getVelocidad() <= 750 && comando.equalsIgnoreCase("d")) {
                valkirie.setVelocidad(valkirie.getVelocidad() - 50);
            }
            if (valkirie.getPosicion_eje_z() <= 200 && comando.equalsIgnoreCase("b")) {
                estado = 3;
            }
            if (comando.equalsIgnoreCase("g")) {
                estado = 2;
            }
            if (comando.equalsIgnoreCase("p")) {
                estado = 4;
            }
        }
        if (valkirie.getPosicion_eje_z() > 0 && valkirie.getPosicion_eje_z() <= 200) {
            if (valkirie.getVelocidad() == 0) {
                System.out.println("Presione a para acelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                }
                if (comando.equalsIgnoreCase("j")) {
                    valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() - 10);
                }
                if (comando.equalsIgnoreCase("l")) {
                    valkirie.setPosicion_eje_x(valkirie.getPosicion_eje_x() + 10);
                }
                if (comando.equalsIgnoreCase("i")) {
                    valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() + 10);
                }
                if (comando.equalsIgnoreCase("k")) {
                    valkirie.setPosicion_eje_y(valkirie.getPosicion_eje_y() - 10);
                }
                if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() + 50);
                }
                if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() - 50);
                }
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if (comando.equalsIgnoreCase("p")) {
                    estado = 4;
                }
            }
        }
        return estado;
    }
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