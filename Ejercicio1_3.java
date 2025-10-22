import java.util.Scanner;

public class Ejercicio1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;

        do {
            System.out.print("Cuantos vendedores hay: ");
            n = sc.nextInt();
            if (n <= 0) System.out.println("Debe ser mayor a 0");
        } while (n <= 0);

        do {
            System.out.print("Cuantas zonas hay: ");
            m = sc.nextInt();
            if (m <= 0) System.out.println("Debe ser mayor a 0");
        } while (m <= 0);

        int[][] ventas = new int[n][m];
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int valor;
                do {
                    System.out.print("Vendedor " + (i + 1) + " zona " + (j + 1) + ": ");
                    valor = sc.nextInt();
                    if (valor < 0) System.out.println("No puede ser negativo");
                } while (valor < 0);
                ventas[i][j] = valor;
                total += valor;
            }
        }

        int zonaMas = 0, maxZona = 0;
        for (int j = 0; j < m; j++) {
            int suma = 0;
            for (int i = 0; i < n; i++) suma += ventas[i][j];
            if (suma > maxZona) {
                maxZona = suma;
                zonaMas = j + 1;
            }
        }

        int menor = Integer.MAX_VALUE, mayor = Integer.MIN_VALUE;
        int vendMenor = 0, vendMayor = 0;

        for (int i = 0; i < n; i++) {
            int suma = 0;
            for (int j = 0; j < m; j++) suma += ventas[i][j];
            if (suma < menor) { menor = suma; vendMenor = i + 1; }
            if (suma > mayor) { mayor = suma; vendMayor = i + 1; }
        }

        System.out.println("\nZona que más vendió: " + zonaMas + " con " + maxZona);
        System.out.println("Vendedor que menos vendió: " + vendMenor + " con " + menor);
        System.out.println("Vendedor que más vendió: " + vendMayor + " con " + mayor);
        System.out.println("Total de ventas: " + total);
    }
}
