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
    public int movimiento(int estado, Robot valkirie, Escenario escenario){
        String accion_seleccionada;
        valkirie.setPosicion_eje_z(0);
        System.out.println("Presione 'x' para consultar la posicion de las pistas - Presione 'm' para mostrar mapa - Presione 'z' para consultar la posición del enemigo");
        System.out.println("Posición (" + valkirie.getPosicion_eje_x() + " ," + valkirie.getPosicion_eje_y() +  " ," + valkirie.getPosicion_eje_z() + ")");
        System.out.println("Utiliza 'i - k - j - l' para moverte)");
        System.out.println("Utilize g para cambiar a modo Gerwalk\nUtilize p para disparar");
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
        if(accion_seleccionada.equalsIgnoreCase("g")){
            estado = 2;
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
        int arma_seleccionada;
        System.out.println("Armas disponibles");
        if(valkirie.array_armas_fighter.get(4).isPresente()){
            System.out.println("Arma cañón brazo izquierdo (Presione botón 5)");
        }
        if(valkirie.array_armas_fighter.get(5).isPresente()){
            System.out.println("Arma cañón brazo derecho (Presione botón 6)");
        }
        arma_seleccionada = lector.nextInt();
        if ((arma_seleccionada != 5 && arma_seleccionada != 6) || (!valkirie.array_armas_fighter.get(arma_seleccionada-1).isPresente())){
            System.out.println("Intente nuevamente");
            arma_seleccionada = lector.nextInt();
        }
        valkirie.getArray_armas_fighter().get(arma_seleccionada-1).disparo();
    }
}