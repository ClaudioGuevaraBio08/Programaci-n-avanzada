import java.util.Random;

public class Rana {
    private String color,duenio;
    private Carrera Apuesta;
    private int variable,distancia;
    int contador=0;

    public Rana()
    {
        Apuesta=new Carrera();
    }

    public Rana(String color,String duenio)
    {
        this.color=color;
        this.duenio=duenio;
    }

    public void Salto_Rana(int longitud)
    {
        variable= (int) (Math.random() * 3)+1;
        distancia=distancia+variable;
        if(distancia<longitud)
        {
            contador=contador+1;
        }
    }

    public Carrera getCarrera()
    {
        return Apuesta;
    }

    public String getColor() {
        return color;
    }

    public String getDuenio() {
        return duenio;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getContador() {
        return contador;
    }
}
