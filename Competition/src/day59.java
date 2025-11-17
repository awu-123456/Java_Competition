import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day59 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        char[] words = word.toCharArray();
        Map<Character,Integer> hash = new HashMap<>();
        int maxn = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        for(char ch : words) {
            int x = hash.getOrDefault(ch,0);
            x++;
            if(x >= maxn) {
                maxn = x;
            }
            if(x <= minn) {
                minn = x;
            }
            hash.put(ch,x);
        }
        int number = maxn - minn;
        if(number < 2) {
            System.out.println("No Answer");
            System.out.println(0);
            return;
        }
        if(number == 2) {
            System.out.println("Lucky Word");
            System.out.println(2);
            return;
        }
        for(int i = 2;i <= Math.sqrt(number);i++) {
            if(number % i == 0) {
                System.out.println("No Answer");
                System.out.println(0);
            }
        }
        System.out.println("Lucky Word");
        System.out.println(number);
    }
}