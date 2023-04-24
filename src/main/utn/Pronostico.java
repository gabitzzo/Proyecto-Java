
public class Pronostico {
    private ResultadoEnum resultadoConstante;
    private Partido partido;

    public Pronostico(Partido partido, ResultadoEnum resultadoConstante) {
        this.partido = partido;
        this.resultadoConstante = resultadoConstante;
    }

    // Resultado Constante
	public ResultadoEnum getResultadoConstante() {
		return resultadoConstante;
	}
    public void setResultadoConstante(ResultadoEnum resultadoConstante) {
		this.resultadoConstante = resultadoConstante;
	}

    public int puntos(Equipo equipo) {
        if (resultadoConstante == partido.resultado(equipo)) {
            return 1;
        } else {
            return 0;
        }
    }
}