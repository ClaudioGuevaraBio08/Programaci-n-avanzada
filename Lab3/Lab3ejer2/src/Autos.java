import java.util.Random;

public class Autos {
    String nombre;
    int litros;
    int km;
    boolean estaciaonado;


    Autos(String nombre,int litros)
    {
        this.nombre=nombre;
        this.litros=litros;
        km= (int) (Math.random() * 2000);
    }

    public String getNombre() {
        return nombre;
    }

    public int getLitros() {
        return litros;
    }

    public int getKm() {
        return km;
    }

    public void setEstaciaonado(boolean estaciaonado) {
        this.estaciaonado = estaciaonado;
    }
}
