import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class day42 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while(cur1 != cur2) {
            cur1 = cur1 != null ? cur1.next : pHead2;
            cur2 = cur2 != null ? cur2.next : pHead1;
        }
        return cur1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int n = Integer.parseInt(bufferedReader.readLine());
        char[] str = bufferedReader.readLine().toCharArray();
        long s = 0,h = 0, y = 0;
        for(int i =0;i < n;i++) {
            if(str[i] == 's') {
                s++;
            } else if(str[i] == 'h') {
                h += s;
            } else if(str[i] == 'y') {
                y += h;
            }
        }
        System.out.println(y);
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        boolean[] flg = new boolean[256];
        String word = scanner.next();
        for(int i = 0;i < word.length();i++) {
            char ch = word.charAt(i);
            flg[ch] = true;
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(flg[ch] != true) {
                result.append(ch);
            }
        }
        System.out.println(result.toString());
    }
}
