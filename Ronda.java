import java.util.ArrayList;
public class Ronda{
    String num;
    Partido partido;
    Pronostico pronostico;
    ArrayList<Partido> losPartidos;


    public Ronda (Partido partido, Pronostico pronostico){
        this.partido = partido;
        this.pronostico = pronostico;
    }
}