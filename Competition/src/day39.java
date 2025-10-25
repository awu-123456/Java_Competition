import java.util.Scanner;

public class day39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = 0,y = 0;
        for(int x1 = 0;x1 <= n;x1++) {
            for(int y1 = 0;y1 <= m;y1++) {
                for(int x2 = x1 + 1;x2 <= n;x2++){
                    for(int y2 = y1 + 1;y2 <= m;y2++) {
                        int dx = x2 - x1;
                        int dy = y2 - y1;
                        if(dx == dy){
                            x++;
                        } else {
                            y++;
                        }
                    }
                }
            }
        }
        System.out.println(x + " " + y);
    }
}