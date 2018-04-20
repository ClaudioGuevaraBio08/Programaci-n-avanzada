import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        Scanner lector = new Scanner(System.in);
        int n;
        int numero;

        System.out.println("Este juego consciente en acertar un numero entre 1 y 20");
        System.out.println("Persona 1 ingrese su numero : ");
        n=lector.nextInt();
        Persona Persona1 = new Persona(n);
        System.out.println("Persona 2 ingrese su numero : ");
        n=lector.nextInt();
        Persona Persona2 = new Persona(n);
        System.out.println("Persona 3 ingrese su numero : ");
        n=lector.nextInt();
        Persona Persona3 = new Persona(n);

        numero = (int) (Math.random()*3)+1;

        System.out.println("EL numero al azar es : "+numero);

        if(Persona1.getNumero()==numero)
        {
            System.out.println("La persona 1 acerto!");
        }
        if(Persona2.getNumero()==numero)
        {
            System.out.println("La persona 2 acerto!");
        }
        if(Persona3.getNumero()==numero)
        {
            System.out.println("La persona 3 acerto!");
        }
        if(Persona1.getNumero()!=numero && Persona2.getNumero()!=numero && Persona3.getNumero()!=numero)
        {
            System.out.println("Todas las personas fallaron");
        }

    }

}
