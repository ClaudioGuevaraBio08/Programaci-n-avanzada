import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner lector = new Scanner(System.in);

        int agitar;

        System.out.println("Cuantas veces desea agitar el termometro?");
        agitar=lector.nextInt();
        while(agitar<1 || agitar>2)
        {
            System.out.println("Solo se puede agitar 1 o 2 veces el termometro");
            agitar=lector.nextInt();
        }

        Termometro Juanito = new Termometro();

        Juanito.agitar(agitar);

        Juanito.Medir_Temperatura();
    }
}
