import java.util.Scanner;
public class Controlador {

    public void Controlador()
    {
        Scanner lector = new Scanner(System.in);
        Contenedor guardar = new Contenedor();
        int arriendo;
        int total;

        for (int i=0;i<10;i=i+1)
        {
            System.out.println("Marca del auto " + guardar.Contenedor.get(i).nombre);
            System.out.println("Litros del auto " + guardar.Contenedor.get(i).litros);
            System.out.println("KM " + guardar.Contenedor.get(i).km);
        }

        System.out.println("Cuanto autos va a arrendar : ");
        total=lector.nextInt();
        for (int i=0;i<total;i=i+1)
        {
            System.out.println("Seleccione un auto que quiera arrendar");
            arriendo=lector.nextInt();
            System.out.println("Usted ha arrendado un automovil marca : " + guardar.Contenedor.get(arriendo-1).nombre);
            System.out.println("Con capacidad de combustible de : " + guardar.Contenedor.get(arriendo-1).litros);
            System.out.println("Con kilometraje de : " + guardar.Contenedor.get(arriendo-1).km);
            System.out.println("por favor al término de su jornada estacionar/devolver\n" +
                    "el automóvil en el lugar : " + (arriendo-1));

        }
    }
}
