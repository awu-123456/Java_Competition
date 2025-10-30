import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class day44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int count = 0;
        for(int i = a;i <= b;i++) {
            String s = String.valueOf(i);
            int n = s.length();
            for(int x = 0;x < n-1;x++) {
                boolean flg = false;
                for(int y = x + 1;y < n;y++) {
                    int a1 = (s.charAt(x) - '0') * 10 + (s.charAt(y) - '0');
                    int a2 = (s.charAt(y) - '0') * 10 + (s.charAt(x) - '0');
                    if(isPrime(a1,a2)) {
                        count++;
                        flg = true;
                        break;
                    }
                }
                if(flg) {
                    break;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int a1, int a2) {
        if(a1 == 1 || a2 == 1) {
            return false;
        }
        if(a1 == 2 || a2 == 2) {
            return true;
        }
        for(int i = 2;i <= Math.sqrt(a1);i++) {
            if(a1 % i == 0) {
                return false;
            }
        }
        for(int i = 2;i <= Math.sqrt(a2);i++) {
            if(a2 % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String formatString (String str, char[] arg) {
        int n = arg.length;
        int pos = 0;
        String result = new String();
        int index = 0;
        while(index < str.length()) {
            if(str.charAt(index) != '%') {
                result = result + str.charAt(index);
                index++;
            } else {
                result = result + arg[pos++];
                index += 2;
            }
        }
        while(pos < n) {
            result = result + arg[pos++];
        }
        return result;
    }
}
