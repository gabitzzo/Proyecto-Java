public class Pronostico {
    Partido partido;
    Equipo equipo;
    ResultadoEnum resultado;

    public int puntos(int punto){
        if(ResultadoEnum.ganador == resultado){
            punto += 3;
        }
        else if(ResultadoEnum.empate == resultado){
            punto += 1;
        }
        else{
            punto += 0;
        }
        return punto;
    }
}
