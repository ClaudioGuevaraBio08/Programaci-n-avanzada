import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner Conteo = new Scanner(System.in);

        char votos='g';
        int x=0;

        Votos Candidato1 = new Votos("Carlos Vidal");
        Votos Candidato2 = new Votos("Claudio Guevara");
        Votos Candidato3 = new Votos("Ricardo Rojas");
        Votos Nulo = new Votos("Completar");

        System.out.println("Ingrese los votos de los candidatos :(a=1) (b=2) (c=3) (D=NULO) ");
        votos=Conteo.nextLine().charAt(0);
        while(votos != 'f')
        {
            System.out.println("Ingrese los votos de los candidatos :(a=1) (b=2) (c=3) ");
            votos=Conteo.nextLine().charAt(0);
            if(votos=='a')
            {
                Candidato1.Contar();
            }
            if(votos=='b')
            {
                Candidato2.Contar();
            }
            if(votos=='c')
            {
                Candidato3.Contar();
            }
            if(votos=='d')
            {
                Nulo.Contar();
            }
            x=x+1;
        }

        if(Candidato1.getCantidad()>Candidato2.getCantidad() && Candidato1.getCantidad()>Candidato3.getCantidad())
        {
            System.out.println("¡FELICIDADES Gano el candidato 1!");
        }

        if(Candidato2.getCantidad()>Candidato1.getCantidad() && Candidato2.getCantidad()>Candidato3.getCantidad())
        {
            System.out.println("¡FELICIDADES Gano el candidato 2!");
        }

        if(Candidato3.getCantidad()>Candidato1.getCantidad() && Candidato3.getCantidad()>Candidato2.getCantidad())
        {
            System.out.println("¡FELICIDADES Gano el candidato 3!");
        }

        if(Candidato1.getCantidad()>Candidato3.getCantidad() && Candidato2.getCantidad()>Candidato3.getCantidad() && Candidato1.getCantidad()==Candidato2.getCantidad())
        {
            System.out.println("Hubo un empate entre el candidato 1 y 2");
        }

        if(Candidato1.getCantidad()>Candidato2.getCantidad() && Candidato3.getCantidad()>Candidato2.getCantidad() && Candidato1.getCantidad()==Candidato3.getCantidad())
        {
            System.out.println("Hubo un empate entre el candidato 1 y 3");
        }

        if(Candidato2.getCantidad()>Candidato1.getCantidad() && Candidato3.getCantidad()>Candidato1.getCantidad() && Candidato2.getCantidad()==Candidato3.getCantidad())
        {
            System.out.println("Hubo un empate entre el candidato 2 y3");
        }
        if(Candidato1.getCantidad()==Candidato2.getCantidad() && Candidato1.getCantidad()==Candidato3.getCantidad() && Candidato2.getCantidad()==Candidato3.getCantidad())
        {
            System.out.println("Hubo un triple empate");
        }

        System.out.println("\nEl total de votos de la eleccion es : "+x);
        System.out.println("\nEl nombre del candidato 1 es : "+Candidato1.getCandidato());
        System.out.println("La cantidad de votos del 1 es : "+Candidato1.getCantidad());
        System.out.println("\nEl nombre del candidato 2 es : "+Candidato2.getCandidato());
        System.out.println("La cantidad de votos del 2 es : "+Candidato2.getCantidad());
        System.out.println("\nEl nombre del candidato 3 es : "+Candidato3.getCandidato());
        System.out.println("La cantidad de votos del 3 es : "+Candidato3.getCantidad());
        System.out.println("\nLa cantidad de votos nulos fue de : "+Nulo.getCantidad());
    }

}
