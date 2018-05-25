import java.util.ArrayList;
import java.util.Scanner;

public class Contenedor {
    Scanner lector = new Scanner(System.in);
    ArrayList<Autos> Contenedor = new ArrayList<Autos>();

    int tipo;

    Contenedor()
    {
       for (int i=0; i<10; i=i+1)
       {
           System.out.println("Ingrese el tipo de auto que quiere");
           tipo=lector.nextInt();
           while (tipo!=1 && tipo!=2 && tipo!=3)
           {
               System.out.println("Ingrese el tipo de auto que quiere");
               tipo=lector.nextInt();
           }
           if (tipo==1)
           {
               Contenedor.add(new Autos("Peugeot 207",40));
           }
           if (tipo==2)
           {
               Contenedor.add(new Autos("Mazda 2",20));
           }
           if (tipo==3)
           {
               Contenedor.add(new Autos("Jeep Full",60));
           }
       }
    }


}
