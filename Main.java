import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {

        // Asignamos el archivo a una variable de tipo File
        File resultados = new File("datos.csv");
        File resultadosPrev = new File("previsto.csv");

        // Creamos un ArrayList para almacenar las línas del archivo
        List<String> lineas = new ArrayList<String>();
        List<String> lineasPrev = new ArrayList<String>();
        // Datos reales
        try {
            // Datos
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(resultados), "ISO-8859-1"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 3) { // Verificamos si la línea tiene exactamente 3 palabras
                    lineas.add(line); // Si cumple con el criterio, la agregamos a la lista
                }
            }

            // Datos previstos
            BufferedReader brPrev = new BufferedReader(new FileReader(resultadosPrev));
            String linePrev;

            while ((linePrev = brPrev.readLine()) != null) {
                String[] dataPrev = linePrev.split(",");
                if (dataPrev.length > 0 ) { // Verificamos si la línea tiene exactamente 3 palabras
                    lineasPrev.add(linePrev);
                }
            }
            brPrev.close();

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Goles de los equipos
        int golesPrev1 = Integer.parseInt(lineasPrev.get(0).split(",")[1]); // Segunda palabra de la primera línea seleccionada
        int golesPrev2 = Integer.parseInt(lineasPrev.get(1).split(",")[1]); // Segunda palabra de la segunda línea seleccionada

        // DATOS. Seleccionamos la segunda palabra de cada línea
        // Nombres de los equipos
        String nombreEquipo1 = lineas.get(0).split(",")[0]; // Primera palabra de la primera línea seleccionada
        String nombreEquipo2 = lineas.get(1).split(",")[0]; // Primera palabra de la segunda línea seleccionada
        // Goles de los equipos
        String golesEquipo1 = lineas.get(0).split(",")[1]; // Primera palabra de la primera línea seleccionada
        String golesEquipo2 = lineas.get(1).split(",")[1]; // Segunda palabra de la segunda línea seleccionada
        // Descripción de los equipos
        String descEquipo1 = lineas.get(0).split(",")[2]; // Primera palabra de la primera línea seleccionada
        String descEquipo2 = lineas.get(1).split(",")[2]; // Segunda palabra de la segunda línea seleccionada

        // Instanciamos los equipos
        Equipo equipo1 = new Equipo(nombreEquipo1, descEquipo1);
        // Le asignamos el nombre que está en info.txt

        Equipo equipo2 = new Equipo(nombreEquipo2, descEquipo2);
        // Le asignamos el nombre que está en info.txt

        ArrayList<Partido> losPartidos = new ArrayList<Partido>();

        // Instanciamos los partidos
        Partido partido1 = new Partido(equipo1, equipo2, Integer.parseInt(golesEquipo1), Integer.parseInt(golesEquipo2));

        Partido partido2 = new Partido(equipo1, equipo2, 3, 4);

        Partido partido = new Partido(equipo1, equipo2, Integer.parseInt(golesEquipo1), Integer.parseInt(golesEquipo2));
        losPartidos.add(partido);
        //Declaración del pronostico1(equipo1) y pronostico2(equipo2)
        Pronostico pronostico1 = new Pronostico(partido1, equipo1, partido1.resultado(equipo1), equipo1, equipo2);
        Pronostico pronostico2 = new Pronostico(partido1, equipo2, partido1.resultado(equipo2), equipo1, equipo2);

        //partido2 y goles(lo mismo que arriba)
        Pronostico pronostico3 = new Pronostico(partido2, equipo1, partido2.resultado(equipo1), equipo1, equipo2);
        Pronostico pronostico4 = new Pronostico(partido2, equipo2, partido2.resultado(equipo2), equipo1, equipo2);

        // Presentación
        System.out.println("\n///////////////////////////////////////////////////////////\n");
        System.out.println("En este gran partido jugarán " + equipo1.getNombre() + " vs " + equipo2.getNombre() + "\n");
        System.out.println("* " + equipo1.getNombre() + ": " + equipo1.getDescripcion() + "\n");
        System.out.println("* " + equipo2.getNombre() + ": " + equipo2.getDescripcion());

        // Resultados previstos
        System.out.println("\n///////////////////////////////////////////////////////////\n");
        System.out.println("-> Resultados previstos\n");
        System.out.println("* " + equipo1.getNombre() + ": " + golesPrev1 + "\n");
        System.out.println("* " + equipo2.getNombre() + ": " + golesPrev2);

        System.out.println("\n///////////////////////////////////////////////////////////");
        System.out.println("\n-> 1ER PARTIDO:\n");
        // Método en el cual se ejecutan los resultados de los equipos
        if(partido1.resultado(equipo2) == ResultadoEnum.empate){
            System.out.println(equipo1.getNombre() + " y " + equipo2.getNombre() + " empataron " + partido1.getGolesEquipo1() + "-" + partido1.getGolesEquipo2());
        }
        else{
            System.out.println("* " + equipo1.getNombre() + " fue " + partido1.resultado(equipo1) + " con " + partido1.getGolesEquipo1() + " goles");
            System.out.println("* " + equipo2.getNombre() + " fue " + partido1.resultado(equipo2) + " con " + partido1.getGolesEquipo2() + " goles");
        }

        //Ejecutamos las puntuaciones de cada equipo en la consola
        System.out.println("\n-> PUNTAJE:\n");
        System.out.println("* Puntos de " + equipo1.getNombre() + ": " + pronostico1.puntos(equipo1, golesPrev1, partido1.getGolesEquipo1(), golesPrev2, partido1.getGolesEquipo1()));
        System.out.println("* Puntos de " + equipo2.getNombre() + ": " + pronostico2.puntos(equipo2, golesPrev1, partido1.getGolesEquipo2(), golesPrev2, partido1.getGolesEquipo2()));
        
        //PARTIDO 2
        System.out.println("\n///////////////////////////////////////////////////////////");
        System.out.println("\n-> 2DO PARTIDO:\n");
        if(partido2.resultado(equipo2) == ResultadoEnum.empate){
            System.out.println(equipo1.getNombre() + " y " + equipo2.getNombre() + " empataron " + partido2.getGolesEquipo1() + "-" + partido2.getGolesEquipo2());
        }
        else{
            System.out.println("* " + equipo1.getNombre() + " fue " + partido2.resultado(equipo1) + " con " + partido2.getGolesEquipo1() + " goles");
            System.out.println("* " + equipo2.getNombre() + " fue " + partido2.resultado(equipo2) + " con " + partido2.getGolesEquipo2() + " goles");
        }

        //Esto es temporal, tenemos que ver un método que lo haga de forma automática :c
        int puntosEquipo1 = pronostico1.puntos(equipo1, golesPrev1, partido1.getGolesEquipo1(), golesPrev2, partido1.getGolesEquipo1()) + pronostico3.puntos(equipo1, golesPrev1, partido1.getGolesEquipo1(), golesPrev2, partido1.getGolesEquipo2());
        int puntosEquipo2 = pronostico2.puntos(equipo2, golesPrev1, partido1.getGolesEquipo1(), golesPrev2, partido1.getGolesEquipo2()) + pronostico4.puntos(equipo2, golesPrev1, partido1.getGolesEquipo1(), golesPrev2, partido1.getGolesEquipo2());

        System.out.println("\n-> PUNTAJE:\n");
        System.out.println("* Puntos de " + equipo1.getNombre() + ": " + puntosEquipo1);
        System.out.println("* Puntos de " + equipo2.getNombre() + ": " + puntosEquipo2);
        System.out.println("\n///////////////////////////////////////////////////////////\n");
    }
}