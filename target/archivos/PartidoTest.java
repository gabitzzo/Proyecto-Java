

// import src.main.utn.Partido;
// import src.main.utn.Equipo;
// import src.main.utn.ResultadoEnum;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.Test;

// public class PartidoTest {

//     @Test
//     public void testResultadoGanadorEquipo1() {
//         Equipo equipo1 = new Equipo("Equipo 1");
//         Equipo equipo2 = new Equipo("Equipo 2");
//         Partido partido = new Partido(equipo1, equipo2, 2, 1);
//         assertEquals(ResultadoEnum.GANADOR, partido.resultado(equipo1));
//     }

//     @Test
//     public void testResultadoGanadorEquipo2() {
//         Equipo equipo1 = new Equipo("Equipo 1");
//         Equipo equipo2 = new Equipo("Equipo 2");
//         Partido partido = new Partido(equipo1, equipo2, 1, 2);
//         assertEquals(ResultadoEnum.GANADOR, partido.resultado(equipo2));
//     }

//     @Test
//     public void testResultadoEmpate() {
//         Equipo equipo1 = new Equipo("Equipo 1");
//         Equipo equipo2 = new Equipo("Equipo 2");
//         Partido partido = new Partido(equipo1, equipo2, 2, 2);
//         assertEquals(ResultadoEnum.EMPATE, partido.resultado(equipo1));
//         assertEquals(ResultadoEnum.EMPATE, partido.resultado(equipo2));
//     }

//     @Test
//     public void testResultadoPerdedorEquipo1() {
//         Equipo equipo1 = new Equipo("Equipo 1");
//         Equipo equipo2 = new Equipo("Equipo 2");
//         Partido partido = new Partido(equipo1, equipo2, 1, 2);
//         assertEquals(ResultadoEnum.PERDEDOR, partido.resultado(equipo1));
//     }

//     @Test
//     public void testResultadoPerdedorEquipo2() {
//         Equipo equipo1 = new Equipo("Equipo 1");
//         Equipo equipo2 = new Equipo("Equipo 2");
//         Partido partido = new Partido(equipo1, equipo2, 2, 1);
//         assertEquals(ResultadoEnum.PERDEDOR, partido.resultado(equipo2));
//     }
// }