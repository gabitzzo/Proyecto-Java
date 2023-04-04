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
    Equipo equipo;
    ResultadoEnum resultadoConstante;
    Partido partido;

    int golesEquipoPrev1;
    int golesEquipoPrev2;
    int golesEquipo1;

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultadoConstante) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultadoConstante = resultadoConstante;
    }

    public int puntos(int golesEquipoPrev1, int golesEquipo1) {
        if (golesEquipoPrev1 == golesEquipo1) {
            return 1;
        } else {
            return 0;
        }
    }
}