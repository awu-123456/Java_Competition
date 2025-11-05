import java.util.Scanner;

public class Main7 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean flg = false;
        char[] numberChars = scanner.next().toCharArray();
        for(char ch : numberChars) {
            if(flg == true) {
                if((ch - '0') % 2 == 1) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else if(flg == false && (ch - '0') % 2 == 1) {
                sb.append(1);
                flg = true;
            }
        }
        if(sb.length() == 0) {
            sb.append(0);
        }
        System.out.println(sb.toString());
    }
}
