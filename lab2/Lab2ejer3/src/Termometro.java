import java.util.Random;

public class Termometro {
    int temperatura;
    float T1;
    float T2;
    float promedio;

    public Termometro()
    {

    }

    public void agitar(int agitan)
    {
        for(int i=0;i<agitan;i=i+1)
        {
            temperatura = (int) (Math.random() * 10 );
        }

        System.out.println("El valor inicial del termometro agitado es : "+temperatura+"°C");
    }

    public void Medir_Temperatura()
    {
        System.out.println("Juanito esta enfermo, por lo que va a medir su Temperatura : ");
        T1=35+(int)(Math.random() * (40-35));
        System.out.println("La primera medicion dio : "+T1+"°C");
        T2=35 +(int)(Math.random() * (40-35));
        System.out.println("La segunda medicon dio : "+T2+"°C");
        promedio=(T1+T2)/2;
        System.out.println("La temperatura corporal de juanito es : "+promedio);
    }
}
