import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class Pronostico {
    private Equipo equipo;
    private ResultadoEnum resultadoConstante;
    private Partido partido;

    private Equipo equipo1;
    private Equipo equipo2;

    private int golesEquipoPrev1;
    private int golesEquipoPrev2;
    private int golesEquipo1;
    private int golesEquipo2;


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

    public int puntos(Equipo equipo, int golesEquipoPrev1, int golesEquipo1, int golesEquipoPrev2, int golesEquipo2) {
        if(equipo1.getNombre().equals(equipo.getNombre())){
            if (golesEquipoPrev1 == golesEquipo1) {
                return 1;
            } else {
                return 0;
            }
        } else if(equipo2.getNombre().equals(equipo.getNombre())){
            if (golesEquipoPrev2 == golesEquipo2) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}