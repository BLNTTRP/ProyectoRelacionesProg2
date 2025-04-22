import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear una escuela
        Escuela escuela = new Escuela();
        escuela.setNumero(1234);
        escuela.setDenominacion("Escuela Técnica UTN");

        // Crear una división y agregarla a la escuela
        DivisionCurso division = new DivisionCurso();
        division.setAnio(2024);
        division.setDivision(1);
        escuela.agregarDivision(division);

        // Crear cátedra para asociar notas
        Catedra catedra = new Catedra();
        catedra.setCodigo(101);
        catedra.setDenominacion("Matemática");

        // Alumno 1: nacido en 2000, sin desaprobadas
        Alumno alumno1 = new Alumno();
        alumno1.setLegajo(1);
        alumno1.setNombre("Sofía");
        alumno1.setApellido("Martínez");
        alumno1.setFechaNacimiento(new GregorianCalendar(2000, Calendar.MARCH, 10).getTime());

        List<Nota> notas1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Nota nota = new Nota();
            nota.setId(i);
            nota.setValor(8 + i % 2); // valores: 8, 9, 8, 9, 8
            nota.setEsRecuperatorio(false);
            nota.setFechaExamen(new Date());
            nota.setCatedra(catedra);
            notas1.add(nota);
        }
        alumno1.setNotas(notas1);

        // Alumno 2: nacido en 2000, PERO tiene una desaprobada
        Alumno alumno2 = new Alumno();
        alumno2.setLegajo(2);
        alumno2.setNombre("Mateo");
        alumno2.setApellido("López");
        alumno2.setFechaNacimiento(new GregorianCalendar(2000, Calendar.JULY, 20).getTime());

        List<Nota> notas2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Nota nota = new Nota();
            nota.setId(i + 10);
            nota.setValor(i == 3 ? 4.5 : 9); // Una desaprobada
            nota.setEsRecuperatorio(false);
            nota.setFechaExamen(new Date());
            nota.setCatedra(catedra);
            notas2.add(nota);
        }
        alumno2.setNotas(notas2);

        // Alumno 3: nacido en otro año
        Alumno alumno3 = new Alumno();
        alumno3.setLegajo(3);
        alumno3.setNombre("Valeria");
        alumno3.setApellido("Paz");
        alumno3.setFechaNacimiento(new GregorianCalendar(2001, Calendar.JANUARY, 1).getTime());

        alumno3.setNotas(notas1); // usa mismas notas que alumno1

        // Agregar alumnos a la división
        division.agregarAlumno(alumno1);
        division.agregarAlumno(alumno2);
        division.agregarAlumno(alumno3);

        // Buscar mejor alumno nacido en 2000 sin desaprobadas
        Alumno mejor = escuela.getMejorAlumnoEscuela(2000);

        if (mejor != null) {
            System.out.println("El mejor alumno nacido en 2000 sin desaprobadas es: "
                    + mejor.getNombre() + " " + mejor.getApellido());
        } else {
            System.out.println("No se encontró ningún alumno que cumpla las condiciones.");
        }

        List<Alumno> mejoresAlumnos = escuela.getMejoresAlumnos(2000);

        System.out.println("Mejores alumnos: ");
        for(var alumno : mejoresAlumnos){
            System.out.println(alumno.getApellido());
        }
    }
}