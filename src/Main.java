import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear una cátedra
        Catedra catedra = new Catedra();
        catedra.setCodigo(101);
        catedra.setDenominacion("Matemática");

        // Crear alumnos
        Alumno alumno1 = new Alumno();
        alumno1.setLegajo(1);
        alumno1.setNombre("Juan");
        alumno1.setApellido("Pérez");
        alumno1.setFechaNacimiento(new GregorianCalendar(2000, Calendar.MAY, 15).getTime());

        Alumno alumno2 = new Alumno();
        alumno2.setLegajo(2);
        alumno2.setNombre("Ana");
        alumno2.setApellido("López");
        alumno2.setFechaNacimiento(new GregorianCalendar(2001, Calendar.AUGUST, 23).getTime());

        // Crear notas para los alumnos
        Nota nota1 = new Nota();
        nota1.setId(1);
        nota1.setValor(8.5);
        nota1.setFechaExamen(new Date());
        nota1.setEsRecuperatorio(false);
        nota1.setCatedra(catedra);

        Nota nota2 = new Nota();
        nota2.setId(2);
        nota2.setValor(9.0);
        nota2.setFechaExamen(new Date());
        nota2.setEsRecuperatorio(false);
        nota2.setCatedra(catedra);

        Nota nota3 = new Nota();
        nota3.setId(3);
        nota3.setValor(7.0);
        nota3.setFechaExamen(new Date());
        nota3.setEsRecuperatorio(false);
        nota3.setCatedra(catedra);

        // Asignar notas
        alumno1.setNotas(Arrays.asList(nota1, nota3));
        alumno2.setNotas(Collections.singletonList(nota2));

        // Asignar alumnos a la cátedra
        catedra.setAlumnos(Arrays.asList(alumno1, alumno2));

        // PROBAR MÉTod: mejorAlumnoCatedra *
        Alumno mejor = catedra.mejorAlumnoCatedra();

        if (mejor != null) {
            System.out.println("El mejor alumno es: " + mejor.getNombre() + " " + mejor.getApellido());
        } else {
            System.out.println("No se encontró mejor alumno.");
        }
    }
}
