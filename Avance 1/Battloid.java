import java.util.Scanner;

public class Battloid {
    Scanner lector = new Scanner(System.in);
    //Función que muestra el título del modo en cada instante.
    public void titulo()
    {
        System.out.println("MODO BATTLOID");
    }
    //Función que mueve el modo Battloid y deriva a disparar.
    public int movimiento(int estado, Robot valkirie){
        String comando;
        valkirie.setAltura(0);
        valkirie.setVelocidad(0);
        System.out.println("Presione a para avanzar con la pierna izquierda\nPresione d para avanzar con la pierna derecha\nPresione g para cambiar a modo Gerwalk\nPresione p para disparar\nDistancia: "+ valkirie.getDistancia());
        comando=lector.nextLine();
        if(comando.equalsIgnoreCase("a") && valkirie.getPierna_izquierda().isAvanzada()== false){
            System.out.println("Izquierda");
            valkirie.getPierna_izquierda().setAvanzada(true);
            valkirie.getPierna_derecha().setAvanzada(false);
            valkirie.setDistancia(valkirie.getDistancia()+1);
        }
        if(comando.equalsIgnoreCase("d") && valkirie.getPierna_derecha().isAvanzada() == false){
            System.out.println("Derecha");
            valkirie.getPierna_izquierda().setAvanzada(false);
            valkirie.getPierna_derecha().setAvanzada(true);
            valkirie.setDistancia(valkirie.getDistancia()+1);
        }
        if(comando.equalsIgnoreCase("g")){
            estado = 2;
        }
        if(comando.equalsIgnoreCase("p")){
            estado = 4;
        }
        return estado;
    }
    //Función que dispara dependiendo de qué arma escoja de entre las disponibles.
    public void disparar(Robot valkirie){
        int arma_seleccionada = 1;
        System.out.println("Armas disponibles");
        if(valkirie.array_armas_fighter.get(4).isPresente() == true){
            System.out.println("Arma cañón brazo izquierdo (Presione botón 5)");
        }
        if(valkirie.array_armas_fighter.get(5).isPresente() == true){
            System.out.println("Arma cañón brazo derecho (Presione botón 6)");
        }
        arma_seleccionada = lector.nextInt();
        if ((arma_seleccionada != 5 && arma_seleccionada != 6) || (valkirie.array_armas_fighter.get(arma_seleccionada-1).isPresente() == false)){
            System.out.println("Intente nuevamente");
            arma_seleccionada = lector.nextInt();
        }
        valkirie.getArray_armas_fighter().get(arma_seleccionada-1).disparo();
    }
}
