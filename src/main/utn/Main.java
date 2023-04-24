import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {

        List<String> datos = FileHelper.readFile("datos.csv");
        List<String> previsto = FileHelper.readFile("previsto.csv");

        // PREVISTO
        String resultadoArg = previsto.get(1).split(",")[2];
        String resultadoFran = previsto.get(1).split(",")[3];
        String resultadoAlem = previsto.get(2).split(",")[2];
        String resultadoSui = previsto.get(2).split(",")[3];

        // DATOS
        // Nombres de los equipos
        String nombreArg = datos.get(1).split(",")[0];
        String nombreFran = datos.get(1).split(",")[3];
        String nombreAlem = datos.get(2).split(",")[0];
        String nombreSui = datos.get(2).split(",")[3];
        // Goles de los equipos
        int golesEquipo1 = Integer.parseInt(datos.get(1).split(",")[1]);
        int golesEquipo2 = Integer.parseInt(datos.get(1).split(",")[2]);
        int golesEquipo3 = Integer.parseInt(datos.get(2).split(",")[1]);
        int golesEquipo4 = Integer.parseInt(datos.get(2).split(",")[2]);
        // Descripción de los equipos
        String descArg = "El mejor país del mundo";
        String descFran = "Francia segundo";
        String descAlem = "Un país competente";
        String descSui = "Muy buen país y un ejemplo a seguir";

        // Se instancian los equipos
        Equipo equipo1 = new Equipo(nombreArg, descArg);
        Equipo equipo2 = new Equipo(nombreFran, descFran);
        Equipo equipo3 = new Equipo(nombreAlem, descAlem);
        Equipo equipo4 = new Equipo(nombreSui, descSui);

        // Creamos el array de partidos
        ArrayList<Partido> partidos = new ArrayList<Partido>();
        Partido partido = new Partido(equipo1, equipo2, equipo3, equipo4, golesEquipo1, golesEquipo2, golesEquipo3, golesEquipo4);
        int cantidadPartidos = 2;
        
        // for (int i = 1; i <= cantidadPartidos; i++) {
        //     String nombrePartido = "partido" + i;
        //     Partido partido = new Partido(equipo1, equipo2, equipo3, equipo4, golesEquipo1, golesEquipo2, golesEquipo3, golesEquipo4);
        //     partido.setNombre(nombrePartido);
        //     partidos.add(partido);
        // }
        
        // String nombreBuscado = "partido1";
        // for (Partido partido : partidos) {
        //     if (partido.getNombre().equals(nombreBuscado)) {
                
        //         break;
        //     }
        // }

        

        Participante participante1 = new Participante(previsto.get(1).split(",")[0], 0);
        Participante participante2 = new Participante(previsto.get(2).split(",")[0], 0);

        Pronostico pronostico = new Pronostico(partido, partido.resultado(equipo1));
        
        // Presentación
        System.out.println("\n///////////////////////////////////////////////////////////\n");
        System.out.println("->  En este gran partido jugarán: \n");
        System.out.println(equipo1.getNombre() + " vs " + equipo2.getNombre());
        System.out.println(equipo3.getNombre() + " vs " + equipo4.getNombre() + "\n");
        System.out.println("* " + equipo1.getNombre() + ": " + equipo1.getDescripcion());
        System.out.println("* " + equipo2.getNombre() + ": " + equipo2.getDescripcion());
        System.out.println("* " + equipo3.getNombre() + ": " + equipo3.getDescripcion());
        System.out.println("* " + equipo4.getNombre() + ": " + equipo4.getDescripcion());

        System.out.println("\n///////////////////////////////////////////////////////////");
        System.out.println("\n-> 1ER PARTIDO:\n");

        // Método en el cual se ejecutan los resultados de los equipos
        if(partido.resultado(equipo1) == ResultadoEnum.EMPATE){
            System.out.println("* " + equipo1.getNombre() + " y " + equipo2.getNombre() + " EMPATARON con " + partido.getGolesEquipo1() + "-" + partido.getGolesEquipo2());
        }
        else{
            System.out.println("* " + equipo1.getNombre() + " fue " + partido.resultado(equipo1) + " con " + partido.getGolesEquipo1() + " goles");
            System.out.println("* " + equipo2.getNombre() + " fue " + partido.resultado(equipo2) + " con " + partido.getGolesEquipo2() + " goles\n");
        }

        // Método en el cual se ejecutan los resultados de los equipos
        if(partido.resultado(equipo3) == ResultadoEnum.EMPATE){
            System.out.println("* " + equipo3.getNombre() + " y " + equipo4.getNombre() + " EMPATARON con " + partido.getGolesEquipo3() + "-" + partido.getGolesEquipo4());
        }
        else{
            System.out.println("* " + equipo3.getNombre() + " fue " + partido.resultado(equipo3) + " con " + partido.getGolesEquipo3() + " goles");
            System.out.println("* " + equipo4.getNombre() + " fue " + partido.resultado(equipo4) + " con " + partido.getGolesEquipo4() + " goles");
        }

        System.out.println("\n-> PUNTAJE:\n");

        if (!("X".equals(resultadoArg) && "X".equals(resultadoFran))) {
            if ("X".equals(resultadoArg) && partido.resultado(equipo1) == ResultadoEnum.GANADOR) {
                System.out.println(participante1.getNombre() + " acertó, " + equipo1.getNombre() + " GANÓ");
                pronostico.setResultadoConstante(ResultadoEnum.GANADOR);

            } else if ("X".equals(resultadoFran) && partido.resultado(equipo2) == ResultadoEnum.GANADOR) {
                System.out.println(participante1.getNombre() + " acertó, " + equipo2.getNombre() + " GANÓ");
                pronostico.setResultadoConstante(ResultadoEnum.GANADOR);

            } else if (resultadoArg.equals(resultadoFran) && partido.resultado(equipo1) == ResultadoEnum.EMPATE){
                System.out.println(participante1.getNombre() + " acertó, " + equipo1.getNombre() + " y " + equipo2.getNombre() + " EMPATARON");
                pronostico.setResultadoConstante(ResultadoEnum.EMPATE);

            } else {
                System.out.println(participante1.getNombre() + " no acertó");
                pronostico.setResultadoConstante(null);
            }

        } else if (partido.resultado(equipo1) == ResultadoEnum.EMPATE) {
            System.out.println(participante1.getNombre() + " acertó, " + equipo1.getNombre() + " y " + equipo2.getNombre() + " EMPATARON");
            pronostico.setResultadoConstante(ResultadoEnum.EMPATE);
        } else {
            System.out.println(participante1.getNombre() + " no acertó");
            pronostico.setResultadoConstante(null);
        }
        
        participante1.setPuntos(pronostico.puntos(equipo1));

        
        if (!("X".equals(resultadoAlem) && "X".equals(resultadoSui))) {
            if ("X".equals(resultadoAlem) && partido.resultado(equipo3) == ResultadoEnum.GANADOR) {
                System.out.println(participante2.getNombre() + " acertó, " + equipo3.getNombre() + " GANÓ");
                pronostico.setResultadoConstante(ResultadoEnum.GANADOR);

            } else if ("X".equals(resultadoSui) && partido.resultado(equipo3) == ResultadoEnum.PERDEDOR) {
                System.out.println(participante2.getNombre() + " acertó, " + equipo4.getNombre() + " GANÓ");
                pronostico.setResultadoConstante(ResultadoEnum.PERDEDOR);

            } else if (resultadoAlem.equals(resultadoSui)  && partido.resultado(equipo3) == ResultadoEnum.EMPATE){
                System.out.println(participante2.getNombre() + " acertó, " + equipo3.getNombre() + " y " + equipo4.getNombre() + " EMPATARON");
                pronostico.setResultadoConstante(ResultadoEnum.EMPATE);

            } else {
                System.out.println(participante2.getNombre() + " no acertó");
                pronostico.setResultadoConstante(null);
            }

        } else if (partido.resultado(equipo3) == ResultadoEnum.EMPATE) {
            System.out.println(participante2.getNombre() + " acertó, " + equipo3.getNombre() + " y " + equipo4.getNombre() + " EMPATARON");
            pronostico.setResultadoConstante(ResultadoEnum.EMPATE);
        } else {
            System.out.println(participante2.getNombre() + " no acertó");
            pronostico.setResultadoConstante(null);
        }

        participante2.setPuntos(pronostico.puntos(equipo3));

        System.out.println("\n* Puntos de " + participante1.getNombre() + ": " + participante1.getPuntos());
        System.out.println("* Puntos de " + participante2.getNombre() + ": " + participante2.getPuntos());
        System.out.println("\n///////////////////////////////////////////////////////////\n");

        
    }
}