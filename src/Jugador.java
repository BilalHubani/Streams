import java.time.LocalDate;

/**
 * Created by dam on 19/12/16.
 */
public class Jugador {
    private String nombre;
    private LocalDate fechaNacimiento;
    private int numCanastas;
    private Equipo equipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumCanastas() {
        return numCanastas;
    }

    public void setNumCanastas(int numCanastas) {
        this.numCanastas = numCanastas;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador(String nombre, LocalDate fechaNacimiento, int numCanastas, Equipo equipo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.numCanastas = numCanastas;
        this.equipo = equipo;
    }
}
