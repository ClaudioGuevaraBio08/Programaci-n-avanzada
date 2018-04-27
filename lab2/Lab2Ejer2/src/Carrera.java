public class Carrera{
    private int longitud;
    private String ganador,color;
    private Rana ranita;

    public Carrera()
    {
        ranita=new Rana();
    }

    public Carrera(int longitud)
    {
        this.longitud=longitud;
    }
    public Carrera(String ganador,String color)
    {
        this.ganador=ganador;
        this.color=color;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getColor() {
        return color;
    }
}
