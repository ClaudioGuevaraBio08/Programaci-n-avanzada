public class Ficha {
    String nombre,sangre;
    int peso,altura,BMI;

    public Ficha(String nombre,String sangre, int peso, int altura, int BMI)
    {
        this.nombre=nombre;
        this.sangre=sangre;
        this.peso=peso;
        this.altura=altura;
        this.BMI=BMI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAltura() {
        return altura;
    }

    public int getBMI() {
        return BMI;
    }

    public int getPeso() {
        return peso;
    }

    public String getSangre() {
        return sangre;
    }
}
