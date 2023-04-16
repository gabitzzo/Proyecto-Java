package src.main.utn;
import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {

        List<String> lineas = FileHelper.readFile("Proyecto-Java/src/main/resources/datos.csv");
        List<String> lineasPrev = FileHelper.readFile("Proyecto-Java/src/main/resources/previsto.csv");

        // PREVISTO: Goles de los equipos
        int golesPrev1 = Integer.parseInt(lineasPrev.get(0).split(",")[1]); // Primera línea - segunda palabra
        int golesPrev2 = Integer.parseInt(lineasPrev.get(1).split(",")[1]); // Segunda línea - segunda palabra

        // DATOS: Seleccionamos la segunda palabra de cada línea
        // Nombres de los equipos
        String nombreEquipo1 = lineas.get(0).split(",")[0]; // Primera línea - primera palabra
        String nombreEquipo2 = lineas.get(1).split(",")[0]; // Segunda línea - primera palabra
        // Goles de los equipos
        String golesEquipo1 = lineas.get(0).split(",")[1]; // Primera línea - segunda palabra
        String golesEquipo2 = lineas.get(1).split(",")[1]; // Segunda línea - segunda palabra
        // Descripción de los equipos
        String descEquipo1 = lineas.get(0).split(",")[2]; // Primera línea - tercera palabra
        String descEquipo2 = lineas.get(1).split(",")[2]; // Segunda línea - tercera palabra

        // Se instancian los equipos
        Equipo equipo1 = new Equipo(nombreEquipo1, descEquipo1);
        Equipo equipo2 = new Equipo(nombreEquipo2, descEquipo2);

        ArrayList<Partido> partidos = new ArrayList<Partido>();

        // Instanciamos los partidos
        Partido partido = new Partido(equipo1, equipo2, Integer.parseInt(golesEquipo1), Integer.parseInt(golesEquipo2));
        partidos.add(partido);
        //Declaración del pronostico1(equipo1) y pronostico2(equipo2)
        Pronostico pronostico1 = new Pronostico(partido, equipo1, partido.resultado(equipo1), equipo1, equipo2);
        Pronostico pronostico2 = new Pronostico(partido, equipo2, partido.resultado(equipo2), equipo1, equipo2);

        //partido2 y goles(lo mismo que arriba)
        Pronostico pronostico3 = new Pronostico(partido, equipo1, partido.resultado(equipo1), equipo1, equipo2);
        Pronostico pronostico4 = new Pronostico(partido, equipo2, partido.resultado(equipo2), equipo1, equipo2);

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
        if(partido.resultado(equipo2) == ResultadoEnum.EMPATE){
            System.out.println(equipo1.getNombre() + " y " + equipo2.getNombre() + " empataron " + partido.getGolesEquipo1() + "-" + partido.getGolesEquipo2());
        }
        else{
            System.out.println("* " + equipo1.getNombre() + " fue " + partido.resultado(equipo1) + " con " + partido.getGolesEquipo1() + " goles");
            System.out.println("* " + equipo2.getNombre() + " fue " + partido.resultado(equipo2) + " con " + partido.getGolesEquipo2() + " goles");
        }

        //Ejecutamos las puntuaciones de cada equipo en la consola
        System.out.println("\n-> PUNTAJE:\n");
        System.out.println("* Puntos de " + equipo1.getNombre() + ": " + pronostico1.puntos());
        System.out.println("* Puntos de " + equipo2.getNombre() + ": " + pronostico2.puntos());
        
        //PARTIDO 2
        System.out.println("\n///////////////////////////////////////////////////////////");
        System.out.println("\n-> 2DO PARTIDO:\n");
        if(partido.resultado(equipo2) == ResultadoEnum.EMPATE){
            System.out.println(equipo1.getNombre() + " y " + equipo2.getNombre() + " empataron " + partido.getGolesEquipo1() + "-" + partido.getGolesEquipo2());
        }
        else{
            System.out.println("* " + equipo1.getNombre() + " fue " + partido.resultado(equipo1) + " con " + partido.getGolesEquipo1() + " goles");
            System.out.println("* " + equipo2.getNombre() + " fue " + partido.resultado(equipo2) + " con " + partido.getGolesEquipo2() + " goles");
        }

        //Esto es temporal, tenemos que ver un método que lo haga de forma automática :c
        int puntosEquipo1 = pronostico1.puntos() + pronostico3.puntos();
        int puntosEquipo2 = pronostico2.puntos() + pronostico4.puntos();

        System.out.println("\n-> PUNTAJE:\n");
        System.out.println("* Puntos de " + equipo1.getNombre() + ": " + puntosEquipo1);
        System.out.println("* Puntos de " + equipo2.getNombre() + ": " + puntosEquipo2);
        System.out.println("\n///////////////////////////////////////////////////////////\n");
    }
}