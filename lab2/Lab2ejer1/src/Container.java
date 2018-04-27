import java.util.ArrayList;

public class Container {
    int contador=0;
    ArrayList<Ficha> pacientes = new ArrayList<Ficha>();

    public Container()
    {

    }
    void Agregar_fichas(Ficha x)
    {
        pacientes.add(x);
    }

    void mostar_fichas()
    {
        for (Ficha i : pacientes)
        {
            System.out.println(i.getNombre());
            System.out.println(i.getAltura());
            System.out.println(i.getBMI());
            System.out.println(i.getPeso());
            System.out.println(i.getSangre());
        }


    }
}
