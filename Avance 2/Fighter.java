import java.util.Scanner;

public class Fighter {
    Scanner lector = new Scanner(System.in);
    public void título() {
        System.out.println("MODO FIGHTER");
    }
    public int movimiento(int estado, Robot valkirie, Escenario escenario) {
        String comando = " ";
        int caso = 0;
        boolean se_encuentra_sobre_pista = false;
        boolean pista_larga = false;
        if (valkirie.getPosición_eje_z() == 0) {
            for(int k = 0; k < escenario.getPistas().size(); k = k + 1) {
                if ((escenario.getPistas().get(k).getOrientación() == 1 &&
                    valkirie.getPosición_eje_x() >= escenario.getPistas().get(k).getPosición_x() &&
                    valkirie.getPosición_eje_x() <= escenario.getPistas().get(k).getPosición_x() + escenario.getPistas().get(k).getLargo_pista() &&
                    valkirie.getPosición_eje_y() == escenario.getPistas().get(k).getPosicion_y()) ||
                    (escenario.getPistas().get(k).getOrientación() == 2 &&
                    valkirie.getPosición_eje_y() >= escenario.getPistas().get(k).getPosicion_y() &&
                    valkirie.getPosición_eje_y() <= escenario.getPistas().get(k).getPosicion_y() + escenario.getPistas().get(k).getLargo_pista()) &&
                    valkirie.getPosición_eje_x() == escenario.getPistas().get(k).getPosición_x()) {
                    se_encuentra_sobre_pista = true;
                    if (escenario.getPistas().get(k).getLargo_pista() > 100) {;
                        pista_larga = true;
                    }
                }
            }
            if(!se_encuentra_sobre_pista) {
                System.out.println("Posición (" + valkirie.getPosición_eje_x() + " ," + valkirie.getPosición_eje_y() + ")");
                System.out.println("Utiliza 'i - k - j - l' para moverte)");
                System.out.print("Presione g para cambiar a modo Gerwalk\nPresione p para disparar\n");
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("j")) {
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                } else if (comando.equalsIgnoreCase("l")) {
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                } else if (comando.equalsIgnoreCase("i")) {
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                } else if (comando.equalsIgnoreCase("k")) {
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                }
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if (comando.equalsIgnoreCase("p")) {
                    estado = 4;
                }
            }
            if(se_encuentra_sobre_pista) {
                if(pista_larga) {
                    if (valkirie.getVelocidad() == 0) {
                        System.out.println("Posición (" + valkirie.getPosición_eje_x() + " ," + valkirie.getPosición_eje_y() + ")");
                        System.out.println("Utiliza 'i - k - j - l' para moverte)");
                        System.out.println("Presione a para acelerar\nPresione g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                        comando = lector.nextLine();
                        if (comando.equalsIgnoreCase("a")) {
                            valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                        } else if (comando.equalsIgnoreCase("j")) {
                            valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                        } else if (comando.equalsIgnoreCase("l")) {
                            valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                        } else if (comando.equalsIgnoreCase("i")) {
                            valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                        } else if (comando.equalsIgnoreCase("k")) {
                            valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                        }
                        if (comando.equalsIgnoreCase("g")) {
                            estado = 2;
                        }
                        if (comando.equalsIgnoreCase("p")) {
                            estado = 4;
                        }
                    }
                    if (valkirie.getVelocidad() > 0 && valkirie.getVelocidad() < 350) {
                        System.out.println("Posición (" + valkirie.getPosición_eje_x() + " ," + valkirie.getPosición_eje_y() + ")");
                        System.out.println("Utiliza 'i - k - j - l' para moverte)");
                        System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPresione g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                        comando = lector.nextLine();
                        if (comando.equalsIgnoreCase("a")) {
                            valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                        } else if (comando.equalsIgnoreCase("d")) {
                            valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                        } else if (comando.equalsIgnoreCase("j")) {
                            valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                        } else if (comando.equalsIgnoreCase("l")) {
                            valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                        } else if (comando.equalsIgnoreCase("i")) {
                            valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                        } else if (comando.equalsIgnoreCase("k")) {
                            valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                        }
                        if (comando.equalsIgnoreCase("g")) {
                            estado = 2;
                        }
                        if (comando.equalsIgnoreCase("p")) {
                            estado = 4;
                        }
                    }
                    if (valkirie.getVelocidad() >= 350 && valkirie.getVelocidad() < 750) {
                        System.out.println("Posición (" + valkirie.getPosición_eje_x() + " ," + valkirie.getPosición_eje_y() + ")");
                        System.out.println("Utiliza 'i - k - j - l' para moverte)");
                        System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                        comando = lector.nextLine();
                        if (comando.equalsIgnoreCase("a")) {
                            valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                        } else if (comando.equalsIgnoreCase("d")) {
                            valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                        } else if (comando.equalsIgnoreCase("j")) {
                            valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                        } else if (comando.equalsIgnoreCase("l")) {
                            valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                        } else if (comando.equalsIgnoreCase("i")) {
                            valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                        } else if (comando.equalsIgnoreCase("k")) {
                            valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                        } else if (comando.equalsIgnoreCase("w")) {
                            valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                        }
                        if (comando.equalsIgnoreCase("g")) {
                            estado = 2;
                        }
                        if (comando.equalsIgnoreCase("p")) {
                            estado = 4;
                        }
                    }
                    if (valkirie.getVelocidad() == 750) {
                        System.out.println("Posición (" + valkirie.getPosición_eje_x() + " ," + valkirie.getPosición_eje_y() + ")");
                        System.out.println("Utiliza 'i - k - j - l' para moverte)");
                        System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                        comando = lector.nextLine();
                        if (comando.equalsIgnoreCase("d")) {
                            valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                        } else if (comando.equalsIgnoreCase("j")) {
                            valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                        } else if (comando.equalsIgnoreCase("l")) {
                            valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                        } else if (comando.equalsIgnoreCase("i")) {
                            valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                        } else if (comando.equalsIgnoreCase("k")) {
                            valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                        } else if (comando.equalsIgnoreCase("w")) {
                            valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                        }
                        if (comando.equalsIgnoreCase("g")) {
                            estado = 2;
                        }
                        if (comando.equalsIgnoreCase("p")) {
                            estado = 4;
                        }
                    }
                }
                if(!pista_larga){
                    System.out.println("La pista no es suficientemente larga");
                    System.out.println("Posición (" + valkirie.getPosición_eje_x() + " ," + valkirie.getPosición_eje_y() + ")");
                    System.out.println("Utiliza 'i - k - j - l' para moverte)");
                    System.out.print("Presione g para cambiar a modo Gerwalk\nPresione p para disparar\n");
                    comando = lector.nextLine();
                    if (comando.equalsIgnoreCase("j")) {
                        valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                    } else if (comando.equalsIgnoreCase("l")) {
                        valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                    } else if (comando.equalsIgnoreCase("i")) {
                        valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                    } else if (comando.equalsIgnoreCase("k")) {
                        valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                    }
                    if (comando.equalsIgnoreCase("g")) {
                        estado = 2;
                    }
                    if (comando.equalsIgnoreCase("p")) {
                        estado = 4;
                    }
                }
            }
        }
        if (valkirie.getPosición_eje_z() > 0 && valkirie.getPosición_eje_z() <= 200) {
            if (valkirie.getVelocidad() == 0) {
                System.out.println("Utiliza 'i - k - j - l' para moverte)");
                System.out.println("Presione a para acelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                } else if(comando.equalsIgnoreCase("j")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                } else if(comando.equalsIgnoreCase("l")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                } else if(comando.equalsIgnoreCase("i")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                } else if(comando.equalsIgnoreCase("k")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                } else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                } else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
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
                System.out.println("Utiliza 'i - k - j - l' para moverte)");
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                } else if (comando.equalsIgnoreCase("d")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                } else if(comando.equalsIgnoreCase("j")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                } else if(comando.equalsIgnoreCase("l")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                } else if(comando.equalsIgnoreCase("i")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                } else if(comando.equalsIgnoreCase("k")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                } else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                } else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
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
                System.out.println("Utiliza 'i - k - j - l' para moverte)");
                System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresiona b para cambiar a modo Battloid\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("d")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                } else if(comando.equalsIgnoreCase("j")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                } else if(comando.equalsIgnoreCase("l")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                } else if(comando.equalsIgnoreCase("i")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                } else if(comando.equalsIgnoreCase("k")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                } else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                } else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
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
        if (valkirie.getPosición_eje_z() > 200) {
            if (valkirie.getVelocidad() == 0) {
                System.out.println("Utiliza 'i - k - j - l' para moverte)");
                System.out.println("Presione a para acelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                } else if(comando.equalsIgnoreCase("j")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                } else if(comando.equalsIgnoreCase("l")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                } else if(comando.equalsIgnoreCase("i")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                } else if(comando.equalsIgnoreCase("k")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                } else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                } else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
                }
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() > 0 && valkirie.getVelocidad() < 750) {
                System.out.println("Utiliza 'i - k - j - l' para moverte)");
                System.out.println("Presione a para acelerar\nPresione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("a")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() + 50);
                }
                else if (comando.equalsIgnoreCase("d")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                }
                else if(comando.equalsIgnoreCase("j")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                }
                else if(comando.equalsIgnoreCase("l")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                }
                else if(comando.equalsIgnoreCase("i")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                }
                else if(comando.equalsIgnoreCase("k")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                }
                else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                }
                else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
                }
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if(comando.equalsIgnoreCase("p")){
                    estado = 4;
                }
            }
            if (valkirie.getVelocidad() == 750) {
                System.out.println("Utiliza 'i - k - j - l' para moverte)");
                System.out.println("Presione d para desacelerar\nPreseione w para subir\nPresione s para bajar\nPresiona g para cambiar a modo Gerwalk\nPresione p para disparar\nVelocidad : " + valkirie.getVelocidad());
                comando = lector.nextLine();
                if (comando.equalsIgnoreCase("d")) {
                    valkirie.setVelocidad(valkirie.getVelocidad() - 50);
                }
                else if(comando.equalsIgnoreCase("j")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() - 10);
                }
                else if(comando.equalsIgnoreCase("l")){
                    valkirie.setPosición_eje_x(valkirie.getPosición_eje_x() + 10);
                }
                else if(comando.equalsIgnoreCase("i")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() + 10);
                }
                else if(comando.equalsIgnoreCase("k")){
                    valkirie.setPosición_eje_y(valkirie.getPosición_eje_y() - 10);
                }
                else if (comando.equalsIgnoreCase("w")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() + 50);
                }
                else if (comando.equalsIgnoreCase("s")) {
                    valkirie.setPosición_eje_z(valkirie.getPosición_eje_z() - 50);
                }
                if (comando.equalsIgnoreCase("g")) {
                    estado = 2;
                }
                if(comando.equalsIgnoreCase("p")){
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

