import java.util.*;

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

    //A.6
    public List<Alumno> getMejoresAlumnos(int anioNacimientoAlumno) {
        List<Alumno> candidatos = new ArrayList<>();

        // Candidatos que cumplen con el año requerido y que no desaprobaron nada
        for (DivisionCurso division : divisiones) {
            for (Alumno alumno : division.getAlumnos()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(alumno.getFechaNacimiento());
                int anio = calendar.get(Calendar.YEAR);

                if (anio == anioNacimientoAlumno && nuncaDesaprobo(alumno)) {
                    if (!candidatos.contains(alumno)) {
                        candidatos.add(alumno);
                    }
                }
            }
        }

        // Ordenar por promedio general calculado manualmente
        for (int i = 0; i < candidatos.size() - 1; i++) {
            for (int j = i + 1; j < candidatos.size(); j++) {
                double promedioI = promedioGeneral(candidatos.get(i));
                double promedioJ = promedioGeneral(candidatos.get(j));

                if (promedioJ > promedioI) {
                    Alumno temp = candidatos.get(i);
                    candidatos.set(i, candidatos.get(j));
                    candidatos.set(j, temp);
                }
            }
        }

        // Devolver hasta 3 mejores
        List<Alumno> mejores = new ArrayList<>();
        for (int i = 0; i < candidatos.size() && i < 3; i++) {
            mejores.add(candidatos.get(i));
        }

        return mejores;
    }

    private double promedioGeneral(Alumno alumno) {
        List<Nota> notas = alumno.getNotas();
        Set<Integer> codigosCatedras = new HashSet<>();

        for (Nota nota : notas) {
            if (!nota.isEsRecuperatorio() && nota.getCatedra() != null) {
                codigosCatedras.add(nota.getCatedra().getCodigo());
            }
        }

        if (codigosCatedras.isEmpty()) return 0.0;

        double sumaPromedios = 0.0;
        int cantidadCatedras = 0;

        for (Integer codigo : codigosCatedras) {
            double promedio = alumno.promedioNotas(codigo);
            if (promedio > 0) {
                sumaPromedios += promedio;
                cantidadCatedras++;
            }
        }

        return cantidadCatedras > 0 ? sumaPromedios / cantidadCatedras : 0.0;
    }

    private boolean nuncaDesaprobo(Alumno alumno) {
        List<Nota> notas = alumno.getNotas();
        for (Nota nota : notas) {
            if (nota.getValor() < 6) {
                return false;
            }
        }
        return true;
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
