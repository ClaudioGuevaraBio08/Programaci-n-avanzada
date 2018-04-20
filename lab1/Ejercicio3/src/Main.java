import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner lector = new Scanner(System.in);

        Viaje Taxi = new Viaje(1500);

        char boton = 'g';
        int km=0;
        int min=0;
        int Pago=0;
        System.out.println("La bajada de bandera es de : "+Taxi.getMonto());

        System.out.println("Ingrese la letra a para indicar los km y los min");
        boton=lector.nextLine().charAt(0);

        while(boton != 'a')
        {
            System.out.println("Ingrese la letra a para indicar los km y los min");
            boton=lector.nextLine().charAt(0);
        }
        km=30;
        min=20;
        Taxi.Datos(km,min);
        System.out.println("La cantidad de Km recorrido son : "+Taxi.getTotalkm());
        System.out.println("La cantiada de minutos son : "+Taxi.getTotalmin());

        System.out.println("Ingrese la letra a para indicar los km y los min");
        boton=lector.nextLine().charAt(0);

        while(boton != 'a')
        {
            System.out.println("Ingrese la letra a para indicar los km y los min");
            boton=lector.nextLine().charAt(0);
        }
        km=50;
        min=40;
        Taxi.Datos(km,min);
        System.out.println("La cantidad de Km recorrido son : "+Taxi.getTotalkm());
        System.out.println("La cantiada de minutos son : "+Taxi.getTotalmin());

        Pago=(Taxi.getMonto()+(Taxi.getTotalkm()*150)+(Taxi.getTotalmin()*60));
        System.out.println("El monto total a pagar es de : $"+Pago);

    }
}
