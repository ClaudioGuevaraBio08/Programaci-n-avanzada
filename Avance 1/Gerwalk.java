import java.util.Scanner;

public class Gerwalk {
    Scanner lector = new Scanner(System.in);
    //MODO GERWALK NO POSEE ATRIBUTOS (
    public void título() {
        System.out.println("MODO GERWALK");
    }
    public int movimiento(int estado, Robot valkirie) {
        int caso = 0;
        String comando = " ";
        if (valkirie.getAltura() == 0) {
            valkirie.setVelocidad(0);
            System.out.println("Presione a para avanzar con la pierna izquierda\nPresione d para avanzar con la pierna derecha\nPresione w para subir\nPresione b para cambiar a modo Battloid\nPresione p para disparar\nAltura: "+valkirie.getAltura() + " Distancia: " + valkirie.getDistancia());
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
            if(comando.equalsIgnoreCase("b")){
                estado = 3;
            }
            if(comando.equalsIgnoreCase("p")){
                estado = 4;
            }
            if(comando.equalsIgnoreCase("w")){
                caso = 3;
            }
            else{
                caso = 0;
            }
        }
        if (valkirie.getAltura() > 0 && valkirie.getAltura() <= 200) {
            if(valkirie.getVelocidad() == 0) {
                System.out.println("Presione a para acelerar\nPreseione w para subir\nPresione s para bajar\nPresione f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad()+ " Altura : " + valkirie.getAltura());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    caso = 1;
                }
                else if (comando.equalsIgnoreCase("w")) {
                    caso = 3;
                }
                else if (comando.equalsIgnoreCase("s")) {
                    caso = 4;
                }
                else {
                    caso = 0;
                }
                if (comando.equalsIgnoreCase("f")) {
                    estado = 1;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() > 0 && valkirie.getVelocidad() < 750) {
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    caso = 1;
                }
                else if (comando.equalsIgnoreCase("d")) {
                    caso = 2;
                }
                else if (comando.equalsIgnoreCase("w")) {
                    caso = 3;
                }
                else if (comando.equalsIgnoreCase("s")) {
                    caso = 4;
                }
                else{
                    caso = 0;
                }
                if (comando.equalsIgnoreCase("f")) {
                    estado = 1;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() == 750) {
                System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("d")) {
                    caso = 2;
                }
                else if (comando.equalsIgnoreCase("w")) {
                    caso = 3;
                }
                else if (comando.equalsIgnoreCase("s")) {
                    caso = 4;
                }
                else {
                    caso = 0;
                }
                if (comando.equalsIgnoreCase("f")) {
                    estado = 1;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
        }
        if(valkirie.getAltura() > 200) {
            if(valkirie.getVelocidad() == 0) {
                System.out.println("Presione a para acelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad()+ " Altura : " + valkirie.getAltura());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    caso = 1;
                }
                else if (comando.equalsIgnoreCase("w")) {
                    caso = 3;
                }
                else if (comando.equalsIgnoreCase("s")) {
                    caso = 4;
                }
                else {
                    caso = 0;
                }
                if (comando.equalsIgnoreCase("f")) {
                    estado = 1;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() > 0 && valkirie.getVelocidad() < 750) {
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    caso = 1;
                }
                else if (comando.equalsIgnoreCase("d")) {
                    caso = 2;
                }
                else if (comando.equalsIgnoreCase("w")) {
                    caso = 3;
                }
                else if (comando.equalsIgnoreCase("s")) {
                    caso = 4;
                }
                else {
                    caso = 0;
                }
                if (comando.equalsIgnoreCase("f")) {
                    estado = 1;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() == 750) {
                System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("d")) {
                    caso = 2;
                }
                else if (comando.equalsIgnoreCase("w")) {
                    caso = 3;
                }
                else if (comando.equalsIgnoreCase("s")) {
                    caso = 4;
                }
                else {
                    caso = 0;
                }
                if (comando.equalsIgnoreCase("f")) {
                    estado = 1;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
        }
        if (caso == 1) {
            valkirie.setVelocidad(valkirie.getVelocidad() + 50);
        }
        if (caso == 2) {
            valkirie.setVelocidad(valkirie.getVelocidad() - 50);
        }
        if (caso == 3) {
            valkirie.setAltura(valkirie.getAltura() + 50);
        }
        if (caso == 4) {
            valkirie.setAltura(valkirie.getAltura() - 50);
        }
        return estado;
    }
    public void disparar(Robot valkirie){
        int arma_seleccionada = 1;
        System.out.println("Armas disponibles");
        if(valkirie.array_armas_fighter.get(0).isPresente() == true){
            System.out.println("Arma cañón fuselaje (Presione botón 1)");
        }
        if(valkirie.array_armas_fighter.get(4).isPresente() == true){
            System.out.println("Arma laser brazo izquierdo (Presione botón 5)");
        }
        if(valkirie.array_armas_fighter.get(5).isPresente() == true){
            System.out.println("Arma laser brazo derecho (Presione botón 6)");
        }
        arma_seleccionada = lector.nextInt();
        while ((arma_seleccionada != 1 && arma_seleccionada != 5 && arma_seleccionada != 6) || (valkirie.array_armas_fighter.get(arma_seleccionada-1).isPresente() == false)){
            System.out.println("Intente nuevamente");
            arma_seleccionada = lector.nextInt();
        }
        valkirie.getArray_armas_fighter().get(arma_seleccionada-1).disparo();
    }
}
