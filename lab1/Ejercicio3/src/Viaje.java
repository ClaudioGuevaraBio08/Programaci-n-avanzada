public class Viaje {
    private int Monto;
    private int totalkm=0;
    private int totalmin=0;

    public Viaje(int Monto)
    {
        this.Monto=Monto;
    }

    public void Datos(int km,int min)
    {
        totalkm=totalkm+km;
        totalmin=totalmin+min;
    }

    public int getMonto()
    {
        return Monto;
    }

    public void setMonto(int monto)
    {
        Monto = monto;
    }

    public int getTotalkm()
    {
        return totalkm;
    }

    public void setTotalkm(int totalkm)
    {
        this.totalkm = totalkm;
    }

    public int getTotalmin()
    {
        return totalmin;
    }

    public void setTotalmin(int totalmin)
    {
        this.totalmin = totalmin;
    }
}
