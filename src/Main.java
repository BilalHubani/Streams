import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dam on 21/12/16.
 */
public class Main {
    public static void main(String[] args) {
        Equipo equipo1 = new Equipo("Lmao team", "Lul");
        Equipo equipo2 = new Equipo("Die team","Hell");
        List<Jugador> jugadores = Arrays.asList(
        new Jugador("XD", LocalDate.of(2000,10,10),600,equipo1),
        new Jugador("Lol", LocalDate.of(2001,11,11),750,equipo1),
        new Jugador("XD", LocalDate.of(2002,12,12),480,equipo1),
        new Jugador("Death", LocalDate.of(1999,1,1),700,equipo2),
        new Jugador("Kill", LocalDate.of(1998,1,1),400,equipo2),
        new Jugador("Dead", LocalDate.of(1997,1,5),800,equipo2)
        );
        List<Jugador> canastasMasDe = jugadores.stream().collect(Collectors.toList());
    }
}
