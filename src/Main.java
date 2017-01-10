import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
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
        new Jugador("Haha", LocalDate.of(2002,12,12),480,equipo1),
        new Jugador("Death", LocalDate.of(1999,1,1),700,equipo2),
        new Jugador("Kill", LocalDate.of(1998,1,1),400,equipo2),
        new Jugador("Dead", LocalDate.of(1997,1,5),800,equipo2)
        );
        System.out.println("Jugadores con mas de 500 canastas:");
        List<Jugador> canastasMasDe = jugadores.stream().filter(jugador -> jugador.getNumCanastas()>500).collect(Collectors.toList());
        System.out.println(canastasMasDe);
        System.out.println("");
        System.out.println("Jugadores con canastas entre 500 y 200: ");
        List<Jugador> canastasEntre = jugadores.stream().filter(jugador -> jugador.getNumCanastas()<=500 && jugador.getNumCanastas()>=200).collect(Collectors.toList());
        System.out.println(canastasEntre);
        System.out.println("");
        System.out.println("Nombre de los jugadores con canastas entre 500 y 200:");
        List<String> canastasEntreNombre = jugadores.stream().filter(jugador -> jugador.getNumCanastas()<=500 && jugador.getNumCanastas()>=200).map(Jugador::getNombre).collect(Collectors.toList());
        System.out.println(canastasEntreNombre);
        System.out.println("");
        System.out.println("Jugadores ordenados por nacimiento: ");
        List<Jugador> ordenNacimiento = jugadores.stream().sorted(Comparator.comparing(Jugador::getFechaNacimiento)).collect(Collectors.toList());
        System.out.println(ordenNacimiento);
        System.out.println("");
        System.out.println("Jugadores ordenados por numero de canastas:");
        List<Jugador> ordenCanastas = jugadores.stream().sorted(Comparator.comparing(Jugador::getNumCanastas)).collect(Collectors.toList());
        System.out.println(ordenCanastas);
        System.out.println("");


    }
}
