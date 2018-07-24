import java.util.Scanner;
public class Gerwalk {
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
    public int movimiento(int estado, Robot valkirie, Escenario escenario) {
        String accion_seleccionada;
        System.out.println("Presione 'x' para consultar la posicion de las pistas - Presione 'm' para mostrar mapa - Presione 'z' para consultar la posición del enemigo");
        System.out.println("Posición (" + valkirie.getPosicion_eje_x() + " ," + valkirie.getPosicion_eje_y() +  " ," + valkirie.getPosicion_eje_z() + ")");
        System.out.println("Velocidad : " + valkirie.getVelocidad());
        System.out.println("Utiliza 'i - k - j - l' para moverte)");
        System.out.println("Presione w para subir");
        if(valkirie.getPosicion_eje_z() > 0 ) {
            if (valkirie.getVelocidad() < 750) {
                System.out.println("Presione 'a' para acelerar");
            }
            if (valkirie.getVelocidad() > 0) {
                System.out.println("Presione 'd' para desacelerar");
            }
            System.out.println("Presione s para bajar\nPresione f para cambiar a modo Fighter");
        }
        if(valkirie.getPosicion_eje_z() <= 200){
            System.out.println("Presione b para cambiar a modo Battloid");
        }
        System.out.println("Presione p para disparar");
        accion_seleccionada = lector.nextLine();
        if(valkirie.getPosicion_eje_z() == 0){
            valkirie.setVelocidad(0);
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
        }
        if(valkirie.getPosicion_eje_z() > 0) {
            if(accion_seleccionada.equalsIgnoreCase("a") && valkirie.getVelocidad() < 750){
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
            if(accion_seleccionada.equalsIgnoreCase("s")){
                valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() - 50);
            }
            if (accion_seleccionada.equalsIgnoreCase("f")) {
                estado = 1;
            }
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
        if(valkirie.getPosicion_eje_z() <= 200 && accion_seleccionada.equalsIgnoreCase("b")){
            estado = 3;
        }
        if(accion_seleccionada.equalsIgnoreCase("w")){
            valkirie.setPosicion_eje_z(valkirie.getPosicion_eje_z() + 50);
        }
        if(accion_seleccionada.equalsIgnoreCase("p")){
            disparar(valkirie);
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
        int arma_seleccionada = 1;
        System.out.println("Armas disponibles");
        if(valkirie.array_armas_fighter.get(0).isPresente()){
            System.out.println("Arma cañón fuselaje (Presione botón 1)");
        }
        if(valkirie.array_armas_fighter.get(4).isPresente()){
            System.out.println("Arma laser brazo izquierdo (Presione botón 5)");
        }
        if(valkirie.array_armas_fighter.get(5).isPresente()){
            System.out.println("Arma laser brazo derecho (Presione botón 6)");
        }
        arma_seleccionada = lector.nextInt();
        while ((arma_seleccionada != 1 && arma_seleccionada != 5 && arma_seleccionada != 6) || (!valkirie.array_armas_fighter.get(arma_seleccionada-1).isPresente())){
            System.out.println("Intente nuevamente");
            arma_seleccionada = lector.nextInt();
        }
        valkirie.getArray_armas_fighter().get(arma_seleccionada-1).disparo();
    }
}