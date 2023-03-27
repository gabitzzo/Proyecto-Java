public class Main{
    public static void main(String[] args) {

        //Declaraciones de equipos
        Equipo equipo1 = new Equipo();
        equipo1.nombre = "Boca";
        Equipo equipo2 = new Equipo();
        equipo2.nombre = "River";

        //Declaración de partido1 y goles
        Partido partido1 = new Partido(equipo1, equipo2);
        partido1.golesEquipo1 = 3;
        partido1.golesEquipo2 = 3;
        //Declaración del pronostico1(equipo1) y pronostico2(equipo2)
        Pronostico pronostico1 = new Pronostico(equipo1, partido1.resultado(equipo1), partido1);
        Pronostico pronostico2 = new Pronostico(equipo2, partido1.resultado(equipo2), partido1);

        //partido2 y goles(lo mismo que arriba)
        Partido partido2 = new Partido(equipo1, equipo2);
        partido2.golesEquipo1 = 3;
        partido2.golesEquipo2 = 4;
        Pronostico pronostico3 = new Pronostico(equipo1, partido2.resultado(equipo1), partido2);
        Pronostico pronostico4 = new Pronostico(equipo2, partido2.resultado(equipo2), partido2);

        //Método en el cual se ejecutan los resultados de los equipos
        System.out.println("\n-> 1ER PARTIDO:\n");
        if(partido1.resultado(equipo2) == ResultadoEnum.empate){
            System.out.println(equipo1.nombre+" y "+equipo2.nombre+" empataron "+partido1.golesEquipo1+"-"+partido1.golesEquipo2);
        }
        else{
            System.out.println(equipo1.nombre + " fue "+partido1.resultado(equipo1)+" con "+partido1.golesEquipo1+" goles");
            System.out.println(equipo2.nombre + " fue "+partido1.resultado(equipo2)+" con "+partido1.golesEquipo2+" goles");
        }

        //Ejecutamos las puntuaciones de cada equipo en la consola
        System.out.println("\n-> PRONÓSTICO:\n");
        System.out.println("Puntos de "+equipo1.nombre+": "+pronostico1.puntos(0));
        System.out.println("Puntos de "+equipo2.nombre+": "+pronostico2.puntos(0));
        
        //PARTIDO 2
        System.out.println("\n///////////////////////////////////////////////////////////\n");
        System.out.println("\n-> 2DO PARTIDO:\n");
        if(partido2.resultado(equipo2) == ResultadoEnum.empate){
            System.out.println(equipo1.nombre+" y "+equipo2.nombre+" empataron "+partido2.golesEquipo1+"-"+partido2.golesEquipo2);
        }
        else{
            System.out.println(equipo1.nombre + " fue "+partido2.resultado(equipo1)+" con "+partido2.golesEquipo1+" goles");
            System.out.println(equipo2.nombre + " fue "+partido2.resultado(equipo2)+" con "+partido2.golesEquipo2+" goles");
        }

        //Esto es temporal, tenemos que ver un método que lo haga de forma automática :c
        int puntosEquipo1 = pronostico1.puntos(0) + pronostico3.puntos(0);
        int puntosEquipo2 = pronostico2.puntos(0) + pronostico4.puntos(0);

        System.out.println("\n-> PRONÓSTICO:\n");
        System.out.println("Puntos de "+equipo1.nombre+": "+puntosEquipo1);
        System.out.println("Puntos de "+equipo2.nombre+": "+puntosEquipo2);
    }

}
