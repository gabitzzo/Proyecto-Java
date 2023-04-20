
public class Pronostico {
    private Equipo equipo;
    private ResultadoEnum resultadoConstante;
    private Partido partido;

    private Equipo equipo1;
    private Equipo equipo2;

    // Resultado Constante
	public ResultadoEnum getResultadoConstante() {
		return resultadoConstante;
	}
    public void setResultadoConstante(ResultadoEnum resultadoConstante) {
		this.resultadoConstante = resultadoConstante;
	}
    

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultadoConstante, Equipo equipo1, Equipo equipo2) {
        this.partido = partido;
        this.equipo = equipo;

        this.resultadoConstante = resultadoConstante;

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public int puntos() {
		if (resultadoConstante == partido.resultado(equipo)) {
			return 1;
		} else {
			return 0;
		}
    }
}