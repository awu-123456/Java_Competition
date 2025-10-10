import java.util.Scanner;

public class day25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j <= i;j++) {
                if((i == j) || (j == 0)) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        for(int i = 0;i < n;i++) {
            for(int j = 0;j <= i;j++) {
                System.out.printf("%5d",arr[i][j]);
            }
            System.out.println();
        }
    }
}
