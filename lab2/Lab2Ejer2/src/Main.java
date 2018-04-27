import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner lector = new Scanner(System.in);

        String color,duenio;
        int longitud;

        System.out.println("RANA 1");
        System.out.println("Ingrese el color de la primera rana : ");
        color=lector.nextLine();
        System.out.println("Ingrese el dueño de la primera rana : ");
        duenio=lector.nextLine();

        Rana rana1 = new Rana(color,duenio);

        System.out.println("\nRANA 2");
        System.out.println("Ingrese el color de la segunda rana : ");
        color=lector.nextLine();
        System.out.println("Ingrese el dueño de la segunda rana : ");
        duenio=lector.nextLine();

        Rana rana2 = new Rana(color,duenio);

        System.out.println("\nIngrese la longitud de los carriles : ");
        longitud=lector.nextInt();
        while(longitud!=15 && longitud!=20 && longitud!=30)
        {
            System.out.println("Ingrese la longitud de los carriles, recuerde que solo pueden ser de " +
                    "15, 20 o 30 metros : ");
            longitud=lector.nextInt();
        }

        Carrera apuesta = new Carrera(longitud);
        System.out.println("La carrera se realizara en un carril de : "+apuesta.getLongitud()+"metros");
        System.out.println("\nLA CARRERA DA INICIO!!!");

        while(rana1.getDistancia()<longitud && rana2.getDistancia()<longitud)
        {
            rana1.Salto_Rana(longitud);
            System.out.println("La distancia recorrida por la rana 1 es : "+rana1.getDistancia());
            rana2.Salto_Rana(longitud);
            System.out.println("CONTADOR : "+rana1.getContador());
            System.out.println("La distancia recorrida por la rana 2 es : "+rana2.getDistancia());
            System.out.println("\n");
            System.out.println("CONTADOR : "+rana2.getContador());
        }

        if(rana1.getContador()<rana2.getContador())
        {
            Carrera ganador = new Carrera("Rana 1",rana1.getColor());
            System.out.println("La rana ganador es : "+ganador.getGanador()+", de color : "+ganador.getColor());
        }
        if(rana2.getContador()<rana1.getContador())
        {
            Carrera ganador = new Carrera("Rana 2",rana2.getColor());
            System.out.println("La rana ganador es : "+ganador.getGanador()+", de color : "+ganador.getColor());
        }
        if(rana1.getContador()==rana2.getContador())
        {
            System.out.println("Hubo un empate entre las ranas");
        }

    }
}
