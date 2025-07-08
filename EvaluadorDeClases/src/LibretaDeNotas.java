import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class LibretaDeNotas {
    private Scanner teclado = new Scanner(System.in);
    private HashMap<String, Estudiante> estudiantes = new HashMap<>();

    public void iniciar() {
        int cantidadAlumnos = leerEntero("Ingrese cantidad de alumnos: ");
        int cantidadNotas = leerEntero("Ingrese cantidad de notas por alumno: ");

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Nombre del alumno #" + (i + 1) + ": ");
            String nombre = teclado.nextLine();
            Estudiante est = new Estudiante(nombre);

            for (int j = 0; j < cantidadNotas; j++) {
                double nota = leerDecimal("Nota #" + (j + 1) + ": ");
                est.agregarNota(nota);
            }

            estudiantes.put(nombre, est);
        }

        mostrarMenu();
    }

    private void mostrarMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ver promedios");
            System.out.println("2. Ver si una nota es aprobatoria");
            System.out.println("3. Comparar nota con promedio del curso");
            System.out.println("0. Salir");
            opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1 -> mostrarPromedios();
                case 2 -> verificarAprobacion();
                case 3 -> compararConPromedioCurso();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void mostrarPromedios() {
        for (Estudiante estudiante : estudiantes.values()) {
            ArrayList<Double> notas = estudiante.getNotas();
            System.out.println(estudiante.getNombre() +
                    ": Promedio = " + Promedio.calcularPromedio(notas) +
                    ", Nota Máxima = " + Promedio.calcularMaxima(notas) +
                    ", Nota Mínima = " + Promedio.calcularMinima(notas));
        }
    }

    private void verificarAprobacion() {
        System.out.print("Nombre del estudiante: ");
        String nombre = teclado.nextLine();
        double nota = leerDecimal("Nota a evaluar: ");
        if (nota >= 4.0) {
            System.out.println("la nota aprueba.");
        } else {
            System.out.println("La nota no aprueba.");
        }
    }

    private void compararConPromedioCurso() {
        System.out.print("Nombre del estudiante: ");
        String nombre = teclado.nextLine();
        double nota = leerDecimal("Nota a comparar: ");

        double suma = 0;
        int total = 0;

        for (Estudiante estudiante : estudiantes.values()) {
            for (double notaActual : estudiante.getNotas()) {
                suma += notaActual;
                total++;
            }
        }

        if (total == 0) {
            System.out.println("No hay notas para comparar.");
            return;
        }

        double promedioCurso = suma / total;
        System.out.println("Promedio del curso: " + promedioCurso);

        if (nota > promedioCurso) {
            System.out.println("La nota está sobre el promedio.");
        } else if (nota < promedioCurso) {
            System.out.println("La nota está debajo del promedio.");
        } else {
            System.out.println("La nota es igual al promedio.");
        }
    }

    private int leerEntero(String mensaje) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(teclado.nextLine());
                if (valor >= 0) {
                    valido = true;
                } else {
                    System.out.println("Debe ser un número positivo.");
                }
            } catch (NumberFormatException estudiante) {
                System.out.println("Nota inválida.");
            }
        }
        return valor;
    }

    private double leerDecimal(String mensaje) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(teclado.nextLine());
                if (valor >= 0 && valor <= 7.0) {
                    valido = true;
                } else {
                    System.out.println("Nota fuera de rango (0-7.0).");
                }
            } catch (NumberFormatException estudiante) {
                System.out.println("Ingrese un número válido.");
            }
        }
        return valor;
    }
}