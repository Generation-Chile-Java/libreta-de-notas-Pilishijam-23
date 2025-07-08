import java.util.ArrayList;

public class Promedio {
    public static double calcularPromedio(ArrayList<Double> notas) {
        if (notas.size() == 0) return 0;
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.size();
    }

    public static double calcularMaxima(ArrayList<Double> notas) {
        if (notas.size() == 0) return 0;
        double max = notas.get(0);
        for (double n : notas) {
            if (n > max) max = n;
        }
        return max;
    }

    public static double calcularMinima(ArrayList<Double> notas) {
        if (notas.size() == 0) return 0;
        double min = notas.get(0);
        for (double n : notas) {
            if (n < min) min = n;
        }
        return min;
    }
}