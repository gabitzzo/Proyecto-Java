public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }
//Equipo1
    public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
    }
//Equipo2
	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
//GolesEquipo1
	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}
//GolesEquipo2
	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

//Método resultados
    public ResultadoEnum resultado(Equipo equipo){
        if(equipo1.getNombre().equals(equipo.getNombre())){
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
        else if(equipo2.getNombre().equals(equipo.getNombre())){
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