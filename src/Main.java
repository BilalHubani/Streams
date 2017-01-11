import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dam on 21/12/16.
 */
public class Main {
    public static void main(String[] args) {
        List<Equipo> equipos = new ArrayList<>();
        Equipo equipo1 = new Equipo("Lmao team", "Lul");
        Equipo equipo2 = new Equipo("Die team","Hell");
        equipos.add(equipo1);
        equipos.add(equipo2);
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
        System.out.println("Top 5 jugadores con mas canastas:");
        List<Jugador> top5Canastas = jugadores.stream().sorted(Comparator.comparing(Jugador::getNumCanastas).reversed()).limit(5).collect(Collectors.toList());
        System.out.println(top5Canastas);
        System.out.println("");
        System.out.println("Jugadores con canastas entre 500 y 200 ordenados por nacimiento descendente: ");
        List<Jugador> canastasEntreNacimiento = jugadores.stream().filter(jugador -> jugador.getNumCanastas()<=500 && jugador.getNumCanastas()>=200).sorted(Comparator.comparing(Jugador::getFechaNacimiento).reversed()).collect(Collectors.toList());
        System.out.println(canastasEntreNacimiento);
        System.out.println("");
        System.out.println("Jugadores con canastas entre 500 y 200 ordenados por nombre y por nacimiento: ");
        List<Jugador> canastasEntreCanastasNacimiento = jugadores.parallelStream()
                .filter(jugador -> jugador.getNumCanastas()<=500 && jugador.getNumCanastas()>=200)
                .sorted(Comparator.comparing(Jugador::getNumCanastas).thenComparing(Jugador::getFechaNacimiento))
                .collect(Collectors.toList());
        System.out.println(canastasEntreCanastasNacimiento);
        System.out.println("");
        System.out.println("Jugador con menos canastas: ");
        Jugador minCanastas = jugadores.stream().min(Comparator.comparing(Jugador::getNumCanastas)).get();
        System.out.println(minCanastas);
        System.out.println("");
        System.out.println("Jugador con mas canastas: ");
        Jugador maxCanastas = jugadores.stream().max(Comparator.comparing(Jugador::getNumCanastas)).get();
        System.out.println(maxCanastas);
        System.out.println("");
        System.out.println("Media de canastas de todos los jugadores: ");
        double media = jugadores.stream().mapToDouble(Jugador::getNumCanastas).average().getAsDouble();
        System.out.println(media);
        System.out.println("");
        System.out.println("Jugadores cuyo equipo tiene de localidad Hell: ");
        List<Jugador> jugadoresLocalidadEquipo = jugadores.stream().filter(jugador -> jugador.getEquipo().getLocalidad().equalsIgnoreCase("Hell")).collect(Collectors.toList());
        System.out.println(jugadoresLocalidadEquipo);
        System.out.println("");
        System.out.println("Boolean si hay un jugador con mas de 4000 canastas: ");
        boolean canastas4000 = jugadores.stream().anyMatch(jugador -> jugador.getNumCanastas()>4000);
        System.out.println(canastas4000);
        System.out.println("");
        System.out.println("Boolean si todos los jugadores han conseguido mas de 50 canastas: ");
        boolean canastas50 = jugadores.stream().allMatch(jugador -> jugador.getNumCanastas()>50);
        System.out.println(canastas50);
        System.out.println("");
        System.out.println("Boolean si todos los jugadores del primer equipo han conseguido mas de 50 canastas: ");
        boolean canastasEquipo50 = jugadores.stream().filter(jugador -> jugador.getEquipo().getNombre().equalsIgnoreCase("Lmao team")).allMatch(jugador ->  jugador.getNumCanastas()>50);
        System.out.println(canastasEquipo50);
        System.out.println("");
        System.out.println("Agrupar equipos que perteneces a la misma localidad: ");
        Map<String,List<Equipo>> localidad = equipos.stream().collect(Collectors.groupingBy(Equipo::getLocalidad));
        System.out.println(localidad);
        System.out.println("");
        System.out.println("Suma de las canastas de todos los jugadores: ");
        int suma = jugadores.parallelStream().mapToInt(Jugador::getNumCanastas).reduce(0, (a,b) -> a+b);
        System.out.println(suma);
        System.out.println("");
        System.out.println("Suma de las canastas de los jugadores del primer equipo: ");
        Map<Equipo,Integer> sumaEquipo = jugadores.parallelStream().collect(Collectors.groupingBy(Jugador::getEquipo, Collectors.summingInt(Jugador::getNumCanastas)));
        System.out.println(sumaEquipo);
    }
}
