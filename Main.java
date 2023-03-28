import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {

        // Archivos de resultado
        Path infoFile = Paths.get("info.txt");

        // Archivo de predicción
        Path resultadosFile = Paths.get("resultados.txt");

        // Lista de strings del archivo
        List<String> lineas;
    
        try {
            lineas = Files.readAllLines(infoFile);
            // System.out.println(data);
            // Files.writeString(Paths.get("prediccion.txt" ), "hola\n quetal?\n");
        } catch (IOException e) {
            // Error
            System.out.println("Error al leer el archivo " + infoFile + ": " + e.getMessage());
            return;
        }

        // Iteraramos sobre las líneas y asignamos los valores correspondientes
        String[] valoresEquipo1 = lineas.get(0).split("-");
        String[] valoresEquipo2 = lineas.get(1).split("-");
        String nombreEquipo1 = valoresEquipo1[0];
        String nombreEquipo2 = valoresEquipo2[0];
        int golesEquipo1 = Integer.parseInt(valoresEquipo1[1]);
        int golesEquipo2 = Integer.parseInt(valoresEquipo2[1]);
        String descripcionEquipo1 = valoresEquipo1[2];
        String descripcionEquipo2 = valoresEquipo2[2];


        // Instanciamos los equipos
        Equipo equipo1 = new Equipo();
        // Le asignamos el nombre que está en info.txt
        equipo1.nombre = nombreEquipo1;
        equipo1.descripcion = descripcionEquipo1;

        Equipo equipo2 = new Equipo();
        // Le asignamos el nombre que está en info.txt
        equipo2.nombre = nombreEquipo2;
        equipo2.descripcion = descripcionEquipo2;

        // Instanciamos los partidos
        Partido partido1 = new Partido(equipo1, equipo2);
        partido1.golesEquipo1 = golesEquipo1;
        partido1.golesEquipo2 = golesEquipo2;

        //Declaración del pronostico1(equipo1) y pronostico2(equipo2)
        Pronostico pronostico1 = new Pronostico(equipo1, partido1.resultado(equipo1), partido1);
        Pronostico pronostico2 = new Pronostico(equipo2, partido1.resultado(equipo2), partido1);

        //partido2 y goles(lo mismo que arriba)
        Partido partido2 = new Partido(equipo1, equipo2);
        partido2.golesEquipo1 = 3;
        partido2.golesEquipo2 = 4;
        Pronostico pronostico3 = new Pronostico(equipo1, partido2.resultado(equipo1), partido2);
        Pronostico pronostico4 = new Pronostico(equipo2, partido2.resultado(equipo2), partido2);

        ArrayList<Partido> losPartidos = new ArrayList<Partido>();




        // Presentación
        System.out.println("\n///////////////////////////////////////////////////////////\n");
        System.out.println("En este gran partido jugarán " + equipo1.nombre + " vs " + equipo2.nombre + "\n");
        System.out.println(equipo1.nombre + ": " + equipo1.descripcion + "\n");
        System.out.println(equipo2.nombre + ": " + equipo2.descripcion);

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
        System.out.println("\n-> PRONÓSTICO:\n");
        System.out.println("* Puntos de " + equipo1.nombre + ": " + pronostico1.puntos(0));
        System.out.println("* Puntos de " + equipo2.nombre + ": " + pronostico2.puntos(0));
        
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
        int puntosEquipo1 = pronostico1.puntos(0) + pronostico3.puntos(0);
        int puntosEquipo2 = pronostico2.puntos(0) + pronostico4.puntos(0);

        System.out.println("\n-> PRONÓSTICO:\n");
        System.out.println("* Puntos de " + equipo1.nombre + ": " + puntosEquipo1);
        System.out.println("* Puntos de " + equipo2.nombre + ": " + puntosEquipo2);
        System.out.println("\n///////////////////////////////////////////////////////////\n");
    }
}