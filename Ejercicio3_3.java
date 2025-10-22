import java.util.Scanner;

public class Ejercicio3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;

        do {
            System.out.print("Cuantos estudiantes hay: ");
            n = sc.nextInt();
            if (n <= 0) System.out.println("Debe ser mayor a 0");
        } while (n <= 0);

        do {
            System.out.print("Cuantos examenes: ");
            m = sc.nextInt();
            if (m <= 0) System.out.println("Debe ser mayor a 0");
        } while (m <= 0);

        double[][] notas = new double[n][m];
        double[] prom = new double[n];

        for (int i = 0; i < n; i++) {
            double suma = 0;
            System.out.println("Estudiante " + (i + 1) + ":");
            for (int j = 0; j < m; j++) {
                double nota;
                do {
                    System.out.print("Examen " + (j + 1) + ": ");
                    nota = sc.nextDouble();
                    if (nota < 0 || nota > 10)
                        System.out.println("Debe estar entre 0 y 10");
                } while (nota < 0 || nota > 10);
                notas[i][j] = nota;
                suma += nota;
            }
            prom[i] = suma / m;
        }

        System.out.println("\nPromedios:");
        for (int i = 0; i < n; i++) System.out.println("Estudiante " + (i + 1) + ": " + prom[i]);

        System.out.println("\nPromedio entre 9 y 10:");
        for (int i = 0; i < n; i++)
            if (prom[i] >= 9) System.out.println("Estudiante " + (i + 1) + ": " + prom[i]);

        System.out.println("\nPromedio menor a 7:");
        for (int i = 0; i < n; i++)
            if (prom[i] < 7) System.out.println("Estudiante " + (i + 1) + ": " + prom[i]);

        double mayor = 0, menor = 100;
        int exMayor = 0, exMenor = 0;

        for (int j = 0; j < m; j++) {
            double suma = 0;
            for (int i = 0; i < n; i++) suma += notas[i][j];
            double p = suma / n;
            if (p > mayor) { mayor = p; exMayor = j + 1; }
            if (p < menor) { menor = p; exMenor = j + 1; }
        }

        System.out.println("\nExamen con promedio más alto: " + exMayor + " (" + mayor + ")");
        System.out.println("Examen con promedio más bajo: " + exMenor + " (" + menor + ")");
    }
}
