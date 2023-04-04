public class Partido {
    Equipo equipo1;
    Equipo equipo2;
    int golesEquipo1;
    int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public ResultadoEnum resultado(Equipo equipo){
        if(equipo1.equals(equipo)){
            if(golesEquipo1>golesEquipo2){
                return ResultadoEnum.ganador;
            }
            else if(golesEquipo1<golesEquipo2){
                return ResultadoEnum.perdedor;
            }
            else{
                return ResultadoEnum.empate;
            }
        }
        else if(equipo2.equals(equipo)){
            if(golesEquipo2>golesEquipo1){
                return ResultadoEnum.ganador;
            }
            else if(golesEquipo2<golesEquipo1){
                return ResultadoEnum.perdedor;
            }
            else{
                return ResultadoEnum.empate;
            }   
        }
        return null;
    }
}