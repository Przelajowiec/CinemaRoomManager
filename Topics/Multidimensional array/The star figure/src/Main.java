import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] matrix = new String[n][n];
        // fill the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ". ";
                if (i == n / 2) {
                    matrix[i][j] = "* ";
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = "* ";
                    matrix[i][n / 2] = "* ";
                    matrix[i][n - j - 1] = "* ";
                }

            }
        }
        // read the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
