import java.util.ArrayList;
import java.util.List;
// a.4
public class DivisionCurso {
    private int codigo;
    private int anio;
    private int division;
    private List<Alumno> alumnos;

    public DivisionCurso() {
        this.alumnos = new ArrayList<>();
    }

    public Alumno mejorAlumnoDivisionCurso() {
        Alumno mejor = null;
        double mejorPromedio = -1;

        for (Alumno alumno : alumnos) {
            List<Nota> notas = alumno.getNotas();

            // Verificamos que tenga al menos 5 notas
            if (notas == null || notas.size() < 5) {
                continue;
            }

            // Verificamos que ninguna nota sea recuperatorio
            boolean tieneRecuperatorio = false;
            for (Nota nota : notas) {
                if (nota.isEsRecuperatorio()) {
                    tieneRecuperatorio = true;
                    break;
                }
            }
            if (tieneRecuperatorio) {
                continue;
            }

            // Calcular promedio total
            double promedio = alumno.promedioNotas(null);
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejor = alumno;
            }
        }

        return mejor;
    }

    // Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }
}
