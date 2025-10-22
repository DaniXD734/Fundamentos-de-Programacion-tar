import java.util.*;

public class Ejercicio2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        boolean llena = false;
        int op;

        do {
            System.out.println("\n1. Rellenar matriz");
            System.out.println("2. Suma filas y columnas");
            System.out.println("3. Suma de fila");
            System.out.println("4. Suma de columna");
            System.out.println("5. Mayor y menor");
            System.out.println("6. Contar pares");
            System.out.println("7. Contar impares");
            System.out.println("8. Matriz con cuadrados");
            System.out.println("9. Diagonal principal");
            System.out.println("10. Diagonal inversa");
            System.out.println("11. Media total");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt();

            if (!llena && op != 1 && op != 0) {
                System.out.println("Primero llena la matriz");
                continue;
            }

            switch (op) {
                case 1:
                    HashSet<Integer> usados = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            int num;
                            do {
                                System.out.print("Valor [" + i + "][" + j + "]: ");
                                num = sc.nextInt();
                                if (usados.contains(num)) System.out.println("Ya existe ese número");
                            } while (usados.contains(num));
                            matriz[i][j] = num;
                            usados.add(num);
                        }
                    }
                    llena = true;
                    break;

                case 2:
                    for (int i = 0; i < 4; i++) {
                        int suma = 0;
                        for (int j = 0; j < 4; j++) suma += matriz[i][j];
                        System.out.println("Fila " + (i + 1) + ": " + suma);
                    }
                    for (int j = 0; j < 4; j++) {
                        int suma = 0;
                        for (int i = 0; i < 4; i++) suma += matriz[i][j];
                        System.out.println("Columna " + (j + 1) + ": " + suma);
                    }
                    break;

                case 3:
                    System.out.print("Fila (1-4): ");
                    int f = sc.nextInt() - 1;
                    if (f < 0 || f > 3) {
                        System.out.println("Fila inválida");
                    } else {
                        int suma = 0;
                        for (int j = 0; j < 4; j++) suma += matriz[f][j];
                        System.out.println("Suma fila: " + suma);
                    }
                    break;

                case 4:
                    System.out.print("Columna (1-4): ");
                    int c = sc.nextInt() - 1;
                    if (c < 0 || c > 3) {
                        System.out.println("Columna inválida");
                    } else {
                        int suma = 0;
                        for (int i = 0; i < 4; i++) suma += matriz[i][c];
                        System.out.println("Suma columna: " + suma);
                    }
                    break;

                case 5:
                    int mayor = matriz[0][0], menor = matriz[0][0];
                    int mayI = 0, mayJ = 0, menI = 0, menJ = 0;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (matriz[i][j] > mayor) { mayor = matriz[i][j]; mayI = i; mayJ = j; }
                            if (matriz[i][j] < menor) { menor = matriz[i][j]; menI = i; menJ = j; }
                        }
                    }
                    System.out.println("Mayor: " + mayor + " en [" + mayI + "][" + mayJ + "]");
                    System.out.println("Menor: " + menor + " en [" + menI + "][" + menJ + "]");
                    break;

                case 6:
                    int pares = 0;
                    for (int[] fila : matriz)
                        for (int x : fila)
                            if (x % 2 == 0) pares++;
                    System.out.println("Pares: " + pares);
                    break;

                case 7:
                    int imp = 0;
                    for (int[] fila : matriz)
                        for (int x : fila)
                            if (x % 2 != 0) imp++;
                    System.out.println("Impares: " + imp);
                    break;

                case 8:
                    int[][] cuadrados = new int[4][4];
                    for (int i = 0; i < 4; i++)
                        for (int j = 0; j < 4; j++)
                            cuadrados[i][j] = matriz[i][j] * matriz[i][j];
                    System.out.println("Matriz de cuadrados:");
                    for (int[] fila : cuadrados)
                        System.out.println(Arrays.toString(fila));
                    break;

                case 9:
                    int d1 = 0;
                    for (int i = 0; i < 4; i++) d1 += matriz[i][i];
                    System.out.println("Diagonal principal: " + d1);
                    break;

                case 10:
                    int d2 = 0;
                    for (int i = 0; i < 4; i++) d2 += matriz[i][3 - i];
                    System.out.println("Diagonal inversa: " + d2);
                    break;

                case 11:
                    int suma = 0;
                    for (int[] fila : matriz)
                        for (int x : fila)
                            suma += x;
                    double media = (double) suma / 16;
                    System.out.println("Media: " + media);
                    break;
            }
        } while (op != 0);
    }
}
