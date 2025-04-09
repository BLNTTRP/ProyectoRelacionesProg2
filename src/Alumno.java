import java.util.Date;
import java.util.List;

public class Alumno {
    private long legajo;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private List<Nota> notas;

    // A1: Metodo para obtener la mejor nota
    public Nota mejorNota(Integer codigoCatedra) {
        Nota mejorNota = null;

        for (Nota nota : notas) {
            // Saltar recuperatorios
            if (nota.isEsRecuperatorio()) {
                continue;
            }

            // Verificar cátedra
            boolean cumpleCatedra = true;
            if (codigoCatedra != null) {
                if (nota.getCatedra() == null || nota.getCatedra().getCodigo() != codigoCatedra) {
                    cumpleCatedra = false;
                }
            }

            if (cumpleCatedra) {
                if (mejorNota == null || nota.getValor() > mejorNota.getValor()) {
                    mejorNota = nota;
                }
            }
        }

        return mejorNota;
    }

    // A2: Metodo para obtener el promedio de notas
    public double promedioNotas(Integer codigoCatedra) {
        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        int cantidad = 0;

        for (Nota nota : notas) {
            // Verificar cátedra
            boolean cumpleCatedra = true;
            if (codigoCatedra != null) {
                if (nota.getCatedra() == null || nota.getCatedra().getCodigo() != codigoCatedra) {
                    cumpleCatedra = false;
                }
            }

            if (cumpleCatedra) {
                suma += nota.getValor();
                cantidad++;
            }
        }

        return cantidad > 0 ? suma / cantidad : 0.0;
    }

    // Getters y setters
    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
