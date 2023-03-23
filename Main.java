public class Main{
    public static void main(String[] args) {

        Equipo e1 = new Equipo();
        e1.name = "Boca";
        e1.jugadores[0] = "Messi";

        Equipo e2 = new Equipo();
        e2.name = "River";
        e2.jugadores[0] = "Ronaldo";

        System.out.println("Primer partido: "+e1.name+" VS "+e2.name);

        Partido p1 = new Partido();
        p1.equipo[0] = e1.name;
        p1.goles[0] = 0;
        
        p1.equipo[1] = e2.name;
        p1.goles[1] = 0;


        if(p1.goles[0] == p1.goles[0]+1){
            System.out.println("¡Gol de "+p1.equipo[0]+"!");
        }
        if(p1.goles[1] == 1){
            System.out.println("¡Gol de "+p1.equipo[1]+"!");
        }


        if(p1.goles[0]>p1.goles[1]){
            System.out.println("¡Gana "+p1.equipo[0]+"!");
        }
        else if(p1.goles[1]>p1.goles[0]){
            System.out.println("¡Gana "+p1.equipo[1]+"!");
        }
        else if(p1.goles[0]==p1.goles[1]){
            System.out.println("¡Empate!");
        }

    }
}
