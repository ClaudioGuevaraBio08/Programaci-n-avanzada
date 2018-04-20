import java.util.ArrayList;

public class Conteo {
    private String Candidato;
    private ArrayList<Votos> lista = new ArrayList<Votos>();

    public Conteo (String Candidato)
    {
        this.Candidato=Candidato;
    }

    public String getCandidato() {
        return Candidato;
    }

    public void setCandidato(String candidato) {
        Candidato = candidato;
    }
}
