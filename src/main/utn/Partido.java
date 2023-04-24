
public class Partido {
    private String nombre;
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipo3;
    private Equipo equipo4;
    private int golesEquipo1;
    private int golesEquipo2;
    private int golesEquipo3;
    private int golesEquipo4;

    public Partido(Equipo equipo1, Equipo equipo2, Equipo equipo3, Equipo equipo4, int golesEquipo1, int golesEquipo2, int golesEquipo3, int golesEquipo4){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.equipo3 = equipo3;
        this.equipo4 = equipo4;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.golesEquipo3 = golesEquipo3;
        this.golesEquipo4 = golesEquipo4;
    }

    // Nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Equipo 1
    public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

    // Equipo 2
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

    // Equipo 3
	public Equipo getEquipo3() {
		return equipo3;
	}
	public void setEquipo3(Equipo equipo3) {
		this.equipo3 = equipo3;
	}

    // Equipo 4
    public Equipo getEquipo4() {
        return equipo4;
    }
    public void setEquipo4(Equipo equipo4) {
        this.equipo4 = equipo4;
    }

    // Goles Equipo 1
	public int getGolesEquipo1() {
		return golesEquipo1;
	}
	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

    // Goles Equipo 2
	public int getGolesEquipo2() {
		return golesEquipo2;
	}
	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

        // Goles Equipo 3
	public int getGolesEquipo3() {
		return golesEquipo3;
	}
	public void setGolesEquipo3(int golesEquipo3) {
		this.golesEquipo3 = golesEquipo3;
	}

        // Goles Equipo 4
	public int getGolesEquipo4() {
		return golesEquipo4;
	}
	public void setGolesEquipo4(int golesEquipo4) {
		this.golesEquipo4 = golesEquipo4;
	}

    public ResultadoEnum resultado(Equipo equipo){
        if ((equipo1.getNombre().equals(equipo.getNombre()) || equipo2.getNombre().equals(equipo.getNombre())) && golesEquipo1 == golesEquipo2) {
            return ResultadoEnum.EMPATE;
        }

        if ((equipo3.getNombre().equals(equipo.getNombre()) || equipo4.getNombre().equals(equipo.getNombre())) && golesEquipo3 == golesEquipo4) {
            return ResultadoEnum.EMPATE;
        }

        if (equipo1.getNombre().equals(equipo.getNombre())) {
            if (golesEquipo1 > golesEquipo2) {
                return ResultadoEnum.GANADOR;
            }
            else {
                return ResultadoEnum.PERDEDOR;
            }
        }
        else if (equipo2.getNombre().equals(equipo.getNombre())) {
            if(golesEquipo2 > golesEquipo1){
                return ResultadoEnum.GANADOR;
            }
            else {
                return ResultadoEnum.PERDEDOR;
            } 
        }
        else if (equipo3.getNombre().equals(equipo.getNombre())) {
            if (golesEquipo3 > golesEquipo4) {
                return ResultadoEnum.GANADOR;
            }
            else {
                return ResultadoEnum.PERDEDOR;
            }
        }
        else {
            if (golesEquipo4 > golesEquipo3) {
                return ResultadoEnum.GANADOR;
            }
            else {
                return ResultadoEnum.PERDEDOR;
            }
        }
    }
}