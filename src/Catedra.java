import java.util.List;

public class Catedra {
    private int codigo;
    private String denominacion;
    private List<Alumno> alumnos; // <- agregamos esta lista

    // A3: Mejor alumno de la cátedra
    public Alumno mejorAlumnoCatedra() {
        Alumno mejor = null;
        double mejorPromedio = -1;

        if (alumnos != null) {
            for (Alumno alumno : alumnos) {
                double promedio = alumno.promedioNotas(this.codigo);
                if (promedio > mejorPromedio) {
                    mejorPromedio = promedio;
                    mejor = alumno;
                }
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

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
