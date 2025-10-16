import java.util.Scanner;

public class day30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
        int n = ss.length;
        for(int i = n-1;i >= 0;i--) {
            System.out.printf("%s",ss[i]);
            if(i != 0) {
                System.out.printf(" ");
            }
        }
    }
}
