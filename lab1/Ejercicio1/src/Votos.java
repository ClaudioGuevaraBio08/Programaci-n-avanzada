import com.sun.javafx.charts.ChartLayoutAnimator;

public class Votos {
    private String Candidato;
    private int votos;
    private int cantidad=0;


    public Votos(String Candidato)
    {
        this.Candidato=Candidato;
    }
    public Votos(int votos)
    {
        this.votos=votos;
    }


    public void Contar()
    {
        cantidad=cantidad+1;

    }

    public String getCandidato() {
        return Candidato;
    }

    public void setCandidato(String candidato) {
        Candidato = candidato;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
