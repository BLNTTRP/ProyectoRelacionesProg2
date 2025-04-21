import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear cátedra
        Catedra catedra = new Catedra();
        catedra.setCodigo(100);
        catedra.setDenominacion("Programación");

        // Crear alumnos
        Alumno a1 = new Alumno();
        a1.setLegajo(1);
        a1.setNombre("Carlos");
        a1.setApellido("Gómez");

        Alumno a2 = new Alumno();
        a2.setLegajo(2);
        a2.setNombre("Lucía");
        a2.setApellido("Fernández");

        // Crear 5 notas para a1 (sin recuperatorio)
        List<Nota> notas1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Nota nota = new Nota();
            nota.setId(i);
            nota.setValor(8 + i % 2); // valores 8, 9, 8, 9, 8
            nota.setEsRecuperatorio(false);
            nota.setFechaExamen(new Date());
            nota.setCatedra(catedra);
            notas1.add(nota);
        }
        a1.setNotas(notas1);

        // Crear 6 notas para a2 (1 recuperatorio)
        List<Nota> notas2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Nota nota = new Nota();
            nota.setId(i + 10);
            nota.setValor(9); // todas 9
            nota.setEsRecuperatorio(i == 2); // la tercera es recuperatorio
            nota.setFechaExamen(new Date());
            nota.setCatedra(catedra);
            notas2.add(nota);
        }
        a2.setNotas(notas2);

        // Crear división y agregar alumnos
        DivisionCurso division = new DivisionCurso();
        division.setAnio(2024);
        division.setDivision(1);
        division.setCodigo(123);
        division.agregarAlumno(a1);
        division.agregarAlumno(a2);

        // Probar mejor alumno
        Alumno mejor = division.mejorAlumnoDivisionCurso();

        if (mejor != null) {
            System.out.println("El mejor alumno de la división (sin recuperatorios y con al menos 5 exámenes) es: "
                    + mejor.getNombre() + " " + mejor.getApellido());
        } else {
            System.out.println("No se encontró alumno que cumpla las condiciones.");
        }
    }
}