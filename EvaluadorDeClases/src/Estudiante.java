import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private ArrayList<Double> notas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        notas = new ArrayList<Double>();
    }

    public void agregarNota(double nota) {
        if (nota >= 0 && nota <= 70) {
            notas.add(nota);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }
}