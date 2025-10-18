import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class day32 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode tmp = pHead1;
        Set<Integer> hash = new HashSet<>();
        hash.add(tmp.val);
        while(tmp.next != null) {
            tmp = tmp.next;
            int a = tmp.val;
            hash.add(a);
        }
        tmp = pHead2;
        if(hash.contains(tmp.val)) {
            return tmp;
        }
        while(tmp.next != null) {
            tmp = tmp.next;
            int a = tmp.val;
            if(hash.contains(a)) {
                return tmp;
            }
        }
        return null;
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] a = new int[200];
        String word = scanner.next();
        for(int i = 0;i < word.length();i++) {
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                a[ch - 'A'] = 1;
            } else if(ch >= 'a' && ch <= 'z') {
                a[ch - 'a'] = 1;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(ch == ' ' || (ch >= 'A' && ch <= 'Z' && a[ch - 'A'] != 1) || (ch >= 'a' && ch <= 'z' && a[ch - 'a'] != 1) || ch == '.') {
                result.append(ch);

            }
        }
        System.out.println(result.toString());
    }
}
