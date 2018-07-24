import java.util.Scanner;

public class Battloid {
    Scanner lector = new Scanner(System.in);
    //Función que muestra el título del modo en cada instante.
    public void titulo()
    {
        System.out.println("MODO BATTLOID");
    }
    //Función que mueve el modo Battloid y deriva a disparar.
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
    public int movimiento(int estado, Robot valkirie){
        String accion_seleccionada;
        valkirie.setPosicion_eje_z(0);
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
            estado = 4;
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
