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
        if (valkirie.getPosición_eje_z() == 0) {
            valkirie.setVelocidad(0);
            System.out.println("Presione a para avanzar con la pierna izquierda\nPresione d para avanzar con la pierna derecha\nPresione w para subir\nPresione b para cambiar a modo Battloid\nPresione p para disparar\nAltura: "+valkirie.getPosición_eje_z() + " Distancia: " + valkirie.getDistancia());
            comando=lector.nextLine();
            if(comando.equalsIgnoreCase("a") && !valkirie.getPierna_izquierda().isAvanzada()){
                System.out.println("Izquierda");
                valkirie.getPierna_izquierda().setAvanzada(true);
                valkirie.getPierna_derecha().setAvanzada(false);
                valkirie.setDistancia(valkirie.getDistancia() + 1);
            }
            if(comando.equalsIgnoreCase("d") && !valkirie.getPierna_derecha().isAvanzada()){
                System.out.println("Derecha");
                valkirie.getPierna_izquierda().setAvanzada(false);
                valkirie.getPierna_derecha().setAvanzada(true);
                valkirie.setDistancia(valkirie.getDistancia() + 1);
            }
            if(comando.equalsIgnoreCase("b")){
                estado = 3;
            }
            if(comando.equalsIgnoreCase("p")){
                estado = 4;
            }
            if(comando.equalsIgnoreCase("w")){
                valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
            }
        }
        if (valkirie.getPosición_eje_z() > 0 && valkirie.getPosición_eje_z() <= 200) {
            if(valkirie.getVelocidad() == 0) {
                System.out.println("Presione a para acelerar\nPreseione w para subir\nPresione s para bajar\nPresione f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad()+ " Altura : " + valkirie.getPosición_eje_z());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                }
                else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                }
                else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
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
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getPosición_eje_z());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                }
                else if (comando.equalsIgnoreCase("d")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                }
                else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                }
                else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
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
                System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getPosición_eje_z());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("d")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                }
                else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                }
                else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
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
        if(valkirie.getPosición_eje_z() > 200) {
            if(valkirie.getVelocidad() == 0) {
                System.out.println("Presione a para acelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad()+ " Altura : " + valkirie.getPosición_eje_z());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                }
                else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                }
                else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
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
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getPosición_eje_z());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                }
                else if (comando.equalsIgnoreCase("d")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                }
                else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                }
                else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
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
                System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona f para cambiar a modo Fighter\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getPosición_eje_z());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("d")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                }
                else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                }
                else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
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
        return estado;
    }
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
