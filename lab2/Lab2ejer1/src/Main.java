import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner lector = new Scanner(System.in);
        String nombre,sangre;
        int peso,altura,BMI;
        int fichas;
        int contador=0;

        System.out.println("Cuantas fichas va a ingresar?");
        fichas=lector.nextInt();
        while(fichas>20)
        {
            System.out.println("Recuerde que solo puede ingresar 20 fichas como maximo");
            fichas=lector.nextInt();
        }

        Container c = new Container();

        while(contador<fichas)
        {
            lector.nextLine();
            System.out.println("Ingrese el nombre del paciente");
            nombre=lector.nextLine();
            System.out.println("Ingrese el tipo de sangre del paciente");
            sangre=lector.nextLine();
            System.out.println("Ingre el peso del paciente");
            peso=lector.nextInt();
            System.out.print("Ingrese la altura del paciente");
            altura=lector.nextInt();
            System.out.println("Ingrese el BMI del paciente");
            BMI=lector.nextInt();
            Ficha x = new Ficha(nombre,sangre,peso,altura,BMI);
            c.Agregar_fichas(x);
            contador=contador+1;
            System.out.println("el contador"+contador);
            c.mostar_fichas();
        }
    }
}
