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
        Equipo equipo1 = new Equipo();
        // Le asignamos el nombre que está en info.txt
        equipo1.nombre = nombreEquipo1;
        equipo1.descripcion = descEquipo1;

        Equipo equipo2 = new Equipo();
        // Le asignamos el nombre que está en info.txt
        equipo2.nombre = nombreEquipo2;
        equipo2.descripcion = descEquipo2;

        // Instanciamos los partidos
        Partido partido1 = new Partido(equipo1, equipo2);
        partido1.golesEquipo1 = Integer.parseInt(golesEquipo1);
        partido1.golesEquipo2 = Integer.parseInt(golesEquipo2);

        //Declaración del pronostico1(equipo1) y pronostico2(equipo2)
        Pronostico pronostico1 = new Pronostico(partido1, equipo1, partido1.resultado(equipo1));
        Pronostico pronostico2 = new Pronostico(partido1, equipo2, partido1.resultado(equipo2));

        //partido2 y goles(lo mismo que arriba)
        Partido partido2 = new Partido(equipo1, equipo2);
        partido2.golesEquipo1 = 3;
        partido2.golesEquipo2 = 4;
        Pronostico pronostico3 = new Pronostico(partido2, equipo1, partido2.resultado(equipo1));
        Pronostico pronostico4 = new Pronostico(partido2, equipo2, partido2.resultado(equipo2));

        ArrayList<Partido> losPartidos = new ArrayList<Partido>();

        // Presentación
        System.out.println("\n///////////////////////////////////////////////////////////\n");
        System.out.println("En este gran partido jugarán " + equipo1.nombre + " vs " + equipo2.nombre + "\n");
        System.out.println("* " + equipo1.nombre + ": " + equipo1.descripcion + "\n");
        System.out.println("* " + equipo2.nombre + ": " + equipo2.descripcion);

        // Resultados previstos
        System.out.println("\n///////////////////////////////////////////////////////////\n");
        System.out.println("-> Resultados previstos\n");
        System.out.println("* " + equipo1.nombre + ": " + golesPrev1 + "\n");
        System.out.println("* " + equipo2.nombre + ": " + golesPrev2);

        System.out.println("\n///////////////////////////////////////////////////////////");
        System.out.println("\n-> 1ER PARTIDO:\n");
        // Método en el cual se ejecutan los resultados de los equipos
        if(partido1.resultado(equipo2) == ResultadoEnum.empate){
            System.out.println(equipo1.nombre + " y " + equipo2.nombre + " empataron " + partido1.golesEquipo1 + "-" + partido1.golesEquipo2);
        }
        else{
            System.out.println("* " + equipo1.nombre + " fue " + partido1.resultado(equipo1) + " con " + partido1.golesEquipo1 + " goles");
            System.out.println("* " + equipo2.nombre + " fue " + partido1.resultado(equipo2) + " con " + partido1.golesEquipo2 + " goles");
        }

        //Ejecutamos las puntuaciones de cada equipo en la consola
        System.out.println("\n-> PUNTAJE:\n");
        System.out.println("* Puntos de " + equipo1.nombre + ": " + pronostico1.puntos(golesPrev1, partido1.golesEquipo1));
        System.out.println("* Puntos de " + equipo2.nombre + ": " + pronostico2.puntos(golesPrev2, partido1.golesEquipo2));
        
        //PARTIDO 2
        System.out.println("\n///////////////////////////////////////////////////////////");
        System.out.println("\n-> 2DO PARTIDO:\n");
        if(partido2.resultado(equipo2) == ResultadoEnum.empate){
            System.out.println(equipo1.nombre + " y " + equipo2.nombre + " empataron " + partido2.golesEquipo1 + "-" + partido2.golesEquipo2);
        }
        else{
            System.out.println("* " + equipo1.nombre + " fue " + partido2.resultado(equipo1) + " con " + partido2.golesEquipo1 + " goles");
            System.out.println("* " + equipo2.nombre + " fue " + partido2.resultado(equipo2) + " con " + partido2.golesEquipo2 + " goles");
        }

        //Esto es temporal, tenemos que ver un método que lo haga de forma automática :c
        int puntosEquipo1 = pronostico1.puntos(golesPrev1, partido1.golesEquipo1) + pronostico3.puntos(golesPrev1, partido1.golesEquipo1);
        int puntosEquipo2 = pronostico2.puntos(golesPrev2, partido1.golesEquipo2) + pronostico4.puntos(golesPrev2, partido1.golesEquipo2);

        System.out.println("\n-> PUNTAJE:\n");
        System.out.println("* Puntos de " + equipo1.nombre + ": " + puntosEquipo1);
        System.out.println("* Puntos de " + equipo2.nombre + ": " + puntosEquipo2);
        System.out.println("\n///////////////////////////////////////////////////////////\n");
    }
}