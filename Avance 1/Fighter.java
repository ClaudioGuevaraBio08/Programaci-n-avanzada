import java.util.ArrayList;
import java.util.Scanner;

public class Fighter {
    Scanner lector = new Scanner(System.in);
    public void título() {
        System.out.println("MODO FIGHTER");
    }
    public int movimiento(int estado, Robot valkirie) {
        String comando = " ";
        int caso=0;
        if (valkirie.getAltura() == 0) {
            if (valkirie.getVelocidad() == 0) {
                System.out.println("Presione a para acelerar\nPresione g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    caso = 1;
                }
                else{
                    caso = 0;
                }
                if(comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() > 0 && valkirie.getVelocidad() < 350) {
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPresione g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    caso = 1;
                }
                else if (comando.equalsIgnoreCase("d")) {
                    caso = 2;
                }
                else{
                    caso = 0;
                }
                if(comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() >= 350 && valkirie.getVelocidad() < 750) {
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
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
                else {
                    caso = 0;
                }
                if(comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() == 750) {
                System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("d")) {
                    caso = 2;
                }
                else if (comando.equalsIgnoreCase("w")) {
                    caso = 3;
                }
                else {
                    caso = 0;
                }
                if(comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
        }

        if (valkirie.getAltura() > 0 && valkirie.getAltura() <= 200) {
            if (valkirie.getVelocidad() == 0) {
                System.out.println("Presione a para acelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
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
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() > 0 && valkirie.getVelocidad() < 750) {
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
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
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() == 750) {
                System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
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
                else{
                    caso = 0;
                }
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if (comando.equalsIgnoreCase("b")) {
                    estado = 3;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
        }
        if (valkirie.getAltura() > 200) {
            if (valkirie.getVelocidad() == 0) {
                System.out.println("Presione a para acelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
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
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() > 0 && valkirie.getVelocidad() < 750) {
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
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
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() == 750) {
                System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad() + " Altura : " + valkirie.getAltura());
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
                else if (comando.equalsIgnoreCase("a")) {
                    caso = 0;
                }
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
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
        if(valkirie.array_armas_fighter.get(1).isPresente() == true){
            System.out.println("Arma laser fuselaje (Presione botón 2)");
        }
        if(valkirie.array_armas_fighter.get(2).isPresente() == true){
            System.out.println("Arma laser ala izquierda (Presione botón 3)");
        }
        if(valkirie.array_armas_fighter.get(3).isPresente() == true){
            System.out.println("Arma laser ala derecha (Presione botón 4)");
        }
        arma_seleccionada = lector.nextInt();
        while((valkirie.array_armas_fighter.get(arma_seleccionada-1).isPresente() == false || (arma_seleccionada<1 && arma_seleccionada>4))){
            System.out.println("Intenta nuevamente");
            arma_seleccionada = lector.nextInt();
        }
        valkirie.getArray_armas_fighter().get(arma_seleccionada).disparo();
    }
}

