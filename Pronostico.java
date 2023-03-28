public class Pronostico {
    Equipo equipo;
    Partido partido;
    ResultadoEnum resultado;

    public Pronostico(Equipo equipo, ResultadoEnum resultado, Partido partido){
        this.equipo = equipo;
        this.resultado = resultado;
        this.partido = partido;
    }

    public int puntos(int punto){
        if (partido.resultado(equipo) == resultado &&  resultado == ResultadoEnum.ganador) {
            punto += 3;
        }
        else if(partido.resultado(equipo) == resultado && ResultadoEnum.empate == resultado){
            punto += 1;
        }
        else{
            punto += 0;
        }
        return punto;
    }
}