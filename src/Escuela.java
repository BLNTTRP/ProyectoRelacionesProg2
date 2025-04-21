import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
//a.5
public class Escuela {
    private int numero;
    private String denominacion;
    private List<DivisionCurso> divisiones;

    public Escuela() {
        this.divisiones = new ArrayList<>();
    }

    public Alumno getMejorAlumnoEscuela(int anioNacimientoAlumno) {
        Alumno mejor = null;
        double mejorPromedio = -1;

        for (DivisionCurso division : divisiones) {
            for (Alumno alumno : division.getAlumnos()) {
                // Verificar año de nacimiento
                Calendar cal = Calendar.getInstance();
                cal.setTime(alumno.getFechaNacimiento());
                int anioNacimiento = cal.get(Calendar.YEAR);
                if (anioNacimiento != anioNacimientoAlumno) {
                    continue;
                }

                // Verificar que no tenga notas desaprobadas (< 6)
                boolean tieneDesaprobadas = false;
                for (Nota nota : alumno.getNotas()) {
                    if (nota.getValor() < 6.0) {
                        tieneDesaprobadas = true;
                        break;
                    }
                }
                if (tieneDesaprobadas) {
                    continue;
                }

                // Comparar promedio general
                double promedio = alumno.promedioNotas(null);
                if (promedio > mejorPromedio) {
                    mejorPromedio = promedio;
                    mejor = alumno;
                }
            }
        }

        return mejor;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<DivisionCurso> getDivisiones() {
        return divisiones;
    }

    public void setDivisiones(List<DivisionCurso> divisiones) {
        this.divisiones = divisiones;
    }

    public void agregarDivision(DivisionCurso division) {
        this.divisiones.add(division);
    }
}
