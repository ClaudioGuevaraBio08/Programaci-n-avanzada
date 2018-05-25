import java.util.Scanner;
import java.util.ArrayList;

public class Controlador {

    public void Controlador()
    {
        Scanner lector = new Scanner(System.in);
        ArrayList<Preguntas> Prueba = new ArrayList<Preguntas>();
        int []seleccionar = new int[5];

        int total;
        int selecc;
        String pregunta;

        System.out.println("Cuantas preguntas le va a ingresar : ");
        total=lector.nextInt();
        while (total<5)
        {
            System.out.println("Ingrese por lo menos 5 preguntas : ");
            total=lector.nextInt();
        }
        lector.nextLine();
        for (int i=0;i<total;i=i+1)
        {
            System.out.println("Ingrese la pregunta : ");
            pregunta=lector.nextLine();
            Preguntas preguntas = new Preguntas(pregunta);
            Prueba.add(preguntas);
        }

        for (int i=0;i<5;i=i+1)
        {
            System.out.println("Que preguntas va a seleccionar : ");
            selecc=lector.nextInt();
            seleccionar[i]=selecc;
        }

        for (int i=0;i<5;i=i+1)
        {
            System.out.println("PRUEBA");
            System.out.println("Pregunta seleccionada : " + Prueba.get(seleccionar[i]).pregunta);
            System.out.println("Puntaje de la pregunta :  " + Prueba.get(seleccionar[i]).puntaje);
        }
    }

}
