import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];

        // make and order array
        for (int i = 1; i < len; ++i) {
            arr[i] = scanner.nextInt();
        }
        arr[0] = scanner.nextInt();

        //read array
        for (int el : arr) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}